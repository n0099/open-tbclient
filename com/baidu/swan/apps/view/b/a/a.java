package com.baidu.swan.apps.view.b.a;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.ao.ah;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String dSr;
    private List<C0478a> dSs;
    private List<C0478a> dSt;
    private int[] dSu;
    private long mTimeStamp;

    public a(MotionEvent motionEvent) {
        this.dSr = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.dSs = new ArrayList();
        this.dSt = new ArrayList();
        this.dSu = new int[2];
        a(motionEvent, "");
    }

    public a(MotionEvent motionEvent, String str) {
        this.dSr = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.dSs = new ArrayList();
        this.dSt = new ArrayList();
        this.dSu = new int[2];
        a(motionEvent, str);
    }

    public String aPm() {
        return this.dSr;
    }

    public void i(int[] iArr) {
        this.dSu = iArr;
        if (DEBUG) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.dSr = "touchstart";
                A(motionEvent);
                break;
            case 1:
                this.dSr = "touchend";
                A(motionEvent);
                break;
            case 2:
                this.dSr = "touchmove";
                A(motionEvent);
                break;
            case 3:
                this.dSr = "touchcancel";
                A(motionEvent);
                break;
            case 4:
            default:
                this.dSr = BdStatsConstant.StatsType.ERROR;
                break;
            case 5:
                this.dSr = "touchpointerdown";
                A(motionEvent);
                break;
            case 6:
                this.dSr = "touchpointerup";
                A(motionEvent);
                break;
        }
        this.mTimeStamp = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.dSr = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.dSr, "touchpointerdown")) {
            this.dSr = "touchstart";
        }
        if (TextUtils.equals(this.dSr, "touchpointerup")) {
            this.dSr = "touchend";
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.dSr, "touchend") && !TextUtils.equals(this.dSr, "touchcancel")) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                        this.dSs.add(c(motionEvent, i));
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
                this.dSt.add(c(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.dSt.add(c(motionEvent, i));
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public C0478a c(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        C0478a c0478a = new C0478a();
        c0478a.identifier = pointerId;
        c0478a.x = motionEvent.getX(i);
        c0478a.y = motionEvent.getY(i);
        c0478a.dSv = (motionEvent.getRawX() + c0478a.x) - motionEvent.getX();
        c0478a.dSw = (motionEvent.getRawY() + c0478a.y) - motionEvent.getY();
        c0478a.dSx = motionEvent.getPressure(i);
        return c0478a;
    }

    public JSONObject aPn() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.dSs.isEmpty()) {
                for (C0478a c0478a : this.dSs) {
                    if (c0478a != null) {
                        jSONArray.put(c0478a.aPo());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.dSt.isEmpty()) {
                for (C0478a c0478a2 : this.dSt) {
                    if (c0478a2 != null) {
                        jSONArray2.put(c0478a2.aPo());
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
    public class C0478a {
        private float dSv;
        private float dSw;
        private float dSx;
        private int identifier;
        private float x;
        private float y;

        private C0478a() {
        }

        JSONObject aPo() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Config.EVENT_HEAT_X, ah.px2dpFloat(this.x));
                jSONObject.put("y", ah.px2dpFloat(this.y));
                jSONObject.put("clientX", ah.px2dpFloat(this.dSv - a.this.dSu[0]));
                jSONObject.put("clientY", ah.px2dpFloat(this.dSw - a.this.dSu[1]));
                jSONObject.put("identifier", this.identifier);
                jSONObject.put("force", this.dSx);
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
    }
}
