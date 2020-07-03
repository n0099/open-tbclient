package com.baidu.live.entereffect.a;

import com.baidu.live.gift.c;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public String aFv;
    public c aFw;
    public int frameCount;
    public String id;
    public int priority;
    public String videoMd5;
    public String videoUrl;

    public JSONObject xc() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("mp4_file_url", this.videoUrl);
            jSONObject.put("video_md5", this.videoMd5);
            jSONObject.put(FuFaceItem.JK_SO_URL, this.aFv);
            jSONObject.put("frame_count", this.frameCount);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public a k(String str, String str2, String str3, String str4) {
        this.videoUrl = str;
        this.videoMd5 = str4;
        if (this.aFw == null) {
            this.aFw = new c();
        }
        this.aFw.aGh = str2;
        this.aFw.videoPath = str3;
        return this;
    }

    public a b(String str, String str2, List<String> list) {
        this.aFv = str;
        if (this.aFw == null) {
            this.aFw = new c();
        }
        this.aFw.upZipDirPath = str2;
        if (list != null) {
            this.frameCount = list.size();
            if (this.aFw.aGg != null && this.aFw.aGg.aGf != null) {
                this.aFw.aGg.aGf.frame_count = this.frameCount;
            }
            this.aFw.unZipFilesPathList = new ArrayList<>();
            this.aFw.unZipFilesPathList.addAll(list);
        }
        return this;
    }
}
