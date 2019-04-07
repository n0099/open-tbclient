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
    public static String brF = "/homepage";
    public static String brG = "/enterforum";
    public static String brH = "/frs";
    public static String brI = "/pb";
    public static String brJ = "/tbwebview";
    public static String brK = "extdata";
    public static String brL = "kw";
    public static String brM = "tid";
    public static String PARAM_URL = "url";
    public static String brN = "schemefrom";
    public static String brO = "maintablocate";
    public static String brP = "from_h5";
    public static String brQ = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void o(HashMap<String, Object> hashMap);
    }

    public static final f Ui() {
        return b.brR;
    }

    /* loaded from: classes.dex */
    private static class b {
        private static final f brR = new f();
    }

    private f() {
    }

    public static boolean m(Uri uri) {
        return uri != null && SCHEME.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && m(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(brK);
            String queryParameter2 = uri.getQueryParameter(brN);
            bp(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            if (brF.equals(uri.getPath())) {
                hashMap.put(brO, 2);
            } else if (brG.equals(uri.getPath())) {
                hashMap.put(brO, 1);
            }
            aVar.o(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && m(uri) && brH.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(brL, uri.getQueryParameter(brL));
            String queryParameter = uri.getQueryParameter(brK);
            String queryParameter2 = uri.getQueryParameter(brN);
            bp(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            aVar.o(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && m(uri) && brI.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(brM, uri.getQueryParameter(brM));
            String queryParameter = uri.getQueryParameter(brK);
            String queryParameter2 = uri.getQueryParameter(brN);
            bp(queryParameter, queryParameter2);
            b(uri, queryParameter2);
            aVar.o(hashMap);
        }
    }

    public void d(Uri uri, a aVar) {
        if (uri != null && m(uri) && brJ.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            String queryParameter = uri.getQueryParameter(brK);
            String queryParameter2 = uri.getQueryParameter(brN);
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
                if (ap.equals(str2, brQ)) {
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
        if (uri != null && uri.getQueryParameter(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE) != null && uri.getQueryParameter("obj_type") != null && !ap.equals(str, brQ)) {
            TiebaStatic.log(new am("c13391").bJ("obj_type", uri.getQueryParameter("obj_type")).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, uri.getQueryParameter(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE)));
        }
    }
}
