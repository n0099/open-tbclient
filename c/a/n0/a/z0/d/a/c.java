package c.a.n0.a.z0.d.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import c.a.n0.a.l1.f;
import c.a.n0.a.v1.f.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class c extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7829b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.t1.e f7830c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.z0.d.c.f f7831d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f7832e;

        public a(c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar, c.a.n0.a.z0.d.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, unitedSchemeEntity, callbackHandler, eVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7832e = cVar;
            this.a = unitedSchemeEntity;
            this.f7829b = callbackHandler;
            this.f7830c = eVar;
            this.f7831d = fVar;
        }

        @Override // c.a.n0.a.l1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (z.f6924b) {
                    Log.d("SwanAppAction", str + "");
                }
                this.f7832e.p(this.a, this.f7829b, this.f7830c, this.f7831d);
            }
        }

        @Override // c.a.n0.a.l1.f
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f7829b, this.a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f7831d.f7886c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7833b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7834c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.t1.e f7835d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.z0.d.c.f f7836e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f7837f;

        public b(c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar, c.a.n0.a.z0.d.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, context, unitedSchemeEntity, callbackHandler, eVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7837f = cVar;
            this.a = context;
            this.f7833b = unitedSchemeEntity;
            this.f7834c = callbackHandler;
            this.f7835d = eVar;
            this.f7836e = fVar;
        }

        @Override // c.a.n0.a.l1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (z.f6924b) {
                    Log.d("SwanAppAction", str + "");
                }
                this.f7837f.r(this.a, this.f7833b, this.f7834c, this.f7835d, this.f7836e);
            }
        }

        @Override // c.a.n0.a.l1.f
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f7834c, this.f7833b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f7836e.f7886c);
            }
        }
    }

    /* renamed from: c.a.n0.a.z0.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0605c implements c.a.n0.a.z0.d.d.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.t1.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7838b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7839c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.z0.d.c.f f7840d;

        public C0605c(c cVar, c.a.n0.a.t1.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, c.a.n0.a.z0.d.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, eVar, callbackHandler, unitedSchemeEntity, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.f7838b = callbackHandler;
            this.f7839c = unitedSchemeEntity;
            this.f7840d = fVar;
        }

        @Override // c.a.n0.a.z0.d.d.d
        public void a(boolean z, String str, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, obj}) == null) {
                if (z && (obj instanceof ArrayList)) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (z.f6924b) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Log.d("chooseVideo", "tempPath = " + ((MediaModel) it.next()).getTempPath());
                        }
                    }
                    c.a.n0.a.u.d.i("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f7838b, this.f7839c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(c.a.n0.a.z0.d.c.d.n(arrayList, this.a), 0).toString(), this.f7840d.f7886c);
                }
                c.a.n0.a.z0.d.c.e.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.n0.a.z0.d.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.z0.d.c.f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.t1.e f7841b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.z0.d.d.d f7842c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7843d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7844e;

        public d(c cVar, c.a.n0.a.z0.d.c.f fVar, c.a.n0.a.t1.e eVar, c.a.n0.a.z0.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, fVar, eVar, dVar, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
            this.f7841b = eVar;
            this.f7842c = dVar;
            this.f7843d = callbackHandler;
            this.f7844e = unitedSchemeEntity;
        }

        @Override // c.a.n0.a.z0.d.d.b
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                c.a.n0.a.u.d.i("chooseVideo", "capture success");
                c.a.n0.a.z0.d.c.e.i(c.a.n0.a.z0.d.c.b.c(file));
                Bundle bundle = new Bundle();
                bundle.putString("swanTmpPath", c.a.n0.a.w0.f.U().G().k());
                bundle.putBoolean("compressed", this.a.f7885b);
                bundle.putString("swanAppId", this.f7841b.f6344b);
                bundle.putParcelableArrayList("mediaModels", c.a.n0.a.z0.d.c.e.e());
                c.a.n0.a.z0.d.c.d.h(this.f7841b.x(), bundle, this.f7842c);
            }
        }

        @Override // c.a.n0.a.z0.d.d.b
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f7843d, this.f7844e, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.a.f7886c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.n0.a.z0.d.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7845b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.z0.d.c.f f7846c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.t1.e f7847d;

        public e(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, c.a.n0.a.z0.d.c.f fVar, c.a.n0.a.t1.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, callbackHandler, unitedSchemeEntity, fVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.f7845b = unitedSchemeEntity;
            this.f7846c = fVar;
            this.f7847d = eVar;
        }

        @Override // c.a.n0.a.z0.d.d.c
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.n0.a.u.d.i("chooseVideo", str);
                UnitedSchemeUtility.safeCallback(this.a, this.f7845b, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.f7846c.f7886c);
            }
        }

        @Override // c.a.n0.a.z0.d.d.c
        public void f(List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list != null && list.size() > 0) {
                    c.a.n0.a.u.d.i("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(this.a, this.f7845b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(c.a.n0.a.z0.d.c.d.n(list, this.f7847d), 0).toString(), this.f7846c.f7886c);
                    return;
                }
                UnitedSchemeUtility.safeCallback(this.a, this.f7845b, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.f7846c.f7886c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(c.a.n0.a.v1.e eVar) {
        super(eVar, "/swanAPI/chooseVideo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.n0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar != null && eVar.m0()) {
                if (z.f6924b) {
                    Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            }
            c.a.n0.a.z0.d.c.f a2 = c.a.n0.a.z0.d.c.f.a(UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity));
            if (a2.a == 2) {
                q(context, unitedSchemeEntity, callbackHandler, eVar, a2);
            } else {
                o(context, unitedSchemeEntity, callbackHandler, eVar, a2);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar, c.a.n0.a.z0.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            c.a.n0.a.l1.e.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new b(this, context, unitedSchemeEntity, callbackHandler, eVar, fVar));
        }
    }

    public final void p(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar, c.a.n0.a.z0.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            d dVar = new d(this, fVar, eVar, new C0605c(this, eVar, callbackHandler, unitedSchemeEntity, fVar), callbackHandler, unitedSchemeEntity);
            c.a.n0.a.z0.d.c.b.e(eVar.x(), eVar.f6344b, fVar.f7888e, TextUtils.equals(fVar.f7887d, "front"), dVar);
        }
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar, c.a.n0.a.z0.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            c.a.n0.a.l1.e.e("android.permission.CAMERA", new String[]{"android.permission.CAMERA"}, 1, context, new a(this, unitedSchemeEntity, callbackHandler, eVar, fVar));
        }
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar, c.a.n0.a.z0.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, context, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("launchType", "video");
            bundle.putBoolean("isShowCamera", fVar.a == 3);
            bundle.putBoolean("isFrontCamera", TextUtils.equals(fVar.f7887d, "front"));
            bundle.putInt("maxDuration", fVar.f7888e);
            bundle.putInt("count", 1);
            bundle.putString("mode", "single");
            bundle.putBoolean("compressed", fVar.f7885b);
            bundle.putString("swanAppId", eVar.f6344b);
            bundle.putString("swanTmpPath", c.a.n0.a.w0.f.U().G().k());
            c.a.n0.a.z0.d.c.d.l(context, bundle, new e(this, callbackHandler, unitedSchemeEntity, fVar, eVar));
        }
    }
}
