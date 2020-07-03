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
    private String cRB;
    private List<C0405a> cRC;
    private List<C0405a> cRD;
    private int[] cRE;
    private long mTimeStamp;

    public a(MotionEvent motionEvent) {
        this.cRB = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.cRC = new ArrayList();
        this.cRD = new ArrayList();
        this.cRE = new int[2];
        a(motionEvent, "");
    }

    public a(MotionEvent motionEvent, String str) {
        this.cRB = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.cRC = new ArrayList();
        this.cRD = new ArrayList();
        this.cRE = new int[2];
        a(motionEvent, str);
    }

    public String avF() {
        return this.cRB;
    }

    public void g(int[] iArr) {
        this.cRE = iArr;
        if (DEBUG) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.cRB = "touchstart";
                l(motionEvent);
                break;
            case 1:
                this.cRB = "touchend";
                l(motionEvent);
                break;
            case 2:
                this.cRB = "touchmove";
                l(motionEvent);
                break;
            case 3:
                this.cRB = "touchcancel";
                l(motionEvent);
                break;
            case 4:
            default:
                this.cRB = BdStatsConstant.StatsType.ERROR;
                break;
            case 5:
                this.cRB = "touchpointerdown";
                l(motionEvent);
                break;
            case 6:
                this.cRB = "touchpointerup";
                l(motionEvent);
                break;
        }
        this.mTimeStamp = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.cRB = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.cRB, "touchpointerdown")) {
            this.cRB = "touchstart";
        }
        if (TextUtils.equals(this.cRB, "touchpointerup")) {
            this.cRB = "touchend";
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.cRB, "touchend") && !TextUtils.equals(this.cRB, "touchcancel")) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                        this.cRC.add(b(motionEvent, i));
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
                this.cRD.add(b(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.cRD.add(b(motionEvent, i));
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public C0405a b(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        C0405a c0405a = new C0405a();
        c0405a.identifier = pointerId;
        c0405a.x = motionEvent.getX(i);
        c0405a.y = motionEvent.getY(i);
        c0405a.cRF = (motionEvent.getRawX() + c0405a.x) - motionEvent.getX();
        c0405a.cRG = (motionEvent.getRawY() + c0405a.y) - motionEvent.getY();
        c0405a.cRH = motionEvent.getPressure(i);
        return c0405a;
    }

    public JSONObject avG() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.cRC.isEmpty()) {
                for (C0405a c0405a : this.cRC) {
                    if (c0405a != null) {
                        jSONArray.put(c0405a.avH());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.cRD.isEmpty()) {
                for (C0405a c0405a2 : this.cRD) {
                    if (c0405a2 != null) {
                        jSONArray2.put(c0405a2.avH());
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
    public class C0405a {
        private float cRF;
        private float cRG;
        private float cRH;
        private int identifier;
        private float x;
        private float y;

        private C0405a() {
        }

        JSONObject avH() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Config.EVENT_HEAT_X, ag.px2dpFloat(this.x));
                jSONObject.put("y", ag.px2dpFloat(this.y));
                jSONObject.put("clientX", ag.px2dpFloat(this.cRF - a.this.cRE[0]));
                jSONObject.put("clientY", ag.px2dpFloat(this.cRG - a.this.cRE[1]));
                jSONObject.put("identifier", this.identifier);
                jSONObject.put("force", this.cRH);
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
    }
}
