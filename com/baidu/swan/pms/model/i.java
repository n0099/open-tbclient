package com.baidu.swan.pms.model;

import android.text.TextUtils;
import com.baidu.swan.pms.utils.AbiType;
/* loaded from: classes24.dex */
public class i extends e {
    public String crS;
    public AbiType dHx;
    public long maxAge;

    @Override // com.baidu.swan.pms.model.e
    public boolean ajY() {
        return (TextUtils.isEmpty(this.dHr) || this.versionCode <= 0 || this.size <= 0 || TextUtils.isEmpty(this.crS) || TextUtils.isEmpty(this.md5) || TextUtils.isEmpty(this.downloadUrl) || this.dHx == null) ? false : true;
    }

    @Override // com.baidu.swan.pms.model.e
    public String toString() {
        return "libName=" + this.crS + ", abi=" + this.dHx + ", maxAge=" + this.maxAge + " " + super.toString();
    }
}
