package com.baidu.tbadk.browser;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRankActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.data.WhiteListData;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.d;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes.dex */
public class d {
    public static boolean SY = true;

    public static void init() {
        MessageManager.getInstance().registerListener(2005016, new CustomMessageListener(0) { // from class: com.baidu.tbadk.browser.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && customResponsedMessage.getData() != null) {
                    a.ar(TbadkCoreApplication.getInst());
                }
            }
        });
        ax.wf().a(new ax.c() { // from class: com.baidu.tbadk.browser.d.2
            @Override // com.baidu.tbadk.core.util.ax.c
            public void a(TbPageContext<?> tbPageContext, String str, String str2, boolean z, ax.d dVar, boolean z2) {
                if (z2) {
                    d.c(tbPageContext, str2, null, false, true, true, true);
                } else {
                    d.a(tbPageContext, str2, str, z, true, true, true);
                }
            }
        });
        com.baidu.adp.lib.b.d.eE().a(new com.baidu.adp.lib.b.b("switch_mbaidu_startup", 1, null));
        pg();
        pi();
        pj();
    }

    private static void pg() {
        ax.wf().a(new ax.a() { // from class: com.baidu.tbadk.browser.d.3
            @Override // com.baidu.tbadk.core.util.ax.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                Bundle ho;
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
                } else if (str.contains("http://tieba.baidu.com/mo/q/hotMessage?topic_id=")) {
                    Uri parse = Uri.parse(str);
                    String queryParameter = parse.getQueryParameter(IntentConfig.TOPIC_ID);
                    String queryParameter2 = parse.getQueryParameter(IntentConfig.TOPIC_NAME);
                    if (TextUtils.isEmpty(queryParameter) || !com.baidu.tbadk.plugins.b.bV(true)) {
                        return 3;
                    }
                    tbPageContext.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(queryParameter, queryParameter2, null)));
                    return 0;
                } else if (str.startsWith("sms:")) {
                    String substring = str.substring(4);
                    String str4 = "";
                    if (str.contains("body=")) {
                        str4 = z.ar(str, "body=");
                        int indexOf = substring.indexOf("?");
                        if (indexOf >= 1) {
                            substring = substring.substring(0, indexOf - 1);
                        } else {
                            substring = "";
                        }
                    }
                    UtilHelper.smsTo(tbPageContext.getPageActivity(), substring, str4);
                    return 0;
                } else if (str.contains("jump=outer")) {
                    a.O(tbPageContext.getPageActivity(), str);
                    return 1;
                } else if (str.contains("jump=open_full_screen_web_page")) {
                    a.M(tbPageContext.getPageActivity(), str);
                    return 1;
                } else if ((str.contains("jump=finish_this_page") || str.startsWith("closewebview://")) && tbPageContext.getPageActivity() != null) {
                    tbPageContext.getPageActivity().finish();
                    return 1;
                } else if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains("pay=1") && (tbPageContext instanceof Activity)) {
                    UtilHelper.showToast(tbPageContext.getPageActivity(), d.k.buy_sucess);
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
                } else if (str.contains("tieba.baidu.com/mo/q/tbeanrights?") && str.contains("from=autopay")) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2016525, true));
                    tbPageContext.getPageActivity().finish();
                    return 1;
                } else if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains("bunding_phone=1")) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001359, z.ar(str, "bindid=")));
                    tbPageContext.getPageActivity().finish();
                    return 1;
                } else if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains("/changeyinjisuccess") && (ho = z.ho(str)) != null && "/changeyinjisuccess".equalsIgnoreCase(ho.getString(ClientCookie.PATH_ATTR))) {
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001372));
                    return 0;
                } else {
                    if (str.startsWith("opfeature:")) {
                        d.c(tbPageContext, a.L(str.replaceFirst("opfeature:", ""), str2), null, false, true, true, true);
                    } else if (str.startsWith("web:")) {
                        d.c(tbPageContext, a.L(str.replaceFirst("web:", ""), str2), null, false, true, true, true);
                    } else if (str.startsWith("topic:")) {
                        d.c(tbPageContext, str3, str.substring(6), false, true, true, false);
                    } else if (str.startsWith("zb:")) {
                        d.c(tbPageContext, str.substring(3), tbPageContext.getString(d.k.photo_live_tips), false, true, false, false);
                    } else if (!str.startsWith("list:")) {
                        return 3;
                    } else {
                        String substring2 = str.substring(5);
                        if (!TextUtils.isEmpty(substring2)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2902028, new ForumRankActivityConfig(tbPageContext.getPageActivity(), substring2, str2)));
                        }
                    }
                    return 3;
                }
            }
        });
    }

    private static String cn(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String checkUrl = TbadkCoreApplication.getInst().getCheckUrl();
        boolean z = !TextUtils.isEmpty(checkUrl) && str.startsWith(checkUrl);
        boolean startsWith = str.startsWith("http://tieba.baidu.com/mo/q/checkurl?url=");
        if (z || startsWith) {
            if (z) {
                str2 = str.substring(checkUrl.length());
            } else if (!startsWith) {
                str2 = null;
            } else {
                str2 = str.substring("http://tieba.baidu.com/mo/q/checkurl?url=".length());
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                    return URLDecoder.decode(str2, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    return str;
                }
            }
            return str;
        }
        return str;
    }

    private static String co(String str) {
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
            return checkUrl + cp(str);
        }
        return str;
    }

    public static String cp(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String str2 = new String(str.getBytes(), "UTF-8");
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
        String cn = cn(str);
        if (!cq(cn) && ph() && cs("com.baidu.searchbox") && cr(cn) && SY) {
            TiebaStatic.eventStat(tbPageContext.getPageActivity(), "url_2", null);
            b(tbPageContext, str, str2, z, z2, z3, z4);
            return;
        }
        c(tbPageContext, str, str2, z, z2, z3, z4);
    }

    private static boolean cq(String str) {
        return WhiteListData.createBySP().checkUrl(str);
    }

    private static boolean ph() {
        return com.baidu.adp.lib.b.d.eE().ak("switch_mbaidu_startup") == 1;
    }

    private static boolean cr(String str) {
        return str.startsWith("http://") || str.startsWith("https://") || !str.contains("://");
    }

    private static boolean cs(String str) {
        try {
            PackageInfo packageInfo = TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(str, 1);
            if (packageInfo == null) {
                return false;
            }
            return str.equals(packageInfo.packageName);
        } catch (Throwable th) {
            return false;
        }
    }

    private static void b(TbPageContext<?> tbPageContext, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        String L = a.L(str, null);
        Intent intent = new Intent();
        intent.setAction("com.baidu.searchbox.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.setData(Uri.parse(L));
        intent.putExtra("EXTRA_URL_NEW_WINDOW", true);
        try {
            TbadkCoreApplication.getInst().startActivity(intent);
            TiebaStatic.eventStat(tbPageContext.getPageActivity(), "url_3", null);
        } catch (Exception e) {
            BdLog.e(e);
            c(tbPageContext, str, str2, z, z2, z3, z4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(final TbPageContext<?> tbPageContext, String str, final String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        final String co = co(str);
        if (z) {
            com.baidu.tbadk.coreExtra.d.a.a(tbPageContext, new a.b() { // from class: com.baidu.tbadk.browser.d.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    a.f(TbPageContext.this.getPageActivity(), str2, co);
                }
            }, new a.b() { // from class: com.baidu.tbadk.browser.d.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }, co);
        } else {
            a.f(tbPageContext.getPageActivity(), str2, co);
        }
    }

    private static void pi() {
        ax.wf().a(new ax.a() { // from class: com.baidu.tbadk.browser.d.6
            @Override // com.baidu.tbadk.core.util.ax.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                PbActivityConfig createNormalCfg;
                if (strArr == null || strArr[0] == null) {
                    return 3;
                }
                Uri parse = Uri.parse(strArr[0]);
                if ("lego".equalsIgnoreCase(parse.getAuthority())) {
                    return !d.a(tbPageContext, parse, null, false) ? 3 : 0;
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
                    tbPageContext.sendMessage(new CustomMessage(2004001, createNormalCfg));
                    return 0;
                } else if ("frs".equalsIgnoreCase(parse.getAuthority())) {
                    String queryParameter3 = parse.getQueryParameter("kw");
                    if (queryParameter3 == null || queryParameter3.length() <= 0) {
                        return 3;
                    }
                    tbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(queryParameter3, "lego")));
                    return 0;
                } else if ("person".equalsIgnoreCase(parse.getAuthority())) {
                    String queryParameter4 = parse.getQueryParameter("uid");
                    String queryParameter5 = parse.getQueryParameter("uname");
                    if (queryParameter4 == null || queryParameter4.length() <= 0 || queryParameter5 == null || queryParameter5.length() <= 0) {
                        return 3;
                    }
                    tbPageContext.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(tbPageContext.getPageActivity(), queryParameter4, queryParameter5)));
                    return 0;
                } else if ("topic".equalsIgnoreCase(parse.getAuthority())) {
                    String queryParameter6 = parse.getQueryParameter(IntentConfig.TOPIC_ID);
                    String queryParameter7 = parse.getQueryParameter(IntentConfig.TOPIC_NAME);
                    if (queryParameter6 != null && queryParameter7 != null) {
                        tbPageContext.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(queryParameter6, queryParameter7, null)));
                        return 1;
                    } else if (queryParameter6 != null) {
                        tbPageContext.sendMessage(new CustomMessage(2002001, new HotTopicActivityConfig(tbPageContext.getPageActivity()).createNormalConfig(queryParameter6, null, null)));
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

    private static void pj() {
        ax.wf().a(new ax.a() { // from class: com.baidu.tbadk.browser.d.7
            @Override // com.baidu.tbadk.core.util.ax.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (strArr == null || strArr[0] == null) {
                    return 3;
                }
                String str = strArr[0];
                String str2 = null;
                if (str.startsWith("http://tieba.baidu.com/mo/q/blitz/index#") || str.startsWith("https://tieba.baidu.com/mo/q/blitz/index#")) {
                    int indexOf = str.indexOf("page/", 0) + "page/".length();
                    int indexOf2 = str.indexOf("?", 0);
                    if (indexOf > "page/".length() && indexOf2 > indexOf) {
                        str2 = str.substring(indexOf, indexOf2);
                    }
                    return (indexOf2 <= -1 || !d.a(tbPageContext, Uri.parse(new StringBuilder().append("tieba://lego?").append(str.substring(indexOf2 + 1)).toString()), str2, false)) ? 3 : 0;
                } else if (str.startsWith("http://tieba.baidu.com/tb/zt/lego/h5/#") || str.startsWith("https://tieba.baidu.com/tb/zt/lego/h5/#")) {
                    int indexOf3 = str.indexOf("page/", 0) + "page/".length();
                    int indexOf4 = str.indexOf("?", 0);
                    if (indexOf3 > "page/".length() && indexOf4 > indexOf3) {
                        str2 = str.substring(indexOf3, indexOf4);
                    }
                    return (indexOf4 <= -1 || !d.a(tbPageContext, Uri.parse(new StringBuilder().append("tieba://lego?").append(str.substring(indexOf4 + 1)).toString()), str2, true)) ? 3 : 0;
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
        String queryParameter3 = uri.getQueryParameter(LegoListActivityConfig.RN);
        String queryParameter4 = uri.getQueryParameter(LegoListActivityConfig.PARAMS);
        String queryParameter5 = uri.getQueryParameter(LegoListActivityConfig.PRE_LOAD);
        String queryParameter6 = uri.getQueryParameter(LegoListActivityConfig.NEXT_PAGE);
        String queryParameter7 = uri.getQueryParameter("lego_version");
        String queryParameter8 = uri.getQueryParameter(LegoListActivityConfig.IS_IMMERSIVE);
        String queryParameter9 = uri.getQueryParameter(LegoListActivityConfig.HAS_ANIMATION);
        String queryParameter10 = uri.getQueryParameter(LegoListActivityConfig.IS_LANDINGPAGE);
        String queryParameter11 = uri.getQueryParameter("source");
        String str3 = TextUtils.isEmpty(queryParameter11) ? "unknown" : queryParameter11;
        if ((!z || ct(queryParameter7)) && str != null && queryParameter != null && str.length() > 0 && queryParameter.length() > 0) {
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
                    tbPageContext.sendMessage(new CustomMessage(2016447, createNormalCfg));
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

    private static boolean ct(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "1.0.0";
        }
        return TbConfig.getLegoLibVersion().compareTo(str) >= 0;
    }

    public static boolean cu(String str) {
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
