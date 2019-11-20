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
    public static String agt = "imlog";
    private static boolean agu = false;
    private a agw;
    private String agx;
    private boolean agv = false;
    private boolean tN = false;

    public void init(String str) {
        this.agx = str;
        if (!this.tN) {
            this.tN = true;
            l.sS().init(TbadkCoreApplication.getInst());
            sW();
            l.sS().a(new l.a() { // from class: com.baidu.live.im.n.1
                @Override // com.baidu.live.im.l.a
                public void k(int i, String str2) {
                    LogUtils.d(n.agt + "LiveIMManager", "LiveIMManager onLoginResult errno = " + i + ", errMsg = " + str2 + ", isConnected = " + n.this.agv);
                    if (i == 0 && !n.this.agv) {
                        n.this.onResult(0);
                    }
                }
            });
            if (this.agw == null) {
                this.agw = new a();
            }
            this.agw.register();
            if (!agu) {
                agu = true;
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                com.baidu.c.b.a.aB(inst).a(new com.baidu.c.b.a.a.b(inst, new com.baidu.c.b.a.b(inst)));
                f.sw().aq(inst);
            }
        }
    }

    private void sW() {
        LogUtils.d(agt + "LiveIMManager", "registerIMConnectListener");
        this.agv = false;
        BIMManager.unregisterConnectListener();
        BIMManager.registerConnectListener(this);
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        LogUtils.d(agt + "LiveIMManager", "IConnectListener onResult statusCode=" + i);
        this.agv = true;
        if (i == 0) {
            LogUtils.d(agt + "LiveIMManager", "IConnectListener net connect");
        } else if (i == 1) {
            LogUtils.d(agt + "LiveIMManager", "IConnectListener net disconnect");
        }
    }

    public void cI(String str) {
        if (this.agx == null || this.agx.equals(str)) {
            this.tN = false;
            LogUtils.d(agt + "LiveIMManager", "destroy");
            this.agv = false;
            if (this.agw != null) {
                this.agw.destroy();
                this.agw = null;
            }
            BIMManager.unregisterConnectListener();
            l.sS().destroy();
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
