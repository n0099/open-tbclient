package com.baidu.mobads.utils;

import java.io.File;
import java.util.Comparator;
/* loaded from: classes5.dex */
class o implements Comparator<File> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f3504a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.f3504a = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(File file, File file2) {
        return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
    }
}
