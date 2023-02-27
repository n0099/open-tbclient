package com.baidu.searchbox.net.update.v2;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class JSONArrayAdapter extends TypeAdapter<JSONArray> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.TypeAdapter
    public JSONArray read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            return JSONParser.readJSONArray(jsonReader);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, JSONArray jSONArray) throws IOException {
        jsonWriter.jsonValue(jSONArray.toString());
    }
}
