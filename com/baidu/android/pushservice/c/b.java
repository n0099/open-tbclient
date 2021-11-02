package com.baidu.android.pushservice.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f35123a;

    /* renamed from: b  reason: collision with root package name */
    public long f35124b;

    /* renamed from: c  reason: collision with root package name */
    public String f35125c;

    /* renamed from: d  reason: collision with root package name */
    public String f35126d;

    /* renamed from: e  reason: collision with root package name */
    public String f35127e;

    /* renamed from: f  reason: collision with root package name */
    public String f35128f;

    /* renamed from: g  reason: collision with root package name */
    public String f35129g;

    /* renamed from: h  reason: collision with root package name */
    public String f35130h;

    /* renamed from: i  reason: collision with root package name */
    public String f35131i;
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
        this.f35123a = 0L;
        this.f35124b = 0L;
        this.f35125c = "";
        this.f35126d = "";
        this.f35127e = "";
        this.f35128f = "";
        this.f35129g = "";
        this.f35130h = "";
        this.f35131i = "";
        this.j = "";
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            long j = this.f35123a;
            if (j > -1) {
                jSONObject.put("push_priority", j);
            }
            long j2 = this.f35124b;
            if (j2 > -1) {
                jSONObject.put("push_version", j2);
            }
            jSONObject.put("push_channelid", this.f35125c);
            jSONObject.put("push_newchannelid", this.f35126d);
            jSONObject.put("push_curpkgname", this.f35127e);
            jSONObject.put("push_webappbindinfo", this.f35128f);
            jSONObject.put("push_lightappbindinfo", this.f35129g);
            jSONObject.put("push_sdkclientbindinfo", this.f35130h);
            jSONObject.put("push_clientsbindinfo", this.f35131i);
            jSONObject.put("push_selfbindinfo", this.j);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
