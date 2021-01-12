package com.baidu.swan.games.glsurface.a;

import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.games.utils.e;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public final class b {
    private static com.baidu.swan.games.glsurface.a.a.b[] efl;
    public static int efq;
    public static long efr;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Point efm = new Point();
    private static float efn = 1.0f;
    private static float efo = 1.0f;
    private static boolean efp = false;

    public static void az(int i, int i2) {
        efm.x = i;
        efm.y = i2;
    }

    public static void ay(int i, int i2) {
        float f = 1.0f;
        efn = (i == 0 || efm.x == 0) ? 1.0f : efm.x / i;
        if (i2 != 0 && efm.y != 0) {
            f = efm.y / i2;
        }
        efo = f;
        if (DEBUG) {
            Log.i("SwanGameTouchHelper", String.format("setSurfaceViewCurrentSize:%f,%f", Float.valueOf(efn), Float.valueOf(efo)));
        }
    }

    public static boolean a(EventTarget eventTarget) {
        if (eventTarget == null) {
            return false;
        }
        return eventTarget.hasEventListener("touchstart", "touchmove", "touchcancel", "touchend");
    }

    public static JSEvent D(MotionEvent motionEvent) {
        String str;
        com.baidu.swan.games.glsurface.a.a.a aVar = new com.baidu.swan.games.glsurface.a.a.a();
        switch (motionEvent.getActionMasked()) {
            case 0:
                str = "touchstart";
                a(motionEvent, aVar, false);
                int i = efq + 1;
                efq = i;
                efq = Math.min(i, 1000);
                efr = System.currentTimeMillis();
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
        return e.Y(motionEvent.getX(i) * efn);
    }

    private static float getY(MotionEvent motionEvent, int i) {
        return e.Y(motionEvent.getY(i) * efo);
    }

    public static void ic(boolean z) {
        efp = z;
    }

    public static boolean aWN() {
        return efp;
    }

    public static void aWO() {
        efq = 0;
    }

    public static int aWP() {
        return efq;
    }

    public static long aWQ() {
        return efr;
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
            if (efl == null || efl.length != pointerCount) {
                efl = new com.baidu.swan.games.glsurface.a.a.b[pointerCount];
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < pointerCount; i++) {
                com.baidu.swan.games.glsurface.a.a.b bVar = new com.baidu.swan.games.glsurface.a.a.b();
                bVar.identifier = motionEvent.getPointerId(i);
                bVar.clientX = getX(motionEvent, i);
                bVar.clientY = getY(motionEvent, i);
                if (!bVar.equals(efl[i])) {
                    arrayList.add(bVar);
                }
                efl[i] = bVar;
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
