package com.baidu.searchbox.net.update.v2;

import com.google.gson.stream.a;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class JSONParser {
    public static JSONObject readJSONObject(a aVar) throws IOException {
        JSONObject jSONObject = new JSONObject();
        aVar.dyy();
        while (aVar.hasNext()) {
            try {
                jSONObject.put(aVar.dyD(), readObject(aVar));
            } catch (JSONException e) {
                throw new IOException(e);
            }
        }
        aVar.dyz();
        return jSONObject;
    }

    public static JSONArray readJSONArray(a aVar) throws IOException {
        JSONArray jSONArray = new JSONArray();
        aVar.dyw();
        while (aVar.hasNext()) {
            jSONArray.put(readObject(aVar));
        }
        aVar.dyx();
        return jSONArray;
    }

    private static Object readObject(a aVar) throws IOException {
        switch (aVar.dyA()) {
            case BEGIN_ARRAY:
                return readJSONArray(aVar);
            case BEGIN_OBJECT:
                return readJSONObject(aVar);
            case STRING:
                return aVar.dyE();
            case NUMBER:
                double dyH = aVar.dyH();
                int i = (int) dyH;
                if (i == dyH) {
                    return Integer.valueOf(i);
                }
                return Double.valueOf(dyH);
            case BOOLEAN:
                return Boolean.valueOf(aVar.dyF());
            case NULL:
                aVar.dyG();
                return null;
            default:
                throw new IllegalStateException();
        }
    }
}
