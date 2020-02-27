package com.baidu.ala.downloader;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.n;
import com.baidu.adp.lib.util.s;
import com.baidu.ala.AlaSharedPrefHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.m;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes3.dex */
public class DownloaderHelper {
    public static String getFileMd5(File file) {
        String md5 = s.toMd5(m.GetStreamFromFile(file));
        if (!StringUtils.isNull(md5)) {
            return md5.toLowerCase();
        }
        return md5;
    }

    public static boolean checkDirFiles(String str, ArrayList<String> arrayList) {
        File[] listFiles;
        boolean z = false;
        if (existFile(str)) {
            if (!isDirectory(str)) {
                m.deleteFileOrDir(new File(str));
                return true;
            } else if (arrayList == null || arrayList.size() <= 0 || (listFiles = new File(str).listFiles()) == null || listFiles.length == 0) {
                return true;
            } else {
                int i = 0;
                while (true) {
                    if (i >= listFiles.length) {
                        break;
                    } else if (!listFiles[i].isDirectory() && !arrayList.contains(getFileMd5(listFiles[i]))) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
                return z;
            }
        }
        return true;
    }

    public static ArrayList<String> getAllFileMd5Set(String str) {
        ArrayList<String> arrayList = null;
        String string = AlaSharedPrefHelper.getInstance().getString(str, null);
        if (string == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            ArrayList<String> arrayList2 = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    String str2 = (String) jSONArray.opt(i);
                    if (str2 != null) {
                        arrayList2.add(str2);
                    }
                } catch (JSONException e) {
                    arrayList = arrayList2;
                    e = e;
                    e.printStackTrace();
                    return arrayList;
                }
            }
            return arrayList2;
        } catch (JSONException e2) {
            e = e2;
        }
    }

    public static void saveAllFileMd5ToSharePreference(String str, String str2) {
        File[] listFiles;
        String fileMd5;
        if (!StringUtils.isNull(str2) && (listFiles = new File(str2).listFiles()) != null) {
            JSONArray jSONArray = new JSONArray();
            for (File file : listFiles) {
                if (file != null && !file.isDirectory() && (fileMd5 = getFileMd5(file)) != null) {
                    jSONArray.put(fileMd5);
                }
            }
            AlaSharedPrefHelper.getInstance().putString(str, jSONArray.toString());
        }
    }

    public static boolean unZipFile(String str, String str2) {
        ZipInputStream zipInputStream;
        try {
            try {
                zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry != null) {
                            if (!nextEntry.isDirectory()) {
                                saveFile(str2, nextEntry.getName(), zipInputStream);
                            }
                        } else {
                            zipInputStream.close();
                            m.deleteFile(new File(str));
                            n.close((InputStream) zipInputStream);
                            return true;
                        }
                    } catch (FileNotFoundException e) {
                        e = e;
                        e.printStackTrace();
                        n.close((InputStream) zipInputStream);
                        return false;
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        n.close((InputStream) zipInputStream);
                        return false;
                    }
                }
            } catch (Throwable th) {
                th = th;
                n.close((InputStream) null);
                throw th;
            }
        } catch (FileNotFoundException e3) {
            e = e3;
            zipInputStream = null;
        } catch (IOException e4) {
            e = e4;
            zipInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            n.close((InputStream) null);
            throw th;
        }
    }

    public static void cleanDir(File file) {
        try {
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                int length = listFiles.length;
                for (int i = 0; i < length; i++) {
                    if (listFiles[i].isFile()) {
                        listFiles[i].delete();
                    } else {
                        cleanDir(listFiles[i]);
                    }
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [267=5] */
    public static String saveFile(String str, String str2, InputStream inputStream) {
        String str3;
        FileOutputStream fileOutputStream;
        if (inputStream == null || StringUtils.isNull(str2)) {
            return null;
        }
        if (str2.contains("/.")) {
            return null;
        }
        try {
            String[] split = str2.split("/");
            str3 = split.length > 1 ? split[split.length - 1] : split[0];
        } catch (Exception e) {
            e.printStackTrace();
            str3 = str2;
        }
        if (!existFile(str)) {
            new File(str).mkdirs();
        }
        File file = new File(str + "/" + str3);
        String parent = file.getParent();
        if (!StringUtils.isNull(parent)) {
            File file2 = new File(parent);
            if (!file2.exists()) {
                file2.mkdirs();
            }
        }
        try {
            if (file.exists() && !file.delete()) {
                n.close((OutputStream) null);
                return null;
            } else if (!file.createNewFile()) {
                n.close((OutputStream) null);
                return null;
            } else {
                fileOutputStream = new FileOutputStream(file);
                try {
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                fileOutputStream.flush();
                                String path = file.getPath();
                                n.close((OutputStream) fileOutputStream);
                                return path;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                    } catch (IOException e2) {
                        e = e2;
                        BdLog.e(e.getMessage());
                        TiebaStatic.file(e, "FileHelper.saveFile " + str + "/" + str3);
                        n.close((OutputStream) fileOutputStream);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    n.close((OutputStream) fileOutputStream);
                    throw th;
                }
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            n.close((OutputStream) fileOutputStream);
            throw th;
        }
    }

    public static boolean existFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new File(str).exists();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public static boolean isDirectory(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new File(str).isDirectory();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }
}
