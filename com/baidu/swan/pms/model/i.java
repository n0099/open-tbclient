package com.baidu.swan.pms.model;

import android.text.TextUtils;
import com.baidu.swan.pms.utils.AbiType;
/* loaded from: classes15.dex */
public class i extends e {
    public String cSs;
    public AbiType ehM;
    public long maxAge;

    @Override // com.baidu.swan.pms.model.e
    public boolean are() {
        return (TextUtils.isEmpty(this.ehG) || this.versionCode <= 0 || this.size <= 0 || TextUtils.isEmpty(this.cSs) || TextUtils.isEmpty(this.md5) || TextUtils.isEmpty(this.downloadUrl) || this.ehM == null) ? false : true;
    }

    @Override // com.baidu.swan.pms.model.e
    public String toString() {
        return "libName=" + this.cSs + ", abi=" + this.ehM + ", maxAge=" + this.maxAge + " " + super.toString();
    }
}
