package c.a.n0.a.k.e.f;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.n0.a.p2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g extends c.a.n0.a.k.e.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f5058b;

        public a(g gVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5058b = gVar;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.x.g.g V = c.a.n0.a.w0.f.U().V();
                if (V == null) {
                    c.a.n0.a.u.d.c("PullDownRefreshApi", "manager is null");
                    this.f5058b.d(this.a, new c.a.n0.a.k.h.b(1001));
                } else if (!(V.m() instanceof c.a.n0.a.x.g.f)) {
                    c.a.n0.a.u.d.c("PullDownRefreshApi", "top fragment error");
                    this.f5058b.d(this.a, new c.a.n0.a.k.h.b(1001));
                } else {
                    c.a.n0.a.x.g.f fVar = (c.a.n0.a.x.g.f) V.m();
                    if (fVar.k0() == null) {
                        c.a.n0.a.u.d.c("PullDownRefreshApi", "view is null");
                        this.f5058b.d(this.a, new c.a.n0.a.k.h.b(1001));
                        return;
                    }
                    fVar.k0().w(false);
                    c.a.n0.a.u.d.i("PullDownRefreshApi", "refresh complete");
                    this.f5058b.d(this.a, new c.a.n0.a.k.h.b(0));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NonNull c.a.n0.a.k.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.n0.a.k.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.n0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "PullDownRefreshApi" : (String) invokeV.objValue;
    }

    public c.a.n0.a.k.h.b x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#stopPullDownRefresh", false);
            Pair<c.a.n0.a.k.h.b, JSONObject> s = s(str);
            c.a.n0.a.k.h.b bVar = (c.a.n0.a.k.h.b) s.first;
            if (bVar.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    p("cb is empty", null, true);
                    return new c.a.n0.a.k.h.b(1001, "cb is empty");
                }
                q0.e0(new a(this, optString));
                return c.a.n0.a.k.h.b.f();
            }
            return bVar;
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }
}
