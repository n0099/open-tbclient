package c.a.o0.a.u.e.o;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.o0.a.e2.c.j.b;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends c.a.o0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.o0.a.v2.e1.b<c.a.o0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f9059e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9060f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f9061g;

        public a(e eVar, Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, context, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9061g = eVar;
            this.f9059e = context;
            this.f9060f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.o0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.o0.a.e2.c.d.h(iVar)) {
                    this.f9061g.d(this.f9060f, new c.a.o0.a.u.h.b(0, this.f9061g.t(this.f9059e)));
                    return;
                }
                int b2 = iVar.b();
                String f2 = c.a.o0.a.e2.c.d.f(b2);
                if (c.a.o0.a.u.c.d.f8699c) {
                    String str = "getDeviceInfo auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX;
                }
                this.f9061g.d(this.f9060f, new c.a.o0.a.u.h.b(b2, c.a.o0.a.e2.c.d.f(b2)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NonNull c.a.o0.a.u.c.b bVar) {
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
    }

    public c.a.o0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            boolean z = c.a.o0.a.u.c.d.f8699c;
            c.a.o0.a.a2.e Q = c.a.o0.a.a2.e.Q();
            if (Q == null) {
                return new c.a.o0.a.u.h.b(1001, "SwanApp is null");
            }
            Pair<c.a.o0.a.u.h.b, JSONObject> b2 = c.a.o0.a.u.i.b.b("Api-DeviceInfo", str);
            c.a.o0.a.u.h.b bVar = (c.a.o0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (c.a.o0.a.u.c.d.f8699c) {
                    c.a.o0.a.e0.d.b("Api-DeviceInfo", "parse fail");
                }
                return bVar;
            }
            String optString = ((JSONObject) b2.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new c.a.o0.a.u.h.b(202, "cb is required");
            }
            Context i2 = i();
            Q.T().g(i2, "scope_get_device_info", new a(this, i2, optString));
            return new c.a.o0.a.u.h.b(0);
        }
        return (c.a.o0.a.u.h.b) invokeL.objValue;
    }

    public final JSONObject t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("oaid", c.a.o0.a.c1.a.q().b(context));
                jSONObject.put("androidId", c.a.o0.a.c1.a.q().a(context));
            } catch (JSONException e2) {
                if (c.a.o0.a.u.c.d.f8699c) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
