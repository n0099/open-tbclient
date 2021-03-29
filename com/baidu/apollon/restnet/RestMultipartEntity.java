package com.baidu.apollon.restnet;

import com.android.internal.http.multipart.Part;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
/* loaded from: classes.dex */
public class RestMultipartEntity {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f3722a = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /* renamed from: c  reason: collision with root package name */
    public String f3724c;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f3727f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressListener f3728g;

    /* renamed from: b  reason: collision with root package name */
    public ByteArrayOutputStream f3723b = new ByteArrayOutputStream();

    /* renamed from: d  reason: collision with root package name */
    public boolean f3725d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3726e = false;

    /* loaded from: classes.dex */
    public interface ProgressListener {
        void transferred(long j, long j2);
    }

    public RestMultipartEntity() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            char[] cArr = f3722a;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        this.f3724c = sb.toString();
        this.f3727f = ("\r\n--" + this.f3724c + Part.CRLF).getBytes();
    }

    private void e() throws IOException {
        if (!this.f3725d) {
            this.f3725d = true;
            ByteArrayOutputStream byteArrayOutputStream = this.f3723b;
            byteArrayOutputStream.write(("--" + this.f3724c + Part.CRLF).getBytes());
            return;
        }
        this.f3723b.write(this.f3727f);
    }

    private void f() {
        if (this.f3726e) {
            return;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = this.f3723b;
            byteArrayOutputStream.write(("\r\n--" + this.f3724c + "--\r\n").getBytes());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.f3726e = true;
    }

    public String a() {
        return this.f3724c;
    }

    public void addPart(String str, String str2) {
        a(str, str2, false);
    }

    public OutputStream b() {
        return this.f3723b;
    }

    public ProgressListener c() {
        return this.f3728g;
    }

    public void closeOutStream() {
        ByteArrayOutputStream byteArrayOutputStream = this.f3723b;
        if (byteArrayOutputStream != null) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public long d() {
        f();
        return this.f3723b.toByteArray().length;
    }

    public void setProgressListener(ProgressListener progressListener) {
        this.f3728g = progressListener;
    }

    public void a(String str, String str2, boolean z) {
        try {
            e();
            ByteArrayOutputStream byteArrayOutputStream = this.f3723b;
            byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str + "\"\r\n\r\n").getBytes());
            this.f3723b.write(str2.getBytes());
            if (z) {
                f();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    public void addPart(String str, String str2, InputStream inputStream, String str3, boolean z) {
        try {
            try {
                try {
                    e();
                    ByteArrayOutputStream byteArrayOutputStream = this.f3723b;
                    byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n").getBytes());
                    if (str3 != null) {
                        ByteArrayOutputStream byteArrayOutputStream2 = this.f3723b;
                        byteArrayOutputStream2.write((Part.CONTENT_TYPE + str3 + "\r\n\r\n").getBytes());
                    } else {
                        this.f3723b.write("Content-Type: application/octet-stream\r\n\r\n".getBytes());
                    }
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        this.f3723b.write(bArr, 0, read);
                    }
                    if (z) {
                        f();
                    }
                    this.f3723b.flush();
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

    /* loaded from: classes.dex */
    public static class a extends FilterOutputStream {

        /* renamed from: a  reason: collision with root package name */
        public final ProgressListener f3729a;

        /* renamed from: b  reason: collision with root package name */
        public final long f3730b;

        /* renamed from: c  reason: collision with root package name */
        public long f3731c;

        public a(long j, OutputStream outputStream, ProgressListener progressListener) {
            super(outputStream);
            this.f3730b = j;
            this.f3731c = 0L;
            this.f3729a = progressListener;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            ((FilterOutputStream) this).out.write(bArr, i, i2);
            long j = this.f3731c + i2;
            this.f3731c = j;
            ProgressListener progressListener = this.f3729a;
            if (progressListener != null) {
                progressListener.transferred(j, this.f3730b);
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            ((FilterOutputStream) this).out.write(i);
            long j = this.f3731c + 1;
            this.f3731c = j;
            ProgressListener progressListener = this.f3729a;
            if (progressListener != null) {
                progressListener.transferred(j, this.f3730b);
            }
        }
    }

    public void a(String str, String str2, InputStream inputStream, String str3) {
        addPart(str, str2, inputStream, str3, false);
    }

    public void a(OutputStream outputStream) throws IOException {
        f();
        a aVar = new a(d(), outputStream, this.f3728g);
        aVar.write(this.f3723b.toByteArray());
        aVar.close();
    }
}
