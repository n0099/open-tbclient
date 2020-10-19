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
    public static String edd = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String ede = "/homepage";
    public static String edf = "/enterforum";
    public static String edg = "/recommendforum";
    public static String edh = "/frs";
    public static String edi = "/pb";
    public static String edj = "/tbwebview";
    public static String edk = "/usercenter";
    public static String edl = "/topicdetail";
    public static String edm = "/tiebachushou";
    public static String edn = "/activitypage";
    public static String edo = "/minapp";
    public static String edp = "extdata";
    public static String edq = "kw";
    public static String edr = "tid";
    public static String eds = "ori_ugc_nid";
    public static String edt = "ori_ugc_tid";
    public static String edu = "ori_ugc_type";
    public static String edv = "ori_ugc_vid";
    public static String edw = "portrait";
    public static String edx = "topic_id";
    public static String PARAM_URL = "url";
    public static String edy = "schemefrom";
    public static String PARAM_FROM = "from";
    public static String edz = "token";
    public static String edA = "tab_name";
    public static String edB = "maintablocate";
    public static String edC = "maintab_subtab";
    public static String edD = "newgod_from";
    public static String edE = "field_id";
    public static String edF = "chushou_third_live_type";
    public static String edG = "chuchou_third_room_id";
    public static String edH = "hotTrend";
    public static String edI = "tab_id";
    public static String edJ = "param_uri";
    public static String edK = "from_h5";
    public static String edL = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void B(HashMap<String, Object> hashMap);
    }

    public static final f bcg() {
        return b.edM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private static final f edM = new f();
    }

    private f() {
    }

    public static boolean p(Uri uri) {
        return uri != null && edd.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && p(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(edp);
            String queryParameter2 = uri.getQueryParameter(edy);
            String queryParameter3 = uri.getQueryParameter(edz);
            String queryParameter4 = uri.getQueryParameter(edA);
            Z(queryParameter, queryParameter2, queryParameter3);
            yZ(uri.getQueryParameter(PARAM_FROM));
            a("", uri, queryParameter2);
            if (ede.equals(uri.getPath())) {
                hashMap.put(edB, 2);
                hashMap.put(edD, uri.getQueryParameter(edD));
                hashMap.put(edE, uri.getQueryParameter(edE));
                hashMap.put(edA, queryParameter4);
            } else if (edf.equals(uri.getPath())) {
                hashMap.put(edB, 1);
                hashMap.put(edC, queryParameter4);
            } else if (edg.equals(uri.getPath())) {
                hashMap.put(edB, 1);
                hashMap.put(edC, "1_recommend");
            } else if (edn.equals(uri.getPath())) {
                hashMap.put(edB, 2);
                hashMap.put(edA, queryParameter4);
            }
            aVar.B(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && p(uri) && edh.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(edq, uri.getQueryParameter(edq));
            hashMap.put(edI, uri.getQueryParameter(edI));
            hashMap.put(edr, uri.getQueryParameter(edr));
            yZ(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(edp);
            String queryParameter2 = uri.getQueryParameter(edy);
            Z(queryParameter, queryParameter2, uri.getQueryParameter(edz));
            a("", uri, queryParameter2);
            aVar.B(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && p(uri) && edi.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(edr, uri.getQueryParameter(edr));
            hashMap.put(eds, uri.getQueryParameter(eds));
            hashMap.put(edt, uri.getQueryParameter(edt));
            hashMap.put(edu, uri.getQueryParameter(edu));
            hashMap.put(edv, uri.getQueryParameter(edv));
            yZ(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(edp);
            String queryParameter2 = uri.getQueryParameter(edy);
            Z(queryParameter, queryParameter2, uri.getQueryParameter(edz));
            a("", uri, queryParameter2);
            aVar.B(hashMap);
        }
    }

    public void a(String str, Uri uri, a aVar) {
        if (uri != null && p(uri) && edj.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            hashMap.put(edJ, uri);
            yZ(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(edp);
            String queryParameter2 = uri.getQueryParameter(edy);
            Z(queryParameter, queryParameter2, uri.getQueryParameter(edz));
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
        if (uri != null && p(uri) && edk.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(edw, uri.getQueryParameter(edw));
            Z(uri.getQueryParameter(edp), uri.getQueryParameter(edy), uri.getQueryParameter(edz));
            aVar.B(hashMap);
        }
    }

    public void e(Uri uri, a aVar) {
        if (uri != null && p(uri) && edl.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(edx, uri.getQueryParameter(edx));
            yZ(uri.getQueryParameter(PARAM_FROM));
            Z(uri.getQueryParameter(edp), uri.getQueryParameter(edy), uri.getQueryParameter(edz));
            aVar.B(hashMap);
        }
    }

    private void Z(String str, String str2, String str3) {
        if (!at.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            bVar.setToken(str3);
            if (bVar.getActivityId() != 0 && bVar.bbw() != 0) {
                TbSingleton.getInstance().setInvokeSource(bVar.bbx());
                com.baidu.adp.lib.stats.f.bY(String.valueOf(bVar.getActivityId()));
                com.baidu.adp.lib.stats.f.bZ(String.valueOf(bVar.bbw()));
                TiebaStatic.log(new aq("c13321").dK("obj_source", bVar.bbx()).aj("obj_type", bVar.getActivityId()).aj("obj_param1", bVar.bbw()).aj(TiebaInitialize.Params.OBJ_PARAM2, at.equals(str2, edL) ? 2 : 1).dK(TiebaInitialize.Params.OBJ_PARAM3, bVar.getSource()).dK("extra", bVar.bby()));
                c.bbM().l(bVar);
            }
        }
    }

    private void a(String str, Uri uri, String str2) {
        if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !at.equals(str2, edL)) {
            TiebaStatic.log(new aq("c13391").dK("obj_type", uri.getQueryParameter("obj_type")).dK("obj_source", uri.getQueryParameter("obj_source")));
        }
        if (str != null && !str.contains("tbwebview") && uri != null) {
            String queryParameter = uri.getQueryParameter("is_new_schema");
            if (!TextUtils.isEmpty(queryParameter) && queryParameter.equals("1")) {
                UtilHelper.clearClipBoard();
            }
        }
    }

    private void yZ(String str) {
        if (!TextUtils.isEmpty(str) && UbcStatConstant.ContentSource.SHOUBAI.equals(str)) {
            com.baidu.tbadk.util.e.byY().kk(true);
            com.baidu.tbadk.util.e.byY().byZ();
        }
    }
}
