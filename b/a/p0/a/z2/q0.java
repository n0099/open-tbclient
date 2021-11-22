package b.a.p0.a.z2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.LocationManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import androidx.annotation.AnyThread;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h0.g.l;
import b.a.p0.a.p.d.c1;
import b.a.p0.a.z2.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class q0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f9833a;

    /* renamed from: b  reason: collision with root package name */
    public static Handler f9834b;

    /* renamed from: c  reason: collision with root package name */
    public static String f9835c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageView f9836e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f9837f;

        public a(ImageView imageView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9836e = imageView;
            this.f9837f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9836e.setImageResource(this.f9837f);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements b.a.p0.d.i.a<Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageView f9838a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f9839b;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f9840e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f9841f;

            public a(b bVar, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9841f = bVar;
                this.f9840e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f9841f.f9838a.setImageBitmap(this.f9840e);
                }
            }
        }

        /* renamed from: b.a.p0.a.z2.q0$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0505b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f9842e;

            public RunnableC0505b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9842e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.f9842e;
                    bVar.f9838a.setImageResource(bVar.f9839b);
                }
            }
        }

        public b(ImageView imageView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9838a = imageView;
            this.f9839b = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.d.i.a
        /* renamed from: a */
        public void run(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) {
                if (bitmap != null) {
                    if (Looper.getMainLooper() == Looper.myLooper()) {
                        this.f9838a.setImageBitmap(bitmap);
                        return;
                    } else {
                        q0.e0(new a(this, bitmap));
                        return;
                    }
                }
                q0.e0(new RunnableC0505b(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements t.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.d.i.a f9843a;

        public c(b.a.p0.d.i.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9843a = aVar;
        }

        @Override // b.a.p0.a.z2.t.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                this.f9843a.run(bitmap);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t.b f9844e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9845f;

        public d(t.b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9844e = bVar;
            this.f9845f = str;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
        public void onCancellation(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
                super.onCancellation(dataSource);
                this.f9844e.a(this.f9845f, null);
            }
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSource) == null) {
                this.f9844e.a(this.f9845f, null);
            }
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(Bitmap bitmap) {
            Bitmap copy;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    try {
                        if (bitmap.getConfig() == null) {
                            copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                        } else {
                            copy = bitmap.copy(bitmap.getConfig(), true);
                        }
                        this.f9844e.a(this.f9845f, copy);
                        return;
                    } catch (Exception unused) {
                        this.f9844e.a(this.f9845f, null);
                        return;
                    }
                }
                this.f9844e.a(this.f9845f, null);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f9846e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Intent f9847f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f9848g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f9849h;

        public e(Context context, Intent intent, String str, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, intent, str, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9846e = context;
            this.f9847f = intent;
            this.f9848g = str;
            this.f9849h = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                boolean b2 = b.a.p0.a.c1.a.a().b(this.f9846e, this.f9847f, b.a.p0.a.d2.d.J().r().N(), this.f9848g, null);
                g gVar = this.f9849h;
                if (gVar != null) {
                    gVar.a(b2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class f implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f9850e;

        public f(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9850e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            g gVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) || (gVar = this.f9850e) == null) {
                return;
            }
            gVar.onCancel();
        }
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(boolean z);

        void onCancel();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1370952165, "Lb/a/p0/a/z2/q0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1370952165, "Lb/a/p0/a/z2/q0;");
                return;
            }
        }
        f9833a = b.a.p0.a.k.f6863a;
        f9834b = new Handler(Looper.getMainLooper());
    }

    public static Uri A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str) || !str.startsWith("tel:")) {
                return null;
            }
            return Uri.parse(str);
        }
        return (Uri) invokeL.objValue;
    }

    public static String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            b.a.p0.a.h0.g.f H = b.a.p0.a.g1.f.U().H();
            if (H != null) {
                return H.q3();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static Uri C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("http://") && !str.startsWith("https://") && !str.startsWith("file://") && !str.startsWith("res:/")) {
                if (str.startsWith("/")) {
                    return Uri.fromFile(new File(str));
                }
                return null;
            }
            return Uri.parse(str);
        }
        return (Uri) invokeL.objValue;
    }

    public static String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                Application c2 = b.a.p0.a.c1.a.c();
                return c2.getPackageManager().getPackageInfo(c2.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean E(String str) {
        InterceptResult invokeL;
        SwanAppConfigData P;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            b.a.p0.a.d2.d J = b.a.p0.a.d2.d.J();
            if (J.D() && (P = J.r().P()) != null && P.n() && !TextUtils.isEmpty(str)) {
                return P.r(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean F(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                try {
                    if (context.getPackageManager().getPackageInfo(str, 0) != null) {
                        return true;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    if (f9833a) {
                        String str2 = str + " is not found";
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            c1 n = b.a.p0.a.c1.a.n();
            return TextUtils.equals(n.getAppName(), n.getSchemeHeader());
        }
        return invokeV.booleanValue;
    }

    public static boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? I(b.a.p0.a.g1.f.U().T()) : invokeV.booleanValue;
    }

    public static boolean I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? !TextUtils.isEmpty(str) && TextUtils.equals(str, p()) : invokeL.booleanValue;
    }

    public static boolean J(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, activity)) == null) {
            try {
                Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(activity);
                Method declaredMethod = ActivityInfo.class.getDeclaredMethod("isFixedOrientation", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((Boolean) declaredMethod.invoke(obj, new Object[0])).booleanValue();
            } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException unused) {
                boolean z = f9833a;
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean K(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return ((LocationManager) context.getSystemService("location")).isLocationEnabled();
            }
            try {
                return Settings.Secure.getInt(context.getContentResolver(), "location_mode") != 0;
            } catch (Settings.SettingNotFoundException e2) {
                if (f9833a) {
                    Log.getStackTraceString(e2);
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean L(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            if (a0.j(context, "android.permission.ACCESS_FINE_LOCATION")) {
                try {
                    LocationManager locationManager = (LocationManager) context.getApplicationContext().getSystemService("location");
                    if (locationManager != null) {
                        return locationManager.isProviderEnabled("gps");
                    }
                } catch (Exception e2) {
                    if (f9833a) {
                        e2.printStackTrace();
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? Build.VERSION.SDK_INT < 23 || AppRuntime.getAppContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 : invokeV.booleanValue;
    }

    public static boolean N(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) ? NotificationManagerCompat.from(context).areNotificationsEnabled() : invokeL.booleanValue;
    }

    public static boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? Looper.getMainLooper().getThread() == Thread.currentThread() : invokeV.booleanValue;
    }

    public static boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            if (b.a.p0.a.d2.e.a0() == null) {
                return false;
            }
            PMSAppInfo f0 = b.a.p0.a.d2.e.a0().V().f0();
            return (f0 == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : f0.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type;
        }
        return invokeV.booleanValue;
    }

    public static boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            if (b.a.p0.a.d2.e.a0() == null) {
                return false;
            }
            PMSAppInfo f0 = b.a.p0.a.d2.e.a0().V().f0();
            return (f0 == null ? PMSConstants.CustomerService.NO_CUSTOMER_SERVICE.type : f0.customerService) == PMSConstants.CustomerService.CUSTOMER_SERVICE.type;
        }
        return invokeV.booleanValue;
    }

    public static boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? j.g() : invokeV.booleanValue;
    }

    public static boolean S(@NonNull b.a.p0.a.p.e.b<?> bVar, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, bVar, str)) == null) {
            int S = bVar.S();
            if (f9833a) {
                String str2 = "slave type - " + S;
                String str3 = "page viewModel type - " + str;
            }
            boolean z = false;
            if (S == 0) {
                z = !TextUtils.equals(str, "na");
            } else if (S == 1) {
                z = TextUtils.equals(str, "na");
            }
            if (f9833a) {
                String str4 = "accept - " + z;
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static boolean T(@StringRes int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65556, null, i2)) == null) {
            Application c2 = b.a.p0.a.c1.a.c();
            if (c2 == null) {
                return false;
            }
            String str = c2.getString(b.a.p0.a.h.swan_app_teen_mode_tips) + StringUtils.LF + c2.getString(i2);
            if (b.a.p0.a.c1.a.y0().d()) {
                b.a.p0.a.c2.b.f.e g2 = b.a.p0.a.c2.b.f.e.g(c2, str);
                g2.l(4);
                g2.F();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @SuppressLint({"PrivateApi"})
    public static boolean U(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, activity)) == null) {
            try {
                Class<?> cls = Class.forName("com.android.internal.R$styleable");
                Field declaredField = cls.getDeclaredField("Window");
                declaredField.setAccessible(true);
                TypedArray obtainStyledAttributes = activity.obtainStyledAttributes((int[]) declaredField.get(null));
                Field declaredField2 = cls.getDeclaredField("Window_windowIsTranslucent");
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("Window_windowSwipeToDismiss");
                declaredField3.setAccessible(true);
                Field declaredField4 = cls.getDeclaredField("Window_windowIsFloating");
                declaredField4.setAccessible(true);
                boolean z = obtainStyledAttributes.getBoolean(((Integer) declaredField2.get(null)).intValue(), false);
                boolean z2 = !obtainStyledAttributes.hasValue(((Integer) declaredField2.get(null)).intValue()) && obtainStyledAttributes.getBoolean(((Integer) declaredField3.get(null)).intValue(), false);
                boolean z3 = obtainStyledAttributes.getBoolean(((Integer) declaredField4.get(null)).intValue(), false);
                obtainStyledAttributes.recycle();
                return z3 || z || z2;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
                boolean z4 = f9833a;
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean V(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager != null) {
                return wifiManager.isWifiEnabled();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean W(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                String decode = Uri.decode(str);
                try {
                    Intent parseUri = Intent.parseUri(decode, 1);
                    parseUri.setFlags(268435456);
                    if (parseUri.resolveActivityInfo(context.getPackageManager(), 65536) != null && b.a.p0.a.c1.a.a().d()) {
                        return b.a.p0.a.c1.a.a().b(context, parseUri, b.a.p0.a.d2.d.J().r().N(), decode, null);
                    }
                } catch (URISyntaxException e2) {
                    if (f9833a) {
                        Log.getStackTraceString(e2);
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @AnyThread
    public static void X(@NonNull ImageView imageView, @Nullable String str, @DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65560, null, imageView, str, i2) == null) {
            if (TextUtils.isEmpty(str)) {
                e0(new a(imageView, i2));
                return;
            }
            b bVar = new b(imageView, i2);
            bVar.run(k(str, str, false, new c(bVar)));
        }
    }

    public static void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, null) == null) {
            boolean z = f9833a;
            SwanAppActivity activity = b.a.p0.a.g1.f.U().getActivity();
            if (activity != null) {
                Bundle bundle = new Bundle();
                bundle.putString("bundle_key_preload_preload_scene", "2");
                activity.preloadNextSwanAppProcess(bundle);
                b.a.p0.a.h0.t.a.n(activity);
            }
        }
    }

    public static boolean Z(Context context, String str, g gVar) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65562, null, context, str, gVar)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                try {
                    Intent parseUri = Intent.parseUri(str, 1);
                    parseUri.setFlags(268435456);
                    PackageManager packageManager = context.getPackageManager();
                    ResolveInfo resolveActivity = packageManager.resolveActivity(parseUri, 65536);
                    if (resolveActivity != null && resolveActivity.activityInfo != null && b.a.p0.a.c1.a.a().d()) {
                        String charSequence = resolveActivity.match != 0 ? resolveActivity.activityInfo.applicationInfo.loadLabel(packageManager).toString() : "其他应用";
                        if (TextUtils.isEmpty(charSequence)) {
                            str2 = "";
                        } else {
                            str2 = context.getResources().getString(b.a.p0.a.h.swanapp_open_app_dialog_tips1) + charSequence;
                        }
                        String str3 = context.getResources().getString(b.a.p0.a.h.swanapp_open_app_dialog_tips) + packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString() + str2;
                        String string = context.getString(b.a.p0.a.h.aiapps_confirm);
                        String string2 = context.getString(b.a.p0.a.h.aiapps_cancel);
                        SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(context);
                        aVar.f(true);
                        aVar.x(str3);
                        aVar.n(new b.a.p0.a.a3.h.a());
                        aVar.m(false);
                        aVar.P(string, new e(context, parseUri, str, gVar));
                        aVar.C(string2, new f(gVar));
                        aVar.X();
                        return true;
                    }
                    return false;
                } catch (PackageManager.NameNotFoundException | URISyntaxException e2) {
                    if (f9833a) {
                        e2.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @NonNull
    public static String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65563, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return "";
            }
            if (!str.endsWith(File.separator)) {
                str = str + File.separator;
            }
            String str4 = str + str2 + DownloadDataConstants.DEFAULT_DL_HTML_EXTENSION;
            if (f9833a) {
                String str5 = "buildPageUrl pageUrl: " + str4;
            }
            if (TextUtils.isEmpty(str3)) {
                return o0.w(str4);
            }
            Uri v = o0.v(str4);
            if (v == null) {
                return o0.w(str4);
            }
            if (f9833a) {
                String str6 = "buildPageUrl pageUrl: " + str4 + str3;
            }
            return v.buildUpon().query(str3).build().toString();
        }
        return (String) invokeLLL.objValue;
    }

    public static void a0(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, runnable) == null) {
            b0(runnable, 0L);
        }
    }

    public static boolean b(SwanAppConfigData swanAppConfigData, b.a.p0.a.m1.b bVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65565, null, swanAppConfigData, bVar, z)) == null) {
            if (swanAppConfigData == null || bVar == null) {
                return false;
            }
            if (b.a.p0.a.w1.c.a.k(bVar.f())) {
                return true;
            }
            if (f9833a) {
                String str = "checkPageParam pageParam : " + bVar.f7014e;
                String str2 = "checkPageParam pageRouteParam : " + bVar.f7017h;
                String str3 = "checkPageParam allowTab : " + z;
            }
            return z ? swanAppConfigData.p(bVar.f7017h) || swanAppConfigData.r(bVar.f7017h) : swanAppConfigData.p(bVar.f7017h) && !swanAppConfigData.r(bVar.f7017h);
        }
        return invokeLLZ.booleanValue;
    }

    public static void b0(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65566, null, runnable, j) == null) {
            f9834b.postDelayed(runnable, j);
        }
    }

    public static boolean c(SwanAppConfigData swanAppConfigData, b.a.p0.a.m1.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65567, null, swanAppConfigData, bVar)) == null) ? swanAppConfigData != null && swanAppConfigData.n() && swanAppConfigData.r(bVar.f7017h) : invokeLL.booleanValue;
    }

    public static int c0(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65568, null, activity)) != null) {
            return invokeL.intValue;
        }
        if (f9833a) {
            String str = "releaseFixedOrientation() called with: activity = [" + activity + PreferencesUtil.RIGHT_MOUNT;
        }
        int i2 = -1;
        if (Build.VERSION.SDK_INT != 26 || activity.getApplicationInfo().targetSdkVersion <= 26 || !U(activity) || !J(activity)) {
            return -1;
        }
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(activity);
            Field declaredField2 = ActivityInfo.class.getDeclaredField("screenOrientation");
            declaredField2.setAccessible(true);
            int i3 = declaredField2.getInt(obj);
            if (i3 != -1) {
                try {
                    declaredField2.setInt(obj, -1);
                    if (f9833a) {
                        String str2 = "set " + activity.getComponentName() + " screenOrientation to UNSPECIFIED";
                    }
                } catch (IllegalAccessException | NoSuchFieldException unused) {
                    i2 = i3;
                    boolean z = f9833a;
                    return i2;
                }
            }
            return i3;
        } catch (IllegalAccessException | NoSuchFieldException unused2) {
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, null) == null) {
            l.d Y2 = b.a.p0.a.h0.g.l.Y2("https://baozhang.baidu.com/guarantee/m/#/swan-guarantee");
            Y2.a(false);
            Y2.b();
        }
    }

    public static void d0(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, null, runnable) == null) {
            f9834b.removeCallbacks(runnable);
        }
    }

    public static boolean e(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65571, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return false;
            }
            if (f9833a) {
                String str2 = "downloadParams is " + str;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (TextUtils.isEmpty(jSONObject.optString("url"))) {
                    return false;
                }
                return b.a.p0.a.c1.a.d().f(context, jSONObject);
            } catch (JSONException e2) {
                if (f9833a) {
                    e2.printStackTrace();
                    return false;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void e0(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65572, null, runnable) == null) {
            f0(runnable, 0L);
        }
    }

    @Nullable
    public static String f(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt <= 31 || charAt >= 127) {
                    stringBuffer.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                } else {
                    stringBuffer.append(charAt);
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void f0(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65574, null, runnable, j) == null) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                f9834b.postDelayed(runnable, j);
            } else {
                runnable.run();
            }
        }
    }

    public static void g(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65575, null, activity, i2) == null) {
            if (f9833a) {
                String str = "fixedOrientation() called with: activity = [" + activity + "], orientation = [" + i2 + PreferencesUtil.RIGHT_MOUNT;
            }
            if (i2 == -1 || Build.VERSION.SDK_INT != 26 || activity.getApplicationInfo().targetSdkVersion <= 26 || !U(activity) || J(activity)) {
                return;
            }
            try {
                Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(activity);
                Field declaredField2 = ActivityInfo.class.getDeclaredField("screenOrientation");
                declaredField2.setAccessible(true);
                if (declaredField2.getInt(obj) == -1) {
                    declaredField2.setInt(obj, i2);
                    if (f9833a) {
                        String str2 = "set " + activity.getComponentName() + " screenOrientation to " + i2;
                    }
                }
            } catch (IllegalAccessException | NoSuchFieldException unused) {
                boolean z = f9833a;
            }
        }
    }

    public static void g0(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65576, null, runnable) == null) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                f9834b.postAtFrontOfQueue(runnable);
            } else {
                runnable.run();
            }
        }
    }

    public static String h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65577, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                boolean z = f9833a;
                return null;
            }
            StringBuilder sb = new StringBuilder(SchemeConfig.getSchemeHead());
            sb.append("://v26/swan/openApp?upgrade=0");
            try {
                JSONObject jSONObject = new JSONObject();
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                jSONObject.put("open", str);
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                jSONObject.put("download", str2);
                sb.append("&params=");
                sb.append(URLEncoder.encode(jSONObject.toString(), "utf-8"));
            } catch (UnsupportedEncodingException | JSONException e2) {
                if (f9833a) {
                    Log.getStackTraceString(e2);
                }
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static Bitmap i(b.a.p0.a.f1.e.b bVar, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65578, null, bVar, str, z)) == null) {
            return j((bVar == null || TextUtils.isEmpty(bVar.Q())) ? "" : bVar.Q(), str, z);
        }
        return (Bitmap) invokeLLZ.objValue;
    }

    public static Bitmap j(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65579, null, str, str2, z)) == null) ? k(str, str2, z, null) : (Bitmap) invokeLLZ.objValue;
    }

    public static Bitmap k(String str, String str2, boolean z, t.b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65580, null, new Object[]{str, str2, Boolean.valueOf(z), bVar})) == null) {
            Uri C = C(str);
            if (t.d(C)) {
                return t.c(C, AppRuntime.getAppContext());
            }
            if (C != null) {
                if (bVar != null) {
                    Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(C).build(), AppRuntime.getAppContext()).subscribe(new d(bVar, str), UiThreadImmediateExecutorService.getInstance());
                } else {
                    t.f(C, str2);
                }
            }
            return BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), z ? b.a.p0.a.e.aiapps_default_icon : b.a.p0.a.e.aiapps_default_grey_icon);
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static synchronized String l(Context context) {
        InterceptResult invokeL;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, context)) == null) {
            synchronized (q0.class) {
                try {
                    string = context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
                } catch (Exception e2) {
                    if (f9833a) {
                        e2.toString();
                        return "";
                    }
                    return "";
                }
            }
            return string;
        }
        return (String) invokeL.objValue;
    }

    public static View m(String str) {
        InterceptResult invokeL;
        b.a.p0.a.p.e.c t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, str)) == null) {
            b.a.p0.a.p.e.d A = b.a.p0.a.g1.f.U().A(str);
            if (A == null || (t = A.t()) == null) {
                return null;
            }
            return t.getCurrentWebView();
        }
        return (View) invokeL.objValue;
    }

    public static b.a.p0.a.m1.b n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) {
            b.a.p0.a.m1.b bVar = new b.a.p0.a.m1.b();
            bVar.f7015f = "";
            bVar.f7014e = "";
            b.a.p0.a.h0.g.g V = b.a.p0.a.g1.f.U().V();
            return (V == null || V.o() == null) ? bVar : V.o().j3();
        }
        return (b.a.p0.a.m1.b) invokeV.objValue;
    }

    public static int o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, str)) == null) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e2) {
                if (f9833a) {
                    e2.printStackTrace();
                }
                return -1;
            }
        }
        return invokeL.intValue;
    }

    @Nullable
    public static String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) {
            b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
            if (a0 == null) {
                return null;
            }
            String e0 = a0.V().e0();
            if (TextUtils.isEmpty(e0)) {
                return b.a.p0.a.g1.f.U().f();
            }
            int lastIndexOf = e0.lastIndexOf("?");
            if (lastIndexOf > 0) {
                e0 = e0.substring(0, lastIndexOf);
            }
            return e0.startsWith(File.separator) ? e0.substring(1) : e0;
        }
        return (String) invokeV.objValue;
    }

    public static Handler q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65586, null)) == null) ? f9834b : (Handler) invokeV.objValue;
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65587, null)) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                boolean z = f9833a;
                return "";
            } else if (!TextUtils.isEmpty(f9835c)) {
                boolean z2 = f9833a;
                return f9835c;
            } else {
                Application c2 = b.a.p0.a.c1.a.c();
                if (ContextCompat.checkSelfPermission(c2, "android.permission.READ_PHONE_STATE") != 0) {
                    return "";
                }
                String str = null;
                if (c2.getSystemService("phone") == null) {
                    return "";
                }
                str = b.a.p0.f.a.b.c.f10262b.getDeviceId(c2);
                if (!TextUtils.isEmpty(str)) {
                    f9835c = str;
                    return str;
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    String d2 = b.a.p0.f.a.b.c.f10262b.d(c2);
                    if (!TextUtils.isEmpty(d2)) {
                        f9835c = d2;
                        return d2;
                    }
                    str = b.a.p0.f.a.b.c.f10262b.c(c2);
                    f9835c = str;
                }
                return TextUtils.isEmpty(str) ? "" : str;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String s(@NonNull File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, null, file)) == null) {
            String t = b.a.p0.w.d.t(file.getPath());
            if (TextUtils.isEmpty(t)) {
                return "*/*";
            }
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(t);
            return !TextUtils.isEmpty(mimeTypeFromExtension) ? mimeTypeFromExtension : "*/*";
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public static PackageInfo t(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65589, null, context, str)) == null) {
            if (context != null) {
                try {
                    return context.getPackageManager().getPackageInfo(str, 64);
                } catch (PackageManager.NameNotFoundException e2) {
                    if (f9833a) {
                        e2.getMessage();
                        return null;
                    }
                    return null;
                }
            }
            return null;
        }
        return (PackageInfo) invokeLL.objValue;
    }

    public static String u(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65590, null, context, str)) == null) {
            PackageInfo t = t(context, str);
            if (t != null) {
                return t.versionName;
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static b.a.p0.a.m1.b v() {
        InterceptResult invokeV;
        b.a.p0.a.m1.b o3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65591, null)) == null) {
            b.a.p0.a.m1.b bVar = new b.a.p0.a.m1.b();
            bVar.f7015f = "";
            bVar.f7014e = "";
            b.a.p0.a.h0.g.g V = b.a.p0.a.g1.f.U().V();
            return (V == null || V.o() == null || (o3 = V.o().o3()) == null) ? bVar : o3;
        }
        return (b.a.p0.a.m1.b) invokeV.objValue;
    }

    public static String w(b.a.p0.a.d2.e eVar, String str) {
        InterceptResult invokeLL;
        File x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65592, null, eVar, str)) == null) {
            if (eVar == null || TextUtils.isEmpty(str) || (x = x(eVar)) == null) {
                return null;
            }
            if (str.startsWith(File.separator)) {
                return new File(x, str).getPath();
            }
            String T = b.a.p0.a.g1.f.U().T();
            if (TextUtils.isEmpty(T)) {
                return null;
            }
            File parentFile = new File(T).getParentFile();
            if (parentFile == null || TextUtils.isEmpty(parentFile.getPath())) {
                parentFile = new File(File.separator);
            }
            try {
                return new File(x, new File(parentFile, str).getCanonicalPath()).getPath();
            } catch (IOException e2) {
                if (f9833a) {
                    Log.getStackTraceString(e2);
                }
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static File x(b.a.p0.a.d2.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65593, null, eVar)) == null) {
            if (eVar == null) {
                return null;
            }
            String appId = eVar.getAppId();
            String v1 = eVar.V().v1();
            File g2 = b.a.p0.a.a1.d.g();
            return new File(g2, appId + File.separator + v1);
        }
        return (File) invokeL.objValue;
    }

    public static String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65594, null)) == null) ? z(Integer.MAX_VALUE) : (String) invokeV.objValue;
    }

    @Nullable
    public static String z(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65595, null, i2)) == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace == null || stackTrace.length <= 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            int i3 = 0;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (i3 >= i2) {
                    break;
                }
                if (stackTraceElement != null) {
                    sb.append(stackTraceElement.toString());
                    sb.append(StringUtils.LF);
                    i3++;
                }
            }
            return sb.toString();
        }
        return (String) invokeI.objValue;
    }
}
