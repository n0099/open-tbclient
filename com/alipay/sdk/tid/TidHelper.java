package com.alipay.sdk.tid;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.packet.impl.c;
import com.alipay.sdk.sys.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class TidHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TidHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, context) == null) || context == null) {
            return;
        }
        b.d().a(context);
    }

    public static Tid b(Context context) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                com.alipay.sdk.packet.b a = new c().a(com.alipay.sdk.sys.a.e(), context);
                if (a != null) {
                    JSONObject jSONObject = new JSONObject(a.a());
                    a a2 = a.a(context);
                    String optString = jSONObject.optString("tid");
                    String string = jSONObject.getString(a.f31911j);
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(string)) {
                        a2.a(optString, string);
                    }
                    return a(context, a2);
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        return (Tid) invokeL.objValue;
    }

    public static void clearTID(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            a.a(context).a();
        }
    }

    public static String getIMEI(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            a(context);
            return com.alipay.sdk.util.a.b(context).b();
        }
        return (String) invokeL.objValue;
    }

    public static String getIMSI(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            a(context);
            return com.alipay.sdk.util.a.b(context).c();
        }
        return (String) invokeL.objValue;
    }

    public static synchronized String getTIDValue(Context context) {
        InterceptResult invokeL;
        String tid;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            synchronized (TidHelper.class) {
                Tid loadOrCreateTID = loadOrCreateTID(context);
                tid = Tid.isEmpty(loadOrCreateTID) ? "" : loadOrCreateTID.getTid();
            }
            return tid;
        }
        return (String) invokeL.objValue;
    }

    public static String getVirtualImei(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            a(context);
            com.alipay.sdk.data.b.b();
            return com.alipay.sdk.data.b.f();
        }
        return (String) invokeL.objValue;
    }

    public static String getVirtualImsi(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            a(context);
            com.alipay.sdk.data.b.b();
            return com.alipay.sdk.data.b.g();
        }
        return (String) invokeL.objValue;
    }

    public static Tid loadLocalTid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            a a = a.a(context);
            if (a.h()) {
                return null;
            }
            return new Tid(a.d(), a.c(), a.e().longValue());
        }
        return (Tid) invokeL.objValue;
    }

    public static synchronized Tid loadOrCreateTID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            synchronized (TidHelper.class) {
                com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "load_create_tid");
                a(context);
                Tid loadTID = loadTID(context);
                if (Tid.isEmpty(loadTID)) {
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        return null;
                    }
                    try {
                        loadTID = b(context);
                    } catch (Throwable unused) {
                    }
                }
                return loadTID;
            }
        }
        return (Tid) invokeL.objValue;
    }

    public static Tid loadTID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            a(context);
            Tid a = a(context, a.a(context));
            if (a == null) {
                com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "load_tid null");
            }
            return a;
        }
        return (Tid) invokeL.objValue;
    }

    public static boolean resetTID(Context context) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            com.alipay.sdk.util.c.b(com.alipay.sdk.cons.a.x, "reset_tid");
            if (Looper.myLooper() != Looper.getMainLooper()) {
                a(context);
                clearTID(context);
                Tid tid = null;
                try {
                    tid = b(context);
                } catch (Throwable unused) {
                }
                return !Tid.isEmpty(tid);
            }
            throw new Exception("Must be called on worker thread");
        }
        return invokeL.booleanValue;
    }

    public static Tid a(Context context, a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, aVar)) == null) {
            if (aVar == null || aVar.i()) {
                return null;
            }
            return new Tid(aVar.d(), aVar.c(), aVar.e().longValue());
        }
        return (Tid) invokeLL.objValue;
    }
}
