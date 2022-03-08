package com.baidu.android.util.io;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
public class BaseJsonData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int ERROR_CODE_OK = 0;
    public static final String TAG = "BaseJsonData";
    public static final String TAG_DATA = "data";
    public static final String TAG_ERRMSG = "errmsg";
    public static final String TAG_ERRNO = "errno";
    public static final String TAG_PUBLICSRV = "publicsrv";
    public static final String TAG_REQUESTID = "requestid";
    public static final String TAG_TIMESTAMP = "timestamp";
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject mData;
    public int mErrorCode;
    public String mErrorMessage;
    public String mRequestId;
    public long mTimestamp;

    public BaseJsonData() {
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
        this.mErrorCode = -1;
    }

    public static BaseJsonData fromJson(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return fromJson(new JSONObject(str));
            } catch (JSONException unused) {
                return null;
            }
        }
        return (BaseJsonData) invokeL.objValue;
    }

    public ActionJsonData getAction(String str, String str2) {
        InterceptResult invokeLL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (this.mData == null || TextUtils.isEmpty(str) || !this.mData.has(str) || this.mData.isNull(str) || (optJSONObject = this.mData.optJSONObject(str)) == null) {
                return null;
            }
            if (TextUtils.isEmpty(str2)) {
                return ActionJsonData.fromJson(optJSONObject);
            }
            return ActionJsonData.fromJson(optJSONObject.optJSONObject(str2));
        }
        return (ActionJsonData) invokeLL.objValue;
    }

    public JSONObject getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mData : (JSONObject) invokeV.objValue;
    }

    public int getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mErrorCode : invokeV.intValue;
    }

    public String getErrorMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mErrorMessage : (String) invokeV.objValue;
    }

    public String getRequestId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mRequestId : (String) invokeV.objValue;
    }

    public long getTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mTimestamp : invokeV.longValue;
    }

    public void setData(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) {
            this.mData = jSONObject;
        }
    }

    public void setErrorCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mErrorCode = i2;
        }
    }

    public void setErrorMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.mErrorMessage = str;
        }
    }

    public void setRequestId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.mRequestId = str;
        }
    }

    public void setTimestamp(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j2) == null) {
            this.mTimestamp = j2;
        }
    }

    public BaseJsonData(int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mErrorCode = -1;
        this.mErrorCode = i2;
        this.mData = jSONObject;
    }

    public static BaseJsonData fromJson(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, jSONObject)) != null) {
            return (BaseJsonData) invokeL.objValue;
        }
        BaseJsonData baseJsonData = null;
        try {
            int i2 = jSONObject.getInt("errno");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONObject == null) {
                optJSONObject = (optJSONArray == null || optJSONArray.length() <= 0) ? null : optJSONArray.getJSONObject(0);
            }
            BaseJsonData baseJsonData2 = new BaseJsonData(i2, optJSONObject);
            try {
                if (jSONObject.has("errmsg") && !jSONObject.isNull("errmsg")) {
                    baseJsonData2.setErrorMessage(jSONObject.getString("errmsg"));
                }
                if (jSONObject.has("timestamp") && !jSONObject.isNull("timestamp")) {
                    try {
                        baseJsonData2.setTimestamp(Long.valueOf(jSONObject.getString("timestamp")).longValue());
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                        baseJsonData2.setTimestamp(0L);
                    }
                }
                if (!jSONObject.has(TAG_REQUESTID) || jSONObject.isNull(TAG_REQUESTID)) {
                    return baseJsonData2;
                }
                baseJsonData2.setRequestId(jSONObject.optString(TAG_REQUESTID));
                return baseJsonData2;
            } catch (JSONException unused) {
                baseJsonData = baseJsonData2;
                return baseJsonData;
            }
        } catch (JSONException unused2) {
        }
    }
}
