package c.a.r0.a.f1;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.r0.a.f1.a;
import c.a.r0.a.k;
import c.a.r0.a.z2.g1.c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import java.util.Map;
/* loaded from: classes.dex */
public class b extends c.a.r0.a.y1.a.a.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static Map<String, c<Bundle>> f5945h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public int f5946f;

    /* renamed from: g  reason: collision with root package name */
    public String f5947g;

    /* loaded from: classes.dex */
    public class a implements c<Bundle> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5948e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f5949f;

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
            this.f5949f = bVar;
            this.f5948e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                this.f5949f.f5947g = bundle.getString("key_launch_app_id");
                this.f5949f.f5946f = bundle.getInt("key_launch_status");
                if (TextUtils.equals(this.f5948e, this.f5949f.f5947g)) {
                    b bVar = this.f5949f;
                    bVar.f9899d.putInt(NewBindCardEntry.BING_CARD_SUCCESS_MSG, bVar.f5946f);
                    this.f5949f.c();
                }
                b.f5945h.remove(this.f5948e);
            }
        }
    }

    /* renamed from: c.a.r0.a.f1.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0304b implements c<Bundle> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5950e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a.e f5951f;

        public C0304b(String str, a.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5950e = str;
            this.f5951f = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                String string = bundle.getString("key_launch_app_id");
                int i2 = bundle.getInt("key_launch_status");
                if (TextUtils.equals(this.f5950e, string)) {
                    if (i2 == 0) {
                        this.f5951f.b();
                    } else {
                        this.f5951f.a();
                    }
                }
                b.f5945h.remove(this.f5950e);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(424162756, "Lc/a/r0/a/f1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(424162756, "Lc/a/r0/a/f1/b;");
                return;
            }
        }
        boolean z = k.a;
        f5945h = new c.a.r0.r.a.c.a();
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
        this.f5946f = -1;
        this.f5947g = "";
    }

    public static void j(String str, a.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, str, eVar) == null) || TextUtils.isEmpty(str) || eVar == null) {
            return;
        }
        f5945h.put(str, new C0304b(str, eVar));
    }

    public static void k(String str) {
        c<Bundle> cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, str) == null) || (cVar = f5945h.get(str)) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_launch_app_id", str);
        bundle.putInt("key_launch_status", 1);
        cVar.onCallback(bundle);
    }

    public static void l(String str) {
        c<Bundle> cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, str) == null) || (cVar = f5945h.get(str)) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_launch_app_id", str);
        bundle.putInt("key_launch_status", 0);
        cVar.onCallback(bundle);
    }

    @Override // c.a.r0.a.y1.a.a.a
    public void b(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            String string = bundle.getString("desAppId");
            f5945h.put(string, new a(this, string));
        }
    }
}
