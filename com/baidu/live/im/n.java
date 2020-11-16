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
    public static String biB = "imlog";
    private static boolean biC = false;
    private a biE;
    private String biF;
    private boolean biD = false;
    private boolean mIsInited = false;

    public void init(String str) {
        this.biF = str;
        if (!this.mIsInited) {
            this.mIsInited = true;
            l.Lj().init(TbadkCoreApplication.getInst());
            Lo();
            Ln();
            if (this.biE == null) {
                this.biE = new a();
            }
            this.biE.register();
            if (!biC) {
                biC = true;
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                com.baidu.h.b.a.aJ(inst).a(new com.baidu.h.b.a.a.b(inst, new com.baidu.h.b.a.b(inst)));
                f.KL().av(inst);
            }
        }
    }

    public void Ln() {
        l.Lj().a(new l.a() { // from class: com.baidu.live.im.n.1
            @Override // com.baidu.live.im.l.a
            public void r(int i, String str) {
                LogUtils.d(n.biB + "LiveIMManager", "LiveIMManager onLoginResult errno = " + i + ", errMsg = " + str + ", isConnected = " + n.this.biD);
                if (i == 0 && !n.this.biD) {
                    n.this.onResult(0);
                }
            }
        });
    }

    private void Lo() {
        LogUtils.d(biB + "LiveIMManager", "registerIMConnectListener");
        this.biD = false;
        BIMManager.unregisterConnectListener();
        BIMManager.registerConnectListener(this);
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        LogUtils.d(biB + "LiveIMManager", "IConnectListener onResult statusCode=" + i);
        this.biD = true;
        if (i == 0) {
            LogUtils.d(biB + "LiveIMManager", "IConnectListener net connect");
        } else if (i == 1) {
            LogUtils.d(biB + "LiveIMManager", "IConnectListener net disconnect");
        }
    }

    public void hE(String str) {
        if (this.biF == null || this.biF.equals(str)) {
            this.mIsInited = false;
            LogUtils.d(biB + "LiveIMManager", "destroy");
            this.biD = false;
            if (this.biE != null) {
                this.biE.destroy();
                this.biE = null;
            }
            BIMManager.unregisterConnectListener();
            l.Lj().destroy();
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
