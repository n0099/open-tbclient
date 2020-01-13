package com.baidu.live.entereffect.a;

import android.text.TextUtils;
import com.baidu.live.gift.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public c ade;
    private JSONObject adf;
    public int frameCount;
    public String id;
    public int priority;
    public String url;

    public a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.adf = jSONObject;
        }
    }

    public JSONObject qj() {
        return this.adf;
    }

    public a b(String str, List<String> list) {
        if (this.ade == null) {
            this.ade = new c();
        }
        this.ade.upZipDirPath = str;
        if (list != null) {
            this.frameCount = list.size();
            if (this.ade.adJ != null && this.ade.adJ.adI != null) {
                this.ade.adJ.adI.frame_count = this.frameCount;
            }
            this.ade.unZipFilesPathList = new ArrayList<>();
            this.ade.unZipFilesPathList.addAll(list);
            if (this.adf != null) {
                try {
                    this.adf.put("frame_count", this.frameCount);
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
