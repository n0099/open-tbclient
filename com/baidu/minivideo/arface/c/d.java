package com.baidu.minivideo.arface.c;

import android.text.TextUtils;
import java.text.DecimalFormat;
import java.util.Vector;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class d {
    private String TAG = "TimerArFrameStatistician";
    private Vector<Integer> clA = new Vector<>();
    private long clB = 0;
    private Vector<Integer> clC = new Vector<>();
    private long mLastTime;

    public void onFrameAvailable() {
        if (this.mLastTime <= 0) {
            this.mLastTime = System.currentTimeMillis();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int i = (int) (currentTimeMillis - this.mLastTime);
        if (i >= 0) {
            this.clA.add(Integer.valueOf(i));
            this.mLastTime = currentTimeMillis;
        }
    }

    public void onRenderStarted() {
        this.clB = System.currentTimeMillis();
    }

    public void onRenderFinished() {
        int currentTimeMillis;
        if (this.clB > 0 && (currentTimeMillis = (int) (System.currentTimeMillis() - this.clB)) >= 0) {
            this.clC.add(Integer.valueOf(currentTimeMillis));
        }
    }

    public String ei(boolean z) {
        if (this.clA == null || this.clA.size() == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        float f = 0.0f;
        int size = this.clA.size();
        int i = 0;
        while (i < size) {
            Integer num = this.clA.get(i);
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
        if (this.clC == null || this.clC.size() == 0) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        float f = 0.0f;
        int size = this.clC.size();
        int i = 0;
        while (i < size) {
            Integer num = this.clC.get(i);
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
        if (this.clA == null || this.clA.size() == 0) {
            return 0;
        }
        int size = this.clA.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            Integer num = this.clA.get(i);
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
        this.clB = 0L;
        this.clA.clear();
        this.clC.clear();
    }
}
