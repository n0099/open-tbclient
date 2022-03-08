package com.baidu.android.pushservice.message;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f30944b;

    /* renamed from: c  reason: collision with root package name */
    public String f30945c;

    /* renamed from: d  reason: collision with root package name */
    public String f30946d;

    /* renamed from: e  reason: collision with root package name */
    public String f30947e;

    /* renamed from: f  reason: collision with root package name */
    public String f30948f;

    /* renamed from: g  reason: collision with root package name */
    public String f30949g;

    /* renamed from: h  reason: collision with root package name */
    public String f30950h;

    /* renamed from: i  reason: collision with root package name */
    public String f30951i;

    /* renamed from: j  reason: collision with root package name */
    public String f30952j;
    public int k;
    public String l;
    public String m;

    public i() {
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

    public PublicMsg a(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            PublicMsg publicMsg = new PublicMsg();
            try {
                publicMsg.mMsgId = this.f30952j;
                publicMsg.mAppId = this.f30951i;
                if (TextUtils.isEmpty(this.f30949g) && TextUtils.isEmpty(this.f30950h)) {
                    publicMsg.mTitle = this.f30947e;
                    publicMsg.mDescription = this.f30948f;
                    publicMsg.mUrl = this.a;
                    str = this.f30945c;
                } else {
                    publicMsg.mTitle = this.f30949g;
                    publicMsg.mDescription = this.f30950h;
                    publicMsg.mUrl = this.f30944b;
                    str = this.f30946d;
                }
                publicMsg.mPkgContent = str;
                return publicMsg;
            } catch (Exception e2) {
                com.baidu.android.pushservice.f.a.b("ProxyPushMessage", "Public Message Parsing Fail:\r\n" + e2.getMessage(), context.getApplicationContext());
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                return null;
            }
        }
        return (PublicMsg) invokeL.objValue;
    }

    public String a(Context context, String str) {
        InterceptResult invokeLL;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.isNull("extras") || (jSONArray = jSONObject.getJSONArray("extras")) == null) {
                    return null;
                }
                a(context, jSONArray);
                if (TextUtils.isEmpty(this.l)) {
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject(new String(this.l));
                String string = !jSONObject2.isNull("custom_content") ? jSONObject2.getString("custom_content") : null;
                if (!jSONObject2.isNull("hwprisigninfo")) {
                    this.m = jSONObject2.getString("hwprisigninfo");
                }
                return string;
            } catch (JSONException e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public void a(Context context, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, jSONArray) == null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (!jSONObject.isNull("Appid")) {
                        this.f30951i = jSONObject.getString("Appid");
                    }
                    if (!jSONObject.isNull("Msgid")) {
                        this.f30952j = jSONObject.getString("Msgid");
                    }
                    if (!jSONObject.isNull("Type")) {
                        this.k = jSONObject.getInt("Type");
                    }
                    if (!jSONObject.isNull("msgBody")) {
                        this.l = jSONObject.getString("msgBody");
                    }
                } catch (Exception e2) {
                    new b.c(context).a(Log.getStackTraceString(e2)).a();
                    return;
                }
            }
        }
    }

    public String b(Context context, String str) {
        InterceptResult invokeLL;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.isNull("extras") || (jSONArray = jSONObject.getJSONArray("extras")) == null) {
                    return null;
                }
                a(context, jSONArray);
                if (TextUtils.isEmpty(this.l)) {
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject(this.l);
                if (jSONObject2.isNull("custom_content")) {
                    return null;
                }
                return jSONObject2.getString("custom_content");
            } catch (JSONException e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public String c(Context context, String str) {
        InterceptResult invokeLL;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.isNull("extras") || (jSONArray = jSONObject.getJSONArray("extras")) == null) {
                    return null;
                }
                a(context, jSONArray);
                if (TextUtils.isEmpty(this.l)) {
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject(this.l);
                String string = !jSONObject2.isNull("custom_content") ? jSONObject2.getString("custom_content") : null;
                if (!jSONObject2.isNull("mzpri_signinfo")) {
                    this.m = jSONObject2.getString("mzpri_signinfo");
                }
                return string;
            } catch (JSONException e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }
}
