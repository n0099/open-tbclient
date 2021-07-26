package com.airbnb.lottie.parser;

import android.graphics.Path;
import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.Collections;
/* loaded from: classes.dex */
public class GradientFillParser {
    public static /* synthetic */ Interceptable $ic;
    public static final JsonReader.Options GRADIENT_NAMES;
    public static final JsonReader.Options NAMES;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1053881312, "Lcom/airbnb/lottie/parser/GradientFillParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1053881312, "Lcom/airbnb/lottie/parser/GradientFillParser;");
                return;
            }
        }
        NAMES = JsonReader.Options.of(SearchView.IME_OPTION_NO_MICROPHONE, "g", Config.OS, "t", "s", "e", r.f7788a, "hd");
        GRADIENT_NAMES = JsonReader.Options.of("p", Config.APP_KEY);
    }

    public GradientFillParser() {
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

    public static GradientFill parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jsonReader, lottieComposition)) == null) {
            AnimatableIntegerValue animatableIntegerValue = null;
            Path.FillType fillType = Path.FillType.WINDING;
            String str = null;
            GradientType gradientType = null;
            AnimatableGradientColorValue animatableGradientColorValue = null;
            AnimatablePointValue animatablePointValue = null;
            AnimatablePointValue animatablePointValue2 = null;
            boolean z = false;
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
                            if (selectName == 0) {
                                i2 = jsonReader.nextInt();
                            } else if (selectName != 1) {
                                jsonReader.skipName();
                                jsonReader.skipValue();
                            } else {
                                animatableGradientColorValue = AnimatableValueParser.parseGradientColor(jsonReader, lottieComposition, i2);
                            }
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
                        fillType = jsonReader.nextInt() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                        break;
                    case 7:
                        z = jsonReader.nextBoolean();
                        break;
                    default:
                        jsonReader.skipName();
                        jsonReader.skipValue();
                        break;
                }
            }
            return new GradientFill(str, gradientType, fillType, animatableGradientColorValue, animatableIntegerValue == null ? new AnimatableIntegerValue(Collections.singletonList(new Keyframe(100))) : animatableIntegerValue, animatablePointValue, animatablePointValue2, null, null, z);
        }
        return (GradientFill) invokeLL.objValue;
    }
}
