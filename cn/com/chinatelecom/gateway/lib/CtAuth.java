package cn.com.chinatelecom.gateway.lib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import cn.com.chinatelecom.gateway.lib.b.e;
import cn.com.chinatelecom.gateway.lib.c.a;
import cn.com.chinatelecom.gateway.lib.c.f;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class CtAuth {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "CtAuth";
    public static int mConnTimeoutL;
    public static Handler mHandler;
    public static int mReadTimeout;
    public static int mTotalTimeout;
    public static TraceLogger mTraceLogger;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1354863452, "Lcn/com/chinatelecom/gateway/lib/CtAuth;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1354863452, "Lcn/com/chinatelecom/gateway/lib/CtAuth;");
                return;
            }
        }
        mHandler = new Handler(Looper.getMainLooper());
        mTotalTimeout = 0;
        mConnTimeoutL = 0;
        mReadTimeout = 0;
    }

    public CtAuth() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, PreCodeListener preCodeListener) {
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65539, null, context, str, str2, str3, preCodeListener) == null) {
            if (preCodeListener == null) {
                mTraceLogger = null;
                return;
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                str4 = "{\"result\":80106,\"msg\":\"请求参数异常\"}";
            } else if (f.b(context)) {
                if (f.c(context)) {
                    new a().a(context, str, str2, str3, preCodeListener);
                    return;
                } else if (f.d(context)) {
                    new a().b(context, str, str2, str3, preCodeListener);
                    return;
                } else {
                    preCodeListener.onResult("{\"result\":80004,\"msg\":\"移动网络未开启\"}");
                    mTraceLogger = null;
                    return;
                }
            } else {
                str4 = "{\"result\":80003,\"msg\":\"网络无连接\"}";
            }
            preCodeListener.onResult(str4);
            mTraceLogger = null;
        }
    }

    public static void info(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) || mTraceLogger == null) {
            return;
        }
        try {
            mTraceLogger.info("CT_" + str, str2);
        } catch (Throwable unused) {
        }
    }

    public static void init(int i2, int i3, int i4, TraceLogger traceLogger) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), traceLogger}) == null) {
            mConnTimeoutL = i2;
            mReadTimeout = i3;
            mTotalTimeout = i4;
            mTraceLogger = traceLogger;
        }
    }

    public static void postResultOnMainThread(Context context, String str, String str2, PreCodeListener preCodeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, null, context, str, str2, preCodeListener) == null) {
            mHandler.post(new Runnable(preCodeListener, str, str2, context) { // from class: cn.com.chinatelecom.gateway.lib.CtAuth.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PreCodeListener a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f30570b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f30571c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ Context f30572d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {preCodeListener, str, str2, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = preCodeListener;
                    this.f30570b = str;
                    this.f30571c = str2;
                    this.f30572d = context;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a == null) {
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(this.f30570b);
                        jSONObject.put("reqId", this.f30571c);
                        this.a.onResult(jSONObject.toString());
                        String str3 = CtAuth.a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("callback result : ");
                        sb.append(jSONObject.toString());
                        CtAuth.info(str3, sb.toString());
                    } catch (Exception unused) {
                        this.a.onResult(this.f30570b);
                        String str4 = CtAuth.a;
                        CtAuth.info(str4, "Exception callback result : " + this.f30570b);
                    }
                    CtAuth.mTraceLogger = null;
                    e.a(this.f30572d, this.f30571c);
                }
            });
        }
    }

    public static void requestPreAuth(Context context, String str, String str2, PreCodeListener preCodeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65543, null, context, str, str2, preCodeListener) == null) {
            String str3 = a;
            info(str3, "called requestPreAuth()   appId：" + str + ",appSecret:" + str2);
            a(context, str, str2, "mhqh", preCodeListener);
        }
    }

    public static void requestPreAuthCode(Context context, String str, String str2, PreCodeListener preCodeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65544, null, context, str, str2, preCodeListener) == null) {
            String str3 = a;
            info(str3, "called requestPreAuthCode()   appId：" + str + ",appSecret:" + str2);
            a(context, str, str2, "qhx", preCodeListener);
        }
    }

    public static void warn(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65545, null, str, str2, th) == null) || mTraceLogger == null) {
            return;
        }
        try {
            mTraceLogger.warn("CT_" + str, str2, th);
        } catch (Throwable unused) {
        }
    }
}
