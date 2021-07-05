package com.airbnb.lottie.parser;

import android.graphics.Color;
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
public class ColorParser implements ValueParser<Integer> {
    public static /* synthetic */ Interceptable $ic;
    public static final ColorParser INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-115504446, "Lcom/airbnb/lottie/parser/ColorParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-115504446, "Lcom/airbnb/lottie/parser/ColorParser;");
                return;
            }
        }
        INSTANCE = new ColorParser();
    }

    public ColorParser() {
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
    public Integer parse(JsonReader jsonReader, float f2) throws IOException {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048576, this, jsonReader, f2)) == null) {
            boolean z = jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY;
            if (z) {
                jsonReader.beginArray();
            }
            double nextDouble = jsonReader.nextDouble();
            double nextDouble2 = jsonReader.nextDouble();
            double nextDouble3 = jsonReader.nextDouble();
            double nextDouble4 = jsonReader.peek() == JsonReader.Token.NUMBER ? jsonReader.nextDouble() : 1.0d;
            if (z) {
                jsonReader.endArray();
            }
            if (nextDouble <= 1.0d && nextDouble2 <= 1.0d && nextDouble3 <= 1.0d) {
                nextDouble *= 255.0d;
                nextDouble2 *= 255.0d;
                nextDouble3 *= 255.0d;
                if (nextDouble4 <= 1.0d) {
                    nextDouble4 *= 255.0d;
                }
            }
            return Integer.valueOf(Color.argb((int) nextDouble4, (int) nextDouble, (int) nextDouble2, (int) nextDouble3));
        }
        return (Integer) invokeLF.objValue;
    }
}
