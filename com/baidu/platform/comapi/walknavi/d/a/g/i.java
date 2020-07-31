package com.baidu.platform.comapi.walknavi.d.a.g;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;
/* loaded from: classes10.dex */
class i implements FileFilter {
    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return Pattern.matches("cpu[0-9]", file.getName());
    }
}
