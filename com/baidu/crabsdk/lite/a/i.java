package com.baidu.crabsdk.lite.a;

import android.os.Process;
import com.baidu.crabsdk.lite.b.b;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes2.dex */
public final class i {
    public static String a(String str) {
        String str2;
        int myPid = Process.myPid();
        if (!com.baidu.crabsdk.lite.a.f4718e || myPid <= 0) {
            str2 = null;
        } else {
            str2 = Integer.toString(myPid) + "):";
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("logcat");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(Arrays.asList("-t", String.valueOf(com.baidu.crabsdk.lite.a.f4717d), "-v", "time"));
        int indexOf = arrayList2.indexOf("-t");
        if (indexOf >= 0 && indexOf < arrayList2.size() && com.baidu.crabsdk.lite.b.c.g() < 8) {
            arrayList2.remove(indexOf + 1);
            arrayList2.remove(indexOf);
            arrayList2.add("-d");
        }
        b bVar = new b(com.baidu.crabsdk.lite.a.f4717d);
        arrayList.addAll(arrayList2);
        try {
            Process exec = Runtime.getRuntime().exec((String[]) arrayList.toArray(new String[arrayList.size()]));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 8192);
            new Thread(new d.b.n.c.a.b(exec, str)).start();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (str2 == null || readLine.contains(str2)) {
                    bVar.add(readLine + "\n");
                }
            }
        } catch (IOException e2) {
            com.baidu.crabsdk.lite.b.a.e(str, "collectLogCat failed.", e2);
        }
        return bVar.toString();
    }
}
