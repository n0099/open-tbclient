package com.baidu.live.entereffect.a;

import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public String aRi;
    public long aRj;
    public com.baidu.live.gift.c aRk;
    public boolean aRl;
    public int frameCount;
    public String id;
    public int priority;
    public String videoMd5;
    public String videoUrl;

    public JSONObject BJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("mp4_file_url", this.videoUrl);
            jSONObject.put("video_md5", this.videoMd5);
            jSONObject.put(FuFaceItem.JK_SO_URL, this.aRi);
            jSONObject.put("frame_count", this.frameCount);
            jSONObject.put("last_accessed", this.aRj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public a k(String str, String str2, String str3, String str4) {
        this.videoUrl = str;
        this.videoMd5 = str4;
        if (this.aRk == null) {
            this.aRk = new com.baidu.live.gift.c();
        }
        this.aRk.aSp = str2;
        this.aRk.videoPath = str3;
        return this;
    }

    public a b(String str, String str2, List<String> list) {
        this.aRi = str;
        if (this.aRk == null) {
            this.aRk = new com.baidu.live.gift.c();
        }
        this.aRk.upZipDirPath = str2;
        if (list != null) {
            this.frameCount = list.size();
            if (this.aRk.aSo != null && this.aRk.aSo.aSm != null) {
                this.aRk.aSo.aSm.frame_count = this.frameCount;
            }
            this.aRk.unZipFilesPathList = new ArrayList<>();
            this.aRk.unZipFilesPathList.addAll(list);
        }
        return this;
    }
}
