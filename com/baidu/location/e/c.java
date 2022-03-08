package com.baidu.location.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static c f33777c;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f33778b;

    /* renamed from: d  reason: collision with root package name */
    public int f33779d;

    /* renamed from: e  reason: collision with root package name */
    public int f33780e;

    /* renamed from: f  reason: collision with root package name */
    public int f33781f;

    /* renamed from: g  reason: collision with root package name */
    public int f33782g;

    /* renamed from: h  reason: collision with root package name */
    public int f33783h;

    /* renamed from: i  reason: collision with root package name */
    public int f33784i;

    public c() {
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
        this.a = "firll.dat";
        this.f33778b = 3164;
        this.f33779d = 0;
        this.f33780e = 20;
        this.f33781f = 40;
        this.f33782g = 60;
        this.f33783h = 80;
        this.f33784i = 100;
    }

    private long a(int i2) {
        InterceptResult invokeI;
        RandomAccessFile randomAccessFile;
        int readInt;
        long readLong;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            String j2 = k.j();
            if (j2 == null) {
                return -1L;
            }
            RandomAccessFile randomAccessFile2 = null;
            try {
                try {
                    randomAccessFile = new RandomAccessFile(j2 + File.separator + this.a, "rw");
                } catch (IOException unused) {
                }
                try {
                    randomAccessFile.seek(i2);
                    readInt = randomAccessFile.readInt();
                    readLong = randomAccessFile.readLong();
                } catch (Exception unused2) {
                    randomAccessFile2 = randomAccessFile;
                    if (randomAccessFile2 != null) {
                        randomAccessFile2.close();
                    }
                    return -1L;
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile2 = randomAccessFile;
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused4) {
            } catch (Throwable th2) {
                th = th2;
            }
            if (readInt == randomAccessFile.readInt()) {
                try {
                    randomAccessFile.close();
                } catch (IOException unused5) {
                }
                return readLong;
            }
            randomAccessFile.close();
            return -1L;
        }
        return invokeI.longValue;
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f33777c == null) {
                f33777c = new c();
            }
            return f33777c;
        }
        return (c) invokeV.objValue;
    }

    private void a(int i2, long j2) {
        String j3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (j3 = k.j()) == null) {
            return;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(j3 + File.separator + this.a, "rw");
            randomAccessFile.seek(i2);
            randomAccessFile.writeInt(this.f33778b);
            randomAccessFile.writeLong(j2);
            randomAccessFile.writeInt(this.f33778b);
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            a(this.f33779d, j2);
        }
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a(this.f33779d) : invokeV.longValue;
    }
}
