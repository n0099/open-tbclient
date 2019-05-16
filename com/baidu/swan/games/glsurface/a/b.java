package com.baidu.swan.games.glsurface.a;

import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.JSEvent;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class b {
    private static com.baidu.swan.games.glsurface.a.a.b[] bhi;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static Point bhj = new Point();
    private static float bhk = 1.0f;
    private static float bhl = 1.0f;
    private static boolean bhm = false;

    public static void I(int i, int i2) {
        bhj.x = i;
        bhj.y = i2;
    }

    public static void H(int i, int i2) {
        float f = 1.0f;
        bhk = (i == 0 || bhj.x == 0) ? 1.0f : bhj.x / i;
        if (i2 != 0 && bhj.y != 0) {
            f = bhj.y / i2;
        }
        bhl = f;
        if (DEBUG) {
            Log.i("SwanGameTouchHelper", String.format("setSurfaceViewCurrentSize:%f,%f", Float.valueOf(bhk), Float.valueOf(bhl)));
        }
    }

    public static boolean a(EventTarget eventTarget) {
        if (eventTarget == null) {
            return false;
        }
        return eventTarget.hasEventListener("touchstart", "touchmove", "touchcancel", "touchend");
    }

    public static JSEvent t(MotionEvent motionEvent) {
        String str;
        com.baidu.swan.games.glsurface.a.a.a aVar = new com.baidu.swan.games.glsurface.a.a.a();
        switch (motionEvent.getActionMasked()) {
            case 0:
                str = "touchstart";
                a(motionEvent, aVar, false);
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
        return com.baidu.swan.games.utils.b.aj(motionEvent.getX(i) * bhk);
    }

    private static float getY(MotionEvent motionEvent, int i) {
        return com.baidu.swan.games.utils.b.aj(motionEvent.getY(i) * bhl);
    }

    public static void cO(boolean z) {
        bhm = z;
    }

    public static boolean Rr() {
        return bhm;
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
            if (bhi == null || bhi.length != pointerCount) {
                bhi = new com.baidu.swan.games.glsurface.a.a.b[pointerCount];
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < pointerCount; i++) {
                com.baidu.swan.games.glsurface.a.a.b bVar = new com.baidu.swan.games.glsurface.a.a.b();
                bVar.identifier = motionEvent.getPointerId(i);
                bVar.clientX = getX(motionEvent, i);
                bVar.clientY = getY(motionEvent, i);
                if (!bVar.equals(bhi[i])) {
                    arrayList.add(bVar);
                }
                bhi[i] = bVar;
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
