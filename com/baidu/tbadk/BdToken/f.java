package com.baidu.tbadk.BdToken;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static String dzP = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String dzQ = "/homepage";
    public static String dzR = "/enterforum";
    public static String dzS = "/recommendforum";
    public static String dzT = "/frs";
    public static String dzU = "/pb";
    public static String dzV = "/tbwebview";
    public static String dzW = "/usercenter";
    public static String dzX = "/topicdetail";
    public static String dzY = "/tiebachushou";
    public static String dzZ = "/activitypage";
    public static String dAa = "extdata";
    public static String dAb = "kw";
    public static String dAc = "tid";
    public static String dAd = "ori_ugc_nid";
    public static String dAe = "ori_ugc_tid";
    public static String dAf = "ori_ugc_type";
    public static String dAg = "ori_ugc_vid";
    public static String dAh = "portrait";
    public static String dAi = "topic_id";
    public static String PARAM_URL = "url";
    public static String dAj = "schemefrom";
    public static String PARAM_FROM = "from";
    public static String dAk = "token";
    public static String dAl = "tab_name";
    public static String dAm = "maintablocate";
    public static String dAn = "maintab_subtab";
    public static String dAo = "newgod_from";
    public static String dAp = "field_id";
    public static String dAq = "chushou_third_live_type";
    public static String dAr = "chuchou_third_room_id";
    public static String dAs = "hotTrend";
    public static String dAt = "tab_id";
    public static String dAu = "from_h5";
    public static String dAv = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void C(HashMap<String, Object> hashMap);
    }

    public static final f aMH() {
        return b.dAw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private static final f dAw = new f();
    }

    private f() {
    }

    public static boolean p(Uri uri) {
        return uri != null && dzP.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && p(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(dAa);
            String queryParameter2 = uri.getQueryParameter(dAj);
            String queryParameter3 = uri.getQueryParameter(dAk);
            String queryParameter4 = uri.getQueryParameter(dAl);
            Y(queryParameter, queryParameter2, queryParameter3);
            uE(uri.getQueryParameter(PARAM_FROM));
            c(uri, queryParameter2);
            if (dzQ.equals(uri.getPath())) {
                hashMap.put(dAm, 2);
                hashMap.put(dAo, uri.getQueryParameter(dAo));
                hashMap.put(dAp, uri.getQueryParameter(dAp));
                hashMap.put(dAl, queryParameter4);
            } else if (dzR.equals(uri.getPath())) {
                hashMap.put(dAm, 1);
                hashMap.put(dAn, queryParameter4);
            } else if (dzS.equals(uri.getPath())) {
                hashMap.put(dAm, 1);
                hashMap.put(dAn, "1_recommend");
            } else if (dzZ.equals(uri.getPath())) {
                hashMap.put(dAm, 2);
                hashMap.put(dAl, queryParameter4);
            }
            aVar.C(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && p(uri) && dzT.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dAb, uri.getQueryParameter(dAb));
            hashMap.put(dAt, uri.getQueryParameter(dAt));
            hashMap.put(dAc, uri.getQueryParameter(dAc));
            uE(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(dAa);
            String queryParameter2 = uri.getQueryParameter(dAj);
            Y(queryParameter, queryParameter2, uri.getQueryParameter(dAk));
            c(uri, queryParameter2);
            aVar.C(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && p(uri) && dzU.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dAc, uri.getQueryParameter(dAc));
            hashMap.put(dAd, uri.getQueryParameter(dAd));
            hashMap.put(dAe, uri.getQueryParameter(dAe));
            hashMap.put(dAf, uri.getQueryParameter(dAf));
            hashMap.put(dAg, uri.getQueryParameter(dAg));
            uE(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(dAa);
            String queryParameter2 = uri.getQueryParameter(dAj);
            Y(queryParameter, queryParameter2, uri.getQueryParameter(dAk));
            c(uri, queryParameter2);
            aVar.C(hashMap);
        }
    }

    public void d(Uri uri, a aVar) {
        if (uri != null && p(uri) && dzV.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            uE(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(dAa);
            String queryParameter2 = uri.getQueryParameter(dAj);
            Y(queryParameter, queryParameter2, uri.getQueryParameter(dAk));
            c(uri, queryParameter2);
            aVar.C(hashMap);
        }
    }

    public void e(Uri uri, a aVar) {
        if (uri != null && p(uri) && dzW.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dAh, uri.getQueryParameter(dAh));
            Y(uri.getQueryParameter(dAa), uri.getQueryParameter(dAj), uri.getQueryParameter(dAk));
            aVar.C(hashMap);
        }
    }

    public void f(Uri uri, a aVar) {
        if (uri != null && p(uri) && dzX.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dAi, uri.getQueryParameter(dAi));
            uE(uri.getQueryParameter(PARAM_FROM));
            Y(uri.getQueryParameter(dAa), uri.getQueryParameter(dAj), uri.getQueryParameter(dAk));
            aVar.C(hashMap);
        }
    }

    private void Y(String str, String str2, String str3) {
        if (!ar.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            bVar.setToken(str3);
            if (bVar.getActivityId() != 0 && bVar.aLY() != 0) {
                TbSingleton.getInstance().setInvokeSource(bVar.aLZ());
                com.baidu.adp.lib.stats.f.bT(String.valueOf(bVar.getActivityId()));
                com.baidu.adp.lib.stats.f.bU(String.valueOf(bVar.aLY()));
                TiebaStatic.log(new ao("c13321").dk("obj_source", bVar.aLZ()).ag("obj_type", bVar.getActivityId()).ag("obj_param1", bVar.aLY()).ag(TiebaInitialize.Params.OBJ_PARAM2, ar.equals(str2, dAv) ? 2 : 1).dk(TiebaInitialize.Params.OBJ_PARAM3, bVar.getSource()).dk("extra", bVar.aMa()));
                c.aMo().l(bVar);
            }
        }
    }

    private void c(Uri uri, String str) {
        if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !ar.equals(str, dAv)) {
            TiebaStatic.log(new ao("c13391").dk("obj_type", uri.getQueryParameter("obj_type")).dk("obj_source", uri.getQueryParameter("obj_source")));
        }
    }

    private void uE(String str) {
        if (!TextUtils.isEmpty(str) && UbcStatConstant.ContentSource.SHOUBAI.equals(str)) {
            com.baidu.tbadk.util.d.biB().iE(true);
            com.baidu.tbadk.util.d.biB().biC();
        }
    }
}
