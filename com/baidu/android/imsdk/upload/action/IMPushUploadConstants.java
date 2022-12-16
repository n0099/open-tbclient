package com.baidu.android.imsdk.upload.action;

import android.annotation.SuppressLint;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public class IMPushUploadConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BIM_LOG_ID = "log-id";
    public static final int ERROR_CODE = -1;
    public static final String ONLINE_URL = "https://pimlog.baidu.com/LogService/PushIMLog";
    public static final String RD_URL = "http://10.227.21.143:8900/LogService/PushIMLog";
    public static final String TAG = "BIMUploadUbc";
    public static final int VERSION = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class Service {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String BAIDU_APP = "baidu_app";
        public transient /* synthetic */ FieldHolder $fh;

        public Service() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public IMPushUploadConstants() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String md5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            try {
                byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    int i = b & 255;
                    if (i < 16) {
                        sb.append(0);
                    }
                    sb.append(Integer.toHexString(i));
                }
                Log.d(TAG, "sign origin :" + str + ", md5: " + sb.toString());
                return sb.toString();
            } catch (NoSuchAlgorithmException e) {
                Log.e(TAG, "md5 exception ", e);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"DefaultLocale"})
    public static String sign(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, str, j)) == null) {
            return md5(String.format("%d%s%d", 1, str.toLowerCase(), Long.valueOf(j)));
        }
        return (String) invokeLJ.objValue;
    }
}
