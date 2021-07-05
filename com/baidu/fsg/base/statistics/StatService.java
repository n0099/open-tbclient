package com.baidu.fsg.base.statistics;

import android.text.TextUtils;
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
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class StatService {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f5260a = "logsender";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, Long> f5261b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class ETag {
        public static final /* synthetic */ ETag[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ETag back;
        public static final ETag in;
        public static final ETag out;
        public static final ETag push;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(276380594, "Lcom/baidu/fsg/base/statistics/StatService$ETag;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(276380594, "Lcom/baidu/fsg/base/statistics/StatService$ETag;");
                    return;
                }
            }
            in = new ETag("in", 0);
            out = new ETag("out", 1);
            push = new ETag("push", 2);
            ETag eTag = new ETag(com.alipay.sdk.widget.j.j, 3);
            back = eTag;
            $VALUES = new ETag[]{in, out, push, eTag};
        }

        public ETag(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ETag valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ETag) Enum.valueOf(ETag.class, str) : (ETag) invokeL.objValue;
        }

        public static ETag[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ETag[]) $VALUES.clone() : (ETag[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static StatService f5262a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-925272690, "Lcom/baidu/fsg/base/statistics/StatService$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-925272690, "Lcom/baidu/fsg/base/statistics/StatService$a;");
                    return;
                }
            }
            f5262a = new StatService(null);
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

    public /* synthetic */ StatService(q qVar) {
        this();
    }

    public static StatService a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f5262a : (StatService) invokeV.objValue;
    }

    public static void b(String str, String str2, Collection<String> collection) {
        ArrayList<String> a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65547, null, str, str2, collection) == null) || (a2 = a(str, str2)) == null) {
            return;
        }
        if (collection != null) {
            a2.addAll(collection);
        }
        a(str, (String) null, a2);
    }

    public StatService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5261b = new ConcurrentHashMap<>();
    }

    public static synchronized void a(String str, ETag eTag, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, str, eTag, collection) == null) {
            synchronized (StatService.class) {
                if (eTag != null) {
                    a(str, eTag.name(), collection);
                }
            }
        }
    }

    public static void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2, str3) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        a(str, str2, str3, System.currentTimeMillis());
    }

    public static void b(String str, String str2, String str3) {
        ArrayList<String> a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65546, null, str, str2, str3) == null) || (a2 = a(str, str2)) == null) {
            return;
        }
        if (str3 != null) {
            a2.add(str3);
        }
        a(str, (String) null, a2);
    }

    public static void a(String str, String str2, String str3, long j) {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, str2, str3, Long.valueOf(j)}) == null) {
            if (str3 != null) {
                arrayList = new ArrayList(1);
                arrayList.add(str3);
            } else {
                arrayList = null;
            }
            a(str, str2, arrayList, j);
        }
    }

    public static void a(String str, String str2, Collection<String> collection, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{str, str2, collection, Long.valueOf(j)}) == null) {
            i.a(RimStatisticsUtil.getAppContext()).a(h.a(str, j, str2, com.baidu.fsg.base.statistics.a.a(), collection));
            if (i.a(RimStatisticsUtil.getAppContext()).a() >= 200) {
                l.a().a("normal_log");
            }
        }
    }

    public static void a(String str, String str2, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65544, null, str, str2, collection) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        a(str, str2, collection, System.currentTimeMillis());
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, null, str) == null) {
            a().f5261b.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static ArrayList<String> a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            Long l = a().f5261b.get(str);
            if (l == null) {
                return null;
            }
            Long valueOf = Long.valueOf(System.currentTimeMillis() - l.longValue());
            a().f5261b.remove(str);
            arrayList.add(Long.toString(valueOf.longValue()));
            arrayList.add(str2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }
}
