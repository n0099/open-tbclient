package c.a.p0.a.c2.f;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.p0.a.e2.c.j.b;
import c.a.p0.a.v2.o0;
import c.a.p0.a.v2.t0;
import c.a.p0.n.i.m.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f4838e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4839f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f4840g;

        public a(g gVar, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4840g = gVar;
            this.f4838e = jSONObject;
            this.f4839f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4840g.o(this.f4838e, this.f4839f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.v2.e1.b<c.a.p0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f4841e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4842f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONArray f4843g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4844h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f4845i;

        public b(g gVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONArray jSONArray, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, unitedSchemeEntity, callbackHandler, jSONArray, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4845i = gVar;
            this.f4841e = unitedSchemeEntity;
            this.f4842f = callbackHandler;
            this.f4843g = jSONArray;
            this.f4844h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.p0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                this.f4845i.m(iVar, this.f4841e, this.f4842f, this.f4843g, this.f4844h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f4846e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4847f;

        public c(g gVar, List list, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, list, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4846e = list;
            this.f4847f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                List<String> h2 = c.a.p0.a.h0.m.p.a.h(this.f4846e);
                if (h2.isEmpty()) {
                    return;
                }
                c.a.p0.n.i.m.b bVar = new c.a.p0.n.i.m.b((Collection<String>) h2, (c.a.p0.n.o.a) t0.b());
                bVar.e(this.f4847f);
                bVar.d("1");
                c.a.p0.a.h0.m.d dVar = new c.a.p0.a.h0.m.d();
                dVar.K(5);
                c.a.p0.n.b.d(bVar, dVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(c.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/downloadPackages");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            c.a.p0.a.e0.d.g("DownloadPackagesAction", "call DownloadPackagesAction, thread=" + Thread.currentThread().getName());
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "invalid parameter");
                return false;
            }
            JSONArray optJSONArray = a2.optJSONArray("appKeys");
            JSONObject optJSONObject = a2.optJSONObject("appList");
            if ((optJSONArray == null || optJSONArray.length() == 0) && optJSONObject == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "appKeys must not empty");
                return false;
            }
            String optString = a2.optString("netconf");
            if (TextUtils.isEmpty(optString)) {
                optString = "0";
            }
            if (!c.a.p0.a.h0.c.a.b.c(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "Network limitation");
                return false;
            }
            String l = l(callbackHandler);
            if (p(callbackHandler)) {
                if (eVar == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
                    return false;
                }
                eVar.T().g(context, "mapp_pre_download", new b(this, unitedSchemeEntity, callbackHandler, optJSONArray, l));
                return true;
            }
            if (optJSONArray != null) {
                n(optJSONArray, l, false);
            }
            if (optJSONObject != null) {
                c.a.p0.a.v2.q.i(new a(this, optJSONObject, l), "handlePreDownloadByCommand");
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    @NonNull
    public final String l(CallbackHandler callbackHandler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, callbackHandler)) == null) ? q(callbackHandler) ? "10" : "2" : (String) invokeL.objValue;
    }

    public final void m(c.a.p0.a.e2.c.i<b.e> iVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, iVar, unitedSchemeEntity, callbackHandler, jSONArray, str) == null) {
            if (!c.a.p0.a.e2.c.d.h(iVar)) {
                c.a.p0.a.e2.c.d.o(iVar, callbackHandler, unitedSchemeEntity);
                return;
            }
            n(jSONArray, str, true);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        }
    }

    public final void n(@Nullable JSONArray jSONArray, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048579, this, jSONArray, str, z) == null) || jSONArray == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(jSONArray.optString(i2));
        }
        c.a.p0.a.v2.q.j(new c(this, arrayList, str), "小程序端能力-批量下载");
    }

    @AnyThread
    public final void o(@NonNull JSONObject jSONObject, String str) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, str) == null) {
            ArrayList arrayList = new ArrayList();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    e.b bVar = new e.b(next);
                    JSONObject optJSONObject = jSONObject.optJSONObject(next);
                    if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("commands")) != null && optJSONArray.length() > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            String optString = optJSONArray.optString(i2);
                            if (!TextUtils.isEmpty(optString)) {
                                try {
                                    Uri parse = Uri.parse(optString);
                                    if (parse != null) {
                                        arrayList2.add(o0.n(next, parse, false));
                                    }
                                } catch (Exception e2) {
                                    if (a0.f4766b) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                        }
                        if (!arrayList2.isEmpty()) {
                            bVar.j((String[]) arrayList2.toArray(new String[arrayList2.size()]));
                        }
                    }
                    arrayList.add(bVar);
                }
            }
            c.a.p0.a.h0.c.a.b.a(arrayList, str, null);
        }
    }

    public final boolean p(CallbackHandler callbackHandler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, callbackHandler)) == null) ? q(callbackHandler) : invokeL.booleanValue;
    }

    public final boolean q(CallbackHandler callbackHandler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, callbackHandler)) == null) {
            if (callbackHandler instanceof TypedCallbackHandler) {
                int invokeSourceType = ((TypedCallbackHandler) callbackHandler).getInvokeSourceType();
                return invokeSourceType == 0 || invokeSourceType == 1;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
