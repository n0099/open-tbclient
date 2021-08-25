package c.a.o0.a.f1;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.o0.a.f1.a;
import c.a.o0.a.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes.dex */
public class b extends c.a.o0.a.v1.a.a.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static Map<String, c.a.o0.a.v2.e1.b<Bundle>> f5640h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public int f5641f;

    /* renamed from: g  reason: collision with root package name */
    public String f5642g;

    /* loaded from: classes.dex */
    public class a implements c.a.o0.a.v2.e1.b<Bundle> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5643e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f5644f;

        public a(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5644f = bVar;
            this.f5643e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                this.f5644f.f5642g = bundle.getString("key_launch_app_id");
                this.f5644f.f5641f = bundle.getInt("key_launch_status");
                if (TextUtils.equals(this.f5643e, this.f5644f.f5642g)) {
                    b bVar = this.f5644f;
                    bVar.f9175d.putInt("ok", bVar.f5641f);
                    this.f5644f.c();
                }
                b.f5640h.remove(this.f5643e);
            }
        }
    }

    /* renamed from: c.a.o0.a.f1.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0179b implements c.a.o0.a.v2.e1.b<Bundle> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5645e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a.d f5646f;

        public C0179b(String str, a.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5645e = str;
            this.f5646f = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                String string = bundle.getString("key_launch_app_id");
                int i2 = bundle.getInt("key_launch_status");
                if (TextUtils.equals(this.f5645e, string)) {
                    if (i2 == 0) {
                        this.f5646f.b();
                    } else {
                        this.f5646f.a();
                    }
                }
                b.f5640h.remove(this.f5645e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1013703271, "Lc/a/o0/a/f1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1013703271, "Lc/a/o0/a/f1/b;");
                return;
            }
        }
        boolean z = k.f7049a;
        f5640h = new c.a.o0.o.a.c.a();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f5641f = -1;
        this.f5642g = "";
    }

    public static void j(String str, a.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, str, dVar) == null) || TextUtils.isEmpty(str) || dVar == null) {
            return;
        }
        f5640h.put(str, new C0179b(str, dVar));
    }

    public static void k(String str) {
        c.a.o0.a.v2.e1.b<Bundle> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, str) == null) || (bVar = f5640h.get(str)) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_launch_app_id", str);
        bundle.putInt("key_launch_status", 1);
        bVar.onCallback(bundle);
    }

    public static void l(String str) {
        c.a.o0.a.v2.e1.b<Bundle> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, str) == null) || (bVar = f5640h.get(str)) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_launch_app_id", str);
        bundle.putInt("key_launch_status", 0);
        bVar.onCallback(bundle);
    }

    @Override // c.a.o0.a.v1.a.a.a
    public void b(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            String string = bundle.getString("desAppId");
            f5640h.put(string, new a(this, string));
        }
    }
}
