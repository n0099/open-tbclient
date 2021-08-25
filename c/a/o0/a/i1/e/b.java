package c.a.o0.a.i1.e;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.e0.d;
import c.a.o0.a.k;
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
    public static final boolean f6736i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Uri f6737a;

    /* renamed from: b  reason: collision with root package name */
    public final Bitmap f6738b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f6739c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6740d;

    /* renamed from: e  reason: collision with root package name */
    public int f6741e;

    /* renamed from: f  reason: collision with root package name */
    public int f6742f;

    /* renamed from: g  reason: collision with root package name */
    public Rect f6743g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6744h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1873859220, "Lc/a/o0/a/i1/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1873859220, "Lc/a/o0/a/i1/e/b;");
                return;
            }
        }
        f6736i = k.f7049a;
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
        this.f6738b = bitmap;
        this.f6737a = null;
        this.f6739c = null;
        this.f6740d = false;
        this.f6741e = bitmap.getWidth();
        this.f6742f = bitmap.getHeight();
        this.f6744h = z;
    }

    public static b a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str == null) {
                if (!f6736i) {
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
                if (!f6736i) {
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
                if (!f6736i) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f6738b : (Bitmap) invokeV.objValue;
    }

    public final Integer d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f6739c : (Integer) invokeV.objValue;
    }

    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f6742f : invokeV.intValue;
    }

    public final Rect f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f6743g : (Rect) invokeV.objValue;
    }

    public final int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f6741e : invokeV.intValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f6740d : invokeV.booleanValue;
    }

    public final Uri i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f6737a : (Uri) invokeV.objValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f6744h : invokeV.booleanValue;
    }

    public b l(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z)) == null) {
            this.f6740d = z;
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
        this.f6738b = null;
        this.f6737a = uri;
        this.f6739c = null;
        this.f6740d = true;
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
        this.f6738b = null;
        this.f6737a = null;
        this.f6739c = Integer.valueOf(i2);
        this.f6740d = true;
    }
}
