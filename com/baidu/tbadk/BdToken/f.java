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
/* loaded from: classes2.dex */
public class f {
    public static String dOT = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String dOU = "/homepage";
    public static String dOV = "/enterforum";
    public static String dOW = "/recommendforum";
    public static String dOX = "/frs";
    public static String dOY = "/pb";
    public static String dOZ = "/tbwebview";
    public static String dPa = "/usercenter";
    public static String dPb = "/topicdetail";
    public static String dPc = "/tiebachushou";
    public static String dPd = "/activitypage";
    public static String dPe = "extdata";
    public static String dPf = "kw";
    public static String dPg = "tid";
    public static String dPh = "ori_ugc_nid";
    public static String dPi = "ori_ugc_tid";
    public static String dPj = "ori_ugc_type";
    public static String dPk = "ori_ugc_vid";
    public static String dPl = "portrait";
    public static String dPm = "topic_id";
    public static String PARAM_URL = "url";
    public static String dPn = "schemefrom";
    public static String PARAM_FROM = "from";
    public static String dPo = "token";
    public static String dPp = "tab_name";
    public static String dPq = "maintablocate";
    public static String dPr = "maintab_subtab";
    public static String dPs = "newgod_from";
    public static String dPt = "field_id";
    public static String dPu = "chushou_third_live_type";
    public static String dPv = "chuchou_third_room_id";
    public static String dPw = "hotTrend";
    public static String dPx = "tab_id";
    public static String dPy = "from_h5";
    public static String dPz = "from_tb_token";

    /* loaded from: classes2.dex */
    public interface a {
        void z(HashMap<String, Object> hashMap);
    }

    public static final f aYL() {
        return b.dPA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        private static final f dPA = new f();
    }

    private f() {
    }

    public static boolean p(Uri uri) {
        return uri != null && dOT.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && p(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(dPe);
            String queryParameter2 = uri.getQueryParameter(dPn);
            String queryParameter3 = uri.getQueryParameter(dPo);
            String queryParameter4 = uri.getQueryParameter(dPp);
            Y(queryParameter, queryParameter2, queryParameter3);
            xS(uri.getQueryParameter(PARAM_FROM));
            c(uri, queryParameter2);
            if (dOU.equals(uri.getPath())) {
                hashMap.put(dPq, 2);
                hashMap.put(dPs, uri.getQueryParameter(dPs));
                hashMap.put(dPt, uri.getQueryParameter(dPt));
                hashMap.put(dPp, queryParameter4);
            } else if (dOV.equals(uri.getPath())) {
                hashMap.put(dPq, 1);
                hashMap.put(dPr, queryParameter4);
            } else if (dOW.equals(uri.getPath())) {
                hashMap.put(dPq, 1);
                hashMap.put(dPr, "1_recommend");
            } else if (dPd.equals(uri.getPath())) {
                hashMap.put(dPq, 2);
                hashMap.put(dPp, queryParameter4);
            }
            aVar.z(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && p(uri) && dOX.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dPf, uri.getQueryParameter(dPf));
            hashMap.put(dPx, uri.getQueryParameter(dPx));
            hashMap.put(dPg, uri.getQueryParameter(dPg));
            xS(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(dPe);
            String queryParameter2 = uri.getQueryParameter(dPn);
            Y(queryParameter, queryParameter2, uri.getQueryParameter(dPo));
            c(uri, queryParameter2);
            aVar.z(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && p(uri) && dOY.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dPg, uri.getQueryParameter(dPg));
            hashMap.put(dPh, uri.getQueryParameter(dPh));
            hashMap.put(dPi, uri.getQueryParameter(dPi));
            hashMap.put(dPj, uri.getQueryParameter(dPj));
            hashMap.put(dPk, uri.getQueryParameter(dPk));
            xS(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(dPe);
            String queryParameter2 = uri.getQueryParameter(dPn);
            Y(queryParameter, queryParameter2, uri.getQueryParameter(dPo));
            c(uri, queryParameter2);
            aVar.z(hashMap);
        }
    }

    public void d(Uri uri, a aVar) {
        if (uri != null && p(uri) && dOZ.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            xS(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(dPe);
            String queryParameter2 = uri.getQueryParameter(dPn);
            Y(queryParameter, queryParameter2, uri.getQueryParameter(dPo));
            c(uri, queryParameter2);
            aVar.z(hashMap);
        }
    }

    public void e(Uri uri, a aVar) {
        if (uri != null && p(uri) && dPa.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dPl, uri.getQueryParameter(dPl));
            Y(uri.getQueryParameter(dPe), uri.getQueryParameter(dPn), uri.getQueryParameter(dPo));
            aVar.z(hashMap);
        }
    }

    public void f(Uri uri, a aVar) {
        if (uri != null && p(uri) && dPb.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dPm, uri.getQueryParameter(dPm));
            xS(uri.getQueryParameter(PARAM_FROM));
            Y(uri.getQueryParameter(dPe), uri.getQueryParameter(dPn), uri.getQueryParameter(dPo));
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
                TiebaStatic.log(new aq("c13321").dD("obj_source", bVar.aYd()).ai("obj_type", bVar.getActivityId()).ai("obj_param1", bVar.aYc()).ai(TiebaInitialize.Params.OBJ_PARAM2, at.equals(str2, dPz) ? 2 : 1).dD(TiebaInitialize.Params.OBJ_PARAM3, bVar.getSource()).dD("extra", bVar.aYe()));
                c.aYs().l(bVar);
            }
        }
    }

    private void c(Uri uri, String str) {
        if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !at.equals(str, dPz)) {
            TiebaStatic.log(new aq("c13391").dD("obj_type", uri.getQueryParameter("obj_type")).dD("obj_source", uri.getQueryParameter("obj_source")));
        }
    }

    private void xS(String str) {
        if (!TextUtils.isEmpty(str) && UbcStatConstant.ContentSource.SHOUBAI.equals(str)) {
            com.baidu.tbadk.util.e.bvj().jJ(true);
            com.baidu.tbadk.util.e.bvj().bvk();
        }
    }
}
