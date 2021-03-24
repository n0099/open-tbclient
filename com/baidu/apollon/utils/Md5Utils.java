package com.baidu.apollon.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.base.CharEncoding;
/* loaded from: classes2.dex */
public final class Md5Utils {

    /* renamed from: a  reason: collision with root package name */
    public static char[] f3966a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

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

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x004d: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:34:0x004d */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getMd5FromFile(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        if (!TextUtils.isEmpty(str)) {
            String str2 = null;
            str2 = null;
            str2 = null;
            str2 = null;
            str2 = null;
            FileInputStream fileInputStream3 = null;
            try {
                try {
                    try {
                        fileInputStream = new FileInputStream(str);
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream3 = fileInputStream2;
                        if (fileInputStream3 != null) {
                            try {
                                fileInputStream3.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileInputStream = null;
                } catch (IOException e4) {
                    e = e4;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream3 != null) {
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            try {
                MessageDigest a2 = a();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    a2.update(bArr, 0, read);
                }
                str2 = md5Hex(a2.digest());
                fileInputStream.close();
            } catch (FileNotFoundException e6) {
                e = e6;
                e.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return str2;
            } catch (IOException e7) {
                e = e7;
                e.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return str2;
            }
            return str2;
        }
        throw new IllegalArgumentException("file path is empty");
    }

    public static String md5Hex(byte[] bArr) {
        return a(b(bArr), null);
    }

    public static String toMD5(String str) {
        if (str != null) {
            try {
                return a(str.getBytes("GBK"));
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
                return a(new String(str.getBytes("GBK"), "GBK").getBytes(CharEncoding.UTF_16LE));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
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
        for (int i = 0; i < bArr.length; i++) {
            int i2 = (bArr[i] >>> 4) & 15;
            int i3 = bArr[i] & 15;
            if (i > 0 && ch != null) {
                stringBuffer.append(ch.charValue());
            }
            stringBuffer.append(f3966a[i2]);
            stringBuffer.append(f3966a[i3]);
        }
        return stringBuffer.toString();
    }
}
