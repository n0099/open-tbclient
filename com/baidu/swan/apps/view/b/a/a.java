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
    private String dGN;
    private List<C0495a> dGO;
    private List<C0495a> dGP;
    private int[] dGQ;
    private long mTimeStamp;

    public a(MotionEvent motionEvent) {
        this.dGN = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.dGO = new ArrayList();
        this.dGP = new ArrayList();
        this.dGQ = new int[2];
        a(motionEvent, "");
    }

    public a(MotionEvent motionEvent, String str) {
        this.dGN = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.dGO = new ArrayList();
        this.dGP = new ArrayList();
        this.dGQ = new int[2];
        a(motionEvent, str);
    }

    public String aNT() {
        return this.dGN;
    }

    public void h(int[] iArr) {
        this.dGQ = iArr;
        if (DEBUG) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.dGN = "touchstart";
                A(motionEvent);
                break;
            case 1:
                this.dGN = "touchend";
                A(motionEvent);
                break;
            case 2:
                this.dGN = "touchmove";
                A(motionEvent);
                break;
            case 3:
                this.dGN = "touchcancel";
                A(motionEvent);
                break;
            case 4:
            default:
                this.dGN = BdStatsConstant.StatsType.ERROR;
                break;
            case 5:
                this.dGN = "touchpointerdown";
                A(motionEvent);
                break;
            case 6:
                this.dGN = "touchpointerup";
                A(motionEvent);
                break;
        }
        this.mTimeStamp = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.dGN = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.dGN, "touchpointerdown")) {
            this.dGN = "touchstart";
        }
        if (TextUtils.equals(this.dGN, "touchpointerup")) {
            this.dGN = "touchend";
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.dGN, "touchend") && !TextUtils.equals(this.dGN, "touchcancel")) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                        this.dGO.add(b(motionEvent, i));
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
                this.dGP.add(b(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.dGP.add(b(motionEvent, i));
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public C0495a b(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        C0495a c0495a = new C0495a();
        c0495a.identifier = pointerId;
        c0495a.x = motionEvent.getX(i);
        c0495a.y = motionEvent.getY(i);
        c0495a.dGR = (motionEvent.getRawX() + c0495a.x) - motionEvent.getX();
        c0495a.dGS = (motionEvent.getRawY() + c0495a.y) - motionEvent.getY();
        c0495a.dGT = motionEvent.getPressure(i);
        return c0495a;
    }

    public JSONObject aNU() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.dGO.isEmpty()) {
                for (C0495a c0495a : this.dGO) {
                    if (c0495a != null) {
                        jSONArray.put(c0495a.aNV());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.dGP.isEmpty()) {
                for (C0495a c0495a2 : this.dGP) {
                    if (c0495a2 != null) {
                        jSONArray2.put(c0495a2.aNV());
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
    public class C0495a {
        private float dGR;
        private float dGS;
        private float dGT;
        private int identifier;
        private float x;
        private float y;

        private C0495a() {
        }

        JSONObject aNV() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", ah.px2dpFloat(this.x));
                jSONObject.put("y", ah.px2dpFloat(this.y));
                jSONObject.put("clientX", ah.px2dpFloat(this.dGR - a.this.dGQ[0]));
                jSONObject.put("clientY", ah.px2dpFloat(this.dGS - a.this.dGQ[1]));
                jSONObject.put("identifier", this.identifier);
                jSONObject.put("force", this.dGT);
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
    }
}
