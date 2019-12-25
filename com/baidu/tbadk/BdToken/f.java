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
    public static String cDQ = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String cDR = "/homepage";
    public static String cDS = "/enterforum";
    public static String cDT = "/recommendforum";
    public static String cDU = "/frs";
    public static String cDV = "/pb";
    public static String cDW = "/tbwebview";
    public static String cDX = "extdata";
    public static String cDY = "kw";
    public static String cDZ = "tid";
    public static String PARAM_URL = "url";
    public static String cEa = "schemefrom";
    public static String PARAM_FROM = "from";
    public static String cEb = "maintablocate";
    public static String cEc = "maintab_subtab";
    public static String cEd = "from_h5";
    public static String cEe = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void n(HashMap<String, Object> hashMap);
    }

    public static final f avg() {
        return b.cEf;
    }

    /* loaded from: classes.dex */
    private static class b {
        private static final f cEf = new f();
    }

    private f() {
    }

    public static boolean m(Uri uri) {
        return uri != null && cDQ.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && m(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(cDX);
            String queryParameter2 = uri.getQueryParameter(cEa);
            cc(queryParameter, queryParameter2);
            rj(uri.getQueryParameter(PARAM_FROM));
            c(uri, queryParameter2);
            if (cDR.equals(uri.getPath())) {
                hashMap.put(cEb, 2);
            } else if (cDS.equals(uri.getPath())) {
                hashMap.put(cEb, 1);
            } else if (cDT.equals(uri.getPath())) {
                hashMap.put(cEb, 1);
                hashMap.put(cEc, "1_recommend");
            }
            aVar.n(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && m(uri) && cDU.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(cDY, uri.getQueryParameter(cDY));
            rj(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(cDX);
            String queryParameter2 = uri.getQueryParameter(cEa);
            cc(queryParameter, queryParameter2);
            c(uri, queryParameter2);
            aVar.n(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && m(uri) && cDV.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(cDZ, uri.getQueryParameter(cDZ));
            rj(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(cDX);
            String queryParameter2 = uri.getQueryParameter(cEa);
            cc(queryParameter, queryParameter2);
            c(uri, queryParameter2);
            aVar.n(hashMap);
        }
    }

    public void d(Uri uri, a aVar) {
        if (uri != null && m(uri) && cDW.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            rj(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(cDX);
            String queryParameter2 = uri.getQueryParameter(cEa);
            cc(queryParameter, queryParameter2);
            c(uri, queryParameter2);
            aVar.n(hashMap);
        }
    }

    private void cc(String str, String str2) {
        if (!aq.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            if (bVar.getActivityId() != 0 && bVar.auA() != 0) {
                TbSingleton.getInstance().setInvokeSource(bVar.auB());
                TiebaStatic.log(new an("c13321").cp("obj_source", bVar.auB()).Z("obj_type", bVar.getActivityId()).Z("obj_param1", bVar.auA()).Z(TiebaInitialize.Params.OBJ_PARAM2, aq.equals(str2, cEe) ? 2 : 1).cp(TiebaInitialize.Params.OBJ_PARAM3, bVar.getSource()).cp("extra", bVar.auC()));
                c.auQ().l(bVar);
            }
        }
    }

    private void c(Uri uri, String str) {
        if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !aq.equals(str, cEe)) {
            TiebaStatic.log(new an("c13391").cp("obj_type", uri.getQueryParameter("obj_type")).cp("obj_source", uri.getQueryParameter("obj_source")));
        }
    }

    private void rj(String str) {
        if (!TextUtils.isEmpty(str) && "shoubai".equals(str)) {
            com.baidu.tbadk.util.d.aPf().setShow(true);
            com.baidu.tbadk.util.d.aPf().aPg();
        }
    }
}
