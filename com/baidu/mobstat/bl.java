package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class bl {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<WebView> f37638b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<Activity> f37639c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f37640d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f37641e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f37642f;

    public bl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void b(Activity activity, WebView webView, Rect rect) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, activity, webView, rect) == null) {
            int i5 = 0;
            if (rect != null) {
                i5 = ah.a(activity, rect.left);
                i3 = ah.a(activity, rect.top);
                i4 = ah.a(activity, rect.width());
                i2 = ah.a(activity, rect.height());
            } else {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            }
            activity.runOnUiThread(new Runnable(webView, "javascript:window._automtj.getViewportTree('android', '" + ("{\"x\": " + i5 + ", \"y\": " + i3 + ", \"w\": " + i4 + ", \"h\": " + i2 + ", \"sw\": " + ah.a(activity, bj.c(activity)) + ", \"sh\": " + ah.a(activity, bj.d(activity)) + "}") + "', 'window.WebViewInterface.setViewportTreeToNative')") { // from class: com.baidu.mobstat.bl.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ WebView a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f37643b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {webView, r7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i6 = newInitContext.flag;
                        if ((i6 & 1) != 0) {
                            int i7 = i6 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = webView;
                    this.f37643b = r7;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.loadUrl(this.f37643b);
                    }
                }
            });
        }
    }

    public void a(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        webView.loadUrl("javascript:" + str);
    }

    @JavascriptInterface
    public void setEventToNative(String str) {
        Activity activity;
        WeakReference<WebView> weakReference;
        WebView webView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (bd.c().b() && this.f37642f) {
                bd c2 = bd.c();
                c2.a("setEventToNative: " + str);
            }
            if (bh.c().b()) {
                bh c3 = bh.c();
                c3.a("setEventToNative: " + str);
            }
            WeakReference<Activity> weakReference2 = this.f37639c;
            if (weakReference2 == null || (activity = weakReference2.get()) == null || (weakReference = this.f37638b) == null || (webView = weakReference.get()) == null) {
                return;
            }
            a(str, activity, webView);
        }
    }

    @JavascriptInterface
    public void setViewportTreeToNative(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (bd.c().b()) {
                bd c2 = bd.c();
                c2.a("setViewportTreeToNative " + str);
            }
            a = str;
        }
    }

    public static String a(Activity activity, WebView webView, Rect rect) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65538, null, activity, webView, rect)) != null) {
            return (String) invokeLLL.objValue;
        }
        a = "";
        b(activity, webView, rect);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 >= 15) {
                return "";
            }
            try {
                Thread.sleep(20L);
            } catch (Exception unused) {
            }
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
            i2 = i3;
        }
    }

    public void a(Activity activity, WebView webView, String str, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{activity, webView, str, jSONObject, Boolean.valueOf(z)}) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (z) {
            this.f37642f = z;
            this.f37640d = jSONObject;
        }
        if (z) {
            bd.c().a("injectTrackJs circleConfig: " + jSONObject);
        }
        if (a(webView, z)) {
            if (z) {
                bd.c().a("injectTrackJs, no need to entry");
                return;
            } else {
                bh.c().a("injectTrackJs, no need to entry");
                return;
            }
        }
        if (activity != null) {
            this.f37639c = new WeakReference<>(activity);
        }
        if (webView != null) {
            this.f37638b = new WeakReference<>(webView);
        }
        this.f37641e = z;
        String a2 = a();
        if (TextUtils.isEmpty(a2)) {
            a2 = new JSONObject().toString();
        }
        if (bd.c().b() && this.f37642f) {
            bd.c().a("injectTrackJs h5Config: " + a2);
        }
        if (bh.c().b()) {
            bh.c().a("injectTrackJs h5Config: " + a2);
        }
        String str2 = "(function(){var h5conf = {\"sdkAPI\": \"window.WebViewInterface.setEventToNative\", \"sdkType\": \"android\", \"events\": " + a2 + "};" + str + "})()";
        if (webView != null) {
            webView.loadUrl("javascript:" + str2);
        }
    }

    private boolean a(WebView webView, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, webView, z)) == null) {
            WeakReference<WebView> weakReference = this.f37638b;
            return (weakReference == null || weakReference.get() != webView || this.f37641e == z) ? false : true;
        }
        return invokeLZ.booleanValue;
    }

    private String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("matchAll", 1);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("meta", jSONObject);
                return jSONObject2.toString();
            } catch (Exception unused) {
                return new JSONObject().toString();
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0038 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, Activity activity, WebView webView) {
        JSONArray jSONArray;
        String str2;
        String str3;
        boolean z;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, this, str, activity, webView) == null) {
            JSONObject jSONObject2 = null;
            try {
                jSONObject = new JSONObject(str);
                jSONArray = jSONObject.optJSONArray("h3");
            } catch (Exception unused) {
                jSONArray = null;
                str2 = null;
            }
            try {
                str2 = jSONObject.optString("p2");
                try {
                    str3 = jSONObject.optString("l");
                    try {
                        jSONObject2 = jSONObject.optJSONObject("point");
                        z = true;
                    } catch (Exception unused2) {
                        z = false;
                        JSONObject jSONObject3 = jSONObject2;
                        JSONArray jSONArray2 = jSONArray;
                        String str4 = str3;
                        if (z) {
                        }
                    }
                } catch (Exception unused3) {
                    str3 = null;
                }
            } catch (Exception unused4) {
                str2 = null;
                str3 = str2;
                z = false;
                JSONObject jSONObject32 = jSONObject2;
                JSONArray jSONArray22 = jSONArray;
                String str42 = str3;
                if (z) {
                }
            }
            JSONObject jSONObject322 = jSONObject2;
            JSONArray jSONArray222 = jSONArray;
            String str422 = str3;
            if (z) {
                String str5 = TextUtils.isEmpty(str2) ? "/" : str2;
                JSONArray a2 = bj.a(activity, webView);
                String name = activity.getClass().getName();
                String a3 = bj.a(a2);
                String b2 = bj.b(jSONArray222);
                String f2 = bj.f(webView);
                Map<String, String> g2 = bj.g(webView);
                Context applicationContext = activity.getApplicationContext();
                long currentTimeMillis = System.currentTimeMillis();
                if (a(this.f37640d, activity.getClass().getName(), str5, a3, b2)) {
                    BDStatCore.instance().onEvent(applicationContext, "", str422, 1, System.currentTimeMillis(), a2, jSONArray222, name, str5, f2, g2, true);
                } else if (bd.c().b() && this.f37642f) {
                    bd.c().a("setEventToNative: not circle event, will not take effect");
                }
                aw.a().a(applicationContext, "", str422, 1, currentTimeMillis, name, a2, str5, jSONArray222, f2, g2, true, jSONObject322, "");
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    private boolean a(JSONObject jSONObject, String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLLL = interceptable.invokeLLLLL(65541, this, jSONObject, str, str2, str3, str4)) != null) {
            return invokeLLLLL.booleanValue;
        }
        int i2 = 0;
        if (jSONObject == null || jSONObject.toString().equals(new JSONObject().toString()) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            return false;
        }
        try {
            if (((JSONObject) jSONObject.get("meta")).getInt("matchAll") != 0) {
                return true;
            }
        } catch (Exception unused) {
        }
        try {
            JSONArray jSONArray = (JSONArray) jSONObject.get("data");
            boolean z = false;
            while (i2 < jSONArray.length()) {
                try {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                    String optString = jSONObject2.optString("page");
                    String optString2 = jSONObject2.optString("layout");
                    String str5 = (String) jSONObject2.opt("url");
                    String str6 = (String) jSONObject2.opt("webLayout");
                    if (str.equals(optString) && str2.equals(str5) && str3.equals(optString2) && str4.equals(str6)) {
                        z = true;
                    }
                    i2++;
                } catch (Exception unused2) {
                    i2 = z ? 1 : 0;
                    return i2;
                }
            }
            return z;
        } catch (Exception unused3) {
        }
    }
}
