package com.baidu.searchbox.aperf.bosuploader;

import android.util.Log;
import com.baidu.android.util.io.Closeables;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/* loaded from: classes2.dex */
public class FileUtil {
    public static final String TAG = "FileUtil";

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:10:0x0022 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.BufferedReader] */
    public static String readFromFileInputStream(FileInputStream fileInputStream) {
        IOException e;
        ?? r5;
        StringBuilder sb = new StringBuilder();
        FileInputStream fileInputStream2 = null;
        try {
            if (fileInputStream != null) {
                try {
                    r5 = new BufferedReader(new InputStreamReader(fileInputStream));
                    try {
                        for (String readLine = r5.readLine(); readLine != null; readLine = r5.readLine()) {
                            sb.append(readLine);
                        }
                        fileInputStream2 = r5;
                    } catch (IOException e2) {
                        e = e2;
                        Log.e(TAG, e.getMessage(), e);
                        Closeables.closeSafely((Closeable) r5);
                        return sb.toString();
                    }
                } catch (IOException e3) {
                    e = e3;
                    r5 = 0;
                } catch (Throwable th) {
                    th = th;
                    Closeables.closeSafely(fileInputStream2);
                    throw th;
                }
            }
            Closeables.closeSafely(fileInputStream2);
            return sb.toString();
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
        }
    }

    public static void writeDataToFile(File file, String str) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e) {
            e = e;
        }
        try {
            writeDataToFile(fileOutputStream, str);
            Closeables.closeSafely(fileOutputStream);
        } catch (FileNotFoundException e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            Log.e(TAG, e.getMessage(), e);
            Closeables.closeSafely(fileOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            Closeables.closeSafely(fileOutputStream2);
            throw th;
        }
    }

    public static void writeDataToFile(FileOutputStream fileOutputStream, String str) {
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            bufferedWriter.write(str);
            bufferedWriter.flush();
            Closeables.closeSafely(bufferedWriter);
        } catch (IOException e2) {
            e = e2;
            bufferedWriter2 = bufferedWriter;
            Log.e(TAG, e.getMessage(), e);
            Closeables.closeSafely(bufferedWriter2);
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            Closeables.closeSafely(bufferedWriter2);
            throw th;
        }
    }
}
