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
    public static String apg = "imlog";
    private static boolean aph = false;
    private a apj;
    private String apk;
    private boolean api = false;
    private boolean mIsInited = false;

    public void init(String str) {
        this.apk = str;
        if (!this.mIsInited) {
            this.mIsInited = true;
            l.vc().init(TbadkCoreApplication.getInst());
            vg();
            l.vc().a(new l.a() { // from class: com.baidu.live.im.n.1
                @Override // com.baidu.live.im.l.a
                public void n(int i, String str2) {
                    LogUtils.d(n.apg + "LiveIMManager", "LiveIMManager onLoginResult errno = " + i + ", errMsg = " + str2 + ", isConnected = " + n.this.api);
                    if (i == 0 && !n.this.api) {
                        n.this.onResult(0);
                    }
                }
            });
            if (this.apj == null) {
                this.apj = new a();
            }
            this.apj.register();
            if (!aph) {
                aph = true;
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                com.baidu.g.b.a.aL(inst).a(new com.baidu.g.b.a.a.b(inst, new com.baidu.g.b.a.b(inst)));
                f.uE().aB(inst);
            }
        }
    }

    private void vg() {
        LogUtils.d(apg + "LiveIMManager", "registerIMConnectListener");
        this.api = false;
        BIMManager.unregisterConnectListener();
        BIMManager.registerConnectListener(this);
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        LogUtils.d(apg + "LiveIMManager", "IConnectListener onResult statusCode=" + i);
        this.api = true;
        if (i == 0) {
            LogUtils.d(apg + "LiveIMManager", "IConnectListener net connect");
        } else if (i == 1) {
            LogUtils.d(apg + "LiveIMManager", "IConnectListener net disconnect");
        }
    }

    public void destroy(String str) {
        if (this.apk == null || this.apk.equals(str)) {
            this.mIsInited = false;
            LogUtils.d(apg + "LiveIMManager", "destroy");
            this.api = false;
            if (this.apj != null) {
                this.apj.destroy();
                this.apj = null;
            }
            BIMManager.unregisterConnectListener();
            l.vc().destroy();
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
