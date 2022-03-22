package c.a.n0.i.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.n0.a.f.d.l1;
import c.a.n0.a.t1.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements l1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, Boolean> a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.n0.i.b.a f8546b;

    /* loaded from: classes2.dex */
    public class a implements c.a.n0.a.k0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.k0.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f8547b;

        public a(b bVar, c.a.n0.a.k0.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8547b = bVar;
            this.a = bVar2;
        }

        @Override // c.a.n0.a.k0.b
        public void a(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.f8547b.g(true);
                this.a.a(jSONObject);
            }
        }

        @Override // c.a.n0.a.k0.b
        public void onFail(int i, @Nullable String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.f8547b.g(false);
                this.a.onFail(i, str);
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        this.f8546b = new c.a.n0.i.b.a();
    }

    @Override // c.a.n0.a.f.d.l1
    @Nullable
    public c.a.n0.a.k.h.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull c.a.n0.a.k0.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, bVar)) == null) {
            if (f()) {
                bVar.a(null);
                return null;
            }
            return this.f8546b.a(jSONObject, c(bVar));
        }
        return (c.a.n0.a.k.h.b) invokeLLL.objValue;
    }

    public final c.a.n0.a.k0.b c(@NonNull c.a.n0.a.k0.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) ? new a(this, bVar) : (c.a.n0.a.k0.b) invokeL.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            e a0 = e.a0();
            if (a0 != null) {
                return a0.N();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? TextUtils.equals(this.f8546b.a, str) : invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String d2 = d();
            if (TextUtils.isEmpty(d2) || (bool = this.a.get(d2)) == null) {
                return false;
            }
            return bool.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public final void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            String d2 = d();
            if (TextUtils.isEmpty(d2)) {
                return;
            }
            this.a.put(d2, Boolean.valueOf(z));
        }
    }
}
