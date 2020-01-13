package com.baidu.searchbox.ugc.utils;

import android.text.TextUtils;
import com.baidu.pyramid.runtime.service.c;
import com.baidu.ubc.Flow;
import com.baidu.ubc.a;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class UgcUBCUtils {
    private static final String CONTENT_KEY_NET = "network";
    public static final boolean DEBUG = false;
    public static final String HOME_UGC_PUBLISH_ENTRANCE_ID = "649";
    public static final String HOME_UGC_PUBLISH_FROM = "home";
    public static final String HOME_UGC_PUBLISH_PAGE_FEED = "feed";
    public static final String HOME_UGC_PUBLISH_PAGE_HOME = "home";
    public static final String HOME_UGC_PUBLISH_SUCCESS_ID = "659";
    public static final String HOME_UGC_PUBLISH_TYPE_ADD = "click";
    public static final String HOME_UGC_PUBLISH_TYPE_IMG = "picture_click";
    public static final String HOME_UGC_PUBLISH_TYPE_TEXT = "word_click";
    public static final String HOME_UGC_PUBLISH_TYPE_VIDEO = "video_click";
    public static final String LAND_PAGE_PV = "71";
    public static final String MINI_VIDEO_COVER = "mini_video_cover";
    public static final String MINI_VIDEO_FROM = "mini_video";
    public static final String MINI_VIDEO_PUBLISH = "mini_video_publish";
    public static final String PUBLISH_FORWARD_PAGE = "publish_forward";
    public static final String PUBLISH_PAGE = "publish";
    public static final String QUESTION_ASK_PAGE = "interest_home";
    public static final String QUESTION_REPLY_PAGE = "answer";
    public static final String TAG = "UgcUBCUtils";
    public static final String UBC_DANGEROUS_PERMISSION_UGC_PIC_SOURCE = "ugc_pic";
    public static final String UBC_DANGEROUS_PERMISSION_UGC_VIDEO_SOURCE = "ugc_video";
    public static final String UBC_STAR_DURATION_ID = "131";
    public static final String UBC_UGC_ANSWER_ID = "701";
    public static final String UBC_UGC_ASK_FROM = "super_interest";
    public static final String UBC_UGC_ASK_ID = "987";
    public static final String UBC_UGC_ASK_TAG_ID = "interest_id";
    public static final String UBC_UGC_CLICK = "487";
    public static final String UBC_UGC_EVENT = "486";
    public static final String UBC_UGC_INTEREST_ID = "interest_id";
    public static final String UBC_UGC_PUBLISH_ID = "593";
    public static final String UBC_UGC_REPLY_PUBLISH_FROM = "super_interest";
    public static final String UBC_UGC_REPLY_PUBLISH_ID = "977";
    public static final String UBC_UGC_TIME = "703";
    public static final String UBC_VIDEO_TRANSCODER_KEY = "369";
    public static final String UGC_EXT_INFO = "ext";
    public static final String UGC_HOME_CLICK = "click";
    public static final String UGC_HOME_SHOW = "show";
    public static final String UGC_SOURCE_FEED = "feed";
    public static final String UGC_SOURCE_FEED_UGC = "feed_ugc";
    public static final String UGC_SOURCE_STAR = "star";
    public static final String UGC_SOURCE_STAR_HOME = "starhome";
    public static final String UGC_SOURCE_UGC = "ugc";
    public static final String UGC_SOURCE_USER_HOME = "userhome";
    public static final String UGC_TIME_CANCEL = "cancel";
    public static final String UGC_TIME_PUB = "pub";
    public static final String UGC_TYPE_ASK = "ask";
    public static final String UGC_TYPE_ASK_DESCRP_CLICK = "descrp_clk";
    public static final String UGC_TYPE_ASK_DESCRP_SHOW = "descrp_show";
    public static final String UGC_TYPE_ASK_PUBLISH_CLICK = "pub_clk";
    public static final String UGC_TYPE_ASK_SHOW = "edit_show ";
    public static final String UGC_TYPE_AT_CLICK = "at_click";
    public static final String UGC_TYPE_CLICK = "click";
    public static final String UGC_TYPE_EDIT_VIEW = "edit_view";
    public static final String UGC_TYPE_EMOJI_CLICK = "emoji_click";
    public static final String UGC_TYPE_LIVE = "live";
    public static final int UGC_TYPE_ONE = 1;
    public static final String UGC_TYPE_PHOTO_CLICK = "photo_click";
    public static final String UGC_TYPE_PIC_BTN = "pic";
    public static final String UGC_TYPE_PUBLISH_CLICK = "pub_click";
    public static final String UGC_TYPE_SHOW = "show";
    public static final String UGC_TYPE_TEXT_BTN = "text";
    public static final String UGC_TYPE_TOPIC_CLICK = "topic_click";
    public static final String UGC_TYPE_VIDEO_BTN = "video";
    public static final String UGC_TYPE_VIDEO_CLICK = "video_click";
    public static final String UGC_TYPE_VOTE = "vote";
    public static final int UGC_TYPE_ZERO = 0;
    public static final String UGC_VALUE_PUB_FAIL = "pub_fail";
    public static final String UGC_VALUE_PUB_SUCCESS = "pub_success";
    public static final String UGC_VALUE_UP_FAIL = "up_fail";
    public static final String UGC_VALUE_UP_SUCCESS = "up_success";
    private static JSONObject extInfo = new JSONObject();
    private static Flow mFlow = null;
    public static final String mLayerBtnPage = "publish_layer_btn";
    public static final String mLayerPage = "publish_layer";
    public static final String mPicChoiceBtnPage = "publish_picchoice_btn";
    public static final String mPicPreviewBtnPage = "publish_picpreview_btn";
    public static final String mPicPublishPage = "picpublish";
    public static final String mPicShootBtnPage = "publish_picshoot_btn";
    public static final String mPicShootcheckBtnPage = "publish_picshootcheck_btn";
    public static final String mPicUploadPage = "picupload";
    public static final String mPublcshVideoBtnPage = "publish_videobtn";
    public static final String mPublishChoicePage = "publish_choice";
    public static final String mPublishPicBtnPage = "publish_picbtn";
    public static final String mPublishPreviewPage = "publish_preview";
    public static final String mPublishShootPage = "publish_shoot";
    public static final String mPublishShootpreviewPage = "publish_shootpreview";
    private static Flow mUgcPageFlow = null;
    public static final String mVideoChoiceBtnPage = "publish_videochoice_btn";
    public static final String mVideoPreviewBtnPage = "publish_videopreview_btn";
    public static final String mVideoPublishPage = "videopublish";
    public static final String mVideoShootBtnPage = "publish_videoshoot_btn";
    public static final String mVideoShootcheckBtnPage = "publish_videoshootcheck_btn";
    public static final String mVideoUploadPage = "videoupload";
    private static UbcConfig sUbcConfig;
    private static String source;

    /* loaded from: classes12.dex */
    public static class UbcConfig {
        public static final String UBC_ID_DUARTION_PUBLISH_PAGE = "703";
        public static final String UBC_ID_DURATION_PICK_PIC = "131";
        public static final String UBC_ID_EVENT_ANSWER = "701";
        public static final String UBC_ID_EVENT_INTEREST = "593";
        public static final String UBC_ID_EVENT_PAGE_DISPLAY = "486";
        public static final String UBC_ID_EVENT_PICK_PIC_PAGE = "487";
        public boolean isValidUbc = true;
        public Map<String, Boolean> validList;
    }

    public static void enterUgc(boolean z) {
        if (!z) {
            enterUgc();
        }
    }

    public static void enterUgc() {
        mFlow = ugcBeginFlow("131");
    }

    public static void exitPages(int i, String str, boolean z) {
        if (!z) {
            exitPages(i, str);
        }
    }

    public static void exitPages(int i, String str) {
        if (mFlow != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("page", str);
                if (i != -1) {
                    jSONObject.put("type", i + "");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ugcEndFlow("131", mFlow, jSONObject.toString());
            mFlow = null;
        }
    }

    public static void enterUGCPage() {
        if (getUBCManager() != null) {
            mUgcPageFlow = ugcBeginFlow("703");
        }
    }

    public static void exitForwardPage(String str) {
        if (mUgcPageFlow != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("page", PUBLISH_FORWARD_PAGE);
                jSONObject.put("from", "ugc");
                jSONObject.put("source", source);
                jSONObject.put("value", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ugcEndFlow("703", mUgcPageFlow, jSONObject.toString());
            mUgcPageFlow = null;
        }
    }

    public static void exitUnForwardPage(String str) {
        if (mUgcPageFlow != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("page", "publish");
                jSONObject.put("from", "ugc");
                jSONObject.put("source", source);
                jSONObject.put("value", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ugcEndFlow("703", mUgcPageFlow, jSONObject.toString());
            mUgcPageFlow = null;
        }
    }

    public static void exitAnswerPage(String str) {
        if (mUgcPageFlow != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("page", QUESTION_REPLY_PAGE);
                jSONObject.put("from", "ugc");
                jSONObject.put("source", source);
                jSONObject.put("value", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ugcEndFlow("703", mUgcPageFlow, jSONObject.toString());
            mUgcPageFlow = null;
        }
    }

    public static void clickLayerStatistics(int i, String str, boolean z) {
        if (!z) {
            clickLayerStatistics(i, str);
        }
    }

    public static void clickLayerStatistics(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page", str);
            jSONObject.put("type", i + "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ugcOnEvent("487", jSONObject.toString());
    }

    public static void clickLayerBtnStatistics(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("page", mLayerBtnPage);
            jSONObject.put("type", str);
            jSONObject.put("source", source);
            jSONObject2.put("interest_id", str2);
            jSONObject.put("ext", jSONObject2.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ugcOnEvent("487", jSONObject.toString());
    }

    @Deprecated
    public static void ugcUbcStatistics(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "ugc");
            if (str4 != null) {
                jSONObject.put("page", str4);
            }
            if (str2 != null) {
                jSONObject.put("type", str2 + "");
            }
            if (str3 != null) {
                jSONObject.put("value", str3);
            }
            jSONObject.put("source", source);
            jSONObject.put("ext", getExtInfo());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ugcOnEvent(str, jSONObject.toString());
    }

    public static void ugcPvStatistics(int i, String str, boolean z) {
        if (!z) {
            ugcPvStatistics(i, str);
        }
    }

    public static void ugcPvStatistics(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.equals(mLayerPage, str)) {
                jSONObject.put("type", i + "");
            }
            jSONObject.put("page", str);
            jSONObject.put("source", source);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ugcOnEvent("486", jSONObject.toString());
    }

    public static void ugcLivePvStatistics() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "ugc");
            jSONObject.put("page", mLayerPage);
            jSONObject.put("source", source);
            jSONObject.put("type", "live");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ugcOnEvent("486", jSONObject.toString());
    }

    public static void miniVideoStatistics(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", str);
            jSONObject.put("page", str2);
            jSONObject.put("network", str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ugcOnEvent(LAND_PAGE_PV, jSONObject.toString());
    }

    public static void ugcHomeStatistics(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "home");
            jSONObject.put("type", str);
            jSONObject.put("page", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ugcOnEvent(HOME_UGC_PUBLISH_SUCCESS_ID, jSONObject.toString());
    }

    public static void answerStatistics(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "ugc");
            jSONObject.put("page", QUESTION_REPLY_PAGE);
            jSONObject.put("source", source);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("type", str);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ugcOnEvent("701", jSONObject.toString());
    }

    public static void askStatistics(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", "super_interest");
            jSONObject.put("page", QUESTION_ASK_PAGE);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("type", str);
            }
            jSONObject.put("ext", getExtInfo());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ugcOnEvent(UBC_UGC_ASK_ID, jSONObject.toString());
    }

    public static void setSource(String str) {
        source = str;
    }

    public static String getSource() {
        return source;
    }

    public static void setExtInfo(String str, String str2) {
        try {
            extInfo.put(str, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getExtInfo() {
        return extInfo;
    }

    public static void ubcEventStatistics(String str, String str2, String str3, String str4, String str5, String str6, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("from", str2);
            jSONObject2.put("page", str3);
            jSONObject2.put("type", str4);
            jSONObject2.put("source", str5);
            jSONObject2.put("value", str6);
            jSONObject2.put("ext", jSONObject);
        } catch (Exception e) {
        }
        ugcOnEvent(str, jSONObject2.toString());
    }

    public static void saveDraftPublishUbcStatistics(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        String str2;
        String str3 = z4 ? "701" : "593";
        String str4 = z ? PUBLISH_FORWARD_PAGE : "publish";
        if (z4) {
            str4 = QUESTION_REPLY_PAGE;
        }
        if (z2) {
            str2 = z3 ? "save" : "quit";
        } else {
            str2 = "direct";
        }
        ubcEventStatistics(str3, "ugc", str4, "cancel_click", str, str2, null);
    }

    public static void recordUgcTagStatistics(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ubcEventStatistics("593", "ugc", null, str, str2, null, null);
        }
    }

    public static void emotionUbcStatistics(String str, boolean z, String str2) {
        String str3 = z ? PUBLISH_FORWARD_PAGE : "publish";
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("emoji_id", str2);
        } catch (JSONException e) {
        }
        ubcEventStatistics("593", "ugc", str3, UGC_TYPE_EMOJI_CLICK, str, "emoji_choice", jSONObject);
    }

    public static void replyPublishUbcStatistics(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            try {
                jSONObject.put("nid", str3);
                jSONObject.put("interestID", str4);
            } catch (JSONException e) {
            }
        }
        ubcEventStatistics(UBC_UGC_REPLY_PUBLISH_ID, "super_interest", null, str, null, str2, jSONObject);
    }

    public static Flow ugcBeginFlow(String str) {
        if (checkValid(str)) {
            print(str, "beginFlow", null);
            a uBCManager = getUBCManager();
            if (uBCManager != null) {
                return uBCManager.Hd(str);
            }
            return null;
        }
        return null;
    }

    public static void ugcOnEvent(String str, String str2) {
        if (checkValid(str)) {
            a uBCManager = getUBCManager();
            if (uBCManager != null) {
                uBCManager.onEvent(str, str2);
            }
            print(str, "onEvent", str2);
        }
    }

    public static void ugcEndFlow(String str, Flow flow, String str2) {
        a uBCManager = getUBCManager();
        if (uBCManager != null) {
            uBCManager.b(flow, str2);
            uBCManager.a(flow);
        }
        print(str, "endFlow", str2);
    }

    public static a getUBCManager() {
        return (a) c.a(a.SERVICE_REFERENCE);
    }

    public static boolean checkValid(String str) {
        Boolean bool;
        if (sUbcConfig == null) {
            return true;
        }
        if (!sUbcConfig.isValidUbc) {
            return false;
        }
        Map<String, Boolean> map = sUbcConfig.validList;
        if (map != null && (bool = map.get(str)) != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private static void print(String str, String str2, Object obj) {
    }

    public static void setUbcConfig(UbcConfig ubcConfig) {
        sUbcConfig = ubcConfig;
    }
}
