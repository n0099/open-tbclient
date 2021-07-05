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
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.pose.PoseAR;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes3.dex */
public abstract class XBaseAdContainer implements IOAdEventListener {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
    public final Long CACHE_FILE_TIME_OUT;
    public boolean hasPlayed;
    public ImageView imageAd;
    public ImageView imageBaidu;
    public Activity mActivity;
    public final XAdContainerContext mAdContainerCxt;
    public String mAdContainerName;
    public IXAdInstanceInfo mAdInstanceInfo;
    public final RemoteXAdLogger mAdLogger;
    public int mAdState;
    public Context mAppContext;
    public XAdRemoteEventDispatcher mContainerEvtListener;
    public HashMap<String, String> mCustomerParameters;
    public Map<String, WeakReference<IDownloadStateChangeListener>> mDownloadListeners;
    public boolean mHasAdLogoClicked;
    public boolean mNeedCallCloseAd;
    public CircleTextProgressbar mProgressView;
    public OAdTimer mTimer;
    public String showRecord;
    public int windowFocusState;

    /* loaded from: classes3.dex */
    public class ApoParser {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<ResolveInfo> mApps;
        public List<ResolveInfo> mAppsOem;
        public XAdContainerContext mContext;
        public boolean mFoundTargetApp;
        public String mPackageName;
        public Uri mSchema;
        public final /* synthetic */ XBaseAdContainer this$0;

        public ApoParser(XBaseAdContainer xBaseAdContainer, XAdContainerContext xAdContainerContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xBaseAdContainer, xAdContainerContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = xBaseAdContainer;
            this.mApps = new ArrayList();
            this.mAppsOem = new ArrayList();
            this.mFoundTargetApp = false;
            this.mContext = xAdContainerContext;
        }

        public int getCount(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                if (z) {
                    return this.mFoundTargetApp ? 1 : 0;
                }
                List<ResolveInfo> list = this.mApps;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeZ.intValue;
        }

        public String getPackageName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mPackageName : (String) invokeV.objValue;
        }

