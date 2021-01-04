package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobstat.bt;
import com.baidu.webkit.internal.ETAG;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
/* loaded from: classes15.dex */
public class bg {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f3787a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f3788b;
    private static volatile boolean c;

    private static boolean a(int i) {
        switch (i) {
            case 0:
                return f3787a;
            case 1:
                return f3788b;
            case 2:
                return c;
            default:
                return false;
        }
    }

    private static void a(int i, boolean z) {
        switch (i) {
            case 0:
                f3787a = z;
                return;
            case 1:
                f3788b = z;
                return;
            case 2:
                c = z;
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0138 A[Catch: all -> 0x011e, TRY_ENTER, TRY_LEAVE, TryCatch #5 {, blocks: (B:4:0x0005, B:10:0x0011, B:13:0x001d, B:16:0x0029, B:17:0x0044, B:19:0x004e, B:20:0x0069, B:54:0x0138, B:44:0x0119, B:24:0x0076, B:27:0x0081, B:28:0x0090, B:31:0x00a4, B:32:0x00ca, B:34:0x00d4, B:37:0x00fe, B:39:0x0103, B:40:0x0110, B:42:0x0114, B:49:0x0121, B:56:0x013d), top: B:77:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean a(Context context, String str, int i, boolean z) {
        boolean z2 = true;
        synchronized (bg.class) {
            if (!a(i)) {
                if (context == null) {
                    z2 = false;
                } else {
                    String a2 = a(context, str, i);
                    if (TextUtils.isEmpty(a2)) {
                        z2 = false;
                    } else {
                        if (bd.c().b() && z) {
                            bd.c().a("requestUrl:" + a2);
                        }
                        if (bh.c().b()) {
                            bh.c().a("requestUrl:" + a2);
                        }
                        String b2 = b(i);
                        if (TextUtils.isEmpty(b2)) {
                            z2 = false;
                        } else {
                            HttpURLConnection httpURLConnection = null;
                            try {
                                httpURLConnection = bo.d(context, a2);
                                httpURLConnection.connect();
                                long j = 0;
                                if (i == 1) {
                                    try {
                                        j = Long.valueOf(httpURLConnection.getHeaderField("X-INTERVAL")).longValue();
                                    } catch (Exception e) {
                                    }
                                }
                                int responseCode = httpURLConnection.getResponseCode();
                                int contentLength = httpURLConnection.getContentLength();
                                if (bd.c().b() && z) {
                                    bd.c().a("contentLength:" + contentLength + " fileName:" + b2);
                                }
                                if (bh.c().b()) {
                                    bh.c().a("contentLength:" + contentLength + " fileName:" + b2);
                                }
                                if (responseCode == 200) {
                                    switch (i) {
                                        case 1:
                                            bq.a().a(context, System.currentTimeMillis());
                                            bq.a().b(context, j);
                                            break;
                                        case 2:
                                            bq.a().c(context, System.currentTimeMillis());
                                            break;
                                    }
                                    if (contentLength > 0) {
                                        FileOutputStream openFileOutput = context.openFileOutput(b2, 0);
                                        boolean a3 = bu.a(httpURLConnection.getInputStream(), openFileOutput);
                                        try {
                                            bu.a(openFileOutput);
                                        } catch (Exception e2) {
                                            z2 = a3;
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            return z2;
                                        }
                                    }
                                    try {
                                        a(i, true);
                                    } catch (Exception e3) {
                                        if (httpURLConnection != null) {
                                        }
                                        return z2;
                                    }
                                } else {
                                    z2 = false;
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                            } catch (Exception e4) {
                                z2 = false;
                            }
                        }
                    }
                }
            }
        }
        return z2;
    }

    private static String a(Context context, String str, int i) {
        switch (i) {
            case 0:
                return a();
            case 1:
                return a(context);
            case 2:
                return a(context, str);
            default:
                return "";
        }
    }

    private static String a() {
        return "https://dxp.baidu.com/vizParser";
    }

    private static String a(Context context) {
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
                    sb.append(ETAG.ITEM_SEPARATOR + encode + "=" + encode2);
                }
            } catch (Exception e) {
            }
        }
        String sb2 = sb.toString();
        return !TextUtils.isEmpty(sb2) ? "https://dxp.baidu.com/autoTracker?" + sb2 : "https://dxp.baidu.com/autoTracker";
    }

    private static String a(Context context, String str) {
        ArrayList<Pair> arrayList = new ArrayList();
        arrayList.add(new Pair(CommandMessage.SDK_VERSION, StatService.getSdkVersion()));
        arrayList.add(new Pair("appKey", "" + str));
        arrayList.add(new Pair("packageName", context.getPackageName()));
        arrayList.add(new Pair("appVersion", bw.g(context)));
        arrayList.add(new Pair("cuid", CooperService.instance().getCUID(context, false)));
        arrayList.add(new Pair("imei", CooperService.instance().getDevicImei(context)));
        arrayList.add(new Pair("platform", "Android"));
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
                    sb.append(ETAG.ITEM_SEPARATOR + encode + "=" + encode2);
                }
            } catch (Exception e) {
            }
        }
        return "https://dxp.baidu.com/circleConfig?" + sb.toString();
    }

    private static String b(int i) {
        switch (i) {
            case 0:
                return "mtj_vizParser.js";
            case 1:
                return "mtj_autoTracker.js";
            case 2:
                return "mtj_auto.config";
            default:
                return "";
        }
    }
}
