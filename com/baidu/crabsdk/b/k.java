package com.baidu.crabsdk.b;

import android.os.Build;
import android.os.Process;
import com.baidu.crabsdk.c.b;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class k {
    public static String a() {
        String str;
        String str2;
        int myPid = Process.myPid();
        if (!com.baidu.crabsdk.a.i || myPid <= 0) {
            str = null;
        } else {
            str = Integer.toString(myPid) + "):";
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("logcat");
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(Arrays.asList("-t", String.valueOf(com.baidu.crabsdk.a.f4677h), "-v", "time"));
        int indexOf = arrayList2.indexOf("-t");
        if (indexOf >= 0 && indexOf < arrayList2.size() && Build.VERSION.SDK_INT < 8) {
            arrayList2.remove(indexOf + 1);
            arrayList2.remove(indexOf);
            arrayList2.add("-d");
        }
        b bVar = new b(com.baidu.crabsdk.a.f4677h);
        arrayList.addAll(arrayList2);
        try {
            Process exec = Runtime.getRuntime().exec((String[]) arrayList.toArray(new String[arrayList.size()]));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 8192);
            new Thread(new d.b.m.b.b(exec)).start();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (str == null || readLine.contains(str)) {
                    bVar.add(readLine + "\n");
                }
            }
        } catch (IOException e2) {
            e = e2;
            str2 = "collectLogCat failed.";
            com.baidu.crabsdk.c.a.a(str2, e);
            return bVar.toString();
        } catch (Exception e3) {
            e = e3;
            str2 = "collectLogCat failed!";
            com.baidu.crabsdk.c.a.a(str2, e);
            return bVar.toString();
        } catch (OutOfMemoryError e4) {
            e = e4;
            str2 = "collectLogCat oom.";
            com.baidu.crabsdk.c.a.a(str2, e);
            return bVar.toString();
        }
        return bVar.toString();
    }
}
