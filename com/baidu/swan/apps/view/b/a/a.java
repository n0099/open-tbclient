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
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String dAV;
    private List<C0483a> dAW;
    private List<C0483a> dAX;
    private int[] dAY;
    private long mTimeStamp;

    public a(MotionEvent motionEvent) {
        this.dAV = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.dAW = new ArrayList();
        this.dAX = new ArrayList();
        this.dAY = new int[2];
        a(motionEvent, "");
    }

    public a(MotionEvent motionEvent, String str) {
        this.dAV = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.dAW = new ArrayList();
        this.dAX = new ArrayList();
        this.dAY = new int[2];
        a(motionEvent, str);
    }

    public String aLt() {
        return this.dAV;
    }

    public void h(int[] iArr) {
        this.dAY = iArr;
        if (DEBUG) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.dAV = "touchstart";
                A(motionEvent);
                break;
            case 1:
                this.dAV = "touchend";
                A(motionEvent);
                break;
            case 2:
                this.dAV = "touchmove";
                A(motionEvent);
                break;
            case 3:
                this.dAV = "touchcancel";
                A(motionEvent);
                break;
            case 4:
            default:
                this.dAV = BdStatsConstant.StatsType.ERROR;
                break;
            case 5:
                this.dAV = "touchpointerdown";
                A(motionEvent);
                break;
            case 6:
                this.dAV = "touchpointerup";
                A(motionEvent);
                break;
        }
        this.mTimeStamp = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.dAV = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.dAV, "touchpointerdown")) {
            this.dAV = "touchstart";
        }
        if (TextUtils.equals(this.dAV, "touchpointerup")) {
            this.dAV = "touchend";
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.dAV, "touchend") && !TextUtils.equals(this.dAV, "touchcancel")) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                        this.dAW.add(b(motionEvent, i));
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
                this.dAX.add(b(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.dAX.add(b(motionEvent, i));
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public C0483a b(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        C0483a c0483a = new C0483a();
        c0483a.identifier = pointerId;
        c0483a.x = motionEvent.getX(i);
        c0483a.y = motionEvent.getY(i);
        c0483a.dAZ = (motionEvent.getRawX() + c0483a.x) - motionEvent.getX();
        c0483a.dBa = (motionEvent.getRawY() + c0483a.y) - motionEvent.getY();
        c0483a.dBb = motionEvent.getPressure(i);
        return c0483a;
    }

    public JSONObject aLu() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.dAW.isEmpty()) {
                for (C0483a c0483a : this.dAW) {
                    if (c0483a != null) {
                        jSONArray.put(c0483a.aLv());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.dAX.isEmpty()) {
                for (C0483a c0483a2 : this.dAX) {
                    if (c0483a2 != null) {
                        jSONArray2.put(c0483a2.aLv());
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
    public class C0483a {
        private float dAZ;
        private float dBa;
        private float dBb;
        private int identifier;
        private float x;
        private float y;

        private C0483a() {
        }

        JSONObject aLv() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", ah.px2dpFloat(this.x));
                jSONObject.put("y", ah.px2dpFloat(this.y));
                jSONObject.put("clientX", ah.px2dpFloat(this.dAZ - a.this.dAY[0]));
                jSONObject.put("clientY", ah.px2dpFloat(this.dBa - a.this.dAY[1]));
                jSONObject.put("identifier", this.identifier);
                jSONObject.put("force", this.dBb);
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
    }
}
