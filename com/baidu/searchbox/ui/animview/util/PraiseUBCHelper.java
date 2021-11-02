package com.baidu.searchbox.ui.animview.util;

import com.baidu.searchbox.ui.animview.praise.data.ComboPraiseUBC;
import com.baidu.searchbox.ui.animview.praise.ioc.PraiseUBCRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class PraiseUBCHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM = "praise";
    public static final String PRAISE_FLOW_ID = "706";
    public static final String PRAISE_ID = "690";
    public static final int PRAISE_MODE_DEGRADED = 0;
    public static final int PRAISE_MODE_NORMAL = 1;
    public static final String SOURCE_COMMENT = "comment";
    public static final String SOURCE_DYNAMIC = "dynamic";
    public static final String SOURCE_DYNAMIC_IMGTXT = "dynamic_imgtxt";
    public static final String SOURCE_DYNAMIC_IMMERSIVE = "dt_immersive";
    public static final String SOURCE_DYNAMIC_LIST = "dynamic_list";
    public static final String SOURCE_DYNAMIC_VIDEO = "dynamic_video";
    public static final String SOURCE_FEED = "feed";
    public static final String SOURCE_FEEDNEWS = "feednews";
    public static final String SOURCE_FEEDVIDEO_LIST = "feedvideo_list";
    public static final String SOURCE_FEEDVIDEO_LP = "feedvideo_lp";
    public static final String SOURCE_FEED_VIDEO_LANDING = "feed_video_landing_like_button";
    public static final String SOURCE_FEED_VIDEO_LANDING_DOUBLE_CLICK = "feed_video_landing_double_click";
    public static final String SOURCE_HOT_DISCUSSION = "reyi_bar";
    public static final String SOURCE_IMMERSIVE_VIDEO_LIST = "feedvideo_immersive";
    public static final String SOURCE_LIVE_ASK_ANSWER = "live_ask_answer";
    public static final String SOURCE_LONGVIDEO = "longvideo";
    public static final String SOURCE_MERGE_VIDEO_LANDING = "merge_video_landing_like_button";
    public static final String SOURCE_MERGE_VIDEO_LANDING_DOUBLE_CLICK = "merge_video_landing_double_click";
    public static final String SOURCE_MINIVIDEO = "minivideo";
    public static final String SOURCE_PAGE = "page";
    public static final String SOURCE_PERSONAL_PAGE = "personal_page";
    public static final String SOURCE_STAR = "star";
    public static final String SOURCE_WENDA = "wenda";
    public static final String SOURCE_YOULIAO = "youliao";
    public static final String UBC_COMBO_KEY = "combo";
    public static final String UBC_COMBO_SOURCE_KEY = "combo_source";
    public static final String UBC_EXT_KEY = "ext";
    public static final String UBC_FROM_KEY = "from";
    public static final String UBC_NID_KEY = "nid";
    public static final String UBC_SOURCE_KEY = "source";
    public static final String UBC_VALUE_KEY = "value";
    public transient /* synthetic */ FieldHolder $fh;

    public PraiseUBCHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void beginPraiseAnimeFlow() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || PraiseUBCRuntime.getContext() == null) {
            return;
        }
        PraiseUBCRuntime.getContext().beginFlow(PRAISE_FLOW_ID);
    }

    public static void endPraiseAnimeFlow(ComboPraiseUBC comboPraiseUBC, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, comboPraiseUBC, i2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "praise");
                jSONObject.put("source", comboPraiseUBC.getUBCSource());
                jSONObject.put("value", i2);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("nid", comboPraiseUBC.getNid());
                jSONObject.putOpt("ext", jSONObject2);
                if (PraiseUBCRuntime.getContext() != null) {
                    PraiseUBCRuntime.getContext().endFlowWithDuration(PRAISE_FLOW_ID, jSONObject.toString());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void praiseUBCEvent(ComboPraiseUBC comboPraiseUBC, int i2, long j, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{comboPraiseUBC, Integer.valueOf(i2), Long.valueOf(j), str}) == null) || comboPraiseUBC == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "praise");
            jSONObject.put("source", comboPraiseUBC.getUBCSource());
            jSONObject.put("value", i2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("nid", comboPraiseUBC.getNid());
            jSONObject2.put(UBC_COMBO_KEY, j);
            jSONObject2.put(UBC_COMBO_SOURCE_KEY, str);
            jSONObject.putOpt("ext", jSONObject2);
            if (PraiseUBCRuntime.getContext() != null) {
                PraiseUBCRuntime.getContext().onEvent(PRAISE_ID, jSONObject.toString());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
