package com.baidu.live.entereffect.a;

import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public String aVV;
    public long aVW;
    public com.baidu.live.gift.c aVX;
    public boolean aVY;
    public int frameCount;
    public String id;
    public int priority;
    public String videoMd5;
    public String videoUrl;

    public JSONObject FE() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("mp4_file_url", this.videoUrl);
            jSONObject.put("video_md5", this.videoMd5);
            jSONObject.put(FuFaceItem.JK_SO_URL, this.aVV);
            jSONObject.put("frame_count", this.frameCount);
            jSONObject.put("last_accessed", this.aVW);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public a k(String str, String str2, String str3, String str4) {
        this.videoUrl = str;
        this.videoMd5 = str4;
        if (this.aVX == null) {
            this.aVX = new com.baidu.live.gift.c();
        }
        this.aVX.aXc = str2;
        this.aVX.videoPath = str3;
        return this;
    }

    public a b(String str, String str2, List<String> list) {
        this.aVV = str;
        if (this.aVX == null) {
            this.aVX = new com.baidu.live.gift.c();
        }
        this.aVX.upZipDirPath = str2;
        if (list != null) {
            this.frameCount = list.size();
            if (this.aVX.aXb != null && this.aVX.aXb.aWZ != null) {
                this.aVX.aXb.aWZ.frame_count = this.frameCount;
            }
            this.aVX.unZipFilesPathList = new ArrayList<>();
            this.aVX.unZipFilesPathList.addAll(list);
        }
        return this;
    }
}
