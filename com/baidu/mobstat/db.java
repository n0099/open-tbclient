package com.baidu.mobstat;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.ContentUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import com.kwad.yoga.YogaNodeJNIBase;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes4.dex */
public class db {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f35253b;

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f35254c;

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f35255d;

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f35256e;

    /* renamed from: f  reason: collision with root package name */
    public static final byte[] f35257f;

    /* renamed from: g  reason: collision with root package name */
    public static final byte[] f35258g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581659764, "Lcom/baidu/mobstat/db;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581659764, "Lcom/baidu/mobstat/db;");
                return;
            }
        }
        a = !db.class.desiredAssertionStatus();
        f35253b = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, Cea608Decoder.CTRL_END_OF_CAPTION};
        f35254c = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, StandardMessageCodec.LIST, 13, 14, 15, YogaNodeJNIBase.HAS_NEW_LAYOUT, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, Base64.INTERNAL_PADDING, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_2_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 40, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, 42, 43, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 45, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, Cea608Decoder.CTRL_END_OF_CAPTION, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        f35255d = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        f35256e = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, StandardMessageCodec.LIST, 13, 14, 15, YogaNodeJNIBase.HAS_NEW_LAYOUT, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, Base64.INTERNAL_PADDING, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_2_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 40, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, 42, 43, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 45, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, Cea608Decoder.CTRL_END_OF_CAPTION, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        f35257f = new byte[]{45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122};
        f35258g = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, StandardMessageCodec.LIST, 13, 14, 15, YogaNodeJNIBase.HAS_NEW_LAYOUT, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, Base64.INTERNAL_PADDING, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, -9, -9, -9, -9, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_2_ROWS, -9, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 40, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, 42, 43, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 45, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, Cea608Decoder.CTRL_END_OF_CAPTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    }

    public db() {
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

    public static final byte[] b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) {
            if ((i2 & 16) == 16) {
                return f35255d;
            }
            if ((i2 & 32) == 32) {
                return f35257f;
            }
            return f35253b;
        }
        return (byte[]) invokeI.objValue;
    }

    public static final byte[] c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i2)) == null) {
            if ((i2 & 16) == 16) {
                return f35256e;
            }
            if ((i2 & 32) == 32) {
                return f35258g;
            }
            return f35254c;
        }
        return (byte[]) invokeI.objValue;
    }

    public static byte[] a(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), bArr2, Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
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
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65547, null, bArr, bArr2, i2, i3)) == null) {
            a(bArr2, 0, i2, bArr, 0, i3);
            return bArr;
        }
        return (byte[]) invokeLLII.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0040 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0044 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v16, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v17, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v19, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v20, resolved type: java.io.ByteArrayOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] b(byte[] bArr, int i2, int i3, int i4) throws IOException {
        InterceptResult invokeLIII;
        ByteArrayOutputStream byteArrayOutputStream;
        a aVar;
        GZIPOutputStream gZIPOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLIII = interceptable.invokeLIII(65546, null, bArr, i2, i3, i4)) != null) {
            return (byte[]) invokeLIII.objValue;
        }
        if (bArr == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i2);
        } else if (i3 >= 0) {
            if (i2 + i3 > bArr.length) {
                throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bArr.length)));
            }
            if ((i4 & 2) != 0) {
                GZIPOutputStream gZIPOutputStream2 = null;
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        aVar = new a(byteArrayOutputStream, i4 | 1);
                        try {
                            gZIPOutputStream = new GZIPOutputStream(aVar);
                            try {
                                gZIPOutputStream.write(bArr, i2, i3);
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
                boolean z = (i4 & 8) != 0;
                int i5 = ((i3 / 3) * 4) + (i3 % 3 > 0 ? 4 : 0);
                if (z) {
                    i5 += i5 / 76;
                }
                int i6 = i5;
                byte[] bArr2 = new byte[i6];
                int i7 = i3 - 2;
                int i8 = 0;
                int i9 = 0;
                int i10 = 0;
                while (i8 < i7) {
                    int i11 = i8;
                    a(bArr, i8 + i2, 3, bArr2, i9, i4);
                    int i12 = i10 + 4;
                    if (!z || i12 < 76) {
                        i10 = i12;
                    } else {
                        bArr2[i9 + 4] = 10;
                        i9++;
                        i10 = 0;
                    }
                    i8 = i11 + 3;
                    i9 += 4;
                }
                int i13 = i8;
                if (i13 < i3) {
                    a(bArr, i13 + i2, i3 - i13, bArr2, i9, i4);
                    i9 += 4;
                }
                int i14 = i9;
                if (i14 <= i6 - 1) {
                    byte[] bArr3 = new byte[i14];
                    System.arraycopy(bArr2, 0, bArr3, 0, i14);
                    return bArr3;
                }
                return bArr2;
            }
        } else {
            throw new IllegalArgumentException("Cannot have length offset: " + i3);
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
                if (!a) {
                    throw new AssertionError(e2.getMessage());
                }
                str = null;
            }
            if (a || str != null) {
                return str;
            }
            throw new AssertionError();
        }
        return (String) invokeL.objValue;
    }

    /* loaded from: classes4.dex */
    public static class a extends FilterOutputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public int f35259b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f35260c;

        /* renamed from: d  reason: collision with root package name */
        public int f35261d;

        /* renamed from: e  reason: collision with root package name */
        public int f35262e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f35263f;

        /* renamed from: g  reason: collision with root package name */
        public byte[] f35264g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f35265h;

        /* renamed from: i  reason: collision with root package name */
        public int f35266i;

        /* renamed from: j  reason: collision with root package name */
        public byte[] f35267j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(OutputStream outputStream, int i2) {
            super(outputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {outputStream, Integer.valueOf(i2)};
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
            this.f35263f = (i2 & 8) != 0;
            boolean z = (i2 & 1) != 0;
            this.a = z;
            int i5 = z ? 3 : 4;
            this.f35261d = i5;
            this.f35260c = new byte[i5];
            this.f35259b = 0;
            this.f35262e = 0;
            this.f35265h = false;
            this.f35264g = new byte[4];
            this.f35266i = i2;
            this.f35267j = db.c(i2);
        }

        public void a() throws IOException {
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (i2 = this.f35259b) <= 0) {
                return;
            }
            if (this.a) {
                ((FilterOutputStream) this).out.write(db.b(this.f35264g, this.f35260c, i2, this.f35266i));
                this.f35259b = 0;
                return;
            }
            throw new IOException("Base64 input not properly padded.");
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                a();
                super.close();
                this.f35260c = null;
                ((FilterOutputStream) this).out = null;
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                if (this.f35265h) {
                    ((FilterOutputStream) this).out.write(i2);
                } else if (this.a) {
                    byte[] bArr = this.f35260c;
                    int i3 = this.f35259b;
                    int i4 = i3 + 1;
                    this.f35259b = i4;
                    bArr[i3] = (byte) i2;
                    int i5 = this.f35261d;
                    if (i4 >= i5) {
                        ((FilterOutputStream) this).out.write(db.b(this.f35264g, bArr, i5, this.f35266i));
                        int i6 = this.f35262e + 4;
                        this.f35262e = i6;
                        if (this.f35263f && i6 >= 76) {
                            ((FilterOutputStream) this).out.write(10);
                            this.f35262e = 0;
                        }
                        this.f35259b = 0;
                    }
                } else {
                    byte[] bArr2 = this.f35267j;
                    int i7 = i2 & 127;
                    if (bArr2[i7] > -5) {
                        byte[] bArr3 = this.f35260c;
                        int i8 = this.f35259b;
                        int i9 = i8 + 1;
                        this.f35259b = i9;
                        bArr3[i8] = (byte) i2;
                        if (i9 >= this.f35261d) {
                            ((FilterOutputStream) this).out.write(this.f35264g, 0, db.b(bArr3, 0, this.f35264g, 0, this.f35266i));
                            this.f35259b = 0;
                        }
                    } else if (bArr2[i7] != -5) {
                        throw new IOException("Invalid character in Base64 data.");
                    }
                }
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048579, this, bArr, i2, i3) == null) {
                if (this.f35265h) {
                    ((FilterOutputStream) this).out.write(bArr, i2, i3);
                    return;
                }
                for (int i4 = 0; i4 < i3; i4++) {
                    write(bArr[i2 + i4]);
                }
            }
        }
    }

    public static String a(byte[] bArr, int i2, int i3, int i4) throws IOException {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i2, i3, i4)) == null) {
            byte[] b2 = b(bArr, i2, i3, i4);
            try {
                return new String(b2, "US-ASCII");
            } catch (UnsupportedEncodingException unused) {
                return new String(b2);
            }
        }
        return (String) invokeLIII.objValue;
    }

    public static int b(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{bArr, Integer.valueOf(i2), bArr2, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (bArr != null) {
                if (bArr2 != null) {
                    if (i2 >= 0 && (i5 = i2 + 3) < bArr.length) {
                        if (i3 >= 0 && (i6 = i3 + 2) < bArr2.length) {
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
                        throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i3)));
                    }
                    throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i2)));
                }
                throw new NullPointerException("Destination array was null.");
            }
            throw new NullPointerException("Source array was null.");
        }
        return invokeCommon.intValue;
    }
}
