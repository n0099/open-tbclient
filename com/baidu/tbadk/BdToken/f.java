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
    public static String cHY = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String cHZ = "/homepage";
    public static String cIa = "/enterforum";
    public static String cIb = "/recommendforum";
    public static String cIc = "/frs";
    public static String cId = "/pb";
    public static String cIe = "/tbwebview";
    public static String cIf = "/usercenter";
    public static String cIg = "/topicdetail";
    public static String cIh = "extdata";
    public static String cIi = "kw";
    public static String cIj = "tid";
    public static String cIk = "ori_ugc_nid";
    public static String cIl = "ori_ugc_tid";
    public static String cIm = "ori_ugc_type";
    public static String cIn = "ori_ugc_vid";
    public static String cIo = "portrait";
    public static String cIp = "topic_id";
    public static String PARAM_URL = "url";
    public static String cIq = "schemefrom";
    public static String PARAM_FROM = "from";
    public static String cIr = "token";
    public static String cIs = "maintablocate";
    public static String cIt = "maintab_subtab";
    public static String cIu = "from_h5";
    public static String cIv = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void n(HashMap<String, Object> hashMap);
    }

    public static final f axP() {
        return b.cIw;
    }

    /* loaded from: classes.dex */
    private static class b {
        private static final f cIw = new f();
    }

    private f() {
    }

    public static boolean n(Uri uri) {
        return uri != null && cHY.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && n(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(cIh);
            String queryParameter2 = uri.getQueryParameter(cIq);
            S(queryParameter, queryParameter2, uri.getQueryParameter(cIr));
            rB(uri.getQueryParameter(PARAM_FROM));
            c(uri, queryParameter2);
            if (cHZ.equals(uri.getPath())) {
                hashMap.put(cIs, 2);
            } else if (cIa.equals(uri.getPath())) {
                hashMap.put(cIs, 1);
            } else if (cIb.equals(uri.getPath())) {
                hashMap.put(cIs, 1);
                hashMap.put(cIt, "1_recommend");
            }
            aVar.n(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && n(uri) && cIc.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(cIi, uri.getQueryParameter(cIi));
            rB(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(cIh);
            String queryParameter2 = uri.getQueryParameter(cIq);
            S(queryParameter, queryParameter2, uri.getQueryParameter(cIr));
            c(uri, queryParameter2);
            aVar.n(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && n(uri) && cId.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(cIj, uri.getQueryParameter(cIj));
            hashMap.put(cIk, uri.getQueryParameter(cIk));
            hashMap.put(cIl, uri.getQueryParameter(cIl));
            hashMap.put(cIm, uri.getQueryParameter(cIm));
            hashMap.put(cIn, uri.getQueryParameter(cIn));
            rB(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(cIh);
            String queryParameter2 = uri.getQueryParameter(cIq);
            S(queryParameter, queryParameter2, uri.getQueryParameter(cIr));
            c(uri, queryParameter2);
            aVar.n(hashMap);
        }
    }

    public void d(Uri uri, a aVar) {
        if (uri != null && n(uri) && cIe.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            rB(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(cIh);
            String queryParameter2 = uri.getQueryParameter(cIq);
            S(queryParameter, queryParameter2, uri.getQueryParameter(cIr));
            c(uri, queryParameter2);
            aVar.n(hashMap);
        }
    }

    public void e(Uri uri, a aVar) {
        if (uri != null && n(uri) && cIf.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(cIo, uri.getQueryParameter(cIo));
            S(uri.getQueryParameter(cIh), uri.getQueryParameter(cIq), uri.getQueryParameter(cIr));
            aVar.n(hashMap);
        }
    }

    public void f(Uri uri, a aVar) {
        if (uri != null && n(uri) && cIg.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(cIp, uri.getQueryParameter(cIp));
            rB(uri.getQueryParameter(PARAM_FROM));
            S(uri.getQueryParameter(cIh), uri.getQueryParameter(cIq), uri.getQueryParameter(cIr));
            aVar.n(hashMap);
        }
    }

    private void S(String str, String str2, String str3) {
        if (!aq.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            bVar.setToken(str3);
            if (bVar.getActivityId() != 0 && bVar.axj() != 0) {
                TbSingleton.getInstance().setInvokeSource(bVar.axk());
                com.baidu.adp.lib.stats.f.aC(String.valueOf(bVar.getActivityId()));
                com.baidu.adp.lib.stats.f.aD(String.valueOf(bVar.axj()));
                TiebaStatic.log(new an("c13321").cy("obj_source", bVar.axk()).X("obj_type", bVar.getActivityId()).X("obj_param1", bVar.axj()).X(TiebaInitialize.Params.OBJ_PARAM2, aq.equals(str2, cIv) ? 2 : 1).cy(TiebaInitialize.Params.OBJ_PARAM3, bVar.getSource()).cy("extra", bVar.axl()));
                c.axz().l(bVar);
            }
        }
    }

    private void c(Uri uri, String str) {
        if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !aq.equals(str, cIv)) {
            TiebaStatic.log(new an("c13391").cy("obj_type", uri.getQueryParameter("obj_type")).cy("obj_source", uri.getQueryParameter("obj_source")));
        }
    }

    private void rB(String str) {
        if (!TextUtils.isEmpty(str) && "shoubai".equals(str)) {
            com.baidu.tbadk.util.d.aRR().setShow(true);
            com.baidu.tbadk.util.d.aRR().aRS();
        }
    }
}
