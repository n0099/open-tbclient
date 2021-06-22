package com.baidu.media.playerconfig;

import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.media.duplayer.Keep;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import org.json.JSONObject;
@Keep
/* loaded from: classes2.dex */
public class PlayerConfigManagerInternal {
    public static final int MINI_VIDEO = 0;
    public static final int SHORT_VIDEO = 1;
    public static final int UNKNOWN = -1;

    /* renamed from: d  reason: collision with root package name */
    public static final PlayerConfigManagerInternal f8064d = new PlayerConfigManagerInternal();

    /* renamed from: a  reason: collision with root package name */
    public c f8065a = null;

    /* renamed from: b  reason: collision with root package name */
    public HandlerThread f8066b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f8067c;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8068e;

        public a(String str) {
            this.f8068e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (PlayerConfigManagerInternal.class) {
                PlayerConfigManagerInternal.this.f8065a = PlayerConfigManagerInternal.this.d(this.f8068e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f8070a;

        /* renamed from: b  reason: collision with root package name */
        public String f8071b;

        public b(String str, int i2) {
            this.f8070a = i2;
            this.f8071b = str;
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public long f8072a = 300;

        /* renamed from: b  reason: collision with root package name */
        public long f8073b = 0;

        /* renamed from: c  reason: collision with root package name */
        public d.a.y.d.a f8074c = null;

        /* renamed from: d  reason: collision with root package name */
        public d.a.y.d.a f8075d = null;

        public d.a.y.d.a a(int i2) {
            if (i2 != 0) {
                if (i2 != 1) {
                    return null;
                }
                return this.f8074c;
            }
            return this.f8075d;
        }
    }

    public PlayerConfigManagerInternal() {
        this.f8066b = null;
        this.f8067c = null;
        HandlerThread handlerThread = new HandlerThread("player_config_thread");
        this.f8066b = handlerThread;
        if (handlerThread != null) {
            handlerThread.start();
            this.f8067c = new Handler(this.f8066b.getLooper());
        }
    }

    public static PlayerConfigManagerInternal getInstance() {
        return f8064d;
    }

    public int a(Uri uri) {
        String query = uri.getQuery();
        if (query == null) {
            return -1;
        }
        String[] split = query.split("&");
        boolean z = false;
        int i2 = -1;
        for (int i3 = 0; i3 < split.length; i3++) {
            if (split[i3].indexOf("vt") != -1) {
                try {
                    i2 = Integer.parseInt(split[i3].substring(3));
                    z = true;
                } catch (Exception unused) {
                    z = true;
                    i2 = -1;
                }
            }
        }
        if (z) {
            if (i2 != 0) {
                if (i2 != 1) {
                    CyberLog.i("PlayerServer-PlyrCnfgMngr", "This URI is UNKNOWN video!!!");
                    return -1;
                }
                return 1;
            }
            return 0;
        }
        return -1;
    }

    public final c d(@NonNull String str) {
        if (str != null) {
            try {
                if (str.isEmpty()) {
                    return null;
                }
                c cVar = new c();
                JSONObject jSONObject = new JSONObject(str).getJSONObject("bandwidth_config");
                try {
                    cVar.f8073b = jSONObject.getLong("now_time");
                    cVar.f8072a = jSONObject.getLong("update_interval");
                } catch (Exception e2) {
                    CyberLog.e("PlayerServer-PlyrCnfgMngr", "get now time fail!", e2);
                }
                cVar.f8074c = e(jSONObject.getJSONObject("default"), "Short Video");
                CyberLog.i("PlayerServer-PlyrCnfgMngr", "" + cVar.f8074c);
                cVar.f8075d = e(jSONObject.getJSONObject("mini_video"), "Mini Video");
                CyberLog.i("PlayerServer-PlyrCnfgMngr", "" + cVar.f8075d);
                return cVar;
            } catch (Exception e3) {
                CyberLog.e("PlayerServer-PlyrCnfgMngr", "update config fail : ", e3);
                return null;
            }
        }
        return null;
    }

    public final d.a.y.d.a e(JSONObject jSONObject, String str) {
        d.a.y.d.a aVar = null;
        try {
            String string = jSONObject.getString("host");
            if (string != null) {
                if (!string.isEmpty()) {
                    aVar = new d.a.y.d.a(str);
                    aVar.f68700e = string.split(";");
                    aVar.f68701f = jSONObject.getString("cntl_id");
                    try {
                        boolean z = true;
                        if (jSONObject.getJSONObject("pcdn_config").getInt(SetImageWatermarkTypeReqMsg.SWITCH) != 1) {
                            z = false;
                        }
                        aVar.f68702g = z;
                    } catch (Exception e2) {
                        CyberLog.e("PlayerServer-PlyrCnfgMngr", "update pcdn_config fail", e2);
                    }
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("cdn_config").getJSONObject("limit_rate");
                        aVar.f68704i.f68705e = jSONObject2.getInt("sle");
                        aVar.f68704i.f68706f = (float) jSONObject2.getDouble("sl_rate");
                        aVar.f68704i.f68707g = (float) jSONObject2.getDouble("split_rate");
                    } catch (Exception e3) {
                        CyberLog.e("PlayerServer-PlyrCnfgMngr", "update cdn config fail", e3);
                    }
                    try {
                        JSONObject jSONObject3 = jSONObject.getJSONObject("prefetch_config");
                        aVar.j.f68708e = jSONObject3.getInt("duration");
                        aVar.j.f68709f = jSONObject3.getInt("pcdn_enable");
                        aVar.j.f68710g = jSONObject3.getInt("p2p_enable");
                        JSONObject jSONObject4 = jSONObject3.getJSONObject("limit_rate");
                        aVar.j.f68711h = jSONObject4.getInt("sle");
                        aVar.j.f68712i = (float) jSONObject4.getDouble("sl_rate");
                        aVar.j.j = (float) jSONObject4.getDouble("split_rate");
                    } catch (Exception e4) {
                        CyberLog.e("PlayerServer-PlyrCnfgMngr", "update prefetch config fail", e4);
                    }
                }
            }
            return aVar;
        } catch (Exception e5) {
            CyberLog.e("PlayerServer-PlyrCnfgMngr", "NO HOST fail : ", e5);
            return null;
        }
    }

    public final boolean f(String str, String[] strArr) {
        if (str != null && !str.isEmpty()) {
            for (int i2 = 0; strArr != null && i2 < strArr.length; i2++) {
                if (str.equals(strArr[i2])) {
                    return true;
                }
            }
        }
        return false;
    }

    public c getPlayerConfig() {
        c cVar;
        synchronized (PlayerConfigManagerInternal.class) {
            cVar = this.f8065a;
        }
        return cVar;
    }

    @RequiresApi(api = 11)
    public Uri rebuildUrlForPlay(Uri uri, String str, int i2, int i3) {
        float f2;
        if (uri == null || i2 <= 0 || i3 <= 0) {
            CyberLog.i("PlayerServer-PlyrCnfgMngr", "(URI == NULL, BPS == 0 MOOV_SIZE == 0) rebuild url fail!");
            return uri;
        }
        c d2 = d(str);
        if (d2 == null && (d2 = getPlayerConfig()) == null) {
            CyberLog.d("PlayerServer-PlyrCnfgMngr", "rebuildUrl get container null!");
            return uri;
        } else if ((System.currentTimeMillis() / 1000) - d2.f8073b > d2.f8072a * 4) {
            CyberLog.d("PlayerServer-PlyrCnfgMngr", "This config is time out!");
            return uri;
        } else {
            int a2 = a(uri);
            if (a2 == -1) {
                return uri;
            }
            d.a.y.d.a a3 = d2.a(a2);
            CyberLog.d("PlayerServer-PlyrCnfgMngr", "" + a3);
            if (!a3.c()) {
                CyberLog.i("PlayerServer-PlyrCnfgMngr", "The player server config is invalidate, use old uri continue!");
                return uri;
            } else if (!f(uri.getHost(), a3.f68700e)) {
                CyberLog.i("PlayerServer-PlyrCnfgMngr", "host : " + uri.getHost() + " not match");
                return uri;
            } else {
                String query = uri.getQuery();
                if (query == null || query.isEmpty()) {
                    CyberLog.i("PlayerServer-PlyrCnfgMngr", "This host has no query!");
                    return uri;
                }
                String[] split = query.split("&");
                boolean z = false;
                int i4 = -1;
                boolean z2 = false;
                for (int i5 = 0; i5 < split.length; i5++) {
                    if (split[i5].indexOf("sle") != -1) {
                        split[i5] = "sle=" + a3.f68704i.f68705e;
                        z2 = true;
                    } else if (split[i5].indexOf("sl") != -1) {
                        split[i5] = "sl=" + ((int) ((a3.f68704i.f68706f * i2) / 8.0f));
                    } else if (split[i5].indexOf("split") != -1) {
                        split[i5] = "split=" + ((int) ((((a3.f68704i.f68707g * i2) * 1024.0f) / 8.0f) + i3));
                    } else {
                        if (split[i5].indexOf("vt") != -1) {
                            i4 = Integer.parseInt(split[i5].substring(3));
                            z = true;
                        }
                    }
                }
                if (!z || (i4 != 1 && i4 != 0)) {
                    CyberLog.i("PlayerServer-PlyrCnfgMngr", "This URI is not shot video!!!");
                    return uri;
                }
                try {
                    Uri.Builder buildUpon = uri.buildUpon();
                    buildUpon.clearQuery();
                    for (String str2 : split) {
                        String[] split2 = str2.split("=");
                        buildUpon.appendQueryParameter(split2[0], split2[1]);
                    }
                    if (!z2) {
                        buildUpon.appendQueryParameter("sle", "" + a3.f68704i.f68705e);
                        StringBuilder sb = new StringBuilder();
                        sb.append("");
                        sb.append((int) ((a3.f68704i.f68706f * ((float) i2)) / 8.0f));
                        buildUpon.appendQueryParameter("sl", sb.toString());
                        buildUpon.appendQueryParameter("split", "" + ((int) ((((a3.f68704i.f68707g * f2) * 1024.0f) / 8.0f) + i3)));
                    }
                    if (a3.f68701f != null && a3.f68701f.length() > 0) {
                        buildUpon.appendQueryParameter("ctid", a3.f68701f);
                    }
                    return buildUpon.build();
                } catch (Exception unused) {
                    return uri;
                }
            }
        }
    }

    public Uri rebuildUrlForPlay(String str, String str2, int i2, int i3) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return rebuildUrlForPlay(Uri.parse(str), str2, i2, i3);
    }

    @RequiresApi(api = 11)
    public b rebuildUrlForPrefetch(Uri uri, String str, int i2, int i3) {
        b bVar;
        String str2;
        float f2;
        if (uri == null || i2 <= 0 || i3 <= 0) {
            bVar = null;
            str2 = "(URI == NULL, BPS == 0 MOOV_SIZE == 0) rebuild url fail!";
        } else {
            c d2 = d(str);
            if (d2 == null && (d2 = getPlayerConfig()) == null) {
                CyberLog.d("PlayerServer-PlyrCnfgMngr", "rebuildUrl get container null!");
                return null;
            } else if ((System.currentTimeMillis() / 1000) - d2.f8073b > d2.f8072a * 4) {
                CyberLog.d("PlayerServer-PlyrCnfgMngr", "This config is time out!");
                return null;
            } else {
                int a2 = a(uri);
                if (a2 == -1) {
                    return null;
                }
                d.a.y.d.a a3 = d2.a(a2);
                CyberLog.d("PlayerServer-PlyrCnfgMngr", "" + a3);
                if (!a3.c()) {
                    CyberLog.i("PlayerServer-PlyrCnfgMngr", "The player server config is invalidate, use old uri continue!");
                    return null;
                } else if (!f(uri.getHost(), a3.f68700e)) {
                    CyberLog.i("PlayerServer-PlyrCnfgMngr", "host : " + uri.getHost() + " not match");
                    return null;
                } else {
                    String query = uri.getQuery();
                    if (query == null || query.isEmpty()) {
                        bVar = null;
                        str2 = "This host has no query!";
                    } else {
                        String[] split = query.split("&");
                        boolean z = false;
                        int i4 = -1;
                        boolean z2 = false;
                        for (int i5 = 0; i5 < split.length; i5++) {
                            if (split[i5].indexOf("sle") != -1) {
                                split[i5] = "sle=" + a3.j.f68711h;
                                z2 = true;
                            } else if (split[i5].indexOf("sl") != -1) {
                                split[i5] = "sl=" + ((int) ((a3.j.f68712i * i2) / 8.0f));
                            } else if (split[i5].indexOf("split") != -1) {
                                split[i5] = "split=" + ((int) ((((a3.j.j * i2) * 1024.0f) / 8.0f) + i3));
                            } else {
                                if (split[i5].indexOf("vt") != -1) {
                                    i4 = Integer.parseInt(split[i5].substring(3));
                                    z = true;
                                }
                            }
                        }
                        if (z && (i4 == 1 || i4 == 0)) {
                            try {
                                Uri.Builder buildUpon = uri.buildUpon();
                                buildUpon.clearQuery();
                                for (String str3 : split) {
                                    String[] split2 = str3.split("=");
                                    buildUpon.appendQueryParameter(split2[0], split2[1]);
                                }
                                if (!z2) {
                                    buildUpon.appendQueryParameter("sle", "" + a3.j.f68711h);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("");
                                    sb.append((int) ((a3.j.f68712i * ((float) i2)) / 8.0f));
                                    buildUpon.appendQueryParameter("sl", sb.toString());
                                    buildUpon.appendQueryParameter("split", "" + ((int) ((((a3.j.j * f2) * 1024.0f) / 8.0f) + i3)));
                                }
                                if (a3.f68701f != null && a3.f68701f.length() > 0) {
                                    buildUpon.appendQueryParameter("ctid", a3.f68701f);
                                }
                                return new b(buildUpon.build().toString(), (((i2 * 1024) / 8) * a3.j.f68708e) + i3);
                            } catch (Exception unused) {
                                return null;
                            }
                        }
                        bVar = null;
                        str2 = "This URI is not shot video!!!";
                    }
                }
            }
        }
        CyberLog.i("PlayerServer-PlyrCnfgMngr", str2);
        return bVar;
    }

    public b rebuildUrlForPrefetch(String str, String str2, int i2, int i3) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return rebuildUrlForPrefetch(Uri.parse(str), str2, i2, i3);
    }

    public void updatePlayerConfig(@NonNull String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        Handler handler = this.f8067c;
        if (handler != null) {
            handler.post(new a(str));
            return;
        }
        synchronized (PlayerConfigManagerInternal.class) {
            this.f8065a = d(str);
        }
    }
}
