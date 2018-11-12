package com.baidu.b.a.c.a;

import com.baidu.ar.parser.ARResourceKey;
import com.baidu.searchbox.NoProGuard;
import com.baidu.webkit.internal.ETAG;
import com.google.gson.a.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements NoProGuard {
    @c("tipmsg")
    public String Zm;
    @c("host_min_version")
    public String Zp;
    @c("host_max_version")
    public String Zq;
    @c("ext")
    public String Zr;
    @c("wifi")
    public int Zs;
    public int Zt;
    public String Zu;
    public String channelId;
    public String channelName;
    @c("download_url")
    public String downloadUrl;
    @c("errmsg")
    public String errMsg;
    @c(ARResourceKey.HTTP_AR_MD5)
    public String md5;
    @c("name")
    public String name;
    @c(ETAG.KEY_PACKAGE_NAME)
    public String packageName;
    @c("package_size")
    public String size;
    @c("version")
    public long Zn = -1;
    @c("update_v")
    public long Zo = 0;
    @c("rollback")
    public int rollback = 0;
    @c("errno")
    public int KC = -1;
    public int type = 0;
    public String filePath = "";
    public byte[] fileData = null;
    public int Zv = 0;
    public long Zw = 0;
    public long Zx = 0;
    public long createTime = 0;
    public long updateTime = 0;
    public long Zy = 0;

    public boolean a(a aVar) {
        return this.Zn < aVar.Zn;
    }

    public void b(a aVar) {
        aVar.Zu = this.Zu;
        aVar.Zt = this.Zt;
        aVar.channelId = this.channelId;
        aVar.channelName = this.channelName;
        aVar.Zn = this.Zn;
        aVar.Zo = this.Zo;
        aVar.Zp = this.Zp;
        aVar.Zq = this.Zq;
        aVar.Zr = this.Zr;
        aVar.downloadUrl = this.downloadUrl;
        aVar.packageName = this.packageName;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof a)) {
            return c((a) obj);
        }
        return false;
    }

    public boolean c(a aVar) {
        return this.packageName.equals(aVar.packageName) && this.Zn == aVar.Zn && this.md5.equals(aVar.md5);
    }

    public String toJSONString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ETAG.KEY_PACKAGE_NAME, this.packageName == null ? "" : this.packageName);
            jSONObject.put("name", this.name == null ? "" : this.name);
            jSONObject.put("version", this.Zn);
            jSONObject.put("udpate_v", this.Zo);
            jSONObject.put("download_url", this.downloadUrl == null ? "" : this.downloadUrl);
            jSONObject.put(ARResourceKey.HTTP_AR_MD5, this.md5 == null ? "" : this.md5);
            jSONObject.put("package_size", this.size == null ? "" : this.size);
            jSONObject.put("host_min_version", this.Zp == null ? "" : this.Zp);
            jSONObject.put("host_max_version", this.Zq == null ? "" : this.Zq);
            jSONObject.put("ext", this.Zr == null ? "" : this.Zr);
            jSONObject.put("wifi", this.Zs);
            jSONObject.put("rollback", this.rollback);
            jSONObject.put("errno", this.KC);
            jSONObject.put("errmsg", this.errMsg == null ? "" : this.errMsg);
            jSONObject.put("tipmsg", this.Zm == null ? "" : this.Zm);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("packageName:" + this.packageName);
        sb.append(",name:" + this.name);
        sb.append(",version:" + this.Zn);
        sb.append(",updateVersion:" + this.Zo);
        sb.append(",downloadUrl:" + this.downloadUrl);
        sb.append(",md5:" + this.md5);
        sb.append(",size:" + this.size);
        sb.append(",minHostVersion:" + this.Zp);
        sb.append(",maxHostVersion:" + this.Zq);
        sb.append(",wifi:" + this.Zs);
        sb.append(",rollback:" + this.rollback);
        sb.append(",errNo:" + this.KC);
        sb.append(",errMsg:" + this.errMsg);
        sb.append(",tipMsg:" + this.Zm);
        sb.append(",channelId:" + this.channelId);
        sb.append(",channelName:" + this.channelName);
        sb.append(",downloadOption:" + this.Zt);
        sb.append(",extraLocal:" + this.Zu);
        sb.append(",type:" + this.type);
        sb.append(",filePath:" + this.filePath);
        sb.append(",fileData:" + this.fileData);
        sb.append(",fileSaveType:" + this.Zv);
        sb.append(",totalSize:" + this.Zw);
        sb.append(",currentSize:" + this.Zx);
        sb.append(",createTime:" + this.createTime);
        sb.append(",updateTime:" + this.updateTime);
        sb.append(",rawid:" + this.Zy);
        return sb.toString();
    }
}
