package com.baidu.adp.lib.stats;

import java.io.File;
import java.io.FilenameFilter;
/* loaded from: classes.dex */
final class g implements FilenameFilter {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.a = fVar;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return str.endsWith("stat");
    }
}
