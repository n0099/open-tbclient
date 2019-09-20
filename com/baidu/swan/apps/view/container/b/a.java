package com.baidu.swan.apps.view.container.b;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.an.z;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bcH;
    private long bcI;
    private List<C0202a> bcJ;
    private List<C0202a> bcK;
    private int[] bcL;

    public a(MotionEvent motionEvent) {
        this.bcH = "error";
        this.bcI = 0L;
        this.bcJ = new ArrayList();
        this.bcK = new ArrayList();
        this.bcL = new int[2];
        a(motionEvent, "");
    }

    public a(MotionEvent motionEvent, String str) {
        this.bcH = "error";
        this.bcI = 0L;
        this.bcJ = new ArrayList();
        this.bcK = new ArrayList();
        this.bcL = new int[2];
        a(motionEvent, str);
    }

    public String Qp() {
        return this.bcH;
    }

    public void g(int[] iArr) {
        this.bcL = iArr;
        if (DEBUG) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.bcH = "touchstart";
                q(motionEvent);
                break;
            case 1:
                this.bcH = "touchend";
                q(motionEvent);
                break;
            case 2:
                this.bcH = "touchmove";
                q(motionEvent);
                break;
            case 3:
                this.bcH = "touchcancel";
                q(motionEvent);
                break;
            case 4:
            default:
                this.bcH = "error";
                break;
            case 5:
                this.bcH = "touchpointerdown";
                q(motionEvent);
                break;
            case 6:
                this.bcH = "touchpointerup";
                q(motionEvent);
                break;
        }
        this.bcI = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.bcH = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.bcH, "touchpointerdown")) {
            this.bcH = "touchstart";
        }
        if (TextUtils.equals(this.bcH, "touchpointerup")) {
            this.bcH = "touchend";
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.bcH, "touchend") && !TextUtils.equals(this.bcH, "touchcancel")) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                        this.bcJ.add(b(motionEvent, i));
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
                this.bcK.add(b(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.bcK.add(b(motionEvent, i));
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public C0202a b(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        C0202a c0202a = new C0202a();
        c0202a.identifier = pointerId;
        c0202a.x = motionEvent.getX(i);
        c0202a.y = motionEvent.getY(i);
        c0202a.bcM = (motionEvent.getRawX() + c0202a.x) - motionEvent.getX();
        c0202a.bcN = (motionEvent.getRawY() + c0202a.y) - motionEvent.getY();
        c0202a.bcO = motionEvent.getPressure(i);
        return c0202a;
    }

    public JSONObject Qq() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.bcJ.isEmpty()) {
                for (C0202a c0202a : this.bcJ) {
                    if (c0202a != null) {
                        jSONArray.put(c0202a.Qr());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.bcK.isEmpty()) {
                for (C0202a c0202a2 : this.bcK) {
                    if (c0202a2 != null) {
                        jSONArray2.put(c0202a2.Qr());
                    }
                }
            }
            jSONObject.put("timeStamp", this.bcI);
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
    public class C0202a {
        private float bcM;
        private float bcN;
        private float bcO;
        private int identifier;
        private float x;
        private float y;

        private C0202a() {
        }

        JSONObject Qr() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Config.EVENT_HEAT_X, z.ag(this.x));
                jSONObject.put("y", z.ag(this.y));
                jSONObject.put("clientX", z.ag(this.bcM - a.this.bcL[0]));
                jSONObject.put("clientY", z.ag(this.bcN - a.this.bcL[1]));
                jSONObject.put("identifier", this.identifier);
                jSONObject.put("force", this.bcO);
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
    }
}
