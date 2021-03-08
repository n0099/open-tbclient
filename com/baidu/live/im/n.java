package com.baidu.live.im;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.IConnectListener;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.im.l;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes10.dex */
public class n implements IConnectListener {
    public static String boD = "imlog";
    private static boolean boE = false;
    private a boG;
    private String mActivityId;
    private boolean boF = false;
    private boolean mIsInited = false;

    public void init(String str) {
        Log.i("updateImsdk", "@@ updateImsdk LiveIMManager.init id =" + str);
        this.mActivityId = str;
        if (!this.mIsInited) {
            this.mIsInited = true;
            l.Ks().init(TbadkCoreApplication.getInst());
            Kx();
            Kw();
            if (this.boG == null) {
                this.boG = new a();
            }
            this.boG.register();
            if (!boE) {
                boE = true;
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                com.baidu.h.b.a.bz(inst).a(new com.baidu.h.b.a.a.b(inst, new com.baidu.h.b.a.b(inst)));
                f.JR().aV(inst);
            }
        }
    }

    public void Kw() {
        l.Ks().a(new l.a() { // from class: com.baidu.live.im.n.1
            @Override // com.baidu.live.im.l.a
            public void w(int i, String str) {
                Log.i("updateImsdk", "@@ updateImsdk LiveIMManager.loginToIm -> loginResult errno=" + i + ", errMsg=" + str);
                LogUtils.d(n.boD + "LiveIMManager", "LiveIMManager onLoginResult errno = " + i + ", errMsg = " + str + ", isConnected = " + n.this.boF);
                if (i == 0 && !n.this.boF) {
                    n.this.onResult(0);
                }
            }
        });
    }

    private void Kx() {
        LogUtils.d(boD + "LiveIMManager", "registerIMConnectListener");
        this.boF = false;
        BIMManager.unregisterConnectListener();
        BIMManager.registerConnectListener(this);
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        Log.i("updateImsdk", "@@ updateImsdk LiveIMManager.onResult statuscode=" + i);
        LogUtils.d(boD + "LiveIMManager", "IConnectListener onResult statusCode=" + i);
        this.boF = true;
        if (i == 0) {
            LogUtils.d(boD + "LiveIMManager", "IConnectListener net connect");
        } else if (i == 1) {
            LogUtils.d(boD + "LiveIMManager", "IConnectListener net disconnect");
        }
    }

    public void hi(String str) {
        if (this.mActivityId == null || this.mActivityId.equals(str)) {
            this.mIsInited = false;
            LogUtils.d(boD + "LiveIMManager", "destroy");
            this.boF = false;
            if (this.boG != null) {
                this.boG.destroy();
                this.boG = null;
            }
            BIMManager.unregisterConnectListener();
            l.Ks().destroy();
        }
    }

    /* loaded from: classes10.dex */
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
