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
/* loaded from: classes3.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String dgp;
    private List<C0452a> dgq;
    private List<C0452a> dgr;
    private int[] dgs;
    private long mTimeStamp;

    public a(MotionEvent motionEvent) {
        this.dgp = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.dgq = new ArrayList();
        this.dgr = new ArrayList();
        this.dgs = new int[2];
        a(motionEvent, "");
    }

    public a(MotionEvent motionEvent, String str) {
        this.dgp = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.dgq = new ArrayList();
        this.dgr = new ArrayList();
        this.dgs = new int[2];
        a(motionEvent, str);
    }

    public String aGQ() {
        return this.dgp;
    }

    public void h(int[] iArr) {
        this.dgs = iArr;
        if (DEBUG) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.dgp = "touchstart";
                A(motionEvent);
                break;
            case 1:
                this.dgp = "touchend";
                A(motionEvent);
                break;
            case 2:
                this.dgp = "touchmove";
                A(motionEvent);
                break;
            case 3:
                this.dgp = "touchcancel";
                A(motionEvent);
                break;
            case 4:
            default:
                this.dgp = BdStatsConstant.StatsType.ERROR;
                break;
            case 5:
                this.dgp = "touchpointerdown";
                A(motionEvent);
                break;
            case 6:
                this.dgp = "touchpointerup";
                A(motionEvent);
                break;
        }
        this.mTimeStamp = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.dgp = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.dgp, "touchpointerdown")) {
            this.dgp = "touchstart";
        }
        if (TextUtils.equals(this.dgp, "touchpointerup")) {
            this.dgp = "touchend";
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.dgp, "touchend") && !TextUtils.equals(this.dgp, "touchcancel")) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                        this.dgq.add(b(motionEvent, i));
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
                this.dgr.add(b(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.dgr.add(b(motionEvent, i));
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public C0452a b(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        C0452a c0452a = new C0452a();
        c0452a.identifier = pointerId;
        c0452a.x = motionEvent.getX(i);
        c0452a.y = motionEvent.getY(i);
        c0452a.dgt = (motionEvent.getRawX() + c0452a.x) - motionEvent.getX();
        c0452a.dgu = (motionEvent.getRawY() + c0452a.y) - motionEvent.getY();
        c0452a.dgv = motionEvent.getPressure(i);
        return c0452a;
    }

    public JSONObject aGR() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.dgq.isEmpty()) {
                for (C0452a c0452a : this.dgq) {
                    if (c0452a != null) {
                        jSONArray.put(c0452a.aGS());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.dgr.isEmpty()) {
                for (C0452a c0452a2 : this.dgr) {
                    if (c0452a2 != null) {
                        jSONArray2.put(c0452a2.aGS());
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
    /* loaded from: classes3.dex */
    public class C0452a {
        private float dgt;
        private float dgu;
        private float dgv;
        private int identifier;
        private float x;
        private float y;

        private C0452a() {
        }

        JSONObject aGS() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", ah.px2dpFloat(this.x));
                jSONObject.put("y", ah.px2dpFloat(this.y));
                jSONObject.put("clientX", ah.px2dpFloat(this.dgt - a.this.dgs[0]));
                jSONObject.put("clientY", ah.px2dpFloat(this.dgu - a.this.dgs[1]));
                jSONObject.put("identifier", this.identifier);
                jSONObject.put("force", this.dgv);
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
    }
}
