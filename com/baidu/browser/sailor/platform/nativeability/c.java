package com.baidu.browser.sailor.platform.nativeability;

import android.text.TextUtils;
import com.baidu.browser.sailor.lightapp.BdLightappKernelJsCallback;
import com.baidu.browser.sailor.util.c;
import org.json.JSONObject;
/* loaded from: classes11.dex */
final class c implements c.a {
    final /* synthetic */ BdLightappKernelJsCallback acJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(BdLightappKernelJsCallback bdLightappKernelJsCallback) {
        this.acJ = bdLightappKernelJsCallback;
    }

    @Override // com.baidu.browser.sailor.util.c.a
    public final void a(JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        this.acJ.sendCallBack((String) null, jSONObject2, !TextUtils.isEmpty(jSONObject2));
    }
}
