package com.baidu.b.a.h;

import android.os.Build;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class c {
    private static c aaA = null;
    public String processor = "";
    public String features = "";

    public static c sd() {
        if (aaA != null) {
            return aaA;
        }
        c cVar = new c();
        try {
            FileReader fileReader = new FileReader("/proc/cpuinfo");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                String lowerCase = readLine.trim().toLowerCase();
                if (lowerCase.startsWith("processor") && lowerCase.indexOf(":", "processor".length()) != -1) {
                    if (cVar.processor.length() > 0) {
                        cVar.processor += "__";
                    }
                    cVar.processor += lowerCase.split(":")[1].trim();
                } else if (lowerCase.startsWith("features") && lowerCase.indexOf(":", "features".length()) != -1) {
                    if (cVar.features.length() > 0) {
                        cVar.features += "__";
                    }
                    cVar.features += lowerCase.split(":")[1].trim();
                }
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (fileReader != null) {
                fileReader.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (Build.CPU_ABI.equalsIgnoreCase(com.baidu.fsg.face.base.d.h.c)) {
            cVar.processor = com.baidu.fsg.face.base.d.h.c;
        }
        aaA = cVar;
        return cVar;
    }
}
