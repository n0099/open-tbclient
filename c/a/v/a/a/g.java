package c.a.v.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SharedPreferences f26459e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f26460f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f26461g;

        public a(SharedPreferences sharedPreferences, String str, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sharedPreferences, str, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26459e = sharedPreferences;
            this.f26460f = str;
            this.f26461g = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g.n(this.f26459e, this.f26460f, this.f26461g);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f26462e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f26463f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Set f26464g;

        public b(Context context, String str, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26462e = context;
            this.f26463f = str;
            this.f26464g = set;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26462e.getSharedPreferences("track_sp", 0).edit().putStringSet(this.f26463f, this.f26464g).apply();
            }
        }
    }

    public static Set<String> b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) ? h(context, "track_connection", new HashSet()) : (Set) invokeL.objValue;
    }

    public static int c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? g(context, Constants.KEY_LOGIN_OPEN_TYPE, -1) : invokeL.intValue;
    }

    public static Set<String> d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? h(context, "track_request", new HashSet()) : (Set) invokeL.objValue;
    }

    public static boolean e(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i2)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            sb.append("real_time_track");
            return g(context, sb.toString(), 0) == 1;
        }
        return invokeLI.booleanValue;
    }

    public static boolean f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? g(context, "track_upload_state", 1) == 1 : invokeL.booleanValue;
    }

    public static int g(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65542, null, context, str, i2)) == null) ? context.getSharedPreferences("track_sp", 0).getInt(str, i2) : invokeLLI.intValue;
    }

    public static Set<String> h(Context context, String str, Set<String> set) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, context, str, set)) == null) ? context.getSharedPreferences("track_sp", 0).getStringSet(str, set) : (Set) invokeLLL.objValue;
    }

    public static void i(Context context, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65544, null, context, i2, i3) == null) {
            l(context, i2 + "real_time_track", i3);
        }
    }

    public static void j(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, null, context, i2) == null) {
            l(context, "track_upload_state", i2);
        }
    }

    public static void k(Context context, Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, context, set) == null) {
            q(context, "track_connection", set);
        }
    }

    public static void l(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65547, null, context, str, i2) == null) {
            p(context, str, Integer.valueOf(i2));
        }
    }

    public static void m(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65548, null, context, i2) == null) {
            l(context, Constants.KEY_LOGIN_OPEN_TYPE, i2);
        }
    }

    public static void n(SharedPreferences sharedPreferences, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, sharedPreferences, str, obj) == null) {
            if (obj instanceof Boolean) {
                sharedPreferences.edit().putBoolean(str, ((Boolean) obj).booleanValue()).apply();
            } else if (obj instanceof Integer) {
                sharedPreferences.edit().putInt(str, ((Integer) obj).intValue()).apply();
            } else if (obj instanceof Long) {
                sharedPreferences.edit().putLong(str, ((Long) obj).longValue()).apply();
            } else if (obj instanceof Float) {
                sharedPreferences.edit().putFloat(str, ((Float) obj).floatValue()).apply();
            } else if (obj instanceof String) {
                sharedPreferences.edit().putString(str, (String) obj).apply();
            }
        }
    }

    public static void o(Context context, Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, context, set) == null) {
            q(context, "track_request", set);
        }
    }

    public static void p(Context context, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, context, str, obj) == null) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("track_sp", 0);
                if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    c.a.v.a.g.a.a(context).b(new a(sharedPreferences, str, obj));
                } else {
                    n(sharedPreferences, str, obj);
                }
            } catch (Throwable th) {
                c.a.v.a.h.e.b("TrackUtils", th.getMessage());
            }
        }
    }

    @SuppressLint({"CommitPrefEdits"})
    public static void q(Context context, String str, Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, null, context, str, set) == null) {
            try {
                if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    c.a.v.a.g.a.a(context).b(new b(context, str, set));
                } else {
                    context.getSharedPreferences("track_sp", 0).edit().putStringSet(str, set).apply();
                }
            } catch (Throwable th) {
                c.a.v.a.h.e.b("TrackUtils", th.getMessage());
            }
        }
    }
}
