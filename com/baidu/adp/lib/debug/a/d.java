package com.baidu.adp.lib.debug.a;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public final class d extends a implements Runnable {
    private String a;

    public d(Context context) {
        this.a = null;
        this.a = context.getPackageName();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0091 -> B:5:0x001e). Please submit an issue!!! */
    public final String d() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("top -n 1").getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (readLine.contains(this.a) && !readLine.contains(String.valueOf(this.a) + ":remote") && !readLine.contains(String.valueOf(this.a) + ":debug")) {
                    String[] split = readLine.split("\\s+");
                    if (split[2].contains("%")) {
                        return split[2].trim();
                    }
                    for (int i = 0; i < split.length; i++) {
                        if (split[i].contains("%")) {
                            return split[i].trim();
                        }
                    }
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "null";
    }

    @Override // java.lang.Runnable
    public final void run() {
        super.b();
        while (true) {
            try {
                com.baidu.adp.lib.debug.c.b(d());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (!a()) {
                return;
            }
            Thread.sleep(500L);
        }
    }
}
