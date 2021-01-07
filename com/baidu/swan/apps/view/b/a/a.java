package com.baidu.swan.apps.view.b.a;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.swan.apps.ao.ah;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String dUX;
    private List<C0498a> dUY;
    private List<C0498a> dUZ;
    private int[] dVa;
    private long mTimeStamp;

    public a(MotionEvent motionEvent) {
        this.dUX = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.dUY = new ArrayList();
        this.dUZ = new ArrayList();
        this.dVa = new int[2];
        a(motionEvent, "");
    }

    public a(MotionEvent motionEvent, String str) {
        this.dUX = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.dUY = new ArrayList();
        this.dUZ = new ArrayList();
        this.dVa = new int[2];
        a(motionEvent, str);
    }

    public String aSN() {
        return this.dUX;
    }

    public void i(int[] iArr) {
        this.dVa = iArr;
        if (DEBUG) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.dUX = "touchstart";
                A(motionEvent);
                break;
            case 1:
                this.dUX = "touchend";
                A(motionEvent);
                break;
            case 2:
                this.dUX = "touchmove";
                A(motionEvent);
                break;
            case 3:
                this.dUX = "touchcancel";
                A(motionEvent);
                break;
            case 4:
            default:
                this.dUX = BdStatsConstant.StatsType.ERROR;
                break;
            case 5:
                this.dUX = "touchpointerdown";
                A(motionEvent);
                break;
            case 6:
                this.dUX = "touchpointerup";
                A(motionEvent);
                break;
        }
        this.mTimeStamp = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.dUX = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.dUX, "touchpointerdown")) {
            this.dUX = "touchstart";
        }
        if (TextUtils.equals(this.dUX, "touchpointerup")) {
            this.dUX = "touchend";
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.dUX, "touchend") && !TextUtils.equals(this.dUX, "touchcancel")) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                        this.dUY.add(c(motionEvent, i));
                    }
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void A(MotionEvent motionEvent) {
        try {
            if (!(motionEvent.getActionMasked() == 2)) {
                this.dUZ.add(c(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.dUZ.add(c(motionEvent, i));
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public C0498a c(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        C0498a c0498a = new C0498a();
        c0498a.identifier = pointerId;
        c0498a.x = motionEvent.getX(i);
        c0498a.y = motionEvent.getY(i);
        c0498a.dVb = (motionEvent.getRawX() + c0498a.x) - motionEvent.getX();
        c0498a.dVc = (motionEvent.getRawY() + c0498a.y) - motionEvent.getY();
        c0498a.dVd = motionEvent.getPressure(i);
        return c0498a;
    }

    public JSONObject aSO() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.dUY.isEmpty()) {
                for (C0498a c0498a : this.dUY) {
                    if (c0498a != null) {
                        jSONArray.put(c0498a.aSP());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.dUZ.isEmpty()) {
                for (C0498a c0498a2 : this.dUZ) {
                    if (c0498a2 != null) {
                        jSONArray2.put(c0498a2.aSP());
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
    public class C0498a {
        private float dVb;
        private float dVc;
        private float dVd;
        private int identifier;
        private float x;
        private float y;

        private C0498a() {
        }

        JSONObject aSP() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", ah.px2dpFloat(this.x));
                jSONObject.put("y", ah.px2dpFloat(this.y));
                jSONObject.put("clientX", ah.px2dpFloat(this.dVb - a.this.dVa[0]));
                jSONObject.put("clientY", ah.px2dpFloat(this.dVc - a.this.dVa[1]));
                jSONObject.put("identifier", this.identifier);
                jSONObject.put("force", this.dVd);
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
    }
}
