package c.a.b0.j.e;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.b0.j.c.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.nadcore.download.notification.NotificationReceiver;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NotificationManager a;

    /* renamed from: b  reason: collision with root package name */
    public NotificationCompat.Builder f1645b;

    /* renamed from: c.a.b0.j.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0047a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1721940390, "Lc/a/b0/j/e/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1721940390, "Lc/a/b0/j/e/a$b;");
                    return;
                }
            }
            a = new a(null);
        }
    }

    public /* synthetic */ a(C0047a c0047a) {
        this();
    }

    public static a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (a) invokeV.objValue;
    }

    public void a(int i2) {
        NotificationManager notificationManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (notificationManager = this.a) == null) {
            return;
        }
        try {
            notificationManager.cancel(i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a == null) {
            return;
        }
        try {
            a(135637042);
            a(1743353008);
            a(-1276312226);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final NotificationCompat.Builder c() {
        InterceptResult invokeV;
        NotificationCompat.Builder builder;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Context b2 = c.a.b0.h.a.b();
            if (Build.VERSION.SDK_INT >= 26) {
                d();
                builder = new NotificationCompat.Builder(b2, "com.baidu.nadcore.notification.channel");
            } else {
                builder = new NotificationCompat.Builder(b2);
            }
            builder.setSmallIcon(c.a().a());
            builder.setWhen(System.currentTimeMillis());
            builder.setPriority(0);
            builder.setDefaults(-1);
            builder.setVisibility(1);
            builder.setVibrate(new long[]{0});
            builder.setSound(null);
            return builder;
        }
        return (NotificationCompat.Builder) invokeV.objValue;
    }

    @RequiresApi(api = 26)
    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.a == null) {
            return;
        }
        NotificationChannel notificationChannel = new NotificationChannel("com.baidu.nadcore.notification.channel", "下载消息提示", 4);
        notificationChannel.setLockscreenVisibility(1);
        notificationChannel.enableLights(false);
        notificationChannel.enableVibration(false);
        notificationChannel.setVibrationPattern(new long[]{0});
        notificationChannel.setSound(null, null);
        this.a.createNotificationChannel(notificationChannel);
    }

    public PendingIntent e(String str, c.a.b0.j.d.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, aVar)) == null) {
            if (TextUtils.isEmpty(str) || aVar == null) {
                return null;
            }
            Context b2 = c.a.b0.h.a.b();
            Intent intent = new Intent(str);
            intent.setComponent(new ComponentName(b2.getPackageName(), NotificationReceiver.class.getName()));
            intent.putExtra(NotificationReceiver.INTENT_PARAMS_KEY_PACKAGE_NAME, aVar.f1614d);
            File file = aVar.f1618h;
            intent.putExtra(NotificationReceiver.INTENT_PARAMS_KEY_DOWNLOAD_FILE_PATH, (file == null || !file.exists()) ? "" : aVar.f1618h.getAbsolutePath());
            intent.putExtra(NotificationReceiver.INTENT_PARAMS_KEY_NOTIFY_TYPE, aVar.o.l);
            intent.putExtra(NotificationReceiver.INTENT_PARAMS_KEY_NOTIFICATION_ID, aVar.d().hashCode());
            intent.putExtra(NotificationReceiver.INTENT_PARAMS_KEY_EXTRA_PARAM, aVar.n.a);
            return PendingIntent.getBroadcast(b2, aVar.d().hashCode(), intent, 134217728);
        }
        return (PendingIntent) invokeLL.objValue;
    }

    public void g(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, str, str2, str3, str4) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (!TextUtils.isEmpty(str)) {
                clogBuilder.t(str);
            }
            if (!TextUtils.equals(str, ClogBuilder.LogType.DOWNLOAD_INSTALL.type) && !TextUtils.equals(str, ClogBuilder.LogType.OPEN_APP.type)) {
                clogBuilder.q(ClogBuilder.Page.AD_NOTIFICATION);
            } else {
                clogBuilder.q(ClogBuilder.Page.RETARGET);
            }
            if (!TextUtils.isEmpty(str2)) {
                clogBuilder.h(str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                clogBuilder.n(str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                clogBuilder.i(str4);
            }
            c.a.b0.a0.a.b(clogBuilder);
        }
    }

    public void h(c.a.b0.j.d.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, aVar, str) == null) || this.a == null) {
            return;
        }
        try {
            b();
            Context b2 = c.a.b0.h.a.b();
            String str2 = aVar.n.f1638h;
            String str3 = "";
            if (TextUtils.equals(str, "notify_type_pause")) {
                str3 = b2.getResources().getString(R.string.nad_download_paused);
            } else if (TextUtils.equals(str, "notify_type_stop")) {
                str3 = b2.getResources().getString(R.string.nad_download_stopped);
            }
            NotificationCompat.Builder c2 = c();
            c2.setTicker(str2 + str3);
            c2.setContentTitle(str2);
            c2.setContentText(str3);
            c2.setAutoCancel(true);
            c2.setOngoing(false);
            this.a.notify(1743353008, c2.build());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void i(c.a.b0.j.d.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) || this.a == null) {
            return;
        }
        try {
            b();
            Context b2 = c.a.b0.h.a.b();
            String str = aVar.n.f1638h;
            String string = b2.getResources().getString(R.string.nad_download_succeed);
            NotificationCompat.Builder c2 = c();
            c2.setTicker(string);
            c2.setContentTitle(str);
            c2.setContentText(string);
            c2.setContentIntent(e(NotificationReceiver.RECEIVER_ACTION_DOWNLOAD_SUCCESS, aVar));
            c2.setAutoCancel(true);
            c2.setOngoing(false);
            this.a.notify(-1276312226, c2.build());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void j(c.a.b0.j.d.a aVar) {
        NotificationManager notificationManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) || (notificationManager = this.a) == null) {
            return;
        }
        try {
            notificationManager.cancel(1743353008);
            this.a.cancel(-1276312226);
            Context b2 = c.a.b0.h.a.b();
            String str = aVar.n.f1638h;
            String string = b2.getResources().getString(R.string.nad_downloading);
            int i2 = (int) (aVar.f1619i * 100.0f);
            if (this.f1645b == null) {
                NotificationCompat.Builder c2 = c();
                this.f1645b = c2;
                c2.setAutoCancel(false);
                this.f1645b.setOngoing(true);
                NotificationCompat.Builder builder = this.f1645b;
                builder.setTicker(string + "：" + str);
                this.f1645b.setContentTitle(str);
                this.f1645b.setContentText(string);
            } else {
                NotificationCompat.Builder builder2 = this.f1645b;
                builder2.setTicker(string + "：" + str);
                this.f1645b.setContentTitle(str);
                this.f1645b.setDefaults(4);
            }
            this.f1645b.setProgress(100, i2, false);
            this.a.notify(135637042, this.f1645b.build());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

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
        this.a = (NotificationManager) c.a.b0.h.a.b().getSystemService(ActionJsonData.TAG_NOTIFICATION);
    }
}
