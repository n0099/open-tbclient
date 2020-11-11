package com.baidu.live.entereffect.a;

import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String aTm;
    public long aTn;
    public com.baidu.live.gift.c aTo;
    public boolean aTp;
    public int frameCount;
    public String id;
    public int priority;
    public String videoMd5;
    public String videoUrl;

    public JSONObject Fj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("mp4_file_url", this.videoUrl);
            jSONObject.put("video_md5", this.videoMd5);
            jSONObject.put(FuFaceItem.JK_SO_URL, this.aTm);
            jSONObject.put("frame_count", this.frameCount);
            jSONObject.put("last_accessed", this.aTn);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public a k(String str, String str2, String str3, String str4) {
        this.videoUrl = str;
        this.videoMd5 = str4;
        if (this.aTo == null) {
            this.aTo = new com.baidu.live.gift.c();
        }
        this.aTo.aUf = str2;
        this.aTo.videoPath = str3;
        return this;
    }

    public a b(String str, String str2, List<String> list) {
        this.aTm = str;
        if (this.aTo == null) {
            this.aTo = new com.baidu.live.gift.c();
        }
        this.aTo.upZipDirPath = str2;
        if (list != null) {
            this.frameCount = list.size();
            if (this.aTo.aUe != null && this.aTo.aUe.aUd != null) {
                this.aTo.aUe.aUd.frame_count = this.frameCount;
            }
            this.aTo.unZipFilesPathList = new ArrayList<>();
            this.aTo.unZipFilesPathList.addAll(list);
        }
        return this;
    }
}
