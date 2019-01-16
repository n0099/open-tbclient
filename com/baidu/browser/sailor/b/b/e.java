package com.baidu.browser.sailor.b.b;

import com.baidu.browser.sailor.a.n;
import com.baidu.browser.sailor.util.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
final class e implements d.a {
    final /* synthetic */ n WR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(n nVar) {
        this.WR = nVar;
    }

    @Override // com.baidu.browser.sailor.util.d.a
    public final void a(JSONObject jSONObject) {
        try {
            int i = jSONObject.getInt("level");
            int i2 = jSONObject.getInt("scale");
            int i3 = jSONObject.getInt("plugged");
            this.WR.addField("level", String.valueOf(i2 != 0 ? i / i2 : 0.0f));
            this.WR.addField("plugged", String.valueOf(i3 != 0));
            this.WR.qR();
        } catch (JSONException e) {
            this.WR.cB(e.getMessage());
            e.printStackTrace();
        }
    }
}
