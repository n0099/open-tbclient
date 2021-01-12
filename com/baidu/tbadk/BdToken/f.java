package com.baidu.tbadk.BdToken;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import java.util.HashMap;
/* loaded from: classes.dex */
public class f {
    public static String eBp = "com.baidu.tieba";
    public static String HOST = "unidispatch";
    public static String eBq = "/homepage";
    public static String eBr = "/enterforum";
    public static String eBs = "/recommendforum";
    public static String eBt = "/frs";
    public static String eBu = "/pb";
    public static String eBv = "/tbwebview";
    public static String eBw = "/usercenter";
    public static String eBx = "/topicdetail";
    public static String eBy = "/tiebachushou";
    public static String eBz = "/activitypage";
    public static String eBA = "/minapp";
    public static String eBB = "/onekeysign";
    public static String eBC = "/hotuserrank";
    public static String eBD = "/forumRuleDetail";
    public static String eBE = "extdata";
    public static String eBF = "kw";
    public static String eBG = "tid";
    public static String eBH = "ori_ugc_nid";
    public static String eBI = "ori_ugc_tid";
    public static String eBJ = "ori_ugc_type";
    public static String eBK = "ori_ugc_vid";
    public static String eBL = "portrait";
    public static String eBM = "topic_id";
    public static String PARAM_URL = "url";
    public static String eBN = "schemefrom";
    public static String PARAM_FROM = "from";
    public static String eBO = "token";
    public static String eBP = "tab_name";
    public static String eBQ = "maintablocate";
    public static String eBR = "maintab_subtab";
    public static String eBS = "newgod_from";
    public static String eBT = "field_id";
    public static String eBU = "chushou_third_live_type";
    public static String eBV = "chuchou_third_room_id";
    public static String eBW = "hotTrend";
    public static String eBX = "tab_id";
    public static String eBY = "param_uri";
    public static String eBZ = TbTitleActivityConfig.FORUM_ID;
    public static String eCa = "from_h5";
    public static String eCb = "from_tb_token";

    /* loaded from: classes.dex */
    public interface a {
        void onCallBack(HashMap<String, Object> hashMap);
    }

    public static final f bhu() {
        return b.eCc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        private static final f eCc = new f();
    }

    private f() {
    }

    public static boolean r(Uri uri) {
        return uri != null && eBp.equals(uri.getScheme()) && HOST.equals(uri.getHost());
    }

