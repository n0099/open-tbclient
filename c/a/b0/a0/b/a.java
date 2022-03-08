package c.a.b0.a0.b;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import c.a.b0.u.g;
import c.a.b0.u.p.c;
import c.a.b0.u.s.d;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.b0.a0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0024a extends c<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C0024a(b bVar) {
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
            this.a = bVar;
        }

        @Override // c.a.b0.u.p.a
        public void a(Exception exc, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i2) == null) {
                c.a.b0.a0.a.b(this.a.a(i2, exc.getMessage()));
            }
        }

        @Override // c.a.b0.u.p.b
        public /* bridge */ /* synthetic */ Object d(Headers headers, String str, int i2) throws Exception {
            f(headers, str, i2);
            return str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.b0.u.p.b
        /* renamed from: e */
        public void b(Headers headers, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, headers, str, i2) == null) {
                c.a.b0.a0.a.b(this.a.a(i2, "success"));
            }
        }

        public String f(Headers headers, String str, int i2) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i2)) == null) ? str : (String) invokeLLI.objValue;
        }
    }

    public static void a(@Nullable b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, bVar) == null) || bVar == null || TextUtils.isEmpty(bVar.d())) {
            return;
        }
        if (!bVar.c()) {
            b(bVar.d());
            return;
        }
        d dVar = new d();
        dVar.k(bVar.d());
        dVar.g(3000);
        dVar.d("User-Agent", c.a.b0.h.a.e());
        dVar.c();
        g.b().a().a(dVar, new C0024a(bVar));
    }

    public static void b(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        d dVar = new d();
        dVar.k(str);
        dVar.g(3000);
        dVar.d("User-Agent", c.a.b0.h.a.e());
        dVar.c();
        g.b().a().a(dVar, null);
    }
}
