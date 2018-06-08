package com.baidu.ar.util;

import android.content.ContentResolver;
import android.os.Environment;
import android.os.StatFs;
import android.provider.MediaStore;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.baidu.ar.external.ARCallback;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes3.dex */
public final class ARFileUtils {
    public static final String AR_UNZIP_ROOT_DIR = "ar";
    private static String a = null;

    private ARFileUtils() {
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:59:0x00b8 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v8 */
    private static HashSet<String> a(String str) {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        HashSet<String> hashSet = new HashSet<>();
        ?? exists = new File(str).exists();
        try {
            if (exists == 0) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
                } catch (FileNotFoundException e) {
                    e = e;
                    bufferedReader = null;
                    inputStreamReader = null;
                } catch (IOException e2) {
                    e = e2;
                    bufferedReader = null;
                    inputStreamReader = null;
                } catch (Throwable th) {
                    exists = 0;
                    inputStreamReader = null;
                    th = th;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                bufferedReader = null;
                inputStreamReader = null;
                fileInputStream = null;
            } catch (IOException e4) {
                e = e4;
                bufferedReader = null;
                inputStreamReader = null;
                fileInputStream = null;
            } catch (Throwable th2) {
                exists = 0;
                inputStreamReader = null;
                fileInputStream = null;
                th = th2;
            }
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        hashSet.add(readLine);
                    } catch (FileNotFoundException e5) {
                        e = e5;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                                return null;
                            }
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                            return null;
                        }
                        return null;
                    } catch (IOException e7) {
                        e = e7;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                                return null;
                            }
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                            return null;
                        }
                        return null;
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                    }
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                ARLog.d("keysSet size is " + hashSet.size());
                return hashSet;
            } catch (FileNotFoundException e10) {
                e = e10;
                bufferedReader = null;
            } catch (IOException e11) {
                e = e11;
                bufferedReader = null;
            } catch (Throwable th3) {
                exists = 0;
                th = th3;
                if (exists != 0) {
                    try {
                        exists.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                        throw th;
                    }
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private static void a(ContentResolver contentResolver, String str) {
        if (contentResolver == null || TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = "_data LIKE '" + str + "%'";
        contentResolver.delete(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, str2, null);
        contentResolver.delete(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, str2, null);
        contentResolver.delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, str2, null);
    }

    public static boolean checkKeyInFile(String str, String str2) {
        HashSet<String> a2 = a(getARCachePath() + File.separator + str2);
        if (a2 != null) {
            Iterator<String> it = a2.iterator();
            while (it.hasNext()) {
                String next = it.next();
                boolean equals = str.equals(next);
                ARLog.d("item = " + next + ", key = " + str + ", result = " + equals);
                if (equals) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void deleteARCache() {
        new Thread(new Runnable() { // from class: com.baidu.ar.util.ARFileUtils.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ARFileUtils.deleteDir(new File(ARFileUtils.getARCachePath()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).run();
    }

    public static boolean deleteDir(File file) {
        String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!deleteDir(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static String getARCacheLogPath() {
        String aRCachePath = getARCachePath();
        if (aRCachePath != null) {
            return aRCachePath + "/log";
        }
        return null;
    }

    public static String getARCachePath() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + ARCallback.AR_APP_NAME + "/.ARResource" + File.separator + getPackageName();
        }
        return null;
    }

    public static String getARCaseDirPath(String str) {
        String aRCachePath = getARCachePath();
        if (aRCachePath != null) {
            return aRCachePath + File.separator + "bar_" + str;
        }
        return null;
    }

    public static String getARCaseFullPath(String str) {
        String aRCaseDirPath = getARCaseDirPath(str);
        if (aRCaseDirPath != null) {
            return aRCaseDirPath + File.separator + AR_UNZIP_ROOT_DIR;
        }
        return null;
    }

    public static String getARCaseMainZipFullPath(String str, String str2) {
        String aRCaseTempDir = getARCaseTempDir(str);
        if (aRCaseTempDir != null) {
            return aRCaseTempDir + File.separator + "main_" + str2 + ".zip";
        }
        return null;
    }

    public static String getARCaseTempDir(String str) {
        String aRCaseDirPath = getARCaseDirPath(str);
        if (aRCaseDirPath != null) {
            return aRCaseDirPath + File.separator + "temp";
        }
        return null;
    }

    public static String getDefaultJsonPath(String str) {
        return str + "/" + AR_UNZIP_ROOT_DIR + "/res/default.json";
    }

    public static String getDumixResJsonPath(String str) {
        return str + "/" + AR_UNZIP_ROOT_DIR + "/dumix_res.json";
    }

    public static File getImageCacheDir() {
        String aRCachePath = getARCachePath();
        if (aRCachePath != null) {
            File file = new File(aRCachePath, "image_cache");
            FileUtils.ensureDir(file);
            return file;
        }
        return null;
    }

    public static String getPackageName() {
        return a;
    }

    public static String getResConfigJsonPath(String str) {
        return str + "/" + AR_UNZIP_ROOT_DIR + "/res_config.json";
    }

    public static String getTargetJsonPath(String str) {
        return str + "/" + AR_UNZIP_ROOT_DIR + "/targets.json";
    }

    public static String getVoiceFilePath(String str) {
        return getARCaseFullPath(str) + "/res/voice.json";
    }

    public static void hideARResourceFile(ContentResolver contentResolver) {
        boolean renameTo;
        String str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + ARCallback.AR_APP_NAME;
        File file = new File(str + "/ARResource");
        if (file.exists()) {
            File file2 = new File(str + "/.ARResource");
            if (file2.exists()) {
                renameTo = deleteDir(file);
                ARLog.i("hideARResourceFile deleteDir result = " + renameTo);
            } else {
                renameTo = file.renameTo(file2);
                ARLog.i("hideARResourceFile renameTo result = " + renameTo);
            }
            if (renameTo) {
                a(contentResolver, file.getPath());
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:100:0x0040 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:57:0x00bc */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:75:0x00e3 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:83:0x00f0 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:89:0x00f8 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d2 A[Catch: IOException -> 0x00db, TryCatch #22 {IOException -> 0x00db, blocks: (B:65:0x00cd, B:67:0x00d2, B:69:0x00d7), top: B:114:0x00cd }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d7 A[Catch: IOException -> 0x00db, TRY_LEAVE, TryCatch #22 {IOException -> 0x00db, blocks: (B:65:0x00cd, B:67:0x00d2, B:69:0x00d7), top: B:114:0x00cd }] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v16, types: [java.io.Writer, java.io.OutputStreamWriter] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.OutputStreamWriter] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.OutputStreamWriter] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.io.OutputStreamWriter] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void putKeyToFile(String str, String str2) {
        FileOutputStream fileOutputStream;
        BufferedWriter bufferedWriter;
        FileOutputStream fileOutputStream2;
        BufferedWriter bufferedWriter2 = null;
        bufferedWriter2 = null;
        bufferedWriter2 = null;
        bufferedWriter2 = null;
        bufferedWriter2 = null;
        bufferedWriter2 = null;
        r2 = null;
        bufferedWriter2 = null;
        bufferedWriter2 = null;
        bufferedWriter2 = null;
        OutputStreamWriter outputStreamWriter = null;
        bufferedWriter2 = null;
        bufferedWriter2 = null;
        bufferedWriter2 = null;
        File file = new File(getARCachePath());
        if (!file.exists()) {
            file.mkdirs();
        }
        String str3 = getARCachePath() + File.separator + str2;
        File file2 = new File(str3);
        OutputStreamWriter exists = file2.exists();
        if (!exists) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            if (checkKeyInFile(str, str2)) {
                return;
            }
            try {
                fileOutputStream = new FileOutputStream(str3, true);
                try {
                    exists = new OutputStreamWriter(fileOutputStream, "UTF-8");
                    try {
                        bufferedWriter = new BufferedWriter(exists);
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        bufferedWriter = null;
                        outputStreamWriter = exists;
                        fileOutputStream2 = fileOutputStream;
                    } catch (UnsupportedEncodingException e3) {
                        e = e3;
                    } catch (IOException e4) {
                        e = e4;
                    }
                } catch (FileNotFoundException e5) {
                    e = e5;
                    bufferedWriter = null;
                    fileOutputStream2 = fileOutputStream;
                } catch (UnsupportedEncodingException e6) {
                    e = e6;
                    exists = 0;
                } catch (IOException e7) {
                    e = e7;
                    exists = 0;
                } catch (Throwable th) {
                    th = th;
                    exists = 0;
                }
                try {
                    bufferedWriter.write(str);
                    bufferedWriter.newLine();
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    if (exists != 0) {
                        exists.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (FileNotFoundException e9) {
                    e = e9;
                    outputStreamWriter = exists;
                    fileOutputStream2 = fileOutputStream;
                    try {
                        e.printStackTrace();
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                                return;
                            }
                        }
                        if (outputStreamWriter != null) {
                            outputStreamWriter.close();
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        exists = outputStreamWriter;
                        bufferedWriter2 = bufferedWriter;
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (IOException e11) {
                                e11.printStackTrace();
                                throw th;
                            }
                        }
                        if (exists != 0) {
                            exists.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (UnsupportedEncodingException e12) {
                    e = e12;
                    bufferedWriter2 = bufferedWriter;
                    e.printStackTrace();
                    if (bufferedWriter2 != null) {
                        try {
                            bufferedWriter2.close();
                        } catch (IOException e13) {
                            e13.printStackTrace();
                        }
                    }
                    if (exists != 0) {
                        exists.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (IOException e14) {
                    e = e14;
                    bufferedWriter2 = bufferedWriter;
                    e.printStackTrace();
                    if (bufferedWriter2 != null) {
                        try {
                            bufferedWriter2.close();
                        } catch (IOException e15) {
                            e15.printStackTrace();
                        }
                    }
                    if (exists != 0) {
                        exists.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedWriter2 = bufferedWriter;
                    if (bufferedWriter2 != null) {
                    }
                    if (exists != 0) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (FileNotFoundException e16) {
                e = e16;
                bufferedWriter = null;
                fileOutputStream2 = null;
            } catch (UnsupportedEncodingException e17) {
                e = e17;
                exists = 0;
                fileOutputStream = null;
            } catch (IOException e18) {
                e = e18;
                exists = 0;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                exists = 0;
                fileOutputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public static boolean sdCardAvailable() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED >= 10;
        }
        return false;
    }

    public static void setPackageName(String str) {
        if (a == null) {
            a = str;
        }
    }
}
