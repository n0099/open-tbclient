package c.a.o0.a.u.e.o;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends c.a.o0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public String f9062d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.a.v2.e1.b<Integer> f9063e;

    /* loaded from: classes.dex */
    public class a implements c.a.o0.a.v2.e1.b<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f9064e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9064e = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                if (num.intValue() == 1 || num.intValue() == 0) {
                    this.f9064e.t();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NonNull c.a.o0.a.u.c.b bVar) {
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
                super((c.a.o0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9063e = new a(this);
    }

    public c.a.o0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Pair<c.a.o0.a.u.h.b, JSONObject> b2 = c.a.o0.a.u.i.b.b("Api-ExitFullScreenApi", str);
            c.a.o0.a.u.h.b bVar = (c.a.o0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (c.a.o0.a.u.c.d.f8699c) {
                    c.a.o0.a.e0.d.b("Api-ExitFullScreenApi", "parse fail");
                }
                return bVar;
            }
            String optString = ((JSONObject) b2.second).optString("cb");
            this.f9062d = optString;
            if (TextUtils.isEmpty(optString)) {
                return new c.a.o0.a.u.h.b(201);
            }
            k.e().u(this.f9063e);
            k.e().l();
            return new c.a.o0.a.u.h.b(0);
        }
        return (c.a.o0.a.u.h.b) invokeL.objValue;
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            k.e().v();
            k.e().o();
            d(this.f9062d, new c.a.o0.a.u.h.b(0));
        }
    }
}
