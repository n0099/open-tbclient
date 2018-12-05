package com.baidu.browser.sailor.b.b;

import com.baidu.browser.sailor.a.n;
import com.baidu.browser.sailor.util.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
final class e implements d.a {
    final /* synthetic */ n WI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(n nVar) {
        this.WI = nVar;
    }

    @Override // com.baidu.browser.sailor.util.d.a
    public final void a(JSONObject jSONObject) {
        try {
            int i = jSONObject.getInt("level");
            int i2 = jSONObject.getInt("scale");
            int i3 = jSONObject.getInt("plugged");
            this.WI.addField("level", String.valueOf(i2 != 0 ? i / i2 : 0.0f));
            this.WI.addField("plugged", String.valueOf(i3 != 0));
            this.WI.qN();
        } catch (JSONException e) {
            this.WI.cA(e.getMessage());
            e.printStackTrace();
        }
    }
}
