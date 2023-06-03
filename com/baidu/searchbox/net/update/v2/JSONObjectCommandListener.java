package com.baidu.searchbox.net.update.v2;

import com.google.gson.TypeAdapter;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class JSONObjectCommandListener extends AbstractCommandListener<JSONObject> {
    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public TypeAdapter<JSONObject> getTypeAdapter() {
        return new JSONObjectAdapter();
    }
}
