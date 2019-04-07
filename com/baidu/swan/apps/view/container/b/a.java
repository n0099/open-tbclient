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
    private String aYJ;
    private long aYK;
    private List<C0183a> aYL;
    private List<C0183a> aYM;
    private int[] aYN;

    public a(MotionEvent motionEvent) {
        this.aYJ = "error";
        this.aYK = 0L;
        this.aYL = new ArrayList();
        this.aYM = new ArrayList();
        this.aYN = new int[2];
        a(motionEvent, "");
    }

    public a(MotionEvent motionEvent, String str) {
        this.aYJ = "error";
        this.aYK = 0L;
        this.aYL = new ArrayList();
        this.aYM = new ArrayList();
        this.aYN = new int[2];
        a(motionEvent, str);
    }

    public String ML() {
        return this.aYJ;
    }

    public void g(int[] iArr) {
        this.aYN = iArr;
        if (DEBUG) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.aYJ = "touchstart";
                q(motionEvent);
                break;
            case 1:
                this.aYJ = "touchend";
                q(motionEvent);
                break;
            case 2:
                this.aYJ = "touchmove";
                q(motionEvent);
                break;
            case 3:
                this.aYJ = "touchcancel";
                q(motionEvent);
                break;
            case 4:
            default:
                this.aYJ = "error";
                break;
            case 5:
                this.aYJ = "touchpointerdown";
                q(motionEvent);
                break;
            case 6:
                this.aYJ = "touchpointerup";
                q(motionEvent);
                break;
        }
        this.aYK = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.aYJ = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.aYJ, "touchpointerdown")) {
            this.aYJ = "touchstart";
        }
        if (TextUtils.equals(this.aYJ, "touchpointerup")) {
            this.aYJ = "touchend";
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.aYJ, "touchend") && !TextUtils.equals(this.aYJ, "touchcancel")) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                        this.aYL.add(b(motionEvent, i));
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
                this.aYM.add(b(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.aYM.add(b(motionEvent, i));
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
        c0183a.aYO = (motionEvent.getRawX() + c0183a.x) - motionEvent.getX();
        c0183a.aYP = (motionEvent.getRawY() + c0183a.y) - motionEvent.getY();
        c0183a.pressure = motionEvent.getPressure(i);
        return c0183a;
    }

    public JSONObject MM() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.aYL.isEmpty()) {
                for (C0183a c0183a : this.aYL) {
                    if (c0183a != null) {
                        jSONArray.put(c0183a.MN());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.aYM.isEmpty()) {
                for (C0183a c0183a2 : this.aYM) {
                    if (c0183a2 != null) {
                        jSONArray2.put(c0183a2.MN());
                    }
                }
            }
            jSONObject.put("timeStamp", this.aYK);
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
        private float aYO;
        private float aYP;
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
                jSONObject.put("clientX", x.af(this.aYO - a.this.aYN[0]));
                jSONObject.put("clientY", x.af(this.aYP - a.this.aYN[1]));
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
