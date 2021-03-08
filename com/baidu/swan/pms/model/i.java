package com.baidu.swan.pms.model;

import android.text.TextUtils;
import com.baidu.swan.pms.utils.AbiType;
/* loaded from: classes3.dex */
public class i extends e {
    public String dbu;
    public AbiType evJ;
    public long maxAge;

    @Override // com.baidu.swan.pms.model.e
    public boolean arC() {
        return (TextUtils.isEmpty(this.evD) || this.versionCode <= 0 || this.size <= 0 || TextUtils.isEmpty(this.dbu) || TextUtils.isEmpty(this.md5) || TextUtils.isEmpty(this.downloadUrl) || this.evJ == null) ? false : true;
    }

    @Override // com.baidu.swan.pms.model.e
    public String toString() {
        return "libName=" + this.dbu + ", abi=" + this.evJ + ", maxAge=" + this.maxAge + " " + super.toString();
    }
}
