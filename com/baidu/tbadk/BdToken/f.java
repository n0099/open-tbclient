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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static String eGb = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String eGc = "/homepage";
    public static String eGd = "/enterforum";
    public static String eGe = "/recommendforum";
    public static String eGf = "/frs";
    public static String eGg = "/pb";
    public static String eGh = "/tbwebview";
    public static String eGi = "/usercenter";
    public static String eGj = "/topicdetail";
    public static String eGk = "/tiebachushou";
    public static String eGl = "/activitypage";
    public static String eGm = "/minapp";
    public static String eGn = "/onekeysign";
    public static String eGo = "/hotuserrank";
    public static String eGp = "/forumRuleDetail";
    public static String eGq = "extdata";
    public static String eGr = "kw";
    public static String eGs = "tid";
    public static String eGt = "ori_ugc_nid";
    public static String eGu = "ori_ugc_tid";
    public static String eGv = "ori_ugc_type";
    public static String eGw = "ori_ugc_vid";
    public static String eGx = "portrait";
    public static String eGy = "topic_id";
    public static String PARAM_URL = "url";
    public static String eGz = "schemefrom";
    public static String PARAM_FROM = "from";
    public static String eGA = "token";
    public static String eGB = "tab_name";
    public static String eGC = "maintablocate";
    public static String eGD = "maintab_subtab";
    public static String eGE = "newgod_from";
    public static String eGF = "field_id";
    public static String eGG = "chushou_third_live_type";
    public static String eGH = "chuchou_third_room_id";
    public static String eGI = "hotTrend";
    public static String eGJ = "tab_id";
    public static String eGK = "param_uri";
    public static String eGL = TbTitleActivityConfig.FORUM_ID;
    public static String eGM = "from_h5";
    public static String eGN = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void onCallBack(HashMap<String, Object> hashMap);
    }

    public static final f bln() {
        return b.eGO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private static final f eGO = new f();
    }

    private f() {
    }

    public static boolean r(Uri uri) {
        return uri != null && eGb.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && r(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(eGq);
            String queryParameter2 = uri.getQueryParameter(eGz);
            String queryParameter3 = uri.getQueryParameter(eGA);
            String queryParameter4 = uri.getQueryParameter(eGB);
            a(queryParameter, queryParameter2, queryParameter3, uri);
            Ad(uri.getQueryParameter(PARAM_FROM));
            a("", uri, queryParameter2);
            if (eGc.equals(uri.getPath())) {
                hashMap.put(eGC, 2);
                hashMap.put(eGE, uri.getQueryParameter(eGE));
                hashMap.put(eGF, uri.getQueryParameter(eGF));
                hashMap.put(eGB, queryParameter4);
            } else if (eGd.equals(uri.getPath())) {
                hashMap.put(eGC, 1);
                hashMap.put(eGD, queryParameter4);
            } else if (eGe.equals(uri.getPath())) {
                hashMap.put(eGC, 1);
                hashMap.put(eGD, "1_recommend");
            } else if (eGl.equals(uri.getPath())) {
                hashMap.put(eGC, 2);
                hashMap.put(eGB, queryParameter4);
            }
            aVar.onCallBack(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && r(uri) && eGf.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(eGr, uri.getQueryParameter(eGr));
            hashMap.put(eGJ, uri.getQueryParameter(eGJ));
            hashMap.put(eGs, uri.getQueryParameter(eGs));
            Ad(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(eGq);
            String queryParameter2 = uri.getQueryParameter(eGz);
            a(queryParameter, queryParameter2, uri.getQueryParameter(eGA), uri);
            a("", uri, queryParameter2);
            aVar.onCallBack(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && r(uri) && eGg.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(eGs, uri.getQueryParameter(eGs));
            hashMap.put(eGt, uri.getQueryParameter(eGt));
            hashMap.put(eGu, uri.getQueryParameter(eGu));
            hashMap.put(eGv, uri.getQueryParameter(eGv));
            hashMap.put(eGw, uri.getQueryParameter(eGw));
            Ad(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(eGq);
            String queryParameter2 = uri.getQueryParameter(eGz);
            a(queryParameter, queryParameter2, uri.getQueryParameter(eGA), uri);
            a("", uri, queryParameter2);
            aVar.onCallBack(hashMap);
        }
    }

    public void a(String str, Uri uri, a aVar) {
        if (uri != null && r(uri) && eGh.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            hashMap.put(eGK, uri);
            Ad(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(eGq);
            String queryParameter2 = uri.getQueryParameter(eGz);
            a(queryParameter, queryParameter2, uri.getQueryParameter(eGA), uri);
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
        if (uri != null && r(uri) && eGi.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(eGx, uri.getQueryParameter(eGx));
            a(uri.getQueryParameter(eGq), uri.getQueryParameter(eGz), uri.getQueryParameter(eGA), uri);
            aVar.onCallBack(hashMap);
        }
    }

    public void e(Uri uri, a aVar) {
        if (uri != null && r(uri) && eGj.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(eGy, uri.getQueryParameter(eGy));
            Ad(uri.getQueryParameter(PARAM_FROM));
            a(uri.getQueryParameter(eGq), uri.getQueryParameter(eGz), uri.getQueryParameter(eGA), uri);
            aVar.onCallBack(hashMap);
        }
    }

    private void a(String str, String str2, String str3, Uri uri) {
        String str4;
        Activity currentActivity;
        if (!at.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            bVar.setToken(str3);
            if (bVar.getActivityId() != 0 && bVar.bkD() != 0) {
                TbSingleton.getInstance().setInvokeSource(bVar.bkE());
                com.baidu.adp.lib.stats.f.setActivityId(String.valueOf(bVar.getActivityId()));
                com.baidu.adp.lib.stats.f.bV(String.valueOf(bVar.bkD()));
                int i = at.equals(str2, eGN) ? 2 : 1;
                String str5 = "";
                if (uri == null) {
                    str4 = "";
                } else {
                    str5 = uri.getQueryParameter(eGr);
                    str4 = uri.getQueryParameter(eGs);
                }
                if (bVar.getActivityId() == 1111 && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null) {
                    if (currentActivity instanceof BaseFragmentActivity) {
                        ((BaseFragmentActivity) currentActivity).showFloatingWindow();
                    } else if (currentActivity instanceof BaseActivity) {
                        ((BaseActivity) currentActivity).showFloatingWindow();
                    }
                }
                TiebaStatic.log(new aq("c13321").dX("obj_source", bVar.bkE()).an("obj_type", bVar.getActivityId()).an("obj_param1", bVar.bkD()).an(TiebaInitialize.Params.OBJ_PARAM2, i).dX(TiebaInitialize.Params.OBJ_PARAM3, bVar.getSource()).dX("extra", bVar.bkF()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dX("fname", str5).dX("tid", str4).an("obj_locate", TbadkCoreApplication.getInst().getStartType()).an("obj_name", 1));
                c.bkT().l(bVar);
            }
        }
    }

    private void a(String str, Uri uri, String str2) {
        if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !at.equals(str2, eGN)) {
            TiebaStatic.log(new aq("c13391").dX("obj_type", uri.getQueryParameter("obj_type")).dX("obj_source", uri.getQueryParameter("obj_source")));
        }
        if (str != null && !str.contains("tbwebview") && uri != null) {
            String queryParameter = uri.getQueryParameter("is_new_schema");
            if (!TextUtils.isEmpty(queryParameter) && queryParameter.equals("1")) {
                UtilHelper.clearClipBoard();
            }
        }
    }

    private void Ad(String str) {
        if (!TextUtils.isEmpty(str) && UbcStatConstant.ContentSource.SHOUBAI.equals(str)) {
            com.baidu.tbadk.util.d.bIE().lw(true);
            com.baidu.tbadk.util.d.bIE().bIF();
        }
    }
}
