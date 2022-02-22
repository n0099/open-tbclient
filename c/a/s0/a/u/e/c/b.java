package c.a.s0.a.u.e.c;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.s0.a.d2.e;
import c.a.s0.a.u.c.d;
import c.a.s0.a.z2.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f9187e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f9188f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f9189g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f9190h;

        public a(b bVar, e eVar, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, eVar, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9190h = bVar;
            this.f9187e = eVar;
            this.f9188f = jSONObject;
            this.f9189g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f9188f.put("isFavor", c.a.s0.a.j0.b.a.n(this.f9187e.N()) ? "1" : "0");
                } catch (JSONException unused) {
                    c.a.s0.a.e0.d.c("FollowStatusApi", "json put data fail");
                }
                this.f9190h.d(this.f9189g, new c.a.s0.a.u.h.b(0, this.f9188f));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull c.a.s0.a.u.c.b bVar) {
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
                super((c.a.s0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.s0.a.u.c.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "Favorite" : (String) invokeV.objValue;
    }

    @Override // c.a.s0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "FollowStatusApi" : (String) invokeV.objValue;
    }

    public c.a.s0.a.u.h.b x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            e a0 = e.a0();
            if (a0 == null) {
                c.a.s0.a.e0.d.c("FollowStatusApi", "swan app is null");
                return new c.a.s0.a.u.h.b(1001, "swan app is null");
            } else if (a0.x() == null) {
                c.a.s0.a.e0.d.c("FollowStatusApi", "swan activity is null");
                return new c.a.s0.a.u.h.b(1001, "swan activity is null");
            } else {
                Pair<c.a.s0.a.u.h.b, JSONObject> s = s(str);
                c.a.s0.a.u.h.b bVar = (c.a.s0.a.u.h.b) s.first;
                if (!bVar.isSuccess()) {
                    c.a.s0.a.e0.d.c("FollowStatusApi", "json str parse fail");
                    return bVar;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    c.a.s0.a.e0.d.c("FollowStatusApi", "cb is empty");
                    return new c.a.s0.a.u.h.b(202, "cb is empty");
                }
                if (a0.M().e(c.a.s0.a.c1.a.c())) {
                    SwanFavorDataManager.h().d();
                }
                q.k(new a(this, a0, new JSONObject(), optString), "getFavorStatus");
                return new c.a.s0.a.u.h.b(0);
            }
        }
        return (c.a.s0.a.u.h.b) invokeL.objValue;
    }
}
