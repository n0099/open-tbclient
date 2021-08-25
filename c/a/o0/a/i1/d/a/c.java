package c.a.o0.a.i1.d.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import c.a.o0.a.c2.f.a0;
import c.a.o0.a.s1.f;
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
        public final /* synthetic */ UnitedSchemeEntity f6635a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6636b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a2.e f6637c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.i1.d.c.f f6638d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f6639e;

        public a(c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar, c.a.o0.a.i1.d.c.f fVar) {
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
            this.f6639e = cVar;
            this.f6635a = unitedSchemeEntity;
            this.f6636b = callbackHandler;
            this.f6637c = eVar;
            this.f6638d = fVar;
        }

        @Override // c.a.o0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a0.f4738b) {
                    String str2 = str + "";
                }
                this.f6639e.p(this.f6635a, this.f6636b, this.f6637c, this.f6638d);
            }
        }

        @Override // c.a.o0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f6636b, this.f6635a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f6638d.f6721c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f6640a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6641b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6642c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a2.e f6643d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.i1.d.c.f f6644e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f6645f;

        public b(c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar, c.a.o0.a.i1.d.c.f fVar) {
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
            this.f6645f = cVar;
            this.f6640a = context;
            this.f6641b = unitedSchemeEntity;
            this.f6642c = callbackHandler;
            this.f6643d = eVar;
            this.f6644e = fVar;
        }

        @Override // c.a.o0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a0.f4738b) {
                    String str2 = str + "";
                }
                this.f6645f.r(this.f6640a, this.f6641b, this.f6642c, this.f6643d, this.f6644e);
            }
        }

        @Override // c.a.o0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f6642c, this.f6641b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f6644e.f6721c);
            }
        }
    }

    /* renamed from: c.a.o0.a.i1.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0259c implements c.a.o0.a.i1.d.d.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a2.e f6646a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6647b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6648c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.i1.d.c.f f6649d;

        public C0259c(c cVar, c.a.o0.a.a2.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, c.a.o0.a.i1.d.c.f fVar) {
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
            this.f6646a = eVar;
            this.f6647b = callbackHandler;
            this.f6648c = unitedSchemeEntity;
            this.f6649d = fVar;
        }

        @Override // c.a.o0.a.i1.d.d.d
        public void a(boolean z, String str, Object obj) {
            Iterator it;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, obj}) == null) {
                if (z && (obj instanceof ArrayList)) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (a0.f4738b) {
                        while (arrayList.iterator().hasNext()) {
                            String str2 = "tempPath = " + ((MediaModel) it.next()).getTempPath();
                        }
                    }
                    c.a.o0.a.e0.d.g("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f6647b, this.f6648c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(c.a.o0.a.i1.d.c.d.n(arrayList, this.f6646a), 0).toString(), this.f6649d.f6721c);
                }
                c.a.o0.a.i1.d.c.e.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.o0.a.i1.d.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.i1.d.c.f f6650a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a2.e f6651b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.i1.d.d.d f6652c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6653d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6654e;

        public d(c cVar, c.a.o0.a.i1.d.c.f fVar, c.a.o0.a.a2.e eVar, c.a.o0.a.i1.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
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
            this.f6650a = fVar;
            this.f6651b = eVar;
            this.f6652c = dVar;
            this.f6653d = callbackHandler;
            this.f6654e = unitedSchemeEntity;
        }

        @Override // c.a.o0.a.i1.d.d.b
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                c.a.o0.a.e0.d.g("chooseVideo", "capture success");
                c.a.o0.a.i1.d.c.e.i(c.a.o0.a.i1.d.c.b.c(file));
                Bundle bundle = new Bundle();
                bundle.putString("swanTmpPath", c.a.o0.a.g1.f.V().I().k());
                bundle.putBoolean("compressed", this.f6650a.f6720b);
                bundle.putString("swanAppId", this.f6651b.f4530f);
                bundle.putParcelableArrayList("mediaModels", c.a.o0.a.i1.d.c.e.e());
                c.a.o0.a.i1.d.c.d.h(this.f6651b.x(), bundle, this.f6652c);
            }
        }

        @Override // c.a.o0.a.i1.d.d.b
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f6653d, this.f6654e, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.f6650a.f6721c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.o0.a.i1.d.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6655e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6656f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.i1.d.c.f f6657g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a2.e f6658h;

        public e(c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, c.a.o0.a.i1.d.c.f fVar, c.a.o0.a.a2.e eVar) {
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
            this.f6655e = callbackHandler;
            this.f6656f = unitedSchemeEntity;
            this.f6657g = fVar;
            this.f6658h = eVar;
        }

        @Override // c.a.o0.a.i1.d.d.c
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.o0.a.e0.d.g("chooseVideo", str);
                UnitedSchemeUtility.safeCallback(this.f6655e, this.f6656f, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.f6657g.f6721c);
            }
        }

        @Override // c.a.o0.a.i1.d.d.c
        public void f(List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list != null && list.size() > 0) {
                    c.a.o0.a.e0.d.g("chooseVideo", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f6655e, this.f6656f, UnitedSchemeUtility.wrapCallbackParamsWithEncode(c.a.o0.a.i1.d.c.d.n(list, this.f6658h), 0).toString(), this.f6657g.f6721c);
                    return;
                }
                UnitedSchemeUtility.safeCallback(this.f6655e, this.f6656f, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.f6657g.f6721c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(c.a.o0.a.c2.e eVar) {
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

    @Override // c.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar != null && eVar.d0()) {
                boolean z = a0.f4738b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            }
            c.a.o0.a.i1.d.c.f a2 = c.a.o0.a.i1.d.c.f.a(UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity));
            if (a2.f6719a == 2) {
                q(context, unitedSchemeEntity, callbackHandler, eVar, a2);
            } else {
                o(context, unitedSchemeEntity, callbackHandler, eVar, a2);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar, c.a.o0.a.i1.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            c.a.o0.a.s1.e.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new b(this, context, unitedSchemeEntity, callbackHandler, eVar, fVar));
        }
    }

    public final void p(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar, c.a.o0.a.i1.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            d dVar = new d(this, fVar, eVar, new C0259c(this, eVar, callbackHandler, unitedSchemeEntity, fVar), callbackHandler, unitedSchemeEntity);
            c.a.o0.a.i1.d.c.b.e(eVar.x(), eVar.f4530f, fVar.f6723e, TextUtils.equals(fVar.f6722d, "front"), dVar);
        }
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar, c.a.o0.a.i1.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            c.a.o0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new a(this, unitedSchemeEntity, callbackHandler, eVar, fVar));
        }
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar, c.a.o0.a.i1.d.c.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, context, unitedSchemeEntity, callbackHandler, eVar, fVar) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("launchType", "video");
            bundle.putBoolean("isShowCamera", fVar.f6719a == 3);
            bundle.putBoolean("isFrontCamera", TextUtils.equals(fVar.f6722d, "front"));
            bundle.putInt("maxDuration", fVar.f6723e);
            bundle.putInt("count", 1);
            bundle.putString("mode", "single");
            bundle.putBoolean("compressed", fVar.f6720b);
            bundle.putString("swanAppId", eVar.f4530f);
            bundle.putString("swanTmpPath", c.a.o0.a.g1.f.V().I().k());
            c.a.o0.a.i1.d.c.d.l(context, bundle, new e(this, callbackHandler, unitedSchemeEntity, fVar, eVar));
        }
    }
}
