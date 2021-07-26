package a.a.a.a.v;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Process;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.fun.ad.sdk.FunAdSdk;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final BroadcastReceiver f1400a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile NetworkInfo f1401b;

    /* renamed from: c  reason: collision with root package name */
    public static final HashSet<b> f1402c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                d.a("onReceive:" + intent, new Object[0]);
                f.a(context, intent);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(@Nullable NetworkInfo networkInfo);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1837085230, "La/a/a/a/v/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1837085230, "La/a/a/a/v/f;");
                return;
            }
        }
        f1400a = new a();
        f1402c = new HashSet<>();
        Context appContext = FunAdSdk.getAppContext();
        a(appContext, appContext.registerReceiver(f1400a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")));
    }

    public static void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, bVar) == null) {
            synchronized (f1402c) {
                f1402c.add(bVar);
            }
            bVar.a(f1401b);
        }
    }

    public static void a(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, intent) == null) {
            if (intent == null || context.checkPermission(DefaultConnectivityMonitorFactory.NETWORK_PERMISSION, Process.myPid(), Process.myUid()) != 0) {
                f1401b = null;
                return;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                f1401b = null;
                return;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            d.a("activeNetworkInfo:" + activeNetworkInfo, new Object[0]);
            f1401b = activeNetworkInfo;
            synchronized (f1402c) {
                Iterator<b> it = f1402c.iterator();
                while (it.hasNext()) {
                    it.next().a(activeNetworkInfo);
                }
            }
        }
    }
}
