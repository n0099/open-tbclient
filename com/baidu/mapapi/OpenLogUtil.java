package com.baidu.mapapi;

import com.baidu.mapsdkplatform.comjni.tools.a;
/* loaded from: classes4.dex */
public class OpenLogUtil {

    /* renamed from: a  reason: collision with root package name */
    private static ModuleName f1977a;

    public static void setModuleLogEnable(ModuleName moduleName, boolean z) {
        f1977a = moduleName;
        a.a(z, f1977a.ordinal());
    }
}
