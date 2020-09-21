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
    public static String dRc = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String dRd = "/homepage";
    public static String dRe = "/enterforum";
    public static String dRf = "/recommendforum";
    public static String dRg = "/frs";
    public static String dRh = "/pb";
    public static String dRi = "/tbwebview";
    public static String dRj = "/usercenter";
    public static String dRk = "/topicdetail";
    public static String dRl = "/tiebachushou";
    public static String dRm = "/activitypage";
    public static String dRn = "/minapp";
    public static String dRo = "extdata";
    public static String dRp = "kw";
    public static String dRq = "tid";
    public static String dRr = "ori_ugc_nid";
    public static String dRs = "ori_ugc_tid";
    public static String dRt = "ori_ugc_type";
    public static String dRu = "ori_ugc_vid";
    public static String dRv = "portrait";
    public static String dRw = "topic_id";
    public static String PARAM_URL = "url";
    public static String dRx = "schemefrom";
    public static String PARAM_FROM = "from";
    public static String dRy = "token";
    public static String dRz = "tab_name";
    public static String dRA = "maintablocate";
    public static String dRB = "maintab_subtab";
    public static String dRC = "newgod_from";
    public static String dRD = "field_id";
    public static String dRE = "chushou_third_live_type";
    public static String dRF = "chuchou_third_room_id";
    public static String dRG = "hotTrend";
    public static String dRH = "tab_id";
    public static String dRI = "param_uri";
    public static String dRJ = "from_h5";
    public static String dRK = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void z(HashMap<String, Object> hashMap);
    }

    public static final f aZy() {
        return b.dRL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private static final f dRL = new f();
    }

    private f() {
    }

    public static boolean p(Uri uri) {
        return uri != null && dRc.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && p(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(dRo);
            String queryParameter2 = uri.getQueryParameter(dRx);
            String queryParameter3 = uri.getQueryParameter(dRy);
            String queryParameter4 = uri.getQueryParameter(dRz);
            Y(queryParameter, queryParameter2, queryParameter3);
            yn(uri.getQueryParameter(PARAM_FROM));
            a("", uri, queryParameter2);
            if (dRd.equals(uri.getPath())) {
                hashMap.put(dRA, 2);
                hashMap.put(dRC, uri.getQueryParameter(dRC));
                hashMap.put(dRD, uri.getQueryParameter(dRD));
                hashMap.put(dRz, queryParameter4);
            } else if (dRe.equals(uri.getPath())) {
                hashMap.put(dRA, 1);
                hashMap.put(dRB, queryParameter4);
            } else if (dRf.equals(uri.getPath())) {
                hashMap.put(dRA, 1);
                hashMap.put(dRB, "1_recommend");
            } else if (dRm.equals(uri.getPath())) {
                hashMap.put(dRA, 2);
                hashMap.put(dRz, queryParameter4);
            }
            aVar.z(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && p(uri) && dRg.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dRp, uri.getQueryParameter(dRp));
            hashMap.put(dRH, uri.getQueryParameter(dRH));
            hashMap.put(dRq, uri.getQueryParameter(dRq));
            yn(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(dRo);
            String queryParameter2 = uri.getQueryParameter(dRx);
            Y(queryParameter, queryParameter2, uri.getQueryParameter(dRy));
            a("", uri, queryParameter2);
            aVar.z(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && p(uri) && dRh.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dRq, uri.getQueryParameter(dRq));
            hashMap.put(dRr, uri.getQueryParameter(dRr));
            hashMap.put(dRs, uri.getQueryParameter(dRs));
            hashMap.put(dRt, uri.getQueryParameter(dRt));
            hashMap.put(dRu, uri.getQueryParameter(dRu));
            yn(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(dRo);
            String queryParameter2 = uri.getQueryParameter(dRx);
            Y(queryParameter, queryParameter2, uri.getQueryParameter(dRy));
            a("", uri, queryParameter2);
            aVar.z(hashMap);
        }
    }

    public void a(String str, Uri uri, a aVar) {
        if (uri != null && p(uri) && dRi.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            hashMap.put(dRI, uri);
            yn(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(dRo);
            String queryParameter2 = uri.getQueryParameter(dRx);
            Y(queryParameter, queryParameter2, uri.getQueryParameter(dRy));
            a(str, uri, queryParameter2);
            aVar.z(hashMap);
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
        if (uri != null && p(uri) && dRj.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dRv, uri.getQueryParameter(dRv));
            Y(uri.getQueryParameter(dRo), uri.getQueryParameter(dRx), uri.getQueryParameter(dRy));
            aVar.z(hashMap);
        }
    }

    public void e(Uri uri, a aVar) {
        if (uri != null && p(uri) && dRk.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(dRw, uri.getQueryParameter(dRw));
            yn(uri.getQueryParameter(PARAM_FROM));
            Y(uri.getQueryParameter(dRo), uri.getQueryParameter(dRx), uri.getQueryParameter(dRy));
            aVar.z(hashMap);
        }
    }

    private void Y(String str, String str2, String str3) {
        if (!at.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            bVar.setToken(str3);
            if (bVar.getActivityId() != 0 && bVar.aYO() != 0) {
                TbSingleton.getInstance().setInvokeSource(bVar.aYP());
                com.baidu.adp.lib.stats.f.bY(String.valueOf(bVar.getActivityId()));
                com.baidu.adp.lib.stats.f.bZ(String.valueOf(bVar.aYO()));
                TiebaStatic.log(new aq("c13321").dF("obj_source", bVar.aYP()).ai("obj_type", bVar.getActivityId()).ai("obj_param1", bVar.aYO()).ai(TiebaInitialize.Params.OBJ_PARAM2, at.equals(str2, dRK) ? 2 : 1).dF(TiebaInitialize.Params.OBJ_PARAM3, bVar.getSource()).dF("extra", bVar.aYQ()));
                c.aZe().l(bVar);
            }
        }
    }

    private void a(String str, Uri uri, String str2) {
        if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !at.equals(str2, dRK)) {
            TiebaStatic.log(new aq("c13391").dF("obj_type", uri.getQueryParameter("obj_type")).dF("obj_source", uri.getQueryParameter("obj_source")));
        }
        if (str != null && !str.contains("tbwebview") && uri != null) {
            String queryParameter = uri.getQueryParameter("is_new_schema");
            if (!TextUtils.isEmpty(queryParameter) && queryParameter.equals("1")) {
                UtilHelper.clearClipBoard();
            }
        }
    }

    private void yn(String str) {
        if (!TextUtils.isEmpty(str) && UbcStatConstant.ContentSource.SHOUBAI.equals(str)) {
            com.baidu.tbadk.util.e.bwo().jM(true);
            com.baidu.tbadk.util.e.bwo().bwp();
        }
    }
}
