package c.a.n0.a.z0.f.d;

import android.telephony.PhoneStateListener;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a extends PhoneStateListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-683112846, "Lc/a/n0/a/z0/f/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-683112846, "Lc/a/n0/a/z0/f/d/a;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
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
            }
        }
    }

    @Override // android.telephony.PhoneStateListener
    public void onCallStateChanged(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
            super.onCallStateChanged(i, str);
            if (i == 0) {
                c.a.n0.a.z0.f.e.a.k().o();
                if (a) {
                    Log.i("PhoneStateListener", "挂断");
                }
            } else if (i == 1) {
                c.a.n0.a.z0.f.e.a.k().n();
                if (a) {
                    Log.i("PhoneStateListener", "响铃:" + str);
                }
            } else if (i != 2) {
                if (a) {
                    Log.e("PhoneStateListener", "invalid state");
                }
            } else {
                c.a.n0.a.z0.f.e.a.k().n();
                if (a) {
                    Log.i("PhoneStateListener", "接听");
                }
            }
        }
    }
}
