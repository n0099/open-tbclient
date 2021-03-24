package com.baidu.platform.comapi.walknavi.d.a.d;

import java.io.File;
import java.io.FileFilter;
/* loaded from: classes2.dex */
public class c implements FileFilter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f9976a;

    public c(b bVar) {
        this.f9976a = bVar;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return file.getName().endsWith(".so");
    }
}
