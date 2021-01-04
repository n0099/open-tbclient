package com.baidu.minivideo.plugin.capture;

import android.content.Context;
/* loaded from: classes3.dex */
public class Application {
    public static Context sInstance;

    public static Context get() {
        return sInstance;
    }

    public static void set(Context context) {
        sInstance = context;
    }
}
