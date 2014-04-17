package com.baidu.adp.lib.stats;

import java.io.File;
import java.io.FilenameFilter;
/* loaded from: classes.dex */
final class d implements FilenameFilter {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return str.endsWith("err");
    }
}
