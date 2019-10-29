package com.baidu.cyberplayer.sdk.statistics;

import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.i;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    private boolean b = false;
    private g a = new g();

    public String a() {
        String str = null;
        if (this.a != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                a.a().a(jSONObject);
                jSONObject.put(DpStatConstants.KEY_SERVER_TYPE, DpStatConstants.SERVER_TYPE_DUPLAYER_MONITOR);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(this.a.a());
                jSONObject.put(DpStatConstants.KEY_ITEMS, jSONArray);
                str = jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jSONObject.remove("cuid");
            CyberLog.i("DpStatSessionImpl", "all session = " + jSONObject.toString());
        }
        return str;
    }

    public void a(int i, String str, int i2) {
        if (this.a != null) {
            this.a.a(i, str, String.valueOf(i2));
        }
    }

    public void a(int i, String str, long j) {
        if (this.a != null) {
            this.a.a(i, str, String.valueOf(j));
        }
    }

    public void a(int i, String str, String str2) {
        if (this.a != null) {
            this.a.a(i, str, str2);
        }
    }

    public void a(i iVar) {
        if (this.a == null || iVar == null) {
            return;
        }
        this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_CURRENT_POSITION, String.valueOf(iVar.getCurrentPosition()));
        this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "decode_mode", String.valueOf(iVar.getDecodeMode()));
        this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_FILE_CACHE, "0");
        this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_P_ID, String.valueOf(iVar.b()));
        this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "network", DpNetworkUtils.getNetworkStatisticsData(CyberPlayerManager.getApplicationContext()));
        this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_NETWORK_STATUS, DpNetworkUtils.a(CyberPlayerManager.getApplicationContext()));
        this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "url", iVar.a());
        this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "timestamp", String.valueOf(iVar.b()));
        this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "duration", String.valueOf(iVar.getDuration()));
        this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_REAL_PLAY_TIME, String.valueOf(iVar.getPlayedTime()));
    }

    public void b(i iVar) {
        if (this.a == null || iVar == null) {
            return;
        }
        this.a.a(DpStatConstants.SESSION_TYPE_MEDIA_FORMAT_INFO, "width", String.valueOf(iVar.getVideoWidth()));
        this.a.a(DpStatConstants.SESSION_TYPE_MEDIA_FORMAT_INFO, "height", String.valueOf(iVar.getVideoHeight()));
        try {
            this.a.a(DpStatConstants.SESSION_TYPE_MEDIA_FORMAT_INFO, DpStatConstants.KEY_PROTO, new URL(iVar.a()).getProtocol());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public boolean b() {
        return this.b;
    }

    public void c() {
        if (this.a != null) {
            this.a.b();
        }
        this.b = false;
    }

    public void c(i iVar) {
        String a;
        if (iVar == null || this.a == null || (a = a()) == null) {
            return;
        }
        this.b = true;
        DpSessionDatasUploader.getInstance().upload(a, DpSessionDatasUploader.SAILOR_MONITOR);
    }
}
