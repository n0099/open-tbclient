package com.baidu.tbadk.browser;

import android.net.Uri;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.bh;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements bh.a {
    @Override // com.baidu.tbadk.core.util.bh.a
    public int a(TbPageContext<?> tbPageContext, String[] strArr) {
        PbActivityConfig createNormalCfg;
        boolean a;
        if (strArr == null || strArr[0] == null) {
            return 3;
        }
        Uri parse = Uri.parse(strArr[0]);
        if (!"lego".equalsIgnoreCase(parse.getAuthority())) {
            if ("pb".equalsIgnoreCase(parse.getAuthority())) {
                String queryParameter = parse.getQueryParameter("tId");
                String queryParameter2 = parse.getQueryParameter("view_type");
                if (queryParameter == null || queryParameter.length() <= 0) {
                    return 3;
                }
                if (queryParameter2 != null && (queryParameter2.equals("2") || queryParameter2.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE))) {
                    createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createViewTypeCfg(queryParameter, Boolean.valueOf(queryParameter2.equals("2")).booleanValue(), Boolean.valueOf(queryParameter2.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE) ? false : true).booleanValue(), "lego");
                    createNormalCfg.setVideo_source("frs");
                } else {
                    createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(queryParameter, null, "lego");
                }
                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                return 0;
            } else if ("frs".equalsIgnoreCase(parse.getAuthority())) {
                String queryParameter3 = parse.getQueryParameter("kw");
                if (queryParameter3 == null || queryParameter3.length() <= 0) {
                    return 3;
                }
                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(queryParameter3, "lego")));
                return 0;
            } else if ("person".equalsIgnoreCase(parse.getAuthority())) {
                String queryParameter4 = parse.getQueryParameter("uid");
                String queryParameter5 = parse.getQueryParameter("uname");
                if (queryParameter4 == null || queryParameter4.length() <= 0 || queryParameter5 == null || queryParameter5.length() <= 0) {
                    return 3;
                }
                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(tbPageContext.getPageActivity(), queryParameter4, queryParameter5)));
                return 0;
            } else if ("topic".equalsIgnoreCase(parse.getAuthority())) {
                String queryParameter6 = parse.getQueryParameter(IntentConfig.TOPIC_ID);
                String queryParameter7 = parse.getQueryParameter(IntentConfig.TOPIC_NAME);
                if (queryParameter6 != null && queryParameter7 != null) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(queryParameter6, queryParameter7, null)));
                    return 1;
                } else if (queryParameter6 != null) {
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(queryParameter6, null, null)));
                    return 1;
                } else {
                    return 3;
                }
            } else {
                return 3;
            }
        }
        a = Static.a(tbPageContext, parse, null);
        return !a ? 3 : 0;
    }
}
