package c.a.s0.a;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.searchbox.launch.ExternalTransferSpeedStats;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.connect.common.Constants;
import java.util.Map;
/* loaded from: classes6.dex */
public class w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) {
            String paramStr = UrlManager.getParamStr(str);
            if (TextUtils.isEmpty(paramStr)) {
                return;
            }
            b(statisticItem, UrlManager.getParamPair(paramStr));
        }
    }

    public static void b(StatisticItem statisticItem, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, statisticItem, map) == null) || statisticItem == null || map == null) {
            return;
        }
        statisticItem.param(TiebaStatic.Params.REFER, map.get(TiebaStatic.Params.REFER));
        statisticItem.param("pid", map.get("hightlight_anchor_pid"));
    }

    public static void c(Uri uri) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, uri) == null) || uri == null) {
            return;
        }
        String d2 = d(uri);
        String queryParameter = uri.getQueryParameter("obj_source");
        if ("shoubai".equals(queryParameter) || ThirdPartyUtil.TYPE_WEIXIN.equals(queryParameter) || "tbShareH5".equals(queryParameter) || ExternalTransferSpeedStats.SOURCE_FROM_WISE.equals(queryParameter) || "zhongjianye".equals(queryParameter) || "PC".equals(queryParameter) || Constants.SOURCE_QQ.equals(queryParameter)) {
            String queryParameter2 = uri.getQueryParameter("obj_locate");
            uri.getQueryParameter("obj_type");
            String queryParameter3 = uri.getQueryParameter("obj_param1");
            String queryParameter4 = uri.getQueryParameter(TiebaStatic.Params.OBJ_PARAM2);
            String queryParameter5 = uri.getQueryParameter(TiebaStatic.Params.OBJ_PARAM3);
            String queryParameter6 = uri.getQueryParameter("tid");
            String queryParameter7 = uri.getQueryParameter(TiebaStatic.Params.H5_FORUM_NAME);
            String queryParameter8 = uri.getQueryParameter(g.v);
            String queryParameter9 = uri.getQueryParameter(g.w);
            String queryParameter10 = uri.getQueryParameter(g.x);
            String queryParameter11 = uri.getQueryParameter(g.y);
            String queryParameter12 = uri.getQueryParameter("obj_name");
            String queryParameter13 = uri.getQueryParameter("eqid");
            String queryParameter14 = uri.getQueryParameter("topic_id");
            String queryParameter15 = uri.getQueryParameter("fid");
            String queryParameter16 = uri.getQueryParameter("room_id");
            String queryParameter17 = uri.getQueryParameter(TiebaStatic.Params.REFER);
            String queryParameter18 = uri.getQueryParameter(TiebaStatic.Params.WISE_SAMPLE_ID);
            String queryParameter19 = uri.getQueryParameter(TiebaStatic.Params.BDID);
            String queryParameter20 = uri.getQueryParameter("hightlight_anchor_pid");
            String queryParameter21 = uri.getQueryParameter(TiebaStatic.Params.QD);
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AIAPPS_CALL_NATIVE);
            statisticItem.param("obj_locate", queryParameter2);
            statisticItem.param("obj_type", d2);
            statisticItem.param("obj_param1", queryParameter3);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, queryParameter4);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, queryParameter5);
            statisticItem.param("tid", queryParameter6);
            statisticItem.param("fid", queryParameter15);
            statisticItem.param("fname", queryParameter7);
            statisticItem.param("room_id", queryParameter16);
            statisticItem.param(g.v, queryParameter8);
            statisticItem.param(g.w, queryParameter9);
            statisticItem.param(g.x, queryParameter10);
            statisticItem.param(g.y, queryParameter11);
            statisticItem.param("obj_source", queryParameter);
            statisticItem.param("obj_name", queryParameter12);
            statisticItem.param("query", queryParameter13);
            statisticItem.param("topic_id", queryParameter14);
            statisticItem.param("obj_id", TbadkCoreApplication.getInst().getStartType());
            statisticItem.param(TiebaStatic.Params.OBJ_TO, 1);
            statisticItem.param(TiebaStatic.Params.WISE_SAMPLE_ID, queryParameter18);
            statisticItem.param(TiebaStatic.Params.BDID, queryParameter19);
            if (TextUtils.isEmpty(queryParameter17)) {
                queryParameter17 = StringUtil.NULL_STRING;
            }
            statisticItem.param(TiebaStatic.Params.REFER, queryParameter17);
            statisticItem.param("pid", queryParameter20);
            statisticItem.param(TiebaStatic.Params.QD, queryParameter21);
            TiebaStatic.log(statisticItem);
        }
    }

    public static String d(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, uri)) == null) {
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
            if (!uri2.contains("tbpb") && !uri2.contains("unidispatch/pb")) {
                return (uri2.contains("tbfrs") || uri2.contains("unidispatch/frs")) ? "2" : uri2.contains("tbwebview") ? "9" : (uri2.contains("tbusercenter") || uri2.contains("unidispatch/usercenter") || uri2.contains("usercenter")) ? "4" : (uri2.contains("tbtopicdetail") || uri2.contains("unidispatch/topicdetail")) ? "3" : uri2.contains("unidispatch/hotuserrank") ? "7" : g.f12263c.equals(uri.getPath()) ? "5" : uri2.contains("unidispatch/searchResultPage") ? !TextUtils.isEmpty(uri.getQueryParameter(g.Y)) ? "11" : "5" : "10";
            } else if ("tbpb://tieba.baidu.com".equals(uri2)) {
                return "5";
            } else {
                if (TextUtils.isEmpty(uri.getQueryParameter(g.v))) {
                    String queryParameter = uri.getQueryParameter("obj_param1");
                    if (g.g0.equals(queryParameter) || "2".equals(queryParameter)) {
                        String queryParameter2 = uri.getQueryParameter("obj_source");
                        String queryParameter3 = uri.getQueryParameter("tid");
                        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_FROM_OUTSIDE);
                        if (g.h0.equals(queryParameter2)) {
                            statisticItem.param("obj_source", 2);
                        } else if (g.i0.equals(queryParameter2)) {
                            statisticItem.param("obj_source", 3);
                        } else if (g.j0.equals(queryParameter2)) {
                            statisticItem.param("obj_source", 4);
                        } else if (g.k0.equals(queryParameter2)) {
                            statisticItem.param("obj_source", 5);
                        }
                        statisticItem.param("tid", queryParameter3);
                        TiebaStatic.log(statisticItem);
                        return "1";
                    }
                    return "1";
                }
                return "6";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void e(Uri uri) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, uri) == null) || uri == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("is_new_schema");
        if (TextUtils.isEmpty(queryParameter) || !queryParameter.equals("1")) {
            return;
        }
        String queryParameter2 = uri.getQueryParameter("obj_source");
        String queryParameter3 = uri.getQueryParameter("obj_locate");
        String queryParameter4 = uri.getQueryParameter("obj_type");
        String queryParameter5 = uri.getQueryParameter("obj_param1");
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_PAY_PUT_TIE);
        statisticItem.param("obj_source", queryParameter2);
        statisticItem.param("obj_locate", queryParameter3);
        statisticItem.param("obj_type", queryParameter4);
        statisticItem.param("obj_param1", queryParameter5);
        TiebaStatic.log(statisticItem);
    }
}
