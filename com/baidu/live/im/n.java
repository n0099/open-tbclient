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
    public static String bbr = "imlog";
    private static boolean bbs = false;
    private a bbu;
    private String bbv;
    private boolean bbt = false;
    private boolean mIsInited = false;

    public void init(String str) {
        this.bbv = str;
        if (!this.mIsInited) {
            this.mIsInited = true;
            l.Jo().init(TbadkCoreApplication.getInst());
            Jt();
            Js();
            if (this.bbu == null) {
                this.bbu = new a();
            }
            this.bbu.register();
            if (!bbs) {
                bbs = true;
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
                LogUtils.d(n.bbr + "LiveIMManager", "LiveIMManager onLoginResult errno = " + i + ", errMsg = " + str + ", isConnected = " + n.this.bbt);
                if (i == 0 && !n.this.bbt) {
                    n.this.onResult(0);
                }
            }
        });
    }

    private void Jt() {
        LogUtils.d(bbr + "LiveIMManager", "registerIMConnectListener");
        this.bbt = false;
        BIMManager.unregisterConnectListener();
        BIMManager.registerConnectListener(this);
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        LogUtils.d(bbr + "LiveIMManager", "IConnectListener onResult statusCode=" + i);
        this.bbt = true;
        if (i == 0) {
            LogUtils.d(bbr + "LiveIMManager", "IConnectListener net connect");
        } else if (i == 1) {
            LogUtils.d(bbr + "LiveIMManager", "IConnectListener net disconnect");
        }
    }

    public void destroy(String str) {
        if (this.bbv == null || this.bbv.equals(str)) {
            this.mIsInited = false;
            LogUtils.d(bbr + "LiveIMManager", "destroy");
            this.bbt = false;
            if (this.bbu != null) {
                this.bbu.destroy();
                this.bbu = null;
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
