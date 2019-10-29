package com.baidu.live.entereffect.a;

import android.text.TextUtils;
import com.baidu.live.gift.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public c VG;
    private JSONObject VH;
    public int frameCount;
    public String id;
    public int priority;
    public String url;

    public a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.VH = jSONObject;
        }
    }

    public JSONObject oI() {
        return this.VH;
    }

    public a c(String str, List<String> list) {
        if (this.VG == null) {
            this.VG = new c();
        }
        this.VG.upZipDirPath = str;
        if (list != null) {
            this.frameCount = list.size();
            if (this.VG.Wm != null && this.VG.Wm.Wl != null) {
                this.VG.Wm.Wl.frame_count = this.frameCount;
            }
            this.VG.unZipFilesPathList = new ArrayList<>();
            this.VG.unZipFilesPathList.addAll(list);
            if (this.VH != null) {
                try {
                    this.VH.put("frame_count", this.frameCount);
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
