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
    public static String dhq = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String dhr = "/homepage";
    public static String dhs = "/enterforum";
    public static String dht = "/recommendforum";
    public static String dhu = "/frs";
    public static String dhv = "/pb";
    public static String dhw = "/tbwebview";
    public static String dhx = "/usercenter";
    public static String dhy = "/topicdetail";
    public static String dhz = "extdata";
    public static String dhA = "kw";
    public static String dhB = "tid";
    public static String dhC = "ori_ugc_nid";
    public static String dhD = "ori_ugc_tid";
    public static String dhE = "ori_ugc_type";
    public static String dhF = "ori_ugc_vid";
    public static String dhG = "portrait";
    public static String dhH = "topic_id";
    public static String PARAM_URL = "url";
    public static String dhI = "schemefrom";
    public static String PARAM_FROM = "from";
    public static String dhJ = "token";
    public static String dhK = "tab_name";
    public static String dhL = "maintablocate";
    public static String dhM = "maintab_subtab";
    public static String dhN = "from_h5";
    public static String dhO = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void B(HashMap<String, Object> hashMap);
    }

    public static final f aGb() {
        return b.dhP;
    }

    /* loaded from: classes.dex */
    private static class b {
        private static final f dhP = new f();
    }

    private f() {
    }

    public static boolean n(Uri uri) {
        return uri != null && dhq.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && n(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(dhz);
            String queryParameter2 = uri.getQueryParameter(dhI);
            String queryParameter3 = uri.getQueryParameter(dhJ);
            String queryParameter4 = uri.getQueryParameter(dhK);
            S(queryParameter, queryParameter2, queryParameter3);
            sR(uri.getQueryParameter(PARAM_FROM));
            c(uri, queryParameter2);
            if (dhr.equals(uri.getPath())) {
                hashMap.put(dhL, 2);
            } else if (dhs.equals(uri.getPath())) {
                hashMap.put(dhL, 1);
                hashMap.put(dhM, queryParameter4);
            } else if (dht.equals(uri.getPath())) {
                hashMap.put(dhL, 1);
                hashMap.put(dhM, "1_recommend");
            }
            aVar.B(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && n(uri) && dhu.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dhA, uri.getQueryParameter(dhA));
            sR(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(dhz);
            String queryParameter2 = uri.getQueryParameter(dhI);
            S(queryParameter, queryParameter2, uri.getQueryParameter(dhJ));
            c(uri, queryParameter2);
            aVar.B(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && n(uri) && dhv.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dhB, uri.getQueryParameter(dhB));
            hashMap.put(dhC, uri.getQueryParameter(dhC));
            hashMap.put(dhD, uri.getQueryParameter(dhD));
            hashMap.put(dhE, uri.getQueryParameter(dhE));
            hashMap.put(dhF, uri.getQueryParameter(dhF));
            sR(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(dhz);
            String queryParameter2 = uri.getQueryParameter(dhI);
            S(queryParameter, queryParameter2, uri.getQueryParameter(dhJ));
            c(uri, queryParameter2);
            aVar.B(hashMap);
        }
    }

    public void d(Uri uri, a aVar) {
        if (uri != null && n(uri) && dhw.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            sR(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(dhz);
            String queryParameter2 = uri.getQueryParameter(dhI);
            S(queryParameter, queryParameter2, uri.getQueryParameter(dhJ));
            c(uri, queryParameter2);
            aVar.B(hashMap);
        }
    }

    public void e(Uri uri, a aVar) {
        if (uri != null && n(uri) && dhx.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dhG, uri.getQueryParameter(dhG));
            S(uri.getQueryParameter(dhz), uri.getQueryParameter(dhI), uri.getQueryParameter(dhJ));
            aVar.B(hashMap);
        }
    }

    public void f(Uri uri, a aVar) {
        if (uri != null && n(uri) && dhy.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dhH, uri.getQueryParameter(dhH));
            sR(uri.getQueryParameter(PARAM_FROM));
            S(uri.getQueryParameter(dhz), uri.getQueryParameter(dhI), uri.getQueryParameter(dhJ));
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
                TiebaStatic.log(new an("c13321").cI("obj_source", bVar.aFy()).af("obj_type", bVar.getActivityId()).af("obj_param1", bVar.aFx()).af(TiebaInitialize.Params.OBJ_PARAM2, aq.equals(str2, dhO) ? 2 : 1).cI(TiebaInitialize.Params.OBJ_PARAM3, bVar.getSource()).cI("extra", bVar.aFz()));
                c.aFN().l(bVar);
            }
        }
    }

    private void c(Uri uri, String str) {
        if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !aq.equals(str, dhO)) {
            TiebaStatic.log(new an("c13391").cI("obj_type", uri.getQueryParameter("obj_type")).cI("obj_source", uri.getQueryParameter("obj_source")));
        }
    }

    private void sR(String str) {
        if (!TextUtils.isEmpty(str) && UbcStatConstant.ContentSource.SHOUBAI.equals(str)) {
            com.baidu.tbadk.util.d.bad().setShow(true);
            com.baidu.tbadk.util.d.bad().bae();
        }
    }
}
