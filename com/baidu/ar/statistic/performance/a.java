package com.baidu.ar.statistic.performance;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
class a {
    String xh;
    double xi;
    long xj;
    long xk;
    long xl;
    BlockingQueue<C0088a> xm = new LinkedBlockingQueue();

    /* renamed from: com.baidu.ar.statistic.performance.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    static class C0088a {
        int xn;
        long xo;
        long xp;
        BlockingQueue<C0089a> xq = new LinkedBlockingQueue();

        /* renamed from: com.baidu.ar.statistic.performance.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        static class C0089a {
            int count;
            String name;
            String xr;
            long xs;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject gt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("case_id", this.xh);
            jSONObject.put("cpu_rate", String.valueOf(this.xi));
            jSONObject.put("cpu_tc", String.valueOf(this.xj));
            jSONObject.put("mem_total", String.valueOf(this.xk));
            jSONObject.put("mem_used", String.valueOf(this.xl));
            JSONArray jSONArray = new JSONArray();
            for (C0088a c0088a : this.xm) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("frame_index", c0088a.xn);
                    jSONObject2.put("frame_in", c0088a.xo);
                    jSONObject2.put("frame_out", c0088a.xp);
                    JSONArray jSONArray2 = new JSONArray();
                    for (C0088a.C0089a c0089a : c0088a.xq) {
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("name", c0089a.name);
                            jSONObject3.put("func", c0089a.xr);
                            jSONObject3.put("time_cost", c0089a.xs);
                            jSONObject3.put("count", c0089a.count);
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
        this.xh = null;
        this.xi = 0.0d;
        this.xj = 0L;
        this.xk = 0L;
        this.xl = 0L;
        this.xm = new LinkedBlockingQueue();
    }
}
