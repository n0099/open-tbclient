package com.baidu.mobads.container.splash;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.mobads.container.XBaseAdContainer;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.mobads.container.adrequest.XAdContainerContext;
import com.baidu.mobads.container.components.utils.XAdRemoteClickHandler;
import com.baidu.mobads.container.error.XAdErrorCode;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.landingpage.AppPriActivity;
import com.baidu.mobads.container.landingpage.LpCloseController;
import com.baidu.mobads.container.template.SplashVSLogUtil;
import com.baidu.mobads.container.util.ActivityUtils;
import com.baidu.mobads.container.util.AdDownloadApkUtils;
import com.baidu.mobads.container.util.PackageUtils;
import com.baidu.mobads.container.widget.OnDialogListener;
import com.baidu.mobads.container.widget.VerifyPerDialog;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.mobads.sdk.api.SplashAd;
import d.a.d0.b.g.e;
import d.a.f0.a.b;
import d.a.f0.a.d.d;
import d.a.f0.a.g.a;
import d.a.f0.a.g.b;
import d.a.f0.a.g.c;
import java.util.HashMap;
import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SplashAdContainer extends XBaseAdContainer implements c, a {
    public static final int DISPLAY_MODE_CENTER_CROP = 17;
    public static final int DISPLAY_MODE_FIT_XY = 16;
    public static final String TAG = "SplashAdContainer";
    public IOAdEventListener lpCloseListener;
    public b mAdContainer;
    public String mAdContainerType;
    public int mBitmapDisplayMode;
    public int mBottomLogoHeight;
    public int mBottomLogoResId;
    public boolean mIsDisplayDownLoadInfo;
    public boolean mIsFullScreenAd;
    public int mLabelType;
    public boolean mLimitRegionClick;
    public String mPermissionLink;
    public boolean mPopDialogIfDl;
    public String mPrivacyLink;
    public int mSkipType;
    public int mSplashLogType;

    /* loaded from: classes2.dex */
    public class LpCloseListener implements IOAdEventListener {
        public LpCloseListener() {
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            if ("AdLpClosed".equals(iOAdEvent.getType())) {
                if (SplashAdContainer.this.mAdContainer != null) {
                    SplashAdContainer.this.mAdContainer.resume();
                }
                if (SplashAdContainer.this.lpCloseListener != null) {
                    SplashAdContainer.this.lpCloseListener = null;
                }
            }
        }
    }

    public SplashAdContainer(XAdContainerContext xAdContainerContext, Context context) {
        super(xAdContainerContext);
        this.mBitmapDisplayMode = 16;
        this.mIsDisplayDownLoadInfo = true;
        this.mIsFullScreenAd = false;
        try {
            JSONObject adReqParam = this.mAdContainerCxt.getAdReqParam();
            this.mBitmapDisplayMode = adReqParam.optInt("bitmapDisplayMode", 16);
            this.mIsDisplayDownLoadInfo = adReqParam.optBoolean("Display_Down_Info", true);
            this.mPopDialogIfDl = adReqParam.optBoolean("popDialogIfDl", true);
            this.mLimitRegionClick = adReqParam.optBoolean("limitRegionClick", true);
            JSONObject originJsonObject = this.mAdInstanceInfo.getOriginJsonObject();
            this.mPrivacyLink = originJsonObject.optString(AppPriActivity.PRIVACY_LINK);
            this.mPermissionLink = originJsonObject.optString("permission_link");
            this.mIsFullScreenAd = "true".equals(adReqParam.optString(SplashAd.KEY_DISPLAY_FULL_SCREEN, "false"));
            this.mBottomLogoResId = Integer.parseInt(adReqParam.optString(SplashAd.KEY_BOTTOM_LOGO_ID, "-1"));
            this.mBottomLogoHeight = Integer.parseInt(adReqParam.optString(SplashAd.KEY_BOTTOM_LOGO_HEIGHT, "0"));
            this.mSkipType = Integer.parseInt(adReqParam.optString(SplashAd.KEY_SKIP_TYPE, "0"));
            this.mLabelType = Integer.parseInt(adReqParam.optString(SplashAd.KEY_LABEL_TYPE, "0"));
        } catch (Exception e2) {
            this.mAdLogger.d(TAG, e2);
        }
        b a2 = new d.a.f0.a.a().a(context, getContainerParameter());
        this.mAdContainer = a2;
        a2.b(this);
        this.mAdContainer.d(this);
    }

    private d.a.f0.a.b getContainerParameter() {
        this.mAdContainerType = "image";
        String mainPictureUrl = this.mAdInstanceInfo.getMainPictureUrl();
        this.mSplashLogType = 1;
        JSONObject originJsonObject = this.mAdInstanceInfo.getOriginJsonObject();
        String optString = originJsonObject.optString("publisher");
        String optString2 = originJsonObject.optString("app_version");
        boolean z = (!this.mIsDisplayDownLoadInfo || TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(this.mPrivacyLink) || TextUtils.isEmpty(this.mPermissionLink)) ? false : true;
        int i2 = getStretchFromJson(originJsonObject) == 0 ? 17 : 16;
        if (this.mAdInstanceInfo.getCreativeType().getValue().equals("gif")) {
            this.mAdContainerType = "gif";
            this.mSplashLogType = 3;
        } else if (this.mAdInstanceInfo.getCreativeType().getValue().equals("video")) {
            this.mAdContainerType = "video";
            mainPictureUrl = this.mAdInstanceInfo.getVideoUrl();
            this.mSplashLogType = 4;
        }
        b.C0581b c0581b = new b.C0581b(this.mAdContainerType, mainPictureUrl);
        c0581b.t("rsplash");
        c0581b.l(this.mIsFullScreenAd);
        c0581b.h(this.mBottomLogoHeight);
        c0581b.m(this.mBottomLogoResId);
        c0581b.j(this.mLimitRegionClick);
        c0581b.r(getMantleActionText());
        c0581b.s(this.mIsFullScreenAd ? 47 : this.mBottomLogoHeight + 39);
        c0581b.k(this.mBitmapDisplayMode);
        c0581b.i(this.mAdInstanceInfo.getCloseType());
        c0581b.v(z);
        c0581b.f(optString);
        c0581b.g(optString2);
        c0581b.u(true);
        c0581b.k(i2);
        c0581b.z(this.mSkipType);
        tryAddExtStyle(c0581b, originJsonObject);
        return c0581b.a();
    }

    private String getMantleActionText() {
        IXAdInstanceInfo iXAdInstanceInfo = this.mAdInstanceInfo;
        if (iXAdInstanceInfo != null) {
            try {
                boolean isInstalled = AdDownloadApkUtils.isInstalled(this.mAppContext, iXAdInstanceInfo.getAppPackageName());
                int optInt = TextUtils.isEmpty(this.mAdInstanceInfo.getAppOpenStrs()) ? 0 : new JSONObject(this.mAdInstanceInfo.getAppOpenStrs()).optInt("fb_act", 0);
                if (this.mAdInstanceInfo.getActionType() != 1) {
                    if (this.mAdInstanceInfo.getActionType() == 2) {
                        if (isInstalled) {
                            return "点击跳转至第三方页面";
                        }
                    } else if (this.mAdInstanceInfo.getActionType() != 512 || isInstalled) {
                        return "点击跳转至第三方页面";
                    } else {
                        if (optInt != 2) {
                            if (optInt != 1) {
                                return "点击跳转至第三方页面";
                            }
                        }
                    }
                    return "点击下载应用";
                }
                return "点击跳转至详情页";
            } catch (Throwable th) {
                String str = TAG;
                Log.e(str, "Action text error: " + th);
                return "点击跳转至第三方页面";
            }
        }
        return "点击跳转至第三方页面";
    }

    private int getStretchFromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                return jSONObject.optInt("allow_stretch", 1);
            } catch (Throwable unused) {
                return 1;
            }
        }
        return 1;
    }

    private void registerLpCloseReceiver(Context context) {
        this.lpCloseListener = new LpCloseListener();
        LpCloseController.getInstance(context).startListener();
        LpCloseController.getInstance(context).addEventListener("AdLpClosed", this.lpCloseListener);
    }

    private void tryAddExtStyle(b.C0581b c0581b, JSONObject jSONObject) {
        try {
            if (this.mSkipType == 1) {
                c0581b.z(1);
                c0581b.i(5);
                c0581b.A(72);
                c0581b.y(30);
            }
            if (this.mLabelType == 1) {
                c0581b.c("广告");
                c0581b.e(25);
                c0581b.d(13);
                c0581b.u(false);
            }
            boolean z = this.mIsFullScreenAd;
            if (jSONObject.has("pattern")) {
                z = jSONObject.optInt("pattern") == 1;
                c0581b.l(z);
                c0581b.h(e.b());
                c0581b.m(e.c());
                c0581b.s(z ? 47 : this.mBottomLogoHeight + 39);
            }
            String optString = jSONObject.optString("custom_ext_data");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject(optString);
            if (jSONObject2.has("duration")) {
                c0581b.B(jSONObject2.optInt("duration") * 1000);
                c0581b.z(1);
                c0581b.i(5);
                c0581b.A(72);
                c0581b.y(30);
            }
            if (jSONObject2.has("label_name")) {
                c0581b.c(jSONObject2.optString("label_name"));
                c0581b.e(25);
                c0581b.d(13);
                c0581b.u(false);
            }
            if (jSONObject2.has("logo_type")) {
                c0581b.n(e.d(jSONObject2.optInt("logo_type")));
                c0581b.D(68);
                c0581b.C(30);
                c0581b.o(z);
            }
            if (jSONObject2.has("style")) {
                c0581b.E(jSONObject2.optJSONObject("style"));
            }
        } catch (JSONException e2) {
            this.mAdLogger.e(TAG, e2);
        }
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public View getAdView() {
        return this.mAdContainer.getAdView();
    }

    public Bitmap getCloseBitmap() {
        d.a.f0.a.g.b bVar = this.mAdContainer;
        if (bVar instanceof d) {
            return ((d) bVar).X();
        }
        return null;
    }

    public boolean isVideoType() {
        return "video".equals(this.mAdContainerType);
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public void load() {
        this.mAdLogger.d(TAG, "load");
        this.mAdContainer.a();
        PackageUtils.sendRsplashLog(this.mAppContext, this.mAdContainerCxt, PackageUtils.RSPLASH_JSON_LOG, 1);
    }

    @Override // d.a.f0.a.g.a
    public void onAdClick() {
        PackageUtils.sendRsplashLog(this.mAppContext, this.mAdContainerCxt, PackageUtils.RSPLASH_JSON_LOG, 8);
        XAdContainerContext xAdContainerContext = this.mAdContainerCxt;
        HashMap<String, Object> shouBaiLpFlag = getShouBaiLpFlag(xAdContainerContext, xAdContainerContext.getAdInstanceInfo());
        if (shouBaiLpFlag == null) {
            shouBaiLpFlag = new HashMap<>();
        }
        shouBaiLpFlag.put(XBaseAdContainer.USE_DIALOG_FRAME, Boolean.valueOf(this.mPopDialogIfDl));
        new XAdRemoteClickHandler().onAdClicked(this, this.mAdContainerCxt.getAdInstanceInfo(), Boolean.TRUE, shouBaiLpFlag);
    }

    @Override // d.a.f0.a.g.c
    public void onAdError(String str) {
        XAdErrorCode xAdErrorCode = XAdErrorCode.MCACHE_FETCH_FAILED;
        processAdError(xAdErrorCode, "Splash Failed: " + str);
    }

    @Override // d.a.f0.a.g.c
    public void onAdLoad() {
        this.mAdState = 1;
        PackageUtils.sendRsplashLog(this.mAppContext, this.mAdContainerCxt, PackageUtils.RSPLASH_JSON_LOG, 5);
    }

    @Override // d.a.f0.a.g.a
    public void onAdLogoClick() {
        startWangmengPage();
    }

    @Override // d.a.f0.a.g.c
    public void onAdStart() {
        this.hasPlayed = true;
        if (this.mAdState != 2) {
            if ("image".equals(this.mAdContainerType)) {
                TaskScheduler.getInstance().submit(new BaseTask<Void>() { // from class: com.baidu.mobads.container.splash.SplashAdContainer.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.mobads.container.executor.BaseTask
                    public Void doInBackground() {
                        PackageUtils.sendRsplashLog(SplashAdContainer.this.mAppContext, SplashAdContainer.this.mAdContainerCxt, PackageUtils.RSPLASH_JSON_LOG, 7);
                        SplashAdContainer splashAdContainer = SplashAdContainer.this;
                        splashAdContainer.checkAndSendRsplashShowLog(splashAdContainer.mSplashLogType, null);
                        if (PackageUtils.checkSendInstalled(SplashAdContainer.this.mAppContext)) {
                            PackageUtils.sendInstalled(SplashAdContainer.this.mAppContext, SplashAdContainer.this.mAdContainerCxt);
                            PackageUtils.sendSysInstalled(SplashAdContainer.this.mAppContext, SplashAdContainer.this.mAdContainerCxt);
                            PackageUtils.sendInfo(SplashAdContainer.this.mAppContext, SplashAdContainer.this.mAdContainerCxt);
                        }
                        return null;
                    }
                }, 2);
            } else if ("gif".equals(this.mAdContainerType)) {
                PackageUtils.sendAppInstallInfo(this.mAppContext, this.mAdContainerCxt);
            } else if ("video".equals(this.mAdContainerType)) {
                checkAndSendRsplashShowLog(4, null);
            }
        }
    }

    @Override // d.a.f0.a.g.c
    public void onAdStop(String str) {
        this.mAdState = 2;
        if (!"video".equals(this.mAdContainerType)) {
            deleteTimeoutCachedFiles(this.mAppContext);
        }
        closeAd(str);
    }

    @Override // d.a.f0.a.g.a
    public void onPermissionClick() {
        VerifyPerDialog createVerPerDialog = VerifyPerDialog.createVerPerDialog(this.mAdContainerCxt.getActivity(), this.mPermissionLink);
        createVerPerDialog.setHideNavigation(true);
        createVerPerDialog.setOnDialogListener(new OnDialogListener() { // from class: com.baidu.mobads.container.splash.SplashAdContainer.2
            @Override // com.baidu.mobads.container.widget.OnDialogListener
            public void onDismiss() {
                if (SplashAdContainer.this.mAdContainer != null) {
                    SplashAdContainer.this.mAdContainer.resume();
                }
            }

            @Override // com.baidu.mobads.container.widget.OnDialogListener
            public void onShow() {
                if (SplashAdContainer.this.mAdContainer != null) {
                    SplashAdContainer.this.mAdContainer.pause();
                }
            }
        });
        createVerPerDialog.show();
    }

    @Override // d.a.f0.a.g.a
    public void onPrivacyClick() {
        Intent intent = new Intent();
        intent.putExtra(AppPriActivity.PRIVACY_LINK, this.mPrivacyLink);
        ActivityUtils.startAppPriActivity(this.mAppContext, intent);
        registerLpCloseReceiver(this.mAppContext);
    }

    @Override // d.a.f0.a.g.a
    public void onSkipClick() {
        onAdStop("click_skip_button");
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public void resetAdContainerName() {
    }

    @Override // com.baidu.mobads.container.XBaseAdContainer
    public void onAdClick(IXAdInstanceInfo iXAdInstanceInfo, View view) {
        int i2 = this.mSplashLogType;
        if (i2 == 4) {
            checkAPO(PackageUtils.SOURCE_DONWLOAD_APO_RSPLASH_VIDEO_JSON);
        } else if (i2 == 3) {
            SplashVSLogUtil.sendLog(this.mAdContainerCxt, 9, false, 3, HttpStatus.SC_FAILED_DEPENDENCY, this.showRecord);
            checkAPO(PackageUtils.SOURCE_DONWLOAD_APO_GIF_JSON);
        } else if (i2 == 1) {
            sendRsplashExpClickLog(1);
            checkAPO(PackageUtils.SOURCE_DONWLOAD_APO_RSPLASH_JSON);
        }
    }
}
