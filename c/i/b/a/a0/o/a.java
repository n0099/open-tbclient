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
/* loaded from: classes4.dex */
public final class a implements c.i.b.a.a0.o.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f32517a;

    /* renamed from: b  reason: collision with root package name */
    public final Stack<b> f32518b;

    /* renamed from: c  reason: collision with root package name */
    public final f f32519c;

    /* renamed from: d  reason: collision with root package name */
    public c f32520d;

    /* renamed from: e  reason: collision with root package name */
    public int f32521e;

    /* renamed from: f  reason: collision with root package name */
    public int f32522f;

    /* renamed from: g  reason: collision with root package name */
    public long f32523g;

    /* renamed from: c.i.b.a.a0.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C1477a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f32524a;

        /* renamed from: b  reason: collision with root package name */
        public final long f32525b;

        public /* synthetic */ b(int i2, long j2, C1477a c1477a) {
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
            this.f32524a = i2;
            this.f32525b = j2;
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
        this.f32517a = new byte[8];
        this.f32518b = new Stack<>();
        this.f32519c = new f();
    }

    @Override // c.i.b.a.a0.o.b
    public boolean a(c.i.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, fVar)) != null) {
            return invokeL.booleanValue;
        }
        c.i.b.a.i0.a.f(this.f32520d != null);
        while (true) {
            if (!this.f32518b.isEmpty() && fVar.getPosition() >= this.f32518b.peek().f32525b) {
                this.f32520d.a(this.f32518b.pop().f32524a);
                return true;
            }
            if (this.f32521e == 0) {
                long d2 = this.f32519c.d(fVar, true, false, 4);
                if (d2 == -2) {
                    d2 = c(fVar);
                }
                if (d2 == -1) {
                    return false;
                }
                this.f32522f = (int) d2;
                this.f32521e = 1;
            }
            if (this.f32521e == 1) {
                this.f32523g = this.f32519c.d(fVar, false, true, 8);
                this.f32521e = 2;
            }
            int g2 = this.f32520d.g(this.f32522f);
            if (g2 != 0) {
                if (g2 == 1) {
                    long position = fVar.getPosition();
                    this.f32518b.add(new b(this.f32522f, this.f32523g + position, null));
                    this.f32520d.f(this.f32522f, position, this.f32523g);
                    this.f32521e = 0;
                    return true;
                } else if (g2 == 2) {
                    long j2 = this.f32523g;
                    if (j2 <= 8) {
                        this.f32520d.c(this.f32522f, e(fVar, (int) j2));
                        this.f32521e = 0;
                        return true;
                    }
                    throw new ParserException("Invalid integer size: " + this.f32523g);
                } else if (g2 == 3) {
                    long j3 = this.f32523g;
                    if (j3 <= 2147483647L) {
                        this.f32520d.e(this.f32522f, f(fVar, (int) j3));
                        this.f32521e = 0;
                        return true;
                    }
                    throw new ParserException("String element size: " + this.f32523g);
                } else if (g2 == 4) {
                    this.f32520d.d(this.f32522f, (int) this.f32523g, fVar);
                    this.f32521e = 0;
                    return true;
                } else if (g2 == 5) {
                    long j4 = this.f32523g;
                    if (j4 != 4 && j4 != 8) {
                        throw new ParserException("Invalid float size: " + this.f32523g);
                    }
                    this.f32520d.b(this.f32522f, d(fVar, (int) this.f32523g));
                    this.f32521e = 0;
                    return true;
                } else {
                    throw new ParserException("Invalid element type " + g2);
                }
            }
            fVar.h((int) this.f32523g);
            this.f32521e = 0;
        }
    }

    @Override // c.i.b.a.a0.o.b
    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f32520d = cVar;
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
            fVar.c(this.f32517a, 0, 4);
            int c2 = f.c(this.f32517a[0]);
            if (c2 != -1 && c2 <= 4) {
                int a2 = (int) f.a(this.f32517a, c2, false);
                if (this.f32520d.h(a2)) {
                    fVar.h(c2);
                    return a2;
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
            fVar.readFully(this.f32517a, 0, i2);
            long j2 = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                j2 = (j2 << 8) | (this.f32517a[i3] & 255);
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
            this.f32521e = 0;
            this.f32518b.clear();
            this.f32519c.e();
        }
    }
}
