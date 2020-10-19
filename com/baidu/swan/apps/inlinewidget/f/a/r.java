package com.baidu.swan.apps.inlinewidget.f.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class r extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.f.c.a> {
    private int cIy = 1;
    private int cIz = 3;

    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String arf() {
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
                aVar.ok(optString);
            }
            this.cIy = jSONObject.optInt("min-cache", this.cIy);
            this.cIz = jSONObject.optInt("max-cache", this.cIz);
            if (this.cIy <= this.cIz) {
                if (jSONObject.has("min-cache")) {
                    aVar.iC(this.cIy);
                }
                if (jSONObject.has("max-cache")) {
                    aVar.iD(this.cIz);
                }
            } else if (DEBUG) {
                Log.w("【InlineCommand】", "setZeusVideoExt: minCache " + this.cIy + " > maxCache " + this.cIz);
            }
        } catch (Exception e) {
        }
    }
}
