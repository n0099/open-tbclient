package c.a.d.f.p;

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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.codec.binary4util.BaseNCodec;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f2314b;

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f2315c;

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f2316d;

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f2317e;

    /* renamed from: f  reason: collision with root package name */
    public static final byte[] f2318f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-502489105, "Lc/a/d/f/p/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-502489105, "Lc/a/d/f/p/e;");
                return;
            }
        }
        a = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, Cea608Decoder.CTRL_END_OF_CAPTION};
        f2314b = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, BaseNCodec.PAD_DEFAULT, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Constants.GZIP_CAST_TYPE, 12, 13, YogaNodeJNIBase.LAYOUT_BORDER_START_INDEX, 15, YogaNodeJNIBase.HAS_NEW_LAYOUT, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, Base64.INTERNAL_PADDING, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_2_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 40, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, 42, 43, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 45, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, Cea608Decoder.CTRL_END_OF_CAPTION, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        f2315c = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        f2316d = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, BaseNCodec.PAD_DEFAULT, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Constants.GZIP_CAST_TYPE, 12, 13, YogaNodeJNIBase.LAYOUT_BORDER_START_INDEX, 15, YogaNodeJNIBase.HAS_NEW_LAYOUT, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, Base64.INTERNAL_PADDING, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_2_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 40, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, 42, 43, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 45, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, Cea608Decoder.CTRL_END_OF_CAPTION, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
        f2317e = new byte[]{45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122};
        f2318f = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, Constants.GZIP_CAST_TYPE, 12, 13, YogaNodeJNIBase.LAYOUT_BORDER_START_INDEX, 15, YogaNodeJNIBase.HAS_NEW_LAYOUT, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, Base64.INTERNAL_PADDING, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, -9, -9, -9, -9, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_2_ROWS, -9, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 40, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, 42, 43, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 45, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, Cea608Decoder.CTRL_END_OF_CAPTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, BaseNCodec.PAD_DEFAULT, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    }

    public static byte[] d(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? e(str, 0) : (byte[]) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0064 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0066 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:51:0x0086 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:63:0x005d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:83:0x003d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.ByteArrayInputStream] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x005d -> B:81:0x005d). Please submit an issue!!! */
    public static byte[] e(String str, int i) throws IOException {
        GZIPInputStream gZIPInputStream;
        byte[] bytes;
        ?? length;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            gZIPInputStream = null;
            InterceptResult invokeLI = interceptable.invokeLI(65541, null, str, i);
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
            byte[] f2 = f(bytes, 0, bytes.length, i);
            boolean z = (i & 4) != 0;
            if (f2 != null && (length = f2.length) >= 4 && !z && 35615 == ((f2[0] & 255) | ((f2[1] << 8) & 65280))) {
                byte[] bArr = new byte[2048];
                ByteArrayOutputStream byteArrayOutputStream = null;
                try {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            length = new ByteArrayInputStream(f2);
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
                                            return f2;
                                        } catch (Throwable th) {
                                            th = th;
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (Exception unused2) {
                                            }
                                            try {
                                                gZIPInputStream.close();
                                            } catch (Exception unused3) {
                                            }
                                            try {
                                                length.close();
                                            } catch (Exception unused4) {
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        byteArrayOutputStream = byteArrayOutputStream2;
                                        byteArrayOutputStream.close();
                                        gZIPInputStream.close();
                                        length.close();
                                        throw th;
                                    }
                                }
                                f2 = byteArrayOutputStream2.toByteArray();
                                byteArrayOutputStream2.close();
                            } catch (IOException e3) {
                                e = e3;
                                gZIPInputStream = null;
                            } catch (Throwable th3) {
                                th = th3;
                                gZIPInputStream = null;
                            }
                        } catch (IOException e4) {
                            e = e4;
                            length = 0;
                            gZIPInputStream = null;
                        } catch (Throwable th4) {
                            th = th4;
                            length = 0;
                            gZIPInputStream = null;
                        }
                    } catch (Exception unused5) {
                    }
                } catch (IOException e5) {
                    e = e5;
                    length = 0;
                    gZIPInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    length = 0;
                    gZIPInputStream = null;
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
            return f2;
        }
        throw new NullPointerException("Input string was null.");
    }

    public static byte[] f(byte[] bArr, int i, int i2, int i3) throws IOException {
        InterceptResult invokeLIII;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65542, null, bArr, i, i2, i3)) == null) {
            if (bArr != null) {
                if (i < 0 || (i4 = i + i2) > bArr.length) {
                    throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
                }
                if (i2 == 0) {
                    return new byte[0];
                }
                if (i2 >= 4) {
                    byte[] p = p(i3);
                    byte[] bArr2 = new byte[(i2 * 3) / 4];
                    byte[] bArr3 = new byte[4];
                    int i5 = 0;
                    int i6 = 0;
                    while (i < i4) {
                        byte b2 = p[bArr[i] & 255];
                        if (b2 < -5) {
                            throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", Integer.valueOf(bArr[i] & 255), Integer.valueOf(i)));
                        }
                        if (b2 >= -1) {
                            int i7 = i5 + 1;
                            bArr3[i5] = bArr[i];
                            if (i7 > 3) {
                                i6 += g(bArr3, 0, bArr2, i6, i3);
                                if (bArr[i] == 61) {
                                    break;
                                }
                                i5 = 0;
                            } else {
                                i5 = i7;
                            }
                        }
                        i++;
                    }
                    byte[] bArr4 = new byte[i6];
                    System.arraycopy(bArr2, 0, bArr4, 0, i6);
                    return bArr4;
                }
                throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + i2);
            }
            throw new NullPointerException("Cannot decode null source array.");
        }
        return (byte[]) invokeLIII.objValue;
    }

    public static int g(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        InterceptResult invokeCommon;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{bArr, Integer.valueOf(i), bArr2, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (bArr != null) {
                if (bArr2 != null) {
                    if (i >= 0 && (i4 = i + 3) < bArr.length) {
                        if (i2 >= 0 && (i5 = i2 + 2) < bArr2.length) {
                            byte[] p = p(i3);
                            int i6 = i + 2;
                            if (bArr[i6] == 61) {
                                bArr2[i2] = (byte) ((((p[bArr[i + 1]] & 255) << 12) | ((p[bArr[i]] & 255) << 18)) >>> 16);
                                return 1;
                            } else if (bArr[i4] == 61) {
                                int i7 = ((p[bArr[i6]] & 255) << 6) | ((p[bArr[i + 1]] & 255) << 12) | ((p[bArr[i]] & 255) << 18);
                                bArr2[i2] = (byte) (i7 >>> 16);
                                bArr2[i2 + 1] = (byte) (i7 >>> 8);
                                return 2;
                            } else {
                                int i8 = (p[bArr[i4]] & 255) | ((p[bArr[i + 1]] & 255) << 12) | ((p[bArr[i]] & 255) << 18) | ((p[bArr[i6]] & 255) << 6);
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

    public static byte[] h(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), bArr2, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            byte[] o = o(i4);
            int i5 = (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0) | (i2 > 2 ? (bArr[i + 2] << 24) >>> 24 : 0);
            if (i2 == 1) {
                bArr2[i3] = o[i5 >>> 18];
                bArr2[i3 + 1] = o[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = BaseNCodec.PAD_DEFAULT;
                bArr2[i3 + 3] = BaseNCodec.PAD_DEFAULT;
                return bArr2;
            } else if (i2 == 2) {
                bArr2[i3] = o[i5 >>> 18];
                bArr2[i3 + 1] = o[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = o[(i5 >>> 6) & 63];
                bArr2[i3 + 3] = BaseNCodec.PAD_DEFAULT;
                return bArr2;
            } else if (i2 != 3) {
                return bArr2;
            } else {
                bArr2[i3] = o[i5 >>> 18];
                bArr2[i3 + 1] = o[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = o[(i5 >>> 6) & 63];
                bArr2[i3 + 3] = o[i5 & 63];
                return bArr2;
            }
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static byte[] i(byte[] bArr, byte[] bArr2, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65545, null, bArr, bArr2, i, i2)) == null) {
            h(bArr2, 0, i, bArr, 0, i2);
            return bArr;
        }
        return (byte[]) invokeLLII.objValue;
    }

    public static String j(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, bArr)) == null) {
            try {
                return l(bArr, 0, bArr.length, 0);
            } catch (IOException unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String k(byte[] bArr, int i) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, bArr, i)) == null) ? l(bArr, 0, bArr.length, i) : (String) invokeLI.objValue;
    }

    public static String l(byte[] bArr, int i, int i2, int i3) throws IOException {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65548, null, bArr, i, i2, i3)) == null) {
            byte[] n = n(bArr, i, i2, i3);
            try {
                return new String(n, "US-ASCII");
            } catch (UnsupportedEncodingException unused) {
                return new String(n);
            }
        }
        return (String) invokeLIII.objValue;
    }

    public static byte[] m(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, bArr)) == null) {
            try {
                return n(bArr, 0, bArr.length, 0);
            } catch (IOException unused) {
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0040 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0044 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v16, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v17, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v18, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v19, resolved type: java.io.ByteArrayOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r2v20, resolved type: java.io.ByteArrayOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] n(byte[] bArr, int i, int i2, int i3) throws IOException {
        InterceptResult invokeLIII;
        ByteArrayOutputStream byteArrayOutputStream;
        a aVar;
        GZIPOutputStream gZIPOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLIII = interceptable.invokeLIII(65550, null, bArr, i, i2, i3)) != null) {
            return (byte[]) invokeLIII.objValue;
        }
        if (bArr == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        }
        if (i < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i);
        } else if (i2 >= 0) {
            if (i + i2 > bArr.length) {
                throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length)));
            }
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
                boolean z = (i3 & 8) != 0;
                int i4 = ((i2 / 3) * 4) + (i2 % 3 > 0 ? 4 : 0);
                if (z) {
                    i4 += i4 / 76;
                }
                int i5 = i4;
                byte[] bArr2 = new byte[i5];
                int i6 = i2 - 2;
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                while (i7 < i6) {
                    int i10 = i7;
                    h(bArr, i7 + i, 3, bArr2, i8, i3);
                    int i11 = i9 + 4;
                    if (!z || i11 < 76) {
                        i9 = i11;
                    } else {
                        bArr2[i8 + 4] = 10;
                        i8++;
                        i9 = 0;
                    }
                    i7 = i10 + 3;
                    i8 += 4;
                }
                int i12 = i7;
                if (i12 < i2) {
                    h(bArr, i12 + i, i2 - i12, bArr2, i8, i3);
                    i8 += 4;
                }
                int i13 = i8;
                if (i13 <= i5 - 1) {
                    byte[] bArr3 = new byte[i13];
                    System.arraycopy(bArr2, 0, bArr3, 0, i13);
                    return bArr3;
                }
                return bArr2;
            }
        } else {
            throw new IllegalArgumentException("Cannot have length offset: " + i2);
        }
    }

    public static final byte[] o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65551, null, i)) == null) {
            if ((i & 16) == 16) {
                return f2315c;
            }
            if ((i & 32) == 32) {
                return f2317e;
            }
            return a;
        }
        return (byte[]) invokeI.objValue;
    }

    public static final byte[] p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i)) == null) {
            if ((i & 16) == 16) {
                return f2316d;
            }
            if ((i & 32) == 32) {
                return f2318f;
            }
            return f2314b;
        }
        return (byte[]) invokeI.objValue;
    }

    /* loaded from: classes.dex */
    public static class a extends FilterOutputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public int f2319b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f2320c;

        /* renamed from: d  reason: collision with root package name */
        public int f2321d;

        /* renamed from: e  reason: collision with root package name */
        public int f2322e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f2323f;

        /* renamed from: g  reason: collision with root package name */
        public byte[] f2324g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f2325h;
        public int i;
        public byte[] j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(OutputStream outputStream, int i) {
            super(outputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {outputStream, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((OutputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2323f = (i & 8) != 0;
            boolean z = (i & 1) != 0;
            this.a = z;
            int i4 = z ? 3 : 4;
            this.f2321d = i4;
            this.f2320c = new byte[i4];
            this.f2319b = 0;
            this.f2322e = 0;
            this.f2325h = false;
            this.f2324g = new byte[4];
            this.i = i;
            this.j = e.p(i);
        }

        public void a() throws IOException {
            int i;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (i = this.f2319b) <= 0) {
                return;
            }
            if (this.a) {
                OutputStream outputStream = ((FilterOutputStream) this).out;
                byte[] bArr = this.f2324g;
                e.i(bArr, this.f2320c, i, this.i);
                outputStream.write(bArr);
                this.f2319b = 0;
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
                this.f2320c = null;
                ((FilterOutputStream) this).out = null;
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                if (this.f2325h) {
                    ((FilterOutputStream) this).out.write(i);
                } else if (this.a) {
                    byte[] bArr = this.f2320c;
                    int i2 = this.f2319b;
                    int i3 = i2 + 1;
                    this.f2319b = i3;
                    bArr[i2] = (byte) i;
                    int i4 = this.f2321d;
                    if (i3 >= i4) {
                        OutputStream outputStream = ((FilterOutputStream) this).out;
                        byte[] bArr2 = this.f2324g;
                        e.i(bArr2, bArr, i4, this.i);
                        outputStream.write(bArr2);
                        int i5 = this.f2322e + 4;
                        this.f2322e = i5;
                        if (this.f2323f && i5 >= 76) {
                            ((FilterOutputStream) this).out.write(10);
                            this.f2322e = 0;
                        }
                        this.f2319b = 0;
                    }
                } else {
                    byte[] bArr3 = this.j;
                    int i6 = i & 127;
                    if (bArr3[i6] > -5) {
                        byte[] bArr4 = this.f2320c;
                        int i7 = this.f2319b;
                        int i8 = i7 + 1;
                        this.f2319b = i8;
                        bArr4[i7] = (byte) i;
                        if (i8 >= this.f2321d) {
                            ((FilterOutputStream) this).out.write(this.f2324g, 0, e.g(bArr4, 0, this.f2324g, 0, this.i));
                            this.f2319b = 0;
                        }
                    } else if (bArr3[i6] != -5) {
                        throw new IOException("Invalid character in Base64 data.");
                    }
                }
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048579, this, bArr, i, i2) == null) {
                if (this.f2325h) {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                    return;
                }
                for (int i3 = 0; i3 < i2; i3++) {
                    write(bArr[i + i3]);
                }
            }
        }
    }
}
