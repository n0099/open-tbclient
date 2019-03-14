package com.baidu.swan.apps.view.container.b;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.an.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String aYG;
    private long aYH;
    private List<C0183a> aYI;
    private List<C0183a> aYJ;
    private int[] aYK;

    public a(MotionEvent motionEvent) {
        this.aYG = "error";
        this.aYH = 0L;
        this.aYI = new ArrayList();
        this.aYJ = new ArrayList();
        this.aYK = new int[2];
        a(motionEvent, "");
    }

    public a(MotionEvent motionEvent, String str) {
        this.aYG = "error";
        this.aYH = 0L;
        this.aYI = new ArrayList();
        this.aYJ = new ArrayList();
        this.aYK = new int[2];
        a(motionEvent, str);
    }

    public String MN() {
        return this.aYG;
    }

    public void g(int[] iArr) {
        this.aYK = iArr;
        if (DEBUG) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.aYG = "touchstart";
                q(motionEvent);
                break;
            case 1:
                this.aYG = "touchend";
                q(motionEvent);
                break;
            case 2:
                this.aYG = "touchmove";
                q(motionEvent);
                break;
            case 3:
                this.aYG = "touchcancel";
                q(motionEvent);
                break;
            case 4:
            default:
                this.aYG = "error";
                break;
            case 5:
                this.aYG = "touchpointerdown";
                q(motionEvent);
                break;
            case 6:
                this.aYG = "touchpointerup";
                q(motionEvent);
                break;
        }
        this.aYH = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.aYG = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.aYG, "touchpointerdown")) {
            this.aYG = "touchstart";
        }
        if (TextUtils.equals(this.aYG, "touchpointerup")) {
            this.aYG = "touchend";
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.aYG, "touchend") && !TextUtils.equals(this.aYG, "touchcancel")) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                        this.aYI.add(b(motionEvent, i));
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
                this.aYJ.add(b(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.aYJ.add(b(motionEvent, i));
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public C0183a b(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        C0183a c0183a = new C0183a();
        c0183a.identifier = pointerId;
        c0183a.x = motionEvent.getX(i);
        c0183a.y = motionEvent.getY(i);
        c0183a.aYL = (motionEvent.getRawX() + c0183a.x) - motionEvent.getX();
        c0183a.aYM = (motionEvent.getRawY() + c0183a.y) - motionEvent.getY();
        c0183a.pressure = motionEvent.getPressure(i);
        return c0183a;
    }

    public JSONObject MO() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.aYI.isEmpty()) {
                for (C0183a c0183a : this.aYI) {
                    if (c0183a != null) {
                        jSONArray.put(c0183a.MP());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.aYJ.isEmpty()) {
                for (C0183a c0183a2 : this.aYJ) {
                    if (c0183a2 != null) {
                        jSONArray2.put(c0183a2.MP());
                    }
                }
            }
            jSONObject.put("timeStamp", this.aYH);
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
    public class C0183a {
        private float aYL;
        private float aYM;
        private int identifier;
        private float pressure;
        private float x;
        private float y;

        private C0183a() {
        }

        JSONObject MP() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Config.EVENT_HEAT_X, x.af(this.x));
                jSONObject.put("y", x.af(this.y));
                jSONObject.put("clientX", x.af(this.aYL - a.this.aYK[0]));
                jSONObject.put("clientY", x.af(this.aYM - a.this.aYK[1]));
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
