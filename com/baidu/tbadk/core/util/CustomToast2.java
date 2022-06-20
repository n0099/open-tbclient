package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pi;
/* loaded from: classes3.dex */
public class CustomToast2 {
    public static /* synthetic */ Interceptable $ic;
    public static Handler mHandler;
    public static String mText;
    public static Toast mToast;
    public static Runnable r;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1684405473, "Lcom/baidu/tbadk/core/util/CustomToast2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1684405473, "Lcom/baidu/tbadk/core/util/CustomToast2;");
                return;
            }
        }
        mHandler = new Handler();
        mText = null;
        r = new Runnable() { // from class: com.baidu.tbadk.core.util.CustomToast2.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    CustomToast2.mToast.cancel();
                }
            }
        };
    }

    public CustomToast2() {
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

    public static void showToast(Context context, String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65542, null, context, str, i) == null) || str == null || str.length() <= 0) {
            return;
        }
        mHandler.removeCallbacks(r);
        if (mToast != null) {
            if (!str.equals(mText)) {
                mText = str;
                mToast.setText(str);
            }
        } else {
            mText = str;
            mToast = Toast.makeText(TbadkCoreApplication.getInst(), str, 0);
            mToast.setGravity(17, 0, pi.d(context, 100.0f));
        }
        mHandler.postDelayed(r, i);
        mToast.show();
    }

    public static void showToast(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, str) == null) {
            showToast(context, str, 2000);
        }
    }

    public static void showToast(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, null, context, i) == null) {
            showToast(context, context.getResources().getString(i));
        }
    }

    public static void showToast(Context context, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i, i2) == null) {
            showToast(context, context.getResources().getString(i), i2);
        }
    }
}
