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
    private d uY;
    private HandlerThread vF;
    private c vG;
    private Thread vH;
    private h vI;
    private volatile k vJ;

    public StatisticApiImpl(Context context, HandlerThread handlerThread) {
        this.uY = new d(context, "ar_stats_local.json", 100, 40);
        d dVar = new d(context, "ar_stats_pfm_local.json", 200, 0);
        this.vJ = new k(dVar, 20, 200);
        a(handlerThread, new b(context, this.uY, q.vK, r.fd(), this.vJ));
        a(context, dVar);
        this.vG.a(1, null);
        p(context);
    }

    private void a(Context context, d dVar) {
        this.vI = new h(context, this.uY, new i[]{new i(this.uY, 10, new j(), true), new m(dVar, 20, new n(), false)});
        this.vH = new Thread(this.vI, "StatsLogSendThd");
        this.vH.start();
    }

    private void a(HandlerThread handlerThread, b bVar) {
        if (handlerThread == null) {
            this.vF = new HandlerThread("StatsEventThd", 10);
            this.vF.start();
        } else {
            this.vF = handlerThread;
            if (this.vF.getState() == Thread.State.NEW) {
                this.vF.start();
            }
        }
        this.vG = new c(this.vF.getLooper(), bVar);
    }

    private void p(Context context) {
        new l(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "");
    }

    public void doRelease() {
        synchronized (this) {
            if (this.vF != null) {
                this.vF.quitSafely();
            }
            if (this.vI != null) {
                this.vI.shutdown();
            }
            if (this.vH != null) {
                synchronized (this.uY) {
                    if (this.uY.isEmpty()) {
                        this.vH.interrupt();
                    }
                }
            }
        }
        a.release();
    }

    @Override // com.baidu.ar.statistic.g
    public boolean isAllowPerformanceEvent(String str) {
        return this.vJ.aC(str);
    }

    @Override // com.baidu.ar.statistic.g
    public void onEvent(String str, String str2) {
        a as = a.as(str);
        as.c("event_param", str2);
        this.vG.a(2, as);
    }

    @Override // com.baidu.ar.statistic.g
    public void onEvent(String str, Map<String, String> map) {
        a as = a.as(str);
        as.a(map);
        this.vG.a(2, as);
    }

    @Override // com.baidu.ar.statistic.g
    public void onEventDebounce(String str, long j, String str2) {
        a as = a.as(str);
        as.c("_db_period", Long.valueOf(j));
        as.c("event_param", str2);
        this.vG.a(6, as);
    }

    @Override // com.baidu.ar.statistic.g
    public void onEventDebounce(String str, long j, Map<String, String> map) {
        a as = a.as(str);
        as.a(map);
        as.c("_db_period", Long.valueOf(j));
        this.vG.a(6, as);
    }

    @Override // com.baidu.ar.statistic.g
    public void onEventEnd(String str) {
        this.vG.a(5, a.as(str));
    }

    @Override // com.baidu.ar.statistic.g
    public void onEventStart(String str) {
        this.vG.a(4, a.as(str));
    }

    @Override // com.baidu.ar.statistic.g
    public void onEventStatus(String str, String str2, boolean z) {
        a as = a.as(str);
        as.c("__stt", z ? "1" : "0");
        as.c("__falseev", str2);
        this.vG.a(3, as);
    }

    @Override // com.baidu.ar.statistic.g
    public void onPerformance(String str, Map<String, String> map) {
        synchronized (this.vJ) {
            if (this.vJ.aC(str)) {
                a as = a.as(str);
                as.a(map);
                this.vG.a(20, as);
            }
        }
    }

    @Override // com.baidu.ar.statistic.g
    public void onPerformance(String str, JSONObject jSONObject) {
        synchronized (this.vJ) {
            if (this.vJ.aC(str)) {
                a as = a.as(str);
                as.c("data", jSONObject);
                this.vG.a(20, as);
            }
        }
    }

    @Override // com.baidu.ar.statistic.l.a
    public void onPerformanceRequestFinished(List<String> list) {
        this.vG.a(21, list);
    }

    @Override // com.baidu.ar.statistic.g
    public void pause() {
        this.vG.a(97, Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.baidu.ar.statistic.g
    public void release() {
        this.vG.a(99, this);
    }

    @Override // com.baidu.ar.statistic.g
    public void resume() {
        this.vG.a(98, Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.baidu.ar.statistic.g
    public void setPubParam(String str, String str2) {
        this.vG.setPubParam(str, str2);
    }

    @Override // com.baidu.ar.statistic.g
    public void setPubParams(Map<String, String> map) {
        this.vG.setPubParams(map);
    }
}
