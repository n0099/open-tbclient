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
    private int[] dsA;
    private String dsx;
    private List<C0469a> dsy;
    private List<C0469a> dsz;
    private long mTimeStamp;

    public a(MotionEvent motionEvent) {
        this.dsx = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.dsy = new ArrayList();
        this.dsz = new ArrayList();
        this.dsA = new int[2];
        a(motionEvent, "");
    }

    public a(MotionEvent motionEvent, String str) {
        this.dsx = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.dsy = new ArrayList();
        this.dsz = new ArrayList();
        this.dsA = new int[2];
        a(motionEvent, str);
    }

    public String aJz() {
        return this.dsx;
    }

    public void h(int[] iArr) {
        this.dsA = iArr;
        if (DEBUG) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.dsx = "touchstart";
                A(motionEvent);
                break;
            case 1:
                this.dsx = "touchend";
                A(motionEvent);
                break;
            case 2:
                this.dsx = "touchmove";
                A(motionEvent);
                break;
            case 3:
                this.dsx = "touchcancel";
                A(motionEvent);
                break;
            case 4:
            default:
                this.dsx = BdStatsConstant.StatsType.ERROR;
                break;
            case 5:
                this.dsx = "touchpointerdown";
                A(motionEvent);
                break;
            case 6:
                this.dsx = "touchpointerup";
                A(motionEvent);
                break;
        }
        this.mTimeStamp = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.dsx = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.dsx, "touchpointerdown")) {
            this.dsx = "touchstart";
        }
        if (TextUtils.equals(this.dsx, "touchpointerup")) {
            this.dsx = "touchend";
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.dsx, "touchend") && !TextUtils.equals(this.dsx, "touchcancel")) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                        this.dsy.add(b(motionEvent, i));
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
                this.dsz.add(b(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.dsz.add(b(motionEvent, i));
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public C0469a b(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        C0469a c0469a = new C0469a();
        c0469a.identifier = pointerId;
        c0469a.x = motionEvent.getX(i);
        c0469a.y = motionEvent.getY(i);
        c0469a.dsB = (motionEvent.getRawX() + c0469a.x) - motionEvent.getX();
        c0469a.dsC = (motionEvent.getRawY() + c0469a.y) - motionEvent.getY();
        c0469a.dsD = motionEvent.getPressure(i);
        return c0469a;
    }

    public JSONObject aJA() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.dsy.isEmpty()) {
                for (C0469a c0469a : this.dsy) {
                    if (c0469a != null) {
                        jSONArray.put(c0469a.aJB());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.dsz.isEmpty()) {
                for (C0469a c0469a2 : this.dsz) {
                    if (c0469a2 != null) {
                        jSONArray2.put(c0469a2.aJB());
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
    public class C0469a {
        private float dsB;
        private float dsC;
        private float dsD;
        private int identifier;
        private float x;
        private float y;

        private C0469a() {
        }

        JSONObject aJB() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", ah.px2dpFloat(this.x));
                jSONObject.put("y", ah.px2dpFloat(this.y));
                jSONObject.put("clientX", ah.px2dpFloat(this.dsB - a.this.dsA[0]));
                jSONObject.put("clientY", ah.px2dpFloat(this.dsC - a.this.dsA[1]));
                jSONObject.put("identifier", this.identifier);
                jSONObject.put("force", this.dsD);
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
    }
}
