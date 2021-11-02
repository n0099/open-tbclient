package b.a.p0.b.n;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import b.a.p0.a.a2.e;
import b.a.p0.a.e2.c.i;
import b.a.p0.a.e2.c.j.b;
import b.a.p0.a.u.c.c;
import b.a.p0.a.u.c.d;
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
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.b.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0486a extends b.a.p0.a.u.c.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f9366d;

        /* renamed from: b.a.p0.b.n.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0487a implements b.a.p0.a.v2.e1.b<i<b.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.b f9367e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C0486a f9368f;

            public C0487a(C0486a c0486a, c.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0486a, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9368f = c0486a;
                this.f9367e = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i<b.e> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    if (b.a.p0.a.e2.c.d.h(iVar)) {
                        this.f9367e.a(this.f9368f.f9366d.s());
                        return;
                    }
                    int b2 = iVar.b();
                    String f2 = b.a.p0.a.e2.c.d.f(b2);
                    if (d.f8000c) {
                        String str = "getBduss failed: auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX;
                    }
                    this.f9367e.a(new b.a.p0.a.u.h.b(b2, f2));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0486a(a aVar, String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9366d = aVar;
        }

        @Override // b.a.p0.a.u.c.c
        @NonNull
        public b.a.p0.a.u.h.b d(@NonNull JSONObject jSONObject, @NonNull c.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
                e P = e.P();
                if (P == null) {
                    boolean z = d.f8000c;
                    return new b.a.p0.a.u.h.b(1001, "null swan runtime");
                }
                P.S().g(b.a.p0.a.a2.d.g(), "mapp_i_get_bduss", new C0487a(this, bVar));
                return new b.a.p0.a.u.h.b(0);
            }
            return (b.a.p0.a.u.h.b) invokeLL.objValue;
        }

        @Override // b.a.p0.a.u.c.c
        @NonNull
        public b.a.p0.a.u.h.b e(@NonNull JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) ? this.f9366d.s() : (b.a.p0.a.u.h.b) invokeL.objValue;
        }

        @Override // b.a.p0.a.u.c.c
        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? b.a.p0.a.a2.d.g().C() && b.a.p0.a.a2.d.g().r().S().f("mapp_i_get_bduss") : invokeV.booleanValue;
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

    @SuppressLint({"SwanBindApiNote"})
    public b.a.p0.a.u.h.b r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? j(str, new C0486a(this, "getBDUSS")) : (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    @NonNull
    public final b.a.p0.a.u.h.b s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String i2 = b.a.p0.b.l.a.i(b.a.p0.a.a2.d.g());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("bduss", i2);
                if (d.f8000c) {
                    String str = "getBduss success: " + jSONObject.toString();
                }
                return new b.a.p0.a.u.h.b(0, jSONObject);
            } catch (JSONException e2) {
                if (d.f8000c) {
                    e2.printStackTrace();
                }
                return new b.a.p0.a.u.h.b(1001, "result JSONException");
            }
        }
        return (b.a.p0.a.u.h.b) invokeV.objValue;
    }
}
