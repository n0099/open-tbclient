package com.baidu.searchbox.net.update.v2;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.a;
import com.google.gson.stream.b;
import java.io.IOException;
import org.json.JSONArray;
/* loaded from: classes13.dex */
public class JSONArrayAdapter extends TypeAdapter<JSONArray> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.TypeAdapter
    public void write(b bVar, JSONArray jSONArray) throws IOException {
        bVar.QR(jSONArray.toString());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.TypeAdapter
    public JSONArray read(a aVar) throws IOException {
        if (aVar.dBr() == JsonToken.BEGIN_ARRAY) {
            return JSONParser.readJSONArray(aVar);
        }
        return null;
    }
}
