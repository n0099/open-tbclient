package c.a.a1.p.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ExecutorService a;

    /* renamed from: b  reason: collision with root package name */
    public c f1362b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f1363c;

    /* renamed from: d  reason: collision with root package name */
    public int f1364d;

    /* renamed from: e  reason: collision with root package name */
    public int f1365e;

    /* renamed from: f  reason: collision with root package name */
    public int f1366f;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ byte[] f1367e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f1368f;

        public a(d dVar, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1368f = dVar;
            this.f1367e = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f1368f.f1363c) {
                        this.f1368f.f1362b.g(d.l(this.f1367e, this.f1368f.f1366f, this.f1368f.f1365e));
                        return;
                    }
                    this.f1368f.d(this.f1367e, this.f1368f.f1364d);
                    this.f1368f.f1362b.g(d.h(this.f1367e, this.f1368f.f1366f, this.f1368f.f1365e));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f1369e;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1369e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f1369e.a != null) {
                        this.f1369e.a.shutdown();
                        this.f1369e.a.awaitTermination(3000L, TimeUnit.MILLISECONDS);
                    }
                    if (this.f1369e.f1362b != null) {
                        this.f1369e.f1362b.c();
                    }
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public d() {
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
        this.f1362b = new c();
    }

    public static byte[] h(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, bArr, i2, i3)) == null) {
            int i4 = i2 * i3;
            int i5 = (i4 * 3) / 2;
            byte[] bArr2 = new byte[i5];
            int i6 = 0;
            for (int i7 = 0; i7 < i2; i7++) {
                for (int i8 = i3 - 1; i8 >= 0; i8--) {
                    bArr2[i6] = bArr[(i8 * i2) + i7];
                    i6++;
                }
            }
            int i9 = i5 - 1;
            for (int i10 = i2 - 1; i10 > 0; i10 -= 2) {
                for (int i11 = 0; i11 < i3 / 2; i11++) {
                    int i12 = (i11 * i2) + i4;
                    bArr2[i9] = bArr[i12 + i10];
                    int i13 = i9 - 1;
                    bArr2[i13] = bArr[i12 + (i10 - 1)];
                    i9 = i13 - 1;
                }
            }
            return bArr2;
        }
        return (byte[]) invokeLII.objValue;
    }

    public static byte[] l(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65541, null, bArr, i2, i3)) == null) {
            int i4 = i2 * i3;
            byte[] bArr2 = new byte[(i4 * 3) / 2];
            int i5 = i2 - 1;
            int i6 = 0;
            for (int i7 = i5; i7 >= 0; i7--) {
                for (int i8 = 0; i8 < i3; i8++) {
                    bArr2[i6] = bArr[(i8 * i2) + i7];
                    i6++;
                }
            }
            int i9 = i4;
            while (i5 > 0) {
                for (int i10 = 0; i10 < i3 / 2; i10++) {
                    int i11 = (i10 * i2) + i4;
                    bArr2[i9] = bArr[(i5 - 1) + i11];
                    int i12 = i9 + 1;
                    bArr2[i12] = bArr[i11 + i5];
                    i9 = i12 + 1;
                }
                i5 -= 2;
            }
            o(bArr2, i3, i2);
            return bArr2;
        }
        return (byte[]) invokeLII.objValue;
    }

    public static byte[] o(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65543, null, bArr, i2, i3)) == null) {
            for (int i4 = 0; i4 < (i3 * 3) / 2; i4++) {
                for (int i5 = 0; i5 < i2 / 2; i5++) {
                    int i6 = (i4 * i2) + i5;
                    byte b2 = bArr[i6];
                    int i7 = (((i4 + 1) * i2) - 1) - i5;
                    bArr[i6] = bArr[i7];
                    bArr[i7] = b2;
                }
            }
            return bArr;
        }
        return (byte[]) invokeLII.objValue;
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f1363c = z;
        }
    }

    public void c(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr) == null) {
            this.a.execute(new a(this, bArr));
        }
    }

    public final void d(byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bArr, i2) == null) {
            if (i2 == 17) {
                k(bArr);
            } else if (i2 == 842094169) {
                n(bArr);
            }
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a != null : invokeV.booleanValue;
    }

    public boolean f(int i2, int i3, int i4, int i5, int i6, int i7, String str) {
        InterceptResult invokeCommon;
        int i8;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), str})) != null) {
            return invokeCommon.booleanValue;
        }
        this.f1364d = i4;
        this.f1365e = i2;
        this.f1366f = i3;
        if (i4 != 17) {
            i8 = i4 == 842094169 ? 19 : 19;
            return false;
        }
        i8 = 21;
        try {
            this.f1362b.d(i2, i3, i8, i5, i6, i7, str);
            this.a = Executors.newSingleThreadExecutor();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Executors.newSingleThreadExecutor().execute(new b(this));
        }
    }

    public final void k(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bArr) == null) {
            for (int length = (bArr.length * 2) / 3; length < bArr.length - 1; length += 2) {
                byte b2 = bArr[length];
                int i2 = length + 1;
                bArr[length] = bArr[i2];
                bArr[i2] = b2;
            }
        }
    }

    public final void n(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bArr) == null) {
            int length = (bArr.length * 2) / 3;
            int i2 = length / 2;
            for (int i3 = length; i3 < length + i2; i3++) {
                byte b2 = bArr[i3];
                int i4 = i3 + i2;
                bArr[i3] = bArr[i4];
                bArr[i4] = b2;
            }
        }
    }
}
