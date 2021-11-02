package b.a.p0.a.u.e.g;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import b.a.p0.a.v2.q0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8162e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f8163f;

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
            this.f8163f = fVar;
            this.f8162e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.h0.g.g U = b.a.p0.a.g1.f.T().U();
                if (U == null) {
                    b.a.p0.a.e0.d.b("Api-PullDownRefresh", "manager is null");
                    this.f8163f.d(this.f8162e, new b.a.p0.a.u.h.b(1001));
                } else if (!(U.m() instanceof b.a.p0.a.h0.g.f)) {
                    b.a.p0.a.e0.d.b("Api-PullDownRefresh", "top fragment error");
                    this.f8163f.d(this.f8162e, new b.a.p0.a.u.h.b(1001));
                } else {
                    b.a.p0.a.h0.g.f fVar = (b.a.p0.a.h0.g.f) U.m();
                    if (fVar.f0() == null) {
                        b.a.p0.a.e0.d.b("Api-PullDownRefresh", "view is null");
                        this.f8163f.d(this.f8162e, new b.a.p0.a.u.h.b(1001));
                        return;
                    }
                    fVar.f0().onPullDownRefreshComplete(false);
                    b.a.p0.a.e0.d.g("Api-PullDownRefresh", "refresh complete");
                    this.f8163f.d(this.f8162e, new b.a.p0.a.u.h.b(0));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NonNull b.a.p0.a.u.c.b bVar) {
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

    public b.a.p0.a.u.h.b q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            boolean z = b.a.p0.a.u.c.d.f8000c;
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-PullDownRefresh", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-PullDownRefresh", "parse fail");
                }
                return bVar;
            }
            String optString = ((JSONObject) b2.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                b.a.p0.a.e0.d.b("Api-PullDownRefresh", "callback is null");
                return new b.a.p0.a.u.h.b(1001, "callback is null");
            }
            q0.b0(new a(this, optString));
            return new b.a.p0.a.u.h.b(0);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
