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
    public static String bhC = "imlog";
    private static boolean bhD = false;
    private a bhF;
    private String bhG;
    private boolean bhE = false;
    private boolean mIsInited = false;

    public void init(String str) {
        this.bhG = str;
        if (!this.mIsInited) {
            this.mIsInited = true;
            l.KY().init(TbadkCoreApplication.getInst());
            Ld();
            Lc();
            if (this.bhF == null) {
                this.bhF = new a();
            }
            this.bhF.register();
            if (!bhD) {
                bhD = true;
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                com.baidu.h.b.a.aJ(inst).a(new com.baidu.h.b.a.a.b(inst, new com.baidu.h.b.a.b(inst)));
                f.KA().av(inst);
            }
        }
    }

    public void Lc() {
        l.KY().a(new l.a() { // from class: com.baidu.live.im.n.1
            @Override // com.baidu.live.im.l.a
            public void r(int i, String str) {
                LogUtils.d(n.bhC + "LiveIMManager", "LiveIMManager onLoginResult errno = " + i + ", errMsg = " + str + ", isConnected = " + n.this.bhE);
                if (i == 0 && !n.this.bhE) {
                    n.this.onResult(0);
                }
            }
        });
    }

    private void Ld() {
        LogUtils.d(bhC + "LiveIMManager", "registerIMConnectListener");
        this.bhE = false;
        BIMManager.unregisterConnectListener();
        BIMManager.registerConnectListener(this);
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        LogUtils.d(bhC + "LiveIMManager", "IConnectListener onResult statusCode=" + i);
        this.bhE = true;
        if (i == 0) {
            LogUtils.d(bhC + "LiveIMManager", "IConnectListener net connect");
        } else if (i == 1) {
            LogUtils.d(bhC + "LiveIMManager", "IConnectListener net disconnect");
        }
    }

    public void hv(String str) {
        if (this.bhG == null || this.bhG.equals(str)) {
            this.mIsInited = false;
            LogUtils.d(bhC + "LiveIMManager", "destroy");
            this.bhE = false;
            if (this.bhF != null) {
                this.bhF.destroy();
                this.bhF = null;
            }
            BIMManager.unregisterConnectListener();
            l.KY().destroy();
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
