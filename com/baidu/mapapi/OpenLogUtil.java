package com.baidu.mapapi;
/* loaded from: classes2.dex */
public class OpenLogUtil {

    /* renamed from: a  reason: collision with root package name */
    public static ModuleName f6775a;

    public static void setModuleLogEnable(ModuleName moduleName, boolean z) {
        f6775a = moduleName;
        com.baidu.mapsdkplatform.comjni.tools.a.a(z, moduleName.ordinal());
    }
}
