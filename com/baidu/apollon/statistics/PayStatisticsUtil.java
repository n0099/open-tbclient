package com.baidu.apollon.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.statistics.StatService;
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
/* loaded from: classes.dex */
public final class PayStatisticsUtil {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static Context f3945d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public StatisticsSettings f3946a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3947b;

    /* renamed from: c  reason: collision with root package name */
    public SyncHttpImpl f3948c;

    /* renamed from: com.baidu.apollon.statistics.PayStatisticsUtil$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class CallerId {
        public static final /* synthetic */ CallerId[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CallerId BaiduWallet;
        public static final CallerId Host;
        public static final CallerId Passport;
        public transient /* synthetic */ FieldHolder $fh;
        public int id;
        public String version;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1272065936, "Lcom/baidu/apollon/statistics/PayStatisticsUtil$CallerId;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1272065936, "Lcom/baidu/apollon/statistics/PayStatisticsUtil$CallerId;");
                    return;
                }
            }
            Passport = new CallerId("Passport", 0, 1);
            BaiduWallet = new CallerId("BaiduWallet", 1, 2);
            CallerId callerId = new CallerId("Host", 2, 3);
            Host = callerId;
            $VALUES = new CallerId[]{Passport, BaiduWallet, callerId};
        }

        public CallerId(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.id = i3;
        }

        public static CallerId valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CallerId) Enum.valueOf(CallerId.class, str) : (CallerId) invokeL.objValue;
        }

        public static CallerId[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CallerId[]) $VALUES.clone() : (CallerId[]) invokeV.objValue;
        }

        public int getId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.id : invokeV.intValue;
        }

        public String getVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.version : (String) invokeV.objValue;
        }

        public void setVersion(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.version = str;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static PayStatisticsUtil f3949a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-16642145, "Lcom/baidu/apollon/statistics/PayStatisticsUtil$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-16642145, "Lcom/baidu/apollon/statistics/PayStatisticsUtil$a;");
                    return;
                }
            }
            f3949a = new PayStatisticsUtil(null);
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

    public /* synthetic */ PayStatisticsUtil(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static Context c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f3945d : (Context) invokeV.objValue;
    }

    private boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) {
            if (f3945d == null) {
                return true;
            }
            StatisticsSettings statisticsSettings = this.f3946a;
            if (statisticsSettings != null) {
                return !statisticsSettings.isEnabled();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static PayStatisticsUtil getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? a.f3949a : (PayStatisticsUtil) invokeV.objValue;
    }

    public static void initData(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context) == null) {
            a(context);
            d.a().b();
        }
    }

    public static void initStatisticsModule(Context context, StatisticsSettings statisticsSettings) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, statisticsSettings) == null) {
            getInstance();
            if (!a(context) || statisticsSettings == null) {
                return;
            }
            PayStatisticsUtil payStatisticsUtil = getInstance();
            payStatisticsUtil.f3946a = statisticsSettings;
            try {
                if (payStatisticsUtil.f3947b) {
                    return;
                }
                payStatisticsUtil.f3947b = true;
                d.a().b();
            } catch (Exception unused) {
            }
        }
    }

    public static void onBack(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, str) == null) || getInstance().d()) {
            return;
        }
        try {
            StatService.a(str, StatService.ETag.back, (Collection<String>) null);
        } catch (Exception unused) {
        }
    }

    public static void onEvent(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, str) == null) || getInstance().d()) {
            return;
        }
        onEventWithValues(str, null, null);
    }

    public static void onEventEnd(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65547, null, str, i2) == null) {
            onEventEndWithValue(str, i2, null, null);
        }
    }

    public static void onEventEndWithValue(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65549, null, str, i2, str2) == null) {
            onEventEndWithValue(str, i2, str2, null);
        }
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65551, null, str, i2, collection) == null) {
            onEventEndWithValues(str, i2, collection, null);
        }
    }

    public static void onEventStart(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65553, null, str) == null) || getInstance().d() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.a(str);
        } catch (Exception unused) {
        }
    }

    public static void onEventWithValue(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, str, str2) == null) {
            onEventWithValue(str, str2, null);
        }
    }

    public static void onEventWithValues(String str, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, str, collection) == null) {
            onEventWithValues(str, collection, null);
        }
    }

    public static void onIn(String str, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65558, null, str, j) == null) || getInstance().d()) {
            return;
        }
        try {
            if (0 < j) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.toString(j));
                StatService.a(str, StatService.ETag.in, arrayList);
            } else {
                StatService.a(str, StatService.ETag.in, (Collection<String>) null);
            }
        } catch (Exception unused) {
        }
    }

    public static void onOut(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65559, null, str) == null) || getInstance().d()) {
            return;
        }
        try {
            StatService.a(str, StatService.ETag.out, (Collection<String>) null);
        } catch (Exception unused) {
        }
    }

    public static void onPush(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65560, null, str) == null) || getInstance().d()) {
            return;
        }
        try {
            StatService.a(str, StatService.ETag.push, (Collection<String>) null);
        } catch (Exception unused) {
        }
    }

    public static void setHttpImpl(SyncHttpImpl syncHttpImpl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, syncHttpImpl) == null) {
            getInstance().f3948c = syncHttpImpl;
        }
    }

    public StatisticsSettings a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f3946a : (StatisticsSettings) invokeV.objValue;
    }

    public SyncHttpImpl b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f3948c : (SyncHttpImpl) invokeV.objValue;
    }

    public PayStatisticsUtil() {
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

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f3945d == null && context != null) {
                f3945d = context.getApplicationContext();
            }
            return f3945d != null;
        }
        return invokeL.booleanValue;
    }

    public static void onEventEnd(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65548, null, str, i2, str2) == null) {
            onEventEndWithValue(str, i2, null, str2);
        }
    }

    public static void onEventEndWithValue(String str, int i2, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(65550, null, str, i2, str2, str3) == null) || getInstance().d() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.a(str, Integer.toString(i2), str2, str3);
        } catch (Exception unused) {
        }
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(65552, null, str, i2, collection, str2) == null) || getInstance().d() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.b(str, Integer.toString(i2), collection, str2);
        } catch (Exception unused) {
        }
    }

    public static void onEventWithValue(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65555, null, str, str2, str3) == null) || getInstance().d() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            StatService.a(str, str2, str3);
        } catch (Exception unused) {
        }
    }

    public static void onEventWithValues(String str, Collection<String> collection, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65557, null, str, collection, str2) == null) || getInstance().d()) {
            return;
        }
        try {
            StatService.a(str, (String) null, collection, str2);
        } catch (Exception unused) {
        }
    }

    public static void onEvent(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) || getInstance().d()) {
            return;
        }
        onEventWithValues(str, null, str2);
    }
}
