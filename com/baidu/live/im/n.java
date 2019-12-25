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
/* loaded from: classes2.dex */
public class n implements IConnectListener {
    public static String aou = "imlog";
    private static boolean aov = false;
    private a aox;
    private String aoy;
    private boolean aow = false;
    private boolean mIsInited = false;

    public void init(String str) {
        this.aoy = str;
        if (!this.mIsInited) {
            this.mIsInited = true;
            l.uL().init(TbadkCoreApplication.getInst());
            uP();
            l.uL().a(new l.a() { // from class: com.baidu.live.im.n.1
                @Override // com.baidu.live.im.l.a
                public void k(int i, String str2) {
                    LogUtils.d(n.aou + "LiveIMManager", "LiveIMManager onLoginResult errno = " + i + ", errMsg = " + str2 + ", isConnected = " + n.this.aow);
                    if (i == 0 && !n.this.aow) {
                        n.this.onResult(0);
                    }
                }
            });
            if (this.aox == null) {
                this.aox = new a();
            }
            this.aox.register();
            if (!aov) {
                aov = true;
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                com.baidu.g.b.a.aL(inst).a(new com.baidu.g.b.a.a.b(inst, new com.baidu.g.b.a.b(inst)));
                f.un().aB(inst);
            }
        }
    }

    private void uP() {
        LogUtils.d(aou + "LiveIMManager", "registerIMConnectListener");
        this.aow = false;
        BIMManager.unregisterConnectListener();
        BIMManager.registerConnectListener(this);
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        LogUtils.d(aou + "LiveIMManager", "IConnectListener onResult statusCode=" + i);
        this.aow = true;
        if (i == 0) {
            LogUtils.d(aou + "LiveIMManager", "IConnectListener net connect");
        } else if (i == 1) {
            LogUtils.d(aou + "LiveIMManager", "IConnectListener net disconnect");
        }
    }

    public void destroy(String str) {
        if (this.aoy == null || this.aoy.equals(str)) {
            this.mIsInited = false;
            LogUtils.d(aou + "LiveIMManager", "destroy");
            this.aow = false;
            if (this.aox != null) {
                this.aox.destroy();
                this.aox = null;
            }
            BIMManager.unregisterConnectListener();
            l.uL().destroy();
        }
    }

    /* loaded from: classes2.dex */
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
