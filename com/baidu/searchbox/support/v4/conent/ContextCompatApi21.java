package com.baidu.searchbox.support.v4.conent;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.File;
/* loaded from: classes2.dex */
class ContextCompatApi21 {
    ContextCompatApi21() {
    }

    public static Drawable getDrawable(Context context, int i) {
        return context.getDrawable(i);
    }

    public static File getNoBackupFilesDir(Context context) {
        return context.getNoBackupFilesDir();
    }

    public static File getCodeCacheDir(Context context) {
        return context.getCodeCacheDir();
    }
}
