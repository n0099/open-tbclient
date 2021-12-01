package c.a.p0.i.c;

import androidx.annotation.NonNull;
import c.a.p0.a.d2.e;
import c.a.p0.a.h2.c.f;
import c.a.p0.a.z2.g1.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends c.a.p0.i.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.i.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0626a implements c<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.u0.b f9944e;

        public C0626a(a aVar, c.a.p0.a.u0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9944e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                boolean z = true;
                if ((fVar == null || fVar.f6237d || fVar.f6243j != 1) ? false : false) {
                    this.f9944e.a(null);
                } else {
                    this.f9944e.onFail(10001, "authorize fail.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super("authorize");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.i.e.a
    public c.a.p0.a.u.h.b a(@NonNull JSONObject jSONObject, @NonNull c.a.p0.a.u0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
            if (c.a.p0.i.e.a.f9947b && jSONObject.optBoolean("debug", false)) {
                bVar.a(null);
                return null;
            }
            e a0 = e.a0();
            if (a0 == null) {
                bVar.onFail(10001, "authorize fail.");
                return null;
            }
            a0.d0().e("mapp_gamecenter_private_api", new C0626a(this, bVar));
            return null;
        }
        return (c.a.p0.a.u.h.b) invokeLL.objValue;
    }
}
