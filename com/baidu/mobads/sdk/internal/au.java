package com.baidu.mobads.sdk.internal;

import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes3.dex */
public class au extends at {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String b = "logout";
    public static final String[] c;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.mobads.sdk.internal.at, com.baidu.mobads.sdk.internal.av.a
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1833693083, "Lcom/baidu/mobads/sdk/internal/au;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1833693083, "Lcom/baidu/mobads/sdk/internal/au;");
                return;
            }
        }
        c = new String[]{"#", "#", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "D", "I", ExifInterface.LONGITUDE_WEST, ExifInterface.LONGITUDE_EAST, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS};
    }

    public au() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.at, com.baidu.mobads.sdk.internal.av.a
    public void a(int i, String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, str2, th}) == null) {
            try {
                IXAdContainerFactory c2 = z.a().c();
                if (c2 != null) {
                    c2.getRemoteParam("debugLogout", (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS", Locale.getDefault()).format(new Date()) + " " + c[i] + "/" + str + ": ") + "当前线程：" + Thread.currentThread().getName() + ";  调用位置：" + c() + ";  打印消息：" + str2 + "\n");
                }
            } catch (Throwable unused) {
            }
        }
    }
}
