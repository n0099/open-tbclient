package com.baidu.mobads.container.bridge;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.Toast;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.XAdRemoteCommonUtils;
import com.baidu.mobads.container.XBaseHtmlAdContainer;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.mobads.container.adrequest.XAdContainerContext;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.components.downloader.IDownloader;
import com.baidu.mobads.container.components.statemachine.AdStateCode;
import com.baidu.mobads.container.components.statemachine.StateMachine;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.template.XTemplateAdContainer;
import com.baidu.mobads.container.util.AdDownloadApkUtils;
import com.baidu.mobads.container.util.AdViewUtils;
import com.baidu.mobads.container.util.CommonUtils;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.EncryptUtils;
import com.baidu.mobads.container.util.OpenAppUtils;
import com.baidu.mobads.container.util.PackageUtils;
import com.baidu.mobads.container.util.ProcessUtils;
import com.baidu.mobads.container.util.RemoteCommonUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.mobads.container.util.ScreenUtils;
import com.baidu.mobads.container.util.SendLogUtil;
import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.mobads.container.util.network.NetworkInfoUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public abstract class BaseHtmlBridgeHandler {
    public static final String DL_STATUS_NONE = "NONE";
    public static final String JAVASCRIPT_PREFIX = "javascript:";
    public static final String TAG = "BaseHtmlBridgeHandler";
    public boolean isClicked;
    public XBaseHtmlAdContainer mAdContainer;
    public XAdContainerContext mAdContainerCxt;
    public BridgeListener mBridgeListener;
    public WebView mWebView;
    public PlacementType mPlacementType = PlacementType.INLINE;
    public Map<String, String> mAdMap = new HashMap();
    public AtomicInteger mCurrentAdSeq = new AtomicInteger();
    public boolean isJSSDK = false;
    public String mBaseJavascript = null;
    public String mUpdateScript = null;
    public boolean mHasInjectPlacementType = false;
    public RemoteXAdLogger mAdLogger = RemoteXAdLogger.getInstance();
    public Handler mMainHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.baidu.mobads.container.bridge.BaseHtmlBridgeHandler$14  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass14 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$mobads$container$bridge$CommandType;

        static {
            int[] iArr = new int[CommandType.values().length];
            $SwitchMap$com$baidu$mobads$container$bridge$CommandType = iArr;
            try {
                iArr[CommandType.GET_ID_FROME_NATIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.UNSPECIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.PAUSE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.GET_DOWNLOAD_STATUS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.CONFIRM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.GET_ACTIVE_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.GET_ADVIEW_STATE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.GET_APP_STATUS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.GET_CONFS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.GET_CURRENT_APP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.GET_INSTALLED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.GET_RECENT_ALL.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.GET_RECENT_DIFF.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.GET_SYS_INSTALLED.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.GET_WIFI_SCANS.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.GET_VERSION_CODE_BY_PKG.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.INSTALL_APP.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.ON_AD_FALED.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.ON_AD_SHOW.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.ON_AD_SWITCH.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.ON_INITED.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.OPEN_APP.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.PLAY_VIDEO.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.PRINT_LOG.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.SET_APP_TIP.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.RESIZE.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.SET_ACTION_URL.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.SET_ORIENTATION_PROPERTIES.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.SET_VISIBILITY.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.CREATE_CALENDAR_EVENT.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.STORE_PICTURE.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.OPEN.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.EXPAND.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.USE_CUSTOM_CLOSE.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.ON_AD_PLAY_END.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.CLOSE.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.HANDLE_PLAY_CLICK.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.DOWNLOAD_PRIVACY_CLICK.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.DOWNLOAD_PERMISSION_CLICK.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
        }
    }

    public BaseHtmlBridgeHandler(XBaseHtmlAdContainer xBaseHtmlAdContainer, WebView webView, BridgeListener bridgeListener, XAdContainerContext xAdContainerContext) {
        this.mAdContainer = xBaseHtmlAdContainer;
        this.mBridgeListener = bridgeListener;
        this.mAdContainerCxt = xAdContainerContext;
        this.mWebView = webView;
        if (Build.VERSION.SDK_INT >= 19) {
            this.mWebView.loadUrl("javascript:(function(){})()");
        }
        initWebViewEnvironment();
        if ("int".equals(this.mAdContainerCxt.getAdProd())) {
            setPlacementType(PlacementType.INTERSTITIAL);
        } else {
            setPlacementType(PlacementType.INLINE);
        }
    }

    private void fire(final String str, final String str2) {
        TaskScheduler.getInstance().submit(new BaseTask() { // from class: com.baidu.mobads.container.bridge.BaseHtmlBridgeHandler.1
            @Override // com.baidu.mobads.container.executor.BaseTask
            public Object doInBackground() {
                try {
                    BaseHtmlBridgeHandler.this.fireAnonymousEvent(str, str2);
                    return null;
                } catch (Exception unused) {
                    return null;
                }
            }
        }, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireAnonymousEvent(String str, String str2) {
        if (str != null && str.length() > 0 && str.contains("#")) {
            str.split("#");
        }
        executeJavaScript("window.mobadssdkbridge.fireAnonymousEvent('" + str + "', '" + str2 + "')");
    }

    private void fireNativeCommandCompleteEvent(CommandType commandType) {
        executeJavaScript("window.mobadssdkbridge && window.mobadssdkbridge.nativeCallComplete && window.mobadssdkbridge.nativeCallComplete(" + JSONObject.quote(commandType.toJavascriptString()) + SmallTailInfo.EMOTION_SUFFIX);
    }

    private IXAdInstanceInfo getCloneIXAdInstanceInfo() {
        try {
            IXAdInstanceInfo adInstanceInfo = this.mAdContainerCxt.getAdInstanceInfo();
            Method declaredMethod = adInstanceInfo.getClass().getDeclaredMethod("clone", new Class[0]);
            declaredMethod.setAccessible(true);
            return (IXAdInstanceInfo) declaredMethod.invoke(adInstanceInfo, new Object[0]);
        } catch (Exception e2) {
            this.mAdLogger.d(e2);
            return null;
        }
    }

    private void handleConfirm(String str, final String str2) {
        Context appContext = this.mAdContainerCxt.getAppContext();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("title");
            String string2 = jSONObject.getString("body");
            String string3 = jSONObject.getString("okBtn");
            String string4 = jSONObject.getString("cancelBtn");
            Activity activity = this.mAdContainerCxt.getActivity();
            if (activity != null && !activity.isFinishing()) {
                AlertDialog create = new AlertDialog.Builder(activity).setIcon(17301659).setTitle(string).setMessage(string2).setPositiveButton(string3, new DialogInterface.OnClickListener() { // from class: com.baidu.mobads.container.bridge.BaseHtmlBridgeHandler.11
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        BaseHtmlBridgeHandler.this.fireAnonymousEvent(str2, "true");
                    }
                }).setNegativeButton(string4, new DialogInterface.OnClickListener() { // from class: com.baidu.mobads.container.bridge.BaseHtmlBridgeHandler.10
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        BaseHtmlBridgeHandler.this.fireAnonymousEvent(str2, "false");
                    }
                }).create();
                create.show();
                int pixel = ScreenUtils.getPixel(appContext, 50);
                create.getButton(-2).setHeight(pixel);
                create.getButton(-1).setHeight(pixel);
            } else {
                fireAnonymousEvent(str2, "true");
            }
        } catch (Exception e2) {
            this.mAdLogger.d(e2);
            fireAnonymousEvent(str2, "true");
        }
    }

    private void handleVideoParameters(IXAdInstanceInfo iXAdInstanceInfo, JSONObject jSONObject) {
        String optString = jSONObject.optString("action", "");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        if (CommonUtils.isMethodExist(IXAdInstanceInfo.class, "setAction", String.class)) {
            iXAdInstanceInfo.setAction(optString);
        }
        if (CommonUtils.isMethodExist(IXAdInstanceInfo.class, "setVideoWidth", Integer.TYPE)) {
            iXAdInstanceInfo.setVideoWidth(jSONObject.optInt("v_video_w", 0));
        }
        if (CommonUtils.isMethodExist(IXAdInstanceInfo.class, "setVideoHeight", Integer.TYPE)) {
            iXAdInstanceInfo.setVideoHeight(jSONObject.optInt("v_video_h", 0));
        }
        if (CommonUtils.isMethodExist(IXAdInstanceInfo.class, "setMainPictureUrl", String.class)) {
            iXAdInstanceInfo.setMainPictureUrl(jSONObject.optString("v_image", ""));
        }
        if (CommonUtils.isMethodExist(IXAdInstanceInfo.class, "setWebUrl", String.class)) {
            iXAdInstanceInfo.setWebUrl(jSONObject.optString("v_url", ""));
        }
        if (CommonUtils.isMethodExist(IXAdInstanceInfo.class, "setVideoUrl", String.class)) {
            iXAdInstanceInfo.setVideoUrl(jSONObject.optString("v_video", ""));
        }
    }

    private String replaceLast(String str, String str2, String str3) {
        int lastIndexOf = str.lastIndexOf(str2);
        if (lastIndexOf < 0) {
            return str;
        }
        String replaceFirst = str.substring(lastIndexOf).replaceFirst(str2, str3);
        return str.substring(0, lastIndexOf) + replaceFirst;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void try2FireCustomizeTracking(IXAdInstanceInfo iXAdInstanceInfo, int i2) {
        try {
            SendLogUtil.Builder.create(this.mAdContainerCxt.getAppContext()).appendType(i2).appendProdType(this.mAdContainerCxt.getAdProd()).appendAppSid(this.mAdContainerCxt.getAppsid()).appendAdInfo(iXAdInstanceInfo).append("from", "native-remote").send();
        } catch (Exception e2) {
            this.mAdLogger.d(e2);
        }
    }

    public void afterJavaScriptBridgeInit(StringBuilder sb) {
    }

    public void detachBridgeFromView() {
        this.mWebView = null;
    }

    public void detachViewFromViewTree() {
        executeJavaScript(BridgeJavascript.JS_ONDETACHED);
    }

    public void executeJavaScript(final String str) {
        String str2;
        if (this.mWebView != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                try {
                    if (this.isJSSDK || str.startsWith("javascript:")) {
                        str2 = str;
                    } else {
                        str2 = "javascript:" + str;
                    }
                    if (Build.VERSION.SDK_INT < 19) {
                        if (this.isJSSDK && !str2.startsWith("javascript:")) {
                            str2 = "javascript:" + str;
                        }
                        this.mWebView.loadUrl(str2);
                        return;
                    }
                    this.mWebView.evaluateJavascript(str2, new ValueCallback<String>() { // from class: com.baidu.mobads.container.bridge.BaseHtmlBridgeHandler.12
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str3) {
                        }
                    });
                    return;
                } catch (Exception e2) {
                    this.mAdLogger.d(e2);
                    return;
                }
            }
            this.mMainHandler.post(new Runnable() { // from class: com.baidu.mobads.container.bridge.BaseHtmlBridgeHandler.13
                @Override // java.lang.Runnable
                public void run() {
                    BaseHtmlBridgeHandler.this.executeJavaScript(str);
                }
            });
            return;
        }
        this.mAdLogger.d("webview is null");
    }

    public void expandCloseSuccess() {
        notifyViewState(ViewState.DEFAULT);
    }

    public void expandSuccess() {
        notifyViewState(ViewState.EXPANDED);
    }

    public int getAdViewState() {
        if (AdViewUtils.isScreenOn(this.mAdContainerCxt.getAppContext())) {
            if (AdViewUtils.isAdViewShown(getWebView())) {
                if (AdViewUtils.isAdViewOutsideScreen(getWebView())) {
                    return 3;
                }
                return AdViewUtils.isAdViewTooSmall(getWebView()) ? 6 : 0;
            }
            return 1;
        }
        return 4;
    }

    public String getAppStatus(String str) {
        Context appContext = this.mAdContainerCxt.getAppContext();
        try {
            JSONObject jSONObject = new JSONObject(str);
            return AdDownloadApkUtils.getStatusStr(appContext, jSONObject.getString("pk"), EncryptUtils.getMD5(jSONObject.getString("originUrl")));
        } catch (Exception unused) {
            return "NONE";
        }
    }

    public BridgeListener getBridgeListener() {
        return this.mBridgeListener;
    }

    public abstract JSONObject getConfs();

    public Handler getMainHandler() {
        return this.mMainHandler;
    }

    public PlacementType getPlacementType() {
        return this.mPlacementType;
    }

    public int getVersionCodeByPkg(String str) {
        Context appContext = this.mAdContainerCxt.getAppContext();
        try {
            return appContext.getPackageManager().getPackageInfo(new JSONObject(str).optString("pk", ""), 0).versionCode;
        } catch (Exception unused) {
            return -100;
        }
    }

    public WebView getWebView() {
        return this.mWebView;
    }

    public String getWifiScans() {
        try {
            return DeviceUtils.getInstance().getWifiScans(this.mAdContainerCxt.getAppContext()).toString();
        } catch (Exception e2) {
            this.mAdLogger.d(e2);
            return "[]";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0292 A[Catch: Exception -> 0x02f8, TryCatch #2 {Exception -> 0x02f8, blocks: (B:98:0x027c, B:100:0x0292, B:102:0x029c, B:104:0x02b3, B:106:0x02b9, B:108:0x02db, B:109:0x02f2), top: B:121:0x027c }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0152 A[Catch: Exception -> 0x025e, TRY_LEAVE, TryCatch #8 {Exception -> 0x025e, blocks: (B:7:0x0040, B:33:0x00ec, B:61:0x0152, B:69:0x0175, B:70:0x017a, B:72:0x0186, B:73:0x0189, B:75:0x01c0, B:76:0x01c3, B:79:0x01ef, B:81:0x0201, B:83:0x020b, B:86:0x0213, B:88:0x0221, B:59:0x0149, B:64:0x0166, B:66:0x016c), top: B:131:0x0040, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0186 A[Catch: Exception -> 0x025e, TryCatch #8 {Exception -> 0x025e, blocks: (B:7:0x0040, B:33:0x00ec, B:61:0x0152, B:69:0x0175, B:70:0x017a, B:72:0x0186, B:73:0x0189, B:75:0x01c0, B:76:0x01c3, B:79:0x01ef, B:81:0x0201, B:83:0x020b, B:86:0x0213, B:88:0x0221, B:59:0x0149, B:64:0x0166, B:66:0x016c), top: B:131:0x0040, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01c0 A[Catch: Exception -> 0x025e, TryCatch #8 {Exception -> 0x025e, blocks: (B:7:0x0040, B:33:0x00ec, B:61:0x0152, B:69:0x0175, B:70:0x017a, B:72:0x0186, B:73:0x0189, B:75:0x01c0, B:76:0x01c3, B:79:0x01ef, B:81:0x0201, B:83:0x020b, B:86:0x0213, B:88:0x0221, B:59:0x0149, B:64:0x0166, B:66:0x016c), top: B:131:0x0040, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ed A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleClick(String str) {
        String str2;
        String str3;
        JSONObject jSONObject;
        int optInt;
        boolean z;
        JSONObject jSONObject2;
        String str4;
        int i2;
        String str5;
        String str6;
        Context appContext;
        Activity activity;
        String str7;
        String str8;
        JSONObject jSONObject3;
        int optInt2;
        JSONObject jSONObject4;
        final IXAdInstanceInfo cloneIXAdInstanceInfo = getCloneIXAdInstanceInfo();
        try {
            JSONObject jSONObject5 = new JSONObject(str);
            String optString = jSONObject5.optString("url");
            String optString2 = jSONObject5.optString("pk");
            String optString3 = jSONObject5.optString(XAdRemoteAPKDownloadExtraInfo.ADID);
            String optString4 = jSONObject5.optString("originUrl");
            int optInt3 = jSONObject5.optInt(XAdRemoteAPKDownloadExtraInfo.DL_TUNNEL);
            str3 = "pk";
            try {
                optInt = jSONObject5.optInt("act");
                str2 = "act";
            } catch (Exception e2) {
                e = e2;
                str2 = "act";
            }
            try {
                boolean optBoolean = jSONObject5.optBoolean("inapp", true);
                boolean optBoolean2 = jSONObject5.optBoolean(IntentConfig.CLOSE);
                boolean optBoolean3 = jSONObject5.optBoolean(XAdRemoteAPKDownloadExtraInfo.AUTO_OPEN);
                boolean optBoolean4 = jSONObject5.optBoolean("popNotif");
                boolean optBoolean5 = jSONObject5.optBoolean("isWifiTargeted");
                boolean optBoolean6 = jSONObject5.optBoolean("isTooLarge");
                boolean optBoolean7 = jSONObject5.optBoolean("canCancel");
                boolean optBoolean8 = jSONObject5.optBoolean("canDelete");
                boolean optBoolean9 = jSONObject5.optBoolean("secondConfirmed");
                String str9 = null;
                try {
                    jSONObject2 = jSONObject5.optJSONObject("exp2");
                    try {
                        JSONObject optJSONObject = jSONObject5.optJSONObject("control_flags");
                        if (cloneIXAdInstanceInfo.getOriginJsonObject() == null || optJSONObject == null) {
                            z = optBoolean;
                            jSONObject4 = jSONObject2;
                        } else {
                            jSONObject4 = jSONObject2;
                            try {
                                z = optBoolean;
                                try {
                                    cloneIXAdInstanceInfo.getOriginJsonObject().put("control_flags", optJSONObject.toString());
                                } catch (Exception unused) {
                                }
                            } catch (Exception unused2) {
                                z = optBoolean;
                            }
                        }
                        jSONObject2 = jSONObject4;
                    } catch (Exception unused3) {
                        z = optBoolean;
                    }
                } catch (Exception unused4) {
                    z = optBoolean;
                    jSONObject2 = null;
                }
                try {
                    JSONObject optJSONObject2 = jSONObject5.optJSONObject("allParamsJson");
                    if (optJSONObject2 != null) {
                        str9 = optJSONObject2.optString("app_store_link");
                        String optString5 = optJSONObject2.optString("da_area");
                        if (cloneIXAdInstanceInfo.getOriginJsonObject() != null) {
                            if (!TextUtils.isEmpty(optString5)) {
                                cloneIXAdInstanceInfo.getOriginJsonObject().put("da_area", optString5);
                            }
                            if (!TextUtils.isEmpty(str9)) {
                                cloneIXAdInstanceInfo.getAppStoreLink();
                            }
                        }
                    }
                } catch (Exception unused5) {
                }
                String optString6 = jSONObject5.optString(XAdRemoteAPKDownloadExtraInfo.QK);
                try {
                    String optString7 = jSONObject5.optString("adJson", "");
                    if (optString7.length() > 0) {
                        try {
                            jSONObject3 = new JSONObject(optString7);
                            str7 = optString6;
                        } catch (Exception e3) {
                            e = e3;
                            str7 = optString6;
                        }
                        try {
                            optInt2 = jSONObject3.optInt("sz", 0);
                        } catch (Exception e4) {
                            e = e4;
                            str4 = str7;
                            i2 = 0;
                            try {
                                this.mAdLogger.d(e);
                                str8 = "";
                                str5 = str4;
                                str6 = str8;
                            } catch (Exception e5) {
                                e = e5;
                                this.mAdLogger.d(e);
                                str5 = str4;
                                str6 = "";
                                if (jSONObject2 != null) {
                                }
                                cloneIXAdInstanceInfo.setAppOpenStrs(new JSONObject(optString).toString());
                                cloneIXAdInstanceInfo.setClickThroughUrl(optString);
                                cloneIXAdInstanceInfo.setAppPackageName(optString2);
                                if (!TextUtils.isEmpty(optString3)) {
                                }
                                cloneIXAdInstanceInfo.setOriginClickUrl(optString4);
                                cloneIXAdInstanceInfo.setDlTunnel(optInt3);
                                cloneIXAdInstanceInfo.setActionType(optInt);
                                cloneIXAdInstanceInfo.setInapp(z);
                                cloneIXAdInstanceInfo.setClose(optBoolean2);
                                cloneIXAdInstanceInfo.setAutoOpen(optBoolean3);
                                cloneIXAdInstanceInfo.setPopNotif(optBoolean4);
                                cloneIXAdInstanceInfo.setWifiTargeted(optBoolean5);
                                cloneIXAdInstanceInfo.setTooLarge(optBoolean6);
                                cloneIXAdInstanceInfo.setCanCancel(optBoolean7);
                                cloneIXAdInstanceInfo.setCanDelete(optBoolean8);
                                if (!TextUtils.isEmpty(str5)) {
                                }
                                cloneIXAdInstanceInfo.setAppSize(i2);
                                cloneIXAdInstanceInfo.setAppName(str6);
                                cloneIXAdInstanceInfo.setSecondConfirmed(optBoolean9);
                                cloneIXAdInstanceInfo.setTitle(jSONObject5.optString("title", "").replace(StringUtil.ARRAY_START, "").replace("}", ""));
                                handleVideoParameters(cloneIXAdInstanceInfo, jSONObject5);
                                if (optInt == 2) {
                                    appContext = this.mAdContainerCxt.getAppContext();
                                    activity = this.mAdContainerCxt.getActivity();
                                    if (NetworkInfoUtils.isCurrentNetworkAvailable(appContext)) {
                                        CommonUtils.showAlertDialog(activity, jSONObject5.optString("dlgTitle", CommonUtils.DIALOG_TITLE), jSONObject5.optString("dlgBody", CommonUtils.DIALOG_MESSAGE), jSONObject5.optString("okBtn", CommonUtils.DIALOG_POS_TEXT), jSONObject5.optString("cancelBtn", CommonUtils.DIALOG_NEG_TEXT), true, new DialogInterface.OnClickListener() { // from class: com.baidu.mobads.container.bridge.BaseHtmlBridgeHandler.7
                                            @Override // android.content.DialogInterface.OnClickListener
                                            public void onClick(DialogInterface dialogInterface, int i3) {
                                                cloneIXAdInstanceInfo.setActionOnlyWifi(false);
                                                cloneIXAdInstanceInfo.setSecondConfirmed(true);
                                                BaseHtmlBridgeHandler.this.mBridgeListener.onAdClicked(cloneIXAdInstanceInfo);
                                                BaseHtmlBridgeHandler.this.try2FireCustomizeTracking(cloneIXAdInstanceInfo, 360);
                                                StateMachine.event(cloneIXAdInstanceInfo.getUniqueId(), AdStateCode.EVENT_CLICK);
                                            }
                                        }, new DialogInterface.OnClickListener() { // from class: com.baidu.mobads.container.bridge.BaseHtmlBridgeHandler.8
                                            @Override // android.content.DialogInterface.OnClickListener
                                            public void onClick(DialogInterface dialogInterface, int i3) {
                                                cloneIXAdInstanceInfo.setActionOnlyWifi(true);
                                                cloneIXAdInstanceInfo.setSecondConfirmed(true);
                                                BaseHtmlBridgeHandler.this.mBridgeListener.onAdClicked(cloneIXAdInstanceInfo);
                                                BaseHtmlBridgeHandler.this.try2FireCustomizeTracking(cloneIXAdInstanceInfo, SDKLogTypeConstants.DZZB_ALERTDIALOG_NEGATIVE_CLICKED);
                                                StateMachine.event(cloneIXAdInstanceInfo.getUniqueId(), AdStateCode.EVENT_CLICK);
                                            }
                                        });
                                        try2FireCustomizeTracking(cloneIXAdInstanceInfo, SDKLogTypeConstants.DZZB_ALERTDIALOG);
                                        return;
                                    }
                                }
                                this.mBridgeListener.onAdClicked(cloneIXAdInstanceInfo);
                                StateMachine.event(cloneIXAdInstanceInfo.getUniqueId(), AdStateCode.EVENT_CLICK);
                                jSONObject = new JSONObject(str);
                                String optString8 = jSONObject.optString(str3);
                                if (jSONObject.optInt(str2) == 2) {
                                }
                            }
                            if (jSONObject2 != null) {
                            }
                            try {
                                cloneIXAdInstanceInfo.setAppOpenStrs(new JSONObject(optString).toString());
                            } catch (Exception e6) {
                                this.mAdLogger.d(e6);
                            }
                            cloneIXAdInstanceInfo.setClickThroughUrl(optString);
                            cloneIXAdInstanceInfo.setAppPackageName(optString2);
                            if (!TextUtils.isEmpty(optString3)) {
                            }
                            cloneIXAdInstanceInfo.setOriginClickUrl(optString4);
                            cloneIXAdInstanceInfo.setDlTunnel(optInt3);
                            cloneIXAdInstanceInfo.setActionType(optInt);
                            cloneIXAdInstanceInfo.setInapp(z);
                            cloneIXAdInstanceInfo.setClose(optBoolean2);
                            cloneIXAdInstanceInfo.setAutoOpen(optBoolean3);
                            cloneIXAdInstanceInfo.setPopNotif(optBoolean4);
                            cloneIXAdInstanceInfo.setWifiTargeted(optBoolean5);
                            cloneIXAdInstanceInfo.setTooLarge(optBoolean6);
                            cloneIXAdInstanceInfo.setCanCancel(optBoolean7);
                            cloneIXAdInstanceInfo.setCanDelete(optBoolean8);
                            if (!TextUtils.isEmpty(str5)) {
                            }
                            cloneIXAdInstanceInfo.setAppSize(i2);
                            cloneIXAdInstanceInfo.setAppName(str6);
                            cloneIXAdInstanceInfo.setSecondConfirmed(optBoolean9);
                            cloneIXAdInstanceInfo.setTitle(jSONObject5.optString("title", "").replace(StringUtil.ARRAY_START, "").replace("}", ""));
                            handleVideoParameters(cloneIXAdInstanceInfo, jSONObject5);
                            if (optInt == 2) {
                            }
                            this.mBridgeListener.onAdClicked(cloneIXAdInstanceInfo);
                            StateMachine.event(cloneIXAdInstanceInfo.getUniqueId(), AdStateCode.EVENT_CLICK);
                            jSONObject = new JSONObject(str);
                            String optString82 = jSONObject.optString(str3);
                            if (jSONObject.optInt(str2) == 2) {
                            }
                        }
                        try {
                            String optString9 = jSONObject3.optString(XAdRemoteAPKDownloadExtraInfo.QK);
                            if (!TextUtils.isEmpty(optString9)) {
                                str7 = optString9;
                            }
                            str8 = jSONObject3.optString("appname");
                            i2 = optInt2;
                            str4 = str7;
                        } catch (Exception e7) {
                            e = e7;
                            i2 = optInt2;
                            str4 = str7;
                            this.mAdLogger.d(e);
                            str8 = "";
                            str5 = str4;
                            str6 = str8;
                            if (jSONObject2 != null) {
                            }
                            cloneIXAdInstanceInfo.setAppOpenStrs(new JSONObject(optString).toString());
                            cloneIXAdInstanceInfo.setClickThroughUrl(optString);
                            cloneIXAdInstanceInfo.setAppPackageName(optString2);
                            if (!TextUtils.isEmpty(optString3)) {
                            }
                            cloneIXAdInstanceInfo.setOriginClickUrl(optString4);
                            cloneIXAdInstanceInfo.setDlTunnel(optInt3);
                            cloneIXAdInstanceInfo.setActionType(optInt);
                            cloneIXAdInstanceInfo.setInapp(z);
                            cloneIXAdInstanceInfo.setClose(optBoolean2);
                            cloneIXAdInstanceInfo.setAutoOpen(optBoolean3);
                            cloneIXAdInstanceInfo.setPopNotif(optBoolean4);
                            cloneIXAdInstanceInfo.setWifiTargeted(optBoolean5);
                            cloneIXAdInstanceInfo.setTooLarge(optBoolean6);
                            cloneIXAdInstanceInfo.setCanCancel(optBoolean7);
                            cloneIXAdInstanceInfo.setCanDelete(optBoolean8);
                            if (!TextUtils.isEmpty(str5)) {
                            }
                            cloneIXAdInstanceInfo.setAppSize(i2);
                            cloneIXAdInstanceInfo.setAppName(str6);
                            cloneIXAdInstanceInfo.setSecondConfirmed(optBoolean9);
                            cloneIXAdInstanceInfo.setTitle(jSONObject5.optString("title", "").replace(StringUtil.ARRAY_START, "").replace("}", ""));
                            handleVideoParameters(cloneIXAdInstanceInfo, jSONObject5);
                            if (optInt == 2) {
                            }
                            this.mBridgeListener.onAdClicked(cloneIXAdInstanceInfo);
                            StateMachine.event(cloneIXAdInstanceInfo.getUniqueId(), AdStateCode.EVENT_CLICK);
                            jSONObject = new JSONObject(str);
                            String optString822 = jSONObject.optString(str3);
                            if (jSONObject.optInt(str2) == 2) {
                            }
                        }
                    } else {
                        str8 = "";
                        str4 = optString6;
                        i2 = 0;
                    }
                    str5 = str4;
                    str6 = str8;
                } catch (Exception e8) {
                    e = e8;
                    str4 = optString6;
                    i2 = 0;
                }
                if (jSONObject2 != null) {
                    cloneIXAdInstanceInfo.setExp2ForSingleAd(jSONObject2.toString());
                }
                try {
                    cloneIXAdInstanceInfo.setAppOpenStrs(new JSONObject(optString).toString());
                } catch (Exception unused6) {
                    JSONObject optJSONObject3 = jSONObject5.optJSONObject("apo");
                    if (optJSONObject3 != null) {
                        cloneIXAdInstanceInfo.setAppOpenStrs(optJSONObject3.toString());
                    }
                }
                cloneIXAdInstanceInfo.setClickThroughUrl(optString);
                cloneIXAdInstanceInfo.setAppPackageName(optString2);
                if (!TextUtils.isEmpty(optString3)) {
                    cloneIXAdInstanceInfo.setAdId(optString3);
                }
                cloneIXAdInstanceInfo.setOriginClickUrl(optString4);
                cloneIXAdInstanceInfo.setDlTunnel(optInt3);
                cloneIXAdInstanceInfo.setActionType(optInt);
                cloneIXAdInstanceInfo.setInapp(z);
                cloneIXAdInstanceInfo.setClose(optBoolean2);
                cloneIXAdInstanceInfo.setAutoOpen(optBoolean3);
                cloneIXAdInstanceInfo.setPopNotif(optBoolean4);
                cloneIXAdInstanceInfo.setWifiTargeted(optBoolean5);
                cloneIXAdInstanceInfo.setTooLarge(optBoolean6);
                cloneIXAdInstanceInfo.setCanCancel(optBoolean7);
                cloneIXAdInstanceInfo.setCanDelete(optBoolean8);
                if (!TextUtils.isEmpty(str5)) {
                    cloneIXAdInstanceInfo.setQueryKey(str5);
                }
                cloneIXAdInstanceInfo.setAppSize(i2);
                cloneIXAdInstanceInfo.setAppName(str6);
                cloneIXAdInstanceInfo.setSecondConfirmed(optBoolean9);
                cloneIXAdInstanceInfo.setTitle(jSONObject5.optString("title", "").replace(StringUtil.ARRAY_START, "").replace("}", ""));
                handleVideoParameters(cloneIXAdInstanceInfo, jSONObject5);
                if (optInt == 2 && !optBoolean9) {
                    appContext = this.mAdContainerCxt.getAppContext();
                    activity = this.mAdContainerCxt.getActivity();
                    if (NetworkInfoUtils.isCurrentNetworkAvailable(appContext) && !NetworkInfoUtils.isWifiConnected(appContext).booleanValue() && TextUtils.isEmpty(str9) && activity != null && !this.mAdContainerCxt.getAdProd().equals("rsplash")) {
                        CommonUtils.showAlertDialog(activity, jSONObject5.optString("dlgTitle", CommonUtils.DIALOG_TITLE), jSONObject5.optString("dlgBody", CommonUtils.DIALOG_MESSAGE), jSONObject5.optString("okBtn", CommonUtils.DIALOG_POS_TEXT), jSONObject5.optString("cancelBtn", CommonUtils.DIALOG_NEG_TEXT), true, new DialogInterface.OnClickListener() { // from class: com.baidu.mobads.container.bridge.BaseHtmlBridgeHandler.7
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                cloneIXAdInstanceInfo.setActionOnlyWifi(false);
                                cloneIXAdInstanceInfo.setSecondConfirmed(true);
                                BaseHtmlBridgeHandler.this.mBridgeListener.onAdClicked(cloneIXAdInstanceInfo);
                                BaseHtmlBridgeHandler.this.try2FireCustomizeTracking(cloneIXAdInstanceInfo, 360);
                                StateMachine.event(cloneIXAdInstanceInfo.getUniqueId(), AdStateCode.EVENT_CLICK);
                            }
                        }, new DialogInterface.OnClickListener() { // from class: com.baidu.mobads.container.bridge.BaseHtmlBridgeHandler.8
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                cloneIXAdInstanceInfo.setActionOnlyWifi(true);
                                cloneIXAdInstanceInfo.setSecondConfirmed(true);
                                BaseHtmlBridgeHandler.this.mBridgeListener.onAdClicked(cloneIXAdInstanceInfo);
                                BaseHtmlBridgeHandler.this.try2FireCustomizeTracking(cloneIXAdInstanceInfo, SDKLogTypeConstants.DZZB_ALERTDIALOG_NEGATIVE_CLICKED);
                                StateMachine.event(cloneIXAdInstanceInfo.getUniqueId(), AdStateCode.EVENT_CLICK);
                            }
                        });
                        try2FireCustomizeTracking(cloneIXAdInstanceInfo, SDKLogTypeConstants.DZZB_ALERTDIALOG);
                        return;
                    }
                }
            } catch (Exception e9) {
                e = e9;
                this.mAdLogger.d(e);
                this.mBridgeListener.onAdClicked(cloneIXAdInstanceInfo);
                StateMachine.event(cloneIXAdInstanceInfo.getUniqueId(), AdStateCode.EVENT_CLICK);
                jSONObject = new JSONObject(str);
                String optString8222 = jSONObject.optString(str3);
                if (jSONObject.optInt(str2) == 2) {
                }
            }
        } catch (Exception e10) {
            e = e10;
            str2 = "act";
            str3 = "pk";
        }
        this.mBridgeListener.onAdClicked(cloneIXAdInstanceInfo);
        StateMachine.event(cloneIXAdInstanceInfo.getUniqueId(), AdStateCode.EVENT_CLICK);
        try {
            jSONObject = new JSONObject(str);
            String optString82222 = jSONObject.optString(str3);
            if (jSONObject.optInt(str2) == 2) {
                String optString10 = jSONObject.optString("apo", "");
                if (!TextUtils.isEmpty(optString10)) {
                    String optString11 = new JSONObject(optString10).optString("page", "");
                    if (AdDownloadApkUtils.isInstalled(this.mAdContainerCxt.getAppContext(), optString82222)) {
                        if (!TextUtils.isEmpty(optString11)) {
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(optString11));
                            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                            if (this.mAdContainerCxt.getAppContext().getPackageManager().resolveActivity(intent, 65536) != null) {
                                this.mAdContainerCxt.getAppContext().startActivity(intent);
                                PackageUtils.sendDownloadAPOLog(this.mAdContainerCxt.getAppContext(), this.mAdContainerCxt, optString82222, optString11, PackageUtils.SOURCE_DONWLOAD_APO_HANDLECLICK_HTML);
                            }
                        }
                    } else {
                        PackageUtils.mPageMap.put(optString82222, optString11);
                    }
                }
            }
        } catch (Exception e11) {
            this.mAdLogger.d(e11);
        }
    }

    public void handleDownloadInfoClick(String str, CommandType commandType) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null || !(this.mBridgeListener instanceof PlayBridgeListener)) {
            return;
        }
        if (CommandType.DOWNLOAD_PRIVACY_CLICK == commandType) {
            String optString = jSONObject.optString("privacyUrl");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            ((PlayBridgeListener) this.mBridgeListener).handlePrivacyClick(optString);
        } else if (CommandType.DOWNLOAD_PERMISSION_CLICK == commandType) {
            String optString2 = jSONObject.optString("permissionUrl");
            if (TextUtils.isEmpty(optString2)) {
                return;
            }
            ((PlayBridgeListener) this.mBridgeListener).handlePermissionClick(optString2);
        }
    }

    public boolean handleShouldOverrideUrlLoading(Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        CommandType fromJavascriptString = CommandType.fromJavascriptString(uri.getHost());
        try {
            try {
                try {
                } catch (Throwable th) {
                    try {
                        fireNativeCommandCompleteEvent(fromJavascriptString);
                    } catch (Exception e2) {
                        this.mAdLogger.d(e2);
                    }
                    throw th;
                }
            } catch (Exception e3) {
                this.mAdLogger.d(e3);
                fireNativeCommandCompleteEvent(fromJavascriptString);
            }
        } catch (Exception e4) {
            this.mAdLogger.d(e4);
        }
        if (BridgeJavascript.BRIDGE_SCHEME.equals(scheme)) {
            runCommand(fromJavascriptString, uri);
            try {
                fireNativeCommandCompleteEvent(fromJavascriptString);
            } catch (Exception e5) {
                this.mAdLogger.d(e5);
            }
            return true;
        }
        fireNativeCommandCompleteEvent(fromJavascriptString);
        return false;
    }

    public void initWebViewEnvironment() {
        StringBuilder sb = new StringBuilder(BridgeJavascript.JAVASCRIPT_SOURCE_PREFIX);
        try {
            JSONObject confs = getConfs();
            if (confs != null) {
                String jSONObject = confs.toString();
                sb.append(BridgeJavascript.JAVASCRIPT_BRIDGE_PARAM);
                sb.append("=");
                sb.append(jSONObject);
                sb.append(";");
            }
        } catch (Exception e2) {
            this.mAdLogger.d(e2);
        }
        sb.append(BridgeJavascript.JAVASCRIPT_SOURCE_SUFFIX);
        afterJavaScriptBridgeInit(sb);
        this.mBaseJavascript = sb.toString();
        if ((this.mAdContainer instanceof XTemplateAdContainer) && !needInjectJSWhenPageFinished()) {
            executeJavaScript("javascript:(function() {\n    window.baidu = {};\n    window.baidu.mobads = {};\n    window.baidu.mobads.Sdk = {\n        isIOS: false\n    };\n    var Sdk = window.baidu.mobads.Sdk;\n    Sdk.isIOS = (/iphone|ipad|ipod/i).test(window.navigator.userAgent.toLowerCase());\n    var mob = window.baidu.mobads;\n    mob.Act = {\n        LP: 1,\n        DL: 2,\n        MAP: 4,\n        SMS: 8,\n        MAIL: 16,\n        PHONE: 32,\n        VIDEO: 64,\n        RM: 128,\n        NA: 256,\n        APO: 512\n    };\n    var win = window;\n    win.MobadsSdk = win.MobadsSdk || {};\n    var MobadsSdk = win.MobadsSdk;\n    var send3rdLog = function(isShowLog, ad) {\n        if (!ad || !ad.mon) {\n            return;\n        }\n        var url;\n        for (var i = 0; i < ad.mon.length; ++i) {\n            url = isShowLog ? ad.mon[i].s: ad.mon[i].c;\n            if (!url) {\n                continue;\n            }\n            new Image().src = url;\n        }\n    };\n    Sdk.setPrivacyActionUrl = function (jsonStr) {\n        var args = ['setPrivacyActionUrl',\n            'json', jsonStr\n        ];\n        MobadsSdk.setPrivacyActionUrl(JSON.stringify(args));\n    };\n    Sdk.setPermissionActionUrl = function (jsonStr) {\n        var args = ['setPermissionActionUrl',\n            'json', jsonStr\n        ];\n        MobadsSdk.setPermissionActionUrl(JSON.stringify(args));\n    };\n    Sdk.setActionUrl = function(url, inapp, act, title, close) {\n        var opt = {};\n        if (\"[object Object]\" === Object.prototype.toString.call(url)) {\n            opt = url;\n            url = opt.url;\n            inapp = opt.inapp;\n            act = opt.act;\n            title = opt.title;\n            close = opt.close;\n               if (opt.allParamsJson) {\n                   if (opt.allParamsJson.action) {\n                       opt.action = opt.allParamsJson.action;\n                       opt.v_video = opt.allParamsJson.v_video || \"\";\n                       opt.v_video_w = opt.allParamsJson.v_video_w || \"\";\n                       opt.v_video_h = opt.allParamsJson.v_video_h || \"\";\n                       opt.v_image = opt.allParamsJson.v_image || \"\";\n                       opt.v_url = opt.allParamsJson.v_url || \"\";\n                       opt.allParamsJson = null;\n                   }\n               }\n        }\n        opt.url = url || \"\";\n        opt.inapp = inapp || false;\n        opt.act = act || 1;\n        opt.title = title || \"\";\n        opt.close = close || false;\n        opt.logurl = opt.logurl || \"\";\n        opt.weibo = opt.weibo || \"\";\n        opt.map = opt.map || \"\";\n        opt.search = opt.search || \"\";\n        opt.sms = opt.sms || \"\";\n        opt.at = opt.at || 1;\n        opt.tid = opt.tid || \"\";\n        if (MobadsSdk.setActionUrl) {\n            var DUMP_PAR = opt.inapp;\n            MobadsSdk.setActionUrl(JSON.stringify(opt), DUMP_PAR)\n        }\n    };\n    Sdk.sendClickLog = function(logurl) {\n        new Image().src = logurl;\n    };\n    Sdk.onAdPlayEnd = function() {\n        if (MobadsSdk.onAdPlayEnd) {\n            setTimeout(function() {\n                MobadsSdk.onAdPlayEnd();\n            },\n            300);\n        }\n    };\n    Sdk.open = function(url, options) {\n        var option = {\n            url: url,\n            inapp: true,\n            act: mob.Act.LP,\n            allParamsJson: options\n        };\n        Sdk.setActionUrl(option);\n        send3rdLog(false, options);\n    };\n    Sdk.startDownload = function(url, options) {\n        var ad = {};\n        ad = options || {};\n        ad.tit = options && options.tit || options.appname || \"应用\";\n        var mobadsJumpUrl = url;\n        if (/^itms-services:\\/\\//.test(url)) {\n            Sdk.setActionUrl(url, false, mob.Act.DL, ad.tit, true);\n            return;\n        }\n        if (Sdk.isIOS) {\n            var tid = options && options.pinfo && options.pinfo.tid;\n            if (tid) {\n                Sdk.sendClickLog(mobadsJumpUrl);\n            }\n            Sdk.setActionUrl({\n                url: url,\n                tid: tid || \"\",\n                inapp: true,\n                act: mob.Act.DL\n            });\n            return;\n        }\n        var mon = options && options.mon || [];\n        var id = options && options.id || 1;\n        var pk = options && options.pk || \"\";\n        var qk = options && options.qk || \"\";\n        var exp2 = options && options.exp2 || {};\n        var apoObj = options && options.apo || {};\n        var wi = options && options.wi ? true: false;\n        var title = ad.tit;\n        Sdk.setActionUrl({\n            url: mobadsJumpUrl,\n            act: mob.Act.DL,\n            apo: JSON.stringify(apoObj),\n            close: true,\n            adid: id,\n            originUrl: mobadsJumpUrl,\n            dlTunnel: 3,\n            autoOpen: true,\n            popNotif: true,\n            canCancel: true,\n            canDelete: 5,\n            mon: mon,\n            pk: pk,\n            qk: qk,\n            adid: id,\n            title: ad.tit,\n            action: options.action,\n            allParamsJson: options \n        });\n        send3rdLog(false, options);\n    };\n    Sdk.openScheme = function(url, options) {\n        var ad = {};\n        ad = options || {};\n        ad.tit = options && options.tit || \"应用\";\n        var pk = options && options.pk || \"\";\n        var option = {\n            url: url,\n            inapp: true,\n            act: ad.act,\n            title: ad.tit,\n            close: true,\n            allParamsJson: options, \n            pk: pk\n        };\n        Sdk.setActionUrl(option);\n        send3rdLog(false, options);\n    };\n    Sdk.handleClick = function(options) {\n        var ad = options || {};\n        var Act = mob.Act;\n        if (Act.LP === ad.act) {\n            Sdk.open(ad.curl, ad);\n        } else if (Act.DL === ad.act) {\n            Sdk.startDownload(ad.curl, ad);\n        } else if (Act.APO === ad.act) {\n            new Image().src = ad.curl;\n            Sdk.openScheme(ad.apo, ad);\n        }\n    };\n    Sdk.onAdPlayEnd = function() {\n        if (MobadsSdk.onAdPlayEnd) {\n            MobadsSdk.onAdPlayEnd();\n        }\n    };\n    Sdk.needsAdIcon = function() {\n        return true;\n    };\n    Sdk.getAdViewState = function(callback) {\n        if (!MobadsSdk || !MobadsSdk.getAdViewState) {\n            callback('BaiduMobAdSpamOK');\n            return;\n        }\n        MobadsSdk.getAdViewState(MobadsSdk.addAnonymousEvent(function(state) {\n            var iState = parseInt(state);\n            var sState = 'BaiduMobAdSpamOK';\n            if (iState != 0) {\n                sState = 'BaiduMobAdSpamNotOK';\n            }\n            callback(sState);\n        }));\n    };\n})();");
        }
        if (needInjectJSWhenPageFinished()) {
            return;
        }
        executeJavaScript(this.mBaseJavascript);
    }

    public void injectJS() {
        if (needInjectJSWhenPageFinished()) {
            if (!TextUtils.isEmpty(this.mBaseJavascript)) {
                executeJavaScript(this.mBaseJavascript);
            }
            if (!TextUtils.isEmpty(this.mUpdateScript)) {
                injectUpdateStr(this.mUpdateScript);
                this.mUpdateScript = null;
            }
            if (this.mHasInjectPlacementType) {
                return;
            }
            executeJavaScript(String.format(BridgeJavascript.JS_SET_PLACEMENT_TYPE, this.mPlacementType.toJavascriptString()));
            this.mHasInjectPlacementType = true;
        }
    }

    public void injectUpdateStr(String str) {
        executeJavaScript("(function(){ var param=window.mobadssdkbridge.P;" + str + BridgeJavascript.JAVASCRIPT_SOURCE_SUFFIX);
    }

    public void installApp(String str) {
        Context appContext = this.mAdContainerCxt.getAppContext();
        String adProd = this.mAdContainerCxt.getAdProd();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("pk", null);
            RemoteXAdLogger remoteXAdLogger = this.mAdLogger;
            remoteXAdLogger.d("getAppStatus:" + str);
            try {
                SendLogUtil.Builder.create(appContext).appendType(PayBeanFactory.BEAN_ID_GET_WALLET_INTERFACE).appendProdType(adProd).appendAppSid(this.mAdContainerCxt.getAppsid()).appendApId(this.mAdContainerCxt.getAdPlacementId()).append("pk", optString != null ? optString : "").append("msg", RemoteCommonUtils.MSG_DOWNLOADED_OPEN_APP).sendWithVd();
            } catch (Exception unused) {
            }
            File file = new File(AdDownloadApkUtils.getApkFileLocalPath(appContext, optString));
            if (file.exists()) {
                AdDownloadApkUtils.installApp(appContext, optString, file, jSONObject.optBoolean(XAdRemoteAPKDownloadExtraInfo.AUTO_OPEN, false));
            }
            String optString2 = jSONObject.optString("apo", "");
            if (TextUtils.isEmpty(optString2)) {
                return;
            }
            String optString3 = new JSONObject(optString2).optString("page", "");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString3)) {
                return;
            }
            PackageUtils.mPageMap.put(optString, optString3);
        } catch (Exception e2) {
            this.mAdLogger.d(e2);
        }
    }

    public void intersAdPlayEnd() {
        executeJavaScript(BridgeJavascript.JS_ON_INTERS_BACK_FINISH);
    }

    public void intersShowAd() {
        executeJavaScript(BridgeJavascript.JS_INTER_PRESENT);
    }

    public boolean needInjectJSWhenPageFinished() {
        return Build.VERSION.SDK_INT >= 24 || CommonUtils.getTargetVersion(this.mAdContainerCxt.getAppContext()) >= 24;
    }

    public void notifySupports(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
    }

    public void notifyViewState(ViewState viewState) {
        executeJavaScript(String.format(BridgeJavascript.JS_SET_VIEW_STATE, viewState.toJavascriptString()));
    }

    public void notifyViewability(boolean z) {
    }

    public void openApp(String str) {
        Context appContext = this.mAdContainerCxt.getAppContext();
        String adProd = this.mAdContainerCxt.getAdProd();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("pk", "");
            RemoteXAdLogger remoteXAdLogger = this.mAdLogger;
            remoteXAdLogger.d("openApp:" + optString);
            try {
                SendLogUtil.Builder.create(appContext).appendType(PayBeanFactory.BEAN_ID_GET_WALLET_INTERFACE).appendProdType(adProd).appendAppSid(this.mAdContainerCxt.getAppsid()).appendApId(this.mAdContainerCxt.getAdPlacementId()).append("pk", optString).append("msg", RemoteCommonUtils.MSG_DOWNLOADED_OPEN_APP).sendWithVd();
            } catch (Exception unused) {
            }
            OpenAppUtils.openApp(appContext, optString);
            String optString2 = jSONObject.optString("apo", "");
            if (TextUtils.isEmpty(optString2)) {
                return;
            }
            String optString3 = new JSONObject(optString2).optString("page", "");
            if (TextUtils.isEmpty(optString3)) {
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(optString3));
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            if (appContext.getPackageManager().resolveActivity(intent, 65536) != null) {
                appContext.startActivity(intent);
                PackageUtils.sendDownloadAPOLog(appContext, this.mAdContainerCxt, optString, optString3, PackageUtils.SOURCE_DONWLOAD_APO_OPENAPP_HTML);
            }
        } catch (Exception e2) {
            this.mAdLogger.d(e2);
        }
    }

    public void pauseAd() {
        executeJavaScript(BridgeJavascript.JS_PAUSE);
    }

    public void playAd() {
        executeJavaScript(BridgeJavascript.JS_PLAY);
    }

    public void preLoadAd() {
        executeJavaScript(BridgeJavascript.JS_PRELOAD);
    }

    public void printLog(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("level", "");
            String optString2 = jSONObject.optString("msg", "");
            if (optString.equals("D")) {
                this.mAdLogger.d(optString2);
            } else if (optString.equals("I")) {
                this.mAdLogger.i(optString2);
            } else if (optString.equals("W")) {
                this.mAdLogger.w(optString2);
            } else if (optString.equals("E")) {
                this.mAdLogger.e(optString2);
            }
        } catch (Exception e2) {
            this.mAdLogger.d(e2);
        }
    }

    public void reloadAd() {
        executeJavaScript(BridgeJavascript.JS_REFRESH);
    }

    public void runCommand(CommandType commandType, Uri uri) throws Exception {
        final Context appContext = this.mAdContainerCxt.getAppContext();
        String queryParameter = uri.getQueryParameter("pkg");
        IDownloader adsApkDownloader = XAdRemoteCommonUtils.getAdsApkDownloader(queryParameter);
        final String queryParameter2 = uri.getQueryParameter("token");
        switch (AnonymousClass14.$SwitchMap$com$baidu$mobads$container$bridge$CommandType[commandType.ordinal()]) {
            case 1:
                int incrementAndGet = this.mCurrentAdSeq.incrementAndGet();
                this.mAdMap.put("" + incrementAndGet, "" + incrementAndGet);
                fireAnonymousEvent(queryParameter2, "" + incrementAndGet);
                return;
            case 2:
                this.mAdLogger.w("bridge.runCommand command is unspecified, detail = ", uri.getHost());
                return;
            case 3:
                if (adsApkDownloader != null) {
                    adsApkDownloader.setPausedManually(true);
                    adsApkDownloader.pause();
                    return;
                }
                return;
            case 4:
                JSONObject jSONObject = new JSONObject();
                if (AdDownloadApkUtils.isInstalled(appContext, queryParameter)) {
                    jSONObject.put("status", 103);
                    fire(queryParameter2, jSONObject.toString());
                    return;
                }
                String currentProcessName = ProcessUtils.getInstance().getCurrentProcessName(appContext);
                String string = appContext.getSharedPreferences(AdDownloadApkUtils.PKGS_PREF_DOWNLOAD, 0).getString(queryParameter + XAdRemoteAPKDownloadExtraInfo.KEY_SPLIT + currentProcessName, null);
                if (string != null) {
                    JSONObject jSONObject2 = new JSONObject(string);
                    int i2 = jSONObject2.getInt("dl");
                    IDownloader.DownloadStatus[] values = IDownloader.DownloadStatus.values();
                    IDownloader.DownloadStatus downloadStatus = IDownloader.DownloadStatus.NONE;
                    for (int i3 = 0; i3 < values.length; i3++) {
                        if (values[i3].getCode() == i2) {
                            downloadStatus = values[i3];
                        }
                    }
                    if (downloadStatus == IDownloader.DownloadStatus.COMPLETED) {
                        if (RemoteCommonUtils.isLocalFileExist(jSONObject2)) {
                            jSONObject.put("status", 102);
                        } else {
                            jSONObject.put("status", 105);
                        }
                        fire(queryParameter2, jSONObject.toString());
                        return;
                    }
                }
                if (adsApkDownloader != null) {
                    IDownloader.DownloadStatus state = adsApkDownloader.getState();
                    jSONObject.put("status", (int) adsApkDownloader.getProgress());
                    if (state == IDownloader.DownloadStatus.PAUSED) {
                        jSONObject.put("isPaused", 1);
                    } else {
                        jSONObject.put("isPaused", 0);
                    }
                    fire(queryParameter2, jSONObject.toString());
                    return;
                }
                jSONObject.put("status", 101);
                fire(queryParameter2, jSONObject.toString());
                return;
            case 5:
                handleConfirm(uri.getQueryParameter("json"), queryParameter2);
                return;
            case 6:
                fireAnonymousEvent(queryParameter2, NetworkInfoUtils.getNetworkType(appContext));
                return;
            case 7:
                fireAnonymousEvent(queryParameter2, getAdViewState() + "");
                return;
            case 8:
                String queryParameter3 = uri.getQueryParameter("json");
                fireAnonymousEvent(queryParameter2, getAppStatus(queryParameter3) + "");
                return;
            case 9:
            case 23:
            case 26:
            case 28:
            case 30:
            case 31:
            case 32:
            default:
                return;
            case 10:
                TaskScheduler.getInstance().submit(new BaseTask() { // from class: com.baidu.mobads.container.bridge.BaseHtmlBridgeHandler.2
                    @Override // com.baidu.mobads.container.executor.BaseTask
                    public Object doInBackground() {
                        try {
                            BaseHtmlBridgeHandler.this.fireAnonymousEvent(queryParameter2, PackageUtils.getCurrentApp(appContext).toString());
                            return null;
                        } catch (Exception unused) {
                            return null;
                        }
                    }
                }, 1);
                return;
            case 11:
                TaskScheduler.getInstance().submit(new BaseTask() { // from class: com.baidu.mobads.container.bridge.BaseHtmlBridgeHandler.3
                    @Override // com.baidu.mobads.container.executor.BaseTask
                    public Object doInBackground() {
                        try {
                            BaseHtmlBridgeHandler.this.fireAnonymousEvent(queryParameter2, PackageUtils.getInstalled(appContext).toString());
                            return null;
                        } catch (Exception unused) {
                            return null;
                        }
                    }
                }, 1);
                return;
            case 12:
                TaskScheduler.getInstance().submit(new BaseTask() { // from class: com.baidu.mobads.container.bridge.BaseHtmlBridgeHandler.4
                    @Override // com.baidu.mobads.container.executor.BaseTask
                    public Object doInBackground() {
                        try {
                            BaseHtmlBridgeHandler.this.fireAnonymousEvent(queryParameter2, PackageUtils.getRecentAll(appContext).toString());
                            return null;
                        } catch (Exception unused) {
                            return null;
                        }
                    }
                }, 1);
                return;
            case 13:
                TaskScheduler.getInstance().submit(new BaseTask() { // from class: com.baidu.mobads.container.bridge.BaseHtmlBridgeHandler.5
                    @Override // com.baidu.mobads.container.executor.BaseTask
                    public Object doInBackground() {
                        try {
                            BaseHtmlBridgeHandler.this.fireAnonymousEvent(queryParameter2, PackageUtils.getRecentDiff(appContext).toString());
                            return null;
                        } catch (Exception unused) {
                            return null;
                        }
                    }
                }, 1);
                return;
            case 14:
                TaskScheduler.getInstance().submit(new BaseTask() { // from class: com.baidu.mobads.container.bridge.BaseHtmlBridgeHandler.6
                    @Override // com.baidu.mobads.container.executor.BaseTask
                    public Object doInBackground() {
                        try {
                            BaseHtmlBridgeHandler.this.fireAnonymousEvent(queryParameter2, PackageUtils.getSysInstalled(appContext).toString());
                            return null;
                        } catch (Exception unused) {
                            return null;
                        }
                    }
                }, 1);
                return;
            case 15:
                fireAnonymousEvent(queryParameter2, getWifiScans());
                return;
            case 16:
                String queryParameter4 = uri.getQueryParameter("json");
                fireAnonymousEvent(queryParameter2, getVersionCodeByPkg(queryParameter4) + "");
                return;
            case 17:
                installApp(uri.getQueryParameter("json"));
                return;
            case 18:
                this.mBridgeListener.onAdFailed("");
                return;
            case 19:
                this.mBridgeListener.onAdShow();
                return;
            case 20:
                this.mBridgeListener.onAdSwitch();
                return;
            case 21:
                this.mBridgeListener.onInited();
                return;
            case 22:
                openApp(uri.getQueryParameter("json"));
                return;
            case 24:
                printLog(uri.getQueryParameter("json"));
                return;
            case 25:
                setAppTip(new JSONObject(uri.getQueryParameter("json")).getString("msg"));
                return;
            case 27:
                handleClick(uri.getQueryParameter("json"));
                return;
            case 29:
                getBridgeListener().setVisibility(new JSONObject(uri.getQueryParameter("json")).getInt("visibility"));
                return;
            case 33:
                if ("int".equals(this.mAdContainerCxt.getAdProd())) {
                    this.mAdLogger.d("bridge.runCommand command is expand, but it is an interstitial prod already");
                    return;
                }
                JSONObject jSONObject3 = new JSONObject(uri.getQueryParameter("json"));
                boolean optBoolean = jSONObject3.optBoolean("shouldUseCustomClose");
                String optString = jSONObject3.optString("url");
                if (optString == null || optString.equals("")) {
                    this.mBridgeListener.onExpand(optBoolean);
                    return;
                }
                return;
            case 34:
                getBridgeListener().onUseCustomClose(new JSONObject(uri.getQueryParameter("json")).optBoolean("shouldUseCustomClose"));
                return;
            case 35:
                this.mAdContainerCxt.getEventDispatcher().dispatchEvent(new XAdRemoteEvent("AdStopped"));
                getBridgeListener().onClose();
                return;
            case 36:
                this.mAdContainer.closeExpand();
                return;
            case 37:
                BridgeListener bridgeListener = this.mBridgeListener;
                if (bridgeListener instanceof PlayBridgeListener) {
                    ((PlayBridgeListener) bridgeListener).handlePlayClick();
                    return;
                }
                return;
            case 38:
                handleDownloadInfoClick(uri.getQueryParameter("json"), CommandType.DOWNLOAD_PRIVACY_CLICK);
                return;
            case 39:
                handleDownloadInfoClick(uri.getQueryParameter("json"), CommandType.DOWNLOAD_PERMISSION_CLICK);
                return;
        }
    }

    public void setAppTip(final String str) {
        this.mMainHandler.post(new Runnable() { // from class: com.baidu.mobads.container.bridge.BaseHtmlBridgeHandler.9
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(BaseHtmlBridgeHandler.this.mAdContainerCxt.getAppContext(), str, 1).show();
            }
        });
    }

    public void setBridgeListener(BridgeListener bridgeListener) {
        this.mBridgeListener = bridgeListener;
    }

    public void setMainHandler(Handler handler) {
        this.mMainHandler = handler;
    }

    public void setPlacementType(PlacementType placementType) {
        try {
            this.mPlacementType = placementType;
            if (needInjectJSWhenPageFinished()) {
                return;
            }
            executeJavaScript(String.format(BridgeJavascript.JS_SET_PLACEMENT_TYPE, placementType.toJavascriptString()));
            this.mHasInjectPlacementType = true;
        } catch (Exception e2) {
            this.mAdLogger.d(e2);
        }
    }

    public void setWebView(WebView webView) {
        this.mWebView = webView;
    }

    public void updateBridgeParams(String str) {
        if (needInjectJSWhenPageFinished()) {
            this.mUpdateScript = str;
        } else {
            injectUpdateStr(str);
        }
    }
}
