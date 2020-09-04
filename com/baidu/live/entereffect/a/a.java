package com.baidu.live.entereffect.a;

import com.baidu.live.gift.c;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public String aMc;
    public c aMd;
    public int frameCount;
    public String id;
    public int priority;
    public String videoMd5;
    public String videoUrl;

    public JSONObject Di() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("mp4_file_url", this.videoUrl);
            jSONObject.put("video_md5", this.videoMd5);
            jSONObject.put(FuFaceItem.JK_SO_URL, this.aMc);
            jSONObject.put("frame_count", this.frameCount);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public a k(String str, String str2, String str3, String str4) {
        this.videoUrl = str;
        this.videoMd5 = str4;
        if (this.aMd == null) {
            this.aMd = new c();
        }
        this.aMd.aMO = str2;
        this.aMd.videoPath = str3;
        return this;
    }

    public a b(String str, String str2, List<String> list) {
        this.aMc = str;
        if (this.aMd == null) {
            this.aMd = new c();
        }
        this.aMd.upZipDirPath = str2;
        if (list != null) {
            this.frameCount = list.size();
            if (this.aMd.aMN != null && this.aMd.aMN.aMM != null) {
                this.aMd.aMN.aMM.frame_count = this.frameCount;
            }
            this.aMd.unZipFilesPathList = new ArrayList<>();
            this.aMd.unZipFilesPathList.addAll(list);
        }
        return this;
    }
}
