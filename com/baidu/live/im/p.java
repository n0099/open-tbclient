package com.baidu.live.im;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.IConnectListener;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.im.n;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class p implements IConnectListener {
    public static String aSe = "imlog";
    private static boolean aSf = false;
    private a aSh;
    private String aSi;
    private boolean aSg = false;
    private boolean mIsInited = false;

    public void init(String str) {
        this.aSi = str;
        if (!this.mIsInited) {
            this.mIsInited = true;
            n.CR().init(TbadkCoreApplication.getInst());
            CW();
            CV();
            if (this.aSh == null) {
                this.aSh = new a();
            }
            this.aSh.register();
            if (!aSf) {
                aSf = true;
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                com.baidu.c.b.a.az(inst).a(new com.baidu.c.b.a.a.b(inst, new com.baidu.c.b.a.b(inst)));
                f.Cl().ao(inst);
            }
        }
    }

    public void CV() {
        n.CR().a(new n.a() { // from class: com.baidu.live.im.p.1
            @Override // com.baidu.live.im.n.a
            public void m(int i, String str) {
                LogUtils.d(p.aSe + "LiveIMManager", "LiveIMManager onLoginResult errno = " + i + ", errMsg = " + str + ", isConnected = " + p.this.aSg);
                if (i == 0 && !p.this.aSg) {
                    p.this.onResult(0);
                }
            }
        });
    }

    private void CW() {
        LogUtils.d(aSe + "LiveIMManager", "registerIMConnectListener");
        this.aSg = false;
        BIMManager.unregisterConnectListener();
        BIMManager.registerConnectListener(this);
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        LogUtils.d(aSe + "LiveIMManager", "IConnectListener onResult statusCode=" + i);
        this.aSg = true;
        if (i == 0) {
            LogUtils.d(aSe + "LiveIMManager", "IConnectListener net connect");
        } else if (i == 1) {
            LogUtils.d(aSe + "LiveIMManager", "IConnectListener net disconnect");
        }
    }

    public void destroy(String str) {
        if (this.aSi == null || this.aSi.equals(str)) {
            this.mIsInited = false;
            LogUtils.d(aSe + "LiveIMManager", "destroy");
            this.aSg = false;
            if (this.aSh != null) {
                this.aSh.destroy();
                this.aSh = null;
            }
            BIMManager.unregisterConnectListener();
            n.CR().destroy();
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
