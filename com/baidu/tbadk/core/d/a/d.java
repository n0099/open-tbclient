package com.baidu.tbadk.core.d.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.d.n;
import com.baidu.tbadk.core.d.p;
import com.baidu.tbadk.core.d.q;
import com.baidu.tbadk.core.util.bb;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends p {
    private TbPageContext<?> aaI;

    public d(n nVar, TbPageContext<?> tbPageContext) {
        super(nVar);
        this.aaI = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.d.p
    public String ob() {
        return "TBHY_COMMON_Navigator";
    }

    @q("toNativePage")
    protected void toNativePage(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            String optString = jSONObject.optString("url");
            if (!StringUtils.isNull(optString)) {
                bb.vQ().c(this.aaI, new String[]{optString});
            }
        }
    }
}
