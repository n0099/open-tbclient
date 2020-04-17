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
    public static String aLY = "imlog";
    private static boolean aLZ = false;
    private a aMb;
    private String aMc;
    private boolean aMa = false;
    private boolean mIsInited = false;

    public void init(String str) {
        this.aMc = str;
        if (!this.mIsInited) {
            this.mIsInited = true;
            n.Bv().init(TbadkCoreApplication.getInst());
            BA();
            Bz();
            if (this.aMb == null) {
                this.aMb = new a();
            }
            this.aMb.register();
            if (!aLZ) {
                aLZ = true;
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                com.baidu.c.b.a.aB(inst).a(new com.baidu.c.b.a.a.b(inst, new com.baidu.c.b.a.b(inst)));
                f.AW().aq(inst);
            }
        }
    }

    public void Bz() {
        n.Bv().a(new n.a() { // from class: com.baidu.live.im.p.1
            @Override // com.baidu.live.im.n.a
            public void m(int i, String str) {
                LogUtils.d(p.aLY + "LiveIMManager", "LiveIMManager onLoginResult errno = " + i + ", errMsg = " + str + ", isConnected = " + p.this.aMa);
                if (i == 0 && !p.this.aMa) {
                    p.this.onResult(0);
                }
            }
        });
    }

    private void BA() {
        LogUtils.d(aLY + "LiveIMManager", "registerIMConnectListener");
        this.aMa = false;
        BIMManager.unregisterConnectListener();
        BIMManager.registerConnectListener(this);
    }

    @Override // com.baidu.android.imsdk.account.IConnectListener
    public void onResult(int i) {
        LogUtils.d(aLY + "LiveIMManager", "IConnectListener onResult statusCode=" + i);
        this.aMa = true;
        if (i == 0) {
            LogUtils.d(aLY + "LiveIMManager", "IConnectListener net connect");
        } else if (i == 1) {
            LogUtils.d(aLY + "LiveIMManager", "IConnectListener net disconnect");
        }
    }

    public void destroy(String str) {
        if (this.aMc == null || this.aMc.equals(str)) {
            this.mIsInited = false;
            LogUtils.d(aLY + "LiveIMManager", "destroy");
            this.aMa = false;
            if (this.aMb != null) {
                this.aMb.destroy();
                this.aMb = null;
            }
            BIMManager.unregisterConnectListener();
            n.Bv().destroy();
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
