package com.baidu.android.pushservice.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f36801a;

    /* renamed from: b  reason: collision with root package name */
    public long f36802b;

    /* renamed from: c  reason: collision with root package name */
    public String f36803c;

    /* renamed from: d  reason: collision with root package name */
    public String f36804d;

    /* renamed from: e  reason: collision with root package name */
    public String f36805e;

    /* renamed from: f  reason: collision with root package name */
    public String f36806f;

    /* renamed from: g  reason: collision with root package name */
    public String f36807g;

    /* renamed from: h  reason: collision with root package name */
    public String f36808h;

    /* renamed from: i  reason: collision with root package name */
    public String f36809i;

    /* renamed from: j  reason: collision with root package name */
    public String f36810j;

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
        this.f36801a = 0L;
        this.f36802b = 0L;
        this.f36803c = "";
        this.f36804d = "";
        this.f36805e = "";
        this.f36806f = "";
        this.f36807g = "";
        this.f36808h = "";
        this.f36809i = "";
        this.f36810j = "";
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            long j2 = this.f36801a;
            if (j2 > -1) {
                jSONObject.put("push_priority", j2);
            }
            long j3 = this.f36802b;
            if (j3 > -1) {
                jSONObject.put("push_version", j3);
            }
            jSONObject.put("push_channelid", this.f36803c);
            jSONObject.put("push_newchannelid", this.f36804d);
            jSONObject.put("push_curpkgname", this.f36805e);
            jSONObject.put("push_webappbindinfo", this.f36806f);
            jSONObject.put("push_lightappbindinfo", this.f36807g);
            jSONObject.put("push_sdkclientbindinfo", this.f36808h);
            jSONObject.put("push_clientsbindinfo", this.f36809i);
            jSONObject.put("push_selfbindinfo", this.f36810j);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
