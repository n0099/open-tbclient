package com.baidu.live.entereffect.a;

import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String aRB;
    public long aRC;
    public com.baidu.live.gift.c aRD;
    public boolean aRE;
    public int frameCount;
    public String id;
    public int priority;
    public String videoMd5;
    public String videoUrl;

    public JSONObject EA() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("mp4_file_url", this.videoUrl);
            jSONObject.put("video_md5", this.videoMd5);
            jSONObject.put(FuFaceItem.JK_SO_URL, this.aRB);
            jSONObject.put("frame_count", this.frameCount);
            jSONObject.put("last_accessed", this.aRC);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public a k(String str, String str2, String str3, String str4) {
        this.videoUrl = str;
        this.videoMd5 = str4;
        if (this.aRD == null) {
            this.aRD = new com.baidu.live.gift.c();
        }
        this.aRD.aSu = str2;
        this.aRD.videoPath = str3;
        return this;
    }

    public a b(String str, String str2, List<String> list) {
        this.aRB = str;
        if (this.aRD == null) {
            this.aRD = new com.baidu.live.gift.c();
        }
        this.aRD.upZipDirPath = str2;
        if (list != null) {
            this.frameCount = list.size();
            if (this.aRD.aSt != null && this.aRD.aSt.aSs != null) {
                this.aRD.aSt.aSs.frame_count = this.frameCount;
            }
            this.aRD.unZipFilesPathList = new ArrayList<>();
            this.aRD.unZipFilesPathList.addAll(list);
        }
        return this;
    }
}
