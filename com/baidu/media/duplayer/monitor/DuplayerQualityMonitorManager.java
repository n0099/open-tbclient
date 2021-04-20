package com.baidu.media.duplayer.monitor;

import android.os.Handler;
import android.os.Looper;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.media.duplayer.Keep;
import com.baidu.rtc.PeerConnectionClient;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes2.dex */
public class DuplayerQualityMonitorManager {

    /* renamed from: c  reason: collision with root package name */
    public static DuplayerQualityMonitorManager f8004c;

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f8005d = {480, 540, PeerConnectionClient.HD_VIDEO_HEIGHT, 1080};

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, Integer> f8006a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public int f8007b = -1;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8008e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8009f;

        public a(String str, int i) {
            this.f8008e = str;
            this.f8009f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            DuplayerQualityMonitorManager.getInstance().e(this.f8008e, this.f8009f);
        }
    }

    public static synchronized DuplayerQualityMonitorManager getInstance() {
        DuplayerQualityMonitorManager duplayerQualityMonitorManager;
        synchronized (DuplayerQualityMonitorManager.class) {
            if (f8004c == null) {
                f8004c = new DuplayerQualityMonitorManager();
            }
            duplayerQualityMonitorManager = f8004c;
        }
        return duplayerQualityMonitorManager;
    }

    private native int nativeGetPlayQualityScore(String str, int i, int i2, int i3);

    private native int nativeInit();

    @Keep
    public static void updateMonitorData(int i, String str, int i2, int i3) {
        if (i != 1000) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new a(str, i2));
    }

    public final int a(int i) {
        if (i == 0 || i == 2 || i == 1) {
            return i;
        }
        return 0;
    }

    public final int b(int i, int i2) {
        int min = Math.min(i, i2);
        if (min <= 0) {
            return 540;
        }
        for (int length = f8005d.length - 1; length >= 0; length--) {
            int[] iArr = f8005d;
            if (min >= iArr[length]) {
                return iArr[length];
            }
        }
        return f8005d[0];
    }

    public final String c(String str, int i, int i2, int i3, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "video/hevc";
        }
        sb.append(str);
        sb.append("_");
        sb.append(a(i));
        sb.append("_");
        sb.append(b(i2, i3));
        return sb.toString();
    }

    public final void e(String str, int i) {
        CyberLog.i("DuplayerQualityMonitorManager", "onUpdateMonitorData key:" + str + " score:" + i);
        ConcurrentHashMap<String, Integer> concurrentHashMap = this.f8006a;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(str, Integer.valueOf(i));
        }
    }

    public int getPlayQualityScore(String str, int i, int i2, int i3, Map<String, String> map) {
        String c2 = c(str, i, i2, i3, map);
        Integer num = this.f8006a.get(c2);
        CyberLog.i("DuplayerQualityMonitorManager", "getPlayQualityScore key:" + c2 + " score:" + num);
        return num != null ? num.intValue() : this.f8007b;
    }

    public void init() {
        this.f8007b = CyberCfgManager.getInstance().getCfgIntValue("default_play_quality_score", -1);
        nativeInit();
    }
}
