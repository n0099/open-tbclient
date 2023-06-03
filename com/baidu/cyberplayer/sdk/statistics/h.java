package com.baidu.cyberplayer.sdk.statistics;

import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    public boolean b = false;
    public g a = new g();
    public boolean e = false;
    public boolean c = false;
    public boolean d = false;

    public synchronized boolean a() {
        return this.b;
    }

    public synchronized void b() {
        if (this.a != null) {
            this.a.b();
        }
        this.b = false;
    }

    public synchronized boolean c() {
        return this.c;
    }

    public synchronized boolean d() {
        return this.d;
    }

    public synchronized boolean e() {
        return this.e;
    }

    private void c(String str) {
        if ("1".equals(str)) {
            this.d = true;
        } else if ("0".equals(str)) {
            this.d = false;
        }
    }

    private void d(String str) {
        String[] strArr = {"(.*)bdstatic.com(.*)", "(.*)baidu.com(.*)", "(.*)baidubce.com(.*)", "(.*)bcebos.com(.*)", "(.*)bcevod.com(.*)"};
        int i = 0;
        while (true) {
            if (i >= 5) {
                break;
            } else if (str.matches(strArr[i])) {
                this.c = true;
                break;
            } else {
                i++;
            }
        }
        this.c = false;
    }

    private void e(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        if (str.length() - lastIndexOf == 2) {
            this.e = true;
        } else if (str.length() - lastIndexOf == 3) {
            this.e = false;
        }
    }

    public synchronized void b(m mVar) {
        if (this.a != null && mVar != null) {
            this.a.a(DpStatConstants.SESSION_TYPE_MEDIA_FORMAT_INFO, "width", String.valueOf(mVar.getVideoWidth()));
            this.a.a(DpStatConstants.SESSION_TYPE_MEDIA_FORMAT_INFO, "height", String.valueOf(mVar.getVideoHeight()));
        }
    }

    public synchronized String a(String str) {
        String str2 = null;
        if (this.a == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject a = this.a.a();
            a.a().a(a);
            a.put(DpStatConstants.KEY_SERVER_TYPE, str);
            if (a.has("url")) {
                d(a.getString("url"));
            }
            if (a.has("app_version")) {
                e(a.getString("app_version"));
            }
            if (a.has(DpStatConstants.KEY_IS_USER_STARTED)) {
                c(a.getString(DpStatConstants.KEY_IS_USER_STARTED));
            }
            a.remove("abtest_sid");
            a.remove("app_name");
            a.remove("app_version");
            a.remove("cuid");
            jSONObject2.put("items", a);
            jSONObject.put("ext", jSONObject2);
            jSONObject.put("from", "cyber");
            jSONObject.put("page", "vod");
            str2 = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return str2;
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

    public synchronized void a(m mVar) {
        String str;
        String str2;
        if (this.a != null && mVar != null) {
            this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_CURRENT_POSITION, String.valueOf(mVar.getCurrentPosition()));
            this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "decode_mode", String.valueOf(mVar.getDecodeMode()));
            this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_FILE_CACHE, "0");
            this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_P_ID, String.valueOf(mVar.b()));
            this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "network", DpNetworkUtils.getNetworkStatisticsNoOperator(CyberPlayerManager.getApplicationContext()));
            this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_NETWORK_STATUS, DpNetworkUtils.b(CyberPlayerManager.getApplicationContext()));
            this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "url", mVar.a());
            this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "timestamp", String.valueOf(System.currentTimeMillis()));
            this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, "duration", String.valueOf(mVar.getDuration()));
            this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_REAL_PLAY_TIME, String.valueOf(mVar.getPlayedTime()));
            g gVar = this.a;
            if (mVar.c()) {
                str = "1";
            } else {
                str = "0";
            }
            gVar.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_IS_USER_STARTED, str);
            g gVar2 = this.a;
            if (mVar.d()) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            gVar2.a(20488, DpStatConstants.KEY_IS_AUDIO_MUTED, str2);
        }
    }

    public synchronized void a(m mVar, String str) {
        String b;
        if (mVar != null) {
            if (this.a != null && (b = b(str)) != null) {
                this.b = true;
                DpSessionDatasUploader.getInstance().upload(b, "sailor_monitor");
            }
        }
    }

    public synchronized String b(String str) {
        String str2 = null;
        if (this.a == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            a.a().a(jSONObject);
            jSONObject.put(DpStatConstants.KEY_SERVER_TYPE, str);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.a.a());
            jSONObject.put("items", jSONArray);
            str2 = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        jSONObject.remove("cuid");
        CyberLog.i("DpStatSessionImpl", "all session = " + jSONObject.toString());
        return str2;
    }
}
