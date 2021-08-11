package c.i.b.a.f0;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import c.i.b.a.d0.s;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import java.util.Arrays;
import java.util.Comparator;
/* loaded from: classes4.dex */
public abstract class b implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final s f33419a;

    /* renamed from: b  reason: collision with root package name */
    public final int f33420b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f33421c;

    /* renamed from: d  reason: collision with root package name */
    public final Format[] f33422d;

    /* renamed from: e  reason: collision with root package name */
    public final long[] f33423e;

    /* renamed from: f  reason: collision with root package name */
    public int f33424f;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.i.b.a.f0.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1491b implements Comparator<Format> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1491b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Format format, Format format2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, format, format2)) == null) ? format2.bitrate - format.bitrate : invokeLL.intValue;
        }

        public /* synthetic */ C1491b(a aVar) {
            this();
        }
    }

    public b(s sVar, int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sVar, iArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        int i4 = 0;
        c.i.b.a.i0.a.f(iArr.length > 0);
        c.i.b.a.i0.a.e(sVar);
        this.f33419a = sVar;
        int length = iArr.length;
        this.f33420b = length;
        this.f33422d = new Format[length];
        for (int i5 = 0; i5 < iArr.length; i5++) {
            this.f33422d[i5] = sVar.a(iArr[i5]);
        }
        Arrays.sort(this.f33422d, new C1491b(null));
        this.f33421c = new int[this.f33420b];
        while (true) {
            int i6 = this.f33420b;
            if (i4 < i6) {
                this.f33421c[i4] = sVar.b(this.f33422d[i4]);
                i4++;
            } else {
                this.f33423e = new long[i6];
                return;
            }
        }
    }

    @Override // c.i.b.a.f0.f
    public final int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f33421c[i2] : invokeI.intValue;
    }

    @Override // c.i.b.a.f0.f
    public final int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            for (int i3 = 0; i3 < this.f33420b; i3++) {
                if (this.f33421c[i3] == i2) {
                    return i3;
                }
            }
            return -1;
        }
        return invokeI.intValue;
    }

    @Override // c.i.b.a.f0.f
    public final s d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33419a : (s) invokeV.objValue;
    }

    @Override // c.i.b.a.f0.f
    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33421c[a()] : invokeV.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f33419a == bVar.f33419a && Arrays.equals(this.f33421c, bVar.f33421c);
        }
        return invokeL.booleanValue;
    }

    @Override // c.i.b.a.f0.f
    public final Format f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f33422d[a()] : (Format) invokeV.objValue;
    }

    @Override // c.i.b.a.f0.f
    public final boolean g(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            boolean m = m(i2, elapsedRealtime);
            int i3 = 0;
            while (i3 < this.f33420b && !m) {
                m = (i3 == i2 || m(i3, elapsedRealtime)) ? false : true;
                i3++;
            }
            if (m) {
                long[] jArr = this.f33423e;
                jArr[i2] = Math.max(jArr[i2], elapsedRealtime + j2);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // c.i.b.a.f0.f
    public final Format h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? this.f33422d[i2] : (Format) invokeI.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f33424f == 0) {
                this.f33424f = (System.identityHashCode(this.f33419a) * 31) + Arrays.hashCode(this.f33421c);
            }
            return this.f33424f;
        }
        return invokeV.intValue;
    }

    @Override // c.i.b.a.f0.f
    public final int k(Format format) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, format)) == null) {
            for (int i2 = 0; i2 < this.f33420b; i2++) {
                if (this.f33422d[i2] == format) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @Override // c.i.b.a.f0.f
    public final int length() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f33421c.length : invokeV.intValue;
    }

    public final boolean m(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) ? this.f33423e[i2] > j2 : invokeCommon.booleanValue;
    }
}
