package c.p.a.e.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import androidx.core.view.InputDeviceCompat;
import c.p.a.e.b.f.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.text.FormattableUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f34961a;

    /* renamed from: b  reason: collision with root package name */
    public static NotificationChannel f34962b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f34963a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f34964b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f34965c;

        public a(Context context, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34963a = context;
            this.f34964b = i2;
            this.f34965c = z;
        }

        @Override // c.p.a.e.a.d.k
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int unused = d.f34961a = d.P(this.f34963a, this.f34964b, this.f34965c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f34966e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f34967f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f34968g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f34969h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ File f34970i;

        public b(Context context, int i2, boolean z, DownloadInfo downloadInfo, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Integer.valueOf(i2), Boolean.valueOf(z), downloadInfo, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34966e = context;
            this.f34967f = i2;
            this.f34968g = z;
            this.f34969h = downloadInfo;
            this.f34970i = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int e2 = d.e(this.f34966e, this.f34967f, this.f34968g, this.f34969h, this.f34970i);
                if (e2 == 1 && c.p.a.e.a.e.G().L() != null) {
                    c.p.a.e.a.e.G().L().a(this.f34969h, null);
                }
                d.I(this.f34969h, this.f34968g, e2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        @Override // c.p.a.e.a.d.e
        public n a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                return null;
            }
            return (n) invokeL.objValue;
        }

        @Override // c.p.a.e.a.d.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* renamed from: c.p.a.e.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public abstract class AbstractC1542d implements n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public AbstractC1542d() {
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

        @Override // c.p.a.e.a.d.n
        public n a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                return null;
            }
            return (n) invokeZ.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        n a(Context context);

        boolean a();
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(int i2, int i3, String str, String str2, String str3);

        void a(Context context, String str);

        void a(DownloadInfo downloadInfo);

        boolean a();

        boolean a(int i2, boolean z);

        void b(int i2, int i3, String str, int i4, long j2);
    }

    /* loaded from: classes4.dex */
    public interface g {
        String a();

        void a(int i2, String str, int i3, long j2);

        void a(Context context, String str);

        void a(DownloadInfo downloadInfo);

        boolean a(boolean z);

        void b(int i2, String str, String str2, String str3);
    }

    /* loaded from: classes4.dex */
    public interface h {
        Uri a(int i2, String str, String str2);
    }

    /* loaded from: classes4.dex */
    public interface i {
        void a(DownloadInfo downloadInfo, boolean z);

        void a(List<DownloadInfo> list);
    }

    /* loaded from: classes4.dex */
    public interface j {
        void a(DownloadInfo downloadInfo, BaseException baseException, int i2);
    }

    /* loaded from: classes4.dex */
    public interface k {
        void a();
    }

    /* loaded from: classes4.dex */
    public interface l {
        void a(DownloadInfo downloadInfo, k kVar);
    }

    /* loaded from: classes4.dex */
    public interface m {
        void a();

        boolean b();
    }

    /* loaded from: classes4.dex */
    public interface n {
        m a();

        n a(int i2);

        n a(int i2, DialogInterface.OnClickListener onClickListener);

        n a(String str);

        n a(boolean z);

        n b(int i2, DialogInterface.OnClickListener onClickListener);

        n c(DialogInterface.OnCancelListener onCancelListener);
    }

    /* loaded from: classes4.dex */
    public interface o {
        NotificationCompat.Builder a(Context context, String str);
    }

    /* loaded from: classes4.dex */
    public interface p {
        void a();

        void b();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-117764140, "Lc/p/a/e/a/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-117764140, "Lc/p/a/e/a/d;");
        }
    }

    public static boolean A(DownloadInfo downloadInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, downloadInfo, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (TextUtils.isEmpty(downloadInfo.getPackageName()) || !str.equals(downloadInfo.getPackageName())) {
                return !TextUtils.isEmpty(downloadInfo.getName()) && y(c.p.a.e.b.g.e.n(), downloadInfo, str);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return new JSONObject(str).optBoolean("bind_app", false);
        }
        return invokeL.booleanValue;
    }

    public static int D(Context context, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            DownloadInfo f2 = c.p.a.e.b.g.a.H(context).f(i2);
            if (f2 != null && "application/vnd.android.package-archive".equals(f2.getMimeType()) && !TextUtils.isEmpty(f2.getSavePath()) && !TextUtils.isEmpty(f2.getName())) {
                File file = new File(f2.getSavePath(), f2.getName());
                if (file.exists()) {
                    c.p.a.e.b.g.e.V(new b(context, i2, z, f2, file));
                    return 1;
                }
            }
            I(f2, z, 2);
            return 2;
        }
        return invokeCommon.intValue;
    }

    public static int E(Context context, DownloadInfo downloadInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, downloadInfo)) == null) {
            if (context != null && downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
                int appVersionCode = downloadInfo.getAppVersionCode();
                if (appVersionCode > 0) {
                    return appVersionCode;
                }
                try {
                    PackageInfo h2 = h(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
                    if (h2 != null) {
                        int i2 = h2.versionCode;
                        downloadInfo.setAppVersionCode(i2);
                        return i2;
                    }
                } catch (Throwable unused) {
                }
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public static String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? c.p.a.e.b.l.f.I0() : (String) invokeV.objValue;
    }

    public static String G(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65543, null, j2)) == null) {
            long[] jArr = {1099511627776L, 1073741824, 1048576, 1024, 1};
            String[] strArr = {"TB", "GB", "MB", "KB", "B"};
            if (j2 < 1) {
                return "0 " + strArr[4];
            }
            for (int i2 = 0; i2 < 5; i2++) {
                long j3 = jArr[i2];
                if (j2 >= j3) {
                    return l(j2, j3, strArr[i2]);
                }
            }
            return null;
        }
        return (String) invokeJ.objValue;
    }

    @TargetApi(26)
    public static String H(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            try {
                if (f34962b == null) {
                    NotificationChannel notificationChannel = new NotificationChannel("111111", "channel_appdownloader", 3);
                    f34962b = notificationChannel;
                    notificationChannel.setSound(null, null);
                    f34962b.setShowBadge(false);
                    ((NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION)).createNotificationChannel(f34962b);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return "111111";
        }
        return (String) invokeL.objValue;
    }

    public static void I(DownloadInfo downloadInfo, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{downloadInfo, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || downloadInfo == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("by_user", z ? 1 : 2);
            jSONObject.put("view_result", i2);
            jSONObject.put("real_package_name", downloadInfo.getFilePackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        c.p.a.e.b.g.e.p().b(downloadInfo.getId(), "install_view_result", jSONObject);
    }

    public static boolean J(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, context, downloadInfo, packageInfo)) == null) ? x(context, downloadInfo, packageInfo, false) : invokeLLL.booleanValue;
    }

    public static boolean K(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (!jSONObject.optBoolean("bind_app", false)) {
                if (jSONObject.optBoolean("auto_install_with_notification", true)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static List<String> M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add("application/vnd.android.package-archive");
            arrayList.add("application/ttpatch");
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static boolean N(Context context, DownloadInfo downloadInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, context, downloadInfo)) == null) {
            if (context == null || downloadInfo == null || TextUtils.isEmpty(downloadInfo.getSavePath()) || TextUtils.isEmpty(downloadInfo.getName())) {
                return false;
            }
            return J(context, downloadInfo, h(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName()));
        }
        return invokeLL.booleanValue;
    }

    public static boolean O(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) ? !TextUtils.isEmpty(str) && str.equals("application/vnd.android.package-archive") : invokeL.booleanValue;
    }

    public static int P(Context context, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (c.p.a.e.b.j.a.d(i2).m("notification_opt_2") == 1) {
                c.p.a.e.b.p.b.a().m(i2);
            }
            q(c.p.a.e.a.k.d().i());
            if (c.p.a.e.b.j.a.d(i2).b("install_queue_enable", 0) == 1) {
                return c.p.a.e.a.k.d().a(context, i2, z);
            }
            return D(context, i2, z);
        }
        return invokeCommon.intValue;
    }

    public static JSONObject Q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new JSONObject(str);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? c.p.a.e.a.e.G().C() ? 16384 : 0 : invokeV.intValue;
    }

    public static int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65555, null, i2)) == null) {
            if (i2 == 0) {
                return 0;
            }
            if (i2 == -2) {
                return 2;
            }
            if (i2 == 1) {
                return 4;
            }
            if (c.p.a.e.b.d.a.b(i2) || i2 == 11) {
                return 1;
            }
            return c.p.a.e.b.d.a.a(i2) ? 3 : 0;
        }
        return invokeI.intValue;
    }

    public static int c(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65556, null, context, f2)) == null) ? (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
    }

    public static int d(Context context, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            l D = c.p.a.e.a.e.G().D();
            if (D == null) {
                return P(context, i2, z);
            }
            DownloadInfo f2 = c.p.a.e.b.g.a.H(context).f(i2);
            f34961a = 1;
            D.a(f2, new a(context, i2, z));
            return f34961a;
        }
        return invokeCommon.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0041, code lost:
        if (r0 == null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int e(Context context, int i2, boolean z, DownloadInfo downloadInfo, File file) {
        InterceptResult invokeCommon;
        PackageInfo packageInfo;
        Intent g2;
        Process process;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65558, null, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z), downloadInfo, file})) == null) {
            if (file.getPath().startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                try {
                    process = Runtime.getRuntime().exec("chmod 555 " + file.getAbsolutePath());
                    try {
                        process.waitFor();
                    } catch (Throwable th) {
                        th = th;
                        try {
                            th.printStackTrace();
                        } finally {
                            if (process != null) {
                                process.destroy();
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    process = null;
                }
            }
            try {
                packageInfo = i(downloadInfo, file);
                if (packageInfo != null) {
                    try {
                        downloadInfo.setFilePackageName(packageInfo.packageName);
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                th = null;
            } catch (Throwable th4) {
                th = th4;
                packageInfo = null;
            }
            if (c.p.a.e.a.e.G().y() != null) {
                if (packageInfo == null) {
                    BaseException baseException = new BaseException(2001, th);
                    c.p.a.e.a.e.G().y().a(downloadInfo, baseException, baseException.getErrorCode());
                } else {
                    c.p.a.e.a.e.G().y().a(downloadInfo, null, 11);
                }
            }
            if (w(context, downloadInfo, packageInfo)) {
                return 2;
            }
            if (packageInfo != null && c.p.a.e.b.j.a.d(downloadInfo.getId()).l("install_callback_error")) {
                downloadInfo.getTempCacheData().put("extra_apk_package_name", packageInfo.packageName);
                downloadInfo.getTempCacheData().put("extra_apk_version_code", Integer.valueOf(packageInfo.versionCode));
            }
            int[] iArr = new int[1];
            if (J(context, downloadInfo, packageInfo)) {
                g2 = context.getPackageManager().getLaunchIntentForPackage(packageInfo.packageName);
            } else if (!z && u(context, i2, file)) {
                downloadInfo.getTempCacheData().put("extra_silent_install_succeed", Boolean.TRUE);
                return 1;
            } else {
                g2 = g(context, downloadInfo, file, z, iArr);
            }
            if (g2 == null) {
                return iArr[0] == 1 ? 2 : 0;
            }
            g2.addFlags(268435456);
            if (downloadInfo.getLinkMode() > 0 && c.p.a.e.b.j.a.d(downloadInfo.getId()).b("app_install_return_result", 0) == 1) {
                g2.putExtra("android.intent.extra.RETURN_RESULT", true);
            }
            if (iArr[0] == 0 && c.p.a.e.a.c.r(context, downloadInfo, g2, z)) {
                return 1;
            }
            return f(context, g2);
        }
        return invokeCommon.intValue;
    }

    public static int f(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, context, intent)) == null) {
            try {
                if (c.p.a.e.a.e.G().K() != null) {
                    if (c.p.a.e.a.e.G().K().a(intent)) {
                        return 1;
                    }
                }
            } catch (Throwable unused) {
            }
            try {
                context.startActivity(intent);
                return 1;
            } catch (Throwable unused2) {
                return 0;
            }
        }
        return invokeLL.intValue;
    }

    public static Intent g(Context context, DownloadInfo downloadInfo, @NonNull File file, boolean z, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65560, null, new Object[]{context, downloadInfo, file, Boolean.valueOf(z), iArr})) == null) {
            Uri j2 = j(downloadInfo.getId(), c.p.a.e.b.g.a.H(context).e(downloadInfo.getId()), context, c.p.a.e.a.e.G().A(), file);
            if (j2 == null) {
                return null;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            if (Build.VERSION.SDK_INT >= 24) {
                intent.addFlags(1);
            }
            intent.setDataAndType(j2, "application/vnd.android.package-archive");
            f u = c.p.a.e.a.e.G().u();
            boolean a2 = u != null ? u.a(downloadInfo.getId(), z) : 0;
            c.p.a.e.b.f.e i2 = c.p.a.e.b.g.a.H(context).i(downloadInfo.getId());
            int i3 = a2;
            if (i2 != null) {
                i3 = i2.a(z);
            }
            iArr[0] = i3;
            if (i3 != 0) {
                return null;
            }
            return intent;
        }
        return (Intent) invokeCommon.objValue;
    }

    public static PackageInfo h(Context context, DownloadInfo downloadInfo, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65561, null, context, downloadInfo, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            File file = new File(str, str2);
            if (file.exists()) {
                String str3 = "isApkInstalled apkFileSize：fileName:" + file.getPath() + " apkFileSize" + file.length();
                return i(downloadInfo, file);
            }
            return null;
        }
        return (PackageInfo) invokeLLLL.objValue;
    }

    public static PackageInfo i(DownloadInfo downloadInfo, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, downloadInfo, file)) == null) {
            if (downloadInfo == null) {
                return c.p.a.e.a.h.a.d.a(c.p.a.e.b.g.e.n(), file, a());
            }
            PackageInfo packageInfo = downloadInfo.getPackageInfo();
            if (packageInfo == null) {
                PackageInfo a2 = c.p.a.e.a.h.a.d.a(c.p.a.e.b.g.e.n(), file, a());
                downloadInfo.setPackageInfo(a2);
                return a2;
            }
            return packageInfo;
        }
        return (PackageInfo) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0025 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Uri j(int i2, w wVar, Context context, String str, File file) {
        Uri uri;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65563, null, new Object[]{Integer.valueOf(i2), wVar, context, str, file})) == null) {
            if (wVar != null) {
                uri = wVar.a(str, file.getAbsolutePath());
            } else {
                h B = c.p.a.e.a.e.G().B();
                if (B != null) {
                    uri = B.a(i2, str, file.getAbsolutePath());
                }
                uri = null;
                if (uri == null) {
                    try {
                        if (Build.VERSION.SDK_INT >= 24 && !TextUtils.isEmpty(str)) {
                            uri = FileProvider.getUriForFile(context, str, file);
                        } else {
                            uri = Uri.fromFile(file);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                return uri;
            }
            if (uri == null) {
            }
            return uri;
        }
        return (Uri) invokeCommon.objValue;
    }

    public static String k(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65564, null, j2)) == null) ? n(j2, true) : (String) invokeJ.objValue;
    }

    public static String l(long j2, long j3, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65565, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str})) == null) {
            double d2 = j2;
            if (j3 > 1) {
                d2 /= j3;
            }
            if ("MB".equals(str)) {
                return new DecimalFormat("#").format(d2) + str;
            }
            return new DecimalFormat("#.##").format(d2) + str;
        }
        return (String) invokeCommon.objValue;
    }

    public static String m(long j2, long j3, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65566, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, Boolean.valueOf(z)})) == null) {
            double d2 = j2;
            if (j3 > 1) {
                d2 /= j3;
            }
            if (!z && !"GB".equals(str) && !"TB".equals(str)) {
                return new DecimalFormat("#").format(d2) + " " + str;
            }
            return new DecimalFormat("#.##").format(d2) + " " + str;
        }
        return (String) invokeCommon.objValue;
    }

    public static String n(long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65567, null, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            long[] jArr = {1099511627776L, 1073741824, 1048576, 1024, 1};
            String[] strArr = {"TB", "GB", "MB", "KB", "B"};
            if (j2 < 1) {
                return "0 " + strArr[4];
            }
            for (int i2 = 0; i2 < 5; i2++) {
                long j3 = jArr[i2];
                if (j2 >= j3) {
                    return m(j2, j3, strArr[i2], z);
                }
            }
            return null;
        }
        return (String) invokeCommon.objValue;
    }

    public static String o(String str, c.p.a.e.b.j.a aVar) {
        InterceptResult invokeLL;
        JSONObject u;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65568, null, str, aVar)) == null) {
            if (aVar == null || (u = aVar.u("download_dir")) == null) {
                return "";
            }
            String optString = u.optString("dir_name");
            if (!TextUtils.isEmpty(optString) && optString.startsWith("/")) {
                optString = optString.substring(1);
            }
            if (TextUtils.isEmpty(optString)) {
                return optString;
            }
            if (!optString.contains(FormattableUtils.SIMPLEST_FORMAT)) {
                format = optString + str;
            } else {
                try {
                    format = String.format(optString, str);
                } catch (Throwable unused) {
                }
            }
            optString = format;
            return optString.length() > 255 ? optString.substring(optString.length() - 255) : optString;
        }
        return (String) invokeLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
        if (android.text.TextUtils.isEmpty(r5) == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String p(String str, String str2, String str3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65569, null, new Object[]{str, str2, str3, Boolean.valueOf(z)})) != null) {
            return (String) invokeCommon.objValue;
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri parse = Uri.parse(str);
        if (z) {
            if (TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(parse.getLastPathSegment())) {
                    str2 = parse.getLastPathSegment();
                }
                str2 = "default.apk";
            }
            if (!O(str3) && !str2.endsWith(".apk")) {
                return str2 + ".apk";
            }
        }
        String lastPathSegment = parse.getLastPathSegment();
        if (!TextUtils.isEmpty(lastPathSegment)) {
            str2 = lastPathSegment;
        }
        return !O(str3) ? str2 : str2;
    }

    public static void q(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65570, null, activity) == null) || activity == null) {
            return;
        }
        try {
            if (activity.isFinishing()) {
                return;
            }
            activity.finish();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void s(DownloadInfo downloadInfo, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65572, null, new Object[]{downloadInfo, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            c.p.a.e.a.i iVar = new c.p.a.e.a.i(c.p.a.e.b.g.e.n(), downloadInfo.getUrl());
            iVar.H(downloadInfo.getTitle());
            iVar.U(downloadInfo.getName());
            iVar.Y(downloadInfo.getSavePath());
            iVar.K(downloadInfo.isShowNotification());
            iVar.W(downloadInfo.isAutoInstallWithoutNotification());
            iVar.Z(downloadInfo.isOnlyWifi() || z2);
            iVar.c0(downloadInfo.getExtra());
            iVar.g0(downloadInfo.getMimeType());
            iVar.I(downloadInfo.getExtraHeaders());
            iVar.h0(true);
            iVar.T(downloadInfo.getRetryCount());
            iVar.X(downloadInfo.getBackUpUrlRetryCount());
            iVar.V(downloadInfo.getBackUpUrls());
            iVar.b0(downloadInfo.getMinProgressTimeMsInterval());
            iVar.f0(downloadInfo.getMaxProgressCount());
            iVar.l0(z);
            iVar.d0(downloadInfo.isNeedHttpsToHttpRetry());
            iVar.k0(downloadInfo.getPackageName());
            iVar.n0(downloadInfo.getMd5());
            iVar.B(downloadInfo.getExpectFileLength());
            iVar.u0(downloadInfo.isNeedDefaultHttpServiceBackUp());
            iVar.x0(downloadInfo.isNeedReuseFirstConnection());
            iVar.B0(downloadInfo.isNeedIndependentProcess());
            iVar.C(downloadInfo.getEnqueueType());
            iVar.F0(downloadInfo.isForce());
            iVar.D0(downloadInfo.isHeadConnectionAvailable());
            iVar.o0(downloadInfo.isNeedRetryDelay());
            iVar.q0(downloadInfo.getRetryDelayTimeArray());
            iVar.J(Q(downloadInfo.getDownloadSettingString()));
            iVar.w0(downloadInfo.getIconUrl());
            iVar.j0(downloadInfo.getExecutorGroup());
            iVar.J0(downloadInfo.isAutoInstall());
            c.p.a.e.a.e.G().a(iVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
        if (r0 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0041, code lost:
        r0.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0045, code lost:
        if (r0 != null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, context)) == null) {
            if (Build.VERSION.SDK_INT > 20 && context != null) {
                TypedArray typedArray = null;
                try {
                    int color = context.getResources().getColor(c.p.a.e.a.g.b());
                    typedArray = context.obtainStyledAttributes(c.p.a.e.a.g.e(), new int[]{c.p.a.e.a.g.c(), c.p.a.e.a.g.d()});
                    if (color == typedArray.getColor(0, 0)) {
                        if (typedArray != null) {
                            try {
                                typedArray.recycle();
                            } catch (Throwable unused) {
                            }
                        }
                        return true;
                    }
                } catch (Throwable unused2) {
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean u(Context context, int i2, File file) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65574, null, context, i2, file)) == null) {
            if (c.p.a.e.b.j.a.d(i2).b("back_miui_silent_install", 1) == 1) {
                return false;
            }
            if ((c.p.a.e.a.h.e.p() || c.p.a.e.a.h.e.q()) && c.p.a.e.b.l.h.a(context, "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService")) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"));
                Bundle bundle = new Bundle();
                bundle.putInt("userId", 0);
                bundle.putInt("flag", 256);
                bundle.putString("apkPath", file.getPath());
                bundle.putString("installerPkg", "com.miui.securitycore");
                intent.putExtras(bundle);
                try {
                    context.startService(intent);
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public static boolean v(Context context, DownloadInfo downloadInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65575, null, context, downloadInfo)) == null) ? z(context, downloadInfo, true) : invokeLL.booleanValue;
    }

    public static boolean w(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65576, null, context, downloadInfo, packageInfo)) == null) {
            if (packageInfo == null || packageInfo.packageName.equals(downloadInfo.getPackageName())) {
                return false;
            }
            f u = c.p.a.e.a.e.G().u();
            if (u != null) {
                u.a(downloadInfo.getId(), 8, downloadInfo.getPackageName(), packageInfo.packageName, "");
                if (u.a()) {
                    return true;
                }
            }
            c.p.a.e.b.f.e i2 = c.p.a.e.b.g.a.H(context).i(downloadInfo.getId());
            if (i2 != null) {
                i2.a(8, downloadInfo, packageInfo.packageName, "");
                e b2 = c.p.a.e.a.e.G().b();
                return (b2 instanceof c) && ((c) b2).b();
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean x(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo, boolean z) {
        InterceptResult invokeCommon;
        PackageInfo packageInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65577, null, new Object[]{context, downloadInfo, packageInfo, Boolean.valueOf(z)})) == null) {
            if (packageInfo == null) {
                return false;
            }
            String str = packageInfo.packageName;
            int i2 = packageInfo.versionCode;
            if (downloadInfo != null) {
                downloadInfo.setAppVersionCode(i2);
            }
            try {
                packageInfo2 = context.getPackageManager().getPackageInfo(str, a());
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo2 = null;
            }
            if (packageInfo2 == null) {
                return false;
            }
            int i3 = packageInfo2.versionCode;
            return z ? i2 < i3 : (downloadInfo == null || c.p.a.e.b.j.a.d(downloadInfo.getId()).b("install_with_same_version_code", 0) != 1) ? i2 <= i3 : i2 < i3;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean y(Context context, DownloadInfo downloadInfo, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65578, null, context, downloadInfo, str)) == null) {
            if (context == null) {
                return false;
            }
            try {
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                PackageInfo packageInfo = null;
                if (file.exists()) {
                    String str2 = "isPackageNameEqualsWithApk fileName:" + downloadInfo.getName() + " apkFileSize：" + file.length() + " fileUrl：" + downloadInfo.getUrl();
                    PackageInfo i2 = i(downloadInfo, file);
                    if (i2 == null || !i2.packageName.equals(str)) {
                        return false;
                    }
                    int i3 = i2.versionCode;
                    try {
                        packageInfo = context.getPackageManager().getPackageInfo(str, a());
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                    if (packageInfo == null || i3 != packageInfo.versionCode) {
                        return false;
                    }
                } else if (!c.p.a.e.b.j.a.d(downloadInfo.getId()).l("install_callback_error")) {
                    return false;
                } else {
                    String i4 = c.p.a.e.b.l.f.i(downloadInfo.getTempCacheData().get("extra_apk_package_name"), null);
                    int c2 = c.p.a.e.b.l.f.c(downloadInfo.getTempCacheData().get("extra_apk_version_code"), 0);
                    if (i4 == null || TextUtils.isEmpty(i4) || !i4.equals(str)) {
                        return false;
                    }
                    try {
                        packageInfo = context.getPackageManager().getPackageInfo(str, a());
                    } catch (PackageManager.NameNotFoundException unused2) {
                    }
                    if (packageInfo == null || c2 != packageInfo.versionCode) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static boolean z(Context context, DownloadInfo downloadInfo, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65579, null, context, downloadInfo, z)) == null) {
            if (downloadInfo == null) {
                return false;
            }
            String packageName = downloadInfo.getPackageName();
            int appVersionCode = downloadInfo.getAppVersionCode();
            if (appVersionCode <= 0 && z) {
                return N(context, downloadInfo);
            }
            PackageInfo packageInfo = null;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(packageName, a());
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (packageInfo == null) {
                return false;
            }
            return c.p.a.e.b.j.a.d(downloadInfo.getId()).b("install_with_same_version_code", 0) == 1 ? appVersionCode < packageInfo.versionCode : appVersionCode <= packageInfo.versionCode;
        }
        return invokeLLZ.booleanValue;
    }
}
