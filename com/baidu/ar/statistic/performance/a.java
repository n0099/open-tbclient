package com.baidu.ar.statistic.performance;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
class a {
    String xh;
    double xi;
    long xj;
    long xk;
    long xl;
    BlockingQueue<C0081a> xm = new LinkedBlockingQueue();

    /* renamed from: com.baidu.ar.statistic.performance.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class C0081a {
        int xn;
        long xo;
        long xp;
        BlockingQueue<C0082a> xq = new LinkedBlockingQueue();

        /* renamed from: com.baidu.ar.statistic.performance.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        static class C0082a {
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
            for (C0081a c0081a : this.xm) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("frame_index", c0081a.xn);
                    jSONObject2.put("frame_in", c0081a.xo);
                    jSONObject2.put("frame_out", c0081a.xp);
                    JSONArray jSONArray2 = new JSONArray();
                    for (C0081a.C0082a c0082a : c0081a.xq) {
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("name", c0082a.name);
                            jSONObject3.put("func", c0082a.xr);
                            jSONObject3.put("time_cost", c0082a.xs);
                            jSONObject3.put("count", c0082a.count);
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
