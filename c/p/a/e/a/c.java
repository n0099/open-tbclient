package c.p.a.e.a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import c.p.a.e.b.a.a;
import c.p.a.e.b.k.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import io.reactivex.annotations.SchedulerSupport;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static e f34704a;

    /* renamed from: b  reason: collision with root package name */
    public static C1538c f34705b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements d {
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

        @Override // c.p.a.e.a.c.d
        public boolean a(@NonNull Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? c.E(context) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // c.p.a.e.a.c.d
        public boolean a(@NonNull Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? c.F(context) : invokeL.booleanValue;
        }
    }

    /* renamed from: c.p.a.e.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1538c implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final g f34706e;

        /* renamed from: f  reason: collision with root package name */
        public final int f34707f;

        /* renamed from: g  reason: collision with root package name */
        public JSONObject f34708g;

        public C1538c(Context context, Intent intent, int i2, JSONObject jSONObject, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, intent, Integer.valueOf(i2), jSONObject, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34708g = jSONObject;
            int optInt = jSONObject.optInt("query_interval", 1000);
            this.f34707f = optInt;
            this.f34706e = new g(context, intent, i2, dVar, optInt);
        }

        @Override // c.p.a.e.b.a.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.f34706e.f34721g) {
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    this.f34706e.f34718d.sendMessage(obtain);
                }
                c.p.a.e.b.a.a.c().i(this);
                C1538c unused = c.f34705b = null;
            }
        }

        @Override // c.p.a.e.b.a.a.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                int optInt = this.f34708g.optInt("time_out_second", 20);
                Message obtain = Message.obtain();
                obtain.what = 1;
                this.f34706e.f34718d.sendMessage(obtain);
                if (optInt <= 0 || optInt >= 60) {
                    return;
                }
                Message obtain2 = Message.obtain();
                obtain2.what = 2;
                this.f34706e.f34718d.sendMessageDelayed(obtain2, optInt * 1000);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        boolean a(@NonNull Context context);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(DownloadInfo downloadInfo, c.p.a.e.a.b bVar);
    }

    /* loaded from: classes4.dex */
    public static class f implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Context f34709e;

        /* renamed from: f  reason: collision with root package name */
        public final d f34710f;

        /* renamed from: g  reason: collision with root package name */
        public final Handler f34711g;

        /* renamed from: h  reason: collision with root package name */
        public final long f34712h;

        public f(Handler handler, Context context, d dVar, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler, context, dVar, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34709e = context;
            this.f34710f = dVar;
            this.f34711g = handler;
            this.f34712h = j2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f34710f != null && this.f34712h > 0 && this.f34712h <= 10000) {
                    Context context = this.f34709e;
                    boolean a2 = context != null ? this.f34710f.a(context) : false;
                    Message obtain = Message.obtain();
                    if (a2) {
                        obtain.what = 2;
                        this.f34711g.sendMessage(obtain);
                    } else {
                        obtain.what = 1;
                        this.f34711g.sendMessageDelayed(obtain, this.f34712h);
                    }
                    return Boolean.FALSE;
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class g implements h.a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: h  reason: collision with root package name */
        public static int f34713h;

        /* renamed from: i  reason: collision with root package name */
        public static int f34714i;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Context f34715a;

        /* renamed from: b  reason: collision with root package name */
        public final Intent f34716b;

        /* renamed from: c  reason: collision with root package name */
        public final d f34717c;

        /* renamed from: d  reason: collision with root package name */
        public final Handler f34718d;

        /* renamed from: e  reason: collision with root package name */
        public final long f34719e;

        /* renamed from: f  reason: collision with root package name */
        public Future<Boolean> f34720f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f34721g;

        public g(Context context, Intent intent, int i2, d dVar, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, intent, Integer.valueOf(i2), dVar, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34721g = false;
            this.f34715a = context;
            this.f34716b = intent;
            f34714i = i2;
            this.f34717c = dVar;
            this.f34718d = new c.p.a.e.b.k.h(Looper.getMainLooper(), this);
            this.f34719e = j2;
        }

        @Override // c.p.a.e.b.k.h.a
        public void a(Message message) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || message == null) {
                return;
            }
            int i2 = message.what;
            if (i2 == 1) {
                long j2 = this.f34719e;
                if (j2 <= 0 || j2 > 10000) {
                    return;
                }
                f34713h = 1;
                this.f34720f = c.p.a.e.b.g.e.A0().submit(new f(this.f34718d, this.f34715a, this.f34717c, this.f34719e));
            } else if (i2 == 2) {
                f34713h = 2;
                this.f34718d.removeMessages(2);
                this.f34718d.removeMessages(1);
                Future<Boolean> future = this.f34720f;
                if (future != null) {
                    future.cancel(true);
                }
                if (!this.f34721g && (Build.VERSION.SDK_INT < 29 || c.p.a.e.b.a.a.c().k())) {
                    Intent intent = this.f34716b;
                    if (intent != null) {
                        c.z(this.f34715a, intent);
                    } else {
                        DownloadInfo f2 = c.p.a.e.b.g.a.H(this.f34715a).f(f34714i);
                        if (f2 != null && f2.isDownloadOverStatus()) {
                            c.p.a.e.a.d.D(this.f34715a, f34714i, false);
                        }
                    }
                    this.f34721g = true;
                }
                c.x(f34714i, this.f34716b == null, c.l(this.f34715a));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final String f34722a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1502237455, "Lc/p/a/e/a/c$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1502237455, "Lc/p/a/e/a/c$h;");
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            boolean z2 = !TextUtils.isEmpty(Build.VERSION.RELEASE);
            boolean z3 = !TextUtils.isEmpty(Build.ID);
            z = (!"REL".equals(Build.VERSION.CODENAME) || TextUtils.isEmpty(Build.MODEL)) ? false : false;
            sb.append("AppDownloader");
            if (z2) {
                sb.append("/");
                sb.append(Build.VERSION.RELEASE);
            }
            sb.append(" (Linux; U; Android");
            if (z2) {
                sb.append(" ");
                sb.append(Build.VERSION.RELEASE);
            }
            if (z || z3) {
                sb.append(";");
                if (z) {
                    sb.append(" ");
                    sb.append(Build.MODEL);
                }
                if (z3) {
                    sb.append(" Build/");
                    sb.append(Build.ID);
                }
            }
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            f34722a = sb.toString();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-117764171, "Lc/p/a/e/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-117764171, "Lc/p/a/e/a/c;");
        }
    }

    public static boolean A(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull c.p.a.e.a.b bVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, context, downloadInfo, jSONObject, bVar)) == null) {
            if (context != null && jSONObject != null) {
                String savePath = downloadInfo.getSavePath();
                if (TextUtils.isEmpty(savePath)) {
                    return false;
                }
                bVar.f34702d = SchedulerSupport.CUSTOM;
                c.p.a.e.a.a.a a2 = c.p.a.e.a.a.d.a(context, SchedulerSupport.CUSTOM, jSONObject, downloadInfo);
                if (a2 != null && a2.a()) {
                    Intent b2 = a2.b();
                    if (b2 == null) {
                        return false;
                    }
                    if (u(new File(savePath), downloadInfo, jSONObject)) {
                        if (z(context, b2)) {
                            bVar.f34700b = 0;
                            return true;
                        }
                        bVar.f34700b = 1;
                    } else {
                        bVar.f34700b = 6;
                    }
                    return false;
                }
                bVar.f34700b = 3;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static void B(int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65538, null, i2, jSONObject) == null) {
            int i3 = 1;
            boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
            JSONObject jSONObject2 = new JSONObject();
            if (!z) {
                i3 = 2;
            }
            try {
                jSONObject2.put("scene", i3);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            c.p.a.e.b.g.e.p().a(i2, "guide_auth_open_setting", jSONObject2);
        }
    }

    public static void D(int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, jSONObject) == null) {
            int i3 = 1;
            boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
            JSONObject jSONObject2 = new JSONObject();
            if (!z) {
                i3 = 2;
            }
            try {
                jSONObject2.put("scene", i3);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            c.p.a.e.b.g.e.p().a(i2, "guide_auth_dialog_show", jSONObject2);
        }
    }

    public static boolean E(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            if (context == null) {
                return true;
            }
            try {
                return Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps", 1) > 0;
            } catch (Throwable unused) {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    @RequiresApi(api = 26)
    public static boolean F(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            if (context == null) {
                return true;
            }
            try {
                return context.getPackageManager().canRequestPackageInstalls();
            } catch (Throwable unused) {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public static int a(@NonNull c.p.a.e.b.j.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, aVar)) == null) {
            JSONObject u = aVar.u("download_dir");
            if (u != null ? !TextUtils.isEmpty(u.optString("dir_name")) : false) {
                if (c.p.a.e.b.j.a.r().l("get_download_info_by_list")) {
                    JSONArray v = aVar.v("ah_plans");
                    int i2 = -1;
                    if (v != null) {
                        int length = v.length();
                        for (int i3 = 0; i3 < length; i3++) {
                            JSONObject optJSONObject = v.optJSONObject(i3);
                            if (c.p.a.e.a.h.b.e(optJSONObject)) {
                                String optString = optJSONObject.optString("type");
                                if (!"plan_a".equals(optString) && !"plan_b".equals(optString) && !"plan_e".equals(optString) && !"plan_f".equals(optString)) {
                                    if ("plan_d".equalsIgnoreCase(optString) || "plan_h".equalsIgnoreCase(optString) || ("plan_g".equalsIgnoreCase(optString) && (i2 = v(optJSONObject, aVar).f34700b) == 0)) {
                                        return 0;
                                    }
                                } else {
                                    i2 = b(optJSONObject, aVar).f34700b;
                                    if (i2 == 0) {
                                        return 0;
                                    }
                                }
                            }
                        }
                    }
                    return i2;
                }
                return 4;
            }
            return 5;
        }
        return invokeL.intValue;
    }

    @NonNull
    public static c.p.a.e.a.b b(JSONObject jSONObject, c.p.a.e.b.j.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, jSONObject, aVar)) == null) {
            c.p.a.e.a.b bVar = new c.p.a.e.a.b();
            if (jSONObject == null) {
                return bVar;
            }
            String optString = jSONObject.optString("type");
            bVar.f34699a = optString;
            if ("plan_b".equals(optString)) {
                bVar.f34703e = SchedulerSupport.CUSTOM;
                if (c.p.a.e.a.a.d.b(c.p.a.e.b.g.e.n(), SchedulerSupport.CUSTOM, jSONObject, aVar)) {
                    bVar.f34700b = 0;
                    return bVar;
                }
                i(bVar, 3);
            } else {
                String optString2 = jSONObject.optString("device_plans");
                bVar.f34703e = optString2;
                if (!TextUtils.isEmpty(optString2)) {
                    for (String str : optString2.split(",")) {
                        if (c.p.a.e.a.a.d.b(c.p.a.e.b.g.e.n(), str, jSONObject, aVar)) {
                            bVar.f34700b = 0;
                            return bVar;
                        }
                        i(bVar, 3);
                    }
                }
            }
            return bVar;
        }
        return (c.p.a.e.a.b) invokeLL.objValue;
    }

    public static c.p.a.e.a.b c(JSONObject jSONObject, String str, Context context, c.p.a.e.b.j.a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65545, null, jSONObject, str, context, aVar)) == null) {
            c.p.a.e.a.b bVar = new c.p.a.e.a.b();
            if (jSONObject != null && c.p.a.e.a.h.e.d()) {
                bVar.f34699a = jSONObject.optString("type");
                if (aVar.b(NotificationStyle.BANNER_IMAGE_URL, 0) == 1) {
                    bVar.f34700b = 0;
                    return bVar;
                } else if (l(context)) {
                    bVar.f34700b = 2;
                } else if (c.p.a.e.a.h.b.a(str) != null) {
                    bVar.f34700b = 0;
                } else {
                    bVar.f34700b = 9;
                }
            }
            return bVar;
        }
        return (c.p.a.e.a.b) invokeLLLL.objValue;
    }

    public static String e(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, th)) == null) {
            String th2 = th.toString();
            return th2.length() > 800 ? th2.substring(0, 500) : th2;
        }
        return (String) invokeL.objValue;
    }

    public static void f(int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65548, null, i2, jSONObject) == null) {
            int i3 = 1;
            boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
            JSONObject jSONObject2 = new JSONObject();
            if (!z) {
                i3 = 2;
            }
            try {
                jSONObject2.put("scene", i3);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            c.p.a.e.b.g.e.p().a(i2, "guide_auth_dialog_confirm", jSONObject2);
        }
    }

    public static void h(Context context, Intent intent, int i2, JSONObject jSONObject, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{context, intent, Integer.valueOf(i2), jSONObject, dVar}) == null) {
            if (f34705b != null) {
                c.p.a.e.b.a.a.c().i(f34705b);
                f34705b = null;
            }
            f34705b = new C1538c(context, intent, i2, jSONObject, dVar);
            c.p.a.e.b.a.a.c().f(f34705b);
        }
    }

    public static void i(c.p.a.e.a.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65551, null, bVar, i2) == null) {
            int i3 = bVar.f34700b;
            if (i3 != -1) {
                bVar.f34700b = (i3 * 10) + i2;
            } else {
                bVar.f34700b = i2;
            }
        }
    }

    public static void j(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, eVar) == null) {
            f34704a = eVar;
        }
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? g.f34713h == 1 : invokeV.booleanValue;
    }

    public static boolean l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            if (context == null) {
                return true;
            }
            if (c.p.a.e.a.h.e.d() && Build.VERSION.SDK_INT < 26) {
                return E(context);
            }
            if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
                return F(context);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean n(Context context, @Nullable Intent intent, int i2, JSONObject jSONObject) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65556, null, context, intent, i2, jSONObject)) == null) {
            try {
                if (c.p.a.e.a.h.e.d() && Build.VERSION.SDK_INT < 26 && !E(context)) {
                    c.p.a.e.a.a.f fVar = new c.p.a.e.a.a.f(context);
                    if (fVar.a()) {
                        h(context, intent, i2, jSONObject, new a());
                        return z(context, fVar.b());
                    }
                } else if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26 && !F(context)) {
                    c.p.a.e.a.a.b bVar = new c.p.a.e.a.a.b(context);
                    if (bVar.a()) {
                        h(context, intent, i2, jSONObject, new b());
                        return z(context, bVar.b());
                    }
                }
            } catch (Throwable unused) {
            }
            return false;
        }
        return invokeLLIL.booleanValue;
    }

    public static boolean o(Context context, @Nullable Intent intent, JSONObject jSONObject, int i2, @Nullable c.p.a.e.a.b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65557, null, new Object[]{context, intent, jSONObject, Integer.valueOf(i2), bVar})) == null) {
            if (context != null && jSONObject != null) {
                long optLong = jSONObject.optLong("jump_interval", 0L);
                if (optLong <= 0) {
                    return false;
                }
                SharedPreferences sharedPreferences = context.getSharedPreferences("sp_ah_config", 0);
                if ((System.currentTimeMillis() - sharedPreferences.getLong("last_jump_unknown_source_time", 0L)) / 60000 >= optLong && !l(context)) {
                    sharedPreferences.edit().putLong("last_jump_unknown_source_time", System.currentTimeMillis()).apply();
                    if (jSONObject.optInt("show_unknown_source_dialog", 0) == 1) {
                        Intent intent2 = new Intent(context, JumpUnknownSourceActivity.class);
                        intent2.addFlags(268435456);
                        intent2.putExtra("intent", intent);
                        intent2.putExtra("config", jSONObject.toString());
                        intent2.putExtra("id", i2);
                        try {
                            if (p(context, intent2, false)) {
                                D(i2, jSONObject);
                            }
                            return true;
                        } catch (Throwable th) {
                            if (bVar != null) {
                                bVar.f34700b = 1;
                                bVar.f34701c = "tryShowUnknownSourceDialog" + e(th);
                            }
                            return false;
                        }
                    }
                    if (n(context, intent, i2, jSONObject)) {
                        B(i2, jSONObject);
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean p(Context context, Intent intent, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65558, null, context, intent, z)) == null) {
            if (context == null || intent == null) {
                return false;
            }
            if (z) {
                try {
                    intent.putExtra("start_only_for_android", true);
                    context.startActivity(intent);
                    return true;
                } catch (Throwable unused) {
                    return false;
                }
            }
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return true;
        }
        return invokeLLZ.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean q(Context context, DownloadInfo downloadInfo, Intent intent, JSONObject jSONObject, boolean z) {
        InterceptResult invokeCommon;
        char c2;
        c.p.a.e.a.b b2;
        boolean s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65559, null, new Object[]{context, downloadInfo, intent, jSONObject, Boolean.valueOf(z)})) == null) {
            boolean z2 = false;
            if (jSONObject != null && downloadInfo != null) {
                c.p.a.e.a.b bVar = new c.p.a.e.a.b();
                String optString = jSONObject.optString("type");
                if (!TextUtils.isEmpty(optString)) {
                    c.p.a.e.b.j.a f2 = c.p.a.e.b.j.a.f(downloadInfo);
                    bVar.f34699a = optString;
                    switch (optString.hashCode()) {
                        case -985763637:
                            if (optString.equals("plan_a")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -985763636:
                            if (optString.equals("plan_b")) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -985763635:
                            if (optString.equals("plan_c")) {
                                c2 = 7;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -985763634:
                            if (optString.equals("plan_d")) {
                                c2 = 4;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -985763633:
                            if (optString.equals("plan_e")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -985763632:
                            if (optString.equals("plan_f")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -985763631:
                            if (optString.equals("plan_g")) {
                                c2 = 5;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -985763630:
                            if (optString.equals("plan_h")) {
                                c2 = 6;
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    switch (c2) {
                        case 0:
                        case 1:
                            if (!downloadInfo.isSavePathRedirected()) {
                                bVar.f34700b = downloadInfo.getAntiHijackErrorCode(-1);
                                break;
                            }
                        case 2:
                            b2 = b(jSONObject, f2);
                            if (b2.f34700b == 0) {
                                if (optString.equals("plan_f") && TextUtils.isEmpty(downloadInfo.getDBJsonString("file_content_uri"))) {
                                    bVar.f34700b = downloadInfo.getAntiHijackErrorCode(10);
                                    break;
                                } else {
                                    s = s(context, downloadInfo, jSONObject, bVar);
                                    z2 = s;
                                    break;
                                }
                            }
                            bVar = b2;
                            break;
                        case 3:
                            b2 = b(jSONObject, f2);
                            if (b2.f34700b == 0) {
                                if (!downloadInfo.isSavePathRedirected()) {
                                    bVar.f34700b = downloadInfo.getAntiHijackErrorCode(-1);
                                    break;
                                } else {
                                    s = A(context, downloadInfo, jSONObject, bVar);
                                    z2 = s;
                                    break;
                                }
                            }
                            bVar = b2;
                            break;
                        case 4:
                            bVar.f34699a = "plan_d";
                            if (!c.p.a.e.a.h.e.f()) {
                                bVar.f34700b = 2;
                                break;
                            } else {
                                try {
                                    c.p.a.e.a.d.f(context, intent);
                                    bVar.f34700b = 0;
                                    z2 = true;
                                    break;
                                } catch (Throwable th) {
                                    bVar.f34700b = 4;
                                    bVar.f34701c = th.toString();
                                    break;
                                }
                            }
                        case 5:
                            b2 = v(jSONObject, f2);
                            if (b2.f34700b == 0) {
                                s = t(context, downloadInfo, jSONObject, bVar, f2);
                                z2 = s;
                                break;
                            }
                            bVar = b2;
                            break;
                        case 6:
                            String b3 = c.p.a.e.a.h.d.b(f2.t("bh"), f2.t("s"));
                            c.p.a.e.a.b c3 = c(jSONObject, b3, context, f2);
                            if (c3.f34700b == 0) {
                                String packageName = context.getPackageName();
                                if (c.p.a.e.a.h.b.f(c.p.a.e.b.j.a.o(), context, b3)) {
                                    try {
                                        c.p.a.e.a.d.f(context, intent);
                                        bVar.f34700b = 0;
                                        z2 = true;
                                        break;
                                    } catch (Throwable th2) {
                                        try {
                                            bVar.f34700b = 1;
                                            bVar.f34701c = th2.toString();
                                            break;
                                        } finally {
                                            c.p.a.e.a.h.b.f(c.p.a.e.b.j.a.o(), context, packageName);
                                        }
                                    }
                                } else {
                                    bVar.f34700b = 11;
                                    break;
                                }
                            } else {
                                bVar = c3;
                                break;
                            }
                        case 7:
                            if (Build.VERSION.SDK_INT >= 26 || c.p.a.e.a.h.e.d()) {
                                if ((jSONObject.optInt("enable_for_all", 0) == 1) || z) {
                                    if (!(jSONObject.optInt("show_unknown_source_on_startup") == 1)) {
                                        s = o(context, intent, jSONObject, downloadInfo.getId(), bVar);
                                        z2 = s;
                                        break;
                                    }
                                }
                            }
                            break;
                    }
                    if (z2) {
                        downloadInfo.getTempCacheData().put("ah_attempt", bVar.b());
                    }
                    if (f34704a != null) {
                        downloadInfo.getTempCacheData().put("intent", intent);
                        f34704a.a(downloadInfo, bVar);
                    }
                }
            }
            return z2;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean r(Context context, DownloadInfo downloadInfo, Intent intent, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65560, null, new Object[]{context, downloadInfo, intent, Boolean.valueOf(z)})) == null) {
            JSONArray v = c.p.a.e.b.j.a.d(downloadInfo.getId()).v("ah_plans");
            if (v != null) {
                int length = v.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = v.optJSONObject(i2);
                    if (c.p.a.e.a.h.b.e(optJSONObject) && q(context, downloadInfo, intent, optJSONObject, z)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean s(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, c.p.a.e.a.b bVar) {
        InterceptResult invokeLLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65561, null, context, downloadInfo, jSONObject, bVar)) == null) {
            if (context != null && jSONObject != null) {
                String optString = jSONObject.optString("device_plans");
                bVar.f34703e = optString;
                if (!TextUtils.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    String savePath = downloadInfo.getSavePath();
                    if (TextUtils.isEmpty(savePath)) {
                        return false;
                    }
                    File file = new File(savePath);
                    StringBuilder sb = new StringBuilder();
                    String str = null;
                    int length = split.length;
                    int i2 = 0;
                    while (true) {
                        z = true;
                        if (i2 >= length) {
                            z = false;
                            break;
                        }
                        String str2 = split[i2];
                        c.p.a.e.a.a.a a2 = c.p.a.e.a.a.d.a(context, str2, jSONObject, downloadInfo);
                        if (a2 != null) {
                            Intent b2 = a2.b();
                            if (b2 != null) {
                                if (u(file, downloadInfo, jSONObject)) {
                                    try {
                                        p(context, b2, false);
                                        str = str2;
                                        break;
                                    } catch (Throwable th) {
                                        sb.append(str2);
                                        sb.append(" startActivity failed : ");
                                        sb.append(e(th));
                                        i(bVar, 1);
                                    }
                                } else {
                                    i(bVar, 6);
                                    sb.append(str2);
                                    sb.append(" createDescFile failed! ");
                                }
                            } else {
                                i(bVar, 3);
                                sb.append(str2);
                                sb.append(" resolveActivity failed! ");
                            }
                        }
                        sb.append(GlideException.IndentedAppendable.INDENT);
                        i2++;
                    }
                    if (!z) {
                        bVar.f34701c = sb.toString();
                    } else {
                        bVar.f34702d = str;
                        bVar.f34700b = 0;
                    }
                    return z;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public static boolean t(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull c.p.a.e.a.b bVar, c.p.a.e.b.j.a aVar) {
        InterceptResult invokeLLLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65562, null, context, downloadInfo, jSONObject, bVar, aVar)) == null) {
            String optString = jSONObject.optString("type");
            bVar.f34699a = optString;
            Intent b2 = c.p.a.e.a.a.d.a(context, "vbi", jSONObject, downloadInfo).b();
            StringBuilder sb = new StringBuilder();
            try {
                z = z(context, b2);
            } catch (Throwable th) {
                sb.append(optString);
                sb.append(" startActivity failed : ");
                sb.append(e(th));
                i(bVar, 1);
                z = false;
            }
            if (!z) {
                bVar.f34701c = sb.toString();
            } else {
                bVar.f34700b = 0;
            }
            return true;
        }
        return invokeLLLLL.booleanValue;
    }

    public static boolean u(File file, DownloadInfo downloadInfo, @NonNull JSONObject jSONObject) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65563, null, file, downloadInfo, jSONObject)) == null) {
            if (file == null) {
                return false;
            }
            String path = file.getPath();
            JSONObject u = c.p.a.e.b.j.a.d(downloadInfo.getId()).u("download_dir");
            File file2 = null;
            String optString = u != null ? u.optString("ins_desc") : null;
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString)) {
                file2 = new File(path + File.separator + optString);
            }
            if (file2 != null) {
                try {
                    if (file2.createNewFile()) {
                        file2.deleteOnExit();
                        return true;
                    }
                    return true;
                } catch (IOException unused) {
                    return false;
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static c.p.a.e.a.b v(JSONObject jSONObject, c.p.a.e.b.j.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, jSONObject, aVar)) == null) {
            c.p.a.e.a.b bVar = new c.p.a.e.a.b();
            if (jSONObject == null) {
                return bVar;
            }
            bVar.f34699a = jSONObject.optString("type");
            bVar.f34703e = "vbi";
            if (c.p.a.e.a.a.d.b(c.p.a.e.b.g.e.n(), "vbi", jSONObject, aVar)) {
                bVar.f34700b = 0;
            } else {
                i(bVar, 3);
            }
            return bVar;
        }
        return (c.p.a.e.a.b) invokeLL.objValue;
    }

    public static void w(int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65565, null, i2, jSONObject) == null) {
            int i3 = 1;
            boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
            JSONObject jSONObject2 = new JSONObject();
            if (!z) {
                i3 = 2;
            }
            try {
                jSONObject2.put("scene", i3);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            c.p.a.e.b.g.e.p().a(i2, "guide_auth_dialog_cancel", jSONObject2);
        }
    }

    public static void x(int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65566, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            JSONObject jSONObject = new JSONObject();
            int i3 = 1;
            try {
                jSONObject.put("scene", z ? 1 : 2);
                if (!z2) {
                    i3 = 2;
                }
                jSONObject.put("result_code", i3);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            c.p.a.e.b.g.e.p().a(i2, "guide_auth_result", jSONObject);
        }
    }

    public static boolean z(Context context, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65568, null, context, intent)) == null) ? p(context, intent, true) : invokeLL.booleanValue;
    }
}
