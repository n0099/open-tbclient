package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobstat.bt;
import com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity;
import com.heytap.mcssdk.mode.CommandMessage;
import com.tencent.connect.common.Constants;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class bg {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f9089a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f9090b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f9091c;

    public static String a() {
        return "https://dxp.baidu.com/vizParser";
    }

    public static boolean a(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return f9091c;
            }
            return f9090b;
        }
        return f9089a;
    }

    public static String b(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "" : "mtj_auto.config" : "mtj_autoTracker.js" : "mtj_vizParser.js";
    }

    public static void a(int i, boolean z) {
        if (i == 0) {
            f9089a = z;
        } else if (i == 1) {
            f9090b = z;
        } else if (i != 2) {
        } else {
            f9091c = z;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0128, code lost:
        if (r4 != null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x012a, code lost:
        r4.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0136, code lost:
        if (r4 != null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x013a, code lost:
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean a(Context context, String str, int i, boolean z) {
        synchronized (bg.class) {
            boolean z2 = true;
            if (a(i)) {
                return true;
            }
            if (context == null) {
                return false;
            }
            String a2 = a(context, str, i);
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            if (bd.c().b() && z) {
                bd c2 = bd.c();
                c2.a("requestUrl:" + a2);
            }
            if (bh.c().b()) {
                bh c3 = bh.c();
                c3.a("requestUrl:" + a2);
            }
            String b2 = b(i);
            if (TextUtils.isEmpty(b2)) {
                return false;
            }
            HttpURLConnection httpURLConnection = null;
            try {
                httpURLConnection = bo.d(context, a2);
                httpURLConnection.connect();
                long j = 0;
                if (i == 1) {
                    try {
                        j = Long.valueOf(httpURLConnection.getHeaderField("X-INTERVAL")).longValue();
                    } catch (Exception unused) {
                    }
                }
                int responseCode = httpURLConnection.getResponseCode();
                int contentLength = httpURLConnection.getContentLength();
                if (bd.c().b() && z) {
                    bd c4 = bd.c();
                    c4.a("contentLength:" + contentLength + " fileName:" + b2);
                }
                if (bh.c().b()) {
                    bh c5 = bh.c();
                    c5.a("contentLength:" + contentLength + " fileName:" + b2);
                }
                if (responseCode == 200) {
                    if (i == 1) {
                        bq.a().a(context, System.currentTimeMillis());
                        bq.a().b(context, j);
                    } else if (i == 2) {
                        bq.a().c(context, System.currentTimeMillis());
                    }
                    if (contentLength > 0) {
                        FileOutputStream openFileOutput = context.openFileOutput(b2, 0);
                        boolean a3 = bu.a(httpURLConnection.getInputStream(), openFileOutput);
                        try {
                            bu.a(openFileOutput);
                        } catch (Exception unused2) {
                            z2 = a3;
                        }
                    }
                    try {
                        a(i, true);
                    } catch (Exception unused3) {
                    }
                } else {
                    z2 = false;
                }
            } catch (Exception unused4) {
                z2 = false;
            }
        }
    }

    public static String a(Context context, String str, int i) {
        if (i != 0) {
            if (i != 1) {
                return i != 2 ? "" : a(context, str);
            }
            return a(context);
        }
        return a();
    }

    public static String a(Context context) {
        String a2 = bo.a(context, "mtj_autoTracker.js");
        ArrayList<Pair> arrayList = new ArrayList();
        if (!TextUtils.isEmpty(a2)) {
            String a3 = bt.a.a(a2.getBytes());
            if (!TextUtils.isEmpty(a3)) {
                arrayList.add(new Pair("sign", a3));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Pair pair : arrayList) {
            try {
                String encode = URLEncoder.encode(((String) pair.first).toString(), "UTF-8");
                String encode2 = URLEncoder.encode(((String) pair.second).toString(), "UTF-8");
                if (TextUtils.isEmpty(sb.toString())) {
                    sb.append(encode + "=" + encode2);
                } else {
                    sb.append("&" + encode + "=" + encode2);
                }
            } catch (Exception unused) {
            }
        }
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            return "https://dxp.baidu.com/autoTracker";
        }
        return "https://dxp.baidu.com/autoTracker?" + sb2;
    }

    public static String a(Context context, String str) {
        ArrayList<Pair> arrayList = new ArrayList();
        arrayList.add(new Pair(CommandMessage.SDK_VERSION, StatService.getSdkVersion()));
        arrayList.add(new Pair("appKey", "" + str));
        arrayList.add(new Pair(InstallAntiBlockingActivity.PARAM_PACKAGE_NAME, context.getPackageName()));
        arrayList.add(new Pair("appVersion", bw.g(context)));
        arrayList.add(new Pair("cuid", CooperService.instance().getCUID(context, false)));
        arrayList.add(new Pair("imei", CooperService.instance().getDevicImei(context)));
        arrayList.add(new Pair(Constants.PARAM_PLATFORM, "Android"));
        arrayList.add(new Pair("model", android.os.Build.MODEL));
        arrayList.add(new Pair("s", Build.VERSION.SDK_INT + ""));
        arrayList.add(new Pair(Config.OS, Build.VERSION.RELEASE));
        StringBuilder sb = new StringBuilder();
        for (Pair pair : arrayList) {
            try {
                String encode = URLEncoder.encode(((String) pair.first).toString(), "UTF-8");
                String encode2 = URLEncoder.encode(((String) pair.second).toString(), "UTF-8");
                if (TextUtils.isEmpty(sb.toString())) {
                    sb.append(encode + "=" + encode2);
                } else {
                    sb.append("&" + encode + "=" + encode2);
                }
            } catch (Exception unused) {
            }
        }
        return "https://dxp.baidu.com/circleConfig?" + sb.toString();
    }
}
