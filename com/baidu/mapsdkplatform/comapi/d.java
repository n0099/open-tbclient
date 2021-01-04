package com.baidu.mapsdkplatform.comapi;

import java.io.File;
import java.io.FilenameFilter;
/* loaded from: classes15.dex */
class d implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3154a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ NativeLoader f3155b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NativeLoader nativeLoader, String str) {
        this.f3155b = nativeLoader;
        this.f3154a = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return (str == null || !str.contains("libBaiduMapSDK_") || str.contains(this.f3154a)) ? false : true;
    }
}
