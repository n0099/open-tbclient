package b.a.p0.b.p.c;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.a.a2.e;
import b.a.p0.a.e2.c.i;
import b.a.p0.a.e2.c.j.b;
import b.a.p0.a.u.c.c;
import b.a.p0.a.u.c.d;
import b.a.p0.a.v2.o0;
import b.a.p0.a.v2.q0;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.core.Domains;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.b.p.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0494a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f9456d;

        /* renamed from: b.a.p0.b.p.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0495a implements b.a.p0.a.v2.e1.b<i<b.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.b f9457e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C0494a f9458f;

            public C0495a(C0494a c0494a, c.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0494a, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9458f = c0494a;
                this.f9457e = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i<b.e> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    if (b.a.p0.a.e2.c.d.h(iVar)) {
                        this.f9457e.a(this.f9458f.f9456d.s());
                        return;
                    }
                    int b2 = iVar.b();
                    String f2 = b.a.p0.a.e2.c.d.f(b2);
                    if (d.f8000c) {
                        String str = "getCommonSysInfo failed: auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX;
                    }
                    this.f9457e.a(new b.a.p0.a.u.h.b(b2, f2));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0494a(a aVar, String str) {
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
            this.f9456d = aVar;
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
                P.S().g(b.a.p0.a.a2.d.g(), "mapp_i_get_common_sys_info", new C0495a(this, bVar));
                return new b.a.p0.a.u.h.b(0);
            }
            return (b.a.p0.a.u.h.b) invokeLL.objValue;
        }

        @Override // b.a.p0.a.u.c.c
        @NonNull
        public b.a.p0.a.u.h.b e(@NonNull JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) ? this.f9456d.s() : (b.a.p0.a.u.h.b) invokeL.objValue;
        }

        @Override // b.a.p0.a.u.c.c
        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? b.a.p0.a.a2.d.g().C() && b.a.p0.a.a2.d.g().r().S().f("mapp_i_get_common_sys_info") : invokeV.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                String string = bundle.getString("httpUrl");
                Bundle bundle2 = new Bundle();
                bundle2.putString("zid", b.a.p0.b.l.a.D(b.a.p0.a.a2.d.g()));
                bundle2.putString("uid", b.a.p0.a.c1.a.a0().h(b.a.p0.a.a2.d.g()));
                bundle2.putString("cookie", TextUtils.isEmpty(string) ? "" : b.a.p0.a.c1.a.p().a().getCookie(string));
                return bundle2;
            }
            return (Bundle) invokeL.objValue;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? j(str, new C0494a(this, "getCommonSysInfo")) : (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    @NonNull
    public final b.a.p0.a.u.h.b s() {
        InterceptResult invokeV;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.a.p0.a.a2.d g2 = b.a.p0.a.a2.d.g();
            String i2 = b.a.p0.a.c1.a.a0().i(g2);
            String r = q0.r();
            Bundle bundle = new Bundle();
            bundle.putString("httpUrl", Domains.BAIDU);
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(g2, b.class, bundle);
            String str3 = "";
            if (callOnMainWithContentProvider.isOk()) {
                String string = callOnMainWithContentProvider.mResult.getString("zid");
                str2 = callOnMainWithContentProvider.mResult.getString("uid");
                str3 = callOnMainWithContentProvider.mResult.getString("cookie");
                str = string;
            } else {
                str = "";
                str2 = str;
            }
            String l = o0.l(str3, "BAIDUID");
            String l2 = o0.l(str3, "H_WISE_SIDS");
            String a2 = b.a.p0.u.b.b(AppRuntime.getAppContext()).a();
            if (d.f8000c) {
                String str4 = "cuid = " + i2 + ", imei = " + r + ", zid = " + str + ", uid = " + str2 + ", baiduId = " + l + ", sid = " + l2 + ", uuid = " + a2;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cuid", i2);
                jSONObject.put("imei", r);
                jSONObject.put("zid", str);
                jSONObject.put("uid", str2);
                jSONObject.put("baidu_id", l);
                jSONObject.put("sid", l2);
                jSONObject.put("uuid", a2);
                if (d.f8000c) {
                    String str5 = "getCommonSysInfo success: " + jSONObject.toString();
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
