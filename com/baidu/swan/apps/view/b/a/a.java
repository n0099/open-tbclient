package com.baidu.swan.apps.view.b.a;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.aq.ai;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cVh;
    private List<C0411a> cVi;
    private List<C0411a> cVj;
    private int[] cVk;
    private long mTimeStamp;

    public a(MotionEvent motionEvent) {
        this.cVh = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.cVi = new ArrayList();
        this.cVj = new ArrayList();
        this.cVk = new int[2];
        a(motionEvent, "");
    }

    public a(MotionEvent motionEvent, String str) {
        this.cVh = BdStatsConstant.StatsType.ERROR;
        this.mTimeStamp = 0L;
        this.cVi = new ArrayList();
        this.cVj = new ArrayList();
        this.cVk = new int[2];
        a(motionEvent, str);
    }

    public String axY() {
        return this.cVh;
    }

    public void g(int[] iArr) {
        this.cVk = iArr;
        if (DEBUG) {
            Log.d("SwanAppTouchHelper", "setWebViewPosition y = " + iArr[1] + ";x = " + iArr[0]);
        }
    }

    private void a(MotionEvent motionEvent, String str) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.cVh = "touchstart";
                l(motionEvent);
                break;
            case 1:
                this.cVh = "touchend";
                l(motionEvent);
                break;
            case 2:
                this.cVh = "touchmove";
                l(motionEvent);
                break;
            case 3:
                this.cVh = "touchcancel";
                l(motionEvent);
                break;
            case 4:
            default:
                this.cVh = BdStatsConstant.StatsType.ERROR;
                break;
            case 5:
                this.cVh = "touchpointerdown";
                l(motionEvent);
                break;
            case 6:
                this.cVh = "touchpointerup";
                l(motionEvent);
                break;
        }
        this.mTimeStamp = motionEvent.getEventTime();
        if (!TextUtils.isEmpty(str)) {
            this.cVh = str;
        }
        onTouch(motionEvent);
        if (TextUtils.equals(this.cVh, "touchpointerdown")) {
            this.cVh = "touchstart";
        }
        if (TextUtils.equals(this.cVh, "touchpointerup")) {
            this.cVh = "touchend";
        }
    }

    private void onTouch(MotionEvent motionEvent) {
        if (!TextUtils.equals(this.cVh, "touchend") && !TextUtils.equals(this.cVh, "touchcancel")) {
            try {
                int pointerCount = motionEvent.getPointerCount();
                for (int i = 0; i < pointerCount; i++) {
                    if (motionEvent.getActionMasked() != 6 || motionEvent.getActionIndex() != i) {
                        this.cVi.add(b(motionEvent, i));
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
                this.cVj.add(b(motionEvent, motionEvent.getActionIndex()));
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.cVj.add(b(motionEvent, i));
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public C0411a b(MotionEvent motionEvent, int i) {
        int pointerId = motionEvent.getPointerId(i);
        C0411a c0411a = new C0411a();
        c0411a.identifier = pointerId;
        c0411a.x = motionEvent.getX(i);
        c0411a.y = motionEvent.getY(i);
        c0411a.cVl = (motionEvent.getRawX() + c0411a.x) - motionEvent.getX();
        c0411a.cVm = (motionEvent.getRawY() + c0411a.y) - motionEvent.getY();
        c0411a.cVn = motionEvent.getPressure(i);
        return c0411a;
    }

    public JSONObject axZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            if (!this.cVi.isEmpty()) {
                for (C0411a c0411a : this.cVi) {
                    if (c0411a != null) {
                        jSONArray.put(c0411a.aya());
                    }
                }
            }
            JSONArray jSONArray2 = new JSONArray();
            if (!this.cVj.isEmpty()) {
                for (C0411a c0411a2 : this.cVj) {
                    if (c0411a2 != null) {
                        jSONArray2.put(c0411a2.aya());
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
    /* loaded from: classes7.dex */
    public class C0411a {
        private float cVl;
        private float cVm;
        private float cVn;
        private int identifier;
        private float x;
        private float y;

        private C0411a() {
        }

        JSONObject aya() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Config.EVENT_HEAT_X, ai.px2dpFloat(this.x));
                jSONObject.put("y", ai.px2dpFloat(this.y));
                jSONObject.put("clientX", ai.px2dpFloat(this.cVl - a.this.cVk[0]));
                jSONObject.put("clientY", ai.px2dpFloat(this.cVm - a.this.cVk[1]));
                jSONObject.put("identifier", this.identifier);
                jSONObject.put("force", this.cVn);
            } catch (JSONException e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
    }
}
