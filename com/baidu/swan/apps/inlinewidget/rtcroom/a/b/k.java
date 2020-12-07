package com.baidu.swan.apps.inlinewidget.rtcroom.a.b;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class k extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.rtcroom.c.b> {
    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String aya() {
        return "getRemoteAudioLevels";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.rtcroom.c.b bVar) {
        ArrayList<com.baidu.swan.apps.inlinewidget.rtcroom.model.a> ayn = bVar.ayn();
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (ayn != null) {
            Iterator<com.baidu.swan.apps.inlinewidget.rtcroom.model.a> it = ayn.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.inlinewidget.rtcroom.model.a next = it.next();
                JSONObject jSONObject2 = next == null ? null : next.toJSONObject();
                if (jSONObject2 != null) {
                    jSONArray.put(jSONObject2);
                }
            }
        }
        try {
            jSONObject.put("audioLevels", jSONArray);
        } catch (JSONException e) {
        }
        command.obj = jSONObject;
        a(bVar, command.what, "" + command.obj, true);
    }

    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command) {
        command.obj = new JSONObject();
    }
}
