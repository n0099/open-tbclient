package com.baidu.searchbox.net.update.v2;

import android.annotation.SuppressLint;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class JSONParser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.searchbox.net.update.v2.JSONParser$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1034731186, "Lcom/baidu/searchbox/net/update/v2/JSONParser$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1034731186, "Lcom/baidu/searchbox/net/update/v2/JSONParser$1;");
                    return;
                }
            }
            int[] iArr = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = iArr;
            try {
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public JSONParser() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static JSONArray readJSONArray(JsonReader jsonReader) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jsonReader)) == null) {
            JSONArray jSONArray = new JSONArray();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                jSONArray.put(readObject(jsonReader));
            }
            jsonReader.endArray();
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static JSONObject readJSONObject(JsonReader jsonReader) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jsonReader)) == null) {
            JSONObject jSONObject = new JSONObject();
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                try {
                    jSONObject.put(jsonReader.nextName(), readObject(jsonReader));
                } catch (JSONException e2) {
                    throw new IOException(e2);
                }
            }
            jsonReader.endObject();
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static Object readObject(JsonReader jsonReader) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jsonReader)) == null) {
            switch (AnonymousClass1.$SwitchMap$com$google$gson$stream$JsonToken[jsonReader.peek().ordinal()]) {
                case 1:
                    return readJSONArray(jsonReader);
                case 2:
                    return readJSONObject(jsonReader);
                case 3:
                    return jsonReader.nextString();
                case 4:
                    double nextDouble = jsonReader.nextDouble();
                    int i2 = (int) nextDouble;
                    if (i2 == nextDouble) {
                        return Integer.valueOf(i2);
                    }
                    return Double.valueOf(nextDouble);
                case 5:
                    return Boolean.valueOf(jsonReader.nextBoolean());
                case 6:
                    jsonReader.nextNull();
                    return null;
                default:
                    throw new IllegalStateException();
            }
        }
        return invokeL.objValue;
    }
}
