package com.baidu.swan.pms.model;

import android.text.TextUtils;
import com.baidu.swan.pms.utils.AbiType;
/* loaded from: classes6.dex */
public class i extends e {
    public String cQI;
    public AbiType ege;
    public long maxAge;

    @Override // com.baidu.swan.pms.model.e
    public boolean aqw() {
        return (TextUtils.isEmpty(this.efY) || this.versionCode <= 0 || this.size <= 0 || TextUtils.isEmpty(this.cQI) || TextUtils.isEmpty(this.md5) || TextUtils.isEmpty(this.downloadUrl) || this.ege == null) ? false : true;
    }

    @Override // com.baidu.swan.pms.model.e
    public String toString() {
        return "libName=" + this.cQI + ", abi=" + this.ege + ", maxAge=" + this.maxAge + " " + super.toString();
    }
}
