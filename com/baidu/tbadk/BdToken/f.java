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
    public static String brC = "/homepage";
    public static String brD = "/enterforum";
    public static String brE = "/frs";
    public static String brF = "/pb";
    public static String brG = "/tbwebview";
    public static String brH = "extdata";
    public static String brI = "kw";
    public static String brJ = "tid";
    public static String PARAM_URL = "url";
    public static String brK = "schemefrom";
    public static String brL = "maintablocate";
    public static String brM = "from_h5";
    public static String brN = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void o(HashMap<String, Object> hashMap);
    }

    public static final f Uk() {
        return b.brO;
    }

    /* loaded from: classes.dex */
    private static class b {
        private static final f brO = new f();
    }

    private f() {
    }

    public static boolean m(Uri uri) {
        return uri != null && SCHEME.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && m(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(brH);
            String queryParameter2 = uri.getQueryParameter(brK);
            bp(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            if (brC.equals(uri.getPath())) {
                hashMap.put(brL, 2);
            } else if (brD.equals(uri.getPath())) {
                hashMap.put(brL, 1);
            }
            aVar.o(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && m(uri) && brE.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(brI, uri.getQueryParameter(brI));
            String queryParameter = uri.getQueryParameter(brH);
            String queryParameter2 = uri.getQueryParameter(brK);
            bp(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            aVar.o(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && m(uri) && brF.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(brJ, uri.getQueryParameter(brJ));
            String queryParameter = uri.getQueryParameter(brH);
            String queryParameter2 = uri.getQueryParameter(brK);
            bp(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            aVar.o(hashMap);
        }
    }

    public void d(Uri uri, a aVar) {
        if (uri != null && m(uri) && brG.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            String queryParameter = uri.getQueryParameter(brH);
            String queryParameter2 = uri.getQueryParameter(brK);
            bp(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            aVar.o(hashMap);
        }
    }

    private void bp(String str, String str2) {
        if (!ap.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            if (bVar.getActivityId() != 0 && bVar.TM() != 0) {
                TbSingleton.getInstance().setInvokeSource(bVar.TN());
                am amVar = new am("c13321");
                amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.TN()).T("obj_type", bVar.getActivityId()).T("obj_param1", bVar.TM());
                if (ap.equals(str2, brN)) {
                    amVar.T("obj_param2", 2);
                } else {
                    amVar.T("obj_param2", 1);
                }
                TiebaStatic.log(amVar);
                c.TZ().b(bVar);
            }
        }
    }

    private void b(Uri uri, String str) {
        if (uri != null && uri.getQueryParameter(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE) != null && uri.getQueryParameter("obj_type") != null && !ap.equals(str, brN)) {
            TiebaStatic.log(new am("c13391").bJ("obj_type", uri.getQueryParameter("obj_type")).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, uri.getQueryParameter(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE)));
        }
    }
}
