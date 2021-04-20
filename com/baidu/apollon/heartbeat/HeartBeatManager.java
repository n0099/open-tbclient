package com.baidu.apollon.heartbeat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.restnet.RestRuntimeException;
import com.baidu.apollon.restnet.RestTemplate;
import com.baidu.apollon.restnet.a;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.apollon.utils.NetworkUtils;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
public final class HeartBeatManager implements NoProguard {
    public static final String EVENT_KEY = "activity_state_oberserver";

    /* renamed from: a  reason: collision with root package name */
    public static final String f3662a = "HeartBeatManager";

    /* renamed from: b  reason: collision with root package name */
    public static final int f3663b = 180;

    /* renamed from: c  reason: collision with root package name */
    public static HeartBeatManager f3664c;

    /* renamed from: d  reason: collision with root package name */
    public Context f3665d = null;

    /* renamed from: e  reason: collision with root package name */
    public RestHeartBeat f3666e = new RestHeartBeat();

    /* renamed from: f  reason: collision with root package name */
    public Timer f3667f = null;

    /* renamed from: g  reason: collision with root package name */
    public b f3668g = new b();

    /* renamed from: h  reason: collision with root package name */
    public long f3669h = 0;
    public a.InterfaceC0063a i = new a.InterfaceC0063a() { // from class: com.baidu.apollon.heartbeat.HeartBeatManager.1
        @Override // com.baidu.apollon.restnet.a.InterfaceC0063a
        public boolean a(String str) {
            return TextUtils.equals(a.c().a() + HeartBeatManager.this.f3666e.mHeartbeatUrl, str);
        }

        @Override // com.baidu.apollon.restnet.a.InterfaceC0063a
        public void a(String str, String str2) {
            if (TextUtils.equals(str2, str)) {
                return;
            }
            if (!a(str)) {
                HeartBeatManager.this.f3666e.reset();
                long splitTimeMs = HeartBeatManager.this.f3666e.getSplitTimeMs();
                HeartBeatManager.this.a(splitTimeMs, splitTimeMs);
                String str3 = HeartBeatManager.f3662a;
                LogUtil.i(str3, HeartBeatManager.f3662a + " business request success.");
                return;
            }
            String str4 = HeartBeatManager.f3662a;
            StringBuilder sb = new StringBuilder();
            sb.append(HeartBeatManager.f3662a);
            sb.append(" heartbeat ");
            sb.append(HeartBeatManager.this.f3669h > 0 ? "background " : "");
            sb.append("request success.");
            LogUtil.i(str4, sb.toString());
        }
    };

    /* loaded from: classes.dex */
    public final class RestHeartBeat implements NoProguard, Serializable {
        public static final long serialVersionUID = 1;
        public long mCostTime;
        public String mHeartbeatUrl;
        public int mKeepAliveMax;
        public int mSplitTime;

        public RestHeartBeat() {
            this.mHeartbeatUrl = "/heartbeat";
            this.mCostTime = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long getSplitTimeMs() {
            return this.mSplitTime * 1000;
        }

        public boolean beating() {
            long j = this.mCostTime + this.mSplitTime;
            this.mCostTime = j;
            return j > ((long) this.mKeepAliveMax);
        }

        public boolean isValid() {
            return this.mSplitTime > 0 && this.mKeepAliveMax > 0;
        }

        public void reset() {
            this.mCostTime = 0L;
        }

        public String toString() {
            return " costTime:" + this.mCostTime + ",splitTime:" + this.mSplitTime;
        }

        public void updateCfg(HeartBeatCfgEntity heartBeatCfgEntity) {
            if (!TextUtils.isEmpty(heartBeatCfgEntity.KA_INIT)) {
                this.mSplitTime = Integer.valueOf(heartBeatCfgEntity.KA_INIT).intValue();
            }
            if (!TextUtils.isEmpty(heartBeatCfgEntity.KA_MAX)) {
                this.mKeepAliveMax = Integer.valueOf(heartBeatCfgEntity.KA_MAX).intValue();
            }
            String str = HeartBeatManager.f3662a;
            LogUtil.i(str, HeartBeatManager.f3662a + " cfg:" + heartBeatCfgEntity);
        }
    }

