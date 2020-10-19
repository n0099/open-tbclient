package com.baidu.mobads.utils;

import java.io.File;
import java.util.Comparator;
/* loaded from: classes7.dex */
class k implements Comparator<File> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f2442a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f2442a = jVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(File file, File file2) {
        return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
    }
}
