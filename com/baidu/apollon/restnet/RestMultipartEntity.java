package com.baidu.apollon.restnet;

import com.android.internal.http.multipart.Part;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
/* loaded from: classes2.dex */
public class RestMultipartEntity {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f3721a = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /* renamed from: c  reason: collision with root package name */
    public String f3723c;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f3726f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressListener f3727g;

    /* renamed from: b  reason: collision with root package name */
    public ByteArrayOutputStream f3722b = new ByteArrayOutputStream();

    /* renamed from: d  reason: collision with root package name */
    public boolean f3724d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3725e = false;

    /* loaded from: classes2.dex */
    public interface ProgressListener {
        void transferred(long j, long j2);
    }

    public RestMultipartEntity() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            char[] cArr = f3721a;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        this.f3723c = sb.toString();
        this.f3726f = ("\r\n--" + this.f3723c + Part.CRLF).getBytes();
    }

    private void e() throws IOException {
        if (!this.f3724d) {
            this.f3724d = true;
            ByteArrayOutputStream byteArrayOutputStream = this.f3722b;
            byteArrayOutputStream.write(("--" + this.f3723c + Part.CRLF).getBytes());
            return;
        }
        this.f3722b.write(this.f3726f);
    }

    private void f() {
        if (this.f3725e) {
            return;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = this.f3722b;
            byteArrayOutputStream.write(("\r\n--" + this.f3723c + "--\r\n").getBytes());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.f3725e = true;
    }

    public String a() {
        return this.f3723c;
    }

    public void addPart(String str, String str2) {
        a(str, str2, false);
    }

    public OutputStream b() {
        return this.f3722b;
    }

    public ProgressListener c() {
        return this.f3727g;
    }

    public void closeOutStream() {
        ByteArrayOutputStream byteArrayOutputStream = this.f3722b;
        if (byteArrayOutputStream != null) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public long d() {
        f();
        return this.f3722b.toByteArray().length;
    }

    public void setProgressListener(ProgressListener progressListener) {
        this.f3727g = progressListener;
    }

    public void a(String str, String str2, boolean z) {
        try {
            e();
            ByteArrayOutputStream byteArrayOutputStream = this.f3722b;
            byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str + "\"\r\n\r\n").getBytes());
            this.f3722b.write(str2.getBytes());
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
                    ByteArrayOutputStream byteArrayOutputStream = this.f3722b;
                    byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n").getBytes());
                    if (str3 != null) {
                        ByteArrayOutputStream byteArrayOutputStream2 = this.f3722b;
                        byteArrayOutputStream2.write((Part.CONTENT_TYPE + str3 + "\r\n\r\n").getBytes());
                    } else {
                        this.f3722b.write("Content-Type: application/octet-stream\r\n\r\n".getBytes());
                    }
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        this.f3722b.write(bArr, 0, read);
                    }
                    if (z) {
                        f();
                    }
                    this.f3722b.flush();
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

    /* loaded from: classes2.dex */
    public static class a extends FilterOutputStream {

        /* renamed from: a  reason: collision with root package name */
        public final ProgressListener f3728a;

        /* renamed from: b  reason: collision with root package name */
        public final long f3729b;

        /* renamed from: c  reason: collision with root package name */
        public long f3730c;

        public a(long j, OutputStream outputStream, ProgressListener progressListener) {
            super(outputStream);
            this.f3729b = j;
            this.f3730c = 0L;
            this.f3728a = progressListener;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            ((FilterOutputStream) this).out.write(bArr, i, i2);
            long j = this.f3730c + i2;
            this.f3730c = j;
            ProgressListener progressListener = this.f3728a;
            if (progressListener != null) {
                progressListener.transferred(j, this.f3729b);
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            ((FilterOutputStream) this).out.write(i);
            long j = this.f3730c + 1;
            this.f3730c = j;
            ProgressListener progressListener = this.f3728a;
            if (progressListener != null) {
                progressListener.transferred(j, this.f3729b);
            }
        }
    }

    public void a(String str, String str2, InputStream inputStream, String str3) {
        addPart(str, str2, inputStream, str3, false);
    }

    public void a(OutputStream outputStream) throws IOException {
        f();
        a aVar = new a(d(), outputStream, this.f3727g);
        aVar.write(this.f3722b.toByteArray());
        aVar.close();
    }
}
