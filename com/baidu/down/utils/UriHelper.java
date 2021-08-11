package com.baidu.down.utils;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes5.dex */
public class UriHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "UriHelper";
    public transient /* synthetic */ FieldHolder $fh;
    public String mUri;
    public Uri mUriObj;
    public UriQuery mUriQueryObj;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-298499330, "Lcom/baidu/down/utils/UriHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-298499330, "Lcom/baidu/down/utils/UriHelper;");
        }
    }

    public UriHelper(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mUriObj = null;
        this.mUri = "";
        this.mUriQueryObj = null;
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            this.mUriObj = parse;
            init(parse);
            return;
        }
        throw new NullPointerException("uri is null");
    }

    public static String getDecodedValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                return URLDecoder.decode(str, "utf-8");
            } catch (UnsupportedEncodingException | Exception unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    private void init(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, uri) == null) {
            this.mUriQueryObj = new UriQuery(uri.getEncodedQuery());
            String uri2 = uri.toString();
            this.mUri = uri2;
            int indexOf = uri2.indexOf("?");
            if (indexOf > 0) {
                this.mUri = this.mUri.substring(0, indexOf);
            }
        }
    }

    public void addParameterReplaceIfExist(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            this.mUriQueryObj.addParam(str, str2);
        }
    }

    public void addWholeParameterReplaceIfExist(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        String[] split = str.split("=");
        if (split.length == 2) {
            this.mUriQueryObj.addParam(split[0], split[1]);
        }
    }

    public String getParameter(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.mUriQueryObj.getParameter(str) : (String) invokeL.objValue;
    }

    public String getQuery() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mUriQueryObj.getQuery() : (String) invokeV.objValue;
    }

    public String getServerUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mUri : (String) invokeV.objValue;
    }

    public void removeParameter(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.mUriQueryObj.removeParam(str);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String str = this.mUri;
            if (TextUtils.isEmpty(this.mUriQueryObj.getQuery())) {
                return str;
            }
            return str + "?" + this.mUriQueryObj.getQuery();
        }
        return (String) invokeV.objValue;
    }

    public UriHelper(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mUriObj = null;
        this.mUri = "";
        this.mUriQueryObj = null;
        if (uri != null) {
            this.mUriObj = uri;
            init(uri);
            return;
        }
        throw new NullPointerException("uri is null");
    }
}
