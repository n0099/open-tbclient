package c.b.a;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.imagemanager.ImageLoader;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.collector.Collector;
import com.bytedance.embedapplog.util.UriConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class j1 implements Handler.Callback, Comparator<p> {
    public static /* synthetic */ Interceptable $ic;
    public static j1 p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public f1 f31246e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f31247f;

    /* renamed from: g  reason: collision with root package name */
    public Application f31248g;

    /* renamed from: h  reason: collision with root package name */
    public y1 f31249h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList<p> f31250i;

    /* renamed from: j  reason: collision with root package name */
    public q f31251j;
    public z1 k;
    public Handler l;
    public p1 m;
    public UriConfig n;
    public Handler o;

    public j1() {
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
        this.f31250i = new ArrayList<>(32);
    }

    public static void b() {
        j1 j1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (j1Var = p) == null) {
            return;
        }
        j1Var.g(null);
    }

    public static void d(p pVar) {
        int size;
        Handler handler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, pVar) == null) {
            j1 j1Var = p;
            if (j1Var == null) {
                h0.c("Init comes First!", null);
                r1.b(pVar);
                return;
            }
            if (pVar.f31282e == 0) {
                h0.b(null);
            }
            if (pVar instanceof x) {
                ((x) pVar).o = j1Var.f31249h.J();
            }
            synchronized (j1Var.f31250i) {
                size = j1Var.f31250i.size();
                j1Var.f31250i.add(pVar);
            }
            if (size % 10 != 0 || (handler = j1Var.o) == null) {
                return;
            }
            handler.removeMessages(4);
            j1Var.o.sendEmptyMessageDelayed(4, size == 0 ? 500L : 250L);
        }
    }

    public static void e(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, strArr) == null) {
            j1 j1Var = p;
            if (j1Var == null) {
                h0.b(new RuntimeException("Init comes First!"));
                return;
            }
            Handler handler = j1Var.o;
            if (handler != null) {
                handler.removeMessages(4);
                j1Var.o.obtainMessage(5, strArr).sendToTarget();
            }
        }
    }

    public static j1 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (p == null) {
                synchronized (j1.class) {
                    if (p == null) {
                        p = new j1();
                    }
                }
            }
            return p;
        }
        return (j1) invokeV.objValue;
    }

    public static String l() {
        InterceptResult invokeV;
        p1 p1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            j1 j1Var = p;
            if (j1Var == null || (p1Var = j1Var.m) == null) {
                return null;
            }
            return p1Var.f31295e;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(p pVar, p pVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, pVar, pVar2)) == null) {
            int i2 = ((pVar.f31282e - pVar2.f31282e) > 0L ? 1 : ((pVar.f31282e - pVar2.f31282e) == 0L ? 0 : -1));
            if (i2 < 0) {
                return -1;
            }
            return i2 > 0 ? 1 : 0;
        }
        return invokeLL.intValue;
    }

    public void c(Application application, y1 y1Var, z1 z1Var, e1 e1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, application, y1Var, z1Var, e1Var) == null) {
            this.f31248g = application;
            this.f31251j = new q(application, z1Var, y1Var);
            this.f31249h = y1Var;
            this.k = z1Var;
            this.m = new p1(z1Var, y1Var);
            this.f31248g.registerActivityLifecycleCallbacks(e1Var);
            HandlerThread handlerThread = new HandlerThread("bd_tracker_w");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper(), this);
            this.o = handler;
            handler.sendEmptyMessage(1);
            g0.b(y1Var.J() != 0);
        }
    }

    public Context f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31248g : (Context) invokeV.objValue;
    }

    public final void g(String[] strArr) {
        ArrayList<p> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, strArr) == null) {
            synchronized (this.f31250i) {
                arrayList = (ArrayList) this.f31250i.clone();
                this.f31250i.clear();
            }
            int i2 = 0;
            if (strArr != null) {
                arrayList.ensureCapacity(arrayList.size() + strArr.length);
                for (String str : strArr) {
                    arrayList.add(p.c(str));
                }
            }
            boolean w = this.f31249h.w(arrayList);
            if (arrayList.size() > 0) {
                if (this.f31249h.S()) {
                    if (!w && arrayList.size() <= 100) {
                        synchronized (this.f31250i) {
                            this.f31250i.addAll(arrayList);
                        }
                        return;
                    }
                    Collections.sort(arrayList, this);
                    ArrayList<p> arrayList2 = new ArrayList<>(arrayList.size());
                    Iterator<p> it = arrayList.iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        p next = it.next();
                        if (this.m.f(next, arrayList2)) {
                            q();
                        }
                        if (next instanceof w) {
                            z = p1.e(next);
                            i2 = 1;
                        }
                    }
                    if (i2 != 0) {
                        if (z) {
                            this.o.removeMessages(7);
                        } else {
                            this.o.sendEmptyMessageDelayed(7, this.f31249h.Y());
                        }
                    }
                    this.f31251j.j(arrayList2);
                    if (this.f31247f || !this.m.h() || this.l == null || !AppLog.getAutoActiveState()) {
                        return;
                    }
                    o();
                    return;
                }
                Intent intent = new Intent(this.f31248g, Collector.class);
                int size = arrayList.size();
                String[] strArr2 = new String[size];
                int i3 = 0;
                while (i2 < size) {
                    strArr2[i2] = arrayList.get(i2).m().toString();
                    i3 += strArr2[i2].length();
                    i2++;
                }
                if (i3 >= 307200) {
                    h0.b(null);
                }
                intent.putExtra("EMBED_K_DATA", strArr2);
                try {
                    this.f31248g.sendBroadcast(intent);
                } catch (Exception e2) {
                    h0.b(e2);
                }
            }
        }
    }

    public q h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f31251j : (q) invokeV.objValue;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, message)) == null) {
            int i2 = message.what;
            if (i2 == 1) {
                h0.f31237a = this.f31249h.X();
                if (this.k.r()) {
                    if (this.f31249h.S()) {
                        HandlerThread handlerThread = new HandlerThread("bd_tracker_n");
                        handlerThread.start();
                        Handler handler = new Handler(handlerThread.getLooper(), this);
                        this.l = handler;
                        handler.sendEmptyMessage(2);
                        if (this.f31250i.size() > 0) {
                            this.o.removeMessages(4);
                            this.o.sendEmptyMessageDelayed(4, 1000L);
                        }
                        h0.e("net|worker start", null);
                    }
                } else {
                    this.o.removeMessages(1);
                    this.o.sendEmptyMessageDelayed(1, 1000L);
                }
                r1.a();
            } else if (i2 == 2) {
                ArrayList arrayList = new ArrayList(4);
                arrayList.add(new n1(this));
                arrayList.add(new i1(this));
                arrayList.add(new m1(this));
                arrayList.add(new o1(this));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    h1 h1Var = (h1) it.next();
                    long h2 = h1Var.h();
                    if (h2 < ImageLoader.f37824d) {
                        this.l.sendMessageDelayed(this.o.obtainMessage(6, h1Var), h2);
                    }
                }
                p();
            } else if (i2 == 4) {
                g(null);
            } else if (i2 == 5) {
                g((String[]) message.obj);
            } else if (i2 == 6) {
                h1 h1Var2 = (h1) message.obj;
                if (!h1Var2.g()) {
                    long h3 = h1Var2.h();
                    if (h3 < ImageLoader.f37824d) {
                        this.l.sendMessageDelayed(this.o.obtainMessage(6, h1Var2), h3);
                    }
                    p();
                }
            } else if (i2 != 7) {
                h0.b(null);
            } else {
                synchronized (this.f31250i) {
                    this.f31250i.add(p1.j());
                }
                g(null);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public y1 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f31249h : (y1) invokeV.objValue;
    }

    public z1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : (z1) invokeV.objValue;
    }

    public p1 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.m : (p1) invokeV.objValue;
    }

    public UriConfig n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.n == null) {
                UriConfig uriConfig = this.f31249h.o().getUriConfig();
                this.n = uriConfig;
                if (uriConfig == null) {
                    this.n = c.b.a.u1.a.a(0);
                }
            }
            return this.n;
        }
        return (UriConfig) invokeV.objValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            this.f31247f = true;
            g1 g1Var = new g1(this);
            Handler handler = this.l;
            if (handler != null) {
                handler.obtainMessage(6, g1Var).sendToTarget();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.f31249h.W()) {
                if (this.f31246e == null) {
                    f1 f1Var = new f1(this);
                    this.f31246e = f1Var;
                    this.l.obtainMessage(6, f1Var).sendToTarget();
                    return;
                }
                return;
            }
            f1 f1Var2 = this.f31246e;
            if (f1Var2 != null) {
                f1Var2.f();
                this.f31246e = null;
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (h0.f31238b) {
                h0.a("packAndSend once, " + this.m.f31295e + ", hadUI:" + this.m.h(), null);
            }
            Handler handler = this.l;
            if (handler != null) {
                handler.sendMessage(this.o.obtainMessage(6, new k1(this)));
                this.l.sendMessage(this.o.obtainMessage(6, new l1(this)));
            }
        }
    }
}
