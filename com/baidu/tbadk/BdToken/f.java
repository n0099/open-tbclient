package com.baidu.tbadk.BdToken;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static String dFL = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String dFM = "/homepage";
    public static String dFN = "/enterforum";
    public static String dFO = "/recommendforum";
    public static String dFP = "/frs";
    public static String dFQ = "/pb";
    public static String dFR = "/tbwebview";
    public static String dFS = "/usercenter";
    public static String dFT = "/topicdetail";
    public static String dFU = "/tiebachushou";
    public static String dFV = "/activitypage";
    public static String dFW = "extdata";
    public static String dFX = "kw";
    public static String dFY = "tid";
    public static String dFZ = "ori_ugc_nid";
    public static String dGa = "ori_ugc_tid";
    public static String dGb = "ori_ugc_type";
    public static String dGc = "ori_ugc_vid";
    public static String dGd = "portrait";
    public static String dGe = "topic_id";
    public static String PARAM_URL = "url";
    public static String dGf = "schemefrom";
    public static String PARAM_FROM = "from";
    public static String dGg = "token";
    public static String dGh = "tab_name";
    public static String dGi = "maintablocate";
    public static String dGj = "maintab_subtab";
    public static String dGk = "newgod_from";
    public static String dGl = "field_id";
    public static String dGm = "chushou_third_live_type";
    public static String dGn = "chuchou_third_room_id";
    public static String dGo = "hotTrend";
    public static String dGp = "tab_id";
    public static String dGq = "from_h5";
    public static String dGr = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void B(HashMap<String, Object> hashMap);
    }

    public static final f aQv() {
        return b.dGs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private static final f dGs = new f();
    }

    private f() {
    }

    public static boolean p(Uri uri) {
        return uri != null && dFL.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && p(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(dFW);
            String queryParameter2 = uri.getQueryParameter(dGf);
            String queryParameter3 = uri.getQueryParameter(dGg);
            String queryParameter4 = uri.getQueryParameter(dGh);
            Y(queryParameter, queryParameter2, queryParameter3);
            vH(uri.getQueryParameter(PARAM_FROM));
            c(uri, queryParameter2);
            if (dFM.equals(uri.getPath())) {
                hashMap.put(dGi, 2);
                hashMap.put(dGk, uri.getQueryParameter(dGk));
                hashMap.put(dGl, uri.getQueryParameter(dGl));
                hashMap.put(dGh, queryParameter4);
            } else if (dFN.equals(uri.getPath())) {
                hashMap.put(dGi, 1);
                hashMap.put(dGj, queryParameter4);
            } else if (dFO.equals(uri.getPath())) {
                hashMap.put(dGi, 1);
                hashMap.put(dGj, "1_recommend");
            } else if (dFV.equals(uri.getPath())) {
                hashMap.put(dGi, 2);
                hashMap.put(dGh, queryParameter4);
            }
            aVar.B(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && p(uri) && dFP.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dFX, uri.getQueryParameter(dFX));
            hashMap.put(dGp, uri.getQueryParameter(dGp));
            hashMap.put(dFY, uri.getQueryParameter(dFY));
            vH(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(dFW);
            String queryParameter2 = uri.getQueryParameter(dGf);
            Y(queryParameter, queryParameter2, uri.getQueryParameter(dGg));
            c(uri, queryParameter2);
            aVar.B(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && p(uri) && dFQ.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dFY, uri.getQueryParameter(dFY));
            hashMap.put(dFZ, uri.getQueryParameter(dFZ));
            hashMap.put(dGa, uri.getQueryParameter(dGa));
            hashMap.put(dGb, uri.getQueryParameter(dGb));
            hashMap.put(dGc, uri.getQueryParameter(dGc));
            vH(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(dFW);
            String queryParameter2 = uri.getQueryParameter(dGf);
            Y(queryParameter, queryParameter2, uri.getQueryParameter(dGg));
            c(uri, queryParameter2);
            aVar.B(hashMap);
        }
    }

    public void d(Uri uri, a aVar) {
        if (uri != null && p(uri) && dFR.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            vH(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(dFW);
            String queryParameter2 = uri.getQueryParameter(dGf);
            Y(queryParameter, queryParameter2, uri.getQueryParameter(dGg));
            c(uri, queryParameter2);
            aVar.B(hashMap);
        }
    }

    public void e(Uri uri, a aVar) {
        if (uri != null && p(uri) && dFS.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dGd, uri.getQueryParameter(dGd));
            Y(uri.getQueryParameter(dFW), uri.getQueryParameter(dGf), uri.getQueryParameter(dGg));
            aVar.B(hashMap);
        }
    }

    public void f(Uri uri, a aVar) {
        if (uri != null && p(uri) && dFT.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dGe, uri.getQueryParameter(dGe));
            vH(uri.getQueryParameter(PARAM_FROM));
            Y(uri.getQueryParameter(dFW), uri.getQueryParameter(dGf), uri.getQueryParameter(dGg));
            aVar.B(hashMap);
        }
    }

    private void Y(String str, String str2, String str3) {
        if (!as.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            bVar.setToken(str3);
            if (bVar.getActivityId() != 0 && bVar.aPM() != 0) {
                TbSingleton.getInstance().setInvokeSource(bVar.aPN());
                com.baidu.adp.lib.stats.f.bR(String.valueOf(bVar.getActivityId()));
                com.baidu.adp.lib.stats.f.bS(String.valueOf(bVar.aPM()));
                TiebaStatic.log(new ap("c13321").dn("obj_source", bVar.aPN()).ah("obj_type", bVar.getActivityId()).ah("obj_param1", bVar.aPM()).ah(TiebaInitialize.Params.OBJ_PARAM2, as.equals(str2, dGr) ? 2 : 1).dn(TiebaInitialize.Params.OBJ_PARAM3, bVar.getSource()).dn("extra", bVar.aPO()));
                c.aQc().l(bVar);
            }
        }
    }

    private void c(Uri uri, String str) {
        if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !as.equals(str, dGr)) {
            TiebaStatic.log(new ap("c13391").dn("obj_type", uri.getQueryParameter("obj_type")).dn("obj_source", uri.getQueryParameter("obj_source")));
        }
    }

    private void vH(String str) {
        if (!TextUtils.isEmpty(str) && UbcStatConstant.ContentSource.SHOUBAI.equals(str)) {
            com.baidu.tbadk.util.e.bmw().jl(true);
            com.baidu.tbadk.util.e.bmw().bmx();
        }
    }
}
