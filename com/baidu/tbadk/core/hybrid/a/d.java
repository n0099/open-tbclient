package com.baidu.tbadk.core.hybrid.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.hybrid.p;
import com.baidu.tbadk.core.hybrid.t;
import com.baidu.tbadk.core.hybrid.u;
import com.baidu.tbadk.core.util.au;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends t {
    private TbPageContext<?> aby;

    public d(p pVar, TbPageContext<?> tbPageContext) {
        super(pVar);
        this.aby = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.t
    public String oc() {
        return "TBHY_COMMON_Navigator";
    }

    @u("toNativePage")
    protected void toNativePage(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            String optString = jSONObject.optString("url");
            if (!StringUtils.isNull(optString)) {
                au.wd().c(this.aby, new String[]{optString});
            }
        }
    }
}
