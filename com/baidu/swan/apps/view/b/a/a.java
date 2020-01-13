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
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bWr;
    private List<C0295a> bWs;
    private int[] bWt;
    private long mTimeStamp;
    private List<C0295a> mTouchList;

    public a(MotionEvent motionEvent) {
        this.bWr = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.mTouchList = new ArrayList();
        this.bWs = new ArrayList();
        this.bWt = new int[2];
        a(motionEvent, "");
    }

    public a(MotionEvent motionEvent, String str) {
        this.bWr = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.mTouchList = new ArrayList();
        this.bWs = new ArrayList();
        this.bWt = new int[2];
        a(motionEvent, str);
    }

    public String afr() {
        return this.bWr;
    }

    public void g(int[] iArr) {
        this.bWt = iArr;
        if (DEBUG) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.bWr = "touchstart";
                m(motionEvent);
                break;
            case 1:
                this.bWr = "touchend";
                m(motionEvent);
                break;
            case 2:
                this.bWr = "touchmove";
                m(motionEvent);
                break;
            case 3:
                this.bWr = "touchcancel";
                m(motionEvent);
                break;
            case 4:
            default:
                this.bWr = BdStatsConstant.StatsType.ERROR;
                break;
            case 5:
                this.bWr = "touchpointerdown";
                m(motionEvent);
                break;
            case 6:
                this.bWr = "touchpointerup";
                m(motionEvent);
                break;
        }
        this.mTimeStamp = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.bWr = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.bWr, "touchpointerdown")) {
            this.bWr = "touchstart";
        }
        if (TextUtils.equals(this.bWr, "touchpointerup")) {
            this.bWr = "touchend";
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.bWr, "touchend") && !TextUtils.equals(this.bWr, "touchcancel")) {
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
                this.bWs.add(b(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.bWs.add(b(motionEvent, i));
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public C0295a b(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        C0295a c0295a = new C0295a();
        c0295a.identifier = pointerId;
        c0295a.x = motionEvent.getX(i);
        c0295a.y = motionEvent.getY(i);
        c0295a.bWu = (motionEvent.getRawX() + c0295a.x) - motionEvent.getX();
        c0295a.bWv = (motionEvent.getRawY() + c0295a.y) - motionEvent.getY();
        c0295a.bWw = motionEvent.getPressure(i);
        return c0295a;
    }

    public JSONObject afs() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.mTouchList.isEmpty()) {
                for (C0295a c0295a : this.mTouchList) {
                    if (c0295a != null) {
                        jSONArray.put(c0295a.aft());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.bWs.isEmpty()) {
                for (C0295a c0295a2 : this.bWs) {
                    if (c0295a2 != null) {
                        jSONArray2.put(c0295a2.aft());
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
    /* loaded from: classes10.dex */
    public class C0295a {
        private float bWu;
        private float bWv;
        private float bWw;
        private int identifier;
        private float x;
        private float y;

        private C0295a() {
        }

        JSONObject aft() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Config.EVENT_HEAT_X, af.px2dpFloat(this.x));
                jSONObject.put("y", af.px2dpFloat(this.y));
                jSONObject.put("clientX", af.px2dpFloat(this.bWu - a.this.bWt[0]));
                jSONObject.put("clientY", af.px2dpFloat(this.bWv - a.this.bWt[1]));
                jSONObject.put("identifier", this.identifier);
                jSONObject.put("force", this.bWw);
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
    }
}
