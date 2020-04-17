package com.baidu.ar.statistic.performance;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class a {
    String vq;
    double vr;
    long vs;
    long vt;
    long vu;
    BlockingQueue<C0063a> vv = new LinkedBlockingQueue();

    /* renamed from: com.baidu.ar.statistic.performance.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class C0063a {
        int vw;
        long vx;
        long vy;
        BlockingQueue<C0064a> vz = new LinkedBlockingQueue();

        /* renamed from: com.baidu.ar.statistic.performance.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static class C0064a {
            int count;
            String name;
            String vA;
            long vB;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject eP() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("case_id", this.vq);
            jSONObject.put("cpu_rate", String.valueOf(this.vr));
            jSONObject.put("cpu_tc", String.valueOf(this.vs));
            jSONObject.put("mem_total", String.valueOf(this.vt));
            jSONObject.put("mem_used", String.valueOf(this.vu));
            JSONArray jSONArray = new JSONArray();
            for (C0063a c0063a : this.vv) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("frame_index", c0063a.vw);
                    jSONObject2.put("frame_in", c0063a.vx);
                    jSONObject2.put("frame_out", c0063a.vy);
                    JSONArray jSONArray2 = new JSONArray();
                    for (C0063a.C0064a c0064a : c0063a.vz) {
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("name", c0064a.name);
                            jSONObject3.put("func", c0064a.vA);
                            jSONObject3.put("time_cost", c0064a.vB);
                            jSONObject3.put("count", c0064a.count);
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
    public void eQ() {
        this.vq = null;
        this.vr = 0.0d;
        this.vs = 0L;
        this.vt = 0L;
        this.vu = 0L;
        this.vv = new LinkedBlockingQueue();
    }
}
