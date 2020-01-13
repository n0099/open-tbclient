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
    public static String cEb = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String cEc = "/homepage";
    public static String cEd = "/enterforum";
    public static String cEe = "/recommendforum";
    public static String cEf = "/frs";
    public static String cEg = "/pb";
    public static String cEh = "/tbwebview";
    public static String cEi = "extdata";
    public static String cEj = "kw";
    public static String cEk = "tid";
    public static String PARAM_URL = "url";
    public static String cEl = "schemefrom";
    public static String PARAM_FROM = "from";
    public static String cEm = "token";
    public static String cEn = "maintablocate";
    public static String cEo = "maintab_subtab";
    public static String cEp = "from_h5";
    public static String cEq = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void n(HashMap<String, Object> hashMap);
    }

    public static final f avz() {
        return b.cEr;
    }

    /* loaded from: classes.dex */
    private static class b {
        private static final f cEr = new f();
    }

    private f() {
    }

    public static boolean m(Uri uri) {
        return uri != null && cEb.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && m(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(cEi);
            String queryParameter2 = uri.getQueryParameter(cEl);
            R(queryParameter, queryParameter2, uri.getQueryParameter(cEm));
            rm(uri.getQueryParameter(PARAM_FROM));
            c(uri, queryParameter2);
            if (cEc.equals(uri.getPath())) {
                hashMap.put(cEn, 2);
            } else if (cEd.equals(uri.getPath())) {
                hashMap.put(cEn, 1);
            } else if (cEe.equals(uri.getPath())) {
                hashMap.put(cEn, 1);
                hashMap.put(cEo, "1_recommend");
            }
            aVar.n(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && m(uri) && cEf.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(cEj, uri.getQueryParameter(cEj));
            rm(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(cEi);
            String queryParameter2 = uri.getQueryParameter(cEl);
            R(queryParameter, queryParameter2, uri.getQueryParameter(cEm));
            c(uri, queryParameter2);
            aVar.n(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && m(uri) && cEg.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(cEk, uri.getQueryParameter(cEk));
            rm(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(cEi);
            String queryParameter2 = uri.getQueryParameter(cEl);
            R(queryParameter, queryParameter2, uri.getQueryParameter(cEm));
            c(uri, queryParameter2);
            aVar.n(hashMap);
        }
    }

    public void d(Uri uri, a aVar) {
        if (uri != null && m(uri) && cEh.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            rm(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(cEi);
            String queryParameter2 = uri.getQueryParameter(cEl);
            R(queryParameter, queryParameter2, uri.getQueryParameter(cEm));
            c(uri, queryParameter2);
            aVar.n(hashMap);
        }
    }

    private void R(String str, String str2, String str3) {
        if (!aq.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            bVar.setToken(str3);
            if (bVar.getActivityId() != 0 && bVar.auT() != 0) {
                TbSingleton.getInstance().setInvokeSource(bVar.auU());
                TiebaStatic.log(new an("c13321").cp("obj_source", bVar.auU()).Z("obj_type", bVar.getActivityId()).Z("obj_param1", bVar.auT()).Z(TiebaInitialize.Params.OBJ_PARAM2, aq.equals(str2, cEq) ? 2 : 1).cp(TiebaInitialize.Params.OBJ_PARAM3, bVar.getSource()).cp("extra", bVar.auV()));
                c.avj().l(bVar);
            }
        }
    }

    private void c(Uri uri, String str) {
        if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !aq.equals(str, cEq)) {
            TiebaStatic.log(new an("c13391").cp("obj_type", uri.getQueryParameter("obj_type")).cp("obj_source", uri.getQueryParameter("obj_source")));
        }
    }

    private void rm(String str) {
        if (!TextUtils.isEmpty(str) && "shoubai".equals(str)) {
            com.baidu.tbadk.util.d.aPy().setShow(true);
            com.baidu.tbadk.util.d.aPy().aPz();
        }
    }
}
