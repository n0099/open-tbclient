package com.baidu.tbadk.BdToken;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static String dOX = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String dOY = "/homepage";
    public static String dOZ = "/enterforum";
    public static String dPa = "/recommendforum";
    public static String dPb = "/frs";
    public static String dPc = "/pb";
    public static String dPd = "/tbwebview";
    public static String dPe = "/usercenter";
    public static String dPf = "/topicdetail";
    public static String dPg = "/tiebachushou";
    public static String dPh = "/activitypage";
    public static String dPi = "extdata";
    public static String dPj = "kw";
    public static String dPk = "tid";
    public static String dPl = "ori_ugc_nid";
    public static String dPm = "ori_ugc_tid";
    public static String dPn = "ori_ugc_type";
    public static String dPo = "ori_ugc_vid";
    public static String dPp = "portrait";
    public static String dPq = "topic_id";
    public static String PARAM_URL = "url";
    public static String dPr = "schemefrom";
    public static String PARAM_FROM = "from";
    public static String dPs = "token";
    public static String dPt = "tab_name";
    public static String dPu = "maintablocate";
    public static String dPv = "maintab_subtab";
    public static String dPw = "newgod_from";
    public static String dPx = "field_id";
    public static String dPy = "chushou_third_live_type";
    public static String dPz = "chuchou_third_room_id";
    public static String dPA = "hotTrend";
    public static String dPB = "tab_id";
    public static String dPC = "from_h5";
    public static String dPD = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void z(HashMap<String, Object> hashMap);
    }

    public static final f aYL() {
        return b.dPE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private static final f dPE = new f();
    }

    private f() {
    }

    public static boolean p(Uri uri) {
        return uri != null && dOX.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && p(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(dPi);
            String queryParameter2 = uri.getQueryParameter(dPr);
            String queryParameter3 = uri.getQueryParameter(dPs);
            String queryParameter4 = uri.getQueryParameter(dPt);
            Y(queryParameter, queryParameter2, queryParameter3);
            xT(uri.getQueryParameter(PARAM_FROM));
            c(uri, queryParameter2);
            if (dOY.equals(uri.getPath())) {
                hashMap.put(dPu, 2);
                hashMap.put(dPw, uri.getQueryParameter(dPw));
                hashMap.put(dPx, uri.getQueryParameter(dPx));
                hashMap.put(dPt, queryParameter4);
            } else if (dOZ.equals(uri.getPath())) {
                hashMap.put(dPu, 1);
                hashMap.put(dPv, queryParameter4);
            } else if (dPa.equals(uri.getPath())) {
                hashMap.put(dPu, 1);
                hashMap.put(dPv, "1_recommend");
            } else if (dPh.equals(uri.getPath())) {
                hashMap.put(dPu, 2);
                hashMap.put(dPt, queryParameter4);
            }
            aVar.z(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && p(uri) && dPb.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dPj, uri.getQueryParameter(dPj));
            hashMap.put(dPB, uri.getQueryParameter(dPB));
            hashMap.put(dPk, uri.getQueryParameter(dPk));
            xT(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(dPi);
            String queryParameter2 = uri.getQueryParameter(dPr);
            Y(queryParameter, queryParameter2, uri.getQueryParameter(dPs));
            c(uri, queryParameter2);
            aVar.z(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && p(uri) && dPc.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dPk, uri.getQueryParameter(dPk));
            hashMap.put(dPl, uri.getQueryParameter(dPl));
            hashMap.put(dPm, uri.getQueryParameter(dPm));
            hashMap.put(dPn, uri.getQueryParameter(dPn));
            hashMap.put(dPo, uri.getQueryParameter(dPo));
            xT(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(dPi);
            String queryParameter2 = uri.getQueryParameter(dPr);
            Y(queryParameter, queryParameter2, uri.getQueryParameter(dPs));
            c(uri, queryParameter2);
            aVar.z(hashMap);
        }
    }

    public void d(Uri uri, a aVar) {
        if (uri != null && p(uri) && dPd.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            xT(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(dPi);
            String queryParameter2 = uri.getQueryParameter(dPr);
            Y(queryParameter, queryParameter2, uri.getQueryParameter(dPs));
            c(uri, queryParameter2);
            aVar.z(hashMap);
        }
    }

    public void e(Uri uri, a aVar) {
        if (uri != null && p(uri) && dPe.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dPp, uri.getQueryParameter(dPp));
            Y(uri.getQueryParameter(dPi), uri.getQueryParameter(dPr), uri.getQueryParameter(dPs));
            aVar.z(hashMap);
        }
    }

    public void f(Uri uri, a aVar) {
        if (uri != null && p(uri) && dPf.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dPq, uri.getQueryParameter(dPq));
            xT(uri.getQueryParameter(PARAM_FROM));
            Y(uri.getQueryParameter(dPi), uri.getQueryParameter(dPr), uri.getQueryParameter(dPs));
            aVar.z(hashMap);
        }
    }

    private void Y(String str, String str2, String str3) {
        if (!at.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            bVar.setToken(str3);
            if (bVar.getActivityId() != 0 && bVar.aYc() != 0) {
                TbSingleton.getInstance().setInvokeSource(bVar.aYd());
                com.baidu.adp.lib.stats.f.bW(String.valueOf(bVar.getActivityId()));
                com.baidu.adp.lib.stats.f.bX(String.valueOf(bVar.aYc()));
                TiebaStatic.log(new aq("c13321").dD("obj_source", bVar.aYd()).ai("obj_type", bVar.getActivityId()).ai("obj_param1", bVar.aYc()).ai(TiebaInitialize.Params.OBJ_PARAM2, at.equals(str2, dPD) ? 2 : 1).dD(TiebaInitialize.Params.OBJ_PARAM3, bVar.getSource()).dD("extra", bVar.aYe()));
                c.aYs().l(bVar);
            }
        }
    }

    private void c(Uri uri, String str) {
        if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !at.equals(str, dPD)) {
            TiebaStatic.log(new aq("c13391").dD("obj_type", uri.getQueryParameter("obj_type")).dD("obj_source", uri.getQueryParameter("obj_source")));
        }
    }

    private void xT(String str) {
        if (!TextUtils.isEmpty(str) && UbcStatConstant.ContentSource.SHOUBAI.equals(str)) {
            com.baidu.tbadk.util.e.bvk().jL(true);
            com.baidu.tbadk.util.e.bvk().bvl();
        }
    }
}
