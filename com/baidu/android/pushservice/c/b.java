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
    public long f37026a;

    /* renamed from: b  reason: collision with root package name */
    public long f37027b;

    /* renamed from: c  reason: collision with root package name */
    public String f37028c;

    /* renamed from: d  reason: collision with root package name */
    public String f37029d;

    /* renamed from: e  reason: collision with root package name */
    public String f37030e;

    /* renamed from: f  reason: collision with root package name */
    public String f37031f;

    /* renamed from: g  reason: collision with root package name */
    public String f37032g;

    /* renamed from: h  reason: collision with root package name */
    public String f37033h;

    /* renamed from: i  reason: collision with root package name */
    public String f37034i;

    /* renamed from: j  reason: collision with root package name */
    public String f37035j;

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
        this.f37026a = 0L;
        this.f37027b = 0L;
        this.f37028c = "";
        this.f37029d = "";
        this.f37030e = "";
        this.f37031f = "";
        this.f37032g = "";
        this.f37033h = "";
        this.f37034i = "";
        this.f37035j = "";
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            long j2 = this.f37026a;
            if (j2 > -1) {
                jSONObject.put("push_priority", j2);
            }
            long j3 = this.f37027b;
            if (j3 > -1) {
                jSONObject.put("push_version", j3);
            }
            jSONObject.put("push_channelid", this.f37028c);
            jSONObject.put("push_newchannelid", this.f37029d);
            jSONObject.put("push_curpkgname", this.f37030e);
            jSONObject.put("push_webappbindinfo", this.f37031f);
            jSONObject.put("push_lightappbindinfo", this.f37032g);
            jSONObject.put("push_sdkclientbindinfo", this.f37033h);
            jSONObject.put("push_clientsbindinfo", this.f37034i);
            jSONObject.put("push_selfbindinfo", this.f37035j);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
