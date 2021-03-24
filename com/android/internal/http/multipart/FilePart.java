package com.android.internal.http.multipart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class FilePart extends PartBase {
    public static final String DEFAULT_CHARSET = "ISO-8859-1";
    public static final String DEFAULT_CONTENT_TYPE = "application/octet-stream";
    public static final String DEFAULT_TRANSFER_ENCODING = "binary";
    public static final String FILE_NAME = "; filename=";

    public FilePart(String str, PartSource partSource, String str2, String str3) {
        super(null, null, null, null);
        throw new RuntimeException("Stub!");
    }

    public PartSource getSource() {
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

    @Override // com.android.internal.http.multipart.Part
    public void sendDispositionHeader(OutputStream outputStream) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public FilePart(String str, PartSource partSource) {
        super(null, null, null, null);
        throw new RuntimeException("Stub!");
    }

    public FilePart(String str, File file) throws FileNotFoundException {
        super(null, null, null, null);
        throw new RuntimeException("Stub!");
    }

    public FilePart(String str, File file, String str2, String str3) throws FileNotFoundException {
        super(null, null, null, null);
        throw new RuntimeException("Stub!");
    }

    public FilePart(String str, String str2, File file) throws FileNotFoundException {
        super(null, null, null, null);
        throw new RuntimeException("Stub!");
    }

    public FilePart(String str, String str2, File file, String str3, String str4) throws FileNotFoundException {
        super(null, null, null, null);
        throw new RuntimeException("Stub!");
    }
}
