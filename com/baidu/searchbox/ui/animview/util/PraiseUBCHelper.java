package com.baidu.searchbox.ui.animview.util;

import com.baidu.searchbox.ui.animview.praise.data.ComboPraiseUBC;
import com.baidu.searchbox.ui.animview.praise.ioc.PraiseUBCRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class PraiseUBCHelper {
    public static final String FROM = "praise";
    public static final String PRAISE_FLOW_ID = "706";
    public static final String PRAISE_ID = "690";
    public static final int PRAISE_MODE_DEGRADED = 0;
    public static final int PRAISE_MODE_NORMAL = 1;
    public static final String SOURCE_COMMENT = "comment";
    public static final String SOURCE_DYNAMIC = "dynamic";
    public static final String SOURCE_DYNAMIC_IMGTXT = "dynamic_imgtxt";
    public static final String SOURCE_DYNAMIC_LIST = "dynamic_list";
    public static final String SOURCE_DYNAMIC_VIDEO = "dynamic_video";
    public static final String SOURCE_FEED = "feed";
    public static final String SOURCE_FEEDNEWS = "feednews";
    public static final String SOURCE_FEEDVIDEO_LIST = "feedvideo_list";
    public static final String SOURCE_FEEDVIDEO_LP = "feedvideo_lp";
    public static final String SOURCE_HOT_DISCUSSION = "reyi_bar";
    public static final String SOURCE_IMMERSIVE_VIDEO_LIST = "feedvideo_immersive";
    public static final String SOURCE_LONGVIDEO = "longvideo";
    public static final String SOURCE_MINIVIDEO = "minivideo";
    public static final String SOURCE_PAGE = "page";
    public static final String SOURCE_PERSONAL_PAGE = "personal_page";
    public static final String SOURCE_STAR = "star";
    public static final String SOURCE_WENDA = "wenda";
    public static final String UBC_COMBO_KEY = "combo";
    public static final String UBC_COMBO_SOURCE_KEY = "combo_source";
    public static final String UBC_EXT_KEY = "ext";
    public static final String UBC_FROM_KEY = "from";
    public static final String UBC_NID_KEY = "nid";
    public static final String UBC_SOURCE_KEY = "source";
    public static final String UBC_VALUE_KEY = "value";

    public static void praiseUBCEvent(ComboPraiseUBC comboPraiseUBC, int i, long j, String str) {
        if (comboPraiseUBC != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "praise");
                jSONObject.put("source", comboPraiseUBC.getUBCSource());
                jSONObject.put("value", i);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("nid", comboPraiseUBC.getNid());
                jSONObject2.put(UBC_COMBO_KEY, j);
                jSONObject2.put(UBC_COMBO_SOURCE_KEY, str);
                jSONObject.putOpt("ext", jSONObject2);
                if (PraiseUBCRuntime.getContext() != null) {
                    PraiseUBCRuntime.getContext().onEvent(PRAISE_ID, jSONObject.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void beginPraiseAnimeFlow() {
        if (PraiseUBCRuntime.getContext() != null) {
            PraiseUBCRuntime.getContext().beginFlow(PRAISE_FLOW_ID);
        }
    }

    public static void endPraiseAnimeFlow(ComboPraiseUBC comboPraiseUBC, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "praise");
            jSONObject.put("source", comboPraiseUBC.getUBCSource());
            jSONObject.put("value", i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("nid", comboPraiseUBC.getNid());
            jSONObject.putOpt("ext", jSONObject2);
            if (PraiseUBCRuntime.getContext() != null) {
                PraiseUBCRuntime.getContext().endFlowWithDuration(PRAISE_FLOW_ID, jSONObject.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
