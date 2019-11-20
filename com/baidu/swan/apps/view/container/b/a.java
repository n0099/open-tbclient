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
    private String buP;
    private List<C0234a> buQ;
    private List<C0234a> buR;
    private int[] buS;
    private long mTimeStamp;

    public a(MotionEvent motionEvent) {
        this.buP = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.buQ = new ArrayList();
        this.buR = new ArrayList();
        this.buS = new int[2];
        a(motionEvent, "");
    }

    public a(MotionEvent motionEvent, String str) {
        this.buP = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.buQ = new ArrayList();
        this.buR = new ArrayList();
        this.buS = new int[2];
        a(motionEvent, str);
    }

    public String Vd() {
        return this.buP;
    }

    public void f(int[] iArr) {
        this.buS = iArr;
        if (DEBUG) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.buP = "touchstart";
                m(motionEvent);
                break;
            case 1:
                this.buP = "touchend";
                m(motionEvent);
                break;
            case 2:
                this.buP = "touchmove";
                m(motionEvent);
                break;
            case 3:
                this.buP = "touchcancel";
                m(motionEvent);
                break;
            case 4:
            default:
                this.buP = BdStatsConstant.StatsType.ERROR;
                break;
            case 5:
                this.buP = "touchpointerdown";
                m(motionEvent);
                break;
            case 6:
                this.buP = "touchpointerup";
                m(motionEvent);
                break;
        }
        this.mTimeStamp = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.buP = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.buP, "touchpointerdown")) {
            this.buP = "touchstart";
        }
        if (TextUtils.equals(this.buP, "touchpointerup")) {
            this.buP = "touchend";
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.buP, "touchend") && !TextUtils.equals(this.buP, "touchcancel")) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                        this.buQ.add(b(motionEvent, i));
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
                this.buR.add(b(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.buR.add(b(motionEvent, i));
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
        c0234a.buT = (motionEvent.getRawX() + c0234a.x) - motionEvent.getX();
        c0234a.buU = (motionEvent.getRawY() + c0234a.y) - motionEvent.getY();
        c0234a.buV = motionEvent.getPressure(i);
        return c0234a;
    }

    public JSONObject Ve() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.buQ.isEmpty()) {
                for (C0234a c0234a : this.buQ) {
                    if (c0234a != null) {
                        jSONArray.put(c0234a.Vf());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.buR.isEmpty()) {
                for (C0234a c0234a2 : this.buR) {
                    if (c0234a2 != null) {
                        jSONArray2.put(c0234a2.Vf());
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
        private float buT;
        private float buU;
        private float buV;
        private int identifier;
        private float x;
        private float y;

        private C0234a() {
        }

        JSONObject Vf() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Config.EVENT_HEAT_X, z.V(this.x));
                jSONObject.put("y", z.V(this.y));
                jSONObject.put("clientX", z.V(this.buT - a.this.buS[0]));
                jSONObject.put("clientY", z.V(this.buU - a.this.buS[1]));
                jSONObject.put("identifier", this.identifier);
                jSONObject.put("force", this.buV);
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
    }
}
