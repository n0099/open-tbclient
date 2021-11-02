package b.a.p0.a.i1.e;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.e0.d;
import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.davemorrissey.labs.subscaleview.ImageSource;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f6094i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Uri f6095a;

    /* renamed from: b  reason: collision with root package name */
    public final Bitmap f6096b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f6097c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6098d;

    /* renamed from: e  reason: collision with root package name */
    public int f6099e;

    /* renamed from: f  reason: collision with root package name */
    public int f6100f;

    /* renamed from: g  reason: collision with root package name */
    public Rect f6101g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6102h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1781491180, "Lb/a/p0/a/i1/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1781491180, "Lb/a/p0/a/i1/e/b;");
                return;
            }
        }
        f6094i = k.f6397a;
    }

    public b(Bitmap bitmap, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f6096b = bitmap;
        this.f6095a = null;
        this.f6097c = null;
        this.f6098d = false;
        this.f6099e = bitmap.getWidth();
        this.f6100f = bitmap.getHeight();
        this.f6102h = z;
    }

    public static b a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str == null) {
                if (!f6094i) {
                    d.h("ImageSource", "asset name is null");
                    return null;
                }
                throw new NullPointerException("Asset name must not be null");
            }
            return o("file:///android_asset/" + str);
        }
        return (b) invokeL.objValue;
    }

    public static b b(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bitmap)) == null) {
            if (bitmap == null) {
                if (!f6094i) {
                    d.h("ImageSource", "bitmap is null");
                    return null;
                }
                throw new NullPointerException("Bitmap must not be null");
            }
            return new b(bitmap, true);
        }
        return (b) invokeL.objValue;
    }

    public static b k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) ? new b(i2) : (b) invokeI.objValue;
    }

    public static b o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (str == null) {
                if (!f6094i) {
                    d.h("ImageSource", "uri is null");
                    return null;
                }
                throw new NullPointerException("Uri must not be null");
            }
            if (!str.contains("://")) {
                if (str.startsWith("/")) {
                    str = str.substring(1);
                }
                str = ImageSource.FILE_SCHEME + str;
            }
            return new b(Uri.parse(str));
        }
        return (b) invokeL.objValue;
    }

    public final Bitmap c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f6096b : (Bitmap) invokeV.objValue;
    }

    public final Integer d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f6097c : (Integer) invokeV.objValue;
    }

    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f6100f : invokeV.intValue;
    }

    public final Rect f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f6101g : (Rect) invokeV.objValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f6099e : invokeV.intValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f6098d : invokeV.booleanValue;
    }

    public final Uri i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f6095a : (Uri) invokeV.objValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f6102h : invokeV.booleanValue;
    }

    public b l(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            this.f6098d = z;
            return this;
        }
        return (b) invokeZ.objValue;
    }

    public b m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            l(false);
            return this;
        }
        return (b) invokeV.objValue;
    }

    public b n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            l(true);
            return this;
        }
        return (b) invokeV.objValue;
    }

    public b(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        String uri2 = uri.toString();
        if (uri2.startsWith(ImageSource.FILE_SCHEME) && !new File(uri2.substring(7)).exists()) {
            try {
                uri = Uri.parse(URLDecoder.decode(uri2, "UTF-8"));
            } catch (UnsupportedEncodingException unused) {
            }
        }
        this.f6096b = null;
        this.f6095a = uri;
        this.f6097c = null;
        this.f6098d = true;
    }

    public b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6096b = null;
        this.f6095a = null;
        this.f6097c = Integer.valueOf(i2);
        this.f6098d = true;
    }
}
