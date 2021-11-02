package b.a.p0.a.i1.d.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import b.a.p0.a.c2.f.a0;
import b.a.p0.a.s1.f;
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
public class c extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5995a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5996b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f5997c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.i1.d.c.f f5998d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5999e;

        public a(c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar, b.a.p0.a.i1.d.c.f fVar) {
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
            this.f5999e = cVar;
            this.f5995a = unitedSchemeEntity;
            this.f5996b = callbackHandler;
            this.f5997c = eVar;
            this.f5998d = fVar;
        }

        @Override // b.a.p0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a0.f4160b) {
                    String str2 = str + "";
                }
                this.f5999e.p(this.f5995a, this.f5996b, this.f5997c, this.f5998d);
            }
        }

        @Override // b.a.p0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f5996b, this.f5995a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f5998d.f6079c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f6000a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6001b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6002c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f6003d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.i1.d.c.f f6004e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f6005f;

        public b(c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar, b.a.p0.a.i1.d.c.f fVar) {
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
            this.f6005f = cVar;
            this.f6000a = context;
            this.f6001b = unitedSchemeEntity;
            this.f6002c = callbackHandler;
            this.f6003d = eVar;
            this.f6004e = fVar;
        }

        @Override // b.a.p0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a0.f4160b) {
                    String str2 = str + "";
                }
                this.f6005f.r(this.f6000a, this.f6001b, this.f6002c, this.f6003d, this.f6004e);
            }
        }

        @Override // b.a.p0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f6002c, this.f6001b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f6004e.f6079c);
            }
        }
    }

    /* renamed from: b.a.p0.a.i1.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0256c implements b.a.p0.a.i1.d.d.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f6006a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6007b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6008c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.i1.d.c.f f6009d;

        public C0256c(c cVar, b.a.p0.a.a2.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, b.a.p0.a.i1.d.c.f fVar) {
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
            this.f6006a = eVar;
            this.f6007b = callbackHandler;
            this.f6008c = unitedSchemeEntity;
            this.f6009d = fVar;
        }

        @Override // b.a.p0.a.i1.d.d.d
        public void a(boolean z, String str, Object obj) {
            Iterator it;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, obj}) == null) {
                if (z && (obj instanceof ArrayList)) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (a0.f4160b) {
                        while (arrayList.iterator().hasNext()) {
                            String str2 = "tempPath = " + ((MediaModel) it.next()).getTempPath();
                        }
                    }
                    b.a.p0.a.e0.d.g("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f6007b, this.f6008c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(b.a.p0.a.i1.d.c.d.n(arrayList, this.f6006a), 0).toString(), this.f6009d.f6079c);
                }
                b.a.p0.a.i1.d.c.e.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements b.a.p0.a.i1.d.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.i1.d.c.f f6010a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f6011b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.i1.d.d.d f6012c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6013d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6014e;

        public d(c cVar, b.a.p0.a.i1.d.c.f fVar, b.a.p0.a.a2.e eVar, b.a.p0.a.i1.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
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
            this.f6010a = fVar;
            this.f6011b = eVar;
            this.f6012c = dVar;
            this.f6013d = callbackHandler;
            this.f6014e = unitedSchemeEntity;
        }

        @Override // b.a.p0.a.i1.d.d.b
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                b.a.p0.a.e0.d.g("chooseVideo", "capture success");
                b.a.p0.a.i1.d.c.e.i(b.a.p0.a.i1.d.c.b.c(file));
                Bundle bundle = new Bundle();
                bundle.putString("swanTmpPath", b.a.p0.a.g1.f.T().G().k());
                bundle.putBoolean("compressed", this.f6010a.f6078b);
                bundle.putString("swanAppId", this.f6011b.f3961f);
                bundle.putParcelableArrayList("mediaModels", b.a.p0.a.i1.d.c.e.e());
                b.a.p0.a.i1.d.c.d.h(this.f6011b.x(), bundle, this.f6012c);
            }
        }

        @Override // b.a.p0.a.i1.d.d.b
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f6013d, this.f6014e, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.f6010a.f6079c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.a.p0.a.i1.d.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6015e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6016f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.i1.d.c.f f6017g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f6018h;

        public e(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, b.a.p0.a.i1.d.c.f fVar, b.a.p0.a.a2.e eVar) {
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
            this.f6015e = callbackHandler;
            this.f6016f = unitedSchemeEntity;
            this.f6017g = fVar;
            this.f6018h = eVar;
        }

        @Override // b.a.p0.a.i1.d.d.c
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b.a.p0.a.e0.d.g("chooseVideo", str);
                UnitedSchemeUtility.safeCallback(this.f6015e, this.f6016f, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.f6017g.f6079c);
            }
        }

        @Override // b.a.p0.a.i1.d.d.c
        public void f(List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list != null && list.size() > 0) {
                    b.a.p0.a.e0.d.g("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f6015e, this.f6016f, UnitedSchemeUtility.wrapCallbackParamsWithEncode(b.a.p0.a.i1.d.c.d.n(list, this.f6018h), 0).toString(), this.f6017g.f6079c);
                    return;
                }
                UnitedSchemeUtility.safeCallback(this.f6015e, this.f6016f, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.f6017g.f6079c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b.a.p0.a.c2.e eVar) {
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

    @Override // b.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar != null && eVar.c0()) {
                boolean z = a0.f4160b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            }
            b.a.p0.a.i1.d.c.f a2 = b.a.p0.a.i1.d.c.f.a(UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity));
            if (a2.f6077a == 2) {
                q(context, unitedSchemeEntity, callbackHandler, eVar, a2);
            } else {
                o(context, unitedSchemeEntity, callbackHandler, eVar, a2);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar, b.a.p0.a.i1.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            b.a.p0.a.s1.e.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new b(this, context, unitedSchemeEntity, callbackHandler, eVar, fVar));
        }
    }

    public final void p(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar, b.a.p0.a.i1.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            d dVar = new d(this, fVar, eVar, new C0256c(this, eVar, callbackHandler, unitedSchemeEntity, fVar), callbackHandler, unitedSchemeEntity);
            b.a.p0.a.i1.d.c.b.e(eVar.x(), eVar.f3961f, fVar.f6081e, TextUtils.equals(fVar.f6080d, "front"), dVar);
        }
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar, b.a.p0.a.i1.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            b.a.p0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new a(this, unitedSchemeEntity, callbackHandler, eVar, fVar));
        }
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar, b.a.p0.a.i1.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, context, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("launchType", "video");
            bundle.putBoolean("isShowCamera", fVar.f6077a == 3);
            bundle.putBoolean("isFrontCamera", TextUtils.equals(fVar.f6080d, "front"));
            bundle.putInt("maxDuration", fVar.f6081e);
            bundle.putInt("count", 1);
            bundle.putString("mode", "single");
            bundle.putBoolean("compressed", fVar.f6078b);
            bundle.putString("swanAppId", eVar.f3961f);
            bundle.putString("swanTmpPath", b.a.p0.a.g1.f.T().G().k());
            b.a.p0.a.i1.d.c.d.l(context, bundle, new e(this, callbackHandler, unitedSchemeEntity, fVar, eVar));
        }
    }
}
