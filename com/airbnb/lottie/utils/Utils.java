package com.airbnb.lottie.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.L;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;
/* loaded from: classes4.dex */
public final class Utils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float INV_SQRT_2;
    public static final int SECOND_IN_NANOS = 1000000000;
    public static float dpScale;
    public static final ThreadLocal<PathMeasure> threadLocalPathMeasure;
    public static final ThreadLocal<float[]> threadLocalPoints;
    public static final ThreadLocal<Path> threadLocalTempPath;
    public static final ThreadLocal<Path> threadLocalTempPath2;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1486194543, "Lcom/airbnb/lottie/utils/Utils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1486194543, "Lcom/airbnb/lottie/utils/Utils;");
                return;
            }
        }
        threadLocalPathMeasure = new ThreadLocal<PathMeasure>() { // from class: com.airbnb.lottie.utils.Utils.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.lang.ThreadLocal
            public PathMeasure initialValue() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new PathMeasure() : (PathMeasure) invokeV.objValue;
            }
        };
        threadLocalTempPath = new ThreadLocal<Path>() { // from class: com.airbnb.lottie.utils.Utils.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.lang.ThreadLocal
            public Path initialValue() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new Path() : (Path) invokeV.objValue;
            }
        };
        threadLocalTempPath2 = new ThreadLocal<Path>() { // from class: com.airbnb.lottie.utils.Utils.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.lang.ThreadLocal
            public Path initialValue() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new Path() : (Path) invokeV.objValue;
            }
        };
        threadLocalPoints = new ThreadLocal<float[]>() { // from class: com.airbnb.lottie.utils.Utils.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.lang.ThreadLocal
            public float[] initialValue() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new float[4] : (float[]) invokeV.objValue;
            }
        };
        INV_SQRT_2 = (float) (Math.sqrt(2.0d) / 2.0d);
        dpScale = -1.0f;
    }

    public Utils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void applyTrimPathIfNeeded(Path path, @Nullable TrimPathContent trimPathContent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, null, path, trimPathContent) == null) || trimPathContent == null || trimPathContent.isHidden()) {
            return;
        }
        applyTrimPathIfNeeded(path, ((FloatKeyframeAnimation) trimPathContent.getStart()).getFloatValue() / 100.0f, ((FloatKeyframeAnimation) trimPathContent.getEnd()).getFloatValue() / 100.0f, ((FloatKeyframeAnimation) trimPathContent.getOffset()).getFloatValue() / 360.0f);
    }

    public static void closeQuietly(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static Path createPath(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, pointF, pointF2, pointF3, pointF4)) == null) {
            Path path = new Path();
            path.moveTo(pointF.x, pointF.y);
            if (pointF3 != null && pointF4 != null && (pointF3.length() != 0.0f || pointF4.length() != 0.0f)) {
                float f2 = pointF.x;
                float f3 = pointF2.x;
                float f4 = pointF2.y;
                path.cubicTo(pointF3.x + f2, pointF.y + pointF3.y, f3 + pointF4.x, f4 + pointF4.y, f3, f4);
            } else {
                path.lineTo(pointF2.x, pointF2.y);
            }
            return path;
        }
        return (Path) invokeLLLL.objValue;
    }

    public static float dpScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (dpScale == -1.0f) {
                dpScale = Resources.getSystem().getDisplayMetrics().density;
            }
            return dpScale;
        }
        return invokeV.floatValue;
    }

    public static float getAnimationScale(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
            }
            return Settings.System.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
        }
        return invokeL.floatValue;
    }

    public static float getScale(Matrix matrix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, matrix)) == null) {
            float[] fArr = threadLocalPoints.get();
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            float f2 = INV_SQRT_2;
            fArr[2] = f2;
            fArr[3] = f2;
            matrix.mapPoints(fArr);
            return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
        }
        return invokeL.floatValue;
    }

    public static boolean hasZeroScaleAxis(Matrix matrix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, matrix)) == null) {
            float[] fArr = threadLocalPoints.get();
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = 37394.73f;
            fArr[3] = 39575.234f;
            matrix.mapPoints(fArr);
            return fArr[0] == fArr[2] || fArr[1] == fArr[3];
        }
        return invokeL.booleanValue;
    }

    public static int hashFor(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            int i2 = f2 != 0.0f ? (int) (527 * f2) : 17;
            if (f3 != 0.0f) {
                i2 = (int) (i2 * 31 * f3);
            }
            if (f4 != 0.0f) {
                i2 = (int) (i2 * 31 * f4);
            }
            return f5 != 0.0f ? (int) (i2 * 31 * f5) : i2;
        }
        return invokeCommon.intValue;
    }

    public static boolean isAtLeastVersion(int i2, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            if (i2 < i5) {
                return false;
            }
            if (i2 > i5) {
                return true;
            }
            if (i3 < i6) {
                return false;
            }
            return i3 > i6 || i4 >= i7;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean isNetworkException(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, th)) == null) ? (th instanceof SocketException) || (th instanceof ClosedChannelException) || (th instanceof InterruptedIOException) || (th instanceof ProtocolException) || (th instanceof SSLException) || (th instanceof UnknownHostException) || (th instanceof UnknownServiceException) : invokeL.booleanValue;
    }

    public static Bitmap renderPath(Path path) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, path)) == null) {
            RectF rectF = new RectF();
            path.computeBounds(rectF, false);
            Bitmap createBitmap = Bitmap.createBitmap((int) rectF.right, (int) rectF.bottom, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            LPaint lPaint = new LPaint();
            lPaint.setAntiAlias(true);
            lPaint.setColor(-16776961);
            canvas.drawPath(path, lPaint);
            return createBitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public static Bitmap resizeBitmapIfNeeded(Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65550, null, bitmap, i2, i3)) == null) {
            if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
                return bitmap;
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, true);
            bitmap.recycle();
            return createScaledBitmap;
        }
        return (Bitmap) invokeLII.objValue;
    }

    public static void saveLayerCompat(Canvas canvas, RectF rectF, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, canvas, rectF, paint) == null) {
            saveLayerCompat(canvas, rectF, paint, 31);
        }
    }

    public static void saveLayerCompat(Canvas canvas, RectF rectF, Paint paint, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65552, null, canvas, rectF, paint, i2) == null) {
            L.beginSection("Utils#saveLayer");
            if (Build.VERSION.SDK_INT < 23) {
                canvas.saveLayer(rectF, paint, i2);
            } else {
                canvas.saveLayer(rectF, paint);
            }
            L.endSection("Utils#saveLayer");
        }
    }

    public static void applyTrimPathIfNeeded(Path path, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{path, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            L.beginSection("applyTrimPathIfNeeded");
            PathMeasure pathMeasure = threadLocalPathMeasure.get();
            Path path2 = threadLocalTempPath.get();
            Path path3 = threadLocalTempPath2.get();
            pathMeasure.setPath(path, false);
            float length = pathMeasure.getLength();
            if (f2 == 1.0f && f3 == 0.0f) {
                L.endSection("applyTrimPathIfNeeded");
            } else if (length >= 1.0f && Math.abs((f3 - f2) - 1.0f) >= 0.01d) {
                float f5 = f2 * length;
                float f6 = f3 * length;
                float f7 = f4 * length;
                float min = Math.min(f5, f6) + f7;
                float max = Math.max(f5, f6) + f7;
                if (min >= length && max >= length) {
                    min = MiscUtils.floorMod(min, length);
                    max = MiscUtils.floorMod(max, length);
                }
                if (min < 0.0f) {
                    min = MiscUtils.floorMod(min, length);
                }
                if (max < 0.0f) {
                    max = MiscUtils.floorMod(max, length);
                }
                int i2 = (min > max ? 1 : (min == max ? 0 : -1));
                if (i2 == 0) {
                    path.reset();
                    L.endSection("applyTrimPathIfNeeded");
                    return;
                }
                if (i2 >= 0) {
                    min -= length;
                }
                path2.reset();
                pathMeasure.getSegment(min, max, path2, true);
                if (max > length) {
                    path3.reset();
                    pathMeasure.getSegment(0.0f, max % length, path3, true);
                    path2.addPath(path3);
                } else if (min < 0.0f) {
                    path3.reset();
                    pathMeasure.getSegment(min + length, length, path3, true);
                    path2.addPath(path3);
                }
                path.set(path2);
                L.endSection("applyTrimPathIfNeeded");
            } else {
                L.endSection("applyTrimPathIfNeeded");
            }
        }
    }
}
