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
    public static String aWa = "imlog";
    private static boolean aWb = false;
    private a aWd;
    private String aWe;
    private boolean aWc = false;
    private boolean mIsInited = false;

    public void init(String str) {
        this.aWe = str;
        if (!this.mIsInited) {
            this.mIsInited = true;
            l.DL().init(TbadkCoreApplication.getInst());
            DQ();
            DP();
            if (this.aWd == null) {
                this.aWd = new a();
            }
            this.aWd.register();
            if (!aWb) {
                aWb = true;
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                com.baidu.d.b.a.aA(inst).a(new com.baidu.d.b.a.a.b(inst, new com.baidu.d.b.a.b(inst)));
                f.Dm().ap(inst);
            }
        }
    }

    public void DP() {
        l.DL().a(new l.a() { // from class: com.baidu.live.im.n.1
            @Override // com.baidu.live.im.l.a
            public void p(int i, String str) {
                LogUtils.d(n.aWa + "LiveIMManager", "LiveIMManager onLoginResult errno = " + i + ", errMsg = " + str + ", isConnected = " + n.this.aWc);
                if (i == 0 && !n.this.aWc) {
                    n.this.onResult(0);
                }
            }
        });
    }

    private void DQ() {
        LogUtils.d(aWa + "LiveIMManager", "registerIMConnectListener");
        this.aWc = false;
        BIMManager.unregisterConnectListener();
        BIMManager.registerConnectListener(this);
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        LogUtils.d(aWa + "LiveIMManager", "IConnectListener onResult statusCode=" + i);
        this.aWc = true;
        if (i == 0) {
            LogUtils.d(aWa + "LiveIMManager", "IConnectListener net connect");
        } else if (i == 1) {
            LogUtils.d(aWa + "LiveIMManager", "IConnectListener net disconnect");
        }
    }

    public void destroy(String str) {
        if (this.aWe == null || this.aWe.equals(str)) {
            this.mIsInited = false;
            LogUtils.d(aWa + "LiveIMManager", "destroy");
            this.aWc = false;
            if (this.aWd != null) {
                this.aWd.destroy();
                this.aWd = null;
            }
            BIMManager.unregisterConnectListener();
            l.DL().destroy();
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
