package com.baidu.searchbox.aperf.bosuploader;

import android.util.Log;
import com.baidu.android.util.io.Closeables;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/* loaded from: classes5.dex */
public class FileUtil {
    private static final String TAG = FileUtil.class.getSimpleName();

    public static void writeDataToFile(File file, String str) {
        FileOutputStream fileOutputStream;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    writeDataToFile(fileOutputStream, str);
                    Closeables.closeSafely(fileOutputStream);
                } catch (FileNotFoundException e) {
                    e = e;
                    Log.e(TAG, e.getMessage(), e);
                    Closeables.closeSafely(fileOutputStream);
                }
            } catch (Throwable th) {
                th = th;
                Closeables.closeSafely(fileOutputStream);
                throw th;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            Closeables.closeSafely(fileOutputStream);
            throw th;
        }
    }

    public static void writeDataToFile(FileOutputStream fileOutputStream, String str) {
        BufferedWriter bufferedWriter;
        try {
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
                try {
                    bufferedWriter.write(str);
                    bufferedWriter.flush();
                    Closeables.closeSafely(bufferedWriter);
                } catch (IOException e) {
                    e = e;
                    Log.e(TAG, e.getMessage(), e);
                    Closeables.closeSafely(bufferedWriter);
                }
            } catch (Throwable th) {
                th = th;
                Closeables.closeSafely(bufferedWriter);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            bufferedWriter = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter = null;
            Closeables.closeSafely(bufferedWriter);
            throw th;
        }
    }

    public static String readFromFileInputStream(FileInputStream fileInputStream) {
        Throwable th;
        BufferedReader bufferedReader;
        IOException iOException;
        BufferedReader bufferedReader2;
        StringBuilder sb = new StringBuilder();
        if (fileInputStream == null) {
            bufferedReader2 = null;
        } else {
            try {
                bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream));
                try {
                    for (String readLine = bufferedReader2.readLine(); readLine != null; readLine = bufferedReader2.readLine()) {
                        sb.append(readLine);
                    }
                } catch (IOException e) {
                    iOException = e;
                    bufferedReader = bufferedReader2;
                    try {
                        Log.e(TAG, iOException.getMessage(), iOException);
                        Closeables.closeSafely(bufferedReader);
                        return sb.toString();
                    } catch (Throwable th2) {
                        th = th2;
                        Closeables.closeSafely(bufferedReader);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = bufferedReader2;
                    Closeables.closeSafely(bufferedReader);
                    throw th;
                }
            } catch (IOException e2) {
                iOException = e2;
                bufferedReader = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        }
        Closeables.closeSafely(bufferedReader2);
        return sb.toString();
    }
}
