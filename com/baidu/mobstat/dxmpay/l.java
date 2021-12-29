package com.baidu.mobstat.dxmpay;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
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
public class l {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<WebView> f38114b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<Activity> f38115c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f38116d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f38117e;

    public l() {
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
        if (interceptable == null || interceptable.invokeLLL(65537, this, str, activity, webView) == null) {
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
                JSONArray a2 = k.a(activity, webView);
                String name = activity.getClass().getName();
                String a3 = k.a(a2);
                String b2 = k.b(jSONArray222);
                String d2 = k.d(webView);
                Map<String, String> e2 = k.e(webView);
                Context applicationContext = activity.getApplicationContext();
                long currentTimeMillis = System.currentTimeMillis();
                if (a(this.f38116d, activity.getClass().getName(), str5, a3, b2)) {
                    BDStatCore.instance().onEvent(applicationContext, "", str422, 1, System.currentTimeMillis(), a2, jSONArray222, name, str5, d2, e2, true);
                } else if (i.c().b() && this.f38117e) {
                    i.c().a("setEventToNative: not circle event, will not take effect");
                }
                e.a().a(applicationContext, "", str422, "", 1, currentTimeMillis, name, a2, str5, jSONArray222, d2, e2, true, jSONObject322, "");
            }
        }
    }

    @JavascriptInterface
    public void setEventToNative(String str) {
        Activity activity;
        WeakReference<WebView> weakReference;
        WebView webView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (i.c().b() && this.f38117e) {
                i c2 = i.c();
                c2.a("setEventToNative: " + str);
            }
            if (j.c().b()) {
                j c3 = j.c();
                c3.a("setEventToNative: " + str);
            }
            WeakReference<Activity> weakReference2 = this.f38115c;
            if (weakReference2 == null || (activity = weakReference2.get()) == null || (weakReference = this.f38114b) == null || (webView = weakReference.get()) == null) {
                return;
            }
            a(str, activity, webView);
        }
    }

    @JavascriptInterface
    public void setViewportTreeToNative(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (i.c().b()) {
                i c2 = i.c();
                c2.a("setViewportTreeToNative " + str);
            }
            a = str;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    private boolean a(JSONObject jSONObject, String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLLL = interceptable.invokeLLLLL(65538, this, jSONObject, str, str2, str3, str4)) != null) {
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
