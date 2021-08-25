package c.a.q0.v0.l2;

import android.app.Activity;
import android.util.LruCache;
import c.a.e.e.d.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static d f26412c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LruCache<String, String> f26413a;

    /* renamed from: b  reason: collision with root package name */
    public l<String> f26414b;

    /* loaded from: classes4.dex */
    public class a extends c.a.p0.n.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f26415e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26415e = dVar;
        }

        @Override // c.a.p0.n.g, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && activity != null && activity.getClass().getName().equals("FrsActivity")) {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : this.f26415e.f26413a.snapshot().entrySet()) {
                    sb.append((String) entry.getKey());
                    sb.append("=");
                    sb.append((String) entry.getValue());
                    sb.append(",");
                }
                if (sb.length() <= 1) {
                    return;
                }
                sb.deleteCharAt(sb.length() - 1);
                this.f26415e.f26414b.a("transition_cache_key", sb.toString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements l.a<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f26416a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26416a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.d.l.a
        /* renamed from: b */
        public void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || str2 == null || str2.isEmpty()) {
                return;
            }
            for (String str3 : str2.split(",")) {
                String[] split = str3.split("=");
                if (split != null && split.length == 2) {
                    this.f26416a.f26413a.put(split[0], split[1]);
                }
            }
        }
    }

    public d() {
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
        this.f26413a = new LruCache<>(10);
        c.a.p0.s.r.a.f();
        this.f26414b = c.a.p0.s.r.a.g("tb.recently_vistited_forum_animation");
        TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new a(this));
        this.f26414b.f("transition_cache_key", new b(this));
    }

    public static d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f26412c == null) {
                synchronized (d.class) {
                    if (f26412c == null) {
                        f26412c = new d();
                    }
                }
            }
            return f26412c;
        }
        return (d) invokeV.objValue;
    }

    public e c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                return new e(null);
            }
            return new e(this.f26413a.get(str));
        }
        return (e) invokeL.objValue;
    }

    public void e(String str, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, eVar) == null) {
            this.f26413a.put(str, eVar.toString());
        }
    }
}