        public String getPackageNameOem() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                List<ResolveInfo> list = this.mAppsOem;
                if (list != null && list.size() != 0) {
                    try {
                        return this.mAppsOem.get(0).activityInfo.packageName;
                    } catch (Throwable unused) {
                    }
                }
                return "";
            }
            return (String) invokeV.objValue;
        }

        public Uri getUri() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mSchema : (Uri) invokeV.objValue;
        }

        public ApoParser parse(IXAdInstanceInfo iXAdInstanceInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, iXAdInstanceInfo)) == null) {
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
            return (ApoParser) invokeL.objValue;
        }
    }

    public XBaseAdContainer(XAdContainerContext xAdContainerContext) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xAdContainerContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.CACHE_FILE_TIME_OUT = 604800000L;
        this.mAdState = 0;
        JSONObject jSONObject = null;
        this.imageBaidu = null;
        this.imageAd = null;
        this.mHasAdLogoClicked = false;
        this.windowFocusState = -1;
        this.mDownloadListeners = new HashMap();
        this.showRecord = null;
        this.mTimer = null;
        this.mAdContainerCxt = xAdContainerContext;
        this.mAppContext = xAdContainerContext.getAppContext();
        this.mActivity = xAdContainerContext.getActivity();
        this.mContainerEvtListener = xAdContainerContext.getEventDispatcher();
        this.mAdInstanceInfo = this.mAdContainerCxt.getAdInstanceInfo();
        this.mAdLogger = RemoteXAdLogger.getInstance();
        try {
            this.mNeedCallCloseAd = Boolean.parseBoolean(this.mAdContainerCxt.getAdReqParam().optString("countDownNew", "true"));
        } catch (Exception unused) {
        }
        resetAdContainerName();
        IXAdInstanceInfo adInstanceInfo = this.mAdContainerCxt.getAdInstanceInfo();
        if (adInstanceInfo != null) {
            jSONObject = adInstanceInfo.getOriginJsonObject();
            i2 = adInstanceInfo.getActionType();
        } else {
            i2 = 0;
        }
        if (jSONObject != null) {
            String optString = jSONObject.optString("control_flags");
            try {
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    if (optString != null && i2 == 1) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
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
                this.mProgressView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.mobads.container.XBaseAdContainer.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ XBaseAdContainer this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.this$0.closeAd("user_close");
                        }
                    }
                });
                this.mProgressView.setCountdownProgressListener(new CircleTextProgressbar.OnCountdownProgressListener(this) { // from class: com.baidu.mobads.container.XBaseAdContainer.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ XBaseAdContainer this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // com.baidu.mobads.container.components.CircleTextProgressbar.OnCountdownProgressListener
                    public void onEnd() {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.this$0.mNeedCallCloseAd) {
                            this.this$0.closeAd("time_end");
                        }
                    }

                    @Override // com.baidu.mobads.container.components.CircleTextProgressbar.OnCountdownProgressListener
                    public void onProgress(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                        }
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
    }

    public void addDownloadDescT(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, str3, str4, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            RelativeLayout relativeLayout = new RelativeLayout(this.mAdContainerCxt.getActivity());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            if (z2) {
                layoutParams.addRule(12);
                layoutParams.setMargins(0, 0, 0, (int) ((this.mActivity.getResources().getDisplayMetrics().density * 15.0f) + 0.5f));
            } else {
                layoutParams.addRule(2, Baidu_Ad_IMG_ID);
            }
            relativeLayout.setLayoutParams(layoutParams);
            DisplayInfoView build = new DisplayInfoView.Builder(this.mAdContainerCxt.getActivity()).addContent(str2, str, str3, str4).addTextColor(-10066330).addHideNavigation(true).addListener(new DisplayInfoView.OnDisplayListener(this) { // from class: com.baidu.mobads.container.XBaseAdContainer.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ XBaseAdContainer this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.mobads.container.widget.DisplayInfoView.OnDisplayListener
                public void onDismiss(boolean z3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z3) == null) {
                        this.this$0.handleResume(null);
                    }
                }

                @Override // com.baidu.mobads.container.widget.DisplayInfoView.OnDisplayListener
                public void onShow(boolean z3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z3) == null) {
                        this.this$0.handlePause(null);
                    }
                }
            }).build();
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            build.setGravity(17);
            relativeLayout.addView(build, layoutParams2);
            this.mAdContainerCxt.getAdProdBase().addView(relativeLayout);
        }
    }

    public void checkAPO(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
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
                                    PackageUtils.sendDownloadAPOLog(this.mAppContext, this.mAdContainerCxt, optString3, optString2, i2);
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
    }

    public void checkAndSendRsplashShowLog(int i2, HashMap<String, Object> hashMap) {
        XAdContainerContext xAdContainerContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, hashMap) == null) || (xAdContainerContext = this.mAdContainerCxt) == null) {
            return;
        }
        if (xAdContainerContext.getAdInstanceInfo() != null) {
            StateMachine.event(this.mAdContainerCxt.getAdInstanceInfo().getUniqueId(), AdStateCode.EVENT_IMPRESSION);
        }
        if (i2 != 1 && i2 != 2) {
            int viewState = AdViewUtils.getViewState(this.mAdContainerCxt.getAdProdBase());
            sendSplashViewState(viewState, true, i2, 413, "");
            sendSplashViewState(viewState, true, i2, HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE, "");
            sendImpressionLog(this.mAdContainerCxt.getAdInstanceInfo());
            send3rdImpressionLog();
            processAdStart(hashMap);
            return;
        }
        int viewState2 = AdViewUtils.getViewState(this.mAdContainerCxt.getAdProdBase());
        if (viewState2 == 0) {
            sendImpressionLog(this.mAdContainerCxt.getAdInstanceInfo());
            send3rdImpressionLog();
            sendSplashViewState(viewState2, true, i2, 413, "");
            processAdStart(hashMap);
            return;
        }
        try {
            processAdStart(hashMap);
            sendSplashViewState(viewState2, false, i2, 413, "1");
            this.showRecord = "";
            this.showRecord += viewState2;
            if (this.mTimer != null) {
                this.mTimer.stop();
                this.mTimer = null;
            }
            OAdTimer oAdTimer = new OAdTimer(3000);
            this.mTimer = oAdTimer;
            oAdTimer.setEventHandler(new OAdTimer.EventHandler(this, i2) { // from class: com.baidu.mobads.container.XBaseAdContainer.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ XBaseAdContainer this$0;
                public final /* synthetic */ int val$rsplashType;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$rsplashType = i2;
                }

                @Override // com.baidu.mobads.container.util.OAdTimer.EventHandler
                public void onTimer(int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i3) == null) {
                        int viewState3 = AdViewUtils.getViewState(this.this$0.mAdContainerCxt.getAdProdBase());
                        StringBuilder sb = new StringBuilder();
                        XBaseAdContainer xBaseAdContainer = this.this$0;
                        sb.append(xBaseAdContainer.showRecord);
                        sb.append(viewState3);
                        xBaseAdContainer.showRecord = sb.toString();
                        if (this.this$0.showRecord.endsWith("00")) {
                            XBaseAdContainer xBaseAdContainer2 = this.this$0;
                            xBaseAdContainer2.sendImpressionLog(xBaseAdContainer2.mAdContainerCxt.getAdInstanceInfo());
                            this.this$0.send3rdImpressionLog();
                            XBaseAdContainer xBaseAdContainer3 = this.this$0;
                            xBaseAdContainer3.sendSplashViewState(9, true, this.val$rsplashType, HttpStatus.SC_LOCKED, xBaseAdContainer3.showRecord);
                            if (this.this$0.mTimer != null) {
                                this.this$0.mTimer.stop();
                                this.this$0.mTimer = null;
                            }
                        }
                    }
                }

                @Override // com.baidu.mobads.container.util.OAdTimer.EventHandler
                public void onTimerComplete() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        int viewState3 = AdViewUtils.getViewState(this.this$0.mAdContainerCxt.getAdProdBase());
                        XBaseAdContainer xBaseAdContainer = this.this$0;
                        xBaseAdContainer.sendSplashViewState(viewState3, false, this.val$rsplashType, HttpStatus.SC_LOCKED, xBaseAdContainer.showRecord);
                        XAdContainerContext xAdContainerContext2 = this.this$0.mAdContainerCxt;
                        if (xAdContainerContext2 == null || xAdContainerContext2.getAdInstanceInfo() == null) {
                            return;
                        }
                        StateMachine.event(this.this$0.mAdContainerCxt.getAdInstanceInfo().getUniqueId(), AdStateCode.EVENT_IMPRESSION_FAILED);
                    }
                }
            });
            this.mTimer.start();
            sendSplashViewState(viewState2, false, i2, 413, "2");
        } catch (Exception e2) {
            sendSplashViewState(viewState2, false, i2, HttpStatus.SC_LOCKED, "exception");
            this.mAdLogger.d(e2);
        }
    }

    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void closeAd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("video_close_reason", str);
            this.mAdContainerCxt.getEventDispatcher().dispatchEvent(new XAdRemoteEvent("AdStopped", hashMap));
        }
    }

    public void deleteTimeoutCachedFiles(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
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
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void displayVersion4DebugMode() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && XAdSDKRemoteVersion.DEBUG.booleanValue() && this.mActivity != null) {
            TextView textView = new TextView(this.mActivity);
            textView.setTextColor(-16776961);
            textView.setTextSize(15.0f);
            textView.setText("P : " + AppConfigImp.getInstance().getProxyVersion() + "\nR : 9.042");
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = 10;
            layoutParams.addRule(13);
            this.mAdContainerCxt.getAdProdBase().addView(textView, layoutParams);
        }
    }

    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public void doAddProgressView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
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
    }

    public void doLoadOnUIThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public void doStartOnUIThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public void doStopOnUIThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    public XAdContainerContext getAdContainerContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mAdContainerCxt : (XAdContainerContext) invokeV.objValue;
    }

    public String getAdContainerName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mAdContainerName : (String) invokeV.objValue;
    }

    public IXAdInstanceInfo getAdInstanceInfoByJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        XAdContainerContext xAdContainerContext;
        ArrayList<IXAdInstanceInfo> adInstanceList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, jSONObject)) == null) {
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
        return (IXAdInstanceInfo) invokeL.objValue;
    }

    public int getAdStateForTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mAdState : invokeV.intValue;
    }

    public View getAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return null;
        }
        return (View) invokeV.objValue;
    }

    public HashMap<String, String> getParameters() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mCustomerParameters : (HashMap) invokeV.objValue;
    }

    public String getRemoteVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? "9.042" : (String) invokeV.objValue;
    }

    public HashMap<String, Object> getShouBaiLpFlag(XAdContainerContext xAdContainerContext, IXAdInstanceInfo iXAdInstanceInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, xAdContainerContext, iXAdInstanceInfo)) == null) ? XAdRemoteCommonUtils.getLpFlag(xAdContainerContext, iXAdInstanceInfo) : (HashMap) invokeLL.objValue;
    }

    public void handleClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    public void handleEvent(JSONObject jSONObject, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, jSONObject, map) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY);
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

    public void handlePause(IXAdInstanceInfo iXAdInstanceInfo) {
        CircleTextProgressbar circleTextProgressbar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, iXAdInstanceInfo) == null) || (circleTextProgressbar = this.mProgressView) == null) {
            return;
        }
        circleTextProgressbar.stop();
    }

    public void handleResume(IXAdInstanceInfo iXAdInstanceInfo) {
        CircleTextProgressbar circleTextProgressbar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, iXAdInstanceInfo) == null) || (circleTextProgressbar = this.mProgressView) == null) {
            return;
        }
        circleTextProgressbar.start();
    }

    public void load() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.mAdLogger.d(TAG, "load");
            this.mAdState = 1;
            ActivityUtils.runOnUiThread(new Runnable(this) { // from class: com.baidu.mobads.container.XBaseAdContainer.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ XBaseAdContainer this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.doLoadOnUIThread();
                    }
                }
            });
            XAdMaterialsLoader.getInstance().startLoadRemoteSetting(this.mAppContext);
        }
    }

    public void onAdClick(IXAdInstanceInfo iXAdInstanceInfo, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, iXAdInstanceInfo, view) == null) {
        }
    }

    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
        }
    }

    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    public void onPermissionClose(IXAdInstanceInfo iXAdInstanceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, iXAdInstanceInfo) == null) {
        }
    }

    public void onPermissionShow(IXAdInstanceInfo iXAdInstanceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, iXAdInstanceInfo) == null) {
        }
    }

    public void onPrivacyClick(IXAdInstanceInfo iXAdInstanceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, iXAdInstanceInfo) == null) {
        }
    }

    public void onPrivacyLpClose(IXAdInstanceInfo iXAdInstanceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, iXAdInstanceInfo) == null) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            if (z) {
                this.windowFocusState = 1;
            } else {
                this.windowFocusState = 0;
            }
        }
    }

    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
        }
    }

    public ApoParser parseApo(IXAdInstanceInfo iXAdInstanceInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, iXAdInstanceInfo)) == null) ? new ApoParser(this, this.mAdContainerCxt).parse(iXAdInstanceInfo) : (ApoParser) invokeL.objValue;
    }

    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
        }
    }

    public void processAdError(XAdErrorCode xAdErrorCode, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, xAdErrorCode, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("error_message", str);
            this.mAdContainerCxt.getEventDispatcher().dispatchEvent(new XAdRemoteEvent("AdError", xAdErrorCode.getCode(), hashMap));
        }
    }

    public void processAdStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            processAdStart(null);
        }
    }

    public Boolean processKeyEvent(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048617, this, i2, keyEvent)) == null) ? Boolean.FALSE : (Boolean) invokeIL.objValue;
    }

    public boolean processShouldOverrideUrlLoading(String str, WebView webView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048618, this, str, webView)) == null) {
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
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(39:3|4|5|6|(3:145|146|147)|8|9|10|(1:12)|13|(8:127|128|130|131|(1:133)|134|135|(2:137|(26:139|17|(1:126)(1:23)|24|25|26|(2:28|(1:30)(1:31))|32|33|(1:123)(16:36|37|38|39|40|41|42|43|44|(1:115)(10:49|50|52|53|54|55|56|(1:58)|59|60)|61|(1:63)|64|(1:66)|(2:89|(1:(3:98|(5:101|102|103|104|105)|100)(1:97))(1:93))(2:70|(5:72|(1:74)|75|76|77)(2:(1:86)(1:88)|87))|(2:79|80)(1:82))|120|44|(0)|115|61|(0)|64|(0)|(1:68)|89|(1:91)|(1:95)|98|(0)|100|(0)(0))))(1:15)|16|17|(1:19)|126|24|25|26|(0)|32|33|(0)|123|120|44|(0)|115|61|(0)|64|(0)|(0)|89|(0)|(0)|98|(0)|100|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0131, code lost:
        r19 = r9;
        r18 = "version";
        r17 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e8 A[Catch: all -> 0x0131, TRY_ENTER, TryCatch #7 {all -> 0x0131, blocks: (B:46:0x00da, B:49:0x00e8, B:52:0x00f9, B:53:0x00fd), top: B:146:0x00da }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x013f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0223  */
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
        int i2;
        int i3;
        XAdInstanceInfoExt xAdInstanceInfoExt4;
        XAdInstanceInfoExt xAdInstanceInfoExt5;
        long lastOpenAppTime;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048619, this, iXAdInstanceInfo) != null) {
            return;
        }
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
        int i4 = App2Activity.ANIMATION_DURATION_ACTIVITY_ENTER;
        try {
            JSONObject jSONObject2 = new JSONObject(iXAdInstanceInfo.getOriginJsonObject().optString("control_flags"));
            i4 = jSONObject2.optInt("cutscenes_time", i4);
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
                            i2 = count;
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
                            i2 = count;
                        }
                        i3 = i2;
                        if (i3 == 0 && z2 && !AppConfigImp.getInstance().isLpMultiProcess()) {
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
                            App2Activity.ANIMATION_DURATION_ACTIVITY_ENTER = i4;
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
                        hashMap.put("exp_allow", "" + i3);
                        if (jSONObject != null) {
                            PackageUtils.sendAPOInfo(this.mAdContainerCxt, jSONObject.optString("page", ""), iXAdInstanceInfo.getAppPackageName(), SDKLogTypeConstants.TYPE_SHOUBAI_APO_INFO, jSONObject.optInt("fb_act", 0), jSONObject.optInt(str, 0), hashMap);
                        }
                        if (i3 == 0 && 1 == parseApo.getCount(true)) {
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
                        } else if (i3 == 0 && 1 == parseApo2.getCount(true)) {
                            new XAdRemoteClickHandler().onAdClicked(this, xAdInstanceInfoExt2, Boolean.TRUE, getShouBaiLpFlag(this.mAdContainerCxt, xAdInstanceInfoExt2));
                        } else if (i3 == 0 && 1 == parseApo3.getCount(true)) {
                            XAdInstanceInfoExt xAdInstanceInfoExt8 = xAdInstanceInfoExt3;
                            new XAdRemoteClickHandler().onAdClicked(this, xAdInstanceInfoExt8, Boolean.TRUE, getShouBaiLpFlag(this.mAdContainerCxt, xAdInstanceInfoExt8));
                        } else {
                            App2Activity.ANIMATION_DURATION_ACTIVITY_ENTER = i4;
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
                    i2 = count;
                    xAdInstanceInfoExt3 = xAdInstanceInfoExt;
                    str = "version";
                    i3 = i2;
                    if (i3 == 0) {
                    }
                    xAdInstanceInfoExt4 = null;
                    HashMap hashMap2 = new HashMap();
                    if (App2Activity.SHOUBAI_LP_APO_START) {
                    }
                    hashMap2.put("exp_main", "" + parseApo.getCount(true));
                    hashMap2.put("exp_lite", "" + parseApo3.getCount(true));
                    hashMap2.put("exp_allow", "" + i3);
                    if (jSONObject != null) {
                    }
                    if (i3 == 0) {
                    }
                    if (i3 == 0) {
                    }
                    if (i3 == 0) {
                    }
                    App2Activity.ANIMATION_DURATION_ACTIVITY_ENTER = i4;
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
        i2 = count;
        xAdInstanceInfoExt3 = xAdInstanceInfoExt;
        str = "version";
        i3 = i2;
        if (i3 == 0) {
        }
        xAdInstanceInfoExt4 = null;
        HashMap hashMap22 = new HashMap();
        if (App2Activity.SHOUBAI_LP_APO_START) {
        }
        hashMap22.put("exp_main", "" + parseApo.getCount(true));
        hashMap22.put("exp_lite", "" + parseApo32.getCount(true));
        hashMap22.put("exp_allow", "" + i3);
        if (jSONObject != null) {
        }
        if (i3 == 0) {
        }
        if (i3 == 0) {
        }
        if (i3 == 0) {
        }
        App2Activity.ANIMATION_DURATION_ACTIVITY_ENTER = i4;
        if (parseApo.getCount(false) > 0) {
        }
        new XAdRemoteClickHandler().onAdClicked(this, iXAdInstanceInfo, Boolean.TRUE, getShouBaiLpFlag(this.mAdContainerCxt, iXAdInstanceInfo));
        if (xAdInstanceInfoExt4 != null) {
        }
    }

    public void registerState(long j, String str, IXAdInstanceInfo iXAdInstanceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Long.valueOf(j), str, iXAdInstanceInfo}) == null) {
        }
    }

    public abstract void resetAdContainerName();

    public void resize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048622, this, i2, i3) == null) {
        }
    }

    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048624, this, iOAdEvent) == null) && iOAdEvent != null && "AdStatusChange".equals(iOAdEvent.getType())) {
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
    }

    public void send3rdImpressionLog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            send3rdLog(this.mAdContainerCxt.getAdInstanceInfo().getThirdImpressionTrackingUrls());
        }
    }

    public void send3rdLog(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, list) == null) || list == null) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list.get(i2);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, iXAdInstanceInfo) == null) {
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
    }

    public void sendRsplashExpClickLog(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i2) == null) {
            sendSplashViewState(9, false, i2, HttpStatus.SC_FAILED_DEPENDENCY, this.showRecord);
        }
    }

    public void sendSplashViewState(int i2, boolean z, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
            SplashVSLogUtil.sendLog(this.mAdContainerCxt, i2, z, i3, i4, str);
        }
    }

    public void setAdStateForTest(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
            this.mAdState = i2;
        }
    }

    public void setParameters(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, hashMap) == null) {
            this.mCustomerParameters = hashMap;
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            this.hasPlayed = true;
            this.mAdLogger.d(TAG, "start");
            ActivityUtils.runOnUiThread(new Runnable(this) { // from class: com.baidu.mobads.container.XBaseAdContainer.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ XBaseAdContainer this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.doStartOnUIThread();
                    }
                }
            });
        }
    }

    public void startWangmengPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            IXAdInstanceInfo adInstanceInfo = this.mAdContainerCxt.getAdInstanceInfo();
            adInstanceInfo.setClickThroughUrl("https://union.baidu.com");
            adInstanceInfo.setActionType(1);
            new XAdRemoteClickHandler().onAdClicked(this, adInstanceInfo, Boolean.TRUE, null);
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            ActivityUtils.runOnUiThread(new Runnable(this) { // from class: com.baidu.mobads.container.XBaseAdContainer.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ XBaseAdContainer this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.doStopOnUIThread();
                    }
                }
            });
        }
    }

    public void switchContext(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, activity) == null) {
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
    }

    public void processAdStart(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, hashMap) == null) {
            this.mAdContainerCxt.getEventDispatcher().dispatchEvent(new XAdRemoteEvent("AdStarted", hashMap));
        }
    }

    public void processAdError(HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, hashMap) == null) {
            this.mAdContainerCxt.getEventDispatcher().dispatchEvent(new XAdRemoteEvent("AdError", hashMap));
        }
    }
}
