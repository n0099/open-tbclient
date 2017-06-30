package com.baidu.android.pushservice.k;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class c {
    /* JADX WARN: Removed duplicated region for block: B:47:0x009b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<String> a(String str, File file) {
        InputStreamReader inputStreamReader;
        FileWriter fileWriter = null;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Process exec = Runtime.getRuntime().exec(str);
            inputStreamReader = new InputStreamReader(exec.getInputStream(), "utf-8");
            try {
                try {
                    LineNumberReader lineNumberReader = new LineNumberReader(inputStreamReader);
                    if (file != null) {
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        fileWriter = new FileWriter(file, true);
                        fileWriter.append((CharSequence) ("\n\n\n---------------   CMD : " + str + "   ---------------\n\n\n"));
                    }
                    while (true) {
                        String readLine = lineNumberReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        arrayList.add(readLine);
                        if (fileWriter != null) {
                            fileWriter.append((CharSequence) (readLine + "\n"));
                        }
                    }
                    if (fileWriter != null) {
                        fileWriter.flush();
                        fileWriter.close();
                    }
                    exec.waitFor();
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    arrayList.add("no su");
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return arrayList;
                }
            } catch (Throwable th) {
                th = th;
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            inputStreamReader = null;
        } catch (Throwable th2) {
            th = th2;
            inputStreamReader = null;
            if (inputStreamReader != null) {
            }
            throw th;
        }
        return arrayList;
    }
}
