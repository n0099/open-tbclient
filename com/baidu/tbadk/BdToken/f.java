package com.baidu.tbadk.BdToken;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static String dvg = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String dvh = "/homepage";
    public static String dvi = "/enterforum";
    public static String dvj = "/recommendforum";
    public static String dvk = "/frs";
    public static String dvl = "/pb";
    public static String dvm = "/tbwebview";
    public static String dvn = "/usercenter";
    public static String dvo = "/topicdetail";
    public static String dvp = "/tiebachushou";
    public static String dvq = "extdata";
    public static String dvr = "kw";
    public static String dvs = "tid";
    public static String dvt = "ori_ugc_nid";
    public static String dvu = "ori_ugc_tid";
    public static String dvv = "ori_ugc_type";
    public static String dvw = "ori_ugc_vid";
    public static String dvx = "portrait";
    public static String dvy = "topic_id";
    public static String PARAM_URL = "url";
    public static String dvz = "schemefrom";
    public static String PARAM_FROM = "from";
    public static String dvA = "token";
    public static String dvB = "tab_name";
    public static String dvC = "maintablocate";
    public static String dvD = "maintab_subtab";
    public static String dvE = "newgod_from";
    public static String dvF = "field_id";
    public static String dvG = "chushou_third_live_type";
    public static String dvH = "chuchou_third_room_id";
    public static String dvI = "from_h5";
    public static String dvJ = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void C(HashMap<String, Object> hashMap);
    }

    public static final f aLw() {
        return b.dvK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private static final f dvK = new f();
    }

    private f() {
    }

    public static boolean p(Uri uri) {
        return uri != null && dvg.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && p(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(dvq);
            String queryParameter2 = uri.getQueryParameter(dvz);
            String queryParameter3 = uri.getQueryParameter(dvA);
            String queryParameter4 = uri.getQueryParameter(dvB);
            X(queryParameter, queryParameter2, queryParameter3);
            uw(uri.getQueryParameter(PARAM_FROM));
            c(uri, queryParameter2);
            if (dvh.equals(uri.getPath())) {
                hashMap.put(dvC, 2);
                hashMap.put(dvE, uri.getQueryParameter(dvE));
                hashMap.put(dvF, uri.getQueryParameter(dvF));
            } else if (dvi.equals(uri.getPath())) {
                hashMap.put(dvC, 1);
                hashMap.put(dvD, queryParameter4);
            } else if (dvj.equals(uri.getPath())) {
                hashMap.put(dvC, 1);
                hashMap.put(dvD, "1_recommend");
            }
            aVar.C(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && p(uri) && dvk.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dvr, uri.getQueryParameter(dvr));
            uw(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(dvq);
            String queryParameter2 = uri.getQueryParameter(dvz);
            X(queryParameter, queryParameter2, uri.getQueryParameter(dvA));
            c(uri, queryParameter2);
            aVar.C(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && p(uri) && dvl.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dvs, uri.getQueryParameter(dvs));
            hashMap.put(dvt, uri.getQueryParameter(dvt));
            hashMap.put(dvu, uri.getQueryParameter(dvu));
            hashMap.put(dvv, uri.getQueryParameter(dvv));
            hashMap.put(dvw, uri.getQueryParameter(dvw));
            uw(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(dvq);
            String queryParameter2 = uri.getQueryParameter(dvz);
            X(queryParameter, queryParameter2, uri.getQueryParameter(dvA));
            c(uri, queryParameter2);
            aVar.C(hashMap);
        }
    }

    public void d(Uri uri, a aVar) {
        if (uri != null && p(uri) && dvm.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            uw(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(dvq);
            String queryParameter2 = uri.getQueryParameter(dvz);
            X(queryParameter, queryParameter2, uri.getQueryParameter(dvA));
            c(uri, queryParameter2);
            aVar.C(hashMap);
        }
    }

    public void e(Uri uri, a aVar) {
        if (uri != null && p(uri) && dvn.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dvx, uri.getQueryParameter(dvx));
            X(uri.getQueryParameter(dvq), uri.getQueryParameter(dvz), uri.getQueryParameter(dvA));
            aVar.C(hashMap);
        }
    }

    public void f(Uri uri, a aVar) {
        if (uri != null && p(uri) && dvo.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dvy, uri.getQueryParameter(dvy));
            uw(uri.getQueryParameter(PARAM_FROM));
            X(uri.getQueryParameter(dvq), uri.getQueryParameter(dvz), uri.getQueryParameter(dvA));
            aVar.C(hashMap);
        }
    }

    private void X(String str, String str2, String str3) {
        if (!aq.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            bVar.setToken(str3);
            if (bVar.getActivityId() != 0 && bVar.aKS() != 0) {
                TbSingleton.getInstance().setInvokeSource(bVar.aKT());
                com.baidu.adp.lib.stats.f.bS(String.valueOf(bVar.getActivityId()));
                com.baidu.adp.lib.stats.f.bT(String.valueOf(bVar.aKS()));
                TiebaStatic.log(new an("c13321").dh("obj_source", bVar.aKT()).ag("obj_type", bVar.getActivityId()).ag("obj_param1", bVar.aKS()).ag(TiebaInitialize.Params.OBJ_PARAM2, aq.equals(str2, dvJ) ? 2 : 1).dh(TiebaInitialize.Params.OBJ_PARAM3, bVar.getSource()).dh("extra", bVar.aKU()));
                c.aLi().l(bVar);
            }
        }
    }

    private void c(Uri uri, String str) {
        if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !aq.equals(str, dvJ)) {
            TiebaStatic.log(new an("c13391").dh("obj_type", uri.getQueryParameter("obj_type")).dh("obj_source", uri.getQueryParameter("obj_source")));
        }
    }

    private void uw(String str) {
        if (!TextUtils.isEmpty(str) && UbcStatConstant.ContentSource.SHOUBAI.equals(str)) {
            com.baidu.tbadk.util.d.bgo().iv(true);
            com.baidu.tbadk.util.d.bgo().bgp();
        }
    }
}
