package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.fi3;
import com.baidu.tieba.j43;
import com.baidu.tieba.j53;
import com.baidu.tieba.k83;
import com.baidu.tieba.m02;
import com.baidu.tieba.m33;
import com.baidu.tieba.p83;
import com.baidu.tieba.tm2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SwanAppDownloadAction extends j53 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public boolean l(UnitedSchemeEntity unitedSchemeEntity, m33 m33Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity, m33Var)) == null) {
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public final class SwanAppDownloadType {
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

        public SwanAppDownloadType(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

        public static SwanAppDownloadType find(String str) {
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                return (SwanAppDownloadType) Enum.valueOf(SwanAppDownloadType.class, str);
            }
            return (SwanAppDownloadType) invokeL.objValue;
        }

        public static SwanAppDownloadType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                return (SwanAppDownloadType[]) $VALUES.clone();
            }
            return (SwanAppDownloadType[]) invokeV.objValue;
        }

        public String getTypeName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.typeName;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ SwanAppDownloadType e;
        public final /* synthetic */ SwanAppDownloadAction f;

        public a(SwanAppDownloadAction swanAppDownloadAction, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, JSONObject jSONObject, SwanAppDownloadType swanAppDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppDownloadAction, callbackHandler, unitedSchemeEntity, context, jSONObject, swanAppDownloadType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = swanAppDownloadAction;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = context;
            this.d = jSONObject;
            this.e = swanAppDownloadType;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(p83 p83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p83Var) == null) {
                if (!k83.h(p83Var)) {
                    k83.p(p83Var, this.a, this.b);
                } else if (!this.f.k(this.c, this.b, this.a, this.d, this.e)) {
                    UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(1001));
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwanAppDownloadAction(j43 j43Var) {
        this(j43Var, "/swanAPI/installApp");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j43Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((j43) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppDownloadAction(j43 j43Var, String str) {
        super(j43Var, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j43Var, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.j53
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, m33 m33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, m33Var)) == null) {
            JSONObject a2 = j53.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal parameter");
                m02.i("SwanAppDownloadAction", "params parse error");
                return false;
            }
            String optString = a2.optString("type");
            SwanAppDownloadType find = SwanAppDownloadType.find(optString);
            if (find == SwanAppDownloadType.TYPE_OTHER) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "parameters empty");
                m02.i("SwanAppDownloadAction", "type error:" + optString);
                return true;
            } else if (!l(unitedSchemeEntity, m33Var)) {
                k(context, unitedSchemeEntity, callbackHandler, a2, find);
                return true;
            } else {
                if (m33Var != null) {
                    m33Var.e0().g(context, "mapp_i_app_download", new a(this, callbackHandler, unitedSchemeEntity, context, a2, find));
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
            boolean e = tm2.d().e(context, unitedSchemeEntity, swanAppDownloadType, jSONObject, callbackHandler);
            if (e) {
                JSONObject wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(0, "success");
                unitedSchemeEntity.result = wrapCallbackParams;
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, wrapCallbackParams);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "parameters error");
            }
            return e;
        }
        return invokeLLLLL.booleanValue;
    }
}
