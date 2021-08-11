package com.airbnb.lottie.parser;

import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import com.baidu.fsg.base.statistics.h;
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
/* loaded from: classes4.dex */
public class ShapeStrokeParser {
    public static /* synthetic */ Interceptable $ic;
    public static final JsonReader.Options DASH_PATTERN_NAMES;
    public static JsonReader.Options NAMES;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(691455340, "Lcom/airbnb/lottie/parser/ShapeStrokeParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(691455340, "Lcom/airbnb/lottie/parser/ShapeStrokeParser;");
                return;
            }
        }
        NAMES = JsonReader.Options.of(SearchView.IME_OPTION_NO_MICROPHONE, "c", "w", "o", h.f39306g, "lj", "ml", "hd", "d");
        DASH_PATTERN_NAMES = JsonReader.Options.of("n", "v");
    }

    public ShapeStrokeParser() {
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

    public static ShapeStroke parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        InterceptResult invokeLL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jsonReader, lottieComposition)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = null;
            AnimatableFloatValue animatableFloatValue = null;
            AnimatableColorValue animatableColorValue = null;
            AnimatableFloatValue animatableFloatValue2 = null;
            ShapeStroke.LineCapType lineCapType = null;
            ShapeStroke.LineJoinType lineJoinType = null;
            float f2 = 0.0f;
            boolean z = false;
            AnimatableIntegerValue animatableIntegerValue = null;
            while (true) {
                int i2 = 100;
                if (jsonReader.hasNext()) {
                    int i3 = 1;
                    switch (jsonReader.selectName(NAMES)) {
                        case 0:
                            str = jsonReader.nextString();
                            break;
                        case 1:
                            animatableColorValue = AnimatableValueParser.parseColor(jsonReader, lottieComposition);
                            break;
                        case 2:
                            animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                            break;
                        case 3:
                            animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                            break;
                        case 4:
                            lineCapType = ShapeStroke.LineCapType.values()[jsonReader.nextInt() - 1];
                            break;
                        case 5:
                            lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.nextInt() - 1];
                            break;
                        case 6:
                            f2 = (float) jsonReader.nextDouble();
                            break;
                        case 7:
                            z = jsonReader.nextBoolean();
                            break;
                        case 8:
                            jsonReader.beginArray();
                            while (jsonReader.hasNext()) {
                                jsonReader.beginObject();
                                AnimatableFloatValue animatableFloatValue3 = null;
                                String str2 = null;
                                while (jsonReader.hasNext()) {
                                    int selectName = jsonReader.selectName(DASH_PATTERN_NAMES);
                                    if (selectName == 0) {
                                        str2 = jsonReader.nextString();
                                    } else if (selectName != i3) {
                                        jsonReader.skipName();
                                        jsonReader.skipValue();
                                    } else {
                                        animatableFloatValue3 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                                    }
                                }
                                jsonReader.endObject();
                                int hashCode = str2.hashCode();
                                if (hashCode == i2) {
                                    if (str2.equals("d")) {
                                        c2 = 1;
                                    }
                                    c2 = 65535;
                                } else if (hashCode != 103) {
                                    if (hashCode == 111 && str2.equals("o")) {
                                        c2 = 0;
                                    }
                                    c2 = 65535;
                                } else {
                                    if (str2.equals("g")) {
                                        c2 = 2;
                                    }
                                    c2 = 65535;
                                }
                                if (c2 == 0) {
                                    animatableFloatValue = animatableFloatValue3;
                                } else if (c2 == 1 || c2 == 2) {
                                    lottieComposition.setHasDashPattern(true);
                                    arrayList.add(animatableFloatValue3);
                                }
                                i2 = 100;
                                i3 = 1;
                            }
                            jsonReader.endArray();
                            if (arrayList.size() != 1) {
                                break;
                            } else {
                                arrayList.add(arrayList.get(0));
                                break;
                            }
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                } else {
                    if (animatableIntegerValue == null) {
                        animatableIntegerValue = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(100)));
                    }
                    return new ShapeStroke(str, animatableFloatValue, arrayList, animatableColorValue, animatableIntegerValue, animatableFloatValue2, lineCapType, lineJoinType, f2, z);
                }
            }
        } else {
            return (ShapeStroke) invokeLL.objValue;
        }
    }
}