    public void a(Uri uri, a aVar) {
        if (uri != null && r(uri)) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String queryParameter = uri.getQueryParameter(eBE);
            String queryParameter2 = uri.getQueryParameter(eBN);
            String queryParameter3 = uri.getQueryParameter(eBO);
            String queryParameter4 = uri.getQueryParameter(eBP);
            a(queryParameter, queryParameter2, queryParameter3, uri);
            yS(uri.getQueryParameter(PARAM_FROM));
            a("", uri, queryParameter2);
            v.u(uri);
            if (eBq.equals(uri.getPath())) {
                hashMap.put(eBQ, 2);
                hashMap.put(eBS, uri.getQueryParameter(eBS));
                hashMap.put(eBT, uri.getQueryParameter(eBT));
                hashMap.put(eBP, queryParameter4);
            } else if (eBr.equals(uri.getPath())) {
                hashMap.put(eBQ, 1);
                hashMap.put(eBR, queryParameter4);
            } else if (eBs.equals(uri.getPath())) {
                hashMap.put(eBQ, 1);
                hashMap.put(eBR, "1_recommend");
            } else if (eBz.equals(uri.getPath())) {
                hashMap.put(eBQ, 2);
                hashMap.put(eBP, queryParameter4);
            }
            aVar.onCallBack(hashMap);
        }
    }

    public void b(Uri uri, a aVar) {
        if (uri != null && r(uri) && eBt.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(eBF, uri.getQueryParameter(eBF));
            hashMap.put(eBX, uri.getQueryParameter(eBX));
            hashMap.put(eBG, uri.getQueryParameter(eBG));
            yS(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(eBE);
            String queryParameter2 = uri.getQueryParameter(eBN);
            a(queryParameter, queryParameter2, uri.getQueryParameter(eBO), uri);
            a("", uri, queryParameter2);
            aVar.onCallBack(hashMap);
        }
    }

    public void c(Uri uri, a aVar) {
        if (uri != null && r(uri) && eBu.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(eBG, uri.getQueryParameter(eBG));
            hashMap.put(eBH, uri.getQueryParameter(eBH));
            hashMap.put(eBI, uri.getQueryParameter(eBI));
            hashMap.put(eBJ, uri.getQueryParameter(eBJ));
            hashMap.put(eBK, uri.getQueryParameter(eBK));
            yS(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(eBE);
            String queryParameter2 = uri.getQueryParameter(eBN);
            a(queryParameter, queryParameter2, uri.getQueryParameter(eBO), uri);
            a("", uri, queryParameter2);
            aVar.onCallBack(hashMap);
        }
    }

    public void a(String str, Uri uri, a aVar) {
        if (uri != null && r(uri) && eBv.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PARAM_URL, uri.getQueryParameter(PARAM_URL));
            hashMap.put(eBY, uri);
            yS(uri.getQueryParameter(PARAM_FROM));
            String queryParameter = uri.getQueryParameter(eBE);
            String queryParameter2 = uri.getQueryParameter(eBN);
            a(queryParameter, queryParameter2, uri.getQueryParameter(eBO), uri);
            a(str, uri, queryParameter2);
            aVar.onCallBack(hashMap);
        }
    }

    public void s(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("is_new_schema");
            if (!TextUtils.isEmpty(queryParameter) && queryParameter.equals("1")) {
                UtilHelper.clearClipBoard();
            }
        }
    }

    public void d(Uri uri, a aVar) {
        if (uri != null && r(uri) && eBw.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(eBL, uri.getQueryParameter(eBL));
            a(uri.getQueryParameter(eBE), uri.getQueryParameter(eBN), uri.getQueryParameter(eBO), uri);
            aVar.onCallBack(hashMap);
        }
    }

    public void e(Uri uri, a aVar) {
        if (uri != null && r(uri) && eBx.equals(uri.getPath())) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(eBM, uri.getQueryParameter(eBM));
            yS(uri.getQueryParameter(PARAM_FROM));
            a(uri.getQueryParameter(eBE), uri.getQueryParameter(eBN), uri.getQueryParameter(eBO), uri);
            aVar.onCallBack(hashMap);
        }
    }

    private void a(String str, String str2, String str3, Uri uri) {
        String str4;
        Activity currentActivity;
        if (!at.isEmpty(str)) {
            com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(str);
            bVar.setToken(str3);
            if (bVar.getActivityId() != 0 && bVar.bgK() != 0) {
                TbSingleton.getInstance().setInvokeSource(bVar.bgL());
                com.baidu.adp.lib.stats.f.setActivityId(String.valueOf(bVar.getActivityId()));
                com.baidu.adp.lib.stats.f.bV(String.valueOf(bVar.bgK()));
                int i = at.equals(str2, eCb) ? 2 : 1;
                String str5 = "";
                if (uri == null) {
                    str4 = "";
                } else {
                    str5 = uri.getQueryParameter(eBF);
                    str4 = uri.getQueryParameter(eBG);
                }
                if (bVar.getActivityId() == 1111 && (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) != null) {
                    if (currentActivity instanceof BaseFragmentActivity) {
                        ((BaseFragmentActivity) currentActivity).showFloatingWindow();
                    } else if (currentActivity instanceof BaseActivity) {
                        ((BaseActivity) currentActivity).showFloatingWindow();
                    }
                }
                TiebaStatic.log(new aq("c13321").dW("obj_source", bVar.bgL()).an("obj_type", bVar.getActivityId()).an("obj_param1", bVar.bgK()).an(TiebaInitialize.Params.OBJ_PARAM2, i).dW(TiebaInitialize.Params.OBJ_PARAM3, bVar.getSource()).dW("extra", bVar.bgM()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dW("fname", str5).dW("tid", str4).an("obj_locate", TbadkCoreApplication.getInst().getStartType()).an("obj_name", 1));
                c.bha().l(bVar);
            }
        }
    }

    private void a(String str, Uri uri, String str2) {
        if (uri != null && uri.getQueryParameter("obj_source") != null && uri.getQueryParameter("obj_type") != null && !at.equals(str2, eCb)) {
            TiebaStatic.log(new aq("c13391").dW("obj_type", uri.getQueryParameter("obj_type")).dW("obj_source", uri.getQueryParameter("obj_source")));
        }
        if (str != null && !str.contains("tbwebview") && uri != null) {
            String queryParameter = uri.getQueryParameter("is_new_schema");
            if (!TextUtils.isEmpty(queryParameter) && queryParameter.equals("1")) {
                UtilHelper.clearClipBoard();
            }
        }
    }

    private void yS(String str) {
        if (!TextUtils.isEmpty(str) && UbcStatConstant.ContentSource.SHOUBAI.equals(str)) {
            com.baidu.tbadk.util.d.bEN().ls(true);
            com.baidu.tbadk.util.d.bEN().bEO();
        }
    }
}
