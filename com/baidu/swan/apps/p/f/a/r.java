package com.baidu.swan.apps.p.f.a;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class r extends com.baidu.swan.apps.p.a<com.baidu.swan.apps.p.f.b.a> {
    private int cmU = 1;
    private int cmV = 3;

    @Override // com.baidu.swan.apps.p.a
    @NonNull
    public String agB() {
        return "setZeusVideoExt";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.p.a
    public void a(@NonNull ZeusPlugin.Command command, @NonNull com.baidu.swan.apps.p.f.b.a aVar) {
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
            this.cmU = jSONObject.optInt("min-cache", this.cmU);
            this.cmV = jSONObject.optInt("max-cache", this.cmV);
            if (this.cmU <= this.cmV) {
                if (jSONObject.has("min-cache")) {
                    aVar.fR(this.cmU);
                }
                if (jSONObject.has("max-cache")) {
                    aVar.fS(this.cmV);
                }
            } else if (DEBUG) {
                Log.w("【InlineCommand】", "setZeusVideoExt: minCache " + this.cmU + " > maxCache " + this.cmV);
            }
        } catch (Exception e) {
            if (DEBUG) {
                throw new RuntimeException("setZeusVideoExt with a illegal str", e);
            }
        }
    }
}
