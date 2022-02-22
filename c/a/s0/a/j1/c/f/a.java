package c.a.s0.a.j1.c.f;

import android.text.TextUtils;
import c.a.s0.a.j1.c.d;
import c.a.s0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f7564c;
    public transient /* synthetic */ FieldHolder $fh;
    public CallbackHandler a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f7565b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1595544125, "Lc/a/s0/a/j1/c/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1595544125, "Lc/a/s0/a/j1/c/f/a;");
                return;
            }
        }
        f7564c = k.a;
    }

    public a(CallbackHandler callbackHandler, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callbackHandler, jSONObject};
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
        this.f7565b = jSONObject;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            b(str, null);
        }
    }

    public void b(String str, JSONObject jSONObject) {
        JSONObject wrapCallbackParamsWithEncode;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) == null) || this.f7565b == null) {
            return;
        }
        this.a.handleSchemeDispatchCallback(this.f7565b.optString(str), UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
        if (f7564c) {
            String str2 = "Audio callback type is : " + str + " , data is : " + wrapCallbackParamsWithEncode.toString();
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? UnitedSchemeUtility.isInvokedFromSwanGame(this.a) : invokeV.booleanValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                boolean z = f7564c;
                return;
            }
            try {
                this.f7565b = new JSONObject(str);
            } catch (JSONException e2) {
                c.a.s0.a.n2.u.a.b(MediaStreamTrack.AUDIO_TRACK_KIND, 2009, "update json exception", -1, "");
                d.c("AudioStatusCallback", "#setCallbacks error", e2);
            }
        }
    }
}
