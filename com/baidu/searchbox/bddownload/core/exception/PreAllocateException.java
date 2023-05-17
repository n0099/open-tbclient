package com.baidu.searchbox.bddownload.core.exception;

import java.io.IOException;
/* loaded from: classes3.dex */
public class PreAllocateException extends IOException {
    public final long freeSpace;
    public final long requireSpace;

    public PreAllocateException(long j, long j2) {
        super("There is Free space less than Require space: " + j2 + " < " + j);
        this.requireSpace = j;
        this.freeSpace = j2;
    }

    public long getFreeSpace() {
        return this.freeSpace;
    }

    public long getRequireSpace() {
        return this.requireSpace;
    }
}
