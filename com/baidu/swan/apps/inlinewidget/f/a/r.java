package com.baidu.swan.apps.inlinewidget.f.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class r extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.f.c.a> {
    private int dbZ = 1;
    private int dca = 3;

    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String aya() {
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
                aVar.pt(optString);
            }
            this.dbZ = jSONObject.optInt("min-cache", this.dbZ);
            this.dca = jSONObject.optInt("max-cache", this.dca);
            if (this.dbZ <= this.dca) {
                if (jSONObject.has("min-cache")) {
                    aVar.jr(this.dbZ);
                }
                if (jSONObject.has("max-cache")) {
                    aVar.js(this.dca);
                }
            } else if (DEBUG) {
                Log.w("【InlineCommand】", "setZeusVideoExt: minCache " + this.dbZ + " > maxCache " + this.dca);
            }
        } catch (Exception e) {
        }
    }
}
