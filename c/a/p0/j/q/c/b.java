package c.a.p0.j.q.c;

import android.graphics.Point;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k;
import c.a.p0.j.n0.g;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static c.a.p0.j.q.c.c.b[] f10446b;

    /* renamed from: c  reason: collision with root package name */
    public static Point f10447c;

    /* renamed from: d  reason: collision with root package name */
    public static float f10448d;

    /* renamed from: e  reason: collision with root package name */
    public static float f10449e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f10450f;

    /* renamed from: g  reason: collision with root package name */
    public static int f10451g;

    /* renamed from: h  reason: collision with root package name */
    public static long f10452h;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1616922191, "Lc/a/p0/j/q/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1616922191, "Lc/a/p0/j/q/c/b;");
                return;
            }
        }
        a = k.a;
        f10447c = new Point();
        f10448d = 1.0f;
        f10449e = 1.0f;
        f10450f = false;
    }

    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f10452h : invokeV.longValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f10451g : invokeV.intValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f10450f : invokeV.booleanValue;
    }

    public static float d(MotionEvent motionEvent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, motionEvent, i2)) == null) ? g.b(motionEvent.getX(i2) * f10448d) : invokeLI.floatValue;
    }

    public static float e(MotionEvent motionEvent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, motionEvent, i2)) == null) ? g.b(motionEvent.getY(i2) * f10449e) : invokeLI.floatValue;
    }

    public static boolean f(EventTarget eventTarget) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, eventTarget)) == null) {
            if (eventTarget == null) {
                return false;
            }
            return eventTarget.hasEventListener("touchstart", "touchmove", "touchcancel", "touchend");
        }
        return invokeL.booleanValue;
    }

    public static void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, null, z) == null) {
            f10450f = z;
        }
    }

    public static void h(MotionEvent motionEvent, c.a.p0.j.q.c.c.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65544, null, motionEvent, aVar, z) == null) {
            try {
                if (!z) {
                    int actionIndex = motionEvent.getActionIndex();
                    aVar.changedTouches = r1;
                    c.a.p0.j.q.c.c.b[] bVarArr = {new c.a.p0.j.q.c.c.b()};
                    aVar.changedTouches[0].identifier = motionEvent.getPointerId(actionIndex);
                    aVar.changedTouches[0].clientX = d(motionEvent, actionIndex);
                    aVar.changedTouches[0].clientY = e(motionEvent, actionIndex);
                    return;
                }
                int pointerCount = motionEvent.getPointerCount();
                if (f10446b == null || f10446b.length != pointerCount) {
                    f10446b = new c.a.p0.j.q.c.c.b[pointerCount];
                }
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < pointerCount; i2++) {
                    c.a.p0.j.q.c.c.b bVar = new c.a.p0.j.q.c.c.b();
                    bVar.identifier = motionEvent.getPointerId(i2);
                    bVar.clientX = d(motionEvent, i2);
                    bVar.clientY = e(motionEvent, i2);
                    if (!bVar.equals(f10446b[i2])) {
                        arrayList.add(bVar);
                    }
                    f10446b[i2] = bVar;
                }
                if (arrayList.size() != 0) {
                    c.a.p0.j.q.c.c.b[] bVarArr2 = new c.a.p0.j.q.c.c.b[arrayList.size()];
                    aVar.changedTouches = bVarArr2;
                    arrayList.toArray(bVarArr2);
                }
            } catch (Exception e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0026, code lost:
        if (r8.getActionIndex() != r3) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void i(MotionEvent motionEvent, c.a.p0.j.q.c.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, motionEvent, aVar) == null) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                while (i2 < pointerCount) {
                    int actionMasked = motionEvent.getActionMasked();
                    boolean z = true;
                    if (actionMasked != 6 && actionMasked != 1 && actionMasked != 3) {
                        z = false;
                    }
                    int pointerId = motionEvent.getPointerId(i2);
                    c.a.p0.j.q.c.c.b bVar = new c.a.p0.j.q.c.c.b();
                    bVar.identifier = pointerId;
                    bVar.clientX = d(motionEvent, i2);
                    bVar.clientY = e(motionEvent, i2);
                    arrayList.add(bVar);
                    i2++;
                }
                aVar.touches = new c.a.p0.j.q.c.c.b[arrayList.size()];
                if (arrayList.isEmpty()) {
                    return;
                }
                arrayList.toArray(aVar.touches);
            } catch (Exception e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static JSEvent j(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, motionEvent)) == null) {
            c.a.p0.j.q.c.c.a aVar = new c.a.p0.j.q.c.c.a();
            int actionMasked = motionEvent.getActionMasked();
            String str = "touchend";
            if (actionMasked == 0) {
                h(motionEvent, aVar, false);
                int i2 = f10451g + 1;
                f10451g = i2;
                f10451g = Math.min(i2, 1000);
                f10452h = System.currentTimeMillis();
            } else {
                if (actionMasked == 1) {
                    h(motionEvent, aVar, false);
                } else if (actionMasked == 2) {
                    h(motionEvent, aVar, true);
                    str = "touchmove";
                } else if (actionMasked == 3) {
                    h(motionEvent, aVar, false);
                    str = "touchcancel";
                } else if (actionMasked == 5) {
                    h(motionEvent, aVar, false);
                } else if (actionMasked != 6) {
                    str = "toucherror";
                } else {
                    h(motionEvent, aVar, false);
                }
                aVar.timeStamp = motionEvent.getEventTime();
                i(motionEvent, aVar);
                JSEvent jSEvent = new JSEvent(str);
                jSEvent.data = aVar;
                if (!"touchmove".equals(str) && aVar.changedTouches == null) {
                    return null;
                }
            }
            str = "touchstart";
            aVar.timeStamp = motionEvent.getEventTime();
            i(motionEvent, aVar);
            JSEvent jSEvent2 = new JSEvent(str);
            jSEvent2.data = aVar;
            return !"touchmove".equals(str) ? jSEvent2 : jSEvent2;
        }
        return (JSEvent) invokeL.objValue;
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            f10451g = 0;
        }
    }

    public static void l(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65548, null, i2, i3) == null) {
            Point point = f10447c;
            point.x = i2;
            point.y = i3;
        }
    }

    public static void m(int i2, int i3) {
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65549, null, i2, i3) == null) {
            float f2 = 1.0f;
            f10448d = (i2 == 0 || (i5 = f10447c.x) == 0) ? 1.0f : i5 / i2;
            if (i3 != 0 && (i4 = f10447c.y) != 0) {
                f2 = i4 / i3;
            }
            f10449e = f2;
            if (a) {
                String.format("setSurfaceViewCurrentSize:%f,%f", Float.valueOf(f10448d), Float.valueOf(f10449e));
            }
        }
    }
}
