package com.baidu.mobads.container.adrequest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.alibaba.fastjson.asm.Label;
import com.baidu.mobads.container.XAdInstanceInfoExt;
import com.baidu.mobads.container.config.AppConfigImp;
import com.baidu.mobads.container.landingpage.XAdRemoteLandingPageExtraInfo;
import com.baidu.mobads.container.util.ActivityUtils;
import com.baidu.mobads.container.util.AppUtils;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.IReflectionInfo;
import com.baidu.mobads.container.util.RemoteXAdLogger;
/* loaded from: classes2.dex */
public class AdLandingpageOpen {
    public static final String EXTRA_AD_INSTANCE_INFO = "EXTRA_DATA_STRING_AD";
    public static final String EXTRA_COMMAND_EXTRA_INFO = "EXTRA_DATA_STRING_COM";
    public static final String EXTRA_DATA = "EXTRA_DATA";
    public static final String EXTRA_LANDINGPAGE_EXTRA_INFO = "EXTRA_DATA_STRING";
    public static final String EXTRA_LP_THEME = "theme";
    public Activity mActivity;
    public XAdInstanceInfoExt mAdInstanceInfo;
    public String mAppsec;
    public String mAppsid;
    public Context mCxt;
    public String mProd;
    public String mUrl;
    public String lpStyle = "";
    public String lpMurl = "";

    public AdLandingpageOpen(XAdContainerContext xAdContainerContext, String str, XAdInstanceInfoExt xAdInstanceInfoExt, String str2) {
        this.mUrl = null;
        this.mUrl = str2;
        if (xAdContainerContext != null) {
            this.mCxt = xAdContainerContext.getAppContext();
            this.mActivity = xAdContainerContext.getActivity();
            this.mAppsid = xAdContainerContext.getAppsid();
            this.mAppsec = xAdContainerContext.getAppSec();
        }
        this.mProd = str;
        this.mAdInstanceInfo = xAdInstanceInfoExt;
    }

    public void execute() {
        try {
            XAdRemoteLandingPageExtraInfo xAdRemoteLandingPageExtraInfo = new XAdRemoteLandingPageExtraInfo(this.mProd, this.mAdInstanceInfo);
            xAdRemoteLandingPageExtraInfo.sn = DeviceUtils.getInstance().getSn(this.mCxt);
            xAdRemoteLandingPageExtraInfo.mIntTesting4LM = 999;
            xAdRemoteLandingPageExtraInfo.mStringTesting4LM = "this is the test string";
            xAdRemoteLandingPageExtraInfo.url = this.mUrl;
            xAdRemoteLandingPageExtraInfo.e75 = 1;
            xAdRemoteLandingPageExtraInfo.from = 0;
            xAdRemoteLandingPageExtraInfo.adid = this.mAdInstanceInfo.getAdId();
            xAdRemoteLandingPageExtraInfo.qk = this.mAdInstanceInfo.getQueryKey();
            xAdRemoteLandingPageExtraInfo.packageNameOfPubliser = this.mCxt.getPackageName();
            xAdRemoteLandingPageExtraInfo.appsid = this.mAppsid;
            xAdRemoteLandingPageExtraInfo.appsec = this.mAppsec;
            xAdRemoteLandingPageExtraInfo.title = this.mAdInstanceInfo.getTitle();
            xAdRemoteLandingPageExtraInfo.lpStyle = this.lpStyle;
            xAdRemoteLandingPageExtraInfo.lpMurl = this.lpMurl;
            xAdRemoteLandingPageExtraInfo.mLpMultiProcess = "" + AppConfigImp.getInstance().isLpMultiProcess();
            Intent intent = new Intent(this.mCxt, AppUtils.getActivityClass());
            if (this.mActivity != null) {
                xAdRemoteLandingPageExtraInfo.isFullScreen = ActivityUtils.isFullScreen(this.mActivity).booleanValue();
            }
            intent.putExtra("EXTRA_DATA", xAdRemoteLandingPageExtraInfo);
            intent.putExtra("activityImplName", IReflectionInfo.APP_LP_ACTIVITY);
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.addFlags(536870912);
            this.mCxt.startActivity(intent);
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().e(e2);
        }
    }
}
