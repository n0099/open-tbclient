package com.baidu.swan.apps.view.b.a;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.swan.apps.ap.ah;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String dMe;
    private List<C0505a> dMf;
    private List<C0505a> dMg;
    private int[] dMh;
    private long mTimeStamp;

    public a(MotionEvent motionEvent) {
        this.dMe = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.dMf = new ArrayList();
        this.dMg = new ArrayList();
        this.dMh = new int[2];
        a(motionEvent, "");
    }

    public a(MotionEvent motionEvent, String str) {
        this.dMe = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.dMf = new ArrayList();
        this.dMg = new ArrayList();
        this.dMh = new int[2];
        a(motionEvent, str);
    }

    public String aQr() {
        return this.dMe;
    }

    public void h(int[] iArr) {
        this.dMh = iArr;
        if (DEBUG) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.dMe = "touchstart";
                A(motionEvent);
                break;
            case 1:
                this.dMe = "touchend";
                A(motionEvent);
                break;
            case 2:
                this.dMe = "touchmove";
                A(motionEvent);
                break;
            case 3:
                this.dMe = "touchcancel";
                A(motionEvent);
                break;
            case 4:
            default:
                this.dMe = BdStatsConstant.StatsType.ERROR;
                break;
            case 5:
                this.dMe = "touchpointerdown";
                A(motionEvent);
                break;
            case 6:
                this.dMe = "touchpointerup";
                A(motionEvent);
                break;
        }
        this.mTimeStamp = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.dMe = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.dMe, "touchpointerdown")) {
            this.dMe = "touchstart";
        }
        if (TextUtils.equals(this.dMe, "touchpointerup")) {
            this.dMe = "touchend";
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.dMe, "touchend") && !TextUtils.equals(this.dMe, "touchcancel")) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                        this.dMf.add(b(motionEvent, i));
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
                this.dMg.add(b(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.dMg.add(b(motionEvent, i));
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public C0505a b(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        C0505a c0505a = new C0505a();
        c0505a.identifier = pointerId;
        c0505a.x = motionEvent.getX(i);
        c0505a.y = motionEvent.getY(i);
        c0505a.dMi = (motionEvent.getRawX() + c0505a.x) - motionEvent.getX();
        c0505a.dMj = (motionEvent.getRawY() + c0505a.y) - motionEvent.getY();
        c0505a.dMk = motionEvent.getPressure(i);
        return c0505a;
    }

    public JSONObject aQs() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.dMf.isEmpty()) {
                for (C0505a c0505a : this.dMf) {
                    if (c0505a != null) {
                        jSONArray.put(c0505a.aQt());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.dMg.isEmpty()) {
                for (C0505a c0505a2 : this.dMg) {
                    if (c0505a2 != null) {
                        jSONArray2.put(c0505a2.aQt());
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
    /* loaded from: classes25.dex */
    public class C0505a {
        private float dMi;
        private float dMj;
        private float dMk;
        private int identifier;
        private float x;
        private float y;

        private C0505a() {
        }

        JSONObject aQt() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", ah.px2dpFloat(this.x));
                jSONObject.put("y", ah.px2dpFloat(this.y));
                jSONObject.put("clientX", ah.px2dpFloat(this.dMi - a.this.dMh[0]));
                jSONObject.put("clientY", ah.px2dpFloat(this.dMj - a.this.dMh[1]));
                jSONObject.put("identifier", this.identifier);
                jSONObject.put("force", this.dMk);
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
    }
}
