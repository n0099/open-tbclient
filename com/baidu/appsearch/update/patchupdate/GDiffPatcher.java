package com.baidu.appsearch.update.patchupdate;

import android.text.TextUtils;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.util.LogUtil;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.zip.GZIPInputStream;
/* loaded from: classes.dex */
public class GDiffPatcher {
    public static final int COPY_INT_INT = 254;
    public static final int COPY_INT_UBYTE = 252;
    public static final int COPY_INT_USHORT = 253;
    public static final int COPY_LONG_INT = 255;
    public static final int COPY_UBYTE_INT = 246;
    public static final int COPY_UBYTE_UBYTE = 244;
    public static final int COPY_UBYTE_USHORT = 245;
    public static final int COPY_USHORT_INT = 251;
    public static final int COPY_USHORT_UBYTE = 249;
    public static final int COPY_USHORT_USHORT = 250;
    public static final int DATA_INT = 248;
    public static final int DATA_MAX = 246;
    public static final int DATA_USHORT = 247;
    public static final byte EOF = 0;
    public static final int ONE_MB = 1048576;
    public static final int QUARTER_MB = 262144;

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f4167a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f4168b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4169c;

    /* renamed from: d  reason: collision with root package name */
    public long f4170d;

    /* renamed from: e  reason: collision with root package name */
    public int f4171e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f4172f;

    /* renamed from: g  reason: collision with root package name */
    public int f4173g;
    public long totalLength;

    public GDiffPatcher() {
        ByteBuffer allocate = ByteBuffer.allocate(5120);
        this.f4167a = allocate;
        this.f4168b = allocate.array();
        this.f4169c = false;
        this.f4170d = 0L;
        this.f4171e = 246;
        this.totalLength = 0L;
        this.f4172f = new byte[1048576];
        this.f4173g = 0;
    }

    private void a(byte[] bArr, int i2, int i3, OutputStream outputStream) {
        try {
            if (this.f4173g + i3 >= this.f4172f.length) {
                outputStream.write(this.f4172f, 0, this.f4173g);
                this.f4173g = 0;
                System.arraycopy(bArr, 0, this.f4172f, 0, i3);
                this.f4173g = i3;
                return;
            }
            if (this.f4173g == 0) {
                System.arraycopy(bArr, 0, this.f4172f, 0, i3);
            } else {
                System.arraycopy(bArr, 0, this.f4172f, this.f4173g, i3);
            }
            this.f4173g += i3;
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void unGZip(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        LogUtil.logD("GDiffPatcher", "unGzip thread name:" + Thread.currentThread().getName());
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str);
        File file2 = new File(str2);
        if (file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new GZIPInputStream(fileInputStream));
                byte[] bArr = new byte[10240];
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, 10240);
                    if (read == -1) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                }
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                fileInputStream.close();
                bufferedInputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            LogUtil.logD("GDiffPatcher", "unzip time:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public void a(int i2, InputStream inputStream, OutputStream outputStream) {
        while (i2 > 0) {
            int read = inputStream.read(this.f4168b, 0, Math.min(this.f4168b.length, i2));
            if (read == -1) {
                throw new EOFException("cannot read " + i2);
            }
            a(this.f4168b, 0, read, outputStream);
            i2 -= read;
        }
    }

    public void a(long j, int i2, d dVar, OutputStream outputStream) {
        dVar.a(j);
        while (i2 > 0) {
            this.f4167a.clear().limit(Math.min(this.f4167a.capacity(), i2));
            int a2 = dVar.a(this.f4167a);
            if (a2 == -1) {
                throw new EOFException("in copy " + j + " " + i2);
            }
            a(this.f4167a.array(), 0, a2, outputStream);
            i2 -= a2;
        }
    }

    public void a(OutputStream outputStream) {
        int i2 = this.f4173g;
        if (i2 > 0) {
            outputStream.write(this.f4172f, 0, i2);
            this.f4173g = 0;
        }
        outputStream.flush();
    }

