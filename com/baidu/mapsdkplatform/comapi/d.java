package com.baidu.mapsdkplatform.comapi;

import java.io.File;
import java.io.FilenameFilter;
/* loaded from: classes3.dex */
class d implements FilenameFilter {
    final /* synthetic */ String a;
    final /* synthetic */ NativeLoader b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(NativeLoader nativeLoader, String str) {
        this.b = nativeLoader;
        this.a = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return (str == null || !str.contains("libBaiduMapSDK_") || str.contains(this.a)) ? false : true;
    }
}
