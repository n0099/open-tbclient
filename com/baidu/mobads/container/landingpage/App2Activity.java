package com.baidu.mobads.container.landingpage;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.net.Uri;
import android.net.http.SslError;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.feature.upload.BdUploadHandler;
import com.baidu.mobads.container.XAdInstanceInfoExt;
import com.baidu.mobads.container.XAdRemoteCommonUtils;
import com.baidu.mobads.container.XAdSDKRemoteVersion;
import com.baidu.mobads.container.XMyWebView;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.mobads.container.bridge.BridgeJavascript;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.components.statemachine.AdStateCode;
import com.baidu.mobads.container.components.statemachine.AdStateEvent;
import com.baidu.mobads.container.components.statemachine.StateMachine;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.landingpage.LpVideoView;
import com.baidu.mobads.container.landingpage.NativePlayerJsBridgeHandler;
import com.baidu.mobads.container.landingpage.XActionBar;
import com.baidu.mobads.container.landingpage.XLPBottomView;
import com.baidu.mobads.container.landingpage.XVideoAutoPlayOnlyWifiView;
import com.baidu.mobads.container.service.PluginLoader;
import com.baidu.mobads.container.util.APKStateManager;
import com.baidu.mobads.container.util.ActivityUtils;
import com.baidu.mobads.container.util.AppUtils;
import com.baidu.mobads.container.util.Base64;
import com.baidu.mobads.container.util.CommonUtils;
import com.baidu.mobads.container.util.ConvertUtils;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.EncryptUtils;
import com.baidu.mobads.container.util.EuiLeakFixUtils;
import com.baidu.mobads.container.util.OpenAppUtils;
import com.baidu.mobads.container.util.PermissionUtils;
import com.baidu.mobads.container.util.RemoteCommonUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.util.ScreenUtils;
import com.baidu.mobads.container.util.SendLogUtil;
import com.baidu.mobads.container.video.CpuLpVideoLayout;
import com.baidu.mobads.container.video.LPVideoLayout;
import com.baidu.mobads.sdk.api.IActivityImpl;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class App2Activity implements IActivityImpl, View.OnTouchListener, NativePlayerJsBridgeHandler.PlayerCallBack {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACTIONBAR_VIEW_ID = 1001;
    public static int ANIMATION_DURATION_ACTIVITY_ENTER = 0;
    public static final int ANIMATION_DURATION_ACTIVITY_EXIT = 300;
    public static final int ANIMATION_DURATION_BOTTOM_ENTER = 500;
    public static final int ANIMATION_DURATION_BOTTOM_EXIT = 250;
    public static boolean CAN_LP_SHOW_WHEN_LOCKED = false;
    public static final String CPU_DOMAIN = "https://cpu.baidu.com/";
    public static int DESTROY_EVENT = 0;
    public static final String EXTRA_DATA = "EXTRA_DATA";
    public static final String EXTRA_LP_FLAG = "EXTRA_LP_FLAG";
    public static final String FINISH_LP_BACK_BTN = "backBtnFinish";
    public static final String FINISH_LP_BACK_HOUSE = "backHouseFinish";
    public static final String FINISH_LP_BACK_KEY = "backKeyFinish";
    public static final String FINISH_LP_BY_SHOUBAI = "pauseShoubaiFinish";
    public static final String FINISH_LP_DATA_ERROR = " dataErrorFinish";
    public static final String FINISH_LP_DEAL_DOWNLOAD = "dealDownloadFinish";
    public static final String FINISH_LP_OPEN_INTENT = "openIntentFinish";
    public static final String FINISH_LP_OPEN_TIMEOUT = "openTimeoutFinish";
    public static final String FINISH_LP_VIDEO_RETURN = "videoBackFinish";
    public static final long LOAD_URL_DELAY_TIME = 500;
    public static final String LP_STYLE_SHOUBAI = "1";
    public static final String LP_STYLE_VIDEO = "video_and_web";
    public static final String LP_STYLE_VR = "lp_vr";
    public static AtomicBoolean MURL_SECOND_CONFIRM = null;
    public static final String MURL_SECOND_CONFIRM_NEW = "murl_second_confirm";
    public static AtomicBoolean MURL_WEB = null;
    public static final String MURL_WEB_NEW = "murl_web";
    public static boolean SHOUBAI_LP_APO_START;
    public static long SHOUBAI_LP_APO_START_TIME;
    public static final String TAG;
    public static AtomicBoolean isAppActivityOpening;
    public static ActionBarColorTheme mSActionBarColorTheme;
    public transient /* synthetic */ FieldHolder $fh;
    public String DOMAIN;
    public XActionBar actionBar;
    public String closeCause;
    public AtomicBoolean closeLp;
    public CookieManager cookieManager;
    public CpuLpVideoLayout cpuLpVideoLayout;
    public XMyWebView curWebview;
    public long delta;
    public int e75;
    public int e753;
    public boolean existWebView;
    public int from;
    public boolean hasClked;
    public boolean isFirstPause;
    public boolean isLuLandingPage;
    public boolean isRecordLpLoad;
    public boolean isRecordPageFinish;
    public boolean isRecordPageStart;
    public boolean isTouched;
    public XDLJsInterface jsInterface;
    public RemoteXAdLogger mAdLogger;
    public String mAdTitle;
    public String mAdUniqueId;
    public Context mAppContext;
    public String mAppsid;
    public View mBackgroundView;
    public BaiduAppJsBridgeHandler mBaiduJsInterface;
    public XLPBottomView mBottomView;
    public boolean mBottomViewIsShowing;
    public boolean mCanOpenAppForAPO;
    public String mContentType;
    public float mCurDy;
    public WebChromeClient.CustomViewCallback mCustomViewCallback;
    public long mEnterLpTimestamp;
    public int mFirstDownY;
    public ImageView mFullScreenBackButton;
    public View mFullScreenView;
    public ViewGroup mFullScreenViewParent;
    public Interpolator mInterpolator;
    public boolean mIsCpuLandingPage;
    public boolean mIsDarkModeStyle;
    public boolean mIsFullScreenVideo;
    public boolean mIsThemeTranslucent;
    public XAdRemoteLandingPageTrackingInfo mLandingPageTrackingInfo;
    public LinearLayout mLlContainer;
    public long mLpExeOnCreateTime;
    public String mLpFinishState;
    public int mLploadtime;
    public ArrayList<String> mLuTwoHopAddress;
    public Handler mMainHandler;
    public NativePlayerJsBridgeHandler mNativePlayerJsBridgeHandler;
    public PageFinishedListener mPageFinishedListener;
    public float mPostY;
    public Activity mProxyActivity;
    public RelativeLayout mRlContainer;
    public float mRlViewTop;
    public View mSpinnerImageView;
    public String mThumburl;
    public XAdRemoteLandingPageExtraInfo mTmpExtraInfo;
    public boolean mUserAutoFinish;
    public int mVideoHeight;
    public int maxOpenedTabs;
    public int order;
    public float ratioH;
    public float ratioW;
    public TextView tipView;
    public int urlclicks;
    public LpVideoView videoView;
    public RelativeLayout wvTool;

    /* loaded from: classes7.dex */
    public class CustomProgressBar extends View {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Paint mPaint;
        public int mProgress;
        public int mScreenWidth;
        public final /* synthetic */ App2Activity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomProgressBar(App2Activity app2Activity, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {app2Activity, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = app2Activity;
            this.mProgress = 0;
            this.mScreenWidth = 0;
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setColor(App2Activity.mSActionBarColorTheme.getProgressColor());
            this.mScreenWidth = ScreenUtils.getScreenRect(app2Activity.mProxyActivity.getApplicationContext()).width();
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
                super.onDraw(canvas);
                canvas.drawRect(0.0f, 0.0f, (this.mScreenWidth * this.mProgress) / 100, getLayoutParams().height, this.mPaint);
            }
        }

        public void setProgress(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || i2 == this.mProgress) {
                return;
            }
            this.mProgress = i2;
            postInvalidate();
        }
    }

    /* loaded from: classes7.dex */
    public interface PageFinishedListener {
        void onPageFinished(WebView webView);
    }

    /* loaded from: classes7.dex */
    public class Redirect38Class {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean isASendingRound;
        public boolean isRedirect;
        public boolean isUrlFinishSended;
        public String startUrl;
        public final /* synthetic */ App2Activity this$0;

        public Redirect38Class(App2Activity app2Activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {app2Activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = app2Activity;
            this.isRedirect = false;
            this.startUrl = "";
            this.isUrlFinishSended = false;
            this.isASendingRound = true;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1726391091, "Lcom/baidu/mobads/container/landingpage/App2Activity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1726391091, "Lcom/baidu/mobads/container/landingpage/App2Activity;");
                return;
            }
        }
        TAG = App2Activity.class.getSimpleName();
        isAppActivityOpening = new AtomicBoolean(false);
        MURL_SECOND_CONFIRM = new AtomicBoolean(false);
        MURL_WEB = new AtomicBoolean(false);
        ANIMATION_DURATION_ACTIVITY_ENTER = 0;
        SHOUBAI_LP_APO_START = false;
        SHOUBAI_LP_APO_START_TIME = 0L;
        DESTROY_EVENT = 39;
        mSActionBarColorTheme = ActionBarColorTheme.ACTION_BAR_WHITE_THEME;
        CAN_LP_SHOW_WHEN_LOCKED = false;
    }

    public App2Activity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.tipView = null;
        this.ratioH = 1.0f;
        this.ratioW = 1.0f;
        this.actionBar = null;
        this.mPostY = 0.0f;
        this.mCurDy = 0.0f;
        this.mRlViewTop = 0.0f;
        this.mVideoHeight = 0;
        this.mInterpolator = new DecelerateInterpolator();
        this.order = 0;
        this.from = 0;
        this.mEnterLpTimestamp = 0L;
        this.urlclicks = 0;
        this.mLploadtime = -1;
        this.mIsThemeTranslucent = false;
        this.e75 = 1;
        this.e753 = 0;
        this.isLuLandingPage = false;
        this.isTouched = false;
        this.hasClked = false;
        this.maxOpenedTabs = 1;
        this.closeCause = "barC";
        this.mAdLogger = RemoteXAdLogger.getInstance();
        this.mCanOpenAppForAPO = true;
        this.mSpinnerImageView = null;
        this.isRecordPageStart = false;
        this.isRecordLpLoad = false;
        this.isRecordPageFinish = false;
        this.mBottomViewIsShowing = false;
        this.videoView = null;
        this.closeLp = new AtomicBoolean(false);
        this.DOMAIN = "";
        this.mLuTwoHopAddress = new ArrayList<>();
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mUserAutoFinish = false;
        this.mLpFinishState = "";
        this.mIsCpuLandingPage = false;
        this.mIsDarkModeStyle = false;
        this.mIsFullScreenVideo = false;
        this.isFirstPause = true;
    }

    public static /* synthetic */ int access$3008(App2Activity app2Activity) {
        int i2 = app2Activity.order;
        app2Activity.order = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFullScreenBackButton() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65583, this) == null) {
            Context applicationContext = this.mProxyActivity.getApplicationContext();
            if (this.mFullScreenBackButton == null) {
                this.mFullScreenBackButton = new ImageView(applicationContext);
                int pixel = ScreenUtils.getPixel(applicationContext, 6);
                this.mFullScreenBackButton.setPadding(pixel, pixel, pixel, pixel);
                this.mFullScreenBackButton.setImageBitmap(ConvertUtils.string2bitmap(LPVideoLayout.ICON_ARROW_BACK));
                this.mFullScreenBackButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.mobads.container.landingpage.App2Activity.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ App2Activity this$0;

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
                            this.this$0.hideCustomView();
                        }
                    }
                });
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenUtils.getPixel(applicationContext, 24), ScreenUtils.getPixel(applicationContext, 24));
                layoutParams.addRule(9);
                layoutParams.addRule(10);
                layoutParams.leftMargin = ScreenUtils.getPixel(applicationContext, 15);
                layoutParams.topMargin = ScreenUtils.getPixel(applicationContext, 15);
                this.mFullScreenBackButton.setLayoutParams(layoutParams);
                ShapeDrawable shapeDrawable = new ShapeDrawable();
                shapeDrawable.setShape(new OvalShape());
                shapeDrawable.getPaint().setColor(Color.argb(50, 186, 183, 185));
                this.mFullScreenBackButton.setBackground(shapeDrawable);
            }
            this.mFullScreenViewParent.addView(this.mFullScreenBackButton);
        }
    }

    private void addGlobalViews(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65584, this, str) == null) {
            this.wvTool = new RelativeLayout(this.mProxyActivity);
            this.mLlContainer = new LinearLayout(this.mProxyActivity);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            this.mLlContainer.setOrientation(1);
            this.wvTool.addView(this.mLlContainer, layoutParams);
            this.mLandingPageTrackingInfo.shoubailp = this.mTmpExtraInfo.lpStyle;
            if (secondConfirm() && isVideoAvailable()) {
                if (CommonUtils.isWifi(this.mProxyActivity)) {
                    showVideo(this.mProxyActivity, this.mTmpExtraInfo.mAdInstanceInfo);
                } else {
                    showAutoPlayVideoPrompt(this.mProxyActivity, this.mTmpExtraInfo.mAdInstanceInfo);
                }
            } else {
                initActionBar();
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, ScreenUtils.getPixel(this.mProxyActivity, 46));
                this.actionBar.setId(1001);
                this.mLlContainer.addView(this.actionBar, layoutParams2);
                this.cpuLpVideoLayout = new CpuLpVideoLayout(this.mProxyActivity);
                int screenWidth = CommonUtils.getScreenWidth(this.mProxyActivity);
                int i2 = (screenWidth * 9) / 16;
                this.mVideoHeight = i2;
                this.mLlContainer.addView(this.cpuLpVideoLayout, new LinearLayout.LayoutParams(screenWidth, i2));
                if (this.mContentType.equals("video")) {
                    this.cpuLpVideoLayout.setVisibility(0);
                    this.cpuLpVideoLayout.setCoverPic(this.mThumburl);
                    this.mVideoHeight = i2;
                } else {
                    this.cpuLpVideoLayout.setVisibility(8);
                    this.mVideoHeight = 0;
                }
            }
            if (!this.existWebView) {
                MURL_SECOND_CONFIRM.set(false);
                MURL_WEB.set(false);
            }
            this.mRlContainer = initFrame(str);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            if (this.mVideoHeight > 0) {
                layoutParams3.height = getDisplayHeight();
            }
            this.mRlContainer.setBackgroundColor(this.mIsDarkModeStyle ? -16777216 : -1);
            this.mLlContainer.addView(this.mRlContainer, layoutParams3);
            if (this.mIsThemeTranslucent && canSupportAnimate()) {
                ActivityUtils.translucentActivity(this.mProxyActivity);
                this.wvTool.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener(this) { // from class: com.baidu.mobads.container.landingpage.App2Activity.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ App2Activity this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
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
                    }

                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            this.this$0.wvTool.getViewTreeObserver().removeOnPreDrawListener(this);
                            App2Activity app2Activity = this.this$0;
                            app2Activity.runActivityStartAnimation(app2Activity.wvTool);
                            return true;
                        }
                        return invokeV.booleanValue;
                    }
                });
            }
        }
    }

    private void addTwoHopAddress() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65585, this) == null) {
            this.mLuTwoHopAddress.add("m.baidu.com");
            this.mLuTwoHopAddress.add("cpro.baidu.com");
            this.mLuTwoHopAddress.add("ada.baidu.com");
            this.mLuTwoHopAddress.add("mobads.php");
            this.mLuTwoHopAddress.add("baidu.php");
            this.mLuTwoHopAddress.add("uijs.php");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0083, code lost:
        if (com.baidu.mobads.container.XMyWebView.needExternalBrowser(r8) != false) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean broswer(WebView webView, String str, Runnable runnable, Runnable runnable2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLL = interceptable.invokeLLLL(65586, this, webView, str, runnable, runnable2)) != null) {
            return invokeLLLL.booleanValue;
        }
        try {
            Uri parse = Uri.parse(str);
            if (BridgeJavascript.BRIDGE_SCHEME.equals(parse.getScheme())) {
                if (this.jsInterface == null) {
                    this.jsInterface = new XDLJsInterface(this.curWebview, this.mProxyActivity, this.mAppsid);
                }
                this.jsInterface.handleShouldOverrideUrlLoading(parse);
                return true;
            }
        } catch (Exception e2) {
            this.mAdLogger.d(TAG, e2.getMessage());
        }
        try {
            if (this.mNativePlayerJsBridgeHandler != null && this.mNativePlayerJsBridgeHandler.isNativePlayerScheme(str)) {
                this.mNativePlayerJsBridgeHandler.handleShouldOverrideUrlLoading(str);
                return true;
            }
        } catch (Throwable th) {
            this.mAdLogger.d(TAG, th.getMessage());
        }
        try {
            if (this.mBaiduJsInterface != null && this.mBaiduJsInterface.isJimuyuUrl(str)) {
                this.mBaiduJsInterface.handleShouldOverrideUrlLoading(str);
                return true;
            }
        } catch (Throwable th2) {
            this.mAdLogger.d(TAG, th2.getMessage());
        }
        try {
            if (this.mCanOpenAppForAPO) {
                if (XMyWebView.canOpenByIntent(str)) {
                    if (XMyWebView.isAudioFile(str)) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setDataAndType(Uri.parse(str), BdUploadHandler.AUDIO_MIME_TYPE);
                        webView.getContext().startActivity(intent);
                    } else if (XMyWebView.isVideoFile(str)) {
                        Intent intent2 = new Intent("android.intent.action.VIEW");
                        intent2.setDataAndType(Uri.parse(str), BdUploadHandler.VIDEO_MIME_TYPE);
                        webView.getContext().startActivity(intent2);
                    } else {
                        OpenAppUtils.browserOutside(webView.getContext(), str);
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                    return true;
                }
                if (runnable2 != null) {
                    runnable2.run();
                    return true;
                }
                return false;
            }
        } catch (Exception e3) {
            this.mAdLogger.d(TAG, e3.getMessage());
            return false;
        }
    }

    public static void canLpShowWhenLocked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65587, null, z) == null) {
            CAN_LP_SHOW_WHEN_LOCKED = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disposeAnimation() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65588, this) == null) || (view = this.mSpinnerImageView) == null) {
            return;
        }
        removeFromParent(view);
        this.mSpinnerImageView = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadAPK(String str, IXAdInstanceInfo iXAdInstanceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65589, this, str, iXAdInstanceInfo) == null) {
            Context context = this.mProxyActivity;
            if (context == null) {
                context = this.curWebview.getContext();
            }
            Context context2 = context;
            String appPackageName = iXAdInstanceInfo.getAppPackageName();
            if (TextUtils.isEmpty(appPackageName)) {
                appPackageName = EncryptUtils.getMD5(str);
            }
            iXAdInstanceInfo.setAppPackageName(appPackageName);
            iXAdInstanceInfo.setClickThroughUrl(str);
            iXAdInstanceInfo.setOriginClickUrl(str);
            iXAdInstanceInfo.setAdId(this.mLandingPageTrackingInfo.adid);
            XAdRemoteCommonUtils.downloadApp(context2, this.mLandingPageTrackingInfo.appsid, iXAdInstanceInfo, this.mTmpExtraInfo.mProdType, "lp_normal", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65590, this) == null) {
            this.mUserAutoFinish = true;
            Handler handler = this.mMainHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.mProxyActivity.finish();
            stopAndRelease();
        }
    }

    public static ActionBarColorTheme getActionBarColorTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65591, null)) == null) ? mSActionBarColorTheme : (ActionBarColorTheme) invokeV.objValue;
    }

    private void getAdUniqueId() {
        XAdRemoteLandingPageExtraInfo xAdRemoteLandingPageExtraInfo;
        XAdInstanceInfoExt xAdInstanceInfoExt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65592, this) == null) || (xAdRemoteLandingPageExtraInfo = this.mTmpExtraInfo) == null || (xAdInstanceInfoExt = xAdRemoteLandingPageExtraInfo.mAdInstanceInfo) == null) {
            return;
        }
        String uniqueId = xAdInstanceInfoExt.getUniqueId();
        this.mAdUniqueId = uniqueId;
        if (TextUtils.isEmpty(uniqueId)) {
            this.mAdUniqueId = StateMachine.queryPossibleUniqueId(this.mTmpExtraInfo.mAdInstanceInfo.getQueryKey());
        }
    }

    private int getDisplayHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65593, this)) == null) {
            Activity activity = this.mProxyActivity;
            if (activity != null) {
                try {
                    if (activity.getRequestedOrientation() == 1) {
                        return CommonUtils.getScreenHeight(this.mProxyActivity) - getStatusBarHeight(this.mProxyActivity);
                    }
                    return 0;
                } catch (Throwable unused) {
                    return 0;
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    private String getSSid() {
        InterceptResult invokeV;
        WifiInfo connectionInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65594, this)) == null) {
            boolean checkPermission = PermissionUtils.checkPermission(this.mProxyActivity, "android.permission.ACCESS_WIFI_STATE");
            WifiManager wifiManager = (WifiManager) this.mProxyActivity.getApplicationContext().getSystemService("wifi");
            return (wifiManager == null || !checkPermission || (connectionInfo = wifiManager.getConnectionInfo()) == null) ? "" : connectionInfo.getSSID();
        }
        return (String) invokeV.objValue;
    }

    private View getSpinnerBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65595, this)) == null) {
            XRefreshImageView xRefreshImageView = new XRefreshImageView(this.mProxyActivity);
            int pixel = ScreenUtils.getPixel(this.mProxyActivity, 38);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(pixel, pixel);
            layoutParams.addRule(13);
            xRefreshImageView.setLayoutParams(layoutParams);
            return xRefreshImageView;
        }
        return (View) invokeV.objValue;
    }

    private int getStatusBarHeight(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65596, this, context)) == null) {
            Resources resources = context.getResources();
            return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
        }
        return invokeL.intValue;
    }

    private int getThemeId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65597, this)) == null) {
            try {
                Method method = Context.class.getMethod("getThemeResId", new Class[0]);
                method.setAccessible(true);
                return ((Integer) method.invoke(this.mProxyActivity, new Object[0])).intValue();
            } catch (Exception e2) {
                this.mAdLogger.e(e2);
                return -1;
            }
        }
        return invokeV.intValue;
    }

    private String hashMapToString(HashMap<String, String> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65598, this, hashMap)) == null) {
            StringBuilder sb = new StringBuilder();
            if (hashMap != null) {
                int i2 = 0;
                for (String str : hashMap.keySet()) {
                    String str2 = hashMap.get(str);
                    if (!TextUtils.isEmpty(str2)) {
                        i2++;
                        if (i2 == 1) {
                            sb.append(str);
                            sb.append("=");
                            sb.append(str2);
                        } else {
                            sb.append("\\0");
                            sb.append(str);
                            sb.append("=");
                            sb.append(str2);
                        }
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideCustomView() {
        ImageView imageView;
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65599, this) == null) || this.mFullScreenView == null) {
            return;
        }
        Activity activity = this.mProxyActivity;
        if (activity != null && !this.mIsThemeTranslucent && activity.getRequestedOrientation() != 1) {
            this.mProxyActivity.setRequestedOrientation(1);
            this.mIsFullScreenVideo = false;
        }
        this.mFullScreenView.setVisibility(8);
        ViewGroup viewGroup = this.mFullScreenViewParent;
        if (viewGroup != null && (view = this.mFullScreenView) != null) {
            viewGroup.removeView(view);
        }
        ViewGroup viewGroup2 = this.mFullScreenViewParent;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(8);
        }
        ViewGroup viewGroup3 = this.mFullScreenViewParent;
        if (viewGroup3 != null && (imageView = this.mFullScreenBackButton) != null) {
            viewGroup3.removeView(imageView);
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.mCustomViewCallback;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
        }
        this.mFullScreenView = null;
        RelativeLayout relativeLayout = this.mRlContainer;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
    }

    @TargetApi(11)
    private void initBackgroundView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65600, this) == null) {
            View view = new View(this.mProxyActivity);
            this.mBackgroundView = view;
            view.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.mobads.container.landingpage.App2Activity.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ App2Activity this$0;

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
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        App2Activity app2Activity = this.this$0;
                        app2Activity.runBottomViewExitAnimation(app2Activity.mBackgroundView, this.this$0.mBottomView);
                    }
                }
            });
            if (canSupportAnimate()) {
                this.mBackgroundView.setBackgroundColor(-16777216);
                this.mBackgroundView.setAlpha(0.0f);
            }
            this.mBackgroundView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
    }

    private void initCookieManager() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65601, this) == null) {
            try {
                CookieSyncManager.createInstance(this.mProxyActivity.getApplicationContext());
            } catch (Throwable unused) {
            }
            try {
                CookieManager cookieManager = CookieManager.getInstance();
                this.cookieManager = cookieManager;
                cookieManager.setAcceptCookie(true);
            } catch (Throwable unused2) {
            }
        }
    }

    @TargetApi(3)
    private RelativeLayout initFrame(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65602, this, str)) == null) {
            CustomProgressBar customProgressBar = new CustomProgressBar(this, this.mProxyActivity);
            XMyWebView.ParameterInfo parameterInfo = new XMyWebView.ParameterInfo();
            parameterInfo.mCloseHardwareAccelerated = false;
            XAdRemoteLandingPageExtraInfo xAdRemoteLandingPageExtraInfo = this.mTmpExtraInfo;
            if (xAdRemoteLandingPageExtraInfo != null && (LP_STYLE_VR.equals(xAdRemoteLandingPageExtraInfo.lpStyle) || "video_and_web".equals(this.mTmpExtraInfo.lpStyle))) {
                parameterInfo.mCloseHardwareAccelerated = false;
            }
            this.curWebview = XMyWebView.create(this.mProxyActivity, RemoteXAdLogger.getInstance(), true, true, parameterInfo);
            XAdRemoteLandingPageExtraInfo xAdRemoteLandingPageExtraInfo2 = this.mTmpExtraInfo;
            if (xAdRemoteLandingPageExtraInfo2 != null && "video_and_web".equals(xAdRemoteLandingPageExtraInfo2.lpStyle) && Build.VERSION.SDK_INT >= 17) {
                this.curWebview.getSettings().setMediaPlaybackRequiresUserGesture(false);
            }
            Redirect38Class redirect38Class = new Redirect38Class(this);
            this.curWebview.curUrl = str;
            try {
                WebSettings.class.getMethod("setDisplayZoomControls", Boolean.TYPE).invoke(this.curWebview.getSettings(), Boolean.FALSE);
            } catch (Exception e2) {
                this.mAdLogger.d(TAG, e2.getMessage());
            }
            this.curWebview.setWebChromeClient(new WebChromeClient(this, customProgressBar) { // from class: com.baidu.mobads.container.landingpage.App2Activity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ App2Activity this$0;
                public final /* synthetic */ CustomProgressBar val$prgBar;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, customProgressBar};
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
                    this.val$prgBar = customProgressBar;
                }

                @Override // android.webkit.WebChromeClient
                public Bitmap getDefaultVideoPoster() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        try {
                            return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
                        } catch (Exception unused) {
                            return super.getDefaultVideoPoster();
                        }
                    }
                    return (Bitmap) invokeV.objValue;
                }

                @Override // android.webkit.WebChromeClient
                public void onHideCustomView() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.this$0.hideCustomView();
                    }
                }

                @Override // android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_SEND_USER_MSG, this, webView, i2) == null) {
                        CustomProgressBar customProgressBar2 = this.val$prgBar;
                        if (customProgressBar2 != null) {
                            customProgressBar2.setProgress(i2);
                            if (i2 > 50) {
                                this.this$0.disposeAnimation();
                                this.val$prgBar.setVisibility(i2 >= 100 ? 4 : 0);
                            }
                        }
                        if (70 >= i2 || this.this$0.isRecordLpLoad) {
                            return;
                        }
                        this.this$0.stateEvent(AdStateCode.EVENT_LP_PAGE_LOADED);
                        this.this$0.stateEvent(AdStateEvent.EVENT_TIME_LP_LOADED);
                        this.this$0.isRecordLpLoad = true;
                    }
                }

                @Override // android.webkit.WebChromeClient
                public void onReceivedTitle(WebView webView, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048579, this, webView, str2) == null) {
                        super.onReceivedTitle(webView, str2);
                        App2Activity app2Activity = this.this$0;
                        if (app2Activity.actionBar == null || app2Activity.cpuLpVideoLayout.getVisibility() != 8) {
                            return;
                        }
                        this.this$0.actionBar.setTitle(str2);
                    }
                }

                @Override // android.webkit.WebChromeClient
                public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLL(1048580, this, view, customViewCallback) == null) || this.this$0.mProxyActivity == null) {
                        return;
                    }
                    if (!this.this$0.mIsThemeTranslucent) {
                        this.this$0.mProxyActivity.setRequestedOrientation(0);
                        this.this$0.mIsFullScreenVideo = true;
                    }
                    if (this.this$0.mFullScreenView == null) {
                        if (this.this$0.mRlContainer != null) {
                            this.this$0.mRlContainer.setVisibility(8);
                        }
                        if (this.this$0.mFullScreenViewParent == null) {
                            this.this$0.mFullScreenViewParent = new FrameLayout(this.this$0.mProxyActivity);
                            this.this$0.mFullScreenViewParent.setBackgroundColor(-16777216);
                            App2Activity app2Activity = this.this$0;
                            app2Activity.wvTool.addView(app2Activity.mFullScreenViewParent);
                        }
                        this.this$0.mCustomViewCallback = customViewCallback;
                        this.this$0.mFullScreenViewParent.addView(this.this$0.mFullScreenView = view);
                        this.this$0.mFullScreenView.setKeepScreenOn(true);
                        this.this$0.addFullScreenBackButton();
                        this.this$0.mFullScreenViewParent.setVisibility(0);
                        return;
                    }
                    customViewCallback.onCustomViewHidden();
                }
            });
            this.curWebview.setOnTouchListener(this);
            this.curWebview.setDownloadListener(new DownloadListener(this) { // from class: com.baidu.mobads.container.landingpage.App2Activity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ App2Activity this$0;

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

                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str2, String str3, String str4, String str5, long j) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{str2, str3, str4, str5, Long.valueOf(j)}) == null) && CommonUtils.isUrlForDownloadApk(str2, str5, str4)) {
                        this.this$0.stateEvent(AdStateCode.EVENT_CLICK_LP_DL);
                        App2Activity app2Activity = this.this$0;
                        app2Activity.downloadAPK(str2, app2Activity.mTmpExtraInfo.getAdInstanceInfo());
                        try {
                            String url = this.this$0.curWebview.getUrl();
                            if (TextUtils.isEmpty(url)) {
                                return;
                            }
                            if ((url.startsWith("http://m.baidu.com/baidu.php?sc") || url.startsWith("https://m.baidu.com/baidu.php?sc")) && this.this$0.curWebview.canGoBack()) {
                                this.this$0.curWebview.goBack();
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
            this.curWebview.setWebViewClient(new WebViewClient(this, redirect38Class) { // from class: com.baidu.mobads.container.landingpage.App2Activity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ App2Activity this$0;
                public final /* synthetic */ Redirect38Class val$redr;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, redirect38Class};
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
                    this.val$redr = redirect38Class;
                }

                private boolean isBrowserOutside(String str2) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(65537, this, str2)) == null) {
                        if (TextUtils.isEmpty(str2)) {
                            return true;
                        }
                        return (str2.startsWith("blob:") || XMyWebView.isAudioFile(str2) || XMyWebView.isVideoFile(str2)) ? false : true;
                    }
                    return invokeL2.booleanValue;
                }

                private void sendFinished(String str2, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(65538, this, str2, i2) == null) {
                        try {
                            this.this$0.mLandingPageTrackingInfo.obj = str2;
                            if (this.this$0.mLandingPageTrackingInfo.lpWebFinishLoad == 0) {
                                this.this$0.mLandingPageTrackingInfo.lpWebFinishLoad = System.currentTimeMillis();
                            }
                            this.this$0.mLandingPageTrackingInfo.order = App2Activity.access$3008(this.this$0);
                            this.this$0.mLandingPageTrackingInfo.e75 = this.this$0.e75;
                            this.this$0.mLandingPageTrackingInfo.from = this.this$0.from;
                            if (this.this$0.curWebview != null) {
                                this.this$0.mLandingPageTrackingInfo.height = this.this$0.curWebview.getContentHeight();
                                this.this$0.mLandingPageTrackingInfo.progress = this.this$0.curWebview.getProgress();
                            }
                            this.this$0.mLandingPageTrackingInfo.duration = System.currentTimeMillis() - this.this$0.mEnterLpTimestamp;
                            this.val$redr.isASendingRound = true;
                        } catch (Exception e3) {
                            this.this$0.mAdLogger.d(App2Activity.TAG, e3.getMessage());
                        }
                    }
                }

                private void sendStarted(String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(65539, this, str2) == null) {
                        try {
                            if (this.val$redr.isASendingRound) {
                                this.this$0.mLandingPageTrackingInfo.obj = str2;
                                if (this.this$0.mLandingPageTrackingInfo.lpWebStartLoad == 0) {
                                    this.this$0.mLandingPageTrackingInfo.lpWebStartLoad = System.currentTimeMillis();
                                }
                                this.this$0.mLandingPageTrackingInfo.order = App2Activity.access$3008(this.this$0);
                                if (this.this$0.curWebview != null) {
                                    this.this$0.mLandingPageTrackingInfo.height = this.this$0.curWebview.getContentHeight();
                                    this.this$0.mLandingPageTrackingInfo.progress = this.this$0.curWebview.getProgress();
                                }
                                this.this$0.mLandingPageTrackingInfo.duration = System.currentTimeMillis() - this.this$0.mEnterLpTimestamp;
                                this.this$0.mLandingPageTrackingInfo.e75 = this.this$0.e75;
                                this.this$0.mLandingPageTrackingInfo.from = this.this$0.from;
                                this.val$redr.isASendingRound = false;
                                this.this$0.stateEvent(AdStateCode.EVENT_LP_PAGE_START);
                                return;
                            }
                            this.this$0.mAdLogger.d(App2Activity.TAG, "App2Activity - not send 37");
                        } catch (Exception e3) {
                            this.this$0.mAdLogger.d(App2Activity.TAG, e3.getMessage());
                        }
                    }
                }

                @Override // android.webkit.WebViewClient
                public void doUpdateVisitedHistory(WebView webView, String str2, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLZ(1048576, this, webView, str2, z) == null) {
                        super.doUpdateVisitedHistory(webView, str2, z);
                    }
                }

                @Override // android.webkit.WebViewClient
                public void onLoadResource(WebView webView, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str2) == null) {
                        try {
                            if (!this.val$redr.isUrlFinishSended && !str2.equals(this.val$redr.startUrl) && !this.val$redr.isRedirect) {
                                this.val$redr.isUrlFinishSended = true;
                                if (this.this$0.mLploadtime == -1) {
                                    this.this$0.mLploadtime = (int) (System.currentTimeMillis() - this.this$0.mEnterLpTimestamp);
                                }
                                sendFinished(this.val$redr.startUrl, 0);
                            }
                            WebView.HitTestResult hitTestResult = webView.getHitTestResult();
                            if (hitTestResult == null || hitTestResult.getType() <= 0 || !isBrowserOutside(str2)) {
                                return;
                            }
                            this.this$0.broswer(webView, str2, new Runnable(this) { // from class: com.baidu.mobads.container.landingpage.App2Activity.4.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass4 this$1;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.this$1.this$0.curWebview.stopLoading();
                                    }
                                }
                            }, null);
                        } catch (Exception e3) {
                            this.this$0.mAdLogger.d(App2Activity.TAG, e3.getMessage());
                        }
                    }
                }

                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str2) == null) {
                        Redirect38Class redirect38Class2 = this.val$redr;
                        if (!redirect38Class2.isRedirect && redirect38Class2.startUrl.equals(str2)) {
                            App2Activity app2Activity = this.this$0;
                            if (app2Activity.mLploadtime == -1) {
                                app2Activity.mLploadtime = (int) (System.currentTimeMillis() - this.this$0.mEnterLpTimestamp);
                            }
                            Redirect38Class redirect38Class3 = this.val$redr;
                            if (!redirect38Class3.isUrlFinishSended) {
                                redirect38Class3.isUrlFinishSended = true;
                                sendFinished(redirect38Class3.startUrl, 0);
                                this.this$0.stateEvent(AdStateCode.EVENT_LP_PAGE_FINISH);
                            }
                        }
                        Redirect38Class redirect38Class4 = this.val$redr;
                        redirect38Class4.isRedirect = false;
                        redirect38Class4.startUrl = "";
                        if (this.this$0.mPageFinishedListener != null) {
                            this.this$0.mPageFinishedListener.onPageFinished(webView);
                        }
                        super.onPageFinished(webView, str2);
                        if (this.this$0.needInjectJSWhenPageFinished()) {
                            this.this$0.executeJavaScript("javascript:(function(){window.baidu={};window.baidu.mobads={};window.baidu.mobads.Sdk={isIOS:false};var Sdk=window.baidu.mobads.Sdk;Sdk.isIOS=(/iphone|ipad|ipod/i).test(window.navigator.userAgent.toLowerCase());var mob=window.baidu.mobads;mob.Act={LP:1,DL:2,MAP:4,SMS:8,MAIL:16,PHONE:32,VIDEO:64,RM:128,NA:256,APO:512};var win=window;win.MobadsSdk=win.MobadsSdk||{};var MobadsSdk=win.MobadsSdk;var send3rdLog=function(isShowLog,ad){if(!ad||!ad.mon){return}var url;for(var i=0;i<ad.mon.length;++i){url=isShowLog?ad.mon[i].s:ad.mon[i].c;if(!url){continue}new Image().src=url}};Sdk.setActionUrl=function(url,inapp,act,title,close){var opt={};if(\"[object Object]\"===Object.prototype.toString.call(url)){opt=url;url=opt.url;inapp=opt.inapp;act=opt.act;title=opt.title;close=opt.close}opt.url=url||\"\";opt.inapp=inapp||false;opt.act=act||1;opt.title=title||\"\";opt.close=close||false;opt.logurl=opt.logurl||\"\";opt.weibo=opt.weibo||\"\";opt.map=opt.map||\"\";opt.search=opt.search||\"\";opt.sms=opt.sms||\"\";opt.at=opt.at||1;opt.tid=opt.tid||\"\";opt.erciqueren=true;if(MobadsSdk.setActionUrl){var DUMP_PAR=opt.inapp;MobadsSdk.setActionUrl(JSON.stringify(opt),DUMP_PAR)}};Sdk.sendClickLog=function(logurl){new Image().src=logurl};Sdk.onAdPlayEnd=function(){if(MobadsSdk.onAdPlayEnd){setTimeout(function(){MobadsSdk.onAdPlayEnd()},300)}};Sdk.open=function(url,options){var option={url:url,inapp:true,act:mob.Act.LP};Sdk.setActionUrl(option);send3rdLog(false,options)};Sdk.startDownload=function(url,options){var ad={};ad=options||{};ad.tit=options&&options.tit||options.appname||\"应用\";var mobadsJumpUrl=url;if(/^itms-services:\\/\\// .test(url)){Sdk.setActionUrl(url,false,mob.Act.DL,ad.tit,true);return}if(Sdk.isIOS){var tid=options&&options.pinfo&&options.pinfo.tid;if(tid){Sdk.sendClickLog(mobadsJumpUrl)}Sdk.setActionUrl({url:url,tid:tid||\"\",inapp:true,act:mob.Act.DL});return}var mon=options&&options.mon||[];var id=options&&options.id||1;var pk=options&&options.pk||\"\";var qk=options&&options.qk||\"\";var exp2=options&&options.exp2||{};var wi=options&&options.wi?true:false;var title=ad.tit;var jsonpar={url:mobadsJumpUrl,act:mob.Act.DL,inapp:true,close:true,adid:id,originUrl:mobadsJumpUrl,dlTunnel:3,autoOpen:true,popNotif:true,canCancel:true,canDelete:5,mon:mon,pk:pk,qk:qk,adid:id,title:ad.tit};Sdk.setActionUrl(jsonpar);if(MobadsSdk.sendActivate){MobadsSdk.sendActivate(JSON.stringify(jsonpar));}send3rdLog(false,options);};Sdk.openScheme=function(url,options){var ad={};ad=options||{};ad.tit=options &&options.tit||\"应用\";var pk=options&&options.pk||\"\";var option={url:url,inapp:true,act:ad.act,title:ad.tit,close:true,pk:pk};Sdk.setActionUrl(option);send3rdLog(false,options);};Sdk.handleClick=function(options){var ad=options||{};var Act=mob.Act;if(Act.LP==ad.act){Sdk.open(ad.curl,ad)}else if(Act.DL==ad.act){Sdk.startDownload(ad.curl,ad)}else if(Act.APO==ad.act){new Image().src=ad.curl;Sdk.openScheme(ad.apo,ad);}};Sdk.onAdPlayEnd=function(){if(MobadsSdk.onAdPlayEnd){MobadsSdk.onAdPlayEnd();}};Sdk.f=function(){if(arguments.length===0){return '';}else if(arguments.length===1){return arguments[0];}var res=arguments[0];for(var i=1;i<arguments.length;++i){var re=new RegExp('\\\\{'+(i-1)+'\\\\}','g');res=res.replace(re,arguments[i]);}return res;};Sdk.randomInt=function(min,max){return Math.floor(Math.random()*(max-min+1)+min);};Sdk.isFunction=function(source){return '[object Function]'===Object.prototype.toString.call(source);};Sdk.natFireEvent=function(token,res){res=res||'';if(token!==''&&Sdk.__events&&Sdk.__events[token]&&Sdk.isFunction(Sdk.__events[token])){Sdk.__events[token](res);if(Sdk.__events[token]&&!Sdk.__events[token].multi){delete Sdk.__events[token];}}};Sdk.natRegEv=function(eventHandler,eventType){eventType=eventType||'';Sdk.__events=Sdk.__events||{};var token=Sdk.f('_{0}_{1}_{2}',eventType,new Date().getTime(),Sdk.randomInt(0,4294967296));Sdk.__events[token]=eventHandler;return token;};Sdk.isInstalled=function(pk,onready){var token=Sdk.natRegEv(onready);if(MobadsSdk.isInstalled){MobadsSdk.isInstalled(token,pk);}else{Sdk.natFireEvent(token,'false');}};Sdk.getDownloadStatus=function(callback,pkg){var token=Sdk.natRegEv(callback);if(MobadsSdk.getDownloadStatus){MobadsSdk.getDownloadStatus(token,pkg);}};Sdk.pauseDownload=function(pkg){if(MobadsSdk.pauseDownload){MobadsSdk.pauseDownload(pkg);}};window.MobadsSdk=window.MobadsSdk||{};window.MobadsSdk.pauseDownload=function(pkg){window.location='mobadssdk://pauseDownload?pkg='+pkg;};window.MobadsSdk.getDownloadStatus=function(token,pkg){window.location='mobadssdk://getDownloadStatus?token='+token+'&pkg='+pkg;};window.MobadsSdk.setActionUrl=function(jsonPar,inapp){window.location='mobadssdk://setActionUrl?json='+jsonPar;};})();");
                            this.this$0.executeJavaScript("javascript:(function(){window.mobadsSdk&&window.mobadsSdk.pageFinishedCallback&&window.mobadsSdk.pageFinishedCallback();})()");
                        }
                        if (this.this$0.isRecordPageFinish) {
                            return;
                        }
                        this.this$0.stateEvent(AdStateEvent.EVENT_TIME_LP_FINISH);
                    }
                }

                @Override // android.webkit.WebViewClient
                public void onPageStarted(WebView webView, String str2, Bitmap bitmap) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048579, this, webView, str2, bitmap) == null) {
                        super.onPageStarted(webView, str2, bitmap);
                        XMyWebView xMyWebView = this.this$0.curWebview;
                        if (xMyWebView != null && str2 != null) {
                            xMyWebView.curUrl = str2;
                        }
                        Redirect38Class redirect38Class2 = this.val$redr;
                        redirect38Class2.startUrl = str2;
                        redirect38Class2.isUrlFinishSended = false;
                        if (!redirect38Class2.isRedirect) {
                            sendStarted(str2);
                        }
                        if (this.this$0.isRecordPageStart) {
                            return;
                        }
                        this.this$0.stateEvent(AdStateEvent.EVENT_TIME_LP_START);
                    }
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLL(1048580, this, webView, sslErrorHandler, sslError) == null) {
                        try {
                            if (!PluginLoader.getSslExemption(sslErrorHandler)) {
                                sslErrorHandler.cancel();
                            }
                            if (this.this$0.isLuLandingPage && this.this$0.mLandingPageTrackingInfo.luSslErrorTime == -1) {
                                this.this$0.mLandingPageTrackingInfo.luSslErrorTime = System.currentTimeMillis() - this.this$0.mEnterLpTimestamp;
                            }
                        } catch (Throwable th) {
                            this.this$0.mAdLogger.d(th.getMessage());
                        }
                    }
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView, String str2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048581, this, webView, str2)) == null) {
                        if (str2 != null) {
                            try {
                                if (!str2.equals("about:blank")) {
                                    if (str2.startsWith("bdmobadsapp://v1/utils/lp?")) {
                                        this.this$0.updateLpState(App2Activity.FINISH_LP_BACK_HOUSE);
                                        this.this$0.closeCause = "clickHouse";
                                        this.this$0.runActivityExitAnimation();
                                        return false;
                                    }
                                    WebView.HitTestResult hitTestResult = webView.getHitTestResult();
                                    if (hitTestResult != null && hitTestResult.getType() == 0) {
                                        this.val$redr.isRedirect = true;
                                    }
                                    if (this.this$0.mTmpExtraInfo == null || !App2Activity.LP_STYLE_VR.equals(this.this$0.mTmpExtraInfo.lpStyle)) {
                                        if (this.this$0.mNativePlayerJsBridgeHandler == null || this.this$0.mNativePlayerJsBridgeHandler.isNativePlayerScheme(str2) || this.this$0.mBaiduJsInterface.isJimuyuUrl(str2) || this.this$0.cpuLpVideoLayout == null || this.this$0.cpuLpVideoLayout.getVisibility() != 0) {
                                            return this.this$0.broswer(webView, str2, null, null);
                                        }
                                        this.this$0.cpuLpVideoLayout.setVisibility(8);
                                        this.this$0.mVideoHeight = 0;
                                        return false;
                                    }
                                    return false;
                                }
                            } catch (Exception e3) {
                                this.this$0.mAdLogger.d(App2Activity.TAG, e3.getMessage());
                                return true;
                            }
                        }
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
            this.jsInterface = new XDLJsInterface(this.curWebview, this.mProxyActivity, this.mAppsid);
            if (this.mTmpExtraInfo != null) {
                this.mBaiduJsInterface = new BaiduAppJsBridgeHandler(this.mProxyActivity.getApplicationContext(), this.curWebview, this.mTmpExtraInfo.getAdInstanceInfo(), this.mTmpExtraInfo.prodType, this.mAppsid);
            }
            this.mProxyActivity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
            RelativeLayout relativeLayout = new RelativeLayout(this.mProxyActivity);
            View spinnerBar = getSpinnerBar();
            this.mSpinnerImageView = spinnerBar;
            relativeLayout.addView(spinnerBar);
            relativeLayout.addView(this.curWebview, new RelativeLayout.LayoutParams(-1, -1));
            relativeLayout.addView(customProgressBar, new RelativeLayout.LayoutParams(-1, ScreenUtils.getPixel(this.mProxyActivity.getApplicationContext(), 2)));
            NativePlayerJsBridgeHandler nativePlayerJsBridgeHandler = new NativePlayerJsBridgeHandler(this.mProxyActivity.getApplicationContext(), this.curWebview, this.cpuLpVideoLayout);
            this.mNativePlayerJsBridgeHandler = nativePlayerJsBridgeHandler;
            nativePlayerJsBridgeHandler.setPlayerCallBack(this);
            return relativeLayout;
        }
        return (RelativeLayout) invokeL.objValue;
    }

    private void injectCookie(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65603, this, str) == null) {
            Uri parse = Uri.parse(str);
            Iterator<String> it = this.mLuTwoHopAddress.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (parse.getHost().contains(next) || parse.getPath().contains(next)) {
                    this.DOMAIN = parse.getScheme() + "://" + parse.getHost();
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("bd_cuid", DeviceUtils.getInstance().getCUID(this.mProxyActivity));
                    hashMap.put("wifi_mac", "");
                    hashMap.put("wifi_name", getSSid());
                    setCookie("BDUD", Base64.encode(hashMapToString(hashMap)));
                }
            }
            if (this.mIsCpuLandingPage) {
                setCookie(CPU_DOMAIN, Double.valueOf(XAdSDKRemoteVersion.getVersion()));
            }
        }
    }

    private boolean isLpThemeDarkMode(IXAdInstanceInfo iXAdInstanceInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65604, this, iXAdInstanceInfo)) == null) {
            if (!this.mIsCpuLandingPage || iXAdInstanceInfo == null) {
                return false;
            }
            String clickThroughUrl = iXAdInstanceInfo.getClickThroughUrl();
            if (TextUtils.isEmpty(clickThroughUrl)) {
                return false;
            }
            try {
                Uri parse = Uri.parse(clickThroughUrl);
                if ("cpu.baidu.com".equals(parse.getHost())) {
                    return SkinManager.SKIN_TYPE_STR_DARK.equals(parse.getQueryParameter("preferscolortheme"));
                }
                return false;
            } catch (Throwable th) {
                this.mAdLogger.d(TAG, th);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private boolean isThemeTranslucent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65605, this)) == null) {
            try {
                return 16973840 == getThemeId();
            } catch (Exception e2) {
                this.mAdLogger.e(e2);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    private boolean isVideoAvailable() {
        InterceptResult invokeV;
        XAdInstanceInfoExt xAdInstanceInfoExt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65606, this)) == null) {
            XAdRemoteLandingPageExtraInfo xAdRemoteLandingPageExtraInfo = this.mTmpExtraInfo;
            return xAdRemoteLandingPageExtraInfo != null && (xAdInstanceInfoExt = xAdRemoteLandingPageExtraInfo.mAdInstanceInfo) != null && xAdInstanceInfoExt.getVideoWidth() > 0 && this.mTmpExtraInfo.mAdInstanceInfo.getVideoHeight() > 0;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void myLoadUrl(WebView webView, String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65607, this, new Object[]{webView, str, Boolean.valueOf(z), str2}) == null) || webView == null) {
            return;
        }
        injectCookie(str);
        if (this.hasClked) {
            this.urlclicks++;
            this.mLandingPageTrackingInfo.mMoveTimes.decrementAndGet();
            this.hasClked = false;
        }
        if (z && str2.equals("ignore")) {
            try {
                this.curWebview.loadUrl(str);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        try {
            HashMap hashMap = new HashMap();
            if (!needInjectJSWhenPageFinished()) {
                executeJavaScript("javascript:(function(){window.baidu={};window.baidu.mobads={};window.baidu.mobads.Sdk={isIOS:false};var Sdk=window.baidu.mobads.Sdk;Sdk.isIOS=(/iphone|ipad|ipod/i).test(window.navigator.userAgent.toLowerCase());var mob=window.baidu.mobads;mob.Act={LP:1,DL:2,MAP:4,SMS:8,MAIL:16,PHONE:32,VIDEO:64,RM:128,NA:256,APO:512};var win=window;win.MobadsSdk=win.MobadsSdk||{};var MobadsSdk=win.MobadsSdk;var send3rdLog=function(isShowLog,ad){if(!ad||!ad.mon){return}var url;for(var i=0;i<ad.mon.length;++i){url=isShowLog?ad.mon[i].s:ad.mon[i].c;if(!url){continue}new Image().src=url}};Sdk.setActionUrl=function(url,inapp,act,title,close){var opt={};if(\"[object Object]\"===Object.prototype.toString.call(url)){opt=url;url=opt.url;inapp=opt.inapp;act=opt.act;title=opt.title;close=opt.close}opt.url=url||\"\";opt.inapp=inapp||false;opt.act=act||1;opt.title=title||\"\";opt.close=close||false;opt.logurl=opt.logurl||\"\";opt.weibo=opt.weibo||\"\";opt.map=opt.map||\"\";opt.search=opt.search||\"\";opt.sms=opt.sms||\"\";opt.at=opt.at||1;opt.tid=opt.tid||\"\";opt.erciqueren=true;if(MobadsSdk.setActionUrl){var DUMP_PAR=opt.inapp;MobadsSdk.setActionUrl(JSON.stringify(opt),DUMP_PAR)}};Sdk.sendClickLog=function(logurl){new Image().src=logurl};Sdk.onAdPlayEnd=function(){if(MobadsSdk.onAdPlayEnd){setTimeout(function(){MobadsSdk.onAdPlayEnd()},300)}};Sdk.open=function(url,options){var option={url:url,inapp:true,act:mob.Act.LP};Sdk.setActionUrl(option);send3rdLog(false,options)};Sdk.startDownload=function(url,options){var ad={};ad=options||{};ad.tit=options&&options.tit||options.appname||\"应用\";var mobadsJumpUrl=url;if(/^itms-services:\\/\\// .test(url)){Sdk.setActionUrl(url,false,mob.Act.DL,ad.tit,true);return}if(Sdk.isIOS){var tid=options&&options.pinfo&&options.pinfo.tid;if(tid){Sdk.sendClickLog(mobadsJumpUrl)}Sdk.setActionUrl({url:url,tid:tid||\"\",inapp:true,act:mob.Act.DL});return}var mon=options&&options.mon||[];var id=options&&options.id||1;var pk=options&&options.pk||\"\";var qk=options&&options.qk||\"\";var exp2=options&&options.exp2||{};var wi=options&&options.wi?true:false;var title=ad.tit;var jsonpar={url:mobadsJumpUrl,act:mob.Act.DL,inapp:true,close:true,adid:id,originUrl:mobadsJumpUrl,dlTunnel:3,autoOpen:true,popNotif:true,canCancel:true,canDelete:5,mon:mon,pk:pk,qk:qk,adid:id,title:ad.tit};Sdk.setActionUrl(jsonpar);if(MobadsSdk.sendActivate){MobadsSdk.sendActivate(JSON.stringify(jsonpar));}send3rdLog(false,options);};Sdk.openScheme=function(url,options){var ad={};ad=options||{};ad.tit=options &&options.tit||\"应用\";var pk=options&&options.pk||\"\";var option={url:url,inapp:true,act:ad.act,title:ad.tit,close:true,pk:pk};Sdk.setActionUrl(option);send3rdLog(false,options);};Sdk.handleClick=function(options){var ad=options||{};var Act=mob.Act;if(Act.LP==ad.act){Sdk.open(ad.curl,ad)}else if(Act.DL==ad.act){Sdk.startDownload(ad.curl,ad)}else if(Act.APO==ad.act){new Image().src=ad.curl;Sdk.openScheme(ad.apo,ad);}};Sdk.onAdPlayEnd=function(){if(MobadsSdk.onAdPlayEnd){MobadsSdk.onAdPlayEnd();}};Sdk.f=function(){if(arguments.length===0){return '';}else if(arguments.length===1){return arguments[0];}var res=arguments[0];for(var i=1;i<arguments.length;++i){var re=new RegExp('\\\\{'+(i-1)+'\\\\}','g');res=res.replace(re,arguments[i]);}return res;};Sdk.randomInt=function(min,max){return Math.floor(Math.random()*(max-min+1)+min);};Sdk.isFunction=function(source){return '[object Function]'===Object.prototype.toString.call(source);};Sdk.natFireEvent=function(token,res){res=res||'';if(token!==''&&Sdk.__events&&Sdk.__events[token]&&Sdk.isFunction(Sdk.__events[token])){Sdk.__events[token](res);if(Sdk.__events[token]&&!Sdk.__events[token].multi){delete Sdk.__events[token];}}};Sdk.natRegEv=function(eventHandler,eventType){eventType=eventType||'';Sdk.__events=Sdk.__events||{};var token=Sdk.f('_{0}_{1}_{2}',eventType,new Date().getTime(),Sdk.randomInt(0,4294967296));Sdk.__events[token]=eventHandler;return token;};Sdk.isInstalled=function(pk,onready){var token=Sdk.natRegEv(onready);if(MobadsSdk.isInstalled){MobadsSdk.isInstalled(token,pk);}else{Sdk.natFireEvent(token,'false');}};Sdk.getDownloadStatus=function(callback,pkg){var token=Sdk.natRegEv(callback);if(MobadsSdk.getDownloadStatus){MobadsSdk.getDownloadStatus(token,pkg);}};Sdk.pauseDownload=function(pkg){if(MobadsSdk.pauseDownload){MobadsSdk.pauseDownload(pkg);}};window.MobadsSdk=window.MobadsSdk||{};window.MobadsSdk.pauseDownload=function(pkg){window.location='mobadssdk://pauseDownload?pkg='+pkg;};window.MobadsSdk.getDownloadStatus=function(token,pkg){window.location='mobadssdk://getDownloadStatus?token='+token+'&pkg='+pkg;};window.MobadsSdk.setActionUrl=function(jsonPar,inapp){window.location='mobadssdk://setActionUrl?json='+jsonPar;};})();");
            }
            this.curWebview.getClass().getMethod("loadUrl", String.class, Map.class).invoke(this.curWebview, str, hashMap);
        } catch (Exception e2) {
            try {
                this.curWebview.loadUrl(str);
            } catch (Exception unused2) {
                this.mAdLogger.d(TAG, e2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshWebView() {
        XMyWebView xMyWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65608, this) == null) || (xMyWebView = this.curWebview) == null) {
            return;
        }
        xMyWebView.reload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFromParent(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65609, this, view) == null) || view == null) {
            return;
        }
        try {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
        } catch (Exception e2) {
            this.mAdLogger.e(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(16)
    public void runActivityExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65610, this) == null) {
            this.mUserAutoFinish = true;
            if (!canSupportAnimate()) {
                finishActivity();
                return;
            }
            try {
                RelativeLayout relativeLayout = this.wvTool;
                if (this.mIsThemeTranslucent) {
                    ActivityUtils.translucentActivity(this.mProxyActivity);
                    relativeLayout.setTranslationX(0.0f);
                    ViewPropertyAnimator translationX = relativeLayout.animate().setDuration(300L).translationX(relativeLayout.getWidth());
                    if (Build.VERSION.SDK_INT >= 16) {
                        translationX.withEndAction(new Runnable(this) { // from class: com.baidu.mobads.container.landingpage.App2Activity.16
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ App2Activity this$0;

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
                                    this.this$0.finishActivity();
                                    this.this$0.mProxyActivity.overridePendingTransition(0, 0);
                                }
                            }
                        });
                    } else {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: com.baidu.mobads.container.landingpage.App2Activity.17
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ App2Activity this$0;

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
                                    this.this$0.finishActivity();
                                }
                            }
                        }, 300L);
                    }
                } else {
                    finishActivity();
                }
            } catch (Exception e2) {
                this.mAdLogger.e(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(12)
    public void runActivityStartAnimation(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65611, this, view) == null) {
            try {
                if (ANIMATION_DURATION_ACTIVITY_ENTER < 0 || ANIMATION_DURATION_ACTIVITY_ENTER > 2000) {
                    ANIMATION_DURATION_ACTIVITY_ENTER = 0;
                }
                view.animate().setDuration(ANIMATION_DURATION_ACTIVITY_ENTER);
                view.setTranslationX(view.getWidth());
                view.animate().setDuration(ANIMATION_DURATION_ACTIVITY_ENTER).translationX(0.0f);
            } catch (Exception e2) {
                this.mAdLogger.e(e2);
            }
        }
    }

    private void runVideoAnimation(float f2) {
        float f3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(65612, this, f2) == null) && this.mVideoHeight > 0 && this.curWebview.isScrollY()) {
            if (f2 > 0.0f) {
                f3 = -this.mRlViewTop;
                this.mRlViewTop = 0.0f;
            } else if (f2 < 0.0f) {
                int i2 = this.mVideoHeight;
                this.mRlViewTop = -i2;
                f3 = i2 + this.mRlViewTop;
            } else {
                float f4 = this.mRlViewTop;
                int i3 = this.mVideoHeight;
                if (f4 < i3 * (-0.25f)) {
                    f3 = f4 + i3;
                    this.mRlViewTop = -i3;
                } else {
                    f3 = -f4;
                    this.mRlViewTop = 0.0f;
                }
            }
            long j = (f3 * 200.0f) / this.mVideoHeight;
            if (j > 0) {
                this.mRlContainer.animate().setDuration(j).setInterpolator(this.mInterpolator).translationY(this.mRlViewTop);
            }
        }
    }

    private boolean secondConfirm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65613, this)) == null) ? this.existWebView ? (TextUtils.isEmpty(this.mTmpExtraInfo.lpMurl) && "video_and_web".equals(this.mTmpExtraInfo.lpStyle)) || MURL_SECOND_CONFIRM_NEW.equals(this.mTmpExtraInfo.lpMurl) : !(MURL_SECOND_CONFIRM.get() || !"video_and_web".equals(this.mTmpExtraInfo.lpStyle) || MURL_WEB.get()) || MURL_SECOND_CONFIRM.get() : invokeV.booleanValue;
    }

    private void sendLpBroadcast() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65614, this) == null) || this.mProxyActivity == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("lp_close");
        this.mProxyActivity.sendBroadcast(intent);
    }

    private void sendLpLifeCircleLog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65615, this, str) == null) {
            try {
                if (this.mTmpExtraInfo == null || this.mTmpExtraInfo.mProdType == null) {
                    return;
                }
                if ("rvideo".equals(this.mTmpExtraInfo.mProdType) || "fvideo".equals(this.mTmpExtraInfo.mProdType)) {
                    HashMap hashMap = new HashMap();
                    if (this.mTmpExtraInfo != null && this.mTmpExtraInfo.getAdInstanceInfo() != null) {
                        hashMap.put(XAdRemoteAPKDownloadExtraInfo.QK, this.mTmpExtraInfo.getAdInstanceInfo().getQueryKey());
                        hashMap.put("adId", this.mTmpExtraInfo.getAdInstanceInfo().getAdId());
                        hashMap.put("prod", this.mTmpExtraInfo.mProdType);
                        try {
                            hashMap.put(XAdRemoteAPKDownloadExtraInfo.BUYER, RemoteCommonUtils.getInstance().getBuyerFromJson(this.mTmpExtraInfo.getAdInstanceInfo().getOriginJsonObject()));
                            hashMap.put("act", String.valueOf(this.mTmpExtraInfo.getAdInstanceInfo().getActionType()));
                            hashMap.put("curl", URLEncoder.encode(this.mTmpExtraInfo.url, "UTF-8"));
                        } catch (Exception unused) {
                        }
                    }
                    hashMap.put("info", str);
                    SendLogUtil.sendExpLpLog(this.mProxyActivity, 703, hashMap);
                }
            } catch (Exception unused2) {
            }
        }
    }

    public static void setActionBarColor(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(65616, null, i2, i3, i4, i5) == null) {
            mSActionBarColorTheme = new ActionBarColorTheme(i2, i3, i4, i5);
        }
    }

    public static void setActionBarColorTheme(ActionBarColorTheme actionBarColorTheme) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65617, null, actionBarColorTheme) == null) || actionBarColorTheme == null) {
            return;
        }
        mSActionBarColorTheme = new ActionBarColorTheme(actionBarColorTheme);
    }

    private void setCookie(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65618, this, str, obj) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append("=");
            stringBuffer.append(obj);
            stringBuffer.append(";");
            try {
                this.cookieManager.setCookie(this.DOMAIN, stringBuffer.toString());
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBottomView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65619, this) == null) {
            initBackgroundView();
            initBottomView();
            this.wvTool.addView(this.mBackgroundView);
            this.wvTool.addView(this.mBottomView);
            if (canSupportAnimate()) {
                this.mBottomView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener(this) { // from class: com.baidu.mobads.container.landingpage.App2Activity.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ App2Activity this$0;

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

                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            this.this$0.mBottomView.getViewTreeObserver().removeOnPreDrawListener(this);
                            App2Activity app2Activity = this.this$0;
                            app2Activity.runBottomViewEnterAnimation(app2Activity.mBackgroundView, this.this$0.mBottomView);
                            return true;
                        }
                        return invokeV.booleanValue;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showVideo(Context context, IXAdInstanceInfo iXAdInstanceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65620, this, context, iXAdInstanceInfo) == null) {
            LpVideoView lpVideoView = new LpVideoView(context, iXAdInstanceInfo);
            this.videoView = lpVideoView;
            lpVideoView.setVideoListener(new LpVideoView.OnVideoListener(this) { // from class: com.baidu.mobads.container.landingpage.App2Activity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ App2Activity this$0;

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

                @Override // com.baidu.mobads.container.landingpage.LpVideoView.OnVideoListener
                public void onReturnButtonClicked() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.updateLpState(App2Activity.FINISH_LP_VIDEO_RETURN);
                        this.this$0.finishActivity();
                    }
                }
            });
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.videoView.getLayoutParams();
            this.mVideoHeight = layoutParams.height;
            this.videoView.setId(1001);
            this.mLlContainer.addView(this.videoView, 0, layoutParams);
            this.videoView.start();
            this.videoView.sendMonitorLogForVideoStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stateEvent(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65622, this, str) == null) || TextUtils.isEmpty(this.mAdUniqueId)) {
            return;
        }
        StateMachine.event(this.mAdUniqueId, str, String.valueOf(System.currentTimeMillis() - StateMachine.queryLong(this.mAdUniqueId, AdStateEvent.EVENT_TIME_AD_CLICK)));
    }

    private void stopAndRelease() {
        LpVideoView lpVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65624, this) == null) || (lpVideoView = this.videoView) == null) {
            return;
        }
        lpVideoView.stopAndRelease();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLpState(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65625, this, str) == null) {
            this.mLpFinishState = str;
        }
    }

    public boolean canSupportAnimate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                if ("video_and_web".equals(this.mTmpExtraInfo.lpStyle)) {
                    return false;
                }
                return Build.VERSION.SDK_INT >= 12;
            } catch (Exception e2) {
                this.mAdLogger.e(e2);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.container.landingpage.NativePlayerJsBridgeHandler.PlayerCallBack
    public void changeVideoUrl(JsWithPlayerData jsWithPlayerData) {
        CpuLpVideoLayout cpuLpVideoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsWithPlayerData) == null) || (cpuLpVideoLayout = this.cpuLpVideoLayout) == null) {
            return;
        }
        cpuLpVideoLayout.setVisibility(0);
        this.cpuLpVideoLayout.changeVideoUrl(jsWithPlayerData);
        XActionBar xActionBar = this.actionBar;
        if (xActionBar != null) {
            xActionBar.setTitle(jsWithPlayerData.videoTitle);
        }
    }

    @Override // com.baidu.mobads.container.landingpage.NativePlayerJsBridgeHandler.PlayerCallBack
    public void clickPreroll() {
        CpuLpVideoLayout cpuLpVideoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (cpuLpVideoLayout = this.cpuLpVideoLayout) == null) {
            return;
        }
        cpuLpVideoLayout.setVisibility(8);
        this.mVideoHeight = 0;
    }

    @TargetApi(11)
    public void copyCurrentPageUrl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (Build.VERSION.SDK_INT < 11) {
                Toast.makeText(this.mProxyActivity, "系统版本不支持", 0).show();
                return;
            }
            try {
                if (TextUtils.isEmpty(this.curWebview.getUrl())) {
                    return;
                }
                ((ClipboardManager) this.mProxyActivity.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setPrimaryClip(ClipData.newPlainText("网页链接", this.curWebview.getUrl()));
                Toast.makeText(this.mProxyActivity, "已复制到剪切板", 0).show();
            } catch (Exception e2) {
                this.mAdLogger.e(e2);
            }
        }
    }

    @Override // com.baidu.mobads.container.landingpage.NativePlayerJsBridgeHandler.PlayerCallBack
    public void createAdView(JsWithPlayerData jsWithPlayerData) {
        CpuLpVideoLayout cpuLpVideoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jsWithPlayerData) == null) || (cpuLpVideoLayout = this.cpuLpVideoLayout) == null) {
            return;
        }
        cpuLpVideoLayout.addPrerolls(jsWithPlayerData);
    }

    @Override // com.baidu.mobads.container.landingpage.NativePlayerJsBridgeHandler.PlayerCallBack
    public void createVideoView(JsWithPlayerData jsWithPlayerData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, jsWithPlayerData) == null) || this.cpuLpVideoLayout == null) {
            return;
        }
        this.mRlContainer.animate().setDuration(800L).setInterpolator(this.mInterpolator).translationY(0.0f);
        this.cpuLpVideoLayout.setVisibility(0);
        this.cpuLpVideoLayout.post(new Runnable(this) { // from class: com.baidu.mobads.container.landingpage.App2Activity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ App2Activity this$0;

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
                    App2Activity app2Activity = this.this$0;
                    app2Activity.mVideoHeight = app2Activity.cpuLpVideoLayout.getMeasuredHeight();
                }
            }
        });
        this.cpuLpVideoLayout.initLayoutWithVideoData(jsWithPlayerData);
        this.cpuLpVideoLayout.playVideo();
        this.mRlContainer.getLayoutParams().height = this.curWebview.getMeasuredHeight();
        this.mRlViewTop = 0.0f;
        XActionBar xActionBar = this.actionBar;
        if (xActionBar != null) {
            xActionBar.setTitle(jsWithPlayerData.videoTitle);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, keyEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"NewApi"})
    public void executeJavaScript(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (this.curWebview != null) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    try {
                        if (!str.startsWith("javascript:")) {
                            str = "javascript:" + str;
                        }
                        if (Build.VERSION.SDK_INT < 19) {
                            this.curWebview.loadUrl(str);
                            return;
                        } else {
                            this.curWebview.evaluateJavascript(str, new ValueCallback<String>(this) { // from class: com.baidu.mobads.container.landingpage.App2Activity.18
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ App2Activity this$0;

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

                                /* JADX DEBUG: Method merged with bridge method */
                                @Override // android.webkit.ValueCallback
                                public void onReceiveValue(String str2) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) {
                                    }
                                }
                            });
                            return;
                        }
                    } catch (Exception e2) {
                        this.mAdLogger.d(TAG, e2.getMessage());
                        return;
                    }
                }
                TaskScheduler.getInstance().submit(new Runnable(this, str) { // from class: com.baidu.mobads.container.landingpage.App2Activity.19
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ App2Activity this$0;
                    public final /* synthetic */ String val$jscode;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
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
                        this.val$jscode = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.executeJavaScript(this.val$jscode);
                        }
                    }
                });
                return;
            }
            this.mAdLogger.d(TAG, "webview is null");
        }
    }

    public void initActionBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            XActionBar xActionBar = new XActionBar(this.mProxyActivity, mSActionBarColorTheme);
            this.actionBar = xActionBar;
            xActionBar.setId(1001);
            this.actionBar.setOnButtonClickListener(new XActionBar.OnButtonClickListener(this) { // from class: com.baidu.mobads.container.landingpage.App2Activity.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ App2Activity this$0;

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

                @Override // com.baidu.mobads.container.landingpage.XActionBar.OnButtonClickListener
                public void onGoBackBttonClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.updateLpState(App2Activity.FINISH_LP_BACK_BTN);
                        App2Activity app2Activity = this.this$0;
                        app2Activity.closeCause = "topLeftBtn";
                        app2Activity.runActivityExitAnimation();
                        this.this$0.mLandingPageTrackingInfo.mButtonClickTopGoBack++;
                    }
                }

                @Override // com.baidu.mobads.container.landingpage.XActionBar.OnButtonClickListener
                public void onThreePointButtonClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.this$0.showBottomView();
                        this.this$0.mLandingPageTrackingInfo.mButtonClickTopThreePoint++;
                    }
                }
            });
        }
    }

    @TargetApi(11)
    public void initBottomView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            XLPBottomView xLPBottomView = new XLPBottomView(this.mProxyActivity);
            this.mBottomView = xLPBottomView;
            xLPBottomView.setOnBottomButtonClickListener(new XLPBottomView.OnBottomButtonClickListener(this) { // from class: com.baidu.mobads.container.landingpage.App2Activity.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ App2Activity this$0;

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

                @Override // com.baidu.mobads.container.landingpage.XLPBottomView.OnBottomButtonClickListener
                public void onCancel() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.mLandingPageTrackingInfo.mButtonClickBottomCancel++;
                        App2Activity app2Activity = this.this$0;
                        app2Activity.runBottomViewExitAnimation(app2Activity.mBackgroundView, this.this$0.mBottomView);
                    }
                }

                @Override // com.baidu.mobads.container.landingpage.XLPBottomView.OnBottomButtonClickListener
                public void onCopyUrl() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.this$0.mLandingPageTrackingInfo.mButtonClickBottomCopyUrl++;
                        this.this$0.copyCurrentPageUrl();
                        App2Activity app2Activity = this.this$0;
                        app2Activity.runBottomViewExitAnimation(app2Activity.mBackgroundView, this.this$0.mBottomView);
                    }
                }

                @Override // com.baidu.mobads.container.landingpage.XLPBottomView.OnBottomButtonClickListener
                public void onRefresh() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.this$0.mLandingPageTrackingInfo.mButtonClickBottomRefresh++;
                        this.this$0.refreshWebView();
                        App2Activity app2Activity = this.this$0;
                        app2Activity.runBottomViewExitAnimation(app2Activity.mBackgroundView, this.this$0.mBottomView);
                    }
                }
            });
            if (canSupportAnimate()) {
                this.mBottomView.setAlpha(0.0f);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mBottomView.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.mobads.container.landingpage.NativePlayerJsBridgeHandler.PlayerCallBack
    public void isFullScreenStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.mIsFullScreenVideo = z;
        }
    }

    public boolean needInjectJSWhenPageFinished() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? Build.VERSION.SDK_INT >= 24 || CommonUtils.getTargetVersion(this.mProxyActivity.getApplicationContext()) >= 24 : invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048589, this, i2, i3, intent) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onBackPressed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, configuration) == null) {
            XAdRemoteLandingPageExtraInfo xAdRemoteLandingPageExtraInfo = this.mTmpExtraInfo;
            if (!(xAdRemoteLandingPageExtraInfo != null && xAdRemoteLandingPageExtraInfo.isFullScreen) && !this.mIsFullScreenVideo) {
                this.mProxyActivity.getWindow().clearFlags(1024);
            } else {
                this.mProxyActivity.getWindow().addFlags(1024);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onCreate(Bundle bundle) {
        XAdRemoteLandingPageExtraInfo xAdRemoteLandingPageExtraInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            this.mLpExeOnCreateTime = System.currentTimeMillis();
            Intent intent = this.mProxyActivity.getIntent();
            if (intent != null) {
                xAdRemoteLandingPageExtraInfo = (XAdRemoteLandingPageExtraInfo) intent.getParcelableExtra("EXTRA_DATA");
                String str = xAdRemoteLandingPageExtraInfo.mLpMultiProcess;
                if (!TextUtils.isEmpty(str)) {
                    this.existWebView = Boolean.parseBoolean(str);
                }
            } else {
                xAdRemoteLandingPageExtraInfo = null;
            }
            if (xAdRemoteLandingPageExtraInfo == null) {
                updateLpState(FINISH_LP_DATA_ERROR);
                finishActivity();
                return;
            }
            if (0 < SHOUBAI_LP_APO_START_TIME) {
                long currentTimeMillis = System.currentTimeMillis() - SHOUBAI_LP_APO_START_TIME;
                this.delta = currentTimeMillis;
                SHOUBAI_LP_APO_START_TIME = 0L;
                if (SHOUBAI_LP_APO_START && 1000 < currentTimeMillis) {
                    SHOUBAI_LP_APO_START = false;
                    updateLpState(FINISH_LP_OPEN_TIMEOUT);
                    finishActivity();
                    return;
                }
            }
            isAppActivityOpening.set(true);
            this.mTmpExtraInfo = xAdRemoteLandingPageExtraInfo;
            this.mContentType = xAdRemoteLandingPageExtraInfo.getAdInstanceInfo().getExtraParams().optString("contenttype");
            this.mThumburl = this.mTmpExtraInfo.getAdInstanceInfo().getExtraParams().optString("thumburl");
            this.mContentType = "image";
            this.mIsCpuLandingPage = "cpu".equals(this.mTmpExtraInfo.mProdType);
            this.mIsDarkModeStyle = isLpThemeDarkMode(this.mTmpExtraInfo.getAdInstanceInfo());
            try {
                if (CAN_LP_SHOW_WHEN_LOCKED) {
                    this.mProxyActivity.getWindow().addFlags(2621440);
                }
            } catch (Throwable th) {
                this.mAdLogger.e(th);
            }
            addTwoHopAddress();
            initCookieManager();
            this.mIsThemeTranslucent = isThemeTranslucent();
            XAdRemoteLandingPageTrackingInfo xAdRemoteLandingPageTrackingInfo = new XAdRemoteLandingPageTrackingInfo(this.mTmpExtraInfo);
            this.mLandingPageTrackingInfo = xAdRemoteLandingPageTrackingInfo;
            this.mAppsid = xAdRemoteLandingPageTrackingInfo.appsid;
            if (intent != null) {
                this.mCanOpenAppForAPO = intent.getBooleanExtra("canOpenAppForAPO", this.mCanOpenAppForAPO);
            }
            Rect windowRect = ScreenUtils.getWindowRect(this.mProxyActivity);
            this.ratioW = (float) ((windowRect.width() * 1.0d) / 640.0d);
            this.ratioH = (float) ((windowRect.height() * 1.0d) / 960.0d);
            this.mProxyActivity.requestWindowFeature(1);
            this.mAdTitle = this.mTmpExtraInfo.title;
            if (this.mIsThemeTranslucent) {
                ActivityUtils.changeOrientation(this.mProxyActivity);
            }
            this.mProxyActivity.setRequestedOrientation(1);
            this.mEnterLpTimestamp = System.currentTimeMillis();
            getAdUniqueId();
            stateEvent(AdStateCode.EVENT_LP_CREATE);
            stateEvent(AdStateEvent.EVENT_TIME_LP_CREATE);
            try {
                if (this.mTmpExtraInfo.isFullScreen) {
                    this.mProxyActivity.getWindow().setFlags(1024, 1024);
                }
            } catch (Exception unused) {
                this.mAdLogger.d(TAG, "exception when getIntent");
            }
            XAdRemoteLandingPageExtraInfo xAdRemoteLandingPageExtraInfo2 = this.mTmpExtraInfo;
            this.from = xAdRemoteLandingPageExtraInfo2.from;
            String str2 = xAdRemoteLandingPageExtraInfo2.url;
            if (XMyWebView.canOpenByIntent(str2)) {
                this.mAdLogger.d(TAG, "AppActivity.browser external");
                if (XMyWebView.isAudioFile(str2)) {
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.setDataAndType(Uri.parse(str2), BdUploadHandler.AUDIO_MIME_TYPE);
                    this.mProxyActivity.startActivity(intent2);
                } else if (XMyWebView.isVideoFile(str2)) {
                    Intent intent3 = new Intent("android.intent.action.VIEW");
                    intent3.setDataAndType(Uri.parse(str2), BdUploadHandler.VIDEO_MIME_TYPE);
                    this.mProxyActivity.startActivity(intent3);
                } else {
                    OpenAppUtils.browserOutside(this.mProxyActivity, str2);
                }
                updateLpState(FINISH_LP_OPEN_INTENT);
                finishActivity();
                return;
            }
            sendLpLifeCircleLog("loadUrl");
            addGlobalViews(str2);
            this.mLandingPageTrackingInfo.shoubailp = this.mTmpExtraInfo.lpStyle;
            if (SHOUBAI_LP_APO_START) {
                this.mMainHandler.postDelayed(new Runnable(this, str2) { // from class: com.baidu.mobads.container.landingpage.App2Activity.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ App2Activity this$0;
                    public final /* synthetic */ String val$loadUrl;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str2};
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
                        this.val$loadUrl = str2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.stateEvent(AdStateEvent.EVENT_TIME_LP_LOAD);
                            App2Activity app2Activity = this.this$0;
                            XMyWebView xMyWebView = app2Activity.curWebview;
                            String str3 = this.val$loadUrl;
                            app2Activity.myLoadUrl(xMyWebView, str3, false, "http://mobads.baidu.com/" + AppUtils.getAppPackage(this.this$0.mProxyActivity));
                        }
                    }
                }, 500L);
            } else {
                stateEvent(AdStateEvent.EVENT_TIME_LP_LOAD);
                XMyWebView xMyWebView = this.curWebview;
                myLoadUrl(xMyWebView, str2, false, "http://mobads.baidu.com/" + AppUtils.getAppPackage(this.mProxyActivity));
            }
            this.wvTool.setBackgroundColor(-1);
            this.mProxyActivity.setContentView(this.wvTool);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            try {
                if (this.tipView != null) {
                    this.tipView.clearAnimation();
                }
                if (this.curWebview != null) {
                    ((ViewGroup) this.curWebview.getParent()).removeView(this.curWebview);
                }
            } catch (Exception e2) {
                this.mAdLogger.d(TAG, e2.getMessage());
            }
            isAppActivityOpening.set(false);
            XAdRemoteLandingPageTrackingInfo xAdRemoteLandingPageTrackingInfo = this.mLandingPageTrackingInfo;
            if (xAdRemoteLandingPageTrackingInfo != null) {
                xAdRemoteLandingPageTrackingInfo.obj = this.closeCause;
                int i2 = this.order;
                this.order = i2 + 1;
                xAdRemoteLandingPageTrackingInfo.order = i2;
                XMyWebView xMyWebView = this.curWebview;
                xAdRemoteLandingPageTrackingInfo.height = xMyWebView != null ? xMyWebView.getContentHeight() : 0;
                XAdRemoteLandingPageTrackingInfo xAdRemoteLandingPageTrackingInfo2 = this.mLandingPageTrackingInfo;
                XMyWebView xMyWebView2 = this.curWebview;
                xAdRemoteLandingPageTrackingInfo2.progress = xMyWebView2 != null ? xMyWebView2.getProgress() : 0;
                XAdRemoteLandingPageTrackingInfo xAdRemoteLandingPageTrackingInfo3 = this.mLandingPageTrackingInfo;
                xAdRemoteLandingPageTrackingInfo3.urlclicks = this.urlclicks;
                xAdRemoteLandingPageTrackingInfo3.lploadtime = this.mLploadtime;
                xAdRemoteLandingPageTrackingInfo3.duration = System.currentTimeMillis() - this.mEnterLpTimestamp;
                XAdRemoteLandingPageTrackingInfo xAdRemoteLandingPageTrackingInfo4 = this.mLandingPageTrackingInfo;
                xAdRemoteLandingPageTrackingInfo4.e75 = this.e75;
                xAdRemoteLandingPageTrackingInfo4.e753 = this.e753;
                xAdRemoteLandingPageTrackingInfo4.from = this.from;
                xAdRemoteLandingPageTrackingInfo4.maxTabs = this.maxOpenedTabs;
            }
            sendLpCloseLog(this.mProxyActivity.getApplicationContext());
            try {
                this.mAdLogger.d(TAG, MissionEvent.MESSAGE_DESTROY);
                if (this.curWebview != null) {
                    this.curWebview.setVisibility(8);
                    this.curWebview.stopLoading();
                    this.curWebview.destroy();
                }
            } catch (Exception e3) {
                this.mAdLogger.d(TAG, e3.getMessage());
            }
            disposeAnimation();
            MURL_SECOND_CONFIRM.set(false);
            sendLpBroadcast();
            try {
                EuiLeakFixUtils.fixLeakCanaryOnEui(this.mProxyActivity.getApplicationContext());
            } catch (Throwable th) {
                this.mAdLogger.d(TAG, th.getMessage());
            }
            if (this.existWebView) {
                Process.killProcess(Process.myPid());
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048596, this, i2, keyEvent)) == null) {
            try {
            } catch (Exception e2) {
                this.mAdLogger.d(TAG, e2.getMessage());
            }
            if (i2 != 4) {
                if (i2 == 46) {
                    this.curWebview.reload();
                    return true;
                }
                return false;
            }
            if (this.videoView == null || !this.videoView.closeFullScreen()) {
                if (this.mBottomViewIsShowing) {
                    runBottomViewExitAnimation(this.mBackgroundView, this.mBottomView);
                } else {
                    if (this.mFullScreenView == null && !this.mIsFullScreenVideo) {
                        if (this.curWebview.canGoBack()) {
                            this.mVideoHeight = 0;
                            this.cpuLpVideoLayout.setVisibility(8);
                            this.curWebview.goBack();
                        } else {
                            this.closeCause = "backC";
                            if (!this.closeLp.get()) {
                                this.closeLp.set(true);
                                updateLpState(FINISH_LP_BACK_KEY);
                                runActivityExitAnimation();
                            }
                        }
                    }
                    hideCustomView();
                    this.cpuLpVideoLayout.shrinkScreen();
                }
            }
            this.mLandingPageTrackingInfo.mButtonClickOsGoBack++;
            return true;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048597, this, i2, keyEvent)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onNewIntent(Intent intent) {
        Parcelable parcelableExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, intent) == null) || intent == null || !APKStateManager.getInstance().getLPSwitch(this.mProxyActivity.getApplicationContext()) || (parcelableExtra = intent.getParcelableExtra("EXTRA_DATA")) == null) {
            return;
        }
        XAdRemoteLandingPageExtraInfo xAdRemoteLandingPageExtraInfo = (XAdRemoteLandingPageExtraInfo) parcelableExtra;
        XAdRemoteLandingPageExtraInfo xAdRemoteLandingPageExtraInfo2 = this.mTmpExtraInfo;
        if (xAdRemoteLandingPageExtraInfo2 == null || xAdRemoteLandingPageExtraInfo == null || TextUtils.equals(xAdRemoteLandingPageExtraInfo2.url, xAdRemoteLandingPageExtraInfo.url)) {
            return;
        }
        this.mTmpExtraInfo = xAdRemoteLandingPageExtraInfo;
        RelativeLayout relativeLayout = this.wvTool;
        if (relativeLayout != null && this.mProxyActivity != null) {
            relativeLayout.removeAllViews();
            addGlobalViews(this.mTmpExtraInfo.url);
            this.wvTool.setBackgroundColor(-1);
            this.mProxyActivity.setContentView(this.wvTool);
        }
        XMyWebView xMyWebView = this.curWebview;
        if (xMyWebView != null) {
            xMyWebView.loadUrl(this.mTmpExtraInfo.url);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.isFirstPause) {
                this.isFirstPause = false;
            } else {
                this.mLandingPageTrackingInfo.mButtonClickOsHome++;
            }
            LpVideoView lpVideoView = this.videoView;
            if (lpVideoView != null) {
                lpVideoView.pause();
            }
            if (this.mIsCpuLandingPage && this.curWebview != null) {
                this.curWebview.onPause();
            }
            if (SHOUBAI_LP_APO_START) {
                if (!this.mUserAutoFinish) {
                    updateLpState(FINISH_LP_BY_SHOUBAI);
                }
                SHOUBAI_LP_APO_START = false;
                finishActivity();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            LpVideoView lpVideoView = this.videoView;
            if (lpVideoView != null && this.mRlViewTop > -0.01f) {
                lpVideoView.resume();
            }
            if (!this.mIsCpuLandingPage || this.curWebview == null) {
                return;
            }
            this.curWebview.onResume();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, view, motionEvent)) == null) {
            this.isTouched = true;
            try {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.hasClked = true;
                    this.mCurDy = 0.0f;
                    this.mFirstDownY = (int) motionEvent.getRawY();
                    this.mPostY = motionEvent.getRawY();
                } else if (action == 1) {
                    runVideoAnimation(this.mCurDy);
                    if (this.videoView != null) {
                        if (this.mRlViewTop == 0.0f) {
                            this.videoView.resume();
                        } else {
                            this.videoView.pause();
                            this.curWebview.setScrollY(false);
                        }
                    }
                    if (this.cpuLpVideoLayout != null && this.cpuLpVideoLayout.getVisibility() == 0) {
                        if (this.mRlViewTop == 0.0f && this.mVideoHeight > 0) {
                            if (Math.abs(((int) motionEvent.getRawY()) - this.mFirstDownY) >= ViewConfiguration.get(this.mProxyActivity).getScaledTouchSlop()) {
                                return true;
                            }
                        } else if (this.mVideoHeight > 0) {
                            this.cpuLpVideoLayout.pauseVideo();
                            this.curWebview.setScrollY(false);
                        }
                    }
                    this.mLandingPageTrackingInfo.mMoveTimes.incrementAndGet();
                    view.performClick();
                } else if (action != 2) {
                    RemoteXAdLogger remoteXAdLogger = this.mAdLogger;
                    String str = TAG;
                    remoteXAdLogger.d(str, "unprocessed action=" + motionEvent.getAction());
                } else if (this.mVideoHeight > 0) {
                    this.mCurDy = motionEvent.getRawY() - this.mPostY;
                    this.mPostY = motionEvent.getRawY();
                    if (this.curWebview.isScrollY()) {
                        if (this.mCurDy >= 0.0f && this.mRlViewTop <= 0.0f) {
                            float f2 = this.mRlViewTop + this.mCurDy;
                            this.mRlViewTop = f2;
                            if (f2 > 0.0f) {
                                this.mRlViewTop = 0.0f;
                            }
                            this.mRlContainer.setTranslationY(this.mRlViewTop);
                            return true;
                        } else if (this.mCurDy <= 0.0f && this.mRlViewTop > (-this.mVideoHeight)) {
                            float f3 = this.mRlViewTop + this.mCurDy;
                            this.mRlViewTop = f3;
                            if (f3 < (-this.mVideoHeight)) {
                                this.mRlViewTop = -this.mVideoHeight;
                                if (this.videoView != null) {
                                    this.videoView.pause();
                                }
                                if (this.cpuLpVideoLayout != null) {
                                    this.cpuLpVideoLayout.pauseVideo();
                                }
                            }
                            this.mRlContainer.setTranslationY(this.mRlViewTop);
                            return true;
                        }
                    }
                }
            } catch (Exception e2) {
                this.mAdLogger.d(TAG, e2.getMessage());
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void overridePendingTransition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048608, this, i2, i3) == null) {
        }
    }

    @TargetApi(12)
    public void runBottomViewEnterAnimation(View view, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, view, view2) == null) {
            this.mBottomViewIsShowing = true;
            try {
                view.animate().setDuration(500L).alpha(0.5f);
                view2.setTranslationY(view2.getHeight());
                view2.animate().setDuration(500L).alpha(1.0f).translationY(0.0f);
            } catch (Exception e2) {
                this.mAdLogger.e(e2);
            }
        }
    }

    @TargetApi(16)
    public void runBottomViewExitAnimation(View view, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, view, view2) == null) {
            this.mBottomViewIsShowing = false;
            if (!canSupportAnimate()) {
                removeFromParent(view2);
                removeFromParent(view);
                return;
            }
            try {
                view.clearAnimation();
                view.animate().setDuration(250L).alpha(0.0f);
                view2.setTranslationY(0.0f);
                ViewPropertyAnimator translationY = view2.animate().setDuration(250L).alpha(0.0f).translationY(view2.getHeight());
                if (Build.VERSION.SDK_INT >= 16) {
                    translationY.withEndAction(new Runnable(this, view2, view) { // from class: com.baidu.mobads.container.landingpage.App2Activity.14
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ App2Activity this$0;
                        public final /* synthetic */ View val$backgroundView;
                        public final /* synthetic */ View val$bottomView;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, view2, view};
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
                            this.val$bottomView = view2;
                            this.val$backgroundView = view;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$0.removeFromParent(this.val$bottomView);
                                this.this$0.removeFromParent(this.val$backgroundView);
                            }
                        }
                    });
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this, view2, view) { // from class: com.baidu.mobads.container.landingpage.App2Activity.15
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ App2Activity this$0;
                        public final /* synthetic */ View val$backgroundView;
                        public final /* synthetic */ View val$bottomView;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, view2, view};
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
                            this.val$bottomView = view2;
                            this.val$backgroundView = view;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.this$0.removeFromParent(this.val$bottomView);
                                this.this$0.removeFromParent(this.val$backgroundView);
                            }
                        }
                    }, 250L);
                }
            } catch (Exception e2) {
                this.mAdLogger.e(e2);
            }
        }
    }

    public void sendLpCloseLog(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, context) == null) {
            try {
                SendLogUtil.Builder append = SendLogUtil.Builder.create(context).appendType(DESTROY_EVENT).append("lpState", this.mLpFinishState);
                SendLogUtil.Builder append2 = append.append("lpLiveTime", (System.currentTimeMillis() - this.mLpExeOnCreateTime) + "");
                SendLogUtil.Builder append3 = append2.append("delta", this.delta + "");
                if (this.mTmpExtraInfo != null && this.mTmpExtraInfo.getAdInstanceInfo() != null) {
                    append3.appendAdInfo(this.mTmpExtraInfo.getAdInstanceInfo());
                }
                stateEvent(AdStateCode.EVENT_LP_CLOSE);
                String str = AdStateEvent.EVENT_LP_CLICKS;
                stateEvent(str, this.urlclicks + "");
                stateEvent(AdStateEvent.EVENT_TIME_LP_CLOSE);
                StateMachine.finish(this.mAdUniqueId);
                if (this.mLandingPageTrackingInfo != null) {
                    append3.append(this.mLandingPageTrackingInfo.toHashMap());
                }
                append3.sendWithVd();
            } catch (Exception e2) {
                this.mAdLogger.d(TAG, e2.getMessage());
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void setActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, activity) == null) {
            this.mProxyActivity = activity;
            this.mAppContext = activity.getApplicationContext();
        }
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void setLpBussParam(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        setActionBarColor(jSONObject.optInt("bar_close_color", -5987164), jSONObject.optInt("bar_title_color", -6842473), jSONObject.optInt("bar_pro_color", -11113262), jSONObject.optInt("bar_bg_color", SwipeRefreshLayout.CIRCLE_BG_LIGHT));
        canLpShowWhenLocked(jSONObject.optBoolean("showWhenLocked", false));
    }

    public void setPageFinishedListener(PageFinishedListener pageFinishedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, pageFinishedListener) == null) {
            this.mPageFinishedListener = pageFinishedListener;
        }
    }

    @Override // com.baidu.mobads.container.landingpage.NativePlayerJsBridgeHandler.PlayerCallBack
    public void setVideoLocation(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            if (z) {
                this.mVideoHeight = 0;
            } else {
                this.mVideoHeight = this.cpuLpVideoLayout.getMeasuredHeight();
            }
        }
    }

    public void showAutoPlayVideoPrompt(Context context, IXAdInstanceInfo iXAdInstanceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, context, iXAdInstanceInfo) == null) {
            XVideoAutoPlayOnlyWifiView xVideoAutoPlayOnlyWifiView = new XVideoAutoPlayOnlyWifiView(context);
            int screenWidth = CommonUtils.getScreenWidth(context);
            int videoHeight = (iXAdInstanceInfo.getVideoHeight() * screenWidth) / iXAdInstanceInfo.getVideoWidth();
            this.mVideoHeight = videoHeight;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(screenWidth, videoHeight);
            layoutParams.addRule(10);
            xVideoAutoPlayOnlyWifiView.setId(1001);
            xVideoAutoPlayOnlyWifiView.setListener(new XVideoAutoPlayOnlyWifiView.OnListener(this, xVideoAutoPlayOnlyWifiView) { // from class: com.baidu.mobads.container.landingpage.App2Activity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ App2Activity this$0;
                public final /* synthetic */ XVideoAutoPlayOnlyWifiView val$wifiView;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, xVideoAutoPlayOnlyWifiView};
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
                    this.val$wifiView = xVideoAutoPlayOnlyWifiView;
                }

                @Override // com.baidu.mobads.container.landingpage.XVideoAutoPlayOnlyWifiView.OnListener
                public void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.this$0.mLlContainer.removeView(this.val$wifiView);
                        } catch (Exception unused) {
                        }
                        App2Activity app2Activity = this.this$0;
                        app2Activity.showVideo(app2Activity.mProxyActivity, this.this$0.mTmpExtraInfo.mAdInstanceInfo);
                    }
                }
            });
            this.mLlContainer.addView(xVideoAutoPlayOnlyWifiView, layoutParams);
        }
    }

    @Override // com.baidu.mobads.container.landingpage.NativePlayerJsBridgeHandler.PlayerCallBack
    public void videoNotVisible() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            new Exception().printStackTrace();
            this.mRlContainer.animate().setDuration(100L).setInterpolator(this.mInterpolator).translationY(0.0f);
        }
    }

    private void stateEvent(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65623, this, str, str2) == null) || TextUtils.isEmpty(this.mAdUniqueId)) {
            return;
        }
        StateMachine.event(this.mAdUniqueId, str, str2);
    }

    /* loaded from: classes7.dex */
    public static class ActionBarColorTheme {
        public static /* synthetic */ Interceptable $ic;
        public static final ActionBarColorTheme ACTION_BAR_BLACK_THEME;
        public static final ActionBarColorTheme ACTION_BAR_BLUE_THEME;
        public static final ActionBarColorTheme ACTION_BAR_COFFEE_THEME;
        public static final ActionBarColorTheme ACTION_BAR_GREEN_THEME;
        public static final ActionBarColorTheme ACTION_BAR_NAVYBLUE_THEME;
        public static final ActionBarColorTheme ACTION_BAR_RED_THEME;
        public static final ActionBarColorTheme ACTION_BAR_WHITE_THEME;
        public transient /* synthetic */ FieldHolder $fh;
        public int backgroundColor;
        public int closeColor;
        public int progressColor;
        public int titleColor;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1327783892, "Lcom/baidu/mobads/container/landingpage/App2Activity$ActionBarColorTheme;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1327783892, "Lcom/baidu/mobads/container/landingpage/App2Activity$ActionBarColorTheme;");
                    return;
                }
            }
            ACTION_BAR_WHITE_THEME = new ActionBarColorTheme(-5987164, -6842473, -11113262, SwipeRefreshLayout.CIRCLE_BG_LIGHT);
            ACTION_BAR_RED_THEME = new ActionBarColorTheme(-1, -1, -12510, -1294276);
            ACTION_BAR_GREEN_THEME = new ActionBarColorTheme(-1, -1, -11113262, -14303071);
            ACTION_BAR_NAVYBLUE_THEME = new ActionBarColorTheme(-1, -1, 16764706, -14210226);
            ACTION_BAR_BLUE_THEME = new ActionBarColorTheme(-1, -1, -12510, -13870424);
            ACTION_BAR_COFFEE_THEME = new ActionBarColorTheme(-1, -1, -12510, -11255230);
            ACTION_BAR_BLACK_THEME = new ActionBarColorTheme(-1, -1, -12510, -13749450);
        }

        public ActionBarColorTheme(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.closeColor = i2;
            this.titleColor = i3;
            this.progressColor = i4;
            this.backgroundColor = i5;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                ActionBarColorTheme actionBarColorTheme = (ActionBarColorTheme) obj;
                return this.backgroundColor == actionBarColorTheme.backgroundColor && this.titleColor == actionBarColorTheme.titleColor && this.closeColor == actionBarColorTheme.closeColor && this.progressColor == actionBarColorTheme.progressColor;
            }
            return invokeL.booleanValue;
        }

        public int getBackgroundColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.backgroundColor : invokeV.intValue;
        }

        public int getCloseColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.closeColor : invokeV.intValue;
        }

        public int getProgressColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.progressColor : invokeV.intValue;
        }

        public int getTitleColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.titleColor : invokeV.intValue;
        }

        public void setBackgroundColor(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
                this.backgroundColor = i2;
            }
        }

        public void setCloseColor(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                this.closeColor = i2;
            }
        }

        public void setProgressColor(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
                this.progressColor = i2;
            }
        }

        public void setTitleColor(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
                this.titleColor = i2;
            }
        }

        public ActionBarColorTheme(ActionBarColorTheme actionBarColorTheme) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {actionBarColorTheme};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.closeColor = actionBarColorTheme.closeColor;
            this.titleColor = actionBarColorTheme.titleColor;
            this.progressColor = actionBarColorTheme.progressColor;
            this.backgroundColor = actionBarColorTheme.backgroundColor;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stateEvent(AdStateCode adStateCode) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65621, this, adStateCode) == null) || TextUtils.isEmpty(this.mAdUniqueId)) {
            return;
        }
        StateMachine.event(this.mAdUniqueId, adStateCode);
    }
}
