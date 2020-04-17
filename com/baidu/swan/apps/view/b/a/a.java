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
    private String czJ;
    private List<C0335a> czK;
    private List<C0335a> czL;
    private int[] czM;
    private long mTimeStamp;

    public a(MotionEvent motionEvent) {
        this.czJ = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.czK = new ArrayList();
        this.czL = new ArrayList();
        this.czM = new int[2];
        a(motionEvent, "");
    }

    public a(MotionEvent motionEvent, String str) {
        this.czJ = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.czK = new ArrayList();
        this.czL = new ArrayList();
        this.czM = new int[2];
        a(motionEvent, str);
    }

    public String apS() {
        return this.czJ;
    }

    public void g(int[] iArr) {
        this.czM = iArr;
        if (DEBUG) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.czJ = "touchstart";
                l(motionEvent);
                break;
            case 1:
                this.czJ = "touchend";
                l(motionEvent);
                break;
            case 2:
                this.czJ = "touchmove";
                l(motionEvent);
                break;
            case 3:
                this.czJ = "touchcancel";
                l(motionEvent);
                break;
            case 4:
            default:
                this.czJ = BdStatsConstant.StatsType.ERROR;
                break;
            case 5:
                this.czJ = "touchpointerdown";
                l(motionEvent);
                break;
            case 6:
                this.czJ = "touchpointerup";
                l(motionEvent);
                break;
        }
        this.mTimeStamp = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.czJ = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.czJ, "touchpointerdown")) {
            this.czJ = "touchstart";
        }
        if (TextUtils.equals(this.czJ, "touchpointerup")) {
            this.czJ = "touchend";
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.czJ, "touchend") && !TextUtils.equals(this.czJ, "touchcancel")) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                        this.czK.add(b(motionEvent, i));
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
                this.czL.add(b(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.czL.add(b(motionEvent, i));
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public C0335a b(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        C0335a c0335a = new C0335a();
        c0335a.identifier = pointerId;
        c0335a.x = motionEvent.getX(i);
        c0335a.y = motionEvent.getY(i);
        c0335a.czN = (motionEvent.getRawX() + c0335a.x) - motionEvent.getX();
        c0335a.czO = (motionEvent.getRawY() + c0335a.y) - motionEvent.getY();
        c0335a.czP = motionEvent.getPressure(i);
        return c0335a;
    }

    public JSONObject apT() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.czK.isEmpty()) {
                for (C0335a c0335a : this.czK) {
                    if (c0335a != null) {
                        jSONArray.put(c0335a.apU());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.czL.isEmpty()) {
                for (C0335a c0335a2 : this.czL) {
                    if (c0335a2 != null) {
                        jSONArray2.put(c0335a2.apU());
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
    public class C0335a {
        private float czN;
        private float czO;
        private float czP;
        private int identifier;
        private float x;
        private float y;

        private C0335a() {
        }

        JSONObject apU() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Config.EVENT_HEAT_X, af.px2dpFloat(this.x));
                jSONObject.put("y", af.px2dpFloat(this.y));
                jSONObject.put("clientX", af.px2dpFloat(this.czN - a.this.czM[0]));
                jSONObject.put("clientY", af.px2dpFloat(this.czO - a.this.czM[1]));
                jSONObject.put("identifier", this.identifier);
                jSONObject.put("force", this.czP);
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
    }
}
