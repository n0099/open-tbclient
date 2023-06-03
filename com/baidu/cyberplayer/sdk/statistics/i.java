package com.baidu.cyberplayer.sdk.statistics;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i implements ComponentCallbacks2 {
    public static volatile i g;
    public volatile JSONObject a = new JSONObject();
    public volatile JSONObject b = new JSONObject();
    public volatile JSONObject c = new JSONObject();
    public volatile int d = -1;
    public volatile long e = -1;
    public volatile long f = -1;

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    public static i a() {
        if (g == null) {
            synchronized (i.class) {
                if (g == null) {
                    g = new i();
                }
            }
        }
        return g;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.e = System.currentTimeMillis();
    }

    private void a(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            keys.next();
            keys.remove();
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        this.d = i;
    }

    public void a(long j) {
        this.f = j;
    }

    public void a(String str, long j) {
        if (str != null && !str.isEmpty()) {
            try {
                this.b.put(str, j);
                if (str.equals("died")) {
                    this.c.put("time", j);
                    this.c.put("lowMem", this.e);
                    this.c.put("trimMem", this.d);
                    this.b.put("died", this.c);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void b() {
        if (this.b.length() > 0 && CyberCfgManager.getInstance().a("media_process_ubc", true)) {
            try {
                this.b.put("MPId", this.f);
                this.a.put("ext", this.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcSessionUploader.getInstance().upload("5248", this.a.toString());
            this.e = -1L;
            this.d = -1;
            a(this.c);
            a(this.b);
            a(this.a);
        }
    }
}
