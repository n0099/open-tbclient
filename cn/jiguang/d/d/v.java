package cn.jiguang.d.d;

import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;
/* loaded from: classes3.dex */
final class v implements FileFilter {
    final /* synthetic */ String a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(String str) {
        this.a = str;
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return file.isDirectory() && (TextUtils.isEmpty(this.a) || this.a.equals(file.getName()));
    }
}
