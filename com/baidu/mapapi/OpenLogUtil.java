package com.baidu.mapapi;

import com.baidu.mapsdkplatform.comjni.tools.a;
/* loaded from: classes6.dex */
public class OpenLogUtil {

    /* renamed from: a  reason: collision with root package name */
    private static ModuleName f2649a;

    public static void setModuleLogEnable(ModuleName moduleName, boolean z) {
        f2649a = moduleName;
        a.a(z, f2649a.ordinal());
    }
}
