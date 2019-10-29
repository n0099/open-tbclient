package com.baidu.swan.apps.view.container.b;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
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
    private String bvG;
    private List<C0234a> bvH;
    private List<C0234a> bvI;
    private int[] bvJ;
    private long mTimeStamp;

    public a(MotionEvent motionEvent) {
        this.bvG = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.bvH = new ArrayList();
        this.bvI = new ArrayList();
        this.bvJ = new int[2];
        a(motionEvent, "");
    }

    public a(MotionEvent motionEvent, String str) {
        this.bvG = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.bvH = new ArrayList();
        this.bvI = new ArrayList();
        this.bvJ = new int[2];
        a(motionEvent, str);
    }

    public String Vf() {
        return this.bvG;
    }

    public void f(int[] iArr) {
        this.bvJ = iArr;
        if (DEBUG) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.bvG = "touchstart";
                m(motionEvent);
                break;
            case 1:
                this.bvG = "touchend";
                m(motionEvent);
                break;
            case 2:
                this.bvG = "touchmove";
                m(motionEvent);
                break;
            case 3:
                this.bvG = "touchcancel";
                m(motionEvent);
                break;
            case 4:
            default:
                this.bvG = BdStatsConstant.StatsType.ERROR;
                break;
            case 5:
                this.bvG = "touchpointerdown";
                m(motionEvent);
                break;
            case 6:
                this.bvG = "touchpointerup";
                m(motionEvent);
                break;
        }
        this.mTimeStamp = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.bvG = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.bvG, "touchpointerdown")) {
            this.bvG = "touchstart";
        }
        if (TextUtils.equals(this.bvG, "touchpointerup")) {
            this.bvG = "touchend";
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.bvG, "touchend") && !TextUtils.equals(this.bvG, "touchcancel")) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                        this.bvH.add(b(motionEvent, i));
                    }
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void m(MotionEvent motionEvent) {
        try {
            if (!(motionEvent.getActionMasked() == 2)) {
                this.bvI.add(b(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.bvI.add(b(motionEvent, i));
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public C0234a b(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        C0234a c0234a = new C0234a();
        c0234a.identifier = pointerId;
        c0234a.x = motionEvent.getX(i);
        c0234a.y = motionEvent.getY(i);
        c0234a.bvK = (motionEvent.getRawX() + c0234a.x) - motionEvent.getX();
        c0234a.bvL = (motionEvent.getRawY() + c0234a.y) - motionEvent.getY();
        c0234a.bvM = motionEvent.getPressure(i);
        return c0234a;
    }

    public JSONObject Vg() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.bvH.isEmpty()) {
                for (C0234a c0234a : this.bvH) {
                    if (c0234a != null) {
                        jSONArray.put(c0234a.Vh());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.bvI.isEmpty()) {
                for (C0234a c0234a2 : this.bvI) {
                    if (c0234a2 != null) {
                        jSONArray2.put(c0234a2.Vh());
                    }
                }
            }
            jSONObject.put("timeStamp", this.mTimeStamp);
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
    public class C0234a {
        private float bvK;
        private float bvL;
        private float bvM;
        private int identifier;
        private float x;
        private float y;

        private C0234a() {
        }

        JSONObject Vh() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Config.EVENT_HEAT_X, z.V(this.x));
                jSONObject.put("y", z.V(this.y));
                jSONObject.put("clientX", z.V(this.bvK - a.this.bvJ[0]));
                jSONObject.put("clientY", z.V(this.bvL - a.this.bvJ[1]));
                jSONObject.put("identifier", this.identifier);
                jSONObject.put("force", this.bvM);
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
    }
}
