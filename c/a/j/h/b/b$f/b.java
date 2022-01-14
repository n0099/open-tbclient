package c.a.j.h.b.b$f;

import android.text.TextUtils;
import c.a.j.h.b.b;
import c.a.j.h.b.b$b.l;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public int f3944b;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f3944b = 0;
    }

    public abstract String a();

    public abstract void b(int i2);

    public abstract void c(IOException iOException);

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f3944b = 0;
            b.e.a().b(str, this);
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.a = z;
        }
    }

    public abstract void f(byte[] bArr);

    public final String g(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bArr)) == null) {
            String str = new String(bArr);
            DebugTrace debugTrace = DebugTrace.a;
            debugTrace.a("processResponseData encodeResponseData=" + str);
            if (this.a) {
                l b2 = b.g.c().b(b.h.b().i(), bArr);
                DebugTrace debugTrace2 = DebugTrace.a;
                debugTrace2.a("processResponseData decodeResponseData=" + b2);
                if (b2 != null) {
                    if (!TextUtils.isEmpty(b2.a())) {
                        str = b2.a();
                    }
                    this.f3944b = b2.d().intValue();
                } else {
                    this.f3944b = -1;
                }
                b.h.b().i().b(this.f3944b);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
