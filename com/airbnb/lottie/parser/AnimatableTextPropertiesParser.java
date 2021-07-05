package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes.dex */
public class AnimatableTextPropertiesParser {
    public static /* synthetic */ Interceptable $ic;
    public static JsonReader.Options ANIMATABLE_PROPERTIES_NAMES;
    public static JsonReader.Options PROPERTIES_NAMES;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1743275883, "Lcom/airbnb/lottie/parser/AnimatableTextPropertiesParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1743275883, "Lcom/airbnb/lottie/parser/AnimatableTextPropertiesParser;");
                return;
            }
        }
        PROPERTIES_NAMES = JsonReader.Options.of("a");
        ANIMATABLE_PROPERTIES_NAMES = JsonReader.Options.of("fc", Config.STAT_SDK_CHANNEL, "sw", "t");
    }

    public AnimatableTextPropertiesParser() {
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

    public static AnimatableTextProperties parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jsonReader, lottieComposition)) == null) {
            jsonReader.beginObject();
            AnimatableTextProperties animatableTextProperties = null;
            while (jsonReader.hasNext()) {
                if (jsonReader.selectName(PROPERTIES_NAMES) != 0) {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                } else {
                    animatableTextProperties = parseAnimatableTextProperties(jsonReader, lottieComposition);
                }
            }
            jsonReader.endObject();
            return animatableTextProperties == null ? new AnimatableTextProperties(null, null, null, null) : animatableTextProperties;
        }
        return (AnimatableTextProperties) invokeLL.objValue;
    }

    public static AnimatableTextProperties parseAnimatableTextProperties(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, jsonReader, lottieComposition)) == null) {
            jsonReader.beginObject();
            AnimatableColorValue animatableColorValue = null;
            AnimatableColorValue animatableColorValue2 = null;
            AnimatableFloatValue animatableFloatValue = null;
            AnimatableFloatValue animatableFloatValue2 = null;
            while (jsonReader.hasNext()) {
                int selectName = jsonReader.selectName(ANIMATABLE_PROPERTIES_NAMES);
                if (selectName == 0) {
                    animatableColorValue = AnimatableValueParser.parseColor(jsonReader, lottieComposition);
                } else if (selectName == 1) {
                    animatableColorValue2 = AnimatableValueParser.parseColor(jsonReader, lottieComposition);
                } else if (selectName == 2) {
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                } else if (selectName != 3) {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                } else {
                    animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                }
            }
            jsonReader.endObject();
            return new AnimatableTextProperties(animatableColorValue, animatableColorValue2, animatableFloatValue, animatableFloatValue2);
        }
        return (AnimatableTextProperties) invokeLL.objValue;
    }
}
