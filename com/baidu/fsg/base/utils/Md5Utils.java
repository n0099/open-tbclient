package com.baidu.fsg.base.utils;

import android.annotation.SuppressLint;
import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.apache.commons.base.CharEncoding;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public final class Md5Utils {

    /* renamed from: a  reason: collision with root package name */
    private static char[] f1515a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private Md5Utils() {
    }

    public static String toMD5(String str) {
        if (str != null) {
            try {
                return a(str.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String toMds(JSONObject jSONObject, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (jSONObject != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                arrayList.add(keys.next());
            }
            Collections.sort(arrayList);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                String str3 = (String) arrayList.get(i2);
                sb.append(str3 + ETAG.EQUAL + jSONObject.optString(str3) + str2);
                i = i2 + 1;
            }
        }
        sb.append("key=" + str);
        return toMD5(sb.toString());
    }

    public static String toMD5(String str, String str2) {
        if (str != null) {
            try {
                return a(str.getBytes(str2));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    public static String toMD5UCS2(String str) {
        if (str != null) {
            try {
                return a(new String(str.getBytes("UTF-8"), "GBK").getBytes(CharEncoding.UTF_16LE));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String toMD5NoEncode(String str) {
        if (str != null) {
            return a(str.getBytes());
        }
        return null;
    }

    private static synchronized String a(byte[] bArr) {
        String str;
        synchronized (Md5Utils.class) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr);
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    sb.append(Integer.toHexString((b & 255) | InputDeviceCompat.SOURCE_ANY).substring(6));
                }
                str = sb.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                str = null;
            }
        }
        return str;
    }

    private static MessageDigest a() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] b(byte[] bArr) {
        return a().digest(bArr);
    }

    private static byte[] a(String str) {
        return b(str.getBytes());
    }

    public static String md5Hex(byte[] bArr) {
        return a(b(bArr), null);
    }

    public static String md5Hex(String str) {
        return a(a(str), null);
    }

    private static String a(byte[] bArr, Character ch) {
        StringBuffer stringBuffer = new StringBuffer((ch == null ? 2 : 3) * bArr.length);
        for (int i = 0; i < bArr.length; i++) {
            int i2 = (bArr[i] >>> 4) & 15;
            int i3 = bArr[i] & 15;
            if (i > 0 && ch != null) {
                stringBuffer.append(ch.charValue());
            }
            stringBuffer.append(f1515a[i2]);
            stringBuffer.append(f1515a[i3]);
        }
        return stringBuffer.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [296=4] */
    public static String getMd5FromFile(String str) {
        FileInputStream fileInputStream;
        String str2 = null;
        try {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("file path is empty");
            }
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    str2 = getMd5FromInputStream(fileInputStream);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return str2;
                }
            } catch (FileNotFoundException e4) {
                e = e4;
                fileInputStream = null;
            } catch (Throwable th) {
                fileInputStream = null;
                th = th;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
            return str2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String getMd5FromInputStream(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest a2 = a();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                a2.update(bArr, 0, read);
            }
            for (byte b : a2.digest()) {
                sb.append(Integer.toHexString((b & 255) | InputDeviceCompat.SOURCE_ANY).substring(6));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
