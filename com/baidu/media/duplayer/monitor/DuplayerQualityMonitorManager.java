package com.baidu.media.duplayer.monitor;

import android.os.Handler;
import android.os.Looper;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.media.duplayer.Keep;
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.sapi2.activity.IdCardOcrCameraActivity;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes2.dex */
public class DuplayerQualityMonitorManager {

    /* renamed from: c  reason: collision with root package name */
    public static DuplayerQualityMonitorManager f8106c;

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f8107d = {480, 540, PeerConnectionClient.HD_VIDEO_HEIGHT, IdCardOcrCameraActivity.G};

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, Integer> f8108a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public int f8109b = -1;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8110e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f8111f;

        public a(String str, int i2) {
            this.f8110e = str;
            this.f8111f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            DuplayerQualityMonitorManager.getInstance().e(this.f8110e, this.f8111f);
        }
    }

    public static synchronized DuplayerQualityMonitorManager getInstance() {
        DuplayerQualityMonitorManager duplayerQualityMonitorManager;
        synchronized (DuplayerQualityMonitorManager.class) {
            if (f8106c == null) {
                f8106c = new DuplayerQualityMonitorManager();
            }
            duplayerQualityMonitorManager = f8106c;
        }
        return duplayerQualityMonitorManager;
    }

    private native int nativeGetPlayQualityScore(String str, int i2, int i3, int i4);

    private native int nativeInit();

    @Keep
    public static void updateMonitorData(int i2, String str, int i3, int i4) {
        if (i2 != 1000) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new a(str, i3));
    }

    public final int a(int i2) {
        if (i2 == 0 || i2 == 2 || i2 == 1) {
            return i2;
        }
        return 0;
    }

    public final int b(int i2, int i3) {
        int min = Math.min(i2, i3);
        if (min <= 0) {
            return 540;
        }
        for (int length = f8107d.length - 1; length >= 0; length--) {
            int[] iArr = f8107d;
            if (min >= iArr[length]) {
                return iArr[length];
            }
        }
        return f8107d[0];
    }

    public final String c(String str, int i2, int i3, int i4, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "video/hevc";
        }
        sb.append(str);
        sb.append("_");
        sb.append(a(i2));
        sb.append("_");
        sb.append(b(i3, i4));
        return sb.toString();
    }

    public final void e(String str, int i2) {
        CyberLog.i("DuplayerQualityMonitorManager", "onUpdateMonitorData key:" + str + " score:" + i2);
        ConcurrentHashMap<String, Integer> concurrentHashMap = this.f8108a;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(str, Integer.valueOf(i2));
        }
    }

    public int getPlayQualityScore(String str, int i2, int i3, int i4, Map<String, String> map) {
        String c2 = c(str, i2, i3, i4, map);
        Integer num = this.f8108a.get(c2);
        CyberLog.i("DuplayerQualityMonitorManager", "getPlayQualityScore key:" + c2 + " score:" + num);
        return num != null ? num.intValue() : this.f8109b;
    }

    public void init() {
        this.f8109b = CyberCfgManager.getInstance().getCfgIntValue("default_play_quality_score", -1);
        nativeInit();
    }
}
