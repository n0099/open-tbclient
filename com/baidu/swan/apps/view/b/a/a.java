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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String dTS;
    private List<C0484a> dTT;
    private List<C0484a> dTU;
    private int[] dTV;
    private long mTimeStamp;

    public a(MotionEvent motionEvent) {
        this.dTS = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.dTT = new ArrayList();
        this.dTU = new ArrayList();
        this.dTV = new int[2];
        a(motionEvent, "");
    }

    public a(MotionEvent motionEvent, String str) {
        this.dTS = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.dTT = new ArrayList();
        this.dTU = new ArrayList();
        this.dTV = new int[2];
        a(motionEvent, str);
    }

    public String aPp() {
        return this.dTS;
    }

    public void i(int[] iArr) {
        this.dTV = iArr;
        if (DEBUG) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.dTS = "touchstart";
                A(motionEvent);
                break;
            case 1:
                this.dTS = "touchend";
                A(motionEvent);
                break;
            case 2:
                this.dTS = "touchmove";
                A(motionEvent);
                break;
            case 3:
                this.dTS = "touchcancel";
                A(motionEvent);
                break;
            case 4:
            default:
                this.dTS = BdStatsConstant.StatsType.ERROR;
                break;
            case 5:
                this.dTS = "touchpointerdown";
                A(motionEvent);
                break;
            case 6:
                this.dTS = "touchpointerup";
                A(motionEvent);
                break;
        }
        this.mTimeStamp = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.dTS = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.dTS, "touchpointerdown")) {
            this.dTS = "touchstart";
        }
        if (TextUtils.equals(this.dTS, "touchpointerup")) {
            this.dTS = "touchend";
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.dTS, "touchend") && !TextUtils.equals(this.dTS, "touchcancel")) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                        this.dTT.add(c(motionEvent, i));
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
                this.dTU.add(c(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.dTU.add(c(motionEvent, i));
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public C0484a c(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        C0484a c0484a = new C0484a();
        c0484a.identifier = pointerId;
        c0484a.x = motionEvent.getX(i);
        c0484a.y = motionEvent.getY(i);
        c0484a.dTW = (motionEvent.getRawX() + c0484a.x) - motionEvent.getX();
        c0484a.dTX = (motionEvent.getRawY() + c0484a.y) - motionEvent.getY();
        c0484a.dTY = motionEvent.getPressure(i);
        return c0484a;
    }

    public JSONObject aPq() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.dTT.isEmpty()) {
                for (C0484a c0484a : this.dTT) {
                    if (c0484a != null) {
                        jSONArray.put(c0484a.aPr());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.dTU.isEmpty()) {
                for (C0484a c0484a2 : this.dTU) {
                    if (c0484a2 != null) {
                        jSONArray2.put(c0484a2.aPr());
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
    public class C0484a {
        private float dTW;
        private float dTX;
        private float dTY;
        private int identifier;
        private float x;
        private float y;

        private C0484a() {
        }

        JSONObject aPr() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Config.EVENT_HEAT_X, ah.px2dpFloat(this.x));
                jSONObject.put("y", ah.px2dpFloat(this.y));
                jSONObject.put("clientX", ah.px2dpFloat(this.dTW - a.this.dTV[0]));
                jSONObject.put("clientY", ah.px2dpFloat(this.dTX - a.this.dTV[1]));
                jSONObject.put("identifier", this.identifier);
                jSONObject.put("force", this.dTY);
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
    }
}
