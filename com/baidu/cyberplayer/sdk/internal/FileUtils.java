package com.baidu.cyberplayer.sdk.internal;

import com.baidu.zeus.NotificationProxy;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Stack;
/* loaded from: classes.dex */
public class FileUtils {
    public static String getDirFromFile(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf > 0) {
            return str.substring(0, lastIndexOf);
        }
        return "./";
    }

    public static boolean createNewFile(String str) {
        if (str == null) {
            return false;
        }
        try {
            File file = new File(getDirFromFile(str));
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(str);
            if (!file2.exists()) {
                file2.createNewFile();
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean fileExists(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isFile();
    }

    public static boolean dirExists(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isDirectory();
    }

    public static void remove(String str) {
        String[] list;
        Stack stack = new Stack();
        stack.push(str);
        while (stack.size() > 0) {
            String str2 = (String) stack.pop();
            File file = new File(str2);
            if (file.isDirectory()) {
                String[] list2 = file.list();
                if (list2 != null && list2.length > 0) {
                    stack.push(str2);
                    String str3 = str2 + "/";
                    int length = file.list().length;
                    for (int i = 0; i < length; i++) {
                        stack.push(str3 + list[i]);
                    }
                } else {
                    file.delete();
                }
            } else {
                file.delete();
            }
        }
    }

    public static String getFileMD5(File file) {
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[NotificationProxy.MAX_URL_LENGTH];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, NotificationProxy.MAX_URL_LENGTH);
                if (read != -1) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return new BigInteger(1, messageDigest.digest()).toString(16);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
