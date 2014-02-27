package com.baidu.adp.lib.stats;

import java.io.File;
import java.util.Comparator;
/* loaded from: classes.dex */
final class b implements Comparator<File> {
    final /* synthetic */ a a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(File file, File file2) {
        File file3 = file;
        File file4 = file2;
        if (file3 != null || file4 != null) {
            if (file3 == null && file4 != null) {
                return 1;
            }
            if (file3 != null && file4 == null) {
                return -1;
            }
            long lastModified = file3.lastModified() - file4.lastModified();
            if (lastModified > 0) {
                return 1;
            }
            if (lastModified < 0) {
                return -1;
            }
        }
        return 0;
    }

    private b(a aVar) {
        this.a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(a aVar, byte b) {
        this(aVar);
    }
}
