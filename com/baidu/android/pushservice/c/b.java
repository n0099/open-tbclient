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
    public long f36907a;

    /* renamed from: b  reason: collision with root package name */
    public long f36908b;

    /* renamed from: c  reason: collision with root package name */
    public String f36909c;

    /* renamed from: d  reason: collision with root package name */
    public String f36910d;

    /* renamed from: e  reason: collision with root package name */
    public String f36911e;

    /* renamed from: f  reason: collision with root package name */
    public String f36912f;

    /* renamed from: g  reason: collision with root package name */
    public String f36913g;

    /* renamed from: h  reason: collision with root package name */
    public String f36914h;

    /* renamed from: i  reason: collision with root package name */
    public String f36915i;

    /* renamed from: j  reason: collision with root package name */
    public String f36916j;

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
        this.f36907a = 0L;
        this.f36908b = 0L;
        this.f36909c = "";
        this.f36910d = "";
        this.f36911e = "";
        this.f36912f = "";
        this.f36913g = "";
        this.f36914h = "";
        this.f36915i = "";
        this.f36916j = "";
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            long j2 = this.f36907a;
            if (j2 > -1) {
                jSONObject.put("push_priority", j2);
            }
            long j3 = this.f36908b;
            if (j3 > -1) {
                jSONObject.put("push_version", j3);
            }
            jSONObject.put("push_channelid", this.f36909c);
            jSONObject.put("push_newchannelid", this.f36910d);
            jSONObject.put("push_curpkgname", this.f36911e);
            jSONObject.put("push_webappbindinfo", this.f36912f);
            jSONObject.put("push_lightappbindinfo", this.f36913g);
            jSONObject.put("push_sdkclientbindinfo", this.f36914h);
            jSONObject.put("push_clientsbindinfo", this.f36915i);
            jSONObject.put("push_selfbindinfo", this.f36916j);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
