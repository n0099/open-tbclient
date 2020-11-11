package com.baidu.tbadk.BdToken;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static String eru = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String erv = "/homepage";
    public static String erw = "/enterforum";
    public static String erx = "/recommendforum";
    public static String ery = "/frs";
    public static String erz = "/pb";
    public static String erA = "/tbwebview";
    public static String erB = "/usercenter";
    public static String erC = "/topicdetail";
    public static String erD = "/tiebachushou";
    public static String erE = "/activitypage";
    public static String erF = "/minapp";
    public static String erG = "extdata";
    public static String erH = "kw";
    public static String erI = "tid";
    public static String erJ = "ori_ugc_nid";
    public static String erK = "ori_ugc_tid";
    public static String erL = "ori_ugc_type";
    public static String erM = "ori_ugc_vid";
    public static String erN = "portrait";
    public static String erO = "topic_id";
    public static String PARAM_URL = "url";
    public static String erP = "schemefrom";
    public static String PARAM_FROM = "from";
    public static String erQ = "token";
    public static String erR = "tab_name";
    public static String erS = "maintablocate";
    public static String erT = "maintab_subtab";
    public static String erU = "newgod_from";
    public static String erV = "field_id";
    public static String erW = "chushou_third_live_type";
    public static String erX = "chuchou_third_room_id";
    public static String erY = "hotTrend";
    public static String erZ = "tab_id";
    public static String esa = "param_uri";
    public static String esb = "from_h5";
    public static String esc = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void B(HashMap<String, Object> hashMap);
    }

    public static final f bgz() {
        return b.esd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private static final f esd = new f();
    }

    private f() {
    }

    public static boolean p(Uri uri) {
        return uri != null && eru.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && p(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(erG);
            String queryParameter2 = uri.getQueryParameter(erP);
            String queryParameter3 = uri.getQueryParameter(erQ);
            String queryParameter4 = uri.getQueryParameter(erR);
            ag(queryParameter, queryParameter2, queryParameter3);
            zG(uri.getQueryParameter(PARAM_FROM));
            a("", uri, queryParameter2);
            if (erv.equals(uri.getPath())) {
                hashMap.put(erS, 2);
                hashMap.put(erU, uri.getQueryParameter(erU));
                hashMap.put(erV, uri.getQueryParameter(erV));
                hashMap.put(erR, queryParameter4);
            } else if (erw.equals(uri.getPath())) {
                hashMap.put(erS, 1);
                hashMap.put(erT, queryParameter4);
            } else if (erx.equals(uri.getPath())) {
                hashMap.put(erS, 1);
                hashMap.put(erT, "1_recommend");
            } else if (erE.equals(uri.getPath())) {
                hashMap.put(erS, 2);
                hashMap.put(erR, queryParameter4);
            }
            aVar.B(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && p(uri) && ery.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(erH, uri.getQueryParameter(erH));
            hashMap.put(erZ, uri.getQueryParameter(erZ));
            hashMap.put(erI, uri.getQueryParameter(erI));
            zG(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(erG);
            String queryParameter2 = uri.getQueryParameter(erP);
            ag(queryParameter, queryParameter2, uri.getQueryParameter(erQ));
            a("", uri, queryParameter2);
            aVar.B(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && p(uri) && erz.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(erI, uri.getQueryParameter(erI));
            hashMap.put(erJ, uri.getQueryParameter(erJ));
            hashMap.put(erK, uri.getQueryParameter(erK));
            hashMap.put(erL, uri.getQueryParameter(erL));
            hashMap.put(erM, uri.getQueryParameter(erM));
            zG(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(erG);
            String queryParameter2 = uri.getQueryParameter(erP);
            ag(queryParameter, queryParameter2, uri.getQueryParameter(erQ));
            a("", uri, queryParameter2);
            aVar.B(hashMap);
        }
    }

    public void a(String str, Uri uri, a aVar) {
        if (uri != null && p(uri) && erA.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            hashMap.put(esa, uri);
            zG(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(erG);
            String queryParameter2 = uri.getQueryParameter(erP);
            ag(queryParameter, queryParameter2, uri.getQueryParameter(erQ));
            a(str, uri, queryParameter2);
            aVar.B(hashMap);
        }
    }

    public void q(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("is_new_schema");
            if (!TextUtils.isEmpty(queryParameter) && queryParameter.equals("1")) {
                UtilHelper.clearClipBoard();
            }
        }
    }

    public void d(Uri uri, a aVar) {
        if (uri != null && p(uri) && erB.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(erN, uri.getQueryParameter(erN));
            ag(uri.getQueryParameter(erG), uri.getQueryParameter(erP), uri.getQueryParameter(erQ));
            aVar.B(hashMap);
        }
    }

    public void e(Uri uri, a aVar) {
        if (uri != null && p(uri) && erC.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(erO, uri.getQueryParameter(erO));
            zG(uri.getQueryParameter(PARAM_FROM));
            ag(uri.getQueryParameter(erG), uri.getQueryParameter(erP), uri.getQueryParameter(erQ));
            aVar.B(hashMap);
        }
    }

    private void ag(String str, String str2, String str3) {
        if (!at.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            bVar.setToken(str3);
            if (bVar.getActivityId() != 0 && bVar.bfP() != 0) {
                TbSingleton.getInstance().setInvokeSource(bVar.bfQ());
                com.baidu.adp.lib.stats.f.bY(String.valueOf(bVar.getActivityId()));
                com.baidu.adp.lib.stats.f.bZ(String.valueOf(bVar.bfP()));
                TiebaStatic.log(new aq("c13321").dR("obj_source", bVar.bfQ()).al("obj_type", bVar.getActivityId()).al("obj_param1", bVar.bfP()).al(TiebaInitialize.Params.OBJ_PARAM2, at.equals(str2, esc) ? 2 : 1).dR(TiebaInitialize.Params.OBJ_PARAM3, bVar.getSource()).dR("extra", bVar.bfR()));
                c.bgf().l(bVar);
            }
        }
    }

    private void a(String str, Uri uri, String str2) {
        if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !at.equals(str2, esc)) {
            TiebaStatic.log(new aq("c13391").dR("obj_type", uri.getQueryParameter("obj_type")).dR("obj_source", uri.getQueryParameter("obj_source")));
        }
        if (str != null && !str.contains("tbwebview") && uri != null) {
            String queryParameter = uri.getQueryParameter("is_new_schema");
            if (!TextUtils.isEmpty(queryParameter) && queryParameter.equals("1")) {
                UtilHelper.clearClipBoard();
            }
        }
    }

    private void zG(String str) {
        if (!TextUtils.isEmpty(str) && UbcStatConstant.ContentSource.SHOUBAI.equals(str)) {
            com.baidu.tbadk.util.e.bDq().kG(true);
            com.baidu.tbadk.util.e.bDq().bDr();
        }
    }
}
