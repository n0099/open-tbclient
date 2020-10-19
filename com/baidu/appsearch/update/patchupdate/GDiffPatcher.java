package com.baidu.appsearch.update.patchupdate;

import android.text.TextUtils;
import com.baidu.util.LogUtil;
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
/* loaded from: classes17.dex */
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
    private ByteBuffer f1185a = ByteBuffer.allocate(5120);
    private byte[] b = this.f1185a.array();
    private boolean c = false;
    private long d = 0;
    private int e = 246;
    public long totalLength = 0;
    private byte[] f = new byte[1048576];
    private int g = 0;

    private void a(byte[] bArr, int i, int i2, OutputStream outputStream) {
        try {
            if (this.g + i2 >= this.f.length) {
                outputStream.write(this.f, 0, this.g);
                this.g = 0;
                System.arraycopy(bArr, 0, this.f, 0, i2);
                this.g = i2;
                return;
            }
            if (this.g == 0) {
                System.arraycopy(bArr, 0, this.f, 0, i2);
            } else {
                System.arraycopy(bArr, 0, this.f, this.g, i2);
            }
            this.g += i2;
        } catch (IOException e) {
            e.printStackTrace();
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
                    int read = bufferedInputStream.read(bArr, 0, bArr.length);
                    if (read == -1) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                }
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                fileInputStream.close();
                bufferedInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            LogUtil.logD("GDiffPatcher", "unzip time:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    void a(int i, InputStream inputStream, OutputStream outputStream) {
        while (i > 0) {
            int read = inputStream.read(this.b, 0, Math.min(this.b.length, i));
            if (read == -1) {
                throw new EOFException("cannot read " + i);
            }
            a(this.b, 0, read, outputStream);
            i -= read;
        }
    }

    void a(long j, int i, d dVar, OutputStream outputStream) {
        dVar.a(j);
        while (i > 0) {
            this.f1185a.clear().limit(Math.min(this.f1185a.capacity(), i));
            int a2 = dVar.a(this.f1185a);
            if (a2 == -1) {
                throw new EOFException("in copy " + j + " " + i);
            }
            a(this.f1185a.array(), 0, a2, outputStream);
            i -= a2;
        }
    }

    void a(OutputStream outputStream) {
        if (this.g > 0) {
            outputStream.write(this.f, 0, this.g);
            this.g = 0;
        }
        outputStream.flush();
    }

    public void patch(d dVar, InputStream inputStream, OutputStream outputStream) {
        long readUnsignedByte;
        long readUnsignedByte2;
        long readUnsignedByte3;
        long readUnsignedShort;
        long readUnsignedShort2;
        long readUnsignedShort3;
        OutputStream dataOutputStream = new DataOutputStream(outputStream);
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(inputStream, 262144));
        if (dataInputStream.readUnsignedByte() != 209 || dataInputStream.readUnsignedByte() != 255 || dataInputStream.readUnsignedByte() != 209 || dataInputStream.readUnsignedByte() != 255) {
            throw new b("magic string not found, aborting!");
        }
        int readUnsignedByte4 = dataInputStream.readUnsignedByte();
        if (readUnsignedByte4 == 5) {
            this.c = true;
            this.e = 243;
        } else if (readUnsignedByte4 != 4) {
            throw new b("magic string not found, aborting!");
        }
        this.totalLength = 0L;
        while (true) {
            int readUnsignedByte5 = dataInputStream.readUnsignedByte();
            if (readUnsignedByte5 == 0) {
                a(dataOutputStream);
                return;
            } else if (readUnsignedByte5 <= this.e) {
                a(readUnsignedByte5, dataInputStream, dataOutputStream);
                this.totalLength += readUnsignedByte5;
            } else {
                switch (readUnsignedByte5) {
                    case COPY_UBYTE_UBYTE /* 244 */:
                        if (this.c) {
                            readUnsignedByte3 = dataInputStream.readByte() + this.d;
                            this.d = readUnsignedByte3;
                        } else {
                            readUnsignedByte3 = dataInputStream.readUnsignedByte();
                        }
                        int readUnsignedByte6 = dataInputStream.readUnsignedByte();
                        a(readUnsignedByte3, readUnsignedByte6, dVar, dataOutputStream);
                        this.totalLength += readUnsignedByte6;
                        continue;
                    case COPY_UBYTE_USHORT /* 245 */:
                        if (this.c) {
                            readUnsignedByte2 = dataInputStream.readByte() + this.d;
                            this.d = readUnsignedByte2;
                        } else {
                            readUnsignedByte2 = dataInputStream.readUnsignedByte();
                        }
                        int readUnsignedShort4 = dataInputStream.readUnsignedShort();
                        a(readUnsignedByte2, readUnsignedShort4, dVar, dataOutputStream);
                        this.totalLength += readUnsignedShort4;
                        continue;
                    case 246:
                        if (this.c) {
                            readUnsignedByte = dataInputStream.readByte() + this.d;
                            this.d = readUnsignedByte;
                        } else {
                            readUnsignedByte = dataInputStream.readUnsignedByte();
                        }
                        int readInt = dataInputStream.readInt();
                        a(readUnsignedByte, readInt, dVar, dataOutputStream);
                        this.totalLength += readInt;
                        continue;
                    case DATA_USHORT /* 247 */:
                        int readUnsignedShort5 = dataInputStream.readUnsignedShort();
                        a(readUnsignedShort5, dataInputStream, dataOutputStream);
                        this.totalLength += readUnsignedShort5;
                        continue;
                    case DATA_INT /* 248 */:
                        int readInt2 = dataInputStream.readInt();
                        a(readInt2, dataInputStream, dataOutputStream);
                        this.totalLength += readInt2;
                        continue;
                    case 249:
                        if (this.c) {
                            readUnsignedShort3 = dataInputStream.readShort() + this.d;
                            this.d = readUnsignedShort3;
                        } else {
                            readUnsignedShort3 = dataInputStream.readUnsignedShort();
                        }
                        int readUnsignedByte7 = dataInputStream.readUnsignedByte();
                        a(readUnsignedShort3, readUnsignedByte7, dVar, dataOutputStream);
                        this.totalLength += readUnsignedByte7;
                        continue;
                    case 250:
                        if (this.c) {
                            readUnsignedShort2 = dataInputStream.readShort() + this.d;
                            this.d = readUnsignedShort2;
                        } else {
                            readUnsignedShort2 = dataInputStream.readUnsignedShort();
                        }
                        int readUnsignedShort6 = dataInputStream.readUnsignedShort();
                        a(readUnsignedShort2, readUnsignedShort6, dVar, dataOutputStream);
                        this.totalLength += readUnsignedShort6;
                        continue;
                    case COPY_USHORT_INT /* 251 */:
                        if (this.c) {
                            readUnsignedShort = dataInputStream.readShort() + this.d;
                            this.d = readUnsignedShort;
                        } else {
                            readUnsignedShort = dataInputStream.readUnsignedShort();
                        }
                        int readInt3 = dataInputStream.readInt();
                        a(readUnsignedShort, readInt3, dVar, dataOutputStream);
                        this.totalLength += readInt3;
                        continue;
                    case COPY_INT_UBYTE /* 252 */:
                        long readInt4 = dataInputStream.readInt();
                        if (this.c) {
                            readInt4 += this.d;
                            this.d = readInt4;
                        }
                        int readUnsignedByte8 = dataInputStream.readUnsignedByte();
                        a(readInt4, readUnsignedByte8, dVar, dataOutputStream);
                        this.totalLength += readUnsignedByte8;
                        continue;
                    case COPY_INT_USHORT /* 253 */:
                        long readInt5 = dataInputStream.readInt();
                        if (this.c) {
                            readInt5 += this.d;
                            this.d = readInt5;
                        }
                        int readUnsignedShort7 = dataInputStream.readUnsignedShort();
                        a(readInt5, readUnsignedShort7, dVar, dataOutputStream);
                        this.totalLength += readUnsignedShort7;
                        continue;
                    case COPY_INT_INT /* 254 */:
                        long readInt6 = dataInputStream.readInt();
                        if (this.c) {
                            readInt6 += this.d;
                            this.d = readInt6;
                        }
                        int readInt7 = dataInputStream.readInt();
                        a(readInt6, readInt7, dVar, dataOutputStream);
                        this.totalLength += readInt7;
                        continue;
                    case 255:
                        long readLong = dataInputStream.readLong();
                        if (this.c) {
                            readLong += this.d;
                            this.d = readLong;
                        }
                        int readInt8 = dataInputStream.readInt();
                        a(readLong, readInt8, dVar, dataOutputStream);
                        this.totalLength += readInt8;
                        continue;
                    default:
                        throw new IllegalStateException("command " + readUnsignedByte5);
                }
            }
        }
    }

    public void patch(File file, File file2, File file3) {
        c cVar = new c(new RandomAccessFile(file, "r"));
        FileInputStream fileInputStream = new FileInputStream(file2);
        FileOutputStream fileOutputStream = new FileOutputStream(file3);
        try {
            try {
                patch(cVar, fileInputStream, fileOutputStream);
            } catch (IOException e) {
                throw e;
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
