package com.baidu.adp.plugin.util;

import java.io.File;
import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Comparator<File> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: b */
    public int compare(File file, File file2) {
        int P;
        if (file == null || file2 == null) {
            return 0;
        }
        P = a.P(file.getAbsolutePath(), file2.getAbsolutePath());
        return P;
    }
}
