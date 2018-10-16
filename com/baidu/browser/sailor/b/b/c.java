package com.baidu.browser.sailor.b.b;

import android.text.TextUtils;
import com.baidu.browser.sailor.a.n;
import com.baidu.browser.sailor.util.d;
import org.json.JSONObject;
/* loaded from: classes2.dex */
final class c implements d.a {
    final /* synthetic */ n WG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(n nVar) {
        this.WG = nVar;
    }

    @Override // com.baidu.browser.sailor.util.d.a
    public final void a(JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        this.WG.c(null, jSONObject2, !TextUtils.isEmpty(jSONObject2));
    }
}
