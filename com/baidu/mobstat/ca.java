package com.baidu.mobstat;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.by;
import com.baidu.mobstat.cd;
import com.baidu.mobstat.cq;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes10.dex */
public class ca implements by {
    public static /* synthetic */ Interceptable $ic;
    public static final List<cd> a;

    /* renamed from: b  reason: collision with root package name */
    public static int f36802b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f36803c;

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ boolean f36804h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final BlockingQueue<ByteBuffer> f36805d;

    /* renamed from: e  reason: collision with root package name */
    public final BlockingQueue<ByteBuffer> f36806e;

    /* renamed from: f  reason: collision with root package name */
    public SelectionKey f36807f;

    /* renamed from: g  reason: collision with root package name */
    public ByteChannel f36808g;

    /* renamed from: i  reason: collision with root package name */
    public final cb f36809i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f36810j;
    public by.a k;
    public cd l;
    public by.b m;
    public cq n;
    public ByteBuffer o;
    public cs p;
    public String q;
    public Integer r;
    public Boolean s;
    public String t;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581658772, "Lcom/baidu/mobstat/ca;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581658772, "Lcom/baidu/mobstat/ca;");
                return;
            }
        }
        f36804h = !ca.class.desiredAssertionStatus();
        ArrayList arrayList = new ArrayList(4);
        a = arrayList;
        f36802b = 16384;
        f36803c = false;
        arrayList.add(new cf());
        a.add(new ce());
    }

    public ca(cb cbVar, cd cdVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cbVar, cdVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f36810j = false;
        this.k = by.a.a;
        this.l = null;
        this.n = null;
        this.o = ByteBuffer.allocate(0);
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        if (cbVar != null && cdVar != null) {
            this.f36805d = new LinkedBlockingQueue();
            this.f36806e = new LinkedBlockingQueue();
            this.f36809i = cbVar;
            this.m = by.b.a;
            if (cdVar != null) {
                this.l = cdVar.c();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("parameters must not be null");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean c(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        ByteBuffer byteBuffer2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, byteBuffer)) == null) {
            if (this.o.capacity() == 0) {
                byteBuffer2 = byteBuffer;
            } else {
                if (this.o.remaining() < byteBuffer.remaining()) {
                    ByteBuffer allocate = ByteBuffer.allocate(this.o.capacity() + byteBuffer.remaining());
                    this.o.flip();
                    allocate.put(this.o);
                    this.o = allocate;
                }
                this.o.put(byteBuffer);
                this.o.flip();
                byteBuffer2 = this.o;
            }
            byteBuffer2.mark();
            try {
            } catch (cg e2) {
                if (this.o.capacity() != 0) {
                }
            }
            if (this.l == null && e(byteBuffer2) == cd.b.a) {
                try {
                    f(ByteBuffer.wrap(dc.a(this.f36809i.a(this))));
                    a(-3, "");
                } catch (ch unused) {
                    c(1006, "remote peer closed connection before flashpolicy could be transmitted", true);
                }
                return false;
            }
            try {
                if (this.m == by.b.a) {
                    this.l.a(this.m);
                    cx d2 = this.l.d(byteBuffer2);
                    if (!(d2 instanceof cz)) {
                        b(1002, "wrong http function", false);
                        return false;
                    }
                    cz czVar = (cz) d2;
                    if (this.l.a(this.p, czVar) == cd.b.a) {
                        try {
                            this.f36809i.a(this, this.p, czVar);
                            a(czVar);
                            return true;
                        } catch (ch e3) {
                            b(e3.a(), e3.getMessage(), false);
                            return false;
                        } catch (RuntimeException e4) {
                            this.f36809i.a(this, e4);
                            b(-1, e4.getMessage(), false);
                            return false;
                        }
                    }
                    a(1002, "draft " + this.l + " refuses handshake");
                }
            } catch (cj e5) {
                a(e5);
            }
            return false;
            if (this.o.capacity() != 0) {
                byteBuffer2.reset();
                int a2 = e2.a();
                if (a2 == 0) {
                    a2 = byteBuffer2.capacity() + 16;
                } else if (!f36804h && e2.a() < byteBuffer2.remaining()) {
                    throw new AssertionError();
                }
                ByteBuffer allocate2 = ByteBuffer.allocate(a2);
                this.o = allocate2;
                allocate2.put(byteBuffer);
            } else {
                ByteBuffer byteBuffer3 = this.o;
                byteBuffer3.position(byteBuffer3.limit());
                ByteBuffer byteBuffer4 = this.o;
                byteBuffer4.limit(byteBuffer4.capacity());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void d(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, byteBuffer) == null) {
            try {
            } catch (ch e2) {
                this.f36809i.a(this, e2);
                a(e2);
                return;
            }
            for (cq cqVar : this.l.c(byteBuffer)) {
                if (f36803c) {
                    PrintStream printStream = System.out;
                    printStream.println("matched frame: " + cqVar);
                }
                cq.a f2 = cqVar.f();
                boolean d2 = cqVar.d();
                if (this.k == by.a.f36798d) {
                    return;
                }
                if (f2 == cq.a.f36839f) {
                    int i2 = 1005;
                    String str = "";
                    if (cqVar instanceof cn) {
                        cn cnVar = (cn) cqVar;
                        i2 = cnVar.a();
                        str = cnVar.b();
                    }
                    if (this.k == by.a.f36798d) {
                        a(i2, str, true);
                    } else if (this.l.b() == cd.a.f36825c) {
                        c(i2, str, true);
                    } else {
                        b(i2, str, false);
                    }
                } else if (f2 == cq.a.f36837d) {
                    this.f36809i.b(this, cqVar);
                } else if (f2 == cq.a.f36838e) {
                    this.f36809i.c(this, cqVar);
                } else {
                    if (d2 && f2 != cq.a.a) {
                        if (this.n == null) {
                            if (f2 == cq.a.f36835b) {
                                try {
                                    this.f36809i.a(this, dc.a(cqVar.c()));
                                } catch (RuntimeException e3) {
                                    this.f36809i.a(this, e3);
                                }
                            } else if (f2 == cq.a.f36836c) {
                                try {
                                    this.f36809i.a(this, cqVar.c());
                                } catch (RuntimeException e4) {
                                    this.f36809i.a(this, e4);
                                }
                            } else {
                                throw new ch(1002, "non control or continious frame expected");
                            }
                            this.f36809i.a(this, e2);
                            a(e2);
                            return;
                        }
                        throw new ch(1002, "Continuous frame sequence not completed.");
                    }
                    if (f2 != cq.a.a) {
                        if (this.n == null) {
                            this.n = cqVar;
                        } else {
                            throw new ch(1002, "Previous continuous frame sequence not completed.");
                        }
                    } else if (d2) {
                        if (this.n != null) {
                            if (this.n.f() == cq.a.f36835b) {
                                int max = Math.max(this.n.c().limit() - 64, 0);
                                this.n.a(cqVar);
                                if (!dc.a(this.n.c(), max)) {
                                    throw new ch(1007);
                                }
                            }
                            this.n = null;
                        } else {
                            throw new ch(1002, "Continuous frame sequence was not started.");
                        }
                    } else if (this.n == null) {
                        throw new ch(1002, "Continuous frame sequence was not started.");
                    }
                    if (f2 == cq.a.f36835b && !dc.b(cqVar.c())) {
                        throw new ch(1007);
                    }
                    if (f2 == cq.a.a && this.n != null && this.n.f() == cq.a.f36835b) {
                        int max2 = Math.max(this.n.c().limit() - 64, 0);
                        this.n.a(cqVar);
                        if (!dc.a(this.n.c(), max2)) {
                            throw new ch(1007);
                        }
                    }
                    try {
                        this.f36809i.a(this, cqVar);
                    } catch (RuntimeException e5) {
                        this.f36809i.a(this, e5);
                    }
                }
            }
        }
    }

    private cd.b e(ByteBuffer byteBuffer) throws cg {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, byteBuffer)) == null) {
            byteBuffer.mark();
            if (byteBuffer.limit() > cd.f36821c.length) {
                return cd.b.f36827b;
            }
            if (byteBuffer.limit() >= cd.f36821c.length) {
                int i2 = 0;
                while (byteBuffer.hasRemaining()) {
                    if (cd.f36821c[i2] != byteBuffer.get()) {
                        byteBuffer.reset();
                        return cd.b.f36827b;
                    }
                    i2++;
                }
                return cd.b.a;
            }
            throw new cg(cd.f36821c.length);
        }
        return (cd.b) invokeL.objValue;
    }

    private void f(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, byteBuffer) == null) {
            if (f36803c) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append("write(");
                sb.append(byteBuffer.remaining());
                sb.append("): {");
                sb.append(byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array()));
                sb.append("}");
                printStream.println(sb.toString());
            }
            this.f36805d.add(byteBuffer);
            this.f36809i.b(this);
        }
    }

    public void a(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer) == null) {
            if (!f36804h && !byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (f36803c) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append("process(");
                sb.append(byteBuffer.remaining());
                sb.append("): {");
                sb.append(byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining()));
                sb.append("}");
                printStream.println(sb.toString());
            }
            if (this.k != by.a.a) {
                d(byteBuffer);
            } else if (c(byteBuffer)) {
                if (!f36804h && this.o.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                    throw new AssertionError();
                }
                if (byteBuffer.hasRemaining()) {
                    d(byteBuffer);
                } else if (this.o.hasRemaining()) {
                    d(this.o);
                }
            }
            if (!f36804h && !d() && !e() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
        }
    }

    public void b(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i2, str) == null) {
            a(i2, str, false);
        }
    }

    public by.a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.k : (by.a) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? super.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? super.toString() : (String) invokeV.objValue;
    }

    public synchronized void b(int i2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (this.f36810j) {
                    return;
                }
                this.r = Integer.valueOf(i2);
                this.q = str;
                this.s = Boolean.valueOf(z);
                this.f36810j = true;
                this.f36809i.b(this);
                try {
                    this.f36809i.b(this, i2, str, z);
                } catch (RuntimeException e2) {
                    this.f36809i.a(this, e2);
                }
                if (this.l != null) {
                    this.l.a();
                }
                this.p = null;
            }
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.k == by.a.f36799e : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f36810j : invokeV.booleanValue;
    }

    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
            c(i2, str, false);
        }
    }

    public synchronized void a(int i2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (this.k == by.a.f36799e) {
                    return;
                }
                if (this.f36807f != null) {
                    this.f36807f.cancel();
                }
                if (this.f36808g != null) {
                    try {
                        this.f36808g.close();
                    } catch (IOException e2) {
                        this.f36809i.a(this, e2);
                    }
                }
                try {
                    this.f36809i.a(this, i2, str, z);
                } catch (RuntimeException e3) {
                    this.f36809i.a(this, e3);
                }
                if (this.l != null) {
                    this.l.a();
                }
                this.p = null;
                this.k = by.a.f36799e;
                this.f36805d.clear();
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (g() == by.a.a) {
                a(-1, true);
            } else if (this.f36810j) {
                a(this.r.intValue(), this.q, this.s.booleanValue());
            } else if (this.l.b() == cd.a.a) {
                a(1000, true);
            } else if (this.l.b() == cd.a.f36824b) {
                a(1000, true);
            } else {
                a(1006, true);
            }
        }
    }

    public void b(ByteBuffer byteBuffer) throws IllegalArgumentException, cm {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, byteBuffer) == null) {
            if (byteBuffer == null) {
                throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
            }
            a(this.l.a(byteBuffer, this.m == by.b.a));
        }
    }

    public void a(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            a(i2, "", z);
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            c(i2, "", false);
        }
    }

    public void a(ch chVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, chVar) == null) {
            c(chVar.a(), chVar.getMessage(), false);
        }
    }

    public void a(byte[] bArr) throws IllegalArgumentException, cm {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bArr) == null) {
            b(ByteBuffer.wrap(bArr));
        }
    }

    private void a(Collection<cq> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, collection) == null) {
            if (c()) {
                for (cq cqVar : collection) {
                    a(cqVar);
                }
                return;
            }
            throw new cm();
        }
    }

    @Override // com.baidu.mobstat.by
    public void a(cq cqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cqVar) == null) {
            if (f36803c) {
                PrintStream printStream = System.out;
                printStream.println("send frame: " + cqVar);
            }
            f(this.l.a(cqVar));
        }
    }

    public void a(ct ctVar) throws cj {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ctVar) == null) {
            if (!f36804h && this.k == by.a.f36796b) {
                throw new AssertionError("shall only be called once");
            }
            this.p = this.l.a(ctVar);
            String a2 = ctVar.a();
            this.t = a2;
            if (!f36804h && a2 == null) {
                throw new AssertionError();
            }
            try {
                this.f36809i.a((by) this, this.p);
                a(this.l.a(this.p, this.m));
            } catch (ch unused) {
                throw new cj("Handshake data rejected by client.");
            } catch (RuntimeException e2) {
                this.f36809i.a(this, e2);
                throw new cj("rejected because of" + e2);
            }
        }
    }

    private void c(int i2, String str, boolean z) {
        by.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) || (aVar = this.k) == by.a.f36798d || aVar == by.a.f36799e) {
            return;
        }
        if (aVar == by.a.f36797c) {
            if (i2 == 1006) {
                if (!f36804h && z) {
                    throw new AssertionError();
                }
                this.k = by.a.f36798d;
                b(i2, str, false);
                return;
            }
            if (this.l.b() != cd.a.a) {
                try {
                    if (!z) {
                        try {
                            this.f36809i.a(this, i2, str);
                        } catch (RuntimeException e2) {
                            this.f36809i.a(this, e2);
                        }
                    }
                    a(new co(i2, str));
                } catch (ch e3) {
                    this.f36809i.a(this, e3);
                    b(1006, "generated frame is invalid", false);
                }
            }
            b(i2, str, z);
        } else if (i2 == -3) {
            if (!f36804h && !z) {
                throw new AssertionError();
            }
            b(-3, str, true);
        } else {
            b(-1, str, false);
        }
        if (i2 == 1002) {
            b(i2, str, z);
        }
        this.k = by.a.f36798d;
        this.o = null;
    }

    private void a(List<ByteBuffer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, list) == null) {
            for (ByteBuffer byteBuffer : list) {
                f(byteBuffer);
            }
        }
    }

    private void a(cx cxVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, cxVar) == null) {
            if (f36803c) {
                PrintStream printStream = System.out;
                printStream.println("open using draft: " + this.l.getClass().getSimpleName());
            }
            this.k = by.a.f36797c;
            try {
                this.f36809i.a(this, cxVar);
            } catch (RuntimeException e2) {
                this.f36809i.a(this, e2);
            }
        }
    }

    @Override // com.baidu.mobstat.by
    public InetSocketAddress a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f36809i.c(this) : (InetSocketAddress) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.k == by.a.f36798d : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (!f36804h && this.k == by.a.f36797c && this.f36810j) {
                throw new AssertionError();
            }
            return this.k == by.a.f36797c;
        }
        return invokeV.booleanValue;
    }
}
