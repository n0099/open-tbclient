package com.baidu.live.entereffect.a;

import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public String aUn;
    public long aUo;
    public com.baidu.live.gift.c aUp;
    public boolean aUq;
    public int frameCount;
    public String id;
    public int priority;
    public String videoMd5;
    public String videoUrl;

    public JSONObject CY() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("mp4_file_url", this.videoUrl);
            jSONObject.put("video_md5", this.videoMd5);
            jSONObject.put(FuFaceItem.JK_SO_URL, this.aUn);
            jSONObject.put("frame_count", this.frameCount);
            jSONObject.put("last_accessed", this.aUo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public a k(String str, String str2, String str3, String str4) {
        this.videoUrl = str;
        this.videoMd5 = str4;
        if (this.aUp == null) {
            this.aUp = new com.baidu.live.gift.c();
        }
        this.aUp.aVt = str2;
        this.aUp.videoPath = str3;
        return this;
    }

    public a b(String str, String str2, List<String> list) {
        this.aUn = str;
        if (this.aUp == null) {
            this.aUp = new com.baidu.live.gift.c();
        }
        this.aUp.upZipDirPath = str2;
        if (list != null) {
            this.frameCount = list.size();
            if (this.aUp.aVs != null && this.aUp.aVs.aVq != null) {
                this.aUp.aVs.aVq.frame_count = this.frameCount;
            }
            this.aUp.unZipFilesPathList = new ArrayList<>();
            this.aUp.unZipFilesPathList.addAll(list);
        }
        return this;
    }
}
