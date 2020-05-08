package com.baidu.live.entereffect.a;

import android.text.TextUtils;
import com.baidu.live.gift.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public c axN;
    private JSONObject axO;
    public int frameCount;
    public String id;
    public int priority;
    public String url;

    public a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.axO = jSONObject;
        }
    }

    public JSONObject vq() {
        return this.axO;
    }

    public a c(String str, List<String> list) {
        if (this.axN == null) {
            this.axN = new c();
        }
        this.axN.upZipDirPath = str;
        if (list != null) {
            this.frameCount = list.size();
            if (this.axN.ays != null && this.axN.ays.ayr != null) {
                this.axN.ays.ayr.frame_count = this.frameCount;
            }
            this.axN.unZipFilesPathList = new ArrayList<>();
            this.axN.unZipFilesPathList.addAll(list);
            if (this.axO != null) {
                try {
                    this.axO.put("frame_count", this.frameCount);
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
