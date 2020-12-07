package com.baidu.swan.apps.inlinewidget.rtcroom.a.b;

import android.support.annotation.NonNull;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class y extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.rtcroom.c.b> {
    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String aya() {
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
                if (com.baidu.swan.apps.inlinewidget.rtcroom.b.a.cf(optLong)) {
                    bVar.e(optLong, optBoolean);
                }
            }
        }
    }
}
