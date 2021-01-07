package com.baidu.mapsdkplatform.comapi;

import java.io.File;
import java.io.FilenameFilter;
/* loaded from: classes3.dex */
class d implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3155a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ NativeLoader f3156b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NativeLoader nativeLoader, String str) {
        this.f3156b = nativeLoader;
        this.f3155a = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return (str == null || !str.contains("libBaiduMapSDK_") || str.contains(this.f3155a)) ? false : true;
    }
}
