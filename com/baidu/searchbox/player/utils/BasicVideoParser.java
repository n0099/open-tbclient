package com.baidu.searchbox.player.utils;

import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/player/utils/BasicVideoParser;", "Lcom/baidu/searchbox/player/utils/IVideoParser;", "()V", "parseClarity", "", "videoSeries", "Lcom/baidu/searchbox/player/model/BasicVideoSeries;", "videoInfoObj", "Lorg/json/JSONObject;", "parseVideoInfo", "videoInfo", "", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class BasicVideoParser implements IVideoParser {
    public void parseClarity(BasicVideoSeries videoSeries, JSONObject videoInfoObj) {
        boolean z;
        Intrinsics.checkNotNullParameter(videoSeries, "videoSeries");
        Intrinsics.checkNotNullParameter(videoInfoObj, "videoInfoObj");
        String optString = videoInfoObj.optString(BasicVideoParserKt.CLARITY);
        Intrinsics.checkNotNullExpressionValue(optString, "videoInfoObj.optString(CLARITY)");
        boolean z2 = true;
        if (optString.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            videoSeries.setClarityUrlList(videoInfoObj.optString(BasicVideoParserKt.CLARITY));
            return;
        }
        String ext = videoSeries.getExt();
        if (ext != null && ext.length() != 0) {
            z2 = false;
        }
        if (!z2) {
            try {
                videoSeries.setClarityUrlList(new JSONObject(ext).optString(BasicVideoParserKt.CLARITY));
            } catch (JSONException e) {
                if (BDPlayerConfig.isDebug()) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.searchbox.player.utils.IVideoParser
    public BasicVideoSeries parseVideoInfo(String str) {
        boolean z;
        int i;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                BasicVideoSeries basicVideoSeries = new BasicVideoSeries();
                String optString = jSONObject.optString("vid");
                Intrinsics.checkNotNullExpressionValue(optString, "videoInfoObj.optString(VID)");
                basicVideoSeries.setVid(optString);
                String optString2 = jSONObject.optString("from");
                Intrinsics.checkNotNullExpressionValue(optString2, "videoInfoObj.optString(FROM)");
                basicVideoSeries.setFrom(optString2);
                String optString3 = jSONObject.optString("page");
                Intrinsics.checkNotNullExpressionValue(optString3, "videoInfoObj.optString(PAGE)");
                basicVideoSeries.setPage(optString3);
                basicVideoSeries.setDuration(jSONObject.optInt("duration"));
                basicVideoSeries.setResourceType(jSONObject.optString(BasicVideoParserKt.RESOURCE_TYPE));
                JSONObject optJSONObject = jSONObject.optJSONObject(BasicVideoParserKt.EXT_LOG);
                if (optJSONObject != null) {
                    basicVideoSeries.setExtLog(optJSONObject.toString());
                    String optString4 = optJSONObject.optString(BasicVideoParserKt.PD_REC);
                    Intrinsics.checkNotNullExpressionValue(optString4, "optString(PD_REC)");
                    basicVideoSeries.setSource(optString4);
                }
                String rank = jSONObject.optString(BasicVideoParserKt.PREFERRED_CLARITY_RANK);
                Intrinsics.checkNotNullExpressionValue(rank, "rank");
                Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(rank);
                if (intOrNull != null) {
                    i = intOrNull.intValue();
                } else {
                    i = -1;
                }
                basicVideoSeries.setPreferredClarityRank(i);
                parseClarity(basicVideoSeries, jSONObject);
                return null;
            } catch (Exception e) {
                BdVideoLog.e(e.getMessage());
                return null;
            }
        }
        return null;
    }
}
