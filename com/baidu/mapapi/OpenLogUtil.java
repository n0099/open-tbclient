package com.baidu.mapapi;

import com.baidu.mapsdkplatform.comjni.tools.a;
/* loaded from: classes2.dex */
public class OpenLogUtil {

    /* renamed from: a  reason: collision with root package name */
    public static ModuleName f6762a;

    public static void setModuleLogEnable(ModuleName moduleName, boolean z) {
        f6762a = moduleName;
        a.a(z, moduleName.ordinal());
    }
}
