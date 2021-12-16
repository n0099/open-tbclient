package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.f2.e;
import c.a.q0.a.f2.f.z;
import c.a.q0.a.h2.c.d;
import c.a.q0.a.h2.c.i;
import c.a.q0.a.h2.c.j.b;
import c.a.q0.a.z2.g1.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class SwanAppDownloadAction extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes11.dex */
    public static final class SwanAppDownloadType {
        public static final /* synthetic */ SwanAppDownloadType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SwanAppDownloadType TYPE_CANCEL_DOWNLOAD;
        public static final SwanAppDownloadType TYPE_INSTALL_APP;
        public static final SwanAppDownloadType TYPE_OTHER;
        public static final SwanAppDownloadType TYPE_PAUSE_DOWNLOAD;
        public static final SwanAppDownloadType TYPE_QUERY_STATUS;
        public static final SwanAppDownloadType TYPE_RESUME_DOWNLOAD;
        public static final SwanAppDownloadType TYPE_START_DOWNLOAD;
        public static final SwanAppDownloadType TYPE_STOP_SERVICE;
        public transient /* synthetic */ FieldHolder $fh;
        public String typeName;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1882222322, "Lcom/baidu/swan/apps/scheme/actions/SwanAppDownloadAction$SwanAppDownloadType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1882222322, "Lcom/baidu/swan/apps/scheme/actions/SwanAppDownloadAction$SwanAppDownloadType;");
                    return;
                }
            }
            TYPE_QUERY_STATUS = new SwanAppDownloadType("TYPE_QUERY_STATUS", 0, "queryStatus");
            TYPE_START_DOWNLOAD = new SwanAppDownloadType("TYPE_START_DOWNLOAD", 1, "startDownload");
            TYPE_PAUSE_DOWNLOAD = new SwanAppDownloadType("TYPE_PAUSE_DOWNLOAD", 2, "pauseDownload");
            TYPE_CANCEL_DOWNLOAD = new SwanAppDownloadType("TYPE_CANCEL_DOWNLOAD", 3, "cancelDownload");
            TYPE_RESUME_DOWNLOAD = new SwanAppDownloadType("TYPE_RESUME_DOWNLOAD", 4, "resumeDownload");
            TYPE_INSTALL_APP = new SwanAppDownloadType("TYPE_INSTALL_APP", 5, "installApp");
            TYPE_STOP_SERVICE = new SwanAppDownloadType("TYPE_STOP_SERVICE", 6, "stopService");
            SwanAppDownloadType swanAppDownloadType = new SwanAppDownloadType("TYPE_OTHER", 7, "#");
            TYPE_OTHER = swanAppDownloadType;
            $VALUES = new SwanAppDownloadType[]{TYPE_QUERY_STATUS, TYPE_START_DOWNLOAD, TYPE_PAUSE_DOWNLOAD, TYPE_CANCEL_DOWNLOAD, TYPE_RESUME_DOWNLOAD, TYPE_INSTALL_APP, TYPE_STOP_SERVICE, swanAppDownloadType};
        }

        public SwanAppDownloadType(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.typeName = str2;
        }

        public static SwanAppDownloadType find(@Nullable String str) {
            InterceptResult invokeL;
            SwanAppDownloadType[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                for (SwanAppDownloadType swanAppDownloadType : values()) {
                    if (swanAppDownloadType.typeName.equals(str)) {
                        return swanAppDownloadType;
                    }
                }
                return TYPE_OTHER;
            }
            return (SwanAppDownloadType) invokeL.objValue;
        }

        public static SwanAppDownloadType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (SwanAppDownloadType) Enum.valueOf(SwanAppDownloadType.class, str) : (SwanAppDownloadType) invokeL.objValue;
        }

        public static SwanAppDownloadType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (SwanAppDownloadType[]) $VALUES.clone() : (SwanAppDownloadType[]) invokeV.objValue;
        }

        public String getTypeName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.typeName : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public class a implements c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f40599e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f40600f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f40601g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f40602h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ SwanAppDownloadType f40603i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ SwanAppDownloadAction f40604j;

        public a(SwanAppDownloadAction swanAppDownloadAction, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, JSONObject jSONObject, SwanAppDownloadType swanAppDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppDownloadAction, callbackHandler, unitedSchemeEntity, context, jSONObject, swanAppDownloadType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40604j = swanAppDownloadAction;
            this.f40599e = callbackHandler;
            this.f40600f = unitedSchemeEntity;
            this.f40601g = context;
            this.f40602h = jSONObject;
            this.f40603i = swanAppDownloadType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.h(iVar)) {
                    if (this.f40604j.k(this.f40601g, this.f40600f, this.f40599e, this.f40602h, this.f40603i)) {
                        return;
                    }
                    UnitedSchemeUtility.callCallback(this.f40599e, this.f40600f, UnitedSchemeUtility.wrapCallbackParams(1001));
                    return;
                }
                d.p(iVar, this.f40599e, this.f40600f);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwanAppDownloadAction(e eVar) {
        this(eVar, "/swanAPI/installApp");
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
                this((e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.q0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.q0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject a2 = z.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal parameter");
                c.a.q0.a.e0.d.i("SwanAppDownloadAction", "params parse error");
                return false;
            }
            String optString = a2.optString("type");
            SwanAppDownloadType find = SwanAppDownloadType.find(optString);
            if (find == SwanAppDownloadType.TYPE_OTHER) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "parameters empty");
                c.a.q0.a.e0.d.i("SwanAppDownloadAction", "type error:" + optString);
                return true;
            } else if (!l(unitedSchemeEntity, eVar)) {
                k(context, unitedSchemeEntity, callbackHandler, a2, find);
                return true;
            } else {
                if (eVar != null) {
                    eVar.d0().g(context, "mapp_i_app_download", new a(this, callbackHandler, unitedSchemeEntity, context, a2, find));
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
                } else {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "SwanApp is Null");
                }
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean k(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject, SwanAppDownloadType swanAppDownloadType) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, jSONObject, swanAppDownloadType)) == null) {
            boolean e2 = c.a.q0.a.c1.a.d().e(context, unitedSchemeEntity, swanAppDownloadType, jSONObject, callbackHandler);
            if (e2) {
                JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(0, "success");
                unitedSchemeEntity.result = wrapCallbackParams;
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, wrapCallbackParams);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "parameters error");
            }
            return e2;
        }
        return invokeLLLLL.booleanValue;
    }

    public boolean l(@NonNull UnitedSchemeEntity unitedSchemeEntity, @Nullable c.a.q0.a.d2.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity, eVar)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppDownloadAction(e eVar, String str) {
        super(eVar, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
