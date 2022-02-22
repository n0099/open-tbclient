package c.i.b.a.j0;

import c.i.b.a.i0.j;
import c.i.b.a.i0.l;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<byte[]> a;

    /* renamed from: b  reason: collision with root package name */
    public final int f30000b;

    /* renamed from: c  reason: collision with root package name */
    public final int f30001c;

    /* renamed from: d  reason: collision with root package name */
    public final int f30002d;

    /* renamed from: e  reason: collision with root package name */
    public final float f30003e;

    public a(List<byte[]> list, int i2, int i3, int i4, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = list;
        this.f30000b = i2;
        this.f30001c = i3;
        this.f30002d = i4;
        this.f30003e = f2;
    }

    public static byte[] a(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, lVar)) == null) {
            int D = lVar.D();
            int c2 = lVar.c();
            lVar.K(D);
            return c.i.b.a.i0.c.c(lVar.a, c2, D);
        }
        return (byte[]) invokeL.objValue;
    }

    public static a b(l lVar) throws ParserException {
        InterceptResult invokeL;
        int i2;
        int i3;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, lVar)) == null) {
            try {
                lVar.K(4);
                int x = (lVar.x() & 3) + 1;
                if (x != 3) {
                    ArrayList arrayList = new ArrayList();
                    int x2 = lVar.x() & 31;
                    for (int i4 = 0; i4 < x2; i4++) {
                        arrayList.add(a(lVar));
                    }
                    int x3 = lVar.x();
                    for (int i5 = 0; i5 < x3; i5++) {
                        arrayList.add(a(lVar));
                    }
                    if (x2 > 0) {
                        j.b i6 = j.i((byte[]) arrayList.get(0), x, ((byte[]) arrayList.get(0)).length);
                        int i7 = i6.f29940b;
                        int i8 = i6.f29941c;
                        f2 = i6.f29942d;
                        i2 = i7;
                        i3 = i8;
                    } else {
                        i2 = -1;
                        i3 = -1;
                        f2 = 1.0f;
                    }
                    return new a(arrayList, x, i2, i3, f2);
                }
                throw new IllegalStateException();
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new ParserException("Error parsing AVC config", e2);
            }
        }
        return (a) invokeL.objValue;
    }
}
