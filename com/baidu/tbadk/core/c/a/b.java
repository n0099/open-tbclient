package com.baidu.tbadk.core.c.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.c.m;
import com.baidu.tbadk.core.c.o;
import com.baidu.tbadk.core.c.p;
import com.baidu.tbadk.core.util.bi;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends o {
    private TbPageContext<?> Dp;

    public b(m mVar, TbPageContext<?> tbPageContext) {
        super(mVar);
        this.Dp = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.c.o
    public String ne() {
        return "TBHY_COMMON_Navigator";
    }

    @p("toNativePage")
    protected void toNativePage(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("url");
            if (!StringUtils.isNull(optString)) {
                bi.us().c(this.Dp, new String[]{optString});
            }
        }
    }
}
