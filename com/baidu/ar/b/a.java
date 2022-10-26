package com.baidu.ar.b;

import android.content.Context;
import android.os.Build;
import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.h.b;
import com.baidu.ar.mdl.ARMdlInterfaceJNI;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "a";
    public static a cG;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray cD;
    public SparseArray cE;
    public SparseArray cF;
    public boolean cH;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1920963863, "Lcom/baidu/ar/b/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1920963863, "Lcom/baidu/ar/b/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.cD = new SparseArray();
        this.cE = new SparseArray();
        this.cF = new SparseArray();
        this.cH = false;
    }

    public static synchronized a as() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (a.class) {
                if (cG == null) {
                    cG = new a();
                }
                aVar = cG;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, context) == null) || this.cH) {
            return;
        }
        if (context == null) {
            b.b(TAG, "setup context = null");
            return;
        }
        try {
            ARMdlInterfaceJNI.setAssetManager(context.getAssets());
            this.cH = true;
        } catch (Exception e) {
            b.b(TAG, "setup error");
            e.printStackTrace();
        }
    }

    public void a(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            synchronized (this.cF) {
                this.cF.put(i, Boolean.valueOf(z));
            }
        }
    }

    public void a(Context context, SparseArray sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, sparseArray) == null) {
            this.cD = sparseArray;
            b(context);
        }
    }

    public void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            if (context == null) {
                b.b(TAG, "setCacheDir context = null");
            } else if (Build.VERSION.SDK_INT < 29) {
                File file = new File(context.getFilesDir(), "snpe");
                if (!file.exists()) {
                    file.mkdirs();
                }
                ARMdlInterfaceJNI.setCacheDir(file.getAbsolutePath());
            }
        }
    }

    public synchronized boolean c(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            synchronized (this) {
                z = ((Integer) this.cE.get(i)) != null;
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public synchronized void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            synchronized (this) {
                this.cE.put(i, Integer.valueOf(i));
            }
        }
    }

    public synchronized void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            synchronized (this) {
                this.cE.remove(i);
            }
        }
    }

    public boolean f(int i) {
        InterceptResult invokeI;
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            synchronized (this.cF) {
                bool = (Boolean) this.cF.get(i);
            }
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }
        return invokeI.booleanValue;
    }

    public com.baidu.ar.mdl.a g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? (com.baidu.ar.mdl.a) this.cD.get(i) : (com.baidu.ar.mdl.a) invokeI.objValue;
    }
}
