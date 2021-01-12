package com.baidu.cyberplayer.sdk.statistics;

import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: b  reason: collision with root package name */
    private boolean f1847b = false;

    /* renamed from: a  reason: collision with root package name */
    private g f1846a = new g();

    public synchronized String a() {
        String str = null;
        synchronized (this) {
            if (this.f1846a != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    a.a().a(jSONObject);
                    jSONObject.put(DpStatConstants.KEY_SERVER_TYPE, DpStatConstants.SERVER_TYPE_DUPLAYER_MONITOR);
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(this.f1846a.a());
                    jSONObject.put("items", jSONArray);
                    str = jSONObject.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jSONObject.remove("cuid");
                CyberLog.i("DpStatSessionImpl", "all session = " + jSONObject.toString());
            }
        }
        return str;
    }

    public synchronized void a(int i, String str, int i2) {
        if (this.f1846a != null) {
            this.f1846a.a(i, str, String.valueOf(i2));
        }
    }

    public synchronized void a(int i, String str, long j) {
        if (this.f1846a != null) {
            this.f1846a.a(i, str, String.valueOf(j));
        }
    }

    public synchronized void a(int i, String str, String str2) {
        if (this.f1846a != null) {
            this.f1846a.a(i, str, str2);
        }
    }

    public synchronized void a(k kVar) {
        if (this.f1846a != null && kVar != null) {
            this.f1846a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_CURRENT_POSITION, String.valueOf(kVar.getCurrentPosition()));
            this.f1846a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "decode_mode", String.valueOf(kVar.getDecodeMode()));
            this.f1846a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_FILE_CACHE, "0");
            this.f1846a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_P_ID, String.valueOf(kVar.b()));
            this.f1846a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "network", DpNetworkUtils.getNetworkStatisticsData(CyberPlayerManager.getApplicationContext()));
            this.f1846a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_NETWORK_STATUS, DpNetworkUtils.a(CyberPlayerManager.getApplicationContext()));
            this.f1846a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "url", kVar.a());
            this.f1846a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "timestamp", String.valueOf(kVar.b()));
            this.f1846a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "duration", String.valueOf(kVar.getDuration()));
            this.f1846a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_REAL_PLAY_TIME, String.valueOf(kVar.getPlayedTime()));
        }
    }

    public synchronized void b(k kVar) {
        if (this.f1846a != null && kVar != null) {
            this.f1846a.a(DpStatConstants.SESSION_TYPE_MEDIA_FORMAT_INFO, "width", String.valueOf(kVar.getVideoWidth()));
            this.f1846a.a(DpStatConstants.SESSION_TYPE_MEDIA_FORMAT_INFO, "height", String.valueOf(kVar.getVideoHeight()));
        }
    }

    public synchronized boolean b() {
        return this.f1847b;
    }

    public synchronized void c() {
        if (this.f1846a != null) {
            this.f1846a.b();
        }
        this.f1847b = false;
    }

    public synchronized void c(k kVar) {
        String a2;
        if (kVar != null) {
            if (this.f1846a != null && (a2 = a()) != null) {
                this.f1847b = true;
                DpSessionDatasUploader.getInstance().upload(a2, DpSessionDatasUploader.SAILOR_MONITOR);
            }
        }
    }
}
