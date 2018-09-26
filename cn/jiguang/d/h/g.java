package cn.jiguang.d.h;

import java.io.File;
import java.io.FileFilter;
/* loaded from: classes3.dex */
final class g implements FileFilter {
    final /* synthetic */ boolean a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(boolean z) {
        this.a = z;
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return this.a == file.isDirectory();
    }
}
