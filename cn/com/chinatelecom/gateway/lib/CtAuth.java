package cn.com.chinatelecom.gateway.lib;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import cn.com.chinatelecom.gateway.lib.b.a;
import cn.com.chinatelecom.gateway.lib.b.d;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class CtAuth {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "CtAuth";
    public static int mConnTimeoutL;
    public static int mReadTimeout;
    public static int mTotalTimeout;
    public static TraceLogger mTraceLogger;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1354863452, "Lcn/com/chinatelecom/gateway/lib/CtAuth;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1354863452, "Lcn/com/chinatelecom/gateway/lib/CtAuth;");
        }
    }

    public CtAuth() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, PreCodeListener preCodeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65538, null, context, str, str2, str3, preCodeListener) == null) {
            if (preCodeListener == null) {
                mTraceLogger = null;
            } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                preCodeListener.onResult("{\"result\":80106,\"msg\":\"请求参数异常\"}");
                mTraceLogger = null;
            } else if (!a.c(context)) {
                preCodeListener.onResult("{\"result\":80003,\"msg\":\"网络无连接\"}");
                mTraceLogger = null;
            } else if (a.d(context)) {
                new cn.com.chinatelecom.gateway.lib.c.a().a(context, str, str2, str3, preCodeListener);
            } else if (a.e(context)) {
                new cn.com.chinatelecom.gateway.lib.c.a().b(context, str, str2, str3, preCodeListener);
            } else {
                preCodeListener.onResult("{\"result\":80004,\"msg\":\"移动网络未开启\"}");
                mTraceLogger = null;
            }
        }
    }

    public static void info(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) || mTraceLogger == null) {
            return;
        }
        try {
            mTraceLogger.info("CT_" + str, str2);
        } catch (Throwable unused) {
        }
    }

    public static void init(int i, int i2, int i3, TraceLogger traceLogger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), traceLogger}) == null) {
            mConnTimeoutL = i;
            mReadTimeout = i2;
            mTotalTimeout = i3;
            mTraceLogger = traceLogger;
        }
    }

    public static void postResult(Context context, String str, String str2, PreCodeListener preCodeListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65541, null, context, str, str2, preCodeListener) == null) || preCodeListener == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("reqId", str2);
            preCodeListener.onResult(jSONObject.toString());
            String str3 = a;
            info(str3, "callback result : " + jSONObject.toString());
        } catch (Exception unused) {
            preCodeListener.onResult(str);
            String str4 = a;
            info(str4, "Exception callback result : " + str);
        }
        mTraceLogger = null;
        d.a(context, str2);
    }

    public static void requestPreAuth(Context context, String str, String str2, PreCodeListener preCodeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, null, context, str, str2, preCodeListener) == null) {
            String str3 = a;
            info(str3, "called requestPreAuth()   appId：" + str + ",appSecret:" + str2);
            a(context, str, str2, "mhqh", preCodeListener);
        }
    }

    public static void requestPreAuthCode(Context context, String str, String str2, PreCodeListener preCodeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65543, null, context, str, str2, preCodeListener) == null) {
            String str3 = a;
            info(str3, "called requestPreAuthCode()   appId：" + str + ",appSecret:" + str2);
            a(context, str, str2, "qhx", preCodeListener);
        }
    }

    public static void warn(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65544, null, str, str2, th) == null) || mTraceLogger == null) {
            return;
        }
        try {
            mTraceLogger.warn("CT_" + str, str2, th);
        } catch (Throwable unused) {
        }
    }
}
