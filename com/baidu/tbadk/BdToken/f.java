package com.baidu.tbadk.BdToken;

import android.net.Uri;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static String bzB = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String bzC = "/homepage";
    public static String bzD = "/enterforum";
    public static String bzE = "/recommendforum";
    public static String bzF = "/frs";
    public static String bzG = "/pb";
    public static String bzH = "/tbwebview";
    public static String bzI = "extdata";
    public static String bzJ = "kw";
    public static String bzK = "tid";
    public static String PARAM_URL = "url";
    public static String bzL = "schemefrom";
    public static String bzM = "maintablocate";
    public static String bzN = "maintab_subtab";
    public static String bzO = "from_h5";
    public static String bzP = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void o(HashMap<String, Object> hashMap);
    }

    public static final f ZA() {
        return b.bzQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private static final f bzQ = new f();
    }

    private f() {
    }

    public static boolean m(Uri uri) {
        return uri != null && bzB.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && m(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(bzI);
            String queryParameter2 = uri.getQueryParameter(bzL);
            bx(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            if (bzC.equals(uri.getPath())) {
                hashMap.put(bzM, 2);
            } else if (bzD.equals(uri.getPath())) {
                hashMap.put(bzM, 1);
            } else if (bzE.equals(uri.getPath())) {
                hashMap.put(bzM, 1);
                hashMap.put(bzN, "1_recommend");
            }
            aVar.o(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && m(uri) && bzF.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(bzJ, uri.getQueryParameter(bzJ));
            String queryParameter = uri.getQueryParameter(bzI);
            String queryParameter2 = uri.getQueryParameter(bzL);
            bx(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            aVar.o(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && m(uri) && bzG.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(bzK, uri.getQueryParameter(bzK));
            String queryParameter = uri.getQueryParameter(bzI);
            String queryParameter2 = uri.getQueryParameter(bzL);
            bx(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            aVar.o(hashMap);
        }
    }

    public void d(Uri uri, a aVar) {
        if (uri != null && m(uri) && bzH.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            String queryParameter = uri.getQueryParameter(bzI);
            String queryParameter2 = uri.getQueryParameter(bzL);
            bx(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            aVar.o(hashMap);
        }
    }

    private void bx(String str, String str2) {
        if (!aq.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            if (bVar.getActivityId() != 0 && bVar.YU() != 0) {
                TbSingleton.getInstance().setInvokeSource(bVar.YV());
                TiebaStatic.log(new an("c13321").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.YV()).P("obj_type", bVar.getActivityId()).P("obj_param1", bVar.YU()).P("obj_param2", aq.bV(str2, bzP) ? 2 : 1).bT("obj_param3", bVar.getSource()).bT("extra", bVar.YW()));
                c.Zk().l(bVar);
            }
        }
    }

    private void b(Uri uri, String str) {
        if (uri != null && uri.getQueryParameter(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE) != null && uri.getQueryParameter("obj_type") != null && !aq.bV(str, bzP)) {
            TiebaStatic.log(new an("c13391").bT("obj_type", uri.getQueryParameter("obj_type")).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, uri.getQueryParameter(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE)));
        }
    }
}
