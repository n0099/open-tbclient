package c.q.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes9.dex */
public class i0 {
    public static /* synthetic */ Interceptable $ic;
    public static i0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public i0() {
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

    public static i0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (i0.class) {
                    if (a == null) {
                        a = new i0();
                    }
                }
            }
            return a;
        }
        return (i0) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
        if (((r6 / 60) / 60) >= r10.a.getSharedPreferences("_prefs", 0).getInt("interval", 0)) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, str) == null) {
            if (context == null) {
                throw new RuntimeException("Error:Context is not allowed to be null");
            }
            context.getApplicationContext();
            if (!TextUtils.isEmpty(str)) {
                m2.v(context, str);
            }
            t2.b(new f0(this, context));
            try {
                t2.b(new l2(context));
            } catch (Throwable th) {
                th.printStackTrace();
            }
            y3 c2 = y3.c(context);
            long B = m2.B(c2.a);
            boolean z = true;
            if (B > 0) {
                try {
                    long time = (new Date().getTime() - B) / 1000;
                    if (time < 0) {
                        c2.f();
                    }
                    z = false;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (z) {
                c2.f31524b = System.currentTimeMillis();
                t2.b(new v3(c2));
            }
            r0.E(context);
            x1.a(context);
        }
    }
}
