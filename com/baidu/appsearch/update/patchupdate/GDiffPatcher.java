package com.baidu.appsearch.update.patchupdate;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes5.dex */
public class GDiffPatcher {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ByteBuffer f38429a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f38430b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f38431c;

    /* renamed from: d  reason: collision with root package name */
    public long f38432d;

    /* renamed from: e  reason: collision with root package name */
    public int f38433e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f38434f;

    /* renamed from: g  reason: collision with root package name */
    public int f38435g;
    public long totalLength;

    public GDiffPatcher() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ByteBuffer allocate = ByteBuffer.allocate(5120);
        this.f38429a = allocate;
        this.f38430b = allocate.array();
        this.f38431c = false;
        this.f38432d = 0L;
        this.f38433e = 246;
        this.totalLength = 0L;
        this.f38434f = new byte[1048576];
        this.f38435g = 0;
    }

    private void a(byte[] bArr, int i2, int i3, OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), outputStream}) == null) {
            try {
                if (this.f38435g + i3 >= this.f38434f.length) {
                    outputStream.write(this.f38434f, 0, this.f38435g);
                    this.f38435g = 0;
                    System.arraycopy(bArr, 0, this.f38434f, 0, i3);
                    this.f38435g = i3;
                    return;
                }
                if (this.f38435g == 0) {
                    System.arraycopy(bArr, 0, this.f38434f, 0, i3);
                } else {
                    System.arraycopy(bArr, 0, this.f38434f, this.f38435g, i3);
                }
                this.f38435g += i3;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void unGZip(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
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
    }

    public void a(int i2, InputStream inputStream, OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i2, inputStream, outputStream) == null) {
            while (i2 > 0) {
                int read = inputStream.read(this.f38430b, 0, Math.min(this.f38430b.length, i2));
                if (read == -1) {
                    throw new EOFException("cannot read " + i2);
                }
                a(this.f38430b, 0, read, outputStream);
                i2 -= read;
            }
        }
    }

    public void a(long j2, int i2, d dVar, OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), dVar, outputStream}) == null) {
            dVar.a(j2);
            while (i2 > 0) {
                this.f38429a.clear().limit(Math.min(this.f38429a.capacity(), i2));
                int a2 = dVar.a(this.f38429a);
                if (a2 == -1) {
                    throw new EOFException("in copy " + j2 + " " + i2);
                }
                a(this.f38429a.array(), 0, a2, outputStream);
                i2 -= a2;
            }
        }
    }

    public void a(OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, outputStream) == null) {
            int i2 = this.f38435g;
            if (i2 > 0) {
                outputStream.write(this.f38434f, 0, i2);
                this.f38435g = 0;
            }
            outputStream.flush();
        }
    }

    public void patch(d dVar, InputStream inputStream, OutputStream outputStream) {
        long readUnsignedByte;
        long readUnsignedByte2;
        long readUnsignedByte3;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLL(1048579, this, dVar, inputStream, outputStream) != null) {
            return;
        }
        OutputStream dataOutputStream = new DataOutputStream(outputStream);
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(inputStream, 262144));
        if (dataInputStream.readUnsignedByte() != 209 || dataInputStream.readUnsignedByte() != 255 || dataInputStream.readUnsignedByte() != 209 || dataInputStream.readUnsignedByte() != 255) {
            throw new b("magic string not found, aborting!");
        }
        int readUnsignedByte4 = dataInputStream.readUnsignedByte();
        if (readUnsignedByte4 == 5) {
            this.f38431c = true;
            this.f38433e = LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK;
        } else if (readUnsignedByte4 != 4) {
            throw new b("magic string not found, aborting!");
        }
        long j3 = 0;
        while (true) {
            this.totalLength = j3;
            int readUnsignedByte5 = dataInputStream.readUnsignedByte();
            if (readUnsignedByte5 == 0) {
                a(dataOutputStream);
                return;
            }
            if (readUnsignedByte5 > this.f38433e) {
                switch (readUnsignedByte5) {
                    case 244:
                        if (this.f38431c) {
                            readUnsignedByte = dataInputStream.readByte() + this.f38432d;
                            this.f38432d = readUnsignedByte;
                        } else {
                            readUnsignedByte = dataInputStream.readUnsignedByte();
                        }
                        j2 = readUnsignedByte;
                        readUnsignedByte5 = dataInputStream.readUnsignedByte();
                        a(j2, readUnsignedByte5, dVar, dataOutputStream);
                        j3 = this.totalLength + readUnsignedByte5;
                    case 245:
                        if (this.f38431c) {
                            readUnsignedByte2 = dataInputStream.readByte() + this.f38432d;
                            this.f38432d = readUnsignedByte2;
                        } else {
                            readUnsignedByte2 = dataInputStream.readUnsignedByte();
                        }
                        j2 = readUnsignedByte2;
                        readUnsignedByte5 = dataInputStream.readUnsignedShort();
                        a(j2, readUnsignedByte5, dVar, dataOutputStream);
                        j3 = this.totalLength + readUnsignedByte5;
                    case 246:
                        if (this.f38431c) {
                            readUnsignedByte3 = dataInputStream.readByte() + this.f38432d;
                            this.f38432d = readUnsignedByte3;
                        } else {
                            readUnsignedByte3 = dataInputStream.readUnsignedByte();
                        }
                        j2 = readUnsignedByte3;
                        readUnsignedByte5 = dataInputStream.readInt();
                        a(j2, readUnsignedByte5, dVar, dataOutputStream);
                        j3 = this.totalLength + readUnsignedByte5;
                    case DATA_USHORT /* 247 */:
                        readUnsignedByte5 = dataInputStream.readUnsignedShort();
                        break;
                    case DATA_INT /* 248 */:
                        readUnsignedByte5 = dataInputStream.readInt();
                        break;
                    case 249:
                        if (this.f38431c) {
                            readUnsignedByte = dataInputStream.readShort() + this.f38432d;
                            this.f38432d = readUnsignedByte;
                        } else {
                            readUnsignedByte = dataInputStream.readUnsignedShort();
                        }
                        j2 = readUnsignedByte;
                        readUnsignedByte5 = dataInputStream.readUnsignedByte();
                        a(j2, readUnsignedByte5, dVar, dataOutputStream);
                        j3 = this.totalLength + readUnsignedByte5;
                    case 250:
                        if (this.f38431c) {
                            readUnsignedByte2 = dataInputStream.readShort() + this.f38432d;
                            this.f38432d = readUnsignedByte2;
                        } else {
                            readUnsignedByte2 = dataInputStream.readUnsignedShort();
                        }
                        j2 = readUnsignedByte2;
                        readUnsignedByte5 = dataInputStream.readUnsignedShort();
                        a(j2, readUnsignedByte5, dVar, dataOutputStream);
                        j3 = this.totalLength + readUnsignedByte5;
                    case COPY_USHORT_INT /* 251 */:
                        if (this.f38431c) {
                            readUnsignedByte3 = dataInputStream.readShort() + this.f38432d;
                            this.f38432d = readUnsignedByte3;
                        } else {
                            readUnsignedByte3 = dataInputStream.readUnsignedShort();
                        }
                        j2 = readUnsignedByte3;
                        readUnsignedByte5 = dataInputStream.readInt();
                        a(j2, readUnsignedByte5, dVar, dataOutputStream);
                        j3 = this.totalLength + readUnsignedByte5;
                    case COPY_INT_UBYTE /* 252 */:
                        readUnsignedByte = dataInputStream.readInt();
                        if (this.f38431c) {
                            readUnsignedByte += this.f38432d;
                            this.f38432d = readUnsignedByte;
                        }
                        j2 = readUnsignedByte;
                        readUnsignedByte5 = dataInputStream.readUnsignedByte();
                        a(j2, readUnsignedByte5, dVar, dataOutputStream);
                        j3 = this.totalLength + readUnsignedByte5;
                    case COPY_INT_USHORT /* 253 */:
                        readUnsignedByte2 = dataInputStream.readInt();
                        if (this.f38431c) {
                            readUnsignedByte2 += this.f38432d;
                            this.f38432d = readUnsignedByte2;
                        }
                        j2 = readUnsignedByte2;
                        readUnsignedByte5 = dataInputStream.readUnsignedShort();
                        a(j2, readUnsignedByte5, dVar, dataOutputStream);
                        j3 = this.totalLength + readUnsignedByte5;
                    case 254:
                        readUnsignedByte3 = dataInputStream.readInt();
                        if (this.f38431c) {
                            readUnsignedByte3 += this.f38432d;
                            this.f38432d = readUnsignedByte3;
                        }
                        j2 = readUnsignedByte3;
                        readUnsignedByte5 = dataInputStream.readInt();
                        a(j2, readUnsignedByte5, dVar, dataOutputStream);
                        j3 = this.totalLength + readUnsignedByte5;
                    case 255:
                        readUnsignedByte3 = dataInputStream.readLong();
                        if (this.f38431c) {
                            readUnsignedByte3 += this.f38432d;
                            this.f38432d = readUnsignedByte3;
                        }
                        j2 = readUnsignedByte3;
                        readUnsignedByte5 = dataInputStream.readInt();
                        a(j2, readUnsignedByte5, dVar, dataOutputStream);
                        j3 = this.totalLength + readUnsignedByte5;
                    default:
                        throw new IllegalStateException("command " + readUnsignedByte5);
                }
            }
            a(readUnsignedByte5, dataInputStream, dataOutputStream);
            j3 = this.totalLength + readUnsignedByte5;
        }
    }

    public void patch(File file, File file2, File file3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, file, file2, file3) == null) {
            c cVar = new c(new RandomAccessFile(file, r.f42346a));
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
    }

    public void patch(byte[] bArr, InputStream inputStream, OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, bArr, inputStream, outputStream) == null) {
            patch(new a(bArr), inputStream, outputStream);
        }
    }

    public byte[] patch(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bArr, bArr2)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            patch(bArr, new ByteArrayInputStream(bArr2), byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeLL.objValue;
    }
}
