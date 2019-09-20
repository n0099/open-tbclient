package com.baidu.swan.pms.model;

import android.text.TextUtils;
import java.util.Objects;
/* loaded from: classes2.dex */
public class e extends c {
    public int avC;
    public String btp;
    public String downloadUrl;
    public String md5;
    public String sign;
    public long size;
    public int versionCode;
    public String versionName;

    public boolean Ws() {
        return (TextUtils.isEmpty(this.btp) || this.versionCode <= 0 || this.size <= 0 || TextUtils.isEmpty(this.md5) || TextUtils.isEmpty(this.sign) || TextUtils.isEmpty(this.downloadUrl)) ? false : true;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj != null && (obj instanceof e)) {
            e eVar = (e) obj;
            return (TextUtils.isEmpty(this.versionName) && TextUtils.isEmpty(eVar.versionName)) ? this.btp.equals(eVar.btp) && this.versionCode == eVar.versionCode : TextUtils.equals(this.btp, eVar.btp) && this.versionCode == eVar.versionCode && TextUtils.equals(this.versionName, eVar.versionName);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.btp, Integer.valueOf(this.avC), Integer.valueOf(this.versionCode), this.versionName);
    }

    public String toString() {
        return "bundleId=" + this.btp + ",category=" + this.avC + ",versionCode=" + this.versionCode + ",versionName=" + this.versionName + ",size=" + this.size + ",md5=" + this.md5 + ",sign=" + this.sign + ",downloadUrl" + this.downloadUrl;
    }
}
