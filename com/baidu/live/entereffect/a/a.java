package com.baidu.live.entereffect.a;

import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public String aVN;
    public long aVO;
    public com.baidu.live.gift.c aVP;
    public boolean aVQ;
    public int frameCount;
    public String id;
    public int priority;
    public String videoMd5;
    public String videoUrl;

    public JSONObject Db() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put("mp4_file_url", this.videoUrl);
            jSONObject.put("video_md5", this.videoMd5);
            jSONObject.put(FuFaceItem.JK_SO_URL, this.aVN);
            jSONObject.put("frame_count", this.frameCount);
            jSONObject.put("last_accessed", this.aVO);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public a k(String str, String str2, String str3, String str4) {
        this.videoUrl = str;
        this.videoMd5 = str4;
        if (this.aVP == null) {
            this.aVP = new com.baidu.live.gift.c();
        }
        this.aVP.aWT = str2;
        this.aVP.videoPath = str3;
        return this;
    }

    public a b(String str, String str2, List<String> list) {
        this.aVN = str;
        if (this.aVP == null) {
            this.aVP = new com.baidu.live.gift.c();
        }
        this.aVP.upZipDirPath = str2;
        if (list != null) {
            this.frameCount = list.size();
            if (this.aVP.aWS != null && this.aVP.aWS.aWQ != null) {
                this.aVP.aWS.aWQ.frame_count = this.frameCount;
            }
            this.aVP.unZipFilesPathList = new ArrayList<>();
            this.aVP.unZipFilesPathList.addAll(list);
        }
        return this;
    }
}
