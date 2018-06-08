package com.baidu.cloudsdk.common.http;

import com.baidu.ar.util.SystemInfoUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;
/* loaded from: classes2.dex */
class MultipartEntity implements HttpEntity {
    private static final char[] MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private String mBoundary;
    private byte[] mBoundaryLineBytes;
    private ByteArrayOutputStream mOut = new ByteArrayOutputStream();
    private boolean mIsSetFirst = false;
    private boolean mIsSetLast = false;

    public MultipartEntity() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            sb.append(MULTIPART_CHARS[random.nextInt(MULTIPART_CHARS.length)]);
        }
        this.mBoundary = sb.toString();
        this.mBoundaryLineBytes = ("\r\n--" + this.mBoundary + SystemInfoUtil.LINE_END).getBytes();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addPart(String str, String str2) {
        try {
            writeBoundaryLine();
            this.mOut.write(("Content-Disposition: form-data; name=\"" + str + "\"\r\n\r\n").getBytes());
            this.mOut.write(str2.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
                    if (read != -1) {
                        this.mOut.write(bArr, 0, read);
                    } else {
                        this.mOut.flush();
                        try {
                            inputStream.close();
                            return;
                        } catch (IOException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
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

    @Override // org.apache.http.HttpEntity
    public void consumeContent() throws IOException {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() throws IOException, IllegalStateException {
        return new ByteArrayInputStream(this.mOut.toByteArray());
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentEncoding() {
        return null;
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        writeLastBoundaryIfNeeds();
        return this.mOut.toByteArray().length;
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentType() {
        return new BasicHeader("Content-Type", "multipart/form-data; boundary=" + this.mBoundary);
    }

    @Override // org.apache.http.HttpEntity
    public boolean isChunked() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.mOut.toByteArray());
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
}
