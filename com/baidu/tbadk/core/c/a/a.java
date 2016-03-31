package com.baidu.tbadk.core.c.a;

import android.content.ClipboardManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.c.m;
import com.baidu.tbadk.core.c.o;
import com.baidu.tbadk.core.c.p;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends o {
    public a(m mVar) {
        super(mVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.c.o
    public String pT() {
        return "TBHY_COMMON_Clipboard";
    }

    @p("copy")
    protected JSONObject copyToClipboard(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            String optString = jSONObject.optString("message");
            if (!StringUtils.isNull(optString)) {
                ((ClipboardManager) getContext().getSystemService("clipboard")).setText(optString.trim());
                jSONObject2.put("status", 0);
                jSONObject2.put("message", "");
                return jSONObject2;
            }
        }
        jSONObject2.put("status", -1);
        jSONObject2.put("message", "无效内容");
        return jSONObject2;
    }
}
