package com.baidu.mobads.container.landingpage;

import android.net.Uri;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class JsWithPlayerData {
    public String callJsfunc;
    public String interactivetype;
    public boolean isAutoPlayNext;
    public boolean isAutoPlayThis;
    public boolean isExistNextVideo;
    public boolean isExistPreVideo;
    public boolean isFullScreenPlay;
    public boolean isPlayerTopLocation;
    public boolean isShowSpeed;
    public boolean isShowTitle;
    public String mCurVideoPlayTime;
    public String mCurVideoStatus;
    public String mCurVideoUserAction;
    public String mPrerolls_Id;
    public String mPrerolls_Img;
    public String mPrerolls_Title;
    public String nextVideoPicurl;
    public String nextVideoTitle;
    public String nextVideoUrl;
    public String preVideoTitle;
    public String prevVideoPicurl;
    public String prevVideoUrl;
    public String videoId;
    public String videoIndex;
    public String videoPicUrl;
    public String videoTitle;
    public String videoUrl;

    public JsWithPlayerData(JSONObject jSONObject, String str) {
        this.interactivetype = jSONObject.optString("type");
        this.isAutoPlayThis = jSONObject.optBoolean("isautoplaythis", true);
        this.isAutoPlayNext = jSONObject.optBoolean("isautoplaynext");
        this.isPlayerTopLocation = jSONObject.optBoolean("isvieoattop");
        this.isShowSpeed = jSONObject.optBoolean("isshowspeed");
        this.isFullScreenPlay = jSONObject.optBoolean("isfullscreen");
        this.isFullScreenPlay = true;
        this.isExistPreVideo = jSONObject.optBoolean("isexistprevideo");
        this.isExistNextVideo = jSONObject.optBoolean("isexistnextvideo");
        this.isShowTitle = jSONObject.optBoolean("isshowtitle");
        this.videoUrl = jSONObject.optString("videourl");
        this.videoTitle = jSONObject.optString("videotitle");
        this.videoPicUrl = jSONObject.optString("mainpicurl");
        this.videoId = jSONObject.optString("videoid");
        this.videoIndex = jSONObject.optString("videoindex");
        this.prevVideoUrl = jSONObject.optString("prevideourl");
        this.nextVideoUrl = jSONObject.optString("nextvideourl");
        this.prevVideoPicurl = jSONObject.optString("prevideopicurl");
        this.nextVideoPicurl = jSONObject.optString("nextvideopicurl");
        this.preVideoTitle = jSONObject.optString("prevideotitle");
        this.nextVideoTitle = jSONObject.optString("nextvideotitle");
        this.mPrerolls_Id = jSONObject.optString("bdadid");
        this.mPrerolls_Img = jSONObject.optString("bdadimg");
        this.mPrerolls_Title = jSONObject.optString("bdadtitle");
        this.callJsfunc = str;
    }

    public static JsWithPlayerData createObjFromUrl(String str) {
        String str2;
        String queryParameter;
        JSONObject jSONObject = null;
        try {
            Uri parse = Uri.parse(str);
            queryParameter = parse.getQueryParameter("params");
            str2 = parse.getQueryParameter("callback");
        } catch (Exception e2) {
            e = e2;
            str2 = null;
        }
        try {
            jSONObject = new JSONObject(queryParameter);
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return new JsWithPlayerData(jSONObject, str2);
        }
        return new JsWithPlayerData(jSONObject, str2);
    }

    public String getCurVideoPlayTime() {
        return this.mCurVideoPlayTime;
    }

    public String getCurVideoStatus() {
        return this.mCurVideoStatus;
    }

    public String getCurVideoUserAction() {
        return this.mCurVideoUserAction;
    }

    public void setCurVideoPlayTime(String str) {
        this.mCurVideoPlayTime = str;
    }

    public void setCurVideoStatus(String str) {
        this.mCurVideoStatus = str;
    }

    public void setCurVideoUserAction(String str) {
        this.mCurVideoUserAction = str;
    }
}
