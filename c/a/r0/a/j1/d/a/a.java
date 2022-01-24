package c.a.r0.a.j1.d.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import c.a.r0.a.d2.e;
import c.a.r0.a.e0.d;
import c.a.r0.a.f2.f.z;
import c.a.r0.a.v1.f;
import c.a.r0.a.z2.w;
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
public class a extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public int f7466c;

    /* renamed from: d  reason: collision with root package name */
    public String f7467d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7468e;

    /* renamed from: f  reason: collision with root package name */
    public String f7469f;

    /* renamed from: c.a.r0.a.j1.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0446a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f7470e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7471f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7472g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f7473h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f7474i;

        public C0446a(a aVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
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
            this.f7474i = aVar;
            this.f7470e = context;
            this.f7471f = unitedSchemeEntity;
            this.f7472g = callbackHandler;
            this.f7473h = eVar;
        }

        @Override // c.a.r0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (z.f6343b) {
                    String str2 = str + "";
                }
                this.f7474i.n(this.f7470e, this.f7471f, this.f7472g, this.f7473h);
            }
        }

        @Override // c.a.r0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f7472g, this.f7471f, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f7474i.f7469f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.r0.a.j1.d.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7475e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7476f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f7477g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f7478h;

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
            this.f7478h = aVar;
            this.f7475e = callbackHandler;
            this.f7476f = unitedSchemeEntity;
            this.f7477g = eVar;
        }

        @Override // c.a.r0.a.j1.d.d.c
        public void f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.c("chooseAlbum", str);
                UnitedSchemeUtility.safeCallback(this.f7475e, this.f7476f, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.f7478h.f7469f);
            }
        }

        @Override // c.a.r0.a.j1.d.d.c
        public void j(List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list != null && list.size() > 0) {
                    d.i("chooseAlbum", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f7475e, this.f7476f, UnitedSchemeUtility.wrapCallbackParamsWithEncode(c.a.r0.a.j1.d.c.d.m(list, this.f7477g, "album"), 0).toString(), this.f7478h.f7469f);
                    return;
                }
                UnitedSchemeUtility.safeCallback(this.f7475e, this.f7476f, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.f7478h.f7469f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.r0.a.f2.e eVar) {
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

    @Override // c.a.r0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar != null && eVar.x() != null) {
                if (eVar.m0()) {
                    boolean z = z.f6343b;
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                    return false;
                }
                JSONObject d2 = w.d(unitedSchemeEntity.getParam("params"));
                String optString = d2.optString("cb");
                this.f7469f = optString;
                if (TextUtils.isEmpty(optString)) {
                    d.c("chooseAlbum", "callback is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "callback is null");
                    return false;
                }
                this.f7466c = d2.optInt("count");
                this.f7467d = d2.optString("mode");
                this.f7468e = d2.optBoolean("compressed");
                m(context, unitedSchemeEntity, callbackHandler, eVar);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            d.c("chooseAlbum", "runtime exception");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar) == null) {
            c.a.r0.a.v1.e.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new C0446a(this, context, unitedSchemeEntity, callbackHandler, eVar));
        }
    }

    public final void n(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, eVar) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("launchType", "album");
            bundle.putBoolean("isShowCamera", false);
            bundle.putInt("count", this.f7466c);
            bundle.putString("mode", this.f7467d);
            bundle.putBoolean("compressed", this.f7468e);
            bundle.putString("swanAppId", eVar.f5679f);
            bundle.putString("swanTmpPath", c.a.r0.a.g1.f.U().G().k());
            c.a.r0.a.j1.d.c.d.l(context, bundle, new b(this, callbackHandler, unitedSchemeEntity, eVar));
        }
    }
}
