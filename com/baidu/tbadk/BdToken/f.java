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
    public static String eDv = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String eDw = "/homepage";
    public static String eDx = "/enterforum";
    public static String eDy = "/recommendforum";
    public static String eDz = "/frs";
    public static String eDA = "/pb";
    public static String eDB = "/tbwebview";
    public static String eDC = "/usercenter";
    public static String eDD = "/topicdetail";
    public static String eDE = "/tiebachushou";
    public static String eDF = "/activitypage";
    public static String eDG = "/minapp";
    public static String eDH = "/onekeysign";
    public static String eDI = "/hotuserrank";
    public static String eDJ = "/forumRuleDetail";
    public static String eDK = "extdata";
    public static String eDL = "kw";
    public static String eDM = "tid";
    public static String eDN = "ori_ugc_nid";
    public static String eDO = "ori_ugc_tid";
    public static String eDP = "ori_ugc_type";
    public static String eDQ = "ori_ugc_vid";
    public static String eDR = "portrait";
    public static String eDS = "topic_id";
    public static String PARAM_URL = "url";
    public static String eDT = "schemefrom";
    public static String PARAM_FROM = "from";
    public static String eDU = "token";
    public static String eDV = "tab_name";
    public static String eDW = "maintablocate";
    public static String eDX = "maintab_subtab";
    public static String eDY = "newgod_from";
    public static String eDZ = "field_id";
    public static String eEa = "chushou_third_live_type";
    public static String eEb = "chuchou_third_room_id";
    public static String eEc = "hotTrend";
    public static String eEd = "tab_id";
    public static String eEe = "param_uri";
    public static String eEf = TbTitleActivityConfig.FORUM_ID;
    public static String eEg = LegoListActivityConfig.ITEM_ID;
    public static String eEh = "from_h5";
    public static String eEi = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void onCallBack(HashMap<String, Object> hashMap);
    }

    public static final f bhH() {
        return b.eEj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private static final f eEj = new f();
    }

    private f() {
    }

    public static boolean r(Uri uri) {
        return uri != null && eDv.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && r(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(eDK);
            String queryParameter2 = uri.getQueryParameter(eDT);
            String queryParameter3 = uri.getQueryParameter(eDU);
            String queryParameter4 = uri.getQueryParameter(eDV);
            a(queryParameter, queryParameter2, queryParameter3, uri);
            zk(uri.getQueryParameter(PARAM_FROM));
            a("", uri, queryParameter2);
            v.u(uri);
            if (eDw.equals(uri.getPath())) {
                hashMap.put(eDW, 2);
                hashMap.put(eDY, uri.getQueryParameter(eDY));
                hashMap.put(eDZ, uri.getQueryParameter(eDZ));
                hashMap.put(eDV, queryParameter4);
            } else if (eDx.equals(uri.getPath())) {
                hashMap.put(eDW, 1);
                hashMap.put(eDX, queryParameter4);
            } else if (eDy.equals(uri.getPath())) {
                hashMap.put(eDW, 1);
                hashMap.put(eDX, "1_recommend");
            } else if (eDF.equals(uri.getPath())) {
                hashMap.put(eDW, 2);
                hashMap.put(eDV, queryParameter4);
            }
            aVar.onCallBack(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && r(uri) && eDz.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(eDL, uri.getQueryParameter(eDL));
            hashMap.put(eEd, uri.getQueryParameter(eEd));
            hashMap.put(eDM, uri.getQueryParameter(eDM));
            zk(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(eDK);
            String queryParameter2 = uri.getQueryParameter(eDT);
            a(queryParameter, queryParameter2, uri.getQueryParameter(eDU), uri);
            a("", uri, queryParameter2);
            aVar.onCallBack(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && r(uri) && eDA.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(eDM, uri.getQueryParameter(eDM));
            hashMap.put(eDN, uri.getQueryParameter(eDN));
            hashMap.put(eDO, uri.getQueryParameter(eDO));
            hashMap.put(eDP, uri.getQueryParameter(eDP));
            hashMap.put(eDQ, uri.getQueryParameter(eDQ));
            zk(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(eDK);
            String queryParameter2 = uri.getQueryParameter(eDT);
            a(queryParameter, queryParameter2, uri.getQueryParameter(eDU), uri);
            a("", uri, queryParameter2);
            aVar.onCallBack(hashMap);
        }
    }

    public void a(String str, Uri uri, a aVar) {
        if (uri != null && r(uri) && eDB.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            hashMap.put(eEe, uri);
            zk(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(eDK);
            String queryParameter2 = uri.getQueryParameter(eDT);
            a(queryParameter, queryParameter2, uri.getQueryParameter(eDU), uri);
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
        if (uri != null && r(uri) && eDC.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(eDR, uri.getQueryParameter(eDR));
            a(uri.getQueryParameter(eDK), uri.getQueryParameter(eDT), uri.getQueryParameter(eDU), uri);
            aVar.onCallBack(hashMap);
        }
    }

    public void e(Uri uri, a aVar) {
        if (uri != null && r(uri) && eDD.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(eDS, uri.getQueryParameter(eDS));
            zk(uri.getQueryParameter(PARAM_FROM));
            a(uri.getQueryParameter(eDK), uri.getQueryParameter(eDT), uri.getQueryParameter(eDU), uri);
            aVar.onCallBack(hashMap);
        }
    }

    private void a(String str, String str2, String str3, Uri uri) {
        String str4;
        Activity currentActivity;
        if (!au.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            bVar.setToken(str3);
            if (bVar.getActivityId() != 0 && bVar.bgX() != 0) {
                TbSingleton.getInstance().setInvokeSource(bVar.bgY());
                com.baidu.adp.lib.stats.f.setActivityId(String.valueOf(bVar.getActivityId()));
                com.baidu.adp.lib.stats.f.bV(String.valueOf(bVar.bgX()));
                int i = au.equals(str2, eEi) ? 2 : 1;
                String str5 = "";
                if (uri == null) {
                    str4 = "";
                } else {
                    str5 = uri.getQueryParameter(eDL);
                    str4 = uri.getQueryParameter(eDM);
                }
                if (bVar.getActivityId() == 1111 && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null) {
                    if (currentActivity instanceof BaseFragmentActivity) {
                        ((BaseFragmentActivity) currentActivity).showFloatingWindow();
                    } else if (currentActivity instanceof BaseActivity) {
                        ((BaseActivity) currentActivity).showFloatingWindow();
                    }
                }
                TiebaStatic.log(new ar("c13321").dR("obj_source", bVar.bgY()).ap("obj_type", bVar.getActivityId()).ap("obj_param1", bVar.bgX()).ap(TiebaInitialize.Params.OBJ_PARAM2, i).dR(TiebaInitialize.Params.OBJ_PARAM3, bVar.getSource()).dR("extra", bVar.bgZ()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("fname", str5).dR("tid", str4).ap("obj_locate", TbadkCoreApplication.getInst().getStartType()).ap("obj_name", 1));
                c.bhn().l(bVar);
            }
        }
    }

    private void a(String str, Uri uri, String str2) {
        if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !au.equals(str2, eEi)) {
            TiebaStatic.log(new ar("c13391").dR("obj_type", uri.getQueryParameter("obj_type")).dR("obj_source", uri.getQueryParameter("obj_source")));
        }
        if (str != null && !str.contains("tbwebview") && uri != null) {
            String queryParameter = uri.getQueryParameter("is_new_schema");
            if (!TextUtils.isEmpty(queryParameter) && queryParameter.equals("1")) {
                UtilHelper.clearClipBoard();
            }
        }
    }

    private void zk(String str) {
        if (!TextUtils.isEmpty(str) && UbcStatConstant.ContentSource.SHOUBAI.equals(str)) {
            com.baidu.tbadk.util.e.bFg().lv(true);
            com.baidu.tbadk.util.e.bFg().bFh();
        }
    }
}
