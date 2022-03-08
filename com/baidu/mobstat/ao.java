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
/* loaded from: classes4.dex */
public class ao {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f35045b;

    /* renamed from: c  reason: collision with root package name */
    public String f35046c;

    /* renamed from: d  reason: collision with root package name */
    public long f35047d;

    /* renamed from: e  reason: collision with root package name */
    public long f35048e;

    /* renamed from: f  reason: collision with root package name */
    public float f35049f;

    /* renamed from: g  reason: collision with root package name */
    public float f35050g;

    /* renamed from: h  reason: collision with root package name */
    public float f35051h;

    /* renamed from: i  reason: collision with root package name */
    public float f35052i;

    /* renamed from: j  reason: collision with root package name */
    public String f35053j;
    public boolean k;
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
        this.f35045b = str2;
        this.f35046c = str3;
        this.f35047d = j2;
        this.f35048e = j3;
        this.f35049f = f2;
        this.f35050g = f3;
        this.f35051h = f4;
        this.f35052i = f5;
        this.f35053j = str4;
        this.k = z;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f35053j : (String) invokeV.objValue;
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
                jSONObject.put("t", this.f35045b);
                jSONObject.put("d", this.f35047d);
                long j3 = this.f35048e - j2;
                if (j3 <= 0) {
                    j3 = 0;
                }
                jSONObject.put("ps", j3);
                jSONObject.put("at", 1);
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
                decimalFormatSymbols.setDecimalSeparator('.');
                decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
                jSONObject.put("xc", decimalFormat.format(this.f35049f));
                jSONObject.put("yc", decimalFormat.format(this.f35050g));
                jSONObject.put("xt", decimalFormat.format(this.f35051h));
                jSONObject.put("yt", decimalFormat.format(this.f35052i));
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
