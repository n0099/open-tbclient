package com.baidu.b.a.c.a;

import com.baidu.ar.parser.ARResourceKey;
import com.baidu.searchbox.NoProGuard;
import com.baidu.webkit.internal.ETAG;
import com.google.gson.a.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements NoProGuard {
    @c("ext")
    public String ZA;
    @c("wifi")
    public int ZB;
    public int ZC;
    public String ZD;
    @c("tipmsg")
    public String Zv;
    @c("host_min_version")
    public String Zy;
    @c("host_max_version")
    public String Zz;
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
    public long Zw = -1;
    @c("update_v")
    public long Zx = 0;
    @c("rollback")
    public int rollback = 0;
    @c("errno")
    public int KI = -1;
    public int type = 0;
    public String filePath = "";
    public byte[] fileData = null;
    public int ZE = 0;
    public long ZF = 0;
    public long ZG = 0;
    public long createTime = 0;
    public long updateTime = 0;
    public long ZH = 0;

    public boolean a(a aVar) {
        return this.Zw < aVar.Zw;
    }

    public void b(a aVar) {
        aVar.ZD = this.ZD;
        aVar.ZC = this.ZC;
        aVar.channelId = this.channelId;
        aVar.channelName = this.channelName;
        aVar.Zw = this.Zw;
        aVar.Zx = this.Zx;
        aVar.Zy = this.Zy;
        aVar.Zz = this.Zz;
        aVar.ZA = this.ZA;
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
        return this.packageName.equals(aVar.packageName) && this.Zw == aVar.Zw && this.md5.equals(aVar.md5);
    }

    public String toJSONString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ETAG.KEY_PACKAGE_NAME, this.packageName == null ? "" : this.packageName);
            jSONObject.put("name", this.name == null ? "" : this.name);
            jSONObject.put("version", this.Zw);
            jSONObject.put("udpate_v", this.Zx);
            jSONObject.put("download_url", this.downloadUrl == null ? "" : this.downloadUrl);
            jSONObject.put(ARResourceKey.HTTP_AR_MD5, this.md5 == null ? "" : this.md5);
            jSONObject.put("package_size", this.size == null ? "" : this.size);
            jSONObject.put("host_min_version", this.Zy == null ? "" : this.Zy);
            jSONObject.put("host_max_version", this.Zz == null ? "" : this.Zz);
            jSONObject.put("ext", this.ZA == null ? "" : this.ZA);
            jSONObject.put("wifi", this.ZB);
            jSONObject.put("rollback", this.rollback);
            jSONObject.put("errno", this.KI);
            jSONObject.put("errmsg", this.errMsg == null ? "" : this.errMsg);
            jSONObject.put("tipmsg", this.Zv == null ? "" : this.Zv);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("packageName:" + this.packageName);
        sb.append(",name:" + this.name);
        sb.append(",version:" + this.Zw);
        sb.append(",updateVersion:" + this.Zx);
        sb.append(",downloadUrl:" + this.downloadUrl);
        sb.append(",md5:" + this.md5);
        sb.append(",size:" + this.size);
        sb.append(",minHostVersion:" + this.Zy);
        sb.append(",maxHostVersion:" + this.Zz);
        sb.append(",wifi:" + this.ZB);
        sb.append(",rollback:" + this.rollback);
        sb.append(",errNo:" + this.KI);
        sb.append(",errMsg:" + this.errMsg);
        sb.append(",tipMsg:" + this.Zv);
        sb.append(",channelId:" + this.channelId);
        sb.append(",channelName:" + this.channelName);
        sb.append(",downloadOption:" + this.ZC);
        sb.append(",extraLocal:" + this.ZD);
        sb.append(",type:" + this.type);
        sb.append(",filePath:" + this.filePath);
        sb.append(",fileData:" + this.fileData);
        sb.append(",fileSaveType:" + this.ZE);
        sb.append(",totalSize:" + this.ZF);
        sb.append(",currentSize:" + this.ZG);
        sb.append(",createTime:" + this.createTime);
        sb.append(",updateTime:" + this.updateTime);
        sb.append(",rawid:" + this.ZH);
        return sb.toString();
    }
}
