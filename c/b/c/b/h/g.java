package c.b.c.b.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Printer;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.b.c.b.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class g implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public static Printer m;
    public static g n;
    public static final Printer o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Handler f31355e;

    /* renamed from: f  reason: collision with root package name */
    public int f31356f;

    /* renamed from: g  reason: collision with root package name */
    public long f31357g;

    /* renamed from: h  reason: collision with root package name */
    public final SparseArray<List<Runnable>> f31358h;

    /* renamed from: i  reason: collision with root package name */
    public final List<Printer> f31359i;

    /* renamed from: j  reason: collision with root package name */
    public final List<Printer> f31360j;
    public boolean k;
    public boolean l;

    /* loaded from: classes4.dex */
    public static class a implements Printer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // android.util.Printer
        public void println(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || str == null) {
                return;
            }
            if (str.startsWith(">>>>> Dispatching")) {
                g.a().e(str);
            } else if (str.startsWith("<<<<< Finished")) {
                g.a().j(str);
            }
            if (g.m == null || g.m == g.o) {
                return;
            }
            g.m.println(str);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1738399481, "Lc/b/c/b/h/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1738399481, "Lc/b/c/b/h/g;");
                return;
            }
        }
        o = new a();
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f31356f = 0;
        this.f31358h = new SparseArray<>();
        this.f31359i = new LinkedList();
        this.f31360j = new LinkedList();
        this.k = false;
        this.f31355e = new Handler(i.a().getLooper(), this);
        h();
    }

    public static g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (n == null) {
                synchronized (g.class) {
                    if (n == null) {
                        n = new g();
                    }
                }
            }
            return n;
        }
        return (g) invokeV.objValue;
    }

    public static void f(List<? extends Runnable> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        try {
            for (Runnable runnable : list) {
                runnable.run();
            }
        } catch (Exception e2) {
            l.k.b(e2);
        }
    }

    public void b(long j2, Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048576, this, j2, runnable) == null) {
            c(j2, runnable, 1, 0L);
        }
    }

    public void c(long j2, Runnable runnable, int i2, long j3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), runnable, Integer.valueOf(i2), Long.valueOf(j3)}) == null) || j2 < 0) {
            return;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = (int) j2;
            List<Runnable> list = this.f31358h.get(i4);
            if (list == null) {
                synchronized (this.f31358h) {
                    list = this.f31358h.get(i4);
                    if (list == null) {
                        list = new LinkedList<>();
                        this.f31358h.put(i4, list);
                    }
                }
            }
            list.add(runnable);
            j2 += j3;
        }
    }

    public void d(Printer printer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, printer) == null) {
            this.f31360j.add(printer);
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (!this.l) {
                h.a(32L);
                this.l = true;
            }
            this.f31357g = SystemClock.uptimeMillis();
            try {
                g(this.f31359i, str);
                this.f31355e.sendEmptyMessage(0);
            } catch (Exception e2) {
                l.k.b(e2);
            }
        }
    }

    public final synchronized void g(List<? extends Printer> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, list, str) == null) {
            synchronized (this) {
                if (list != null) {
                    if (!list.isEmpty()) {
                        try {
                            for (Printer printer : list) {
                                printer.println(str);
                            }
                        } catch (Exception e2) {
                            l.k.b(e2);
                        }
                    }
                }
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.k) {
            return;
        }
        this.k = true;
        Printer m2 = m();
        m = m2;
        if (m2 == o) {
            m = null;
        }
        Looper.getMainLooper().setMessageLogging(o);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, message)) == null) {
            if (this.f31355e.hasMessages(0)) {
                return true;
            }
            int i2 = message.what;
            if (i2 == 0) {
                this.f31356f = 0;
                if (this.f31358h.size() != 0 && this.f31358h.keyAt(0) == 0) {
                    f(this.f31358h.valueAt(0));
                    this.f31356f++;
                }
            } else if (i2 == 1) {
                this.f31355e.removeMessages(2);
                if (this.f31358h.size() != 0) {
                    SparseArray<List<Runnable>> sparseArray = this.f31358h;
                    if (sparseArray.keyAt(sparseArray.size() - 1) == 0) {
                        f(this.f31358h.get(Integer.MAX_VALUE));
                    }
                }
                return true;
            } else if (i2 == 2) {
                f(this.f31358h.valueAt(this.f31356f));
                this.f31356f++;
            }
            if (this.f31356f >= this.f31358h.size()) {
                return true;
            }
            long keyAt = this.f31358h.keyAt(this.f31356f);
            if (keyAt != 2147483647L) {
                this.f31355e.sendEmptyMessageAtTime(2, this.f31357g + keyAt);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public synchronized void i(Printer printer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, printer) == null) {
            synchronized (this) {
                this.f31359i.add(printer);
            }
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            SystemClock.uptimeMillis();
            try {
                this.f31355e.removeMessages(2);
                g(this.f31360j, str);
                this.f31355e.sendEmptyMessage(1);
            } catch (Exception e2) {
                l.k.c(e2);
            }
        }
    }

    public final Printer m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            try {
                Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
                declaredField.setAccessible(true);
                return (Printer) declaredField.get(Looper.getMainLooper());
            } catch (Exception e2) {
                l.k.c(e2);
                return null;
            }
        }
        return (Printer) invokeV.objValue;
    }
}
