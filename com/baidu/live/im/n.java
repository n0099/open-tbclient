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
    public static String biT = "imlog";
    private static boolean biU = false;
    private a biW;
    private String biX;
    private boolean biV = false;
    private boolean mIsInited = false;

    public void init(String str) {
        this.biX = str;
        if (!this.mIsInited) {
            this.mIsInited = true;
            l.Ls().init(TbadkCoreApplication.getInst());
            Lx();
            Lw();
            if (this.biW == null) {
                this.biW = new a();
            }
            this.biW.register();
            if (!biU) {
                biU = true;
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                com.baidu.h.b.a.aJ(inst).a(new com.baidu.h.b.a.a.b(inst, new com.baidu.h.b.a.b(inst)));
                f.KU().av(inst);
            }
        }
    }

    public void Lw() {
        l.Ls().a(new l.a() { // from class: com.baidu.live.im.n.1
            @Override // com.baidu.live.im.l.a
            public void r(int i, String str) {
                LogUtils.d(n.biT + "LiveIMManager", "LiveIMManager onLoginResult errno = " + i + ", errMsg = " + str + ", isConnected = " + n.this.biV);
                if (i == 0 && !n.this.biV) {
                    n.this.onResult(0);
                }
            }
        });
    }

    private void Lx() {
        LogUtils.d(biT + "LiveIMManager", "registerIMConnectListener");
        this.biV = false;
        BIMManager.unregisterConnectListener();
        BIMManager.registerConnectListener(this);
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        LogUtils.d(biT + "LiveIMManager", "IConnectListener onResult statusCode=" + i);
        this.biV = true;
        if (i == 0) {
            LogUtils.d(biT + "LiveIMManager", "IConnectListener net connect");
        } else if (i == 1) {
            LogUtils.d(biT + "LiveIMManager", "IConnectListener net disconnect");
        }
    }

    public void hD(String str) {
        if (this.biX == null || this.biX.equals(str)) {
            this.mIsInited = false;
            LogUtils.d(biT + "LiveIMManager", "destroy");
            this.biV = false;
            if (this.biW != null) {
                this.biW.destroy();
                this.biW = null;
            }
            BIMManager.unregisterConnectListener();
            l.Ls().destroy();
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
