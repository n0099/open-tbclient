package com.baidu.adp.plugin.util;

import java.io.File;
import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Comparator<File> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    public int compare(File file, File file2) {
        int I;
        if (file == null || file2 == null) {
            return 0;
        }
        I = a.I(file.getAbsolutePath(), file2.getAbsolutePath());
        return I;
    }
}
