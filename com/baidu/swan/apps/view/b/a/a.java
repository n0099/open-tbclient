package com.baidu.swan.apps.view.b.a;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.aq.ag;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cMR;
    private List<C0399a> cMS;
    private List<C0399a> cMT;
    private int[] cMU;
    private long mTimeStamp;

    public a(MotionEvent motionEvent) {
        this.cMR = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.cMS = new ArrayList();
        this.cMT = new ArrayList();
        this.cMU = new int[2];
        a(motionEvent, "");
    }

    public a(MotionEvent motionEvent, String str) {
        this.cMR = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.cMS = new ArrayList();
        this.cMT = new ArrayList();
        this.cMU = new int[2];
        a(motionEvent, str);
    }

    public String auz() {
        return this.cMR;
    }

    public void g(int[] iArr) {
        this.cMU = iArr;
        if (DEBUG) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.cMR = "touchstart";
                l(motionEvent);
                break;
            case 1:
                this.cMR = "touchend";
                l(motionEvent);
                break;
            case 2:
                this.cMR = "touchmove";
                l(motionEvent);
                break;
            case 3:
                this.cMR = "touchcancel";
                l(motionEvent);
                break;
            case 4:
            default:
                this.cMR = BdStatsConstant.StatsType.ERROR;
                break;
            case 5:
                this.cMR = "touchpointerdown";
                l(motionEvent);
                break;
            case 6:
                this.cMR = "touchpointerup";
                l(motionEvent);
                break;
        }
        this.mTimeStamp = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.cMR = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.cMR, "touchpointerdown")) {
            this.cMR = "touchstart";
        }
        if (TextUtils.equals(this.cMR, "touchpointerup")) {
            this.cMR = "touchend";
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.cMR, "touchend") && !TextUtils.equals(this.cMR, "touchcancel")) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                        this.cMS.add(b(motionEvent, i));
                    }
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void l(MotionEvent motionEvent) {
        try {
            if (!(motionEvent.getActionMasked() == 2)) {
                this.cMT.add(b(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.cMT.add(b(motionEvent, i));
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public C0399a b(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        C0399a c0399a = new C0399a();
        c0399a.identifier = pointerId;
        c0399a.x = motionEvent.getX(i);
        c0399a.y = motionEvent.getY(i);
        c0399a.cMV = (motionEvent.getRawX() + c0399a.x) - motionEvent.getX();
        c0399a.cMW = (motionEvent.getRawY() + c0399a.y) - motionEvent.getY();
        c0399a.cMX = motionEvent.getPressure(i);
        return c0399a;
    }

    public JSONObject auA() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.cMS.isEmpty()) {
                for (C0399a c0399a : this.cMS) {
                    if (c0399a != null) {
                        jSONArray.put(c0399a.auB());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.cMT.isEmpty()) {
                for (C0399a c0399a2 : this.cMT) {
                    if (c0399a2 != null) {
                        jSONArray2.put(c0399a2.auB());
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
    /* renamed from: com.baidu.swan.apps.view.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0399a {
        private float cMV;
        private float cMW;
        private float cMX;
        private int identifier;
        private float x;
        private float y;

        private C0399a() {
        }

        JSONObject auB() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Config.EVENT_HEAT_X, ag.px2dpFloat(this.x));
                jSONObject.put("y", ag.px2dpFloat(this.y));
                jSONObject.put("clientX", ag.px2dpFloat(this.cMV - a.this.cMU[0]));
                jSONObject.put("clientY", ag.px2dpFloat(this.cMW - a.this.cMU[1]));
                jSONObject.put("identifier", this.identifier);
                jSONObject.put("force", this.cMX);
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
    }
}
