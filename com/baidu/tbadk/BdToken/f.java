package com.baidu.tbadk.BdToken;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static String eEW = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String eEX = "/homepage";
    public static String eEY = "/enterforum";
    public static String eEZ = "/recommendforum";
    public static String eFa = "/frs";
    public static String eFb = "/pb";
    public static String eFc = "/tbwebview";
    public static String eFd = "/usercenter";
    public static String eFe = "/topicdetail";
    public static String eFf = "/tiebachushou";
    public static String eFg = "/activitypage";
    public static String eFh = "/minapp";
    public static String eFi = "/onekeysign";
    public static String eFj = "/hotuserrank";
    public static String eFk = "/forumRuleDetail";
    public static String eFl = "extdata";
    public static String eFm = "kw";
    public static String eFn = "tid";
    public static String eFo = "ori_ugc_nid";
    public static String eFp = "ori_ugc_tid";
    public static String eFq = "ori_ugc_type";
    public static String eFr = "ori_ugc_vid";
    public static String eFs = "portrait";
    public static String eFt = "topic_id";
    public static String PARAM_URL = "url";
    public static String eFu = "schemefrom";
    public static String PARAM_FROM = "from";
    public static String eFv = "token";
    public static String eFw = "tab_name";
    public static String eFx = "maintablocate";
    public static String eFy = "maintab_subtab";
    public static String eFz = "newgod_from";
    public static String eFA = "field_id";
    public static String eFB = "chushou_third_live_type";
    public static String eFC = "chuchou_third_room_id";
    public static String eFD = "hotTrend";
    public static String eFE = "tab_id";
    public static String eFF = "param_uri";
    public static String eFG = TbTitleActivityConfig.FORUM_ID;
    public static String eFH = LegoListActivityConfig.ITEM_ID;
    public static String eFI = "from_h5";
    public static String eFJ = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void onCallBack(HashMap<String, Object> hashMap);
    }

    public static final f bhJ() {
        return b.eFK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private static final f eFK = new f();
    }

    private f() {
    }

    public static boolean r(Uri uri) {
        return uri != null && eEW.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && r(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(eFl);
            String queryParameter2 = uri.getQueryParameter(eFu);
            String queryParameter3 = uri.getQueryParameter(eFv);
            String queryParameter4 = uri.getQueryParameter(eFw);
            a(queryParameter, queryParameter2, queryParameter3, uri);
            zr(uri.getQueryParameter(PARAM_FROM));
            a("", uri, queryParameter2);
            v.u(uri);
            if (eEX.equals(uri.getPath())) {
                hashMap.put(eFx, 2);
                hashMap.put(eFz, uri.getQueryParameter(eFz));
                hashMap.put(eFA, uri.getQueryParameter(eFA));
                hashMap.put(eFw, queryParameter4);
            } else if (eEY.equals(uri.getPath())) {
                hashMap.put(eFx, 1);
                hashMap.put(eFy, queryParameter4);
            } else if (eEZ.equals(uri.getPath())) {
                hashMap.put(eFx, 1);
                hashMap.put(eFy, "1_recommend");
            } else if (eFg.equals(uri.getPath())) {
                hashMap.put(eFx, 2);
                hashMap.put(eFw, queryParameter4);
            }
            aVar.onCallBack(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && r(uri) && eFa.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(eFm, uri.getQueryParameter(eFm));
            hashMap.put(eFE, uri.getQueryParameter(eFE));
            hashMap.put(eFn, uri.getQueryParameter(eFn));
            zr(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(eFl);
            String queryParameter2 = uri.getQueryParameter(eFu);
            a(queryParameter, queryParameter2, uri.getQueryParameter(eFv), uri);
            a("", uri, queryParameter2);
            aVar.onCallBack(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && r(uri) && eFb.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(eFn, uri.getQueryParameter(eFn));
            hashMap.put(eFo, uri.getQueryParameter(eFo));
            hashMap.put(eFp, uri.getQueryParameter(eFp));
            hashMap.put(eFq, uri.getQueryParameter(eFq));
            hashMap.put(eFr, uri.getQueryParameter(eFr));
            zr(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(eFl);
            String queryParameter2 = uri.getQueryParameter(eFu);
            a(queryParameter, queryParameter2, uri.getQueryParameter(eFv), uri);
            a("", uri, queryParameter2);
            aVar.onCallBack(hashMap);
        }
    }

    public void a(String str, Uri uri, a aVar) {
        if (uri != null && r(uri) && eFc.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            hashMap.put(eFF, uri);
            zr(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(eFl);
            String queryParameter2 = uri.getQueryParameter(eFu);
            a(queryParameter, queryParameter2, uri.getQueryParameter(eFv), uri);
            a(str, uri, queryParameter2);
            aVar.onCallBack(hashMap);
        }
    }

    public void s(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("is_new_schema");
            if (!TextUtils.isEmpty(queryParameter) && queryParameter.equals("1")) {
                UtilHelper.clearClipBoard();
            }
        }
    }

    public void d(Uri uri, a aVar) {
        if (uri != null && r(uri) && eFd.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(eFs, uri.getQueryParameter(eFs));
            a(uri.getQueryParameter(eFl), uri.getQueryParameter(eFu), uri.getQueryParameter(eFv), uri);
            aVar.onCallBack(hashMap);
        }
    }

    public void e(Uri uri, a aVar) {
        if (uri != null && r(uri) && eFe.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(eFt, uri.getQueryParameter(eFt));
            zr(uri.getQueryParameter(PARAM_FROM));
            a(uri.getQueryParameter(eFl), uri.getQueryParameter(eFu), uri.getQueryParameter(eFv), uri);
            aVar.onCallBack(hashMap);
        }
    }

    private void a(String str, String str2, String str3, Uri uri) {
        String str4;
        Activity currentActivity;
        if (!au.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            bVar.setToken(str3);
            if (bVar.getActivityId() != 0 && bVar.bgZ() != 0) {
                TbSingleton.getInstance().setInvokeSource(bVar.bha());
                com.baidu.adp.lib.stats.f.setActivityId(String.valueOf(bVar.getActivityId()));
                com.baidu.adp.lib.stats.f.bZ(String.valueOf(bVar.bgZ()));
                int i = au.equals(str2, eFJ) ? 2 : 1;
                String str5 = "";
                if (uri == null) {
                    str4 = "";
                } else {
                    str5 = uri.getQueryParameter(eFm);
                    str4 = uri.getQueryParameter(eFn);
                }
                if (bVar.getActivityId() == 1111 && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null) {
                    if (currentActivity instanceof BaseFragmentActivity) {
                        ((BaseFragmentActivity) currentActivity).showFloatingWindow();
                    } else if (currentActivity instanceof BaseActivity) {
                        ((BaseActivity) currentActivity).showFloatingWindow();
                    }
                }
                TiebaStatic.log(new ar("c13321").dR("obj_source", bVar.bha()).aq("obj_type", bVar.getActivityId()).aq("obj_param1", bVar.bgZ()).aq(TiebaInitialize.Params.OBJ_PARAM2, i).dR(TiebaInitialize.Params.OBJ_PARAM3, bVar.getSource()).dR("extra", bVar.bhb()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("fname", str5).dR("tid", str4).aq("obj_locate", TbadkCoreApplication.getInst().getStartType()).aq("obj_name", 1));
                c.bhp().l(bVar);
            }
        }
    }

    private void a(String str, Uri uri, String str2) {
        if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !au.equals(str2, eFJ)) {
            TiebaStatic.log(new ar("c13391").dR("obj_type", uri.getQueryParameter("obj_type")).dR("obj_source", uri.getQueryParameter("obj_source")));
        }
        if (str != null && !str.contains("tbwebview") && uri != null) {
            String queryParameter = uri.getQueryParameter("is_new_schema");
            if (!TextUtils.isEmpty(queryParameter) && queryParameter.equals("1")) {
                UtilHelper.clearClipBoard();
            }
        }
    }

    private void zr(String str) {
        if (!TextUtils.isEmpty(str) && UbcStatConstant.ContentSource.SHOUBAI.equals(str)) {
            com.baidu.tbadk.util.e.bFk().lv(true);
            com.baidu.tbadk.util.e.bFk().bFl();
        }
    }
}
