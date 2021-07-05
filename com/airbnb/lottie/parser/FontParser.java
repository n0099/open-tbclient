package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.Font;
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
public class FontParser {
    public static /* synthetic */ Interceptable $ic;
    public static final JsonReader.Options NAMES;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(927904740, "Lcom/airbnb/lottie/parser/FontParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(927904740, "Lcom/airbnb/lottie/parser/FontParser;");
                return;
            }
        }
        NAMES = JsonReader.Options.of("fFamily", "fName", "fStyle", "ascent");
    }

    public FontParser() {
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

    public static Font parse(JsonReader jsonReader) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jsonReader)) == null) {
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            String str3 = null;
            float f2 = 0.0f;
            while (jsonReader.hasNext()) {
                int selectName = jsonReader.selectName(NAMES);
                if (selectName == 0) {
                    str = jsonReader.nextString();
                } else if (selectName == 1) {
                    str2 = jsonReader.nextString();
                } else if (selectName == 2) {
                    str3 = jsonReader.nextString();
                } else if (selectName != 3) {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                } else {
                    f2 = (float) jsonReader.nextDouble();
                }
            }
            jsonReader.endObject();
            return new Font(str, str2, str3, f2);
        }
        return (Font) invokeL.objValue;
    }
}
