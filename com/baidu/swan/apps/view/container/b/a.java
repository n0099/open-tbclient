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
    private List<C0191a> bbA;
    private List<C0191a> bbB;
    private int[] bbC;
    private String bby;
    private long bbz;

    public a(MotionEvent motionEvent) {
        this.bby = "error";
        this.bbz = 0L;
        this.bbA = new ArrayList();
        this.bbB = new ArrayList();
        this.bbC = new int[2];
        a(motionEvent, "");
    }

    public a(MotionEvent motionEvent, String str) {
        this.bby = "error";
        this.bbz = 0L;
        this.bbA = new ArrayList();
        this.bbB = new ArrayList();
        this.bbC = new int[2];
        a(motionEvent, str);
    }

    public String Pu() {
        return this.bby;
    }

    public void g(int[] iArr) {
        this.bbC = iArr;
        if (DEBUG) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.bby = "touchstart";
                q(motionEvent);
                break;
            case 1:
                this.bby = "touchend";
                q(motionEvent);
                break;
            case 2:
                this.bby = "touchmove";
                q(motionEvent);
                break;
            case 3:
                this.bby = "touchcancel";
                q(motionEvent);
                break;
            case 4:
            default:
                this.bby = "error";
                break;
            case 5:
                this.bby = "touchpointerdown";
                q(motionEvent);
                break;
            case 6:
                this.bby = "touchpointerup";
                q(motionEvent);
                break;
        }
        this.bbz = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.bby = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.bby, "touchpointerdown")) {
            this.bby = "touchstart";
        }
        if (TextUtils.equals(this.bby, "touchpointerup")) {
            this.bby = "touchend";
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.bby, "touchend") && !TextUtils.equals(this.bby, "touchcancel")) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                        this.bbA.add(b(motionEvent, i));
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
                this.bbB.add(b(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.bbB.add(b(motionEvent, i));
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public C0191a b(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        C0191a c0191a = new C0191a();
        c0191a.identifier = pointerId;
        c0191a.x = motionEvent.getX(i);
        c0191a.y = motionEvent.getY(i);
        c0191a.bbD = (motionEvent.getRawX() + c0191a.x) - motionEvent.getX();
        c0191a.bbE = (motionEvent.getRawY() + c0191a.y) - motionEvent.getY();
        c0191a.pressure = motionEvent.getPressure(i);
        return c0191a;
    }

    public JSONObject Pv() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.bbA.isEmpty()) {
                for (C0191a c0191a : this.bbA) {
                    if (c0191a != null) {
                        jSONArray.put(c0191a.Pw());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.bbB.isEmpty()) {
                for (C0191a c0191a2 : this.bbB) {
                    if (c0191a2 != null) {
                        jSONArray2.put(c0191a2.Pw());
                    }
                }
            }
            jSONObject.put("timeStamp", this.bbz);
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
    public class C0191a {
        private float bbD;
        private float bbE;
        private int identifier;
        private float pressure;
        private float x;
        private float y;

        private C0191a() {
        }

        JSONObject Pw() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Config.EVENT_HEAT_X, z.ag(this.x));
                jSONObject.put("y", z.ag(this.y));
                jSONObject.put("clientX", z.ag(this.bbD - a.this.bbC[0]));
                jSONObject.put("clientY", z.ag(this.bbE - a.this.bbC[1]));
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
