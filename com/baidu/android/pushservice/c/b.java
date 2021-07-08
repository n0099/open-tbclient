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
    public long f2894a;

    /* renamed from: b  reason: collision with root package name */
    public long f2895b;

    /* renamed from: c  reason: collision with root package name */
    public String f2896c;

    /* renamed from: d  reason: collision with root package name */
    public String f2897d;

    /* renamed from: e  reason: collision with root package name */
    public String f2898e;

    /* renamed from: f  reason: collision with root package name */
    public String f2899f;

    /* renamed from: g  reason: collision with root package name */
    public String f2900g;

    /* renamed from: h  reason: collision with root package name */
    public String f2901h;

    /* renamed from: i  reason: collision with root package name */
    public String f2902i;
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
        this.f2894a = 0L;
        this.f2895b = 0L;
        this.f2896c = "";
        this.f2897d = "";
        this.f2898e = "";
        this.f2899f = "";
        this.f2900g = "";
        this.f2901h = "";
        this.f2902i = "";
        this.j = "";
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            long j = this.f2894a;
            if (j > -1) {
                jSONObject.put("push_priority", j);
            }
            long j2 = this.f2895b;
            if (j2 > -1) {
                jSONObject.put("push_version", j2);
            }
            jSONObject.put("push_channelid", this.f2896c);
            jSONObject.put("push_newchannelid", this.f2897d);
            jSONObject.put("push_curpkgname", this.f2898e);
            jSONObject.put("push_webappbindinfo", this.f2899f);
            jSONObject.put("push_lightappbindinfo", this.f2900g);
            jSONObject.put("push_sdkclientbindinfo", this.f2901h);
            jSONObject.put("push_clientsbindinfo", this.f2902i);
            jSONObject.put("push_selfbindinfo", this.j);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
