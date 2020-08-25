package com.baidu.swan.pms.model;

import android.text.TextUtils;
import com.baidu.swan.pms.utils.AbiType;
/* loaded from: classes14.dex */
public class i extends e {
    public String cpL;
    public AbiType dFp;
    public long maxAge;

    @Override // com.baidu.swan.pms.model.e
    public boolean ajo() {
        return (TextUtils.isEmpty(this.dFj) || this.versionCode <= 0 || this.size <= 0 || TextUtils.isEmpty(this.cpL) || TextUtils.isEmpty(this.md5) || TextUtils.isEmpty(this.downloadUrl) || this.dFp == null) ? false : true;
    }

    @Override // com.baidu.swan.pms.model.e
    public String toString() {
        return "libName=" + this.cpL + ", abi=" + this.dFp + ", maxAge=" + this.maxAge + " " + super.toString();
    }
}
