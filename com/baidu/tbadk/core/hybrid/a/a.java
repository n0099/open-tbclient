package com.baidu.tbadk.core.hybrid.a;

import android.content.ClipboardManager;
import android.support.v4.app.NotificationCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.hybrid.l;
import com.baidu.tbadk.core.hybrid.n;
import com.baidu.tbadk.core.hybrid.o;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends n {
    public a(l lVar) {
        super(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.n
    public String tt() {
        return "TBHY_COMMON_Clipboard";
    }

    @o("copy")
    protected JSONObject copyToClipboard(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            String optString = jSONObject.optString("message");
            if (!StringUtils.isNull(optString)) {
                ((ClipboardManager) getContext().getSystemService("clipboard")).setText(optString.trim());
                jSONObject2.put(NotificationCompat.CATEGORY_STATUS, 0);
                jSONObject2.put("message", "");
                return jSONObject2;
            }
        }
        jSONObject2.put(NotificationCompat.CATEGORY_STATUS, -1);
        jSONObject2.put("message", "无效内容");
        return jSONObject2;
    }
}
