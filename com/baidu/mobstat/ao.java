package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ao {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f37487b;

    /* renamed from: c  reason: collision with root package name */
    public String f37488c;

    /* renamed from: d  reason: collision with root package name */
    public long f37489d;

    /* renamed from: e  reason: collision with root package name */
    public long f37490e;

    /* renamed from: f  reason: collision with root package name */
    public float f37491f;

    /* renamed from: g  reason: collision with root package name */
    public float f37492g;

    /* renamed from: h  reason: collision with root package name */
    public float f37493h;

    /* renamed from: i  reason: collision with root package name */
    public float f37494i;

    /* renamed from: j  reason: collision with root package name */
    public String f37495j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f37496k;
    public String l;

    public ao(String str, String str2, String str3, long j2, long j3, float f2, float f3, float f4, float f5, String str4, boolean z, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {str, str2, str3, Long.valueOf(j2), Long.valueOf(j3), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), str4, Boolean.valueOf(z), str5};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        this.f37487b = str2;
        this.f37488c = str3;
        this.f37489d = j2;
        this.f37490e = j3;
        this.f37491f = f2;
        this.f37492g = f3;
        this.f37493h = f4;
        this.f37494i = f5;
        this.f37495j = str4;
        this.f37496k = z;
        this.l = str5;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f37495j : (String) invokeV.objValue;
    }

    public JSONObject a(long j2, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), str, str2})) == null) {
            if (TextUtils.isEmpty(this.l)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("n", str);
                jSONObject.put("t", this.f37487b);
                jSONObject.put("d", this.f37489d);
                long j3 = this.f37490e - j2;
                if (j3 <= 0) {
                    j3 = 0;
                }
                jSONObject.put("ps", j3);
                jSONObject.put("at", 1);
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
                decimalFormatSymbols.setDecimalSeparator('.');
                decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
                jSONObject.put("xc", decimalFormat.format(this.f37491f));
                jSONObject.put("yc", decimalFormat.format(this.f37492g));
                jSONObject.put("xt", decimalFormat.format(this.f37493h));
                jSONObject.put("yt", decimalFormat.format(this.f37494i));
                jSONObject.put("h5", 0);
                jSONObject.put("sign", this.l);
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeCommon.objValue;
    }
}
