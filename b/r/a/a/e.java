package b.r.a.a;

import android.content.Context;
import b.r.a.a.c.a.a;
import b.r.a.a.c.b.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class e implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public /* synthetic */ b f33693e;

    public e(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33693e = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        String str;
        d dVar;
        d dVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                context = this.f33693e.f33664a;
                if (context == null) {
                    dVar2 = this.f33693e.f33669f;
                    dVar2.a(-3, "parameter error");
                    return;
                }
                b bVar = this.f33693e;
                context2 = this.f33693e.f33664a;
                bVar.f33665b = context2.getPackageName();
                a a2 = a.a();
                str = this.f33693e.f33665b;
                a2.d(str);
                b bVar2 = this.f33693e;
                dVar = this.f33693e.f33669f;
                bVar2.i(dVar);
            } catch (Throwable th) {
                c.c(th);
            }
        }
    }
}
