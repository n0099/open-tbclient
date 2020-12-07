package com.baidu.ar.statistic;

import android.content.Context;
import android.os.AsyncTask;
import android.os.HandlerThread;
import com.baidu.ar.statistic.l;
import java.lang.Thread;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class StatisticApiImpl implements g, l.a {
    private HandlerThread wW;
    private c wX;
    private Thread wY;
    private h wZ;
    private d wp;
    private volatile k xa;

    public StatisticApiImpl(Context context, HandlerThread handlerThread) {
        this.wp = new d(context, "ar_stats_local.json", 100, 40);
        d dVar = new d(context, "ar_stats_pfm_local.json", 200, 0);
        this.xa = new k(dVar, 20, 200);
        a(handlerThread, new b(context, this.wp, q.xb, r.gr(), this.xa));
        a(context, dVar);
        this.wX.a(1, null);
        r(context);
    }

    private void a(Context context, d dVar) {
        this.wZ = new h(context, this.wp, new i[]{new i(this.wp, 10, new j(), true), new m(dVar, 20, new n(), false)});
        this.wY = new Thread(this.wZ, "StatsLogSendThd");
        this.wY.start();
    }

    private void a(HandlerThread handlerThread, b bVar) {
        if (handlerThread == null) {
            this.wW = new HandlerThread("StatsEventThd", 10);
            this.wW.start();
        } else {
            this.wW = handlerThread;
            if (this.wW.getState() == Thread.State.NEW) {
                this.wW.start();
            }
        }
        this.wX = new c(this.wW.getLooper(), bVar);
    }

    private void r(Context context) {
        new l(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "");
    }

    public void doRelease() {
        synchronized (this) {
            if (this.wW != null) {
                this.wW.quitSafely();
            }
            if (this.wZ != null) {
                this.wZ.shutdown();
            }
            if (this.wY != null) {
                synchronized (this.wp) {
                    if (this.wp.isEmpty()) {
                        this.wY.interrupt();
                    }
                }
            }
        }
        a.release();
    }

    @Override // com.baidu.ar.statistic.g
    public boolean isAllowPerformanceEvent(String str) {
        return this.xa.aJ(str);
    }

    @Override // com.baidu.ar.statistic.g
    public void onEvent(String str, String str2) {
        a az = a.az(str);
        az.b("event_param", str2);
        this.wX.a(2, az);
    }

    @Override // com.baidu.ar.statistic.g
    public void onEvent(String str, Map<String, String> map) {
        a az = a.az(str);
        az.a(map);
        this.wX.a(2, az);
    }

    @Override // com.baidu.ar.statistic.g
    public void onEventDebounce(String str, long j, String str2) {
        a az = a.az(str);
        az.b("_db_period", Long.valueOf(j));
        az.b("event_param", str2);
        this.wX.a(6, az);
    }

    @Override // com.baidu.ar.statistic.g
    public void onEventDebounce(String str, long j, Map<String, String> map) {
        a az = a.az(str);
        az.a(map);
        az.b("_db_period", Long.valueOf(j));
        this.wX.a(6, az);
    }

    @Override // com.baidu.ar.statistic.g
    public void onEventEnd(String str) {
        this.wX.a(5, a.az(str));
    }

    @Override // com.baidu.ar.statistic.g
    public void onEventStart(String str) {
        this.wX.a(4, a.az(str));
    }

    @Override // com.baidu.ar.statistic.g
    public void onEventStatus(String str, String str2, boolean z) {
        a az = a.az(str);
        az.b("__stt", z ? "1" : "0");
        az.b("__falseev", str2);
        this.wX.a(3, az);
    }

    @Override // com.baidu.ar.statistic.g
    public void onPerformance(String str, Map<String, String> map) {
        synchronized (this.xa) {
            if (this.xa.aJ(str)) {
                a az = a.az(str);
                az.a(map);
                this.wX.a(20, az);
            }
        }
    }

    @Override // com.baidu.ar.statistic.g
    public void onPerformance(String str, JSONObject jSONObject) {
        synchronized (this.xa) {
            if (this.xa.aJ(str)) {
                a az = a.az(str);
                az.b("data", jSONObject);
                this.wX.a(20, az);
            }
        }
    }

    @Override // com.baidu.ar.statistic.l.a
    public void onPerformanceRequestFinished(List<String> list) {
        this.wX.a(21, list);
    }

    @Override // com.baidu.ar.statistic.g
    public void pause() {
        this.wX.a(97, Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.baidu.ar.statistic.g
    public void release() {
        this.wX.a(99, this);
    }

    @Override // com.baidu.ar.statistic.g
    public void resume() {
        this.wX.a(98, Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.baidu.ar.statistic.g
    public void setPubParam(String str, String str2) {
        this.wX.setPubParam(str, str2);
    }

    @Override // com.baidu.ar.statistic.g
    public void setPubParams(Map<String, String> map) {
        this.wX.setPubParams(map);
    }
}
