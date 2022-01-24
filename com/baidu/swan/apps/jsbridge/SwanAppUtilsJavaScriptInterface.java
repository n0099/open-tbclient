package com.baidu.swan.apps.jsbridge;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.c1.d.j;
import c.a.r0.a.k;
import c.a.r0.a.n2.g;
import c.a.r0.a.u1.k.f;
import c.a.r0.a.z2.q0;
import c.a.r0.a.z2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
@Keep
/* loaded from: classes11.dex */
public class SwanAppUtilsJavaScriptInterface {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_android_utils";
    public static final String KEY_SHARE_FORCE_LIGHT_THEME = "forceLightTheme";
    public static final String KEY_SHARE_SNAPSHOT = "snapshot";
    public static final String TAG = "UtilsJS";
    public static final long UBC_MIN_VERSION = 16789504;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mActivity;
    public boolean mIsForceLight;
    public String mSource;
    public c.a.r0.a.h0.f.a mWebView;

    /* loaded from: classes11.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f38850e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppUtilsJavaScriptInterface f38851f;

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
            this.f38851f = swanAppUtilsJavaScriptInterface;
            this.f38850e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = this.f38850e;
                if (!str.startsWith("javascript:")) {
                    str = "javascript:" + str;
                }
                if (SwanAppUtilsJavaScriptInterface.DEBUG) {
                    String str2 = "share result:" + str;
                }
                this.f38851f.mWebView.evaluateJavascript(str, null);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f38852b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SwanAppUtilsJavaScriptInterface f38853c;

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
            this.f38853c = swanAppUtilsJavaScriptInterface;
            this.a = str;
            this.f38852b = str2;
        }

        @Override // c.a.r0.a.c1.d.j.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f38853c.notifyCallback(this.f38852b, String.valueOf(false));
            }
        }

        @Override // c.a.r0.a.c1.d.j.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f38853c.notifyCallback(this.a, String.valueOf(true));
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f38854e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppUtilsJavaScriptInterface f38855f;

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
            this.f38855f = swanAppUtilsJavaScriptInterface;
            this.f38854e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = SwanAppUtilsJavaScriptInterface.DEBUG;
                this.f38855f.doUbcEvent(this.f38854e);
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
        DEBUG = k.a;
    }

    public SwanAppUtilsJavaScriptInterface(Context context, c.a.r0.a.h0.f.a aVar) {
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
        this.mWebView = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUbcEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("min_v");
                if ((TextUtils.isEmpty(optString) ? 0L : Long.valueOf(optString).longValue()) < UBC_MIN_VERSION) {
                    return;
                }
                c.a.r0.a.n2.b.l(jSONObject.optString("actionId"), jSONObject.optString("value"));
                f.j().i().d(jSONObject);
            } catch (NumberFormatException | JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCallback(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, str, str2) == null) {
            loadJavaScript("javascript:" + str + "(" + str2 + ");");
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
            String str2 = "consoleLog : " + str + "->" + System.currentTimeMillis();
        }
    }

    public void loadJavaScript(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || this.mWebView == null) {
            return;
        }
        q0.e0(new a(this, str));
    }

    public void realCallShare(Context context, String str, String str2, String str3, boolean z, boolean z2, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, str, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2), str4}) == null) {
            boolean z3 = DEBUG;
            JSONObject d2 = w.d(str2);
            try {
                d2.put(KEY_SHARE_SNAPSHOT, z);
                d2.put(KEY_SHARE_FORCE_LIGHT_THEME, z2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            c.a.r0.a.c1.a.f0().a(context, d2, new b(this, str3, str4));
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
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || TextUtils.isEmpty(str) || g.b(str)) {
            return;
        }
        c.a.r0.a.h0.f.a aVar = this.mWebView;
        if (c.a.r0.a.h0.l.g.f.a(aVar, "ubcEvent - " + str)) {
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
