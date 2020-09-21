package com.baidu.live.entereffect.a;

import com.baidu.live.gift.c;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String aNU;
    public c aNV;
    public int frameCount;
    public String id;
    public int priority;
    public String videoMd5;
    public String videoUrl;

    public JSONObject Dy() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("mp4_file_url", this.videoUrl);
            jSONObject.put("video_md5", this.videoMd5);
            jSONObject.put(FuFaceItem.JK_SO_URL, this.aNU);
            jSONObject.put("frame_count", this.frameCount);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public a k(String str, String str2, String str3, String str4) {
        this.videoUrl = str;
        this.videoMd5 = str4;
        if (this.aNV == null) {
            this.aNV = new c();
        }
        this.aNV.aOG = str2;
        this.aNV.videoPath = str3;
        return this;
    }

    public a b(String str, String str2, List<String> list) {
        this.aNU = str;
        if (this.aNV == null) {
            this.aNV = new c();
        }
        this.aNV.upZipDirPath = str2;
        if (list != null) {
            this.frameCount = list.size();
            if (this.aNV.aOF != null && this.aNV.aOF.aOE != null) {
                this.aNV.aOF.aOE.frame_count = this.frameCount;
            }
            this.aNV.unZipFilesPathList = new ArrayList<>();
            this.aNV.unZipFilesPathList.addAll(list);
        }
        return this;
    }
}
