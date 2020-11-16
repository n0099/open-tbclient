package com.baidu.ar.statistic.performance;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
class a {
    String wt;
    double wu;
    long wv;
    long ww;
    long wx;
    BlockingQueue<C0087a> wy = new LinkedBlockingQueue();

    /* renamed from: com.baidu.ar.statistic.performance.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    static class C0087a {
        long wA;
        long wB;
        BlockingQueue<C0088a> wC = new LinkedBlockingQueue();
        int wz;

        /* renamed from: com.baidu.ar.statistic.performance.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        static class C0088a {
            int count;
            String name;
            String wD;
            long wE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject gt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("case_id", this.wt);
            jSONObject.put("cpu_rate", String.valueOf(this.wu));
            jSONObject.put("cpu_tc", String.valueOf(this.wv));
            jSONObject.put("mem_total", String.valueOf(this.ww));
            jSONObject.put("mem_used", String.valueOf(this.wx));
            JSONArray jSONArray = new JSONArray();
            for (C0087a c0087a : this.wy) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("frame_index", c0087a.wz);
                    jSONObject2.put("frame_in", c0087a.wA);
                    jSONObject2.put("frame_out", c0087a.wB);
                    JSONArray jSONArray2 = new JSONArray();
                    for (C0087a.C0088a c0088a : c0087a.wC) {
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("name", c0088a.name);
                            jSONObject3.put("func", c0088a.wD);
                            jSONObject3.put("time_cost", c0088a.wE);
                            jSONObject3.put("count", c0088a.count);
                            jSONArray2.put(jSONObject3);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    jSONObject2.put("algo_data", jSONArray2);
                    jSONArray.put(jSONObject2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            jSONObject.put("frame_data", jSONArray);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gu() {
        this.wt = null;
        this.wu = 0.0d;
        this.wv = 0L;
        this.ww = 0L;
        this.wx = 0L;
        this.wy = new LinkedBlockingQueue();
    }
}
