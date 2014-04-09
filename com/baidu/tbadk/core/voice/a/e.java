package com.baidu.tbadk.core.voice.a;

import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.switchs.features.VoiceSwitchStatic;
import java.io.File;
/* loaded from: classes.dex */
public final class e {
    public static boolean a(String str, String str2) {
        return w.g(str, w.a(str2, 1, true));
    }

    public static synchronized void a() {
        synchronized (e.class) {
            File file = new File(String.valueOf(w.d()) + VoiceSwitchStatic.VOICE);
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }
    }
}
