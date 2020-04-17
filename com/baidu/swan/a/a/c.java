package com.baidu.swan.a.a;

import android.text.TextUtils;
import com.baidu.swan.pms.model.e;
/* loaded from: classes11.dex */
public class c extends e {
    @Override // com.baidu.swan.pms.model.e
    public boolean XM() {
        return (TextUtils.isEmpty(this.dai) || this.versionCode <= 0 || this.size <= 0 || TextUtils.isEmpty(this.md5) || TextUtils.isEmpty(this.downloadUrl)) ? false : true;
    }
}
