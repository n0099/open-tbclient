package c.a.k.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.browser.core.util.BdLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public static ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> a;

    /* renamed from: b  reason: collision with root package name */
    public static b f3743b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f3744c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ b(Looper looper, a aVar) {
            this(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                f.d();
                f.f3743b.sendEmptyMessageDelayed(0, 15000L);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1328758003, "Lc/a/k/a/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1328758003, "Lc/a/k/a/f;");
                return;
            }
        }
        a = new ConcurrentHashMap<>();
        f3744c = false;
        b bVar = new b(c.a.k.a.o.b.a("PreferenceQueue").getLooper(), null);
        f3743b = bVar;
        bVar.sendEmptyMessageDelayed(0, 15000L);
    }

    public static void c(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, str, str2, obj) == null) || str == null) {
            return;
        }
        if (!a.containsKey(str)) {
            if (obj == null || str2 == null) {
                return;
            }
            ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
            concurrentHashMap.put(str2, obj);
            a.put(str, concurrentHashMap);
            return;
        }
        ConcurrentHashMap<String, Object> concurrentHashMap2 = a.get(str);
        if (concurrentHashMap2 != null) {
            if (obj != null) {
                concurrentHashMap2.put(str2, obj);
            } else {
                concurrentHashMap2.remove(str2);
            }
        } else if (obj == null || str2 == null) {
        } else {
            ConcurrentHashMap<String, Object> concurrentHashMap3 = new ConcurrentHashMap<>();
            concurrentHashMap3.put(str2, obj);
            a.put(str, concurrentHashMap3);
        }
    }

    public static void d() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) || f3744c) {
            return;
        }
        f3744c = true;
        try {
            try {
                Context baseContext = c.a.k.a.b.a().getBaseContext();
                BdLog.a("BdPreferenceQueueWorker", "pending work category: " + a.size());
                for (String str : a.keySet()) {
                    ConcurrentHashMap<String, Object> concurrentHashMap = a.get(str);
                    if (concurrentHashMap == null || concurrentHashMap.size() <= 0) {
                        i2 = 0;
                    } else {
                        SharedPreferences.Editor edit = baseContext.getSharedPreferences(str, 0).edit();
                        i2 = 0;
                        for (String str2 : concurrentHashMap.keySet()) {
                            Object obj = concurrentHashMap.get(str2);
                            if (obj != null) {
                                if (obj instanceof Integer) {
                                    edit.putInt(str2, ((Integer) obj).intValue());
                                } else if (obj instanceof Long) {
                                    edit.putLong(str2, ((Long) obj).longValue());
                                } else if (obj instanceof Float) {
                                    edit.putFloat(str2, ((Float) obj).floatValue());
                                } else if (obj instanceof Boolean) {
                                    edit.putBoolean(str2, ((Boolean) obj).booleanValue());
                                } else if (obj instanceof String) {
                                    edit.putString(str2, (String) obj);
                                } else if (obj instanceof Set) {
                                    edit.putStringSet(str2, (Set) obj);
                                }
                                i2++;
                            }
                        }
                        edit.commit();
                    }
                    concurrentHashMap.clear();
                    if (i2 > 0) {
                        BdLog.a("BdPreferenceQueueWorker", str + ".xml " + i2 + " items have been wroten");
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            f3744c = false;
        }
    }

    public static void e(String str) {
        ConcurrentHashMap<String, Object> concurrentHashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, str) == null) || str == null || (concurrentHashMap = a.get(str)) == null) {
            return;
        }
        concurrentHashMap.clear();
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65542, null) == null) || f3743b.hasMessages(0)) {
            return;
        }
        f3743b.sendEmptyMessageDelayed(0, 15000L);
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            f3743b.removeMessages(0);
            d();
            f();
        }
    }
}
