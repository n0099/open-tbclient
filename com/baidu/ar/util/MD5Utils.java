package com.baidu.ar.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes3.dex */
public class MD5Utils {
    private static char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static MessageDigest b;

    static {
        try {
            b = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.err.println(MD5Utils.class.getName() + "初始化失败，MessageDigest不支持MD5Util。");
            e.printStackTrace();
        }
    }

    private static String a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    private static String a(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2 * 2);
        int i3 = i + i2;
        while (i < i3) {
            a(bArr[i], stringBuffer);
            i++;
        }
        return stringBuffer.toString();
    }

    private static void a(byte b2, StringBuffer stringBuffer) {
        char c = a[(b2 & 240) >> 4];
        char c2 = a[b2 & 15];
        stringBuffer.append(c);
        stringBuffer.append(c2);
    }

    public static boolean checkPassword(String str, String str2) {
        return getMD5String(str).equals(str2);
    }

    public static String fileToMD5(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        String str = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    byte[] bArr = new byte[1024];
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        } else if (read > 0) {
                            messageDigest.update(bArr, 0, read);
                        }
                    }
                    str = new BigInteger(1, messageDigest.digest()).toString(16);
                    IoUtils.closeQuietly(fileInputStream);
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    IoUtils.closeQuietly(fileInputStream);
                    return str;
                }
            } catch (Throwable th2) {
                th = th2;
                IoUtils.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            IoUtils.closeQuietly(fileInputStream);
            throw th;
        }
        return str;
    }

    public static String getFileMD5String(File file) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        fileInputStream.close();
                        return a(b.digest());
                    }
                    b.update(bArr, 0, read);
                }
            } catch (IOException e) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                        return null;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        } catch (IOException e3) {
            fileInputStream = null;
        }
    }

    public static String getFileMD5StringOld(File file) {
        if (file == null) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        MappedByteBuffer map = fileInputStream.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, file.length());
        fileInputStream.close();
        b.update(map);
        return a(b.digest());
    }

    public static synchronized String getMD5String(String str) {
        String mD5String;
        synchronized (MD5Utils.class) {
            mD5String = getMD5String(str.getBytes(Charset.forName(IoUtils.UTF_8)));
        }
        return mD5String;
    }

    public static String getMD5String(byte[] bArr) {
        b.update(bArr);
        return a(b.digest());
    }

    public static String md5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                bArr[i] = (byte) charArray[i];
            }
            byte[] digest = messageDigest.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                int i2 = b2 & 255;
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
