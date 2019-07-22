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
    public static String bzd = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String bze = "/homepage";
    public static String bzf = "/enterforum";
    public static String bzg = "/recommendforum";
    public static String bzh = "/frs";
    public static String bzi = "/pb";
    public static String bzj = "/tbwebview";
    public static String bzk = "extdata";
    public static String bzl = "kw";
    public static String bzm = "tid";
    public static String PARAM_URL = "url";
    public static String bzn = "schemefrom";
    public static String bzo = "maintablocate";
    public static String bzp = "maintab_subtab";
    public static String bzq = "from_h5";
    public static String bzr = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void o(HashMap<String, Object> hashMap);
    }

    public static final f Zw() {
        return b.bzs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private static final f bzs = new f();
    }

    private f() {
    }

    public static boolean m(Uri uri) {
        return uri != null && bzd.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && m(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(bzk);
            String queryParameter2 = uri.getQueryParameter(bzn);
            bx(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            if (bze.equals(uri.getPath())) {
                hashMap.put(bzo, 2);
            } else if (bzf.equals(uri.getPath())) {
                hashMap.put(bzo, 1);
            } else if (bzg.equals(uri.getPath())) {
                hashMap.put(bzo, 1);
                hashMap.put(bzp, "1_recommend");
            }
            aVar.o(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && m(uri) && bzh.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(bzl, uri.getQueryParameter(bzl));
            String queryParameter = uri.getQueryParameter(bzk);
            String queryParameter2 = uri.getQueryParameter(bzn);
            bx(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            aVar.o(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && m(uri) && bzi.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(bzm, uri.getQueryParameter(bzm));
            String queryParameter = uri.getQueryParameter(bzk);
            String queryParameter2 = uri.getQueryParameter(bzn);
            bx(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            aVar.o(hashMap);
        }
    }

    public void d(Uri uri, a aVar) {
        if (uri != null && m(uri) && bzj.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            String queryParameter = uri.getQueryParameter(bzk);
            String queryParameter2 = uri.getQueryParameter(bzn);
            bx(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            aVar.o(hashMap);
        }
    }

    private void bx(String str, String str2) {
        if (!aq.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            if (bVar.getActivityId() != 0 && bVar.YQ() != 0) {
                TbSingleton.getInstance().setInvokeSource(bVar.YR());
                TiebaStatic.log(new an("c13321").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.YR()).P("obj_type", bVar.getActivityId()).P("obj_param1", bVar.YQ()).P("obj_param2", aq.bV(str2, bzr) ? 2 : 1).bT("obj_param3", bVar.getSource()).bT("extra", bVar.YS()));
                c.Zg().l(bVar);
            }
        }
    }

    private void b(Uri uri, String str) {
        if (uri != null && uri.getQueryParameter(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE) != null && uri.getQueryParameter("obj_type") != null && !aq.bV(str, bzr)) {
            TiebaStatic.log(new an("c13391").bT("obj_type", uri.getQueryParameter("obj_type")).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, uri.getQueryParameter(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE)));
        }
    }
}
