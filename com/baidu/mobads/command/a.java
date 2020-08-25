package com.baidu.mobads.command;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class a implements Serializable {
    private long A;
    private boolean B;
    public String a;
    public String b;
    public String c;
    public int f;
    public String i;
    public String j;
    public String k;
    public boolean l;
    public String n;
    public String o;
    public String p;
    public String q;
    public long t;
    protected long u;
    protected long v;
    private long z;
    public long d = -1;
    public int e = 0;
    public IOAdDownloader.DownloadStatus g = IOAdDownloader.DownloadStatus.NONE;
    public Object h = null;
    public boolean m = true;
    public int r = 0;
    public boolean s = false;
    public boolean w = false;
    public String x = null;
    protected final IXAdLogger y = XAdSDKFoundationFacade.getInstance().getAdLogger();

    public a(String str, String str2) {
        this.i = str;
        this.a = str2;
    }

    public void a(String str, String str2, String str3, boolean z) {
        this.n = str;
        this.o = str2;
        this.j = str3;
        this.l = z;
    }

    public void a(String str, String str2) {
        this.b = str;
        this.c = str2;
    }

    public void b(String str, String str2) {
        this.p = str;
        this.q = str2;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS, this.g.getCode());
            jSONObject.put("filename", this.b);
            jSONObject.put("folder", this.c);
            jSONObject.put("title", this.a);
            jSONObject.put("contentLength", this.d);
            jSONObject.put("pk", this.i);
            jSONObject.put("qk", this.n);
            jSONObject.put("autoOpen", this.l);
            jSONObject.put("popNotify", this.m);
            jSONObject.put("adid", this.o);
            jSONObject.put("placeId", this.p);
            jSONObject.put("prod", this.q);
            jSONObject.put("dlTunnel", 4);
            if (this.k != null && this.k.length() > 0) {
                jSONObject.put("turl", this.k);
            } else {
                jSONObject.put("url", this.j);
            }
            jSONObject.put("mnCfm", this.s);
            jSONObject.put("dlCnt", this.r);
            jSONObject.put("cts", this.t);
            if (this.r == 1) {
                this.u = System.currentTimeMillis();
                this.v = Process.myPid();
            }
            jSONObject.put("ts", this.u);
            jSONObject.put("clickProcId", this.v);
        } catch (Exception e) {
            this.y.d(e);
        }
        return jSONObject;
    }

    public static String b() {
        return XAdSDKFoundationFacade.getInstance().getSystemUtils().getCurrentProcessName(XAdSDKFoundationFacade.getInstance().getApplicationContext());
    }

    public static a a(Context context, String str) {
        a aVar = null;
        if (str == null || "".equals(str)) {
            return null;
        }
        try {
            String string = context.getSharedPreferences(IXAdCommonUtils.PKGS_PREF_DOWNLOAD, 0).getString(str + "#$#" + b(), null);
            if (string != null) {
                JSONObject jSONObject = new JSONObject(string);
                String string2 = jSONObject.getString("title");
                String optString = jSONObject.optString("url", jSONObject.getString("turl"));
                a aVar2 = new a(str, string2);
                try {
                    aVar2.a(jSONObject.optString("qk"), jSONObject.optString("adid"), optString, jSONObject.optBoolean("autoOpen"));
                    aVar2.m = jSONObject.optBoolean("popNotify");
                    aVar2.a(jSONObject.getString("filename"), jSONObject.getString("folder"));
                    aVar2.b(jSONObject.optString("placeId"), jSONObject.optString("prod"));
                    int i = jSONObject.getInt(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS);
                    IOAdDownloader.DownloadStatus[] values = IOAdDownloader.DownloadStatus.values();
                    IOAdDownloader.DownloadStatus downloadStatus = IOAdDownloader.DownloadStatus.NONE;
                    for (int i2 = 0; i2 < values.length; i2++) {
                        if (values[i2].getCode() == i) {
                            downloadStatus = values[i2];
                        }
                    }
                    aVar2.g = downloadStatus;
                    aVar2.s = jSONObject.optBoolean("mnCfm");
                    aVar2.r = jSONObject.getInt("dlCnt");
                    aVar2.t = jSONObject.optLong("cts");
                    aVar2.u = jSONObject.optLong("ts");
                    aVar2.v = jSONObject.optInt("clickProcId");
                    return aVar2;
                } catch (Exception e) {
                    aVar = aVar2;
                    e = e;
                    XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
                    com.baidu.mobads.c.a.a().a("get stored download info failed: " + e.toString());
                    return aVar;
                }
            }
            return null;
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static List<String> a(Context context, long j) {
        int i;
        ArrayList arrayList = new ArrayList();
        try {
            for (Map.Entry<String, ?> entry : context.getSharedPreferences(IXAdCommonUtils.PKGS_PREF_DOWNLOAD, 0).getAll().entrySet()) {
                try {
                    String b = b();
                    String key = entry.getKey();
                    if (key.contains("#$#" + b)) {
                        JSONObject jSONObject = new JSONObject((String) entry.getValue());
                        if (jSONObject.getLong("cts") >= j && ((i = jSONObject.getInt(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS)) == 0 || i == 1 || i == 4)) {
                            arrayList.add(key.substring(0, key.indexOf("#$#")));
                        }
                    }
                } catch (Exception e) {
                    XAdSDKFoundationFacade.getInstance().getAdLogger().d("XAdDownloaderManager", e.getMessage());
                }
            }
        } catch (Exception e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e2);
        }
        return arrayList;
    }

    public long c() {
        return this.z;
    }

    public void a(long j) {
        this.z = j;
    }

    public String d() {
        return this.i;
    }

    public long e() {
        return this.A;
    }

    public boolean f() {
        return this.B;
    }

    public void a(boolean z) {
        this.B = z;
    }

    public void b(long j) {
        this.A = j;
    }

    @TargetApi(9)
    public void a(Context context) {
        if (this.i != null && !"".equals(this.i)) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences(IXAdCommonUtils.PKGS_PREF_DOWNLOAD, 0).edit();
                edit.putString(this.i + "#$#" + b(), a().toString());
                if (Build.VERSION.SDK_INT >= 9) {
                    edit.apply();
                } else {
                    edit.commit();
                }
            } catch (Exception e) {
                XAdSDKFoundationFacade.getInstance().getAdLogger().d("XAdAPKDownloadExtraInfo", e);
            }
        }
    }

    public String g() {
        return this.o;
    }

    public String h() {
        return this.n;
    }

    public String i() {
        return this.q;
    }
}
