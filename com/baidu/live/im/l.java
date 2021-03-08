package com.baidu.live.im;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.android.imrtc.BIMRtcClient;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.ILoginListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.util.SingleRunnable;
import com.baidu.live.tbadk.util.TbSingleExecutor;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class l implements ILoginListener {
    private static volatile l box;
    static boolean boy = true;
    private a bow;
    private boolean mIsDestroy;
    private boolean mIsLogin;
    private boolean bov = false;
    private Handler handler = new Handler();
    private BroadcastReceiver boz = new AnonymousClass1();

    /* loaded from: classes10.dex */
    public interface a {
        void w(int i, String str);
    }

    private l() {
    }

    public static l Ks() {
        if (box == null) {
            synchronized (l.class) {
                if (box == null) {
                    box = new l();
                }
            }
        }
        return box;
    }

    public void init(Context context) {
        int i = 0;
        Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.init context=" + context);
        this.mIsDestroy = false;
        String subappVersionName = TbConfig.getSubappVersionName();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.lcp.sdk.broadcast");
        LocalBroadcastManager.getInstance(context).registerReceiver(this.boz, intentFilter);
        com.baidu.lcp.sdk.d.e.l(context, true);
        BIMManager.setProductLine(context, 3, subappVersionName);
        String cuid = ExtraParamsManager.getInstance().buildParamsExtra().getCuid();
        BIMManager.enableDebugMode(true);
        if (TbConfig.IM_ENV_DEBUG || isDebug()) {
            Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.init debug");
            BIMManager.init(context, Constants.APPID_TIEBA, 1, cuid);
            BIMRtcClient.setRtcDebugAndLogEnable(context, true, true);
            i = 1;
        } else {
            Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.init online");
            BIMManager.init(context, Constants.APPID_TIEBA, 0, cuid);
            BIMRtcClient.setRtcDebugAndLogEnable(context, false, false);
        }
        LogUtils.d("imlog", "BIMManager init env:" + i);
        aW(context);
        this.bov = true;
    }

    private void aW(Context context) {
        int i;
        Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.loginToLCP context=" + context);
        if (boy) {
            i = 1;
        } else {
            i = 2;
        }
        boy = false;
        com.baidu.lcp.sdk.client.a.c(context, "10773430", ExtraParamsManager.getInstance().buildParamsExtra().getCuid(), i);
        Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.loginToLCP connect end");
    }

    public void a(a aVar) {
        Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.loginToIM listener=" + aVar);
        this.mIsLogin = true;
        this.bow = aVar;
        String fromHost = TbConfig.getFromHost();
        String currentFromHost = TbConfig.getCurrentFromHost();
        if (TbadkCoreApplication.isLogin()) {
            Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.loginToIM login");
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String currentBduss = TbadkCoreApplication.getCurrentBduss();
            BIMManager.login(currentAccount, currentBduss, 1, fromHost, currentFromHost, this);
            LogUtils.d("imlog", "IMSdkManager PassIsLogin loginToIM uid = " + currentAccount + ", bduss = " + currentBduss + ", from = " + fromHost + ", cfrom = " + currentFromHost);
            return;
        }
        Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.loginToIM cuid");
        String cuid = ExtraParamsManager.getInstance().buildParamsExtra().getCuid();
        BIMManager.login(null, cuid, 6, fromHost, currentFromHost, this);
        LogUtils.d("imlog", "IMSdkManager 匿名使用cuid登录 loginToIM , cuid = " + cuid + ", from = " + fromHost + ", cfrom = " + currentFromHost);
    }

    public void Kt() {
        AccountManager.disconnect(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.android.imsdk.account.ILoginListener
    public void onLoginResult(int i, String str) {
        Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.onLoginResult errno=" + i + ", errMsg=" + str);
        if (this.bow != null) {
            this.bow.w(i, str);
            this.bow = null;
        }
    }

    @Override // com.baidu.android.imsdk.account.ILoginListener
    public void onLogoutResult(int i, String str, int i2) {
        Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.onLogoutResult errno=" + i + ", errMsg=" + str + ", type=" + i2);
        if (!this.mIsDestroy) {
            a((a) null);
        }
    }

    /* renamed from: com.baidu.live.im.l$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass1 extends BroadcastReceiver {
        AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.iConnectListener -> onReceive context=" + context + ", intent=" + intent);
            if (intent != null && "com.baidu.lcp.sdk.broadcast".equals(intent.getAction())) {
                boolean z = intent.getIntExtra("com.baidu.lcp.sdk.connect.state", -1) == 0;
                Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.iConnectListener -> onReceive connect=" + z);
                Log.d("ImSdkManager", "registerConnectListener connect ：" + intent.getIntExtra("com.baidu.lcp.sdk.connect.state", -1));
                if (z) {
                    TbSingleExecutor.execute(new SingleRunnable<Object>() { // from class: com.baidu.live.im.l.1.1
                        @Override // com.baidu.live.tbadk.util.SingleRunnable
                        public Object doInBackground() {
                            Log.i("updateImsdk", "@@ updateImsdk ImSdkManager.iConnectListener -> onReceive doInBackground");
                            l.this.handler.post(new Runnable() { // from class: com.baidu.live.im.l.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.this.a((a) null);
                                }
                            });
                            return null;
                        }
                    }, null);
                }
            }
        }
    }

    public void destroy() {
        this.mIsDestroy = true;
        this.handler.removeCallbacksAndMessages(null);
        Kt();
    }

    public static boolean isDebug() {
        HashMap hashMap = new HashMap();
        hashMap.put("test_checkoutImEnvRD", false);
        Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
        if (process.containsKey("test_checkoutImEnvRD")) {
            return ((Boolean) process.get("test_checkoutImEnvRD")).booleanValue();
        }
        return false;
    }
}
