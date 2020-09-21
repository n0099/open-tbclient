package com.baidu.mapapi;
/* loaded from: classes3.dex */
public class OpenLogUtil {
    private static ModuleName a;

    public static void setModuleLogEnable(ModuleName moduleName, boolean z) {
        a = moduleName;
        com.baidu.mapsdkplatform.comjni.tools.a.a(z, a.ordinal());
    }
}
