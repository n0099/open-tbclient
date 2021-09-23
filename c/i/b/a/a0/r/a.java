package c.i.b.a.a0.r;

import androidx.core.view.InputDeviceCompat;
import c.i.b.a.a0.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.EOFException;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class a implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final e f32700a;

    /* renamed from: b  reason: collision with root package name */
    public final long f32701b;

    /* renamed from: c  reason: collision with root package name */
    public final long f32702c;

    /* renamed from: d  reason: collision with root package name */
    public final h f32703d;

    /* renamed from: e  reason: collision with root package name */
    public int f32704e;

    /* renamed from: f  reason: collision with root package name */
    public long f32705f;

    /* renamed from: g  reason: collision with root package name */
    public long f32706g;

    /* renamed from: h  reason: collision with root package name */
    public long f32707h;

    /* renamed from: i  reason: collision with root package name */
    public long f32708i;

    /* renamed from: j  reason: collision with root package name */
    public long f32709j;
    public long k;
    public long l;

    /* renamed from: c.i.b.a.a0.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C1480a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public class b implements l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f32710a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32710a = aVar;
        }

        @Override // c.i.b.a.a0.l
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // c.i.b.a.a0.l
        public long c(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
                if (j2 == 0) {
                    return this.f32710a.f32701b;
                }
                long b2 = this.f32710a.f32703d.b(j2);
                a aVar = this.f32710a;
                return aVar.i(aVar.f32701b, b2, 30000L);
            }
            return invokeJ.longValue;
        }

        @Override // c.i.b.a.a0.l
        public long h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32710a.f32703d.a(this.f32710a.f32705f) : invokeV.longValue;
        }

        public /* synthetic */ b(a aVar, C1480a c1480a) {
            this(aVar);
        }
    }

    public a(long j2, long j3, h hVar, int i2, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), hVar, Integer.valueOf(i2), Long.valueOf(j4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32700a = new e();
        c.i.b.a.i0.a.a(j2 >= 0 && j3 > j2);
        this.f32703d = hVar;
        this.f32701b = j2;
        this.f32702c = j3;
        if (i2 == j3 - j2) {
            this.f32705f = j4;
            this.f32704e = 3;
            return;
        }
        this.f32704e = 0;
    }

    @Override // c.i.b.a.a0.r.f
    public long a(c.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
            int i2 = this.f32704e;
            if (i2 == 0) {
                long position = fVar.getPosition();
                this.f32706g = position;
                this.f32704e = 1;
                long j2 = this.f32702c - 65307;
                if (j2 > position) {
                    return j2;
                }
            } else if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        return -1L;
                    }
                    throw new IllegalStateException();
                }
                long j3 = this.f32707h;
                long j4 = 0;
                if (j3 != 0) {
                    long j5 = j(j3, fVar);
                    if (j5 >= 0) {
                        return j5;
                    }
                    j4 = o(fVar, this.f32707h, -(j5 + 2));
                }
                this.f32704e = 3;
                return -(j4 + 2);
            }
            this.f32705f = k(fVar);
            this.f32704e = 3;
            return this.f32706g;
        }
        return invokeL.longValue;
    }

    @Override // c.i.b.a.a0.r.f
    public long e(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            int i2 = this.f32704e;
            c.i.b.a.i0.a.a(i2 == 3 || i2 == 2);
            this.f32707h = j2 != 0 ? this.f32703d.b(j2) : 0L;
            this.f32704e = 2;
            l();
            return this.f32707h;
        }
        return invokeJ.longValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.b.a.a0.r.f
    /* renamed from: h */
    public b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f32705f != 0) {
                return new b(this, null);
            }
            return null;
        }
        return (b) invokeV.objValue;
    }

    public final long i(long j2, long j3, long j4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)})) == null) {
            long j5 = this.f32702c;
            long j6 = this.f32701b;
            long j7 = j2 + (((j3 * (j5 - j6)) / this.f32705f) - j4);
            if (j7 >= j6) {
                j6 = j7;
            }
            long j8 = this.f32702c;
            return j6 >= j8 ? j8 - 1 : j6;
        }
        return invokeCommon.longValue;
    }

    public long j(long j2, c.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048581, this, j2, fVar)) == null) {
            if (this.f32708i == this.f32709j) {
                return -(this.k + 2);
            }
            long position = fVar.getPosition();
            if (!n(fVar, this.f32709j)) {
                long j3 = this.f32708i;
                if (j3 != position) {
                    return j3;
                }
                throw new IOException("No ogg page can be found.");
            }
            this.f32700a.a(fVar, false);
            fVar.e();
            e eVar = this.f32700a;
            long j4 = j2 - eVar.f32727c;
            int i2 = eVar.f32729e + eVar.f32730f;
            int i3 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
            if (i3 >= 0 && j4 <= 72000) {
                fVar.h(i2);
                return -(this.f32700a.f32727c + 2);
            }
            if (i3 < 0) {
                this.f32709j = position;
                this.l = this.f32700a.f32727c;
            } else {
                long j5 = i2;
                long position2 = fVar.getPosition() + j5;
                this.f32708i = position2;
                this.k = this.f32700a.f32727c;
                if ((this.f32709j - position2) + j5 < 100000) {
                    fVar.h(i2);
                    return -(this.k + 2);
                }
            }
            long j6 = this.f32709j;
            long j7 = this.f32708i;
            if (j6 - j7 < 100000) {
                this.f32709j = j7;
                return j7;
            }
            long position3 = fVar.getPosition() - (i2 * (i3 <= 0 ? 2 : 1));
            long j8 = this.f32709j;
            long j9 = this.f32708i;
            return Math.min(Math.max(position3 + ((j4 * (j8 - j9)) / (this.l - this.k)), j9), this.f32709j - 1);
        }
        return invokeJL.longValue;
    }

    public long k(c.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, fVar)) == null) {
            m(fVar);
            this.f32700a.b();
            while ((this.f32700a.f32726b & 4) != 4 && fVar.getPosition() < this.f32702c) {
                this.f32700a.a(fVar, false);
                e eVar = this.f32700a;
                fVar.h(eVar.f32729e + eVar.f32730f);
            }
            return this.f32700a.f32727c;
        }
        return invokeL.longValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f32708i = this.f32701b;
            this.f32709j = this.f32702c;
            this.k = 0L;
            this.l = this.f32705f;
        }
    }

    public void m(c.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) && !n(fVar, this.f32702c)) {
            throw new EOFException();
        }
    }

    public boolean n(c.i.b.a.a0.f fVar, long j2) throws IOException, InterruptedException {
        InterceptResult invokeLJ;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLJ = interceptable.invokeLJ(1048585, this, fVar, j2)) != null) {
            return invokeLJ.booleanValue;
        }
        long min = Math.min(j2 + 3, this.f32702c);
        int i3 = 2048;
        byte[] bArr = new byte[2048];
        while (true) {
            int i4 = 0;
            if (fVar.getPosition() + i3 > min && (i3 = (int) (min - fVar.getPosition())) < 4) {
                return false;
            }
            fVar.d(bArr, 0, i3, false);
            while (true) {
                i2 = i3 - 3;
                if (i4 < i2) {
                    if (bArr[i4] == 79 && bArr[i4 + 1] == 103 && bArr[i4 + 2] == 103 && bArr[i4 + 3] == 83) {
                        fVar.h(i4);
                        return true;
                    }
                    i4++;
                }
            }
            fVar.h(i2);
        }
    }

    public long o(c.i.b.a.a0.f fVar, long j2, long j3) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{fVar, Long.valueOf(j2), Long.valueOf(j3)})) != null) {
            return invokeCommon.longValue;
        }
        this.f32700a.a(fVar, false);
        while (true) {
            e eVar = this.f32700a;
            if (eVar.f32727c < j2) {
                fVar.h(eVar.f32729e + eVar.f32730f);
                e eVar2 = this.f32700a;
                long j4 = eVar2.f32727c;
                eVar2.a(fVar, false);
                j3 = j4;
            } else {
                fVar.e();
                return j3;
            }
        }
    }
}
