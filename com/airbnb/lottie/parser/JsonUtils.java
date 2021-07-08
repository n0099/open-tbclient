package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class JsonUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final JsonReader.Options POINT_NAMES;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.airbnb.lottie.parser.JsonUtils$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2074920018, "Lcom/airbnb/lottie/parser/JsonUtils$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2074920018, "Lcom/airbnb/lottie/parser/JsonUtils$1;");
                    return;
                }
            }
            int[] iArr = new int[JsonReader.Token.values().length];
            $SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token = iArr;
            try {
                iArr[JsonReader.Token.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token[JsonReader.Token.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token[JsonReader.Token.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-739588453, "Lcom/airbnb/lottie/parser/JsonUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-739588453, "Lcom/airbnb/lottie/parser/JsonUtils;");
                return;
            }
        }
        POINT_NAMES = JsonReader.Options.of("x", "y");
    }

    public JsonUtils() {
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

    public static PointF jsonArrayToPoint(JsonReader jsonReader, float f2) throws IOException {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65538, null, jsonReader, f2)) == null) {
            jsonReader.beginArray();
            float nextDouble = (float) jsonReader.nextDouble();
            float nextDouble2 = (float) jsonReader.nextDouble();
            while (jsonReader.peek() != JsonReader.Token.END_ARRAY) {
                jsonReader.skipValue();
            }
            jsonReader.endArray();
            return new PointF(nextDouble * f2, nextDouble2 * f2);
        }
        return (PointF) invokeLF.objValue;
    }

    public static PointF jsonNumbersToPoint(JsonReader jsonReader, float f2) throws IOException {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65539, null, jsonReader, f2)) == null) {
            float nextDouble = (float) jsonReader.nextDouble();
            float nextDouble2 = (float) jsonReader.nextDouble();
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            return new PointF(nextDouble * f2, nextDouble2 * f2);
        }
        return (PointF) invokeLF.objValue;
    }

    public static PointF jsonObjectToPoint(JsonReader jsonReader, float f2) throws IOException {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(InputDeviceCompat.SOURCE_TRACKBALL, null, jsonReader, f2)) == null) {
            jsonReader.beginObject();
            float f3 = 0.0f;
            float f4 = 0.0f;
            while (jsonReader.hasNext()) {
                int selectName = jsonReader.selectName(POINT_NAMES);
                if (selectName == 0) {
                    f3 = valueFromObject(jsonReader);
                } else if (selectName != 1) {
                    jsonReader.skipName();
                    jsonReader.skipValue();
                } else {
                    f4 = valueFromObject(jsonReader);
                }
            }
            jsonReader.endObject();
            return new PointF(f3 * f2, f4 * f2);
        }
        return (PointF) invokeLF.objValue;
    }

    @ColorInt
    public static int jsonToColor(JsonReader jsonReader) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, jsonReader)) == null) {
            jsonReader.beginArray();
            int nextDouble = (int) (jsonReader.nextDouble() * 255.0d);
            int nextDouble2 = (int) (jsonReader.nextDouble() * 255.0d);
            int nextDouble3 = (int) (jsonReader.nextDouble() * 255.0d);
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            jsonReader.endArray();
            return Color.argb(255, nextDouble, nextDouble2, nextDouble3);
        }
        return invokeL.intValue;
    }

    public static PointF jsonToPoint(JsonReader jsonReader, float f2) throws IOException {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(AdIconUtil.BAIDU_LOGO_ID, null, jsonReader, f2)) == null) {
            int i2 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token[jsonReader.peek().ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        return jsonObjectToPoint(jsonReader, f2);
                    }
                    throw new IllegalArgumentException("Unknown point starts with " + jsonReader.peek());
                }
                return jsonArrayToPoint(jsonReader, f2);
            }
            return jsonNumbersToPoint(jsonReader, f2);
        }
        return (PointF) invokeLF.objValue;
    }

    public static List<PointF> jsonToPoints(JsonReader jsonReader, float f2) throws IOException {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65543, null, jsonReader, f2)) == null) {
            ArrayList arrayList = new ArrayList();
            jsonReader.beginArray();
            while (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
                jsonReader.beginArray();
                arrayList.add(jsonToPoint(jsonReader, f2));
                jsonReader.endArray();
            }
            jsonReader.endArray();
            return arrayList;
        }
        return (List) invokeLF.objValue;
    }

    public static float valueFromObject(JsonReader jsonReader) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, jsonReader)) == null) {
            JsonReader.Token peek = jsonReader.peek();
            int i2 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token[peek.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    jsonReader.beginArray();
                    float nextDouble = (float) jsonReader.nextDouble();
                    while (jsonReader.hasNext()) {
                        jsonReader.skipValue();
                    }
                    jsonReader.endArray();
                    return nextDouble;
                }
                throw new IllegalArgumentException("Unknown value for token of type " + peek);
            }
            return (float) jsonReader.nextDouble();
        }
        return invokeL.floatValue;
    }
}
