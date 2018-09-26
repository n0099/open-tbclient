package cn.jiguang.d.d;

import java.io.File;
import java.io.FileFilter;
/* loaded from: classes3.dex */
final class t implements FileFilter {
    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return file.isDirectory() && file.getName().startsWith("jpush_stat_history");
    }
}
