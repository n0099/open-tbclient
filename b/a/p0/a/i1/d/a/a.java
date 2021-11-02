package b.a.p0.a.i1.d.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import b.a.p0.a.a2.e;
import b.a.p0.a.c2.f.a0;
import b.a.p0.a.e0.d;
import b.a.p0.a.s1.f;
import b.a.p0.a.v2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public int f5951c;

    /* renamed from: d  reason: collision with root package name */
    public String f5952d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5953e;

    /* renamed from: f  reason: collision with root package name */
    public String f5954f;

    /* renamed from: b.a.p0.a.i1.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0254a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f5955a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5956b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5957c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f5958d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f5959e;

        public C0254a(a aVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context, unitedSchemeEntity, callbackHandler, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5959e = aVar;
            this.f5955a = context;
            this.f5956b = unitedSchemeEntity;
            this.f5957c = callbackHandler;
            this.f5958d = eVar;
        }

        @Override // b.a.p0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a0.f4160b) {
                    String str2 = str + "";
                }
                this.f5959e.n(this.f5955a, this.f5956b, this.f5957c, this.f5958d);
            }
        }

        @Override // b.a.p0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f5957c, this.f5956b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f5959e.f5954f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.i1.d.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5960e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5961f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f5962g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f5963h;

        public b(a aVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, unitedSchemeEntity, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5963h = aVar;
            this.f5960e = callbackHandler;
            this.f5961f = unitedSchemeEntity;
            this.f5962g = eVar;
        }

        @Override // b.a.p0.a.i1.d.d.c
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.b("chooseAlbum", str);
                UnitedSchemeUtility.safeCallback(this.f5960e, this.f5961f, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.f5963h.f5954f);
            }
        }

        @Override // b.a.p0.a.i1.d.d.c
        public void f(List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list != null && list.size() > 0) {
                    d.g("chooseAlbum", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f5960e, this.f5961f, UnitedSchemeUtility.wrapCallbackParamsWithEncode(b.a.p0.a.i1.d.c.d.m(list, this.f5962g, "album"), 0).toString(), this.f5963h.f5954f);
                    return;
                }
                UnitedSchemeUtility.safeCallback(this.f5960e, this.f5961f, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.f5963h.f5954f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/chooseAlbum");
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

    @Override // b.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar != null && eVar.x() != null) {
                if (eVar.c0()) {
                    boolean z = a0.f4160b;
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                    return false;
                }
                JSONObject d2 = w.d(unitedSchemeEntity.getParam("params"));
                String optString = d2.optString("cb");
                this.f5954f = optString;
                if (TextUtils.isEmpty(optString)) {
                    d.b("chooseAlbum", "callback is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "callback is null");
                    return false;
                }
                this.f5951c = d2.optInt("count");
                this.f5952d = d2.optString("mode");
                this.f5953e = d2.optBoolean("compressed");
                m(context, unitedSchemeEntity, callbackHandler, eVar);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            d.b("chooseAlbum", "runtime exception");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar) == null) {
            b.a.p0.a.s1.e.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new C0254a(this, context, unitedSchemeEntity, callbackHandler, eVar));
        }
    }

    public final void n(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, eVar) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("launchType", "album");
            bundle.putBoolean("isShowCamera", false);
            bundle.putInt("count", this.f5951c);
            bundle.putString("mode", this.f5952d);
            bundle.putBoolean("compressed", this.f5953e);
            bundle.putString("swanAppId", eVar.f3961f);
            bundle.putString("swanTmpPath", b.a.p0.a.g1.f.T().G().k());
            b.a.p0.a.i1.d.c.d.l(context, bundle, new b(this, callbackHandler, unitedSchemeEntity, eVar));
        }
    }
}
