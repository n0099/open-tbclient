package com.baidu.mobads.container.landingpage;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.XAdInstanceInfoExt;
import com.baidu.mobads.container.XAdRemoteCommonUtils;
import com.baidu.mobads.container.XMyWebView;
import com.baidu.mobads.container.bridge.BridgeJavascript;
import com.baidu.mobads.container.bridge.CommandType;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.components.downloader.IDownloader;
import com.baidu.mobads.container.util.AdDownloadApkUtils;
import com.baidu.mobads.container.util.EncryptUtils;
import com.baidu.mobads.container.util.ProcessUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class XDLJsInterface {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String JAVASCRIPT_PREFIX = "javascript:";
    public static final String JS_NAT_FIRE_EVENT = "javascript:(function(){baidu.mobads.Sdk.natFireEvent('%s', '%s')})()";
    public static final String TAG = "DLJsInterface";
    public transient /* synthetic */ FieldHolder $fh;
    public Context context;
    public RemoteXAdLogger mAdLogger;
    public String mAppsid;
    public Handler mMainHandler;
    public XMyWebView mWebView;

    /* renamed from: com.baidu.mobads.container.landingpage.XDLJsInterface$4  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$mobads$container$bridge$CommandType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(375031859, "Lcom/baidu/mobads/container/landingpage/XDLJsInterface$4;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(375031859, "Lcom/baidu/mobads/container/landingpage/XDLJsInterface$4;");
                    return;
                }
            }
            int[] iArr = new int[CommandType.values().length];
            $SwitchMap$com$baidu$mobads$container$bridge$CommandType = iArr;
            try {
                iArr[CommandType.PAUSE_DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.GET_DOWNLOAD_STATUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$mobads$container$bridge$CommandType[CommandType.SET_ACTION_URL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public XDLJsInterface(XMyWebView xMyWebView, Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xMyWebView, context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAdLogger = RemoteXAdLogger.getInstance();
        this.context = context.getApplicationContext();
        this.mWebView = xMyWebView;
        this.mAppsid = str;
        this.mMainHandler = new Handler(Looper.getMainLooper());
    }

    private void fireNativeCommandCompleteEvent(CommandType commandType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, commandType) == null) {
            executeJavaScript("window.mobadssdkbridge.nativeCallComplete(" + JSONObject.quote(commandType.toJavascriptString()) + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00ee A[Catch: Exception -> 0x0150, TryCatch #0 {Exception -> 0x0150, blocks: (B:5:0x0014, B:8:0x0044, B:37:0x00e8, B:39:0x00ee, B:40:0x00f2, B:36:0x00df), top: B:49:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleclickdl(String str) {
        JSONObject jSONObject;
        String optString;
        String optString2;
        String optString3;
        String optString4;
        int optInt;
        int optInt2;
        String str2;
        JSONObject jSONObject2;
        int i2;
        String str3;
        String str4;
        JSONObject jSONObject3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, str) == null) {
            XAdInstanceInfoExt xAdInstanceInfoExt = new XAdInstanceInfoExt(new JSONObject());
            try {
                jSONObject = new JSONObject(str);
                optString = jSONObject.optString("url");
                optString2 = jSONObject.optString("pk");
                optString3 = jSONObject.optString(XAdRemoteAPKDownloadExtraInfo.ADID);
                optString4 = jSONObject.optString("originUrl");
                optInt = jSONObject.optInt(XAdRemoteAPKDownloadExtraInfo.DL_TUNNEL);
                optInt2 = jSONObject.optInt("act");
            } catch (Exception e2) {
                this.mAdLogger.d(e2);
            }
            if (optInt2 != 2) {
                return;
            }
            boolean optBoolean = jSONObject.optBoolean("inapp", true);
            boolean optBoolean2 = jSONObject.optBoolean(IntentConfig.CLOSE);
            boolean optBoolean3 = jSONObject.optBoolean(XAdRemoteAPKDownloadExtraInfo.AUTO_OPEN);
            boolean optBoolean4 = jSONObject.optBoolean("popNotif");
            boolean optBoolean5 = jSONObject.optBoolean("isWifiTargeted");
            boolean optBoolean6 = jSONObject.optBoolean("isTooLarge");
            boolean optBoolean7 = jSONObject.optBoolean("canCancel");
            boolean optBoolean8 = jSONObject.optBoolean("canDelete");
            boolean optBoolean9 = jSONObject.optBoolean("secondConfirmed");
            String optString5 = jSONObject.optString(XAdRemoteAPKDownloadExtraInfo.QK);
            try {
                String optString6 = jSONObject.optString("adJson", "");
                if (optString6.length() > 0) {
                    str2 = "";
                    try {
                        jSONObject3 = new JSONObject(optString6);
                        jSONObject2 = jSONObject;
                    } catch (Exception e3) {
                        e = e3;
                        jSONObject2 = jSONObject;
                    }
                    try {
                        i2 = jSONObject3.optInt("sz", 0);
                    } catch (Exception e4) {
                        e = e4;
                        i2 = 0;
                        try {
                            this.mAdLogger.d(e);
                            str4 = str2;
                            str3 = optString5;
                        } catch (Exception e5) {
                            e = e5;
                            this.mAdLogger.d(e);
                            str3 = optString5;
                            str4 = str2;
                            if (TextUtils.isEmpty(optString2)) {
                            }
                            xAdInstanceInfoExt.setClickThroughUrl(optString);
                            xAdInstanceInfoExt.setAppPackageName(optString2);
                            xAdInstanceInfoExt.setAdId(optString3);
                            xAdInstanceInfoExt.setOriginClickUrl(optString4);
                            xAdInstanceInfoExt.setDlTunnel(optInt);
                            xAdInstanceInfoExt.setActionType(optInt2);
                            xAdInstanceInfoExt.setInapp(optBoolean);
                            xAdInstanceInfoExt.setClose(optBoolean2);
                            xAdInstanceInfoExt.setAutoOpen(optBoolean3);
                            xAdInstanceInfoExt.setPopNotif(optBoolean4);
                            xAdInstanceInfoExt.setWifiTargeted(optBoolean5);
                            xAdInstanceInfoExt.setTooLarge(optBoolean6);
                            xAdInstanceInfoExt.setCanCancel(optBoolean7);
                            xAdInstanceInfoExt.setCanDelete(optBoolean8);
                            xAdInstanceInfoExt.setQueryKey(str3);
                            xAdInstanceInfoExt.setAppSize(i2);
                            xAdInstanceInfoExt.setAppName(str4);
                            xAdInstanceInfoExt.setSecondConfirmed(optBoolean9);
                            String str5 = str2;
                            xAdInstanceInfoExt.setTitle(jSONObject2.optString("title", str5).replace(StringUtil.ARRAY_START, str5).replace("}", str5));
                            XAdRemoteCommonUtils.downloadApp(this.context, this.mAppsid, xAdInstanceInfoExt, null, "lp_js_interface", true);
                        }
                        if (TextUtils.isEmpty(optString2)) {
                        }
                        xAdInstanceInfoExt.setClickThroughUrl(optString);
                        xAdInstanceInfoExt.setAppPackageName(optString2);
                        xAdInstanceInfoExt.setAdId(optString3);
                        xAdInstanceInfoExt.setOriginClickUrl(optString4);
                        xAdInstanceInfoExt.setDlTunnel(optInt);
                        xAdInstanceInfoExt.setActionType(optInt2);
                        xAdInstanceInfoExt.setInapp(optBoolean);
                        xAdInstanceInfoExt.setClose(optBoolean2);
                        xAdInstanceInfoExt.setAutoOpen(optBoolean3);
                        xAdInstanceInfoExt.setPopNotif(optBoolean4);
                        xAdInstanceInfoExt.setWifiTargeted(optBoolean5);
                        xAdInstanceInfoExt.setTooLarge(optBoolean6);
                        xAdInstanceInfoExt.setCanCancel(optBoolean7);
                        xAdInstanceInfoExt.setCanDelete(optBoolean8);
                        xAdInstanceInfoExt.setQueryKey(str3);
                        xAdInstanceInfoExt.setAppSize(i2);
                        xAdInstanceInfoExt.setAppName(str4);
                        xAdInstanceInfoExt.setSecondConfirmed(optBoolean9);
                        String str52 = str2;
                        xAdInstanceInfoExt.setTitle(jSONObject2.optString("title", str52).replace(StringUtil.ARRAY_START, str52).replace("}", str52));
                        XAdRemoteCommonUtils.downloadApp(this.context, this.mAppsid, xAdInstanceInfoExt, null, "lp_js_interface", true);
                    }
                    try {
                        String optString7 = jSONObject3.optString(XAdRemoteAPKDownloadExtraInfo.QK);
                        if (!TextUtils.isEmpty(optString7)) {
                            optString5 = optString7;
                        }
                        str4 = jSONObject3.optString("appname");
                    } catch (Exception e6) {
                        e = e6;
                        this.mAdLogger.d(e);
                        str4 = str2;
                        str3 = optString5;
                        if (TextUtils.isEmpty(optString2)) {
                        }
                        xAdInstanceInfoExt.setClickThroughUrl(optString);
                        xAdInstanceInfoExt.setAppPackageName(optString2);
                        xAdInstanceInfoExt.setAdId(optString3);
                        xAdInstanceInfoExt.setOriginClickUrl(optString4);
                        xAdInstanceInfoExt.setDlTunnel(optInt);
                        xAdInstanceInfoExt.setActionType(optInt2);
                        xAdInstanceInfoExt.setInapp(optBoolean);
                        xAdInstanceInfoExt.setClose(optBoolean2);
                        xAdInstanceInfoExt.setAutoOpen(optBoolean3);
                        xAdInstanceInfoExt.setPopNotif(optBoolean4);
                        xAdInstanceInfoExt.setWifiTargeted(optBoolean5);
                        xAdInstanceInfoExt.setTooLarge(optBoolean6);
                        xAdInstanceInfoExt.setCanCancel(optBoolean7);
                        xAdInstanceInfoExt.setCanDelete(optBoolean8);
                        xAdInstanceInfoExt.setQueryKey(str3);
                        xAdInstanceInfoExt.setAppSize(i2);
                        xAdInstanceInfoExt.setAppName(str4);
                        xAdInstanceInfoExt.setSecondConfirmed(optBoolean9);
                        String str522 = str2;
                        xAdInstanceInfoExt.setTitle(jSONObject2.optString("title", str522).replace(StringUtil.ARRAY_START, str522).replace("}", str522));
                        XAdRemoteCommonUtils.downloadApp(this.context, this.mAppsid, xAdInstanceInfoExt, null, "lp_js_interface", true);
                    }
                } else {
                    str2 = "";
                    jSONObject2 = jSONObject;
                    str4 = str2;
                    i2 = 0;
                }
                str3 = optString5;
            } catch (Exception e7) {
                e = e7;
                str2 = "";
                jSONObject2 = jSONObject;
                i2 = 0;
            }
            if (TextUtils.isEmpty(optString2)) {
                optString2 = EncryptUtils.getMD5(optString);
            }
            xAdInstanceInfoExt.setClickThroughUrl(optString);
            xAdInstanceInfoExt.setAppPackageName(optString2);
            xAdInstanceInfoExt.setAdId(optString3);
            xAdInstanceInfoExt.setOriginClickUrl(optString4);
            xAdInstanceInfoExt.setDlTunnel(optInt);
            xAdInstanceInfoExt.setActionType(optInt2);
            xAdInstanceInfoExt.setInapp(optBoolean);
            xAdInstanceInfoExt.setClose(optBoolean2);
            xAdInstanceInfoExt.setAutoOpen(optBoolean3);
            xAdInstanceInfoExt.setPopNotif(optBoolean4);
            xAdInstanceInfoExt.setWifiTargeted(optBoolean5);
            xAdInstanceInfoExt.setTooLarge(optBoolean6);
            xAdInstanceInfoExt.setCanCancel(optBoolean7);
            xAdInstanceInfoExt.setCanDelete(optBoolean8);
            xAdInstanceInfoExt.setQueryKey(str3);
            xAdInstanceInfoExt.setAppSize(i2);
            xAdInstanceInfoExt.setAppName(str4);
            xAdInstanceInfoExt.setSecondConfirmed(optBoolean9);
            String str5222 = str2;
            xAdInstanceInfoExt.setTitle(jSONObject2.optString("title", str5222).replace(StringUtil.ARRAY_START, str5222).replace("}", str5222));
            XAdRemoteCommonUtils.downloadApp(this.context, this.mAppsid, xAdInstanceInfoExt, null, "lp_js_interface", true);
        }
    }

    private String string2jsParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) ? str.replace("'", "\\'").replace("\"", "\\\"") : (String) invokeL.objValue;
    }

    public void executeJavaScript(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (this.mWebView != null) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    try {
                        if (!str.startsWith("javascript:")) {
                            str = "javascript:" + str;
                        }
                        if (Build.VERSION.SDK_INT < 19) {
                            this.mWebView.loadUrl(str);
                            return;
                        } else {
                            this.mWebView.evaluateJavascript(str, new ValueCallback<String>(this) { // from class: com.baidu.mobads.container.landingpage.XDLJsInterface.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ XDLJsInterface this$0;

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
                        RemoteXAdLogger.getInstance().w(e2);
                        return;
                    }
                }
                this.mMainHandler.post(new Runnable(this, str) { // from class: com.baidu.mobads.container.landingpage.XDLJsInterface.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ XDLJsInterface this$0;
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
            RemoteXAdLogger.getInstance().i("webview is null");
        }
    }

    public void fireEvent(String str, String str2) {
        Handler handler;
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || str == null) {
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        try {
            try {
                String string2jsParam = string2jsParam(str2);
                handler = this.mWebView.getHandler();
                runnable = new Runnable(this, str, string2jsParam) { // from class: com.baidu.mobads.container.landingpage.XDLJsInterface.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ XDLJsInterface this$0;
                    public final /* synthetic */ String val$pRes;
                    public final /* synthetic */ String val$token;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, string2jsParam};
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
                        this.val$token = str;
                        this.val$pRes = string2jsParam;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                this.this$0.mWebView.loadUrl(String.format(XDLJsInterface.JS_NAT_FIRE_EVENT, this.val$token, this.val$pRes));
                            } catch (Exception e2) {
                                RemoteXAdLogger.getInstance().d(XDLJsInterface.TAG, e2.getMessage());
                            }
                        }
                    }
                };
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().d(TAG, e2.getMessage());
                handler = this.mWebView.getHandler();
                runnable = new Runnable(this, str, str2) { // from class: com.baidu.mobads.container.landingpage.XDLJsInterface.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ XDLJsInterface this$0;
                    public final /* synthetic */ String val$pRes;
                    public final /* synthetic */ String val$token;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = objArr;
                            Object[] objArr = {this, str, str2};
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
                        this.val$token = str;
                        this.val$pRes = str2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                this.this$0.mWebView.loadUrl(String.format(XDLJsInterface.JS_NAT_FIRE_EVENT, this.val$token, this.val$pRes));
                            } catch (Exception e22) {
                                RemoteXAdLogger.getInstance().d(XDLJsInterface.TAG, e22.getMessage());
                            }
                        }
                    }
                };
            }
            handler.post(runnable);
        } catch (Throwable th) {
            this.mWebView.getHandler().post(new Runnable(this, str, str2) { // from class: com.baidu.mobads.container.landingpage.XDLJsInterface.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ XDLJsInterface this$0;
                public final /* synthetic */ String val$pRes;
                public final /* synthetic */ String val$token;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = objArr;
                        Object[] objArr = {this, str, str2};
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
                    this.val$token = str;
                    this.val$pRes = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.this$0.mWebView.loadUrl(String.format(XDLJsInterface.JS_NAT_FIRE_EVENT, this.val$token, this.val$pRes));
                        } catch (Exception e22) {
                            RemoteXAdLogger.getInstance().d(XDLJsInterface.TAG, e22.getMessage());
                        }
                    }
                }
            });
            throw th;
        }
    }

    public void getDownloadStatus(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (AdDownloadApkUtils.isInstalled(this.context, str2)) {
                    jSONObject.put("status", 103);
                    fireEvent(str, jSONObject.toString());
                    return;
                }
                String currentProcessName = ProcessUtils.getInstance().getCurrentProcessName(this.context);
                SharedPreferences sharedPreferences = this.context.getSharedPreferences(AdDownloadApkUtils.PKGS_PREF_DOWNLOAD, 0);
                String string = sharedPreferences.getString(str2 + XAdRemoteAPKDownloadExtraInfo.KEY_SPLIT + currentProcessName, null);
                if (string != null) {
                    int i2 = new JSONObject(string).getInt("dl");
                    IDownloader.DownloadStatus[] values = IDownloader.DownloadStatus.values();
                    IDownloader.DownloadStatus downloadStatus = IDownloader.DownloadStatus.NONE;
                    for (int i3 = 0; i3 < values.length; i3++) {
                        if (values[i3].getCode() == i2) {
                            downloadStatus = values[i3];
                        }
                    }
                    if (downloadStatus == IDownloader.DownloadStatus.COMPLETED) {
                        jSONObject.put("status", 102);
                        fireEvent(str, jSONObject.toString());
                        return;
                    }
                }
                IDownloader adsApkDownloader = XAdRemoteCommonUtils.getAdsApkDownloader(str2);
                if (adsApkDownloader != null) {
                    IDownloader.DownloadStatus state = adsApkDownloader.getState();
                    jSONObject.put("status", (int) adsApkDownloader.getProgress());
                    if (state == IDownloader.DownloadStatus.PAUSED) {
                        jSONObject.put("isPaused", 1);
                    } else {
                        jSONObject.put("isPaused", 0);
                    }
                    if (state == IDownloader.DownloadStatus.ERROR) {
                        jSONObject.put("status", 104);
                    }
                    fireEvent(str, jSONObject.toString());
                    return;
                }
                jSONObject.put("status", 101);
                fireEvent(str, jSONObject.toString());
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().d(TAG, e2.getMessage());
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    public boolean handleShouldOverrideUrlLoading(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, uri)) == null) {
            if (uri == null) {
                return false;
            }
            String scheme = uri.getScheme();
            CommandType fromJavascriptString = CommandType.fromJavascriptString(uri.getHost());
            try {
                try {
                    try {
                    } catch (Exception e2) {
                        RemoteXAdLogger.getInstance().w(e2);
                        fireNativeCommandCompleteEvent(fromJavascriptString);
                    }
                } catch (Throwable th) {
                    try {
                        fireNativeCommandCompleteEvent(fromJavascriptString);
                    } catch (Exception e3) {
                        RemoteXAdLogger.getInstance().d(e3);
                    }
                    throw th;
                }
            } catch (Exception e4) {
                RemoteXAdLogger.getInstance().d(e4);
            }
            if (BridgeJavascript.BRIDGE_SCHEME.equals(scheme)) {
                runCommand(fromJavascriptString, uri);
                try {
                    fireNativeCommandCompleteEvent(fromJavascriptString);
                } catch (Exception e5) {
                    RemoteXAdLogger.getInstance().d(e5);
                }
                return true;
            }
            fireNativeCommandCompleteEvent(fromJavascriptString);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void runCommand(CommandType commandType, Uri uri) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, commandType, uri) == null) {
            String queryParameter = uri.getQueryParameter("pkg");
            IDownloader adsApkDownloader = XAdRemoteCommonUtils.getAdsApkDownloader(queryParameter);
            String queryParameter2 = uri.getQueryParameter("token");
            int i2 = AnonymousClass4.$SwitchMap$com$baidu$mobads$container$bridge$CommandType[commandType.ordinal()];
            if (i2 == 1) {
                if (adsApkDownloader != null) {
                    adsApkDownloader.setPausedManually(true);
                    adsApkDownloader.pause();
                }
            } else if (i2 == 2) {
                getDownloadStatus(queryParameter2, queryParameter);
            } else if (i2 != 3) {
            } else {
                handleclickdl(uri.getQueryParameter("json"));
            }
        }
    }
}
