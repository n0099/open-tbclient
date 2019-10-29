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
    public static String bSh = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String bSi = "/homepage";
    public static String bSj = "/enterforum";
    public static String bSk = "/recommendforum";
    public static String bSl = "/frs";
    public static String bSm = "/pb";
    public static String bSn = "/tbwebview";
    public static String bSo = "extdata";
    public static String bSp = "kw";
    public static String bSq = "tid";
    public static String PARAM_URL = "url";
    public static String bSr = "schemefrom";
    public static String bSs = "maintablocate";
    public static String bSt = "maintab_subtab";
    public static String bSu = "from_h5";
    public static String bSv = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void o(HashMap<String, Object> hashMap);
    }

    public static final f aep() {
        return b.bSw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private static final f bSw = new f();
    }

    private f() {
    }

    public static boolean k(Uri uri) {
        return uri != null && bSh.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && k(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(bSo);
            String queryParameter2 = uri.getQueryParameter(bSr);
            bE(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            if (bSi.equals(uri.getPath())) {
                hashMap.put(bSs, 2);
            } else if (bSj.equals(uri.getPath())) {
                hashMap.put(bSs, 1);
            } else if (bSk.equals(uri.getPath())) {
                hashMap.put(bSs, 1);
                hashMap.put(bSt, "1_recommend");
            }
            aVar.o(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && k(uri) && bSl.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(bSp, uri.getQueryParameter(bSp));
            String queryParameter = uri.getQueryParameter(bSo);
            String queryParameter2 = uri.getQueryParameter(bSr);
            bE(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            aVar.o(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && k(uri) && bSm.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(bSq, uri.getQueryParameter(bSq));
            String queryParameter = uri.getQueryParameter(bSo);
            String queryParameter2 = uri.getQueryParameter(bSr);
            bE(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            aVar.o(hashMap);
        }
    }

    public void d(Uri uri, a aVar) {
        if (uri != null && k(uri) && bSn.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            String queryParameter = uri.getQueryParameter(bSo);
            String queryParameter2 = uri.getQueryParameter(bSr);
            bE(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            aVar.o(hashMap);
        }
    }

    private void bE(String str, String str2) {
        if (!aq.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            if (bVar.getActivityId() != 0 && bVar.adJ() != 0) {
                TbSingleton.getInstance().setInvokeSource(bVar.adK());
                TiebaStatic.log(new an("c13321").bS("obj_source", bVar.adK()).O("obj_type", bVar.getActivityId()).O("obj_param1", bVar.adJ()).O(TiebaInitialize.Params.OBJ_PARAM2, aq.equals(str2, bSv) ? 2 : 1).bS(TiebaInitialize.Params.OBJ_PARAM3, bVar.getSource()).bS("extra", bVar.adL()));
                c.adZ().l(bVar);
            }
        }
    }

    private void b(Uri uri, String str) {
        if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !aq.equals(str, bSv)) {
            TiebaStatic.log(new an("c13391").bS("obj_type", uri.getQueryParameter("obj_type")).bS("obj_source", uri.getQueryParameter("obj_source")));
        }
    }
}
