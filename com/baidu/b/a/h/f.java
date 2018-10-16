package com.baidu.b.a.h;

import android.content.Context;
import java.io.File;
/* loaded from: classes2.dex */
public class f {
    public static File bk(Context context) {
        File dir = context.getDir("aps_dir", 0);
        if (!dir.exists()) {
            dir.mkdir();
        }
        return dir;
    }
}
