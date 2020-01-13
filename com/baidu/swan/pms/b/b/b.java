package com.baidu.swan.pms.b.b;

import android.support.annotation.NonNull;
/* loaded from: classes10.dex */
public class b {
    @NonNull
    public String filePath;
    @NonNull
    public String msg;
    public int statusCode;

    public b(int i, @NonNull String str) {
        this.filePath = "";
        this.statusCode = i;
        this.msg = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i, @NonNull String str, @NonNull String str2) {
        this.filePath = "";
        this.statusCode = i;
        this.msg = str;
        this.filePath = str2;
    }

    public boolean isSuccess() {
        return this.statusCode == 0;
    }

    public String toString() {
        return "DownloadResponse{statusCode=" + this.statusCode + ", msg='" + this.msg + "', filePath='" + this.filePath + "'}";
    }
}
