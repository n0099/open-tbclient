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
    public long f37074a;

    /* renamed from: b  reason: collision with root package name */
    public long f37075b;

    /* renamed from: c  reason: collision with root package name */
    public String f37076c;

    /* renamed from: d  reason: collision with root package name */
    public String f37077d;

    /* renamed from: e  reason: collision with root package name */
    public String f37078e;

    /* renamed from: f  reason: collision with root package name */
    public String f37079f;

    /* renamed from: g  reason: collision with root package name */
    public String f37080g;

    /* renamed from: h  reason: collision with root package name */
    public String f37081h;

    /* renamed from: i  reason: collision with root package name */
    public String f37082i;

    /* renamed from: j  reason: collision with root package name */
    public String f37083j;

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
        this.f37074a = 0L;
        this.f37075b = 0L;
        this.f37076c = "";
        this.f37077d = "";
        this.f37078e = "";
        this.f37079f = "";
        this.f37080g = "";
        this.f37081h = "";
        this.f37082i = "";
        this.f37083j = "";
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            long j2 = this.f37074a;
            if (j2 > -1) {
                jSONObject.put("push_priority", j2);
            }
            long j3 = this.f37075b;
            if (j3 > -1) {
                jSONObject.put("push_version", j3);
            }
            jSONObject.put("push_channelid", this.f37076c);
            jSONObject.put("push_newchannelid", this.f37077d);
            jSONObject.put("push_curpkgname", this.f37078e);
            jSONObject.put("push_webappbindinfo", this.f37079f);
            jSONObject.put("push_lightappbindinfo", this.f37080g);
            jSONObject.put("push_sdkclientbindinfo", this.f37081h);
            jSONObject.put("push_clientsbindinfo", this.f37082i);
            jSONObject.put("push_selfbindinfo", this.f37083j);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
