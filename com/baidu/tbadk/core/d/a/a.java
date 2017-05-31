package com.baidu.tbadk.core.d.a;

import android.content.ClipboardManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.d.n;
import com.baidu.tbadk.core.d.p;
import com.baidu.tbadk.core.d.q;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends p {
    public a(n nVar) {
        super(nVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.d.p
    public String nX() {
        return "TBHY_COMMON_Clipboard";
    }

    @q("copy")
    protected JSONObject copyToClipboard(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            String optString = jSONObject.optString(PushConstants.EXTRA_PUSH_MESSAGE);
            if (!StringUtils.isNull(optString)) {
                ((ClipboardManager) getContext().getSystemService("clipboard")).setText(optString.trim());
                jSONObject2.put("status", 0);
                jSONObject2.put(PushConstants.EXTRA_PUSH_MESSAGE, "");
                return jSONObject2;
            }
        }
        jSONObject2.put("status", -1);
        jSONObject2.put(PushConstants.EXTRA_PUSH_MESSAGE, "无效内容");
        return jSONObject2;
    }
}
