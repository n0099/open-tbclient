package com.baidu.spswitch.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class SoftInputSharedPreferences {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FILE_NAME = "baidu.softinput.common";
    public static final String KEY_SOFITNPUT_HEIGHT = "sp.key.softinput.height";
    public static volatile SharedPreferences sSp;
    public transient /* synthetic */ FieldHolder $fh;

    public SoftInputSharedPreferences() {
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

    public static int get(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, context, i2)) == null) ? with(context).getInt(KEY_SOFITNPUT_HEIGHT, i2) : invokeLI.intValue;
    }

    public static boolean save(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, context, i2)) == null) ? with(context).edit().putInt(KEY_SOFITNPUT_HEIGHT, i2).commit() : invokeLI.booleanValue;
    }

    public static SharedPreferences with(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (sSp == null) {
                synchronized (SoftInputSharedPreferences.class) {
                    if (sSp == null) {
                        sSp = context.getSharedPreferences(FILE_NAME, 0);
                    }
                }
            }
            return sSp;
        }
        return (SharedPreferences) invokeL.objValue;
    }
}
