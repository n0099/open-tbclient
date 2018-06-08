package com.baidu.android.pushservice.k;

import com.baidu.ar.util.IoUtils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.io.FileWriter */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<String> a(String str, File file) {
        InputStreamReader inputStreamReader;
        FileWriter fileWriter = 0;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            try {
                Process exec = Runtime.getRuntime().exec(str);
                inputStreamReader = new InputStreamReader(exec.getInputStream(), IoUtils.UTF_8);
                try {
                    LineNumberReader lineNumberReader = new LineNumberReader(inputStreamReader);
                    if (file != null) {
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        FileWriter fileWriter2 = new FileWriter(file, true);
                        fileWriter2.append((CharSequence) ("\n\n\n---------------   CMD : " + str + "   ---------------\n\n\n"));
                        fileWriter = fileWriter2;
                    }
                    while (true) {
                        String readLine = lineNumberReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        arrayList.add(readLine);
                        if (fileWriter != 0) {
                            fileWriter.append((CharSequence) (readLine + "\n"));
                        }
                    }
                    if (fileWriter != 0) {
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
                if (0 != 0) {
                    try {
                        fileWriter.close();
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
            if (0 != 0) {
            }
            throw th;
        }
        return arrayList;
    }
}
