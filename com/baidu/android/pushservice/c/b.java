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
    public long f2891a;

    /* renamed from: b  reason: collision with root package name */
    public long f2892b;

    /* renamed from: c  reason: collision with root package name */
    public String f2893c;

    /* renamed from: d  reason: collision with root package name */
    public String f2894d;

    /* renamed from: e  reason: collision with root package name */
    public String f2895e;

    /* renamed from: f  reason: collision with root package name */
    public String f2896f;

    /* renamed from: g  reason: collision with root package name */
    public String f2897g;

    /* renamed from: h  reason: collision with root package name */
    public String f2898h;

    /* renamed from: i  reason: collision with root package name */
    public String f2899i;
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
        this.f2891a = 0L;
        this.f2892b = 0L;
        this.f2893c = "";
        this.f2894d = "";
        this.f2895e = "";
        this.f2896f = "";
        this.f2897g = "";
        this.f2898h = "";
        this.f2899i = "";
        this.j = "";
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            long j = this.f2891a;
            if (j > -1) {
                jSONObject.put("push_priority", j);
            }
            long j2 = this.f2892b;
            if (j2 > -1) {
                jSONObject.put("push_version", j2);
            }
            jSONObject.put("push_channelid", this.f2893c);
            jSONObject.put("push_newchannelid", this.f2894d);
            jSONObject.put("push_curpkgname", this.f2895e);
            jSONObject.put("push_webappbindinfo", this.f2896f);
            jSONObject.put("push_lightappbindinfo", this.f2897g);
            jSONObject.put("push_sdkclientbindinfo", this.f2898h);
            jSONObject.put("push_clientsbindinfo", this.f2899i);
            jSONObject.put("push_selfbindinfo", this.j);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
