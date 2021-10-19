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
    public long f37078a;

    /* renamed from: b  reason: collision with root package name */
    public long f37079b;

    /* renamed from: c  reason: collision with root package name */
    public String f37080c;

    /* renamed from: d  reason: collision with root package name */
    public String f37081d;

    /* renamed from: e  reason: collision with root package name */
    public String f37082e;

    /* renamed from: f  reason: collision with root package name */
    public String f37083f;

    /* renamed from: g  reason: collision with root package name */
    public String f37084g;

    /* renamed from: h  reason: collision with root package name */
    public String f37085h;

    /* renamed from: i  reason: collision with root package name */
    public String f37086i;

    /* renamed from: j  reason: collision with root package name */
    public String f37087j;

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
        this.f37078a = 0L;
        this.f37079b = 0L;
        this.f37080c = "";
        this.f37081d = "";
        this.f37082e = "";
        this.f37083f = "";
        this.f37084g = "";
        this.f37085h = "";
        this.f37086i = "";
        this.f37087j = "";
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            long j2 = this.f37078a;
            if (j2 > -1) {
                jSONObject.put("push_priority", j2);
            }
            long j3 = this.f37079b;
            if (j3 > -1) {
                jSONObject.put("push_version", j3);
            }
            jSONObject.put("push_channelid", this.f37080c);
            jSONObject.put("push_newchannelid", this.f37081d);
            jSONObject.put("push_curpkgname", this.f37082e);
            jSONObject.put("push_webappbindinfo", this.f37083f);
            jSONObject.put("push_lightappbindinfo", this.f37084g);
            jSONObject.put("push_sdkclientbindinfo", this.f37085h);
            jSONObject.put("push_clientsbindinfo", this.f37086i);
            jSONObject.put("push_selfbindinfo", this.f37087j);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
