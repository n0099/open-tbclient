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
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public int k;
    public String l;
    public String m;

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
                publicMsg.mMsgId = this.j;
                publicMsg.mAppId = this.i;
                if (TextUtils.isEmpty(this.g) && TextUtils.isEmpty(this.h)) {
                    publicMsg.mTitle = this.e;
                    publicMsg.mDescription = this.f;
                    publicMsg.mUrl = this.a;
                    str = this.c;
                } else {
                    publicMsg.mTitle = this.g;
                    publicMsg.mDescription = this.h;
                    publicMsg.mUrl = this.b;
                    str = this.d;
                }
                publicMsg.mPkgContent = str;
                return publicMsg;
            } catch (Exception e) {
                com.baidu.android.pushservice.f.a.b("ProxyPushMessage", "Public Message Parsing Fail:\r\n" + e.getMessage(), context.getApplicationContext());
                new b.c(context).a(Log.getStackTraceString(e)).a();
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
            } catch (JSONException e) {
                new b.c(context).a(Log.getStackTraceString(e)).a();
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public void a(Context context, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, jSONArray) == null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (!jSONObject.isNull("Appid")) {
                        this.i = jSONObject.getString("Appid");
                    }
                    if (!jSONObject.isNull("Msgid")) {
                        this.j = jSONObject.getString("Msgid");
                    }
                    if (!jSONObject.isNull("Type")) {
                        this.k = jSONObject.getInt("Type");
                    }
                    if (!jSONObject.isNull("msgBody")) {
                        this.l = jSONObject.getString("msgBody");
                    }
                } catch (Exception e) {
                    new b.c(context).a(Log.getStackTraceString(e)).a();
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
            } catch (JSONException e) {
                new b.c(context).a(Log.getStackTraceString(e)).a();
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
            } catch (JSONException e) {
                new b.c(context).a(Log.getStackTraceString(e)).a();
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }
}
