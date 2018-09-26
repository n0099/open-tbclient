package cn.jpush.android.d;

import java.io.File;
import java.util.Comparator;
/* loaded from: classes3.dex */
final class d implements Comparator<File> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(File file, File file2) {
        File file3 = file;
        File file4 = file2;
        if (file3.lastModified() > file4.lastModified()) {
            return -1;
        }
        return file3.lastModified() < file4.lastModified() ? 1 : 0;
    }
}
