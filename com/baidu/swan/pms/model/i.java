package com.baidu.swan.pms.model;

import android.text.TextUtils;
import com.baidu.swan.pms.utils.AbiType;
/* loaded from: classes14.dex */
public class i extends e {
    public String cpP;
    public AbiType dFt;
    public long maxAge;

    @Override // com.baidu.swan.pms.model.e
    public boolean ajo() {
        return (TextUtils.isEmpty(this.dFn) || this.versionCode <= 0 || this.size <= 0 || TextUtils.isEmpty(this.cpP) || TextUtils.isEmpty(this.md5) || TextUtils.isEmpty(this.downloadUrl) || this.dFt == null) ? false : true;
    }

    @Override // com.baidu.swan.pms.model.e
    public String toString() {
        return "libName=" + this.cpP + ", abi=" + this.dFt + ", maxAge=" + this.maxAge + " " + super.toString();
    }
}
