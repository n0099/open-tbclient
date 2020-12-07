package com.baidu.live.entereffect.a;

import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String aUD;
    public long aUE;
    public com.baidu.live.gift.c aUF;
    public boolean aUG;
    public int frameCount;
    public String id;
    public int priority;
    public String videoMd5;
    public String videoUrl;

    public JSONObject Gl() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("mp4_file_url", this.videoUrl);
            jSONObject.put("video_md5", this.videoMd5);
            jSONObject.put(FuFaceItem.JK_SO_URL, this.aUD);
            jSONObject.put("frame_count", this.frameCount);
            jSONObject.put("last_accessed", this.aUE);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public a k(String str, String str2, String str3, String str4) {
        this.videoUrl = str;
        this.videoMd5 = str4;
        if (this.aUF == null) {
            this.aUF = new com.baidu.live.gift.c();
        }
        this.aUF.aVw = str2;
        this.aUF.videoPath = str3;
        return this;
    }

    public a b(String str, String str2, List<String> list) {
        this.aUD = str;
        if (this.aUF == null) {
            this.aUF = new com.baidu.live.gift.c();
        }
        this.aUF.upZipDirPath = str2;
        if (list != null) {
            this.frameCount = list.size();
            if (this.aUF.aVv != null && this.aUF.aVv.aVu != null) {
                this.aUF.aVv.aVu.frame_count = this.frameCount;
            }
            this.aUF.unZipFilesPathList = new ArrayList<>();
            this.aUF.unZipFilesPathList.addAll(list);
        }
        return this;
    }
}
