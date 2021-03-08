package com.baidu.tbadk.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.searchbox.aps.megapp_interface.BuildConfig;
import com.baidu.tbadk.BdToken.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ForumRankActivityConfig;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.t;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
/* loaded from: classes.dex */
public class c {
    public static boolean eIM = true;

    public static void init() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE, new CustomMessageListener(0) { // from class: com.baidu.tbadk.browser.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && customResponsedMessage.getData() != null) {
                    a.initCookie(TbadkCoreApplication.getInst());
                }
            }
        });
        bf.bsY().a(new bf.c() { // from class: com.baidu.tbadk.browser.c.2
            @Override // com.baidu.tbadk.core.util.bf.c
            public void a(TbPageContext<?> tbPageContext, String str, String str2, boolean z, bf.d dVar, boolean z2) {
                if (z2) {
                    c.b(tbPageContext, str2, null, false, true, true, true);
                } else {
                    c.a(tbPageContext, str2, str, z, true, true, true);
                }
            }
        });
        SwitchManager.getInstance().addSwitchData(new com.baidu.adp.lib.featureSwitch.b("switch_mbaidu_startup", 1, null));
        bkx();
        bky();
        bkz();
    }

    private static void bkx() {
        bf.bsY().a(new bf.a() { // from class: com.baidu.tbadk.browser.c.3
            @Override // com.baidu.tbadk.core.util.bf.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                Bundle parserQuery;
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (StringUtils.isNull(str)) {
                    return 3;
                }
                str.toLowerCase();
                String str2 = strArr.length > 2 ? strArr[2] : null;
                String str3 = strArr.length > 1 ? strArr[1] : null;
                if (str.startsWith("tel:")) {
                    UtilHelper.callPhone(tbPageContext.getPageActivity(), str.substring(4));
                    return 0;
                } else if (al.Ed(str) && str.toLowerCase().endsWith(".apk")) {
                    c.az(tbPageContext.getPageActivity(), str);
                    return 0;
                } else if (str.contains("http://tieba.baidu.com/mo/q/hotMessage?topic_id=")) {
                    Uri parse = Uri.parse(str);
                    String queryParameter = parse.getQueryParameter("topic_id");
                    String queryParameter2 = parse.getQueryParameter("topic_name");
                    if (TextUtils.isEmpty(queryParameter) || !com.baidu.tbadk.plugins.b.lq(true)) {
                        return 3;
                    }
                    String str4 = "";
                    if (strArr != null && strArr.length > 1 && !StringUtils.isNull(strArr[1])) {
                        str4 = strArr[1];
                    }
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(queryParameter, queryParameter2, str4)));
                    return 0;
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SMS)) {
                    String substring = str.substring(4);
                    String str5 = "";
                    if (str.contains("body=")) {
                        str5 = al.getMatchStringFromURL(str, "body=");
                        int indexOf = substring.indexOf("?");
                        if (indexOf >= 1 && indexOf <= substring.length()) {
                            substring = substring.substring(0, indexOf);
                        } else {
                            substring = "";
                        }
                    }
                    UtilHelper.smsTo(tbPageContext.getPageActivity(), substring, str5);
                    return 0;
                } else if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_JUMP_OUTER)) {
                    a.startExternWebActivity(tbPageContext.getPageActivity(), str);
                    return 1;
                } else if (UtilHelper.isNativeAdURL(str)) {
                    t.i(tbPageContext.getPageActivity(), str, null, null);
                    return 1;
                } else if (str.contains(UrlSchemaHelper.JUMP_TO_NEW_PAGE) || str.contains("jump=open_screen_web_page")) {
                    a.startWebActivity(tbPageContext.getPageActivity(), str);
                    return 1;
                } else if ((str.contains(UrlSchemaHelper.SCHEMA_TYPE_FINISH_THIS_PAGE) || str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_CLOSE_WEBVIEW)) && tbPageContext.getPageActivity() != null) {
                    tbPageContext.getPageActivity().finish();
                    return 1;
                } else if (str.contains("jump_tieba_native=1") && str.contains(UrlSchemaHelper.TBEAN_TOAST) && (tbPageContext instanceof Activity)) {
                    UtilHelper.showToast(tbPageContext.getPageActivity(), R.string.buy_sucess);
                    ((Activity) tbPageContext).finish();
                    return 0;
                } else if (str.startsWith("tieba://focusforum")) {
                    TbadkCoreApplication.getInst().setLikeBarChanged(true);
                    return 0;
                } else if (str.startsWith("baiduxiuba://")) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.setData(Uri.parse(str));
                    intent.setFlags(268435456);
                    tbPageContext.getPageActivity().startActivity(intent);
                    return 0;
                } else if (str.contains(UrlSchemaHelper.AUTO_PAY_MEMBER_SUCC_URL) && str.contains(UrlSchemaHelper.AUTO_PAY_MEMBER_SUCC_PARAM)) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_AUTO_PAY_SUCC, true));
                    tbPageContext.getPageActivity().finish();
                    return 1;
                } else if (str.contains("jump_tieba_native=1") && str.contains(UrlSchemaHelper.GOTO_TDOU_PAY_BUNDING_PHONE)) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_TDOU_PAY_BUNDING_PHONE, al.getMatchStringFromURL(str, "bindid=")));
                    tbPageContext.getPageActivity().finish();
                    return 1;
                } else if (str.contains("jump_tieba_native=1") && str.contains(UrlSchemaHelper.CHANGE_YINJI_SUCCESS) && (parserQuery = al.parserQuery(str)) != null && UrlSchemaHelper.CHANGE_YINJI_SUCCESS.equalsIgnoreCase(parserQuery.getString("path"))) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_YINJIN_CHANGE));
                    return 0;
                } else if (str.startsWith("tieba://accountsafe") && tbPageContext.getPageActivity() != null) {
                    MessageManager.getInstance().runTask(2921329, null, tbPageContext.getPageActivity());
                    return 0;
                } else if (str.contains("unidispatch/forumsquare") && tbPageContext.getPageActivity() != null) {
                    ForumSquareActivityConfig forumSquareActivityConfig = new ForumSquareActivityConfig(tbPageContext.getPageActivity());
                    forumSquareActivityConfig.setUri(Uri.parse(str));
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumSquareActivityConfig));
                    return 0;
                } else if (str.contains("unidispatch/enterforum") && tbPageContext.getPageActivity() != null) {
                    MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(1);
                    String queryParameter3 = Uri.parse(str).getQueryParameter(f.eFw);
                    if (!au.isEmpty(queryParameter3)) {
                        createNormalCfg.setSubTab(0, queryParameter3);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, createNormalCfg));
                    return 0;
                } else {
                    if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_OPFEATURE)) {
                        c.b(tbPageContext, a.parseWebViewUrl(str.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_OPFEATURE, ""), str2), null, false, true, true, true);
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_WEB)) {
                        c.b(tbPageContext, a.parseWebViewUrl(str.replaceFirst(UrlSchemaHelper.SCHEMA_TYPE_WEB, ""), str2), null, false, true, true, true);
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TOPIC)) {
                        c.b(tbPageContext, str3, str.substring(6), false, true, true, false);
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_ZB)) {
                        c.b(tbPageContext, str.substring(3), tbPageContext.getString(R.string.photo_live_tips), false, true, false, false);
                    } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_LIST)) {
                        String substring2 = str.substring(5);
                        if (!TextUtils.isEmpty(substring2)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SQUARE_FORUM_RANK, new ForumRankActivityConfig(tbPageContext.getPageActivity(), substring2, str2)));
                        }
                    } else if (!str.contains("com.baidu.tieba://unidispatch/tbwebview")) {
                        return 3;
                    } else {
                        Uri parse2 = Uri.parse(str);
                        if (parse2 != null) {
                            c.b(tbPageContext, parse2.getQueryParameter("url"), null, false, true, false, false);
                            return 0;
                        }
                    }
                    return 3;
                }
            }
        });
    }

    private static String zG(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        String checkUrl = TbadkCoreApplication.getInst().getCheckUrl();
        if (checkUrl == null) {
            checkUrl = "http://tieba.baidu.com/mo/q/checkurl?url=";
        } else if (checkUrl.trim().length() == 0) {
            return str;
        }
        if (!str.startsWith(checkUrl)) {
            return checkUrl + toURLEncoded(str);
        }
        return str;
    }

    public static String toURLEncoded(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String str2 = new String(str.getBytes(), StandardCharsets.UTF_8);
            try {
                return URLEncoder.encode(str2, "UTF-8");
            } catch (Exception e) {
                return str2;
            }
        } catch (Exception e2) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(TbPageContext<?> tbPageContext, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        TiebaStatic.eventStat(tbPageContext.getPageActivity(), "url_1", null);
        b(tbPageContext, str, str2, z, z2, z3, z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final TbPageContext<?> tbPageContext, String str, final String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        final String zG = zG(str);
        if (z) {
            com.baidu.tbadk.coreExtra.c.a.a(tbPageContext, new a.b() { // from class: com.baidu.tbadk.browser.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    a.startWebActivity(TbPageContext.this.getPageActivity(), str2, zG);
                }
            }, new a.b() { // from class: com.baidu.tbadk.browser.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }, zG);
        } else {
            a.startWebActivity(tbPageContext.getPageActivity(), str2, zG);
        }
    }

    public static boolean az(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                context.startActivity(intent);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void bky() {
        bf.bsY().a(new bf.a() { // from class: com.baidu.tbadk.browser.c.6
            @Override // com.baidu.tbadk.core.util.bf.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                PbActivityConfig createNormalCfg;
                if (strArr == null || strArr[0] == null) {
                    return 3;
                }
                Uri parse = Uri.parse(strArr[0]);
                if ("lego".equalsIgnoreCase(parse.getAuthority())) {
                    return !c.a(tbPageContext, parse, null, false) ? 3 : 0;
                } else if ("pb".equalsIgnoreCase(parse.getAuthority())) {
                    String queryParameter = parse.getQueryParameter("tId");
                    String queryParameter2 = parse.getQueryParameter("view_type");
                    if (queryParameter == null || queryParameter.length() <= 0) {
                        return 3;
                    }
                    if (queryParameter2 != null && (queryParameter2.equals("2") || queryParameter2.equals("3"))) {
                        createNormalCfg = new PbActivityConfig(tbPageContext.getPageActivity()).createViewTypeCfg(queryParameter, Boolean.valueOf(queryParameter2.equals("2")).booleanValue(), Boolean.valueOf(queryParameter2.equals("3") ? false : true).booleanValue(), "lego");
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
                    FrsActivityConfig createNormalCfg2 = new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(queryParameter3, "lego");
                    createNormalCfg2.setCallFrom(12);
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, createNormalCfg2));
                    return 0;
                } else if (AlbumActivityConfig.FROM_PERSON.equalsIgnoreCase(parse.getAuthority())) {
                    String queryParameter4 = parse.getQueryParameter("uid");
                    String queryParameter5 = parse.getQueryParameter(BdStatsConstant.StatsKey.UNAME);
                    if (queryParameter4 == null || queryParameter4.length() <= 0) {
                        return 3;
                    }
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(tbPageContext.getPageActivity(), queryParameter4, queryParameter5)));
                    return 0;
                } else if (AlbumActivityConfig.FROM_TOPIC.equalsIgnoreCase(parse.getAuthority())) {
                    String queryParameter6 = parse.getQueryParameter("topic_id");
                    String queryParameter7 = parse.getQueryParameter("topic_name");
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
        });
    }

    private static void bkz() {
        bf.bsY().a(new bf.a() { // from class: com.baidu.tbadk.browser.c.7
            @Override // com.baidu.tbadk.core.util.bf.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr[0] == null) {
                    return 3;
                }
                String str = strArr[0];
                String str2 = null;
                if (str.startsWith("http://tieba.baidu.com/mo/q/blitz/index#") || str.startsWith("https://tieba.baidu.com/mo/q/blitz/index#")) {
                    int indexOf = str.indexOf("page/") + "page/".length();
                    int indexOf2 = str.indexOf("?");
                    if (indexOf > "page/".length() && indexOf2 > indexOf) {
                        str2 = str.substring(indexOf, indexOf2);
                    }
                    return (indexOf2 <= -1 || !c.a(tbPageContext, Uri.parse(new StringBuilder().append(UrlSchemaHelper.SCHEMA_TYPE_LEGO).append(str.substring(indexOf2 + 1)).toString()), str2, false)) ? 3 : 0;
                } else if (str.startsWith("http://tieba.baidu.com/tb/zt/lego/h5/#") || str.startsWith("https://tieba.baidu.com/tb/zt/lego/h5/#")) {
                    int indexOf3 = str.indexOf("page/") + "page/".length();
                    int indexOf4 = str.indexOf("?");
                    if (indexOf3 > "page/".length() && indexOf4 > indexOf3) {
                        str2 = str.substring(indexOf3, indexOf4);
                    }
                    return (indexOf4 <= -1 || !c.a(tbPageContext, Uri.parse(new StringBuilder().append(UrlSchemaHelper.SCHEMA_TYPE_LEGO).append(str.substring(indexOf4 + 1)).toString()), str2, true)) ? 3 : 0;
                } else {
                    return 3;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(TbPageContext<?> tbPageContext, Uri uri, String str, boolean z) {
        int i;
        int i2;
        int i3;
        String str2;
        int i4;
        if (tbPageContext == null || uri == null) {
            return false;
        }
        if (str == null || str.length() == 0) {
            str = uri.getQueryParameter("page_id");
        }
        String queryParameter = uri.getQueryParameter("page_type");
        String queryParameter2 = uri.getQueryParameter(LegoListActivityConfig.ITEM_ID);
        String queryParameter3 = uri.getQueryParameter("rn");
        String queryParameter4 = uri.getQueryParameter("params");
        String queryParameter5 = uri.getQueryParameter(LegoListActivityConfig.PRE_LOAD);
        String queryParameter6 = uri.getQueryParameter(LegoListActivityConfig.NEXT_PAGE);
        String queryParameter7 = uri.getQueryParameter("lego_version");
        String queryParameter8 = uri.getQueryParameter(LegoListActivityConfig.IS_IMMERSIVE);
        String queryParameter9 = uri.getQueryParameter(LegoListActivityConfig.HAS_ANIMATION);
        String queryParameter10 = uri.getQueryParameter(LegoListActivityConfig.IS_LANDINGPAGE);
        String queryParameter11 = uri.getQueryParameter("source");
        String str3 = TextUtils.isEmpty(queryParameter11) ? "unknown" : queryParameter11;
        if ((!z || zH(queryParameter7)) && str != null && queryParameter != null && str.length() > 0 && queryParameter.length() > 0) {
            try {
                int parseInt = Integer.parseInt(queryParameter);
                try {
                    long parseLong = Long.parseLong(str);
                    try {
                        i = Integer.parseInt(queryParameter3);
                    } catch (Exception e) {
                        i = 20;
                    }
                    try {
                        i2 = Integer.parseInt(queryParameter8);
                    } catch (Exception e2) {
                        i2 = 0;
                    }
                    try {
                        i3 = Integer.parseInt(queryParameter9);
                    } catch (Exception e3) {
                        i3 = 0;
                    }
                    if (i3 != 1) {
                        str2 = "";
                    } else {
                        str2 = uri.getQueryParameter(LegoListActivityConfig.ANIMATION_INFO);
                    }
                    try {
                        i4 = Integer.parseInt(queryParameter10);
                    } catch (Exception e4) {
                        i4 = 0;
                    }
                    LegoListActivityConfig createNormalCfg = new LegoListActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(parseLong, parseInt, queryParameter2, i2, i, queryParameter4);
                    createNormalCfg.addLandingPageParams(str2, queryParameter5, queryParameter6, i3, i4, str3);
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_LEGO_LIST, createNormalCfg));
                    return true;
                } catch (Exception e5) {
                    return false;
                }
            } catch (Exception e6) {
                return false;
            }
        }
        return false;
    }

    private static boolean zH(String str) {
        if (TextUtils.isEmpty(str)) {
            str = BuildConfig.VERSION_NAME;
        }
        return TbConfig.getLegoLibVersion().compareTo(str) >= 0;
    }

    public static boolean zI(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return "lego".equalsIgnoreCase(Uri.parse(str).getAuthority());
        } catch (Throwable th) {
            return false;
        }
    }
}
