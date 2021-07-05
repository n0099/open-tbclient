package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.android.common.others.IStringUtil;
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
/* loaded from: classes3.dex */
public class ao {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f8666a;

    /* renamed from: b  reason: collision with root package name */
    public String f8667b;

    /* renamed from: c  reason: collision with root package name */
    public String f8668c;

    /* renamed from: d  reason: collision with root package name */
    public long f8669d;

    /* renamed from: e  reason: collision with root package name */
    public long f8670e;

    /* renamed from: f  reason: collision with root package name */
    public float f8671f;

    /* renamed from: g  reason: collision with root package name */
    public float f8672g;

    /* renamed from: h  reason: collision with root package name */
    public float f8673h;

    /* renamed from: i  reason: collision with root package name */
    public float f8674i;
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
        this.f8666a = str;
        this.f8667b = str2;
        this.f8668c = str3;
        this.f8669d = j;
        this.f8670e = j2;
        this.f8671f = f2;
        this.f8672g = f3;
        this.f8673h = f4;
        this.f8674i = f5;
        this.j = str4;
        this.k = z;
        this.l = str5;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f8666a : (String) invokeV.objValue;
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
                jSONObject.put("t", this.f8667b);
                jSONObject.put("d", this.f8669d);
                long j2 = this.f8670e - j;
                if (j2 <= 0) {
                    j2 = 0;
                }
                jSONObject.put("ps", j2);
                jSONObject.put("at", 1);
                DecimalFormat decimalFormat = new DecimalFormat(XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT);
                DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
                decimalFormatSymbols.setDecimalSeparator(IStringUtil.EXTENSION_SEPARATOR);
                decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
                jSONObject.put(Config.SESSTION_ACTIVITY_X_VIEW_HEIGHT, decimalFormat.format(this.f8671f));
                jSONObject.put(Config.SESSTION_ACTIVITY_Y_VIEW_HEIGHT, decimalFormat.format(this.f8672g));
                jSONObject.put(Config.SESSTION_ACTIVITY_X_TOTAL_HEIGHT, decimalFormat.format(this.f8673h));
                jSONObject.put(Config.SESSTION_ACTIVITY_Y_TOTAL_HEIGHT, decimalFormat.format(this.f8674i));
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
