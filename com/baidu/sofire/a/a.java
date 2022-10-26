package com.baidu.sofire.a;

import android.accounts.NetworkErrorException;
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
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.sofire.MyService;
import com.baidu.sofire.ac.Callback;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.ac.U;
import com.baidu.sofire.b.k;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.k.i;
import com.baidu.sofire.k.j;
import com.baidu.sofire.k.l;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.sofire.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public final class C0155a extends Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0155a() {
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
            String[] p = com.baidu.sofire.k.a.p(context);
            String str3 = p[0];
            String str4 = p[1];
            if ("com.baidu.input_huawei".equals(context.getPackageName()) && !com.baidu.sofire.j.a.a(context).b()) {
                throw new NetworkErrorException("conn is blocked");
            }
            String valueOf = String.valueOf(new Date().getTime() / 1000);
            String a = j.a(str3 + valueOf + str4);
            char[] charArray = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
            char[] cArr = new char[16];
            for (int i = 0; i < 16; i++) {
                cArr[i] = charArray[new Random().nextInt(62)];
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
            byte[] bytes3 = j.a(com.baidu.sofire.k.c.a(context)).getBytes();
            String encodeToString = Base64.encodeToString(F.getInstance().re(bytes2, bytes3), 0);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("/");
            sb.append("100");
            sb.append("/");
            sb.append(str3);
            sb.append("/");
            sb.append(valueOf);
            sb.append("/");
            sb.append(a);
            if (!TextUtils.isEmpty(encodeToString)) {
                sb.append("?skey=");
                sb.append(URLEncoder.encode(encodeToString, IMAudioTransRequest.CHARSET));
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
                        if (com.baidu.sofire.k.a.m(context)) {
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
                        com.baidu.sofire.k.a.a(context, "1003112", (Map) hashMap, false);
                    } else if (com.baidu.sofire.k.a.m(context)) {
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
                        com.baidu.sofire.k.a.a(context, "1003119", (Map) hashMap2, false);
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
                    if (l.a(context)) {
                        a = new l(context).a(sb.toString());
                    } else {
                        a = new i(context).a(sb.toString());
                    }
                } else if (l.a(context)) {
                    a = new l(context).b(sb.toString(), bArr);
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

    public static String a(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, bArr, z)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                messageDigest.update(bArr);
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    String hexString = Integer.toHexString(b & 255);
                    if (z) {
                        hexString = hexString.toUpperCase();
                    }
                    if (hexString.length() == 1) {
                        sb.append("0");
                    }
                    sb.append(hexString);
                    sb.append("");
                }
                return sb.toString();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
        return (String) invokeLZ.objValue;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 15) {
                    TrafficStats.clearThreadStatsTag();
                }
            } catch (Throwable unused) {
                int i = b.a;
            }
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
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
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            try {
                com.baidu.sofire.c.a a = com.baidu.sofire.c.a.a(context);
                com.baidu.sofire.b.d a2 = com.baidu.sofire.b.d.a(context);
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

    public static void a(Context context, int i, boolean z) {
        PendingIntent service;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{context, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
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
                if (com.baidu.sofire.k.a.i(context)) {
                    service = PendingIntent.getService(context, 1001, intent, 201326592);
                } else {
                    service = PendingIntent.getService(context, 1001, intent, 134217728);
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
        if (interceptable == null || interceptable.invokeLL(65542, null, context, intent) == null) {
            try {
                String[] p = com.baidu.sofire.k.a.p(context);
                com.baidu.sofire.b.e.a(context, 0, p[0], p[1], 100028);
                int i = 0;
                while (true) {
                    Thread.sleep(500L);
                    i++;
                    if (i > 60) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("0", "152");
                        hashMap.put("1", p[0]);
                        com.baidu.sofire.k.a.a(context.getApplicationContext(), "1014115", (Map) hashMap, false);
                        break;
                    }
                    k kVar = k.f;
                    if (kVar != null && kVar.b("com.baidu.sofire.x24") != null) {
                        break;
                    }
                }
                com.baidu.sofire.b.e.a(100028, "onReceiveAwakeMessage", new C0155a(), new Class[]{Context.class, Intent.class}, context, intent);
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
        if ((interceptable != null && interceptable.invokeLL(65543, null, context, jSONObject) != null) || context == null) {
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, boolean z) {
        PendingIntent service;
        long currentTimeMillis;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65544, null, context, z) == null) {
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
                if (com.baidu.sofire.k.a.i(context)) {
                    service = PendingIntent.getService(context, 1000, intent, 201326592);
                } else {
                    service = PendingIntent.getService(context, 1000, intent, 134217728);
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

    public static byte[] a(String str, String str2, byte[] bArr) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, str, str2, bArr)) == null) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
            return cipher.doFinal(bArr);
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        InterceptResult invokeLLL;
        BufferedInputStream bufferedInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, jarFile, jarEntry, bArr)) == null) {
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
