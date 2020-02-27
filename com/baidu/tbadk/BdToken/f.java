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
    public static String cHX = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String cHY = "/homepage";
    public static String cHZ = "/enterforum";
    public static String cIa = "/recommendforum";
    public static String cIb = "/frs";
    public static String cIc = "/pb";
    public static String cId = "/tbwebview";
    public static String cIe = "/usercenter";
    public static String cIf = "/topicdetail";
    public static String cIg = "extdata";
    public static String cIh = "kw";
    public static String cIi = "tid";
    public static String cIj = "ori_ugc_nid";
    public static String cIk = "ori_ugc_tid";
    public static String cIl = "ori_ugc_type";
    public static String cIm = "ori_ugc_vid";
    public static String cIn = "portrait";
    public static String cIo = "topic_id";
    public static String PARAM_URL = "url";
    public static String cIp = "schemefrom";
    public static String PARAM_FROM = "from";
    public static String cIq = "token";
    public static String cIr = "maintablocate";
    public static String cIs = "maintab_subtab";
    public static String cIt = "from_h5";
    public static String cIu = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void n(HashMap<String, Object> hashMap);
    }

    public static final f axN() {
        return b.cIv;
    }

    /* loaded from: classes.dex */
    private static class b {
        private static final f cIv = new f();
    }

    private f() {
    }

    public static boolean n(Uri uri) {
        return uri != null && cHX.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && n(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(cIg);
            String queryParameter2 = uri.getQueryParameter(cIp);
            S(queryParameter, queryParameter2, uri.getQueryParameter(cIq));
            rB(uri.getQueryParameter(PARAM_FROM));
            c(uri, queryParameter2);
            if (cHY.equals(uri.getPath())) {
                hashMap.put(cIr, 2);
            } else if (cHZ.equals(uri.getPath())) {
                hashMap.put(cIr, 1);
            } else if (cIa.equals(uri.getPath())) {
                hashMap.put(cIr, 1);
                hashMap.put(cIs, "1_recommend");
            }
            aVar.n(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && n(uri) && cIb.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(cIh, uri.getQueryParameter(cIh));
            rB(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(cIg);
            String queryParameter2 = uri.getQueryParameter(cIp);
            S(queryParameter, queryParameter2, uri.getQueryParameter(cIq));
            c(uri, queryParameter2);
            aVar.n(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && n(uri) && cIc.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(cIi, uri.getQueryParameter(cIi));
            hashMap.put(cIj, uri.getQueryParameter(cIj));
            hashMap.put(cIk, uri.getQueryParameter(cIk));
            hashMap.put(cIl, uri.getQueryParameter(cIl));
            hashMap.put(cIm, uri.getQueryParameter(cIm));
            rB(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(cIg);
            String queryParameter2 = uri.getQueryParameter(cIp);
            S(queryParameter, queryParameter2, uri.getQueryParameter(cIq));
            c(uri, queryParameter2);
            aVar.n(hashMap);
        }
    }

    public void d(Uri uri, a aVar) {
        if (uri != null && n(uri) && cId.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            rB(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(cIg);
            String queryParameter2 = uri.getQueryParameter(cIp);
            S(queryParameter, queryParameter2, uri.getQueryParameter(cIq));
            c(uri, queryParameter2);
            aVar.n(hashMap);
        }
    }

    public void e(Uri uri, a aVar) {
        if (uri != null && n(uri) && cIe.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(cIn, uri.getQueryParameter(cIn));
            S(uri.getQueryParameter(cIg), uri.getQueryParameter(cIp), uri.getQueryParameter(cIq));
            aVar.n(hashMap);
        }
    }

    public void f(Uri uri, a aVar) {
        if (uri != null && n(uri) && cIf.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(cIo, uri.getQueryParameter(cIo));
            rB(uri.getQueryParameter(PARAM_FROM));
            S(uri.getQueryParameter(cIg), uri.getQueryParameter(cIp), uri.getQueryParameter(cIq));
            aVar.n(hashMap);
        }
    }

    private void S(String str, String str2, String str3) {
        if (!aq.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            bVar.setToken(str3);
            if (bVar.getActivityId() != 0 && bVar.axh() != 0) {
                TbSingleton.getInstance().setInvokeSource(bVar.axi());
                com.baidu.adp.lib.stats.f.aC(String.valueOf(bVar.getActivityId()));
                com.baidu.adp.lib.stats.f.aD(String.valueOf(bVar.axh()));
                TiebaStatic.log(new an("c13321").cy("obj_source", bVar.axi()).X("obj_type", bVar.getActivityId()).X("obj_param1", bVar.axh()).X(TiebaInitialize.Params.OBJ_PARAM2, aq.equals(str2, cIu) ? 2 : 1).cy(TiebaInitialize.Params.OBJ_PARAM3, bVar.getSource()).cy("extra", bVar.axj()));
                c.axx().l(bVar);
            }
        }
    }

    private void c(Uri uri, String str) {
        if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !aq.equals(str, cIu)) {
            TiebaStatic.log(new an("c13391").cy("obj_type", uri.getQueryParameter("obj_type")).cy("obj_source", uri.getQueryParameter("obj_source")));
        }
    }

    private void rB(String str) {
        if (!TextUtils.isEmpty(str) && "shoubai".equals(str)) {
            com.baidu.tbadk.util.d.aRP().setShow(true);
            com.baidu.tbadk.util.d.aRP().aRQ();
        }
    }
}
