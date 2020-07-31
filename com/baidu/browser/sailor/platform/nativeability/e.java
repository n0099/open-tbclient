package com.baidu.browser.sailor.platform.nativeability;

import com.baidu.browser.sailor.lightapp.BdLightappKernelJsCallback;
import com.baidu.browser.sailor.util.c;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
final class e implements c.a {
    final /* synthetic */ BdLightappKernelJsCallback adz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(BdLightappKernelJsCallback bdLightappKernelJsCallback) {
        this.adz = bdLightappKernelJsCallback;
    }

    @Override // com.baidu.browser.sailor.util.c.a
    public final void a(JSONObject jSONObject) {
        try {
            int i = jSONObject.getInt(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL);
            int i2 = jSONObject.getInt("scale");
            int i3 = jSONObject.getInt("plugged");
            this.adz.addField(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, String.valueOf(i2 != 0 ? i / i2 : 0.0f));
            this.adz.addField("plugged", String.valueOf(i3 != 0));
            this.adz.sendSuccCallBack();
        } catch (JSONException e) {
            this.adz.sendFailCallBack(e.getMessage());
            e.printStackTrace();
        }
    }
}
