package c.b.c.b.a;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.os.SystemClock;
import android.util.Printer;
import c.b.c.b.h.h;
import c.b.c.b.h.i;
import c.b.c.b.l;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f31513a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f31514b = true;

    /* renamed from: c  reason: collision with root package name */
    public static int f31515c;

    /* renamed from: d  reason: collision with root package name */
    public static List<d> f31516d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile AtomicLong f31517e;

    /* renamed from: f  reason: collision with root package name */
    public static long f31518f;

    /* renamed from: g  reason: collision with root package name */
    public static long f31519g;

    /* renamed from: h  reason: collision with root package name */
    public static HandlerThread f31520h;

    /* renamed from: i  reason: collision with root package name */
    public static long f31521i;

    /* renamed from: j  reason: collision with root package name */
    public static long f31522j;
    public static Handler k;
    public static int l;
    public static boolean m;
    public static volatile String n;
    public static volatile boolean o;
    public static int p;
    public static long q;
    public static long r;
    public static int s;
    public static MessageQueue t;
    public static Field u;
    public static Field v;
    public transient /* synthetic */ FieldHolder $fh;

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
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && g.f31514b) {
                String unused = g.n = str;
                if (!g.m) {
                    boolean unused2 = g.m = true;
                    int unused3 = g.p = Process.myTid();
                    g.I();
                }
                g.q = g.f31517e.get();
                if (g.r == -1) {
                    return;
                }
                long j2 = g.q - g.r;
                if (j2 > 0) {
                    if (j2 == 1) {
                        if (g.l > 1) {
                            i2 = 7;
                        } else {
                            i2 = g.l == 1 ? 3 : 0;
                        }
                    } else if (g.l > 1) {
                        i2 = 5;
                    } else {
                        i2 = g.l == 1 ? 6 : 1;
                    }
                    long J = g.J();
                    long uptimeMillis = SystemClock.uptimeMillis();
                    if (!g.o) {
                        g.o(g.H(), J - g.f31521i, uptimeMillis - g.f31522j, j2, i2, g.l, null);
                    }
                    long unused4 = g.f31521i = J;
                    long unused5 = g.f31522j = uptimeMillis;
                    int unused6 = g.l = 1;
                    return;
                }
                g.x();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements Printer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                g.r = g.f31517e.get();
                if (g.q <= 0) {
                    return;
                }
                long j2 = g.r - g.q;
                if (j2 <= 0) {
                    return;
                }
                long J = g.J();
                long uptimeMillis = SystemClock.uptimeMillis();
                int i3 = (j2 > 1L ? 1 : (j2 == 1L ? 0 : -1));
                if (i3 == 0 && g.l > 1) {
                    i2 = 9;
                } else if (i3 == 0 && g.l == 1) {
                    i2 = 2;
                } else if (i3 <= 0 || g.l <= 1) {
                    i2 = (i3 <= 0 || g.l != 1) ? 0 : 8;
                } else {
                    i2 = 4;
                }
                if (!g.o) {
                    g.o(g.H(), J - g.f31521i, uptimeMillis - g.f31522j, j2, i2, g.l, str);
                }
                long unused = g.f31521i = J;
                long unused2 = g.f31522j = uptimeMillis;
                int unused3 = g.l = 0;
                g.q = -1L;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        @Override // java.lang.Runnable
        public void run() {
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g.f31517e.set((SystemClock.uptimeMillis() - g.f31519g) / g.f31518f);
                long uptimeMillis = (SystemClock.uptimeMillis() - g.f31519g) % g.f31518f;
                if (uptimeMillis >= 95) {
                    g.f31517e.incrementAndGet();
                    j2 = g.f31518f << 1;
                } else {
                    j2 = g.f31518f;
                }
                g.k.postDelayed(this, j2 - uptimeMillis);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f31523a;

        /* renamed from: b  reason: collision with root package name */
        public int f31524b;

        /* renamed from: c  reason: collision with root package name */
        public long f31525c;

        /* renamed from: d  reason: collision with root package name */
        public long f31526d;

        /* renamed from: e  reason: collision with root package name */
        public long f31527e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f31528f;

        /* renamed from: g  reason: collision with root package name */
        public String f31529g;

        public d() {
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

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.f31524b;
                if (i2 == 0) {
                    return "[[[ IDLE  ]]] cost " + this.f31525c + " tick , mDuration：" + this.f31526d + ",cpuTime:" + this.f31527e;
                } else if (i2 == 1) {
                    return "[[[ Long IDLE  ]]] cost " + this.f31525c + " tick , mDuration：" + this.f31526d + ",cpuTime:" + this.f31527e;
                } else if (i2 == 2) {
                    return "[[[  1 msg  ]]] cost " + this.f31525c + " tick , mDuration：" + this.f31526d + ",cpuTime:" + this.f31527e + ", msg:" + this.f31529g;
                } else if (i2 == 3) {
                    return "[[[ 1 msg + IDLE  ]]] cost " + this.f31525c + " tick , mDuration：" + this.f31526d + ",cpuTime:" + this.f31527e;
                } else if (i2 == 4) {
                    return "[[[ " + (this.f31523a - 1) + " msgs  ]]] cost less than 1 tick, [[[  last msg ]]] cost more than " + (this.f31525c - 1) + "tick ,, mDuration：" + this.f31526d + "cpuTime:" + this.f31527e + " msg:" + this.f31529g;
                } else if (i2 == 5) {
                    return "[[[ " + this.f31523a + " msgs ]]] cost less than 1 tick but [[[  IDLE ]]] cost more than" + (this.f31525c - 1) + " ticks, , mDuration：" + this.f31526d + "cpuTime:" + this.f31527e;
                } else if (i2 == 6) {
                    return "[[[  1 msg  ]]] cost less than 1 tick , but [[[  IDLE ]]] cost more than" + (this.f31525c - 1) + ", , mDuration：" + this.f31526d + "cpuTime:" + this.f31527e;
                } else if (i2 == 7) {
                    return "[[[ " + this.f31523a + " msgs + IDLE  ]]] cost 1 tick , mDuration：" + this.f31526d + " cost cpuTime:" + this.f31527e;
                } else if (i2 == 8) {
                    return "[[[ 1 msgs ]]] cost " + this.f31525c + " ticks , mDuration：" + this.f31526d + " cost cpuTime:" + this.f31527e + " msg:" + this.f31529g;
                } else if (i2 == 9) {
                    return "[[[ " + this.f31523a + " msgs ]]] cost 1 tick , mDuration：" + this.f31526d + " cost cpuTime:" + this.f31527e;
                } else {
                    return "=========   UNKNOW =========  Type:" + this.f31524b + " cost ticks " + this.f31525c + " msgs:" + this.f31523a;
                }
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1738190944, "Lc/b/c/b/a/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1738190944, "Lc/b/c/b/a/g;");
                return;
            }
        }
        f31517e = new AtomicLong(-1L);
        f31518f = 100L;
        n = null;
        o = false;
        p = -1;
        q = -1L;
        r = -1L;
        s = -1;
        t = null;
        u = null;
        v = null;
    }

    public static d H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            int size = f31516d.size();
            int i2 = f31515c;
            if (size == i2) {
                int i3 = (s + 1) % i2;
                s = i3;
                return f31516d.get(i3);
            }
            d dVar = new d();
            f31516d.add(dVar);
            s++;
            return dVar;
        }
        return (d) invokeV.objValue;
    }

    public static void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            f31520h = i.a();
            f31519g = SystemClock.uptimeMillis();
            k = new Handler(f31520h.getLooper());
            h.a(8L);
            k.postDelayed(new c(), f31518f);
        }
    }

    public static long J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? c.b.c.b.h.d.a(p) : invokeV.longValue;
    }

    public static Message b(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, message)) == null) {
            Field field = v;
            if (field == null) {
                try {
                    Field declaredField = Class.forName("android.os.Message").getDeclaredField(UnitedSchemeConstants.UNITED_SCHEME_NEXT);
                    v = declaredField;
                    declaredField.setAccessible(true);
                    Message message2 = (Message) v.get(message);
                    if (f31513a) {
                        String str = "[getNextMessage] success get next msg :" + message2;
                    }
                    return message2;
                } catch (Exception unused) {
                    return null;
                }
            }
            try {
                return (Message) field.get(message);
            } catch (Exception unused2) {
                return null;
            }
        }
        return (Message) invokeL.objValue;
    }

    public static Message c(MessageQueue messageQueue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, messageQueue)) == null) {
            Field field = u;
            if (field == null) {
                try {
                    Field declaredField = Class.forName("android.os.MessageQueue").getDeclaredField("mMessages");
                    u = declaredField;
                    declaredField.setAccessible(true);
                    return (Message) u.get(messageQueue);
                } catch (Exception unused) {
                    return null;
                }
            }
            try {
                return (Message) field.get(messageQueue);
            } catch (Exception unused2) {
                return null;
            }
        }
        return (Message) invokeL.objValue;
    }

    public static JSONArray e(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            MessageQueue r2 = r();
            JSONArray jSONArray = new JSONArray();
            if (r2 == null) {
                return jSONArray;
            }
            synchronized (r2) {
                Message c2 = c(r2);
                if (c2 == null) {
                    return jSONArray;
                }
                int i3 = 0;
                int i4 = 0;
                while (c2 != null && i3 < i2) {
                    i3++;
                    i4++;
                    JSONObject g2 = g(c2, j2);
                    try {
                        g2.put("id", i4);
                    } catch (JSONException unused) {
                    }
                    jSONArray.put(g2);
                    c2 = b(c2);
                }
                return jSONArray;
            }
        }
        return (JSONArray) invokeCommon.objValue;
    }

    public static JSONObject f(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65552, null, j2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", n);
                jSONObject.put("currentMessageCost", s());
                jSONObject.put("currentMessageCpu", J() - f31521i);
                jSONObject.put("currentTick", f31517e.get());
            } catch (Throwable th) {
                l.k.b(th);
            }
            return jSONObject;
        }
        return (JSONObject) invokeJ.objValue;
    }

    public static JSONObject g(Message message, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65553, null, message, j2)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (message == null) {
                return jSONObject;
            }
            try {
                jSONObject.put("when", message.getWhen() - j2);
                if (message.getCallback() != null) {
                    jSONObject.put("callback", message.getCallback());
                }
                jSONObject.put("what", message.what);
                if (message.getTarget() != null) {
                    jSONObject.put("target", message.getTarget());
                } else {
                    jSONObject.put("barrier", message.arg1);
                }
                jSONObject.put("arg1", message.arg1);
                jSONObject.put("arg2", message.arg2);
                if (message.obj != null) {
                    jSONObject.put("obj", message.obj);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeLJ.objValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            h.a(4L);
            c.b.c.b.h.g.a().h();
            c.b.c.b.h.g.a().i(new a());
            c.b.c.b.h.g.a().d(new b());
            f31521i = J();
            f31522j = SystemClock.uptimeMillis();
        }
    }

    public static void i(int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(65555, null, i2, i3) == null) && f31514b) {
            if (i2 > 10) {
                f31515c = i2;
            }
            if (i3 > 10) {
                f31518f = i3;
            }
            f31516d = new ArrayList();
            h();
            c(r());
        }
    }

    public static JSONArray n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            JSONArray jSONArray = new JSONArray();
            List<d> q2 = q();
            if (q2 == null) {
                return jSONArray;
            }
            int i2 = 0;
            for (d dVar : q2) {
                if (dVar != null) {
                    i2++;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("msg", dVar.f31529g);
                        jSONObject.put("cpuDuration", dVar.f31527e);
                        jSONObject.put("duration", dVar.f31526d);
                        jSONObject.put("tick", dVar.f31525c);
                        jSONObject.put("type", dVar.f31524b);
                        jSONObject.put("count", dVar.f31523a);
                        jSONObject.put("id", i2);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    jSONArray.put(jSONObject);
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public static void o(d dVar, long j2, long j3, long j4, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{dVar, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            dVar.f31527e = j2;
            dVar.f31525c = j4;
            dVar.f31526d = j3;
            dVar.f31528f = false;
            dVar.f31523a = i3;
            if (str != null) {
                dVar.f31529g = str;
            }
            dVar.f31524b = i2;
        }
    }

    public static List<d> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            if (f31516d == null) {
                return null;
            }
            o = true;
            ArrayList arrayList = new ArrayList();
            if (f31516d.size() == f31515c) {
                for (int i2 = s; i2 < f31516d.size(); i2++) {
                    arrayList.add(f31516d.get(i2));
                }
                for (int i3 = 0; i3 < s; i3++) {
                    arrayList.add(f31516d.get(i3));
                }
            } else {
                arrayList.addAll(f31516d);
            }
            o = false;
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static MessageQueue r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            if (t == null && Looper.getMainLooper() != null) {
                Looper mainLooper = Looper.getMainLooper();
                if (mainLooper == Looper.myLooper()) {
                    t = Looper.myQueue();
                } else if (Build.VERSION.SDK_INT >= 23) {
                    t = mainLooper.getQueue();
                } else {
                    try {
                        Field declaredField = mainLooper.getClass().getDeclaredField("mQueue");
                        declaredField.setAccessible(true);
                        t = (MessageQueue) declaredField.get(mainLooper);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
            return t;
        }
        return (MessageQueue) invokeV.objValue;
    }

    public static long s() {
        InterceptResult invokeV;
        long uptimeMillis;
        long j2;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            if (q < 0) {
                uptimeMillis = SystemClock.uptimeMillis() - f31519g;
                j2 = r;
                j3 = f31518f;
            } else {
                uptimeMillis = SystemClock.uptimeMillis() - f31519g;
                j2 = q;
                j3 = f31518f;
            }
            return uptimeMillis - (j2 * j3);
        }
        return invokeV.longValue;
    }

    public static /* synthetic */ int x() {
        int i2 = l;
        l = i2 + 1;
        return i2;
    }
}
