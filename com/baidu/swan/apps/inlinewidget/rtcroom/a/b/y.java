package com.baidu.swan.apps.inlinewidget.rtcroom.a.b;

import androidx.annotation.NonNull;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class y extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.rtcroom.c.b> {
    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String avW() {
        return "setRemoteVideoPlayState";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.rtcroom.c.b bVar) {
        a(bVar, command.what, "" + command.obj, true);
        if (command.obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) command.obj;
            if (jSONObject.has("status") && jSONObject.has(TbEnum.SystemMessage.KEY_USER_ID)) {
                long optLong = jSONObject.optLong(TbEnum.SystemMessage.KEY_USER_ID, -1L);
                boolean optBoolean = jSONObject.optBoolean("status");
                if (com.baidu.swan.apps.inlinewidget.rtcroom.b.a.cm(optLong)) {
                    bVar.g(optLong, optBoolean);
                }
            }
        }
    }
}
