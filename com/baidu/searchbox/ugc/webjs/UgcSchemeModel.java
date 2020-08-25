package com.baidu.searchbox.ugc.webjs;

import android.text.TextUtils;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.searchbox.ugc.utils.SelectUtil;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class UgcSchemeModel implements Serializable {
    public static final int NA_CALL_TYPE = 1;
    public static final int SCHEME_CALL_TYPE = 2;
    public String atSchema;
    public String cameraBtns;
    public String channel;
    public int clipMaxDuration;
    public int clipMinDuration;
    public String delayTime;
    public String duration;
    public String ext;
    public String forwardContent;
    public String forwardSource;
    public int from;
    public transient JSONObject iconInfoObjs;
    public List<String> iconList;
    public String launchFrom;
    public String location;
    public int maxSelected;
    public int maxTime;
    public int minTime;
    public String musicPageUrl;
    public boolean noStatistics;
    public String path;
    public String placeContent;
    public String placeTitle;
    public String placeholder;
    public String publishLimit;
    public String publishType;
    public String questionAsk;
    public String questionReply;
    public String referenceDt;
    public int serverTopicsRule;
    public int showToast;
    public String sourceFrom;
    public int sourceType;
    public int sourceid;
    public int supportGif;
    public boolean supportSingleSelect;
    public String swan;
    public String target;
    public String topic;
    public String topicSelectSchema;
    public boolean tuneupPlugin;
    public int type;
    public String ugcCallback;
    public String url;
    public String voteSchema;
    public String videoCover = "";
    public String followVideoDataStr = "";
    public boolean isFollowVideo = false;
    public String videoProductionType = "";
    public int callType = 2;

    public static UgcSchemeModel parserSchemeModel(JSONObject jSONObject) {
        UgcSchemeModel ugcSchemeModel = new UgcSchemeModel();
        ugcSchemeModel.iconInfoObjs = jSONObject.optJSONObject(UgcConstant.ICONS_INFO);
        ugcSchemeModel.ugcCallback = jSONObject.optString(UgcConstant.UGC_CALLBACK);
        ugcSchemeModel.url = jSONObject.optString("url");
        ugcSchemeModel.publishType = jSONObject.optString(UgcConstant.PUBLISH_TYPE);
        ugcSchemeModel.placeholder = jSONObject.optString(UgcConstant.PLACEHOLDER);
        ugcSchemeModel.sourceType = jSONObject.optInt(UgcConstant.SOURCE_TYPE);
        ugcSchemeModel.topicSelectSchema = jSONObject.optString("topic_pageurl");
        ugcSchemeModel.atSchema = jSONObject.optString(UgcConstant.AT_PAGEURL);
        ugcSchemeModel.voteSchema = jSONObject.optString(UgcConstant.VOTE_PAGEURL);
        ugcSchemeModel.serverTopicsRule = jSONObject.optInt(UgcConstant.SERVER_TOPICS_RULE);
        ugcSchemeModel.placeTitle = jSONObject.optString(UgcConstant.PLACE_TITLE);
        ugcSchemeModel.placeContent = jSONObject.optString(UgcConstant.PLACE_CONTENT);
        JSONObject optJSONObject = jSONObject.optJSONObject("topic");
        if (optJSONObject != null) {
            ugcSchemeModel.topic = optJSONObject.toString();
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("location");
        if (optJSONObject2 != null) {
            ugcSchemeModel.location = optJSONObject2.toString();
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject(UgcConstant.EXT_INFO);
        if (optJSONObject3 != null) {
            ugcSchemeModel.ext = optJSONObject3.toString();
        }
        ugcSchemeModel.forwardContent = jSONObject.optString("forward_content");
        JSONObject optJSONObject4 = jSONObject.optJSONObject("reference_dt");
        if (optJSONObject4 != null) {
            ugcSchemeModel.referenceDt = optJSONObject4.toString();
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("target");
        if (optJSONObject5 != null) {
            ugcSchemeModel.target = optJSONObject5.toString();
        } else {
            ugcSchemeModel.target = jSONObject.optString("target");
        }
        ugcSchemeModel.forwardSource = jSONObject.optString("forward_tab");
        ugcSchemeModel.supportGif = jSONObject.optInt(UgcConstant.SUPPORT_GIF, 1);
        SelectUtil.supportGifLongImg = ugcSchemeModel.supportGif == 1;
        String optString = jSONObject.optString("source_from");
        ugcSchemeModel.sourceFrom = optString;
        if (TextUtils.equals(ugcSchemeModel.publishType, "5")) {
            transferSourceData(optString, ugcSchemeModel);
        }
        UgcUBCUtils.setSource(ugcSchemeModel.sourceFrom);
        ugcSchemeModel.path = jSONObject.optString("video_path");
        ugcSchemeModel.channel = jSONObject.optString("channel");
        ugcSchemeModel.sourceid = jSONObject.optInt(UgcConstant.SOURCE_ID);
        ugcSchemeModel.musicPageUrl = jSONObject.optString(UgcConstant.MUSIC_PAGEURL);
        JSONObject optJSONObject6 = jSONObject.optJSONObject("duration");
        if (optJSONObject6 != null) {
            ugcSchemeModel.duration = optJSONObject6.toString();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(UgcConstant.CAMERA_BTNS);
        if (optJSONArray != null) {
            ugcSchemeModel.cameraBtns = optJSONArray.toString();
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(UgcConstant.TIMER_COUNT);
        if (optJSONArray2 != null) {
            ugcSchemeModel.delayTime = optJSONArray2.toString();
        }
        JSONObject optJSONObject7 = jSONObject.optJSONObject(UgcConstant.QUESTION_REPLY);
        if (optJSONObject7 != null) {
            ugcSchemeModel.questionReply = optJSONObject7.toString();
        }
        JSONObject optJSONObject8 = jSONObject.optJSONObject(UgcConstant.QUESTION_ASK);
        if (optJSONObject8 != null) {
            ugcSchemeModel.questionAsk = optJSONObject8.toString();
        }
        JSONObject optJSONObject9 = jSONObject.optJSONObject(UgcConstant.FOLLOW_VIDEO);
        if (optJSONObject9 != null) {
            ugcSchemeModel.followVideoDataStr = optJSONObject9.toString();
            ugcSchemeModel.isFollowVideo = true;
        } else {
            ugcSchemeModel.isFollowVideo = false;
        }
        ugcSchemeModel.showToast = jSONObject.optInt(UgcConstant.SHOW_TOAST, 0);
        ugcSchemeModel.clipMinDuration = jSONObject.optInt(UgcConstant.CLIP_MIN_DURATION, 3);
        ugcSchemeModel.clipMaxDuration = jSONObject.optInt(UgcConstant.CLIP_MAX_DURATION, 20);
        ugcSchemeModel.swan = jSONObject.optString("swan");
        JSONObject optJSONObject10 = jSONObject.optJSONObject(UgcConstant.UGC_PUBLISH_LIMIT);
        if (optJSONObject10 != null) {
            ugcSchemeModel.publishLimit = optJSONObject10.toString();
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray("icons");
        if (optJSONArray3 != null) {
            ugcSchemeModel.iconList = new ArrayList();
            for (int i = 0; i < optJSONArray3.length(); i++) {
                String optString2 = optJSONArray3.optString(i);
                if (!TextUtils.isEmpty(optString2)) {
                    ugcSchemeModel.iconList.add(optString2);
                }
            }
        }
        return ugcSchemeModel;
    }

    private static void transferSourceData(String str, UgcSchemeModel ugcSchemeModel) {
        if (TextUtils.equals(str, "ugc")) {
            ugcSchemeModel.sourceFrom = UgcUBCUtils.UGC_SOURCE_USER_HOME;
        } else if (TextUtils.equals(str, "star")) {
            ugcSchemeModel.sourceFrom = UgcUBCUtils.UGC_SOURCE_STAR_HOME;
        } else if (TextUtils.equals(str, "feed")) {
            ugcSchemeModel.sourceFrom = UgcUBCUtils.UGC_SOURCE_FEED_UGC;
        } else {
            ugcSchemeModel.sourceFrom = str;
        }
    }
}
