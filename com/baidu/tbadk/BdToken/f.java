package com.baidu.tbadk.BdToken;

import android.net.Uri;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static String SCHEME = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String akM = "/homepage";
    public static String akN = "/enterforum";
    public static String akO = "/frs";
    public static String akP = "/pb";
    public static String akQ = "/tbwebview";
    public static String akR = "extdata";
    public static String akS = "kw";
    public static String akT = "tid";
    public static String PARAM_URL = "url";
    public static String akU = "schemefrom";
    public static String akV = "maintablocate";
    public static String akW = "from_h5";
    public static String akX = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void n(HashMap<String, Object> hashMap);
    }

    public static final f vF() {
        return b.akY;
    }

    /* loaded from: classes.dex */
    private static class b {
        private static final f akY = new f();
    }

    private f() {
    }

    public static boolean e(Uri uri) {
        return uri != null && SCHEME.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && e(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            ai(uri.getQueryParameter(akR), uri.getQueryParameter(akU));
            if (akM.equals(uri.getPath())) {
                hashMap.put(akV, 2);
            } else if (akN.equals(uri.getPath())) {
                hashMap.put(akV, 1);
            }
            aVar.n(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && e(uri) && akO.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(akS, uri.getQueryParameter(akS));
            ai(uri.getQueryParameter(akR), uri.getQueryParameter(akU));
            aVar.n(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && e(uri) && akP.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(akT, uri.getQueryParameter(akT));
            ai(uri.getQueryParameter(akR), uri.getQueryParameter(akU));
            aVar.n(hashMap);
        }
    }

    public void d(Uri uri, a aVar) {
        if (uri != null && e(uri) && akQ.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            ai(uri.getQueryParameter(akR), uri.getQueryParameter(akU));
            aVar.n(hashMap);
        }
    }

    private void ai(String str, String str2) {
        if (!ao.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            if (bVar.getActivityId() != 0 && bVar.vh() != 0) {
                am amVar = new am("c13321");
                amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.vi()).x("obj_type", bVar.getActivityId()).x("obj_param1", bVar.vh());
                if (ao.equals(str2, akX)) {
                    amVar.x("obj_param2", 2);
                } else {
                    amVar.x("obj_param2", 1);
                }
                TiebaStatic.log(amVar);
                c.vu().b(bVar);
            }
        }
    }
}
