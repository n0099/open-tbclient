package com.baidu.fsg.base.restnet;

import com.baidu.ar.util.SystemInfoUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
/* loaded from: classes6.dex */
public class RestMultipartEntity {
    private static final char[] MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private ProgressListener listener;
    private String mBoundary;
    private byte[] mBoundaryLineBytes;
    private ByteArrayOutputStream mOut = new ByteArrayOutputStream();
    private boolean mIsSetFirst = false;
    private boolean mIsSetLast = false;

    /* loaded from: classes6.dex */
    public interface ProgressListener {
        void transferred(long j, long j2);
    }

    public RestMultipartEntity() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            sb.append(MULTIPART_CHARS[random.nextInt(MULTIPART_CHARS.length)]);
        }
        this.mBoundary = sb.toString();
        this.mBoundaryLineBytes = ("\r\n--" + this.mBoundary + SystemInfoUtil.LINE_END).getBytes();
    }

    public String getBoundary() {
        return this.mBoundary;
    }

    public OutputStream getOutputStream() {
        return this.mOut;
    }

    public void addPart(String str, String str2) {
        addPart(str, str2, false);
    }

    public void addPart(String str, String str2, boolean z) {
        try {
            writeBoundaryLine();
            this.mOut.write(("Content-Disposition: form-data; name=\"" + str + "\"\r\n\r\n").getBytes());
            this.mOut.write(str2.getBytes());
            if (z) {
                writeLastBoundaryIfNeeds();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addPart(String str, String str2, InputStream inputStream, String str3) {
        addPart(str, str2, inputStream, str3, false);
    }

    public void addPart(String str, String str2, InputStream inputStream, String str3, boolean z) {
        try {
            try {
                writeBoundaryLine();
                this.mOut.write(("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n").getBytes());
                if (str3 != null) {
                    this.mOut.write(("Content-Type: " + str3 + "\r\n\r\n").getBytes());
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
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    public void closeOutStream() {
        if (this.mOut != null) {
            try {
                this.mOut.close();
            } catch (IOException e) {
            }
        }
    }

    private void writeBoundaryLine() throws IOException {
        if (!this.mIsSetFirst) {
            this.mIsSetFirst = true;
            this.mOut.write(("--" + this.mBoundary + SystemInfoUtil.LINE_END).getBytes());
            return;
        }
        this.mOut.write(this.mBoundaryLineBytes);
    }

    private void writeLastBoundaryIfNeeds() {
        if (!this.mIsSetLast) {
            try {
                this.mOut.write(("\r\n--" + this.mBoundary + "--\r\n").getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.mIsSetLast = true;
        }
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
            if (read == -1) {
                break;
            }
            countingOutputStream.write(bArr, 0, read);
        }
        if (countingOutputStream != null) {
            countingOutputStream.close();
        }
        byteArrayInputStream.close();
    }

    public long getContentLength() {
        writeLastBoundaryIfNeeds();
        return this.mOut.toByteArray().length;
    }

    /* loaded from: classes6.dex */
    public static class CountingOutputStream extends FilterOutputStream {
        private final long length;
        private final ProgressListener listener;
        private long transferred;

        public CountingOutputStream(long j, OutputStream outputStream, ProgressListener progressListener) {
            super(outputStream);
            this.length = j;
            this.transferred = 0L;
            this.listener = progressListener;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.out.write(bArr, i, i2);
            this.transferred += i2;
            if (this.listener != null) {
                this.listener.transferred(this.transferred, this.length);
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            this.out.write(i);
            this.transferred++;
            if (this.listener != null) {
                this.listener.transferred(this.transferred, this.length);
            }
        }
    }
}
