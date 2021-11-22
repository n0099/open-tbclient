package b.a.p0.a.z2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
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
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
/* loaded from: classes.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f9865a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f9866e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9867f;

        public a(b bVar, String str) {
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
            this.f9866e = bVar;
            this.f9867f = str;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
        public void onCancellation(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
                super.onCancellation(dataSource);
                this.f9866e.a(this.f9867f, null);
            }
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSource) == null) {
                this.f9866e.a(this.f9867f, null);
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
                        this.f9866e.a(this.f9867f, copy);
                        return;
                    } catch (Exception e2) {
                        if (t.f9865a) {
                            e2.getMessage();
                        }
                        this.f9866e.a(this.f9867f, null);
                        return;
                    }
                }
                this.f9866e.a(this.f9867f, null);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(String str, Bitmap bitmap);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1341249160, "Lb/a/p0/a/z2/t;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1341249160, "Lb/a/p0/a/z2/t;");
                return;
            }
        }
        f9865a = b.a.p0.a.k.f6863a;
    }

    public static Bitmap b(DataSource<CloseableReference<CloseableImage>> dataSource) {
        InterceptResult invokeL;
        CloseableReference<CloseableImage> closeableReference;
        Throwable th;
        Bitmap underlyingBitmap;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, dataSource)) != null) {
            return (Bitmap) invokeL.objValue;
        }
        if (dataSource == null) {
            return null;
        }
        try {
            closeableReference = dataSource.getResult();
            if (closeableReference != null) {
                try {
                    CloseableImage closeableImage = closeableReference.get();
                    if (closeableImage != null && (closeableImage instanceof CloseableBitmap) && (underlyingBitmap = ((CloseableBitmap) closeableImage).getUnderlyingBitmap()) != null && !underlyingBitmap.isRecycled()) {
                        try {
                            Bitmap createBitmap = Bitmap.createBitmap(underlyingBitmap);
                            dataSource.close();
                            CloseableReference.closeSafely(closeableReference);
                            return createBitmap;
                        } catch (OutOfMemoryError unused) {
                            System.gc();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    dataSource.close();
                    CloseableReference.closeSafely(closeableReference);
                    throw th;
                }
            }
            dataSource.close();
            CloseableReference.closeSafely(closeableReference);
            return null;
        } catch (Throwable th3) {
            closeableReference = null;
            th = th3;
        }
    }

    public static Bitmap c(Uri uri, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, uri, context)) == null) {
            if (uri != null && context != null) {
                if (d(uri)) {
                    if (f9865a) {
                        String str = "start get Bitmap from memory, uri : " + uri.toString();
                    }
                    return b(Fresco.getImagePipeline().fetchImageFromBitmapCache(ImageRequest.fromUri(uri), context.getApplicationContext()));
                }
                if (f9865a) {
                    String str2 = "start get Bitmap from sdcard, uri : " + uri.toString();
                }
                DataSource<Boolean> isInDiskCache = Fresco.getImagePipeline().isInDiskCache(uri);
                if (isInDiskCache != null && isInDiskCache.hasResult() && isInDiskCache.getResult() != null && isInDiskCache.getResult().booleanValue()) {
                    try {
                        return b(Fresco.getImagePipeline().fetchDecodedImage(ImageRequest.fromUri(uri), context));
                    } finally {
                        isInDiskCache.close();
                    }
                }
            }
            return null;
        }
        return (Bitmap) invokeLL.objValue;
    }

    public static boolean d(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, uri)) == null) ? uri != null && Fresco.getImagePipeline().isInBitmapMemoryCache(uri) : invokeL.booleanValue;
    }

    public static void e(String str, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, bVar) == null) {
            Uri C = q0.C(str);
            if (C == null) {
                bVar.a(str, null);
                return;
            }
            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(C).build(), AppRuntime.getAppContext()).subscribe(new a(bVar, str), UiThreadImmediateExecutorService.getInstance());
        }
    }

    public static void f(Uri uri, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, uri, str) == null) || uri == null) {
            return;
        }
        if (f9865a) {
            String str2 = "start preFetch into memory, uri : " + uri.toString();
        }
        Fresco.getImagePipeline().prefetchToBitmapCache(ImageRequestBuilder.newBuilderWithSource(uri).build(), str);
    }

    public static Bitmap g(Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65543, null, bitmap, i2, i3)) == null) {
            if (bitmap == null || i2 <= 0 || i3 <= 0) {
                return null;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width == 0 || height == 0) {
                return null;
            }
            Matrix matrix = new Matrix();
            matrix.postScale(i2 / width, i3 / height);
            try {
                return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            } catch (Exception | OutOfMemoryError unused) {
                return null;
            }
        }
        return (Bitmap) invokeLII.objValue;
    }
}
