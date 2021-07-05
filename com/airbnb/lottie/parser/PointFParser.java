package com.airbnb.lottie.parser;

import android.graphics.PointF;
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
public class PointFParser implements ValueParser<PointF> {
    public static /* synthetic */ Interceptable $ic;
    public static final PointFParser INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(229408733, "Lcom/airbnb/lottie/parser/PointFParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(229408733, "Lcom/airbnb/lottie/parser/PointFParser;");
                return;
            }
        }
        INSTANCE = new PointFParser();
    }

    public PointFParser() {
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
    public PointF parse(JsonReader jsonReader, float f2) throws IOException {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048576, this, jsonReader, f2)) == null) {
            JsonReader.Token peek = jsonReader.peek();
            if (peek == JsonReader.Token.BEGIN_ARRAY) {
                return JsonUtils.jsonToPoint(jsonReader, f2);
            }
            if (peek == JsonReader.Token.BEGIN_OBJECT) {
                return JsonUtils.jsonToPoint(jsonReader, f2);
            }
            if (peek == JsonReader.Token.NUMBER) {
                PointF pointF = new PointF(((float) jsonReader.nextDouble()) * f2, ((float) jsonReader.nextDouble()) * f2);
                while (jsonReader.hasNext()) {
                    jsonReader.skipValue();
                }
                return pointF;
            }
            throw new IllegalArgumentException("Cannot convert json to point. Next token is " + peek);
        }
        return (PointF) invokeLF.objValue;
    }
}
