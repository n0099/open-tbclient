package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class IMConfigInternal {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMConfigInternal";
    public static IMConfigInternal sConfig;
    public transient /* synthetic */ FieldHolder $fh;
    public IIMConfig mConfig;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1655218899, "Lcom/baidu/android/imsdk/internal/IMConfigInternal;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1655218899, "Lcom/baidu/android/imsdk/internal/IMConfigInternal;");
        }
    }

    public IMConfigInternal() {
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

    private IIMConfig createConfig(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, context, str)) == null) {
            try {
                Class<?> cls = Class.forName(str);
                if (cls != null) {
                    try {
                        return (IIMConfig) cls.newInstance();
                    } catch (Exception e) {
                        new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
                        LogUtils.d(TAG, "Product line of jar is ERROR!");
                    }
                }
                LogUtils.d(TAG, "Init ERROR!");
                return null;
            } catch (ClassNotFoundException e2) {
                new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
                LogUtils.d(TAG, "Product line of jar is ERROR!");
                return null;
            }
        }
        return (IIMConfig) invokeLL.objValue;
    }

    public static IMConfigInternal getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (IMConfigInternal.class) {
                if (sConfig == null) {
                    sConfig = new IMConfigInternal();
                }
            }
            return sConfig;
        }
        return (IMConfigInternal) invokeV.objValue;
    }

    public IIMConfig getIMConfig(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (this.mConfig == null) {
                synchronized (IMConfigInternal.class) {
                    if (this.mConfig == null) {
                        int productLine = getProductLine(context);
                        IIMConfig createConfig = createConfig(context, productLine != 1 ? productLine != 3 ? "com.baidu.android.imsdk.internal.DefaultConfig" : "com.baidu.android.imsdk.box.BoxConfig" : "com.baidu.android.imsdk.internal.DefaultConfig");
                        this.mConfig = createConfig;
                        if (createConfig == null) {
                            this.mConfig = new DefaultConfig();
                        }
                    }
                }
            }
            return this.mConfig;
        }
        return (IIMConfig) invokeL.objValue;
    }

    public int getProductLine(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (context == null) {
                return 1;
            }
            int readIntData = Utility.readIntData(context, Constants.KEY_PRODUCT_LINE, 1);
            if (readIntData == 3 || readIntData == 1 || readIntData == 6 || readIntData == 4) {
                return readIntData;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public int getSDKVersionValue(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            try {
                int productLine = getProductLine(context);
                return Integer.valueOf("740" + String.format("%03d", Integer.valueOf(productLine)) + "6").intValue();
            } catch (Exception e) {
                new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public boolean setProductLine(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, context, i)) == null) {
            Utility.writeIntData(context, Constants.KEY_PRODUCT_LINE, i);
            return true;
        }
        return invokeLI.booleanValue;
    }
}
