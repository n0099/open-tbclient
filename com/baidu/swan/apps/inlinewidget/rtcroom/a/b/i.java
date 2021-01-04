package com.baidu.swan.apps.inlinewidget.rtcroom.a.b;

import androidx.annotation.NonNull;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class i extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.rtcroom.c.b> {
    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String azr() {
        return "enterRoom";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.rtcroom.c.b bVar) {
        a(bVar, command.what, "" + command.obj, true);
        if (command.obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) command.obj;
            com.baidu.swan.apps.inlinewidget.rtcroom.model.b bVar2 = new com.baidu.swan.apps.inlinewidget.rtcroom.model.b(jSONObject.optString("roomName"), jSONObject.optLong(TbEnum.SystemMessage.KEY_USER_ID, -1L), jSONObject.optString("displayName"), jSONObject.optString("rtcAppId"), jSONObject.optString("token"));
            boolean isValid = bVar2.isValid();
            if (isValid) {
                bVar.a(bVar2);
            }
            command.ret = isValid ? 1 : 0;
        }
        a(bVar, command.what, "result: " + command.ret, true);
    }

    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command) {
        if (command.obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) command.obj;
            command.ret = new com.baidu.swan.apps.inlinewidget.rtcroom.model.b(jSONObject.optString("roomName"), jSONObject.optLong(TbEnum.SystemMessage.KEY_USER_ID, -1L), jSONObject.optString("displayName"), jSONObject.optString("rtcAppId"), jSONObject.optString("token")).isValid() ? 1 : 0;
        }
    }
}
