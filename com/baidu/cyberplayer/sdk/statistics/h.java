package com.baidu.cyberplayer.sdk.statistics;

import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.j;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    private boolean b = false;
    private g a = new g();

    public synchronized String a() {
        String str = null;
        synchronized (this) {
            if (this.a != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    a.a().a(jSONObject);
                    jSONObject.put(DpStatConstants.KEY_SERVER_TYPE, DpStatConstants.SERVER_TYPE_DUPLAYER_MONITOR);
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(this.a.a());
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
        if (this.a != null) {
            this.a.a(i, str, String.valueOf(i2));
        }
    }

    public synchronized void a(int i, String str, long j) {
        if (this.a != null) {
            this.a.a(i, str, String.valueOf(j));
        }
    }

    public synchronized void a(int i, String str, String str2) {
        if (this.a != null) {
            this.a.a(i, str, str2);
        }
    }

    public synchronized void a(j jVar) {
        if (this.a != null && jVar != null) {
            this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_CURRENT_POSITION, String.valueOf(jVar.getCurrentPosition()));
            this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "decode_mode", String.valueOf(jVar.getDecodeMode()));
            this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_FILE_CACHE, "0");
            this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_P_ID, String.valueOf(jVar.b()));
            this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "network", DpNetworkUtils.getNetworkStatisticsData(CyberPlayerManager.getApplicationContext()));
            this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_NETWORK_STATUS, DpNetworkUtils.a(CyberPlayerManager.getApplicationContext()));
            this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "url", jVar.a());
            this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "timestamp", String.valueOf(jVar.b()));
            this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "duration", String.valueOf(jVar.getDuration()));
            this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_REAL_PLAY_TIME, String.valueOf(jVar.getPlayedTime()));
        }
    }

    public synchronized void b(j jVar) {
        if (this.a != null && jVar != null) {
            this.a.a(DpStatConstants.SESSION_TYPE_MEDIA_FORMAT_INFO, "width", String.valueOf(jVar.getVideoWidth()));
            this.a.a(DpStatConstants.SESSION_TYPE_MEDIA_FORMAT_INFO, "height", String.valueOf(jVar.getVideoHeight()));
            try {
                this.a.a(DpStatConstants.SESSION_TYPE_MEDIA_FORMAT_INFO, DpStatConstants.KEY_PROTO, new URL(jVar.a()).getProtocol());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized boolean b() {
        return this.b;
    }

    public synchronized void c() {
        if (this.a != null) {
            this.a.b();
        }
        this.b = false;
    }

    public synchronized void c(j jVar) {
        String a;
        if (jVar != null) {
            if (this.a != null && (a = a()) != null) {
                this.b = true;
                DpSessionDatasUploader.getInstance().upload(a, DpSessionDatasUploader.SAILOR_MONITOR);
            }
        }
    }
}
