package com.baidu.android.util.io;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Locale;
import org.apache.commons.codec.binary4util.Base64;
@Deprecated
/* loaded from: classes.dex */
public class DataUri {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "DataUri";
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] mData;
    public final String mMimeType;

    public DataUri(String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMimeType = str;
        this.mData = bArr;
    }

    public static DataUri parseDataUri(String str) {
        InterceptResult invokeL;
        int indexOf;
        String str2;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith(WebGLImageLoader.DATA_URL) || (indexOf = str.indexOf(44)) == -1) {
                return null;
            }
            String substring = str.substring(5, indexOf);
            String substring2 = str.substring(indexOf + 1);
            String[] split = substring.split(ParamableElem.DIVIDE_PARAM);
            if (split.length != 2 || !"base64".equalsIgnoreCase(split[1])) {
                return null;
            }
            try {
                str2 = URLDecoder.decode(split[0], "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                str2 = null;
            }
            if (str2 == null) {
                str2 = split[0];
            }
            try {
                bArr = Base64.decodeBase64(substring2);
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                bArr = null;
            }
            if (bArr == null) {
                return null;
            }
            return new DataUri(str2, bArr);
        }
        return (DataUri) invokeL.objValue;
    }

    public byte[] getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mData;
        }
        return (byte[]) invokeV.objValue;
    }

    public String getMimeType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mMimeType;
        }
        return (String) invokeV.objValue;
    }
}
