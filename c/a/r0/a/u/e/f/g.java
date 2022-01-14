package c.a.r0.a.u.e.f;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.r0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g extends c.a.r0.a.u.e.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9038e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f9039f;

        public a(g gVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9039f = gVar;
            this.f9038e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.r0.a.h0.g.g V = c.a.r0.a.g1.f.U().V();
                if (V == null) {
                    c.a.r0.a.e0.d.c("PullDownRefreshApi", "manager is null");
                    this.f9039f.d(this.f9038e, new c.a.r0.a.u.h.b(1001));
                } else if (!(V.m() instanceof c.a.r0.a.h0.g.f)) {
                    c.a.r0.a.e0.d.c("PullDownRefreshApi", "top fragment error");
                    this.f9039f.d(this.f9038e, new c.a.r0.a.u.h.b(1001));
                } else {
                    c.a.r0.a.h0.g.f fVar = (c.a.r0.a.h0.g.f) V.m();
                    if (fVar.j0() == null) {
                        c.a.r0.a.e0.d.c("PullDownRefreshApi", "view is null");
                        this.f9039f.d(this.f9038e, new c.a.r0.a.u.h.b(1001));
                        return;
                    }
                    fVar.j0().onPullDownRefreshComplete(false);
                    c.a.r0.a.e0.d.i("PullDownRefreshApi", "refresh complete");
                    this.f9039f.d(this.f9038e, new c.a.r0.a.u.h.b(0));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NonNull c.a.r0.a.u.c.b bVar) {
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
                super((c.a.r0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.r0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "PullDownRefreshApi" : (String) invokeV.objValue;
    }

    public c.a.r0.a.u.h.b x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#stopPullDownRefresh", false);
            Pair<c.a.r0.a.u.h.b, JSONObject> s = s(str);
            c.a.r0.a.u.h.b bVar = (c.a.r0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    p("cb is empty", null, true);
                    return new c.a.r0.a.u.h.b(1001, "cb is empty");
                }
                q0.e0(new a(this, optString));
                return c.a.r0.a.u.h.b.f();
            }
            return bVar;
        }
        return (c.a.r0.a.u.h.b) invokeL.objValue;
    }
}
