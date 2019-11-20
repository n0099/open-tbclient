package com.baidu.tbadk.BdToken;

import android.net.Uri;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static String bRq = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String bRr = "/homepage";
    public static String bRs = "/enterforum";
    public static String bRt = "/recommendforum";
    public static String bRu = "/frs";
    public static String bRv = "/pb";
    public static String bRw = "/tbwebview";
    public static String bRx = "extdata";
    public static String bRy = "kw";
    public static String bRz = "tid";
    public static String PARAM_URL = "url";
    public static String bRA = "schemefrom";
    public static String bRB = "maintablocate";
    public static String bRC = "maintab_subtab";
    public static String bRD = "from_h5";
    public static String bRE = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void o(HashMap<String, Object> hashMap);
    }

    public static final f aen() {
        return b.bRF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private static final f bRF = new f();
    }

    private f() {
    }

    public static boolean k(Uri uri) {
        return uri != null && bRq.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && k(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(bRx);
            String queryParameter2 = uri.getQueryParameter(bRA);
            bE(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            if (bRr.equals(uri.getPath())) {
                hashMap.put(bRB, 2);
            } else if (bRs.equals(uri.getPath())) {
                hashMap.put(bRB, 1);
            } else if (bRt.equals(uri.getPath())) {
                hashMap.put(bRB, 1);
                hashMap.put(bRC, "1_recommend");
            }
            aVar.o(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && k(uri) && bRu.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(bRy, uri.getQueryParameter(bRy));
            String queryParameter = uri.getQueryParameter(bRx);
            String queryParameter2 = uri.getQueryParameter(bRA);
            bE(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            aVar.o(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && k(uri) && bRv.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(bRz, uri.getQueryParameter(bRz));
            String queryParameter = uri.getQueryParameter(bRx);
            String queryParameter2 = uri.getQueryParameter(bRA);
            bE(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            aVar.o(hashMap);
        }
    }

    public void d(Uri uri, a aVar) {
        if (uri != null && k(uri) && bRw.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            String queryParameter = uri.getQueryParameter(bRx);
            String queryParameter2 = uri.getQueryParameter(bRA);
            bE(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            aVar.o(hashMap);
        }
    }

    private void bE(String str, String str2) {
        if (!aq.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            if (bVar.getActivityId() != 0 && bVar.adH() != 0) {
                TbSingleton.getInstance().setInvokeSource(bVar.adI());
                TiebaStatic.log(new an("c13321").bS("obj_source", bVar.adI()).O("obj_type", bVar.getActivityId()).O("obj_param1", bVar.adH()).O(TiebaInitialize.Params.OBJ_PARAM2, aq.equals(str2, bRE) ? 2 : 1).bS(TiebaInitialize.Params.OBJ_PARAM3, bVar.getSource()).bS("extra", bVar.adJ()));
                c.adX().l(bVar);
            }
        }
    }

    private void b(Uri uri, String str) {
        if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !aq.equals(str, bRE)) {
            TiebaStatic.log(new an("c13391").bS("obj_type", uri.getQueryParameter("obj_type")).bS("obj_source", uri.getQueryParameter("obj_source")));
        }
    }
}
