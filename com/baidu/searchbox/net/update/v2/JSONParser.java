package com.baidu.searchbox.net.update.v2;

import com.google.gson.stream.a;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class JSONParser {
    public static JSONObject readJSONObject(a aVar) throws IOException {
        JSONObject jSONObject = new JSONObject();
        aVar.dAS();
        while (aVar.hasNext()) {
            try {
                jSONObject.put(aVar.dAW(), readObject(aVar));
            } catch (JSONException e) {
                throw new IOException(e);
            }
        }
        aVar.endObject();
        return jSONObject;
    }

    public static JSONArray readJSONArray(a aVar) throws IOException {
        JSONArray jSONArray = new JSONArray();
        aVar.dAR();
        while (aVar.hasNext()) {
            jSONArray.put(readObject(aVar));
        }
        aVar.endArray();
        return jSONArray;
    }

    private static Object readObject(a aVar) throws IOException {
        switch (aVar.dAT()) {
            case BEGIN_ARRAY:
                return readJSONArray(aVar);
            case BEGIN_OBJECT:
                return readJSONObject(aVar);
            case STRING:
                return aVar.dAX();
            case NUMBER:
                double nextDouble = aVar.nextDouble();
                int i = (int) nextDouble;
                if (i == nextDouble) {
                    return Integer.valueOf(i);
                }
                return Double.valueOf(nextDouble);
            case BOOLEAN:
                return Boolean.valueOf(aVar.nextBoolean());
            case NULL:
                aVar.dAY();
                return null;
            default:
                throw new IllegalStateException();
        }
    }
}
