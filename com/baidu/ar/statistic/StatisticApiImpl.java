package com.baidu.ar.statistic;

import android.content.Context;
import android.os.AsyncTask;
import android.os.HandlerThread;
import com.baidu.ar.statistic.l;
import java.lang.Thread;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class StatisticApiImpl implements g, l.a {
    private d uy;
    private HandlerThread vf;
    private c vg;
    private Thread vh;
    private h vi;
    private volatile k vj;

    public StatisticApiImpl(Context context, HandlerThread handlerThread) {
        this.uy = new d(context, "ar_stats_local.json", 100, 40);
        d dVar = new d(context, "ar_stats_pfm_local.json", 200, 0);
        this.vj = new k(dVar, 20, 200);
        a(handlerThread, new b(context, this.uy, q.vk, r.eN(), this.vj));
        a(context, dVar);
        this.vg.a(1, null);
        n(context);
    }

    private void a(Context context, d dVar) {
        this.vi = new h(context, this.uy, new i[]{new i(this.uy, 10, new j(), true), new m(dVar, 20, new n(), false)});
        this.vh = new Thread(this.vi, "StatsLogSendThd");
        this.vh.start();
    }

    private void a(HandlerThread handlerThread, b bVar) {
        if (handlerThread == null) {
            this.vf = new HandlerThread("StatsEventThd", 10);
            this.vf.start();
        } else {
            this.vf = handlerThread;
            if (this.vf.getState() == Thread.State.NEW) {
                this.vf.start();
            }
        }
        this.vg = new c(this.vf.getLooper(), bVar);
    }

    private void n(Context context) {
        new l(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "");
    }

    public void doRelease() {
        synchronized (this) {
            if (this.vf != null) {
                this.vf.quitSafely();
            }
            if (this.vi != null) {
                this.vi.shutdown();
            }
            if (this.vh != null) {
                synchronized (this.uy) {
                    if (this.uy.isEmpty()) {
                        this.vh.interrupt();
                    }
                }
            }
        }
        a.release();
    }

    @Override // com.baidu.ar.statistic.g
    public boolean isAllowPerformanceEvent(String str) {
        return this.vj.aB(str);
    }

    @Override // com.baidu.ar.statistic.g
    public void onEvent(String str, String str2) {
        a ar = a.ar(str);
        ar.c("event_param", str2);
        this.vg.a(2, ar);
    }

    @Override // com.baidu.ar.statistic.g
    public void onEvent(String str, Map<String, String> map) {
        a ar = a.ar(str);
        ar.a(map);
        this.vg.a(2, ar);
    }

    @Override // com.baidu.ar.statistic.g
    public void onEventDebounce(String str, long j, String str2) {
        a ar = a.ar(str);
        ar.c("_db_period", Long.valueOf(j));
        ar.c("event_param", str2);
        this.vg.a(6, ar);
    }

    @Override // com.baidu.ar.statistic.g
    public void onEventDebounce(String str, long j, Map<String, String> map) {
        a ar = a.ar(str);
        ar.a(map);
        ar.c("_db_period", Long.valueOf(j));
        this.vg.a(6, ar);
    }

    @Override // com.baidu.ar.statistic.g
    public void onEventEnd(String str) {
        this.vg.a(5, a.ar(str));
    }

    @Override // com.baidu.ar.statistic.g
    public void onEventStart(String str) {
        this.vg.a(4, a.ar(str));
    }

    @Override // com.baidu.ar.statistic.g
    public void onEventStatus(String str, String str2, boolean z) {
        a ar = a.ar(str);
        ar.c("__stt", z ? "1" : "0");
        ar.c("__falseev", str2);
        this.vg.a(3, ar);
    }

    @Override // com.baidu.ar.statistic.g
    public void onPerformance(String str, Map<String, String> map) {
        synchronized (this.vj) {
            if (this.vj.aB(str)) {
                a ar = a.ar(str);
                ar.a(map);
                this.vg.a(20, ar);
            }
        }
    }

    @Override // com.baidu.ar.statistic.g
    public void onPerformance(String str, JSONObject jSONObject) {
        synchronized (this.vj) {
            if (this.vj.aB(str)) {
                a ar = a.ar(str);
                ar.c("data", jSONObject);
                this.vg.a(20, ar);
            }
        }
    }

    @Override // com.baidu.ar.statistic.l.a
    public void onPerformanceRequestFinished(List<String> list) {
        this.vg.a(21, list);
    }

    @Override // com.baidu.ar.statistic.g
    public void pause() {
        this.vg.a(97, Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.baidu.ar.statistic.g
    public void release() {
        this.vg.a(99, this);
    }

    @Override // com.baidu.ar.statistic.g
    public void resume() {
        this.vg.a(98, Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.baidu.ar.statistic.g
    public void setPubParam(String str, String str2) {
        this.vg.setPubParam(str, str2);
    }

    @Override // com.baidu.ar.statistic.g
    public void setPubParams(Map<String, String> map) {
        this.vg.setPubParams(map);
    }
}
