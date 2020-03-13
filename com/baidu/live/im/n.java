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
/* loaded from: classes3.dex */
public class n implements IConnectListener {
    public static String asA = "imlog";
    private static boolean asB = false;
    private a asD;
    private String asE;
    private boolean asC = false;
    private boolean mIsInited = false;

    public void init(String str) {
        this.asE = str;
        if (!this.mIsInited) {
            this.mIsInited = true;
            l.wG().init(TbadkCoreApplication.getInst());
            wK();
            l.wG().a(new l.a() { // from class: com.baidu.live.im.n.1
                @Override // com.baidu.live.im.l.a
                public void n(int i, String str2) {
                    LogUtils.d(n.asA + "LiveIMManager", "LiveIMManager onLoginResult errno = " + i + ", errMsg = " + str2 + ", isConnected = " + n.this.asC);
                    if (i == 0 && !n.this.asC) {
                        n.this.onResult(0);
                    }
                }
            });
            if (this.asD == null) {
                this.asD = new a();
            }
            this.asD.register();
            if (!asB) {
                asB = true;
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                com.baidu.g.b.a.aP(inst).a(new com.baidu.g.b.a.a.b(inst, new com.baidu.g.b.a.b(inst)));
                f.wi().aE(inst);
            }
        }
    }

    private void wK() {
        LogUtils.d(asA + "LiveIMManager", "registerIMConnectListener");
        this.asC = false;
        BIMManager.unregisterConnectListener();
        BIMManager.registerConnectListener(this);
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        LogUtils.d(asA + "LiveIMManager", "IConnectListener onResult statusCode=" + i);
        this.asC = true;
        if (i == 0) {
            LogUtils.d(asA + "LiveIMManager", "IConnectListener net connect");
        } else if (i == 1) {
            LogUtils.d(asA + "LiveIMManager", "IConnectListener net disconnect");
        }
    }

    public void destroy(String str) {
        if (this.asE == null || this.asE.equals(str)) {
            this.mIsInited = false;
            LogUtils.d(asA + "LiveIMManager", "destroy");
            this.asC = false;
            if (this.asD != null) {
                this.asD.destroy();
                this.asD = null;
            }
            BIMManager.unregisterConnectListener();
            l.wG().destroy();
        }
    }

    /* loaded from: classes3.dex */
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
