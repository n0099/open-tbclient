package b.h.b.a.a0.o;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.Stack;
/* loaded from: classes6.dex */
public final class a implements b.h.b.a.a0.o.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f32256a;

    /* renamed from: b  reason: collision with root package name */
    public final Stack<b> f32257b;

    /* renamed from: c  reason: collision with root package name */
    public final f f32258c;

    /* renamed from: d  reason: collision with root package name */
    public c f32259d;

    /* renamed from: e  reason: collision with root package name */
    public int f32260e;

    /* renamed from: f  reason: collision with root package name */
    public int f32261f;

    /* renamed from: g  reason: collision with root package name */
    public long f32262g;

    /* renamed from: b.h.b.a.a0.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class C1515a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f32263a;

        /* renamed from: b  reason: collision with root package name */
        public final long f32264b;

        public /* synthetic */ b(int i2, long j, C1515a c1515a) {
            this(i2, j);
        }

        public b(int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f32263a = i2;
            this.f32264b = j;
        }
    }

    public a() {
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
        this.f32256a = new byte[8];
        this.f32257b = new Stack<>();
        this.f32258c = new f();
    }

    @Override // b.h.b.a.a0.o.b
    public boolean a(b.h.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, fVar)) != null) {
            return invokeL.booleanValue;
        }
        b.h.b.a.i0.a.f(this.f32259d != null);
        while (true) {
            if (!this.f32257b.isEmpty() && fVar.getPosition() >= this.f32257b.peek().f32264b) {
                this.f32259d.a(this.f32257b.pop().f32263a);
                return true;
            }
            if (this.f32260e == 0) {
                long d2 = this.f32258c.d(fVar, true, false, 4);
                if (d2 == -2) {
                    d2 = c(fVar);
                }
                if (d2 == -1) {
                    return false;
                }
                this.f32261f = (int) d2;
                this.f32260e = 1;
            }
            if (this.f32260e == 1) {
                this.f32262g = this.f32258c.d(fVar, false, true, 8);
                this.f32260e = 2;
            }
            int g2 = this.f32259d.g(this.f32261f);
            if (g2 != 0) {
                if (g2 == 1) {
                    long position = fVar.getPosition();
                    this.f32257b.add(new b(this.f32261f, this.f32262g + position, null));
                    this.f32259d.f(this.f32261f, position, this.f32262g);
                    this.f32260e = 0;
                    return true;
                } else if (g2 == 2) {
                    long j = this.f32262g;
                    if (j <= 8) {
                        this.f32259d.c(this.f32261f, e(fVar, (int) j));
                        this.f32260e = 0;
                        return true;
                    }
                    throw new ParserException("Invalid integer size: " + this.f32262g);
                } else if (g2 == 3) {
                    long j2 = this.f32262g;
                    if (j2 <= 2147483647L) {
                        this.f32259d.e(this.f32261f, f(fVar, (int) j2));
                        this.f32260e = 0;
                        return true;
                    }
                    throw new ParserException("String element size: " + this.f32262g);
                } else if (g2 == 4) {
                    this.f32259d.d(this.f32261f, (int) this.f32262g, fVar);
                    this.f32260e = 0;
                    return true;
                } else if (g2 == 5) {
                    long j3 = this.f32262g;
                    if (j3 != 4 && j3 != 8) {
                        throw new ParserException("Invalid float size: " + this.f32262g);
                    }
                    this.f32259d.b(this.f32261f, d(fVar, (int) this.f32262g));
                    this.f32260e = 0;
                    return true;
                } else {
                    throw new ParserException("Invalid element type " + g2);
                }
            }
            fVar.h((int) this.f32262g);
            this.f32260e = 0;
        }
    }

    @Override // b.h.b.a.a0.o.b
    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f32259d = cVar;
        }
    }

    public final long c(b.h.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar)) != null) {
            return invokeL.longValue;
        }
        fVar.e();
        while (true) {
            fVar.c(this.f32256a, 0, 4);
            int c2 = f.c(this.f32256a[0]);
            if (c2 != -1 && c2 <= 4) {
                int a2 = (int) f.a(this.f32256a, c2, false);
                if (this.f32259d.h(a2)) {
                    fVar.h(c2);
                    return a2;
                }
            }
            fVar.h(1);
        }
    }

    public final double d(b.h.b.a.a0.f fVar, int i2) throws IOException, InterruptedException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, fVar, i2)) == null) {
            long e2 = e(fVar, i2);
            if (i2 == 4) {
                return Float.intBitsToFloat((int) e2);
            }
            return Double.longBitsToDouble(e2);
        }
        return invokeLI.doubleValue;
    }

    public final long e(b.h.b.a.a0.f fVar, int i2) throws IOException, InterruptedException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, fVar, i2)) == null) {
            fVar.readFully(this.f32256a, 0, i2);
            long j = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                j = (j << 8) | (this.f32256a[i3] & 255);
            }
            return j;
        }
        return invokeLI.longValue;
    }

    public final String f(b.h.b.a.a0.f fVar, int i2) throws IOException, InterruptedException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, fVar, i2)) == null) {
            if (i2 == 0) {
                return "";
            }
            byte[] bArr = new byte[i2];
            fVar.readFully(bArr, 0, i2);
            return new String(bArr);
        }
        return (String) invokeLI.objValue;
    }

    @Override // b.h.b.a.a0.o.b
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f32260e = 0;
            this.f32257b.clear();
            this.f32258c.e();
        }
    }
}
