package com.baidu.mapapi;
/* loaded from: classes3.dex */
public class OpenLogUtil {

    /* renamed from: a  reason: collision with root package name */
    private static ModuleName f2739a;

    public static void setModuleLogEnable(ModuleName moduleName, boolean z) {
        f2739a = moduleName;
        com.baidu.mapsdkplatform.comjni.tools.a.a(z, f2739a.ordinal());
    }
}
