package com.baidu.sapi2.utils.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.loginshare.e;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.a.i;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private static a a = null;
    private static final String b = "http://or.baidu.com/or/api/get";
    private static int c = 1;
    private Context d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private boolean j;
    private final ArrayList<b> k = new ArrayList<>();
    private ArrayList<b> l = new ArrayList<>();

    public static a a() {
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
        }
        return a;
    }

    public void a(Context context) {
        this.d = context;
        this.e = Build.VERSION.RELEASE;
        this.f = ((TelephonyManager) this.d.getSystemService("phone")).getDeviceId();
        this.g = SapiAccountManager.VERSION_NAME;
        this.h = SapiAccountManager.getInstance().getSapiConfiguration().tpl;
        this.i = SapiAccountManager.getInstance().getSapiConfiguration().loginShareStrategy.getStrValue();
    }

    public void a(boolean z, Object... objArr) {
        if (objArr != null) {
            b bVar = new b();
            for (int i = 0; i < objArr.length / 2; i++) {
                if ((i * 2) + 1 < objArr.length) {
                    bVar.a(objArr[i * 2], objArr[(i * 2) + 1]);
                }
            }
            synchronized (this.k) {
                if (this.j) {
                    this.l.add(bVar);
                } else {
                    this.k.add(bVar);
                    int size = this.k.size();
                    if (z || size >= c) {
                        b();
                    }
                }
            }
        }
    }

    public void a(String str, String str2, long j, long j2) {
        a().a(false, "op_key", str, "op_val", str2, "is_net", 0, "cost", Long.valueOf(j), "result", Long.valueOf(j2), "module", "op");
    }

    public void a(String str, long j, long j2) {
        a(str, "", j, j2);
    }

    public void a(String str, long j, long j2, long j3, long j4, long j5, long j6, int i, long j7) {
        a().a(false, "cost", Long.valueOf(j3), "dns_cost", Long.valueOf(j4), "con_cost", Long.valueOf(j5), "rsp_cost", Long.valueOf(j6), "result", Long.valueOf(j7), "module", e.e, "logid", Long.valueOf(System.currentTimeMillis()), "interface", str, "retry", Integer.valueOf(i), "size_d", Long.valueOf(j), "size_u", Long.valueOf(j2), e.e, c());
    }

    public void b() {
        if (!this.j) {
            this.j = true;
            try {
                com.baidu.sapi2.a.a aVar = new com.baidu.sapi2.a.a();
                byte[] g = g();
                if (g != null && g.length > 0) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    c.a(g, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    com.baidu.sapi2.a.b bVar = new com.baidu.sapi2.a.b();
                    bVar.a("monitor", new ByteArrayInputStream(byteArray));
                    aVar.b(this.d, b, bVar, new C0013a());
                }
            } catch (Exception e) {
                d();
                this.j = false;
                L.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sapi2.utils.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0013a extends i {
        C0013a() {
        }

        @Override // com.baidu.sapi2.a.i
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            a.this.e();
            a.this.j = false;
        }

        @Override // com.baidu.sapi2.a.i
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            a.this.d();
            a.this.j = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        synchronized (this.k) {
            while (this.k.size() > c - 1) {
                this.k.remove(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        synchronized (this.k) {
            this.k.clear();
            if (this.l.size() > 0) {
                this.k.addAll(this.l);
                this.l.clear();
            }
        }
    }

    private String f() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("product=");
            sb.append(URLEncoder.encode("pass", "utf-8"));
            sb.append("&sub_sys=");
            sb.append(URLEncoder.encode("sapi_android", "utf-8"));
            sb.append("&env=");
            sb.append(URLEncoder.encode(SapiAccountManager.getInstance().getSapiConfiguration().environment.name(), "utf-8"));
            sb.append("&tpl=");
            sb.append(URLEncoder.encode(this.h, "utf-8"));
            sb.append("&share_mode=");
            sb.append(URLEncoder.encode(this.i, "utf-8"));
            sb.append("&version=");
            sb.append(URLEncoder.encode(this.g, "utf-8"));
            sb.append("&os=");
            sb.append(SocialConstants.ANDROID_CLIENT_TYPE);
            sb.append("&os_version=");
            sb.append(URLEncoder.encode(this.e, "utf-8"));
            if (this.f != null && this.f.length() > 0) {
                sb.append("&imei=");
                sb.append(URLEncoder.encode(this.f, "utf-8"));
            }
            sb.append("&net=");
            sb.append(URLEncoder.encode(c(), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private byte[] g() {
        StringBuilder sb = new StringBuilder();
        sb.append(f());
        synchronized (this.k) {
            int size = this.k.size();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    sb.append("&rec");
                    sb.append(i);
                    sb.append('=');
                    try {
                        sb.append(URLEncoder.encode(this.k.get(i).toString(), "utf-8"));
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
        ConnectivityManager connectivityManager = (ConnectivityManager) this.d.getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                return "WIFI";
            }
            if (type == 0) {
                int readNetworkOperatorType = SapiUtils.readNetworkOperatorType(this.d);
                StringBuilder sb = new StringBuilder();
                switch (readNetworkOperatorType) {
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
                if (activeNetworkInfo.getExtraInfo() != null) {
                    if (activeNetworkInfo.getExtraInfo().contains(e.d)) {
                        sb.append("_WAP_");
                    } else {
                        sb.append("_NET_");
                    }
                } else {
                    sb.append("_");
                }
                switch (((TelephonyManager) this.d.getSystemService("phone")).getNetworkType()) {
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
