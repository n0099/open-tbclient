package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.bt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.heytap.mcssdk.mode.CommandMessage;
import com.tencent.connect.common.Constants;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class bg {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f8821a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f8822b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f8823c;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? "https://dxp.baidu.com/vizParser" : (String) invokeV.objValue;
    }

    public static boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        return false;
                    }
                    return f8823c;
                }
                return f8822b;
            }
            return f8821a;
        }
        return invokeI.booleanValue;
    }

    public static String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) ? i2 != 0 ? i2 != 1 ? i2 != 2 ? "" : "mtj_auto.config" : "mtj_autoTracker.js" : "mtj_vizParser.js" : (String) invokeI.objValue;
    }

    public static void a(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65540, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 == 0) {
                f8821a = z;
            } else if (i2 == 1) {
                f8822b = z;
            } else if (i2 != 2) {
            } else {
                f8823c = z;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x012c, code lost:
        if (r4 != null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x012e, code lost:
        r4.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x013a, code lost:
        if (r4 != null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x013e, code lost:
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean a(Context context, String str, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{context, str, Integer.valueOf(i2), Boolean.valueOf(z)})) != null) {
            return invokeCommon.booleanValue;
        }
        synchronized (bg.class) {
            boolean z2 = true;
            if (a(i2)) {
                return true;
            }
            if (context == null) {
                return false;
            }
            String a2 = a(context, str, i2);
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
            String b2 = b(i2);
            if (TextUtils.isEmpty(b2)) {
                return false;
            }
            HttpURLConnection httpURLConnection = null;
            try {
                httpURLConnection = bo.d(context, a2);
                httpURLConnection.connect();
                long j = 0;
                if (i2 == 1) {
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
                    if (i2 == 1) {
                        bq.a().a(context, System.currentTimeMillis());
                        bq.a().b(context, j);
                    } else if (i2 == 2) {
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
                        a(i2, true);
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

    public static String a(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, context, str, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    return i2 != 2 ? "" : a(context, str);
                }
                return a(context);
            }
            return a();
        }
        return (String) invokeLLI.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            ArrayList<Pair> arrayList = new ArrayList();
            arrayList.add(new Pair(CommandMessage.SDK_VERSION, StatService.getSdkVersion()));
            arrayList.add(new Pair("appKey", "" + str));
            arrayList.add(new Pair("packageName", context.getPackageName()));
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
        return (String) invokeLL.objValue;
    }
}
