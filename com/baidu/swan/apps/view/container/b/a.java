package com.baidu.swan.apps.view.container.b;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = c.DEBUG;
    private String aYF;
    private long aYG;
    private List<C0154a> aYH;
    private List<C0154a> aYI;
    private int[] aYJ;

    public a(MotionEvent motionEvent) {
        this.aYF = "error";
        this.aYG = 0L;
        this.aYH = new ArrayList();
        this.aYI = new ArrayList();
        this.aYJ = new int[2];
        a(motionEvent, "");
    }

    public a(MotionEvent motionEvent, String str) {
        this.aYF = "error";
        this.aYG = 0L;
        this.aYH = new ArrayList();
        this.aYI = new ArrayList();
        this.aYJ = new int[2];
        a(motionEvent, str);
    }

    public String MN() {
        return this.aYF;
    }

    public void g(int[] iArr) {
        this.aYJ = iArr;
        if (DEBUG) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.aYF = "touchstart";
                q(motionEvent);
                break;
            case 1:
                this.aYF = "touchend";
                q(motionEvent);
                break;
            case 2:
                this.aYF = "touchmove";
                q(motionEvent);
                break;
            case 3:
                this.aYF = "touchcancel";
                q(motionEvent);
                break;
            case 4:
            default:
                this.aYF = "error";
                break;
            case 5:
                this.aYF = "touchpointerdown";
                q(motionEvent);
                break;
            case 6:
                this.aYF = "touchpointerup";
                q(motionEvent);
                break;
        }
        this.aYG = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.aYF = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.aYF, "touchpointerdown")) {
            this.aYF = "touchstart";
        }
        if (TextUtils.equals(this.aYF, "touchpointerup")) {
            this.aYF = "touchend";
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.aYF, "touchend") && !TextUtils.equals(this.aYF, "touchcancel")) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                        this.aYH.add(b(motionEvent, i));
                    }
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void q(MotionEvent motionEvent) {
        try {
            if (!(motionEvent.getActionMasked() == 2)) {
                this.aYI.add(b(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.aYI.add(b(motionEvent, i));
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public C0154a b(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        C0154a c0154a = new C0154a();
        c0154a.identifier = pointerId;
        c0154a.x = motionEvent.getX(i);
        c0154a.y = motionEvent.getY(i);
        c0154a.aYK = (motionEvent.getRawX() + c0154a.x) - motionEvent.getX();
        c0154a.aYL = (motionEvent.getRawY() + c0154a.y) - motionEvent.getY();
        c0154a.pressure = motionEvent.getPressure(i);
        return c0154a;
    }

    public JSONObject MO() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.aYH.isEmpty()) {
                for (C0154a c0154a : this.aYH) {
                    if (c0154a != null) {
                        jSONArray.put(c0154a.MP());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.aYI.isEmpty()) {
                for (C0154a c0154a2 : this.aYI) {
                    if (c0154a2 != null) {
                        jSONArray2.put(c0154a2.MP());
                    }
                }
            }
            jSONObject.put("timeStamp", this.aYG);
            jSONObject.put("touches", jSONArray);
            jSONObject.put("changedTouches", jSONArray2);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.view.container.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0154a {
        private float aYK;
        private float aYL;
        private int identifier;
        private float pressure;
        private float x;
        private float y;

        private C0154a() {
        }

        JSONObject MP() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", x.af(this.x));
                jSONObject.put("y", x.af(this.y));
                jSONObject.put("clientX", x.af(this.aYK - a.this.aYJ[0]));
                jSONObject.put("clientY", x.af(this.aYL - a.this.aYJ[1]));
                jSONObject.put("identifier", this.identifier);
                jSONObject.put("force", this.pressure);
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
    }
}
