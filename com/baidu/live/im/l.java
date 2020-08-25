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
/* loaded from: classes7.dex */
public class l implements ILoginListener {
    private static volatile l bbn;
    private boolean bbl = false;
    private a bbm;
    private boolean mIsDestroy;
    private boolean mIsLogin;

    /* loaded from: classes7.dex */
    public interface a {
        void o(int i, String str);
    }

    private l() {
    }

    public static l Jo() {
        if (bbn == null) {
            synchronized (l.class) {
                if (bbn == null) {
                    bbn = new l();
                }
            }
        }
        return bbn;
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
        this.bbl = true;
    }

    public void a(a aVar) {
        this.mIsLogin = true;
        this.bbm = aVar;
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

    public void Jp() {
        AccountManager.disconnect(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.android.imsdk.account.ILoginListener
    public void onLoginResult(int i, String str) {
        if (this.bbm != null) {
            this.bbm.o(i, str);
            this.bbm = null;
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
        Jp();
    }
}
