package com.baidu.swan.pms.model;

import android.text.TextUtils;
import com.baidu.swan.pms.utils.AbiType;
/* loaded from: classes6.dex */
public class i extends e {
    public String cXB;
    public AbiType eng;
    public long maxAge;

    @Override // com.baidu.swan.pms.model.e
    public boolean atE() {
        return (TextUtils.isEmpty(this.emZ) || this.versionCode <= 0 || this.size <= 0 || TextUtils.isEmpty(this.cXB) || TextUtils.isEmpty(this.md5) || TextUtils.isEmpty(this.downloadUrl) || this.eng == null) ? false : true;
    }

    @Override // com.baidu.swan.pms.model.e
    public String toString() {
        return "libName=" + this.cXB + ", abi=" + this.eng + ", maxAge=" + this.maxAge + " " + super.toString();
    }
}
