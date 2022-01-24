package c.a.r0.a.j1.d.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import c.a.r0.a.f2.f.z;
import c.a.r0.a.h2.c.i;
import c.a.r0.a.h2.c.j.b;
import c.a.r0.a.z2.w;
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
    public int f7479c;

    /* renamed from: d  reason: collision with root package name */
    public String f7480d;

    /* renamed from: e  reason: collision with root package name */
    public String f7481e;

    /* loaded from: classes.dex */
    public class a implements c.a.r0.a.z2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7482e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7483f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f7484g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.d2.e f7485h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f7486i;

        public a(b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, c.a.r0.a.d2.e eVar) {
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
            this.f7486i = bVar;
            this.f7482e = callbackHandler;
            this.f7483f = unitedSchemeEntity;
            this.f7484g = context;
            this.f7485h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.r0.a.h2.c.d.h(iVar)) {
                    this.f7486i.v(this.f7484g, this.f7483f, this.f7482e, this.f7485h);
                    return;
                }
                c.a.r0.a.h2.c.d.p(iVar, this.f7482e, this.f7483f);
                c.a.r0.a.e0.d.c("chooseImage", "camera authorize failure");
            }
        }
    }

    /* renamed from: c.a.r0.a.j1.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0447b implements c.a.r0.a.v1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7487e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7488f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.d2.e f7489g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f7490h;

        public C0447b(b bVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar) {
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
            this.f7490h = bVar;
            this.f7487e = unitedSchemeEntity;
            this.f7488f = callbackHandler;
            this.f7489g = eVar;
        }

        @Override // c.a.r0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (z.f6343b) {
                    String str2 = str + "";
                }
                this.f7490h.t(this.f7487e, this.f7488f, this.f7489g);
            }
        }

        @Override // c.a.r0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f7488f, this.f7487e, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f7490h.f7481e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.r0.a.v1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f7491e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7492f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7493g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.d2.e f7494h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ boolean f7495i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f7496j;

        public c(b bVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar, boolean z) {
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
            this.f7496j = bVar;
            this.f7491e = context;
            this.f7492f = unitedSchemeEntity;
            this.f7493g = callbackHandler;
            this.f7494h = eVar;
            this.f7495i = z;
        }

        @Override // c.a.r0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (z.f6343b) {
                    String str2 = str + "";
                }
                this.f7496j.x(this.f7491e, this.f7492f, this.f7493g, this.f7494h, this.f7495i);
            }
        }

        @Override // c.a.r0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f7493g, this.f7492f, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f7496j.f7481e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.r0.a.j1.d.d.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.d2.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7497b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7498c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f7499d;

        public d(b bVar, c.a.r0.a.d2.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
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
            this.f7499d = bVar;
            this.a = eVar;
            this.f7497b = callbackHandler;
            this.f7498c = unitedSchemeEntity;
        }

        @Override // c.a.r0.a.j1.d.d.d
        public void a(boolean z, String str, Object obj) {
            Iterator it;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, obj}) == null) {
                if (z && (obj instanceof ArrayList)) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (z.f6343b) {
                        while (arrayList.iterator().hasNext()) {
                            String str2 = "tempPath = " + ((MediaModel) it.next()).getTempPath();
                        }
                    }
                    c.a.r0.a.e0.d.i("chooseImage", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f7497b, this.f7498c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(c.a.r0.a.j1.d.c.d.m(arrayList, this.a, "Image"), 0).toString(), this.f7499d.f7481e);
                }
                c.a.r0.a.j1.d.c.e.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.r0.a.j1.d.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.d2.e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.j1.d.d.d f7500b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7501c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7502d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f7503e;

        public e(b bVar, c.a.r0.a.d2.e eVar, c.a.r0.a.j1.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
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
            this.f7503e = bVar;
            this.a = eVar;
            this.f7500b = dVar;
            this.f7501c = callbackHandler;
            this.f7502d = unitedSchemeEntity;
        }

        @Override // c.a.r0.a.j1.d.d.b
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                c.a.r0.a.e0.d.i("chooseImage", "capture success");
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                c.a.r0.a.j1.d.c.e.i(imageModel);
                Bundle bundle = new Bundle();
                bundle.putString("swanTmpPath", c.a.r0.a.g1.f.U().G().k());
                bundle.putBoolean("compressed", TextUtils.equals(this.f7503e.f7480d, "compressed"));
                bundle.putString("swanAppId", this.a.f5679f);
                bundle.putParcelableArrayList("mediaModels", c.a.r0.a.j1.d.c.e.e());
                c.a.r0.a.j1.d.c.d.h(this.a.x(), bundle, this.f7500b);
            }
        }

        @Override // c.a.r0.a.j1.d.d.b
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f7501c, this.f7502d, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.f7503e.f7481e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.r0.a.j1.d.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7504e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7505f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.d2.e f7506g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f7507h;

        public f(b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, c.a.r0.a.d2.e eVar) {
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
            this.f7507h = bVar;
            this.f7504e = callbackHandler;
            this.f7505f = unitedSchemeEntity;
            this.f7506g = eVar;
        }

        @Override // c.a.r0.a.j1.d.d.c
        public void f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.r0.a.e0.d.i("chooseImage", str);
                UnitedSchemeUtility.safeCallback(this.f7504e, this.f7505f, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.f7507h.f7481e);
            }
        }

        @Override // c.a.r0.a.j1.d.d.c
        public void j(List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list != null && list.size() > 0) {
                    c.a.r0.a.e0.d.i("chooseImage", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f7504e, this.f7505f, UnitedSchemeUtility.wrapCallbackParamsWithEncode(c.a.r0.a.j1.d.c.d.m(list, this.f7506g, "Image"), 0).toString(), this.f7507h.f7481e);
                    return;
                }
                UnitedSchemeUtility.safeCallback(this.f7504e, this.f7505f, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.f7507h.f7481e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c.a.r0.a.f2.e eVar) {
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

    @Override // c.a.r0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar) {
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
                this.f7481e = optString;
                if (TextUtils.isEmpty(optString)) {
                    c.a.r0.a.e0.d.c("chooseImage", "empty cb");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                try {
                    int parseInt = Integer.parseInt(d2.optString("count"));
                    this.f7479c = parseInt;
                    if (parseInt < 1 || parseInt > 9) {
                        this.f7479c = 9;
                    }
                } catch (NumberFormatException unused) {
                    c.a.r0.a.e0.d.c("chooseImage", "count format error");
                    this.f7479c = 9;
                }
                this.f7480d = r(d2.optJSONArray("sizeType"));
                JSONArray optJSONArray = d2.optJSONArray("sourceType");
                String s = s(optJSONArray);
                c.a.r0.a.e0.d.i("chooseImage", "sizeType: " + this.f7480d + ",sourceType: " + s);
                if (TextUtils.equals(s, "album")) {
                    u(context, unitedSchemeEntity, callbackHandler, eVar, w(optJSONArray));
                } else {
                    eVar.d0().g(eVar.x(), PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, eVar));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            c.a.r0.a.e0.d.c("chooseImage", "illegal swanApp");
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

    public final void t(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, unitedSchemeEntity, callbackHandler, eVar) == null) {
            c.a.r0.a.j1.d.c.b.f(eVar.x(), eVar.f5679f, new e(this, eVar, new d(this, eVar, callbackHandler, unitedSchemeEntity), callbackHandler, unitedSchemeEntity));
        }
    }

    public final void u(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, Boolean.valueOf(z)}) == null) {
            c.a.r0.a.v1.e.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new c(this, context, unitedSchemeEntity, callbackHandler, eVar, z));
        }
    }

    public final void v(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, context, unitedSchemeEntity, callbackHandler, eVar) == null) {
            c.a.r0.a.v1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new C0447b(this, unitedSchemeEntity, callbackHandler, eVar));
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

    public final void x(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.r0.a.d2.e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, Boolean.valueOf(z)}) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("launchType", "Image");
            bundle.putBoolean("isShowCamera", z);
            bundle.putInt("count", this.f7479c);
            bundle.putString("mode", "single");
            bundle.putBoolean("compressed", TextUtils.equals(this.f7480d, "compressed"));
            bundle.putString("swanAppId", eVar.f5679f);
            bundle.putString("swanTmpPath", c.a.r0.a.g1.f.U().G().k());
            c.a.r0.a.j1.d.c.d.l(context, bundle, new f(this, callbackHandler, unitedSchemeEntity, eVar));
        }
    }
}
