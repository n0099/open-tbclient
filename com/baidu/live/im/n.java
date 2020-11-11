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
/* loaded from: classes4.dex */
public class n implements IConnectListener {
    public static String bkm = "imlog";
    private static boolean bkn = false;
    private a bkp;
    private String bkq;
    private boolean bko = false;
    private boolean mIsInited = false;

    public void init(String str) {
        this.bkq = str;
        if (!this.mIsInited) {
            this.mIsInited = true;
            l.LS().init(TbadkCoreApplication.getInst());
            LX();
            LW();
            if (this.bkp == null) {
                this.bkp = new a();
            }
            this.bkp.register();
            if (!bkn) {
                bkn = true;
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                com.baidu.h.b.a.aJ(inst).a(new com.baidu.h.b.a.a.b(inst, new com.baidu.h.b.a.b(inst)));
                f.Lu().av(inst);
            }
        }
    }

    public void LW() {
        l.LS().a(new l.a() { // from class: com.baidu.live.im.n.1
            @Override // com.baidu.live.im.l.a
            public void r(int i, String str) {
                LogUtils.d(n.bkm + "LiveIMManager", "LiveIMManager onLoginResult errno = " + i + ", errMsg = " + str + ", isConnected = " + n.this.bko);
                if (i == 0 && !n.this.bko) {
                    n.this.onResult(0);
                }
            }
        });
    }

    private void LX() {
        LogUtils.d(bkm + "LiveIMManager", "registerIMConnectListener");
        this.bko = false;
        BIMManager.unregisterConnectListener();
        BIMManager.registerConnectListener(this);
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        LogUtils.d(bkm + "LiveIMManager", "IConnectListener onResult statusCode=" + i);
        this.bko = true;
        if (i == 0) {
            LogUtils.d(bkm + "LiveIMManager", "IConnectListener net connect");
        } else if (i == 1) {
            LogUtils.d(bkm + "LiveIMManager", "IConnectListener net disconnect");
        }
    }

    public void hK(String str) {
        if (this.bkq == null || this.bkq.equals(str)) {
            this.mIsInited = false;
            LogUtils.d(bkm + "LiveIMManager", "destroy");
            this.bko = false;
            if (this.bkp != null) {
                this.bkp.destroy();
                this.bkp = null;
            }
            BIMManager.unregisterConnectListener();
            l.LS().destroy();
        }
    }

    /* loaded from: classes4.dex */
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
