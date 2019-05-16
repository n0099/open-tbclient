package com.baidu.tbadk.BdToken;

import android.net.Uri;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static String SCHEME = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String bym = "/homepage";
    public static String byn = "/enterforum";
    public static String byo = "/frs";
    public static String byp = "/pb";
    public static String byq = "/tbwebview";
    public static String byr = "extdata";
    public static String bys = "kw";
    public static String byt = "tid";
    public static String PARAM_URL = "url";
    public static String byu = "schemefrom";
    public static String byv = "maintablocate";
    public static String byw = "from_h5";
    public static String byx = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void o(HashMap<String, Object> hashMap);
    }

    public static final f YA() {
        return b.byy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private static final f byy = new f();
    }

    private f() {
    }

    public static boolean m(Uri uri) {
        return uri != null && SCHEME.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && m(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(byr);
            String queryParameter2 = uri.getQueryParameter(byu);
            bx(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            if (bym.equals(uri.getPath())) {
                hashMap.put(byv, 2);
            } else if (byn.equals(uri.getPath())) {
                hashMap.put(byv, 1);
            }
            aVar.o(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && m(uri) && byo.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(bys, uri.getQueryParameter(bys));
            String queryParameter = uri.getQueryParameter(byr);
            String queryParameter2 = uri.getQueryParameter(byu);
            bx(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            aVar.o(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && m(uri) && byp.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(byt, uri.getQueryParameter(byt));
            String queryParameter = uri.getQueryParameter(byr);
            String queryParameter2 = uri.getQueryParameter(byu);
            bx(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            aVar.o(hashMap);
        }
    }

    public void d(Uri uri, a aVar) {
        if (uri != null && m(uri) && byq.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            String queryParameter = uri.getQueryParameter(byr);
            String queryParameter2 = uri.getQueryParameter(byu);
            bx(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            aVar.o(hashMap);
        }
    }

    private void bx(String str, String str2) {
        if (!ap.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            if (bVar.getActivityId() != 0 && bVar.XU() != 0) {
                TbSingleton.getInstance().setInvokeSource(bVar.XV());
                TiebaStatic.log(new am("c13321").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.XV()).P("obj_type", bVar.getActivityId()).P("obj_param1", bVar.XU()).P("obj_param2", ap.equals(str2, byx) ? 2 : 1).bT("obj_param3", bVar.getSource()).bT("extra", bVar.XW()));
                c.Yk().l(bVar);
            }
        }
    }

    private void b(Uri uri, String str) {
        if (uri != null && uri.getQueryParameter(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE) != null && uri.getQueryParameter("obj_type") != null && !ap.equals(str, byx)) {
            TiebaStatic.log(new am("c13391").bT("obj_type", uri.getQueryParameter("obj_type")).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, uri.getQueryParameter(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE)));
        }
    }
}
