package com.baidu.mobads.container;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.asm.Label;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.mobads.container.XAdSDKRemoteExp;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.mobads.container.adrequest.ProdAdRequestInfo;
import com.baidu.mobads.container.adrequest.XAbstractAdProdTemplate;
import com.baidu.mobads.container.adrequest.XAdContainerContext;
import com.baidu.mobads.container.components.CircleTextProgressbar;
import com.baidu.mobads.container.components.command.IDownloadStateChangeListener;
import com.baidu.mobads.container.components.statemachine.AdStateCode;
import com.baidu.mobads.container.components.statemachine.StateMachine;
import com.baidu.mobads.container.components.utils.XAdRemoteClickHandler;
import com.baidu.mobads.container.config.AppConfigImp;
import com.baidu.mobads.container.download.DownloadStateHandler;
import com.baidu.mobads.container.error.XAdErrorCode;
import com.baidu.mobads.container.feeds.ThirdMonitorTracker;
import com.baidu.mobads.container.landingpage.App2Activity;
import com.baidu.mobads.container.preload.XAdMaterialsLoader;
import com.baidu.mobads.container.template.SplashVSLogUtil;
import com.baidu.mobads.container.util.ActivityUtils;
import com.baidu.mobads.container.util.AdDownloadApkUtils;
import com.baidu.mobads.container.util.AdURIUtils;
import com.baidu.mobads.container.util.AdViewUtils;
import com.baidu.mobads.container.util.OAdTimer;
import com.baidu.mobads.container.util.OpenAppUtils;
import com.baidu.mobads.container.util.PackageUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.mobads.container.util.ScreenUtils;
import com.baidu.mobads.container.util.SdcardUtils;
import com.baidu.mobads.container.util.SendLogUtil;
import com.baidu.mobads.container.util.TimeUtils;
import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.mobads.container.util.XAdRemoteEventDispatcher;
import com.baidu.mobads.container.util.animation.TransitionController;
import com.baidu.mobads.container.widget.DisplayInfoView;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class XBaseAdContainer implements IOAdEventListener {
    public static final String ADSERV_URL = "http://mobads.baidu.com/ads/index.htm";
    public static final int Baidu_Ad_IMG_ID = 16972527;
    public static final int PATTERN_FULLSCREEN = 1;
    public static final int SPLASH_BUTTON = 1;
    public static final int SPLASH_NO = 4;
    public static final int SPLASH_PRO = 5;
    public static final int STATE_LOAD = 1;
    public static final int STATE_STOP = 2;
    public static final String TAG = "XBaseAdContainer";
    public static final String TIEBA_APPID = "bb3808eb";
    public static final String USE_DIALOG_FRAME = "use_dialog_frame";
    public boolean hasPlayed;
    public Activity mActivity;
    public final XAdContainerContext mAdContainerCxt;
    public String mAdContainerName;
    public IXAdInstanceInfo mAdInstanceInfo;
    public Context mAppContext;
    public XAdRemoteEventDispatcher mContainerEvtListener;
    public HashMap<String, String> mCustomerParameters;
    public boolean mNeedCallCloseAd;
    public CircleTextProgressbar mProgressView;
    public final Long CACHE_FILE_TIME_OUT = 604800000L;
    public int mAdState = 0;
    public ImageView imageBaidu = null;
    public ImageView imageAd = null;
    public boolean mHasAdLogoClicked = false;
    public int windowFocusState = -1;
    public Map<String, WeakReference<IDownloadStateChangeListener>> mDownloadListeners = new HashMap();
    public String showRecord = null;
    public OAdTimer mTimer = null;
    public final RemoteXAdLogger mAdLogger = RemoteXAdLogger.getInstance();

    /* loaded from: classes2.dex */
    public class ApoParser {
        public XAdContainerContext mContext;
        public String mPackageName;
        public Uri mSchema;
        public List<ResolveInfo> mApps = new ArrayList();
        public List<ResolveInfo> mAppsOem = new ArrayList();
        public boolean mFoundTargetApp = false;

        public ApoParser(XAdContainerContext xAdContainerContext) {
            this.mContext = xAdContainerContext;
        }

        public int getCount(boolean z) {
            if (z) {
                return this.mFoundTargetApp ? 1 : 0;
            }
            List<ResolveInfo> list = this.mApps;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public String getPackageName() {
            return this.mPackageName;
        }

        public String getPackageNameOem() {
            List<ResolveInfo> list = this.mAppsOem;
            if (list != null && list.size() != 0) {
                try {
                    return this.mAppsOem.get(0).activityInfo.packageName;
                } catch (Throwable unused) {
                }
            }
            return "";
        }

        public Uri getUri() {
            return this.mSchema;
        }

        public ApoParser parse(IXAdInstanceInfo iXAdInstanceInfo) {
            if (iXAdInstanceInfo == null) {
                return this;
            }
            try {
                JSONObject jSONObject = new JSONObject(iXAdInstanceInfo.getAppOpenStrs());
                String optString = jSONObject.optString("page", "");
                int optInt = jSONObject.optInt("version", 0);
                this.mSchema = Uri.parse(optString);
                Intent intent = new Intent("android.intent.action.VIEW", this.mSchema);
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                PackageManager packageManager = this.mContext.getAppContext().getPackageManager();
                List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
                this.mApps = queryIntentActivities;
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    if (TextUtils.equals(resolveInfo.activityInfo.packageName, iXAdInstanceInfo.getAppPackageName())) {
                        this.mFoundTargetApp = true;
                        if (optInt > 0 && packageManager.getPackageInfo(resolveInfo.activityInfo.packageName, 0).versionCode < optInt) {
                            this.mFoundTargetApp = false;
                        }
                    } else if (resolveInfo.activityInfo.packageName.startsWith(iXAdInstanceInfo.getAppPackageName()) && optInt <= packageManager.getPackageInfo(resolveInfo.activityInfo.packageName, 0).versionCode) {
                        this.mAppsOem.add(resolveInfo);
                    }
                }
                this.mPackageName = iXAdInstanceInfo.getAppPackageName();
            } catch (Exception unused) {
                this.mApps = null;
                this.mSchema = null;
                this.mFoundTargetApp = false;
            }
            return this;
        }
    }

    public XBaseAdContainer(XAdContainerContext xAdContainerContext) {
        int i;
        JSONObject jSONObject = null;
        this.mAdContainerCxt = xAdContainerContext;
        this.mAppContext = xAdContainerContext.getAppContext();
        this.mActivity = xAdContainerContext.getActivity();
        this.mContainerEvtListener = xAdContainerContext.getEventDispatcher();
        this.mAdInstanceInfo = this.mAdContainerCxt.getAdInstanceInfo();
        try {
            this.mNeedCallCloseAd = Boolean.parseBoolean(this.mAdContainerCxt.getAdReqParam().optString("countDownNew", "true"));
        } catch (Exception unused) {
        }
        resetAdContainerName();
        IXAdInstanceInfo adInstanceInfo = this.mAdContainerCxt.getAdInstanceInfo();
        if (adInstanceInfo != null) {
            jSONObject = adInstanceInfo.getOriginJsonObject();
            i = adInstanceInfo.getActionType();
        } else {
            i = 0;
        }
        if (jSONObject != null) {
            String optString = jSONObject.optString("control_flags");
            try {
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    if (optString != null && i == 1) {
                        App2Activity.ANIMATION_DURATION_ACTIVITY_ENTER = jSONObject2.optInt("cutscenes_time", 0);
                    } else {
                        App2Activity.ANIMATION_DURATION_ACTIVITY_ENTER = 0;
                    }
                }
            } catch (JSONException unused2) {
            }
        }
    }

    private void addProgressView() {
        try {
            CircleTextProgressbar circleTextProgressbar = new CircleTextProgressbar(this.mActivity);
            this.mProgressView = circleTextProgressbar;
            circleTextProgressbar.setVisibility(4);
            this.mProgressView.setOutLineColor(-7697782);
            this.mProgressView.setProgressColor(-12956454);
            this.mProgressView.setProgressLineWidth(ScreenUtils.dp2px(this.mActivity, 2.0f));
            this.mProgressView.setTextSize(1, 10.0f);
            this.mProgressView.setTextColor(-1);
            this.mProgressView.setText("跳过");
            this.mProgressView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.mobads.container.XBaseAdContainer.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    XBaseAdContainer.this.closeAd("user_close");
                }
            });
            this.mProgressView.setCountdownProgressListener(new CircleTextProgressbar.OnCountdownProgressListener() { // from class: com.baidu.mobads.container.XBaseAdContainer.6
                @Override // com.baidu.mobads.container.components.CircleTextProgressbar.OnCountdownProgressListener
                public void onEnd() {
                    if (XBaseAdContainer.this.mNeedCallCloseAd) {
                        XBaseAdContainer.this.closeAd("time_end");
                    }
                }

                @Override // com.baidu.mobads.container.components.CircleTextProgressbar.OnCountdownProgressListener
                public void onProgress(int i) {
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenUtils.dp2px(this.mActivity, 40.0f), ScreenUtils.dp2px(this.mActivity, 40.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            int dp2px = ScreenUtils.dp2px(this.mActivity, 14.0f);
            layoutParams.setMargins(0, dp2px, dp2px, 0);
            this.mAdContainerCxt.getAdProdBase().addView(this.mProgressView, layoutParams);
        } catch (Exception unused) {
        }
    }

    public void addDownloadDescT(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mAdContainerCxt.getActivity());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (z2) {
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, 0, (int) ((this.mActivity.getResources().getDisplayMetrics().density * 15.0f) + 0.5f));
        } else {
            layoutParams.addRule(2, Baidu_Ad_IMG_ID);
        }
        relativeLayout.setLayoutParams(layoutParams);
        DisplayInfoView build = new DisplayInfoView.Builder(this.mAdContainerCxt.getActivity()).addContent(str2, str, str3, str4).addTextColor(-10066330).addHideNavigation(true).addListener(new DisplayInfoView.OnDisplayListener() { // from class: com.baidu.mobads.container.XBaseAdContainer.4
            @Override // com.baidu.mobads.container.widget.DisplayInfoView.OnDisplayListener
            public void onDismiss(boolean z3) {
                XBaseAdContainer.this.handleResume(null);
            }

            @Override // com.baidu.mobads.container.widget.DisplayInfoView.OnDisplayListener
            public void onShow(boolean z3) {
                XBaseAdContainer.this.handlePause(null);
            }
        }).build();
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        build.setGravity(17);
        relativeLayout.addView(build, layoutParams2);
        this.mAdContainerCxt.getAdProdBase().addView(relativeLayout);
    }

    public void checkAPO(int i) {
        try {
            JSONObject originJsonObject = this.mAdContainerCxt.getAdInstanceInfo().getOriginJsonObject();
            if (originJsonObject.optInt("act") == 2) {
                String optString = originJsonObject.optString("apo", "");
                if (!TextUtils.isEmpty(optString)) {
                    String optString2 = new JSONObject(optString).optString("page", "");
                    String optString3 = originJsonObject.optString("pk", "");
                    if (AdDownloadApkUtils.isInstalled(this.mAppContext, optString3)) {
                        if (!TextUtils.isEmpty(optString2)) {
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(optString2));
                            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                            if (this.mAppContext.getPackageManager().resolveActivity(intent, 65536) != null) {
                                this.mAppContext.startActivity(intent);
                                PackageUtils.sendDownloadAPOLog(this.mAppContext, this.mAdContainerCxt, optString3, optString2, i);
                            }
                        }
                    } else {
                        PackageUtils.mPageMap.put(optString3, optString2);
                    }
                }
            }
        } catch (Exception e2) {
            this.mAdLogger.d(e2);
        }
    }

    public void checkAndSendRsplashShowLog(final int i, HashMap<String, Object> hashMap) {
        XAdContainerContext xAdContainerContext = this.mAdContainerCxt;
        if (xAdContainerContext != null) {
            if (xAdContainerContext.getAdInstanceInfo() != null) {
                StateMachine.event(this.mAdContainerCxt.getAdInstanceInfo().getUniqueId(), AdStateCode.EVENT_IMPRESSION);
            }
            if (i != 1 && i != 2) {
                int viewState = AdViewUtils.getViewState(this.mAdContainerCxt.getAdProdBase());
                sendSplashViewState(viewState, true, i, 413, "");
                sendSplashViewState(viewState, true, i, HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE, "");
                sendImpressionLog(this.mAdContainerCxt.getAdInstanceInfo());
                send3rdImpressionLog();
                processAdStart(hashMap);
                return;
            }
            int viewState2 = AdViewUtils.getViewState(this.mAdContainerCxt.getAdProdBase());
            if (viewState2 == 0) {
                sendImpressionLog(this.mAdContainerCxt.getAdInstanceInfo());
                send3rdImpressionLog();
                sendSplashViewState(viewState2, true, i, 413, "");
                processAdStart(hashMap);
                return;
            }
            try {
                processAdStart(hashMap);
                sendSplashViewState(viewState2, false, i, 413, "1");
                this.showRecord = "";
                this.showRecord += viewState2;
                if (this.mTimer != null) {
                    this.mTimer.stop();
                    this.mTimer = null;
                }
                OAdTimer oAdTimer = new OAdTimer(3000);
                this.mTimer = oAdTimer;
                oAdTimer.setEventHandler(new OAdTimer.EventHandler() { // from class: com.baidu.mobads.container.XBaseAdContainer.7
                    @Override // com.baidu.mobads.container.util.OAdTimer.EventHandler
                    public void onTimer(int i2) {
                        int viewState3 = AdViewUtils.getViewState(XBaseAdContainer.this.mAdContainerCxt.getAdProdBase());
                        StringBuilder sb = new StringBuilder();
                        XBaseAdContainer xBaseAdContainer = XBaseAdContainer.this;
                        sb.append(xBaseAdContainer.showRecord);
                        sb.append(viewState3);
                        xBaseAdContainer.showRecord = sb.toString();
                        if (XBaseAdContainer.this.showRecord.endsWith("00")) {
                            XBaseAdContainer xBaseAdContainer2 = XBaseAdContainer.this;
                            xBaseAdContainer2.sendImpressionLog(xBaseAdContainer2.mAdContainerCxt.getAdInstanceInfo());
                            XBaseAdContainer.this.send3rdImpressionLog();
                            XBaseAdContainer xBaseAdContainer3 = XBaseAdContainer.this;
                            xBaseAdContainer3.sendSplashViewState(9, true, i, HttpStatus.SC_LOCKED, xBaseAdContainer3.showRecord);
                            if (XBaseAdContainer.this.mTimer != null) {
                                XBaseAdContainer.this.mTimer.stop();
                                XBaseAdContainer.this.mTimer = null;
                            }
                        }
                    }

                    @Override // com.baidu.mobads.container.util.OAdTimer.EventHandler
                    public void onTimerComplete() {
                        int viewState3 = AdViewUtils.getViewState(XBaseAdContainer.this.mAdContainerCxt.getAdProdBase());
                        XBaseAdContainer xBaseAdContainer = XBaseAdContainer.this;
                        xBaseAdContainer.sendSplashViewState(viewState3, false, i, HttpStatus.SC_LOCKED, xBaseAdContainer.showRecord);
                        XAdContainerContext xAdContainerContext2 = XBaseAdContainer.this.mAdContainerCxt;
                        if (xAdContainerContext2 == null || xAdContainerContext2.getAdInstanceInfo() == null) {
                            return;
                        }
                        StateMachine.event(XBaseAdContainer.this.mAdContainerCxt.getAdInstanceInfo().getUniqueId(), AdStateCode.EVENT_IMPRESSION_FAILED);
                    }
                });
                this.mTimer.start();
                sendSplashViewState(viewState2, false, i, 413, "2");
            } catch (Exception e2) {
                sendSplashViewState(viewState2, false, i, HttpStatus.SC_LOCKED, "exception");
                this.mAdLogger.d(e2);
            }
        }
    }

    public void close() {
    }

    public void closeAd(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("video_close_reason", str);
        this.mAdContainerCxt.getEventDispatcher().dispatchEvent(new XAdRemoteEvent("AdStopped", hashMap));
    }

    public void deleteTimeoutCachedFiles(Context context) {
        try {
            File file = new File(SdcardUtils.getStoragePath(context));
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    if (System.currentTimeMillis() - file2.lastModified() > this.CACHE_FILE_TIME_OUT.longValue()) {
                        file2.delete();
                    }
                }
            }
        } catch (Exception e2) {
            this.mAdLogger.e(e2);
        }
    }

    public void destroy() {
    }

    public void displayVersion4DebugMode() {
        if (!XAdSDKRemoteVersion.DEBUG.booleanValue() || this.mActivity == null) {
            return;
        }
        TextView textView = new TextView(this.mActivity);
        textView.setTextColor(-16776961);
        textView.setTextSize(15.0f);
        textView.setText("P : " + AppConfigImp.getInstance().getProxyVersion() + "\nR : 9.041");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = 10;
        layoutParams.addRule(13);
        this.mAdContainerCxt.getAdProdBase().addView(textView, layoutParams);
    }

    public void dispose() {
    }

    public void doAddProgressView() {
        IXAdInstanceInfo adInstanceInfo = this.mAdContainerCxt.getAdInstanceInfo();
        int optInt = this.mAdContainerCxt.getAdReqParam().optInt("splashTipStyle", 4);
        if (adInstanceInfo.getOriginJsonObject().has("closetype")) {
            optInt = adInstanceInfo.getOriginJsonObject().optInt("closetype", 4);
        }
        addProgressView();
        if (!"video".equals(adInstanceInfo.getCreativeType().getValue())) {
            this.mProgressView.setTimeMillis(5000L);
            this.mProgressView.start();
        }
        if (optInt == 5) {
            this.mProgressView.setVisibility(0);
        } else if (optInt == 1) {
            this.mProgressView.setVisibility(0);
        }
    }

    public void doLoadOnUIThread() {
    }

    public void doStartOnUIThread() {
    }

    public void doStopOnUIThread() {
    }

    public XAdContainerContext getAdContainerContext() {
        return this.mAdContainerCxt;
    }

    public String getAdContainerName() {
        return this.mAdContainerName;
    }

    public IXAdInstanceInfo getAdInstanceInfoByJson(JSONObject jSONObject) {
        XAdContainerContext xAdContainerContext;
        ArrayList<IXAdInstanceInfo> adInstanceList;
        if (jSONObject == null || !jSONObject.has("uniqueId")) {
            return null;
        }
        String optString = jSONObject.optString("uniqueId");
        if (TextUtils.isEmpty(optString) || (xAdContainerContext = this.mAdContainerCxt) == null || xAdContainerContext.getAdResponseInfo() == null || (adInstanceList = this.mAdContainerCxt.getAdResponseInfo().getAdInstanceList()) == null) {
            return null;
        }
        for (IXAdInstanceInfo iXAdInstanceInfo : adInstanceList) {
            if (iXAdInstanceInfo != null && optString.equals(iXAdInstanceInfo.getUniqueId())) {
                return iXAdInstanceInfo;
            }
        }
        return null;
    }

    public int getAdStateForTest() {
        return this.mAdState;
    }

    public View getAdView() {
        return null;
    }

    public HashMap<String, String> getParameters() {
        return this.mCustomerParameters;
    }

    public String getRemoteVersion() {
        return "9.041";
    }

    public HashMap<String, Object> getShouBaiLpFlag(XAdContainerContext xAdContainerContext, IXAdInstanceInfo iXAdInstanceInfo) {
        return XAdRemoteCommonUtils.getLpFlag(xAdContainerContext, iXAdInstanceInfo);
    }

    public void handleClick() {
    }

    public void handleEvent(JSONObject jSONObject, Map<String, Object> map) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("event_type");
            try {
                if ("splash_focus_start_activity".equals(optString)) {
                    TransitionController.startActivity((Intent) map.get("splash_focus_user_intent"), this);
                } else if ("splash_focus_register_transition".equals(optString)) {
                    TransitionController.registerSceneTransition((Activity) map.get("splash_focus_activity"), jSONObject.optJSONObject("splash_focus_params"));
                }
            } catch (Throwable th) {
                RemoteXAdLogger.getInstance().e(th);
            }
        }
    }

    public void handlePause(IXAdInstanceInfo iXAdInstanceInfo) {
        CircleTextProgressbar circleTextProgressbar = this.mProgressView;
        if (circleTextProgressbar != null) {
            circleTextProgressbar.stop();
        }
    }

    public void handleResume(IXAdInstanceInfo iXAdInstanceInfo) {
        CircleTextProgressbar circleTextProgressbar = this.mProgressView;
        if (circleTextProgressbar != null) {
            circleTextProgressbar.start();
        }
    }

    public void load() {
        this.mAdLogger.d(TAG, TrackLoadSettingsAtom.TYPE);
        this.mAdState = 1;
        ActivityUtils.runOnUiThread(new Runnable() { // from class: com.baidu.mobads.container.XBaseAdContainer.1
            @Override // java.lang.Runnable
            public void run() {
                XBaseAdContainer.this.doLoadOnUIThread();
            }
        });
        XAdMaterialsLoader.getInstance().startLoadRemoteSetting(this.mAppContext);
    }

    public void onAdClick(IXAdInstanceInfo iXAdInstanceInfo, View view) {
    }

    public void onAttachedToWindow() {
    }

    public void onDetachedFromWindow() {
    }

    public void onPermissionClose(IXAdInstanceInfo iXAdInstanceInfo) {
    }

    public void onPermissionShow(IXAdInstanceInfo iXAdInstanceInfo) {
    }

    public void onPrivacyClick(IXAdInstanceInfo iXAdInstanceInfo) {
    }

    public void onPrivacyLpClose(IXAdInstanceInfo iXAdInstanceInfo) {
    }

    public void onWindowFocusChanged(boolean z) {
        if (z) {
            this.windowFocusState = 1;
        } else {
            this.windowFocusState = 0;
        }
    }

    public void onWindowVisibilityChanged(int i) {
    }

    public ApoParser parseApo(IXAdInstanceInfo iXAdInstanceInfo) {
        return new ApoParser(this.mAdContainerCxt).parse(iXAdInstanceInfo);
    }

    public void pause() {
    }

    public void processAdError(XAdErrorCode xAdErrorCode, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("error_message", str);
        this.mAdContainerCxt.getEventDispatcher().dispatchEvent(new XAdRemoteEvent("AdError", xAdErrorCode.getCode(), hashMap));
    }

    public void processAdStart() {
        processAdStart(null);
    }

    public Boolean processKeyEvent(int i, KeyEvent keyEvent) {
        return Boolean.FALSE;
    }

    public boolean processShouldOverrideUrlLoading(String str, WebView webView) {
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            OpenAppUtils.browserOutside(webView.getContext(), str);
        } else if (str.startsWith(AdURIUtils.replaceURLWithSupportProtocol("http://mobads.baidu.com/ads/index.htm"))) {
            webView.loadUrl(str);
        } else {
            IXAdInstanceInfo adInstanceInfo = this.mAdContainerCxt.getAdInstanceInfo();
            adInstanceInfo.setClickThroughUrl(str);
            adInstanceInfo.setActionType(1);
            new XAdRemoteClickHandler().onAdClicked(this, adInstanceInfo, Boolean.TRUE, null);
            StateMachine.event(adInstanceInfo.getUniqueId(), AdStateCode.EVENT_CLICK);
            StateMachine.event(adInstanceInfo.getUniqueId(), AdStateCode.EVENT_CLICK_LP);
        }
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(38:1|2|3|4|(3:143|144|145)|6|(2:7|8)|(1:10)|11|(8:125|126|128|129|(1:131)|132|133|(2:135|(26:137|15|(1:124)(1:21)|22|23|24|(2:26|(1:28)(1:29))|30|31|(1:121)(16:34|35|36|37|38|39|40|41|42|(1:113)(10:47|48|50|51|52|53|54|(1:56)|57|58)|59|(1:61)|62|(1:64)|(2:87|(1:(3:96|(5:99|100|102|103|104)|98)(1:95))(1:91))(2:68|(5:70|(1:72)|73|74|75)(2:(1:84)(1:86)|85))|(2:77|78)(1:80))|118|42|(0)|113|59|(0)|62|(0)|(1:66)|87|(1:89)|(1:93)|96|(0)|98|(0)(0))))(1:13)|14|15|(1:17)|124|22|23|24|(0)|30|31|(0)|121|118|42|(0)|113|59|(0)|62|(0)|(0)|87|(0)|(0)|96|(0)|98|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x012d, code lost:
        r19 = r9;
        r18 = "version";
        r17 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e4 A[Catch: all -> 0x012d, TRY_ENTER, TryCatch #5 {all -> 0x012d, blocks: (B:44:0x00d6, B:47:0x00e4, B:50:0x00f5, B:51:0x00f9), top: B:137:0x00d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x021f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void pullShoubaiExp(IXAdInstanceInfo iXAdInstanceInfo) {
        JSONObject jSONObject;
        boolean z;
        XAdInstanceInfoExt xAdInstanceInfoExt;
        XAdInstanceInfoExt xAdInstanceInfoExt2;
        XAdInstanceInfoExt xAdInstanceInfoExt3;
        String str;
        int i;
        int i2;
        XAdInstanceInfoExt xAdInstanceInfoExt4;
        XAdInstanceInfoExt xAdInstanceInfoExt5;
        long lastOpenAppTime;
        int count;
        try {
            jSONObject = new JSONObject(iXAdInstanceInfo.getAppOpenStrs());
        } catch (Exception e2) {
            this.mAdLogger.d(e2);
            jSONObject = null;
        }
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject(iXAdInstanceInfo.getClickThroughUrl());
            } catch (Exception e3) {
                this.mAdLogger.d(e3);
            }
        }
        int i3 = App2Activity.ANIMATION_DURATION_ACTIVITY_ENTER;
        try {
            JSONObject jSONObject2 = new JSONObject(iXAdInstanceInfo.getOriginJsonObject().optString("control_flags"));
            i3 = jSONObject2.optInt("cutscenes_time", i3);
            z = jSONObject2.optBoolean("exp_apo_ignore_freq_limit", false);
        } catch (Exception unused) {
            z = false;
        }
        if (jSONObject != null) {
            iXAdInstanceInfo.setAppOpenStrs(jSONObject.toString());
        }
        ApoParser parseApo = parseApo(iXAdInstanceInfo);
        if (parseApo.getCount(true) == 0) {
            try {
                xAdInstanceInfoExt = new XAdInstanceInfoExt(iXAdInstanceInfo);
                try {
                    JSONObject jSONObject3 = new JSONObject(xAdInstanceInfoExt.getAppOpenStrs());
                    String optString = jSONObject3.optString("page", "");
                    if (!TextUtils.isEmpty(optString)) {
                        jSONObject3.put("page", optString.replace(BaseWebViewActivity.SHOUBAI_SCHEME, "baiduboxlite"));
                    }
                    jSONObject3.put("version", 19202176);
                    xAdInstanceInfoExt.setAppOpenStrs(jSONObject3.toString());
                    xAdInstanceInfoExt.setAppPackageName(BdSailorPlatform.LITE_PACKAGE_NAME);
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                xAdInstanceInfoExt = null;
            }
            if (parseApo.getCount(false) > 0) {
                String packageNameOem = parseApo.getPackageNameOem();
                if (!TextUtils.isEmpty(packageNameOem)) {
                    xAdInstanceInfoExt2 = new XAdInstanceInfoExt(iXAdInstanceInfo);
                    xAdInstanceInfoExt2.setAppPackageName(packageNameOem);
                    ApoParser parseApo2 = parseApo(xAdInstanceInfoExt2);
                    ApoParser parseApo3 = parseApo(xAdInstanceInfoExt);
                    boolean z2 = 1 != parseApo.getCount(true) || 1 == parseApo3.getCount(true) || 1 == parseApo2.getCount(true);
                    lastOpenAppTime = TimeUtils.getLastOpenAppTime(this.mAppContext);
                    if (lastOpenAppTime < 0) {
                        String str2 = XAdPersistData.getInstance().get("dltime");
                        lastOpenAppTime = TextUtils.isEmpty(str2) ? 0L : Long.parseLong(str2);
                    }
                    count = XAdSDKRemoteExp.SearchBoxAct.count(lastOpenAppTime) | z;
                    if (count == 0 && z2) {
                        try {
                            XAdPersistData xAdPersistData = XAdPersistData.getInstance();
                            i = count;
                            try {
                                StringBuilder sb = new StringBuilder();
                                sb.append("");
                                xAdInstanceInfoExt3 = xAdInstanceInfoExt;
                                str = "version";
                                try {
                                    sb.append(TimeUtils.getDateHour());
                                    xAdPersistData.put("dltime", sb.toString());
                                } catch (Throwable unused4) {
                                }
                            } catch (Throwable unused5) {
                            }
                        } catch (Throwable unused6) {
                            i = count;
                        }
                        i2 = i;
                        if (i2 == 0 && z2 && !AppConfigImp.getInstance().isLpMultiProcess()) {
                            try {
                                XAdInstanceInfoExt xAdInstanceInfoExt6 = new XAdInstanceInfoExt(iXAdInstanceInfo);
                                try {
                                    JSONObject jSONObject4 = new JSONObject(iXAdInstanceInfo.getAppOpenStrs());
                                    xAdInstanceInfoExt5 = xAdInstanceInfoExt6;
                                    try {
                                        int optInt = jSONObject4.optInt("fb_act", 0);
                                        String optString2 = jSONObject4.optString("fallback", "");
                                        if (!TextUtils.isEmpty(optString2)) {
                                            optString2 = optString2 + "&exp_dup=1";
                                        }
                                        iXAdInstanceInfo.setActionType(optInt);
                                        iXAdInstanceInfo.setAppPackageName("");
                                        iXAdInstanceInfo.setClickThroughUrl(optString2);
                                    } catch (Exception unused7) {
                                    }
                                } catch (Exception unused8) {
                                    xAdInstanceInfoExt5 = xAdInstanceInfoExt6;
                                }
                            } catch (Exception unused9) {
                                xAdInstanceInfoExt5 = null;
                            }
                            App2Activity.SHOUBAI_LP_APO_START = true;
                            App2Activity.SHOUBAI_LP_APO_START_TIME = System.currentTimeMillis();
                            App2Activity.ANIMATION_DURATION_ACTIVITY_ENTER = i3;
                            new XAdRemoteClickHandler().onAdClicked(this, iXAdInstanceInfo, Boolean.TRUE, getShouBaiLpFlag(this.mAdContainerCxt, iXAdInstanceInfo));
                            xAdInstanceInfoExt4 = xAdInstanceInfoExt5;
                        } else {
                            xAdInstanceInfoExt4 = null;
                        }
                        HashMap hashMap = new HashMap();
                        if (App2Activity.SHOUBAI_LP_APO_START) {
                            hashMap.put("exp_dup", "1");
                        }
                        hashMap.put("exp_main", "" + parseApo.getCount(true));
                        hashMap.put("exp_lite", "" + parseApo3.getCount(true));
                        hashMap.put("exp_allow", "" + i2);
                        if (jSONObject != null) {
                            PackageUtils.sendAPOInfo(this.mAdContainerCxt, jSONObject.optString("page", ""), iXAdInstanceInfo.getAppPackageName(), SDKLogTypeConstants.TYPE_SHOUBAI_APO_INFO, jSONObject.optInt("fb_act", 0), jSONObject.optInt(str, 0), hashMap);
                        }
                        if (i2 == 0 && 1 == parseApo.getCount(true)) {
                            if (1 < parseApo.getCount(false)) {
                                Intent intent = new Intent("android.intent.action.VIEW", parseApo.getUri());
                                if (!TextUtils.isEmpty(parseApo.getPackageName())) {
                                    intent.setPackage(parseApo.getPackageName());
                                }
                                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                                try {
                                    this.mAppContext.startActivity(intent);
                                } catch (Throwable unused10) {
                                }
                            } else {
                                XAdInstanceInfoExt xAdInstanceInfoExt7 = xAdInstanceInfoExt4 == null ? iXAdInstanceInfo : xAdInstanceInfoExt4;
                                new XAdRemoteClickHandler().onAdClicked(this, xAdInstanceInfoExt7, Boolean.TRUE, getShouBaiLpFlag(this.mAdContainerCxt, xAdInstanceInfoExt7));
                            }
                        } else if (i2 == 0 && 1 == parseApo2.getCount(true)) {
                            new XAdRemoteClickHandler().onAdClicked(this, xAdInstanceInfoExt2, Boolean.TRUE, getShouBaiLpFlag(this.mAdContainerCxt, xAdInstanceInfoExt2));
                        } else if (i2 == 0 && 1 == parseApo3.getCount(true)) {
                            XAdInstanceInfoExt xAdInstanceInfoExt8 = xAdInstanceInfoExt3;
                            new XAdRemoteClickHandler().onAdClicked(this, xAdInstanceInfoExt8, Boolean.TRUE, getShouBaiLpFlag(this.mAdContainerCxt, xAdInstanceInfoExt8));
                        } else {
                            App2Activity.ANIMATION_DURATION_ACTIVITY_ENTER = i3;
                            if (parseApo.getCount(false) > 0) {
                                try {
                                    XAdInstanceInfoExt xAdInstanceInfoExt9 = new XAdInstanceInfoExt(iXAdInstanceInfo.getOriginJsonObject());
                                    try {
                                        JSONObject jSONObject5 = new JSONObject(iXAdInstanceInfo.getAppOpenStrs());
                                        iXAdInstanceInfo.setActionType(jSONObject5.optInt("fb_act", 0));
                                        iXAdInstanceInfo.setAppPackageName("");
                                        iXAdInstanceInfo.setClickThroughUrl(jSONObject5.optString("fallback", ""));
                                    } catch (Exception unused11) {
                                    }
                                    xAdInstanceInfoExt4 = xAdInstanceInfoExt9;
                                } catch (Exception unused12) {
                                }
                            }
                            new XAdRemoteClickHandler().onAdClicked(this, iXAdInstanceInfo, Boolean.TRUE, getShouBaiLpFlag(this.mAdContainerCxt, iXAdInstanceInfo));
                        }
                        if (xAdInstanceInfoExt4 != null) {
                            iXAdInstanceInfo.setActionType(xAdInstanceInfoExt4.getActionType());
                            iXAdInstanceInfo.setAppPackageName(xAdInstanceInfoExt4.getAppPackageName());
                            iXAdInstanceInfo.setClickThroughUrl(xAdInstanceInfoExt4.getClickThroughUrl());
                            return;
                        }
                        return;
                    }
                    i = count;
                    xAdInstanceInfoExt3 = xAdInstanceInfoExt;
                    str = "version";
                    i2 = i;
                    if (i2 == 0) {
                    }
                    xAdInstanceInfoExt4 = null;
                    HashMap hashMap2 = new HashMap();
                    if (App2Activity.SHOUBAI_LP_APO_START) {
                    }
                    hashMap2.put("exp_main", "" + parseApo.getCount(true));
                    hashMap2.put("exp_lite", "" + parseApo3.getCount(true));
                    hashMap2.put("exp_allow", "" + i2);
                    if (jSONObject != null) {
                    }
                    if (i2 == 0) {
                    }
                    if (i2 == 0) {
                    }
                    if (i2 == 0) {
                    }
                    App2Activity.ANIMATION_DURATION_ACTIVITY_ENTER = i3;
                    if (parseApo.getCount(false) > 0) {
                    }
                    new XAdRemoteClickHandler().onAdClicked(this, iXAdInstanceInfo, Boolean.TRUE, getShouBaiLpFlag(this.mAdContainerCxt, iXAdInstanceInfo));
                    if (xAdInstanceInfoExt4 != null) {
                    }
                }
            }
        } else {
            xAdInstanceInfoExt = null;
        }
        xAdInstanceInfoExt2 = null;
        ApoParser parseApo22 = parseApo(xAdInstanceInfoExt2);
        ApoParser parseApo32 = parseApo(xAdInstanceInfoExt);
        if (1 != parseApo.getCount(true)) {
        }
        lastOpenAppTime = TimeUtils.getLastOpenAppTime(this.mAppContext);
        if (lastOpenAppTime < 0) {
        }
        count = XAdSDKRemoteExp.SearchBoxAct.count(lastOpenAppTime) | z;
        if (count == 0) {
        }
        i = count;
        xAdInstanceInfoExt3 = xAdInstanceInfoExt;
        str = "version";
        i2 = i;
        if (i2 == 0) {
        }
        xAdInstanceInfoExt4 = null;
        HashMap hashMap22 = new HashMap();
        if (App2Activity.SHOUBAI_LP_APO_START) {
        }
        hashMap22.put("exp_main", "" + parseApo.getCount(true));
        hashMap22.put("exp_lite", "" + parseApo32.getCount(true));
        hashMap22.put("exp_allow", "" + i2);
        if (jSONObject != null) {
        }
        if (i2 == 0) {
        }
        if (i2 == 0) {
        }
        if (i2 == 0) {
        }
        App2Activity.ANIMATION_DURATION_ACTIVITY_ENTER = i3;
        if (parseApo.getCount(false) > 0) {
        }
        new XAdRemoteClickHandler().onAdClicked(this, iXAdInstanceInfo, Boolean.TRUE, getShouBaiLpFlag(this.mAdContainerCxt, iXAdInstanceInfo));
        if (xAdInstanceInfoExt4 != null) {
        }
    }

    public void registerState(long j, String str, IXAdInstanceInfo iXAdInstanceInfo) {
    }

    public abstract void resetAdContainerName();

    public void resize(int i, int i2) {
    }

    public void resume() {
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent == null || !"AdStatusChange".equals(iOAdEvent.getType())) {
            return;
        }
        try {
            String message = iOAdEvent.getMessage();
            if (TextUtils.isEmpty(message)) {
                return;
            }
            Iterator<IXAdInstanceInfo> it = getAdContainerContext().getAdResponseInfo().getAdInstanceList().iterator();
            while (it.hasNext()) {
                IXAdInstanceInfo next = it.next();
                if (message.equals(next.getAppPackageName())) {
                    this.mAdContainerCxt.getEventDispatcher().dispatchEvent(new XAdRemoteEvent("AdStatusChange", next.getUniqueId()));
                }
            }
            HashMap<String, WeakReference<IDownloadStateChangeListener>> downloadListener = DownloadStateHandler.getInstance().getDownloadListener();
            this.mDownloadListeners = downloadListener;
            if (downloadListener == null || downloadListener.size() <= 0 || this.mDownloadListeners.get(message) == null || this.mDownloadListeners.get(message).get() == null) {
                return;
            }
            this.mDownloadListeners.get(message).get().onDownloadStateChange();
        } catch (Throwable th) {
            this.mAdLogger.d(th);
        }
    }

    public void send3rdImpressionLog() {
        send3rdLog(this.mAdContainerCxt.getAdInstanceInfo().getThirdImpressionTrackingUrls());
    }

    public void send3rdLog(List<String> list) {
        if (list == null) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("appsid", this.mAdContainerCxt.getAppsid());
                } catch (JSONException unused) {
                }
                SendLogUtil.fireAdMetrics(ThirdMonitorTracker.getInstance().build3rdLogUrl(this.mAppContext, str, jSONObject), null);
            }
        }
    }

    public void sendImpressionLog(IXAdInstanceInfo iXAdInstanceInfo) {
        Set<String> impressionUrls = iXAdInstanceInfo.getImpressionUrls();
        if (impressionUrls != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : impressionUrls.toArray()) {
                arrayList.add((String) obj);
            }
            impressionUrls.clear();
            send3rdLog(arrayList);
        }
        this.mAdContainerCxt.getEventDispatcher().dispatchEvent(new XAdRemoteEvent("AdImpression", iXAdInstanceInfo.getUniqueId()));
    }

    public void sendRsplashExpClickLog(int i) {
        sendSplashViewState(9, false, i, HttpStatus.SC_FAILED_DEPENDENCY, this.showRecord);
    }

    public void sendSplashViewState(int i, boolean z, int i2, int i3, String str) {
        SplashVSLogUtil.sendLog(this.mAdContainerCxt, i, z, i2, i3, str);
    }

    public void setAdStateForTest(int i) {
        this.mAdState = i;
    }

    public void setParameters(HashMap<String, String> hashMap) {
        this.mCustomerParameters = hashMap;
    }

    public void start() {
        this.hasPlayed = true;
        this.mAdLogger.d(TAG, IntentConfig.START);
        ActivityUtils.runOnUiThread(new Runnable() { // from class: com.baidu.mobads.container.XBaseAdContainer.2
            @Override // java.lang.Runnable
            public void run() {
                XBaseAdContainer.this.doStartOnUIThread();
            }
        });
    }

    public void startWangmengPage() {
        IXAdInstanceInfo adInstanceInfo = this.mAdContainerCxt.getAdInstanceInfo();
        adInstanceInfo.setClickThroughUrl("https://union.baidu.com");
        adInstanceInfo.setActionType(1);
        new XAdRemoteClickHandler().onAdClicked(this, adInstanceInfo, Boolean.TRUE, null);
    }

    public void stop() {
        ActivityUtils.runOnUiThread(new Runnable() { // from class: com.baidu.mobads.container.XBaseAdContainer.3
            @Override // java.lang.Runnable
            public void run() {
                XBaseAdContainer.this.doStopOnUIThread();
            }
        });
    }

    public void switchContext(Activity activity) {
        this.mActivity = activity;
        XAdContainerContext adContainerContext = getAdContainerContext();
        if (adContainerContext instanceof XAbstractAdProdTemplate) {
            adContainerContext.setActivity(activity);
            ProdAdRequestInfo prodAdRequestInfo = ((XAbstractAdProdTemplate) adContainerContext).mAdRequestInfo;
            if (prodAdRequestInfo != null) {
                prodAdRequestInfo.setAdContainer(null);
            }
        }
        this.imageAd = null;
        this.imageBaidu = null;
        this.mProgressView = null;
    }

    public void processAdStart(HashMap<String, Object> hashMap) {
        this.mAdContainerCxt.getEventDispatcher().dispatchEvent(new XAdRemoteEvent("AdStarted", hashMap));
    }

    public void processAdError(HashMap<String, Object> hashMap) {
        this.mAdContainerCxt.getEventDispatcher().dispatchEvent(new XAdRemoteEvent("AdError", hashMap));
    }
}
