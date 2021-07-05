package com.airbnb.lottie.parser;

import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes.dex */
public class GradientStrokeParser {
    public static /* synthetic */ Interceptable $ic;
    public static final JsonReader.Options DASH_PATTERN_NAMES;
    public static final JsonReader.Options GRADIENT_NAMES;
    public static JsonReader.Options NAMES;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1206972469, "Lcom/airbnb/lottie/parser/GradientStrokeParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1206972469, "Lcom/airbnb/lottie/parser/GradientStrokeParser;");
                return;
            }
        }
        NAMES = JsonReader.Options.of(SearchView.IME_OPTION_NO_MICROPHONE, "g", Config.OS, "t", "s", "e", "w", "lc", "lj", "ml", "hd", "d");
        GRADIENT_NAMES = JsonReader.Options.of("p", Config.APP_KEY);
        DASH_PATTERN_NAMES = JsonReader.Options.of("n", "v");
    }

    public GradientStrokeParser() {
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

    public static GradientStroke parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        InterceptResult invokeLL;
        AnimatableGradientColorValue animatableGradientColorValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jsonReader, lottieComposition)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = null;
            GradientType gradientType = null;
            AnimatableGradientColorValue animatableGradientColorValue2 = null;
            AnimatablePointValue animatablePointValue = null;
            AnimatablePointValue animatablePointValue2 = null;
            AnimatableFloatValue animatableFloatValue = null;
            ShapeStroke.LineCapType lineCapType = null;
            ShapeStroke.LineJoinType lineJoinType = null;
            float f2 = 0.0f;
            AnimatableFloatValue animatableFloatValue2 = null;
            boolean z = false;
            AnimatableIntegerValue animatableIntegerValue = null;
            while (jsonReader.hasNext()) {
                switch (jsonReader.selectName(NAMES)) {
                    case 0:
                        str = jsonReader.nextString();
                        break;
                    case 1:
                        int i2 = -1;
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            int selectName = jsonReader.selectName(GRADIENT_NAMES);
                            if (selectName != 0) {
                                animatableGradientColorValue = animatableGradientColorValue2;
                                if (selectName != 1) {
                                    jsonReader.skipName();
                                    jsonReader.skipValue();
                                } else {
                                    animatableGradientColorValue2 = AnimatableValueParser.parseGradientColor(jsonReader, lottieComposition, i2);
                                }
                            } else {
                                animatableGradientColorValue = animatableGradientColorValue2;
                                i2 = jsonReader.nextInt();
                            }
                            animatableGradientColorValue2 = animatableGradientColorValue;
                        }
                        jsonReader.endObject();
                        break;
                    case 2:
                        animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                        break;
                    case 3:
                        gradientType = jsonReader.nextInt() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                        break;
                    case 4:
                        animatablePointValue = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
                        break;
                    case 5:
                        animatablePointValue2 = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
                        break;
                    case 6:
                        animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                        break;
                    case 7:
                        lineCapType = ShapeStroke.LineCapType.values()[jsonReader.nextInt() - 1];
                        break;
                    case 8:
                        lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.nextInt() - 1];
                        break;
                    case 9:
                        f2 = (float) jsonReader.nextDouble();
                        break;
                    case 10:
                        z = jsonReader.nextBoolean();
                        break;
                    case 11:
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            jsonReader.beginObject();
                            String str2 = null;
                            AnimatableFloatValue animatableFloatValue3 = null;
                            while (jsonReader.hasNext()) {
                                int selectName2 = jsonReader.selectName(DASH_PATTERN_NAMES);
                                if (selectName2 != 0) {
                                    AnimatableFloatValue animatableFloatValue4 = animatableFloatValue2;
                                    if (selectName2 != 1) {
                                        jsonReader.skipName();
                                        jsonReader.skipValue();
                                    } else {
                                        animatableFloatValue3 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                                    }
                                    animatableFloatValue2 = animatableFloatValue4;
                                } else {
                                    str2 = jsonReader.nextString();
                                }
                            }
                            AnimatableFloatValue animatableFloatValue5 = animatableFloatValue2;
                            jsonReader.endObject();
                            if (str2.equals(Config.OS)) {
                                animatableFloatValue2 = animatableFloatValue3;
                            } else {
                                if (str2.equals("d") || str2.equals("g")) {
                                    lottieComposition.setHasDashPattern(true);
                                    arrayList.add(animatableFloatValue3);
                                }
                                animatableFloatValue2 = animatableFloatValue5;
                            }
                        }
                        AnimatableFloatValue animatableFloatValue6 = animatableFloatValue2;
                        jsonReader.endArray();
                        if (arrayList.size() == 1) {
                            arrayList.add(arrayList.get(0));
                        }
                        animatableFloatValue2 = animatableFloatValue6;
                        break;
                    default:
                        jsonReader.skipName();
                        jsonReader.skipValue();
                        break;
                }
            }
            if (animatableIntegerValue == null) {
                animatableIntegerValue = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(100)));
            }
            return new GradientStroke(str, gradientType, animatableGradientColorValue2, animatableIntegerValue, animatablePointValue, animatablePointValue2, animatableFloatValue, lineCapType, lineJoinType, f2, arrayList, animatableFloatValue2, z);
        }
        return (GradientStroke) invokeLL.objValue;
    }
}
