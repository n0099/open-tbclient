package com.baidu.mapapi;
/* loaded from: classes15.dex */
public class OpenLogUtil {

    /* renamed from: a  reason: collision with root package name */
    private static ModuleName f2738a;

    public static void setModuleLogEnable(ModuleName moduleName, boolean z) {
        f2738a = moduleName;
        com.baidu.mapsdkplatform.comjni.tools.a.a(z, f2738a.ordinal());
    }
}
