package c.a.p0.i.b.h;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.z2.k;
import c.a.p0.i.b.d.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.KVStorageFactory;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.gamecenter.appmanager.notification.InstallNotifyReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Calendar;
import java.util.Collection;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f9934c;
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences a;

    /* renamed from: b  reason: collision with root package name */
    public String f9935b;

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
                return;
            }
        }
        this.f9935b = "com.baidu.gamenow";
        this.a = KVStorageFactory.getSharedPreferences("gamecenter_install_notification", 0);
    }

    public static a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f9934c == null) {
                synchronized (a.class) {
                    if (f9934c == null) {
                        f9934c = new a();
                    }
                }
            }
            return f9934c;
        }
        return (a) invokeV.objValue;
    }

    public void a(Download download) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, download) == null) {
            b.a(AppRuntime.getAppContext(), Long.valueOf(download.getId().longValue()).intValue());
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? k.f(Long.valueOf(g()), Long.valueOf(System.currentTimeMillis())) : invokeV.booleanValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (b()) {
                return null;
            }
            if (d()) {
                return "todayfirst";
            }
            if (e()) {
                return "pushregularly";
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (System.currentTimeMillis() / 86400000) - (g() / 86400000) > 1 : invokeV.booleanValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? i() <= System.currentTimeMillis() : invokeV.booleanValue;
    }

    public final long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.getLong("key_notification_time", 0L) : invokeV.longValue;
    }

    public final long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            long i2 = i();
            return i2 >= System.currentTimeMillis() ? i2 : i2 + 86400000;
        }
        return invokeV.longValue;
    }

    public final long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 19);
            calendar.set(12, 30);
            return calendar.getTimeInMillis();
        }
        return invokeV.longValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || TextUtils.isEmpty(c())) {
            return;
        }
        n(c());
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            SharedPreferences.Editor edit = this.a.edit();
            edit.putLong("key_notification_time", System.currentTimeMillis());
            edit.apply();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ((AlarmManager) AppRuntime.getAppContext().getSystemService(NotificationCompat.CATEGORY_ALARM)).set(0, h(), PendingIntent.getBroadcast(AppRuntime.getAppContext(), 2147483646, InstallNotifyReceiver.createIntent(InstallNotifyReceiver.NOTIFICATION_INSTALL_ACTION_ALARM), 0));
        }
    }

    public void m(Download download, boolean z, String str) {
        String format;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048587, this, new Object[]{download, Boolean.valueOf(z), str}) != null) {
            return;
        }
        try {
            String str2 = download.getRealDownloadDir() + File.separator + download.getFileName();
            PackageManager packageManager = AppRuntime.getAppContext().getPackageManager();
            PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str2, 1);
            if (packageArchiveInfo == null) {
                return;
            }
            Context appContext = AppRuntime.getAppContext();
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.sourceDir = str2;
            applicationInfo.publicSourceDir = str2;
            Drawable applicationIcon = packageManager.getApplicationIcon(applicationInfo);
            String charSequence = packageManager.getApplicationLabel(applicationInfo).toString();
            PendingIntent broadcast = PendingIntent.getBroadcast(appContext, Long.valueOf(download.getId().longValue()).intValue(), InstallNotifyReceiver.createIntent(InstallNotifyReceiver.NOTIFICATION_INSTALL_ACTION_ONE, download.getKeyByUser(), str), 134217728);
            if (z) {
                l();
                format = String.format(appContext.getString(c.a.p0.i.a.aiapps_title_notification1), charSequence);
                string = appContext.getString(c.a.p0.i.a.aiapps_content_notification1);
            } else {
                format = String.format(appContext.getString(c.a.p0.i.a.aiapps_title_notification1), charSequence);
                string = appContext.getString(c.a.p0.i.a.aiapps_content_notification1);
            }
            try {
                b.c(appContext, Long.valueOf(download.getId().longValue()).intValue(), format, TextUtils.equals(download.getKeyByUser(), this.f9935b) ? appContext.getString(c.a.p0.i.a.aiapps_gamenow_notification) : string, b.b(applicationIcon), System.currentTimeMillis(), broadcast, str, download.getKeyByUser());
            } catch (Exception e2) {
                e = e2;
                if (c.a.p0.a.k.a) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || b()) {
            return;
        }
        try {
            Collection<Download> t = new c(DownloadManager.getInstance(AppRuntime.getAppContext())).t();
            if (t != null && t.size() != 0) {
                k();
                Download download = null;
                for (Download download2 : t) {
                    if (download2 != null) {
                        download = download2;
                    }
                }
                if (1 == t.size()) {
                    m(download, false, str);
                    return;
                }
                String str2 = download.getRealDownloadDir() + File.separator + download.getFileName();
                PackageManager packageManager = AppRuntime.getAppContext().getPackageManager();
                PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str2, 1);
                if (packageArchiveInfo == null) {
                    return;
                }
                Context appContext = AppRuntime.getAppContext();
                ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
                applicationInfo.sourceDir = str2;
                applicationInfo.publicSourceDir = str2;
                b.c(appContext, 0, String.format(appContext.getString(c.a.p0.i.a.aiapps_title_notification2), Integer.valueOf(t.size())), appContext.getString(c.a.p0.i.a.aiapps_content_notification1), b.b(packageManager.getApplicationIcon(applicationInfo)), System.currentTimeMillis(), PendingIntent.getBroadcast(appContext, Integer.MAX_VALUE, InstallNotifyReceiver.createToDownloadPageIntent(InstallNotifyReceiver.NOTIFICATION_INSTALL_ACTION_MULTIPLE).putExtra(InstallNotifyReceiver.OPPORTUNITY, str), 134217728), str, download.getKeyByUser());
            }
        } catch (Exception e2) {
            if (c.a.p0.a.k.a) {
                e2.printStackTrace();
            }
        }
    }
}
