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
    private String bcj;
    private long bck;
    private List<C0193a> bcl;
    private List<C0193a> bcm;
    private int[] bcn;

    public a(MotionEvent motionEvent) {
        this.bcj = "error";
        this.bck = 0L;
        this.bcl = new ArrayList();
        this.bcm = new ArrayList();
        this.bcn = new int[2];
        a(motionEvent, "");
    }

    public a(MotionEvent motionEvent, String str) {
        this.bcj = "error";
        this.bck = 0L;
        this.bcl = new ArrayList();
        this.bcm = new ArrayList();
        this.bcn = new int[2];
        a(motionEvent, str);
    }

    public String Ql() {
        return this.bcj;
    }

    public void g(int[] iArr) {
        this.bcn = iArr;
        if (DEBUG) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.bcj = "touchstart";
                q(motionEvent);
                break;
            case 1:
                this.bcj = "touchend";
                q(motionEvent);
                break;
            case 2:
                this.bcj = "touchmove";
                q(motionEvent);
                break;
            case 3:
                this.bcj = "touchcancel";
                q(motionEvent);
                break;
            case 4:
            default:
                this.bcj = "error";
                break;
            case 5:
                this.bcj = "touchpointerdown";
                q(motionEvent);
                break;
            case 6:
                this.bcj = "touchpointerup";
                q(motionEvent);
                break;
        }
        this.bck = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.bcj = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.bcj, "touchpointerdown")) {
            this.bcj = "touchstart";
        }
        if (TextUtils.equals(this.bcj, "touchpointerup")) {
            this.bcj = "touchend";
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.bcj, "touchend") && !TextUtils.equals(this.bcj, "touchcancel")) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                        this.bcl.add(b(motionEvent, i));
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
                this.bcm.add(b(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.bcm.add(b(motionEvent, i));
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public C0193a b(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        C0193a c0193a = new C0193a();
        c0193a.identifier = pointerId;
        c0193a.x = motionEvent.getX(i);
        c0193a.y = motionEvent.getY(i);
        c0193a.bco = (motionEvent.getRawX() + c0193a.x) - motionEvent.getX();
        c0193a.bcp = (motionEvent.getRawY() + c0193a.y) - motionEvent.getY();
        c0193a.bcq = motionEvent.getPressure(i);
        return c0193a;
    }

    public JSONObject Qm() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.bcl.isEmpty()) {
                for (C0193a c0193a : this.bcl) {
                    if (c0193a != null) {
                        jSONArray.put(c0193a.Qn());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.bcm.isEmpty()) {
                for (C0193a c0193a2 : this.bcm) {
                    if (c0193a2 != null) {
                        jSONArray2.put(c0193a2.Qn());
                    }
                }
            }
            jSONObject.put("timeStamp", this.bck);
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
    public class C0193a {
        private float bco;
        private float bcp;
        private float bcq;
        private int identifier;
        private float x;
        private float y;

        private C0193a() {
        }

        JSONObject Qn() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Config.EVENT_HEAT_X, z.ag(this.x));
                jSONObject.put("y", z.ag(this.y));
                jSONObject.put("clientX", z.ag(this.bco - a.this.bcn[0]));
                jSONObject.put("clientY", z.ag(this.bcp - a.this.bcn[1]));
                jSONObject.put("identifier", this.identifier);
                jSONObject.put("force", this.bcq);
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
    }
}
