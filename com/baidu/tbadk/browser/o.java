package com.baidu.tbadk.browser;

import android.net.Uri;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements bg.a {
    @Override // com.baidu.tbadk.core.util.bg.a
    public int a(TbPageContext<?> tbPageContext, String[] strArr) {
        boolean a;
        if (strArr == null || strArr[0] == null) {
            return 3;
        }
        Uri parse = Uri.parse(strArr[0]);
        if (!"lego".equalsIgnoreCase(parse.getAuthority())) {
            if ("pb".equalsIgnoreCase(parse.getAuthority())) {
                String queryParameter = parse.getQueryParameter("tId");
                if (queryParameter == null || queryParameter.length() <= 0) {
                    return 3;
                }
                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(queryParameter, null, "lego")));
                return 0;
            } else if ("frs".equalsIgnoreCase(parse.getAuthority())) {
                String queryParameter2 = parse.getQueryParameter("kw");
                if (queryParameter2 == null || queryParameter2.length() <= 0) {
                    return 3;
                }
                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(queryParameter2, "lego")));
                return 0;
            } else if ("person".equalsIgnoreCase(parse.getAuthority())) {
                String queryParameter3 = parse.getQueryParameter("uid");
                String queryParameter4 = parse.getQueryParameter("uname");
                if (queryParameter3 == null || queryParameter3.length() <= 0 || queryParameter4 == null || queryParameter4.length() <= 0) {
                    return 3;
                }
                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(tbPageContext.getPageActivity(), queryParameter3, queryParameter4)));
                return 0;
            } else {
                return 3;
            }
        }
        a = Static.a(tbPageContext, parse, null);
        return !a ? 3 : 0;
    }
}
