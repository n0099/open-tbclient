package com.baidu.swan.pms.model;

import android.text.TextUtils;
import com.baidu.swan.pms.utils.AbiType;
/* loaded from: classes15.dex */
public class i extends e {
    public String cEd;
    public AbiType dTy;
    public long maxAge;

    @Override // com.baidu.swan.pms.model.e
    public boolean amJ() {
        return (TextUtils.isEmpty(this.dTs) || this.versionCode <= 0 || this.size <= 0 || TextUtils.isEmpty(this.cEd) || TextUtils.isEmpty(this.md5) || TextUtils.isEmpty(this.downloadUrl) || this.dTy == null) ? false : true;
    }

    @Override // com.baidu.swan.pms.model.e
    public String toString() {
        return "libName=" + this.cEd + ", abi=" + this.dTy + ", maxAge=" + this.maxAge + " " + super.toString();
    }
}
