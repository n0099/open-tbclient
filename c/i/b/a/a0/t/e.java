package c.i.b.a.a0.t;

import android.util.SparseArray;
import c.i.b.a.a0.t.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public final class e implements w.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final List<Format> f28828b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(int i2) {
        this(i2, Collections.emptyList());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.i.b.a.a0.t.w.c
    public w a(int i2, w.b bVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, bVar)) == null) {
            if (i2 != 2) {
                if (i2 == 3 || i2 == 4) {
                    return new p(new n(bVar.f28973b));
                }
                if (i2 == 15) {
                    if (d(2)) {
                        return null;
                    }
                    return new p(new d(false, bVar.f28973b));
                } else if (i2 == 17) {
                    if (d(2)) {
                        return null;
                    }
                    return new p(new m(bVar.f28973b));
                } else if (i2 != 21) {
                    if (i2 == 27) {
                        if (d(4)) {
                            return null;
                        }
                        return new p(new j(c(bVar), d(1), d(8)));
                    } else if (i2 != 36) {
                        if (i2 != 89) {
                            if (i2 != 138) {
                                if (i2 != 129) {
                                    if (i2 != 130) {
                                        if (i2 == 134) {
                                            if (d(16)) {
                                                return null;
                                            }
                                            return new s(new u());
                                        } else if (i2 != 135) {
                                            return null;
                                        }
                                    }
                                }
                                return new p(new b(bVar.f28973b));
                            }
                            return new p(new f(bVar.f28973b));
                        }
                        return new p(new g(bVar.f28974c));
                    } else {
                        return new p(new k(c(bVar)));
                    }
                } else {
                    return new p(new l());
                }
            }
            return new p(new i());
        }
        return (w) invokeIL.objValue;
    }

    @Override // c.i.b.a.a0.t.w.c
    public SparseArray<w> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new SparseArray<>() : (SparseArray) invokeV.objValue;
    }

    public final t c(w.b bVar) {
        InterceptResult invokeL;
        String str;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
            if (d(32)) {
                return new t(this.f28828b);
            }
            c.i.b.a.i0.l lVar = new c.i.b.a.i0.l(bVar.f28975d);
            List<Format> list = this.f28828b;
            while (lVar.a() > 0) {
                int x = lVar.x();
                int c2 = lVar.c() + lVar.x();
                if (x == 134) {
                    list = new ArrayList<>();
                    int x2 = lVar.x() & 31;
                    for (int i3 = 0; i3 < x2; i3++) {
                        String u = lVar.u(3);
                        int x3 = lVar.x();
                        if ((x3 & 128) != 0) {
                            i2 = x3 & 63;
                            str = "application/cea-708";
                        } else {
                            str = "application/cea-608";
                            i2 = 1;
                        }
                        list.add(Format.createTextSampleFormat((String) null, str, (String) null, -1, 0, u, i2, (DrmInitData) null));
                        lVar.K(2);
                    }
                }
                lVar.J(c2);
            }
            return new t(list);
        }
        return (t) invokeL.objValue;
    }

    public final boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? (i2 & this.a) != 0 : invokeI.booleanValue;
    }

    public e(int i2, List<Format> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = i2;
        if (!d(32) && list.isEmpty()) {
            list = Collections.singletonList(Format.createTextSampleFormat(null, "application/cea-608", 0, null));
        }
        this.f28828b = list;
    }
}
