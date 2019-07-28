package com.baidu.mobads.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes5.dex */
public final class v {
    public static List<File> a(String str, String str2) {
        return a(str, str2, (String) null);
    }

    public static List<File> a(String str, String str2, String str3) {
        return a(a(str), a(str2), str3);
    }

    public static List<File> a(File file, File file2, String str) {
        if (file == null || file2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        if (b(str)) {
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                if (!a(file2, arrayList, zipFile, nextElement, nextElement.getName())) {
                    return arrayList;
                }
            }
        } else {
            while (entries.hasMoreElements()) {
                ZipEntry nextElement2 = entries.nextElement();
                String name = nextElement2.getName();
                if (name.contains(str) && !a(file2, arrayList, zipFile, nextElement2, name)) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    private static boolean a(File file, List<File> list, ZipFile zipFile, ZipEntry zipEntry, String str) {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream = null;
        File file2 = new File(file + File.separator + str);
        list.add(file2);
        if (zipEntry.isDirectory()) {
            if (!a(file2)) {
                return false;
            }
        } else if (!b(file2)) {
            return false;
        } else {
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = bufferedInputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                        bufferedInputStream2.close();
                        bufferedOutputStream.close();
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        bufferedInputStream.close();
                        bufferedOutputStream.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = null;
                    bufferedInputStream = bufferedInputStream2;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
            }
        }
        return true;
    }

    private static boolean a(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    private static boolean b(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (a(file.getParentFile())) {
            try {
                return file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    private static File a(String str) {
        if (b(str)) {
            return null;
        }
        return new File(str);
    }

    private static boolean b(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
