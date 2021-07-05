package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.ScaleXY;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes.dex */
public class ScaleXYParser implements ValueParser<ScaleXY> {
    public static /* synthetic */ Interceptable $ic;
    public static final ScaleXYParser INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-619018982, "Lcom/airbnb/lottie/parser/ScaleXYParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-619018982, "Lcom/airbnb/lottie/parser/ScaleXYParser;");
                return;
            }
        }
        INSTANCE = new ScaleXYParser();
    }

    public ScaleXYParser() {
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public ScaleXY parse(JsonReader jsonReader, float f2) throws IOException {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048576, this, jsonReader, f2)) == null) {
            boolean z = jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY;
            if (z) {
                jsonReader.beginArray();
            }
            float nextDouble = (float) jsonReader.nextDouble();
            float nextDouble2 = (float) jsonReader.nextDouble();
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            if (z) {
                jsonReader.endArray();
            }
            return new ScaleXY((nextDouble / 100.0f) * f2, (nextDouble2 / 100.0f) * f2);
        }
        return (ScaleXY) invokeLF.objValue;
    }
}
