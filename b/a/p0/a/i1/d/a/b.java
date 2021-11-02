package b.a.p0.a.i1.d.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import b.a.p0.a.c2.f.a0;
import b.a.p0.a.e2.c.i;
import b.a.p0.a.e2.c.j.b;
import b.a.p0.a.v2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
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
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public int f5964c;

    /* renamed from: d  reason: collision with root package name */
    public String f5965d;

    /* renamed from: e  reason: collision with root package name */
    public String f5966e;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5967e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5968f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f5969g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f5970h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f5971i;

        public a(b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, b.a.p0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, callbackHandler, unitedSchemeEntity, context, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5971i = bVar;
            this.f5967e = callbackHandler;
            this.f5968f = unitedSchemeEntity;
            this.f5969g = context;
            this.f5970h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (b.a.p0.a.e2.c.d.h(iVar)) {
                    this.f5971i.v(this.f5969g, this.f5968f, this.f5967e, this.f5970h);
                    return;
                }
                b.a.p0.a.e2.c.d.o(iVar, this.f5967e, this.f5968f);
                b.a.p0.a.e0.d.b("chooseImage", "camera authorize failure");
            }
        }
    }

    /* renamed from: b.a.p0.a.i1.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0255b implements b.a.p0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5972a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5973b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f5974c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f5975d;

        public C0255b(b bVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, unitedSchemeEntity, callbackHandler, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5975d = bVar;
            this.f5972a = unitedSchemeEntity;
            this.f5973b = callbackHandler;
            this.f5974c = eVar;
        }

        @Override // b.a.p0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a0.f4160b) {
                    String str2 = str + "";
                }
                this.f5975d.t(this.f5972a, this.f5973b, this.f5974c);
            }
        }

        @Override // b.a.p0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f5973b, this.f5972a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f5975d.f5966e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.a.p0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f5976a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5977b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5978c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f5979d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f5980e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f5981f;

        public c(b bVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, context, unitedSchemeEntity, callbackHandler, eVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5981f = bVar;
            this.f5976a = context;
            this.f5977b = unitedSchemeEntity;
            this.f5978c = callbackHandler;
            this.f5979d = eVar;
            this.f5980e = z;
        }

        @Override // b.a.p0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a0.f4160b) {
                    String str2 = str + "";
                }
                this.f5981f.x(this.f5976a, this.f5977b, this.f5978c, this.f5979d, this.f5980e);
            }
        }

        @Override // b.a.p0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f5978c, this.f5977b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f5981f.f5966e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements b.a.p0.a.i1.d.d.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f5982a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5983b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5984c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f5985d;

        public d(b bVar, b.a.p0.a.a2.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, eVar, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5985d = bVar;
            this.f5982a = eVar;
            this.f5983b = callbackHandler;
            this.f5984c = unitedSchemeEntity;
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
                    b.a.p0.a.e0.d.g("chooseImage", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f5983b, this.f5984c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(b.a.p0.a.i1.d.c.d.m(arrayList, this.f5982a, "Image"), 0).toString(), this.f5985d.f5966e);
                }
                b.a.p0.a.i1.d.c.e.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements b.a.p0.a.i1.d.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f5986a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.i1.d.d.d f5987b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5988c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5989d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f5990e;

        public e(b bVar, b.a.p0.a.a2.e eVar, b.a.p0.a.i1.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, eVar, dVar, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5990e = bVar;
            this.f5986a = eVar;
            this.f5987b = dVar;
            this.f5988c = callbackHandler;
            this.f5989d = unitedSchemeEntity;
        }

        @Override // b.a.p0.a.i1.d.d.b
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                b.a.p0.a.e0.d.g("chooseImage", "capture success");
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                b.a.p0.a.i1.d.c.e.i(imageModel);
                Bundle bundle = new Bundle();
                bundle.putString("swanTmpPath", b.a.p0.a.g1.f.T().G().k());
                bundle.putBoolean("compressed", TextUtils.equals(this.f5990e.f5965d, "compressed"));
                bundle.putString("swanAppId", this.f5986a.f3961f);
                bundle.putParcelableArrayList("mediaModels", b.a.p0.a.i1.d.c.e.e());
                b.a.p0.a.i1.d.c.d.h(this.f5986a.x(), bundle, this.f5987b);
            }
        }

        @Override // b.a.p0.a.i1.d.d.b
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f5988c, this.f5989d, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.f5990e.f5966e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements b.a.p0.a.i1.d.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5991e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f5992f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f5993g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f5994h;

        public f(b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, b.a.p0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, callbackHandler, unitedSchemeEntity, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5994h = bVar;
            this.f5991e = callbackHandler;
            this.f5992f = unitedSchemeEntity;
            this.f5993g = eVar;
        }

        @Override // b.a.p0.a.i1.d.d.c
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                b.a.p0.a.e0.d.g("chooseImage", str);
                UnitedSchemeUtility.safeCallback(this.f5991e, this.f5992f, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.f5994h.f5966e);
            }
        }

        @Override // b.a.p0.a.i1.d.d.c
        public void f(List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list != null && list.size() > 0) {
                    b.a.p0.a.e0.d.g("chooseImage", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f5991e, this.f5992f, UnitedSchemeUtility.wrapCallbackParamsWithEncode(b.a.p0.a.i1.d.c.d.m(list, this.f5993g, "Image"), 0).toString(), this.f5994h.f5966e);
                    return;
                }
                UnitedSchemeUtility.safeCallback(this.f5991e, this.f5992f, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.f5994h.f5966e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(b.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/chooseImage");
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
            if (eVar != null && eVar.x() != null) {
                if (eVar.c0()) {
                    boolean z = a0.f4160b;
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                    return false;
                }
                JSONObject d2 = w.d(unitedSchemeEntity.getParam("params"));
                String optString = d2.optString("cb");
                this.f5966e = optString;
                if (TextUtils.isEmpty(optString)) {
                    b.a.p0.a.e0.d.b("chooseImage", "empty cb");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                try {
                    int parseInt = Integer.parseInt(d2.optString("count"));
                    this.f5964c = parseInt;
                    if (parseInt < 1 || parseInt > 9) {
                        this.f5964c = 9;
                    }
                } catch (NumberFormatException unused) {
                    b.a.p0.a.e0.d.b("chooseImage", "count format error");
                    this.f5964c = 9;
                }
                this.f5965d = r(d2.optJSONArray("sizeType"));
                JSONArray optJSONArray = d2.optJSONArray("sourceType");
                String s = s(optJSONArray);
                b.a.p0.a.e0.d.g("chooseImage", "sizeType: " + this.f5965d + ",sourceType: " + s);
                if (TextUtils.equals(s, "album")) {
                    u(context, unitedSchemeEntity, callbackHandler, eVar, w(optJSONArray));
                } else {
                    eVar.S().g(eVar.x(), PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, eVar));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            b.a.p0.a.e0.d.b("chooseImage", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final String r(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray)) == null) {
            boolean z = true;
            return (jSONArray != null && jSONArray.length() == 1 && TextUtils.equals("original", jSONArray.optString(0))) ? false : false ? "original" : "compressed";
        }
        return (String) invokeL.objValue;
    }

    public final String s(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONArray)) == null) {
            boolean z = true;
            return (jSONArray != null && jSONArray.length() == 1 && TextUtils.equals("camera", jSONArray.optString(0))) ? false : false ? "camera" : "album";
        }
        return (String) invokeL.objValue;
    }

    public final void t(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, unitedSchemeEntity, callbackHandler, eVar) == null) {
            b.a.p0.a.i1.d.c.b.f(eVar.x(), eVar.f3961f, new e(this, eVar, new d(this, eVar, callbackHandler, unitedSchemeEntity), callbackHandler, unitedSchemeEntity));
        }
    }

    public final void u(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, Boolean.valueOf(z)}) == null) {
            b.a.p0.a.s1.e.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new c(this, context, unitedSchemeEntity, callbackHandler, eVar, z));
        }
    }

    public final void v(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, context, unitedSchemeEntity, callbackHandler, eVar) == null) {
            b.a.p0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new C0255b(this, unitedSchemeEntity, callbackHandler, eVar));
        }
    }

    public final boolean w(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() == 0) {
                return true;
            }
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (TextUtils.equals("camera", jSONArray.optString(i2))) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void x(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, Boolean.valueOf(z)}) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("launchType", "Image");
            bundle.putBoolean("isShowCamera", z);
            bundle.putInt("count", this.f5964c);
            bundle.putString("mode", "single");
            bundle.putBoolean("compressed", TextUtils.equals(this.f5965d, "compressed"));
            bundle.putString("swanAppId", eVar.f3961f);
            bundle.putString("swanTmpPath", b.a.p0.a.g1.f.T().G().k());
            b.a.p0.a.i1.d.c.d.l(context, bundle, new f(this, callbackHandler, unitedSchemeEntity, eVar));
        }
    }
}
