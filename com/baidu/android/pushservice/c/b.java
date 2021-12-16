package com.baidu.android.pushservice.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f32659b;

    /* renamed from: c  reason: collision with root package name */
    public String f32660c;

    /* renamed from: d  reason: collision with root package name */
    public String f32661d;

    /* renamed from: e  reason: collision with root package name */
    public String f32662e;

    /* renamed from: f  reason: collision with root package name */
    public String f32663f;

    /* renamed from: g  reason: collision with root package name */
    public String f32664g;

    /* renamed from: h  reason: collision with root package name */
    public String f32665h;

    /* renamed from: i  reason: collision with root package name */
    public String f32666i;

    /* renamed from: j  reason: collision with root package name */
    public String f32667j;

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
        this.a = 0L;
        this.f32659b = 0L;
        this.f32660c = "";
        this.f32661d = "";
        this.f32662e = "";
        this.f32663f = "";
        this.f32664g = "";
        this.f32665h = "";
        this.f32666i = "";
        this.f32667j = "";
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            long j2 = this.a;
            if (j2 > -1) {
                jSONObject.put("push_priority", j2);
            }
            long j3 = this.f32659b;
            if (j3 > -1) {
                jSONObject.put("push_version", j3);
            }
            jSONObject.put("push_channelid", this.f32660c);
            jSONObject.put("push_newchannelid", this.f32661d);
            jSONObject.put("push_curpkgname", this.f32662e);
            jSONObject.put("push_webappbindinfo", this.f32663f);
            jSONObject.put("push_lightappbindinfo", this.f32664g);
            jSONObject.put("push_sdkclientbindinfo", this.f32665h);
            jSONObject.put("push_clientsbindinfo", this.f32666i);
            jSONObject.put("push_selfbindinfo", this.f32667j);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
