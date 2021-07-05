package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.moshi.JsonReader;
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
public class FontCharacterParser {
    public static /* synthetic */ Interceptable $ic;
    public static final JsonReader.Options DATA_NAMES;
    public static final JsonReader.Options NAMES;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1615499861, "Lcom/airbnb/lottie/parser/FontCharacterParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1615499861, "Lcom/airbnb/lottie/parser/FontCharacterParser;");
                return;
            }
        }
        NAMES = JsonReader.Options.of("ch", "size", "w", "style", "fFamily", "data");
        DATA_NAMES = JsonReader.Options.of("shapes");
    }

    public FontCharacterParser() {
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

    public static FontCharacter parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jsonReader, lottieComposition)) == null) {
            ArrayList arrayList = new ArrayList();
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            double d2 = 0.0d;
            double d3 = 0.0d;
            char c2 = 0;
            while (jsonReader.hasNext()) {
                int selectName = jsonReader.selectName(NAMES);
                if (selectName == 0) {
                    c2 = jsonReader.nextString().charAt(0);
                } else if (selectName == 1) {
                    d2 = jsonReader.nextDouble();
                } else if (selectName == 2) {
                    d3 = jsonReader.nextDouble();
                } else if (selectName == 3) {
                    str = jsonReader.nextString();
                } else if (selectName == 4) {
                    str2 = jsonReader.nextString();
                } else if (selectName != 5) {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                } else {
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if (jsonReader.selectName(DATA_NAMES) != 0) {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                        } else {
                            jsonReader.beginArray();
                            while (jsonReader.hasNext()) {
                                arrayList.add((ShapeGroup) ContentModelParser.parse(jsonReader, lottieComposition));
                            }
                            jsonReader.endArray();
                        }
                    }
                    jsonReader.endObject();
                }
            }
            jsonReader.endObject();
            return new FontCharacter(arrayList, c2, d2, d3, str, str2);
        }
        return (FontCharacter) invokeLL.objValue;
    }
}
