package com.baidu.mobads.utils;

import java.io.File;
import java.util.Comparator;
/* loaded from: classes2.dex */
public class o implements Comparator<File> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n f8554a;

    public o(n nVar) {
        this.f8554a = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(File file, File file2) {
        return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
    }
}
