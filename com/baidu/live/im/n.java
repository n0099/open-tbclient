package com.baidu.live.im;

import android.content.Context;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.ILoginListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
/* loaded from: classes3.dex */
public class n implements ILoginListener {
    private static volatile n aUI;
    private boolean aUG = false;
    private a aUH;
    private boolean mIsDestroy;
    private boolean mIsLogin;

    /* loaded from: classes3.dex */
    public interface a {
        void o(int i, String str);
    }

    private n() {
    }

    public static n Ds() {
        if (aUI == null) {
            synchronized (n.class) {
                if (aUI == null) {
                    aUI = new n();
                }
            }
        }
        return aUI;
    }

    public void init(Context context) {
        int i = 0;
        this.mIsDestroy = false;
        BIMManager.setProductLine(context, 3, "4.10.0");
        String cuid = ExtraParamsManager.getInstance().buildParamsExtra().getCuid();
        BIMManager.enableDebugMode(true);
        if (TbConfig.IM_ENV_DEBUG) {
            BIMManager.init(context, Constants.APPID_TIEBA, 1, cuid);
            i = 1;
        } else {
            BIMManager.init(context, Constants.APPID_TIEBA, 0, cuid);
        }
        LogUtils.d("imlog", "BIMManager init env:" + i);
        this.aUG = true;
    }

    public void a(a aVar) {
        this.mIsLogin = true;
        this.aUH = aVar;
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

    public void Dt() {
        AccountManager.disconnect(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.android.imsdk.account.ILoginListener
    public void onLoginResult(int i, String str) {
        if (this.aUH != null) {
            this.aUH.o(i, str);
            this.aUH = null;
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
        Dt();
    }
}
