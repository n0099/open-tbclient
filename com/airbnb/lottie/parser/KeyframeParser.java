package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class KeyframeParser {
    public static final float MAX_CP_VALUE = 100.0f;
    public static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache;
    public static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    public static JsonReader.Options NAMES = JsonReader.Options.of("t", "s", "e", "o", "i", "h", "to", "ti");

    @Nullable
    public static WeakReference<Interpolator> getInterpolator(int i2) {
        WeakReference<Interpolator> weakReference;
        synchronized (KeyframeParser.class) {
            weakReference = pathInterpolatorCache().get(i2);
        }
        return weakReference;
    }

    public static <T> Keyframe<T> parse(JsonReader jsonReader, LottieComposition lottieComposition, float f2, ValueParser<T> valueParser, boolean z) throws IOException {
        if (z) {
            return parseKeyframe(lottieComposition, jsonReader, f2, valueParser);
        }
        return parseStaticValue(jsonReader, f2, valueParser);
    }

    public static <T> Keyframe<T> parseKeyframe(LottieComposition lottieComposition, JsonReader jsonReader, float f2, ValueParser<T> valueParser) throws IOException {
        Interpolator interpolator;
        T t;
        Interpolator linearInterpolator;
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

    public static <T> Keyframe<T> parseStaticValue(JsonReader jsonReader, float f2, ValueParser<T> valueParser) throws IOException {
        return new Keyframe<>(valueParser.parse(jsonReader, f2));
    }

    public static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache() {
        if (pathInterpolatorCache == null) {
            pathInterpolatorCache = new SparseArrayCompat<>();
        }
        return pathInterpolatorCache;
    }

    public static void putInterpolator(int i2, WeakReference<Interpolator> weakReference) {
        synchronized (KeyframeParser.class) {
            pathInterpolatorCache.put(i2, weakReference);
        }
    }
}
