package com.baidu.android.defense.a;

import android.os.Environment;
import java.io.File;
/* loaded from: classes.dex */
public final class a {
    public String a;
    public String b;
    public long c;

    public String a() {
        String str = this.a;
        String substring = str.substring(str.lastIndexOf("/"));
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (!absolutePath.endsWith("/")) {
            absolutePath = absolutePath + "/";
        }
        String str2 = absolutePath + this.b;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdir();
        }
        return str2 + substring;
    }

    public String toString() {
        return "DownloadItem: mDownloadUrl =" + this.a + " mSavePath = " + this.b + " mFileSize =" + this.c;
    }
}
