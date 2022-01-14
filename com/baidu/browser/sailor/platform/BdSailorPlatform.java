package com.baidu.browser.sailor.platform;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.core.BdCore;
import com.baidu.browser.core.INoProGuard;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.BdSailorConfig;
import com.baidu.browser.sailor.feature.upload.BdUploadFeature;
import com.baidu.browser.sailor.webkit.loader.BdWebkitManager;
import com.baidu.browser.sailor.webkit.update.BdZeusUpdate;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.blink.EngineManager;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.CookieSyncManager;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebChromeClient;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.dumper.CrashCallback;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes10.dex */
public final class BdSailorPlatform implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int APP_STATE_BACKGROUND = 0;
    public static final int APP_STATE_FOREGROUND = 1;
    public static final String ERROR_PAGE_ASSET = "webkit/errorpage/flyflow_error_page.html";
    public static final String LITE_PACKAGE_NAME = "com.baidu.searchbox.lite";
    public static final int MSG_PAUSER_WEBKIT_TIMER = 1;
    public static final int PAUSER_WEBKIT_TIMER_DELAY_TIME = 2000;
    public static final String SAILOR_MODULE_NAME = "sailor";
    public static final String TAG = "com.baidu.browser.sailor.platform.BdSailorPlatform";
    public static SoftReference<String> sErrorPageContent;
    public static BdSailorPlatform sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public Handler mHandler;
    public boolean mHasInit;
    public boolean mIsEnableJavaScriptOnFileScheme;
    public boolean mIsNeedUpdateKernel;
    public boolean mIsWebkitInited;
    public boolean mNeedFix;
    public b mNetworkChangedReciever;
    public int mNetworkType;
    public HashMap<String, com.baidu.browser.sailor.feature.a> mSailorFeatureMap;
    public c.a.k.b.b.b.a mSailorStatic;
    public BdWebkitManager mWebkitMgr;
    public boolean mWebkitTimerPaused;
    public String mWorkspace;

    /* loaded from: classes10.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdSailorPlatform a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BdSailorPlatform bdSailorPlatform, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSailorPlatform, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdSailorPlatform;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1 && this.a.mContext != null) {
                BdSailorPlatform bdSailorPlatform = this.a;
                if (bdSailorPlatform.isAppOnForeground(bdSailorPlatform.mContext)) {
                    return;
                }
                try {
                    Log.d(BdSailorPlatform.TAG, "do pause");
                    this.a.mWebkitTimerPaused = c.a.k.b.d.a.a().c();
                    CookieSyncManager createInstance = CookieSyncManager.createInstance(this.a.mContext);
                    if (createInstance != null) {
                        createInstance.stopSync();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdSailorPlatform a;

        public b(BdSailorPlatform bdSailorPlatform) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdSailorPlatform};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdSailorPlatform;
        }

        public /* synthetic */ b(BdSailorPlatform bdSailorPlatform, byte b2) {
            this(bdSailorPlatform);
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String action;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && (action = intent.getAction()) != null && action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                BdSailor.getInstance().onNetworkChanged(((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-587795332, "Lcom/baidu/browser/sailor/platform/BdSailorPlatform;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-587795332, "Lcom/baidu/browser/sailor/platform/BdSailorPlatform;");
        }
    }

    public BdSailorPlatform() {
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
        this.mNeedFix = true;
        this.mIsWebkitInited = false;
        this.mIsEnableJavaScriptOnFileScheme = false;
        this.mWebkitTimerPaused = false;
        this.mNetworkType = -1;
        this.mHasInit = false;
        this.mIsNeedUpdateKernel = true;
        Log.d(TAG, "BdSailorPlatform");
        this.mSailorStatic = new c.a.k.b.b.b.a();
        this.mWebkitMgr = new BdWebkitManager();
        this.mSailorFeatureMap = new HashMap<>(4);
    }

    public static void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            BdSailorPlatform bdSailorPlatform = sInstance;
            if (bdSailorPlatform != null) {
                bdSailorPlatform.doDestroy();
            }
            sInstance = null;
        }
    }

    private boolean doInitWorkspace(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1);
            }
            new File(str).mkdirs();
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String getDefaultErrorPageHtml(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) ? "<html></html>" : (String) invokeL.objValue;
    }

    public static synchronized BdSailorPlatform getInstance() {
        InterceptResult invokeV;
        BdSailorPlatform bdSailorPlatform;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            synchronized (BdSailorPlatform.class) {
                if (sInstance == null) {
                    sInstance = new BdSailorPlatform();
                }
                bdSailorPlatform = sInstance;
            }
            return bdSailorPlatform;
        }
        return (BdSailorPlatform) invokeV.objValue;
    }

    public static c.a.k.b.b.b.a getStatic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? getInstance().mSailorStatic : (c.a.k.b.b.b.a) invokeV.objValue;
    }

    public static BdWebkitManager getWebkitManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? getInstance().mWebkitMgr : (BdWebkitManager) invokeV.objValue;
    }

    public static void initCookieSyncManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            CookieSyncManager.createInstance(context);
        }
    }

    private void initFeature(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, this, context) == null) || this.mHasInit) {
            return;
        }
        registerFeature(new BdUploadFeature(context));
        this.mHasInit = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAppOnForeground(Context context) {
        InterceptResult invokeL;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, context)) == null) {
            if (context == null) {
                return false;
            }
            try {
                runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            } catch (Exception e2) {
                Log.e(TAG, "isAppOnForeground exception");
                e2.printStackTrace();
            }
            if (runningAppProcesses == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                    if (runningAppProcessInfo.importance == 100) {
                        Log.d(TAG, "app is in foreground");
                        return true;
                    }
                    Log.d(TAG, "app is in background");
                    return false;
                }
            }
            Log.d(TAG, "app is in background 1");
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean onShowFileChooser(Activity activity, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, activity, valueCallback, fileChooserParams)) == null) {
            com.baidu.browser.sailor.feature.a featureByName = getInstance().getFeatureByName(BdSailorConfig.SAILOR_BASE_UPLOAD);
            if (featureByName == null || !featureByName.isEnable()) {
                valueCallback.onReceiveValue(null);
                return false;
            }
            BdUploadFeature bdUploadFeature = (BdUploadFeature) featureByName;
            if (bdUploadFeature == null || activity == null) {
                return false;
            }
            return bdUploadFeature.openFileChooser(activity, valueCallback, fileChooserParams);
        }
        return invokeLLL.booleanValue;
    }

    public static boolean openFileChooser(Activity activity, ValueCallback<Uri> valueCallback) {
        InterceptResult invokeLL;
        BdUploadFeature bdUploadFeature;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, activity, valueCallback)) == null) {
            com.baidu.browser.sailor.feature.a featureByName = getInstance().getFeatureByName(BdSailorConfig.SAILOR_BASE_UPLOAD);
            if (featureByName == null || !featureByName.isEnable() || (bdUploadFeature = (BdUploadFeature) featureByName) == null || activity == null) {
                valueCallback.onReceiveValue(null);
                return false;
            }
            return bdUploadFeature.openFileChooser(activity, valueCallback);
        }
        return invokeLL.booleanValue;
    }

    public static boolean openFileChooser(Activity activity, ValueCallback<Uri> valueCallback, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65552, null, activity, valueCallback, str)) == null) {
            com.baidu.browser.sailor.feature.a featureByName = getInstance().getFeatureByName(BdSailorConfig.SAILOR_BASE_UPLOAD);
            if (featureByName == null || !featureByName.isEnable()) {
                valueCallback.onReceiveValue(null);
                return false;
            }
            BdUploadFeature bdUploadFeature = (BdUploadFeature) featureByName;
            if (bdUploadFeature == null || activity == null) {
                return false;
            }
            return bdUploadFeature.openFileChooser(activity, valueCallback, str);
        }
        return invokeLLL.booleanValue;
    }

    public static boolean openFileChooser(Activity activity, ValueCallback<Uri> valueCallback, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65553, null, activity, valueCallback, str, str2)) == null) {
            com.baidu.browser.sailor.feature.a featureByName = getInstance().getFeatureByName(BdSailorConfig.SAILOR_BASE_UPLOAD);
            if (featureByName == null || !featureByName.isEnable()) {
                valueCallback.onReceiveValue(null);
                return false;
            }
            BdUploadFeature bdUploadFeature = (BdUploadFeature) featureByName;
            if (bdUploadFeature == null || activity == null) {
                return false;
            }
            return bdUploadFeature.openFileChooser(activity, valueCallback, str, str2);
        }
        return invokeLLLL.booleanValue;
    }

    private void registerFeature(com.baidu.browser.sailor.feature.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, this, aVar) == null) || aVar == null) {
            return;
        }
        this.mSailorFeatureMap.put(aVar.getName(), aVar);
    }

    private void registerReceiver() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65555, this) == null) && getAppContext() != null && this.mNetworkChangedReciever == null) {
            this.mNetworkChangedReciever = new b(this, (byte) 0);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            getAppContext().registerReceiver(this.mNetworkChangedReciever, intentFilter);
        }
    }

    private void setNetworkType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65556, this, i2) == null) {
            this.mNetworkType = i2;
            if (1 == i2 || -1 == i2) {
                BdSailor.getInstance().getSailorSettings().setSaveFlow(false);
            }
        }
    }

    private void unregisterFeature(com.baidu.browser.sailor.feature.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65557, this, aVar) == null) || aVar == null || TextUtils.isEmpty(aVar.getName())) {
            return;
        }
        this.mSailorFeatureMap.remove(aVar);
    }

    private void unregisterReceiver() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65558, this) == null) || getAppContext() == null || this.mNetworkChangedReciever == null) {
            return;
        }
        getAppContext().unregisterReceiver(this.mNetworkChangedReciever);
        this.mNetworkChangedReciever = null;
    }

    public final void clearCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            c.a.k.b.d.a a2 = c.a.k.b.d.a.a();
            try {
                a2.e();
                a2.f4127b.clearCache(z);
            } catch (Exception e2) {
                Log.printStackTrace(e2);
            }
        }
    }

    public final void doDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Log.d(TAG, "doDestroy");
            try {
                unregisterReceiver();
                if (this.mHandler != null) {
                    this.mHandler.removeMessages(1);
                    this.mHandler = null;
                }
                c.a.k.b.b.a.a.a();
                c.a.k.b.d.a.b();
                WebKitFactory.destroy();
                this.mContext = null;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final com.baidu.browser.sailor.feature.a findSailorFeature(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? getFeatureByName(str) : (com.baidu.browser.sailor.feature.a) invokeL.objValue;
    }

    public final Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mContext : (Context) invokeV.objValue;
    }

    public final String getCookie(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            CookieSyncManager.createInstance(this.mContext);
            return CookieManager.getInstance().getCookie(str);
        }
        return (String) invokeL.objValue;
    }

    public final String getCuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? WebKitFactory.getCUIDString() : (String) invokeV.objValue;
    }

    public final com.baidu.browser.sailor.feature.a getFeatureByName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            com.baidu.browser.sailor.feature.a aVar = this.mSailorFeatureMap.get(str);
            if (aVar instanceof com.baidu.browser.sailor.feature.a) {
                return aVar;
            }
            return null;
        }
        return (com.baidu.browser.sailor.feature.a) invokeL.objValue;
    }

    public final int getNetworkType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mNetworkType : invokeV.intValue;
    }

    public final String getWorkspace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mWorkspace : (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean init(Context context, String str) {
        InterceptResult invokeLL;
        boolean z;
        File filesDir;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, context, str)) == null) {
            Log.d(TAG, "init");
            this.mContext = context;
            if (TextUtils.isEmpty(str)) {
                str = SAILOR_MODULE_NAME;
            }
            if (context != null) {
                this.mWorkspace = str;
                try {
                    if (context.getFilesDir() == null) {
                        new File(context.getApplicationContext().getFilesDir() + "/").mkdirs();
                    }
                    filesDir = context.getFilesDir();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (filesDir != null) {
                    z = doInitWorkspace(filesDir.getAbsolutePath() + str);
                    initFeature(context);
                    BdCore.a().b(context, false);
                    if (this.mHandler == null) {
                        this.mHandler = new a(this, Looper.getMainLooper());
                    }
                    return z;
                }
            }
            z = false;
            initFeature(context);
            BdCore.a().b(context, false);
            if (this.mHandler == null) {
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public final void initWebkit(String str, boolean z, Class<? extends CrashCallback> cls) {
        String packageName;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, Boolean.valueOf(z), cls}) == null) || this.mIsWebkitInited) {
            return;
        }
        Log.d(TAG, "initWebkit");
        WebKitFactory.setKernelSessionId(String.valueOf(System.currentTimeMillis()));
        BdWebkitManager bdWebkitManager = this.mWebkitMgr;
        if (bdWebkitManager != null) {
            bdWebkitManager.initWebkit(str, z, cls);
        } else {
            WebKitFactory.getLoadErrorCode().trace(523);
        }
        long currentTimeMillis = System.currentTimeMillis();
        c.a.k.b.d.a a2 = c.a.k.b.d.a.a();
        Context appContext = getAppContext();
        if (a2.a == null) {
            a2.a = appContext.getApplicationContext();
            Log.d(c.a.k.b.d.a.f4125d, "in BdWebViewSingleton, init");
        }
        this.mIsWebkitInited = true;
        long currentTimeMillis2 = System.currentTimeMillis();
        Log.d("tangxianding", "[START] BdWebViewSingleton init time = " + (currentTimeMillis2 - currentTimeMillis));
        registerReceiver();
        Context context = this.mContext;
        boolean z2 = false;
        if (context != null && (packageName = context.getApplicationContext().getPackageName()) != null && packageName.equalsIgnoreCase(LITE_PACKAGE_NAME)) {
            z = false;
        }
        if (!WebSettingsGlobalBlink.isSFSwitchEnabled() && WebViewFactory.isMainAppProcess()) {
            z2 = z;
        }
        this.mIsNeedUpdateKernel = z2;
        if (!z2 || getAppContext() == null) {
            return;
        }
        getAppContext();
        BdZeusUpdate.a().c(getAppContext());
    }

    public final boolean isFixWebViewSecurityHoles() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mNeedFix : invokeV.booleanValue;
    }

    public final boolean isJavaScriptEnabledOnFileScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mIsEnableJavaScriptOnFileScheme : invokeV.booleanValue;
    }

    public final boolean isNeedUpdateKernel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mIsNeedUpdateKernel : invokeV.booleanValue;
    }

    public final boolean isWebkitInit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mIsWebkitInited : invokeV.booleanValue;
    }

    public final void onActivityDestory(Activity activity) {
        com.baidu.browser.sailor.feature.a findSailorFeature;
        BdUploadFeature bdUploadFeature;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, activity) == null) || (findSailorFeature = findSailorFeature(BdSailorConfig.SAILOR_BASE_UPLOAD)) == null || !findSailorFeature.isEnable() || (bdUploadFeature = (BdUploadFeature) findSailorFeature) == null) {
            return;
        }
        bdUploadFeature.onDestroy(activity);
    }

    public final void onActivityResult(Activity activity, int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{activity, Integer.valueOf(i2), Integer.valueOf(i3), intent}) == null) && 11 == i2) {
            ((BdUploadFeature) findSailorFeature(BdSailorConfig.SAILOR_BASE_UPLOAD)).onResult(activity, i3, intent);
        }
    }

    public final void onReceivedNetworkType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            setNetworkType(i2);
        }
    }

    public final void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            WebSettingsGlobalBlink.notifyBdAppStatusChange(0);
            Log.d(TAG, "pause ");
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeMessages(1);
                Handler handler2 = this.mHandler;
                handler2.sendMessageDelayed(handler2.obtainMessage(1), 2000L);
            }
        }
    }

    public final void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            Log.d(TAG, "resume ");
            WebSettingsGlobalBlink.notifyBdAppStatusChange(1);
            try {
                if (this.mHandler != null) {
                    this.mHandler.removeMessages(1);
                    if (this.mWebkitTimerPaused) {
                        Log.d(TAG, "do resume");
                        c.a.k.b.d.a.a().d();
                        CookieSyncManager createInstance = CookieSyncManager.createInstance(this.mContext);
                        if (createInstance != null) {
                            createInstance.startSync();
                        }
                        this.mWebkitTimerPaused = false;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Deprecated
    public final void setCuid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
        }
    }

    public final void setFixWebViewSecurityHoles(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.mNeedFix = z;
        }
    }

    public final void setJavaScriptEnabledOnFileScheme(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.mIsEnableJavaScriptOnFileScheme = z;
        }
    }

    public final void setNightMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
        }
    }

    public final void startCheckUpdate() {
        String packageName;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || getAppContext() == null || (packageName = getAppContext().getApplicationContext().getPackageName()) == null || !packageName.equalsIgnoreCase(LITE_PACKAGE_NAME)) {
            return;
        }
        Log.i(EngineManager.LOG_TAG, "start check zeus update form api");
        getAppContext();
        BdZeusUpdate.a().c(getAppContext());
    }

    public final void sync2Cookie(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, str, str2) == null) {
            CookieSyncManager createInstance = CookieSyncManager.createInstance(this.mContext);
            CookieManager.getInstance().setCookie(str, str2);
            createInstance.sync();
        }
    }
}
