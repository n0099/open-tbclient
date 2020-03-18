package com.baidu.tbadk.BdToken;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static String cIk = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String cIl = "/homepage";
    public static String cIm = "/enterforum";
    public static String cIn = "/recommendforum";
    public static String cIo = "/frs";
    public static String cIp = "/pb";
    public static String cIq = "/tbwebview";
    public static String cIr = "/usercenter";
    public static String cIs = "/topicdetail";
    public static String cIt = "extdata";
    public static String cIu = "kw";
    public static String cIv = "tid";
    public static String cIw = "ori_ugc_nid";
    public static String cIx = "ori_ugc_tid";
    public static String cIy = "ori_ugc_type";
    public static String cIz = "ori_ugc_vid";
    public static String cIA = "portrait";
    public static String cIB = "topic_id";
    public static String PARAM_URL = "url";
    public static String cIC = "schemefrom";
    public static String PARAM_FROM = "from";
    public static String cID = "token";
    public static String cIE = "maintablocate";
    public static String cIF = "maintab_subtab";
    public static String cIG = "from_h5";
    public static String cIH = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void n(HashMap<String, Object> hashMap);
    }

    public static final f axS() {
        return b.cII;
    }

    /* loaded from: classes.dex */
    private static class b {
        private static final f cII = new f();
    }

    private f() {
    }

    public static boolean n(Uri uri) {
        return uri != null && cIk.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && n(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(cIt);
            String queryParameter2 = uri.getQueryParameter(cIC);
            S(queryParameter, queryParameter2, uri.getQueryParameter(cID));
            rA(uri.getQueryParameter(PARAM_FROM));
            c(uri, queryParameter2);
            if (cIl.equals(uri.getPath())) {
                hashMap.put(cIE, 2);
            } else if (cIm.equals(uri.getPath())) {
                hashMap.put(cIE, 1);
            } else if (cIn.equals(uri.getPath())) {
                hashMap.put(cIE, 1);
                hashMap.put(cIF, "1_recommend");
            }
            aVar.n(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && n(uri) && cIo.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(cIu, uri.getQueryParameter(cIu));
            rA(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(cIt);
            String queryParameter2 = uri.getQueryParameter(cIC);
            S(queryParameter, queryParameter2, uri.getQueryParameter(cID));
            c(uri, queryParameter2);
            aVar.n(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && n(uri) && cIp.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(cIv, uri.getQueryParameter(cIv));
            hashMap.put(cIw, uri.getQueryParameter(cIw));
            hashMap.put(cIx, uri.getQueryParameter(cIx));
            hashMap.put(cIy, uri.getQueryParameter(cIy));
            hashMap.put(cIz, uri.getQueryParameter(cIz));
            rA(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(cIt);
            String queryParameter2 = uri.getQueryParameter(cIC);
            S(queryParameter, queryParameter2, uri.getQueryParameter(cID));
            c(uri, queryParameter2);
            aVar.n(hashMap);
        }
    }

    public void d(Uri uri, a aVar) {
        if (uri != null && n(uri) && cIq.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            rA(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(cIt);
            String queryParameter2 = uri.getQueryParameter(cIC);
            S(queryParameter, queryParameter2, uri.getQueryParameter(cID));
            c(uri, queryParameter2);
            aVar.n(hashMap);
        }
    }

    public void e(Uri uri, a aVar) {
        if (uri != null && n(uri) && cIr.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(cIA, uri.getQueryParameter(cIA));
            S(uri.getQueryParameter(cIt), uri.getQueryParameter(cIC), uri.getQueryParameter(cID));
            aVar.n(hashMap);
        }
    }

    public void f(Uri uri, a aVar) {
        if (uri != null && n(uri) && cIs.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(cIB, uri.getQueryParameter(cIB));
            rA(uri.getQueryParameter(PARAM_FROM));
            S(uri.getQueryParameter(cIt), uri.getQueryParameter(cIC), uri.getQueryParameter(cID));
            aVar.n(hashMap);
        }
    }

    private void S(String str, String str2, String str3) {
        if (!aq.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            bVar.setToken(str3);
            if (bVar.getActivityId() != 0 && bVar.axm() != 0) {
                TbSingleton.getInstance().setInvokeSource(bVar.axn());
                com.baidu.adp.lib.stats.f.aC(String.valueOf(bVar.getActivityId()));
                com.baidu.adp.lib.stats.f.aD(String.valueOf(bVar.axm()));
                TiebaStatic.log(new an("c13321").cx("obj_source", bVar.axn()).X("obj_type", bVar.getActivityId()).X("obj_param1", bVar.axm()).X(TiebaInitialize.Params.OBJ_PARAM2, aq.equals(str2, cIH) ? 2 : 1).cx(TiebaInitialize.Params.OBJ_PARAM3, bVar.getSource()).cx("extra", bVar.axo()));
                c.axC().l(bVar);
            }
        }
    }

    private void c(Uri uri, String str) {
        if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !aq.equals(str, cIH)) {
            TiebaStatic.log(new an("c13391").cx("obj_type", uri.getQueryParameter("obj_type")).cx("obj_source", uri.getQueryParameter("obj_source")));
        }
    }

    private void rA(String str) {
        if (!TextUtils.isEmpty(str) && "shoubai".equals(str)) {
            com.baidu.tbadk.util.d.aRW().setShow(true);
            com.baidu.tbadk.util.d.aRW().aRX();
        }
    }
}
