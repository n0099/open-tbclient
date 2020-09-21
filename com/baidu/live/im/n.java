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
    public static String bdQ = "imlog";
    private static boolean bdR = false;
    private a bdT;
    private String bdU;
    private boolean bdS = false;
    private boolean mIsInited = false;

    public void init(String str) {
        this.bdU = str;
        if (!this.mIsInited) {
            this.mIsInited = true;
            l.JS().init(TbadkCoreApplication.getInst());
            JX();
            JW();
            if (this.bdT == null) {
                this.bdT = new a();
            }
            this.bdT.register();
            if (!bdR) {
                bdR = true;
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                com.baidu.h.b.a.aF(inst).a(new com.baidu.h.b.a.a.b(inst, new com.baidu.h.b.a.b(inst)));
                f.Jt().as(inst);
            }
        }
    }

    public void JW() {
        l.JS().a(new l.a() { // from class: com.baidu.live.im.n.1
            @Override // com.baidu.live.im.l.a
            public void p(int i, String str) {
                LogUtils.d(n.bdQ + "LiveIMManager", "LiveIMManager onLoginResult errno = " + i + ", errMsg = " + str + ", isConnected = " + n.this.bdS);
                if (i == 0 && !n.this.bdS) {
                    n.this.onResult(0);
                }
            }
        });
    }

    private void JX() {
        LogUtils.d(bdQ + "LiveIMManager", "registerIMConnectListener");
        this.bdS = false;
        BIMManager.unregisterConnectListener();
        BIMManager.registerConnectListener(this);
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        LogUtils.d(bdQ + "LiveIMManager", "IConnectListener onResult statusCode=" + i);
        this.bdS = true;
        if (i == 0) {
            LogUtils.d(bdQ + "LiveIMManager", "IConnectListener net connect");
        } else if (i == 1) {
            LogUtils.d(bdQ + "LiveIMManager", "IConnectListener net disconnect");
        }
    }

    public void he(String str) {
        if (this.bdU == null || this.bdU.equals(str)) {
            this.mIsInited = false;
            LogUtils.d(bdQ + "LiveIMManager", "destroy");
            this.bdS = false;
            if (this.bdT != null) {
                this.bdT.destroy();
                this.bdT = null;
            }
            BIMManager.unregisterConnectListener();
            l.JS().destroy();
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
