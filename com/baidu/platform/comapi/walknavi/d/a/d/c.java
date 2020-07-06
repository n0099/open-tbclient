package com.baidu.platform.comapi.walknavi.d.a.d;

import com.baidu.adp.plugin.install.PluginInstallerService;
import java.io.File;
import java.io.FileFilter;
/* loaded from: classes8.dex */
class c implements FileFilter {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return file.getName().endsWith(PluginInstallerService.APK_LIB_SUFFIX);
    }
}
