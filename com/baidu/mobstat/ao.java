package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ao {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f41005a;

    /* renamed from: b  reason: collision with root package name */
    public String f41006b;

    /* renamed from: c  reason: collision with root package name */
    public String f41007c;

    /* renamed from: d  reason: collision with root package name */
    public long f41008d;

    /* renamed from: e  reason: collision with root package name */
    public long f41009e;

    /* renamed from: f  reason: collision with root package name */
    public float f41010f;

    /* renamed from: g  reason: collision with root package name */
    public float f41011g;

    /* renamed from: h  reason: collision with root package name */
    public float f41012h;

    /* renamed from: i  reason: collision with root package name */
    public float f41013i;
    public String j;
    public boolean k;
    public String l;

    public ao(String str, String str2, String str3, long j, long j2, float f2, float f3, float f4, float f5, String str4, boolean z, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {str, str2, str3, Long.valueOf(j), Long.valueOf(j2), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), str4, Boolean.valueOf(z), str5};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41005a = str;
        this.f41006b = str2;
        this.f41007c = str3;
        this.f41008d = j;
        this.f41009e = j2;
        this.f41010f = f2;
        this.f41011g = f3;
        this.f41012h = f4;
        this.f41013i = f5;
        this.j = str4;
        this.k = z;
        this.l = str5;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f41005a : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public JSONObject a(long j, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), str, str2})) == null) {
            if (TextUtils.isEmpty(this.l)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("n", str);
                jSONObject.put("t", this.f41006b);
                jSONObject.put("d", this.f41008d);
                long j2 = this.f41009e - j;
                if (j2 <= 0) {
                    j2 = 0;
                }
                jSONObject.put("ps", j2);
                jSONObject.put("at", 1);
                DecimalFormat decimalFormat = new DecimalFormat(XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT);
                DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
                decimalFormatSymbols.setDecimalSeparator('.');
                decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
                jSONObject.put("xc", decimalFormat.format(this.f41010f));
                jSONObject.put("yc", decimalFormat.format(this.f41011g));
                jSONObject.put("xt", decimalFormat.format(this.f41012h));
                jSONObject.put("yt", decimalFormat.format(this.f41013i));
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
