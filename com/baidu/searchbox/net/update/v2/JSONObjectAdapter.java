package com.baidu.searchbox.net.update.v2;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class JSONObjectAdapter extends TypeAdapter<JSONObject> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.TypeAdapter
    public JSONObject read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
            return JSONParser.readJSONObject(jsonReader);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, JSONObject jSONObject) throws IOException {
        jsonWriter.jsonValue(jSONObject.toString());
    }
}
