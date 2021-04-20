package com.baidu.sofire.g;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.tbadk.core.util.FieldBuilder;
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
/* loaded from: classes2.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final String f11424a = new String(b.a(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, 61}));

    /* renamed from: b  reason: collision with root package name */
    public static final String f11425b = new String(b.a(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, 61}));

    /* renamed from: c  reason: collision with root package name */
    public static final String f11426c = f11424a + f11425b;

    /* renamed from: d  reason: collision with root package name */
    public static c f11427d;

    /* renamed from: e  reason: collision with root package name */
    public Context f11428e;

    /* loaded from: classes2.dex */
    public static class a {
        public static byte[] a(String str, String str2, byte[] bArr) throws Exception {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
            return cipher.doFinal(bArr);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final byte[] f11429a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, Constants.SHORT_PING_CMD_TYPE, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        public static byte[] a(byte[] bArr) {
            byte b2;
            int i;
            int length = bArr.length;
            int i2 = (length / 4) * 3;
            if (i2 == 0) {
                return new byte[0];
            }
            byte[] bArr2 = new byte[i2];
            int i3 = 0;
            while (true) {
                byte b3 = bArr[length - 1];
                b2 = 10;
                if (b3 != 10 && b3 != 13 && b3 != 32 && b3 != 9) {
                    if (b3 != 61) {
                        break;
                    }
                    i3++;
                }
                length--;
            }
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i4 < length) {
                byte b4 = bArr[i4];
                if (b4 != b2 && b4 != 13 && b4 != 32 && b4 != 9) {
                    if (b4 >= 65 && b4 <= 90) {
                        i = b4 - 65;
                    } else if (b4 >= 97 && b4 <= 122) {
                        i = b4 - 71;
                    } else if (b4 >= 48 && b4 <= 57) {
                        i = b4 + 4;
                    } else if (b4 == 43) {
                        i = 62;
                    } else if (b4 != 47) {
                        return null;
                    } else {
                        i = 63;
                    }
                    i5 = (i5 << 6) | ((byte) i);
                    if (i7 % 4 == 3) {
                        int i8 = i6 + 1;
                        bArr2[i6] = (byte) ((i5 & ItemTouchHelper.ACTION_MODE_DRAG_MASK) >> 16);
                        int i9 = i8 + 1;
                        bArr2[i8] = (byte) ((i5 & 65280) >> 8);
                        bArr2[i9] = (byte) (i5 & 255);
                        i6 = i9 + 1;
                    }
                    i7++;
                }
                i4++;
                b2 = 10;
            }
            if (i3 > 0) {
                int i10 = i5 << (i3 * 6);
                int i11 = i6 + 1;
                bArr2[i6] = (byte) ((i10 & ItemTouchHelper.ACTION_MODE_DRAG_MASK) >> 16);
                if (i3 == 1) {
                    i6 = i11 + 1;
                    bArr2[i11] = (byte) ((i10 & 65280) >> 8);
                } else {
                    i6 = i11;
                }
            }
            byte[] bArr3 = new byte[i6];
            System.arraycopy(bArr2, 0, bArr3, 0, i6);
            return bArr3;
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f11430a;

        /* renamed from: b  reason: collision with root package name */
        public String f11431b;

        public c() {
        }

        public static c a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString(DeviceUtils.KEY_OLD_NAME_STRING);
                String string2 = jSONObject.getString("imei");
                if (!TextUtils.isEmpty(string) && string2 != null) {
                    c cVar = new c();
                    cVar.f11430a = string;
                    cVar.f11431b = string2;
                    return cVar;
                }
                return null;
            } catch (Throwable unused) {
                com.baidu.sofire.g.d.a();
                return null;
            }
        }

        public /* synthetic */ c(byte b2) {
            this();
        }

        public final String a() {
            try {
                String str = this.f11431b;
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                String stringBuffer = new StringBuffer(str).reverse().toString();
                return this.f11430a + FieldBuilder.SE + stringBuffer;
            } catch (Throwable unused) {
                com.baidu.sofire.g.d.a();
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d {
        public static String a(byte[] bArr) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                messageDigest.update(bArr);
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b2 : digest) {
                    String upperCase = Integer.toHexString(b2 & 255).toUpperCase();
                    if (upperCase.length() == 1) {
                        sb.append("0");
                    }
                    sb.append(upperCase);
                    sb.append("");
                }
                return sb.toString();
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public j(Context context) {
        this.f11428e = context;
    }

    private String a(String str) {
        try {
            return r.b(this.f11428e) ? Settings.System.getString(this.f11428e.getContentResolver(), str) : "";
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            return null;
        }
    }

    public static synchronized c b(Context context) {
        c cVar;
        synchronized (j.class) {
            if (f11427d == null) {
                f11427d = new j(context).a();
            }
            cVar = f11427d;
        }
        return cVar;
    }

    private c c() {
        try {
            String a2 = a(com.baidu.sofire.g.d.f("FLI7RPHK558lhmIMdK5V18TV2libLOeHJlQPRa8lKBaxRs4pujQo1mXKtiCUFVkg"));
            String a3 = a(com.baidu.sofire.g.d.f("ARQJ8IArCy4jLSUJ6i4PbDdNue2ww1CwfUTDQn8F4ug="));
            if (TextUtils.isEmpty(a3)) {
                a3 = c("");
            }
            if (TextUtils.isEmpty(a2)) {
                String i = r.i(this.f11428e);
                a2 = a(d.a((com.baidu.sofire.g.d.f("q6R8gqLUgHDSsH6dbL27xN7Qr9sa0MxMqXTV66AWUUE=") + a3 + i).getBytes()));
            }
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            c cVar = new c((byte) 0);
            cVar.f11430a = a2;
            cVar.f11431b = a3;
            return cVar;
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            return null;
        }
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(a.a(f11426c, f11426c, b.a(str.getBytes())));
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            return "";
        }
    }

    public static String a(File file) {
        FileReader fileReader;
        try {
            fileReader = new FileReader(file);
        } catch (Throwable unused) {
            fileReader = null;
        }
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
            } catch (Throwable unused2) {
                com.baidu.sofire.g.d.a();
            }
            return charArrayWriter2;
        } catch (Throwable unused3) {
            try {
                com.baidu.sofire.g.d.a();
                return null;
            } finally {
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable unused4) {
                        com.baidu.sofire.g.d.a();
                    }
                }
            }
        }
    }

    private c b() {
        try {
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
        if (r.c(this.f11428e)) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            File file = new File(externalStorageDirectory, com.baidu.sofire.g.d.f("_99uIeWLLYgYWnfdVm4xmTNMy58crLVzIq1_1xd6OaXaqNsyUOaKaQPHeL9hMa2J") + "/" + com.baidu.sofire.g.d.f("idzo8hWEQF2c4tBTa5WOlQMU8UU8Wq-86X4X9ljayiU="));
            if (file.exists()) {
                String a2 = a(file);
                if (!TextUtils.isEmpty(a2)) {
                    return c.a(new String(a.a(f11426c, f11426c, b.a(a2.getBytes()))));
                }
            }
            return null;
        }
        return null;
    }

    public static String a(Context context) {
        try {
            c b2 = b(context);
            return b2 != null ? b2.a() : "";
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            return "";
        }
    }

    private c b(String str) {
        boolean z = Build.VERSION.SDK_INT < 23;
        if (!(z && TextUtils.isEmpty(str)) && r.c(this.f11428e)) {
            String str2 = "";
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            File file = new File(externalStorageDirectory, com.baidu.sofire.g.d.f("u_lhldj5Nkwulw6YvIU2wr_ieZRcYQnQZ7zSlbUYnYY=") + "/" + com.baidu.sofire.g.d.f("u2fjUEpcZJL7IE6RlBqIRmFJW_FjZrNApjdMKDgt7FM="));
            if (!file.exists()) {
                File externalStorageDirectory2 = Environment.getExternalStorageDirectory();
                file = new File(externalStorageDirectory2, com.baidu.sofire.g.d.f("_99uIeWLLYgYWnfdVm4xmTNMy58crLVzIq1_1xd6OaXaqNsyUOaKaQPHeL9hMa2J") + "/" + com.baidu.sofire.g.d.f("u2fjUEpcZJL7IE6RlBqIRmFJW_FjZrNApjdMKDgt7FM="));
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
                String[] split = new String(a.a(f11426c, f11426c, b.a(sb.toString().getBytes()))).split("=");
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
            } catch (Throwable unused) {
                com.baidu.sofire.g.d.a();
            }
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            c cVar = new c((byte) 0);
            cVar.f11430a = str2;
            cVar.f11431b = str;
            return cVar;
        }
        return null;
    }

    public static String c(String str) {
        return TextUtils.isEmpty("0") ? str : "0";
    }

    private c a() {
        try {
            File file = new File(this.f11428e.getFilesDir(), com.baidu.sofire.g.d.f("K5j7Snuat7HHCaEg62XaRa41Ukv_4vtSH9Z4FqXi1Fs="));
            c a2 = file.exists() ? c.a(d(a(file))) : null;
            if (a2 != null) {
                return a2;
            }
            c a3 = c.a(d(a(com.baidu.sofire.g.d.f("FLI7RPHK558lhmIMdK5V1-nh-gfSlVAFvUdffcjh8sgAXO2nb2l_YXWA6lX6geWt"))));
            if (a3 != null) {
                return a3;
            }
            boolean z = this.f11428e.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) == 0;
            if (z) {
                a3 = b();
            }
            if (a3 != null) {
                return a3;
            }
            c c2 = c();
            return (c2 == null && z) ? b(c("")) : c2;
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            return null;
        }
    }
}
