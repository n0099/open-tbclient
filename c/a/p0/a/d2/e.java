package c.a.p0.a.d2;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import c.a.p0.a.g1.g;
import c.a.p0.a.k;
import c.a.p0.a.v2.q0;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f5158a;

    /* renamed from: b  reason: collision with root package name */
    public static long f5159b;

    /* renamed from: c  reason: collision with root package name */
    public static ContentObserver f5160c;

    /* renamed from: d  reason: collision with root package name */
    public static ContentResolver f5161d;

    /* renamed from: e  reason: collision with root package name */
    public static PackageManager f5162e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f5163f;

    /* renamed from: g  reason: collision with root package name */
    public static long f5164g;

    /* renamed from: h  reason: collision with root package name */
    public static List<c.a.p0.a.d2.c> f5165h;

    /* renamed from: i  reason: collision with root package name */
    public static Runnable f5166i;

    /* renamed from: j  reason: collision with root package name */
    public static int f5167j;
    public static Uri k;
    public static String l;
    public static String m;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Handler f5168a;

        /* renamed from: c.a.p0.a.d2.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0147a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Uri f5169e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f5170f;

            public RunnableC0147a(a aVar, Uri uri) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, uri};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5170f = aVar;
                this.f5169e = uri;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    e.q(this.f5170f.f5168a, this.f5169e);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Handler handler, Handler handler2) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler, handler2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Handler) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5168a = handler2;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, uri) == null) {
                super.onChange(z, uri);
                if (e.f5158a) {
                    String str = "onChange(), uri: " + uri;
                }
                ExecutorUtilsExt.postOnElastic(new RunnableC0147a(this, uri), "systemScreenShot", 1);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.z1.b.f.e.g(AppRuntime.getAppContext(), "WRITE_EXTERNAL_STORAGE permission denied").F();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5171e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Handler f5172f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ C0148e f5173g;

        public c(String str, Handler handler, C0148e c0148e) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, handler, c0148e};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5171e = str;
            this.f5172f = handler;
            this.f5173g = c0148e;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e.e();
                if (e.f5158a) {
                    String str = "mCount: " + e.f5167j;
                }
                long j2 = c.a.p0.a.v2.d.a() ? 500L : 100L;
                if (e.m(this.f5171e, e.k) || e.f5167j > 10) {
                    if (e.m(this.f5171e, e.k) && e.l() && !e.o(this.f5171e, e.k)) {
                        for (c.a.p0.a.d2.c cVar : e.f5165h) {
                            if (cVar != null) {
                                cVar.a(this.f5173g);
                            }
                        }
                        return;
                    }
                    return;
                }
                this.f5172f.postDelayed(e.f5166i, j2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static String f5174a;

        /* renamed from: b  reason: collision with root package name */
        public static String[] f5175b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1889009472, "Lc/a/p0/a/d2/e$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1889009472, "Lc/a/p0/a/d2/e$d;");
                    return;
                }
            }
            f5174a = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
            f5175b = new String[]{"_display_name", "_data", "date_added", "_id"};
        }

        public static boolean e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? str != null && (str.toLowerCase().contains(StatisticConstants.SCREENSHOT) || str.contains("截屏") || str.contains("截图")) : invokeL.booleanValue;
        }

        public static boolean f(long j2, long j3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) ? Math.abs(j2 - j3) <= 10 : invokeCommon.booleanValue;
        }
    }

    /* renamed from: c.a.p0.a.d2.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0148e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f5176a;

        /* renamed from: b  reason: collision with root package name */
        public Uri f5177b;

        public /* synthetic */ C0148e(String str, Long l, Uri uri, a aVar) {
            this(str, l, uri);
        }

        public C0148e(String str, Long l, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, l, uri};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5176a = str;
            l.longValue();
            this.f5177b = uri;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(815372608, "Lc/a/p0/a/d2/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(815372608, "Lc/a/p0/a/d2/e;");
                return;
            }
        }
        f5158a = k.f7077a;
        f5164g = System.currentTimeMillis() - 10000;
        f5165h = new ArrayList();
        f5167j = 0;
        l = null;
        m = null;
    }

    public static /* synthetic */ int e() {
        int i2 = f5167j;
        f5167j = i2 + 1;
        return i2;
    }

    public static double i(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, uri)) == null) {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(f5161d, uri);
                if (bitmap == null) {
                    return 0.0d;
                }
                int height = bitmap.getHeight();
                int width = bitmap.getWidth();
                if (width != 0) {
                    return height / (width * 1.0d);
                }
                return 0.0d;
            } catch (Exception unused) {
                return 0.0d;
            }
        }
        return invokeL.doubleValue;
    }

    public static int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            boolean hasPermanentMenuKey = ViewConfiguration.get(AppRuntime.getAppContext()).hasPermanentMenuKey();
            boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
            if (hasPermanentMenuKey || deviceHasKey) {
                return 0;
            }
            Resources resources = AppRuntime.getAppContext().getResources();
            return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
        }
        return invokeV.intValue;
    }

    public static boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (!c.a.p0.a.v2.d.a()) {
                return TextUtils.isEmpty(str) || TextUtils.equals(m, str);
            }
            Uri uri = k;
            return uri == null || TextUtils.equals(l, uri.toString());
        }
        return invokeL.booleanValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return g.a().b() && System.currentTimeMillis() - f5159b > 2000;
        }
        return invokeV.booleanValue;
    }

    public static boolean m(String str, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, str, uri)) == null) {
            if (c.a.p0.a.v2.d.a()) {
                return n(uri);
            }
            new BitmapFactory.Options().inJustDecodeBounds = true;
            return BitmapFactory.decodeFile(str) != null;
        }
        return invokeLL.booleanValue;
    }

    public static boolean n(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, uri)) == null) {
            if (uri == null) {
                return false;
            }
            try {
                return MediaStore.Images.Media.getBitmap(f5161d, uri) != null;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean o(String str, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, uri)) == null) {
            Point point = new Point();
            WindowManager windowManager = (WindowManager) AppRuntime.getAppContext().getSystemService("window");
            if (windowManager.getDefaultDisplay() != null) {
                windowManager.getDefaultDisplay().getSize(point);
            }
            int j2 = point.y + j();
            int i2 = point.x;
            double d2 = (i2 != 0 ? j2 / (i2 * 1.0d) : 0.0d) * 1.2d;
            double i3 = c.a.p0.a.v2.d.a() ? i(uri) : 0.0d;
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i4 = options.outHeight;
            int i5 = options.outWidth;
            if (i5 != 0) {
                i3 = i4 / (i5 * 1.0d);
            }
            return i3 > d2;
        }
        return invokeLL.booleanValue;
    }

    public static boolean p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) ? Build.VERSION.SDK_INT < 23 || c.a.p0.o.a.b.a.a(context, "android.permission.READ_EXTERNAL_STORAGE") == 0 : invokeL.booleanValue;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0145: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:44:0x0145 */
    public static void q(Handler handler, Uri uri) {
        Cursor cursor;
        Closeable closeable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, handler, uri) == null) {
            if (uri.toString().matches(d.f5174a + ".*")) {
                if (t() && f5163f) {
                    f5164g = System.currentTimeMillis();
                    return;
                }
                f5167j = 0;
                f5164g = System.currentTimeMillis();
                Closeable closeable2 = null;
                try {
                    try {
                        cursor = f5161d.query(uri, d.f5175b, null, null, "date_added DESC");
                        if (cursor != null) {
                            try {
                                if (cursor.moveToFirst()) {
                                    String string = cursor.getString(cursor.getColumnIndex("_data"));
                                    long j2 = cursor.getLong(cursor.getColumnIndex("date_added"));
                                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                                    k = uri;
                                    if (c.a.p0.a.v2.d.a()) {
                                        k = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, cursor.getInt(cursor.getColumnIndex("_id")));
                                    }
                                    if (f5158a) {
                                        String str = "imagepath: " + string;
                                        String str2 = "dateAdded: " + j2;
                                        String str3 = "nowSecs: " + currentTimeMillis;
                                        String str4 = "imageUri: " + k.toString();
                                    }
                                    if (k(string)) {
                                        c.a.p0.t.d.d(cursor);
                                        return;
                                    }
                                    l = k.toString();
                                    m = string;
                                    if (d.e(string) && d.f(currentTimeMillis, j2)) {
                                        f5163f = true;
                                        c cVar = new c(string, handler, new C0148e(string, Long.valueOf(j2), k, null));
                                        f5166i = cVar;
                                        handler.post(cVar);
                                    } else {
                                        f5163f = false;
                                    }
                                }
                            } catch (RuntimeException unused) {
                                if (f5162e != null) {
                                    List<ProviderInfo> queryContentProviders = f5162e.queryContentProviders(null, 0, 131072);
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("from", "SystemScreenshot");
                                    hashMap.put("page", "SystemScreenshot");
                                    hashMap.put("ext", queryContentProviders.toString());
                                    c.a.p0.a.j2.b.j("460", hashMap);
                                }
                                c.a.p0.t.d.d(cursor);
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        closeable2 = closeable;
                        c.a.p0.t.d.d(closeable2);
                        throw th;
                    }
                } catch (RuntimeException unused2) {
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                    c.a.p0.t.d.d(closeable2);
                    throw th;
                }
                c.a.p0.t.d.d(cursor);
            }
        }
    }

    public static void r(c.a.p0.a.d2.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, null, cVar) == null) || cVar == null) {
            return;
        }
        f5165h.add(cVar);
    }

    public static void s(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, context) == null) {
            f5162e = context.getPackageManager();
            Handler handler = new Handler(Looper.getMainLooper());
            f5161d = context.getContentResolver();
            f5160c = new a(handler, handler);
            if (p(context)) {
                f5161d.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, f5160c);
            } else if (f5158a && q0.G()) {
                q0.b0(new b());
            }
        }
    }

    public static boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? System.currentTimeMillis() - f5164g <= 1000 : invokeV.booleanValue;
    }

    public static void u(c.a.p0.a.d2.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65557, null, cVar) == null) || cVar == null) {
            return;
        }
        f5165h.remove(cVar);
    }
}
