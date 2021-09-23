package c.p.a.e.b.p;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.p.a.e.b.g.e;
import c.p.a.e.b.g.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationService;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f35474c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<Integer, Long> f35475a;

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray<a> f35476b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1473210636, "Lc/p/a/e/b/p/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1473210636, "Lc/p/a/e/b/p/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35475a = new HashMap();
        new HashSet();
        this.f35476b = new SparseArray<>();
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f35474c == null) {
                synchronized (b.class) {
                    if (f35474c == null) {
                        f35474c = new b();
                    }
                }
            }
            return f35474c;
        }
        return (b) invokeV.objValue;
    }

    public static boolean h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? i2 == 1 || i2 == 3 : invokeI.booleanValue;
    }

    public static boolean j(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, downloadInfo)) == null) ? downloadInfo.isDownloadOverStatus() && h(downloadInfo.getNotificationVisibility()) : invokeL.booleanValue;
    }

    public void b(int i2) {
        DownloadInfo f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (f2 = c.p.a.e.b.g.a.H(e.n()).f(i2)) == null) {
            return;
        }
        d(f2);
        g(f2);
    }

    public void c(int i2, int i3, Notification notification) {
        Context n;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, notification) == null) || (n = e.n()) == null || i2 == 0 || notification == null) {
            return;
        }
        if (i3 == 4) {
            synchronized (this.f35475a) {
                Long l = this.f35475a.get(Integer.valueOf(i2));
                long currentTimeMillis = System.currentTimeMillis();
                if (l != null && Math.abs(currentTimeMillis - l.longValue()) < 1000) {
                    return;
                }
                this.f35475a.put(Integer.valueOf(i2), Long.valueOf(currentTimeMillis));
            }
        }
        try {
            Intent intent = new Intent(n, DownloadNotificationService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY");
            intent.putExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", i3);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i2);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA", notification);
            n.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void d(DownloadInfo downloadInfo) {
        k M0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo) == null) && (M0 = e.M0()) != null && downloadInfo.isDownloadOverStatus()) {
            downloadInfo.setNotificationVisibility(3);
            try {
                M0.a(downloadInfo);
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void e(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null) {
            return;
        }
        synchronized (this.f35476b) {
            this.f35476b.put(aVar.a(), aVar);
        }
    }

    public SparseArray<a> f() {
        InterceptResult invokeV;
        SparseArray<a> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this.f35476b) {
                sparseArray = this.f35476b;
            }
            return sparseArray;
        }
        return (SparseArray) invokeV.objValue;
    }

    public void g(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, downloadInfo) == null) && j(downloadInfo)) {
            m(downloadInfo.getId());
        }
    }

    public void i(int i2) {
        Context n;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (n = e.n()) == null || i2 == 0) {
            return;
        }
        try {
            Intent intent = new Intent(n, DownloadNotificationService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i2);
            n.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public a k(int i2) {
        InterceptResult invokeI;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (i2 == 0) {
                return null;
            }
            synchronized (this.f35476b) {
                aVar = this.f35476b.get(i2);
                if (aVar != null) {
                    this.f35476b.remove(i2);
                    c.p.a.e.b.c.a.b("removeNotificationId " + i2);
                }
            }
            return aVar;
        }
        return (a) invokeI.objValue;
    }

    public a l(int i2) {
        InterceptResult invokeI;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (i2 == 0) {
                return null;
            }
            synchronized (this.f35476b) {
                aVar = this.f35476b.get(i2);
            }
            return aVar;
        }
        return (a) invokeI.objValue;
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            k(i2);
            if (i2 != 0) {
                a().i(i2);
            }
        }
    }
}
