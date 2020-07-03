package com.baidu.swan.apps.p.e.a;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class r extends com.baidu.swan.apps.p.a<com.baidu.swan.apps.p.e.b.a> {
    private int ckP = 1;
    private int ckQ = 3;

    @Override // com.baidu.swan.apps.p.a
    @NonNull
    public String afq() {
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
            this.ckP = jSONObject.optInt("min-cache", this.ckP);
            this.ckQ = jSONObject.optInt("max-cache", this.ckQ);
            if (this.ckP <= this.ckQ) {
                if (jSONObject.has("min-cache")) {
                    aVar.fH(this.ckP);
                }
                if (jSONObject.has("max-cache")) {
                    aVar.fI(this.ckQ);
                }
            } else if (DEBUG) {
                Log.w("【InlineCommand】", "setZeusVideoExt: minCache " + this.ckP + " > maxCache " + this.ckQ);
            }
        } catch (Exception e) {
            if (DEBUG) {
                throw new RuntimeException("setZeusVideoExt with a illegal str", e);
            }
        }
    }
}
