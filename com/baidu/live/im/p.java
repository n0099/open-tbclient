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
    public static String aUK = "imlog";
    private static boolean aUL = false;
    private a aUN;
    private String aUO;
    private boolean aUM = false;
    private boolean mIsInited = false;

    public void init(String str) {
        this.aUO = str;
        if (!this.mIsInited) {
            this.mIsInited = true;
            n.Ds().init(TbadkCoreApplication.getInst());
            Dx();
            Dw();
            if (this.aUN == null) {
                this.aUN = new a();
            }
            this.aUN.register();
            if (!aUL) {
                aUL = true;
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                com.baidu.c.b.a.aA(inst).a(new com.baidu.c.b.a.a.b(inst, new com.baidu.c.b.a.b(inst)));
                f.CL().ap(inst);
            }
        }
    }

    public void Dw() {
        n.Ds().a(new n.a() { // from class: com.baidu.live.im.p.1
            @Override // com.baidu.live.im.n.a
            public void o(int i, String str) {
                LogUtils.d(p.aUK + "LiveIMManager", "LiveIMManager onLoginResult errno = " + i + ", errMsg = " + str + ", isConnected = " + p.this.aUM);
                if (i == 0 && !p.this.aUM) {
                    p.this.onResult(0);
                }
            }
        });
    }

    private void Dx() {
        LogUtils.d(aUK + "LiveIMManager", "registerIMConnectListener");
        this.aUM = false;
        BIMManager.unregisterConnectListener();
        BIMManager.registerConnectListener(this);
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        LogUtils.d(aUK + "LiveIMManager", "IConnectListener onResult statusCode=" + i);
        this.aUM = true;
        if (i == 0) {
            LogUtils.d(aUK + "LiveIMManager", "IConnectListener net connect");
        } else if (i == 1) {
            LogUtils.d(aUK + "LiveIMManager", "IConnectListener net disconnect");
        }
    }

    public void destroy(String str) {
        if (this.aUO == null || this.aUO.equals(str)) {
            this.mIsInited = false;
            LogUtils.d(aUK + "LiveIMManager", "destroy");
            this.aUM = false;
            if (this.aUN != null) {
                this.aUN.destroy();
                this.aUN = null;
            }
            BIMManager.unregisterConnectListener();
            n.Ds().destroy();
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
