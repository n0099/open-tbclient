package com.baidu.sofire.a;

import android.accounts.NetworkErrorException;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.TrafficStats;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.newwidget.ImageView.BDImageView;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.sofire.MyService;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.k.i;
import com.baidu.sofire.k.j;
import com.baidu.sofire.k.p;
import com.baidu.sofire.k.t;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.sofire.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0173a extends Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0173a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.sofire.ac.Callback
        public Object onEnd(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                return super.onEnd(objArr);
            }
            return invokeL.objValue;
        }
    }

    public static String a(Context context, String str, String str2, boolean z, boolean z2) throws Throwable {
        InterceptResult invokeCommon;
        byte[] bytes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{context, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            String[] o = com.baidu.sofire.k.b.o(context);
            String str3 = o[0];
            String str4 = o[1];
            if ("com.baidu.input_huawei".equals(context.getPackageName()) && !com.baidu.sofire.j.a.a(context).b()) {
                throw new NetworkErrorException("conn is blocked");
            }
            String valueOf = String.valueOf(new Date().getTime() / 1000);
            String a = j.a(str3 + valueOf + str4);
            Random random = t.a;
            char[] charArray = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
            char[] cArr = new char[16];
            for (int i = 0; i < 16; i++) {
                cArr[i] = charArray[t.a.nextInt(62)];
            }
            byte[] bytes2 = new String(cArr).getBytes();
            String str5 = "";
            if (!TextUtils.isEmpty(str2)) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str2.getBytes());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = byteArrayInputStream.read(bArr, 0, 2048);
                    if (read == -1) {
                        break;
                    }
                    gZIPOutputStream.write(bArr, 0, read);
                }
                gZIPOutputStream.flush();
                gZIPOutputStream.finish();
                gZIPOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                byteArrayInputStream.close();
                bytes = F.getInstance().ae(byteArray, bytes2);
            } else {
                bytes = "".getBytes();
            }
            byte[] bytes3 = j.a(com.baidu.sofire.k.d.a(context)).getBytes();
            String encodeToString = Base64.encodeToString(F.getInstance().re(bytes2, bytes3), 0);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("/");
            sb.append(YYOption.UrlProtocol.USER);
            sb.append("/");
            sb.append(str3);
            sb.append("/");
            sb.append(valueOf);
            sb.append("/");
            sb.append(a);
            if (!TextUtils.isEmpty(encodeToString)) {
                sb.append("?skey=");
                sb.append(URLEncoder.encode(encodeToString, "utf-8"));
            }
            try {
                str5 = a(context, false, sb, bytes);
            } catch (Throwable unused) {
                int i2 = b.a;
            }
            if (z && TextUtils.isEmpty(str5)) {
                try {
                    com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(context);
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = a2.a.getLong("pu_cl_fd", 0L);
                    if (j == 0) {
                        j = System.currentTimeMillis();
                        a2.b.putLong("pu_cl_fd", System.currentTimeMillis());
                        a2.b.commit();
                    }
                    if (currentTimeMillis - j > 86400000) {
                        HashMap hashMap = new HashMap();
                        if (com.baidu.sofire.k.b.l(context)) {
                            hashMap.put("0", Integer.valueOf(a2.k() + 1));
                            hashMap.put("1", Integer.valueOf(a2.j()));
                        } else {
                            hashMap.put("0", Integer.valueOf(a2.k()));
                            hashMap.put("1", Integer.valueOf(a2.j() + 1));
                        }
                        a2.b.putInt("mo_fa_pu_cl", 0);
                        a2.b.commit();
                        a2.b.putInt("wi_fa_pu_cl", 0);
                        a2.b.commit();
                        a2.b.putLong("pu_cl_fd", System.currentTimeMillis());
                        a2.b.commit();
                        com.baidu.sofire.k.b.a(context, "1003112", (Map<String, Object>) hashMap, false);
                    } else if (com.baidu.sofire.k.b.l(context)) {
                        a2.c(a2.k() + 1);
                    } else {
                        a2.b(a2.j() + 1);
                    }
                } catch (Throwable unused2) {
                    int i3 = b.a;
                }
                throw new NetworkErrorException("response is empty");
            } else if (z2) {
                JSONObject jSONObject = new JSONObject(str5);
                byte[] rd = F.getInstance().rd(Base64.decode(jSONObject.optString("skey"), 0), bytes3);
                String optString = jSONObject.optString("response");
                jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
                byte[] decode = Base64.decode(optString, 0);
                byte[] ad = F.getInstance().ad(decode, rd);
                if (decode != null && decode.length > 0 && (ad == null || ad.length == 0)) {
                    com.baidu.sofire.j.a a3 = com.baidu.sofire.j.a.a(context);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    long j2 = a3.a.getLong("se_ae_fd", 0L);
                    if (j2 == 0) {
                        j2 = System.currentTimeMillis();
                        a3.b.putLong("se_ae_fd", System.currentTimeMillis());
                        a3.b.commit();
                    }
                    if (currentTimeMillis2 - j2 > 86400000) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("0", Integer.valueOf(a3.a.getInt("mo_ae_fa_ct", 0) + 1));
                        a3.b.putInt("mo_ae_fa_ct", 0);
                        a3.b.commit();
                        a3.b.putLong("se_ae_fd", System.currentTimeMillis());
                        a3.b.commit();
                        com.baidu.sofire.k.b.a(context, "1003119", (Map<String, Object>) hashMap2, false);
                    } else {
                        a3.b.putInt("mo_ae_fa_ct", a3.a.getInt("mo_ae_fa_ct", 0) + 1);
                        a3.b.commit();
                    }
                    throw new NetworkErrorException("aes is fail");
                }
                return new String(ad);
            } else {
                return str5;
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static String a(Context context, boolean z, StringBuilder sb, byte[] bArr) {
        String a;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, Boolean.valueOf(z), sb, bArr})) == null) {
            try {
                if (z) {
                    if (p.a(context)) {
                        a = new p(context).a(sb.toString());
                    } else {
                        a = new i(context).a(sb.toString());
                    }
                } else if (p.a(context)) {
                    a = new p(context).b(sb.toString(), bArr);
                } else {
                    a = new i(context).a(sb.toString(), bArr);
                }
                return a;
            } catch (Throwable unused) {
                int i = b.a;
                return "";
            }
        }
        return (String) invokeCommon.objValue;
    }

    @SuppressLint({"NewApi"})
    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 15) {
                    TrafficStats.clearThreadStatsTag();
                }
            } catch (Throwable unused) {
                int i = b.a;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 15) {
                    TrafficStats.setThreadStatsTag(155648);
                }
            } catch (Throwable unused) {
                int i = b.a;
            }
        }
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            try {
                com.baidu.sofire.c.a a = com.baidu.sofire.c.a.a(context);
                com.baidu.sofire.b.b a2 = com.baidu.sofire.b.b.a(context);
                Iterator it = ((ArrayList) a.b()).iterator();
                while (it.hasNext()) {
                    ApkInfo apkInfo = (ApkInfo) it.next();
                    int i = apkInfo.duration;
                    if (i != 0 && apkInfo.startTime + (i * 60 * 1000) < System.currentTimeMillis()) {
                        a2.b(apkInfo.packageName);
                    }
                }
            } catch (Throwable unused) {
                int i2 = b.a;
            }
        }
    }

    @SuppressLint({"WrongConstant"})
    public static void a(Context context, int i, boolean z) {
        PendingIntent service;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            try {
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                Intent intent = new Intent("com.baidu.action.SOFIRE.VIEW");
                intent.setClass(context, MyService.class);
                intent.setPackage(context.getPackageName());
                intent.addCategory("com.baidu.category.SOFIRE");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.putExtra("from_plugin_package", context.getPackageName());
                intent.putExtra("target_class", U.class.getCanonicalName());
                intent.putExtra("target_method", "handleWork");
                intent.putExtra("from", 2);
                if (com.baidu.sofire.k.b.h(context)) {
                    service = PendingIntent.getService(context, 1001, intent, BDImageView.DEFAULT_BORDER_COLOR);
                } else {
                    service = PendingIntent.getService(context, 1001, intent, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
                }
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            j = 600000;
                        } else {
                            j = 300000;
                        }
                    } else {
                        j = LiveFeedPageSdk.REFRESH_TIME;
                    }
                } else {
                    j = 30000;
                }
                long currentTimeMillis = System.currentTimeMillis() + j;
                try {
                    alarmManager.cancel(service);
                } catch (Throwable unused) {
                }
                if (z) {
                    return;
                }
                try {
                    alarmManager.set(1, currentTimeMillis, service);
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                int i2 = b.a;
            }
        }
    }

    public static void a(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, intent) == null) {
            try {
                String[] o = com.baidu.sofire.k.b.o(context);
                com.baidu.sofire.b.c.a(context, 0, o[0], o[1], 100028);
                int i = 0;
                while (true) {
                    Thread.sleep(500L);
                    i++;
                    if (i > 60) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("0", "152");
                        hashMap.put("1", o[0]);
                        com.baidu.sofire.k.b.a(context.getApplicationContext(), "1014115", (Map<String, Object>) hashMap, false);
                        break;
                    }
                    com.baidu.sofire.b.i iVar = com.baidu.sofire.b.i.g;
                    if (iVar != null && iVar.b("com.baidu.sofire.x24") != null) {
                        break;
                    }
                }
                com.baidu.sofire.b.c.a(100028, "onReceiveAwakeMessage", new C0173a(), new Class[]{Context.class, Intent.class}, context, intent);
            } catch (Throwable unused) {
                int i2 = b.a;
            }
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        com.baidu.sofire.l.a aVar;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65542, null, context, jSONObject) != null) || context == null) {
            return;
        }
        try {
            synchronized (com.baidu.sofire.l.a.class) {
                if (com.baidu.sofire.l.a.c == null) {
                    com.baidu.sofire.l.a.c = new com.baidu.sofire.l.a(context);
                }
                aVar = com.baidu.sofire.l.a.c;
            }
            boolean z8 = false;
            try {
                if (jSONObject.getInt("1") == 1) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                aVar.b.putBoolean("lt_sdcf", z7);
                aVar.b.commit();
            } catch (JSONException unused) {
                int i = b.a;
            }
            try {
                if (jSONObject.getInt("2") == 1) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                aVar.b.putBoolean("lt_sucf", z6);
                aVar.b.commit();
            } catch (JSONException unused2) {
                int i2 = b.a;
            }
            try {
                if (jSONObject.getInt("3") == 1) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                aVar.b.putBoolean("lt_sbff", z5);
                aVar.b.commit();
            } catch (JSONException unused3) {
                int i3 = b.a;
            }
            try {
                if (jSONObject.getInt("4") == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                aVar.b.putBoolean("lt_sppf", z4);
                aVar.b.commit();
            } catch (JSONException unused4) {
                int i4 = b.a;
            }
            try {
                if (jSONObject.getInt("5") == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                aVar.b.putBoolean("lt_sssf", z3);
                aVar.b.commit();
            } catch (JSONException unused5) {
                int i5 = b.a;
            }
            try {
                if (jSONObject.getInt("5") == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                aVar.b.putBoolean("lt_sssf", z2);
                aVar.b.commit();
            } catch (JSONException unused6) {
                int i6 = b.a;
            }
            try {
                aVar.b.putLong("lt_sfii", jSONObject.getLong("7"));
                aVar.b.commit();
            } catch (JSONException unused7) {
                int i7 = b.a;
            }
            try {
                if (jSONObject.getInt("8") == 1) {
                    z = true;
                } else {
                    z = false;
                }
                aVar.b.putBoolean("lt_sfff", z);
                aVar.b.commit();
            } catch (JSONException unused8) {
                int i8 = b.a;
            }
            try {
                aVar.b.putString("lt_sha", jSONObject.getJSONArray("9").toString());
                aVar.b.commit();
            } catch (JSONException unused9) {
                int i9 = b.a;
            }
            try {
                if (jSONObject.getInt("10") == 1) {
                    z8 = true;
                }
                aVar.b.putBoolean("lt_sbwnp", z8);
                aVar.b.commit();
            } catch (JSONException unused10) {
                int i10 = b.a;
            }
        } catch (Throwable unused11) {
            int i11 = b.a;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:7|8|9|10|11|12|(1:14)(1:33)|15|(8:17|(1:19)|21|22|23|24|25|27)(1:32)|20|21|22|23|24|25|27) */
    @SuppressLint({"WrongConstant"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, boolean z) {
        PendingIntent service;
        long currentTimeMillis;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65543, null, context, z) == null) {
            try {
                com.baidu.sofire.j.a a = com.baidu.sofire.j.a.a(context);
                long j2 = a.a.getInt("appal_te", 24) * 3600000;
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                Intent intent = new Intent("com.baidu.action.SOFIRE.VIEW");
                intent.setClass(context, MyService.class);
                intent.setPackage(context.getPackageName());
                intent.addCategory("com.baidu.category.SOFIRE");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.putExtra("from_plugin_package", context.getPackageName());
                intent.putExtra("target_class", U.class.getCanonicalName());
                intent.putExtra("target_method", "handleWork");
                intent.putExtra("from", 6);
                if (com.baidu.sofire.k.b.h(context)) {
                    service = PendingIntent.getService(context, 1000, intent, BDImageView.DEFAULT_BORDER_COLOR);
                } else {
                    service = PendingIntent.getService(context, 1000, intent, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
                }
                try {
                    if (z) {
                        j = a.a.getLong("npuct", 0L);
                        if (j <= 0) {
                            currentTimeMillis = System.currentTimeMillis() + j2;
                            a.b.putLong("npuct", currentTimeMillis);
                            a.b.commit();
                        }
                        alarmManager.cancel(service);
                        alarmManager.set(1, j, service);
                        return;
                    }
                    currentTimeMillis = ((System.currentTimeMillis() + j2) - 600000) + ((long) (Math.random() * 1200000.0d));
                    a.b.putLong("npuct", currentTimeMillis);
                    a.b.commit();
                    alarmManager.set(1, j, service);
                    return;
                } catch (Throwable unused) {
                    return;
                }
                j = currentTimeMillis;
                alarmManager.cancel(service);
            } catch (Throwable unused2) {
                int i = b.a;
            }
        }
    }

    public static void a(File file, File file2) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65544, null, file, file2) != null) || !com.baidu.sofire.k.b.a(file)) {
            return;
        }
        if (file2.exists()) {
            file2.delete();
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Throwable unused) {
                fileOutputStream = null;
            }
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                try {
                    fileInputStream2.close();
                } catch (Throwable unused2) {
                    int i = b.a;
                }
            } catch (Throwable unused3) {
                fileInputStream = fileInputStream2;
                try {
                    int i2 = b.a;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused4) {
                            int i3 = b.a;
                        }
                    }
                    if (fileOutputStream == null) {
                        return;
                    }
                    fileOutputStream.close();
                } catch (Throwable th) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused5) {
                            int i4 = b.a;
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused6) {
                            int i5 = b.a;
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable unused7) {
            fileOutputStream = null;
        }
        try {
            fileOutputStream.close();
        } catch (Throwable unused8) {
            int i6 = b.a;
        }
    }

    public static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        InterceptResult invokeLLL;
        BufferedInputStream bufferedInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, jarFile, jarEntry, bArr)) == null) {
            try {
                bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
                while (bufferedInputStream.read(bArr, 0, bArr.length) != -1) {
                    try {
                    } catch (Throwable unused) {
                        try {
                            int i = b.a;
                            return new Certificate[0];
                        } finally {
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (Throwable unused2) {
                                    int i2 = b.a;
                                }
                            }
                        }
                    }
                }
                Certificate[] certificates = jarEntry.getCertificates();
                try {
                    bufferedInputStream.close();
                } catch (Throwable unused3) {
                    int i3 = b.a;
                }
                return certificates;
            } catch (Throwable unused4) {
                bufferedInputStream = null;
            }
        } else {
            return (Certificate[]) invokeLLL.objValue;
        }
    }
}
