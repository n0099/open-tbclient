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
    public static String dhl = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String dhm = "/homepage";
    public static String dhn = "/enterforum";
    public static String dho = "/recommendforum";
    public static String dhp = "/frs";
    public static String dhq = "/pb";
    public static String dhr = "/tbwebview";
    public static String dhs = "/usercenter";
    public static String dht = "/topicdetail";
    public static String dhu = "extdata";
    public static String dhv = "kw";
    public static String dhw = "tid";
    public static String dhx = "ori_ugc_nid";
    public static String dhy = "ori_ugc_tid";
    public static String dhz = "ori_ugc_type";
    public static String dhA = "ori_ugc_vid";
    public static String dhB = "portrait";
    public static String dhC = "topic_id";
    public static String PARAM_URL = "url";
    public static String dhD = "schemefrom";
    public static String PARAM_FROM = "from";
    public static String dhE = "token";
    public static String dhF = "tab_name";
    public static String dhG = "maintablocate";
    public static String dhH = "maintab_subtab";
    public static String dhI = "from_h5";
    public static String dhJ = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void B(HashMap<String, Object> hashMap);
    }

    public static final f aGd() {
        return b.dhK;
    }

    /* loaded from: classes.dex */
    private static class b {
        private static final f dhK = new f();
    }

    private f() {
    }

    public static boolean n(Uri uri) {
        return uri != null && dhl.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && n(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(dhu);
            String queryParameter2 = uri.getQueryParameter(dhD);
            String queryParameter3 = uri.getQueryParameter(dhE);
            String queryParameter4 = uri.getQueryParameter(dhF);
            S(queryParameter, queryParameter2, queryParameter3);
            sO(uri.getQueryParameter(PARAM_FROM));
            c(uri, queryParameter2);
            if (dhm.equals(uri.getPath())) {
                hashMap.put(dhG, 2);
            } else if (dhn.equals(uri.getPath())) {
                hashMap.put(dhG, 1);
                hashMap.put(dhH, queryParameter4);
            } else if (dho.equals(uri.getPath())) {
                hashMap.put(dhG, 1);
                hashMap.put(dhH, "1_recommend");
            }
            aVar.B(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && n(uri) && dhp.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dhv, uri.getQueryParameter(dhv));
            sO(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(dhu);
            String queryParameter2 = uri.getQueryParameter(dhD);
            S(queryParameter, queryParameter2, uri.getQueryParameter(dhE));
            c(uri, queryParameter2);
            aVar.B(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && n(uri) && dhq.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dhw, uri.getQueryParameter(dhw));
            hashMap.put(dhx, uri.getQueryParameter(dhx));
            hashMap.put(dhy, uri.getQueryParameter(dhy));
            hashMap.put(dhz, uri.getQueryParameter(dhz));
            hashMap.put(dhA, uri.getQueryParameter(dhA));
            sO(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(dhu);
            String queryParameter2 = uri.getQueryParameter(dhD);
            S(queryParameter, queryParameter2, uri.getQueryParameter(dhE));
            c(uri, queryParameter2);
            aVar.B(hashMap);
        }
    }

    public void d(Uri uri, a aVar) {
        if (uri != null && n(uri) && dhr.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            sO(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(dhu);
            String queryParameter2 = uri.getQueryParameter(dhD);
            S(queryParameter, queryParameter2, uri.getQueryParameter(dhE));
            c(uri, queryParameter2);
            aVar.B(hashMap);
        }
    }

    public void e(Uri uri, a aVar) {
        if (uri != null && n(uri) && dhs.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dhB, uri.getQueryParameter(dhB));
            S(uri.getQueryParameter(dhu), uri.getQueryParameter(dhD), uri.getQueryParameter(dhE));
            aVar.B(hashMap);
        }
    }

    public void f(Uri uri, a aVar) {
        if (uri != null && n(uri) && dht.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dhC, uri.getQueryParameter(dhC));
            sO(uri.getQueryParameter(PARAM_FROM));
            S(uri.getQueryParameter(dhu), uri.getQueryParameter(dhD), uri.getQueryParameter(dhE));
            aVar.B(hashMap);
        }
    }

    private void S(String str, String str2, String str3) {
        if (!aq.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            bVar.setToken(str3);
            if (bVar.getActivityId() != 0 && bVar.aFx() != 0) {
                TbSingleton.getInstance().setInvokeSource(bVar.aFy());
                com.baidu.adp.lib.stats.f.bR(String.valueOf(bVar.getActivityId()));
                com.baidu.adp.lib.stats.f.bS(String.valueOf(bVar.aFx()));
                TiebaStatic.log(new an("c13321").cI("obj_source", bVar.aFy()).af("obj_type", bVar.getActivityId()).af("obj_param1", bVar.aFx()).af(TiebaInitialize.Params.OBJ_PARAM2, aq.equals(str2, dhJ) ? 2 : 1).cI(TiebaInitialize.Params.OBJ_PARAM3, bVar.getSource()).cI("extra", bVar.aFz()));
                c.aFN().l(bVar);
            }
        }
    }

    private void c(Uri uri, String str) {
        if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !aq.equals(str, dhJ)) {
            TiebaStatic.log(new an("c13391").cI("obj_type", uri.getQueryParameter("obj_type")).cI("obj_source", uri.getQueryParameter("obj_source")));
        }
    }

    private void sO(String str) {
        if (!TextUtils.isEmpty(str) && UbcStatConstant.ContentSource.SHOUBAI.equals(str)) {
            com.baidu.tbadk.util.d.baf().setShow(true);
            com.baidu.tbadk.util.d.baf().bag();
        }
    }
}
