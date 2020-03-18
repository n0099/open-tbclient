package com.baidu.live.entereffect.a;

import android.text.TextUtils;
import com.baidu.live.gift.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public c afq;
    private JSONObject afr;
    public int frameCount;
    public String id;
    public int priority;
    public String url;

    public a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.afr = jSONObject;
        }
    }

    public JSONObject qZ() {
        return this.afr;
    }

    public a c(String str, List<String> list) {
        if (this.afq == null) {
            this.afq = new c();
        }
        this.afq.upZipDirPath = str;
        if (list != null) {
            this.frameCount = list.size();
            if (this.afq.afV != null && this.afq.afV.afU != null) {
                this.afq.afV.afU.frame_count = this.frameCount;
            }
            this.afq.unZipFilesPathList = new ArrayList<>();
            this.afq.unZipFilesPathList.addAll(list);
            if (this.afr != null) {
                try {
                    this.afr.put("frame_count", this.frameCount);
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
