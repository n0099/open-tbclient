package com.baidu.swan.apps.inlinewidget.rtcroom.a.b;

import android.support.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class l extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.rtcroom.c.b> {
    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String auS() {
        return "getRemoteUserList";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.rtcroom.c.b bVar) {
        ArrayList<com.baidu.swan.apps.inlinewidget.rtcroom.model.c> ave = bVar.ave();
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (ave != null) {
            Iterator<com.baidu.swan.apps.inlinewidget.rtcroom.model.c> it = ave.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.inlinewidget.rtcroom.model.c next = it.next();
                JSONObject jSONObject2 = next == null ? null : next.toJSONObject();
                if (jSONObject2 != null) {
                    jSONArray.put(jSONObject2);
                }
            }
        }
        try {
            jSONObject.put("userList", jSONArray);
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
