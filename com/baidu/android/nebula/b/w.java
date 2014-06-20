package com.baidu.android.nebula.b;

import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes.dex */
class w extends FileInputStream {
    final /* synthetic */ long a;
    final /* synthetic */ t b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(t tVar, File file, long j) {
        super(file);
        this.b = tVar;
        this.a = j;
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public int available() {
        return (int) this.a;
    }
}
