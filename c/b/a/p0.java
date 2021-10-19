package c.b.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class p0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Runnable f31422e;

        /* renamed from: f  reason: collision with root package name */
        public final String f31423f;

        /* renamed from: g  reason: collision with root package name */
        public final String f31424g;

        public a(Runnable runnable, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {runnable, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31422e = runnable;
            this.f31423f = str;
            this.f31424g = Log.getStackTraceString(new RuntimeException("origin stacktrace"));
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f31422e.run();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    o0.f("TrackerDr", "Thread:" + this.f31423f + " exception\n" + this.f31424g, e2);
                }
            }
        }
    }

    public static void a(@Nullable String str, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, str, runnable) == null) || runnable == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "TrackerDr";
        }
        new Thread(new a(runnable, str), str).start();
    }

    public static boolean b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(str, 128) != null;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
