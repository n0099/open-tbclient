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
    public static String brG = "/homepage";
    public static String brH = "/enterforum";
    public static String brI = "/frs";
    public static String brJ = "/pb";
    public static String brK = "/tbwebview";
    public static String brL = "extdata";
    public static String brM = "kw";
    public static String brN = "tid";
    public static String PARAM_URL = "url";
    public static String brO = "schemefrom";
    public static String brP = "maintablocate";
    public static String brQ = "from_h5";
    public static String brR = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void o(HashMap<String, Object> hashMap);
    }

    public static final f Ui() {
        return b.brS;
    }

    /* loaded from: classes.dex */
    private static class b {
        private static final f brS = new f();
    }

    private f() {
    }

    public static boolean m(Uri uri) {
        return uri != null && SCHEME.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && m(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(brL);
            String queryParameter2 = uri.getQueryParameter(brO);
            bp(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            if (brG.equals(uri.getPath())) {
                hashMap.put(brP, 2);
            } else if (brH.equals(uri.getPath())) {
                hashMap.put(brP, 1);
            }
            aVar.o(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && m(uri) && brI.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(brM, uri.getQueryParameter(brM));
            String queryParameter = uri.getQueryParameter(brL);
            String queryParameter2 = uri.getQueryParameter(brO);
            bp(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            aVar.o(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && m(uri) && brJ.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(brN, uri.getQueryParameter(brN));
            String queryParameter = uri.getQueryParameter(brL);
            String queryParameter2 = uri.getQueryParameter(brO);
            bp(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            aVar.o(hashMap);
        }
    }

    public void d(Uri uri, a aVar) {
        if (uri != null && m(uri) && brK.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            String queryParameter = uri.getQueryParameter(brL);
            String queryParameter2 = uri.getQueryParameter(brO);
            bp(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            aVar.o(hashMap);
        }
    }

    private void bp(String str, String str2) {
        if (!ap.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            if (bVar.getActivityId() != 0 && bVar.TK() != 0) {
                TbSingleton.getInstance().setInvokeSource(bVar.TL());
                am amVar = new am("c13321");
                amVar.bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bVar.TL()).T("obj_type", bVar.getActivityId()).T("obj_param1", bVar.TK());
                if (ap.equals(str2, brR)) {
                    amVar.T("obj_param2", 2);
                } else {
                    amVar.T("obj_param2", 1);
                }
                TiebaStatic.log(amVar);
                c.TX().b(bVar);
            }
        }
    }

    private void b(Uri uri, String str) {
        if (uri != null && uri.getQueryParameter(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE) != null && uri.getQueryParameter("obj_type") != null && !ap.equals(str, brR)) {
            TiebaStatic.log(new am("c13391").bJ("obj_type", uri.getQueryParameter("obj_type")).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, uri.getQueryParameter(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE)));
        }
    }
}
