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
    public static String bnd = "imlog";
    private static boolean bne = false;
    private a bng;
    private String mActivityId;
    private boolean bnf = false;
    private boolean mIsInited = false;

    public void init(String str) {
        Log.i("updateImsdk", "@@ updateImsdk LiveIMManager.init id =" + str);
        this.mActivityId = str;
        if (!this.mIsInited) {
            this.mIsInited = true;
            l.Kp().init(TbadkCoreApplication.getInst());
            Ku();
            Kt();
            if (this.bng == null) {
                this.bng = new a();
            }
            this.bng.register();
            if (!bne) {
                bne = true;
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                com.baidu.h.b.a.bA(inst).a(new com.baidu.h.b.a.a.b(inst, new com.baidu.h.b.a.b(inst)));
                f.JO().aW(inst);
            }
        }
    }

    public void Kt() {
        l.Kp().a(new l.a() { // from class: com.baidu.live.im.n.1
            @Override // com.baidu.live.im.l.a
            public void w(int i, String str) {
                Log.i("updateImsdk", "@@ updateImsdk LiveIMManager.loginToIm -> loginResult errno=" + i + ", errMsg=" + str);
                LogUtils.d(n.bnd + "LiveIMManager", "LiveIMManager onLoginResult errno = " + i + ", errMsg = " + str + ", isConnected = " + n.this.bnf);
                if (i == 0 && !n.this.bnf) {
                    n.this.onResult(0);
                }
            }
        });
    }

    private void Ku() {
        LogUtils.d(bnd + "LiveIMManager", "registerIMConnectListener");
        this.bnf = false;
        BIMManager.unregisterConnectListener();
        BIMManager.registerConnectListener(this);
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        Log.i("updateImsdk", "@@ updateImsdk LiveIMManager.onResult statuscode=" + i);
        LogUtils.d(bnd + "LiveIMManager", "IConnectListener onResult statusCode=" + i);
        this.bnf = true;
        if (i == 0) {
            LogUtils.d(bnd + "LiveIMManager", "IConnectListener net connect");
        } else if (i == 1) {
            LogUtils.d(bnd + "LiveIMManager", "IConnectListener net disconnect");
        }
    }

    public void hc(String str) {
        if (this.mActivityId == null || this.mActivityId.equals(str)) {
            this.mIsInited = false;
            LogUtils.d(bnd + "LiveIMManager", "destroy");
            this.bnf = false;
            if (this.bng != null) {
                this.bng.destroy();
                this.bng = null;
            }
            BIMManager.unregisterConnectListener();
            l.Kp().destroy();
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
