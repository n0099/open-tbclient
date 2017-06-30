package com.baidu.tbadk.core.hybrid.a;

import android.content.ClipboardManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.hybrid.s;
import com.baidu.tbadk.core.hybrid.w;
import com.baidu.tbadk.core.hybrid.x;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends w {
    public a(s sVar) {
        super(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.w
    public String nT() {
        return "TBHY_COMMON_Clipboard";
    }

    @x("copy")
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
