package com.baidu.minivideo.arface.c;

import android.text.TextUtils;
import java.text.DecimalFormat;
import java.util.Vector;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class d {
    private String TAG = "TimerArFrameStatistician";
    private Vector<Integer> cnb = new Vector<>();
    private long cnc = 0;
    private Vector<Integer> cnd = new Vector<>();
    private long mLastTime;

    public void onFrameAvailable() {
        if (this.mLastTime <= 0) {
            this.mLastTime = System.currentTimeMillis();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int i = (int) (currentTimeMillis - this.mLastTime);
        if (i >= 0) {
            this.cnb.add(Integer.valueOf(i));
            this.mLastTime = currentTimeMillis;
        }
    }

    public void onRenderStarted() {
        this.cnc = System.currentTimeMillis();
    }

    public void onRenderFinished() {
        int currentTimeMillis;
        if (this.cnc > 0 && (currentTimeMillis = (int) (System.currentTimeMillis() - this.cnc)) >= 0) {
            this.cnd.add(Integer.valueOf(currentTimeMillis));
        }
    }

    public String ei(boolean z) {
        if (this.cnb == null || this.cnb.size() == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        float f = 0.0f;
        int size = this.cnb.size();
        int i = 0;
        while (i < size) {
            Integer num = this.cnb.get(i);
            if (num != null) {
                f += num.intValue();
                jSONArray.put(num);
            }
            i++;
            f = f;
        }
        if (z) {
            String jSONArray2 = jSONArray.toString();
            return TextUtils.isEmpty(jSONArray2) ? "" : jSONArray2;
        }
        return new DecimalFormat(".0").format(f / size);
    }

    public String ej(boolean z) {
        if (this.cnd == null || this.cnd.size() == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        float f = 0.0f;
        int size = this.cnd.size();
        int i = 0;
        while (i < size) {
            Integer num = this.cnd.get(i);
            if (num != null) {
                f += num.intValue();
                jSONArray.put(num);
            }
            i++;
            f = f;
        }
        if (z) {
            String jSONArray2 = jSONArray.toString();
            return TextUtils.isEmpty(jSONArray2) ? "" : jSONArray2;
        }
        return new DecimalFormat(".0").format(f / size);
    }

    public int getFps() {
        if (this.cnb == null || this.cnb.size() == 0) {
            return 0;
        }
        int size = this.cnb.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            Integer num = this.cnb.get(i);
            i++;
            i2 = num == null ? i2 : num.intValue() + i2;
        }
        float f = (i2 * 1.0f) / size;
        if (f == 0.0f) {
            return 0;
        }
        return Math.round(1000.0f / f);
    }

    public void resetData() {
        this.mLastTime = 0L;
        this.cnc = 0L;
        this.cnb.clear();
        this.cnd.clear();
    }
}
