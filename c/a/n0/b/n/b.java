package c.a.n0.b.n;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.n0.a.a2.e;
import c.a.n0.a.e2.c.i;
import c.a.n0.a.e2.c.j.b;
import c.a.n0.a.u.c.d;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.n0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f9862e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f9863f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f9864g;

        public a(b bVar, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9864g = bVar;
            this.f9862e = str;
            this.f9863f = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!c.a.n0.a.e2.c.d.h(iVar)) {
                    int b2 = iVar.b();
                    String f2 = c.a.n0.a.e2.c.d.f(b2);
                    if (d.f8453c) {
                        String str = "getOpenBduss failed: auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX;
                    }
                    this.f9864g.d(this.f9862e, new c.a.n0.a.u.h.b(b2, c.a.n0.a.e2.c.d.f(b2)));
                    return;
                }
                JSONArray optJSONArray = this.f9863f.optJSONArray("tpls");
                ArrayList arrayList = new ArrayList();
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    arrayList.add(optJSONArray.optString(i2));
                }
                this.f9864g.t(this.f9863f.optString("clientId"), arrayList, this.f9862e);
            }
        }
    }

    /* renamed from: c.a.n0.b.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0483b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f9865a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f9866b;

        public C0483b(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9866b = bVar;
            this.f9865a = str;
        }

        @Override // c.a.n0.b.n.b.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                try {
                    this.f9866b.d(this.f9865a, new c.a.n0.a.u.h.b(0, new JSONObject(str)));
                } catch (JSONException e2) {
                    this.f9866b.d(this.f9865a, new c.a.n0.a.u.h.b(10001, "internal error"));
                    if (d.f8453c) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull c.a.n0.a.u.c.b bVar) {
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

    @SuppressLint({"SwanBindApiNote"})
    public c.a.n0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            e Q = e.Q();
            if (Q == null) {
                boolean z = d.f8453c;
                return new c.a.n0.a.u.h.b(1001, "null swan runtime");
            }
            Pair<c.a.n0.a.u.h.b, JSONObject> b2 = c.a.n0.a.u.i.b.b("Api-Base", str);
            c.a.n0.a.u.h.b bVar = (c.a.n0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.f8453c) {
                    c.a.n0.a.e0.d.b("Api-Base", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new c.a.n0.a.u.h.b(201, "empty cb");
            }
            Q.T().g(c.a.n0.a.a2.d.g(), "scope_get_open_bduss", new a(this, optString, jSONObject));
            return new c.a.n0.a.u.h.b(0);
        }
        return (c.a.n0.a.u.h.b) invokeL.objValue;
    }

    public final void t(String str, ArrayList<String> arrayList, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, arrayList, str2) == null) {
            if (!c.a.n0.b.l.a.G(c.a.n0.a.a2.d.g())) {
                d(str2, new c.a.n0.a.u.h.b(202, "user is not logged in or the params are invalid"));
            } else {
                c.a.n0.b.l.a.o(c.a.n0.a.a2.d.g(), str, arrayList, new C0483b(this, str2));
            }
        }
    }
}
