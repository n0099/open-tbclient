package com.baidu.tbadk.BdToken;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.tencent.connect.common.Constants;
/* loaded from: classes.dex */
public class v {
    public static String t(Uri uri) {
        if (uri == null) {
            return "";
        }
        String uri2 = uri.toString();
        if (TextUtils.isEmpty(uri2)) {
            return "";
        }
        if (uri2.contains("unidispatch/openapp") || uri2.contains("donothing")) {
            return "5";
        }
        if (uri2.contains("tbpb") || uri2.contains("unidispatch/pb")) {
            if ("tbpb://tieba.baidu.com".equals(uri2)) {
                return "5";
            }
            if (!TextUtils.isEmpty(uri.getQueryParameter(f.eBH))) {
                return "6";
            }
            return "1";
        } else if (uri2.contains("invoke_frs") || uri2.contains("tbfrs") || uri2.contains("unidispatch/frs")) {
            return "2";
        } else {
            if (uri2.contains("tbwebview")) {
                return "9";
            }
            if (uri2.contains("tbusercenter") || uri2.contains("unidispatch/usercenter") || uri2.contains("usercenter")) {
                return "4";
            }
            if (uri2.contains("tbtopicdetail") || uri2.contains("unidispatch/topicdetail")) {
                return "3";
            }
            if (uri2.contains("unidispatch/hotuserrank")) {
                return "7";
            }
            if (f.eBq.equals(uri.getPath())) {
                return "5";
            }
            return Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        }
    }

    public static void u(Uri uri) {
        if (uri != null) {
            String t = t(uri);
            String queryParameter = uri.getQueryParameter("obj_source");
            if (UbcStatConstant.ContentSource.SHOUBAI.equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter) || "zhongjianye".equals(queryParameter) || "PC".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                uri.getQueryParameter("obj_type");
                String queryParameter3 = uri.getQueryParameter("obj_param1");
                String queryParameter4 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM3);
                String queryParameter6 = uri.getQueryParameter("tid");
                String queryParameter7 = uri.getQueryParameter("kw");
                String queryParameter8 = uri.getQueryParameter(f.eBH);
                String queryParameter9 = uri.getQueryParameter(f.eBI);
                String queryParameter10 = uri.getQueryParameter(f.eBJ);
                String queryParameter11 = uri.getQueryParameter(f.eBK);
                String queryParameter12 = uri.getQueryParameter("obj_name");
                String queryParameter13 = uri.getQueryParameter("eqid");
                String queryParameter14 = uri.getQueryParameter("topic_id");
                String queryParameter15 = uri.getQueryParameter("fid");
                aq aqVar = new aq("c13561");
                aqVar.dW("obj_locate", queryParameter2);
                aqVar.dW("obj_type", t);
                aqVar.dW("obj_param1", queryParameter3);
                aqVar.dW(TiebaInitialize.Params.OBJ_PARAM2, queryParameter4);
                aqVar.dW(TiebaInitialize.Params.OBJ_PARAM3, queryParameter5);
                aqVar.dW("tid", queryParameter6);
                aqVar.dW("fid", queryParameter15);
                aqVar.dW("fname", queryParameter7);
                aqVar.dW(f.eBH, queryParameter8);
                aqVar.dW(f.eBI, queryParameter9);
                aqVar.dW(f.eBJ, queryParameter10);
                aqVar.dW(f.eBK, queryParameter11);
                aqVar.dW("obj_source", queryParameter);
                aqVar.dW("obj_name", queryParameter12);
                aqVar.dW("query", queryParameter13);
                aqVar.dW("topic_id", queryParameter14);
                aqVar.an("obj_id", TbadkCoreApplication.getInst().getStartType());
                aqVar.an(TiebaInitialize.Params.OBJ_TO, 1);
                TiebaStatic.log(aqVar);
            }
        }
    }

    public static void v(Uri uri) {
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("is_new_schema");
            if (!TextUtils.isEmpty(queryParameter) && queryParameter.equals("1")) {
                String queryParameter2 = uri.getQueryParameter("obj_source");
                String queryParameter3 = uri.getQueryParameter("obj_locate");
                String queryParameter4 = uri.getQueryParameter("obj_type");
                String queryParameter5 = uri.getQueryParameter("obj_param1");
                aq aqVar = new aq("c13998");
                aqVar.dW("obj_source", queryParameter2);
                aqVar.dW("obj_locate", queryParameter3);
                aqVar.dW("obj_type", queryParameter4);
                aqVar.dW("obj_param1", queryParameter5);
                TiebaStatic.log(aqVar);
            }
        }
    }
}
