package com.baidu.tbadk.core.c.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.c.n;
import com.baidu.tbadk.core.c.p;
import com.baidu.tbadk.core.c.q;
import com.baidu.tbadk.core.util.bi;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends p {
    private TbPageContext<?> DQ;

    public c(n nVar, TbPageContext<?> tbPageContext) {
        super(nVar);
        this.DQ = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.c.p
    public String mU() {
        return "TBHY_COMMON_Navigator";
    }

    @q("toNativePage")
    protected void toNativePage(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            String optString = jSONObject.optString("url");
            if (!StringUtils.isNull(optString)) {
                bi.us().c(this.DQ, new String[]{optString});
            }
        }
    }
}
