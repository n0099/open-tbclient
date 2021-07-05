package com.baidu.swan.apps.jsbridge;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.base.LightappJsNativeClient;
import d.a.q0.a.a2.e;
import d.a.q0.a.c1.d.i;
import d.a.q0.a.e0.d;
import d.a.q0.a.f1.e.b;
import d.a.q0.a.j2.c;
import d.a.q0.a.k;
import d.a.q0.a.r1.k.f;
import d.a.q0.a.v2.q0;
import d.a.q0.a.v2.w;
import org.json.JSONException;
import org.json.JSONObject;
@Keep
/* loaded from: classes4.dex */
public class SwanAppUtilsJavaScriptInterface {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final int DEFAULT_SWAN_UBC_LOG_SIZE = 150;
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_android_utils";
    public static final String KEY_EXT_PARAMS = "params";
    public static final String KEY_EXT_SCHEME = "scheme";
    public static final String KEY_EXT_SWAN_JS = "swanjs";
    public static final String KEY_SHARE_FORCE_LIGHT_THEME = "forceLightTheme";
    public static final String KEY_SHARE_SNAPSHOT = "snapshot";
    public static final int SWAN_UBC_LOG_MAX_SIZE_BYTES;
    public static final String TAG = "UtilsJS";
    public static final long UBC_MIN_VERSION = 16789504;
    public static final int UNIT_KB = 1024;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mActivity;
    public Context mContext;
    public boolean mIsForceLight;
    public String mSource;
    public d.a.q0.a.h0.f.a mWebView;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11019e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppUtilsJavaScriptInterface f11020f;

        public a(SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppUtilsJavaScriptInterface, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11020f = swanAppUtilsJavaScriptInterface;
            this.f11019e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = this.f11019e;
                if (!str.startsWith("javascript:")) {
                    str = "javascript:" + str;
                }
                if (SwanAppUtilsJavaScriptInterface.DEBUG) {
                    Log.d(SwanAppUtilsJavaScriptInterface.TAG, "share result:" + str);
                }
                this.f11020f.mWebView.evaluateJavascript(str, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements i.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f11021a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f11022b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SwanAppUtilsJavaScriptInterface f11023c;

        public b(SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppUtilsJavaScriptInterface, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11023c = swanAppUtilsJavaScriptInterface;
            this.f11021a = str;
            this.f11022b = str2;
        }

        @Override // d.a.q0.a.c1.d.i.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11023c.notifyCallback(this.f11022b, String.valueOf(false));
            }
        }

        @Override // d.a.q0.a.c1.d.i.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f11023c.notifyCallback(this.f11021a, String.valueOf(true));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11024e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppUtilsJavaScriptInterface f11025f;

        public c(SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppUtilsJavaScriptInterface, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11025f = swanAppUtilsJavaScriptInterface;
            this.f11024e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (SwanAppUtilsJavaScriptInterface.DEBUG) {
                    Log.d(SwanAppUtilsJavaScriptInterface.TAG, "ubcEvent in thread pool");
                }
                this.f11025f.doUbcEvent(this.f11024e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-242701184, "Lcom/baidu/swan/apps/jsbridge/SwanAppUtilsJavaScriptInterface;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-242701184, "Lcom/baidu/swan/apps/jsbridge/SwanAppUtilsJavaScriptInterface;");
                return;
            }
        }
        DEBUG = k.f49133a;
        SWAN_UBC_LOG_MAX_SIZE_BYTES = d.a.q0.a.c1.a.Z().x() * 1024;
    }

    public SwanAppUtilsJavaScriptInterface(Context context, d.a.q0.a.h0.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsForceLight = false;
        this.mSource = "";
        this.mActivity = context;
        this.mContext = context.getApplicationContext();
        this.mWebView = aVar;
    }

    private boolean checkParamsInvalid(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str)) == null) ? TextUtils.isEmpty(str) || str.getBytes().length > SWAN_UBC_LOG_MAX_SIZE_BYTES : invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUbcEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("min_v");
                if ((TextUtils.isEmpty(optString) ? 0L : Long.valueOf(optString).longValue()) < UBC_MIN_VERSION) {
                    return;
                }
                d.a.q0.a.j2.b.l(jSONObject.optString("actionId"), jSONObject.optString("value"));
                f.j().i().d(jSONObject);
            } catch (NumberFormatException | JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private boolean hasHitsAbTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? SWAN_UBC_LOG_MAX_SIZE_BYTES > 0 : invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCallback(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, str, str2) == null) {
            loadJavaScript("javascript:" + str + "(" + str2 + ");");
        }
    }

    private void reportUbcBusinessEvent(@NonNull String str) {
        e Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, str) == null) || (Q = e.Q()) == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            b.a L = Q.L();
            SwanCoreVersion N = d.a.q0.a.g1.f.V().N();
            int l = Q.l();
            jSONObject.putOpt("scheme", L.W());
            jSONObject.putOpt(KEY_EXT_SWAN_JS, d.a.q0.a.m2.b.i(N, l));
            if (str != null && str.length() > 1024) {
                jSONObject.putOpt("params", str.substring(0, 1024));
            }
            c.b bVar = new c.b(10020);
            bVar.j(q0.n().h());
            bVar.i(jSONObject.toString());
            bVar.h(Q.getAppId());
            bVar.m();
            d.h(TAG, "10020, params: " + str);
        } catch (JSONException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    @JavascriptInterface
    public void callShare(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
            callShare(str, str2, true, str3);
        }
    }

    @JavascriptInterface
    public void consoleLog(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && !TextUtils.isEmpty(str) && DEBUG) {
            Log.e(TAG, "consoleLog : " + str + "->" + System.currentTimeMillis());
        }
    }

    public void loadJavaScript(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || this.mWebView == null) {
            return;
        }
        q0.b0(new a(this, str));
    }

    public void realCallShare(Context context, String str, String str2, String str3, boolean z, boolean z2, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2), str4}) == null) {
            if (DEBUG) {
                Log.i(TAG, LightappJsNativeClient.METHOD_CALL_SHARE);
            }
            JSONObject d2 = w.d(str2);
            try {
                d2.put(KEY_SHARE_SNAPSHOT, z);
                d2.put(KEY_SHARE_FORCE_LIGHT_THEME, z2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            d.a.q0.a.c1.a.Y().a(context, d2, new b(this, str3, str4));
        }
    }

    public void setActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
            this.mActivity = activity;
        }
    }

    public void setForceShareLight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.mIsForceLight = z;
        }
    }

    public void setSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.mSource = str;
        }
    }

    @JavascriptInterface
    public void ubcEvent(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (hasHitsAbTest() && checkParamsInvalid(str)) {
            reportUbcBusinessEvent(str);
            return;
        }
        d.a.q0.a.h0.f.a aVar = this.mWebView;
        if (d.a.q0.a.h0.l.g.f.a(aVar, "ubcEvent - " + str)) {
            return;
        }
        ExecutorUtilsExt.postOnElastic(new c(this, str), "ubcEvent", 3);
    }

    @JavascriptInterface
    public void callShare(String str, String str2, boolean z, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Boolean.valueOf(z), str3}) == null) {
            if (this.mIsForceLight) {
                callShare(str, str2, z, true, str3);
            } else {
                callShare(str, str2, z, false, str3);
            }
        }
    }

    @JavascriptInterface
    public void callShare(String str, String str2, boolean z, boolean z2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), str3}) == null) {
            realCallShare(this.mActivity, this.mSource, str, str2, z, z2, str3);
        }
    }
}
