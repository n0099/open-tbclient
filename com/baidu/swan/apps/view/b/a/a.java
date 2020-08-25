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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String dek;
    private List<C0457a> del;
    private List<C0457a> dem;
    private int[] den;
    private long mTimeStamp;

    public a(MotionEvent motionEvent) {
        this.dek = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.del = new ArrayList();
        this.dem = new ArrayList();
        this.den = new int[2];
        a(motionEvent, "");
    }

    public a(MotionEvent motionEvent, String str) {
        this.dek = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.del = new ArrayList();
        this.dem = new ArrayList();
        this.den = new int[2];
        a(motionEvent, str);
    }

    public String aGg() {
        return this.dek;
    }

    public void h(int[] iArr) {
        this.den = iArr;
        if (DEBUG) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.dek = "touchstart";
                A(motionEvent);
                break;
            case 1:
                this.dek = "touchend";
                A(motionEvent);
                break;
            case 2:
                this.dek = "touchmove";
                A(motionEvent);
                break;
            case 3:
                this.dek = "touchcancel";
                A(motionEvent);
                break;
            case 4:
            default:
                this.dek = BdStatsConstant.StatsType.ERROR;
                break;
            case 5:
                this.dek = "touchpointerdown";
                A(motionEvent);
                break;
            case 6:
                this.dek = "touchpointerup";
                A(motionEvent);
                break;
        }
        this.mTimeStamp = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.dek = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.dek, "touchpointerdown")) {
            this.dek = "touchstart";
        }
        if (TextUtils.equals(this.dek, "touchpointerup")) {
            this.dek = "touchend";
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.dek, "touchend") && !TextUtils.equals(this.dek, "touchcancel")) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                        this.del.add(b(motionEvent, i));
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
                this.dem.add(b(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.dem.add(b(motionEvent, i));
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public C0457a b(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        C0457a c0457a = new C0457a();
        c0457a.identifier = pointerId;
        c0457a.x = motionEvent.getX(i);
        c0457a.y = motionEvent.getY(i);
        c0457a.deo = (motionEvent.getRawX() + c0457a.x) - motionEvent.getX();
        c0457a.dep = (motionEvent.getRawY() + c0457a.y) - motionEvent.getY();
        c0457a.deq = motionEvent.getPressure(i);
        return c0457a;
    }

    public JSONObject aGh() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.del.isEmpty()) {
                for (C0457a c0457a : this.del) {
                    if (c0457a != null) {
                        jSONArray.put(c0457a.aGi());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.dem.isEmpty()) {
                for (C0457a c0457a2 : this.dem) {
                    if (c0457a2 != null) {
                        jSONArray2.put(c0457a2.aGi());
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
    /* loaded from: classes8.dex */
    public class C0457a {
        private float deo;
        private float dep;
        private float deq;
        private int identifier;
        private float x;
        private float y;

        private C0457a() {
        }

        JSONObject aGi() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", ah.px2dpFloat(this.x));
                jSONObject.put("y", ah.px2dpFloat(this.y));
                jSONObject.put("clientX", ah.px2dpFloat(this.deo - a.this.den[0]));
                jSONObject.put("clientY", ah.px2dpFloat(this.dep - a.this.den[1]));
                jSONObject.put("identifier", this.identifier);
                jSONObject.put("force", this.deq);
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
    }
}
