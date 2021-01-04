package com.baidu.swan.pms.model;

import android.text.TextUtils;
import com.baidu.swan.pms.utils.AbiType;
/* loaded from: classes6.dex */
public class i extends e {
    public AbiType ewO;
    public String libName;
    public long maxAge;

    @Override // com.baidu.swan.pms.model.e
    public boolean auV() {
        return (TextUtils.isEmpty(this.ewI) || this.versionCode <= 0 || this.size <= 0 || TextUtils.isEmpty(this.libName) || TextUtils.isEmpty(this.md5) || TextUtils.isEmpty(this.downloadUrl) || this.ewO == null) ? false : true;
    }

    @Override // com.baidu.swan.pms.model.e
    public String toString() {
        return "libName=" + this.libName + ", abi=" + this.ewO + ", maxAge=" + this.maxAge + " " + super.toString();
    }
}
