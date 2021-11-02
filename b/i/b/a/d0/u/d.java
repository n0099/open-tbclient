package b.i.b.a.d0.u;

import android.util.SparseArray;
import b.i.b.a.a0.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class d implements b.i.b.a.a0.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final b.i.b.a.a0.e f32014e;

    /* renamed from: f  reason: collision with root package name */
    public final int f32015f;

    /* renamed from: g  reason: collision with root package name */
    public final Format f32016g;

    /* renamed from: h  reason: collision with root package name */
    public final SparseArray<a> f32017h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f32018i;
    public b j;
    public b.i.b.a.a0.l k;
    public Format[] l;

    /* loaded from: classes6.dex */
    public static final class a implements b.i.b.a.a0.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f32019a;

        /* renamed from: b  reason: collision with root package name */
        public final int f32020b;

        /* renamed from: c  reason: collision with root package name */
        public final Format f32021c;

        /* renamed from: d  reason: collision with root package name */
        public Format f32022d;

        /* renamed from: e  reason: collision with root package name */
        public b.i.b.a.a0.m f32023e;

        public a(int i2, int i3, Format format) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), format};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32019a = i2;
            this.f32020b = i3;
            this.f32021c = format;
        }

        @Override // b.i.b.a.a0.m
        public void a(b.i.b.a.i0.l lVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, lVar, i2) == null) {
                this.f32023e.a(lVar, i2);
            }
        }

        @Override // b.i.b.a.a0.m
        public void b(Format format) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, format) == null) {
                Format format2 = this.f32021c;
                if (format2 != null) {
                    format = format.copyWithManifestFormatInfo(format2);
                }
                this.f32022d = format;
                this.f32023e.b(format);
            }
        }

        @Override // b.i.b.a.a0.m
        public void c(long j, int i2, int i3, int i4, m.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), aVar}) == null) {
                this.f32023e.c(j, i2, i3, i4, aVar);
            }
        }

        @Override // b.i.b.a.a0.m
        public int d(b.i.b.a.a0.f fVar, int i2, boolean z) throws IOException, InterruptedException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{fVar, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? this.f32023e.d(fVar, i2, z) : invokeCommon.intValue;
        }

        public void e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
                if (bVar == null) {
                    this.f32023e = new b.i.b.a.a0.d();
                    return;
                }
                b.i.b.a.a0.m a2 = bVar.a(this.f32019a, this.f32020b);
                this.f32023e = a2;
                Format format = this.f32022d;
                if (format != null) {
                    a2.b(format);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        b.i.b.a.a0.m a(int i2, int i3);
    }

    public d(b.i.b.a.a0.e eVar, int i2, Format format) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, Integer.valueOf(i2), format};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32014e = eVar;
        this.f32015f = i2;
        this.f32016g = format;
        this.f32017h = new SparseArray<>();
    }

    @Override // b.i.b.a.a0.g
    public b.i.b.a.a0.m a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            a aVar = this.f32017h.get(i2);
            if (aVar == null) {
                b.i.b.a.i0.a.f(this.l == null);
                aVar = new a(i2, i3, i3 == this.f32015f ? this.f32016g : null);
                aVar.e(this.j);
                this.f32017h.put(i2, aVar);
            }
            return aVar;
        }
        return (b.i.b.a.a0.m) invokeII.objValue;
    }

    public Format[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (Format[]) invokeV.objValue;
    }

    public b.i.b.a.a0.l c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : (b.i.b.a.a0.l) invokeV.objValue;
    }

    public void d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.j = bVar;
            if (!this.f32018i) {
                this.f32014e.f(this);
                this.f32018i = true;
                return;
            }
            this.f32014e.a(0L, 0L);
            for (int i2 = 0; i2 < this.f32017h.size(); i2++) {
                this.f32017h.valueAt(i2).e(bVar);
            }
        }
    }

    @Override // b.i.b.a.a0.g
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Format[] formatArr = new Format[this.f32017h.size()];
            for (int i2 = 0; i2 < this.f32017h.size(); i2++) {
                formatArr[i2] = this.f32017h.valueAt(i2).f32022d;
            }
            this.l = formatArr;
        }
    }

    @Override // b.i.b.a.a0.g
    public void p(b.i.b.a.a0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, lVar) == null) {
            this.k = lVar;
        }
    }
}
