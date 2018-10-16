package com.baidu.browser.sailor.b.b;

import com.baidu.browser.sailor.a.n;
import com.baidu.browser.sailor.util.d;
import com.baidu.searchbox.ng.ai.apps.canvas.action.draw.DaScale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
final class e implements d.a {
    final /* synthetic */ n WG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(n nVar) {
        this.WG = nVar;
    }

    @Override // com.baidu.browser.sailor.util.d.a
    public final void a(JSONObject jSONObject) {
        try {
            int i = jSONObject.getInt("level");
            int i2 = jSONObject.getInt(DaScale.ACTION_TYPE);
            int i3 = jSONObject.getInt("plugged");
            this.WG.addField("level", String.valueOf(i2 != 0 ? i / i2 : 0.0f));
            this.WG.addField("plugged", String.valueOf(i3 != 0));
            this.WG.qQ();
        } catch (JSONException e) {
            this.WG.cA(e.getMessage());
            e.printStackTrace();
        }
    }
}
