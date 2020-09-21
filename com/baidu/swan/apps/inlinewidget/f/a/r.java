package com.baidu.swan.apps.inlinewidget.f.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class r extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.f.c.a> {
    private int cws = 1;
    private int cwt = 3;

    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String aot() {
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
                aVar.nx(optString);
            }
            this.cws = jSONObject.optInt("min-cache", this.cws);
            this.cwt = jSONObject.optInt("max-cache", this.cwt);
            if (this.cws <= this.cwt) {
                if (jSONObject.has("min-cache")) {
                    aVar.mo34if(this.cws);
                }
                if (jSONObject.has("max-cache")) {
                    aVar.ig(this.cwt);
                }
            } else if (DEBUG) {
                Log.w("【InlineCommand】", "setZeusVideoExt: minCache " + this.cws + " > maxCache " + this.cwt);
            }
        } catch (Exception e) {
        }
    }
}
