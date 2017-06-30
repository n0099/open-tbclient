package com.baidu.tbadk.core.hybrid.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.hybrid.s;
import com.baidu.tbadk.core.hybrid.w;
import com.baidu.tbadk.core.hybrid.x;
import com.baidu.tbadk.core.util.be;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends w {
    private TbPageContext<?> aat;

    public d(s sVar, TbPageContext<?> tbPageContext) {
        super(sVar);
        this.aat = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.w
    public String nT() {
        return "TBHY_COMMON_Navigator";
    }

    @x("toNativePage")
    protected void toNativePage(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            String optString = jSONObject.optString("url");
            if (!StringUtils.isNull(optString)) {
                be.vP().c(this.aat, new String[]{optString});
            }
        }
    }
}
