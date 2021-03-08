package com.baidu.mobads.utils;

import java.io.File;
import java.util.Comparator;
/* loaded from: classes4.dex */
class o implements Comparator<File> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f2491a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.f2491a = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(File file, File file2) {
        return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
    }
}
