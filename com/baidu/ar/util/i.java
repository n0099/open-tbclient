package com.baidu.ar.util;

import android.content.ContentResolver;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
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
public final class i {
    private static String a = null;

    public static String a() {
        return a;
    }

    public static String a(int i) {
        String b = b();
        if (b != null) {
            switch (i) {
                case 0:
                    return b + Constants.AR_RESOURCE_CACHE_DIR_TRACK;
                case 1:
                    return null;
                case 2:
                    return b + Constants.AR_RESOURCE_CACHE_DIR_TRACK;
                case 3:
                    return b + Constants.AR_RESOURCE_CACHE_DIR_UDT;
                case 4:
                default:
                    return b + Constants.AR_RESOURCE_CACHE_DIR_NORMAL;
                case 5:
                    return b + Constants.AR_RESOURCE_CACHE_DIR_SLAM;
            }
        }
        return null;
    }

    public static String a(String str, int i) {
        String b = b();
        String str2 = null;
        if (b != null) {
            switch (i) {
                case 0:
                    str2 = b + Constants.AR_RESOURCE_CACHE_DIR_TRACK;
                    break;
                case 1:
                default:
                    str2 = b + Constants.AR_RESOURCE_CACHE_DIR_NORMAL;
                    break;
                case 2:
                    str2 = b + Constants.AR_RESOURCE_CACHE_DIR_TRACK;
                    break;
                case 3:
                    str2 = b + Constants.AR_RESOURCE_CACHE_DIR_UDT;
                    break;
                case 4:
                    str2 = b + Constants.AR_RESOURCE_CACHE_DIR_NPC;
                    break;
            }
        }
        return !TextUtils.isEmpty(str) ? str2 + File.separator + str : str2;
    }

    public static void a(ContentResolver contentResolver) {
        boolean renameTo;
        String str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + Constants.AR_APP_NAME;
        File file = new File(str + Constants.AR_RESOURCE_CACHE_DIR);
        if (file.exists()) {
            File file2 = new File(str + Constants.AR_RESOURCE_CACHE_DIR_HIDE);
            if (file2.exists()) {
                renameTo = a(file);
                b.b("hideARResourceFile deleteDir result = " + renameTo);
            } else {
                renameTo = file.renameTo(file2);
                b.b("hideARResourceFile renameTo result = " + renameTo);
            }
            if (renameTo) {
                a(contentResolver, file.getPath());
            }
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

    public static void a(String str) {
        if (a == null) {
            a = str;
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
    public static void a(String str, String str2) {
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
        File file = new File(b());
        if (!file.exists()) {
            file.mkdirs();
        }
        String str3 = b() + File.separator + str2;
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
            if (b(str, str2)) {
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

    public static boolean a(File file) {
        String[] list;
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                if (!a(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static String b() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + Constants.AR_APP_NAME + Constants.AR_RESOURCE_CACHE_DIR_HIDE + File.separator + a();
        }
        return null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:59:0x00b8 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v8 */
    private static HashSet<String> b(String str) {
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
                b.a("keysSet size is " + hashSet.size());
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

    public static boolean b(String str, String str2) {
        HashSet<String> b = b(b() + File.separator + str2);
        if (b != null) {
            Iterator<String> it = b.iterator();
            while (it.hasNext()) {
                String next = it.next();
                boolean equals = str.equals(next);
                b.a("item = " + next + ", key = " + str + ", result = " + equals);
                if (equals) {
                    return true;
                }
            }
        }
        return false;
    }
}
