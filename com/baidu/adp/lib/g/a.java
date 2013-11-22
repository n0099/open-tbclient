package com.baidu.adp.lib.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.baidu.adp.lib.network.g;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.loginshare.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f484a;
    private static int b = 20;
    private Context c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private boolean n;
    private ArrayList<c> o = new ArrayList<>();
    private ArrayList<c> p = new ArrayList<>();

    public static a a() {
        if (f484a == null) {
            f484a = new a();
        }
        return f484a;
    }

    public void a(Context context, String str, String str2, String str3, String str4, String str5) {
        this.c = context;
        this.d = str2;
        this.f = str3;
        this.h = str4;
        this.i = str5;
        this.k = Build.MODEL;
        this.l = Build.VERSION.RELEASE;
        this.m = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        this.j = str;
    }

    public void a(String str, String str2) {
        this.e = str;
        this.g = str2;
    }

    public void a(boolean z, Object... objArr) {
        if (objArr != null) {
            c cVar = new c();
            for (int i = 0; i < objArr.length / 2; i++) {
                if ((i * 2) + 1 < objArr.length) {
                    cVar.a(objArr[i * 2], objArr[(i * 2) + 1]);
                }
            }
            synchronized (this.o) {
                if (this.n) {
                    this.p.add(cVar);
                } else {
                    this.o.add(cVar);
                    int size = this.o.size();
                    if (z || size >= b) {
                        b();
                    }
                }
            }
        }
    }

    public void a(String str, long j, long j2) {
        a().a(false, "op_key", str, "is_net", 0, "cost", Long.valueOf(j), "result", Long.valueOf(j2), "module", "op");
    }

    public void a(String str, long j, long j2, long j3, long j4, long j5, long j6, int i, long j7) {
        a().a(false, "cost", Long.valueOf(j3), "dns_cost", Long.valueOf(j4), "con_cost", Long.valueOf(j5), "rsp_cost", Long.valueOf(j6), "result", Long.valueOf(j7), "module", e.e, "logid", Long.valueOf(System.currentTimeMillis()), "interface", str, "retry", Integer.valueOf(i), "size_d", Long.valueOf(j), "size_u", Long.valueOf(j2), e.e, c());
    }

    public void a(String str) {
        a().a(true, "module", "crash", "crash_type", str, e.e, c());
    }

    public void b() {
        if (!this.n) {
            this.n = true;
            new Thread(new b(this)).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        synchronized (this.o) {
            while (this.o.size() > b - 1) {
                this.o.remove(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        synchronized (this.o) {
            this.o.clear();
            if (this.p.size() > 0) {
                this.o.addAll(this.p);
                this.p.clear();
            }
        }
    }

    private String f() {
        StringBuilder sb = new StringBuilder();
        sb.append("product=");
        try {
            sb.append(URLEncoder.encode(this.h, BdUtil.UTF8));
            sb.append("&sub_sys=");
            sb.append(URLEncoder.encode(this.i, BdUtil.UTF8));
            sb.append("&version=");
            sb.append(URLEncoder.encode(this.j, BdUtil.UTF8));
            sb.append("&os=");
            sb.append(SocialConstants.ANDROID_CLIENT_TYPE);
            sb.append("&os_version=");
            sb.append(URLEncoder.encode(this.l, BdUtil.UTF8));
            if (this.d != null && this.d.length() > 0) {
                sb.append("&from=");
                sb.append(URLEncoder.encode(this.d, BdUtil.UTF8));
            }
            sb.append("&phone=");
            sb.append(URLEncoder.encode(this.k, BdUtil.UTF8));
            if (this.e != null && this.e.length() > 0) {
                sb.append("&uid=");
                sb.append(URLEncoder.encode(this.e, BdUtil.UTF8));
            }
            if (this.f != null && this.f.length() > 0) {
                sb.append("&client_id=");
                sb.append(URLEncoder.encode(this.f, BdUtil.UTF8));
            }
            if (this.m != null && this.m.length() > 0) {
                sb.append("&imei=");
                sb.append(URLEncoder.encode(this.m, BdUtil.UTF8));
            }
            if (this.g != null && this.g.length() > 0) {
                sb.append("&uname=");
                sb.append(URLEncoder.encode(this.g, BdUtil.UTF8));
            }
            sb.append("&net=");
            sb.append(URLEncoder.encode(c(), BdUtil.UTF8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] g() {
        StringBuilder sb = new StringBuilder();
        sb.append(f());
        synchronized (this.o) {
            int size = this.o.size();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    sb.append("&rec");
                    sb.append(i);
                    sb.append('=');
                    try {
                        sb.append(URLEncoder.encode(this.o.get(i).toString(), BdUtil.UTF8));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                return sb.toString().getBytes();
            }
            return null;
        }
    }

    public String c() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.c.getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                return "WIFI";
            }
            if (type == 0) {
                int c = g.c();
                StringBuilder sb = new StringBuilder();
                switch (c) {
                    case 1:
                        sb.append('M');
                        break;
                    case 2:
                        sb.append('U');
                        break;
                    case 3:
                        sb.append('T');
                        break;
                    default:
                        sb.append('N');
                        break;
                }
                if (activeNetworkInfo.getExtraInfo().contains(e.d)) {
                    sb.append("_WAP_");
                } else {
                    sb.append("_NET_");
                }
                switch (((TelephonyManager) this.c.getSystemService("phone")).getNetworkType()) {
                    case 1:
                    case 2:
                    case 4:
                    case 5:
                        sb.append("2G");
                        break;
                    case 3:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        sb.append("3G");
                        break;
                    default:
                        sb.append('N');
                        break;
                }
                return sb.toString();
            }
        }
        return "unknown";
    }
}
