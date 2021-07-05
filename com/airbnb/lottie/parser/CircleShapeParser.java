package com.airbnb.lottie.parser;

import android.graphics.PointF;
import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes.dex */
public class CircleShapeParser {
    public static /* synthetic */ Interceptable $ic;
    public static JsonReader.Options NAMES;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1209106164, "Lcom/airbnb/lottie/parser/CircleShapeParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1209106164, "Lcom/airbnb/lottie/parser/CircleShapeParser;");
                return;
            }
        }
        NAMES = JsonReader.Options.of(SearchView.IME_OPTION_NO_MICROPHONE, "p", "s", "hd", "d");
    }

    public CircleShapeParser() {
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

    public static CircleShape parse(JsonReader jsonReader, LottieComposition lottieComposition, int i2) throws IOException {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, jsonReader, lottieComposition, i2)) == null) {
            boolean z = i2 == 3;
            String str = null;
            AnimatableValue<PointF, PointF> animatableValue = null;
            AnimatablePointValue animatablePointValue = null;
            boolean z2 = false;
            while (jsonReader.hasNext()) {
                int selectName = jsonReader.selectName(NAMES);
                if (selectName == 0) {
                    str = jsonReader.nextString();
                } else if (selectName == 1) {
                    animatableValue = AnimatablePathValueParser.parseSplitPath(jsonReader, lottieComposition);
                } else if (selectName == 2) {
                    animatablePointValue = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
                } else if (selectName == 3) {
                    z2 = jsonReader.nextBoolean();
                } else if (selectName != 4) {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                } else {
                    z = jsonReader.nextInt() == 3;
                }
            }
            return new CircleShape(str, animatableValue, animatablePointValue, z, z2);
        }
        return (CircleShape) invokeLLI.objValue;
    }
}
