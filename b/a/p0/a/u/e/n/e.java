package b.a.p0.a.u.e.n;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.a.p0.a.r2.e.a;
import b.a.p0.a.u.c.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends b.a.p0.a.u.e.n.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f8858a;

        /* renamed from: b.a.p0.a.u.e.n.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0440a implements a.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ m f8859a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f8860b;

            public C0440a(a aVar, m mVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, mVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8860b = aVar;
                this.f8859a = mVar;
            }

            @Override // b.a.p0.a.r2.e.a.c
            public void a(float f2, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("direction", f2);
                        jSONObject.put("accuracy", b.a.p0.a.r2.e.a.h(i2));
                        this.f8859a.d(this.f8860b.f8858a, jSONObject);
                    } catch (JSONException e2) {
                        b.a.p0.a.e0.d.c("CompassApi", "handle compass,json error，" + e2.toString());
                        this.f8859a.f(this.f8860b.f8858a, "Json error");
                    }
                }
            }
        }

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8858a = eVar;
        }

        @Override // b.a.p0.a.u.c.d.a
        public b.a.p0.a.u.h.b a(b.a.p0.a.d2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                m mVar = new m("compassChange", jSONObject, str);
                b.a.p0.a.r2.e.a i2 = b.a.p0.a.r2.e.a.i();
                i2.l(this.f8858a.getContext());
                i2.o(new C0440a(this, mVar));
                b.a.p0.a.e0.d.i("CompassApi", "start listen compass");
                i2.p();
                mVar.b(this.f8858a);
                return b.a.p0.a.u.h.b.f();
            }
            return (b.a.p0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NonNull b.a.p0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // b.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "CompassApi" : (String) invokeV.objValue;
    }

    public b.a.p0.a.u.h.b y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#startCompass", true);
            return l(str, true, new a(this));
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            q("#stopCompass", true);
            b.a.p0.a.r2.e.a.i().q();
            return b.a.p0.a.u.h.b.f();
        }
        return (b.a.p0.a.u.h.b) invokeV.objValue;
    }
}
