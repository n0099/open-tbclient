package com.baidu.ar.statistic.performance;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class a {
    String vQ;
    double vR;
    long vS;
    long vT;
    long vU;
    BlockingQueue<C0087a> vV = new LinkedBlockingQueue();

    /* renamed from: com.baidu.ar.statistic.performance.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class C0087a {
        int vW;
        long vX;
        long vY;
        BlockingQueue<C0088a> vZ = new LinkedBlockingQueue();

        /* renamed from: com.baidu.ar.statistic.performance.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static class C0088a {
            int count;
            String name;
            String wa;
            long wb;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject ff() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("case_id", this.vQ);
            jSONObject.put("cpu_rate", String.valueOf(this.vR));
            jSONObject.put("cpu_tc", String.valueOf(this.vS));
            jSONObject.put("mem_total", String.valueOf(this.vT));
            jSONObject.put("mem_used", String.valueOf(this.vU));
            JSONArray jSONArray = new JSONArray();
            for (C0087a c0087a : this.vV) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("frame_index", c0087a.vW);
                    jSONObject2.put("frame_in", c0087a.vX);
                    jSONObject2.put("frame_out", c0087a.vY);
                    JSONArray jSONArray2 = new JSONArray();
                    for (C0087a.C0088a c0088a : c0087a.vZ) {
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("name", c0088a.name);
                            jSONObject3.put("func", c0088a.wa);
                            jSONObject3.put("time_cost", c0088a.wb);
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
    public void fg() {
        this.vQ = null;
        this.vR = 0.0d;
        this.vS = 0L;
        this.vT = 0L;
        this.vU = 0L;
        this.vV = new LinkedBlockingQueue();
    }
}
