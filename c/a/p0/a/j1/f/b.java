package c.a.p0.a.j1.f;

import android.text.TextUtils;
import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f6587c;

    /* renamed from: d  reason: collision with root package name */
    public static String f6588d;

    /* renamed from: e  reason: collision with root package name */
    public static String f6589e;

    /* renamed from: f  reason: collision with root package name */
    public static String f6590f;

    /* renamed from: g  reason: collision with root package name */
    public static String f6591g;

    /* renamed from: h  reason: collision with root package name */
    public static String f6592h;

    /* renamed from: i  reason: collision with root package name */
    public static String f6593i;

    /* renamed from: j  reason: collision with root package name */
    public static String f6594j;
    public transient /* synthetic */ FieldHolder $fh;
    public CallbackHandler a;

    /* renamed from: b  reason: collision with root package name */
    public UnitedSchemeEntity f6595b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1404491885, "Lc/a/p0/a/j1/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1404491885, "Lc/a/p0/a/j1/f/b;");
                return;
            }
        }
        f6587c = k.a;
    }

    public b(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callbackHandler, unitedSchemeEntity, str, str2, str3, str4, str5, str6, str7};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = callbackHandler;
        this.f6595b = unitedSchemeEntity;
        f6588d = str;
        f6589e = str2;
        f6590f = str3;
        f6591g = str4;
        f6592h = str5;
        f6593i = str6;
        f6594j = str7;
    }

    public static b a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, b bVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, callbackHandler, unitedSchemeEntity, str, bVar)) == null) {
            if (str == null) {
                return bVar;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("onStart");
                String optString2 = jSONObject.optString(MissionEvent.MESSAGE_PAUSE);
                String optString3 = jSONObject.optString("onResume");
                String optString4 = jSONObject.optString(MissionEvent.MESSAGE_STOP);
                String optString5 = jSONObject.optString("onError");
                String optString6 = jSONObject.optString("onInterruptionBegin");
                String optString7 = jSONObject.optString("onInterruptionEnd");
                if (callbackHandler != null && unitedSchemeEntity != null && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5)) {
                    return new b(callbackHandler, unitedSchemeEntity, optString, optString2, optString3, optString4, optString5, optString6, optString7);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return bVar;
        }
        return (b) invokeLLLL.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            c(str, null);
        }
    }

    public void c(String str, JSONObject jSONObject) {
        JSONObject wrapCallbackParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        UnitedSchemeUtility.safeCallback(this.a, this.f6595b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
        if (f6587c) {
            String str2 = "Audio callback type is : " + str + " , data is : " + wrapCallbackParams.toString();
        }
    }

    public void d(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("errCode", Integer.valueOf(i2));
            jSONObject.putOpt("errMsg", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        c(f6592h, jSONObject);
    }
}
