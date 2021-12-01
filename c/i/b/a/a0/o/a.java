package c.i.b.a.a0.o;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.Stack;
/* loaded from: classes7.dex */
public final class a implements c.i.b.a.a0.o.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public final Stack<b> f29045b;

    /* renamed from: c  reason: collision with root package name */
    public final f f29046c;

    /* renamed from: d  reason: collision with root package name */
    public c f29047d;

    /* renamed from: e  reason: collision with root package name */
    public int f29048e;

    /* renamed from: f  reason: collision with root package name */
    public int f29049f;

    /* renamed from: g  reason: collision with root package name */
    public long f29050g;

    /* renamed from: c.i.b.a.a0.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class C1591a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final long f29051b;

        public /* synthetic */ b(int i2, long j2, C1591a c1591a) {
            this(i2, j2);
        }

        public b(int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i2;
            this.f29051b = j2;
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
        this.a = new byte[8];
        this.f29045b = new Stack<>();
        this.f29046c = new f();
    }

    @Override // c.i.b.a.a0.o.b
    public boolean a(c.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, fVar)) != null) {
            return invokeL.booleanValue;
        }
        c.i.b.a.i0.a.f(this.f29047d != null);
        while (true) {
            if (!this.f29045b.isEmpty() && fVar.getPosition() >= this.f29045b.peek().f29051b) {
                this.f29047d.a(this.f29045b.pop().a);
                return true;
            }
            if (this.f29048e == 0) {
                long d2 = this.f29046c.d(fVar, true, false, 4);
                if (d2 == -2) {
                    d2 = c(fVar);
                }
                if (d2 == -1) {
                    return false;
                }
                this.f29049f = (int) d2;
                this.f29048e = 1;
            }
            if (this.f29048e == 1) {
                this.f29050g = this.f29046c.d(fVar, false, true, 8);
                this.f29048e = 2;
            }
            int g2 = this.f29047d.g(this.f29049f);
            if (g2 != 0) {
                if (g2 == 1) {
                    long position = fVar.getPosition();
                    this.f29045b.add(new b(this.f29049f, this.f29050g + position, null));
                    this.f29047d.f(this.f29049f, position, this.f29050g);
                    this.f29048e = 0;
                    return true;
                } else if (g2 == 2) {
                    long j2 = this.f29050g;
                    if (j2 <= 8) {
                        this.f29047d.c(this.f29049f, e(fVar, (int) j2));
                        this.f29048e = 0;
                        return true;
                    }
                    throw new ParserException("Invalid integer size: " + this.f29050g);
                } else if (g2 == 3) {
                    long j3 = this.f29050g;
                    if (j3 <= 2147483647L) {
                        this.f29047d.e(this.f29049f, f(fVar, (int) j3));
                        this.f29048e = 0;
                        return true;
                    }
                    throw new ParserException("String element size: " + this.f29050g);
                } else if (g2 == 4) {
                    this.f29047d.d(this.f29049f, (int) this.f29050g, fVar);
                    this.f29048e = 0;
                    return true;
                } else if (g2 == 5) {
                    long j4 = this.f29050g;
                    if (j4 != 4 && j4 != 8) {
                        throw new ParserException("Invalid float size: " + this.f29050g);
                    }
                    this.f29047d.b(this.f29049f, d(fVar, (int) this.f29050g));
                    this.f29048e = 0;
                    return true;
                } else {
                    throw new ParserException("Invalid element type " + g2);
                }
            }
            fVar.h((int) this.f29050g);
            this.f29048e = 0;
        }
    }

    @Override // c.i.b.a.a0.o.b
    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f29047d = cVar;
        }
    }

    public final long c(c.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar)) != null) {
            return invokeL.longValue;
        }
        fVar.e();
        while (true) {
            fVar.c(this.a, 0, 4);
            int c2 = f.c(this.a[0]);
            if (c2 != -1 && c2 <= 4) {
                int a = (int) f.a(this.a, c2, false);
                if (this.f29047d.h(a)) {
                    fVar.h(c2);
                    return a;
                }
            }
            fVar.h(1);
        }
    }

    public final double d(c.i.b.a.a0.f fVar, int i2) throws IOException, InterruptedException {
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

    public final long e(c.i.b.a.a0.f fVar, int i2) throws IOException, InterruptedException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, fVar, i2)) == null) {
            fVar.readFully(this.a, 0, i2);
            long j2 = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                j2 = (j2 << 8) | (this.a[i3] & 255);
            }
            return j2;
        }
        return invokeLI.longValue;
    }

    public final String f(c.i.b.a.a0.f fVar, int i2) throws IOException, InterruptedException {
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

    @Override // c.i.b.a.a0.o.b
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f29048e = 0;
            this.f29045b.clear();
            this.f29046c.e();
        }
    }
}
