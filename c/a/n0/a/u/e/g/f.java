package c.a.n0.a.u.e.g;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.n0.a.v2.q0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends c.a.n0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8622e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f8623f;

        public a(f fVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8623f = fVar;
            this.f8622e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.h0.g.g W = c.a.n0.a.g1.f.V().W();
                if (W == null) {
                    c.a.n0.a.e0.d.b("Api-PullDownRefresh", "manager is null");
                    this.f8623f.d(this.f8622e, new c.a.n0.a.u.h.b(1001));
                } else if (!(W.m() instanceof c.a.n0.a.h0.g.f)) {
                    c.a.n0.a.e0.d.b("Api-PullDownRefresh", "top fragment error");
                    this.f8623f.d(this.f8622e, new c.a.n0.a.u.h.b(1001));
                } else {
                    c.a.n0.a.h0.g.f fVar = (c.a.n0.a.h0.g.f) W.m();
                    if (fVar.g0() == null) {
                        c.a.n0.a.e0.d.b("Api-PullDownRefresh", "view is null");
                        this.f8623f.d(this.f8622e, new c.a.n0.a.u.h.b(1001));
                        return;
                    }
                    fVar.g0().onPullDownRefreshComplete(false);
                    c.a.n0.a.e0.d.g("Api-PullDownRefresh", "refresh complete");
                    this.f8623f.d(this.f8622e, new c.a.n0.a.u.h.b(0));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NonNull c.a.n0.a.u.c.b bVar) {
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
                super((c.a.n0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public c.a.n0.a.u.h.b r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            boolean z = c.a.n0.a.u.c.d.f8453c;
            Pair<c.a.n0.a.u.h.b, JSONObject> b2 = c.a.n0.a.u.i.b.b("Api-PullDownRefresh", str);
            c.a.n0.a.u.h.b bVar = (c.a.n0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (c.a.n0.a.u.c.d.f8453c) {
                    c.a.n0.a.e0.d.b("Api-PullDownRefresh", "parse fail");
                }
                return bVar;
            }
            String optString = ((JSONObject) b2.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.n0.a.e0.d.b("Api-PullDownRefresh", "callback is null");
                return new c.a.n0.a.u.h.b(1001, "callback is null");
            }
            q0.b0(new a(this, optString));
            return new c.a.n0.a.u.h.b(0);
        }
        return (c.a.n0.a.u.h.b) invokeL.objValue;
    }
}
