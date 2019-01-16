package com.baidu.tbadk.BdToken;

import android.net.Uri;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static String SCHEME = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String akW = "/homepage";
    public static String akX = "/enterforum";
    public static String akY = "/frs";
    public static String akZ = "/pb";
    public static String ala = "/tbwebview";
    public static String alb = "extdata";
    public static String alc = "kw";
    public static String ald = "tid";
    public static String PARAM_URL = "url";
    public static String ale = "schemefrom";
    public static String alf = "maintablocate";
    public static String alg = "from_h5";
    public static String alh = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void n(HashMap<String, Object> hashMap);
    }

    public static final f vJ() {
        return b.ali;
    }

    /* loaded from: classes.dex */
    private static class b {
        private static final f ali = new f();
    }

    private f() {
    }

    public static boolean e(Uri uri) {
        return uri != null && SCHEME.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && e(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(alb);
            String queryParameter2 = uri.getQueryParameter(ale);
            aj(queryParameter, queryParameter2);
            a(uri, queryParameter2);
            if (akW.equals(uri.getPath())) {
                hashMap.put(alf, 2);
            } else if (akX.equals(uri.getPath())) {
                hashMap.put(alf, 1);
            }
            aVar.n(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && e(uri) && akY.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(alc, uri.getQueryParameter(alc));
            String queryParameter = uri.getQueryParameter(alb);
            String queryParameter2 = uri.getQueryParameter(ale);
            aj(queryParameter, queryParameter2);
            a(uri, queryParameter2);
            aVar.n(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && e(uri) && akZ.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(ald, uri.getQueryParameter(ald));
            String queryParameter = uri.getQueryParameter(alb);
            String queryParameter2 = uri.getQueryParameter(ale);
            aj(queryParameter, queryParameter2);
            a(uri, queryParameter2);
            aVar.n(hashMap);
        }
    }

    public void d(Uri uri, a aVar) {
        if (uri != null && e(uri) && ala.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            String queryParameter = uri.getQueryParameter(alb);
            String queryParameter2 = uri.getQueryParameter(ale);
            aj(queryParameter, queryParameter2);
            a(uri, queryParameter2);
            aVar.n(hashMap);
        }
    }

    private void aj(String str, String str2) {
        if (!ao.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            if (bVar.getActivityId() != 0 && bVar.vl() != 0) {
                TbSingleton.getInstance().setInvokeSource(bVar.vm());
                am amVar = new am("c13321");
                amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.vm()).y("obj_type", bVar.getActivityId()).y("obj_param1", bVar.vl());
                if (ao.equals(str2, alh)) {
                    amVar.y("obj_param2", 2);
                } else {
                    amVar.y("obj_param2", 1);
                }
                TiebaStatic.log(amVar);
                c.vy().b(bVar);
            }
        }
    }

    private void a(Uri uri, String str) {
        if (uri != null && uri.getQueryParameter(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE) != null && uri.getQueryParameter("obj_type") != null && !ao.equals(str, alh)) {
            TiebaStatic.log(new am("c13391").aB("obj_type", uri.getQueryParameter("obj_type")).aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, uri.getQueryParameter(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE)));
        }
    }
}
