package c.b.c.b.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import c.b.c.b.c.a.a;
import c.b.c.b.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f31536c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.b.c.b.c.c.b f31537a;

    /* renamed from: b  reason: collision with root package name */
    public SQLiteDatabase f31538b;

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
            }
        }
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f31536c == null) {
                synchronized (b.class) {
                    if (f31536c == null) {
                        f31536c = new b();
                    }
                }
            }
            return f31536c;
        }
        return (b) invokeV.objValue;
    }

    public void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            try {
                this.f31538b = new d(context).getWritableDatabase();
            } catch (Throwable th) {
                l.k.c(th);
            }
            this.f31537a = new c.b.c.b.c.c.b();
        }
    }

    public synchronized void c(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            synchronized (this) {
                if (this.f31537a != null) {
                    this.f31537a.f(this.f31538b, aVar);
                }
            }
        }
    }

    public synchronized boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            synchronized (this) {
                if (this.f31537a != null) {
                    return this.f31537a.g(this.f31538b, str);
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
