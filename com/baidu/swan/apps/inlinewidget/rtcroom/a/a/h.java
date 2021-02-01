package com.baidu.swan.apps.inlinewidget.rtcroom.a.a;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class h extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.rtcroom.c.a> {
    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String avW() {
        return "onSurfaceChanged";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.rtcroom.c.a aVar) {
        a(aVar, command.what, "" + command.obj, true);
        if (command.obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) command.obj;
            aVar.onSurfaceChanged(jSONObject.optInt("width"), jSONObject.optInt("height"));
        }
    }
}
