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
    private String cav;
    private List<C0305a> caw;
    private int[] cax;
    private long mTimeStamp;
    private List<C0305a> mTouchList;

    public a(MotionEvent motionEvent) {
        this.cav = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.mTouchList = new ArrayList();
        this.caw = new ArrayList();
        this.cax = new int[2];
        a(motionEvent, "");
    }

    public a(MotionEvent motionEvent, String str) {
        this.cav = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.mTouchList = new ArrayList();
        this.caw = new ArrayList();
        this.cax = new int[2];
        a(motionEvent, str);
    }

    public String ahF() {
        return this.cav;
    }

    public void g(int[] iArr) {
        this.cax = iArr;
        if (DEBUG) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.cav = "touchstart";
                m(motionEvent);
                break;
            case 1:
                this.cav = "touchend";
                m(motionEvent);
                break;
            case 2:
                this.cav = "touchmove";
                m(motionEvent);
                break;
            case 3:
                this.cav = "touchcancel";
                m(motionEvent);
                break;
            case 4:
            default:
                this.cav = BdStatsConstant.StatsType.ERROR;
                break;
            case 5:
                this.cav = "touchpointerdown";
                m(motionEvent);
                break;
            case 6:
                this.cav = "touchpointerup";
                m(motionEvent);
                break;
        }
        this.mTimeStamp = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.cav = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.cav, "touchpointerdown")) {
            this.cav = "touchstart";
        }
        if (TextUtils.equals(this.cav, "touchpointerup")) {
            this.cav = "touchend";
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.cav, "touchend") && !TextUtils.equals(this.cav, "touchcancel")) {
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
                this.caw.add(b(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.caw.add(b(motionEvent, i));
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public C0305a b(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        C0305a c0305a = new C0305a();
        c0305a.identifier = pointerId;
        c0305a.x = motionEvent.getX(i);
        c0305a.y = motionEvent.getY(i);
        c0305a.cay = (motionEvent.getRawX() + c0305a.x) - motionEvent.getX();
        c0305a.caz = (motionEvent.getRawY() + c0305a.y) - motionEvent.getY();
        c0305a.caA = motionEvent.getPressure(i);
        return c0305a;
    }

    public JSONObject ahG() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.mTouchList.isEmpty()) {
                for (C0305a c0305a : this.mTouchList) {
                    if (c0305a != null) {
                        jSONArray.put(c0305a.ahH());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.caw.isEmpty()) {
                for (C0305a c0305a2 : this.caw) {
                    if (c0305a2 != null) {
                        jSONArray2.put(c0305a2.ahH());
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
    public class C0305a {
        private float caA;
        private float cay;
        private float caz;
        private int identifier;
        private float x;
        private float y;

        private C0305a() {
        }

        JSONObject ahH() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Config.EVENT_HEAT_X, af.px2dpFloat(this.x));
                jSONObject.put("y", af.px2dpFloat(this.y));
                jSONObject.put("clientX", af.px2dpFloat(this.cay - a.this.cax[0]));
                jSONObject.put("clientY", af.px2dpFloat(this.caz - a.this.cax[1]));
                jSONObject.put("identifier", this.identifier);
                jSONObject.put("force", this.caA);
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
    }
}
