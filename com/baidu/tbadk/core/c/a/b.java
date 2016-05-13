package com.baidu.tbadk.core.c.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.c.m;
import com.baidu.tbadk.core.c.o;
import com.baidu.tbadk.core.c.p;
import com.baidu.tbadk.core.util.bg;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends o {
    private TbPageContext<?> Do;

    public b(m mVar, TbPageContext<?> tbPageContext) {
        super(mVar);
        this.Do = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.c.o
    public String nj() {
        return "TBHY_COMMON_Navigator";
    }

    @p(sE = "toNativePage")
    protected void toNativePage(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("url");
            if (!StringUtils.isNull(optString)) {
                bg.ut().c(this.Do, new String[]{optString});
            }
        }
    }
}
