package com.baidu.fsg.base.statistics;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.fsg.base.statistics.StatService;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.base.utils.ResUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
/* loaded from: classes5.dex */
public final class RimStatisticsUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "logsender";
    public static boolean mInited;
    public static Context sAppContext;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasInit;
    public k mHttpImpl;

    /* renamed from: com.baidu.fsg.base.statistics.RimStatisticsUtil$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static RimStatisticsUtil f39243a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-258752044, "Lcom/baidu/fsg/base/statistics/RimStatisticsUtil$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-258752044, "Lcom/baidu/fsg/base/statistics/RimStatisticsUtil$a;");
                    return;
                }
            }
            f39243a = new RimStatisticsUtil(null);
        }

        public a() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-103062415, "Lcom/baidu/fsg/base/statistics/RimStatisticsUtil;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-103062415, "Lcom/baidu/fsg/base/statistics/RimStatisticsUtil;");
        }
    }

    public RimStatisticsUtil() {
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

    public /* synthetic */ RimStatisticsUtil(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static boolean cacheAppContext(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (sAppContext == null && context != null) {
                sAppContext = context;
            }
            return sAppContext != null;
        }
        return invokeL.booleanValue;
    }

    public static Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? sAppContext : (Context) invokeV.objValue;
    }

    public static RimStatisticsUtil getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? a.f39243a : (RimStatisticsUtil) invokeV.objValue;
    }

    private String getSignKey1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) ? com.baidu.fsg.base.a.f39084h : (String) invokeV.objValue;
    }

    private String getSignKey2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? ResUtils.getString(sAppContext, "rim_base_asdasdasd_assdadsads") : (String) invokeV.objValue;
    }

    private String getSignKey3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) ? "G4Ytg9bd7jt7sJG9sGf" : (String) invokeV.objValue;
    }

    public static boolean initData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (mInited) {
                return false;
            }
            mInited = true;
            e.a().b();
            return true;
        }
        return invokeV.booleanValue;
    }

    public static void initStatisticsModule(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, context) == null) && cacheAppContext(context)) {
            RimStatisticsUtil rimStatisticsUtil = getInstance();
            try {
                if (rimStatisticsUtil.hasInit) {
                    return;
                }
                rimStatisticsUtil.hasInit = true;
                d.a().a(context);
                initData();
            } catch (Exception unused) {
            }
        }
    }

    public static void onBack(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            try {
                StatService.a(str, StatService.ETag.back, (Collection<String>) null);
            } catch (Exception unused) {
            }
        }
    }

    public static void onEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, str) == null) {
            onEventWithValues(str, null);
        }
    }

    public static void onEventEnd(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65549, null, str, i2) == null) {
            onEventEndWithValue(str, i2, null);
        }
    }

    public static void onEventEndWithValue(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65550, null, str, i2, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.b(str, Integer.toString(i2), str2);
        } catch (Exception unused) {
        }
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65551, null, str, i2, collection) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.b(str, Integer.toString(i2), collection);
        } catch (Exception unused) {
        }
    }

    public static void onEventStart(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.a(str);
        } catch (Exception unused) {
        }
    }

    public static void onEventWithValue(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65553, null, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.a(str, (String) null, str2);
        } catch (Exception unused) {
        }
    }

    public static void onEventWithValues(String str, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, str, collection) == null) {
            try {
                StatService.a(str, (String) null, collection);
            } catch (Exception e2) {
                e2.printStackTrace();
                LogUtil.d("logsender", e2.toString());
            }
        }
    }

    public static void onIn(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65555, null, str, j2) == null) {
            try {
                if (0 < j2) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Long.toString(j2));
                    StatService.a(str, StatService.ETag.in, arrayList);
                } else {
                    StatService.a(str, StatService.ETag.in, (Collection<String>) null);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void onOut(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, str) == null) {
            try {
                StatService.a(str, StatService.ETag.out, (Collection<String>) null);
            } catch (Exception unused) {
            }
        }
    }

    public static void onPush(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, str) == null) {
            try {
                StatService.a(str, StatService.ETag.push, (Collection<String>) null);
            } catch (Exception unused) {
            }
        }
    }

    public String getSignKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(getSignKey1());
            stringBuffer.append(getSignKey2());
            stringBuffer.append(getSignKey3());
            return RimArmor.getInstance().localDecryptProxy(stringBuffer.toString());
        }
        return (String) invokeV.objValue;
    }

    public boolean isReleaseVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void triggerSending() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LogUtil.d("logsender", "=====triggerSending====");
            i.a().a("normal_log");
            i.a().a(b.o);
        }
    }
}
