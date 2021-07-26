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
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static c f6801c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f6802a;

    /* renamed from: b  reason: collision with root package name */
    public int f6803b;

    /* renamed from: d  reason: collision with root package name */
    public int f6804d;

    /* renamed from: e  reason: collision with root package name */
    public int f6805e;

    /* renamed from: f  reason: collision with root package name */
    public int f6806f;

    /* renamed from: g  reason: collision with root package name */
    public int f6807g;

    /* renamed from: h  reason: collision with root package name */
    public int f6808h;

    /* renamed from: i  reason: collision with root package name */
    public int f6809i;

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
        this.f6802a = "firll.dat";
        this.f6803b = 3164;
        this.f6804d = 0;
        this.f6805e = 20;
        this.f6806f = 40;
        this.f6807g = 60;
        this.f6808h = 80;
        this.f6809i = 100;
    }

    private long a(int i2) {
        InterceptResult invokeI;
        RandomAccessFile randomAccessFile;
        int readInt;
        long readLong;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            String j = k.j();
            if (j == null) {
                return -1L;
            }
            RandomAccessFile randomAccessFile2 = null;
            try {
                try {
                    randomAccessFile = new RandomAccessFile(j + File.separator + this.f6802a, "rw");
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
            if (f6801c == null) {
                f6801c = new c();
            }
            return f6801c;
        }
        return (c) invokeV.objValue;
    }

    private void a(int i2, long j) {
        String j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) || (j2 = k.j()) == null) {
            return;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(j2 + File.separator + this.f6802a, "rw");
            randomAccessFile.seek(i2);
            randomAccessFile.writeInt(this.f6803b);
            randomAccessFile.writeLong(j);
            randomAccessFile.writeInt(this.f6803b);
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            a(this.f6804d, j);
        }
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a(this.f6804d) : invokeV.longValue;
    }
}
