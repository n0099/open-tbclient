package com.baidu.location.b.b;

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
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
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
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class c {
    private static volatile b aBY;
    private final Context a;
    private PublicKey aBX;
    private int b = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
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

        /* synthetic */ a(d dVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public String a;
        public String b;
        public int c;

        private b() {
            this.c = 2;
        }

        /* synthetic */ b(d dVar) {
            this();
        }

        public static b ca(String str) {
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
                c.b(e);
                return null;
            }
        }

        public String a() {
            try {
                return new JSONObject().put("deviceid", this.a).put("imei", this.b).put("ver", this.c).toString();
            } catch (JSONException e) {
                c.b(e);
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

    private c(Context context) {
        this.a = context.getApplicationContext();
        a();
    }

    public static String a(Context context) {
        return aw(context).b();
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
                        } catch (Exception e) {
                            b(e);
                            str = charArrayWriter2;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    b(e);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e3) {
                            b(e3);
                        }
                    }
                    return str;
                }
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    try {
                        str.close();
                    } catch (Exception e4) {
                        b(e4);
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
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
        PackageManager packageManager = this.a.getPackageManager();
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers != null) {
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.applicationInfo != null) {
                    try {
                        Bundle bundle = packageManager.getReceiverInfo(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name), 128).metaData;
                        if (bundle != null) {
                            String string = bundle.getString("galaxy_data");
                            if (!TextUtils.isEmpty(string)) {
                                byte[] a2 = com.baidu.location.b.a.b.a(string.getBytes("utf-8"));
                                JSONObject jSONObject = new JSONObject(new String(a2));
                                a aVar = new a(null);
                                aVar.b = jSONObject.getInt(LogFactory.PRIORITY_KEY);
                                aVar.a = resolveInfo.activityInfo.applicationInfo;
                                if (this.a.getPackageName().equals(resolveInfo.activityInfo.applicationInfo.packageName)) {
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
                                            byte[] a3 = a(com.baidu.location.b.a.b.a(string2.getBytes()), this.aBX);
                                            if (a3 != null && Arrays.equals(a3, com.baidu.location.b.a.d.a(a2))) {
                                                aVar.c = true;
                                            }
                                        }
                                    }
                                }
                                arrayList.add(aVar);
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        Collections.sort(arrayList, new d(this));
        return arrayList;
    }

    private void a() {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(com.baidu.location.b.b.b.a());
        } catch (Exception e) {
            byteArrayInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.aBX = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream).getPublicKey();
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (Exception e2) {
                    b(e2);
                }
            }
        } catch (Exception e3) {
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (Exception e4) {
                    b(e4);
                }
            }
        } catch (Throwable th2) {
            byteArrayInputStream2 = byteArrayInputStream;
            th = th2;
            if (byteArrayInputStream2 != null) {
                try {
                    byteArrayInputStream2.close();
                } catch (Exception e5) {
                    b(e5);
                }
            }
            throw th;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    private boolean a(String str) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                fileOutputStream = this.a.openFileOutput("libcuid.so", 1);
                fileOutputStream.write(str.getBytes());
                fileOutputStream.flush();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        return true;
                    } catch (Exception e) {
                        b(e);
                        return true;
                    }
                }
                return true;
            } catch (Throwable th) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e2) {
                        b(e2);
                    }
                }
                throw th;
            }
        } catch (Exception e3) {
            b(e3);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e4) {
                    b(e4);
                }
            }
            return false;
        }
    }

    private boolean a(String str, String str2) {
        try {
            return Settings.System.putString(this.a.getContentResolver(), str, str2);
        } catch (Exception e) {
            b(e);
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
            strArr[i] = a(com.baidu.location.b.a.d.a(signatureArr[i].toByteArray()));
        }
        return strArr;
    }

    private static b aw(Context context) {
        if (aBY == null) {
            synchronized (b.class) {
                if (aBY == null) {
                    SystemClock.uptimeMillis();
                    aBY = new c(context).uz();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return aBY;
    }

    public static String b(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        return TextUtils.isEmpty(string) ? "" : string;
    }

    private String b(String str) {
        try {
            return Settings.System.getString(this.a.getContentResolver(), str);
        } catch (Exception e) {
            b(e);
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
            fileWriter.write(com.baidu.location.b.a.b.a(com.baidu.location.b.a.a.a("30212102dicudiab", "30212102dicudiab", (str + "=" + str2).getBytes()), "utf-8"));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Throwable th) {
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private b bZ(String str) {
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
                sb.append("\r\n");
            }
            bufferedReader.close();
            split = new String(com.baidu.location.b.a.a.b("30212102dicudiab", "30212102dicudiab", com.baidu.location.b.a.b.a(sb.toString().getBytes()))).split("=");
        } catch (FileNotFoundException e) {
            str2 = str;
        } catch (IOException e2) {
            str2 = str;
        } catch (Exception e3) {
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
                } catch (FileNotFoundException e4) {
                } catch (IOException e5) {
                } catch (Exception e6) {
                }
            }
            if (TextUtils.isEmpty(str3)) {
                b bVar = new b(null);
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

    private boolean c() {
        return c("android.permission.WRITE_SETTINGS");
    }

    private boolean c(String str) {
        return this.a.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    private static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return com.baidu.location.b.a.b.a(com.baidu.location.b.a.a.a("30212102dicudiab", "30212102dicudiab", str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException e) {
            b(e);
            return "";
        } catch (Exception e2) {
            b(e2);
            return "";
        }
    }

    private static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(com.baidu.location.b.a.a.b("30212102dicudiab", "30212102dicudiab", com.baidu.location.b.a.b.a(str.getBytes())));
        } catch (Exception e) {
            b(e);
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
        } catch (IOException e) {
        } catch (Exception e2) {
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
            telephonyManager = (TelephonyManager) this.a.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
        } catch (Exception e) {
            Log.e("DeviceId", "Read IMEI failed", e);
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

    private b uA() {
        String b2 = b("com.baidu.deviceid");
        String b3 = b("bd_setting_i");
        if (TextUtils.isEmpty(b3)) {
            b3 = h("");
            if (!TextUtils.isEmpty(b3)) {
                a("bd_setting_i", b3);
            }
        }
        if (TextUtils.isEmpty(b2)) {
            b2 = b(com.baidu.location.b.a.c.a(("com.baidu" + b3 + b(this.a)).getBytes(), true));
        }
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        b bVar = new b(null);
        bVar.a = b2;
        bVar.b = b3;
        return bVar;
    }

    private b uB() {
        File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
        if (file.exists()) {
            String a2 = a(file);
            if (!TextUtils.isEmpty(a2)) {
                try {
                    return b.ca(new String(com.baidu.location.b.a.a.b("30212102dicudiab", "30212102dicudiab", com.baidu.location.b.a.b.a(a2.getBytes()))));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private b uz() {
        boolean z;
        b bVar;
        b bVar2;
        String str;
        b bVar3;
        String str2;
        String str3 = null;
        boolean z2 = false;
        List<a> a2 = a(new Intent("com.baidu.intent.action.GALAXY").setPackage(this.a.getPackageName()), true);
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
        File file = new File(this.a.getFilesDir(), "libcuid.so");
        b ca = file.exists() ? b.ca(f(a(file))) : null;
        if (ca == null) {
            this.b |= 16;
            List<a> a3 = a(new Intent("com.baidu.intent.action.GALAXY"), z);
            if (a3 != null) {
                File filesDir = this.a.getFilesDir();
                if (com.baidu.fsg.biometrics.base.b.c.g.equals(filesDir.getName())) {
                    str2 = com.baidu.fsg.biometrics.base.b.c.g;
                } else {
                    Log.e("DeviceId", "fetal error:: app files dir name is unexpectedly :: " + filesDir.getAbsolutePath());
                    str2 = filesDir.getName();
                }
                for (a aVar2 : a3) {
                    if (!aVar2.d) {
                        File file2 = new File(new File(aVar2.a.dataDir, str2), "libcuid.so");
                        if (file2.exists()) {
                            bVar = b.ca(f(a(file2)));
                            if (bVar != null) {
                                break;
                            }
                        } else {
                            bVar = ca;
                        }
                        ca = bVar;
                    }
                }
            }
        }
        bVar = ca;
        if (bVar == null) {
            bVar = b.ca(f(b("com.baidu.deviceid.v2")));
        }
        boolean c = c("android.permission.READ_EXTERNAL_STORAGE");
        if (bVar == null && c) {
            this.b |= 2;
            bVar2 = uB();
        } else {
            bVar2 = bVar;
        }
        if (bVar2 == null) {
            this.b |= 8;
            bVar2 = uA();
        }
        if (bVar2 == null && c) {
            this.b |= 1;
            str = h("");
            bVar2 = bZ(str);
            z2 = true;
        } else {
            str = null;
        }
        if (bVar2 == null) {
            this.b |= 4;
            if (!z2) {
                str = h("");
            }
            b bVar4 = new b(null);
            String b2 = b(this.a);
            bVar4.a = com.baidu.location.b.a.c.a((Build.VERSION.SDK_INT < 23 ? str + b2 + UUID.randomUUID().toString() : "com.baidu" + b2).getBytes(), true);
            bVar4.b = str;
            bVar3 = bVar4;
        } else {
            bVar3 = bVar2;
        }
        File file3 = new File(this.a.getFilesDir(), "libcuid.so");
        if ((this.b & 16) != 0 || !file3.exists()) {
            String e = TextUtils.isEmpty(null) ? e(bVar3.a()) : null;
            a(e);
            str3 = e;
        }
        boolean c2 = c();
        if (c2 && ((this.b & 2) != 0 || TextUtils.isEmpty(b("com.baidu.deviceid.v2")))) {
            if (TextUtils.isEmpty(str3)) {
                str3 = e(bVar3.a());
            }
            a("com.baidu.deviceid.v2", str3);
        }
        if (c("android.permission.WRITE_EXTERNAL_STORAGE")) {
            File file4 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
            if ((this.b & 8) != 0 || !file4.exists()) {
                if (TextUtils.isEmpty(str3)) {
                    str3 = e(bVar3.a());
                }
                g(str3);
            }
        }
        if (c2 && ((this.b & 1) != 0 || TextUtils.isEmpty(b("com.baidu.deviceid")))) {
            a("com.baidu.deviceid", bVar3.a);
            a("bd_setting_i", bVar3.b);
        }
        if (c2 && !TextUtils.isEmpty(bVar3.b)) {
            File file5 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
            if ((this.b & 2) != 0 || !file5.exists()) {
                b(bVar3.b, bVar3.a);
            }
        }
        return bVar3;
    }
}
