package c.a.a0.k0.e;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.a0.e0.b;
import c.a.a0.g.g.d;
import c.a.a0.k0.i.k;
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
public class a extends c.a.a0.g.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.a0.k0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0041a implements k.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HashMap f1302b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f1303c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.a0.g.f.a f1304d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f1305e;

        public C0041a(a aVar, Context context, HashMap hashMap, d dVar, c.a.a0.g.f.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, hashMap, dVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1305e = aVar;
            this.a = context;
            this.f1302b = hashMap;
            this.f1303c = dVar;
            this.f1304d = aVar2;
        }

        @Override // c.a.a0.k0.i.k.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean f2 = a.f(this.a, this.f1302b);
                this.f1305e.c(this.f1303c, this.f1304d, f2 ? 0 : 1001, f2);
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean f(Context context, @NonNull HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, hashMap)) == null) {
            if (c.a.a0.a.a) {
                b.a().a(context, "启动SDK Webview");
            }
            if (c.a.a0.k0.a.a.b(hashMap, 0)) {
                Intent intent = new Intent(context, "1".equals(hashMap.remove("newbrowser")) ? AdWebActivityStandard.class : AdWebActivity.class);
                intent.putExtra("map", hashMap);
                return c.a.a0.h0.a.c(context, intent);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.a0.g.d.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "easybrowse" : (String) invokeV.objValue;
    }

    @Override // c.a.a0.g.d.a
    public boolean b(@NonNull Context context, @NonNull c.a.a0.g.f.a aVar, @Nullable Map<String, Object> map, @Nullable d dVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, aVar, map, dVar)) == null) {
            super.b(context, aVar, map, dVar);
            HashMap<String, String> d2 = aVar.d();
            int b2 = c.a.a0.k0.f.a.b(context.getApplicationContext(), new C0041a(this, context, d2, dVar, aVar));
            if (4 != b2 && b2 != 0) {
                if (2 != b2 && 1 != b2) {
                    boolean f2 = f(context, d2);
                    c(dVar, aVar, f2 ? 0 : 1001, f2);
                }
                return true;
            }
            c(dVar, aVar, 1001, false);
            if (c.a.a0.a.a) {
                throw new IllegalStateException("web app init failed, state=" + b2);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
