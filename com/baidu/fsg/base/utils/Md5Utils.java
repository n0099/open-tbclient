package com.baidu.fsg.base.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;
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
/* loaded from: classes2.dex */
public final class Md5Utils {

    /* renamed from: a  reason: collision with root package name */
    public static char[] f5405a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static synchronized String a(byte[] bArr) {
        String sb;
        synchronized (Md5Utils.class) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr);
                byte[] digest = messageDigest.digest();
                StringBuilder sb2 = new StringBuilder();
                for (byte b2 : digest) {
                    sb2.append(Integer.toHexString((b2 & 255) | (-256)).substring(6));
                }
                sb = sb2.toString();
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return sb;
    }

    public static byte[] b(byte[] bArr) {
        return a().digest(bArr);
    }

    public static String getMd5FromFile(String str) {
        FileInputStream fileInputStream;
        if (!TextUtils.isEmpty(str)) {
            String str2 = null;
            str2 = null;
            str2 = null;
            FileInputStream fileInputStream2 = null;
            try {
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
            }
            try {
                try {
                    fileInputStream = new FileInputStream(str);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                try {
                    str2 = getMd5FromInputStream(fileInputStream);
                    fileInputStream.close();
                } catch (FileNotFoundException e3) {
                    e = e3;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return str2;
                }
            } catch (FileNotFoundException e4) {
                e = e4;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
            return str2;
        }
        throw new IllegalArgumentException("file path is empty");
    }

    public static String getMd5FromInputStream(InputStream inputStream) {
        int i2;
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
            for (byte b2 : a2.digest()) {
                sb.append(Integer.toHexString((b2 & 255) | (-256)).substring(6));
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return sb.toString();
    }

    public static String md5Hex(byte[] bArr) {
        return a(b(bArr), null);
    }

    public static String toMD5(String str) {
        if (str != null) {
            try {
                return a(str.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return null;
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

    @SuppressLint({"NewApi"})
    public static String toMD5UCS2(String str) {
        if (str != null) {
            try {
                return a(new String(str.getBytes("UTF-8"), "GBK").getBytes(CharEncoding.UTF_16LE));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return null;
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
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                String str3 = (String) arrayList.get(i2);
                String optString = jSONObject.optString(str3);
                sb.append(str3 + "=" + optString + str2);
            }
        }
        sb.append("key=" + str);
        return toMD5(sb.toString());
    }

    public static String md5Hex(String str) {
        return a(a(str), null);
    }

    public static String toMD5(String str, String str2) {
        if (str != null) {
            try {
                return a(str.getBytes(str2));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static MessageDigest a() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static byte[] a(String str) {
        return b(str.getBytes());
    }

    public static String a(byte[] bArr, Character ch) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length * (ch == null ? 2 : 3));
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = (bArr[i2] >>> 4) & 15;
            int i4 = bArr[i2] & 15;
            if (i2 > 0 && ch != null) {
                stringBuffer.append(ch.charValue());
            }
            stringBuffer.append(f5405a[i3]);
            stringBuffer.append(f5405a[i4]);
        }
        return stringBuffer.toString();
    }
}
