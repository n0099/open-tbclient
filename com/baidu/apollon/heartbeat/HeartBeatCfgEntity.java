package com.baidu.apollon.heartbeat;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.utils.FileCopyUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.Serializable;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class HeartBeatCfgEntity implements NoProguard, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String HEART_BEAT_CFG_UNUSE = "0";
    public static final String HEART_BEAT_CFG_USED = "1";
    public static final String TAG;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String KA_CFG_TIME;
    public String KA_INIT;
    public String KA_MAX;
    public String KA_SWITCH;
    public String KA_TIMEOUT;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1768108383, "Lcom/baidu/apollon/heartbeat/HeartBeatCfgEntity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1768108383, "Lcom/baidu/apollon/heartbeat/HeartBeatCfgEntity;");
                return;
            }
        }
        TAG = HeartBeatCfgEntity.class.getSimpleName();
    }

    public HeartBeatCfgEntity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static HeartBeatCfgEntity build(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HeartBeatCfgEntity heartBeatCfgEntity = new HeartBeatCfgEntity();
            try {
                JSONObject jSONObject = new JSONObject(str);
                heartBeatCfgEntity.KA_SWITCH = jSONObject.optString("KA_SWITCH");
                heartBeatCfgEntity.KA_INIT = jSONObject.optString("KA_INIT");
                heartBeatCfgEntity.KA_MAX = jSONObject.optString("KA_MAX");
                heartBeatCfgEntity.KA_TIMEOUT = jSONObject.optString("KA_TIMEOUT");
                heartBeatCfgEntity.KA_CFG_TIME = jSONObject.optString("KA_CFG_TIME");
                return heartBeatCfgEntity;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return heartBeatCfgEntity;
            }
        }
        return (HeartBeatCfgEntity) invokeL.objValue;
    }

    public boolean checkResponseValidity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TextUtils.equals(this.KA_SWITCH, "0") || TextUtils.equals(this.KA_SWITCH, "1") : invokeV.booleanValue;
    }

    public boolean isUsed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TextUtils.equals(this.KA_SWITCH, "1") : invokeV.booleanValue;
    }

    public boolean isValidRequestTime(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            if (TextUtils.isEmpty(this.KA_CFG_TIME)) {
                return false;
            }
            long longValue = Long.valueOf(this.KA_CFG_TIME).longValue();
            if (longValue >= 0) {
                long timeInMillis = Calendar.getInstance().getTimeInMillis() / 1000;
                if (timeInMillis > j + longValue) {
                    return true;
                }
                String str = TAG;
                LogUtil.w(str, TAG + " isValidRequestTime currentTime:" + timeInMillis + ", lastTime:" + j + ", cfgTime:" + longValue);
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public void storeResponse(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            String json = JsonUtils.toJson(this);
            if (!TextUtils.isEmpty(json)) {
                FileCopyUtils.copyToFile(json, new File(context.getCacheDir() + File.separator + a.f35977b));
            }
            c.a(context, c.f36004b, Calendar.getInstance().getTimeInMillis() / 1000);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return " KA_SWITCH:" + this.KA_SWITCH + ",KA_INIT:" + this.KA_INIT + ",KA_MAX:" + this.KA_MAX + ",KA_TIMEOUT:" + this.KA_TIMEOUT + ", KA_CFG_TIME:" + this.KA_CFG_TIME;
        }
        return (String) invokeV.objValue;
    }

    public boolean validate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            boolean z = false;
            if (!TextUtils.isEmpty(this.KA_TIMEOUT) && !TextUtils.isEmpty(this.KA_INIT) && !TextUtils.isEmpty(this.KA_MAX) && !TextUtils.isEmpty(this.KA_CFG_TIME)) {
                try {
                    int intValue = Integer.valueOf(this.KA_TIMEOUT).intValue();
                    int intValue2 = Integer.valueOf(this.KA_INIT).intValue();
                    if (intValue > 0 && intValue2 < intValue) {
                        z = true;
                    }
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
            if (!z) {
                String str = TAG;
                LogUtil.errord(str, TAG + " validate exception,KA_INIT:" + this.KA_INIT + ", KA_TIMEOUT:" + this.KA_TIMEOUT + ", KA_MAX:" + this.KA_MAX + ", KA_CFG_TIME:" + this.KA_CFG_TIME);
            }
            return z;
        }
        return invokeV.booleanValue;
    }
}
