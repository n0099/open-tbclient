package com.baidu.swan.apps.inlinewidget.f.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class r extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.f.c.a> {
    private int cQU = 1;
    private int cQV = 3;

    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String ata() {
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
                aVar.oE(optString);
            }
            this.cQU = jSONObject.optInt("min-cache", this.cQU);
            this.cQV = jSONObject.optInt("max-cache", this.cQV);
            if (this.cQU <= this.cQV) {
                if (jSONObject.has("min-cache")) {
                    aVar.iN(this.cQU);
                }
                if (jSONObject.has("max-cache")) {
                    aVar.iO(this.cQV);
                }
            } else if (DEBUG) {
                Log.w("【InlineCommand】", "setZeusVideoExt: minCache " + this.cQU + " > maxCache " + this.cQV);
            }
        } catch (Exception e) {
        }
    }
}
