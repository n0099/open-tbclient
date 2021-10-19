package com.baidu.apollon.beans;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.StringUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class BeanResponseBase implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f37877a = "系统开小差，等一会儿再试吧";

    /* renamed from: b  reason: collision with root package name */
    public static final String f37878b = "content";

    /* renamed from: c  reason: collision with root package name */
    public static final String f37879c = "data";
    public transient /* synthetic */ FieldHolder $fh;
    public Session cashdesk;
    public JSONObject content;
    public String contentSign;
    public JSONObject data;
    public int encrypted;
    public JSONObject errContent;
    public String err_msg;
    public int err_no;
    public String mdAlgorithm;
    public String msg;
    public int result;
    public String result_info;
    public String result_string;
    public int ret;
    public String signature;
    public String token;

    /* loaded from: classes5.dex */
    public static class Session implements NoProguard, Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int biz_code;
        public String delete_flag;
        public String session_id;
        public String[] session_uri;

        public Session() {
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
    }

    public BeanResponseBase() {
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
        this.result = 0;
        this.err_no = 0;
        this.ret = 0;
        this.result_info = null;
        this.err_msg = null;
        this.msg = null;
        this.content = null;
        this.errContent = null;
        this.data = null;
        this.token = "";
        this.encrypted = 0;
        this.contentSign = "";
    }

    public String getContentsign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.contentSign : (String) invokeV.objValue;
    }

    public String getNameOfRealResponseContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.content == null && this.data != null) ? "data" : "content" : (String) invokeV.objValue;
    }

    public String getRealResponseContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject jSONObject = this.content;
            if (jSONObject != null) {
                return StringUtils.replaceBom(jSONObject.toString());
            }
            JSONObject jSONObject2 = this.data;
            return jSONObject2 != null ? StringUtils.replaceBom(jSONObject2.toString()) : "";
        }
        return (String) invokeV.objValue;
    }

    public String getRealResponseErrContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = this.errContent;
            return jSONObject != null ? StringUtils.replaceBom(jSONObject.toString()) : "";
        }
        return (String) invokeV.objValue;
    }

    public String getRealResponseMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!TextUtils.isEmpty(this.msg)) {
                return this.msg;
            }
            if (!TextUtils.isEmpty(this.err_msg)) {
                return this.err_msg;
            }
            if (TextUtils.isEmpty(this.result_info)) {
                return !TextUtils.isEmpty(this.result_string) ? this.result_string : f37877a;
            }
            return this.result_info;
        }
        return (String) invokeV.objValue;
    }

    public int getServerReturnValue(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cls)) == null) {
            int i2 = this.ret;
            if (i2 != 0) {
                return i2;
            }
            int i3 = this.result;
            if (i3 != 0) {
                return i3;
            }
            int i4 = this.err_no;
            if (i4 != 0) {
                return i4;
            }
            if (i2 == 0 && (this.content != null || cls == null || JsonUtils.DataType.isString(cls))) {
                return this.ret;
            }
            if (this.result == 0 && (this.data != null || cls == null || JsonUtils.DataType.isString(cls))) {
                return this.result;
            }
            int i5 = this.err_no;
            if (i5 == 0) {
                return i5;
            }
            return -3;
        }
        return invokeL.intValue;
    }

    public String getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.token : (String) invokeV.objValue;
    }

    public boolean needDecryption() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.encrypted == 1 : invokeV.booleanValue;
    }

    public boolean needVerifySignature() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (TextUtils.isEmpty(this.signature) || TextUtils.isEmpty(this.mdAlgorithm)) ? false : true : invokeV.booleanValue;
    }
}
