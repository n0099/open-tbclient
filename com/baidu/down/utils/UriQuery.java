package com.baidu.down.utils;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class UriQuery {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "UriQuery";
    public transient /* synthetic */ FieldHolder $fh;
    public String mBackupQuery;
    public boolean mBackupQueryDirty;
    public HashMap<String, String> mEncodedValuesCache;
    public HashMap<String, String> mParams;
    public String mQuery;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1925171618, "Lcom/baidu/down/utils/UriQuery;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1925171618, "Lcom/baidu/down/utils/UriQuery;");
        }
    }

    public UriQuery(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mQuery = "";
        this.mParams = new HashMap<>();
        this.mBackupQueryDirty = false;
        this.mBackupQuery = null;
        this.mEncodedValuesCache = new HashMap<>();
        this.mQuery = str;
        parseQuery();
    }

    private String getEncodedValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            String str2 = this.mEncodedValuesCache.get(str);
            if (str2 == null) {
                String encodedValue = Utils.getEncodedValue(str);
                this.mEncodedValuesCache.put(str, encodedValue);
                return encodedValue;
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    private void parseQuery() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || TextUtils.isEmpty(this.mQuery)) {
            return;
        }
        String[] split = this.mQuery.split("&");
        for (int i2 = 0; i2 < split.length; i2++) {
            int indexOf = split[i2].indexOf("=");
            if (indexOf >= 0) {
                this.mParams.put(UriHelper.getDecodedValue(split[i2].substring(0, indexOf)), UriHelper.getDecodedValue(split[i2].substring(indexOf + 1)));
            } else {
                this.mParams.put(UriHelper.getDecodedValue(split[i2]), "");
            }
        }
        this.mBackupQueryDirty = true;
    }

    public void addParam(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mParams.put(str, str2);
        this.mBackupQueryDirty = true;
    }

    public String getParameter(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.mParams.get(str) : (String) invokeL.objValue;
    }

    public String getQuery() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!this.mBackupQueryDirty) {
                return this.mBackupQuery;
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (String str : this.mParams.keySet()) {
                stringBuffer.append(str);
                stringBuffer.append("=");
                stringBuffer.append(getEncodedValue(this.mParams.get(str)));
                stringBuffer.append("&");
            }
            String stringBuffer2 = stringBuffer.toString();
            this.mBackupQueryDirty = false;
            this.mBackupQuery = stringBuffer2;
            return stringBuffer2;
        }
        return (String) invokeV.objValue;
    }

    public void removeParam(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mParams.remove(str);
        this.mBackupQueryDirty = true;
    }
}
