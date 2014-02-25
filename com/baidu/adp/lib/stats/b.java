package com.baidu.adp.lib.stats;

import java.io.File;
import java.util.Comparator;
/* loaded from: classes.dex */
class b implements Comparator<File> {
    final /* synthetic */ a a;

    private b(a aVar) {
        this.a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ b(a aVar, b bVar) {
        this(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(File file, File file2) {
        if (file == null && file2 == null) {
            return 0;
        }
        if (file != null || file2 == null) {
            if (file == null || file2 != null) {
                long lastModified = file.lastModified() - file2.lastModified();
                if (lastModified > 0) {
                    return 1;
                }
                return lastModified < 0 ? -1 : 0;
            }
            return -1;
        }
        return 1;
    }
}
