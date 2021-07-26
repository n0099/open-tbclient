package com.baidu.android.pushservice.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f2920a;

    /* renamed from: b  reason: collision with root package name */
    public long f2921b;

    /* renamed from: c  reason: collision with root package name */
    public String f2922c;

    /* renamed from: d  reason: collision with root package name */
    public String f2923d;

    /* renamed from: e  reason: collision with root package name */
    public String f2924e;

    /* renamed from: f  reason: collision with root package name */
    public String f2925f;

    /* renamed from: g  reason: collision with root package name */
    public String f2926g;

    /* renamed from: h  reason: collision with root package name */
    public String f2927h;

    /* renamed from: i  reason: collision with root package name */
    public String f2928i;
    public String j;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f2920a = 0L;
        this.f2921b = 0L;
        this.f2922c = "";
        this.f2923d = "";
        this.f2924e = "";
        this.f2925f = "";
        this.f2926g = "";
        this.f2927h = "";
        this.f2928i = "";
        this.j = "";
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            long j = this.f2920a;
            if (j > -1) {
                jSONObject.put("push_priority", j);
            }
            long j2 = this.f2921b;
            if (j2 > -1) {
                jSONObject.put("push_version", j2);
            }
            jSONObject.put("push_channelid", this.f2922c);
            jSONObject.put("push_newchannelid", this.f2923d);
            jSONObject.put("push_curpkgname", this.f2924e);
            jSONObject.put("push_webappbindinfo", this.f2925f);
            jSONObject.put("push_lightappbindinfo", this.f2926g);
            jSONObject.put("push_sdkclientbindinfo", this.f2927h);
            jSONObject.put("push_clientsbindinfo", this.f2928i);
            jSONObject.put("push_selfbindinfo", this.j);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
