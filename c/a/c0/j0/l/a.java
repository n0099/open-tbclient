package c.a.c0.j0.l;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.c0.e0.b;
import c.a.c0.f.h.d;
import c.a.c0.j0.p.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.AdWebActivity;
import com.baidu.nadcore.webview.AdWebActivityStandard;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
@Service
/* loaded from: classes.dex */
public class a extends c.a.c0.f.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.c0.j0.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0069a implements k.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HashMap f2007b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f2008c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.c0.f.g.a f2009d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f2010e;

        public C0069a(a aVar, Context context, HashMap hashMap, d dVar, c.a.c0.f.g.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, hashMap, dVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2010e = aVar;
            this.a = context;
            this.f2007b = hashMap;
            this.f2008c = dVar;
            this.f2009d = aVar2;
        }

        @Override // c.a.c0.j0.p.k.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean f2 = a.f(this.a, this.f2007b);
                this.f2010e.c(this.f2008c, this.f2009d, f2 ? 0 : 1001, f2);
            }
        }
    }

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
            }
        }
    }

    public static boolean f(Context context, @NonNull HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, hashMap)) == null) {
            if (c.a.c0.a.a) {
                b.a().a(context, "启动SDK Webview");
            }
            if (c.a.c0.j0.a.a.b(hashMap, 0)) {
                Intent intent = new Intent(context, "1".equals(hashMap.remove("newbrowser")) ? AdWebActivityStandard.class : AdWebActivity.class);
                intent.putExtra("map", hashMap);
                return c.a.c0.g0.a.c(context, intent);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.c0.f.e.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "easybrowse" : (String) invokeV.objValue;
    }

    @Override // c.a.c0.f.e.a
    public boolean b(@NonNull Context context, @NonNull c.a.c0.f.g.a aVar, @Nullable Map<String, Object> map, @Nullable d dVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, aVar, map, dVar)) == null) {
            super.b(context, aVar, map, dVar);
            HashMap<String, String> d2 = aVar.d();
            int b2 = c.a.c0.j0.m.a.b(context.getApplicationContext(), new C0069a(this, context, d2, dVar, aVar));
            if (4 != b2 && b2 != 0) {
                if (2 != b2 && 1 != b2) {
                    boolean f2 = f(context, d2);
                    c(dVar, aVar, f2 ? 0 : 1001, f2);
                }
                return true;
            }
            c(dVar, aVar, 1001, false);
            if (c.a.c0.a.a) {
                throw new IllegalStateException("web app init failed, state=" + b2);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
