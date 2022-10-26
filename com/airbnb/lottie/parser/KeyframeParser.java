package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import com.baidu.mobstat.Config;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class KeyframeParser {
    public static final float MAX_CP_VALUE = 100.0f;
    public static SparseArrayCompat pathInterpolatorCache;
    public static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    public static JsonReader.Options NAMES = JsonReader.Options.of("t", "s", "e", "o", "i", "h", "to", Config.FEED_LIST_PART);

    public static SparseArrayCompat pathInterpolatorCache() {
        if (pathInterpolatorCache == null) {
            pathInterpolatorCache = new SparseArrayCompat();
        }
        return pathInterpolatorCache;
    }

    public static WeakReference getInterpolator(int i) {
        WeakReference weakReference;
        synchronized (KeyframeParser.class) {
            weakReference = (WeakReference) pathInterpolatorCache().get(i);
        }
        return weakReference;
    }

    public static Keyframe parse(JsonReader jsonReader, LottieComposition lottieComposition, float f, ValueParser valueParser, boolean z) throws IOException {
        if (z) {
            return parseKeyframe(lottieComposition, jsonReader, f, valueParser);
        }
        return parseStaticValue(jsonReader, f, valueParser);
    }

    public static Keyframe parseKeyframe(LottieComposition lottieComposition, JsonReader jsonReader, float f, ValueParser valueParser) throws IOException {
        Interpolator interpolator;
        Object obj;
        Interpolator linearInterpolator;
        jsonReader.beginObject();
        Interpolator interpolator2 = null;
        PointF pointF = null;
        PointF pointF2 = null;
        Object obj2 = null;
        Object obj3 = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        boolean z = false;
        float f2 = 0.0f;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    f2 = (float) jsonReader.nextDouble();
                    break;
                case 1:
                    obj3 = valueParser.parse(jsonReader, f);
                    break;
                case 2:
                    obj2 = valueParser.parse(jsonReader, f);
                    break;
                case 3:
                    pointF = JsonUtils.jsonToPoint(jsonReader, f);
                    break;
                case 4:
                    pointF2 = JsonUtils.jsonToPoint(jsonReader, f);
                    break;
                case 5:
                    if (jsonReader.nextInt() == 1) {
                        z = true;
                        break;
                    } else {
                        z = false;
                        break;
                    }
                case 6:
                    pointF4 = JsonUtils.jsonToPoint(jsonReader, f);
                    break;
                case 7:
                    pointF3 = JsonUtils.jsonToPoint(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            interpolator = LINEAR_INTERPOLATOR;
            obj = obj3;
        } else {
            if (pointF != null && pointF2 != null) {
                float f3 = -f;
                pointF.x = MiscUtils.clamp(pointF.x, f3, f);
                pointF.y = MiscUtils.clamp(pointF.y, -100.0f, 100.0f);
                pointF2.x = MiscUtils.clamp(pointF2.x, f3, f);
                float clamp = MiscUtils.clamp(pointF2.y, -100.0f, 100.0f);
                pointF2.y = clamp;
                int hashFor = Utils.hashFor(pointF.x, pointF.y, pointF2.x, clamp);
                WeakReference interpolator3 = getInterpolator(hashFor);
                if (interpolator3 != null) {
                    interpolator2 = (Interpolator) interpolator3.get();
                }
                if (interpolator3 == null || interpolator2 == null) {
                    pointF.x /= f;
                    pointF.y /= f;
                    float f4 = pointF2.x / f;
                    pointF2.x = f4;
                    float f5 = pointF2.y / f;
                    pointF2.y = f5;
                    try {
                        linearInterpolator = PathInterpolatorCompat.create(pointF.x, pointF.y, f4, f5);
                    } catch (IllegalArgumentException e) {
                        if (e.getMessage().equals("The Path cannot loop back on itself.")) {
                            linearInterpolator = PathInterpolatorCompat.create(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                        } else {
                            linearInterpolator = new LinearInterpolator();
                        }
                    }
                    interpolator2 = linearInterpolator;
                    try {
                        putInterpolator(hashFor, new WeakReference(interpolator2));
                    } catch (ArrayIndexOutOfBoundsException unused) {
                    }
                }
                interpolator = interpolator2;
            } else {
                interpolator = LINEAR_INTERPOLATOR;
            }
            obj = obj2;
        }
        Keyframe keyframe = new Keyframe(lottieComposition, obj3, obj, interpolator, f2, null);
        keyframe.pathCp1 = pointF4;
        keyframe.pathCp2 = pointF3;
        return keyframe;
    }

    public static Keyframe parseStaticValue(JsonReader jsonReader, float f, ValueParser valueParser) throws IOException {
        return new Keyframe(valueParser.parse(jsonReader, f));
    }

    public static void putInterpolator(int i, WeakReference weakReference) {
        synchronized (KeyframeParser.class) {
            pathInterpolatorCache.put(i, weakReference);
        }
    }
}
