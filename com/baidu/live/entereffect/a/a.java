package com.baidu.live.entereffect.a;

import com.baidu.live.gift.c;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String aRf;
    public c aRg;
    public int frameCount;
    public String id;
    public int priority;
    public String videoMd5;
    public String videoUrl;

    public JSONObject Ev() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("mp4_file_url", this.videoUrl);
            jSONObject.put("video_md5", this.videoMd5);
            jSONObject.put(FuFaceItem.JK_SO_URL, this.aRf);
            jSONObject.put("frame_count", this.frameCount);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public a k(String str, String str2, String str3, String str4) {
        this.videoUrl = str;
        this.videoMd5 = str4;
        if (this.aRg == null) {
            this.aRg = new c();
        }
        this.aRg.aRR = str2;
        this.aRg.videoPath = str3;
        return this;
    }

    public a b(String str, String str2, List<String> list) {
        this.aRf = str;
        if (this.aRg == null) {
            this.aRg = new c();
        }
        this.aRg.upZipDirPath = str2;
        if (list != null) {
            this.frameCount = list.size();
            if (this.aRg.aRQ != null && this.aRg.aRQ.aRP != null) {
                this.aRg.aRQ.aRP.frame_count = this.frameCount;
            }
            this.aRg.unZipFilesPathList = new ArrayList<>();
            this.aRg.unZipFilesPathList.addAll(list);
        }
        return this;
    }
}
