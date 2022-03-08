package c.a.b0.k0.e;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.b0.e0.b;
import c.a.b0.f.g.d;
import c.a.b0.k0.i.k;
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
public class a extends c.a.b0.f.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.b0.k0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0056a implements k.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HashMap f1682b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f1683c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.b0.f.f.a f1684d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f1685e;

        public C0056a(a aVar, Context context, HashMap hashMap, d dVar, c.a.b0.f.f.a aVar2) {
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
            this.f1685e = aVar;
            this.a = context;
            this.f1682b = hashMap;
            this.f1683c = dVar;
            this.f1684d = aVar2;
        }

        @Override // c.a.b0.k0.i.k.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean f2 = a.f(this.a, this.f1682b);
                this.f1685e.c(this.f1683c, this.f1684d, f2 ? 0 : 1001, f2);
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
            if (c.a.b0.a.a) {
                b.a().a(context, "启动SDK Webview");
            }
            if (c.a.b0.k0.a.a.b(hashMap, 0)) {
                Intent intent = new Intent(context, "1".equals(hashMap.remove("newbrowser")) ? AdWebActivityStandard.class : AdWebActivity.class);
                intent.putExtra("map", hashMap);
                return c.a.b0.h0.a.c(context, intent);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.b0.f.d.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "easybrowse" : (String) invokeV.objValue;
    }

    @Override // c.a.b0.f.d.a
    public boolean b(@NonNull Context context, @NonNull c.a.b0.f.f.a aVar, @Nullable Map<String, Object> map, @Nullable d dVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, aVar, map, dVar)) == null) {
            super.b(context, aVar, map, dVar);
            HashMap<String, String> d2 = aVar.d();
            int b2 = c.a.b0.k0.f.a.b(context.getApplicationContext(), new C0056a(this, context, d2, dVar, aVar));
            if (4 != b2 && b2 != 0) {
                if (2 != b2 && 1 != b2) {
                    boolean f2 = f(context, d2);
                    c(dVar, aVar, f2 ? 0 : 1001, f2);
                }
                return true;
            }
            c(dVar, aVar, 1001, false);
            if (c.a.b0.a.a) {
                throw new IllegalStateException("web app init failed, state=" + b2);
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
