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
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String dFg;
    private List<C0493a> dFh;
    private List<C0493a> dFi;
    private int[] dFj;
    private long mTimeStamp;

    public a(MotionEvent motionEvent) {
        this.dFg = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.dFh = new ArrayList();
        this.dFi = new ArrayList();
        this.dFj = new int[2];
        a(motionEvent, "");
    }

    public a(MotionEvent motionEvent, String str) {
        this.dFg = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.dFh = new ArrayList();
        this.dFi = new ArrayList();
        this.dFj = new int[2];
        a(motionEvent, str);
    }

    public String aNl() {
        return this.dFg;
    }

    public void h(int[] iArr) {
        this.dFj = iArr;
        if (DEBUG) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.dFg = "touchstart";
                A(motionEvent);
                break;
            case 1:
                this.dFg = "touchend";
                A(motionEvent);
                break;
            case 2:
                this.dFg = "touchmove";
                A(motionEvent);
                break;
            case 3:
                this.dFg = "touchcancel";
                A(motionEvent);
                break;
            case 4:
            default:
                this.dFg = BdStatsConstant.StatsType.ERROR;
                break;
            case 5:
                this.dFg = "touchpointerdown";
                A(motionEvent);
                break;
            case 6:
                this.dFg = "touchpointerup";
                A(motionEvent);
                break;
        }
        this.mTimeStamp = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.dFg = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.dFg, "touchpointerdown")) {
            this.dFg = "touchstart";
        }
        if (TextUtils.equals(this.dFg, "touchpointerup")) {
            this.dFg = "touchend";
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.dFg, "touchend") && !TextUtils.equals(this.dFg, "touchcancel")) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                        this.dFh.add(b(motionEvent, i));
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
                this.dFi.add(b(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.dFi.add(b(motionEvent, i));
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public C0493a b(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        C0493a c0493a = new C0493a();
        c0493a.identifier = pointerId;
        c0493a.x = motionEvent.getX(i);
        c0493a.y = motionEvent.getY(i);
        c0493a.dFk = (motionEvent.getRawX() + c0493a.x) - motionEvent.getX();
        c0493a.dFl = (motionEvent.getRawY() + c0493a.y) - motionEvent.getY();
        c0493a.dFm = motionEvent.getPressure(i);
        return c0493a;
    }

    public JSONObject aNm() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.dFh.isEmpty()) {
                for (C0493a c0493a : this.dFh) {
                    if (c0493a != null) {
                        jSONArray.put(c0493a.aNn());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.dFi.isEmpty()) {
                for (C0493a c0493a2 : this.dFi) {
                    if (c0493a2 != null) {
                        jSONArray2.put(c0493a2.aNn());
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
    /* loaded from: classes7.dex */
    public class C0493a {
        private float dFk;
        private float dFl;
        private float dFm;
        private int identifier;
        private float x;
        private float y;

        private C0493a() {
        }

        JSONObject aNn() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", ah.px2dpFloat(this.x));
                jSONObject.put("y", ah.px2dpFloat(this.y));
                jSONObject.put("clientX", ah.px2dpFloat(this.dFk - a.this.dFj[0]));
                jSONObject.put("clientY", ah.px2dpFloat(this.dFl - a.this.dFj[1]));
                jSONObject.put("identifier", this.identifier);
                jSONObject.put("force", this.dFm);
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
    }
}
