package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class KeyframeParser {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Interpolator LINEAR_INTERPOLATOR;
    public static final float MAX_CP_VALUE = 100.0f;
    public static JsonReader.Options NAMES;
    public static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1273253221, "Lcom/airbnb/lottie/parser/KeyframeParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1273253221, "Lcom/airbnb/lottie/parser/KeyframeParser;");
                return;
            }
        }
        LINEAR_INTERPOLATOR = new LinearInterpolator();
        NAMES = JsonReader.Options.of("t", "s", "e", Config.OS, "i", "h", "to", Config.FEED_LIST_PART);
    }

    public KeyframeParser() {
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

    @Nullable
    public static WeakReference<Interpolator> getInterpolator(int i2) {
        InterceptResult invokeI;
        WeakReference<Interpolator> weakReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            synchronized (KeyframeParser.class) {
                weakReference = pathInterpolatorCache().get(i2);
            }
            return weakReference;
        }
        return (WeakReference) invokeI.objValue;
    }

    public static <T> Keyframe<T> parse(JsonReader jsonReader, LottieComposition lottieComposition, float f2, ValueParser<T> valueParser, boolean z) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{jsonReader, lottieComposition, Float.valueOf(f2), valueParser, Boolean.valueOf(z)})) == null) {
            if (z) {
                return parseKeyframe(lottieComposition, jsonReader, f2, valueParser);
            }
            return parseStaticValue(jsonReader, f2, valueParser);
        }
        return (Keyframe) invokeCommon.objValue;
    }

    public static <T> Keyframe<T> parseKeyframe(LottieComposition lottieComposition, JsonReader jsonReader, float f2, ValueParser<T> valueParser) throws IOException {
        InterceptResult invokeCommon;
        Interpolator interpolator;
        T t;
        Interpolator linearInterpolator;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{lottieComposition, jsonReader, Float.valueOf(f2), valueParser})) == null) {
            jsonReader.beginObject();
            PointF pointF = null;
            PointF pointF2 = null;
            T t2 = null;
            T t3 = null;
            PointF pointF3 = null;
            PointF pointF4 = null;
            boolean z = false;
            float f3 = 0.0f;
            while (jsonReader.hasNext()) {
                switch (jsonReader.selectName(NAMES)) {
                    case 0:
                        f3 = (float) jsonReader.nextDouble();
                        break;
                    case 1:
                        t3 = valueParser.parse(jsonReader, f2);
                        break;
                    case 2:
                        t2 = valueParser.parse(jsonReader, f2);
                        break;
                    case 3:
                        pointF = JsonUtils.jsonToPoint(jsonReader, f2);
                        break;
                    case 4:
                        pointF2 = JsonUtils.jsonToPoint(jsonReader, f2);
                        break;
                    case 5:
                        if (jsonReader.nextInt() != 1) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    case 6:
                        pointF4 = JsonUtils.jsonToPoint(jsonReader, f2);
                        break;
                    case 7:
                        pointF3 = JsonUtils.jsonToPoint(jsonReader, f2);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            if (z) {
                interpolator = LINEAR_INTERPOLATOR;
                t = t3;
            } else {
                if (pointF != null && pointF2 != null) {
                    float f4 = -f2;
                    pointF.x = MiscUtils.clamp(pointF.x, f4, f2);
                    pointF.y = MiscUtils.clamp(pointF.y, -100.0f, 100.0f);
                    pointF2.x = MiscUtils.clamp(pointF2.x, f4, f2);
                    float clamp = MiscUtils.clamp(pointF2.y, -100.0f, 100.0f);
                    pointF2.y = clamp;
                    int hashFor = Utils.hashFor(pointF.x, pointF.y, pointF2.x, clamp);
                    WeakReference<Interpolator> interpolator2 = getInterpolator(hashFor);
                    Interpolator interpolator3 = interpolator2 != null ? interpolator2.get() : null;
                    if (interpolator2 == null || interpolator3 == null) {
                        pointF.x /= f2;
                        pointF.y /= f2;
                        float f5 = pointF2.x / f2;
                        pointF2.x = f5;
                        float f6 = pointF2.y / f2;
                        pointF2.y = f6;
                        try {
                            linearInterpolator = PathInterpolatorCompat.create(pointF.x, pointF.y, f5, f6);
                        } catch (IllegalArgumentException e2) {
                            if (e2.getMessage().equals("The Path cannot loop back on itself.")) {
                                linearInterpolator = PathInterpolatorCompat.create(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                            } else {
                                linearInterpolator = new LinearInterpolator();
                            }
                        }
                        interpolator3 = linearInterpolator;
                        try {
                            putInterpolator(hashFor, new WeakReference(interpolator3));
                        } catch (ArrayIndexOutOfBoundsException unused) {
                        }
                    }
                    interpolator = interpolator3;
                } else {
                    interpolator = LINEAR_INTERPOLATOR;
                }
                t = t2;
            }
            Keyframe<T> keyframe = new Keyframe<>(lottieComposition, t3, t, interpolator, f3, null);
            keyframe.pathCp1 = pointF4;
            keyframe.pathCp2 = pointF3;
            return keyframe;
        }
        return (Keyframe) invokeCommon.objValue;
    }

    public static <T> Keyframe<T> parseStaticValue(JsonReader jsonReader, float f2, ValueParser<T> valueParser) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{jsonReader, Float.valueOf(f2), valueParser})) == null) ? new Keyframe<>(valueParser.parse(jsonReader, f2)) : (Keyframe) invokeCommon.objValue;
    }

    public static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (pathInterpolatorCache == null) {
                pathInterpolatorCache = new SparseArrayCompat<>();
            }
            return pathInterpolatorCache;
        }
        return (SparseArrayCompat) invokeV.objValue;
    }

    public static void putInterpolator(int i2, WeakReference<Interpolator> weakReference) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65543, null, i2, weakReference) == null) {
            synchronized (KeyframeParser.class) {
                pathInterpolatorCache.put(i2, weakReference);
            }
        }
    }
}
