package com.baidu.fsg.base.utils.support;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.ContentUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.kwad.yoga.YogaNodeJNIBase;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes10.dex */
public class Base64 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DECODE = 0;
    public static final int DONT_GUNZIP = 4;
    public static final int DO_BREAK_LINES = 8;
    public static final int ENCODE = 1;
    public static final int GZIP = 2;
    public static final int NO_OPTIONS = 0;
    public static final int ORDERED = 32;
    public static final int URL_SAFE = 16;
    public static final int a = 76;

    /* renamed from: b  reason: collision with root package name */
    public static final byte f33921b = 61;

    /* renamed from: c  reason: collision with root package name */
    public static final byte f33922c = 10;

    /* renamed from: d  reason: collision with root package name */
    public static final String f33923d = "US-ASCII";

    /* renamed from: e  reason: collision with root package name */
    public static final byte f33924e = -5;

    /* renamed from: f  reason: collision with root package name */
    public static final byte f33925f = -1;

    /* renamed from: g  reason: collision with root package name */
    public static final byte[] f33926g;

    /* renamed from: h  reason: collision with root package name */
    public static final byte[] f33927h;

    /* renamed from: i  reason: collision with root package name */
    public static final byte[] f33928i;

    /* renamed from: j  reason: collision with root package name */
    public static final byte[] f33929j;
    public static final byte[] k;
    public static final byte[] l;
    public static final /* synthetic */ boolean m;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class InputStream extends FilterInputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f33930b;

        /* renamed from: c  reason: collision with root package name */
        public final int f33931c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f33932d;

        /* renamed from: e  reason: collision with root package name */
        public final int f33933e;

        /* renamed from: f  reason: collision with root package name */
        public final byte[] f33934f;

        /* renamed from: g  reason: collision with root package name */
        public int f33935g;

        /* renamed from: h  reason: collision with root package name */
        public int f33936h;

        /* renamed from: i  reason: collision with root package name */
        public int f33937i;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public InputStream(java.io.InputStream inputStream) {
            this(inputStream, 0);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((java.io.InputStream) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InputStream(java.io.InputStream inputStream, int i2) {
            super(inputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputStream, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super((java.io.InputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f33933e = i2;
            this.f33932d = (i2 & 8) > 0;
            boolean z = (i2 & 1) > 0;
            this.a = z;
            int i5 = z ? 4 : 3;
            this.f33931c = i5;
            this.f33930b = new byte[i5];
            this.f33935g = -1;
            this.f33937i = 0;
            this.f33934f = Base64.c(i2);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            InterceptResult invokeV;
            int read;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f33935g < 0) {
                    if (this.a) {
                        byte[] bArr = new byte[3];
                        int i2 = 0;
                        for (int i3 = 0; i3 < 3; i3++) {
                            int read2 = ((FilterInputStream) this).in.read();
                            if (read2 < 0) {
                                break;
                            }
                            bArr[i3] = (byte) read2;
                            i2++;
                        }
                        if (i2 <= 0) {
                            return -1;
                        }
                        Base64.b(bArr, 0, i2, this.f33930b, 0, this.f33933e);
                        this.f33935g = 0;
                        this.f33936h = 4;
                    } else {
                        byte[] bArr2 = new byte[4];
                        int i4 = 0;
                        while (i4 < 4) {
                            do {
                                read = ((FilterInputStream) this).in.read();
                                if (read < 0) {
                                    break;
                                }
                            } while (this.f33934f[read & 127] <= -5);
                            if (read < 0) {
                                break;
                            }
                            bArr2[i4] = (byte) read;
                            i4++;
                        }
                        if (i4 != 4) {
                            if (i4 == 0) {
                                return -1;
                            }
                            throw new IOException("Improperly padded Base64 input.");
                        }
                        this.f33936h = Base64.b(bArr2, 0, this.f33930b, 0, this.f33933e);
                        this.f33935g = 0;
                    }
                }
                int i5 = this.f33935g;
                if (i5 >= 0) {
                    if (i5 >= this.f33936h) {
                        return -1;
                    }
                    if (this.a && this.f33932d && this.f33937i >= 76) {
                        this.f33937i = 0;
                        return 10;
                    }
                    this.f33937i++;
                    byte[] bArr3 = this.f33930b;
                    int i6 = this.f33935g;
                    int i7 = i6 + 1;
                    this.f33935g = i7;
                    byte b2 = bArr3[i6];
                    if (i7 >= this.f33931c) {
                        this.f33935g = -1;
                    }
                    return b2 & 255;
                }
                throw new IOException("Error in Base64 code reading stream.");
            }
            return invokeV.intValue;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) throws IOException {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2, i3)) == null) {
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        break;
                    }
                    int read = read();
                    if (read >= 0) {
                        bArr[i2 + i4] = (byte) read;
                        i4++;
                    } else if (i4 == 0) {
                        return -1;
                    }
                }
                return i4;
            }
            return invokeLII.intValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class OutputStream extends FilterOutputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final int f33938b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f33939c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f33940d;

        /* renamed from: e  reason: collision with root package name */
        public final int f33941e;

        /* renamed from: f  reason: collision with root package name */
        public final byte[] f33942f;

        /* renamed from: g  reason: collision with root package name */
        public int f33943g;

        /* renamed from: h  reason: collision with root package name */
        public byte[] f33944h;

        /* renamed from: i  reason: collision with root package name */
        public int f33945i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f33946j;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public OutputStream(java.io.OutputStream outputStream) {
            this(outputStream, 1);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {outputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((java.io.OutputStream) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OutputStream(java.io.OutputStream outputStream, int i2) {
            super(outputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {outputStream, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super((java.io.OutputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f33939c = (i2 & 8) != 0;
            boolean z = (i2 & 1) != 0;
            this.a = z;
            int i5 = z ? 3 : 4;
            this.f33938b = i5;
            this.f33944h = new byte[i5];
            this.f33943g = 0;
            this.f33945i = 0;
            this.f33946j = false;
            this.f33940d = new byte[4];
            this.f33941e = i2;
            this.f33942f = Base64.c(i2);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                flushBase64();
                super.close();
                this.f33944h = null;
                ((FilterOutputStream) this).out = null;
            }
        }

        public void flushBase64() throws IOException {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (i2 = this.f33943g) <= 0) {
                return;
            }
            if (!this.a) {
                throw new IOException("Base64 input not properly padded.");
            }
            ((FilterOutputStream) this).out.write(Base64.b(this.f33940d, this.f33944h, i2, this.f33941e));
            this.f33943g = 0;
        }

        public void resumeEncoding() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f33946j = false;
            }
        }

        public void suspendEncoding() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                flushBase64();
                this.f33946j = true;
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                if (this.f33946j) {
                    ((FilterOutputStream) this).out.write(i2);
                    return;
                }
                if (this.a) {
                    byte[] bArr = this.f33944h;
                    int i3 = this.f33943g;
                    int i4 = i3 + 1;
                    this.f33943g = i4;
                    bArr[i3] = (byte) i2;
                    int i5 = this.f33938b;
                    if (i4 < i5) {
                        return;
                    }
                    ((FilterOutputStream) this).out.write(Base64.b(this.f33940d, bArr, i5, this.f33941e));
                    int i6 = this.f33945i + 4;
                    this.f33945i = i6;
                    if (this.f33939c && i6 >= 76) {
                        ((FilterOutputStream) this).out.write(10);
                        this.f33945i = 0;
                    }
                } else {
                    byte[] bArr2 = this.f33942f;
                    int i7 = i2 & 127;
                    if (bArr2[i7] <= -5) {
                        if (bArr2[i7] != -5) {
                            throw new IOException("Invalid character in Base64 data.");
                        }
                        return;
                    }
                    byte[] bArr3 = this.f33944h;
                    int i8 = this.f33943g;
                    int i9 = i8 + 1;
                    this.f33943g = i9;
                    bArr3[i8] = (byte) i2;
                    if (i9 < this.f33938b) {
                        return;
                    }
                    ((FilterOutputStream) this).out.write(this.f33940d, 0, Base64.b(bArr3, 0, this.f33940d, 0, this.f33941e));
                }
                this.f33943g = 0;
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048581, this, bArr, i2, i3) == null) {
                if (this.f33946j) {
                    ((FilterOutputStream) this).out.write(bArr, i2, i3);
                    return;
                }
                for (int i4 = 0; i4 < i3; i4++) {
                    write(bArr[i2 + i4]);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2118589651, "Lcom/baidu/fsg/base/utils/support/Base64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2118589651, "Lcom/baidu/fsg/base/utils/support/Base64;");
                return;
            }
        }
        m = !Base64.class.desiredAssertionStatus();
        f33926g = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        f33927h = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, StandardMessageCodec.LIST, 13, 14, 15, YogaNodeJNIBase.HAS_NEW_LAYOUT, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, com.baidu.webkit.internal.Base64.INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, 42, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        f33928i = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, UtilsBlink.VER_TYPE_SEPARATOR, 95};
        f33929j = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, StandardMessageCodec.LIST, 13, 14, 15, YogaNodeJNIBase.HAS_NEW_LAYOUT, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, com.baidu.webkit.internal.Base64.INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, 42, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        k = new byte[]{UtilsBlink.VER_TYPE_SEPARATOR, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122};
        l = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, StandardMessageCodec.LIST, 13, 14, 15, YogaNodeJNIBase.HAS_NEW_LAYOUT, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, com.baidu.webkit.internal.Base64.INTERNAL_PADDING, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, UtilsBlink.VER_TYPE_SEPARATOR, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    }

    public Base64() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int b(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{bArr, Integer.valueOf(i2), bArr2, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (bArr != null) {
                if (bArr2 != null) {
                    if (i2 < 0 || (i5 = i2 + 3) >= bArr.length) {
                        throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i2)));
                    }
                    if (i3 < 0 || (i6 = i3 + 2) >= bArr2.length) {
                        throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i3)));
                    }
                    byte[] c2 = c(i4);
                    int i7 = i2 + 2;
                    if (bArr[i7] == 61) {
                        bArr2[i3] = (byte) ((((c2[bArr[i2 + 1]] & 255) << 12) | ((c2[bArr[i2]] & 255) << 18)) >>> 16);
                        return 1;
                    } else if (bArr[i5] == 61) {
                        int i8 = ((c2[bArr[i7]] & 255) << 6) | ((c2[bArr[i2 + 1]] & 255) << 12) | ((c2[bArr[i2]] & 255) << 18);
                        bArr2[i3] = (byte) (i8 >>> 16);
                        bArr2[i3 + 1] = (byte) (i8 >>> 8);
                        return 2;
                    } else {
                        int i9 = (c2[bArr[i5]] & 255) | ((c2[bArr[i2 + 1]] & 255) << 12) | ((c2[bArr[i2]] & 255) << 18) | ((c2[bArr[i7]] & 255) << 6);
                        bArr2[i3] = (byte) (i9 >> 16);
                        bArr2[i3 + 1] = (byte) (i9 >> 8);
                        bArr2[i6] = (byte) i9;
                        return 3;
                    }
                }
                throw new NullPointerException("Destination array was null.");
            }
            throw new NullPointerException("Source array was null.");
        }
        return invokeCommon.intValue;
    }

    public static final byte[] b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) ? (i2 & 16) == 16 ? f33928i : (i2 & 32) == 32 ? k : f33926g : (byte[]) invokeI.objValue;
    }

    public static byte[] b(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), bArr2, Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            byte[] b2 = b(i5);
            int i6 = (i3 > 0 ? (bArr[i2] << 24) >>> 8 : 0) | (i3 > 1 ? (bArr[i2 + 1] << 24) >>> 16 : 0) | (i3 > 2 ? (bArr[i2 + 2] << 24) >>> 24 : 0);
            if (i3 == 1) {
                bArr2[i4] = b2[i6 >>> 18];
                bArr2[i4 + 1] = b2[(i6 >>> 12) & 63];
                bArr2[i4 + 2] = 61;
                bArr2[i4 + 3] = 61;
                return bArr2;
            } else if (i3 == 2) {
                bArr2[i4] = b2[i6 >>> 18];
                bArr2[i4 + 1] = b2[(i6 >>> 12) & 63];
                bArr2[i4 + 2] = b2[(i6 >>> 6) & 63];
                bArr2[i4 + 3] = 61;
                return bArr2;
            } else if (i3 != 3) {
                return bArr2;
            } else {
                bArr2[i4] = b2[i6 >>> 18];
                bArr2[i4 + 1] = b2[(i6 >>> 12) & 63];
                bArr2[i4 + 2] = b2[(i6 >>> 6) & 63];
                bArr2[i4 + 3] = b2[i6 & 63];
                return bArr2;
            }
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65545, null, bArr, bArr2, i2, i3)) == null) {
            b(bArr2, 0, i2, bArr, 0, i3);
            return bArr;
        }
        return (byte[]) invokeLLII.objValue;
    }

    public static final byte[] c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) ? (i2 & 16) == 16 ? f33929j : (i2 & 32) == 32 ? l : f33927h : (byte[]) invokeI.objValue;
    }

    public static byte[] decode(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) ? decode(str, 0) : (byte[]) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x0064 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0066 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x0068 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:67:0x005d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:87:0x003d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x005d -> B:85:0x005d). Please submit an issue!!! */
    public static byte[] decode(String str, int i2) throws IOException {
        GZIPInputStream gZIPInputStream;
        byte[] bytes;
        ByteArrayInputStream length;
        GZIPInputStream gZIPInputStream2;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            gZIPInputStream = null;
            InterceptResult invokeLI = interceptable.invokeLI(65548, null, str, i2);
            if (invokeLI != null) {
                return (byte[]) invokeLI.objValue;
            }
        }
        if (str != null) {
            try {
                bytes = str.getBytes("US-ASCII");
            } catch (UnsupportedEncodingException unused) {
                bytes = str.getBytes();
            }
            byte[] decode = decode(bytes, 0, bytes.length, i2);
            boolean z = (i2 & 4) != 0;
            if (decode != null && (length = decode.length) >= 4 && !z && 35615 == ((decode[0] & 255) | ((decode[1] << 8) & 65280))) {
                byte[] bArr = new byte[2048];
                ByteArrayOutputStream byteArrayOutputStream = 0;
                try {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            length = new ByteArrayInputStream(decode);
                            try {
                                gZIPInputStream = new GZIPInputStream(length);
                                while (true) {
                                    try {
                                        int read = gZIPInputStream.read(bArr);
                                        if (read < 0) {
                                            break;
                                        }
                                        byteArrayOutputStream2.write(bArr, 0, read);
                                    } catch (IOException e2) {
                                        e = e2;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        length = length;
                                        try {
                                            e.printStackTrace();
                                            byteArrayOutputStream.close();
                                            gZIPInputStream.close();
                                            length.close();
                                            return decode;
                                        } catch (Throwable th) {
                                            th = th;
                                            byteArrayOutputStream2 = byteArrayOutputStream;
                                            byteArrayOutputStream = gZIPInputStream;
                                            gZIPInputStream2 = byteArrayOutputStream;
                                            byteArrayInputStream2 = length;
                                            byteArrayOutputStream = byteArrayOutputStream2;
                                            byteArrayInputStream = byteArrayInputStream2;
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Exception unused2) {
                                            }
                                            try {
                                                gZIPInputStream2.close();
                                            } catch (Exception unused3) {
                                            }
                                            try {
                                                byteArrayInputStream.close();
                                            } catch (Exception unused4) {
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        byteArrayOutputStream = gZIPInputStream;
                                        gZIPInputStream2 = byteArrayOutputStream;
                                        byteArrayInputStream2 = length;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        byteArrayInputStream = byteArrayInputStream2;
                                        byteArrayOutputStream.close();
                                        gZIPInputStream2.close();
                                        byteArrayInputStream.close();
                                        throw th;
                                    }
                                }
                                decode = byteArrayOutputStream2.toByteArray();
                                byteArrayOutputStream2.close();
                            } catch (IOException e3) {
                                e = e3;
                                gZIPInputStream = null;
                            } catch (Throwable th3) {
                                th = th3;
                                gZIPInputStream2 = byteArrayOutputStream;
                                byteArrayInputStream2 = length;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                byteArrayInputStream = byteArrayInputStream2;
                                byteArrayOutputStream.close();
                                gZIPInputStream2.close();
                                byteArrayInputStream.close();
                                throw th;
                            }
                        } catch (IOException e4) {
                            e = e4;
                            length = null;
                            gZIPInputStream = null;
                        } catch (Throwable th4) {
                            th = th4;
                            gZIPInputStream2 = null;
                            byteArrayInputStream2 = null;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            byteArrayInputStream = byteArrayInputStream2;
                            byteArrayOutputStream.close();
                            gZIPInputStream2.close();
                            byteArrayInputStream.close();
                            throw th;
                        }
                    } catch (Exception unused5) {
                    }
                } catch (IOException e5) {
                    e = e5;
                    length = null;
                    gZIPInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    gZIPInputStream2 = null;
                    byteArrayInputStream = null;
                    byteArrayOutputStream.close();
                    gZIPInputStream2.close();
                    byteArrayInputStream.close();
                    throw th;
                }
                try {
                    gZIPInputStream.close();
                } catch (Exception unused6) {
                }
                try {
                    length.close();
                } catch (Exception unused7) {
                }
            }
            return decode;
        }
        throw new NullPointerException("Input string was null.");
    }

    public static byte[] decode(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, bArr)) == null) ? decode(bArr, 0, bArr.length, 0) : (byte[]) invokeL.objValue;
    }

    public static byte[] decode(byte[] bArr, int i2, int i3, int i4) throws IOException {
        InterceptResult invokeLIII;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65550, null, bArr, i2, i3, i4)) == null) {
            if (bArr != null) {
                if (i2 < 0 || (i5 = i2 + i3) > bArr.length) {
                    throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
                }
                if (i3 == 0) {
                    return new byte[0];
                }
                if (i3 < 4) {
                    throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + i3);
                }
                byte[] c2 = c(i4);
                byte[] bArr2 = new byte[(i3 * 3) / 4];
                byte[] bArr3 = new byte[4];
                int i6 = 0;
                int i7 = 0;
                while (i2 < i5) {
                    byte b2 = c2[bArr[i2] & 255];
                    if (b2 < -5) {
                        throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", Integer.valueOf(bArr[i2] & 255), Integer.valueOf(i2)));
                    }
                    if (b2 >= -1) {
                        int i8 = i6 + 1;
                        bArr3[i6] = bArr[i2];
                        if (i8 > 3) {
                            i7 += b(bArr3, 0, bArr2, i7, i4);
                            if (bArr[i2] == 61) {
                                break;
                            }
                            i6 = 0;
                        } else {
                            i6 = i8;
                        }
                    }
                    i2++;
                }
                byte[] bArr4 = new byte[i7];
                System.arraycopy(bArr2, 0, bArr4, 0, i7);
                return bArr4;
            }
            throw new NullPointerException("Cannot decode null source array.");
        }
        return (byte[]) invokeLIII.objValue;
    }

    public static void decodeFileToFile(String str, String str2) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, str, str2) == null) {
            byte[] decodeFromFile = decodeFromFile(str);
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    bufferedOutputStream.write(decodeFromFile);
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream2 = bufferedOutputStream;
                    try {
                        bufferedOutputStream2.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                throw e3;
            }
        }
    }

    public static byte[] decodeFromFile(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65552, null, str)) != null) {
            return (byte[]) invokeL.objValue;
        }
        InputStream inputStream = null;
        try {
            try {
                File file = new File(str);
                if (file.length() > 2147483647L) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("File is too big for this convenience method (");
                    sb.append(file.length());
                    sb.append(" bytes).");
                    throw new IOException(sb.toString());
                }
                byte[] bArr = new byte[(int) file.length()];
                InputStream inputStream2 = new InputStream(new BufferedInputStream(new FileInputStream(file)), 0);
                int i2 = 0;
                while (true) {
                    try {
                        int read = inputStream2.read(bArr, i2, 4096);
                        if (read < 0) {
                            break;
                        }
                        i2 += read;
                    } catch (IOException e2) {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                        throw th;
                    }
                }
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, 0, bArr2, 0, i2);
                try {
                    inputStream2.close();
                } catch (Exception unused2) {
                }
                return bArr2;
            } catch (IOException e3) {
                throw e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void decodeToFile(String str, String str2) throws IOException {
        OutputStream outputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, str, str2) == null) {
            OutputStream outputStream2 = null;
            try {
                try {
                    outputStream = new OutputStream(new FileOutputStream(str2), 0);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    outputStream.write(str.getBytes("US-ASCII"));
                    try {
                        outputStream.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                } catch (Throwable th2) {
                    th = th2;
                    outputStream2 = outputStream;
                    try {
                        outputStream2.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                throw e3;
            }
        }
    }

    public static Object decodeToObject(String str) throws IOException, ClassNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) ? decodeToObject(str, 0, null) : invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: java.io.ByteArrayInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: java.io.ByteArrayInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r5v3, resolved type: java.io.ByteArrayInputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public static Object decodeToObject(String str, int i2, ClassLoader classLoader) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream;
        Interceptable interceptable = $ic;
        InterceptResult interceptResult = interceptable;
        if (interceptable != null) {
            InterceptResult invokeLIL = interceptable.invokeLIL(65555, null, str, i2, classLoader);
            interceptResult = invokeLIL;
            if (invokeLIL != null) {
                return invokeLIL.objValue;
            }
        }
        byte[] decode = decode(str, i2);
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            try {
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(decode);
                try {
                    ObjectInputStream objectInputStream2 = classLoader == null ? new ObjectInputStream(byteArrayInputStream2) : new ObjectInputStream(byteArrayInputStream2, classLoader) { // from class: com.baidu.fsg.base.utils.support.Base64.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ClassLoader a;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(byteArrayInputStream2);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {byteArrayInputStream2, classLoader};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    super((java.io.InputStream) newInitContext.callArgs[0]);
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = classLoader;
                        }

                        @Override // java.io.ObjectInputStream
                        public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
                            InterceptResult invokeL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, objectStreamClass)) == null) {
                                Class<?> cls = Class.forName(objectStreamClass.getName(), false, this.a);
                                return cls == null ? super.resolveClass(objectStreamClass) : cls;
                            }
                            return (Class) invokeL.objValue;
                        }
                    };
                    Object readObject = objectInputStream2.readObject();
                    try {
                        byteArrayInputStream2.close();
                    } catch (Exception unused) {
                    }
                    try {
                        objectInputStream2.close();
                    } catch (Exception unused2) {
                    }
                    return readObject;
                } catch (IOException e2) {
                    throw e2;
                } catch (ClassNotFoundException e3) {
                    throw e3;
                }
            } catch (Throwable th) {
                th = th;
                objectInputStream = null;
                byteArrayInputStream = interceptResult;
                try {
                    byteArrayInputStream.close();
                } catch (Exception unused3) {
                }
                try {
                    objectInputStream.close();
                } catch (Exception unused4) {
                }
                throw th;
            }
        } catch (IOException e4) {
            throw e4;
        } catch (ClassNotFoundException e5) {
            throw e5;
        } catch (Throwable th2) {
            th = th2;
            objectInputStream = null;
            byteArrayInputStream.close();
            objectInputStream.close();
            throw th;
        }
    }

    public static void encode(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, byteBuffer, byteBuffer2) == null) {
            byte[] bArr = new byte[3];
            byte[] bArr2 = new byte[4];
            while (byteBuffer.hasRemaining()) {
                int min = Math.min(3, byteBuffer.remaining());
                byteBuffer.get(bArr, 0, min);
                b(bArr2, bArr, min, 0);
                byteBuffer2.put(bArr2);
            }
        }
    }

    public static void encode(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, null, byteBuffer, charBuffer) == null) {
            byte[] bArr = new byte[3];
            byte[] bArr2 = new byte[4];
            while (byteBuffer.hasRemaining()) {
                int min = Math.min(3, byteBuffer.remaining());
                byteBuffer.get(bArr, 0, min);
                b(bArr2, bArr, min, 0);
                for (int i2 = 0; i2 < 4; i2++) {
                    charBuffer.put((char) (bArr2[i2] & 255));
                }
            }
        }
    }

    public static String encodeBytes(byte[] bArr) {
        String str;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, bArr)) == null) {
            try {
                str = encodeBytes(bArr, 0, bArr.length, 0);
            } catch (IOException e2) {
                if (!m) {
                    throw new AssertionError(e2.getMessage());
                }
                str = null;
            }
            if (m || str != null) {
                return str;
            }
            throw new AssertionError();
        }
        return (String) invokeL.objValue;
    }

    public static String encodeBytes(byte[] bArr, int i2) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65559, null, bArr, i2)) == null) ? encodeBytes(bArr, 0, bArr.length, i2) : (String) invokeLI.objValue;
    }

    public static String encodeBytes(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65560, null, bArr, i2, i3)) == null) {
            try {
                str = encodeBytes(bArr, i2, i3, 0);
            } catch (IOException e2) {
                if (!m) {
                    throw new AssertionError(e2.getMessage());
                }
                str = null;
            }
            if (m || str != null) {
                return str;
            }
            throw new AssertionError();
        }
        return (String) invokeLII.objValue;
    }

    public static String encodeBytes(byte[] bArr, int i2, int i3, int i4) throws IOException {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65561, null, bArr, i2, i3, i4)) == null) {
            byte[] encodeBytesToBytes = encodeBytesToBytes(bArr, i2, i3, i4);
            try {
                return new String(encodeBytesToBytes, "US-ASCII");
            } catch (UnsupportedEncodingException unused) {
                return new String(encodeBytesToBytes);
            }
        }
        return (String) invokeLIII.objValue;
    }

    public static byte[] encodeBytesToBytes(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, bArr)) == null) {
            try {
                return encodeBytesToBytes(bArr, 0, bArr.length, 0);
            } catch (IOException e2) {
                if (m) {
                    return null;
                }
                throw new AssertionError("IOExceptions only come from GZipping, which is turned off: " + e2.getMessage());
            }
        }
        return (byte[]) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0046 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v18, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r2v19, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    public static byte[] encodeBytesToBytes(byte[] bArr, int i2, int i3, int i4) throws IOException {
        InterceptResult invokeLIII;
        OutputStream outputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLIII = interceptable.invokeLIII(65563, null, bArr, i2, i3, i4)) != null) {
            return (byte[]) invokeLIII.objValue;
        }
        if (bArr == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i2);
        } else if (i3 < 0) {
            throw new IllegalArgumentException("Cannot have length offset: " + i3);
        } else {
            int i5 = i2 + i3;
            ?? length = bArr.length;
            if (i5 > length) {
                throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bArr.length)));
            }
            if ((i4 & 2) == 0) {
                boolean z = (i4 & 8) != 0;
                int i6 = ((i3 / 3) * 4) + (i3 % 3 > 0 ? 4 : 0);
                if (z) {
                    i6 += i6 / 76;
                }
                int i7 = i6;
                byte[] bArr2 = new byte[i7];
                int i8 = i3 - 2;
                int i9 = 0;
                int i10 = 0;
                int i11 = 0;
                while (i9 < i8) {
                    int i12 = i9;
                    b(bArr, i9 + i2, 3, bArr2, i10, i4);
                    int i13 = i11 + 4;
                    if (!z || i13 < 76) {
                        i11 = i13;
                    } else {
                        bArr2[i10 + 4] = 10;
                        i10++;
                        i11 = 0;
                    }
                    i9 = i12 + 3;
                    i10 += 4;
                }
                int i14 = i9;
                if (i14 < i3) {
                    b(bArr, i14 + i2, i3 - i14, bArr2, i10, i4);
                    i10 += 4;
                }
                int i15 = i10;
                if (i15 <= i7 - 1) {
                    byte[] bArr3 = new byte[i15];
                    System.arraycopy(bArr2, 0, bArr3, 0, i15);
                    return bArr3;
                }
                return bArr2;
            }
            GZIPOutputStream gZIPOutputStream = null;
            try {
                try {
                    length = new ByteArrayOutputStream();
                    try {
                        outputStream = new OutputStream(length, i4 | 1);
                        try {
                            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(outputStream);
                            try {
                                gZIPOutputStream2.write(bArr, i2, i3);
                                gZIPOutputStream2.close();
                                try {
                                    gZIPOutputStream2.close();
                                } catch (Exception unused) {
                                }
                                try {
                                    outputStream.close();
                                } catch (Exception unused2) {
                                }
                                try {
                                    length.close();
                                } catch (Exception unused3) {
                                }
                                return length.toByteArray();
                            } catch (IOException e2) {
                                throw e2;
                            } catch (Throwable th) {
                                th = th;
                                gZIPOutputStream = gZIPOutputStream2;
                                try {
                                    gZIPOutputStream.close();
                                } catch (Exception unused4) {
                                }
                                try {
                                    outputStream.close();
                                } catch (Exception unused5) {
                                }
                                try {
                                    length.close();
                                } catch (Exception unused6) {
                                }
                                throw th;
                            }
                        } catch (IOException e3) {
                            throw e3;
                        }
                    } catch (IOException e4) {
                        throw e4;
                    } catch (Throwable th2) {
                        th = th2;
                        outputStream = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e5) {
                throw e5;
            } catch (Throwable th4) {
                th = th4;
                length = 0;
                outputStream = null;
            }
        }
    }

    public static void encodeFileToFile(String str, String str2) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65564, null, str, str2) == null) {
            String encodeFromFile = encodeFromFile(str);
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
                } catch (IOException e2) {
                    throw e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                bufferedOutputStream.write(encodeFromFile.getBytes("US-ASCII"));
                try {
                    bufferedOutputStream.close();
                } catch (Exception unused) {
                }
            } catch (IOException e3) {
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream2 = bufferedOutputStream;
                try {
                    bufferedOutputStream2.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
    }

    public static String encodeFromFile(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65565, null, str)) != null) {
            return (String) invokeL.objValue;
        }
        InputStream inputStream = null;
        try {
            try {
                File file = new File(str);
                byte[] bArr = new byte[Math.max((int) ((file.length() * 1.4d) + 1.0d), 40)];
                InputStream inputStream2 = new InputStream(new BufferedInputStream(new FileInputStream(file)), 1);
                int i2 = 0;
                while (true) {
                    try {
                        int read = inputStream2.read(bArr, i2, 4096);
                        if (read < 0) {
                            break;
                        }
                        i2 += read;
                    } catch (IOException e2) {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                        throw th;
                    }
                }
                String str2 = new String(bArr, 0, i2, "US-ASCII");
                try {
                    inputStream2.close();
                } catch (Exception unused2) {
                }
                return str2;
            } catch (IOException e3) {
                throw e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String encodeObject(Serializable serializable) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65566, null, serializable)) == null) ? encodeObject(serializable, 0) : (String) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:13:0x0023 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:80:? */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v17, types: [java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v21, types: [java.io.OutputStream, java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    public static String encodeObject(Serializable serializable, int i2) throws IOException {
        InterceptResult invokeLI;
        ?? r6;
        ByteArrayOutputStream byteArrayOutputStream;
        OutputStream outputStream;
        ObjectOutputStream objectOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(65567, null, serializable, i2)) != null) {
            return (String) invokeLI.objValue;
        }
        if (serializable == null) {
            throw new NullPointerException("Cannot serialize a null object.");
        }
        ObjectOutputStream objectOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                outputStream = new OutputStream(byteArrayOutputStream, i2 | 1);
                try {
                    if ((i2 & 2) != 0) {
                        r6 = new GZIPOutputStream(outputStream);
                        try {
                            try {
                                objectOutputStream2 = new ObjectOutputStream(r6);
                                r6 = r6;
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    objectOutputStream2.close();
                                } catch (Exception unused) {
                                }
                                try {
                                    r6.close();
                                } catch (Exception unused2) {
                                }
                                try {
                                    outputStream.close();
                                } catch (Exception unused3) {
                                }
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception unused4) {
                                }
                                throw th;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            ObjectOutputStream objectOutputStream3 = objectOutputStream2;
                            objectOutputStream2 = r6;
                            objectOutputStream = objectOutputStream3;
                            try {
                                throw e;
                            } catch (Throwable th2) {
                                th = th2;
                                ObjectOutputStream objectOutputStream4 = objectOutputStream2;
                                objectOutputStream2 = objectOutputStream;
                                r6 = objectOutputStream4;
                                objectOutputStream2.close();
                                r6.close();
                                outputStream.close();
                                byteArrayOutputStream.close();
                                throw th;
                            }
                        }
                    } else {
                        objectOutputStream2 = new ObjectOutputStream(outputStream);
                        r6 = 0;
                    }
                    try {
                        objectOutputStream2.writeObject(serializable);
                        try {
                            objectOutputStream2.close();
                        } catch (Exception unused5) {
                        }
                        try {
                            r6.close();
                        } catch (Exception unused6) {
                        }
                        try {
                            outputStream.close();
                        } catch (Exception unused7) {
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused8) {
                        }
                        try {
                            return new String(byteArrayOutputStream.toByteArray(), "US-ASCII");
                        } catch (UnsupportedEncodingException unused9) {
                            return new String(byteArrayOutputStream.toByteArray());
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        ObjectOutputStream objectOutputStream5 = objectOutputStream2;
                        objectOutputStream2 = r6;
                        objectOutputStream = objectOutputStream5;
                        ObjectOutputStream objectOutputStream42 = objectOutputStream2;
                        objectOutputStream2 = objectOutputStream;
                        r6 = objectOutputStream42;
                        objectOutputStream2.close();
                        r6.close();
                        outputStream.close();
                        byteArrayOutputStream.close();
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    objectOutputStream = objectOutputStream2;
                } catch (Throwable th4) {
                    th = th4;
                    r6 = objectOutputStream2;
                }
            } catch (IOException e4) {
                e = e4;
                objectOutputStream = null;
                outputStream = null;
            } catch (Throwable th5) {
                th = th5;
                r6 = 0;
                outputStream = null;
            }
        } catch (IOException e5) {
            e = e5;
            objectOutputStream = null;
            byteArrayOutputStream = null;
            outputStream = null;
        } catch (Throwable th6) {
            th = th6;
            r6 = 0;
            byteArrayOutputStream = null;
            outputStream = null;
        }
    }

    public static void encodeToFile(byte[] bArr, String str) throws IOException {
        OutputStream outputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65568, null, bArr, str) == null) {
            if (bArr == null) {
                throw new NullPointerException("Data to encode was null.");
            }
            OutputStream outputStream2 = null;
            try {
                try {
                    outputStream = new OutputStream(new FileOutputStream(str), 1);
                } catch (IOException e2) {
                    throw e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                outputStream.write(bArr);
                try {
                    outputStream.close();
                } catch (Exception unused) {
                }
            } catch (IOException e3) {
            } catch (Throwable th2) {
                th = th2;
                outputStream2 = outputStream;
                try {
                    outputStream2.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
    }
}
