package com.baidu.searchbox.net.update.v2;

import com.google.gson.TypeAdapter;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public abstract class JSONArrayCommandListener extends AbstractCommandListener<JSONArray> {
    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public TypeAdapter<JSONArray> getTypeAdapter() {
        return new JSONArrayAdapter();
    }
}
