package com.baidu.mobstat;

import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.codec.binary4util.BaseNCodec;
/* loaded from: classes2.dex */
public class dh {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ boolean a;
    public static final byte[] b;
    public static final byte[] c;
    public static final byte[] d;
    public static final byte[] e;
    public static final byte[] f;
    public static final byte[] g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a extends FilterOutputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public int b;
        public byte[] c;
        public int d;
        public int e;
        public boolean f;
        public byte[] g;
        public boolean h;
        public int i;
        public byte[] j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(OutputStream outputStream, int i) {
            super(outputStream);
            boolean z;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {outputStream, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super((OutputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if ((i & 8) != 0) {
                z = true;
            } else {
                z = false;
            }
            this.f = z;
            boolean z2 = (i & 1) != 0;
            this.a = z2;
            if (z2) {
                i2 = 3;
            } else {
                i2 = 4;
            }
            this.d = i2;
            this.c = new byte[i2];
            this.b = 0;
            this.e = 0;
            this.h = false;
            this.g = new byte[4];
            this.i = i;
            this.j = dh.c(i);
        }

        public void a() throws IOException {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (i = this.b) > 0) {
                if (this.a) {
                    ((FilterOutputStream) this).out.write(dh.b(this.g, this.c, i, this.i));
                    this.b = 0;
                    return;
                }
                throw new IOException("Base64 input not properly padded.");
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a();
                super.close();
                this.c = null;
                ((FilterOutputStream) this).out = null;
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                if (this.h) {
                    ((FilterOutputStream) this).out.write(i);
                } else if (this.a) {
                    byte[] bArr = this.c;
                    int i2 = this.b;
                    int i3 = i2 + 1;
                    this.b = i3;
                    bArr[i2] = (byte) i;
                    int i4 = this.d;
                    if (i3 >= i4) {
                        ((FilterOutputStream) this).out.write(dh.b(this.g, bArr, i4, this.i));
                        int i5 = this.e + 4;
                        this.e = i5;
                        if (this.f && i5 >= 76) {
                            ((FilterOutputStream) this).out.write(10);
                            this.e = 0;
                        }
                        this.b = 0;
                    }
                } else {
                    byte[] bArr2 = this.j;
                    int i6 = i & 127;
                    if (bArr2[i6] > -5) {
                        byte[] bArr3 = this.c;
                        int i7 = this.b;
                        int i8 = i7 + 1;
                        this.b = i8;
                        bArr3[i7] = (byte) i;
                        if (i8 >= this.d) {
                            ((FilterOutputStream) this).out.write(this.g, 0, dh.b(bArr3, 0, this.g, 0, this.i));
                            this.b = 0;
                        }
                    } else if (bArr2[i6] == -5) {
                    } else {
                        throw new IOException("Invalid character in Base64 data.");
                    }
                }
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048579, this, bArr, i, i2) == null) {
                if (this.h) {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                    return;
                }
                for (int i3 = 0; i3 < i2; i3++) {
                    write(bArr[i + i3]);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581659950, "Lcom/baidu/mobstat/dh;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581659950, "Lcom/baidu/mobstat/dh;");
                return;
            }
        }
        a = !dh.class.desiredAssertionStatus();
        b = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        c = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, BaseNCodec.PAD_DEFAULT, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Constants.GZIP_CAST_TYPE, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, Base64.INTERNAL_PADDING, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_2_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 40, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, ExifInterface.START_CODE, 43, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 45, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        d = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        e = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, BaseNCodec.PAD_DEFAULT, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Constants.GZIP_CAST_TYPE, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, Base64.INTERNAL_PADDING, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_2_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 40, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, ExifInterface.START_CODE, 43, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 45, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        f = new byte[]{45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
        g = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, Constants.GZIP_CAST_TYPE, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, Base64.INTERNAL_PADDING, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, -9, -9, -9, -9, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_2_ROWS, -9, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 40, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, ExifInterface.START_CODE, 43, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 45, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, BaseNCodec.PAD_DEFAULT, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    }

    public dh() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String a(byte[] bArr) {
        String str;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            try {
                str = a(bArr, 0, bArr.length, 0);
            } catch (IOException e2) {
                if (a) {
                    str = null;
                } else {
                    throw new AssertionError(e2.getMessage());
                }
            }
            if (!a && str == null) {
                throw new AssertionError();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String a(byte[] bArr, int i, int i2, int i3) throws IOException {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i, i2, i3)) == null) {
            byte[] b2 = b(bArr, i, i2, i3);
            try {
                return new String(b2, "US-ASCII");
            } catch (UnsupportedEncodingException unused) {
                return new String(b2);
            }
        }
        return (String) invokeLIII.objValue;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65547, null, bArr, bArr2, i, i2)) == null) {
            a(bArr2, 0, i, bArr, 0, i2);
            return bArr;
        }
        return (byte[]) invokeLLII.objValue;
    }

    public static final byte[] b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) {
            if ((i & 16) == 16) {
                return d;
            }
            if ((i & 32) == 32) {
                return f;
            }
            return b;
        }
        return (byte[]) invokeI.objValue;
    }

    public static final byte[] c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i)) == null) {
            if ((i & 16) == 16) {
                return e;
            }
            if ((i & 32) == 32) {
                return g;
            }
            return c;
        }
        return (byte[]) invokeI.objValue;
    }

    public static byte[] a(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), bArr2, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            byte[] b2 = b(i4);
            int i7 = 0;
            if (i2 > 0) {
                i5 = (bArr[i] << 24) >>> 8;
            } else {
                i5 = 0;
            }
            if (i2 > 1) {
                i6 = (bArr[i + 1] << 24) >>> 16;
            } else {
                i6 = 0;
            }
            int i8 = i5 | i6;
            if (i2 > 2) {
                i7 = (bArr[i + 2] << 24) >>> 24;
            }
            int i9 = i8 | i7;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return bArr2;
                    }
                    bArr2[i3] = b2[i9 >>> 18];
                    bArr2[i3 + 1] = b2[(i9 >>> 12) & 63];
                    bArr2[i3 + 2] = b2[(i9 >>> 6) & 63];
                    bArr2[i3 + 3] = b2[i9 & 63];
                    return bArr2;
                }
                bArr2[i3] = b2[i9 >>> 18];
                bArr2[i3 + 1] = b2[(i9 >>> 12) & 63];
                bArr2[i3 + 2] = b2[(i9 >>> 6) & 63];
                bArr2[i3 + 3] = BaseNCodec.PAD_DEFAULT;
                return bArr2;
            }
            bArr2[i3] = b2[i9 >>> 18];
            bArr2[i3 + 1] = b2[(i9 >>> 12) & 63];
            bArr2[i3 + 2] = BaseNCodec.PAD_DEFAULT;
            bArr2[i3 + 3] = BaseNCodec.PAD_DEFAULT;
            return bArr2;
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static int b(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        InterceptResult invokeCommon;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (bArr != null) {
                if (bArr2 != null) {
                    if (i >= 0 && (i4 = i + 3) < bArr.length) {
                        if (i2 >= 0 && (i5 = i2 + 2) < bArr2.length) {
                            byte[] c2 = c(i3);
                            int i6 = i + 2;
                            if (bArr[i6] == 61) {
                                bArr2[i2] = (byte) ((((c2[bArr[i + 1]] & 255) << 12) | ((c2[bArr[i]] & 255) << 18)) >>> 16);
                                return 1;
                            } else if (bArr[i4] == 61) {
                                int i7 = ((c2[bArr[i6]] & 255) << 6) | ((c2[bArr[i + 1]] & 255) << 12) | ((c2[bArr[i]] & 255) << 18);
                                bArr2[i2] = (byte) (i7 >>> 16);
                                bArr2[i2 + 1] = (byte) (i7 >>> 8);
                                return 2;
                            } else {
                                int i8 = (c2[bArr[i4]] & 255) | ((c2[bArr[i + 1]] & 255) << 12) | ((c2[bArr[i]] & 255) << 18) | ((c2[bArr[i6]] & 255) << 6);
                                bArr2[i2] = (byte) (i8 >> 16);
                                bArr2[i2 + 1] = (byte) (i8 >> 8);
                                bArr2[i5] = (byte) i8;
                                return 3;
                            }
                        }
                        throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i2)));
                    }
                    throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i)));
                }
                throw new NullPointerException("Destination array was null.");
            }
            throw new NullPointerException("Source array was null.");
        }
        return invokeCommon.intValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0040 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0044 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v16, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v17, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v19, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v20, resolved type: java.io.ByteArrayOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] b(byte[] bArr, int i, int i2, int i3) throws IOException {
        InterceptResult invokeLIII;
        boolean z;
        int i4;
        ByteArrayOutputStream byteArrayOutputStream;
        a aVar;
        GZIPOutputStream gZIPOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65546, null, bArr, i, i2, i3)) == null) {
            if (bArr != null) {
                if (i >= 0) {
                    if (i2 >= 0) {
                        if (i + i2 <= bArr.length) {
                            if ((i3 & 2) != 0) {
                                GZIPOutputStream gZIPOutputStream2 = null;
                                try {
                                    byteArrayOutputStream = new ByteArrayOutputStream();
                                    try {
                                        aVar = new a(byteArrayOutputStream, i3 | 1);
                                        try {
                                            gZIPOutputStream = new GZIPOutputStream(aVar);
                                            try {
                                                gZIPOutputStream.write(bArr, i, i2);
                                                gZIPOutputStream.close();
                                                try {
                                                    gZIPOutputStream.close();
                                                } catch (Exception unused) {
                                                }
                                                try {
                                                    aVar.close();
                                                } catch (Exception unused2) {
                                                }
                                                try {
                                                    byteArrayOutputStream.close();
                                                } catch (Exception unused3) {
                                                }
                                                return byteArrayOutputStream.toByteArray();
                                            } catch (IOException e2) {
                                                e = e2;
                                                gZIPOutputStream2 = byteArrayOutputStream;
                                                try {
                                                    throw e;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    byteArrayOutputStream = gZIPOutputStream2;
                                                    gZIPOutputStream2 = gZIPOutputStream;
                                                    try {
                                                        gZIPOutputStream2.close();
                                                    } catch (Exception unused4) {
                                                    }
                                                    try {
                                                        aVar.close();
                                                    } catch (Exception unused5) {
                                                    }
                                                    try {
                                                        byteArrayOutputStream.close();
                                                    } catch (Exception unused6) {
                                                    }
                                                    throw th;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                gZIPOutputStream2 = gZIPOutputStream;
                                                gZIPOutputStream2.close();
                                                aVar.close();
                                                byteArrayOutputStream.close();
                                                throw th;
                                            }
                                        } catch (IOException e3) {
                                            e = e3;
                                            gZIPOutputStream = null;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            gZIPOutputStream2.close();
                                            aVar.close();
                                            byteArrayOutputStream.close();
                                            throw th;
                                        }
                                    } catch (IOException e4) {
                                        e = e4;
                                        aVar = null;
                                        gZIPOutputStream = null;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        aVar = null;
                                    }
                                } catch (IOException e5) {
                                    e = e5;
                                    aVar = null;
                                    gZIPOutputStream = null;
                                } catch (Throwable th5) {
                                    th = th5;
                                    byteArrayOutputStream = 0;
                                    aVar = null;
                                }
                            } else {
                                if ((i3 & 8) != 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                int i5 = (i2 / 3) * 4;
                                if (i2 % 3 > 0) {
                                    i4 = 4;
                                } else {
                                    i4 = 0;
                                }
                                int i6 = i5 + i4;
                                if (z) {
                                    i6 += i6 / 76;
                                }
                                int i7 = i6;
                                byte[] bArr2 = new byte[i7];
                                int i8 = i2 - 2;
                                int i9 = 0;
                                int i10 = 0;
                                int i11 = 0;
                                while (i9 < i8) {
                                    int i12 = i9;
                                    a(bArr, i9 + i, 3, bArr2, i10, i3);
                                    int i13 = i11 + 4;
                                    if (z && i13 >= 76) {
                                        bArr2[i10 + 4] = 10;
                                        i10++;
                                        i11 = 0;
                                    } else {
                                        i11 = i13;
                                    }
                                    i9 = i12 + 3;
                                    i10 += 4;
                                }
                                int i14 = i9;
                                if (i14 < i2) {
                                    a(bArr, i14 + i, i2 - i14, bArr2, i10, i3);
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
                        } else {
                            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length)));
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot have length offset: " + i2);
                    }
                } else {
                    throw new IllegalArgumentException("Cannot have negative offset: " + i);
                }
            } else {
                throw new NullPointerException("Cannot serialize a null array.");
            }
        } else {
            return (byte[]) invokeLIII.objValue;
        }
    }
}
