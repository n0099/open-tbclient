package b.a.p0.a.i1.f.d;

import android.telephony.PhoneStateListener;
import b.a.p0.a.k;
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

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f6138a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1707607391, "Lb/a/p0/a/i1/f/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1707607391, "Lb/a/p0/a/i1/f/d/a;");
                return;
            }
        }
        f6138a = k.f6397a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // android.telephony.PhoneStateListener
    public void onCallStateChanged(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            super.onCallStateChanged(i2, str);
            if (i2 == 0) {
                b.a.p0.a.i1.f.e.a.k().o();
                boolean z = f6138a;
            } else if (i2 != 1) {
                if (i2 != 2) {
                    boolean z2 = f6138a;
                    return;
                }
                b.a.p0.a.i1.f.e.a.k().n();
                boolean z3 = f6138a;
            } else {
                b.a.p0.a.i1.f.e.a.k().n();
                if (f6138a) {
                    String str2 = "响铃:" + str;
                }
            }
        }
    }
}
