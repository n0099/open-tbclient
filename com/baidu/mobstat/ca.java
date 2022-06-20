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
/* loaded from: classes2.dex */
public class ca implements by {
    public static /* synthetic */ Interceptable $ic;
    public static final List<cd> a;
    public static int b;
    public static boolean c;
    public static final /* synthetic */ boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public final BlockingQueue<ByteBuffer> d;
    public final BlockingQueue<ByteBuffer> e;
    public SelectionKey f;
    public ByteChannel g;
    public final cb i;
    public volatile boolean j;
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
        h = !ca.class.desiredAssertionStatus();
        ArrayList arrayList = new ArrayList(4);
        a = arrayList;
        b = 16384;
        c = false;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = false;
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
            this.d = new LinkedBlockingQueue();
            this.e = new LinkedBlockingQueue();
            this.i = cbVar;
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
            } catch (cg e) {
                if (this.o.capacity() != 0) {
                }
            }
            if (this.l == null && e(byteBuffer2) == cd.b.a) {
                try {
                    f(ByteBuffer.wrap(dc.a(this.i.a(this))));
                    a(-3, "");
                } catch (ch unused) {
                    c(1006, "remote peer closed connection before flashpolicy could be transmitted", true);
                }
                return false;
            }
            try {
                if (this.m == by.b.a) {
                    this.l.a(this.m);
                    cx d = this.l.d(byteBuffer2);
                    if (!(d instanceof cz)) {
                        b(1002, "wrong http function", false);
                        return false;
                    }
                    cz czVar = (cz) d;
                    if (this.l.a(this.p, czVar) == cd.b.a) {
                        try {
                            this.i.a(this, this.p, czVar);
                            a(czVar);
                            return true;
                        } catch (ch e2) {
                            b(e2.a(), e2.getMessage(), false);
                            return false;
                        } catch (RuntimeException e3) {
                            this.i.a(this, e3);
                            b(-1, e3.getMessage(), false);
                            return false;
                        }
                    }
                    a(1002, "draft " + this.l + " refuses handshake");
                }
            } catch (cj e4) {
                a(e4);
            }
            return false;
            if (this.o.capacity() != 0) {
                byteBuffer2.reset();
                int a2 = e.a();
                if (a2 == 0) {
                    a2 = byteBuffer2.capacity() + 16;
                } else if (!h && e.a() < byteBuffer2.remaining()) {
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
            } catch (ch e) {
                this.i.a(this, e);
                a(e);
                return;
            }
            for (cq cqVar : this.l.c(byteBuffer)) {
                if (c) {
                    PrintStream printStream = System.out;
                    printStream.println("matched frame: " + cqVar);
                }
                cq.a f = cqVar.f();
                boolean d = cqVar.d();
                if (this.k == by.a.d) {
                    return;
                }
                if (f == cq.a.f) {
                    int i = 1005;
                    String str = "";
                    if (cqVar instanceof cn) {
                        cn cnVar = (cn) cqVar;
                        i = cnVar.a();
                        str = cnVar.b();
                    }
                    if (this.k == by.a.d) {
                        a(i, str, true);
                    } else if (this.l.b() == cd.a.c) {
                        c(i, str, true);
                    } else {
                        b(i, str, false);
                    }
                } else if (f == cq.a.d) {
                    this.i.b(this, cqVar);
                } else if (f == cq.a.e) {
                    this.i.c(this, cqVar);
                } else {
                    if (d && f != cq.a.a) {
                        if (this.n == null) {
                            if (f == cq.a.b) {
                                try {
                                    this.i.a(this, dc.a(cqVar.c()));
                                } catch (RuntimeException e2) {
                                    this.i.a(this, e2);
                                }
                            } else if (f == cq.a.c) {
                                try {
                                    this.i.a(this, cqVar.c());
                                } catch (RuntimeException e3) {
                                    this.i.a(this, e3);
                                }
                            } else {
                                throw new ch(1002, "non control or continious frame expected");
                            }
                            this.i.a(this, e);
                            a(e);
                            return;
                        }
                        throw new ch(1002, "Continuous frame sequence not completed.");
                    }
                    if (f != cq.a.a) {
                        if (this.n == null) {
                            this.n = cqVar;
                        } else {
                            throw new ch(1002, "Previous continuous frame sequence not completed.");
                        }
                    } else if (d) {
                        if (this.n != null) {
                            if (this.n.f() == cq.a.b) {
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
                    if (f == cq.a.b && !dc.b(cqVar.c())) {
                        throw new ch(1007);
                    }
                    if (f == cq.a.a && this.n != null && this.n.f() == cq.a.b) {
                        int max2 = Math.max(this.n.c().limit() - 64, 0);
                        this.n.a(cqVar);
                        if (!dc.a(this.n.c(), max2)) {
                            throw new ch(1007);
                        }
                    }
                    try {
                        this.i.a(this, cqVar);
                    } catch (RuntimeException e4) {
                        this.i.a(this, e4);
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
            if (byteBuffer.limit() > cd.c.length) {
                return cd.b.b;
            }
            if (byteBuffer.limit() >= cd.c.length) {
                int i = 0;
                while (byteBuffer.hasRemaining()) {
                    if (cd.c[i] != byteBuffer.get()) {
                        byteBuffer.reset();
                        return cd.b.b;
                    }
                    i++;
                }
                return cd.b.a;
            }
            throw new cg(cd.c.length);
        }
        return (cd.b) invokeL.objValue;
    }

    private void f(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, byteBuffer) == null) {
            if (c) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append("write(");
                sb.append(byteBuffer.remaining());
                sb.append("): {");
                sb.append(byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array()));
                sb.append("}");
                printStream.println(sb.toString());
            }
            this.d.add(byteBuffer);
            this.i.b(this);
        }
    }

    public void a(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer) == null) {
            if (!h && !byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
            if (c) {
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
                if (!h && this.o.hasRemaining() == byteBuffer.hasRemaining() && byteBuffer.hasRemaining()) {
                    throw new AssertionError();
                }
                if (byteBuffer.hasRemaining()) {
                    d(byteBuffer);
                } else if (this.o.hasRemaining()) {
                    d(this.o);
                }
            }
            if (!h && !d() && !e() && byteBuffer.hasRemaining()) {
                throw new AssertionError();
            }
        }
    }

    public void b(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i, str) == null) {
            a(i, str, false);
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

    public synchronized void b(int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (this.j) {
                    return;
                }
                this.r = Integer.valueOf(i);
                this.q = str;
                this.s = Boolean.valueOf(z);
                this.j = true;
                this.i.b(this);
                try {
                    this.i.b(this, i, str, z);
                } catch (RuntimeException e) {
                    this.i.a(this, e);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.k == by.a.e : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str) == null) {
            c(i, str, false);
        }
    }

    public synchronized void a(int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (this.k == by.a.e) {
                    return;
                }
                if (this.f != null) {
                    this.f.cancel();
                }
                if (this.g != null) {
                    try {
                        this.g.close();
                    } catch (IOException e) {
                        this.i.a(this, e);
                    }
                }
                try {
                    this.i.a(this, i, str, z);
                } catch (RuntimeException e2) {
                    this.i.a(this, e2);
                }
                if (this.l != null) {
                    this.l.a();
                }
                this.p = null;
                this.k = by.a.e;
                this.d.clear();
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (g() == by.a.a) {
                a(-1, true);
            } else if (this.j) {
                a(this.r.intValue(), this.q, this.s.booleanValue());
            } else if (this.l.b() == cd.a.a) {
                a(1000, true);
            } else if (this.l.b() == cd.a.b) {
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

    public void a(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            a(i, "", z);
        }
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            c(i, "", false);
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
            if (c) {
                PrintStream printStream = System.out;
                printStream.println("send frame: " + cqVar);
            }
            f(this.l.a(cqVar));
        }
    }

    public void a(ct ctVar) throws cj {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ctVar) == null) {
            if (!h && this.k == by.a.b) {
                throw new AssertionError("shall only be called once");
            }
            this.p = this.l.a(ctVar);
            String a2 = ctVar.a();
            this.t = a2;
            if (!h && a2 == null) {
                throw new AssertionError();
            }
            try {
                this.i.a((by) this, this.p);
                a(this.l.a(this.p, this.m));
            } catch (ch unused) {
                throw new cj("Handshake data rejected by client.");
            } catch (RuntimeException e) {
                this.i.a(this, e);
                throw new cj("rejected because of" + e);
            }
        }
    }

    private void c(int i, String str, boolean z) {
        by.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) || (aVar = this.k) == by.a.d || aVar == by.a.e) {
            return;
        }
        if (aVar == by.a.c) {
            if (i == 1006) {
                if (!h && z) {
                    throw new AssertionError();
                }
                this.k = by.a.d;
                b(i, str, false);
                return;
            }
            if (this.l.b() != cd.a.a) {
                try {
                    if (!z) {
                        try {
                            this.i.a(this, i, str);
                        } catch (RuntimeException e) {
                            this.i.a(this, e);
                        }
                    }
                    a(new co(i, str));
                } catch (ch e2) {
                    this.i.a(this, e2);
                    b(1006, "generated frame is invalid", false);
                }
            }
            b(i, str, z);
        } else if (i == -3) {
            if (!h && !z) {
                throw new AssertionError();
            }
            b(-3, str, true);
        } else {
            b(-1, str, false);
        }
        if (i == 1002) {
            b(i, str, z);
        }
        this.k = by.a.d;
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
            if (c) {
                PrintStream printStream = System.out;
                printStream.println("open using draft: " + this.l.getClass().getSimpleName());
            }
            this.k = by.a.c;
            try {
                this.i.a(this, cxVar);
            } catch (RuntimeException e) {
                this.i.a(this, e);
            }
        }
    }

    @Override // com.baidu.mobstat.by
    public InetSocketAddress a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.i.c(this) : (InetSocketAddress) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.k == by.a.d : invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (!h && this.k == by.a.c && this.j) {
                throw new AssertionError();
            }
            return this.k == by.a.c;
        }
        return invokeV.booleanValue;
    }
}
