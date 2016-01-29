package com.baidu.adp.plugin;
/* loaded from: classes.dex */
public class PluginNative {
    public static boolean bLoadLibrary;

    public static native boolean hookdvmResolveClass();

    static {
        bLoadLibrary = false;
        bLoadLibrary = com.baidu.adp.lib.util.g.iL().i("pluginhook", 2);
    }
}
