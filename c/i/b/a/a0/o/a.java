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
/* loaded from: classes9.dex */
public final class a implements c.i.b.a.a0.o.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] a;

    /* renamed from: b  reason: collision with root package name */
    public final Stack<b> f29493b;

    /* renamed from: c  reason: collision with root package name */
    public final f f29494c;

    /* renamed from: d  reason: collision with root package name */
    public c f29495d;

    /* renamed from: e  reason: collision with root package name */
    public int f29496e;

    /* renamed from: f  reason: collision with root package name */
    public int f29497f;

    /* renamed from: g  reason: collision with root package name */
    public long f29498g;

    /* renamed from: c.i.b.a.a0.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class C1634a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final long f29499b;

        public /* synthetic */ b(int i2, long j2, C1634a c1634a) {
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
            this.f29499b = j2;
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
        this.f29493b = new Stack<>();
        this.f29494c = new f();
    }

    @Override // c.i.b.a.a0.o.b
    public boolean a(c.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, fVar)) != null) {
            return invokeL.booleanValue;
        }
        c.i.b.a.i0.a.f(this.f29495d != null);
        while (true) {
            if (!this.f29493b.isEmpty() && fVar.getPosition() >= this.f29493b.peek().f29499b) {
                this.f29495d.a(this.f29493b.pop().a);
                return true;
            }
            if (this.f29496e == 0) {
                long d2 = this.f29494c.d(fVar, true, false, 4);
                if (d2 == -2) {
                    d2 = c(fVar);
                }
                if (d2 == -1) {
                    return false;
                }
                this.f29497f = (int) d2;
                this.f29496e = 1;
            }
            if (this.f29496e == 1) {
                this.f29498g = this.f29494c.d(fVar, false, true, 8);
                this.f29496e = 2;
            }
            int g2 = this.f29495d.g(this.f29497f);
            if (g2 != 0) {
                if (g2 == 1) {
                    long position = fVar.getPosition();
                    this.f29493b.add(new b(this.f29497f, this.f29498g + position, null));
                    this.f29495d.f(this.f29497f, position, this.f29498g);
                    this.f29496e = 0;
                    return true;
                } else if (g2 == 2) {
                    long j2 = this.f29498g;
                    if (j2 <= 8) {
                        this.f29495d.c(this.f29497f, e(fVar, (int) j2));
                        this.f29496e = 0;
                        return true;
                    }
                    throw new ParserException("Invalid integer size: " + this.f29498g);
                } else if (g2 == 3) {
                    long j3 = this.f29498g;
                    if (j3 <= 2147483647L) {
                        this.f29495d.e(this.f29497f, f(fVar, (int) j3));
                        this.f29496e = 0;
                        return true;
                    }
                    throw new ParserException("String element size: " + this.f29498g);
                } else if (g2 == 4) {
                    this.f29495d.d(this.f29497f, (int) this.f29498g, fVar);
                    this.f29496e = 0;
                    return true;
                } else if (g2 == 5) {
                    long j4 = this.f29498g;
                    if (j4 != 4 && j4 != 8) {
                        throw new ParserException("Invalid float size: " + this.f29498g);
                    }
                    this.f29495d.b(this.f29497f, d(fVar, (int) this.f29498g));
                    this.f29496e = 0;
                    return true;
                } else {
                    throw new ParserException("Invalid element type " + g2);
                }
            }
            fVar.h((int) this.f29498g);
            this.f29496e = 0;
        }
    }

    @Override // c.i.b.a.a0.o.b
    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f29495d = cVar;
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
                if (this.f29495d.h(a)) {
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
            this.f29496e = 0;
            this.f29493b.clear();
            this.f29494c.e();
        }
    }
}
