package com.alipay.sdk.tid;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.data.c;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
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
        com.alipay.sdk.sys.b.a().a(context, c.b());
    }

    public static Tid b(Context context) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                com.alipay.sdk.packet.b a2 = new com.alipay.sdk.packet.impl.c().a(context);
                if (a2 != null) {
                    JSONObject jSONObject = new JSONObject(a2.b());
                    b a3 = b.a(context);
                    String optString = jSONObject.optString("tid");
                    String string = jSONObject.getString(b.f1980e);
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(string)) {
                        a3.a(optString, string);
                    }
                    return a(context, a3);
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
            b.a(context).g();
        }
    }

    public static String getIMEI(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            a(context);
            return com.alipay.sdk.util.a.a(context).b();
        }
        return (String) invokeL.objValue;
    }

    public static String getIMSI(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            a(context);
            return com.alipay.sdk.util.a.a(context).a();
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
            return c.b().c();
        }
        return (String) invokeL.objValue;
    }

    public static String getVirtualImsi(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            a(context);
            return c.b().d();
        }
        return (String) invokeL.objValue;
    }

    public static Tid loadLocalTid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            b a2 = b.a(context);
            if (a2.h()) {
                return null;
            }
            return new Tid(a2.a(), a2.b(), a2.i().longValue());
        }
        return (Tid) invokeL.objValue;
    }

    public static synchronized Tid loadOrCreateTID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            synchronized (TidHelper.class) {
                com.alipay.sdk.util.c.b("TidHelper", "TidHelper.loadOrCreateTID");
                if (context == null) {
                    com.alipay.sdk.app.statistic.a.a(context, "tid", com.alipay.sdk.app.statistic.c.aa, "");
                }
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
            Tid a2 = a(context, b.a(context));
            if (a2 == null) {
                com.alipay.sdk.util.c.b("TidHelper.loadTID", "TidHelper:::loadTID > null");
            } else {
                com.alipay.sdk.util.c.b("TidHelper.loadTID", "TidHelper:::loadTID > " + a2.toString());
            }
            return a2;
        }
        return (Tid) invokeL.objValue;
    }

    public static boolean resetTID(Context context) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            com.alipay.sdk.util.c.b("TidHelper.resetTID", "resetTID");
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
            throw new Exception("不能在主线程中调用此方法");
        }
        return invokeL.booleanValue;
    }

    public static Tid a(Context context, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, bVar)) == null) {
            if (bVar == null || bVar.e()) {
                return null;
            }
            return new Tid(bVar.a(), bVar.b(), bVar.i().longValue());
        }
        return (Tid) invokeLL.objValue;
    }
}
