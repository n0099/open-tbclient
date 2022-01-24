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
    public static Map<String, c<Bundle>> f5956h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public int f5957f;

    /* renamed from: g  reason: collision with root package name */
    public String f5958g;

    /* loaded from: classes.dex */
    public class a implements c<Bundle> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5959e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f5960f;

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
            this.f5960f = bVar;
            this.f5959e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                this.f5960f.f5958g = bundle.getString("key_launch_app_id");
                this.f5960f.f5957f = bundle.getInt("key_launch_status");
                if (TextUtils.equals(this.f5959e, this.f5960f.f5958g)) {
                    b bVar = this.f5960f;
                    bVar.f9827d.putInt(NewBindCardEntry.BING_CARD_SUCCESS_MSG, bVar.f5957f);
                    this.f5960f.c();
                }
                b.f5956h.remove(this.f5959e);
            }
        }
    }

    /* renamed from: c.a.r0.a.f1.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0322b implements c<Bundle> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5961e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a.e f5962f;

        public C0322b(String str, a.e eVar) {
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
            this.f5961e = str;
            this.f5962f = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                String string = bundle.getString("key_launch_app_id");
                int i2 = bundle.getInt("key_launch_status");
                if (TextUtils.equals(this.f5961e, string)) {
                    if (i2 == 0) {
                        this.f5962f.b();
                    } else {
                        this.f5962f.a();
                    }
                }
                b.f5956h.remove(this.f5961e);
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
        f5956h = new c.a.r0.r.a.c.a();
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
        this.f5957f = -1;
        this.f5958g = "";
    }

    public static void j(String str, a.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, str, eVar) == null) || TextUtils.isEmpty(str) || eVar == null) {
            return;
        }
        f5956h.put(str, new C0322b(str, eVar));
    }

    public static void k(String str) {
        c<Bundle> cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, str) == null) || (cVar = f5956h.get(str)) == null) {
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
        if (!(interceptable == null || interceptable.invokeL(65545, null, str) == null) || (cVar = f5956h.get(str)) == null) {
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
            f5956h.put(string, new a(this, string));
        }
    }
}
