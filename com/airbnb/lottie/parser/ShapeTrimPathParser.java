package com.airbnb.lottie.parser;

import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
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
public class ShapeTrimPathParser {
    public static /* synthetic */ Interceptable $ic;
    public static JsonReader.Options NAMES;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-508765347, "Lcom/airbnb/lottie/parser/ShapeTrimPathParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-508765347, "Lcom/airbnb/lottie/parser/ShapeTrimPathParser;");
                return;
            }
        }
        NAMES = JsonReader.Options.of("s", "e", Config.OS, SearchView.IME_OPTION_NO_MICROPHONE, "m", "hd");
    }

    public ShapeTrimPathParser() {
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

    public static ShapeTrimPath parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jsonReader, lottieComposition)) == null) {
            String str = null;
            ShapeTrimPath.Type type = null;
            AnimatableFloatValue animatableFloatValue = null;
            AnimatableFloatValue animatableFloatValue2 = null;
            AnimatableFloatValue animatableFloatValue3 = null;
            boolean z = false;
            while (jsonReader.hasNext()) {
                int selectName = jsonReader.selectName(NAMES);
                if (selectName == 0) {
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                } else if (selectName == 1) {
                    animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                } else if (selectName == 2) {
                    animatableFloatValue3 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                } else if (selectName == 3) {
                    str = jsonReader.nextString();
                } else if (selectName == 4) {
                    type = ShapeTrimPath.Type.forId(jsonReader.nextInt());
                } else if (selectName != 5) {
                    jsonReader.skipValue();
                } else {
                    z = jsonReader.nextBoolean();
                }
            }
            return new ShapeTrimPath(str, type, animatableFloatValue, animatableFloatValue2, animatableFloatValue3, z);
        }
        return (ShapeTrimPath) invokeLL.objValue;
    }
}
