package com.baidu.ar.statistic;

import android.content.Context;
import android.os.AsyncTask;
import android.os.HandlerThread;
import com.baidu.ar.statistic.l;
import java.lang.Thread;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class StatisticApiImpl implements g, l.a {
    private d vB;
    private HandlerThread wi;
    private c wj;
    private Thread wk;
    private h wl;
    private volatile k wm;

    public StatisticApiImpl(Context context, HandlerThread handlerThread) {
        this.vB = new d(context, "ar_stats_local.json", 100, 40);
        d dVar = new d(context, "ar_stats_pfm_local.json", 200, 0);
        this.wm = new k(dVar, 20, 200);
        a(handlerThread, new b(context, this.vB, q.wn, r.gr(), this.wm));
        a(context, dVar);
        this.wj.a(1, null);
        q(context);
    }

    private void a(Context context, d dVar) {
        this.wl = new h(context, this.vB, new i[]{new i(this.vB, 10, new j(), true), new m(dVar, 20, new n(), false)});
        this.wk = new Thread(this.wl, "StatsLogSendThd");
        this.wk.start();
    }

    private void a(HandlerThread handlerThread, b bVar) {
        if (handlerThread == null) {
            this.wi = new HandlerThread("StatsEventThd", 10);
            this.wi.start();
        } else {
            this.wi = handlerThread;
            if (this.wi.getState() == Thread.State.NEW) {
                this.wi.start();
            }
        }
        this.wj = new c(this.wi.getLooper(), bVar);
    }

    private void q(Context context) {
        new l(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "");
    }

    public void doRelease() {
        synchronized (this) {
            if (this.wi != null) {
                this.wi.quitSafely();
            }
            if (this.wl != null) {
                this.wl.shutdown();
            }
            if (this.wk != null) {
                synchronized (this.vB) {
                    if (this.vB.isEmpty()) {
                        this.wk.interrupt();
                    }
                }
            }
        }
        a.release();
    }

    @Override // com.baidu.ar.statistic.g
    public boolean isAllowPerformanceEvent(String str) {
        return this.wm.aG(str);
    }

    @Override // com.baidu.ar.statistic.g
    public void onEvent(String str, String str2) {
        a aw = a.aw(str);
        aw.c("event_param", str2);
        this.wj.a(2, aw);
    }

    @Override // com.baidu.ar.statistic.g
    public void onEvent(String str, Map<String, String> map) {
        a aw = a.aw(str);
        aw.a(map);
        this.wj.a(2, aw);
    }

    @Override // com.baidu.ar.statistic.g
    public void onEventDebounce(String str, long j, String str2) {
        a aw = a.aw(str);
        aw.c("_db_period", Long.valueOf(j));
        aw.c("event_param", str2);
        this.wj.a(6, aw);
    }

    @Override // com.baidu.ar.statistic.g
    public void onEventDebounce(String str, long j, Map<String, String> map) {
        a aw = a.aw(str);
        aw.a(map);
        aw.c("_db_period", Long.valueOf(j));
        this.wj.a(6, aw);
    }

    @Override // com.baidu.ar.statistic.g
    public void onEventEnd(String str) {
        this.wj.a(5, a.aw(str));
    }

    @Override // com.baidu.ar.statistic.g
    public void onEventStart(String str) {
        this.wj.a(4, a.aw(str));
    }

    @Override // com.baidu.ar.statistic.g
    public void onEventStatus(String str, String str2, boolean z) {
        a aw = a.aw(str);
        aw.c("__stt", z ? "1" : "0");
        aw.c("__falseev", str2);
        this.wj.a(3, aw);
    }

    @Override // com.baidu.ar.statistic.g
    public void onPerformance(String str, Map<String, String> map) {
        synchronized (this.wm) {
            if (this.wm.aG(str)) {
                a aw = a.aw(str);
                aw.a(map);
                this.wj.a(20, aw);
            }
        }
    }

    @Override // com.baidu.ar.statistic.g
    public void onPerformance(String str, JSONObject jSONObject) {
        synchronized (this.wm) {
            if (this.wm.aG(str)) {
                a aw = a.aw(str);
                aw.c("data", jSONObject);
                this.wj.a(20, aw);
            }
        }
    }

    @Override // com.baidu.ar.statistic.l.a
    public void onPerformanceRequestFinished(List<String> list) {
        this.wj.a(21, list);
    }

    @Override // com.baidu.ar.statistic.g
    public void pause() {
        this.wj.a(97, Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.baidu.ar.statistic.g
    public void release() {
        this.wj.a(99, this);
    }

    @Override // com.baidu.ar.statistic.g
    public void resume() {
        this.wj.a(98, Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.baidu.ar.statistic.g
    public void setPubParam(String str, String str2) {
        this.wj.setPubParam(str, str2);
    }

    @Override // com.baidu.ar.statistic.g
    public void setPubParams(Map<String, String> map) {
        this.wj.setPubParams(map);
    }
}
