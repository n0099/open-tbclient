package com.android.internal.http.multipart;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class StringPart extends PartBase {
    public static final String DEFAULT_CHARSET = "US-ASCII";
    public static final String DEFAULT_CONTENT_TYPE = "text/plain";
    public static final String DEFAULT_TRANSFER_ENCODING = "8bit";

    public StringPart(String str, String str2, String str3) {
        super(null, null, null, null);
        throw new RuntimeException("Stub!");
    }

    @Override // com.android.internal.http.multipart.Part
    public long lengthOfData() {
        throw new RuntimeException("Stub!");
    }

    @Override // com.android.internal.http.multipart.Part
    public void sendData(OutputStream outputStream) throws IOException {
        throw new RuntimeException("Stub!");
    }

    @Override // com.android.internal.http.multipart.PartBase
    public void setCharSet(String str) {
        throw new RuntimeException("Stub!");
    }

    public StringPart(String str, String str2) {
        super(null, null, null, null);
        throw new RuntimeException("Stub!");
    }
}
