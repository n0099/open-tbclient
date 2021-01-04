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
/* loaded from: classes11.dex */
public class n implements IConnectListener {
    public static String boy = "imlog";
    private static boolean boz = false;
    private a boB;
    private String mActivityId;
    private boolean boA = false;
    private boolean mIsInited = false;

    public void init(String str) {
        Log.i("updateImsdk", "@@ updateImsdk LiveIMManager.init id =" + str);
        this.mActivityId = str;
        if (!this.mIsInited) {
            this.mIsInited = true;
            l.MM().init(TbadkCoreApplication.getInst());
            MR();
            MQ();
            if (this.boB == null) {
                this.boB = new a();
            }
            this.boB.register();
            if (!boz) {
                boz = true;
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                com.baidu.j.b.a.by(inst).a(new com.baidu.j.b.a.a.b(inst, new com.baidu.j.b.a.b(inst)));
                f.Ml().aX(inst);
            }
        }
    }

    public void MQ() {
        l.MM().a(new l.a() { // from class: com.baidu.live.im.n.1
            @Override // com.baidu.live.im.l.a
            public void s(int i, String str) {
                Log.i("updateImsdk", "@@ updateImsdk LiveIMManager.loginToIm -> loginResult errno=" + i + ", errMsg=" + str);
                LogUtils.d(n.boy + "LiveIMManager", "LiveIMManager onLoginResult errno = " + i + ", errMsg = " + str + ", isConnected = " + n.this.boA);
                if (i == 0 && !n.this.boA) {
                    n.this.onResult(0);
                }
            }
        });
    }

    private void MR() {
        LogUtils.d(boy + "LiveIMManager", "registerIMConnectListener");
        this.boA = false;
        BIMManager.unregisterConnectListener();
        BIMManager.registerConnectListener(this);
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        Log.i("updateImsdk", "@@ updateImsdk LiveIMManager.onResult statuscode=" + i);
        LogUtils.d(boy + "LiveIMManager", "IConnectListener onResult statusCode=" + i);
        this.boA = true;
        if (i == 0) {
            LogUtils.d(boy + "LiveIMManager", "IConnectListener net connect");
        } else if (i == 1) {
            LogUtils.d(boy + "LiveIMManager", "IConnectListener net disconnect");
        }
    }

    public void hP(String str) {
        if (this.mActivityId == null || this.mActivityId.equals(str)) {
            this.mIsInited = false;
            LogUtils.d(boy + "LiveIMManager", "destroy");
            this.boA = false;
            if (this.boB != null) {
                this.boB.destroy();
                this.boB = null;
            }
            BIMManager.unregisterConnectListener();
            l.MM().destroy();
        }
    }

    /* loaded from: classes11.dex */
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
