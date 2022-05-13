package com.baidu.browser.sailor.webkit.loader;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.core.INoProGuard;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.BdSailorConfig;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.blink.EngineManager;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.dumper.CrashCallback;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import com.repackage.tx;
import com.repackage.yx;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.DebugKt;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BdWebkitManager implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_TAG = "com.baidu.browser.sailor.webkit.loader.BdWebkitManager";
    public static a mBdWebkitType;
    public static a mWebkitType;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsWebkitBuiltin;
    public List<IWebkitLoaderListener> mListenerLst;
    public yx mLoader;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public static final a b;
        public static final a c;
        public static final /* synthetic */ a[] d;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(42445962, "Lcom/baidu/browser/sailor/webkit/loader/BdWebkitManager$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(42445962, "Lcom/baidu/browser/sailor/webkit/loader/BdWebkitManager$a;");
                    return;
                }
            }
            a = new a("SYSTEM", 0);
            b = new a("T5", 1);
            a aVar = new a("T7", 2);
            c = aVar;
            d = new a[]{a, b, aVar};
        }

        public a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (a) Enum.valueOf(a.class, str) : (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) d.clone() : (a[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(773227687, "Lcom/baidu/browser/sailor/webkit/loader/BdWebkitManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(773227687, "Lcom/baidu/browser/sailor/webkit/loader/BdWebkitManager;");
                return;
            }
        }
        a aVar = BdSailorConfig.BUILTIN_WEBKIT;
        mWebkitType = aVar;
        mBdWebkitType = aVar;
    }

    public BdWebkitManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsWebkitBuiltin = true;
        this.mListenerLst = new ArrayList();
        this.mLoader = new yx();
    }

    private String makeErrorInfo(LoadErrorCode loadErrorCode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, loadErrorCode)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_code", loadErrorCode.getInt());
                jSONObject.put(LoadErrorCode.Statistics.KEY_ERROR_REASON, loadErrorCode.getString());
                String str = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
                if (BdZeusUtil.isWebkitLoaded()) {
                    str = DebugKt.DEBUG_PROPERTY_VALUE_ON;
                }
                jSONObject.put("t5_integration", str);
            } catch (Exception unused) {
                Log.d("soar", "exception when make error info");
            }
            Log.d("soar", "error info: " + jSONObject.toString());
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public void addListener(IWebkitLoaderListener iWebkitLoaderListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iWebkitLoaderListener) == null) {
            synchronized (this) {
                this.mListenerLst.add(iWebkitLoaderListener);
            }
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void disableBdWebkit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            mWebkitType = a.a;
        }
    }

    public void enableBdWebkit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            mWebkitType = mBdWebkitType;
        }
    }

    public a getWebkitType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? mWebkitType : (a) invokeV.objValue;
    }

    public void initWebkit(String str, boolean z, Class<? extends CrashCallback> cls) {
        String str2;
        StringBuilder sb;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Boolean.valueOf(z), cls}) == null) {
            this.mIsWebkitBuiltin = z;
            yx yxVar = this.mLoader;
            Context appContext = BdSailorPlatform.getInstance().getAppContext();
            a aVar = mWebkitType;
            if (z && (a.b == aVar || a.c == aVar)) {
                if (cls != null) {
                    WebKitFactory.setCrashCallback(appContext, cls);
                }
                WebKitFactory.init(appContext, str, BdSailorPlatform.getInstance().getCuid());
                WebKitFactory.setApkLibLoadType(z);
                WebKitFactory.setEmulator(BdZeusUtil.checkEmulator());
                if (WebKitFactory.isZeusSupported()) {
                    if (a.c == aVar) {
                        tx txVar = BdSailorPlatform.getStatic();
                        txVar.b("emulator-check", "emulator:" + BdZeusUtil.checkEmulator());
                        z2 = WebKitFactory.setEngine(1);
                        String str3 = yx.c;
                        Log.d(str3, "zeus version = " + WebKitFactory.getZeusVersionName());
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        String str4 = yx.c;
                        Log.d(str4, "zeus version = " + WebKitFactory.getZeusVersionName());
                        String str5 = yx.c;
                        Log.d(str5, "sdk version = " + WebKitFactory.getSdkVersionName());
                        BdSailorPlatform.getWebkitManager().onLoadZeusSDKSuccess();
                        BdSailorPlatform.getStatic().b("init-webkit", "success");
                        BdSailorPlatform.getStatic().d = true;
                    } else {
                        LoadErrorCode loadErrorCode = WebKitFactory.getLoadErrorCode();
                        yxVar.a(loadErrorCode);
                        yx.c(loadErrorCode);
                    }
                } else {
                    yxVar.a(new LoadErrorCode(99, "not support"));
                    BdSailorPlatform.getStatic().b("init-webkit", "notSupport");
                }
                BdSailorPlatform.getStatic().d = false;
            } else if (BdZeusUtil.isWebkitLoaded()) {
                return;
            } else {
                WebKitFactory.init(appContext, appContext.getPackageName(), BdSailorPlatform.getInstance().getCuid());
                WebKitFactory.setApkLibLoadType(z);
                if (a.c == aVar || a.b == aVar) {
                    WebKitFactory.setEngine(1);
                    str2 = yx.c;
                    sb = new StringBuilder("zeus version =");
                } else {
                    WebKitFactory.setEngine(0);
                    str2 = yx.c;
                    sb = new StringBuilder("zeus version =");
                }
                sb.append(WebKitFactory.getZeusVersionName());
                Log.d(str2, sb.toString());
                Log.i(EngineManager.LOG_TAG, "so in=" + WebKitFactory.getZeusVersionName());
                Log.i(EngineManager.LOG_TAG, "so out=" + WebKitFactory.getSdkVersionName());
                if (BdZeusUtil.isWebkitLoaded()) {
                    BdSailorPlatform.getStatic().b("init-webkit", "success");
                    BdSailorPlatform.getWebkitManager().onLoadZeusSDKSuccess();
                } else {
                    LoadErrorCode loadErrorCode2 = WebKitFactory.getLoadErrorCode();
                    yxVar.a(loadErrorCode2);
                    yx.c(loadErrorCode2);
                    BdSailorPlatform.getWebkitManager().onLoadSysSDKSuccess();
                }
            }
            ZeusPerformanceTiming.setZeusWebkitInitStatistics(BdSailorPlatform.getStatic().b);
        }
    }

    public void installZeusFromDownload(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (!WebViewFactory.hasProvider()) {
                Log.i(EngineManager.LOG_TAG, "installZeusFromDownload post after initwebkit");
                BdSailor.getInstance().addListener(new IWebkitLoaderListener(this, str) { // from class: com.baidu.browser.sailor.webkit.loader.BdWebkitManager.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BdWebkitManager this$0;
                    public final /* synthetic */ String val$zeusPath;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$zeusPath = str;
                    }

                    @Override // com.baidu.browser.sailor.webkit.loader.IWebkitLoaderListener
                    public void onInstallZeusSDKFailed(byte b, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Byte.valueOf(b), str2}) == null) {
                        }
                    }

                    @Override // com.baidu.browser.sailor.webkit.loader.IWebkitLoaderListener
                    public void onInstallZeusSDKSuccess(byte b) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeB(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b) == null) {
                        }
                    }

                    @Override // com.baidu.browser.sailor.webkit.loader.IWebkitLoaderListener
                    public void onLoadSysSDKFailed() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            Log.i(EngineManager.LOG_TAG, "installZeusFromDownload after onLoadSysSDKFailed");
                        }
                    }

                    @Override // com.baidu.browser.sailor.webkit.loader.IWebkitLoaderListener
                    public void onLoadSysSDKSuccess() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            Log.i(EngineManager.LOG_TAG, "installZeusFromDownload after onLoadSysSDKSuccess");
                            yx yxVar = this.this$0.mLoader;
                            BdSailorPlatform.getInstance().getAppContext();
                            String str2 = this.val$zeusPath;
                            a unused = BdWebkitManager.mWebkitType;
                            yxVar.b(str2);
                        }
                    }

                    @Override // com.baidu.browser.sailor.webkit.loader.IWebkitLoaderListener
                    public void onLoadZeusSDKFailed() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                            Log.i(EngineManager.LOG_TAG, "installZeusFromDownload after onLoadZeusSDKFailed");
                        }
                    }

                    @Override // com.baidu.browser.sailor.webkit.loader.IWebkitLoaderListener
                    public void onLoadZeusSDKSuccess() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                            Log.i(EngineManager.LOG_TAG, "installZeusFromDownload after onLoadZeusSDKSuccess");
                            yx yxVar = this.this$0.mLoader;
                            BdSailorPlatform.getInstance().getAppContext();
                            String str2 = this.val$zeusPath;
                            a unused = BdWebkitManager.mWebkitType;
                            yxVar.b(str2);
                        }
                    }
                });
                return;
            }
            yx yxVar = this.mLoader;
            BdSailorPlatform.getInstance().getAppContext();
            yxVar.b(str);
        }
    }

    public boolean isWebkitBuiltin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mIsWebkitBuiltin : invokeV.booleanValue;
    }

    public void loadWebkitOnly(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, z) == null) {
            boolean init = WebKitFactory.init(context, context.getPackageName(), BdSailorPlatform.getInstance().getCuid());
            WebKitFactory.setApkLibLoadType(z);
            WebKitFactory.destroy();
            boolean engine = (a.b == mWebkitType || a.c == mWebkitType) ? WebKitFactory.setEngine(1) : false;
            Log.d(" initResult " + init + " " + engine);
        }
    }

    public void onInstallZeusPluginFailed(byte b, LoadErrorCode loadErrorCode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Byte.valueOf(b), loadErrorCode}) == null) {
            String makeErrorInfo = makeErrorInfo(loadErrorCode);
            Log.d(LOG_TAG, makeErrorInfo);
            List<IWebkitLoaderListener> list = this.mListenerLst;
            if (list != null) {
                for (IWebkitLoaderListener iWebkitLoaderListener : list) {
                    iWebkitLoaderListener.onInstallZeusSDKFailed(b, makeErrorInfo);
                }
            }
        }
    }

    public void onInstallZeusPluginSuccess(Context context, String str, byte b) {
        ArrayList<IWebkitLoaderListener> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, str, Byte.valueOf(b)}) == null) || this.mListenerLst == null) {
            return;
        }
        synchronized (this) {
            arrayList = new ArrayList(this.mListenerLst);
        }
        for (IWebkitLoaderListener iWebkitLoaderListener : arrayList) {
            iWebkitLoaderListener.onInstallZeusSDKSuccess(b);
        }
    }

    public void onLoadSysSDKFailed() {
        List<IWebkitLoaderListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (list = this.mListenerLst) == null) {
            return;
        }
        for (IWebkitLoaderListener iWebkitLoaderListener : list) {
            iWebkitLoaderListener.onLoadSysSDKFailed();
        }
    }

    public void onLoadSysSDKSuccess() {
        List<IWebkitLoaderListener> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (list = this.mListenerLst) == null) {
            return;
        }
        for (IWebkitLoaderListener iWebkitLoaderListener : list) {
            iWebkitLoaderListener.onLoadSysSDKSuccess();
        }
    }

    public void onLoadZeusSDKFailed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            for (IWebkitLoaderListener iWebkitLoaderListener : this.mListenerLst) {
                iWebkitLoaderListener.onLoadZeusSDKFailed();
            }
        }
    }

    public void onLoadZeusSDKSuccess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            for (IWebkitLoaderListener iWebkitLoaderListener : this.mListenerLst) {
                iWebkitLoaderListener.onLoadZeusSDKSuccess();
            }
        }
    }

    public void removeListener(IWebkitLoaderListener iWebkitLoaderListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, iWebkitLoaderListener) == null) {
            synchronized (this) {
                if (this.mListenerLst.contains(iWebkitLoaderListener)) {
                    this.mListenerLst.remove(iWebkitLoaderListener);
                }
            }
        }
    }
}
