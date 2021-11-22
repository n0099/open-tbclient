package b.a.p0.a.j1.d.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import b.a.p0.a.f2.f.z;
import b.a.p0.a.v1.f;
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
        public final /* synthetic */ UnitedSchemeEntity f6647e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6648f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.d2.e f6649g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.j1.d.c.f f6650h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c f6651i;

        public a(c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar, b.a.p0.a.j1.d.c.f fVar) {
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
            this.f6651i = cVar;
            this.f6647e = unitedSchemeEntity;
            this.f6648f = callbackHandler;
            this.f6649g = eVar;
            this.f6650h = fVar;
        }

        @Override // b.a.p0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (z.f5228b) {
                    String str2 = str + "";
                }
                this.f6651i.p(this.f6647e, this.f6648f, this.f6649g, this.f6650h);
            }
        }

        @Override // b.a.p0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f6648f, this.f6647e, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f6650h.f6731c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f6652e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6653f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6654g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.d2.e f6655h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.j1.d.c.f f6656i;
        public final /* synthetic */ c j;

        public b(c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar, b.a.p0.a.j1.d.c.f fVar) {
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
            this.j = cVar;
            this.f6652e = context;
            this.f6653f = unitedSchemeEntity;
            this.f6654g = callbackHandler;
            this.f6655h = eVar;
            this.f6656i = fVar;
        }

        @Override // b.a.p0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (z.f5228b) {
                    String str2 = str + "";
                }
                this.j.r(this.f6652e, this.f6653f, this.f6654g, this.f6655h, this.f6656i);
            }
        }

        @Override // b.a.p0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f6654g, this.f6653f, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f6656i.f6731c);
            }
        }
    }

    /* renamed from: b.a.p0.a.j1.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0290c implements b.a.p0.a.j1.d.d.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.d2.e f6657a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6658b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6659c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.j1.d.c.f f6660d;

        public C0290c(c cVar, b.a.p0.a.d2.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, b.a.p0.a.j1.d.c.f fVar) {
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
            this.f6657a = eVar;
            this.f6658b = callbackHandler;
            this.f6659c = unitedSchemeEntity;
            this.f6660d = fVar;
        }

        @Override // b.a.p0.a.j1.d.d.d
        public void a(boolean z, String str, Object obj) {
            Iterator it;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, obj}) == null) {
                if (z && (obj instanceof ArrayList)) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (z.f5228b) {
                        while (arrayList.iterator().hasNext()) {
                            String str2 = "tempPath = " + ((MediaModel) it.next()).getTempPath();
                        }
                    }
                    b.a.p0.a.e0.d.i("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f6658b, this.f6659c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(b.a.p0.a.j1.d.c.d.n(arrayList, this.f6657a), 0).toString(), this.f6660d.f6731c);
                }
                b.a.p0.a.j1.d.c.e.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements b.a.p0.a.j1.d.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.j1.d.c.f f6661a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.d2.e f6662b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.j1.d.d.d f6663c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6664d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6665e;

        public d(c cVar, b.a.p0.a.j1.d.c.f fVar, b.a.p0.a.d2.e eVar, b.a.p0.a.j1.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
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
            this.f6661a = fVar;
            this.f6662b = eVar;
            this.f6663c = dVar;
            this.f6664d = callbackHandler;
            this.f6665e = unitedSchemeEntity;
        }

        @Override // b.a.p0.a.j1.d.d.b
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                b.a.p0.a.e0.d.i("chooseVideo", "capture success");
                b.a.p0.a.j1.d.c.e.i(b.a.p0.a.j1.d.c.b.c(file));
                Bundle bundle = new Bundle();
                bundle.putString("swanTmpPath", b.a.p0.a.g1.f.U().G().k());
                bundle.putBoolean("compressed", this.f6661a.f6730b);
                bundle.putString("swanAppId", this.f6662b.f4474f);
                bundle.putParcelableArrayList("mediaModels", b.a.p0.a.j1.d.c.e.e());
                b.a.p0.a.j1.d.c.d.h(this.f6662b.x(), bundle, this.f6663c);
            }
        }

        @Override // b.a.p0.a.j1.d.d.b
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f6664d, this.f6665e, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.f6661a.f6731c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.a.p0.a.j1.d.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6666e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6667f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.j1.d.c.f f6668g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.d2.e f6669h;

        public e(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, b.a.p0.a.j1.d.c.f fVar, b.a.p0.a.d2.e eVar) {
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
            this.f6666e = callbackHandler;
            this.f6667f = unitedSchemeEntity;
            this.f6668g = fVar;
            this.f6669h = eVar;
        }

        @Override // b.a.p0.a.j1.d.d.c
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b.a.p0.a.e0.d.i("chooseVideo", str);
                UnitedSchemeUtility.safeCallback(this.f6666e, this.f6667f, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.f6668g.f6731c);
            }
        }

        @Override // b.a.p0.a.j1.d.d.c
        public void f(List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list != null && list.size() > 0) {
                    b.a.p0.a.e0.d.i("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f6666e, this.f6667f, UnitedSchemeUtility.wrapCallbackParamsWithEncode(b.a.p0.a.j1.d.c.d.n(list, this.f6669h), 0).toString(), this.f6668g.f6731c);
                    return;
                }
                UnitedSchemeUtility.safeCallback(this.f6666e, this.f6667f, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.f6668g.f6731c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b.a.p0.a.f2.e eVar) {
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

    @Override // b.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar != null && eVar.m0()) {
                boolean z = z.f5228b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            }
            b.a.p0.a.j1.d.c.f a2 = b.a.p0.a.j1.d.c.f.a(UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity));
            if (a2.f6729a == 2) {
                q(context, unitedSchemeEntity, callbackHandler, eVar, a2);
            } else {
                o(context, unitedSchemeEntity, callbackHandler, eVar, a2);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar, b.a.p0.a.j1.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            b.a.p0.a.v1.e.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new b(this, context, unitedSchemeEntity, callbackHandler, eVar, fVar));
        }
    }

    public final void p(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar, b.a.p0.a.j1.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            d dVar = new d(this, fVar, eVar, new C0290c(this, eVar, callbackHandler, unitedSchemeEntity, fVar), callbackHandler, unitedSchemeEntity);
            b.a.p0.a.j1.d.c.b.e(eVar.x(), eVar.f4474f, fVar.f6733e, TextUtils.equals(fVar.f6732d, "front"), dVar);
        }
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar, b.a.p0.a.j1.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            b.a.p0.a.v1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new a(this, unitedSchemeEntity, callbackHandler, eVar, fVar));
        }
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar, b.a.p0.a.j1.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, context, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("launchType", "video");
            bundle.putBoolean("isShowCamera", fVar.f6729a == 3);
            bundle.putBoolean("isFrontCamera", TextUtils.equals(fVar.f6732d, "front"));
            bundle.putInt("maxDuration", fVar.f6733e);
            bundle.putInt("count", 1);
            bundle.putString("mode", "single");
            bundle.putBoolean("compressed", fVar.f6730b);
            bundle.putString("swanAppId", eVar.f4474f);
            bundle.putString("swanTmpPath", b.a.p0.a.g1.f.U().G().k());
            b.a.p0.a.j1.d.c.d.l(context, bundle, new e(this, callbackHandler, unitedSchemeEntity, fVar, eVar));
        }
    }
}
