package c.i.b.a.d0.u;

import android.util.SparseArray;
import c.i.b.a.a0.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import java.io.IOException;
/* loaded from: classes9.dex */
public final class d implements c.i.b.a.a0.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final c.i.b.a.a0.e f29182e;

    /* renamed from: f  reason: collision with root package name */
    public final int f29183f;

    /* renamed from: g  reason: collision with root package name */
    public final Format f29184g;

    /* renamed from: h  reason: collision with root package name */
    public final SparseArray<a> f29185h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f29186i;

    /* renamed from: j  reason: collision with root package name */
    public b f29187j;
    public c.i.b.a.a0.l k;
    public Format[] l;

    /* loaded from: classes9.dex */
    public static final class a implements c.i.b.a.a0.m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f29188b;

        /* renamed from: c  reason: collision with root package name */
        public final Format f29189c;

        /* renamed from: d  reason: collision with root package name */
        public Format f29190d;

        /* renamed from: e  reason: collision with root package name */
        public c.i.b.a.a0.m f29191e;

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
            this.a = i2;
            this.f29188b = i3;
            this.f29189c = format;
        }

        @Override // c.i.b.a.a0.m
        public void a(c.i.b.a.i0.l lVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, lVar, i2) == null) {
                this.f29191e.a(lVar, i2);
            }
        }

        @Override // c.i.b.a.a0.m
        public void b(Format format) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, format) == null) {
                Format format2 = this.f29189c;
                if (format2 != null) {
                    format = format.copyWithManifestFormatInfo(format2);
                }
                this.f29190d = format;
                this.f29191e.b(format);
            }
        }

        @Override // c.i.b.a.a0.m
        public void c(long j2, int i2, int i3, int i4, m.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), aVar}) == null) {
                this.f29191e.c(j2, i2, i3, i4, aVar);
            }
        }

        @Override // c.i.b.a.a0.m
        public int d(c.i.b.a.a0.f fVar, int i2, boolean z) throws IOException, InterruptedException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{fVar, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? this.f29191e.d(fVar, i2, z) : invokeCommon.intValue;
        }

        public void e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
                if (bVar == null) {
                    this.f29191e = new c.i.b.a.a0.d();
                    return;
                }
                c.i.b.a.a0.m a = bVar.a(this.a, this.f29188b);
                this.f29191e = a;
                Format format = this.f29190d;
                if (format != null) {
                    a.b(format);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        c.i.b.a.a0.m a(int i2, int i3);
    }

    public d(c.i.b.a.a0.e eVar, int i2, Format format) {
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
        this.f29182e = eVar;
        this.f29183f = i2;
        this.f29184g = format;
        this.f29185h = new SparseArray<>();
    }

    @Override // c.i.b.a.a0.g
    public c.i.b.a.a0.m a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            a aVar = this.f29185h.get(i2);
            if (aVar == null) {
                c.i.b.a.i0.a.f(this.l == null);
                aVar = new a(i2, i3, i3 == this.f29183f ? this.f29184g : null);
                aVar.e(this.f29187j);
                this.f29185h.put(i2, aVar);
            }
            return aVar;
        }
        return (c.i.b.a.a0.m) invokeII.objValue;
    }

    public Format[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (Format[]) invokeV.objValue;
    }

    public c.i.b.a.a0.l c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : (c.i.b.a.a0.l) invokeV.objValue;
    }

    public void d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f29187j = bVar;
            if (!this.f29186i) {
                this.f29182e.f(this);
                this.f29186i = true;
                return;
            }
            this.f29182e.a(0L, 0L);
            for (int i2 = 0; i2 < this.f29185h.size(); i2++) {
                this.f29185h.valueAt(i2).e(bVar);
            }
        }
    }

    @Override // c.i.b.a.a0.g
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Format[] formatArr = new Format[this.f29185h.size()];
            for (int i2 = 0; i2 < this.f29185h.size(); i2++) {
                formatArr[i2] = this.f29185h.valueAt(i2).f29190d;
            }
            this.l = formatArr;
        }
    }

    @Override // c.i.b.a.a0.g
    public void p(c.i.b.a.a0.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, lVar) == null) {
            this.k = lVar;
        }
    }
}
