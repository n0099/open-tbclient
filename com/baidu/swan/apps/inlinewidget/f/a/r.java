package com.baidu.swan.apps.inlinewidget.f.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class r extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.f.c.a> {
    private int cul = 1;
    private int cum = 3;

    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String anJ() {
        return "setZeusVideoExt";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.inlinewidget.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.inlinewidget.f.c.a aVar) {
        Object obj = command.obj;
        if (!(obj instanceof String)) {
            if (DEBUG) {
                throw new RuntimeException("setZeusVideoExt with a illegal obj " + (obj == null));
            }
            return;
        }
        a(aVar, command.what, "setZeusVideoExt:" + obj, false);
        try {
            JSONObject jSONObject = new JSONObject((String) obj);
            String optString = jSONObject.optString("firstPlayStatus");
            if (!TextUtils.isEmpty(optString)) {
                aVar.nd(optString);
            }
            this.cul = jSONObject.optInt("min-cache", this.cul);
            this.cum = jSONObject.optInt("max-cache", this.cum);
            if (this.cul <= this.cum) {
                if (jSONObject.has("min-cache")) {
                    aVar.hV(this.cul);
                }
                if (jSONObject.has("max-cache")) {
                    aVar.hW(this.cum);
                }
            } else if (DEBUG) {
                Log.w("【InlineCommand】", "setZeusVideoExt: minCache " + this.cul + " > maxCache " + this.cum);
            }
        } catch (Exception e) {
        }
    }
}