    public static synchronized HeartBeatManager getInstance() {
        HeartBeatManager heartBeatManager;
        synchronized (HeartBeatManager.class) {
            if (f3664c == null) {
                f3664c = new HeartBeatManager();
            }
            heartBeatManager = f3664c;
        }
        return heartBeatManager;
    }

    public synchronized void applyBeating() {
        HeartBeatCfgEntity a2 = a.c().a(this.f3665d);
        if (a2 != null && a2.isUsed()) {
            if (a2.validate()) {
                this.f3666e.updateCfg(a2);
                this.f3668g.a(1);
            } else {
                String str = f3662a;
                LogUtil.w(str, f3662a + " start resp isn't validate.");
            }
            return;
        }
        String str2 = f3662a;
        LogUtil.w(str2, f3662a + " start resp is null or isn't used.");
        this.f3668g.a(2);
    }

    public void executeInForeground(boolean z) {
        String str = f3662a;
        LogUtil.i(str, f3662a + " onStateChanged isForeground:" + z);
        if (z) {
            if (this.f3666e.isValid()) {
                this.f3668g.a(1);
                this.f3668g.a(4);
            }
            a.c().b(this.f3665d);
            return;
        }
        this.f3668g.a(3);
    }

    public void init(Context context, String str) {
        if (context != null) {
            this.f3665d = context.getApplicationContext();
            a.c().b(str);
            return;
        }
        throw new IllegalArgumentException("context param is null exception.");
    }

    public void startHeartBeat() {
        com.baidu.apollon.restnet.a.a(this.i);
        a(0L, this.f3666e.getSplitTimeMs());
        String str = f3662a;
        LogUtil.i(str, f3662a + " HeartBeat start.");
    }

    public void stopHeartBeat() {
        Timer timer = this.f3667f;
        if (timer != null) {
            timer.cancel();
            this.f3667f = null;
        }
        this.f3666e.reset();
        a(0L);
        com.baidu.apollon.restnet.a.a(null);
        String str = f3662a;
        LogUtil.i(str, f3662a + " HeartBeat end.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.f3666e.beating()) {
            this.f3668g.a(2);
            String str = f3662a;
            LogUtil.i(str, f3662a + " heartbeat beat enough mKeepAliveMax:" + this.f3666e.mKeepAliveMax + ", costTime:" + this.f3666e.mCostTime);
        } else if (this.f3669h > 0 && Calendar.getInstance().getTimeInMillis() / 1000 > this.f3669h + 180) {
            this.f3668g.a(2);
        } else if (!NetworkUtils.isNetworkAvailable(this.f3665d)) {
            String str2 = f3662a;
            LogUtil.i(str2, f3662a + " schedule the network isn't available.");
        } else {
            RestTemplate restTemplate = new RestTemplate(this.f3665d);
            restTemplate.setMessageConverter(new com.baidu.apollon.restnet.converter.b());
            try {
                String str3 = f3662a;
                LogUtil.i(str3, f3662a + " send heartbeat request.");
                restTemplate.a(a.c().a() + this.f3666e.mHeartbeatUrl, null, "utf-8", String.class);
            } catch (RestRuntimeException e2) {
                String str4 = f3662a;
                LogUtil.errord(str4, f3662a + " Heart Beat exception:" + e2.getMessage());
                e2.printStackTrace();
            }
        }
    }

    public void a(long j) {
        this.f3669h = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        try {
            if (this.f3667f != null) {
                this.f3667f.cancel();
            }
            Timer timer = new Timer();
            this.f3667f = timer;
            timer.schedule(new TimerTask() { // from class: com.baidu.apollon.heartbeat.HeartBeatManager.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    HeartBeatManager.this.b();
                }
            }, j, j2);
        } catch (RuntimeException e2) {
            e2.printStackTrace();
        }
    }
}
