package com.baidu.tbadk.BdToken;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static String ewL = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String ewM = "/homepage";
    public static String ewN = "/enterforum";
    public static String ewO = "/recommendforum";
    public static String ewP = "/frs";
    public static String ewQ = "/pb";
    public static String ewR = "/tbwebview";
    public static String ewS = "/usercenter";
    public static String ewT = "/topicdetail";
    public static String ewU = "/tiebachushou";
    public static String ewV = "/activitypage";
    public static String ewW = "/minapp";
    public static String ewX = "/onekeysign";
    public static String ewY = "/hotuserrank";
    public static String ewZ = "/forumRuleDetail";
    public static String exa = "extdata";
    public static String exb = "kw";
    public static String exc = "tid";
    public static String exd = "ori_ugc_nid";
    public static String exe = "ori_ugc_tid";
    public static String exf = "ori_ugc_type";
    public static String exg = "ori_ugc_vid";
    public static String exh = "portrait";
    public static String exi = "topic_id";
    public static String PARAM_URL = "url";
    public static String exj = "schemefrom";
    public static String PARAM_FROM = "from";
    public static String exk = "token";
    public static String exl = "tab_name";
    public static String exm = "maintablocate";
    public static String exn = "maintab_subtab";
    public static String exo = "newgod_from";
    public static String exp = "field_id";
    public static String exq = "chushou_third_live_type";
    public static String exr = "chuchou_third_room_id";
    public static String exs = "hotTrend";
    public static String exu = "tab_id";
    public static String exv = "param_uri";
    public static String exw = TbTitleActivityConfig.FORUM_ID;
    public static String exx = "from_h5";
    public static String exy = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void onCallBack(HashMap<String, Object> hashMap);
    }

    public static final f biX() {
        return b.exz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private static final f exz = new f();
    }

    private f() {
    }

    public static boolean p(Uri uri) {
        return uri != null && ewL.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && p(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(exa);
            String queryParameter2 = uri.getQueryParameter(exj);
            String queryParameter3 = uri.getQueryParameter(exk);
            String queryParameter4 = uri.getQueryParameter(exl);
            a(queryParameter, queryParameter2, queryParameter3, uri);
            Ai(uri.getQueryParameter(PARAM_FROM));
            a("", uri, queryParameter2);
            if (ewM.equals(uri.getPath())) {
                hashMap.put(exm, 2);
                hashMap.put(exo, uri.getQueryParameter(exo));
                hashMap.put(exp, uri.getQueryParameter(exp));
                hashMap.put(exl, queryParameter4);
            } else if (ewN.equals(uri.getPath())) {
                hashMap.put(exm, 1);
                hashMap.put(exn, queryParameter4);
            } else if (ewO.equals(uri.getPath())) {
                hashMap.put(exm, 1);
                hashMap.put(exn, "1_recommend");
            } else if (ewV.equals(uri.getPath())) {
                hashMap.put(exm, 2);
                hashMap.put(exl, queryParameter4);
            }
            aVar.onCallBack(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && p(uri) && ewP.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(exb, uri.getQueryParameter(exb));
            hashMap.put(exu, uri.getQueryParameter(exu));
            hashMap.put(exc, uri.getQueryParameter(exc));
            Ai(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(exa);
            String queryParameter2 = uri.getQueryParameter(exj);
            a(queryParameter, queryParameter2, uri.getQueryParameter(exk), uri);
            a("", uri, queryParameter2);
            aVar.onCallBack(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && p(uri) && ewQ.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(exc, uri.getQueryParameter(exc));
            hashMap.put(exd, uri.getQueryParameter(exd));
            hashMap.put(exe, uri.getQueryParameter(exe));
            hashMap.put(exf, uri.getQueryParameter(exf));
            hashMap.put(exg, uri.getQueryParameter(exg));
            Ai(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(exa);
            String queryParameter2 = uri.getQueryParameter(exj);
            a(queryParameter, queryParameter2, uri.getQueryParameter(exk), uri);
            a("", uri, queryParameter2);
            aVar.onCallBack(hashMap);
        }
    }

    public void a(String str, Uri uri, a aVar) {
        if (uri != null && p(uri) && ewR.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            hashMap.put(exv, uri);
            Ai(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(exa);
            String queryParameter2 = uri.getQueryParameter(exj);
            a(queryParameter, queryParameter2, uri.getQueryParameter(exk), uri);
            a(str, uri, queryParameter2);
            aVar.onCallBack(hashMap);
        }
    }

    public void q(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("is_new_schema");
            if (!TextUtils.isEmpty(queryParameter) && queryParameter.equals("1")) {
                UtilHelper.clearClipBoard();
            }
        }
    }

    public void d(Uri uri, a aVar) {
        if (uri != null && p(uri) && ewS.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(exh, uri.getQueryParameter(exh));
            a(uri.getQueryParameter(exa), uri.getQueryParameter(exj), uri.getQueryParameter(exk), uri);
            aVar.onCallBack(hashMap);
        }
    }

    public void e(Uri uri, a aVar) {
        if (uri != null && p(uri) && ewT.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(exi, uri.getQueryParameter(exi));
            Ai(uri.getQueryParameter(PARAM_FROM));
            a(uri.getQueryParameter(exa), uri.getQueryParameter(exj), uri.getQueryParameter(exk), uri);
            aVar.onCallBack(hashMap);
        }
    }

    private void a(String str, String str2, String str3, Uri uri) {
        if (!au.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            bVar.setToken(str3);
            if (bVar.getActivityId() != 0 && bVar.bin() != 0) {
                TbSingleton.getInstance().setInvokeSource(bVar.bio());
                com.baidu.adp.lib.stats.f.cb(String.valueOf(bVar.getActivityId()));
                com.baidu.adp.lib.stats.f.cc(String.valueOf(bVar.bin()));
                int i = au.equals(str2, exy) ? 2 : 1;
                String str4 = "";
                String str5 = "";
                if (uri != null) {
                    str4 = uri.getQueryParameter(exb);
                    str5 = uri.getQueryParameter(exc);
                }
                TiebaStatic.log(new ar("c13321").dY("obj_source", bVar.bio()).al("obj_type", bVar.getActivityId()).al("obj_param1", bVar.bin()).al(TiebaInitialize.Params.OBJ_PARAM2, i).dY(TiebaInitialize.Params.OBJ_PARAM3, bVar.getSource()).dY("extra", bVar.bip()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dY("fname", str4).dY("tid", str5));
                c.biD().l(bVar);
            }
        }
    }

    private void a(String str, Uri uri, String str2) {
        if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !au.equals(str2, exy)) {
            TiebaStatic.log(new ar("c13391").dY("obj_type", uri.getQueryParameter("obj_type")).dY("obj_source", uri.getQueryParameter("obj_source")));
        }
        if (str != null && !str.contains("tbwebview") && uri != null) {
            String queryParameter = uri.getQueryParameter("is_new_schema");
            if (!TextUtils.isEmpty(queryParameter) && queryParameter.equals("1")) {
                UtilHelper.clearClipBoard();
            }
        }
    }

    private void Ai(String str) {
        if (!TextUtils.isEmpty(str) && UbcStatConstant.ContentSource.SHOUBAI.equals(str)) {
            com.baidu.tbadk.util.e.bGk().la(true);
            com.baidu.tbadk.util.e.bGk().bGl();
        }
    }
}
