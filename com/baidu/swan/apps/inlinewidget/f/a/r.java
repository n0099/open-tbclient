package com.baidu.swan.apps.inlinewidget.f.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class r extends com.baidu.swan.apps.inlinewidget.a<com.baidu.swan.apps.inlinewidget.f.c.a> {
    private int cVd = 1;
    private int cVe = 3;

    @Override // com.baidu.swan.apps.inlinewidget.a
    @NonNull
    public String auS() {
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
                aVar.oM(optString);
            }
            this.cVd = jSONObject.optInt("min-cache", this.cVd);
            this.cVe = jSONObject.optInt("max-cache", this.cVe);
            if (this.cVd <= this.cVe) {
                if (jSONObject.has("min-cache")) {
                    aVar.iT(this.cVd);
                }
                if (jSONObject.has("max-cache")) {
                    aVar.iU(this.cVe);
                }
            } else if (DEBUG) {
                Log.w("【InlineCommand】", "setZeusVideoExt: minCache " + this.cVd + " > maxCache " + this.cVe);
            }
        } catch (Exception e) {
        }
    }
}
