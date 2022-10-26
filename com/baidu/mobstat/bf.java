package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobstat.bs;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.heytap.mcssdk.mode.CommandMessage;
import com.tencent.connect.common.Constants;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class bf {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? "https://dxp.baidu.com/vizParser" : (String) invokeV.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
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
        return (String) invokeLL.objValue;
    }

    public static String a(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, context, str, i)) == null) {
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
        return (String) invokeLLI.objValue;
    }

    public static void a(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
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
    }

    public static boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
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
        return invokeI.booleanValue;
    }

    public static String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
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
        return (String) invokeI.objValue;
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
    public static synchronized boolean a(Context context, String str, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{context, str, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
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
        } else {
            return invokeCommon.booleanValue;
        }
    }
}
