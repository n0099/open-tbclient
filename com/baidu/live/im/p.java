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
    public static String aMe = "imlog";
    private static boolean aMf = false;
    private a aMh;
    private String aMi;
    private boolean aMg = false;
    private boolean mIsInited = false;

    public void init(String str) {
        this.aMi = str;
        if (!this.mIsInited) {
            this.mIsInited = true;
            n.Bu().init(TbadkCoreApplication.getInst());
            Bz();
            By();
            if (this.aMh == null) {
                this.aMh = new a();
            }
            this.aMh.register();
            if (!aMf) {
                aMf = true;
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                com.baidu.c.b.a.ap(inst).a(new com.baidu.c.b.a.a.b(inst, new com.baidu.c.b.a.b(inst)));
                f.AV().ae(inst);
            }
        }
    }

    public void By() {
        n.Bu().a(new n.a() { // from class: com.baidu.live.im.p.1
            @Override // com.baidu.live.im.n.a
            public void m(int i, String str) {
                LogUtils.d(p.aMe + "LiveIMManager", "LiveIMManager onLoginResult errno = " + i + ", errMsg = " + str + ", isConnected = " + p.this.aMg);
                if (i == 0 && !p.this.aMg) {
                    p.this.onResult(0);
                }
            }
        });
    }

    private void Bz() {
        LogUtils.d(aMe + "LiveIMManager", "registerIMConnectListener");
        this.aMg = false;
        BIMManager.unregisterConnectListener();
        BIMManager.registerConnectListener(this);
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        LogUtils.d(aMe + "LiveIMManager", "IConnectListener onResult statusCode=" + i);
        this.aMg = true;
        if (i == 0) {
            LogUtils.d(aMe + "LiveIMManager", "IConnectListener net connect");
        } else if (i == 1) {
            LogUtils.d(aMe + "LiveIMManager", "IConnectListener net disconnect");
        }
    }

    public void destroy(String str) {
        if (this.aMi == null || this.aMi.equals(str)) {
            this.mIsInited = false;
            LogUtils.d(aMe + "LiveIMManager", "destroy");
            this.aMg = false;
            if (this.aMh != null) {
                this.aMh.destroy();
                this.aMh = null;
            }
            BIMManager.unregisterConnectListener();
            n.Bu().destroy();
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
