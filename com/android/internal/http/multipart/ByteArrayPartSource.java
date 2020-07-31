package com.android.internal.http.multipart;

import java.io.InputStream;
/* loaded from: classes20.dex */
public class ByteArrayPartSource implements PartSource {
    public ByteArrayPartSource(String str, byte[] bArr) {
        throw new RuntimeException("Stub!");
    }

    @Override // com.android.internal.http.multipart.PartSource
    public long getLength() {
        throw new RuntimeException("Stub!");
    }

    @Override // com.android.internal.http.multipart.PartSource
    public String getFileName() {
        throw new RuntimeException("Stub!");
    }

    @Override // com.android.internal.http.multipart.PartSource
    public InputStream createInputStream() {
        throw new RuntimeException("Stub!");
    }
}
