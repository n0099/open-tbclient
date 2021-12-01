package c.a.p0.a.j1.d.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import c.a.p0.a.f2.f.z;
import c.a.p0.a.v1.f;
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
import com.baidu.webkit.sdk.PermissionRequest;
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6487e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6488f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.d2.e f6489g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.j1.d.c.f f6490h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c f6491i;

        public a(c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.d2.e eVar, c.a.p0.a.j1.d.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, unitedSchemeEntity, callbackHandler, eVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6491i = cVar;
            this.f6487e = unitedSchemeEntity;
            this.f6488f = callbackHandler;
            this.f6489g = eVar;
            this.f6490h = fVar;
        }

        @Override // c.a.p0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (z.f5296b) {
                    String str2 = str + "";
                }
                this.f6491i.p(this.f6487e, this.f6488f, this.f6489g, this.f6490h);
            }
        }

        @Override // c.a.p0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f6488f, this.f6487e, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f6490h.f6558c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f6492e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6493f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6494g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.d2.e f6495h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.j1.d.c.f f6496i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c f6497j;

        public b(c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.d2.e eVar, c.a.p0.a.j1.d.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, context, unitedSchemeEntity, callbackHandler, eVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6497j = cVar;
            this.f6492e = context;
            this.f6493f = unitedSchemeEntity;
            this.f6494g = callbackHandler;
            this.f6495h = eVar;
            this.f6496i = fVar;
        }

        @Override // c.a.p0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (z.f5296b) {
                    String str2 = str + "";
                }
                this.f6497j.r(this.f6492e, this.f6493f, this.f6494g, this.f6495h, this.f6496i);
            }
        }

        @Override // c.a.p0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f6494g, this.f6493f, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f6496i.f6558c);
            }
        }
    }

    /* renamed from: c.a.p0.a.j1.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0346c implements c.a.p0.a.j1.d.d.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.d2.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6498b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6499c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.j1.d.c.f f6500d;

        public C0346c(c cVar, c.a.p0.a.d2.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, c.a.p0.a.j1.d.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, eVar, callbackHandler, unitedSchemeEntity, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.f6498b = callbackHandler;
            this.f6499c = unitedSchemeEntity;
            this.f6500d = fVar;
        }

        @Override // c.a.p0.a.j1.d.d.d
        public void a(boolean z, String str, Object obj) {
            Iterator it;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, obj}) == null) {
                if (z && (obj instanceof ArrayList)) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (z.f5296b) {
                        while (arrayList.iterator().hasNext()) {
                            String str2 = "tempPath = " + ((MediaModel) it.next()).getTempPath();
                        }
                    }
                    c.a.p0.a.e0.d.i("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f6498b, this.f6499c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(c.a.p0.a.j1.d.c.d.n(arrayList, this.a), 0).toString(), this.f6500d.f6558c);
                }
                c.a.p0.a.j1.d.c.e.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.p0.a.j1.d.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.j1.d.c.f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.d2.e f6501b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.j1.d.d.d f6502c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6503d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6504e;

        public d(c cVar, c.a.p0.a.j1.d.c.f fVar, c.a.p0.a.d2.e eVar, c.a.p0.a.j1.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, fVar, eVar, dVar, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
            this.f6501b = eVar;
            this.f6502c = dVar;
            this.f6503d = callbackHandler;
            this.f6504e = unitedSchemeEntity;
        }

        @Override // c.a.p0.a.j1.d.d.b
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                c.a.p0.a.e0.d.i("chooseVideo", "capture success");
                c.a.p0.a.j1.d.c.e.i(c.a.p0.a.j1.d.c.b.c(file));
                Bundle bundle = new Bundle();
                bundle.putString("swanTmpPath", c.a.p0.a.g1.f.U().G().k());
                bundle.putBoolean("compressed", this.a.f6557b);
                bundle.putString("swanAppId", this.f6501b.f4616f);
                bundle.putParcelableArrayList("mediaModels", c.a.p0.a.j1.d.c.e.e());
                c.a.p0.a.j1.d.c.d.h(this.f6501b.x(), bundle, this.f6502c);
            }
        }

        @Override // c.a.p0.a.j1.d.d.b
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f6503d, this.f6504e, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.a.f6558c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.p0.a.j1.d.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6505e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6506f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.j1.d.c.f f6507g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.d2.e f6508h;

        public e(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, c.a.p0.a.j1.d.c.f fVar, c.a.p0.a.d2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, callbackHandler, unitedSchemeEntity, fVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6505e = callbackHandler;
            this.f6506f = unitedSchemeEntity;
            this.f6507g = fVar;
            this.f6508h = eVar;
        }

        @Override // c.a.p0.a.j1.d.d.c
        public void f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.p0.a.e0.d.i("chooseVideo", str);
                UnitedSchemeUtility.safeCallback(this.f6505e, this.f6506f, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.f6507g.f6558c);
            }
        }

        @Override // c.a.p0.a.j1.d.d.c
        public void j(List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list != null && list.size() > 0) {
                    c.a.p0.a.e0.d.i("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f6505e, this.f6506f, UnitedSchemeUtility.wrapCallbackParamsWithEncode(c.a.p0.a.j1.d.c.d.n(list, this.f6508h), 0).toString(), this.f6507g.f6558c);
                    return;
                }
                UnitedSchemeUtility.safeCallback(this.f6505e, this.f6506f, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.f6507g.f6558c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(c.a.p0.a.f2.e eVar) {
        super(eVar, "/swanAPI/chooseVideo");
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

    @Override // c.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar != null && eVar.m0()) {
                boolean z = z.f5296b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            }
            c.a.p0.a.j1.d.c.f a2 = c.a.p0.a.j1.d.c.f.a(UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity));
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

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.d2.e eVar, c.a.p0.a.j1.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            c.a.p0.a.v1.e.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new b(this, context, unitedSchemeEntity, callbackHandler, eVar, fVar));
        }
    }

    public final void p(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.d2.e eVar, c.a.p0.a.j1.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            d dVar = new d(this, fVar, eVar, new C0346c(this, eVar, callbackHandler, unitedSchemeEntity, fVar), callbackHandler, unitedSchemeEntity);
            c.a.p0.a.j1.d.c.b.e(eVar.x(), eVar.f4616f, fVar.f6560e, TextUtils.equals(fVar.f6559d, "front"), dVar);
        }
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.d2.e eVar, c.a.p0.a.j1.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            c.a.p0.a.v1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new a(this, unitedSchemeEntity, callbackHandler, eVar, fVar));
        }
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.d2.e eVar, c.a.p0.a.j1.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, context, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("launchType", "video");
            bundle.putBoolean("isShowCamera", fVar.a == 3);
            bundle.putBoolean("isFrontCamera", TextUtils.equals(fVar.f6559d, "front"));
            bundle.putInt("maxDuration", fVar.f6560e);
            bundle.putInt("count", 1);
            bundle.putString("mode", "single");
            bundle.putBoolean("compressed", fVar.f6557b);
            bundle.putString("swanAppId", eVar.f4616f);
            bundle.putString("swanTmpPath", c.a.p0.a.g1.f.U().G().k());
            c.a.p0.a.j1.d.c.d.l(context, bundle, new e(this, callbackHandler, unitedSchemeEntity, fVar, eVar));
        }
    }
}
