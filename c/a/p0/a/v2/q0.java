package c.a.p0.a.v2;

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
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import androidx.annotation.AnyThread;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.h0.g.k;
import c.a.p0.a.v2.t;
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
    public static final boolean f9390a;

    /* renamed from: b  reason: collision with root package name */
    public static Handler f9391b;

    /* renamed from: c  reason: collision with root package name */
    public static String f9392c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageView f9393e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f9394f;

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
            this.f9393e = imageView;
            this.f9394f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f9393e.setImageResource(this.f9394f);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements c.a.p0.d.i.a<Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageView f9395a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f9396b;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f9397e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f9398f;

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
                this.f9398f = bVar;
                this.f9397e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f9398f.f9395a.setImageBitmap(this.f9397e);
                }
            }
        }

        /* renamed from: c.a.p0.a.v2.q0$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0439b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f9399e;

            public RunnableC0439b(b bVar) {
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
                this.f9399e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b bVar = this.f9399e;
                    bVar.f9395a.setImageResource(bVar.f9396b);
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
            this.f9395a = imageView;
            this.f9396b = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.d.i.a
        /* renamed from: a */
        public void run(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) {
                if (bitmap != null) {
                    if (Looper.getMainLooper() == Looper.myLooper()) {
                        this.f9395a.setImageBitmap(bitmap);
                        return;
                    } else {
                        q0.b0(new a(this, bitmap));
                        return;
                    }
                }
                q0.b0(new RunnableC0439b(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements t.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.d.i.a f9400a;

        public c(c.a.p0.d.i.a aVar) {
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
            this.f9400a = aVar;
        }

        @Override // c.a.p0.a.v2.t.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                this.f9400a.run(bitmap);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t.b f9401a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f9402b;

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
            this.f9401a = bVar;
            this.f9402b = str;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
        public void onCancellation(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
                super.onCancellation(dataSource);
                this.f9401a.a(this.f9402b, null);
            }
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSource) == null) {
                this.f9401a.a(this.f9402b, null);
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
                        this.f9401a.a(this.f9402b, copy);
                        return;
                    } catch (Exception unused) {
                        this.f9401a.a(this.f9402b, null);
                        return;
                    }
                }
                this.f9401a.a(this.f9402b, null);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f9403e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Intent f9404f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f9405g;

        public e(Context context, Intent intent, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, intent, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9403e = context;
            this.f9404f = intent;
            this.f9405g = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                boolean g2 = c.a.p0.a.v2.f.g(this.f9403e, this.f9404f);
                g gVar = this.f9405g;
                if (gVar != null) {
                    gVar.a(g2);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class f implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f9406e;

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
            this.f9406e = gVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            g gVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) || (gVar = this.f9406e) == null) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(22083040, "Lc/a/p0/a/v2/q0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(22083040, "Lc/a/p0/a/v2/q0;");
                return;
            }
        }
        f9390a = c.a.p0.a.k.f7085a;
        f9391b = new Handler(Looper.getMainLooper());
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
            c.a.p0.a.h0.g.f J = c.a.p0.a.g1.f.V().J();
            if (J != null) {
                return J.e3();
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
                Application b2 = c.a.p0.a.c1.a.b();
                return b2.getPackageManager().getPackageInfo(b2.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean E(String str) {
        InterceptResult invokeL;
        SwanAppConfigData F;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            c.a.p0.a.a2.d g2 = c.a.p0.a.a2.d.g();
            if (g2.C() && (F = g2.r().F()) != null && F.m() && !TextUtils.isEmpty(str)) {
                return F.q(str);
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
                    if (f9390a) {
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
            c.a.p0.a.p.d.x0 m = c.a.p0.a.c1.a.m();
            return TextUtils.equals(m.getAppName(), m.getSchemeHeader());
        }
        return invokeV.booleanValue;
    }

    public static boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? I(c.a.p0.a.g1.f.V().U()) : invokeV.booleanValue;
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
                boolean z = f9390a;
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean K(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            if (a0.j(context, "android.permission.ACCESS_FINE_LOCATION")) {
                try {
                    LocationManager locationManager = (LocationManager) context.getApplicationContext().getSystemService("location");
                    if (locationManager != null) {
                        return locationManager.isProviderEnabled("gps");
                    }
                } catch (Exception e2) {
                    if (f9390a) {
                        e2.printStackTrace();
                    }
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? Build.VERSION.SDK_INT < 23 || AppRuntime.getAppContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 : invokeV.booleanValue;
    }

    public static boolean M(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) ? NotificationManagerCompat.from(context).areNotificationsEnabled() : invokeL.booleanValue;
    }

    public static boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? Looper.getMainLooper().getThread() == Thread.currentThread() : invokeV.booleanValue;
    }

    public static boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            if (c.a.p0.a.a2.e.Q() == null) {
                return false;
            }
            PMSAppInfo f0 = c.a.p0.a.a2.e.Q().L().f0();
            return (f0 == null ? PMSConstants.PayProtected.NO_PAY_PROTECTED.type : f0.payProtected) == PMSConstants.PayProtected.PAY_PROTECTED.type;
        }
        return invokeV.booleanValue;
    }

    public static boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            if (c.a.p0.a.a2.e.Q() == null) {
                return false;
            }
            PMSAppInfo f0 = c.a.p0.a.a2.e.Q().L().f0();
            return (f0 == null ? PMSConstants.CustomerService.NO_CUSTOMER_SERVICE.type : f0.customerService) == PMSConstants.CustomerService.CUSTOMER_SERVICE.type;
        }
        return invokeV.booleanValue;
    }

    public static boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? j.e() : invokeV.booleanValue;
    }

    @SuppressLint({"PrivateApi"})
    public static boolean R(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, activity)) == null) {
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
                boolean z4 = f9390a;
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean S(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager != null) {
                return wifiManager.isWifiEnabled();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean T(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                Intent parseUri = Intent.parseUri(Uri.decode(str), 1);
                parseUri.setFlags(268435456);
                if (parseUri.resolveActivityInfo(context.getPackageManager(), 65536) != null) {
                    c.a.p0.a.v2.f.g(context, parseUri);
                    return true;
                }
                return false;
            } catch (URISyntaxException e2) {
                if (f9390a) {
                    Log.getStackTraceString(e2);
                    return false;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @AnyThread
    public static void U(@NonNull ImageView imageView, @Nullable String str, @DrawableRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65557, null, imageView, str, i2) == null) {
            if (TextUtils.isEmpty(str)) {
                b0(new a(imageView, i2));
                return;
            }
            b bVar = new b(imageView, i2);
            bVar.run(k(str, str, false, new c(bVar)));
        }
    }

    public static void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, null) == null) {
            boolean z = f9390a;
            SwanAppActivity activity = c.a.p0.a.g1.f.V().getActivity();
            if (activity != null) {
                Bundle bundle = new Bundle();
                bundle.putString("bundle_key_preload_preload_scene", "2");
                activity.preloadNextSwanAppProcess(bundle);
                c.a.p0.a.h0.t.a.l(activity);
            }
        }
    }

    public static boolean W(Context context, String str, g gVar) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65559, null, context, str, gVar)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                try {
                    Intent parseUri = Intent.parseUri(str, 1);
                    parseUri.setFlags(268435456);
                    PackageManager packageManager = context.getPackageManager();
                    ResolveInfo resolveActivity = packageManager.resolveActivity(parseUri, 65536);
                    if (resolveActivity != null && resolveActivity.activityInfo != null) {
                        String charSequence = resolveActivity.match != 0 ? resolveActivity.activityInfo.applicationInfo.loadLabel(packageManager).toString() : "其他应用";
                        if (TextUtils.isEmpty(charSequence)) {
                            str2 = "";
                        } else {
                            str2 = context.getResources().getString(c.a.p0.a.h.swanapp_open_app_dialog_tips1) + charSequence;
                        }
                        String str3 = context.getResources().getString(c.a.p0.a.h.swanapp_open_app_dialog_tips) + packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString() + str2;
                        String string = context.getString(c.a.p0.a.h.aiapps_confirm);
                        String string2 = context.getString(c.a.p0.a.h.aiapps_cancel);
                        SwanAppAlertDialog.a aVar = new SwanAppAlertDialog.a(context);
                        aVar.f(true);
                        aVar.x(str3);
                        aVar.n(new c.a.p0.a.w2.h.a());
                        aVar.m(false);
                        aVar.P(string, new e(context, parseUri, gVar));
                        aVar.C(string2, new f(gVar));
                        aVar.X();
                        return true;
                    }
                    return false;
                } catch (PackageManager.NameNotFoundException | URISyntaxException e2) {
                    if (f9390a) {
                        e2.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static void X(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, runnable) == null) {
            Y(runnable, 0L);
        }
    }

    public static void Y(Runnable runnable, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65561, null, runnable, j2) == null) {
            f9391b.postDelayed(runnable, j2);
        }
    }

    public static int Z(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65562, null, activity)) != null) {
            return invokeL.intValue;
        }
        if (f9390a) {
            String str = "releaseFixedOrientation() called with: activity = [" + activity + PreferencesUtil.RIGHT_MOUNT;
        }
        int i2 = -1;
        if (Build.VERSION.SDK_INT != 26 || activity.getApplicationInfo().targetSdkVersion <= 26 || !R(activity) || !J(activity)) {
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
                    if (f9390a) {
                        String str2 = "set " + activity.getComponentName() + " screenOrientation to UNSPECIFIED";
                    }
                } catch (IllegalAccessException | NoSuchFieldException unused) {
                    i2 = i3;
                    boolean z = f9390a;
                    return i2;
                }
            }
            return i3;
        } catch (IllegalAccessException | NoSuchFieldException unused2) {
        }
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
            if (f9390a) {
                String str5 = "buildPageUrl pageUrl: " + str4;
            }
            if (TextUtils.isEmpty(str3)) {
                return o0.w(str4);
            }
            Uri v = o0.v(str4);
            if (v == null) {
                return o0.w(str4);
            }
            if (f9390a) {
                String str6 = "buildPageUrl pageUrl: " + str4 + str3;
            }
            return v.buildUpon().query(str3).build().toString();
        }
        return (String) invokeLLL.objValue;
    }

    public static void a0(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, runnable) == null) {
            f9391b.removeCallbacks(runnable);
        }
    }

    public static boolean b(SwanAppConfigData swanAppConfigData, c.a.p0.a.l1.b bVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65565, null, swanAppConfigData, bVar, z)) == null) {
            if (swanAppConfigData == null || bVar == null) {
                return false;
            }
            if (c.a.p0.a.t1.b.a.e(bVar.h())) {
                return true;
            }
            if (f9390a) {
                String str = "checkPageParam pageParam : " + bVar.f7244e;
                String str2 = "checkPageParam pageRouteParam : " + bVar.f7247h;
                String str3 = "checkPageParam allowTab : " + z;
            }
            return z ? swanAppConfigData.o(bVar.f7247h) || swanAppConfigData.q(bVar.f7247h) : swanAppConfigData.o(bVar.f7247h) && !swanAppConfigData.q(bVar.f7247h);
        }
        return invokeLLZ.booleanValue;
    }

    public static void b0(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, runnable) == null) {
            c0(runnable, 0L);
        }
    }

    public static boolean c(SwanAppConfigData swanAppConfigData, c.a.p0.a.l1.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65567, null, swanAppConfigData, bVar)) == null) ? swanAppConfigData != null && swanAppConfigData.m() && swanAppConfigData.q(bVar.f7247h) : invokeLL.booleanValue;
    }

    public static void c0(Runnable runnable, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65568, null, runnable, j2) == null) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                f9391b.postDelayed(runnable, j2);
            } else {
                runnable.run();
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, null) == null) {
            k.d M2 = c.a.p0.a.h0.g.k.M2("https://baozhang.baidu.com/guarantee/m/#/swan-guarantee");
            M2.a(false);
            M2.b();
        }
    }

    public static void d0(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, null, runnable) == null) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                f9391b.postAtFrontOfQueue(runnable);
            } else {
                runnable.run();
            }
        }
    }

    public static boolean e(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65571, null, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return false;
            }
            if (f9390a) {
                String str2 = "downloadParams is " + str;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (TextUtils.isEmpty(jSONObject.optString("url"))) {
                    return false;
                }
                return c.a.p0.a.c1.a.c().d(context, jSONObject);
            } catch (JSONException e2) {
                if (f9390a) {
                    e2.printStackTrace();
                    return false;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Nullable
    public static String f(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, str)) == null) {
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

    public static void g(Activity activity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65573, null, activity, i2) == null) {
            if (f9390a) {
                String str = "fixedOrientation() called with: activity = [" + activity + "], orientation = [" + i2 + PreferencesUtil.RIGHT_MOUNT;
            }
            if (i2 == -1 || Build.VERSION.SDK_INT != 26 || activity.getApplicationInfo().targetSdkVersion <= 26 || !R(activity) || J(activity)) {
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
                    if (f9390a) {
                        String str2 = "set " + activity.getComponentName() + " screenOrientation to " + i2;
                    }
                }
            } catch (IllegalAccessException | NoSuchFieldException unused) {
                boolean z = f9390a;
            }
        }
    }

    public static String h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65574, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                boolean z = f9390a;
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
                if (f9390a) {
                    Log.getStackTraceString(e2);
                }
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static Bitmap i(c.a.p0.a.f1.e.b bVar, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65575, null, bVar, str, z)) == null) {
            return j((bVar == null || TextUtils.isEmpty(bVar.Q())) ? "" : bVar.Q(), str, z);
        }
        return (Bitmap) invokeLLZ.objValue;
    }

    public static Bitmap j(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65576, null, str, str2, z)) == null) ? k(str, str2, z, null) : (Bitmap) invokeLLZ.objValue;
    }

    public static Bitmap k(String str, String str2, boolean z, t.b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65577, null, new Object[]{str, str2, Boolean.valueOf(z), bVar})) == null) {
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
            return BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), z ? c.a.p0.a.e.aiapps_default_icon : c.a.p0.a.e.aiapps_default_grey_icon);
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public static synchronized String l(Context context) {
        InterceptResult invokeL;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, context)) == null) {
            synchronized (q0.class) {
                try {
                    string = context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
                } catch (Exception e2) {
                    if (f9390a) {
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

    public static AbsoluteLayout m(String str) {
        InterceptResult invokeL;
        c.a.p0.a.p.e.c t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, str)) == null) {
            c.a.p0.a.p.e.d B = c.a.p0.a.g1.f.V().B(str);
            if (B == null || (t = B.t()) == null) {
                return null;
            }
            return t.getCurrentWebView();
        }
        return (AbsoluteLayout) invokeL.objValue;
    }

    public static c.a.p0.a.l1.b n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) {
            c.a.p0.a.l1.b bVar = new c.a.p0.a.l1.b();
            bVar.f7245f = "";
            bVar.f7244e = "";
            c.a.p0.a.h0.g.g W = c.a.p0.a.g1.f.V().W();
            return (W == null || W.o() == null) ? bVar : W.o().X2();
        }
        return (c.a.p0.a.l1.b) invokeV.objValue;
    }

    public static int o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, str)) == null) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e2) {
                if (f9390a) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) {
            c.a.p0.a.a2.e Q = c.a.p0.a.a2.e.Q();
            if (Q == null) {
                return null;
            }
            String e0 = Q.L().e0();
            if (TextUtils.isEmpty(e0)) {
                return c.a.p0.a.g1.f.V().f();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) ? f9391b : (Handler) invokeV.objValue;
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String r() {
        InterceptResult invokeV;
        TelephonyManager telephonyManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                boolean z = f9390a;
                return "";
            } else if (!TextUtils.isEmpty(f9392c)) {
                boolean z2 = f9390a;
                return f9392c;
            } else {
                Application b2 = c.a.p0.a.c1.a.b();
                if (ContextCompat.checkSelfPermission(b2, "android.permission.READ_PHONE_STATE") != 0) {
                    return "";
                }
                String str = null;
                try {
                    telephonyManager = (TelephonyManager) b2.getSystemService("phone");
                } catch (Exception unused) {
                }
                if (telephonyManager == null) {
                    return "";
                }
                str = telephonyManager.getDeviceId();
                if (!TextUtils.isEmpty(str)) {
                    f9392c = str;
                    return str;
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    String imei = telephonyManager.getImei();
                    if (!TextUtils.isEmpty(imei)) {
                        f9392c = imei;
                        return imei;
                    }
                    str = telephonyManager.getMeid();
                    f9392c = str;
                }
                return TextUtils.isEmpty(str) ? "" : str;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String s(@NonNull File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, file)) == null) {
            String s = c.a.p0.t.d.s(file.getPath());
            if (TextUtils.isEmpty(s)) {
                return "*/*";
            }
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(s);
            return !TextUtils.isEmpty(mimeTypeFromExtension) ? mimeTypeFromExtension : "*/*";
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public static PackageInfo t(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65586, null, context, str)) == null) {
            if (context != null) {
                try {
                    return context.getPackageManager().getPackageInfo(str, 64);
                } catch (PackageManager.NameNotFoundException e2) {
                    if (f9390a) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65587, null, context, str)) == null) {
            PackageInfo t = t(context, str);
            if (t != null) {
                return t.versionName;
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static c.a.p0.a.l1.b v() {
        InterceptResult invokeV;
        c.a.p0.a.l1.b c3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65588, null)) == null) {
            c.a.p0.a.l1.b bVar = new c.a.p0.a.l1.b();
            bVar.f7245f = "";
            bVar.f7244e = "";
            c.a.p0.a.h0.g.g W = c.a.p0.a.g1.f.V().W();
            return (W == null || W.o() == null || (c3 = W.o().c3()) == null) ? bVar : c3;
        }
        return (c.a.p0.a.l1.b) invokeV.objValue;
    }

    public static String w(c.a.p0.a.a2.e eVar, String str) {
        InterceptResult invokeLL;
        File x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65589, null, eVar, str)) == null) {
            if (eVar == null || TextUtils.isEmpty(str) || (x = x(eVar)) == null) {
                return null;
            }
            if (str.startsWith(File.separator)) {
                return new File(x, str).getPath();
            }
            String U = c.a.p0.a.g1.f.V().U();
            if (TextUtils.isEmpty(U)) {
                return null;
            }
            File parentFile = new File(U).getParentFile();
            if (parentFile == null || TextUtils.isEmpty(parentFile.getPath())) {
                parentFile = new File(File.separator);
            }
            try {
                return new File(x, new File(parentFile, str).getCanonicalPath()).getPath();
            } catch (IOException e2) {
                if (f9390a) {
                    Log.getStackTraceString(e2);
                }
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static File x(c.a.p0.a.a2.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65590, null, eVar)) == null) {
            if (eVar == null) {
                return null;
            }
            String appId = eVar.getAppId();
            String u1 = eVar.L().u1();
            File g2 = c.a.p0.a.a1.e.g();
            return new File(g2, appId + File.separator + u1);
        }
        return (File) invokeL.objValue;
    }

    public static String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65591, null)) == null) ? z(Integer.MAX_VALUE) : (String) invokeV.objValue;
    }

    @Nullable
    public static String z(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65592, null, i2)) == null) {
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
