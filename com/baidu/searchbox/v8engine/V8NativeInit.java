package com.baidu.searchbox.v8engine;

import android.content.Context;
import android.content.res.AssetManager;
@NotProguard
/* loaded from: classes3.dex */
public class V8NativeInit {
    private static native void initAppContext(Context context);

    private static native void initClassLoader(Object obj);

    public static native synchronized void initialize(long j, AssetManager assetManager, AssetManager assetManager2, V8Timer v8Timer, Object obj, long j2);

    static {
        initAppContext(V8Engine.getAppContext());
        initClassLoader(V8NativeInit.class.getClassLoader());
    }

    public static void initEnv() {
    }
}
