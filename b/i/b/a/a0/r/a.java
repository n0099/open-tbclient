package b.i.b.a.a0.r;

import androidx.core.view.InputDeviceCompat;
import b.i.b.a.a0.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.EOFException;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class a implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final e f31572a;

    /* renamed from: b  reason: collision with root package name */
    public final long f31573b;

    /* renamed from: c  reason: collision with root package name */
    public final long f31574c;

    /* renamed from: d  reason: collision with root package name */
    public final h f31575d;

    /* renamed from: e  reason: collision with root package name */
    public int f31576e;

    /* renamed from: f  reason: collision with root package name */
    public long f31577f;

    /* renamed from: g  reason: collision with root package name */
    public long f31578g;

    /* renamed from: h  reason: collision with root package name */
    public long f31579h;

    /* renamed from: i  reason: collision with root package name */
    public long f31580i;
    public long j;
    public long k;
    public long l;

    /* renamed from: b.i.b.a.a0.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class C1476a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b implements l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31581a;

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
            this.f31581a = aVar;
        }

        @Override // b.i.b.a.a0.l
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // b.i.b.a.a0.l
        public long c(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                if (j == 0) {
                    return this.f31581a.f31573b;
                }
                long b2 = this.f31581a.f31575d.b(j);
                a aVar = this.f31581a;
                return aVar.i(aVar.f31573b, b2, 30000L);
            }
            return invokeJ.longValue;
        }

        @Override // b.i.b.a.a0.l
        public long h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f31581a.f31575d.a(this.f31581a.f31577f) : invokeV.longValue;
        }

        public /* synthetic */ b(a aVar, C1476a c1476a) {
            this(aVar);
        }
    }

    public a(long j, long j2, h hVar, int i2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), hVar, Integer.valueOf(i2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31572a = new e();
        b.i.b.a.i0.a.a(j >= 0 && j2 > j);
        this.f31575d = hVar;
        this.f31573b = j;
        this.f31574c = j2;
        if (i2 == j2 - j) {
            this.f31577f = j3;
            this.f31576e = 3;
            return;
        }
        this.f31576e = 0;
    }

    @Override // b.i.b.a.a0.r.f
    public long a(b.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
            int i2 = this.f31576e;
            if (i2 == 0) {
                long position = fVar.getPosition();
                this.f31578g = position;
                this.f31576e = 1;
                long j = this.f31574c - 65307;
                if (j > position) {
                    return j;
                }
            } else if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        return -1L;
                    }
                    throw new IllegalStateException();
                }
                long j2 = this.f31579h;
                long j3 = 0;
                if (j2 != 0) {
                    long j4 = j(j2, fVar);
                    if (j4 >= 0) {
                        return j4;
                    }
                    j3 = o(fVar, this.f31579h, -(j4 + 2));
                }
                this.f31576e = 3;
                return -(j3 + 2);
            }
            this.f31577f = k(fVar);
            this.f31576e = 3;
            return this.f31578g;
        }
        return invokeL.longValue;
    }

    @Override // b.i.b.a.a0.r.f
    public long e(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            int i2 = this.f31576e;
            b.i.b.a.i0.a.a(i2 == 3 || i2 == 2);
            this.f31579h = j != 0 ? this.f31575d.b(j) : 0L;
            this.f31576e = 2;
            l();
            return this.f31579h;
        }
        return invokeJ.longValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.i.b.a.a0.r.f
    /* renamed from: h */
    public b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f31577f != 0) {
                return new b(this, null);
            }
            return null;
        }
        return (b) invokeV.objValue;
    }

    public final long i(long j, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            long j4 = this.f31574c;
            long j5 = this.f31573b;
            long j6 = j + (((j2 * (j4 - j5)) / this.f31577f) - j3);
            if (j6 >= j5) {
                j5 = j6;
            }
            long j7 = this.f31574c;
            return j5 >= j7 ? j7 - 1 : j5;
        }
        return invokeCommon.longValue;
    }

    public long j(long j, b.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048581, this, j, fVar)) == null) {
            if (this.f31580i == this.j) {
                return -(this.k + 2);
            }
            long position = fVar.getPosition();
            if (!n(fVar, this.j)) {
                long j2 = this.f31580i;
                if (j2 != position) {
                    return j2;
                }
                throw new IOException("No ogg page can be found.");
            }
            this.f31572a.a(fVar, false);
            fVar.e();
            e eVar = this.f31572a;
            long j3 = j - eVar.f31598c;
            int i2 = eVar.f31600e + eVar.f31601f;
            int i3 = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
            if (i3 >= 0 && j3 <= 72000) {
                fVar.h(i2);
                return -(this.f31572a.f31598c + 2);
            }
            if (i3 < 0) {
                this.j = position;
                this.l = this.f31572a.f31598c;
            } else {
                long j4 = i2;
                long position2 = fVar.getPosition() + j4;
                this.f31580i = position2;
                this.k = this.f31572a.f31598c;
                if ((this.j - position2) + j4 < 100000) {
                    fVar.h(i2);
                    return -(this.k + 2);
                }
            }
            long j5 = this.j;
            long j6 = this.f31580i;
            if (j5 - j6 < 100000) {
                this.j = j6;
                return j6;
            }
            long position3 = fVar.getPosition() - (i2 * (i3 <= 0 ? 2 : 1));
            long j7 = this.j;
            long j8 = this.f31580i;
            return Math.min(Math.max(position3 + ((j3 * (j7 - j8)) / (this.l - this.k)), j8), this.j - 1);
        }
        return invokeJL.longValue;
    }

    public long k(b.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, fVar)) == null) {
            m(fVar);
            this.f31572a.b();
            while ((this.f31572a.f31597b & 4) != 4 && fVar.getPosition() < this.f31574c) {
                this.f31572a.a(fVar, false);
                e eVar = this.f31572a;
                fVar.h(eVar.f31600e + eVar.f31601f);
            }
            return this.f31572a.f31598c;
        }
        return invokeL.longValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f31580i = this.f31573b;
            this.j = this.f31574c;
            this.k = 0L;
            this.l = this.f31577f;
        }
    }

    public void m(b.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) && !n(fVar, this.f31574c)) {
            throw new EOFException();
        }
    }

    public boolean n(b.i.b.a.a0.f fVar, long j) throws IOException, InterruptedException {
        InterceptResult invokeLJ;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLJ = interceptable.invokeLJ(1048585, this, fVar, j)) != null) {
            return invokeLJ.booleanValue;
        }
        long min = Math.min(j + 3, this.f31574c);
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

    public long o(b.i.b.a.a0.f fVar, long j, long j2) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{fVar, Long.valueOf(j), Long.valueOf(j2)})) != null) {
            return invokeCommon.longValue;
        }
        this.f31572a.a(fVar, false);
        while (true) {
            e eVar = this.f31572a;
            if (eVar.f31598c < j) {
                fVar.h(eVar.f31600e + eVar.f31601f);
                e eVar2 = this.f31572a;
                long j3 = eVar2.f31598c;
                eVar2.a(fVar, false);
                j2 = j3;
            } else {
                fVar.e();
                return j2;
            }
        }
    }
}
