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
/* loaded from: classes4.dex */
public class n implements IConnectListener {
    public static String bmT = "imlog";
    private static boolean bmU = false;
    private a bmW;
    private String bmX;
    private boolean bmV = false;
    private boolean mIsInited = false;

    public void init(String str) {
        Log.i("updateImsdk", "@@ updateImsdk LiveIMManager.init id =" + str);
        this.bmX = str;
        if (!this.mIsInited) {
            this.mIsInited = true;
            l.Nn().init(TbadkCoreApplication.getInst());
            Ns();
            Nr();
            if (this.bmW == null) {
                this.bmW = new a();
            }
            this.bmW.register();
            if (!bmU) {
                bmU = true;
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                com.baidu.i.b.a.bn(inst).a(new com.baidu.i.b.a.a.b(inst, new com.baidu.i.b.a.b(inst)));
                f.MO().aY(inst);
            }
        }
    }

    public void Nr() {
        l.Nn().a(new l.a() { // from class: com.baidu.live.im.n.1
            @Override // com.baidu.live.im.l.a
            public void r(int i, String str) {
                Log.i("updateImsdk", "@@ updateImsdk LiveIMManager.loginToIm -> loginResult errno=" + i + ", errMsg=" + str);
                LogUtils.d(n.bmT + "LiveIMManager", "LiveIMManager onLoginResult errno = " + i + ", errMsg = " + str + ", isConnected = " + n.this.bmV);
                if (i == 0 && !n.this.bmV) {
                    n.this.onResult(0);
                }
            }
        });
    }

    private void Ns() {
        LogUtils.d(bmT + "LiveIMManager", "registerIMConnectListener");
        this.bmV = false;
        BIMManager.unregisterConnectListener();
        BIMManager.registerConnectListener(this);
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        Log.i("updateImsdk", "@@ updateImsdk LiveIMManager.onResult statuscode=" + i);
        LogUtils.d(bmT + "LiveIMManager", "IConnectListener onResult statusCode=" + i);
        this.bmV = true;
        if (i == 0) {
            LogUtils.d(bmT + "LiveIMManager", "IConnectListener net connect");
        } else if (i == 1) {
            LogUtils.d(bmT + "LiveIMManager", "IConnectListener net disconnect");
        }
    }

    public void ie(String str) {
        if (this.bmX == null || this.bmX.equals(str)) {
            this.mIsInited = false;
            LogUtils.d(bmT + "LiveIMManager", "destroy");
            this.bmV = false;
            if (this.bmW != null) {
                this.bmW.destroy();
                this.bmW = null;
            }
            BIMManager.unregisterConnectListener();
            l.Nn().destroy();
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
