package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobstat.bs;
import com.tencent.connect.common.Constants;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class bf {
    public static volatile boolean a;
    public static volatile boolean b;
    public static volatile boolean c;

    public static String a() {
        return "https://dxp.baidu.com/vizParser";
    }

    public static String a(Context context) {
        String a2 = bn.a(context, af.b);
        ArrayList<Pair> arrayList = new ArrayList();
        if (!TextUtils.isEmpty(a2)) {
            String a3 = bs.a.a(a2.getBytes());
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
        arrayList.add(new Pair(com.heytap.mcssdk.constant.b.C, StatService.getSdkVersion()));
        arrayList.add(new Pair("appKey", "" + str));
        arrayList.add(new Pair("packageName", context.getPackageName()));
        arrayList.add(new Pair("appVersion", bw.g(context)));
        arrayList.add(new Pair("cuid", CooperService.instance().getCUID(context, false)));
        arrayList.add(new Pair("imei", CooperService.instance().getDevicImei(context)));
        arrayList.add(new Pair(Constants.PARAM_PLATFORM, "Android"));
        arrayList.add(new Pair("model", CooperService.instance().getPhoneModel()));
        arrayList.add(new Pair("s", Build.VERSION.SDK_INT + ""));
        arrayList.add(new Pair("o", CooperService.instance().getOSSysVersion()));
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

    public static String a(Context context, String str, int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return "";
                }
                return a(context, str);
            }
            return a(context);
        }
        return a();
    }

    public static void a(int i, boolean z) {
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    c = z;
                    return;
                }
                return;
            }
            b = z;
            return;
        }
        a = z;
    }

    public static boolean a(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return false;
                }
                return c;
            }
            return b;
        }
        return a;
    }

    public static String b(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return "";
                }
                return af.c;
            }
            return af.b;
        }
        return af.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x012a, code lost:
        if (r4 != null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x012c, code lost:
        r4.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0138, code lost:
        if (r4 != null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x013c, code lost:
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean a(Context context, String str, int i, boolean z) {
        synchronized (bf.class) {
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
            if (bc.c().b() && z) {
                bc c2 = bc.c();
                c2.a("requestUrl:" + a2);
            }
            if (bg.c().b()) {
                bg c3 = bg.c();
                c3.a("requestUrl:" + a2);
            }
            String b2 = b(i);
            if (TextUtils.isEmpty(b2)) {
                return false;
            }
            HttpURLConnection httpURLConnection = null;
            try {
                httpURLConnection = bn.d(context, a2);
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
                if (bc.c().b() && z) {
                    bc c4 = bc.c();
                    c4.a("contentLength:" + contentLength + " fileName:" + b2);
                }
                if (bg.c().b()) {
                    bg c5 = bg.c();
                    c5.a("contentLength:" + contentLength + " fileName:" + b2);
                }
                if (responseCode == 200) {
                    if (i != 1) {
                        if (i == 2) {
                            bp.a().c(context, System.currentTimeMillis());
                        }
                    } else {
                        bp.a().a(context, System.currentTimeMillis());
                        bp.a().b(context, j);
                    }
                    if (contentLength > 0) {
                        FileOutputStream openFileOutput = context.openFileOutput(b2, 0);
                        boolean a3 = bt.a(httpURLConnection.getInputStream(), openFileOutput);
                        try {
                            bt.a(openFileOutput);
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
}
