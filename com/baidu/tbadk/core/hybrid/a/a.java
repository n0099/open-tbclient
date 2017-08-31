package com.baidu.tbadk.core.hybrid.a;

import android.content.ClipboardManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.hybrid.p;
import com.baidu.tbadk.core.hybrid.t;
import com.baidu.tbadk.core.hybrid.u;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends t {
    public a(p pVar) {
        super(pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.t
    public String oc() {
        return "TBHY_COMMON_Clipboard";
    }

    @u("copy")
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
