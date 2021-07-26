package com.airbnb.lottie.parser;

import android.graphics.Path;
import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeFill;
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
public class ShapeFillParser {
    public static /* synthetic */ Interceptable $ic;
    public static final JsonReader.Options NAMES;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1341889985, "Lcom/airbnb/lottie/parser/ShapeFillParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1341889985, "Lcom/airbnb/lottie/parser/ShapeFillParser;");
                return;
            }
        }
        NAMES = JsonReader.Options.of(SearchView.IME_OPTION_NO_MICROPHONE, "c", Config.OS, "fillEnabled", r.f7788a, "hd");
    }

    public ShapeFillParser() {
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

    public static ShapeFill parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jsonReader, lottieComposition)) == null) {
            AnimatableIntegerValue animatableIntegerValue = null;
            String str = null;
            AnimatableColorValue animatableColorValue = null;
            int i2 = 1;
            boolean z = false;
            boolean z2 = false;
            while (jsonReader.hasNext()) {
                int selectName = jsonReader.selectName(NAMES);
                if (selectName == 0) {
                    str = jsonReader.nextString();
                } else if (selectName == 1) {
                    animatableColorValue = AnimatableValueParser.parseColor(jsonReader, lottieComposition);
                } else if (selectName == 2) {
                    animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                } else if (selectName == 3) {
                    z = jsonReader.nextBoolean();
                } else if (selectName == 4) {
                    i2 = jsonReader.nextInt();
                } else if (selectName != 5) {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                } else {
                    z2 = jsonReader.nextBoolean();
                }
            }
            return new ShapeFill(str, z, i2 == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, animatableColorValue, animatableIntegerValue == null ? new AnimatableIntegerValue(Collections.singletonList(new Keyframe(100))) : animatableIntegerValue, z2);
        }
        return (ShapeFill) invokeLL.objValue;
    }
}
