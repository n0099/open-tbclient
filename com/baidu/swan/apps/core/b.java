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

    public static void h(long j, final String str) {
        long bY = bY(j);
        if (bY == -1) {
            if (DEBUG) {
                Log.e("LaunchTipsFileHelper", "get timestampByDay failed");
                return;
            }
            return;
        }
        final File bW = bW(bY);
        if (bW != null && bW.exists()) {
            p.a(new Runnable() { // from class: com.baidu.swan.apps.core.b.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (b.class) {
                        com.baidu.swan.c.d.saveToFile(str, bW, true);
                    }
                    b.aqB();
                }
            }, "saveLaunchTipsLog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aqB() {
        com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
        if (aMl != null && !TextUtils.isEmpty(aMl.getAppId())) {
            File file = new File(com.baidu.swan.apps.r.d.aAh().getPath() + File.separator + "launch_tips");
            if (file.exists() && file.isDirectory()) {
                com.baidu.swan.c.d.deleteFile(file);
            }
        }
    }

    private static File bW(long j) {
        long parseLong;
        File file = null;
        File[] aqD = aqD();
        if (aqD == null || aqD.length == 0) {
            return bX(j);
        }
        int length = aqD.length;
        int i = 0;
        while (i < length) {
            File file2 = aqD[i];
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
            return bX(j);
        }
        return file;
    }

    public static String aqC() {
        File[] aqD = aqD();
        if (aqD == null) {
            return null;
        }
        TreeMap treeMap = new TreeMap(new Comparator<Long>() { // from class: com.baidu.swan.apps.core.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: b */
            public int compare(Long l, Long l2) {
                return l2.compareTo(l);
            }
        });
        long bY = bY(System.currentTimeMillis());
        for (File file : aqD) {
            try {
                long parseLong = Long.parseLong(file.getName());
                if (bY - parseLong >= Config.THREAD_IMAGE_SAVE_MAX_TIME) {
                    com.baidu.swan.c.d.deleteFile(file);
                } else {
                    List<String> P = com.baidu.swan.c.d.P(file);
                    if (P != null && P.size() > 0) {
                        treeMap.put(Long.valueOf(parseLong), P);
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

    private static File[] aqD() {
        String aqE = aqE();
        if (aqE == null) {
            return null;
        }
        File file = new File(aqE);
        if (file.exists() && file.isDirectory()) {
            return file.listFiles();
        }
        return null;
    }

    private static File bX(long j) {
        String aqE = aqE();
        if (aqE == null) {
            return null;
        }
        File file = new File(aqE + File.separator + j);
        if (file.exists()) {
            com.baidu.swan.c.d.safeDeleteFile(file);
        }
        com.baidu.swan.c.d.createNewFileSafely(file);
        return file;
    }

    private static String aqE() {
        com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
        if (aMl == null) {
            return null;
        }
        String appId = aMl.getAppId();
        if (TextUtils.isEmpty(appId)) {
            return null;
        }
        return com.baidu.swan.apps.r.d.aAh().getPath() + File.separator + "launch_tips_v2" + File.separator + appId;
    }

    private static long bY(long j) {
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
