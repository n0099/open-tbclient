package com.baidu.fsg.base.restnet;

import com.android.internal.http.multipart.Part;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
/* loaded from: classes.dex */
public class RestMultipartEntity {
    public static final char[] MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    public ProgressListener listener;
    public String mBoundary;
    public byte[] mBoundaryLineBytes;
    public ByteArrayOutputStream mOut = new ByteArrayOutputStream();
    public boolean mIsSetFirst = false;
    public boolean mIsSetLast = false;

    /* loaded from: classes.dex */
    public interface ProgressListener {
        void transferred(long j, long j2);
    }

    public RestMultipartEntity() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            char[] cArr = MULTIPART_CHARS;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        this.mBoundary = sb.toString();
        this.mBoundaryLineBytes = ("\r\n--" + this.mBoundary + Part.CRLF).getBytes();
    }

    private void writeBoundaryLine() throws IOException {
        if (!this.mIsSetFirst) {
            this.mIsSetFirst = true;
            ByteArrayOutputStream byteArrayOutputStream = this.mOut;
            byteArrayOutputStream.write(("--" + this.mBoundary + Part.CRLF).getBytes());
            return;
        }
        this.mOut.write(this.mBoundaryLineBytes);
    }

    private void writeLastBoundaryIfNeeds() {
        if (this.mIsSetLast) {
            return;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = this.mOut;
            byteArrayOutputStream.write(("\r\n--" + this.mBoundary + "--\r\n").getBytes());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.mIsSetLast = true;
    }

    public void addPart(String str, String str2) {
        addPart(str, str2, false);
    }

    public void closeOutStream() {
        ByteArrayOutputStream byteArrayOutputStream = this.mOut;
        if (byteArrayOutputStream != null) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public String getBoundary() {
        return this.mBoundary;
    }

    public long getContentLength() {
        writeLastBoundaryIfNeeds();
        return this.mOut.toByteArray().length;
    }

    public OutputStream getOutputStream() {
        return this.mOut;
    }

    public ProgressListener getProgressListener() {
        return this.listener;
    }

    public void setProgressListener(ProgressListener progressListener) {
        this.listener = progressListener;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        writeLastBoundaryIfNeeds();
        CountingOutputStream countingOutputStream = new CountingOutputStream(getContentLength(), outputStream, this.listener);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.mOut.toByteArray());
        byte[] bArr = new byte[8192];
        while (true) {
            int read = byteArrayInputStream.read(bArr);
            if (read != -1) {
                countingOutputStream.write(bArr, 0, read);
            } else {
                countingOutputStream.close();
                byteArrayInputStream.close();
                return;
            }
        }
    }

    public void addPart(String str, String str2, boolean z) {
        try {
            writeBoundaryLine();
            ByteArrayOutputStream byteArrayOutputStream = this.mOut;
            byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str + "\"\r\n\r\n").getBytes());
            this.mOut.write(str2.getBytes());
            if (z) {
                writeLastBoundaryIfNeeds();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* loaded from: classes.dex */
    public static class CountingOutputStream extends FilterOutputStream {
        public final long length;
        public final ProgressListener listener;
        public long transferred;

        public CountingOutputStream(long j, OutputStream outputStream, ProgressListener progressListener) {
            super(outputStream);
            this.length = j;
            this.transferred = 0L;
            this.listener = progressListener;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            ((FilterOutputStream) this).out.write(bArr, i, i2);
            long j = this.transferred + i2;
            this.transferred = j;
            ProgressListener progressListener = this.listener;
            if (progressListener != null) {
                progressListener.transferred(j, this.length);
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            ((FilterOutputStream) this).out.write(i);
            long j = this.transferred + 1;
            this.transferred = j;
            ProgressListener progressListener = this.listener;
            if (progressListener != null) {
                progressListener.transferred(j, this.length);
            }
        }
    }

    public void addPart(String str, String str2, InputStream inputStream, String str3) {
        addPart(str, str2, inputStream, str3, false);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    public void addPart(String str, String str2, InputStream inputStream, String str3, boolean z) {
        try {
            try {
                try {
                    writeBoundaryLine();
                    ByteArrayOutputStream byteArrayOutputStream = this.mOut;
                    byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n").getBytes());
                    if (str3 != null) {
                        ByteArrayOutputStream byteArrayOutputStream2 = this.mOut;
                        byteArrayOutputStream2.write((Part.CONTENT_TYPE + str3 + "\r\n\r\n").getBytes());
                    } else {
                        this.mOut.write("Content-Type: application/octet-stream\r\n\r\n".getBytes());
                    }
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        this.mOut.write(bArr, 0, read);
                    }
                    if (z) {
                        writeLastBoundaryIfNeeds();
                    }
                    this.mOut.flush();
                    inputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    inputStream.close();
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                throw th;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }
}
