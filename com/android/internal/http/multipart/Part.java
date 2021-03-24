package com.android.internal.http.multipart;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public abstract class Part {
    @Deprecated
    public static final String BOUNDARY = "----------------314159265358979323846";
    @Deprecated
    public static final byte[] BOUNDARY_BYTES = null;
    public static final String CHARSET = "; charset=";
    public static final byte[] CHARSET_BYTES = null;
    public static final String CONTENT_DISPOSITION = "Content-Disposition: form-data; name=";
    public static final byte[] CONTENT_DISPOSITION_BYTES = null;
    public static final String CONTENT_TRANSFER_ENCODING = "Content-Transfer-Encoding: ";
    public static final byte[] CONTENT_TRANSFER_ENCODING_BYTES = null;
    public static final String CONTENT_TYPE = "Content-Type: ";
    public static final byte[] CONTENT_TYPE_BYTES = null;
    public static final String CRLF = "\r\n";
    public static final byte[] CRLF_BYTES = null;
    public static final String EXTRA = "--";
    public static final byte[] EXTRA_BYTES = null;
    public static final String QUOTE = "\"";
    public static final byte[] QUOTE_BYTES = null;

    public Part() {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public static String getBoundary() {
        throw new RuntimeException("Stub!");
    }

    public static long getLengthOfParts(Part[] partArr) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public static void sendParts(OutputStream outputStream, Part[] partArr) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public abstract String getCharSet();

    public abstract String getContentType();

    public abstract String getName();

    public byte[] getPartBoundary() {
        throw new RuntimeException("Stub!");
    }

    public abstract String getTransferEncoding();

    public boolean isRepeatable() {
        throw new RuntimeException("Stub!");
    }

    public long length() throws IOException {
        throw new RuntimeException("Stub!");
    }

    public abstract long lengthOfData() throws IOException;

    public void send(OutputStream outputStream) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public void sendContentTypeHeader(OutputStream outputStream) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public abstract void sendData(OutputStream outputStream) throws IOException;

    public void sendDispositionHeader(OutputStream outputStream) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public void sendEnd(OutputStream outputStream) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public void sendEndOfHeader(OutputStream outputStream) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public void sendStart(OutputStream outputStream) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public void sendTransferEncodingHeader(OutputStream outputStream) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public String toString() {
        throw new RuntimeException("Stub!");
    }

    public static long getLengthOfParts(Part[] partArr, byte[] bArr) throws IOException {
        throw new RuntimeException("Stub!");
    }

    public static void sendParts(OutputStream outputStream, Part[] partArr, byte[] bArr) throws IOException {
        throw new RuntimeException("Stub!");
    }
}
