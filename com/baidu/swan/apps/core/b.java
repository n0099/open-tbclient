package com.baidu.swan.apps.core;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.data.Config;
import com.baidu.swan.apps.ao.p;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes9.dex */
class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    b() {
    }

    public static void i(long j, final String str) {
        long ce = ce(j);
        if (ce == -1) {
            if (DEBUG) {
                Log.e("LaunchTipsFileHelper", "get timestampByDay failed");
                return;
            }
            return;
        }
        final File cc = cc(ce);
        if (cc != null && cc.exists()) {
            p.a(new Runnable() { // from class: com.baidu.swan.apps.core.b.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (b.class) {
                        com.baidu.swan.c.d.saveToFile(str, cc, true);
                    }
                    b.anf();
                }
            }, "saveLaunchTipsLog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void anf() {
        com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
        if (aIL != null && !TextUtils.isEmpty(aIL.getAppId())) {
            File file = new File(com.baidu.swan.apps.r.d.awM().getPath() + File.separator + "launch_tips");
            if (file.exists() && file.isDirectory()) {
                com.baidu.swan.c.d.deleteFile(file);
            }
        }
    }

    private static File cc(long j) {
        long parseLong;
        File file = null;
        File[] anh = anh();
        if (anh == null || anh.length == 0) {
            return cd(j);
        }
        int length = anh.length;
        int i = 0;
        while (i < length) {
            File file2 = anh[i];
            try {
                parseLong = Long.parseLong(file2.getName());
            } catch (NumberFormatException e) {
                com.baidu.swan.c.d.deleteFile(file2);
            }
            if (parseLong == j) {
                i++;
                file = file2;
            } else {
                if (j - parseLong >= Config.THREAD_IMAGE_SAVE_MAX_TIME) {
                    com.baidu.swan.c.d.deleteFile(file2);
                }
                file2 = file;
                i++;
                file = file2;
            }
        }
        if (file == null) {
            return cd(j);
        }
        return file;
    }

    public static String ang() {
        File[] anh = anh();
        if (anh == null) {
            return null;
        }
        TreeMap treeMap = new TreeMap(new Comparator<Long>() { // from class: com.baidu.swan.apps.core.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Long l, Long l2) {
                return l2.compareTo(l);
            }
        });
        long ce = ce(System.currentTimeMillis());
        for (File file : anh) {
            try {
                long parseLong = Long.parseLong(file.getName());
                if (ce - parseLong >= Config.THREAD_IMAGE_SAVE_MAX_TIME) {
                    com.baidu.swan.c.d.deleteFile(file);
                } else {
                    List<String> K = com.baidu.swan.c.d.K(file);
                    if (K != null && K.size() > 0) {
                        treeMap.put(Long.valueOf(parseLong), K);
                    }
                }
            } catch (NumberFormatException e) {
                com.baidu.swan.c.d.deleteFile(file);
            }
        }
        if (treeMap.size() != 0) {
            StringBuilder sb = new StringBuilder("（二）历史日志\n");
            for (Map.Entry entry : treeMap.entrySet()) {
                sb.append("「").append(new SimpleDateFormat("yyyy-MM-dd").format(new Date(((Long) entry.getKey()).longValue()))).append("」\n");
                for (String str : (List) entry.getValue()) {
                    sb.append(str).append("\n");
                }
            }
            return sb.toString();
        }
        return null;
    }

    private static File[] anh() {
        String ani = ani();
        if (ani == null) {
            return null;
        }
        File file = new File(ani);
        if (file.exists() && file.isDirectory()) {
            return file.listFiles();
        }
        return null;
    }

    private static File cd(long j) {
        String ani = ani();
        if (ani == null) {
            return null;
        }
        File file = new File(ani + File.separator + j);
        if (file.exists()) {
            com.baidu.swan.c.d.safeDeleteFile(file);
        }
        com.baidu.swan.c.d.createNewFileSafely(file);
        return file;
    }

    private static String ani() {
        com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
        if (aIL == null) {
            return null;
        }
        String appId = aIL.getAppId();
        if (TextUtils.isEmpty(appId)) {
            return null;
        }
        return com.baidu.swan.apps.r.d.awM().getPath() + File.separator + "launch_tips_v2" + File.separator + appId;
    }

    private static long ce(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = simpleDateFormat.parse(simpleDateFormat.format(new Date(j)));
            if (parse == null) {
                return -1L;
            }
            return parse.getTime();
        } catch (ParseException e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
                return -1L;
            }
            return -1L;
        }
    }
}
