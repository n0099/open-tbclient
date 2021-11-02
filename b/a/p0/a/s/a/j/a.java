package b.a.p0.a.s.a.j;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import b.a.p0.a.a2.e;
import b.a.p0.a.e2.c.i;
import b.a.p0.a.e2.c.j.b;
import b.a.p0.a.u.c.d;
import b.a.p0.a.v2.w;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.s.a.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0361a implements b.a.p0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7783e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f7784f;

        public C0361a(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7784f = aVar;
            this.f7783e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (b.a.p0.a.e2.c.d.h(iVar)) {
                    this.f7784f.s(this.f7783e);
                    return;
                }
                int b2 = iVar.b();
                String f2 = b.a.p0.a.e2.c.d.f(b2);
                if (d.f8000c) {
                    String str = "getUnionBDUSS failed: auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX;
                }
                this.f7784f.d(this.f7783e, new b.a.p0.a.u.h.b(b2, b.a.p0.a.e2.c.d.f(b2)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull b.a.p0.a.u.c.b bVar) {
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

    public b.a.p0.a.u.h.b r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (d.f8000c) {
                String str2 = "getUnionBduss start: " + str;
            }
            e P = e.P();
            if (P == null) {
                boolean z = d.f8000c;
                return new b.a.p0.a.u.h.b(1001, "null swan runtime");
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("AllianceAccountApi", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.f8000c) {
                    b.a.p0.a.e0.d.b("AllianceAccountApi", "parse fail");
                }
                return bVar;
            }
            String optString = ((JSONObject) b2.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new b.a.p0.a.u.h.b(201, "empty cb");
            }
            P.S().g(b.a.p0.a.a2.d.g(), "account_get_union_bduss", new C0361a(this, optString));
            return new b.a.p0.a.u.h.b(0);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            JSONObject jSONObject = new JSONObject();
            w.f(jSONObject, "bduss", b.a.p0.a.s.a.d.f7767a.a());
            d(str, new b.a.p0.a.u.h.b(0, jSONObject));
        }
    }
}
