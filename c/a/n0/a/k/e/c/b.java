package c.a.n0.a.k.e.c;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.n0.a.k.c.d;
import c.a.n0.a.p2.q;
import c.a.n0.a.t1.e;
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
        public final /* synthetic */ e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4991b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4992c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f4993d;

        public a(b bVar, e eVar, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, eVar, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4993d = bVar;
            this.a = eVar;
            this.f4991b = jSONObject;
            this.f4992c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f4991b.put("isFavor", c.a.n0.a.z.b.a.n(this.a.N()) ? "1" : "0");
                } catch (JSONException unused) {
                    c.a.n0.a.u.d.c("FollowStatusApi", "json put data fail");
                }
                this.f4993d.d(this.f4992c, new c.a.n0.a.k.h.b(0, this.f4991b));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull c.a.n0.a.k.c.b bVar) {
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
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "Favorite" : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "FollowStatusApi" : (String) invokeV.objValue;
    }

    public c.a.n0.a.k.h.b x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            e a0 = e.a0();
            if (a0 == null) {
                c.a.n0.a.u.d.c("FollowStatusApi", "swan app is null");
                return new c.a.n0.a.k.h.b(1001, "swan app is null");
            } else if (a0.x() == null) {
                c.a.n0.a.u.d.c("FollowStatusApi", "swan activity is null");
                return new c.a.n0.a.k.h.b(1001, "swan activity is null");
            } else {
                Pair<c.a.n0.a.k.h.b, JSONObject> s = s(str);
                c.a.n0.a.k.h.b bVar = (c.a.n0.a.k.h.b) s.first;
                if (!bVar.isSuccess()) {
                    c.a.n0.a.u.d.c("FollowStatusApi", "json str parse fail");
                    return bVar;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    c.a.n0.a.u.d.c("FollowStatusApi", "cb is empty");
                    return new c.a.n0.a.k.h.b(202, "cb is empty");
                }
                if (a0.M().e(c.a.n0.a.s0.a.c())) {
                    SwanFavorDataManager.h().d();
                }
                q.k(new a(this, a0, new JSONObject(), optString), "getFavorStatus");
                return new c.a.n0.a.k.h.b(0);
            }
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }
}
