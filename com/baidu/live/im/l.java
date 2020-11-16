package com.baidu.live.im;

import android.content.Context;
import com.baidu.android.imrtc.BIMRtcClient;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.ILoginListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class l implements ILoginListener {
    private static volatile l biz;
    private boolean bix = false;
    private a biy;
    private boolean mIsDestroy;
    private boolean mIsLogin;

    /* loaded from: classes4.dex */
    public interface a {
        void r(int i, String str);
    }

    private l() {
    }

    public static l Lj() {
        if (biz == null) {
            synchronized (l.class) {
                if (biz == null) {
                    biz = new l();
                }
            }
        }
        return biz;
    }

    public void init(Context context) {
        int i = 0;
        this.mIsDestroy = false;
        BIMManager.setProductLine(context, 3, "4.10.0");
        String cuid = ExtraParamsManager.getInstance().buildParamsExtra().getCuid();
        BIMManager.enableDebugMode(true);
        if (TbConfig.IM_ENV_DEBUG || isDebug()) {
            BIMManager.init(context, Constants.APPID_TIEBA, 1, cuid);
            BIMRtcClient.setRtcDebugAndLogEnable(context, true, true);
            i = 1;
        } else {
            BIMManager.init(context, Constants.APPID_TIEBA, 0, cuid);
            BIMRtcClient.setRtcDebugAndLogEnable(context, false, false);
        }
        LogUtils.d("imlog", "BIMManager init env:" + i);
        this.bix = true;
    }

    public void a(a aVar) {
        this.mIsLogin = true;
        this.biy = aVar;
        String fromHost = TbConfig.getFromHost();
        String currentFromHost = TbConfig.getCurrentFromHost();
        if (TbadkCoreApplication.isLogin()) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String currentBduss = TbadkCoreApplication.getCurrentBduss();
            BIMManager.login(currentAccount, currentBduss, 1, fromHost, currentFromHost, this);
            LogUtils.d("imlog", "IMSdkManager PassIsLogin loginToIM uid = " + currentAccount + ", bduss = " + currentBduss + ", from = " + fromHost + ", cfrom = " + currentFromHost);
            return;
        }
        String cuid = ExtraParamsManager.getInstance().buildParamsExtra().getCuid();
        BIMManager.login(null, cuid, 6, fromHost, currentFromHost, this);
        LogUtils.d("imlog", "IMSdkManager 匿名使用cuid登录 loginToIM , cuid = " + cuid + ", from = " + fromHost + ", cfrom = " + currentFromHost);
    }

    public void Lk() {
        AccountManager.disconnect(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.android.imsdk.account.ILoginListener
    public void onLoginResult(int i, String str) {
        if (this.biy != null) {
            this.biy.r(i, str);
            this.biy = null;
        }
    }

    @Override // com.baidu.android.imsdk.account.ILoginListener
    public void onLogoutResult(int i, String str, int i2) {
        if (!this.mIsDestroy) {
            a(null);
        }
    }

    public void destroy() {
        this.mIsDestroy = true;
        Lk();
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
