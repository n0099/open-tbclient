package c.i.b.a.d0.x.e;

import android.net.Uri;
import c.i.b.a.i0.u;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import java.util.List;
import java.util.UUID;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f33293a;

    /* renamed from: b  reason: collision with root package name */
    public final C1489a f33294b;

    /* renamed from: c  reason: collision with root package name */
    public final b[] f33295c;

    /* renamed from: d  reason: collision with root package name */
    public final long f33296d;

    /* renamed from: e  reason: collision with root package name */
    public final long f33297e;

    /* renamed from: c.i.b.a.d0.x.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1489a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final UUID f33298a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f33299b;

        public C1489a(UUID uuid, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uuid, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33298a = uuid;
            this.f33299b = bArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(int i2, int i3, long j2, long j3, long j4, int i4, boolean z, C1489a c1489a, b[] bVarArr) {
        this(i2, i3, j3 == 0 ? -9223372036854775807L : v.F(j3, 1000000L, j2), j4 != 0 ? v.F(j4, 1000000L, j2) : -9223372036854775807L, i4, z, c1489a, bVarArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i4), Boolean.valueOf(z), c1489a, bVarArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Long) objArr2[2]).longValue(), ((Long) objArr2[3]).longValue(), ((Integer) objArr2[4]).intValue(), ((Boolean) objArr2[5]).booleanValue(), (C1489a) objArr2[6], (b[]) objArr2[7]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f33300a;

        /* renamed from: b  reason: collision with root package name */
        public final long f33301b;

        /* renamed from: c  reason: collision with root package name */
        public final Format[] f33302c;

        /* renamed from: d  reason: collision with root package name */
        public final int f33303d;

        /* renamed from: e  reason: collision with root package name */
        public final String f33304e;

        /* renamed from: f  reason: collision with root package name */
        public final String f33305f;

        /* renamed from: g  reason: collision with root package name */
        public final List<Long> f33306g;

        /* renamed from: h  reason: collision with root package name */
        public final long[] f33307h;

        /* renamed from: i  reason: collision with root package name */
        public final long f33308i;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, int i2, String str3, long j2, String str4, int i3, int i4, int i5, int i6, String str5, Format[] formatArr, List<Long> list, long j3) {
            this(str, str2, i2, str3, j2, str4, i3, i4, i5, i6, str5, formatArr, list, v.G(list, 1000000L, j2), v.F(j3, 1000000L, j2));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, str2, Integer.valueOf(i2), str3, Long.valueOf(j2), str4, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), str5, formatArr, list, Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i7 = newInitContext.flag;
                if ((i7 & 1) != 0) {
                    int i8 = i7 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue(), (String) objArr2[3], ((Long) objArr2[4]).longValue(), (String) objArr2[5], ((Integer) objArr2[6]).intValue(), ((Integer) objArr2[7]).intValue(), ((Integer) objArr2[8]).intValue(), ((Integer) objArr2[9]).intValue(), (String) objArr2[10], (Format[]) objArr2[11], (List) objArr2[12], (long[]) objArr2[13], ((Long) objArr2[14]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public Uri a(int i2, int i3) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
                c.i.b.a.i0.a.f(this.f33302c != null);
                c.i.b.a.i0.a.f(this.f33306g != null);
                c.i.b.a.i0.a.f(i3 < this.f33306g.size());
                String num = Integer.toString(this.f33302c[i2].bitrate);
                String l = this.f33306g.get(i3).toString();
                return u.d(this.f33304e, this.f33305f.replace("{bitrate}", num).replace("{Bitrate}", num).replace("{start time}", l).replace("{start_time}", l));
            }
            return (Uri) invokeII.objValue;
        }

        public long b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                if (i2 == this.f33303d - 1) {
                    return this.f33308i;
                }
                long[] jArr = this.f33307h;
                return jArr[i2 + 1] - jArr[i2];
            }
            return invokeI.longValue;
        }

        public int c(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) ? v.e(this.f33307h, j2, true, true) : invokeJ.intValue;
        }

        public long d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.f33307h[i2] : invokeI.longValue;
        }

        public b(String str, String str2, int i2, String str3, long j2, String str4, int i3, int i4, int i5, int i6, String str5, Format[] formatArr, List<Long> list, long[] jArr, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, Integer.valueOf(i2), str3, Long.valueOf(j2), str4, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), str5, formatArr, list, jArr, Long.valueOf(j3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i7 = newInitContext.flag;
                if ((i7 & 1) != 0) {
                    int i8 = i7 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f33304e = str;
            this.f33305f = str2;
            this.f33300a = i2;
            this.f33301b = j2;
            this.f33302c = formatArr;
            this.f33306g = list;
            this.f33307h = jArr;
            this.f33308i = j3;
            this.f33303d = list.size();
        }
    }

    public a(int i2, int i3, long j2, long j3, int i4, boolean z, C1489a c1489a, b[] bVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i4), Boolean.valueOf(z), c1489a, bVarArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33296d = j2;
        this.f33297e = j3;
        this.f33293a = z;
        this.f33294b = c1489a;
        this.f33295c = bVarArr;
    }
}
