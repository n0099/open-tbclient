package com.baidu.searchbox.net.update.v2;

import android.annotation.SuppressLint;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class JSONParser {

    /* renamed from: com.baidu.searchbox.net.update.v2.JSONParser$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        static {
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

    public static JSONArray readJSONArray(JsonReader jsonReader) throws IOException {
        JSONArray jSONArray = new JSONArray();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jSONArray.put(readObject(jsonReader));
        }
        jsonReader.endArray();
        return jSONArray;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static JSONObject readJSONObject(JsonReader jsonReader) throws IOException {
        JSONObject jSONObject = new JSONObject();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            try {
                jSONObject.put(jsonReader.nextName(), readObject(jsonReader));
            } catch (JSONException e) {
                throw new IOException(e);
            }
        }
        jsonReader.endObject();
        return jSONObject;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static Object readObject(JsonReader jsonReader) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$gson$stream$JsonToken[jsonReader.peek().ordinal()]) {
            case 1:
                return readJSONArray(jsonReader);
            case 2:
                return readJSONObject(jsonReader);
            case 3:
                return jsonReader.nextString();
            case 4:
                double nextDouble = jsonReader.nextDouble();
                int i = (int) nextDouble;
                if (i == nextDouble) {
                    return Integer.valueOf(i);
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
}
