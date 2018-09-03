package com.baidu.crabsdk.b;

import android.os.Process;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes2.dex */
public final class j {
    public static String z() {
        int myPid = Process.myPid();
        String str = (!com.baidu.crabsdk.a.i || myPid <= 0) ? null : Integer.toString(myPid) + "):";
        ArrayList arrayList = new ArrayList();
        arrayList.add("logcat");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(Arrays.asList("-t", String.valueOf(com.baidu.crabsdk.a.h), "-v", "time"));
        int indexOf = arrayList2.indexOf("-t");
        if (indexOf >= 0 && indexOf < arrayList2.size() && com.baidu.crabsdk.c.c.pg() < 8) {
            arrayList2.remove(indexOf + 1);
            arrayList2.remove(indexOf);
            arrayList2.add("-d");
        }
        com.baidu.crabsdk.c.b bVar = new com.baidu.crabsdk.c.b(com.baidu.crabsdk.a.h);
        arrayList.addAll(arrayList2);
        try {
            Process exec = Runtime.getRuntime().exec((String[]) arrayList.toArray(new String[arrayList.size()]));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 8192);
            new Thread(new k(exec)).start();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (str == null || readLine.contains(str)) {
                    bVar.add(readLine + "\n");
                }
            }
        } catch (IOException e) {
        }
        return bVar.toString();
    }
}
