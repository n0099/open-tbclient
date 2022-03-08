package c.a.r0.l4.k;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteOrder;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f19152b;

        /* renamed from: c  reason: collision with root package name */
        public int f19153c;

        /* renamed from: d  reason: collision with root package name */
        public int f19154d;

        public a() {
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
            this.a = 48000;
            this.f19152b = 1;
            this.f19153c = 16;
            this.f19154d = 0;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.f19154d;
                return i2 == 5 || i2 == 6 || i2 == 8 || i2 == 9;
            }
            return invokeV.booleanValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i2 = this.f19154d;
                return i2 == 3 || i2 == 4 || i2 == 8 || i2 == 9;
            }
            return invokeV.booleanValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i2 = this.f19154d;
                return i2 == 1 || i2 == 4 || i2 == 6 || i2 == 9;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1690848788, "Lc/a/r0/l4/k/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1690848788, "Lc/a/r0/l4/k/g;");
        }
    }

    public static byte[] a(byte b2, byte b3, byte b4, byte b5, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3), Byte.valueOf(b4), Byte.valueOf(b5), Boolean.valueOf(z)})) == null) ? e((short) ((f(b2, b3, z) / 2) + (f(b4, b5, z) / 2)), z) : (byte[]) invokeCommon.objValue;
    }

    public static byte[] b(int i2, int i3, byte[] bArr) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65538, null, i2, i3, bArr)) == null) {
            BdLog.e("convertChannelCount sourceByteWidth = " + i2 + " outputByteWidth = " + i3);
            if (i2 == i3) {
                return bArr;
            }
            int length = bArr.length;
            if (i2 != 1) {
                if (i2 == 2 && i3 == 1) {
                    int i4 = length / 2;
                    byte[] bArr2 = new byte[i4];
                    for (int i5 = 0; i5 < i4; i5++) {
                        int i6 = i5 * 2;
                        bArr2[i5] = (byte) (f(bArr[i6], bArr[i6 + 1], a) / 256);
                    }
                    return bArr2;
                }
            } else if (i3 == 2) {
                byte[] bArr3 = new byte[length * 2];
                for (int i7 = 0; i7 < length; i7++) {
                    byte[] e2 = e((short) (bArr[i7] * 256), a);
                    int i8 = i7 * 2;
                    bArr3[i8] = e2[0];
                    bArr3[i8 + 1] = e2[1];
                }
                return bArr3;
            }
            return bArr;
        }
        return (byte[]) invokeIIL.objValue;
    }

    public static byte[] c(int i2, int i3, int i4, byte[] bArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bArr})) == null) {
            BdLog.e("convertChannelCount sourceChannelCount = " + i2 + " outputChannelCount = " + i3);
            if (i2 == i3) {
                return bArr;
            }
            if (i4 == 1 || i4 == 2) {
                int length = bArr.length;
                int i5 = 0;
                if (i2 != 1) {
                    if (i2 == 2 && i3 == 1) {
                        int i6 = length / 2;
                        byte[] bArr2 = new byte[i6];
                        if (i4 == 1) {
                            while (i5 < i6) {
                                int i7 = i5 * 2;
                                bArr2[i5] = (byte) (((short) (bArr[i7] + bArr[i7 + 1])) >> 1);
                                i5 += 2;
                            }
                        } else if (i4 == 2) {
                            for (int i8 = 0; i8 < i6; i8 += 2) {
                                int i9 = i8 * 2;
                                byte[] a2 = a(bArr[i9], bArr[i9 + 1], bArr[i9 + 2], bArr[i9 + 3], a);
                                bArr2[i8] = a2[0];
                                bArr2[i8 + 1] = a2[1];
                            }
                        }
                        return bArr2;
                    }
                } else if (i3 == 2) {
                    byte[] bArr3 = new byte[length * 2];
                    if (i4 == 1) {
                        while (i5 < length) {
                            byte b2 = bArr[i5];
                            int i10 = i5 * 2;
                            bArr3[i10] = b2;
                            bArr3[i10 + 1] = b2;
                            i5++;
                        }
                    } else if (i4 == 2) {
                        while (i5 < length) {
                            byte b3 = bArr[i5];
                            byte b4 = bArr[i5 + 1];
                            int i11 = i5 * 2;
                            bArr3[i11] = b3;
                            bArr3[i11 + 1] = b4;
                            bArr3[i11 + 2] = b3;
                            bArr3[i11 + 3] = b4;
                            i5 += 2;
                        }
                    }
                    return bArr3;
                }
                return bArr;
            }
            return bArr;
        }
        return (byte[]) invokeCommon.objValue;
    }

    @TargetApi(16)
    public static a d(String str) {
        InterceptResult invokeL;
        MediaFormat mediaFormat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            MediaExtractor mediaExtractor = new MediaExtractor();
            try {
                mediaExtractor.setDataSource(str);
                int i2 = 0;
                while (true) {
                    if (i2 >= mediaExtractor.getTrackCount()) {
                        mediaFormat = null;
                        break;
                    }
                    mediaFormat = mediaExtractor.getTrackFormat(i2);
                    if (mediaFormat.getString("mime").startsWith("audio/")) {
                        mediaExtractor.selectTrack(i2);
                        break;
                    }
                    i2++;
                }
                if (mediaFormat == null) {
                    mediaExtractor.release();
                    return null;
                }
                a aVar = new a();
                aVar.a = mediaFormat.containsKey("sample-rate") ? mediaFormat.getInteger("sample-rate") : 48000;
                aVar.f19152b = mediaFormat.containsKey("channel-count") ? mediaFormat.getInteger("channel-count") : 1;
                aVar.f19153c = mediaFormat.containsKey("bit-width") ? mediaFormat.getInteger("bit-width") : 16;
                mediaExtractor.release();
                return aVar;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (a) invokeL.objValue;
    }

    public static byte[] e(short s, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Short.valueOf(s), Boolean.valueOf(z)})) == null) {
            byte[] bArr = new byte[2];
            if (z) {
                bArr[1] = (byte) (s & 255);
                bArr[0] = (byte) (((short) (s >> 8)) & 255);
            } else {
                bArr[0] = (byte) (s & 255);
                bArr[1] = (byte) (((short) (s >> 8)) & 255);
            }
            return bArr;
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static short f(byte b2, byte b3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3), Boolean.valueOf(z)})) == null) {
            return (short) (z ? ((short) (((short) ((b2 & 255) | 0)) << 8)) | (b3 & 255) : (b2 & 255) | ((short) (((short) ((b3 & 255) | 0)) << 8)));
        }
        return invokeCommon.shortValue;
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
                a = true;
            } else {
                a = false;
            }
        }
    }

    public static boolean h(a... aVarArr) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVarArr)) == null) {
            if (aVarArr == null || aVarArr.length < 2 || (aVar = aVarArr[0]) == null) {
                return false;
            }
            boolean z = true;
            for (int i2 = 1; i2 < aVarArr.length; i2++) {
                if (aVar.a != aVarArr[i2].a) {
                    aVarArr[i2].f19154d++;
                    z = false;
                }
                if (aVar.f19152b != aVarArr[i2].f19152b) {
                    aVarArr[i2].f19154d += 3;
                    z = false;
                }
                if (aVar.f19153c != aVarArr[i2].f19153c) {
                    aVarArr[i2].f19154d += 5;
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static boolean i(String str, String str2, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65545, null, str, str2, i2, i3)) == null) {
            BdLog.e("resampling sampleRate = " + i2 + " resampleRate = " + i3);
            if (i3 == i2) {
                return false;
            }
            File file = new File(str);
            File file2 = new File(str2);
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                new j(fileInputStream, fileOutputStream, i2, i3, 2, 2, 1, Integer.MAX_VALUE, 0.0d, 0, true);
                fileInputStream.close();
                fileOutputStream.close();
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLLII.booleanValue;
    }
}
