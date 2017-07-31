package com.baidu.tbadk.core.hybrid.cache;

import android.text.TextUtils;
import com.baidu.tbadk.core.hybrid.r;
import java.io.InputStream;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class CacheEntry implements Serializable {
    private static final long serialVersionUID = -5523550985316702406L;
    private String eTag;
    private boolean forever;
    private InputStream in;
    private String name;
    private long size;
    private String url;
    private long writeTime;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public String geteTag() {
        return this.eTag;
    }

    public void seteTag(String str) {
        this.eTag = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public long getWriteTime() {
        return this.writeTime;
    }

    public void setWriteTime(long j) {
        this.writeTime = j;
    }

    public boolean isForever() {
        return this.forever;
    }

    public void setForever(boolean z) {
        this.forever = z;
    }

    public String toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", this.url);
            jSONObject.put("size", this.size);
            jSONObject.put("eTag", this.eTag);
            jSONObject.put("name", this.name);
            jSONObject.put("writeTime", this.writeTime);
            jSONObject.put("forever", this.forever);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void parse(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.url = jSONObject.optString("url");
            this.size = jSONObject.optLong("size");
            this.eTag = jSONObject.optString("eTag");
            this.name = jSONObject.optString("name");
            this.writeTime = jSONObject.optLong("writeTime");
            this.forever = jSONObject.optBoolean("forever");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public InputStream getInputStream() {
        return this.in;
    }

    public void setInputStream(InputStream inputStream) {
        this.in = inputStream;
    }

    public boolean isValidate(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str) || bArr == null) {
            return false;
        }
        String md5 = r.toMd5(bArr);
        return !TextUtils.isEmpty(md5) && md5.length() > 10 && str.equalsIgnoreCase(md5.substring(0, 10));
    }
}
