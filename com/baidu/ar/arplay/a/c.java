package com.baidu.ar.arplay.a;

import android.content.Context;
import android.view.OrientationEventListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c extends OrientationEventListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a dp;
    public a dq;
    public boolean dr;
    public int ds;
    public int dt;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a du;
        public static final a dv;
        public static final a dw;
        public static final a dx;
        public static final a dy;
        public static final /* synthetic */ a[] dz;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-735267613, "Lcom/baidu/ar/arplay/a/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-735267613, "Lcom/baidu/ar/arplay/a/c$a;");
                    return;
                }
            }
            du = new a("SCREEN_ORIENTATION_PORTRAIT", 0);
            dv = new a("SCREEN_ORIENTATION_LANDSCAPE", 1);
            dw = new a("SCREEN_ORIENTATION_REVERSE_PORTRAIT", 2);
            dx = new a("SCREEN_ORIENTATION_REVERSE_LANDSCAPE", 3);
            a aVar = new a("SCREEN_ORIENTATION_NOT_DEFINED", 4);
            dy = aVar;
            dz = new a[]{du, dv, dw, dx, aVar};
        }

        public a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (a) Enum.valueOf(a.class, str) : (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) dz.clone() : (a[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.dr = false;
        this.dt = 0;
    }

    private int aK() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            a aVar = this.dp;
            if (aVar == a.dv) {
                return 90;
            }
            if (aVar == a.dx) {
                return -90;
            }
            return aVar == a.dw ? 180 : 0;
        }
        return invokeV.intValue;
    }

    public void aJ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.ds = aK();
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.dt = i;
        }
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        a aVar;
        a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (i < 0) {
                aVar = a.dy;
            } else {
                int i2 = this.dt;
                if (i2 == 1) {
                    int i3 = ((i + 360) + this.ds) % 360;
                    if (i3 <= 45 || i3 > 315) {
                        aVar2 = a.du;
                    } else if (i3 > 45 && i3 <= 135) {
                        aVar2 = a.dx;
                    } else if (i3 <= 135 || i3 > 225) {
                        if (i3 > 225 && i3 <= 315) {
                            aVar2 = a.dv;
                        }
                        if (this.dr && this.dt == 1) {
                            this.dr = true;
                            this.dp = this.dq;
                            aJ();
                            return;
                        }
                        return;
                    } else {
                        aVar2 = a.dw;
                    }
                    this.dq = aVar2;
                    if (this.dr) {
                        return;
                    }
                    return;
                } else if (i2 != 0) {
                    return;
                } else {
                    if (i <= 45 || i > 315) {
                        aVar = a.du;
                    } else if (i > 45 && i <= 135) {
                        aVar = a.dx;
                    } else if (i > 135 && i <= 225) {
                        aVar = a.dw;
                    } else if (i <= 225 || i > 315) {
                        return;
                    } else {
                        aVar = a.dv;
                    }
                }
            }
            this.dq = aVar;
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                disable();
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
            this.dt = 0;
        }
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                enable();
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
        }
    }
}
