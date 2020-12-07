package com.baidu.mapapi;
/* loaded from: classes26.dex */
public class OpenLogUtil {

    /* renamed from: a  reason: collision with root package name */
    private static ModuleName f1962a;

    public static void setModuleLogEnable(ModuleName moduleName, boolean z) {
        f1962a = moduleName;
        com.baidu.mapsdkplatform.comjni.tools.a.a(z, f1962a.ordinal());
    }
}
