package com.baidu.live.entereffect.a;

import android.text.TextUtils;
import com.baidu.live.gift.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public c afg;
    private JSONObject afh;
    public int frameCount;
    public String id;
    public int priority;
    public String url;

    public a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.afh = jSONObject;
        }
    }

    public JSONObject qU() {
        return this.afh;
    }

    public a c(String str, List<String> list) {
        if (this.afg == null) {
            this.afg = new c();
        }
        this.afg.upZipDirPath = str;
        if (list != null) {
            this.frameCount = list.size();
            if (this.afg.afL != null && this.afg.afL.afK != null) {
                this.afg.afL.afK.frame_count = this.frameCount;
            }
            this.afg.unZipFilesPathList = new ArrayList<>();
            this.afg.unZipFilesPathList.addAll(list);
            if (this.afh != null) {
                try {
                    this.afh.put("frame_count", this.frameCount);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass() || TextUtils.isEmpty(this.id) || TextUtils.isEmpty(this.url)) {
            return false;
        }
        a aVar = (a) obj;
        if (!this.id.equals(aVar.id) || !this.url.equals(aVar.url)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((this.id != null ? this.id.hashCode() : 0) + 629) * 37) + (this.url != null ? this.url.hashCode() : 0);
    }
}
