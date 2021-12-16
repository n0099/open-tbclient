package com.baidu.android.imsdk.upload.action;

import android.annotation.SuppressLint;
import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes9.dex */
public class IMPushUploadConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BIM_LOG_ID = "log-id";
    public static final int ERROR_CODE = -1;
    public static final String ONLINE_URL = "https://pimlog.baidu.com/LogService/PushIMLog";
    public static final String TAG = "BIMUploadUbc";
    public static final String TEST_URL = "http://bjhw-ps-superpage131.bjhw.baidu.com:8900/LogService/PushIMLog";
    public static final int VERSION = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class Service {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String BAIDU_APP = "baidu_app";
        public transient /* synthetic */ FieldHolder $fh;

        public Service() {
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

    public IMPushUploadConstants() {
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

    public static String md5(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            try {
                byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
                StringBuilder sb = new StringBuilder();
                for (byte b2 : digest) {
                    int i2 = b2 & 255;
                    if (i2 < 16) {
                        sb.append(0);
                    }
                    sb.append(Integer.toHexString(i2));
                }
                String str2 = "sign origin :" + str + ", md5: " + sb.toString();
                return sb.toString();
            } catch (NoSuchAlgorithmException unused) {
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    @SuppressLint({"DefaultLocale"})
    public static String sign(Context context, String str, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, str, Long.valueOf(j2)})) == null) ? md5(context, String.format("%d%s%d", 1, str.toLowerCase(), Long.valueOf(j2))) : (String) invokeCommon.objValue;
    }
}
