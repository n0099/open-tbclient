package com.baidu.media.duplayer;

import com.baidu.cyberplayer.sdk.SDKVersion;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class b {
    private static final Set<String> a = new LinkedHashSet();
    private static final Set<String> b = new LinkedHashSet();
    private static final Set<String> c = new LinkedHashSet();
    private static final Set<String> d = new LinkedHashSet();
    private static final Map<String, String> e = new HashMap();
    private static final Map<String, String> f = new HashMap();

    static {
        a.add("cyber-ffmpeg");
        a.add("cyber-sdl");
        a.add("cyber-player");
        b.addAll(a);
        b.add("cyber-pcdn");
        c.addAll(a);
        c.add("cyber-ffmpeg-extend");
        d.addAll(a);
        d.add("cyber-ffmpeg-extend");
        d.add("cyber-pcdn");
        e.put("cyber-player", SDKVersion.VERSION);
        e.put("cyber-sdl", SDKVersion.VERSION);
        e.put("cyber-ffmpeg", "3.3.2.4");
        e.put("cyber-ffmpeg-extend", "3.3.2.2");
        e.put("cyber-pcdn", "2.0.1.319");
        f.putAll(e);
    }

    public static String a(String str) {
        return CyberCfgManager.getInstance().getPrefStr(str, "");
    }

    public static void a() {
        for (Map.Entry<String, String> entry : e.entrySet()) {
            CyberCfgManager.getInstance().setPrefStr(entry.getKey(), entry.getValue());
        }
    }

    public static String b(String str) {
        return f.get(str);
    }

    public static Set<String> di(int i) {
        switch (i) {
            case 1:
                return a;
            case 2:
            case 4:
            default:
                return d;
            case 3:
                return b;
            case 5:
                return c;
        }
    }
}
