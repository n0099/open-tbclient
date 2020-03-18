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
    public static String asK = "imlog";
    private static boolean asL = false;
    private a asN;
    private String asO;
    private boolean asM = false;
    private boolean mIsInited = false;

    public void init(String str) {
        this.asO = str;
        if (!this.mIsInited) {
            this.mIsInited = true;
            l.wL().init(TbadkCoreApplication.getInst());
            wP();
            l.wL().a(new l.a() { // from class: com.baidu.live.im.n.1
                @Override // com.baidu.live.im.l.a
                public void n(int i, String str2) {
                    LogUtils.d(n.asK + "LiveIMManager", "LiveIMManager onLoginResult errno = " + i + ", errMsg = " + str2 + ", isConnected = " + n.this.asM);
                    if (i == 0 && !n.this.asM) {
                        n.this.onResult(0);
                    }
                }
            });
            if (this.asN == null) {
                this.asN = new a();
            }
            this.asN.register();
            if (!asL) {
                asL = true;
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                com.baidu.g.b.a.aO(inst).a(new com.baidu.g.b.a.a.b(inst, new com.baidu.g.b.a.b(inst)));
                f.wn().aD(inst);
            }
        }
    }

    private void wP() {
        LogUtils.d(asK + "LiveIMManager", "registerIMConnectListener");
        this.asM = false;
        BIMManager.unregisterConnectListener();
        BIMManager.registerConnectListener(this);
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        LogUtils.d(asK + "LiveIMManager", "IConnectListener onResult statusCode=" + i);
        this.asM = true;
        if (i == 0) {
            LogUtils.d(asK + "LiveIMManager", "IConnectListener net connect");
        } else if (i == 1) {
            LogUtils.d(asK + "LiveIMManager", "IConnectListener net disconnect");
        }
    }

    public void destroy(String str) {
        if (this.asO == null || this.asO.equals(str)) {
            this.mIsInited = false;
            LogUtils.d(asK + "LiveIMManager", "destroy");
            this.asM = false;
            if (this.asN != null) {
                this.asN.destroy();
                this.asN = null;
            }
            BIMManager.unregisterConnectListener();
            l.wL().destroy();
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
