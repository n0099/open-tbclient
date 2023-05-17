package com.baidu.ar.statistic.performance;

import com.baidu.webkit.sdk.WebChromeClient;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public String xh;
    public double xi;
    public long xj;
    public long xk;
    public long xl;
    public BlockingQueue<C0062a> xm = new LinkedBlockingQueue();

    /* renamed from: com.baidu.ar.statistic.performance.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0062a {
        public int xn;
        public long xo;
        public long xp;
        public BlockingQueue<C0063a> xq = new LinkedBlockingQueue();

        /* renamed from: com.baidu.ar.statistic.performance.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0063a {
            public int count;
            public String name;
            public String xr;
            public long xs;
        }
    }

    public JSONObject gt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("case_id", this.xh);
            jSONObject.put("cpu_rate", String.valueOf(this.xi));
            jSONObject.put("cpu_tc", String.valueOf(this.xj));
            jSONObject.put("mem_total", String.valueOf(this.xk));
            jSONObject.put("mem_used", String.valueOf(this.xl));
            JSONArray jSONArray = new JSONArray();
            for (C0062a c0062a : this.xm) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("frame_index", c0062a.xn);
                    jSONObject2.put("frame_in", c0062a.xo);
                    jSONObject2.put("frame_out", c0062a.xp);
                    JSONArray jSONArray2 = new JSONArray();
                    for (C0062a.C0063a c0063a : c0062a.xq) {
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("name", c0063a.name);
                            jSONObject3.put(WebChromeClient.KEY_FUNCTION_NAME, c0063a.xr);
                            jSONObject3.put("time_cost", c0063a.xs);
                            jSONObject3.put("count", c0063a.count);
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

    public void gu() {
        this.xh = null;
        this.xi = 0.0d;
        this.xj = 0L;
        this.xk = 0L;
        this.xl = 0L;
        this.xm = new LinkedBlockingQueue();
    }
}
