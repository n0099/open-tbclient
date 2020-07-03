package com.baidu.swan.pms.b.b;

import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public class a {
    @NonNull
    public String downloadUrl;
    @NonNull
    public com.baidu.swan.pms.b.b dqk;
    @NonNull
    public String md5;
    public long size;

    public a(@NonNull String str, long j, @NonNull String str2, @NonNull com.baidu.swan.pms.b.b bVar) {
        this.downloadUrl = str;
        this.size = j;
        this.md5 = str2;
        this.dqk = bVar;
    }
}
