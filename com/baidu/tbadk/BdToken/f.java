package com.baidu.tbadk.BdToken;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static String epM = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String epN = "/homepage";
    public static String epO = "/enterforum";
    public static String epP = "/recommendforum";
    public static String epQ = "/frs";
    public static String epR = "/pb";
    public static String epS = "/tbwebview";
    public static String epT = "/usercenter";
    public static String epU = "/topicdetail";
    public static String epV = "/tiebachushou";
    public static String epW = "/activitypage";
    public static String epX = "/minapp";
    public static String epY = "/onekeysign";
    public static String epZ = "/hotuserrank";
    public static String eqa = "extdata";
    public static String eqb = "kw";
    public static String eqc = "tid";
    public static String eqd = "ori_ugc_nid";
    public static String eqe = "ori_ugc_tid";
    public static String eqf = "ori_ugc_type";
    public static String eqg = "ori_ugc_vid";
    public static String eqh = "portrait";
    public static String eqi = "topic_id";
    public static String PARAM_URL = "url";
    public static String eqj = "schemefrom";
    public static String PARAM_FROM = "from";
    public static String eqk = "token";
    public static String eql = "tab_name";
    public static String eqm = "maintablocate";
    public static String eqn = "maintab_subtab";
    public static String eqo = "newgod_from";
    public static String eqp = "field_id";
    public static String eqq = "chushou_third_live_type";
    public static String eqr = "chuchou_third_room_id";
    public static String eqs = "hotTrend";
    public static String eqt = "tab_id";
    public static String equ = "param_uri";
    public static String eqv = "from_h5";
    public static String eqw = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void onCallBack(HashMap<String, Object> hashMap);
    }

    public static final f bfS() {
        return b.eqx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private static final f eqx = new f();
    }

    private f() {
    }

    public static boolean p(Uri uri) {
        return uri != null && epM.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && p(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(eqa);
            String queryParameter2 = uri.getQueryParameter(eqj);
            String queryParameter3 = uri.getQueryParameter(eqk);
            String queryParameter4 = uri.getQueryParameter(eql);
            ag(queryParameter, queryParameter2, queryParameter3);
            zB(uri.getQueryParameter(PARAM_FROM));
            a("", uri, queryParameter2);
            if (epN.equals(uri.getPath())) {
                hashMap.put(eqm, 2);
                hashMap.put(eqo, uri.getQueryParameter(eqo));
                hashMap.put(eqp, uri.getQueryParameter(eqp));
                hashMap.put(eql, queryParameter4);
            } else if (epO.equals(uri.getPath())) {
                hashMap.put(eqm, 1);
                hashMap.put(eqn, queryParameter4);
            } else if (epP.equals(uri.getPath())) {
                hashMap.put(eqm, 1);
                hashMap.put(eqn, "1_recommend");
            } else if (epW.equals(uri.getPath())) {
                hashMap.put(eqm, 2);
                hashMap.put(eql, queryParameter4);
            }
            aVar.onCallBack(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && p(uri) && epQ.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(eqb, uri.getQueryParameter(eqb));
            hashMap.put(eqt, uri.getQueryParameter(eqt));
            hashMap.put(eqc, uri.getQueryParameter(eqc));
            zB(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(eqa);
            String queryParameter2 = uri.getQueryParameter(eqj);
            ag(queryParameter, queryParameter2, uri.getQueryParameter(eqk));
            a("", uri, queryParameter2);
            aVar.onCallBack(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && p(uri) && epR.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(eqc, uri.getQueryParameter(eqc));
            hashMap.put(eqd, uri.getQueryParameter(eqd));
            hashMap.put(eqe, uri.getQueryParameter(eqe));
            hashMap.put(eqf, uri.getQueryParameter(eqf));
            hashMap.put(eqg, uri.getQueryParameter(eqg));
            zB(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(eqa);
            String queryParameter2 = uri.getQueryParameter(eqj);
            ag(queryParameter, queryParameter2, uri.getQueryParameter(eqk));
            a("", uri, queryParameter2);
            aVar.onCallBack(hashMap);
        }
    }

    public void a(String str, Uri uri, a aVar) {
        if (uri != null && p(uri) && epS.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            hashMap.put(equ, uri);
            zB(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(eqa);
            String queryParameter2 = uri.getQueryParameter(eqj);
            ag(queryParameter, queryParameter2, uri.getQueryParameter(eqk));
            a(str, uri, queryParameter2);
            aVar.onCallBack(hashMap);
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
        if (uri != null && p(uri) && epT.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(eqh, uri.getQueryParameter(eqh));
            ag(uri.getQueryParameter(eqa), uri.getQueryParameter(eqj), uri.getQueryParameter(eqk));
            aVar.onCallBack(hashMap);
        }
    }

    public void e(Uri uri, a aVar) {
        if (uri != null && p(uri) && epU.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(eqi, uri.getQueryParameter(eqi));
            zB(uri.getQueryParameter(PARAM_FROM));
            ag(uri.getQueryParameter(eqa), uri.getQueryParameter(eqj), uri.getQueryParameter(eqk));
            aVar.onCallBack(hashMap);
        }
    }

    private void ag(String str, String str2, String str3) {
        if (!au.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            bVar.setToken(str3);
            if (bVar.getActivityId() != 0 && bVar.bfi() != 0) {
                TbSingleton.getInstance().setInvokeSource(bVar.bfj());
                com.baidu.adp.lib.stats.f.bY(String.valueOf(bVar.getActivityId()));
                com.baidu.adp.lib.stats.f.bZ(String.valueOf(bVar.bfi()));
                TiebaStatic.log(new ar("c13321").dR("obj_source", bVar.bfj()).ak("obj_type", bVar.getActivityId()).ak("obj_param1", bVar.bfi()).ak(TiebaInitialize.Params.OBJ_PARAM2, au.equals(str2, eqw) ? 2 : 1).dR(TiebaInitialize.Params.OBJ_PARAM3, bVar.getSource()).dR("extra", bVar.bfk()));
                c.bfy().l(bVar);
            }
        }
    }

    private void a(String str, Uri uri, String str2) {
        if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !au.equals(str2, eqw)) {
            TiebaStatic.log(new ar("c13391").dR("obj_type", uri.getQueryParameter("obj_type")).dR("obj_source", uri.getQueryParameter("obj_source")));
        }
        if (str != null && !str.contains("tbwebview") && uri != null) {
            String queryParameter = uri.getQueryParameter("is_new_schema");
            if (!TextUtils.isEmpty(queryParameter) && queryParameter.equals("1")) {
                UtilHelper.clearClipBoard();
            }
        }
    }

    private void zB(String str) {
        if (!TextUtils.isEmpty(str) && UbcStatConstant.ContentSource.SHOUBAI.equals(str)) {
            com.baidu.tbadk.util.e.bCJ().kH(true);
            com.baidu.tbadk.util.e.bCJ().bCK();
        }
    }
}
