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
    private String aYK;
    private long aYL;
    private List<C0183a> aYM;
    private List<C0183a> aYN;
    private int[] aYO;

    public a(MotionEvent motionEvent) {
        this.aYK = "error";
        this.aYL = 0L;
        this.aYM = new ArrayList();
        this.aYN = new ArrayList();
        this.aYO = new int[2];
        a(motionEvent, "");
    }

    public a(MotionEvent motionEvent, String str) {
        this.aYK = "error";
        this.aYL = 0L;
        this.aYM = new ArrayList();
        this.aYN = new ArrayList();
        this.aYO = new int[2];
        a(motionEvent, str);
    }

    public String ML() {
        return this.aYK;
    }

    public void g(int[] iArr) {
        this.aYO = iArr;
        if (DEBUG) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.aYK = "touchstart";
                q(motionEvent);
                break;
            case 1:
                this.aYK = "touchend";
                q(motionEvent);
                break;
            case 2:
                this.aYK = "touchmove";
                q(motionEvent);
                break;
            case 3:
                this.aYK = "touchcancel";
                q(motionEvent);
                break;
            case 4:
            default:
                this.aYK = "error";
                break;
            case 5:
                this.aYK = "touchpointerdown";
                q(motionEvent);
                break;
            case 6:
                this.aYK = "touchpointerup";
                q(motionEvent);
                break;
        }
        this.aYL = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.aYK = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.aYK, "touchpointerdown")) {
            this.aYK = "touchstart";
        }
        if (TextUtils.equals(this.aYK, "touchpointerup")) {
            this.aYK = "touchend";
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.aYK, "touchend") && !TextUtils.equals(this.aYK, "touchcancel")) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                        this.aYM.add(b(motionEvent, i));
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
                this.aYN.add(b(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.aYN.add(b(motionEvent, i));
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
        c0183a.aYP = (motionEvent.getRawX() + c0183a.x) - motionEvent.getX();
        c0183a.aYQ = (motionEvent.getRawY() + c0183a.y) - motionEvent.getY();
        c0183a.pressure = motionEvent.getPressure(i);
        return c0183a;
    }

    public JSONObject MM() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.aYM.isEmpty()) {
                for (C0183a c0183a : this.aYM) {
                    if (c0183a != null) {
                        jSONArray.put(c0183a.MN());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.aYN.isEmpty()) {
                for (C0183a c0183a2 : this.aYN) {
                    if (c0183a2 != null) {
                        jSONArray2.put(c0183a2.MN());
                    }
                }
            }
            jSONObject.put("timeStamp", this.aYL);
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
        private float aYP;
        private float aYQ;
        private int identifier;
        private float pressure;
        private float x;
        private float y;

        private C0183a() {
        }

        JSONObject MN() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Config.EVENT_HEAT_X, x.af(this.x));
                jSONObject.put("y", x.af(this.y));
                jSONObject.put("clientX", x.af(this.aYP - a.this.aYO[0]));
                jSONObject.put("clientY", x.af(this.aYQ - a.this.aYO[1]));
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
