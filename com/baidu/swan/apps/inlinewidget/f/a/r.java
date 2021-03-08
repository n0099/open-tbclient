package com.baidu.swan.apps.inlinewidget.f.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class r extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.f.c.a> {
    private int dfU = 1;
    private int dfV = 3;

    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String avZ() {
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
                aVar.oA(optString);
            }
            this.dfU = jSONObject.optInt("min-cache", this.dfU);
            this.dfV = jSONObject.optInt("max-cache", this.dfV);
            if (this.dfU <= this.dfV) {
                if (jSONObject.has("min-cache")) {
                    aVar.hK(this.dfU);
                }
                if (jSONObject.has("max-cache")) {
                    aVar.hL(this.dfV);
                }
            } else if (DEBUG) {
                Log.w("【InlineCommand】", "setZeusVideoExt: minCache " + this.dfU + " > maxCache " + this.dfV);
            }
        } catch (Exception e) {
        }
    }
}
