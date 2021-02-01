package com.baidu.swan.pms.model;

import android.text.TextUtils;
import com.baidu.swan.pms.utils.AbiType;
/* loaded from: classes3.dex */
public class i extends e {
    public AbiType eui;
    public String libName;
    public long maxAge;

    @Override // com.baidu.swan.pms.model.e
    public boolean arz() {
        return (TextUtils.isEmpty(this.euc) || this.versionCode <= 0 || this.size <= 0 || TextUtils.isEmpty(this.libName) || TextUtils.isEmpty(this.md5) || TextUtils.isEmpty(this.downloadUrl) || this.eui == null) ? false : true;
    }

    @Override // com.baidu.swan.pms.model.e
    public String toString() {
        return "libName=" + this.libName + ", abi=" + this.eui + ", maxAge=" + this.maxAge + " " + super.toString();
    }
}
