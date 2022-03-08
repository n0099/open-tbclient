package c.a.p0.a.z0.d.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import c.a.p0.a.p2.w;
import c.a.p0.a.v1.f.z;
import c.a.p0.a.x1.c.i;
import c.a.p0.a.x1.c.j.b;
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
public class b extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public int f9312c;

    /* renamed from: d  reason: collision with root package name */
    public String f9313d;

    /* renamed from: e  reason: collision with root package name */
    public String f9314e;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.p2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9315e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9316f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f9317g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.e f9318h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f9319i;

        public a(b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, c.a.p0.a.t1.e eVar) {
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
            this.f9319i = bVar;
            this.f9315e = callbackHandler;
            this.f9316f = unitedSchemeEntity;
            this.f9317g = context;
            this.f9318h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.x1.c.d.h(iVar)) {
                    this.f9319i.v(this.f9317g, this.f9316f, this.f9315e, this.f9318h);
                    return;
                }
                c.a.p0.a.x1.c.d.p(iVar, this.f9315e, this.f9316f);
                c.a.p0.a.u.d.c("chooseImage", "camera authorize failure");
            }
        }
    }

    /* renamed from: c.a.p0.a.z0.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0612b implements c.a.p0.a.l1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9320e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9321f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.e f9322g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f9323h;

        public C0612b(b bVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar) {
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
            this.f9323h = bVar;
            this.f9320e = unitedSchemeEntity;
            this.f9321f = callbackHandler;
            this.f9322g = eVar;
        }

        @Override // c.a.p0.a.l1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (z.f8176b) {
                    String str2 = str + "";
                }
                this.f9323h.t(this.f9320e, this.f9321f, this.f9322g);
            }
        }

        @Override // c.a.p0.a.l1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f9321f, this.f9320e, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f9323h.f9314e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.p0.a.l1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f9324e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9325f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9326g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.e f9327h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f9328i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f9329j;

        public c(b bVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar, boolean z) {
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
            this.f9329j = bVar;
            this.f9324e = context;
            this.f9325f = unitedSchemeEntity;
            this.f9326g = callbackHandler;
            this.f9327h = eVar;
            this.f9328i = z;
        }

        @Override // c.a.p0.a.l1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (z.f8176b) {
                    String str2 = str + "";
                }
                this.f9329j.x(this.f9324e, this.f9325f, this.f9326g, this.f9327h, this.f9328i);
            }
        }

        @Override // c.a.p0.a.l1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f9326g, this.f9325f, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f9329j.f9314e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.p0.a.z0.d.d.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.t1.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9330b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9331c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f9332d;

        public d(b bVar, c.a.p0.a.t1.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
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
            this.f9332d = bVar;
            this.a = eVar;
            this.f9330b = callbackHandler;
            this.f9331c = unitedSchemeEntity;
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
                    c.a.p0.a.u.d.i("chooseImage", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f9330b, this.f9331c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(c.a.p0.a.z0.d.c.d.m(arrayList, this.a, "Image"), 0).toString(), this.f9332d.f9314e);
                }
                c.a.p0.a.z0.d.c.e.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.p0.a.z0.d.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.t1.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.z0.d.d.d f9333b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9334c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9335d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f9336e;

        public e(b bVar, c.a.p0.a.t1.e eVar, c.a.p0.a.z0.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
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
            this.f9336e = bVar;
            this.a = eVar;
            this.f9333b = dVar;
            this.f9334c = callbackHandler;
            this.f9335d = unitedSchemeEntity;
        }

        @Override // c.a.p0.a.z0.d.d.b
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                c.a.p0.a.u.d.i("chooseImage", "capture success");
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                c.a.p0.a.z0.d.c.e.i(imageModel);
                Bundle bundle = new Bundle();
                bundle.putString("swanTmpPath", c.a.p0.a.w0.f.U().G().k());
                bundle.putBoolean("compressed", TextUtils.equals(this.f9336e.f9313d, "compressed"));
                bundle.putString("swanAppId", this.a.f7512f);
                bundle.putParcelableArrayList("mediaModels", c.a.p0.a.z0.d.c.e.e());
                c.a.p0.a.z0.d.c.d.h(this.a.x(), bundle, this.f9333b);
            }
        }

        @Override // c.a.p0.a.z0.d.d.b
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f9334c, this.f9335d, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.f9336e.f9314e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.p0.a.z0.d.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9337e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f9338f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.t1.e f9339g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f9340h;

        public f(b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, c.a.p0.a.t1.e eVar) {
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
            this.f9340h = bVar;
            this.f9337e = callbackHandler;
            this.f9338f = unitedSchemeEntity;
            this.f9339g = eVar;
        }

        @Override // c.a.p0.a.z0.d.d.c
        public void f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.p0.a.u.d.i("chooseImage", str);
                UnitedSchemeUtility.safeCallback(this.f9337e, this.f9338f, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.f9340h.f9314e);
            }
        }

        @Override // c.a.p0.a.z0.d.d.c
        public void j(List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list != null && list.size() > 0) {
                    c.a.p0.a.u.d.i("chooseImage", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f9337e, this.f9338f, UnitedSchemeUtility.wrapCallbackParamsWithEncode(c.a.p0.a.z0.d.c.d.m(list, this.f9339g, "Image"), 0).toString(), this.f9340h.f9314e);
                    return;
                }
                UnitedSchemeUtility.safeCallback(this.f9337e, this.f9338f, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.f9340h.f9314e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c.a.p0.a.v1.e eVar) {
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

    @Override // c.a.p0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar != null && eVar.x() != null) {
                if (eVar.m0()) {
                    boolean z = z.f8176b;
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                    return false;
                }
                JSONObject d2 = w.d(unitedSchemeEntity.getParam("params"));
                String optString = d2.optString("cb");
                this.f9314e = optString;
                if (TextUtils.isEmpty(optString)) {
                    c.a.p0.a.u.d.c("chooseImage", "empty cb");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                try {
                    int parseInt = Integer.parseInt(d2.optString("count"));
                    this.f9312c = parseInt;
                    if (parseInt < 1 || parseInt > 9) {
                        this.f9312c = 9;
                    }
                } catch (NumberFormatException unused) {
                    c.a.p0.a.u.d.c("chooseImage", "count format error");
                    this.f9312c = 9;
                }
                this.f9313d = r(d2.optJSONArray("sizeType"));
                JSONArray optJSONArray = d2.optJSONArray("sourceType");
                String s = s(optJSONArray);
                c.a.p0.a.u.d.i("chooseImage", "sizeType: " + this.f9313d + ",sourceType: " + s);
                if (TextUtils.equals(s, "album")) {
                    u(context, unitedSchemeEntity, callbackHandler, eVar, w(optJSONArray));
                } else {
                    eVar.d0().g(eVar.x(), PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, eVar));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            c.a.p0.a.u.d.c("chooseImage", "illegal swanApp");
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

    public final void t(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, unitedSchemeEntity, callbackHandler, eVar) == null) {
            c.a.p0.a.z0.d.c.b.f(eVar.x(), eVar.f7512f, new e(this, eVar, new d(this, eVar, callbackHandler, unitedSchemeEntity), callbackHandler, unitedSchemeEntity));
        }
    }

    public final void u(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, Boolean.valueOf(z)}) == null) {
            c.a.p0.a.l1.e.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new c(this, context, unitedSchemeEntity, callbackHandler, eVar, z));
        }
    }

    public final void v(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, context, unitedSchemeEntity, callbackHandler, eVar) == null) {
            c.a.p0.a.l1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new C0612b(this, unitedSchemeEntity, callbackHandler, eVar));
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

    public final void x(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, Boolean.valueOf(z)}) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("launchType", "Image");
            bundle.putBoolean("isShowCamera", z);
            bundle.putInt("count", this.f9312c);
            bundle.putString("mode", "single");
            bundle.putBoolean("compressed", TextUtils.equals(this.f9313d, "compressed"));
            bundle.putString("swanAppId", eVar.f7512f);
            bundle.putString("swanTmpPath", c.a.p0.a.w0.f.U().G().k());
            c.a.p0.a.z0.d.c.d.l(context, bundle, new f(this, callbackHandler, unitedSchemeEntity, eVar));
        }
    }
}
