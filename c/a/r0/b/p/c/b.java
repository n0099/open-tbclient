package c.a.r0.b.p.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.k;
import c.a.r0.b.h;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f10173b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0669b f10174e;

        public a(InterfaceC0669b interfaceC0669b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC0669b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10174e = interfaceC0669b;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            InterfaceC0669b interfaceC0669b;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) || (interfaceC0669b = this.f10174e) == null) {
                return;
            }
            interfaceC0669b.onResult(i2 == -1);
        }
    }

    /* renamed from: c.a.r0.b.p.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0669b {
        void onResult(boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2002067556, "Lc/a/r0/b/p/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2002067556, "Lc/a/r0/b/p/c/b;");
                return;
            }
        }
        a = k.a;
        f10173b = new String[]{"BLA-AL00", "R7Plus"};
    }

    public static DialogInterface.OnClickListener a(InterfaceC0669b interfaceC0669b) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, interfaceC0669b)) == null) ? new a(interfaceC0669b) : (DialogInterface.OnClickListener) invokeL.objValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return NotificationManagerCompat.from(context).areNotificationsEnabled();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            String packageName = context.getPackageName();
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", packageName, null));
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            if (!Arrays.asList(f10173b).contains(Build.MODEL)) {
                Intent intent = new Intent();
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 26) {
                    intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
                    intent.setFlags(268435456);
                } else if (i2 >= 21) {
                    intent.putExtra("app_package", context.getPackageName());
                    intent.putExtra("app_uid", context.getApplicationInfo().uid);
                }
                try {
                    context.startActivity(intent);
                    return;
                } catch (Exception e2) {
                    if (a) {
                        String str = "openNotificationSettingPages() Exception:" + e2;
                    }
                    c(context);
                    return;
                }
            }
            c(context);
        }
    }

    public static void e(Context context, InterfaceC0669b interfaceC0669b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, interfaceC0669b) == null) {
            if (!(context instanceof Activity)) {
                if (a) {
                    throw new IllegalArgumentException("context must be activity.");
                }
            } else if (interfaceC0669b == null) {
            } else {
                DialogInterface.OnClickListener a2 = a(interfaceC0669b);
                SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(context);
                aVar.n(new c.a.r0.a.a3.h.a());
                SwanAppAlertDialog c2 = aVar.c();
                aVar.U(h.swan_app_guide_notify_title);
                aVar.x(context.getString(h.swan_app_guide_notify_msg));
                aVar.y();
                aVar.J(c.a.r0.a.c1.a.M().a());
                aVar.O(h.swan_app_guide_positive_btn, a2);
                aVar.B(h.swan_app_guide_negative_btn, a2);
                aVar.a();
                c2.setCancelable(false);
                c2.show();
            }
        }
    }
}
