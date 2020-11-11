package com.baidu.mapapi;
/* loaded from: classes7.dex */
public class OpenLogUtil {

    /* renamed from: a  reason: collision with root package name */
    private static ModuleName f1960a;

    public static void setModuleLogEnable(ModuleName moduleName, boolean z) {
        f1960a = moduleName;
        com.baidu.mapsdkplatform.comjni.tools.a.a(z, f1960a.ordinal());
    }
}
