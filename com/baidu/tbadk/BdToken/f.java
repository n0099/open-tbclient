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
    public static String elz = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String elA = "/homepage";
    public static String elB = "/enterforum";
    public static String elC = "/recommendforum";
    public static String elD = "/frs";
    public static String elE = "/pb";
    public static String elF = "/tbwebview";
    public static String elG = "/usercenter";
    public static String elH = "/topicdetail";
    public static String elI = "/tiebachushou";
    public static String elJ = "/activitypage";
    public static String elK = "/minapp";
    public static String elL = "extdata";
    public static String elM = "kw";
    public static String elN = "tid";
    public static String elO = "ori_ugc_nid";
    public static String elP = "ori_ugc_tid";
    public static String elQ = "ori_ugc_type";
    public static String elR = "ori_ugc_vid";
    public static String elS = "portrait";
    public static String elT = "topic_id";
    public static String PARAM_URL = "url";
    public static String elU = "schemefrom";
    public static String PARAM_FROM = "from";
    public static String elV = "token";
    public static String elW = "tab_name";
    public static String elX = "maintablocate";
    public static String elY = "maintab_subtab";
    public static String elZ = "newgod_from";
    public static String ema = "field_id";
    public static String emb = "chushou_third_live_type";
    public static String emc = "chuchou_third_room_id";
    public static String emd = "hotTrend";
    public static String eme = "tab_id";
    public static String emf = "param_uri";
    public static String emg = "from_h5";
    public static String emh = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void B(HashMap<String, Object> hashMap);
    }

    public static final f bdZ() {
        return b.emi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private static final f emi = new f();
    }

    private f() {
    }

    public static boolean p(Uri uri) {
        return uri != null && elz.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && p(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(elL);
            String queryParameter2 = uri.getQueryParameter(elU);
            String queryParameter3 = uri.getQueryParameter(elV);
            String queryParameter4 = uri.getQueryParameter(elW);
            ag(queryParameter, queryParameter2, queryParameter3);
            zs(uri.getQueryParameter(PARAM_FROM));
            a("", uri, queryParameter2);
            if (elA.equals(uri.getPath())) {
                hashMap.put(elX, 2);
                hashMap.put(elZ, uri.getQueryParameter(elZ));
                hashMap.put(ema, uri.getQueryParameter(ema));
                hashMap.put(elW, queryParameter4);
            } else if (elB.equals(uri.getPath())) {
                hashMap.put(elX, 1);
                hashMap.put(elY, queryParameter4);
            } else if (elC.equals(uri.getPath())) {
                hashMap.put(elX, 1);
                hashMap.put(elY, "1_recommend");
            } else if (elJ.equals(uri.getPath())) {
                hashMap.put(elX, 2);
                hashMap.put(elW, queryParameter4);
            }
            aVar.B(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && p(uri) && elD.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(elM, uri.getQueryParameter(elM));
            hashMap.put(eme, uri.getQueryParameter(eme));
            hashMap.put(elN, uri.getQueryParameter(elN));
            zs(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(elL);
            String queryParameter2 = uri.getQueryParameter(elU);
            ag(queryParameter, queryParameter2, uri.getQueryParameter(elV));
            a("", uri, queryParameter2);
            aVar.B(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && p(uri) && elE.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(elN, uri.getQueryParameter(elN));
            hashMap.put(elO, uri.getQueryParameter(elO));
            hashMap.put(elP, uri.getQueryParameter(elP));
            hashMap.put(elQ, uri.getQueryParameter(elQ));
            hashMap.put(elR, uri.getQueryParameter(elR));
            zs(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(elL);
            String queryParameter2 = uri.getQueryParameter(elU);
            ag(queryParameter, queryParameter2, uri.getQueryParameter(elV));
            a("", uri, queryParameter2);
            aVar.B(hashMap);
        }
    }

    public void a(String str, Uri uri, a aVar) {
        if (uri != null && p(uri) && elF.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            hashMap.put(emf, uri);
            zs(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(elL);
            String queryParameter2 = uri.getQueryParameter(elU);
            ag(queryParameter, queryParameter2, uri.getQueryParameter(elV));
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
        if (uri != null && p(uri) && elG.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(elS, uri.getQueryParameter(elS));
            ag(uri.getQueryParameter(elL), uri.getQueryParameter(elU), uri.getQueryParameter(elV));
            aVar.B(hashMap);
        }
    }

    public void e(Uri uri, a aVar) {
        if (uri != null && p(uri) && elH.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(elT, uri.getQueryParameter(elT));
            zs(uri.getQueryParameter(PARAM_FROM));
            ag(uri.getQueryParameter(elL), uri.getQueryParameter(elU), uri.getQueryParameter(elV));
            aVar.B(hashMap);
        }
    }

    private void ag(String str, String str2, String str3) {
        if (!at.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            bVar.setToken(str3);
            if (bVar.getActivityId() != 0 && bVar.bdp() != 0) {
                TbSingleton.getInstance().setInvokeSource(bVar.bdq());
                com.baidu.adp.lib.stats.f.bY(String.valueOf(bVar.getActivityId()));
                com.baidu.adp.lib.stats.f.bZ(String.valueOf(bVar.bdp()));
                TiebaStatic.log(new aq("c13321").dR("obj_source", bVar.bdq()).aj("obj_type", bVar.getActivityId()).aj("obj_param1", bVar.bdp()).aj(TiebaInitialize.Params.OBJ_PARAM2, at.equals(str2, emh) ? 2 : 1).dR(TiebaInitialize.Params.OBJ_PARAM3, bVar.getSource()).dR("extra", bVar.bdr()));
                c.bdF().l(bVar);
            }
        }
    }

    private void a(String str, Uri uri, String str2) {
        if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !at.equals(str2, emh)) {
            TiebaStatic.log(new aq("c13391").dR("obj_type", uri.getQueryParameter("obj_type")).dR("obj_source", uri.getQueryParameter("obj_source")));
        }
        if (str != null && !str.contains("tbwebview") && uri != null) {
            String queryParameter = uri.getQueryParameter("is_new_schema");
            if (!TextUtils.isEmpty(queryParameter) && queryParameter.equals("1")) {
                UtilHelper.clearClipBoard();
            }
        }
    }

    private void zs(String str) {
        if (!TextUtils.isEmpty(str) && UbcStatConstant.ContentSource.SHOUBAI.equals(str)) {
            com.baidu.tbadk.util.e.bAR().kx(true);
            com.baidu.tbadk.util.e.bAR().bAS();
        }
    }
}
