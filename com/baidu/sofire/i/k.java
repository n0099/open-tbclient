package com.baidu.sofire.i;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.webkit.internal.ETAG;
import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class k {
    private static final String a = new String(b.a(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, 61}));
    private static final String b = new String(b.a(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, 61}));
    private static final String c = a + b;
    private static c d;
    private Context e;

    private k(Context context) {
        this.e = context;
    }

    private String a(String str) {
        try {
            return Settings.System.getString(this.e.getContentResolver(), str);
        } catch (Throwable th) {
            com.baidu.sofire.i.d.a();
            return null;
        }
    }

    private static String a(File file) {
        FileReader fileReader;
        String str = null;
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
                str = charArrayWriter.toString();
                try {
                    fileReader.close();
                } catch (Throwable th) {
                    com.baidu.sofire.i.d.a();
                }
            } catch (Throwable th2) {
                try {
                    com.baidu.sofire.i.d.a();
                    return str;
                } finally {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable th3) {
                            com.baidu.sofire.i.d.a();
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            fileReader = null;
        }
        return str;
    }

    public static String a(Context context) {
        try {
            c b2 = b(context);
            if (b2 != null) {
                return b2.a();
            }
        } catch (Throwable th) {
            com.baidu.sofire.i.d.a();
        }
        return "";
    }

    private static synchronized c b(Context context) {
        c cVar;
        synchronized (k.class) {
            if (d == null) {
                d = new k(context).a();
            }
            cVar = d;
        }
        return cVar;
    }

    private c a() {
        boolean z;
        c cVar = null;
        try {
            File file = new File(this.e.getFilesDir(), com.baidu.sofire.i.d.f("K5j7Snuat7HHCaEg62XaRa41Ukv_4vtSH9Z4FqXi1Fs="));
            if (file.exists()) {
                cVar = c.a(d(a(file)));
            }
            if (cVar == null) {
                c a2 = c.a(d(a(com.baidu.sofire.i.d.f("FLI7RPHK558lhmIMdK5V1-nh-gfSlVAFvUdffcjh8sgAXO2nb2l_YXWA6lX6geWt"))));
                if (a2 != null) {
                    return a2;
                }
                if (this.e.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    a2 = b();
                }
                if (a2 == null) {
                    c c2 = c();
                    if (c2 == null && z) {
                        return b(c(""));
                    }
                    return c2;
                }
                return a2;
            }
            return cVar;
        } catch (Throwable th) {
            com.baidu.sofire.i.d.a();
            return null;
        }
    }

    private static c b() {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), com.baidu.sofire.i.d.f("_99uIeWLLYgYWnfdVm4xmTNMy58crLVzIq1_1xd6OaXaqNsyUOaKaQPHeL9hMa2J") + "/" + com.baidu.sofire.i.d.f("idzo8hWEQF2c4tBTa5WOlQMU8UU8Wq-86X4X9ljayiU="));
            if (file.exists()) {
                String a2 = a(file);
                if (!TextUtils.isEmpty(a2)) {
                    return c.a(new String(a.a(c, c, b.a(a2.getBytes()))));
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.i.d.a();
        }
        return null;
    }

    private static c b(String str) {
        boolean z = Build.VERSION.SDK_INT < 23;
        if (z && TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = "";
        File file = new File(Environment.getExternalStorageDirectory(), com.baidu.sofire.i.d.f("u_lhldj5Nkwulw6YvIU2wr_ieZRcYQnQZ7zSlbUYnYY=") + "/" + com.baidu.sofire.i.d.f("u2fjUEpcZJL7IE6RlBqIRmFJW_FjZrNApjdMKDgt7FM="));
        if (!file.exists()) {
            file = new File(Environment.getExternalStorageDirectory(), com.baidu.sofire.i.d.f("_99uIeWLLYgYWnfdVm4xmTNMy58crLVzIq1_1xd6OaXaqNsyUOaKaQPHeL9hMa2J") + "/" + com.baidu.sofire.i.d.f("u2fjUEpcZJL7IE6RlBqIRmFJW_FjZrNApjdMKDgt7FM="));
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
            String[] split = new String(a.a(c, c, b.a(sb.toString().getBytes()))).split(ETAG.EQUAL);
            if (split != null && split.length == 2) {
                if (z && str.equals(split[0])) {
                    str2 = split[1];
                } else if (!z) {
                    if (TextUtils.isEmpty(str)) {
                        str = split[1];
                    }
                    str2 = split[1];
                }
            }
        } catch (Throwable th) {
            com.baidu.sofire.i.d.a();
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        c cVar = new c((byte) 0);
        cVar.a = str2;
        cVar.b = str;
        return cVar;
    }

    private c c() {
        String str;
        try {
            String a2 = a(com.baidu.sofire.i.d.f("FLI7RPHK558lhmIMdK5V18TV2libLOeHJlQPRa8lKBaxRs4pujQo1mXKtiCUFVkg"));
            String a3 = a(com.baidu.sofire.i.d.f("ARQJ8IArCy4jLSUJ6i4PbDdNue2ww1CwfUTDQn8F4ug="));
            String c2 = TextUtils.isEmpty(a3) ? c("") : a3;
            if (TextUtils.isEmpty(a2)) {
                String string = Settings.Secure.getString(this.e.getContentResolver(), "android_id");
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
                str = a(d.a((com.baidu.sofire.i.d.f("q6R8gqLUgHDSsH6dbL27xN7Qr9sa0MxMqXTV66AWUUE=") + c2 + string).getBytes()));
            } else {
                str = a2;
            }
            if (!TextUtils.isEmpty(str)) {
                c cVar = new c((byte) 0);
                cVar.a = str;
                cVar.b = c2;
                return cVar;
            }
        } catch (Throwable th) {
            com.baidu.sofire.i.d.a();
        }
        return null;
    }

    private static String c(String str) {
        String str2 = "0";
        if ("0".contains(":")) {
            str2 = "";
        }
        return TextUtils.isEmpty(str2) ? str : str2;
    }

    private static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(a.a(c, c, b.a(str.getBytes())));
        } catch (Throwable th) {
            com.baidu.sofire.i.d.a();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c {
        public String a;
        public String b;

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        public static c a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("deviceid");
                String string2 = jSONObject.getString("imei");
                if (TextUtils.isEmpty(string) || string2 == null) {
                    return null;
                }
                c cVar = new c();
                cVar.a = string;
                cVar.b = string2;
                return cVar;
            } catch (Throwable th) {
                com.baidu.sofire.i.d.a();
                return null;
            }
        }

        public final String a() {
            try {
                String str = this.b;
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                return this.a + "|" + new StringBuffer(str).reverse().toString();
            } catch (Throwable th) {
                com.baidu.sofire.i.d.a();
                return null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        public static byte[] a(String str, String str2, byte[] bArr) throws Exception {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), com.baidu.sapi2.utils.h.q);
            Cipher cipher = Cipher.getInstance(com.baidu.sapi2.utils.h.p);
            cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
            return cipher.doFinal(bArr);
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        private static final byte[] a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        public static byte[] a(byte[] bArr) {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            int length = bArr.length;
            int i6 = (length / 4) * 3;
            if (i6 == 0) {
                return new byte[0];
            }
            byte[] bArr2 = new byte[i6];
            int i7 = length;
            int i8 = 0;
            while (true) {
                byte b = bArr[i7 - 1];
                if (b != 10 && b != 13 && b != 32 && b != 9) {
                    if (b != 61) {
                        break;
                    }
                    i8++;
                }
                i7--;
            }
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (i9 < i7) {
                byte b2 = bArr[i9];
                if (b2 == 10 || b2 == 13 || b2 == 32 || b2 == 9) {
                    i = i10;
                    i2 = i12;
                    i3 = i11;
                } else {
                    if (b2 >= 65 && b2 <= 90) {
                        i4 = b2 - 65;
                    } else if (b2 >= 97 && b2 <= 122) {
                        i4 = b2 - 71;
                    } else if (b2 >= 48 && b2 <= 57) {
                        i4 = b2 + 4;
                    } else if (b2 == 43) {
                        i4 = 62;
                    } else if (b2 == 47) {
                        i4 = 63;
                    } else {
                        return null;
                    }
                    int i13 = (i10 << 6) | ((byte) i4);
                    if (i11 % 4 == 3) {
                        int i14 = i12 + 1;
                        bArr2[i12] = (byte) ((16711680 & i13) >> 16);
                        int i15 = i14 + 1;
                        bArr2[i14] = (byte) ((65280 & i13) >> 8);
                        i5 = i15 + 1;
                        bArr2[i15] = (byte) (i13 & 255);
                    } else {
                        i5 = i12;
                    }
                    i3 = i11 + 1;
                    i2 = i5;
                    i = i13;
                }
                i9++;
                i11 = i3;
                i12 = i2;
                i10 = i;
            }
            if (i8 > 0) {
                int i16 = i10 << (i8 * 6);
                int i17 = i12 + 1;
                bArr2[i12] = (byte) ((16711680 & i16) >> 16);
                if (i8 == 1) {
                    i12 = i17 + 1;
                    bArr2[i17] = (byte) ((65280 & i16) >> 8);
                } else {
                    i12 = i17;
                }
            }
            byte[] bArr3 = new byte[i12];
            System.arraycopy(bArr2, 0, bArr3, 0, i12);
            return bArr3;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {
        public static String a(byte[] bArr) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                messageDigest.update(bArr);
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    String upperCase = Integer.toHexString(b & 255).toUpperCase();
                    if (upperCase.length() == 1) {
                        sb.append("0");
                    }
                    sb.append(upperCase).append("");
                }
                return sb.toString();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
