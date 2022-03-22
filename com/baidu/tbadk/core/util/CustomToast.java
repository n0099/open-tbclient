package com.baidu.tbadk.core.util;

import android.os.Handler;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class CustomToast {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TOAST_DURATION = 2000;
    public static Handler mHandler;
    public static Toast mToast;
    public static Runnable r;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean dontShowToast;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1855450971, "Lcom/baidu/tbadk/core/util/CustomToast;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1855450971, "Lcom/baidu/tbadk/core/util/CustomToast;");
                return;
            }
        }
        mHandler = new Handler();
        r = new Runnable() { // from class: com.baidu.tbadk.core.util.CustomToast.1
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
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || CustomToast.mToast == null) {
                    return;
                }
                CustomToast.mToast.cancel();
            }
        };
    }

    public CustomToast() {
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

    public static void cancel() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || mToast == null) {
            return;
        }
        mHandler.removeCallbacks(r);
        mToast.cancel();
        mToast = null;
    }

    public static CustomToast newInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new CustomToast() : (CustomToast) invokeV.objValue;
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.dontShowToast = true;
            cancel();
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.dontShowToast = false;
        }
    }

    public void showToast(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048583, this, str, i, i2) == null) || this.dontShowToast || str == null) {
            return;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return;
        }
        mHandler.removeCallbacks(r);
        Toast toast = mToast;
        if (toast != null && toast.getView() != null) {
            try {
                mToast.setText(trim);
            } catch (RuntimeException e2) {
                BdLog.e(e2);
                Toast makeText = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
                mToast = makeText;
                makeText.setText(trim);
                mToast.setGravity(17, 0, i2);
            }
        } else {
            Toast makeText2 = Toast.makeText(BdBaseApplication.getInst().getApp(), trim, 0);
            mToast = makeText2;
            makeText2.setText(trim);
            mToast.setGravity(17, 0, i2);
        }
        mHandler.postDelayed(r, i);
        mToast.show();
    }

    public void showToast(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            showToast(str, 2000);
        }
    }

    public void showToast(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            showToast(i, 2000);
        }
    }

    public void showToast(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i) == null) {
            showToast(str, i, n.d(BdBaseApplication.getInst().getApp(), 100.0f));
        }
    }

    public void showToast(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            showToast(BdBaseApplication.getInst().getApp().getResources().getString(i), i2);
        }
    }

    public void showToast(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048580, this, i, i2, i3) == null) {
            showToast(BdBaseApplication.getInst().getApp().getResources().getString(i), i2, i3);
        }
    }
}
