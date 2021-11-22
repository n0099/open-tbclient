package b.a.n0.m;

import android.content.Context;
import android.os.Build;
import b.a.n0.n.b;
import b.a.n0.q.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a implements b.a.n0.n.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static a f3814c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.n0.n.a f3815a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3816b;

    public a() {
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
        this.f3815a = null;
        this.f3816b = false;
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f3814c == null) {
                synchronized (a.class) {
                    if (f3814c == null) {
                        f3814c = new a();
                    }
                }
            }
            return f3814c;
        }
        return (a) invokeV.objValue;
    }

    @Override // b.a.n0.n.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b.a.n0.n.a aVar = this.f3815a;
            if (aVar == null) {
                return null;
            }
            try {
                return aVar.a();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0044 A[Catch: all -> 0x0049, TRY_LEAVE, TryCatch #0 {all -> 0x0049, blocks: (B:4:0x0004, B:7:0x0009, B:23:0x0040, B:25:0x0044, B:17:0x0024, B:18:0x0029, B:19:0x002c, B:20:0x0032, B:21:0x0038), top: B:31:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // b.a.n0.n.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, b bVar) {
        b.a.n0.n.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bVar) != null) {
            return;
        }
        try {
            if (this.f3816b) {
                return;
            }
            this.f3816b = true;
            int ordinal = com.baidu.sso.r.a.a(Build.MANUFACTURER).ordinal();
            if (ordinal == 0) {
                aVar = null;
            } else if (ordinal == 1) {
                aVar = new b.a.n0.o.b();
            } else if (ordinal == 2) {
                aVar = new b.a.n0.r.b();
            } else if (ordinal == 3) {
                aVar = new c();
            } else if (ordinal != 4) {
                if (this.f3815a == null) {
                    this.f3815a.a(context, bVar);
                    return;
                }
                return;
            } else {
                aVar = new b.a.n0.p.b();
            }
            this.f3815a = aVar;
            if (this.f3815a == null) {
            }
        } catch (Throwable unused) {
        }
    }
}
