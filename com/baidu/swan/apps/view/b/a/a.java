package com.baidu.swan.apps.view.b.a;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.as.af;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String czP;
    private List<C0356a> czQ;
    private List<C0356a> czR;
    private int[] czS;
    private long mTimeStamp;

    public a(MotionEvent motionEvent) {
        this.czP = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.czQ = new ArrayList();
        this.czR = new ArrayList();
        this.czS = new int[2];
        a(motionEvent, "");
    }

    public a(MotionEvent motionEvent, String str) {
        this.czP = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.czQ = new ArrayList();
        this.czR = new ArrayList();
        this.czS = new int[2];
        a(motionEvent, str);
    }

    public String apR() {
        return this.czP;
    }

    public void g(int[] iArr) {
        this.czS = iArr;
        if (DEBUG) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.czP = "touchstart";
                l(motionEvent);
                break;
            case 1:
                this.czP = "touchend";
                l(motionEvent);
                break;
            case 2:
                this.czP = "touchmove";
                l(motionEvent);
                break;
            case 3:
                this.czP = "touchcancel";
                l(motionEvent);
                break;
            case 4:
            default:
                this.czP = BdStatsConstant.StatsType.ERROR;
                break;
            case 5:
                this.czP = "touchpointerdown";
                l(motionEvent);
                break;
            case 6:
                this.czP = "touchpointerup";
                l(motionEvent);
                break;
        }
        this.mTimeStamp = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.czP = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.czP, "touchpointerdown")) {
            this.czP = "touchstart";
        }
        if (TextUtils.equals(this.czP, "touchpointerup")) {
            this.czP = "touchend";
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.czP, "touchend") && !TextUtils.equals(this.czP, "touchcancel")) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                        this.czQ.add(b(motionEvent, i));
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
                this.czR.add(b(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.czR.add(b(motionEvent, i));
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public C0356a b(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        C0356a c0356a = new C0356a();
        c0356a.identifier = pointerId;
        c0356a.x = motionEvent.getX(i);
        c0356a.y = motionEvent.getY(i);
        c0356a.czT = (motionEvent.getRawX() + c0356a.x) - motionEvent.getX();
        c0356a.czU = (motionEvent.getRawY() + c0356a.y) - motionEvent.getY();
        c0356a.czV = motionEvent.getPressure(i);
        return c0356a;
    }

    public JSONObject apS() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.czQ.isEmpty()) {
                for (C0356a c0356a : this.czQ) {
                    if (c0356a != null) {
                        jSONArray.put(c0356a.apT());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.czR.isEmpty()) {
                for (C0356a c0356a2 : this.czR) {
                    if (c0356a2 != null) {
                        jSONArray2.put(c0356a2.apT());
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
    public class C0356a {
        private float czT;
        private float czU;
        private float czV;
        private int identifier;
        private float x;
        private float y;

        private C0356a() {
        }

        JSONObject apT() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Config.EVENT_HEAT_X, af.px2dpFloat(this.x));
                jSONObject.put("y", af.px2dpFloat(this.y));
                jSONObject.put("clientX", af.px2dpFloat(this.czT - a.this.czS[0]));
                jSONObject.put("clientY", af.px2dpFloat(this.czU - a.this.czS[1]));
                jSONObject.put("identifier", this.identifier);
                jSONObject.put("force", this.czV);
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
    }
}
