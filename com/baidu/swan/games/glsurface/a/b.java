package com.baidu.swan.games.glsurface.a;

import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.games.utils.d;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public final class b {
    private static com.baidu.swan.games.glsurface.a.a.b[] coD;
    public static int coI;
    public static long coJ;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Point coE = new Point();
    private static float coF = 1.0f;
    private static float coG = 1.0f;
    private static boolean coH = false;

    public static void ao(int i, int i2) {
        coE.x = i;
        coE.y = i2;
    }

    public static void an(int i, int i2) {
        float f = 1.0f;
        coF = (i == 0 || coE.x == 0) ? 1.0f : coE.x / i;
        if (i2 != 0 && coE.y != 0) {
            f = coE.y / i2;
        }
        coG = f;
        if (DEBUG) {
            Log.i("SwanGameTouchHelper", String.format("setSurfaceViewCurrentSize:%f,%f", Float.valueOf(coF), Float.valueOf(coG)));
        }
    }

    public static boolean a(EventTarget eventTarget) {
        if (eventTarget == null) {
            return false;
        }
        return eventTarget.hasEventListener("touchstart", "touchmove", "touchcancel", "touchend");
    }

    public static JSEvent p(MotionEvent motionEvent) {
        String str;
        com.baidu.swan.games.glsurface.a.a.a aVar = new com.baidu.swan.games.glsurface.a.a.a();
        switch (motionEvent.getActionMasked()) {
            case 0:
                str = "touchstart";
                a(motionEvent, aVar, false);
                int i = coI + 1;
                coI = i;
                coI = Math.min(i, 1000);
                coJ = System.currentTimeMillis();
                break;
            case 1:
                str = "touchend";
                a(motionEvent, aVar, false);
                break;
            case 2:
                str = "touchmove";
                a(motionEvent, aVar, true);
                break;
            case 3:
                str = "touchcancel";
                a(motionEvent, aVar, false);
                break;
            case 4:
            default:
                str = "toucherror";
                break;
            case 5:
                str = "touchstart";
                a(motionEvent, aVar, false);
                break;
            case 6:
                str = "touchend";
                a(motionEvent, aVar, false);
                break;
        }
        aVar.timeStamp = motionEvent.getEventTime();
        a(motionEvent, aVar);
        JSEvent jSEvent = new JSEvent(str);
        jSEvent.data = aVar;
        if ("touchmove".equals(str) && aVar.changedTouches == null) {
            return null;
        }
        return jSEvent;
    }

    private static void a(MotionEvent motionEvent, com.baidu.swan.games.glsurface.a.a.a aVar) {
        try {
            int pointerCount = motionEvent.getPointerCount();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < pointerCount; i++) {
                int actionMasked = motionEvent.getActionMasked();
                if (!(actionMasked == 6 || actionMasked == 1 || actionMasked == 3) || motionEvent.getActionIndex() != i) {
                    int pointerId = motionEvent.getPointerId(i);
                    com.baidu.swan.games.glsurface.a.a.b bVar = new com.baidu.swan.games.glsurface.a.a.b();
                    bVar.identifier = pointerId;
                    bVar.clientX = getX(motionEvent, i);
                    bVar.clientY = getY(motionEvent, i);
                    arrayList.add(bVar);
                }
            }
            aVar.touches = new com.baidu.swan.games.glsurface.a.a.b[arrayList.size()];
            if (!arrayList.isEmpty()) {
                arrayList.toArray(aVar.touches);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private static float getX(MotionEvent motionEvent, int i) {
        return d.ab(motionEvent.getX(i) * coF);
    }

    private static float getY(MotionEvent motionEvent, int i) {
        return d.ab(motionEvent.getY(i) * coG);
    }

    public static void eE(boolean z) {
        coH = z;
    }

    public static boolean aos() {
        return coH;
    }

    public static void aot() {
        coI = 0;
    }

    public static int aou() {
        return coI;
    }

    public static long aov() {
        return coJ;
    }

    private static void a(MotionEvent motionEvent, com.baidu.swan.games.glsurface.a.a.a aVar, boolean z) {
        try {
            if (!z) {
                int actionIndex = motionEvent.getActionIndex();
                aVar.changedTouches = new com.baidu.swan.games.glsurface.a.a.b[1];
                aVar.changedTouches[0] = new com.baidu.swan.games.glsurface.a.a.b();
                aVar.changedTouches[0].identifier = motionEvent.getPointerId(actionIndex);
                aVar.changedTouches[0].clientX = getX(motionEvent, actionIndex);
                aVar.changedTouches[0].clientY = getY(motionEvent, actionIndex);
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            if (coD == null || coD.length != pointerCount) {
                coD = new com.baidu.swan.games.glsurface.a.a.b[pointerCount];
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < pointerCount; i++) {
                com.baidu.swan.games.glsurface.a.a.b bVar = new com.baidu.swan.games.glsurface.a.a.b();
                bVar.identifier = motionEvent.getPointerId(i);
                bVar.clientX = getX(motionEvent, i);
                bVar.clientY = getY(motionEvent, i);
                if (!bVar.equals(coD[i])) {
                    arrayList.add(bVar);
                }
                coD[i] = bVar;
            }
            if (arrayList.size() != 0) {
                aVar.changedTouches = new com.baidu.swan.games.glsurface.a.a.b[arrayList.size()];
                arrayList.toArray(aVar.changedTouches);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
