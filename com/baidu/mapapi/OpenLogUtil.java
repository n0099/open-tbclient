package com.baidu.mapapi;
/* loaded from: classes20.dex */
public class OpenLogUtil {
    private static ModuleName a;

    public static void setModuleLogEnable(ModuleName moduleName, boolean z) {
        a = moduleName;
        com.baidu.mapsdkplatform.comjni.tools.a.a(z, a.ordinal());
    }
}
