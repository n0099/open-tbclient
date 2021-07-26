package com.baidu.location.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static g f6598a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f6599b = "Temp_in.dat";

    /* renamed from: c  reason: collision with root package name */
    public static File f6600c;

    /* renamed from: d  reason: collision with root package name */
    public static StringBuffer f6601d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f6602e;

    /* renamed from: f  reason: collision with root package name */
    public static int f6603f;

    /* renamed from: g  reason: collision with root package name */
    public static int f6604g;

    /* renamed from: h  reason: collision with root package name */
    public static long f6605h;

    /* renamed from: i  reason: collision with root package name */
    public static long f6606i;
    public static long j;
    public static double k;
    public static double l;
    public static int m;
    public static int n;
    public static int o;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1037723469, "Lcom/baidu/location/b/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1037723469, "Lcom/baidu/location/b/g;");
                return;
            }
        }
        f6600c = new File(com.baidu.location.e.j.f6833a, f6599b);
        f6601d = null;
        f6602e = true;
        f6603f = 0;
        f6604g = 0;
        f6605h = 0L;
        f6606i = 0L;
        j = 0L;
        k = 0.0d;
        l = 0.0d;
        m = 0;
        n = 0;
        o = 0;
    }

    public static String a() {
        InterceptResult invokeV;
        RandomAccessFile randomAccessFile;
        int readInt;
        int readInt2;
        int readInt3;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            File file = f6600c;
            if (file != null && file.exists()) {
                try {
                    randomAccessFile = new RandomAccessFile(f6600c, "rw");
                    randomAccessFile.seek(0L);
                    readInt = randomAccessFile.readInt();
                    readInt2 = randomAccessFile.readInt();
                    readInt3 = randomAccessFile.readInt();
                } catch (IOException unused) {
                }
                if (!a(readInt, readInt2, readInt3)) {
                    randomAccessFile.close();
                    c();
                    return null;
                }
                if (readInt2 != 0 && readInt2 != readInt3) {
                    long j2 = ((readInt2 - 1) * 1024) + 12 + 0;
                    randomAccessFile.seek(j2);
                    int readInt4 = randomAccessFile.readInt();
                    byte[] bArr = new byte[readInt4];
                    randomAccessFile.seek(j2 + 4);
                    for (int i3 = 0; i3 < readInt4; i3++) {
                        bArr[i3] = randomAccessFile.readByte();
                    }
                    String str = new String(bArr);
                    int i4 = 1;
                    if (readInt < com.baidu.location.e.k.af) {
                        i2 = readInt2 + 1;
                    } else {
                        if (readInt2 != com.baidu.location.e.k.af) {
                            i4 = 1 + readInt2;
                        }
                        i2 = i4;
                    }
                    randomAccessFile.seek(4L);
                    randomAccessFile.writeInt(i2);
                    randomAccessFile.close();
                    return str;
                }
                randomAccessFile.close();
                return null;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static boolean a(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(65538, null, i2, i3, i4)) == null) ? i2 >= 0 && i2 <= (i5 = com.baidu.location.e.k.af) && i3 >= 0 && i3 <= (i6 = i2 + 1) && i4 >= 1 && i4 <= i6 && i4 <= i5 : invokeIII.booleanValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            f6602e = true;
            f6601d = null;
            f6603f = 0;
            f6604g = 0;
            f6605h = 0L;
            f6606i = 0L;
            j = 0L;
            k = 0.0d;
            l = 0.0d;
            m = 0;
            n = 0;
            o = 0;
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f6600c.exists()) {
                f6600c.delete();
            }
            if (!f6600c.getParentFile().exists()) {
                f6600c.getParentFile().mkdirs();
            }
            try {
                f6600c.createNewFile();
                RandomAccessFile randomAccessFile = new RandomAccessFile(f6600c, "rw");
                randomAccessFile.seek(0L);
                randomAccessFile.writeInt(0);
                randomAccessFile.writeInt(0);
                randomAccessFile.writeInt(1);
                randomAccessFile.close();
                b();
                return f6600c.exists();
            } catch (IOException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
