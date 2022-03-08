package com.baidu.sapi2.result;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.utils.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class OneKeyLoginOptResult implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "OneKeyLoginOptResult";
    public transient /* synthetic */ FieldHolder $fh;
    public int code;
    public String extraStr;
    public String operateType;
    public String securityPhone;
    public int subCode;

    /* loaded from: classes4.dex */
    public interface OptResultFields {
        public static final String CODE = "0";
        public static final String EXTRA = "3";
        public static final String OPERATE_TYPE = "2";
        public static final String SECURITY_PHONE = "fakeMobile";
        public static final String SUB_CODE = "1";
    }

    public OneKeyLoginOptResult() {
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

    public static OneKeyLoginOptResult formatOptResult(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            OneKeyLoginOptResult oneKeyLoginOptResult = new OneKeyLoginOptResult();
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    oneKeyLoginOptResult.code = jSONObject.optInt("0", -202);
                    oneKeyLoginOptResult.subCode = jSONObject.optInt("1", -202);
                    oneKeyLoginOptResult.operateType = jSONObject.optString("2");
                    oneKeyLoginOptResult.extraStr = jSONObject.optString("3");
                } catch (JSONException e2) {
                    Log.e(TAG, e2.getMessage());
                }
            }
            return oneKeyLoginOptResult;
        }
        return (OneKeyLoginOptResult) invokeL.objValue;
    }

    public static boolean isValid(OneKeyLoginOptResult oneKeyLoginOptResult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, oneKeyLoginOptResult)) == null) ? (oneKeyLoginOptResult == null || oneKeyLoginOptResult.code != 0 || oneKeyLoginOptResult.subCode != 0 || TextUtils.isEmpty(oneKeyLoginOptResult.operateType) || TextUtils.isEmpty(oneKeyLoginOptResult.extraStr)) ? false : true : invokeL.booleanValue;
    }

    public void generateSecurityPhone() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Log.d(TAG, "generateSecurityPhone extraStr=" + this.extraStr);
            if (TextUtils.isEmpty(this.extraStr)) {
                return;
            }
            try {
                this.securityPhone = new JSONObject(this.extraStr).optString(OptResultFields.SECURITY_PHONE);
            } catch (JSONException e2) {
                Log.e(TAG, e2.getMessage());
            }
        }
    }

    public int getCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.code : invokeV.intValue;
    }

    public String getExtraStr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.extraStr : (String) invokeV.objValue;
    }

    public String getOperateType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.operateType : (String) invokeV.objValue;
    }

    public String getSecurityPhone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.securityPhone : (String) invokeV.objValue;
    }

    public int getSubCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.subCode : invokeV.intValue;
    }

    public void setCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.code = i2;
        }
    }

    public void setSubCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.subCode = i2;
        }
    }
}
