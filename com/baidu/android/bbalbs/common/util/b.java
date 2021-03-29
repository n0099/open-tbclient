package com.baidu.android.bbalbs.common.util;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.system.ErrnoException;
import android.system.Os;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.http.multipart.Part;
import com.baidu.android.bbalbs.common.a.d;
import com.baidu.android.common.util.DeviceId;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.crypto.Cipher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2500a;

    /* renamed from: e  reason: collision with root package name */
    public static C0024b f2501e;

    /* renamed from: b  reason: collision with root package name */
    public final Context f2502b;

    /* renamed from: c  reason: collision with root package name */
    public int f2503c = 0;

    /* renamed from: d  reason: collision with root package name */
    public PublicKey f2504d;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public ApplicationInfo f2505a;

        /* renamed from: b  reason: collision with root package name */
        public int f2506b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2507c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f2508d;

        public a() {
            this.f2506b = 0;
            this.f2507c = false;
            this.f2508d = false;
        }

        public /* synthetic */ a(com.baidu.android.bbalbs.common.util.c cVar) {
            this();
        }
    }

    /* renamed from: com.baidu.android.bbalbs.common.util.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0024b {

        /* renamed from: a  reason: collision with root package name */
        public String f2509a;

        /* renamed from: b  reason: collision with root package name */
        public String f2510b;

        /* renamed from: c  reason: collision with root package name */
        public int f2511c;

        public C0024b() {
            this.f2511c = 2;
        }

        public /* synthetic */ C0024b(com.baidu.android.bbalbs.common.util.c cVar) {
            this();
        }

        public static C0024b a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("deviceid");
                String string2 = jSONObject.getString("imei");
                int i = jSONObject.getInt("ver");
                if (!TextUtils.isEmpty(string) && string2 != null) {
                    C0024b c0024b = new C0024b();
                    c0024b.f2509a = string;
                    c0024b.f2510b = string2;
                    c0024b.f2511c = i;
                    return c0024b;
                }
            } catch (JSONException e2) {
                b.b(e2);
            }
            return null;
        }

        public String a() {
            try {
                return new JSONObject().put("deviceid", this.f2509a).put("imei", this.f2510b).put("ver", this.f2511c).toString();
            } catch (JSONException e2) {
                b.b(e2);
                return null;
            }
        }

        public String b() {
            String str = this.f2510b;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            String stringBuffer = new StringBuffer(str).reverse().toString();
            return this.f2509a + FieldBuilder.SE + stringBuffer;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static boolean a(String str, int i) {
            try {
                Os.chmod(str, i);
                return true;
            } catch (ErrnoException e2) {
                b.b(e2);
                return false;
            }
        }
    }

    static {
        String str = new String(com.baidu.android.bbalbs.common.a.b.a(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, 61}));
        String str2 = new String(com.baidu.android.bbalbs.common.a.b.a(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, 61}));
        f2500a = str + str2;
    }

    public b(Context context) {
        this.f2502b = context.getApplicationContext();
        a();
    }

    public static String a(Context context) {
        return d(context).b();
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(File file) {
        FileReader fileReader;
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader(file);
            try {
                try {
                    char[] cArr = new char[8192];
                    CharArrayWriter charArrayWriter = new CharArrayWriter();
                    while (true) {
                        int read = fileReader.read(cArr);
                        if (read <= 0) {
                            break;
                        }
                        charArrayWriter.write(cArr, 0, read);
                    }
                    String charArrayWriter2 = charArrayWriter.toString();
                    try {
                        fileReader.close();
                    } catch (Exception e2) {
                        b(e2);
                    }
                    return charArrayWriter2;
                } catch (Exception e3) {
                    e = e3;
                    b(e);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e4) {
                            b(e4);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileReader2 = fileReader;
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (Exception e5) {
                        b(e5);
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            fileReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (fileReader2 != null) {
            }
            throw th;
        }
    }

    public static String a(byte[] bArr) {
        StringBuilder sb;
        if (bArr != null) {
            String str = "";
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    sb = new StringBuilder();
                    sb.append(str);
                    str = "0";
                } else {
                    sb = new StringBuilder();
                }
                sb.append(str);
                sb.append(hexString);
                str = sb.toString();
            }
            return str.toLowerCase();
        }
        throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
    }

    private List<a> a(Intent intent, boolean z) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = this.f2502b.getPackageManager();
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers != null) {
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null && activityInfo.applicationInfo != null) {
                    try {
                        Bundle bundle = packageManager.getReceiverInfo(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name), 128).metaData;
                        if (bundle != null) {
                            String string = bundle.getString("galaxy_data");
                            if (!TextUtils.isEmpty(string)) {
                                byte[] a2 = com.baidu.android.bbalbs.common.a.b.a(string.getBytes("utf-8"));
                                JSONObject jSONObject = new JSONObject(new String(a2));
                                a aVar = new a(null);
                                aVar.f2506b = jSONObject.getInt("priority");
                                aVar.f2505a = resolveInfo.activityInfo.applicationInfo;
                                if (this.f2502b.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                                    aVar.f2508d = true;
                                }
                                if (z) {
                                    String string2 = bundle.getString("galaxy_sf");
                                    if (!TextUtils.isEmpty(string2)) {
                                        PackageInfo packageInfo = packageManager.getPackageInfo(resolveInfo.activityInfo.applicationInfo.packageName, 64);
                                        JSONArray jSONArray = jSONObject.getJSONArray("sigs");
                                        int length = jSONArray.length();
                                        String[] strArr = new String[length];
                                        for (int i = 0; i < length; i++) {
                                            strArr[i] = jSONArray.getString(i);
                                        }
                                        if (a(strArr, a(packageInfo.signatures))) {
                                            byte[] a3 = a(com.baidu.android.bbalbs.common.a.b.a(string2.getBytes()), this.f2504d);
                                            if (a3 != null && Arrays.equals(a3, d.a(a2))) {
                                                aVar.f2507c = true;
                                            }
                                        }
                                    }
                                }
                                arrayList.add(aVar);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        Collections.sort(arrayList, new com.baidu.android.bbalbs.common.util.c(this));
        return arrayList;
    }

    private void a() {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(com.baidu.android.bbalbs.common.util.a.a());
                try {
                    this.f2504d = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream).getPublicKey();
                    byteArrayInputStream.close();
                } catch (Exception unused) {
                    byteArrayInputStream2 = byteArrayInputStream;
                    if (byteArrayInputStream2 != null) {
                        byteArrayInputStream2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Exception e2) {
                            b(e2);
                        }
                    }
                    throw th;
                }
            } catch (Exception e3) {
                b(e3);
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            byteArrayInputStream = null;
            th = th3;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    @SuppressLint({"NewApi"})
    private boolean a(String str) {
        int i = Build.VERSION.SDK_INT >= 24 ? 0 : 1;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                fileOutputStream = this.f2502b.openFileOutput("libcuid.so", i);
                fileOutputStream.write(str.getBytes());
                fileOutputStream.flush();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e2) {
                        b(e2);
                    }
                }
                if (i == 0) {
                    return c.a(new File(this.f2502b.getFilesDir(), "libcuid.so").getAbsolutePath(), 436);
                }
                return true;
            } catch (Throwable th) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e3) {
                        b(e3);
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            b(e4);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e5) {
                    b(e5);
                }
            }
            return false;
        }
    }

    private boolean a(String str, String str2) {
        try {
            return Settings.System.putString(this.f2502b.getContentResolver(), str, str2);
        } catch (Exception e2) {
            b(e2);
            return false;
        }
    }

    private boolean a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            hashSet.add(str);
        }
        HashSet hashSet2 = new HashSet();
        for (String str2 : strArr2) {
            hashSet2.add(str2);
        }
        return hashSet.equals(hashSet2);
    }

    public static byte[] a(byte[] bArr, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, publicKey);
        return cipher.doFinal(bArr);
    }

    private String[] a(Signature[] signatureArr) {
        int length = signatureArr.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = a(d.a(signatureArr[i].toByteArray()));
        }
        return strArr;
    }

    private C0024b b() {
        boolean z;
        String str;
        List<a> a2 = a(new Intent("com.baidu.intent.action.GALAXY").setPackage(this.f2502b.getPackageName()), true);
        boolean z2 = false;
        if (a2 == null || a2.size() == 0) {
            for (int i = 0; i < 3; i++) {
                Log.w(DeviceId.f2516a, "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
            }
            z = false;
        } else {
            z = a2.get(0).f2507c;
            if (!z) {
                for (int i2 = 0; i2 < 3; i2++) {
                    Log.w(DeviceId.f2516a, "galaxy config err, In the release version of the signature should be matched");
                }
            }
        }
        File file = new File(this.f2502b.getFilesDir(), "libcuid.so");
        C0024b a3 = file.exists() ? C0024b.a(f(a(file))) : null;
        if (a3 == null) {
            this.f2503c |= 16;
            List<a> a4 = a(new Intent("com.baidu.intent.action.GALAXY"), z);
            if (a4 != null) {
                String str2 = com.baidu.fsg.face.base.b.c.f5557g;
                File filesDir = this.f2502b.getFilesDir();
                if (!com.baidu.fsg.face.base.b.c.f5557g.equals(filesDir.getName())) {
                    Log.e(DeviceId.f2516a, "fetal error:: app files dir name is unexpectedly :: " + filesDir.getAbsolutePath());
                    str2 = filesDir.getName();
                }
                for (a aVar : a4) {
                    if (!aVar.f2508d) {
                        File file2 = new File(new File(aVar.f2505a.dataDir, str2), "libcuid.so");
                        if (file2.exists() && (a3 = C0024b.a(f(a(file2)))) != null) {
                            break;
                        }
                    }
                }
            }
        }
        if (a3 == null) {
            a3 = C0024b.a(f(b("com.baidu.deviceid.v2")));
        }
        boolean c2 = c("android.permission.READ_EXTERNAL_STORAGE");
        if (a3 == null && c2) {
            this.f2503c |= 2;
            a3 = e();
        }
        if (a3 == null) {
            this.f2503c |= 8;
            a3 = d();
        }
        if (a3 == null && c2) {
            this.f2503c |= 1;
            str = h("");
            a3 = d(str);
            z2 = true;
        } else {
            str = null;
        }
        if (a3 == null) {
            this.f2503c |= 4;
            if (!z2) {
                str = h("");
            }
            a3 = new C0024b(null);
            String c3 = c(this.f2502b);
            a3.f2509a = com.baidu.android.bbalbs.common.a.c.a((Build.VERSION.SDK_INT < 23 ? str + c3 + UUID.randomUUID().toString() : "com.baidu" + c3).getBytes(), true);
            a3.f2510b = str;
        }
        File file3 = new File(this.f2502b.getFilesDir(), "libcuid.so");
        if ((this.f2503c & 16) != 0 || !file3.exists()) {
            r8 = TextUtils.isEmpty(null) ? e(a3.a()) : null;
            a(r8);
        }
        boolean c4 = c();
        if (c4 && ((this.f2503c & 2) != 0 || TextUtils.isEmpty(b("com.baidu.deviceid.v2")))) {
            if (TextUtils.isEmpty(r8)) {
                r8 = e(a3.a());
            }
            a("com.baidu.deviceid.v2", r8);
        }
        if (c(StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
            File file4 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
            if ((this.f2503c & 8) != 0 || !file4.exists()) {
                if (TextUtils.isEmpty(r8)) {
                    r8 = e(a3.a());
                }
                g(r8);
            }
        }
        if (c4 && ((this.f2503c & 1) != 0 || TextUtils.isEmpty(b("com.baidu.deviceid")))) {
            a("com.baidu.deviceid", a3.f2509a);
        }
        if (c4 && !TextUtils.isEmpty(a3.f2510b)) {
            File file5 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
            if ((this.f2503c & 2) != 0 || !file5.exists()) {
                b(a3.f2510b, a3.f2509a);
            }
        }
        return a3;
    }

    public static String b(Context context) {
        return d(context).f2509a;
    }

    private String b(String str) {
        try {
            return Settings.System.getString(this.f2502b.getContentResolver(), str);
        } catch (Exception e2) {
            b(e2);
            return null;
        }
    }

    public static void b(String str, String str2) {
        File file;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file2 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
        File file3 = new File(file2, ".cuid");
        try {
            if (file2.exists() && !file2.isDirectory()) {
                Random random = new Random();
                File parentFile = file2.getParentFile();
                String name = file2.getName();
                do {
                    file = new File(parentFile, name + random.nextInt() + ".tmp");
                } while (file.exists());
                file2.renameTo(file);
                file.delete();
            }
            file2.mkdirs();
            FileWriter fileWriter = new FileWriter(file3, false);
            fileWriter.write(com.baidu.android.bbalbs.common.a.b.a(com.baidu.android.bbalbs.common.a.a.a(f2500a, f2500a, (str + "=" + str2).getBytes()), "utf-8"));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException | Exception unused) {
        }
    }

    public static void b(Throwable th) {
    }

    public static String c(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        return TextUtils.isEmpty(string) ? "" : string;
    }

    private boolean c() {
        return c("android.permission.WRITE_SETTINGS");
    }

    private boolean c(String str) {
        return this.f2502b.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    private C0024b d() {
        String b2 = b("com.baidu.deviceid");
        String b3 = b("bd_setting_i");
        if (TextUtils.isEmpty(b3)) {
            b3 = h("");
            TextUtils.isEmpty(b3);
        }
        if (TextUtils.isEmpty(b2)) {
            String c2 = c(this.f2502b);
            b2 = b(com.baidu.android.bbalbs.common.a.c.a(("com.baidu" + b3 + c2).getBytes(), true));
        }
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        C0024b c0024b = new C0024b(null);
        c0024b.f2509a = b2;
        c0024b.f2510b = b3;
        return c0024b;
    }

    public static C0024b d(Context context) {
        if (f2501e == null) {
            synchronized (C0024b.class) {
                if (f2501e == null) {
                    SystemClock.uptimeMillis();
                    f2501e = new b(context).b();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return f2501e;
    }

    private C0024b d(String str) {
        boolean z;
        String str2;
        boolean z2 = Build.VERSION.SDK_INT < 23;
        if (z2 && TextUtils.isEmpty(str)) {
            return null;
        }
        String str3 = "";
        File file = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
        if (file.exists()) {
            z = false;
        } else {
            file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
            z = true;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append(Part.CRLF);
            }
            bufferedReader.close();
            String[] split = new String(com.baidu.android.bbalbs.common.a.a.b(f2500a, f2500a, com.baidu.android.bbalbs.common.a.b.a(sb.toString().getBytes()))).split("=");
            if (split != null && split.length == 2) {
                if (z2 && str.equals(split[0])) {
                    str2 = split[1];
                } else if (!z2) {
                    if (TextUtils.isEmpty(str)) {
                        str = split[1];
                    }
                    str2 = split[1];
                }
                str3 = str2;
            }
            if (!z) {
                b(str, str3);
            }
        } catch (FileNotFoundException | IOException | Exception unused) {
        }
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        C0024b c0024b = new C0024b(null);
        c0024b.f2509a = str3;
        c0024b.f2510b = str;
        return c0024b;
    }

    private C0024b e() {
        File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
        if (file.exists()) {
            String a2 = a(file);
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            try {
                return C0024b.a(new String(com.baidu.android.bbalbs.common.a.a.b(f2500a, f2500a, com.baidu.android.bbalbs.common.a.b.a(a2.getBytes()))));
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return com.baidu.android.bbalbs.common.a.b.a(com.baidu.android.bbalbs.common.a.a.a(f2500a, f2500a, str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException | Exception e2) {
            b(e2);
            return "";
        }
    }

    public static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(com.baidu.android.bbalbs.common.a.a.b(f2500a, f2500a, com.baidu.android.bbalbs.common.a.b.a(str.getBytes())));
        } catch (Exception e2) {
            b(e2);
            return "";
        }
    }

    public static void g(String str) {
        File file;
        File file2 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig");
        File file3 = new File(file2, ".cuid2");
        try {
            if (file2.exists() && !file2.isDirectory()) {
                Random random = new Random();
                File parentFile = file2.getParentFile();
                String name = file2.getName();
                do {
                    file = new File(parentFile, name + random.nextInt() + ".tmp");
                } while (file.exists());
                file2.renameTo(file);
                file.delete();
            }
            file2.mkdirs();
            FileWriter fileWriter = new FileWriter(file3, false);
            fileWriter.write(str);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException | Exception unused) {
        }
    }

    private String h(String str) {
        String str2 = null;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f2502b.getSystemService("phone");
            if (telephonyManager != null) {
                str2 = telephonyManager.getDeviceId();
            }
        } catch (Exception e2) {
            Log.e(DeviceId.f2516a, "Read IMEI failed", e2);
        }
        String i = i(str2);
        return TextUtils.isEmpty(i) ? str : i;
    }

    public static String i(String str) {
        return (str == null || !str.contains(":")) ? str : "";
    }
}
