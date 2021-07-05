package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
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
import java.util.List;
/* loaded from: classes.dex */
public class KeyframesParser {
    public static /* synthetic */ Interceptable $ic;
    public static JsonReader.Options NAMES;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1004909664, "Lcom/airbnb/lottie/parser/KeyframesParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1004909664, "Lcom/airbnb/lottie/parser/KeyframesParser;");
                return;
            }
        }
        NAMES = JsonReader.Options.of(Config.APP_KEY);
    }

    public KeyframesParser() {
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

    public static <T> List<Keyframe<T>> parse(JsonReader jsonReader, LottieComposition lottieComposition, float f2, ValueParser<T> valueParser) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{jsonReader, lottieComposition, Float.valueOf(f2), valueParser})) == null) {
            ArrayList arrayList = new ArrayList();
            if (jsonReader.peek() == JsonReader.Token.STRING) {
                lottieComposition.addWarning("Lottie doesn't support expressions.");
                return arrayList;
            }
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.selectName(NAMES) != 0) {
                    jsonReader.skipValue();
                } else if (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
                    jsonReader.beginArray();
                    if (jsonReader.peek() == JsonReader.Token.NUMBER) {
                        arrayList.add(KeyframeParser.parse(jsonReader, lottieComposition, f2, valueParser, false));
                    } else {
                        while (jsonReader.hasNext()) {
                            arrayList.add(KeyframeParser.parse(jsonReader, lottieComposition, f2, valueParser, true));
                        }
                    }
                    jsonReader.endArray();
                } else {
                    arrayList.add(KeyframeParser.parse(jsonReader, lottieComposition, f2, valueParser, false));
                }
            }
            jsonReader.endObject();
            setEndFrames(arrayList);
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public static <T> void setEndFrames(List<? extends Keyframe<T>> list) {
        int i2;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, list) == null) {
            int size = list.size();
            int i3 = 0;
            while (true) {
                i2 = size - 1;
                if (i3 >= i2) {
                    break;
                }
                Keyframe<T> keyframe = list.get(i3);
                i3++;
                Keyframe<T> keyframe2 = list.get(i3);
                keyframe.endFrame = Float.valueOf(keyframe2.startFrame);
                if (keyframe.endValue == null && (t = keyframe2.startValue) != null) {
                    keyframe.endValue = t;
                    if (keyframe instanceof PathKeyframe) {
                        ((PathKeyframe) keyframe).createPath();
                    }
                }
            }
            Keyframe<T> keyframe3 = list.get(i2);
            if ((keyframe3.startValue == null || keyframe3.endValue == null) && list.size() > 1) {
                list.remove(keyframe3);
            }
        }
    }
}
