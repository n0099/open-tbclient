package com.baidu.media.duplayer.monitor;

import android.os.Handler;
import android.os.Looper;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.media.duplayer.Keep;
import com.baidu.platform.comapi.UIMsg;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes15.dex */
public class DuplayerQualityMonitorManager {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f3246b = {480, UIMsg.MsgDefine.MSG_NETWORK_CHANNEL, 720, 1080};
    private static DuplayerQualityMonitorManager cjc;
    private ConcurrentHashMap<String, Integer> c = new ConcurrentHashMap<>();
    private int d = -1;

    private DuplayerQualityMonitorManager() {
    }

    private int a(int i) {
        if (i == 0 || i == 2 || i == 1) {
            return i;
        }
        return 0;
    }

    private int a(int i, int i2) {
        int min = Math.min(i, i2);
        if (min <= 0) {
            return UIMsg.MsgDefine.MSG_NETWORK_CHANNEL;
        }
        for (int length = f3246b.length - 1; length >= 0; length--) {
            if (min >= f3246b[length]) {
                return f3246b[length];
            }
        }
        return f3246b[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i) {
        CyberLog.i("DuplayerQualityMonitorManager", "onUpdateMonitorData key:" + str + " score:" + i);
        if (this.c != null) {
            this.c.put(str, Integer.valueOf(i));
        }
    }

    private String b(String str, int i, int i2, int i3, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        } else {
            sb.append("video/hevc");
        }
        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        sb.append(a(i));
        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
        sb.append(a(i2, i3));
        return sb.toString();
    }

    public static synchronized DuplayerQualityMonitorManager getInstance() {
        DuplayerQualityMonitorManager duplayerQualityMonitorManager;
        synchronized (DuplayerQualityMonitorManager.class) {
            if (cjc == null) {
                cjc = new DuplayerQualityMonitorManager();
            }
            duplayerQualityMonitorManager = cjc;
        }
        return duplayerQualityMonitorManager;
    }

    private native int nativeGetPlayQualityScore(String str, int i, int i2, int i3);

    private native int nativeInit();

    @Keep
    private static void updateMonitorData(int i, final String str, final int i2, int i3) {
        switch (i) {
            case 1000:
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.media.duplayer.monitor.DuplayerQualityMonitorManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DuplayerQualityMonitorManager.getInstance().a(str, i2);
                    }
                });
                return;
            default:
                return;
        }
    }

    public int getPlayQualityScore(String str, int i, int i2, int i3, Map<String, String> map) {
        String b2 = b(str, i, i2, i3, map);
        Integer num = this.c.get(b2);
        CyberLog.i("DuplayerQualityMonitorManager", "getPlayQualityScore key:" + b2 + " score:" + num);
        return num != null ? num.intValue() : this.d;
    }

    public void init() {
        this.d = CyberCfgManager.getInstance().getCfgIntValue("default_play_quality_score", -1);
        nativeInit();
    }
}
