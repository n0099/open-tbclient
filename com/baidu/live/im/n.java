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
/* loaded from: classes6.dex */
public class n implements IConnectListener {
    public static String agL = "imlog";
    private static boolean agM = false;
    private a agO;
    private String agP;
    private boolean agN = false;
    private boolean ur = false;

    public void init(String str) {
        this.agP = str;
        if (!this.ur) {
            this.ur = true;
            l.sR().init(TbadkCoreApplication.getInst());
            sV();
            l.sR().a(new l.a() { // from class: com.baidu.live.im.n.1
                @Override // com.baidu.live.im.l.a
                public void k(int i, String str2) {
                    LogUtils.d(n.agL + "LiveIMManager", "LiveIMManager onLoginResult errno = " + i + ", errMsg = " + str2 + ", isConnected = " + n.this.agN);
                    if (i == 0 && !n.this.agN) {
                        n.this.onResult(0);
                    }
                }
            });
            if (this.agO == null) {
                this.agO = new a();
            }
            this.agO.register();
            if (!agM) {
                agM = true;
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                com.baidu.c.b.a.aB(inst).a(new com.baidu.c.b.a.a.b(inst, new com.baidu.c.b.a.b(inst)));
                f.sv().aq(inst);
            }
        }
    }

    private void sV() {
        LogUtils.d(agL + "LiveIMManager", "registerIMConnectListener");
        this.agN = false;
        BIMManager.unregisterConnectListener();
        BIMManager.registerConnectListener(this);
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        LogUtils.d(agL + "LiveIMManager", "IConnectListener onResult statusCode=" + i);
        this.agN = true;
        if (i == 0) {
            LogUtils.d(agL + "LiveIMManager", "IConnectListener net connect");
        } else if (i == 1) {
            LogUtils.d(agL + "LiveIMManager", "IConnectListener net disconnect");
        }
    }

    public void cI(String str) {
        if (this.agP == null || this.agP.equals(str)) {
            this.ur = false;
            LogUtils.d(agL + "LiveIMManager", "destroy");
            this.agN = false;
            if (this.agO != null) {
                this.agO.destroy();
                this.agO = null;
            }
            BIMManager.unregisterConnectListener();
            l.sR().destroy();
        }
    }

    /* loaded from: classes6.dex */
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
