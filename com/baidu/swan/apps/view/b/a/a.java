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
    private String dQl;
    private List<C0481a> dQm;
    private List<C0481a> dQn;
    private int[] dQo;
    private long mTimeStamp;

    public a(MotionEvent motionEvent) {
        this.dQl = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.dQm = new ArrayList();
        this.dQn = new ArrayList();
        this.dQo = new int[2];
        a(motionEvent, "");
    }

    public a(MotionEvent motionEvent, String str) {
        this.dQl = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.dQm = new ArrayList();
        this.dQn = new ArrayList();
        this.dQo = new int[2];
        a(motionEvent, str);
    }

    public String aOT() {
        return this.dQl;
    }

    public void i(int[] iArr) {
        this.dQo = iArr;
        if (DEBUG) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.dQl = "touchstart";
                A(motionEvent);
                break;
            case 1:
                this.dQl = "touchend";
                A(motionEvent);
                break;
            case 2:
                this.dQl = "touchmove";
                A(motionEvent);
                break;
            case 3:
                this.dQl = "touchcancel";
                A(motionEvent);
                break;
            case 4:
            default:
                this.dQl = BdStatsConstant.StatsType.ERROR;
                break;
            case 5:
                this.dQl = "touchpointerdown";
                A(motionEvent);
                break;
            case 6:
                this.dQl = "touchpointerup";
                A(motionEvent);
                break;
        }
        this.mTimeStamp = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.dQl = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.dQl, "touchpointerdown")) {
            this.dQl = "touchstart";
        }
        if (TextUtils.equals(this.dQl, "touchpointerup")) {
            this.dQl = "touchend";
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.dQl, "touchend") && !TextUtils.equals(this.dQl, "touchcancel")) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                        this.dQm.add(c(motionEvent, i));
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
                this.dQn.add(c(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.dQn.add(c(motionEvent, i));
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public C0481a c(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        C0481a c0481a = new C0481a();
        c0481a.identifier = pointerId;
        c0481a.x = motionEvent.getX(i);
        c0481a.y = motionEvent.getY(i);
        c0481a.dQp = (motionEvent.getRawX() + c0481a.x) - motionEvent.getX();
        c0481a.dQq = (motionEvent.getRawY() + c0481a.y) - motionEvent.getY();
        c0481a.dQr = motionEvent.getPressure(i);
        return c0481a;
    }

    public JSONObject aOU() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.dQm.isEmpty()) {
                for (C0481a c0481a : this.dQm) {
                    if (c0481a != null) {
                        jSONArray.put(c0481a.aOV());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.dQn.isEmpty()) {
                for (C0481a c0481a2 : this.dQn) {
                    if (c0481a2 != null) {
                        jSONArray2.put(c0481a2.aOV());
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
    public class C0481a {
        private float dQp;
        private float dQq;
        private float dQr;
        private int identifier;
        private float x;
        private float y;

        private C0481a() {
        }

        JSONObject aOV() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Config.EVENT_HEAT_X, ah.px2dpFloat(this.x));
                jSONObject.put("y", ah.px2dpFloat(this.y));
                jSONObject.put("clientX", ah.px2dpFloat(this.dQp - a.this.dQo[0]));
                jSONObject.put("clientY", ah.px2dpFloat(this.dQq - a.this.dQo[1]));
                jSONObject.put("identifier", this.identifier);
                jSONObject.put("force", this.dQr);
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
    }
}
