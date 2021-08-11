package c.a.n0.a.v2;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.FileNotFoundException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class h0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static BitmapFactory.Options a(Uri uri) {
        InterceptResult invokeL;
        InputStream openInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, uri)) == null) {
            Context appContext = AppRuntime.getAppContext();
            InputStream inputStream = null;
            if (appContext == null || uri == null) {
                return null;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            try {
                try {
                    openInputStream = appContext.getContentResolver().openInputStream(uri);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e2) {
                e = e2;
            }
            try {
                BitmapFactory.decodeStream(openInputStream, null, options);
                c.a.n0.t.d.d(openInputStream);
            } catch (FileNotFoundException e3) {
                e = e3;
                inputStream = openInputStream;
                e.printStackTrace();
                c.a.n0.t.d.d(inputStream);
                return options;
            } catch (Throwable th2) {
                th = th2;
                inputStream = openInputStream;
                c.a.n0.t.d.d(inputStream);
                throw th;
            }
            return options;
        }
        return (BitmapFactory.Options) invokeL.objValue;
    }

    public static boolean b(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, uri)) == null) {
            BitmapFactory.Options a2 = a(uri);
            if (a2 != null) {
                String str = a2.outMimeType;
                return !TextUtils.isEmpty(str) && str.equalsIgnoreCase("image/gif");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return b(o0.p(str));
        }
        return invokeL.booleanValue;
    }

    public static boolean d(int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            if (z) {
                return false;
            }
            float f2 = i2;
            if (f2 > 100.0f) {
                float f3 = i3;
                if (f3 > 100.0f) {
                    float f4 = f2 / f3;
                    return f4 > 2.5f || 1.0f / f4 > 2.5f;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean e(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, uri)) == null) {
            BitmapFactory.Options a2 = a(uri);
            return a2 != null && d(a2.outWidth, a2.outHeight, b(uri));
        }
        return invokeL.booleanValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return e(o0.p(str));
        }
        return invokeL.booleanValue;
    }
}
