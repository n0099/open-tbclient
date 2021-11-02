package b.a.p0.h.q.c;

import android.graphics.Point;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
import b.a.p0.h.m0.g;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f10717a;

    /* renamed from: b  reason: collision with root package name */
    public static b.a.p0.h.q.c.c.b[] f10718b;

    /* renamed from: c  reason: collision with root package name */
    public static Point f10719c;

    /* renamed from: d  reason: collision with root package name */
    public static float f10720d;

    /* renamed from: e  reason: collision with root package name */
    public static float f10721e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f10722f;

    /* renamed from: g  reason: collision with root package name */
    public static int f10723g;

    /* renamed from: h  reason: collision with root package name */
    public static long f10724h;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1979839922, "Lb/a/p0/h/q/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1979839922, "Lb/a/p0/h/q/c/b;");
                return;
            }
        }
        f10717a = k.f6397a;
        f10719c = new Point();
        f10720d = 1.0f;
        f10721e = 1.0f;
        f10722f = false;
    }

    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f10724h : invokeV.longValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f10723g : invokeV.intValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f10722f : invokeV.booleanValue;
    }

    public static float d(MotionEvent motionEvent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, motionEvent, i2)) == null) ? g.b(motionEvent.getX(i2) * f10720d) : invokeLI.floatValue;
    }

    public static float e(MotionEvent motionEvent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, null, motionEvent, i2)) == null) ? g.b(motionEvent.getY(i2) * f10721e) : invokeLI.floatValue;
    }

    public static boolean f(EventTarget eventTarget) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, eventTarget)) == null) {
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
            f10722f = z;
        }
    }

    public static void h(MotionEvent motionEvent, b.a.p0.h.q.c.c.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65544, null, motionEvent, aVar, z) == null) {
            try {
                if (!z) {
                    int actionIndex = motionEvent.getActionIndex();
                    aVar.changedTouches = r1;
                    b.a.p0.h.q.c.c.b[] bVarArr = {new b.a.p0.h.q.c.c.b()};
                    aVar.changedTouches[0].identifier = motionEvent.getPointerId(actionIndex);
                    aVar.changedTouches[0].clientX = d(motionEvent, actionIndex);
                    aVar.changedTouches[0].clientY = e(motionEvent, actionIndex);
                    return;
                }
                int pointerCount = motionEvent.getPointerCount();
                if (f10718b == null || f10718b.length != pointerCount) {
                    f10718b = new b.a.p0.h.q.c.c.b[pointerCount];
                }
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < pointerCount; i2++) {
                    b.a.p0.h.q.c.c.b bVar = new b.a.p0.h.q.c.c.b();
                    bVar.identifier = motionEvent.getPointerId(i2);
                    bVar.clientX = d(motionEvent, i2);
                    bVar.clientY = e(motionEvent, i2);
                    if (!bVar.equals(f10718b[i2])) {
                        arrayList.add(bVar);
                    }
                    f10718b[i2] = bVar;
                }
                if (arrayList.size() != 0) {
                    b.a.p0.h.q.c.c.b[] bVarArr2 = new b.a.p0.h.q.c.c.b[arrayList.size()];
                    aVar.changedTouches = bVarArr2;
                    arrayList.toArray(bVarArr2);
                }
            } catch (Exception e2) {
                if (f10717a) {
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
    public static void i(MotionEvent motionEvent, b.a.p0.h.q.c.c.a aVar) {
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
                    b.a.p0.h.q.c.c.b bVar = new b.a.p0.h.q.c.c.b();
                    bVar.identifier = pointerId;
                    bVar.clientX = d(motionEvent, i2);
                    bVar.clientY = e(motionEvent, i2);
                    arrayList.add(bVar);
                    i2++;
                }
                aVar.touches = new b.a.p0.h.q.c.c.b[arrayList.size()];
                if (arrayList.isEmpty()) {
                    return;
                }
                arrayList.toArray(aVar.touches);
            } catch (Exception e2) {
                if (f10717a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static JSEvent j(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, motionEvent)) == null) {
            b.a.p0.h.q.c.c.a aVar = new b.a.p0.h.q.c.c.a();
            int actionMasked = motionEvent.getActionMasked();
            String str = "touchend";
            if (actionMasked == 0) {
                h(motionEvent, aVar, false);
                int i2 = f10723g + 1;
                f10723g = i2;
                f10723g = Math.min(i2, 1000);
                f10724h = System.currentTimeMillis();
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
            f10723g = 0;
        }
    }

    public static void l(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65548, null, i2, i3) == null) {
            Point point = f10719c;
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
            f10720d = (i2 == 0 || (i5 = f10719c.x) == 0) ? 1.0f : i5 / i2;
            if (i3 != 0 && (i4 = f10719c.y) != 0) {
                f2 = i4 / i3;
            }
            f10721e = f2;
            if (f10717a) {
                String.format("setSurfaceViewCurrentSize:%f,%f", Float.valueOf(f10720d), Float.valueOf(f10721e));
            }
        }
    }
}
