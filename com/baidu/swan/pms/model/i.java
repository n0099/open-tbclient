package com.baidu.swan.pms.model;

import android.text.TextUtils;
import com.baidu.swan.pms.utils.AbiType;
/* loaded from: classes15.dex */
public class i extends e {
    public String cMz;
    public AbiType ebU;
    public long maxAge;

    @Override // com.baidu.swan.pms.model.e
    public boolean aoD() {
        return (TextUtils.isEmpty(this.ebO) || this.versionCode <= 0 || this.size <= 0 || TextUtils.isEmpty(this.cMz) || TextUtils.isEmpty(this.md5) || TextUtils.isEmpty(this.downloadUrl) || this.ebU == null) ? false : true;
    }

    @Override // com.baidu.swan.pms.model.e
    public String toString() {
        return "libName=" + this.cMz + ", abi=" + this.ebU + ", maxAge=" + this.maxAge + " " + super.toString();
    }
}
