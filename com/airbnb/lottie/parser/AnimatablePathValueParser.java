package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
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
/* loaded from: classes.dex */
public class AnimatablePathValueParser {
    public static /* synthetic */ Interceptable $ic;
    public static JsonReader.Options NAMES;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-823315593, "Lcom/airbnb/lottie/parser/AnimatablePathValueParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-823315593, "Lcom/airbnb/lottie/parser/AnimatablePathValueParser;");
                return;
            }
        }
        NAMES = JsonReader.Options.of(Config.APP_KEY, "x", "y");
    }

    public AnimatablePathValueParser() {
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

    public static AnimatablePathValue parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jsonReader, lottieComposition)) == null) {
            ArrayList arrayList = new ArrayList();
            if (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    arrayList.add(PathKeyframeParser.parse(jsonReader, lottieComposition));
                }
                jsonReader.endArray();
                KeyframesParser.setEndFrames(arrayList);
            } else {
                arrayList.add(new Keyframe(JsonUtils.jsonToPoint(jsonReader, Utils.dpScale())));
            }
            return new AnimatablePathValue(arrayList);
        }
        return (AnimatablePathValue) invokeLL.objValue;
    }

    public static AnimatableValue<PointF, PointF> parseSplitPath(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, jsonReader, lottieComposition)) == null) {
            jsonReader.beginObject();
            AnimatablePathValue animatablePathValue = null;
            AnimatableFloatValue animatableFloatValue = null;
            AnimatableFloatValue animatableFloatValue2 = null;
            boolean z = false;
            while (jsonReader.peek() != JsonReader.Token.END_OBJECT) {
                int selectName = jsonReader.selectName(NAMES);
                if (selectName == 0) {
                    animatablePathValue = parse(jsonReader, lottieComposition);
                } else if (selectName != 1) {
                    if (selectName != 2) {
                        jsonReader.skipName();
                        jsonReader.skipValue();
                    } else if (jsonReader.peek() == JsonReader.Token.STRING) {
                        jsonReader.skipValue();
                        z = true;
                    } else {
                        animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                    }
                } else if (jsonReader.peek() == JsonReader.Token.STRING) {
                    jsonReader.skipValue();
                    z = true;
                } else {
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                }
            }
            jsonReader.endObject();
            if (z) {
                lottieComposition.addWarning("Lottie doesn't support expressions.");
            }
            return animatablePathValue != null ? animatablePathValue : new AnimatableSplitDimensionPathValue(animatableFloatValue, animatableFloatValue2);
        }
        return (AnimatableValue) invokeLL.objValue;
    }
}
