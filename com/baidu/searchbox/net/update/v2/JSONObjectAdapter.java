package com.baidu.searchbox.net.update.v2;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.a;
import com.google.gson.stream.b;
import java.io.IOException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class JSONObjectAdapter extends TypeAdapter<JSONObject> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.TypeAdapter
    public void write(b bVar, JSONObject jSONObject) throws IOException {
        bVar.QD(jSONObject.toString());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.gson.TypeAdapter
    public JSONObject read(a aVar) throws IOException {
        if (aVar.dzL() == JsonToken.BEGIN_OBJECT) {
            return JSONParser.readJSONObject(aVar);
        }
        return null;
    }
}
