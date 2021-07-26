package com.airbnb.lottie.parser;

import android.graphics.PointF;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.ScaleXY;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes.dex */
public class AnimatableTransformParser {
    public static /* synthetic */ Interceptable $ic;
    public static JsonReader.Options ANIMATABLE_NAMES;
    public static JsonReader.Options NAMES;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1192398935, "Lcom/airbnb/lottie/parser/AnimatableTransformParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1192398935, "Lcom/airbnb/lottie/parser/AnimatableTransformParser;");
                return;
            }
        }
        NAMES = JsonReader.Options.of("a", "p", "s", "rz", r.f7788a, Config.OS, "so", "eo", ContentUtil.RESULT_KEY_SK, "sa");
        ANIMATABLE_NAMES = JsonReader.Options.of(Config.APP_KEY);
    }

    public AnimatableTransformParser() {
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

    public static boolean isAnchorPointIdentity(AnimatablePathValue animatablePathValue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, animatablePathValue)) == null) ? animatablePathValue == null || (animatablePathValue.isStatic() && animatablePathValue.getKeyframes().get(0).startValue.equals(0.0f, 0.0f)) : invokeL.booleanValue;
    }

    public static boolean isPositionIdentity(AnimatableValue<PointF, PointF> animatableValue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, animatableValue)) == null) ? animatableValue == null || (!(animatableValue instanceof AnimatableSplitDimensionPathValue) && animatableValue.isStatic() && animatableValue.getKeyframes().get(0).startValue.equals(0.0f, 0.0f)) : invokeL.booleanValue;
    }

    public static boolean isRotationIdentity(AnimatableFloatValue animatableFloatValue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, animatableFloatValue)) == null) ? animatableFloatValue == null || (animatableFloatValue.isStatic() && ((Float) ((Keyframe) animatableFloatValue.getKeyframes().get(0)).startValue).floatValue() == 0.0f) : invokeL.booleanValue;
    }

    public static boolean isScaleIdentity(AnimatableScaleValue animatableScaleValue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, animatableScaleValue)) == null) ? animatableScaleValue == null || (animatableScaleValue.isStatic() && ((ScaleXY) ((Keyframe) animatableScaleValue.getKeyframes().get(0)).startValue).equals(1.0f, 1.0f)) : invokeL.booleanValue;
    }

    public static boolean isSkewAngleIdentity(AnimatableFloatValue animatableFloatValue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, animatableFloatValue)) == null) ? animatableFloatValue == null || (animatableFloatValue.isStatic() && ((Float) ((Keyframe) animatableFloatValue.getKeyframes().get(0)).startValue).floatValue() == 0.0f) : invokeL.booleanValue;
    }

    public static boolean isSkewIdentity(AnimatableFloatValue animatableFloatValue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, animatableFloatValue)) == null) ? animatableFloatValue == null || (animatableFloatValue.isStatic() && ((Float) ((Keyframe) animatableFloatValue.getKeyframes().get(0)).startValue).floatValue() == 0.0f) : invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AnimatableTransform parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        InterceptResult invokeLL;
        AnimatableFloatValue parseFloat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, jsonReader, lottieComposition)) == null) {
            boolean z = false;
            boolean z2 = jsonReader.peek() == JsonReader.Token.BEGIN_OBJECT;
            if (z2) {
                jsonReader.beginObject();
            }
            AnimatableFloatValue animatableFloatValue = null;
            AnimatablePathValue animatablePathValue = null;
            AnimatableValue<PointF, PointF> animatableValue = null;
            AnimatableScaleValue animatableScaleValue = null;
            AnimatableFloatValue animatableFloatValue2 = null;
            AnimatableFloatValue animatableFloatValue3 = null;
            AnimatableIntegerValue animatableIntegerValue = null;
            AnimatableFloatValue animatableFloatValue4 = null;
            AnimatableFloatValue animatableFloatValue5 = null;
            while (jsonReader.hasNext()) {
                switch (jsonReader.selectName(NAMES)) {
                    case 0:
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            if (jsonReader.selectName(ANIMATABLE_NAMES) != 0) {
                                jsonReader.skipName();
                                jsonReader.skipValue();
                            } else {
                                animatablePathValue = AnimatablePathValueParser.parse(jsonReader, lottieComposition);
                            }
                        }
                        jsonReader.endObject();
                        break;
                    case 1:
                        animatableValue = AnimatablePathValueParser.parseSplitPath(jsonReader, lottieComposition);
                        break;
                    case 2:
                        animatableScaleValue = AnimatableValueParser.parseScale(jsonReader, lottieComposition);
                        break;
                    case 3:
                        lottieComposition.addWarning("Lottie doesn't support 3D layers.");
                        parseFloat = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, z);
                        if (!parseFloat.getKeyframes().isEmpty()) {
                            parseFloat.getKeyframes().add(new Keyframe(lottieComposition, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(lottieComposition.getEndFrame())));
                        } else if (((Keyframe) parseFloat.getKeyframes().get(0)).startValue == 0) {
                            parseFloat.getKeyframes().set(0, new Keyframe(lottieComposition, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(lottieComposition.getEndFrame())));
                            animatableFloatValue = parseFloat;
                            break;
                        }
                        animatableFloatValue = parseFloat;
                    case 4:
                        parseFloat = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, z);
                        if (!parseFloat.getKeyframes().isEmpty()) {
                        }
                        animatableFloatValue = parseFloat;
                        break;
                    case 5:
                        animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                        continue;
                    case 6:
                        animatableFloatValue4 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, z);
                        continue;
                    case 7:
                        animatableFloatValue5 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, z);
                        continue;
                    case 8:
                        animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, z);
                        continue;
                    case 9:
                        animatableFloatValue3 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, z);
                        continue;
                    default:
                        jsonReader.skipName();
                        jsonReader.skipValue();
                        break;
                }
                z = false;
            }
            if (z2) {
                jsonReader.endObject();
            }
            AnimatablePathValue animatablePathValue2 = isAnchorPointIdentity(animatablePathValue) ? null : animatablePathValue;
            AnimatableValue<PointF, PointF> animatableValue2 = isPositionIdentity(animatableValue) ? null : animatableValue;
            AnimatableFloatValue animatableFloatValue6 = isRotationIdentity(animatableFloatValue) ? null : animatableFloatValue;
            if (isScaleIdentity(animatableScaleValue)) {
                animatableScaleValue = null;
            }
            return new AnimatableTransform(animatablePathValue2, animatableValue2, animatableScaleValue, animatableFloatValue6, animatableIntegerValue, animatableFloatValue4, animatableFloatValue5, isSkewIdentity(animatableFloatValue2) ? null : animatableFloatValue2, isSkewAngleIdentity(animatableFloatValue3) ? null : animatableFloatValue3);
        }
        return (AnimatableTransform) invokeLL.objValue;
    }
}
