package c.a.q0.d1;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class g0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f12928g;

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f12929h;

    /* renamed from: i  reason: collision with root package name */
    public static final String[] f12930i;

    /* renamed from: j  reason: collision with root package name */
    public static Point f12931j;
    public static final List<String> k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f12932a;

    /* renamed from: b  reason: collision with root package name */
    public b f12933b;

    /* renamed from: c  reason: collision with root package name */
    public long f12934c;

    /* renamed from: d  reason: collision with root package name */
    public a f12935d;

    /* renamed from: e  reason: collision with root package name */
    public a f12936e;

    /* renamed from: f  reason: collision with root package name */
    public final Handler f12937f;

    /* loaded from: classes3.dex */
    public class a extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Uri f12938a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g0 f12939b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g0 g0Var, Uri uri, Handler handler) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g0Var, uri, handler};
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
            this.f12939b = g0Var;
            this.f12938a = uri;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                super.onChange(z);
                this.f12939b.f(this.f12938a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onShot(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1214548346, "Lc/a/q0/d1/g0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1214548346, "Lc/a/q0/d1/g0;");
                return;
            }
        }
        f12928g = new String[]{"_data", "datetaken"};
        f12929h = new String[]{"_data", "datetaken", "width", "height"};
        f12930i = new String[]{StatisticConstants.SCREENSHOT, "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap"};
        k = new ArrayList();
    }

    public g0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f12937f = new Handler(Looper.getMainLooper());
        this.f12932a = context;
        if (f12931j == null) {
            Point e2 = e();
            f12931j = e2;
            if (e2 != null) {
                BdLog.d("ScreenShotListenManager: Screen Real Size: " + f12931j.x + " * " + f12931j.y);
                return;
            }
            BdLog.d("ScreenShotListenManager: Get screen real size failed.");
        }
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? Looper.myLooper() == Looper.getMainLooper() : invokeV.booleanValue;
    }

    public final boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (k.contains(str)) {
                BdLog.d("ScreenShotListenManager: ScreenShot: imgPath has done; imagePath = " + str);
                return true;
            }
            if (k.size() >= 20) {
                for (int i2 = 0; i2 < 5; i2++) {
                    k.remove(0);
                }
            }
            k.add(str);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean c(String str, long j2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (j2 >= this.f12934c && System.currentTimeMillis() - j2 <= 10000) {
                Point point = f12931j;
                if (point != null && (i2 > point.x || i3 > point.y)) {
                    Point point2 = f12931j;
                    if (i3 > point2.x || i2 > point2.y) {
                        return false;
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                String lowerCase = str.toLowerCase();
                for (String str2 : f12930i) {
                    if (lowerCase.contains(str2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final Point d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            return new Point(options.outWidth, options.outHeight);
        }
        return (Point) invokeL.objValue;
    }

    public final Point e() {
        InterceptResult invokeV;
        Exception e2;
        Point point;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!h() || this.f12932a == null) {
                return null;
            }
            try {
                point = new Point();
            } catch (Exception e3) {
                e2 = e3;
                point = null;
            }
            try {
                Display defaultDisplay = ((WindowManager) this.f12932a.getSystemService("window")).getDefaultDisplay();
                if (Build.VERSION.SDK_INT >= 17) {
                    defaultDisplay.getRealSize(point);
                } else {
                    try {
                        point.set(((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue(), ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue());
                    } catch (Exception e4) {
                        point.set(defaultDisplay.getWidth(), defaultDisplay.getHeight());
                        BdLog.e(e4);
                    }
                }
            } catch (Exception e5) {
                e2 = e5;
                BdLog.e(e2);
                return point;
            }
            return point;
        }
        return (Point) invokeV.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, IF, INVOKE] complete} */
    public final void f(Uri uri) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, uri) == null) {
            Cursor cursor = null;
            try {
                try {
                    cursor = this.f12932a.getContentResolver().query(uri, Build.VERSION.SDK_INT < 16 ? f12928g : f12929h, null, null, "date_added desc limit 1");
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (0 == 0 || cursor.isClosed()) {
                        return;
                    }
                }
                if (cursor == null) {
                    if (cursor == null || cursor.isClosed()) {
                        return;
                    }
                    cursor.close();
                } else if (!cursor.moveToFirst()) {
                    if (cursor == null || cursor.isClosed()) {
                        return;
                    }
                    cursor.close();
                } else {
                    int columnIndex = cursor.getColumnIndex("_data");
                    int columnIndex2 = cursor.getColumnIndex("datetaken");
                    int i5 = -1;
                    if (Build.VERSION.SDK_INT >= 16) {
                        i5 = cursor.getColumnIndex("width");
                        i2 = cursor.getColumnIndex("height");
                    } else {
                        i2 = -1;
                    }
                    String string = cursor.getString(columnIndex);
                    long j2 = cursor.getLong(columnIndex2);
                    if (i5 >= 0 && i2 >= 0) {
                        i4 = cursor.getInt(i5);
                        i3 = cursor.getInt(i2);
                    } else {
                        Point d2 = d(string);
                        int i6 = d2.x;
                        i3 = d2.y;
                        i4 = i6;
                    }
                    g(string, j2, i4, i3);
                    if (cursor == null || cursor.isClosed()) {
                        return;
                    }
                    cursor.close();
                }
            } catch (Throwable th) {
                if (0 != 0 && !cursor.isClosed()) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    public final void g(String str, long j2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            if (c(str, j2, i2, i3)) {
                BdLog.d("ScreenShotListenManager: ScreenShot: path = " + str + "; size = " + i2 + " * " + i3 + "; date = " + j2);
                if (this.f12933b == null || b(str)) {
                    return;
                }
                this.f12933b.onShot(str);
                return;
            }
            BdLog.d("ScreenShotListenManager: Media content changed, but not screenshot: path = " + str + "; size = " + i2 + " * " + i3 + "; date = " + j2);
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f12933b = bVar;
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && h() && PermissionUtil.isAgreePrivacyPolicy()) {
            this.f12934c = System.currentTimeMillis();
            this.f12935d = new a(this, MediaStore.Images.Media.INTERNAL_CONTENT_URI, this.f12937f);
            this.f12936e = new a(this, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, this.f12937f);
            if (Build.VERSION.SDK_INT >= 29) {
                this.f12932a.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, true, this.f12935d);
                this.f12932a.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.f12936e);
                return;
            }
            this.f12932a.getContentResolver().registerContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, false, this.f12935d);
            this.f12932a.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, this.f12936e);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && h()) {
            if (this.f12935d != null) {
                try {
                    this.f12932a.getContentResolver().unregisterContentObserver(this.f12935d);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.f12935d = null;
            }
            if (this.f12936e != null) {
                try {
                    this.f12932a.getContentResolver().unregisterContentObserver(this.f12936e);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                this.f12936e = null;
            }
            this.f12934c = 0L;
            this.f12933b = null;
        }
    }
}
