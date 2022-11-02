package com.baidu.mobstat;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.ce;
import com.baidu.mobstat.cj;
import com.baidu.mobstat.cw;
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
public class cg implements ce {
    public static /* synthetic */ Interceptable $ic;
    public static final List<cj> a;
    public static int b;
    public static boolean c;
    public static final /* synthetic */ boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public final BlockingQueue<ByteBuffer> d;
    public final BlockingQueue<ByteBuffer> e;
    public SelectionKey f;
    public ByteChannel g;
    public final ch i;
    public volatile boolean j;
    public ce.a k;
    public cj l;
    public ce.b m;
    public cw n;
    public ByteBuffer o;
    public cy p;
    public String q;
    public Integer r;
    public Boolean s;
    public String t;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581658958, "Lcom/baidu/mobstat/cg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581658958, "Lcom/baidu/mobstat/cg;");
                return;
            }
        }
        h = !cg.class.desiredAssertionStatus();
        ArrayList arrayList = new ArrayList(4);
        a = arrayList;
        b = 16384;
        c = false;
        arrayList.add(new cl());
        a.add(new ck());
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (g() == ce.a.a) {
                a(-1, true);
            } else if (this.j) {
                a(this.r.intValue(), this.q, this.s.booleanValue());
            } else if (this.l.b() == cj.a.a) {
                a(1000, true);
            } else if (this.l.b() == cj.a.b) {
                a(1000, true);
            } else {
                a(1006, true);
            }
        }
    }

    public cg(ch chVar, cj cjVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {chVar, cjVar};
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
        this.k = ce.a.a;
        this.l = null;
        this.n = null;
        this.o = ByteBuffer.allocate(0);
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        if (chVar != null && cjVar != null) {
            this.d = new LinkedBlockingQueue();
            this.e = new LinkedBlockingQueue();
            this.i = chVar;
            this.m = ce.b.a;
            if (cjVar != null) {
                this.l = cjVar.c();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("parameters must not be null");
    }

    private void a(dd ddVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, ddVar) == null) {
            if (c) {
                PrintStream printStream = System.out;
                printStream.println("open using draft: " + this.l.getClass().getSimpleName());
            }
            this.k = ce.a.c;
            try {
                this.i.a(this, ddVar);
            } catch (RuntimeException e) {
                this.i.a(this, e);
            }
        }
    }

    private void a(Collection<cw> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, collection) == null) {
            if (c()) {
                for (cw cwVar : collection) {
                    a(cwVar);
                }
                return;
            }
            throw new cs();
        }
    }

    public void b(ByteBuffer byteBuffer) throws IllegalArgumentException, cs {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, byteBuffer) == null) {
            if (byteBuffer != null) {
                cj cjVar = this.l;
                if (this.m == ce.b.a) {
                    z = true;
                } else {
                    z = false;
                }
                a(cjVar.a(byteBuffer, z));
                return;
            }
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
    }

    private void a(List<ByteBuffer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, list) == null) {
            for (ByteBuffer byteBuffer : list) {
                f(byteBuffer);
            }
        }
    }

    private void c(int i, String str, boolean z) {
        ce.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) && (aVar = this.k) != ce.a.d && aVar != ce.a.e) {
            if (aVar == ce.a.c) {
                if (i == 1006) {
                    if (!h && z) {
                        throw new AssertionError();
                    }
                    this.k = ce.a.d;
                    b(i, str, false);
                    return;
                }
                if (this.l.b() != cj.a.a) {
                    if (!z) {
                        try {
                            try {
                                this.i.a(this, i, str);
                            } catch (RuntimeException e) {
                                this.i.a(this, e);
                            }
                        } catch (cn e2) {
                            this.i.a(this, e2);
                            b(1006, "generated frame is invalid", false);
                        }
                    }
                    a(new cu(i, str));
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
            this.k = ce.a.d;
            this.o = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0120  */
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
            } catch (cm e) {
                if (this.o.capacity() != 0) {
                }
            }
            if (this.l == null && e(byteBuffer2) == cj.b.a) {
                try {
                    f(ByteBuffer.wrap(di.a(this.i.a(this))));
                    a(-3, "");
                } catch (cn unused) {
                    c(1006, "remote peer closed connection before flashpolicy could be transmitted", true);
                }
                return false;
            }
            try {
                if (this.m == ce.b.a) {
                    this.l.a(this.m);
                    dd d = this.l.d(byteBuffer2);
                    if (!(d instanceof df)) {
                        b(1002, "wrong http function", false);
                        return false;
                    }
                    df dfVar = (df) d;
                    if (this.l.a(this.p, dfVar) == cj.b.a) {
                        try {
                            this.i.a(this, this.p, dfVar);
                            a(dfVar);
                            return true;
                        } catch (cn e2) {
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
            } catch (cp e4) {
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
            } catch (cn e) {
                this.i.a(this, e);
                a(e);
                return;
            }
            for (cw cwVar : this.l.c(byteBuffer)) {
                if (c) {
                    PrintStream printStream = System.out;
                    printStream.println("matched frame: " + cwVar);
                }
                cw.a f = cwVar.f();
                boolean d = cwVar.d();
                if (this.k == ce.a.d) {
                    return;
                }
                if (f == cw.a.f) {
                    int i = 1005;
                    String str = "";
                    if (cwVar instanceof ct) {
                        ct ctVar = (ct) cwVar;
                        i = ctVar.a();
                        str = ctVar.b();
                    }
                    if (this.k == ce.a.d) {
                        a(i, str, true);
                    } else if (this.l.b() == cj.a.c) {
                        c(i, str, true);
                    } else {
                        b(i, str, false);
                    }
                } else if (f == cw.a.d) {
                    this.i.b(this, cwVar);
                } else if (f == cw.a.e) {
                    this.i.c(this, cwVar);
                } else {
                    if (d && f != cw.a.a) {
                        if (this.n == null) {
                            if (f == cw.a.b) {
                                try {
                                    this.i.a(this, di.a(cwVar.c()));
                                } catch (RuntimeException e2) {
                                    this.i.a(this, e2);
                                }
                            } else if (f == cw.a.c) {
                                try {
                                    this.i.a(this, cwVar.c());
                                } catch (RuntimeException e3) {
                                    this.i.a(this, e3);
                                }
                            } else {
                                throw new cn(1002, "non control or continious frame expected");
                            }
                            this.i.a(this, e);
                            a(e);
                            return;
                        }
                        throw new cn(1002, "Continuous frame sequence not completed.");
                    }
                    if (f != cw.a.a) {
                        if (this.n == null) {
                            this.n = cwVar;
                        } else {
                            throw new cn(1002, "Previous continuous frame sequence not completed.");
                        }
                    } else if (d) {
                        if (this.n != null) {
                            if (this.n.f() == cw.a.b) {
                                int max = Math.max(this.n.c().limit() - 64, 0);
                                this.n.a(cwVar);
                                if (!di.a(this.n.c(), max)) {
                                    throw new cn(1007);
                                }
                            }
                            this.n = null;
                        } else {
                            throw new cn(1002, "Continuous frame sequence was not started.");
                        }
                    } else if (this.n == null) {
                        throw new cn(1002, "Continuous frame sequence was not started.");
                    }
                    if (f == cw.a.b && !di.b(cwVar.c())) {
                        throw new cn(1007);
                    }
                    if (f == cw.a.a && this.n != null && this.n.f() == cw.a.b) {
                        int max2 = Math.max(this.n.c().limit() - 64, 0);
                        this.n.a(cwVar);
                        if (!di.a(this.n.c(), max2)) {
                            throw new cn(1007);
                        }
                    }
                    try {
                        this.i.a(this, cwVar);
                    } catch (RuntimeException e4) {
                        this.i.a(this, e4);
                    }
                }
            }
        }
    }

    private cj.b e(ByteBuffer byteBuffer) throws cm {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, byteBuffer)) == null) {
            byteBuffer.mark();
            if (byteBuffer.limit() > cj.c.length) {
                return cj.b.b;
            }
            if (byteBuffer.limit() >= cj.c.length) {
                int i = 0;
                while (byteBuffer.hasRemaining()) {
                    if (cj.c[i] != byteBuffer.get()) {
                        byteBuffer.reset();
                        return cj.b.b;
                    }
                    i++;
                }
                return cj.b.a;
            }
            throw new cm(cj.c.length);
        }
        return (cj.b) invokeL.objValue;
    }

    private void f(ByteBuffer byteBuffer) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, byteBuffer) == null) {
            if (c) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append("write(");
                sb.append(byteBuffer.remaining());
                sb.append("): {");
                if (byteBuffer.remaining() > 1000) {
                    str = "too big to display";
                } else {
                    str = new String(byteBuffer.array());
                }
                sb.append(str);
                sb.append("}");
                printStream.println(sb.toString());
            }
            this.d.add(byteBuffer);
            this.i.b(this);
        }
    }

    @Override // com.baidu.mobstat.ce
    public InetSocketAddress a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.i.c(this);
        }
        return (InetSocketAddress) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (!h && this.k == ce.a.c && this.j) {
                throw new AssertionError();
            }
            if (this.k == ce.a.c) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.k == ce.a.d) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.k == ce.a.e) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ce.a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.k;
        }
        return (ce.a) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return super.hashCode();
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return super.toString();
        }
        return (String) invokeV.objValue;
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            c(i, "", false);
        }
    }

    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str) == null) {
            c(i, str, false);
        }
    }

    public void b(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i, str) == null) {
            a(i, str, false);
        }
    }

    public synchronized void a(int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (this.k == ce.a.e) {
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
                this.k = ce.a.e;
                this.d.clear();
            }
        }
    }

    public void a(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            a(i, "", z);
        }
    }

    public void a(cn cnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cnVar) == null) {
            c(cnVar.a(), cnVar.getMessage(), false);
        }
    }

    @Override // com.baidu.mobstat.ce
    public void a(cw cwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cwVar) == null) {
            if (c) {
                PrintStream printStream = System.out;
                printStream.println("send frame: " + cwVar);
            }
            f(this.l.a(cwVar));
        }
    }

    public void a(cz czVar) throws cp {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, czVar) == null) {
            if (!h && this.k == ce.a.b) {
                throw new AssertionError("shall only be called once");
            }
            this.p = this.l.a(czVar);
            String a2 = czVar.a();
            this.t = a2;
            if (!h && a2 == null) {
                throw new AssertionError();
            }
            try {
                this.i.a((ce) this, this.p);
                a(this.l.a(this.p, this.m));
            } catch (cn unused) {
                throw new cp("Handshake data rejected by client.");
            } catch (RuntimeException e) {
                this.i.a(this, e);
                throw new cp("rejected because of" + e);
            }
        }
    }

    public void a(ByteBuffer byteBuffer) {
        String str;
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
                if (byteBuffer.remaining() > 1000) {
                    str = "too big to display";
                } else {
                    str = new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
                }
                sb.append(str);
                sb.append("}");
                printStream.println(sb.toString());
            }
            if (this.k != ce.a.a) {
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

    public void a(byte[] bArr) throws IllegalArgumentException, cs {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bArr) == null) {
            b(ByteBuffer.wrap(bArr));
        }
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
}
