package com.baidu.swan.pms.model;

import android.text.TextUtils;
import com.baidu.swan.pms.utils.AbiType;
/* loaded from: classes6.dex */
public class i extends e {
    public AbiType esb;
    public String libName;
    public long maxAge;

    @Override // com.baidu.swan.pms.model.e
    public boolean arb() {
        return (TextUtils.isEmpty(this.erV) || this.versionCode <= 0 || this.size <= 0 || TextUtils.isEmpty(this.libName) || TextUtils.isEmpty(this.md5) || TextUtils.isEmpty(this.downloadUrl) || this.esb == null) ? false : true;
    }

    @Override // com.baidu.swan.pms.model.e
    public String toString() {
        return "libName=" + this.libName + ", abi=" + this.esb + ", maxAge=" + this.maxAge + " " + super.toString();
    }
}
