package c.a.b0.g0.l;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.b0.d.g.d;
import c.a.b0.g0.p.k;
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
public class a extends c.a.b0.d.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.b0.g0.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0041a implements k.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HashMap f1557b;

        public C0041a(a aVar, Context context, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, hashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.f1557b = hashMap;
        }

        @Override // c.a.b0.g0.p.k.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a.e(this.a, this.f1557b);
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

    public static void e(Context context, @NonNull HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, context, hashMap) == null) && c.a.b0.g0.a.a.b(hashMap, 0)) {
            Intent intent = new Intent(context, "1".equals(hashMap.remove("newbrowser")) ? AdWebActivityStandard.class : AdWebActivity.class);
            intent.putExtra("map", hashMap);
            c.a.b0.d0.a.c(context, intent);
        }
    }

    @Override // c.a.b0.d.d.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "easybrowse" : (String) invokeV.objValue;
    }

    @Override // c.a.b0.d.d.a
    public boolean b(@NonNull Context context, @NonNull c.a.b0.d.f.a aVar, @Nullable Map<String, Object> map, @Nullable d dVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, aVar, map, dVar)) == null) {
            super.b(context, aVar, map, dVar);
            HashMap<String, String> d2 = aVar.d();
            int b2 = c.a.b0.g0.m.a.b(context.getApplicationContext(), new C0041a(this, context, d2));
            if (4 == b2 || b2 == 0) {
                c(false, null, dVar);
                return false;
            } else if (2 == b2 || 1 == b2) {
                return false;
            } else {
                e(context, d2);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
