package c.a.p0.a.z0.d.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import c.a.p0.a.l1.f;
import c.a.p0.a.v1.f.z;
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
        public final /* synthetic */ UnitedSchemeEntity f9341e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9342f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.e f9343g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.z0.d.c.f f9344h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c f9345i;

        public a(c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar, c.a.p0.a.z0.d.c.f fVar) {
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
            this.f9345i = cVar;
            this.f9341e = unitedSchemeEntity;
            this.f9342f = callbackHandler;
            this.f9343g = eVar;
            this.f9344h = fVar;
        }

        @Override // c.a.p0.a.l1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (z.f8176b) {
                    String str2 = str + "";
                }
                this.f9345i.p(this.f9341e, this.f9342f, this.f9343g, this.f9344h);
            }
        }

        @Override // c.a.p0.a.l1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f9342f, this.f9341e, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f9344h.f9412c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f9346e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9347f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9348g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.e f9349h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.z0.d.c.f f9350i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c f9351j;

        public b(c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar, c.a.p0.a.z0.d.c.f fVar) {
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
            this.f9351j = cVar;
            this.f9346e = context;
            this.f9347f = unitedSchemeEntity;
            this.f9348g = callbackHandler;
            this.f9349h = eVar;
            this.f9350i = fVar;
        }

        @Override // c.a.p0.a.l1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (z.f8176b) {
                    String str2 = str + "";
                }
                this.f9351j.r(this.f9346e, this.f9347f, this.f9348g, this.f9349h, this.f9350i);
            }
        }

        @Override // c.a.p0.a.l1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f9348g, this.f9347f, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f9350i.f9412c);
            }
        }
    }

    /* renamed from: c.a.p0.a.z0.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0613c implements c.a.p0.a.z0.d.d.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.t1.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9352b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9353c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.z0.d.c.f f9354d;

        public C0613c(c cVar, c.a.p0.a.t1.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, c.a.p0.a.z0.d.c.f fVar) {
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
            this.f9352b = callbackHandler;
            this.f9353c = unitedSchemeEntity;
            this.f9354d = fVar;
        }

        @Override // c.a.p0.a.z0.d.d.d
        public void a(boolean z, String str, Object obj) {
            Iterator it;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, obj}) == null) {
                if (z && (obj instanceof ArrayList)) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (z.f8176b) {
                        while (arrayList.iterator().hasNext()) {
                            String str2 = "tempPath = " + ((MediaModel) it.next()).getTempPath();
                        }
                    }
                    c.a.p0.a.u.d.i("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f9352b, this.f9353c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(c.a.p0.a.z0.d.c.d.n(arrayList, this.a), 0).toString(), this.f9354d.f9412c);
                }
                c.a.p0.a.z0.d.c.e.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.p0.a.z0.d.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.z0.d.c.f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.e f9355b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.z0.d.d.d f9356c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9357d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9358e;

        public d(c cVar, c.a.p0.a.z0.d.c.f fVar, c.a.p0.a.t1.e eVar, c.a.p0.a.z0.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
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
            this.f9355b = eVar;
            this.f9356c = dVar;
            this.f9357d = callbackHandler;
            this.f9358e = unitedSchemeEntity;
        }

        @Override // c.a.p0.a.z0.d.d.b
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                c.a.p0.a.u.d.i("chooseVideo", "capture success");
                c.a.p0.a.z0.d.c.e.i(c.a.p0.a.z0.d.c.b.c(file));
                Bundle bundle = new Bundle();
                bundle.putString("swanTmpPath", c.a.p0.a.w0.f.U().G().k());
                bundle.putBoolean("compressed", this.a.f9411b);
                bundle.putString("swanAppId", this.f9355b.f7512f);
                bundle.putParcelableArrayList("mediaModels", c.a.p0.a.z0.d.c.e.e());
                c.a.p0.a.z0.d.c.d.h(this.f9355b.x(), bundle, this.f9356c);
            }
        }

        @Override // c.a.p0.a.z0.d.d.b
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f9357d, this.f9358e, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.a.f9412c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.p0.a.z0.d.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9359e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9360f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.z0.d.c.f f9361g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.e f9362h;

        public e(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, c.a.p0.a.z0.d.c.f fVar, c.a.p0.a.t1.e eVar) {
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
            this.f9359e = callbackHandler;
            this.f9360f = unitedSchemeEntity;
            this.f9361g = fVar;
            this.f9362h = eVar;
        }

        @Override // c.a.p0.a.z0.d.d.c
        public void f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.p0.a.u.d.i("chooseVideo", str);
                UnitedSchemeUtility.safeCallback(this.f9359e, this.f9360f, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.f9361g.f9412c);
            }
        }

        @Override // c.a.p0.a.z0.d.d.c
        public void j(List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list != null && list.size() > 0) {
                    c.a.p0.a.u.d.i("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f9359e, this.f9360f, UnitedSchemeUtility.wrapCallbackParamsWithEncode(c.a.p0.a.z0.d.c.d.n(list, this.f9362h), 0).toString(), this.f9361g.f9412c);
                    return;
                }
                UnitedSchemeUtility.safeCallback(this.f9359e, this.f9360f, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.f9361g.f9412c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(c.a.p0.a.v1.e eVar) {
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

    @Override // c.a.p0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar != null && eVar.m0()) {
                boolean z = z.f8176b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            }
            c.a.p0.a.z0.d.c.f a2 = c.a.p0.a.z0.d.c.f.a(UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity));
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

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar, c.a.p0.a.z0.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            c.a.p0.a.l1.e.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new b(this, context, unitedSchemeEntity, callbackHandler, eVar, fVar));
        }
    }

    public final void p(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar, c.a.p0.a.z0.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            d dVar = new d(this, fVar, eVar, new C0613c(this, eVar, callbackHandler, unitedSchemeEntity, fVar), callbackHandler, unitedSchemeEntity);
            c.a.p0.a.z0.d.c.b.e(eVar.x(), eVar.f7512f, fVar.f9414e, TextUtils.equals(fVar.f9413d, "front"), dVar);
        }
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar, c.a.p0.a.z0.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            c.a.p0.a.l1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new a(this, unitedSchemeEntity, callbackHandler, eVar, fVar));
        }
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar, c.a.p0.a.z0.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, context, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("launchType", "video");
            bundle.putBoolean("isShowCamera", fVar.a == 3);
            bundle.putBoolean("isFrontCamera", TextUtils.equals(fVar.f9413d, "front"));
            bundle.putInt("maxDuration", fVar.f9414e);
            bundle.putInt("count", 1);
            bundle.putString("mode", "single");
            bundle.putBoolean("compressed", fVar.f9411b);
            bundle.putString("swanAppId", eVar.f7512f);
            bundle.putString("swanTmpPath", c.a.p0.a.w0.f.U().G().k());
            c.a.p0.a.z0.d.c.d.l(context, bundle, new e(this, callbackHandler, unitedSchemeEntity, fVar, eVar));
        }
    }
}
