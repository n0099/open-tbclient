package com.baidu.live.entereffect.a;

import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String aRU;
    public long aRV;
    public com.baidu.live.gift.c aRW;
    public boolean aRX;
    public int frameCount;
    public String id;
    public int priority;
    public String videoMd5;
    public String videoUrl;

    public JSONObject EI() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("mp4_file_url", this.videoUrl);
            jSONObject.put("video_md5", this.videoMd5);
            jSONObject.put(FuFaceItem.JK_SO_URL, this.aRU);
            jSONObject.put("frame_count", this.frameCount);
            jSONObject.put("last_accessed", this.aRV);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public a k(String str, String str2, String str3, String str4) {
        this.videoUrl = str;
        this.videoMd5 = str4;
        if (this.aRW == null) {
            this.aRW = new com.baidu.live.gift.c();
        }
        this.aRW.aSM = str2;
        this.aRW.videoPath = str3;
        return this;
    }

    public a b(String str, String str2, List<String> list) {
        this.aRU = str;
        if (this.aRW == null) {
            this.aRW = new com.baidu.live.gift.c();
        }
        this.aRW.upZipDirPath = str2;
        if (list != null) {
            this.frameCount = list.size();
            if (this.aRW.aSL != null && this.aRW.aSL.aSK != null) {
                this.aRW.aSL.aSK.frame_count = this.frameCount;
            }
            this.aRW.unZipFilesPathList = new ArrayList<>();
            this.aRW.unZipFilesPathList.addAll(list);
        }
        return this;
    }
}
