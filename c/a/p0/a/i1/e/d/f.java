package c.a.p0.a.i1.e.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
/* loaded from: classes.dex */
public class f implements d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f6783c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BitmapRegionDecoder f6784a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f6785b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(681906042, "Lc/a/p0/a/i1/e/d/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(681906042, "Lc/a/p0/a/i1/e/d/f;");
                return;
            }
        }
        f6783c = k.f7085a;
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6785b = new Object();
    }

    @Override // c.a.p0.a.i1.e.d.d
    public Point a(Context context, Bitmap bitmap) throws Exception {
        InputStream inputStream;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048576, this, context, bitmap)) != null) {
            return (Point) invokeLL.objValue;
        }
        try {
            inputStream = b(bitmap);
            try {
                this.f6784a = BitmapRegionDecoder.newInstance(inputStream, false);
                c.a.p0.t.d.d(inputStream);
                return new Point(this.f6784a.getWidth(), this.f6784a.getHeight());
            } catch (Throwable th) {
                th = th;
                c.a.p0.t.d.d(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    public InputStream b(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap)) == null) {
            if (bitmap == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
            if (bitmap.hasAlpha()) {
                compressFormat = Bitmap.CompressFormat.PNG;
            }
            bitmap.compress(compressFormat, 100, byteArrayOutputStream);
            return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        }
        return (InputStream) invokeL.objValue;
    }

    @Override // c.a.p0.a.i1.e.d.d
    public Bitmap decodeRegion(Rect rect, int i2) {
        InterceptResult invokeLI;
        Bitmap decodeRegion;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, rect, i2)) == null) {
            synchronized (this.f6785b) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = i2;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                decodeRegion = this.f6784a.decodeRegion(rect, options);
                if (decodeRegion == null) {
                    if (!f6783c) {
                        c.a.p0.a.e0.d.h("SkiaImageRegionDecoder", "bitmap is null");
                    } else {
                        throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
                    }
                }
            }
            return decodeRegion;
        }
        return (Bitmap) invokeLI.objValue;
    }

    @Override // c.a.p0.a.i1.e.d.d
    public Point init(Context context, Uri uri) throws Exception {
        InterceptResult invokeLL;
        Resources resourcesForApplication;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, uri)) == null) {
            String uri2 = uri.toString();
            if (uri2.startsWith("android.resource://")) {
                String authority = uri.getAuthority();
                if (context.getPackageName().equals(authority)) {
                    resourcesForApplication = context.getResources();
                } else {
                    resourcesForApplication = context.getPackageManager().getResourcesForApplication(authority);
                }
                List<String> pathSegments = uri.getPathSegments();
                int size = pathSegments.size();
                if (size == 2 && pathSegments.get(0).equals("drawable")) {
                    i2 = resourcesForApplication.getIdentifier(pathSegments.get(1), "drawable", authority);
                } else {
                    if (size == 1 && TextUtils.isDigitsOnly(pathSegments.get(0))) {
                        try {
                            i2 = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException e2) {
                            e2.printStackTrace();
                        }
                    }
                    i2 = 0;
                }
                this.f6784a = BitmapRegionDecoder.newInstance(context.getResources().openRawResource(i2), false);
            } else if (uri2.startsWith("file:///android_asset/")) {
                this.f6784a = BitmapRegionDecoder.newInstance(context.getAssets().open(uri2.substring(22), 1), false);
            } else if (uri2.startsWith("file://")) {
                this.f6784a = BitmapRegionDecoder.newInstance(uri2.substring(7), false);
            } else {
                InputStream inputStream = null;
                try {
                    inputStream = context.getContentResolver().openInputStream(uri);
                    this.f6784a = BitmapRegionDecoder.newInstance(inputStream, false);
                } finally {
                    c.a.p0.t.d.d(inputStream);
                }
            }
            return new Point(this.f6784a.getWidth(), this.f6784a.getHeight());
        }
        return (Point) invokeLL.objValue;
    }

    @Override // c.a.p0.a.i1.e.d.d
    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            BitmapRegionDecoder bitmapRegionDecoder = this.f6784a;
            return (bitmapRegionDecoder == null || bitmapRegionDecoder.isRecycled()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.a.i1.e.d.d
    public void recycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f6784a.recycle();
        }
    }
}
