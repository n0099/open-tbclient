package com.baidu.swan.apps.p.e.a;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class r extends com.baidu.swan.apps.p.a<com.baidu.swan.apps.p.e.b.a> {
    private int cgb = 1;
    private int cgc = 3;

    @Override // com.baidu.swan.apps.p.a
    @NonNull
    public String aek() {
        return "setZeusVideoExt";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.p.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.p.e.b.a aVar) {
        Object obj = command.obj;
        if (!(obj instanceof String)) {
            if (DEBUG) {
                throw new RuntimeException("setZeusVideoExt with a illegal obj " + (obj == null));
            }
            return;
        }
        a(aVar, command.what, "setZeusVideoExt:" + obj, true);
        try {
            JSONObject jSONObject = new JSONObject((String) obj);
            this.cgb = jSONObject.optInt("min-cache", this.cgb);
            this.cgc = jSONObject.optInt("max-cache", this.cgc);
            if (this.cgb <= this.cgc) {
                if (jSONObject.has("min-cache")) {
                    aVar.fw(this.cgb);
                }
                if (jSONObject.has("max-cache")) {
                    aVar.fx(this.cgc);
                }
            } else if (DEBUG) {
                Log.w("【InlineCommand】", "setZeusVideoExt: minCache " + this.cgb + " > maxCache " + this.cgc);
            }
        } catch (Exception e) {
            if (DEBUG) {
                throw new RuntimeException("setZeusVideoExt with a illegal str", e);
            }
        }
    }
}
