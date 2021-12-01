package com.baidu.fsg.face.liveness.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.fsg.base.restnet.beans.business.core.utils.BdWalletUtils;
import com.baidu.fsg.base.restnet.fp.GetFPResponse;
import com.baidu.fsg.base.utils.JsonUtils;
import com.baidu.fsg.base.utils.SharedPreferencesUtils;
import com.baidu.fsg.face.base.dto.SapiBiometricDto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONException;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "request_data";

    /* renamed from: b  reason: collision with root package name */
    public static c f34741b = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f34742d = "RIM_LIVENESS_VIDEO_PREFERENCE";

    /* renamed from: e  reason: collision with root package name */
    public static final String f34743e = "RIM_LIVENESS_VIDEO_VIDEOENCODINGBITRATE";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, SapiBiometricDto> f34744c;

    public c() {
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
        this.f34744c = new HashMap<>();
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f34741b == null) {
                f34741b = new c();
            }
            return f34741b;
        }
        return (c) invokeV.objValue;
    }

    public void b() {
        HashMap<String, SapiBiometricDto> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (hashMap = this.f34744c) == null) {
            return;
        }
        hashMap.clear();
        this.f34744c = null;
    }

    public SapiBiometricDto a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            HashMap<String, SapiBiometricDto> hashMap = this.f34744c;
            if (hashMap != null) {
                return hashMap.get(str);
            }
            return null;
        }
        return (SapiBiometricDto) invokeL.objValue;
    }

    public int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            String localDecryptProxy = RimArmor.getInstance().localDecryptProxy((String) SharedPreferencesUtils.getParam(context, f34742d, f34743e, ""));
            try {
                if (TextUtils.isEmpty(localDecryptProxy)) {
                    return 1048576;
                }
                return Integer.parseInt(localDecryptProxy);
            } catch (Exception e2) {
                e2.printStackTrace();
                return 1048576;
            }
        }
        return invokeL.intValue;
    }

    public void a(String str, SapiBiometricDto sapiBiometricDto) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, sapiBiometricDto) == null) {
            if (this.f34744c == null) {
                this.f34744c = new HashMap<>();
            }
            this.f34744c.put(str, sapiBiometricDto);
        }
    }

    public GetFPResponse.LivenessConfig a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            String rimAllConfig = BdWalletUtils.getRimAllConfig(context.getApplicationContext());
            if (!TextUtils.isEmpty(rimAllConfig)) {
                try {
                    GetFPResponse.RimConfig rimConfig = (GetFPResponse.RimConfig) JsonUtils.fromJson(rimAllConfig, GetFPResponse.RimConfig.class);
                    if (rimConfig != null && rimConfig.living != null) {
                        return rimConfig.living;
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return new GetFPResponse.LivenessConfig();
        }
        return (GetFPResponse.LivenessConfig) invokeL.objValue;
    }

    public void a(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, context, i2) == null) || i2 <= 0) {
            return;
        }
        SharedPreferencesUtils.setParam(context, f34742d, f34743e, RimArmor.getInstance().localEncryptProxy(String.valueOf(i2)));
    }
}
