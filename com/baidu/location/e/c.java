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
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static c f35687c;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f35688b;

    /* renamed from: d  reason: collision with root package name */
    public int f35689d;

    /* renamed from: e  reason: collision with root package name */
    public int f35690e;

    /* renamed from: f  reason: collision with root package name */
    public int f35691f;

    /* renamed from: g  reason: collision with root package name */
    public int f35692g;

    /* renamed from: h  reason: collision with root package name */
    public int f35693h;

    /* renamed from: i  reason: collision with root package name */
    public int f35694i;

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
        this.f35688b = 3164;
        this.f35689d = 0;
        this.f35690e = 20;
        this.f35691f = 40;
        this.f35692g = 60;
        this.f35693h = 80;
        this.f35694i = 100;
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
            if (f35687c == null) {
                f35687c = new c();
            }
            return f35687c;
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
            randomAccessFile.writeInt(this.f35688b);
            randomAccessFile.writeLong(j2);
            randomAccessFile.writeInt(this.f35688b);
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            a(this.f35689d, j2);
        }
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a(this.f35689d) : invokeV.longValue;
    }
}
