package com.baidu.live.im;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.IConnectListener;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.im.l;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes7.dex */
public class n implements IConnectListener {
    public static String bbp = "imlog";
    private static boolean bbq = false;
    private a bbs;
    private String bbt;
    private boolean bbr = false;
    private boolean mIsInited = false;

    public void init(String str) {
        this.bbt = str;
        if (!this.mIsInited) {
            this.mIsInited = true;
            l.Jo().init(TbadkCoreApplication.getInst());
            Jt();
            Js();
            if (this.bbs == null) {
                this.bbs = new a();
            }
            this.bbs.register();
            if (!bbq) {
                bbq = true;
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                com.baidu.h.b.a.aF(inst).a(new com.baidu.h.b.a.a.b(inst, new com.baidu.h.b.a.b(inst)));
                f.IP().as(inst);
            }
        }
    }

    public void Js() {
        l.Jo().a(new l.a() { // from class: com.baidu.live.im.n.1
            @Override // com.baidu.live.im.l.a
            public void o(int i, String str) {
                LogUtils.d(n.bbp + "LiveIMManager", "LiveIMManager onLoginResult errno = " + i + ", errMsg = " + str + ", isConnected = " + n.this.bbr);
                if (i == 0 && !n.this.bbr) {
                    n.this.onResult(0);
                }
            }
        });
    }

    private void Jt() {
        LogUtils.d(bbp + "LiveIMManager", "registerIMConnectListener");
        this.bbr = false;
        BIMManager.unregisterConnectListener();
        BIMManager.registerConnectListener(this);
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        LogUtils.d(bbp + "LiveIMManager", "IConnectListener onResult statusCode=" + i);
        this.bbr = true;
        if (i == 0) {
            LogUtils.d(bbp + "LiveIMManager", "IConnectListener net connect");
        } else if (i == 1) {
            LogUtils.d(bbp + "LiveIMManager", "IConnectListener net disconnect");
        }
    }

    public void destroy(String str) {
        if (this.bbt == null || this.bbt.equals(str)) {
            this.mIsInited = false;
            LogUtils.d(bbp + "LiveIMManager", "destroy");
            this.bbr = false;
            if (this.bbs != null) {
                this.bbs.destroy();
                this.bbs = null;
            }
            BIMManager.unregisterConnectListener();
            l.Jo().destroy();
        }
    }

    /* loaded from: classes7.dex */
    private class a extends BroadcastReceiver {
        private boolean mIsDestroy;
        private boolean mIsInit;

        private a() {
        }

        public void register() {
            init();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            TbadkCoreApplication.getInst().registerReceiver(this, intentFilter);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                if (this.mIsInit) {
                    this.mIsInit = false;
                } else if (BdNetTypeUtil.isNetWorkAvailable() && !this.mIsDestroy) {
                    BIMManager.tryConnection(context);
                }
            }
        }

        private void init() {
            this.mIsInit = true;
            this.mIsDestroy = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroy() {
            this.mIsDestroy = true;
            try {
                TbadkCoreApplication.getInst().unregisterReceiver(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
