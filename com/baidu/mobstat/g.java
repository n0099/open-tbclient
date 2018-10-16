package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
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
import com.baidu.ar.util.IoUtils;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.webkit.internal.ETAG;
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
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.crypto.Cipher;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class g {
    private static final String a;
    private static b e;
    private final Context b;
    private int c = 0;
    private PublicKey d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        public ApplicationInfo a;
        public int b;
        public boolean c;
        public boolean d;

        private a() {
            this.b = 0;
            this.c = false;
            this.d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class b {
        public String a;
        public String b;
        public int c;

        private b() {
            this.c = 2;
        }

        public static b a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("deviceid");
                String string2 = jSONObject.getString("imei");
                int i = jSONObject.getInt("ver");
                if (TextUtils.isEmpty(string) || string2 == null) {
                    return null;
                }
                b bVar = new b();
                bVar.a = string;
                bVar.b = string2;
                bVar.c = i;
                return bVar;
            } catch (JSONException e) {
                g.b(e);
                return null;
            }
        }

        public String a() {
            try {
                return new JSONObject().put("deviceid", this.a).put("imei", this.b).put("ver", this.c).toString();
            } catch (JSONException e) {
                g.b(e);
                return null;
            }
        }

        public String b() {
            String str = this.b;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            return this.a + "|" + new StringBuffer(str).reverse().toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class c {
        static boolean a(String str, int i) {
            try {
                Os.chmod(str, i);
                return true;
            } catch (ErrnoException e) {
                g.b(e);
                return false;
            }
        }
    }

    static {
        String str = new String(com.baidu.mobstat.b.a(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, 61}));
        a = str + new String(com.baidu.mobstat.b.a(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, 61}));
    }

    private g(Context context) {
        this.b = context.getApplicationContext();
        a();
    }

    public static String a(Context context) {
        return c(context).b();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.FileReader] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(File file) {
        Throwable th;
        FileReader fileReader;
        String str = 0;
        str = 0;
        str = 0;
        try {
            try {
                fileReader = new FileReader(file);
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
                    str = charArrayWriter2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                            str = charArrayWriter2;
                        } catch (Exception e2) {
                            b(e2);
                            str = charArrayWriter2;
                        }
                    }
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
                    return str;
                }
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    try {
                        str.close();
                    } catch (Exception e5) {
                        b(e5);
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            fileReader = null;
        } catch (Throwable th3) {
            th = th3;
            if (0 != 0) {
            }
            throw th;
        }
        return str;
    }

    private static String a(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
        }
        String str = "";
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            str = hexString.length() == 1 ? str + "0" + hexString : str + hexString;
        }
        return str.toLowerCase();
    }

    private List<a> a(Intent intent, boolean z) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = this.b.getPackageManager();
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers != null) {
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.applicationInfo != null) {
                    try {
                        Bundle bundle = packageManager.getReceiverInfo(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name), 128).metaData;
                        if (bundle != null) {
                            String string = bundle.getString("galaxy_data");
                            if (!TextUtils.isEmpty(string)) {
                                byte[] a2 = com.baidu.mobstat.b.a(string.getBytes(IoUtils.UTF_8));
                                JSONObject jSONObject = new JSONObject(new String(a2));
                                a aVar = new a();
                                aVar.b = jSONObject.getInt(LogFactory.PRIORITY_KEY);
                                aVar.a = resolveInfo.activityInfo.applicationInfo;
                                if (this.b.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
                                    aVar.d = true;
                                }
                                if (z) {
                                    String string2 = bundle.getString("galaxy_sf");
                                    if (!TextUtils.isEmpty(string2)) {
                                        PackageInfo packageInfo = packageManager.getPackageInfo(resolveInfo.activityInfo.applicationInfo.packageName, 64);
                                        JSONArray jSONArray = jSONObject.getJSONArray("sigs");
                                        String[] strArr = new String[jSONArray.length()];
                                        for (int i = 0; i < strArr.length; i++) {
                                            strArr[i] = jSONArray.getString(i);
                                        }
                                        if (a(strArr, a(packageInfo.signatures))) {
                                            byte[] a3 = a(com.baidu.mobstat.b.a(string2.getBytes()), this.d);
                                            if (a3 != null && Arrays.equals(a3, d.a(a2))) {
                                                aVar.c = true;
                                            }
                                        }
                                    }
                                }
                                arrayList.add(aVar);
                            }
                        }
                    } catch (Exception e2) {
                    }
                }
            }
        }
        Collections.sort(arrayList, new Comparator<a>() { // from class: com.baidu.mobstat.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(a aVar2, a aVar3) {
                int i2 = aVar3.b - aVar2.b;
                if (i2 == 0) {
                    if (aVar2.d && aVar3.d) {
                        return 0;
                    }
                    if (aVar2.d) {
                        return -1;
                    }
                    if (aVar3.d) {
                        return 1;
                    }
                    return i2;
                }
                return i2;
            }
        });
        return arrayList;
    }

    private void a() {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(f.a());
        } catch (Exception e2) {
            byteArrayInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.d = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream).getPublicKey();
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (Exception e3) {
                    b(e3);
                }
            }
        } catch (Exception e4) {
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (Exception e5) {
                    b(e5);
                }
            }
        } catch (Throwable th2) {
            byteArrayInputStream2 = byteArrayInputStream;
            th = th2;
            if (byteArrayInputStream2 != null) {
                try {
                    byteArrayInputStream2.close();
                } catch (Exception e6) {
                    b(e6);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(String str) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        int i = Build.VERSION.SDK_INT >= 24 ? 0 : 1;
        try {
            try {
                FileOutputStream openFileOutput = this.b.openFileOutput("libcuid.so", i);
                try {
                    openFileOutput.write(str.getBytes());
                    openFileOutput.flush();
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (Exception e2) {
                            b(e2);
                        }
                    }
                    if (i == 0) {
                        return c.a(new File(this.b.getFilesDir(), "libcuid.so").getAbsolutePath(), 436);
                    }
                    return true;
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = openFileOutput;
                    try {
                        b(e);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e4) {
                                b(e4);
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (Exception e5) {
                                b(e5);
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream2 != null) {
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
        }
    }

    private boolean a(String str, String str2) {
        try {
            return Settings.System.putString(this.b.getContentResolver(), str, str2);
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

    private static byte[] a(byte[] bArr, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, publicKey);
        return cipher.doFinal(bArr);
    }

    private String[] a(Signature[] signatureArr) {
        String[] strArr = new String[signatureArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = a(d.a(signatureArr[i].toByteArray()));
        }
        return strArr;
    }

    private b b() {
        boolean z;
        b bVar;
        b bVar2;
        String str;
        b bVar3;
        String str2;
        String str3 = null;
        boolean z2 = false;
        List<a> a2 = a(new Intent("com.baidu.intent.action.GALAXY").setPackage(this.b.getPackageName()), true);
        if (a2 == null || a2.size() == 0) {
            for (int i = 0; i < 3; i++) {
                Log.w("DeviceId", "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
            }
            z = false;
        } else {
            a aVar = a2.get(0);
            boolean z3 = aVar.c;
            if (!aVar.c) {
                for (int i2 = 0; i2 < 3; i2++) {
                    Log.w("DeviceId", "galaxy config err, In the release version of the signature should be matched");
                }
            }
            z = z3;
        }
        File file = new File(this.b.getFilesDir(), "libcuid.so");
        b a3 = file.exists() ? b.a(f(a(file))) : null;
        if (a3 == null) {
            this.c |= 16;
            List<a> a4 = a(new Intent("com.baidu.intent.action.GALAXY"), z);
            if (a4 != null) {
                File filesDir = this.b.getFilesDir();
                if (com.baidu.fsg.face.base.b.c.g.equals(filesDir.getName())) {
                    str2 = com.baidu.fsg.face.base.b.c.g;
                } else {
                    Log.e("DeviceId", "fetal error:: app files dir name is unexpectedly :: " + filesDir.getAbsolutePath());
                    str2 = filesDir.getName();
                }
                for (a aVar2 : a4) {
                    if (!aVar2.d) {
                        File file2 = new File(new File(aVar2.a.dataDir, str2), "libcuid.so");
                        if (file2.exists()) {
                            bVar = b.a(f(a(file2)));
                            if (bVar != null) {
                                break;
                            }
                        } else {
                            bVar = a3;
                        }
                        a3 = bVar;
                    }
                }
            }
        }
        bVar = a3;
        if (bVar == null) {
            bVar = b.a(f(b("com.baidu.deviceid.v2")));
        }
        boolean c2 = c("android.permission.READ_EXTERNAL_STORAGE");
        if (bVar == null && c2) {
            this.c |= 2;
            bVar2 = e();
        } else {
            bVar2 = bVar;
        }
        if (bVar2 == null) {
            this.c |= 8;
            bVar2 = d();
        }
        if (bVar2 == null && c2) {
            this.c |= 1;
            str = h("");
            bVar2 = d(str);
            z2 = true;
        } else {
            str = null;
        }
        if (bVar2 == null) {
            this.c |= 4;
            if (!z2) {
                str = h("");
            }
            b bVar4 = new b();
            String b2 = b(this.b);
            bVar4.a = com.baidu.mobstat.c.a((Build.VERSION.SDK_INT < 23 ? str + b2 + UUID.randomUUID().toString() : "com.baidu" + b2).getBytes(), true);
            bVar4.b = str;
            bVar3 = bVar4;
        } else {
            bVar3 = bVar2;
        }
        File file3 = new File(this.b.getFilesDir(), "libcuid.so");
        if ((this.c & 16) != 0 || !file3.exists()) {
            String e2 = TextUtils.isEmpty(null) ? e(bVar3.a()) : null;
            a(e2);
            str3 = e2;
        }
        boolean c3 = c();
        if (c3 && ((this.c & 2) != 0 || TextUtils.isEmpty(b("com.baidu.deviceid.v2")))) {
            if (TextUtils.isEmpty(str3)) {
                str3 = e(bVar3.a());
            }
            a("com.baidu.deviceid.v2", str3);
        }
        if (c("android.permission.WRITE_EXTERNAL_STORAGE")) {
            File file4 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
            if ((this.c & 8) != 0 || !file4.exists()) {
                if (TextUtils.isEmpty(str3)) {
                    str3 = e(bVar3.a());
                }
                g(str3);
            }
        }
        if (c3 && ((this.c & 1) != 0 || TextUtils.isEmpty(b("com.baidu.deviceid")))) {
            a("com.baidu.deviceid", bVar3.a);
            a("bd_setting_i", bVar3.b);
        }
        if (c3 && !TextUtils.isEmpty(bVar3.b)) {
            File file5 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
            if ((this.c & 2) != 0 || !file5.exists()) {
                b(bVar3.b, bVar3.a);
            }
        }
        return bVar3;
    }

    public static String b(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        return TextUtils.isEmpty(string) ? "" : string;
    }

    private String b(String str) {
        try {
            return Settings.System.getString(this.b.getContentResolver(), str);
        } catch (Exception e2) {
            b(e2);
            return null;
        }
    }

    private static void b(String str, String str2) {
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
            fileWriter.write(com.baidu.mobstat.b.a(com.baidu.mobstat.a.a(a, a, (str + ETAG.EQUAL + str2).getBytes()), IoUtils.UTF_8));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e2) {
        } catch (Exception e3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Throwable th) {
    }

    private static b c(Context context) {
        if (e == null) {
            synchronized (b.class) {
                if (e == null) {
                    SystemClock.uptimeMillis();
                    e = new g(context).b();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return e;
    }

    private boolean c() {
        return c("android.permission.WRITE_SETTINGS");
    }

    private boolean c(String str) {
        return this.b.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    private b d() {
        String b2 = b("com.baidu.deviceid");
        String b3 = b("bd_setting_i");
        if (TextUtils.isEmpty(b3)) {
            b3 = h("");
            if (!TextUtils.isEmpty(b3)) {
                a("bd_setting_i", b3);
            }
        }
        if (TextUtils.isEmpty(b2)) {
            b2 = b(com.baidu.mobstat.c.a(("com.baidu" + b3 + b(this.b)).getBytes(), true));
        }
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        b bVar = new b();
        bVar.a = b2;
        bVar.b = b3;
        return bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private b d(String str) {
        String str2;
        String[] split;
        boolean z = false;
        boolean z2 = Build.VERSION.SDK_INT < 23;
        if (z2 && TextUtils.isEmpty(str)) {
            return null;
        }
        String str3 = "";
        File file = new File(Environment.getExternalStorageDirectory(), "baidu/.cuid");
        if (!file.exists()) {
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
                sb.append(SystemInfoUtil.LINE_END);
            }
            bufferedReader.close();
            split = new String(com.baidu.mobstat.a.b(a, a, com.baidu.mobstat.b.a(sb.toString().getBytes()))).split(ETAG.EQUAL);
        } catch (FileNotFoundException e2) {
            str2 = str;
        } catch (IOException e3) {
            str2 = str;
        } catch (Exception e4) {
            str2 = str;
        }
        if (split != null && split.length == 2) {
            if (z2 && str.equals(split[0])) {
                str3 = split[1];
                str2 = str;
            } else if (!z2) {
                if (TextUtils.isEmpty(str)) {
                    str = split[1];
                }
                str3 = split[1];
                str2 = str;
            }
            if (!z) {
                try {
                    b(str2, str3);
                } catch (FileNotFoundException e5) {
                } catch (IOException e6) {
                } catch (Exception e7) {
                }
            }
            if (TextUtils.isEmpty(str3)) {
                b bVar = new b();
                bVar.a = str3;
                bVar.b = str2;
                return bVar;
            }
            return null;
        }
        str2 = str;
        if (!z) {
        }
        if (TextUtils.isEmpty(str3)) {
        }
    }

    private b e() {
        File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
        if (file.exists()) {
            String a2 = a(file);
            if (!TextUtils.isEmpty(a2)) {
                try {
                    return b.a(new String(com.baidu.mobstat.a.b(a, a, com.baidu.mobstat.b.a(a2.getBytes()))));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    private static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return com.baidu.mobstat.b.a(com.baidu.mobstat.a.a(a, a, str.getBytes()), IoUtils.UTF_8);
        } catch (UnsupportedEncodingException e2) {
            b(e2);
            return "";
        } catch (Exception e3) {
            b(e3);
            return "";
        }
    }

    private static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(com.baidu.mobstat.a.b(a, a, com.baidu.mobstat.b.a(str.getBytes())));
        } catch (Exception e2) {
            b(e2);
            return "";
        }
    }

    private static void g(String str) {
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
        } catch (IOException e2) {
        } catch (Exception e3) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String h(String str) {
        String str2;
        TelephonyManager telephonyManager;
        try {
            telephonyManager = (TelephonyManager) this.b.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
        } catch (Exception e2) {
            Log.e("DeviceId", "Read IMEI failed", e2);
        }
        if (telephonyManager != null) {
            str2 = telephonyManager.getDeviceId();
            String i = i(str2);
            return !TextUtils.isEmpty(i) ? str : i;
        }
        str2 = null;
        String i2 = i(str2);
        if (!TextUtils.isEmpty(i2)) {
        }
    }

    private static String i(String str) {
        return (str == null || !str.contains(":")) ? str : "";
    }
}
