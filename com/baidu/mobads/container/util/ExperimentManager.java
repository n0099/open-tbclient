package com.baidu.mobads.container.util;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ExperimentManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ID_CTR_LP_BACK = "18797";
    public static final String ID_HIT_LP_BACK = "18798";
    public static final String KEY_CONTROL_FLAG = "control_flag";
    public static final String KEY_EXP_ID_ARRAY = "expids";
    public static final String TAG = "ExperimentManager";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class ExpHitStatus {
        public static final /* synthetic */ ExpHitStatus[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ExpHitStatus HIT_CTR_ID;
        public static final ExpHitStatus HIT_EXP_ID;
        public static final ExpHitStatus HIT_NONE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(677855025, "Lcom/baidu/mobads/container/util/ExperimentManager$ExpHitStatus;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(677855025, "Lcom/baidu/mobads/container/util/ExperimentManager$ExpHitStatus;");
                    return;
                }
            }
            HIT_EXP_ID = new ExpHitStatus("HIT_EXP_ID", 0);
            HIT_CTR_ID = new ExpHitStatus("HIT_CTR_ID", 1);
            ExpHitStatus expHitStatus = new ExpHitStatus("HIT_NONE", 2);
            HIT_NONE = expHitStatus;
            $VALUES = new ExpHitStatus[]{HIT_EXP_ID, HIT_CTR_ID, expHitStatus};
        }

        public ExpHitStatus(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ExpHitStatus valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ExpHitStatus) Enum.valueOf(ExpHitStatus.class, str) : (ExpHitStatus) invokeL.objValue;
        }

        public static ExpHitStatus[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ExpHitStatus[]) $VALUES.clone() : (ExpHitStatus[]) invokeV.objValue;
        }
    }

    public ExperimentManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static ExpHitStatus getHitResultForExp(JSONObject jSONObject, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, jSONObject, str, str2)) == null) {
            if (jSONObject != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                String optString = jSONObject.optString(KEY_CONTROL_FLAG);
                if (TextUtils.isEmpty(optString)) {
                    return ExpHitStatus.HIT_NONE;
                }
                try {
                    JSONArray optJSONArray = new JSONObject(optString).optJSONArray(KEY_EXP_ID_ARRAY);
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        int length = optJSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            if (str.equals(optJSONArray.optString(i2))) {
                                return ExpHitStatus.HIT_EXP_ID;
                            }
                            if (str2.equals(optJSONArray.optString(i2))) {
                                return ExpHitStatus.HIT_CTR_ID;
                            }
                        }
                    }
                } catch (JSONException unused) {
                    RemoteXAdLogger.getInstance().e(TAG, "parse json error.");
                }
                return ExpHitStatus.HIT_NONE;
            }
            return ExpHitStatus.HIT_NONE;
        }
        return (ExpHitStatus) invokeLLL.objValue;
    }

    public static boolean isAdInfoMatchLpBackExp(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            ExpHitStatus hitResultForExp = getHitResultForExp(jSONObject, ID_HIT_LP_BACK, ID_CTR_LP_BACK);
            RemoteXAdLogger remoteXAdLogger = RemoteXAdLogger.getInstance();
            remoteXAdLogger.d(TAG, "Lp back experiment: " + hitResultForExp);
            return ExpHitStatus.HIT_EXP_ID == hitResultForExp;
        }
        return invokeL.booleanValue;
    }
}