    public void patch(d dVar, InputStream inputStream, OutputStream outputStream) {
        long readUnsignedByte;
        long readUnsignedByte2;
        long readUnsignedByte3;
        long j;
        OutputStream dataOutputStream = new DataOutputStream(outputStream);
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(inputStream, 262144));
        if (dataInputStream.readUnsignedByte() != 209 || dataInputStream.readUnsignedByte() != 255 || dataInputStream.readUnsignedByte() != 209 || dataInputStream.readUnsignedByte() != 255) {
            throw new b("magic string not found, aborting!");
        }
        int readUnsignedByte4 = dataInputStream.readUnsignedByte();
        if (readUnsignedByte4 == 5) {
            this.f4169c = true;
            this.f4171e = LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK;
        } else if (readUnsignedByte4 != 4) {
            throw new b("magic string not found, aborting!");
        }
        long j2 = 0;
        while (true) {
            this.totalLength = j2;
            int readUnsignedByte5 = dataInputStream.readUnsignedByte();
            if (readUnsignedByte5 == 0) {
                a(dataOutputStream);
                return;
            }
            if (readUnsignedByte5 > this.f4171e) {
                switch (readUnsignedByte5) {
                    case 244:
                        if (this.f4169c) {
                            readUnsignedByte = dataInputStream.readByte() + this.f4170d;
                            this.f4170d = readUnsignedByte;
                        } else {
                            readUnsignedByte = dataInputStream.readUnsignedByte();
                        }
                        j = readUnsignedByte;
                        readUnsignedByte5 = dataInputStream.readUnsignedByte();
                        a(j, readUnsignedByte5, dVar, dataOutputStream);
                        j2 = this.totalLength + readUnsignedByte5;
                    case 245:
                        if (this.f4169c) {
                            readUnsignedByte2 = dataInputStream.readByte() + this.f4170d;
                            this.f4170d = readUnsignedByte2;
                        } else {
                            readUnsignedByte2 = dataInputStream.readUnsignedByte();
                        }
                        j = readUnsignedByte2;
                        readUnsignedByte5 = dataInputStream.readUnsignedShort();
                        a(j, readUnsignedByte5, dVar, dataOutputStream);
                        j2 = this.totalLength + readUnsignedByte5;
                    case 246:
                        if (this.f4169c) {
                            readUnsignedByte3 = dataInputStream.readByte() + this.f4170d;
                            this.f4170d = readUnsignedByte3;
                        } else {
                            readUnsignedByte3 = dataInputStream.readUnsignedByte();
                        }
                        j = readUnsignedByte3;
                        readUnsignedByte5 = dataInputStream.readInt();
                        a(j, readUnsignedByte5, dVar, dataOutputStream);
                        j2 = this.totalLength + readUnsignedByte5;
                    case DATA_USHORT /* 247 */:
                        readUnsignedByte5 = dataInputStream.readUnsignedShort();
                        break;
                    case DATA_INT /* 248 */:
                        readUnsignedByte5 = dataInputStream.readInt();
                        break;
                    case 249:
                        if (this.f4169c) {
                            readUnsignedByte = dataInputStream.readShort() + this.f4170d;
                            this.f4170d = readUnsignedByte;
                        } else {
                            readUnsignedByte = dataInputStream.readUnsignedShort();
                        }
                        j = readUnsignedByte;
                        readUnsignedByte5 = dataInputStream.readUnsignedByte();
                        a(j, readUnsignedByte5, dVar, dataOutputStream);
                        j2 = this.totalLength + readUnsignedByte5;
                    case 250:
                        if (this.f4169c) {
                            readUnsignedByte2 = dataInputStream.readShort() + this.f4170d;
                            this.f4170d = readUnsignedByte2;
                        } else {
                            readUnsignedByte2 = dataInputStream.readUnsignedShort();
                        }
                        j = readUnsignedByte2;
                        readUnsignedByte5 = dataInputStream.readUnsignedShort();
                        a(j, readUnsignedByte5, dVar, dataOutputStream);
                        j2 = this.totalLength + readUnsignedByte5;
                    case COPY_USHORT_INT /* 251 */:
                        if (this.f4169c) {
                            readUnsignedByte3 = dataInputStream.readShort() + this.f4170d;
                            this.f4170d = readUnsignedByte3;
                        } else {
                            readUnsignedByte3 = dataInputStream.readUnsignedShort();
                        }
                        j = readUnsignedByte3;
                        readUnsignedByte5 = dataInputStream.readInt();
                        a(j, readUnsignedByte5, dVar, dataOutputStream);
                        j2 = this.totalLength + readUnsignedByte5;
                    case COPY_INT_UBYTE /* 252 */:
                        readUnsignedByte = dataInputStream.readInt();
                        if (this.f4169c) {
                            readUnsignedByte += this.f4170d;
                            this.f4170d = readUnsignedByte;
                        }
                        j = readUnsignedByte;
                        readUnsignedByte5 = dataInputStream.readUnsignedByte();
                        a(j, readUnsignedByte5, dVar, dataOutputStream);
                        j2 = this.totalLength + readUnsignedByte5;
                    case COPY_INT_USHORT /* 253 */:
                        readUnsignedByte2 = dataInputStream.readInt();
                        if (this.f4169c) {
                            readUnsignedByte2 += this.f4170d;
                            this.f4170d = readUnsignedByte2;
                        }
                        j = readUnsignedByte2;
                        readUnsignedByte5 = dataInputStream.readUnsignedShort();
                        a(j, readUnsignedByte5, dVar, dataOutputStream);
                        j2 = this.totalLength + readUnsignedByte5;
                    case 254:
                        readUnsignedByte3 = dataInputStream.readInt();
                        if (this.f4169c) {
                            readUnsignedByte3 += this.f4170d;
                            this.f4170d = readUnsignedByte3;
                        }
                        j = readUnsignedByte3;
                        readUnsignedByte5 = dataInputStream.readInt();
                        a(j, readUnsignedByte5, dVar, dataOutputStream);
                        j2 = this.totalLength + readUnsignedByte5;
                    case 255:
                        readUnsignedByte3 = dataInputStream.readLong();
                        if (this.f4169c) {
                            readUnsignedByte3 += this.f4170d;
                            this.f4170d = readUnsignedByte3;
                        }
                        j = readUnsignedByte3;
                        readUnsignedByte5 = dataInputStream.readInt();
                        a(j, readUnsignedByte5, dVar, dataOutputStream);
                        j2 = this.totalLength + readUnsignedByte5;
                    default:
                        throw new IllegalStateException("command " + readUnsignedByte5);
                }
            }
            a(readUnsignedByte5, dataInputStream, dataOutputStream);
            j2 = this.totalLength + readUnsignedByte5;
        }
    }

    public void patch(File file, File file2, File file3) {
        c cVar = new c(new RandomAccessFile(file, r.f7975a));
        FileInputStream fileInputStream = new FileInputStream(file2);
        FileOutputStream fileOutputStream = new FileOutputStream(file3);
        try {
            try {
                patch(cVar, fileInputStream, fileOutputStream);
            } catch (IOException e2) {
                throw e2;
            }
        } finally {
            cVar.close();
            fileInputStream.close();
            fileOutputStream.close();
            file3.length();
        }
    }

    public void patch(byte[] bArr, InputStream inputStream, OutputStream outputStream) {
        patch(new a(bArr), inputStream, outputStream);
    }

    public byte[] patch(byte[] bArr, byte[] bArr2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        patch(bArr, new ByteArrayInputStream(bArr2), byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
