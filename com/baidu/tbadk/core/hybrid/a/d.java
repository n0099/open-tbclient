package com.baidu.tbadk.core.hybrid.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.hybrid.m;
import com.baidu.tbadk.core.hybrid.o;
import com.baidu.tbadk.core.hybrid.p;
import com.baidu.tbadk.core.util.av;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends o {
    private TbPageContext<?> abI;

    public d(m mVar, TbPageContext<?> tbPageContext) {
        super(mVar);
        this.abI = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.o
    public String oc() {
        return "TBHY_COMMON_Navigator";
    }

    @p("toNativePage")
    protected void toNativePage(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            String optString = jSONObject.optString("url");
            if (!StringUtils.isNull(optString)) {
                av.vI().c(this.abI, new String[]{optString});
            }
        }
    }
}
