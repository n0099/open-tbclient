package com.airbnb.lottie.parser;

import android.graphics.PointF;
import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes.dex */
public class RectangleShapeParser {
    public static /* synthetic */ Interceptable $ic;
    public static JsonReader.Options NAMES;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-931960159, "Lcom/airbnb/lottie/parser/RectangleShapeParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-931960159, "Lcom/airbnb/lottie/parser/RectangleShapeParser;");
                return;
            }
        }
        NAMES = JsonReader.Options.of(SearchView.IME_OPTION_NO_MICROPHONE, "p", "s", r.f7745a, "hd");
    }

    public RectangleShapeParser() {
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

    public static RectangleShape parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jsonReader, lottieComposition)) == null) {
            String str = null;
            AnimatableValue<PointF, PointF> animatableValue = null;
            AnimatablePointValue animatablePointValue = null;
            AnimatableFloatValue animatableFloatValue = null;
            boolean z = false;
            while (jsonReader.hasNext()) {
                int selectName = jsonReader.selectName(NAMES);
                if (selectName == 0) {
                    str = jsonReader.nextString();
                } else if (selectName == 1) {
                    animatableValue = AnimatablePathValueParser.parseSplitPath(jsonReader, lottieComposition);
                } else if (selectName == 2) {
                    animatablePointValue = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
                } else if (selectName == 3) {
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                } else if (selectName != 4) {
                    jsonReader.skipValue();
                } else {
                    z = jsonReader.nextBoolean();
                }
            }
            return new RectangleShape(str, animatableValue, animatablePointValue, animatableFloatValue, z);
        }
        return (RectangleShape) invokeLL.objValue;
    }
}
