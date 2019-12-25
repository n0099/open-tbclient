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
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bWf;
    private List<C0293a> bWg;
    private int[] bWh;
    private long mTimeStamp;
    private List<C0293a> mTouchList;

    public a(MotionEvent motionEvent) {
        this.bWf = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.mTouchList = new ArrayList();
        this.bWg = new ArrayList();
        this.bWh = new int[2];
        a(motionEvent, "");
    }

    public a(MotionEvent motionEvent, String str) {
        this.bWf = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.mTouchList = new ArrayList();
        this.bWg = new ArrayList();
        this.bWh = new int[2];
        a(motionEvent, str);
    }

    public String aeY() {
        return this.bWf;
    }

    public void g(int[] iArr) {
        this.bWh = iArr;
        if (DEBUG) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.bWf = "touchstart";
                m(motionEvent);
                break;
            case 1:
                this.bWf = "touchend";
                m(motionEvent);
                break;
            case 2:
                this.bWf = "touchmove";
                m(motionEvent);
                break;
            case 3:
                this.bWf = "touchcancel";
                m(motionEvent);
                break;
            case 4:
            default:
                this.bWf = BdStatsConstant.StatsType.ERROR;
                break;
            case 5:
                this.bWf = "touchpointerdown";
                m(motionEvent);
                break;
            case 6:
                this.bWf = "touchpointerup";
                m(motionEvent);
                break;
        }
        this.mTimeStamp = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.bWf = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.bWf, "touchpointerdown")) {
            this.bWf = "touchstart";
        }
        if (TextUtils.equals(this.bWf, "touchpointerup")) {
            this.bWf = "touchend";
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.bWf, "touchend") && !TextUtils.equals(this.bWf, "touchcancel")) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                        this.mTouchList.add(b(motionEvent, i));
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
                this.bWg.add(b(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.bWg.add(b(motionEvent, i));
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public C0293a b(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        C0293a c0293a = new C0293a();
        c0293a.identifier = pointerId;
        c0293a.x = motionEvent.getX(i);
        c0293a.y = motionEvent.getY(i);
        c0293a.bWi = (motionEvent.getRawX() + c0293a.x) - motionEvent.getX();
        c0293a.bWj = (motionEvent.getRawY() + c0293a.y) - motionEvent.getY();
        c0293a.bWk = motionEvent.getPressure(i);
        return c0293a;
    }

    public JSONObject aeZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.mTouchList.isEmpty()) {
                for (C0293a c0293a : this.mTouchList) {
                    if (c0293a != null) {
                        jSONArray.put(c0293a.afa());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.bWg.isEmpty()) {
                for (C0293a c0293a2 : this.bWg) {
                    if (c0293a2 != null) {
                        jSONArray2.put(c0293a2.afa());
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
    /* loaded from: classes9.dex */
    public class C0293a {
        private float bWi;
        private float bWj;
        private float bWk;
        private int identifier;
        private float x;
        private float y;

        private C0293a() {
        }

        JSONObject afa() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Config.EVENT_HEAT_X, af.px2dpFloat(this.x));
                jSONObject.put("y", af.px2dpFloat(this.y));
                jSONObject.put("clientX", af.px2dpFloat(this.bWi - a.this.bWh[0]));
                jSONObject.put("clientY", af.px2dpFloat(this.bWj - a.this.bWh[1]));
                jSONObject.put("identifier", this.identifier);
                jSONObject.put("force", this.bWk);
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
    }
}
