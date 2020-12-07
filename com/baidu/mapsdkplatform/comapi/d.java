package com.baidu.mapsdkplatform.comapi;

import java.io.File;
import java.io.FilenameFilter;
/* loaded from: classes26.dex */
class d implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2216a;
    final /* synthetic */ NativeLoader b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NativeLoader nativeLoader, String str) {
        this.b = nativeLoader;
        this.f2216a = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return (str == null || !str.contains("libBaiduMapSDK_") || str.contains(this.f2216a)) ? false : true;
    }
}
