package com.baidu.swan.apps.inlinewidget.f.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class r extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.f.c.a> {
    private int dgU = 1;
    private int dgV = 3;

    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String azr() {
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
                aVar.pm(optString);
            }
            this.dgU = jSONObject.optInt("min-cache", this.dgU);
            this.dgV = jSONObject.optInt("max-cache", this.dgV);
            if (this.dgU <= this.dgV) {
                if (jSONObject.has("min-cache")) {
                    aVar.jm(this.dgU);
                }
                if (jSONObject.has("max-cache")) {
                    aVar.jn(this.dgV);
                }
            } else if (DEBUG) {
                Log.w("【InlineCommand】", "setZeusVideoExt: minCache " + this.dgU + " > maxCache " + this.dgV);
            }
        } catch (Exception e) {
        }
    }
}
