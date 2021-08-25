package c.a.o0.a.i1.d.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import c.a.o0.a.c2.f.a0;
import c.a.o0.a.e2.c.i;
import c.a.o0.a.e2.c.j.b;
import c.a.o0.a.v2.w;
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
    public int f6604c;

    /* renamed from: d  reason: collision with root package name */
    public String f6605d;

    /* renamed from: e  reason: collision with root package name */
    public String f6606e;

    /* loaded from: classes.dex */
    public class a implements c.a.o0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6607e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6608f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f6609g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a2.e f6610h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f6611i;

        public a(b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, c.a.o0.a.a2.e eVar) {
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
            this.f6611i = bVar;
            this.f6607e = callbackHandler;
            this.f6608f = unitedSchemeEntity;
            this.f6609g = context;
            this.f6610h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.o0.a.e2.c.d.h(iVar)) {
                    this.f6611i.v(this.f6609g, this.f6608f, this.f6607e, this.f6610h);
                    return;
                }
                c.a.o0.a.e2.c.d.o(iVar, this.f6607e, this.f6608f);
                c.a.o0.a.e0.d.b("chooseImage", "camera authorize failure");
            }
        }
    }

    /* renamed from: c.a.o0.a.i1.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0258b implements c.a.o0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6612a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6613b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a2.e f6614c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f6615d;

        public C0258b(b bVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar) {
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
            this.f6615d = bVar;
            this.f6612a = unitedSchemeEntity;
            this.f6613b = callbackHandler;
            this.f6614c = eVar;
        }

        @Override // c.a.o0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a0.f4738b) {
                    String str2 = str + "";
                }
                this.f6615d.t(this.f6612a, this.f6613b, this.f6614c);
            }
        }

        @Override // c.a.o0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f6613b, this.f6612a, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f6615d.f6606e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.o0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f6616a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6617b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6618c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a2.e f6619d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f6620e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f6621f;

        public c(b bVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar, boolean z) {
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
            this.f6621f = bVar;
            this.f6616a = context;
            this.f6617b = unitedSchemeEntity;
            this.f6618c = callbackHandler;
            this.f6619d = eVar;
            this.f6620e = z;
        }

        @Override // c.a.o0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (a0.f4738b) {
                    String str2 = str + "";
                }
                this.f6621f.x(this.f6616a, this.f6617b, this.f6618c, this.f6619d, this.f6620e);
            }
        }

        @Override // c.a.o0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f6618c, this.f6617b, UnitedSchemeUtility.wrapCallbackParams(10005, str).toString(), this.f6621f.f6606e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements c.a.o0.a.i1.d.d.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a2.e f6622a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6623b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6624c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f6625d;

        public d(b bVar, c.a.o0.a.a2.e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
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
            this.f6625d = bVar;
            this.f6622a = eVar;
            this.f6623b = callbackHandler;
            this.f6624c = unitedSchemeEntity;
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
                    c.a.o0.a.e0.d.g("chooseImage", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f6623b, this.f6624c, UnitedSchemeUtility.wrapCallbackParamsWithEncode(c.a.o0.a.i1.d.c.d.m(arrayList, this.f6622a, "Image"), 0).toString(), this.f6625d.f6606e);
                }
                c.a.o0.a.i1.d.c.e.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements c.a.o0.a.i1.d.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a2.e f6626a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.i1.d.d.d f6627b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6628c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6629d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f6630e;

        public e(b bVar, c.a.o0.a.a2.e eVar, c.a.o0.a.i1.d.d.d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
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
            this.f6630e = bVar;
            this.f6626a = eVar;
            this.f6627b = dVar;
            this.f6628c = callbackHandler;
            this.f6629d = unitedSchemeEntity;
        }

        @Override // c.a.o0.a.i1.d.d.b
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                c.a.o0.a.e0.d.g("chooseImage", "capture success");
                ImageModel imageModel = new ImageModel(file.getAbsolutePath());
                imageModel.setSize(file.length());
                c.a.o0.a.i1.d.c.e.i(imageModel);
                Bundle bundle = new Bundle();
                bundle.putString("swanTmpPath", c.a.o0.a.g1.f.V().I().k());
                bundle.putBoolean("compressed", TextUtils.equals(this.f6630e.f6605d, "compressed"));
                bundle.putString("swanAppId", this.f6626a.f4530f);
                bundle.putParcelableArrayList("mediaModels", c.a.o0.a.i1.d.c.e.e());
                c.a.o0.a.i1.d.c.d.h(this.f6626a.x(), bundle, this.f6627b);
            }
        }

        @Override // c.a.o0.a.i1.d.d.b
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                UnitedSchemeUtility.safeCallback(this.f6628c, this.f6629d, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.f6630e.f6606e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements c.a.o0.a.i1.d.d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6631e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6632f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a2.e f6633g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f6634h;

        public f(b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, c.a.o0.a.a2.e eVar) {
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
            this.f6634h = bVar;
            this.f6631e = callbackHandler;
            this.f6632f = unitedSchemeEntity;
            this.f6633g = eVar;
        }

        @Override // c.a.o0.a.i1.d.d.c
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                c.a.o0.a.e0.d.g("chooseImage", str);
                UnitedSchemeUtility.safeCallback(this.f6631e, this.f6632f, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), this.f6634h.f6606e);
            }
        }

        @Override // c.a.o0.a.i1.d.d.c
        public void f(List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                if (list != null && list.size() > 0) {
                    c.a.o0.a.e0.d.g("chooseImage", "choose success");
                    UnitedSchemeUtility.safeCallback(this.f6631e, this.f6632f, UnitedSchemeUtility.wrapCallbackParamsWithEncode(c.a.o0.a.i1.d.c.d.m(list, this.f6633g, "Image"), 0).toString(), this.f6634h.f6606e);
                    return;
                }
                UnitedSchemeUtility.safeCallback(this.f6631e, this.f6632f, UnitedSchemeUtility.wrapCallbackParams(1002, "choose file list is error").toString(), this.f6634h.f6606e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c.a.o0.a.c2.e eVar) {
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

    @Override // c.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar != null && eVar.x() != null) {
                if (eVar.d0()) {
                    boolean z = a0.f4738b;
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
                    return false;
                }
                JSONObject d2 = w.d(unitedSchemeEntity.getParam("params"));
                String optString = d2.optString("cb");
                this.f6606e = optString;
                if (TextUtils.isEmpty(optString)) {
                    c.a.o0.a.e0.d.b("chooseImage", "empty cb");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                try {
                    int parseInt = Integer.parseInt(d2.optString("count"));
                    this.f6604c = parseInt;
                    if (parseInt < 1 || parseInt > 9) {
                        this.f6604c = 9;
                    }
                } catch (NumberFormatException unused) {
                    c.a.o0.a.e0.d.b("chooseImage", "count format error");
                    this.f6604c = 9;
                }
                this.f6605d = r(d2.optJSONArray("sizeType"));
                JSONArray optJSONArray = d2.optJSONArray("sourceType");
                String s = s(optJSONArray);
                c.a.o0.a.e0.d.g("chooseImage", "sizeType: " + this.f6605d + ",sourceType: " + s);
                if (TextUtils.equals(s, "album")) {
                    u(context, unitedSchemeEntity, callbackHandler, eVar, w(optJSONArray));
                } else {
                    eVar.T().g(eVar.x(), PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, eVar));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            c.a.o0.a.e0.d.b("chooseImage", "illegal swanApp");
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

    public final void t(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, unitedSchemeEntity, callbackHandler, eVar) == null) {
            c.a.o0.a.i1.d.c.b.f(eVar.x(), eVar.f4530f, new e(this, eVar, new d(this, eVar, callbackHandler, unitedSchemeEntity), callbackHandler, unitedSchemeEntity));
        }
    }

    public final void u(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, Boolean.valueOf(z)}) == null) {
            c.a.o0.a.s1.e.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new c(this, context, unitedSchemeEntity, callbackHandler, eVar, z));
        }
    }

    public final void v(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, context, unitedSchemeEntity, callbackHandler, eVar) == null) {
            c.a.o0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new C0258b(this, unitedSchemeEntity, callbackHandler, eVar));
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

    public final void x(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, Boolean.valueOf(z)}) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("launchType", "Image");
            bundle.putBoolean("isShowCamera", z);
            bundle.putInt("count", this.f6604c);
            bundle.putString("mode", "single");
            bundle.putBoolean("compressed", TextUtils.equals(this.f6605d, "compressed"));
            bundle.putString("swanAppId", eVar.f4530f);
            bundle.putString("swanTmpPath", c.a.o0.a.g1.f.V().I().k());
            c.a.o0.a.i1.d.c.d.l(context, bundle, new f(this, callbackHandler, unitedSchemeEntity, eVar));
        }
    }
}
