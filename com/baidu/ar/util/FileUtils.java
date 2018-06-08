package com.baidu.ar.util;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public final class FileUtils {
    private FileUtils() {
    }

    public static void deleteDir(File file) {
        deleteDir(file, true);
    }

    public static void deleteDir(File file, boolean z) {
        if (file == null || !file.isDirectory()) {
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteDir(file2, z);
                } else {
                    file2.delete();
                }
            }
        }
        if (z) {
            file.delete();
        }
    }

    public static boolean deleteFileIfExist(File file) {
        if (file != null && file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static void ensureDir(File file) {
        if (!file.exists()) {
            file.mkdirs();
        } else if (file.isFile()) {
            file.delete();
            file.mkdirs();
        }
    }

    public static boolean ensureDirectoryExist(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            try {
                file.mkdirs();
            } catch (SecurityException e) {
                return false;
            }
        }
        return true;
    }

    public static void ensureParent(File file) {
        File parentFile;
        if (file == null || (parentFile = file.getParentFile()) == null || parentFile.exists()) {
            return;
        }
        parentFile.mkdirs();
    }

    public static boolean existsDir(File file) {
        return file != null && file.exists() && file.isDirectory();
    }

    public static boolean existsDir(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return existsDir(new File(str));
    }

    public static boolean existsFile(File file) {
        return file != null && file.exists() && file.isFile();
    }

    public static boolean existsFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return existsFile(new File(str));
    }

    public static ArrayList<File> getChildFiles(File file) {
        File[] listFiles = file.listFiles();
        ArrayList<File> arrayList = new ArrayList<>();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    arrayList.add(file2);
                } else {
                    getChildFiles(file2);
                }
            }
        }
        return arrayList;
    }

    public static String getFileExtention(String str) {
        int lastIndexOf;
        if (str == null || str.length() == 0 || (lastIndexOf = str.lastIndexOf(".")) <= -1 || lastIndexOf >= str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }

    public static FileOutputStream openFileOutputStream(File file) {
        deleteFileIfExist(file);
        ensureParent(file);
        file.createNewFile();
        return new FileOutputStream(file);
    }

    public static List<String> readFileLineText(File file) {
        FileInputStream fileInputStream;
        List<String> list = null;
        try {
            if (existsFile(file)) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        list = IoUtils.loadLineContent(fileInputStream);
                        IoUtils.closeQuietly(fileInputStream);
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        IoUtils.closeQuietly(fileInputStream);
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        return list;
                    }
                } catch (IOException e4) {
                    e = e4;
                    fileInputStream = null;
                } catch (Throwable th) {
                    fileInputStream = null;
                    th = th;
                    IoUtils.closeQuietly(fileInputStream);
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    throw th;
                }
            }
            return list;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static List<String> readFileLineText(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return readFileLineText(new File(str));
    }

    public static String readFileText(File file) {
        FileInputStream fileInputStream;
        String str = null;
        try {
            if (existsFile(file)) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        str = IoUtils.loadContent(fileInputStream);
                        IoUtils.closeQuietly(fileInputStream);
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        IoUtils.closeQuietly(fileInputStream);
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        return str;
                    }
                } catch (IOException e4) {
                    e = e4;
                    fileInputStream = null;
                } catch (Throwable th) {
                    fileInputStream = null;
                    th = th;
                    IoUtils.closeQuietly(fileInputStream);
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    throw th;
                }
            }
            return str;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String readFileText(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return readFileText(new File(str));
    }
}
