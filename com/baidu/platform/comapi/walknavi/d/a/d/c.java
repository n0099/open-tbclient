package com.baidu.platform.comapi.walknavi.d.a.d;

import com.baidu.adp.plugin.install.PluginInstallerService;
import java.io.File;
import java.io.FileFilter;
/* loaded from: classes6.dex */
class c implements FileFilter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f4222a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f4222a = bVar;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return file.getName().endsWith(PluginInstallerService.APK_LIB_SUFFIX);
    }
}
