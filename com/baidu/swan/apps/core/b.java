package com.baidu.swan.apps.core;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.data.Config;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import com.baidu.swan.apps.ap.p;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes10.dex */
class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    b() {
    }

    public static void f(long j, final String str) {
        long ba = ba(j);
        if (ba == -1) {
            if (DEBUG) {
                Log.e("LaunchTipsFileHelper", "get timestampByDay failed");
                return;
            }
            return;
        }
        final File aY = aY(ba);
        if (aY != null && aY.exists()) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.b.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (b.class) {
                        com.baidu.swan.c.d.saveToFile(str, aY, true);
                    }
                    b.aiu();
                }
            }, "saveLaunchTipsLog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aiu() {
        com.baidu.swan.apps.runtime.e aDb = com.baidu.swan.apps.runtime.e.aDb();
        if (aDb != null && !TextUtils.isEmpty(aDb.getAppId())) {
            File file = new File(com.baidu.swan.apps.r.d.arV().getPath() + File.separator + "launch_tips");
            if (file.exists() && file.isDirectory()) {
                com.baidu.swan.c.d.deleteFile(file);
            }
        }
    }

    private static File aY(long j) {
        long parseLong;
        File file = null;
        File[] aiw = aiw();
        if (aiw == null || aiw.length == 0) {
            return aZ(j);
        }
        int length = aiw.length;
        int i = 0;
        while (i < length) {
            File file2 = aiw[i];
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
            return aZ(j);
        }
        return file;
    }

    public static String aiv() {
        File[] aiw = aiw();
        if (aiw == null) {
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
        long ba = ba(System.currentTimeMillis());
        for (File file : aiw) {
            try {
                long parseLong = Long.parseLong(file.getName());
                if (ba - parseLong >= Config.THREAD_IMAGE_SAVE_MAX_TIME) {
                    com.baidu.swan.c.d.deleteFile(file);
                } else {
                    List<String> N = com.baidu.swan.c.d.N(file);
                    if (N != null && N.size() > 0) {
                        treeMap.put(Long.valueOf(parseLong), N);
                    }
                }
            } catch (NumberFormatException e) {
                com.baidu.swan.c.d.deleteFile(file);
            }
        }
        if (treeMap.size() != 0) {
            StringBuilder sb = new StringBuilder("（二）历史日志\n");
            for (Map.Entry entry : treeMap.entrySet()) {
                sb.append("「").append(new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date(((Long) entry.getKey()).longValue()))).append("」\n");
                for (String str : (List) entry.getValue()) {
                    sb.append(str).append("\n");
                }
            }
            return sb.toString();
        }
        return null;
    }

    private static File[] aiw() {
        String aix = aix();
        if (aix == null) {
            return null;
        }
        File file = new File(aix);
        if (file.exists() && file.isDirectory()) {
            return file.listFiles();
        }
        return null;
    }

    private static File aZ(long j) {
        String aix = aix();
        if (aix == null) {
            return null;
        }
        File file = new File(aix + File.separator + j);
        if (file.exists()) {
            com.baidu.swan.c.d.safeDeleteFile(file);
        }
        com.baidu.swan.c.d.createNewFileSafely(file);
        return file;
    }

    private static String aix() {
        com.baidu.swan.apps.runtime.e aDb = com.baidu.swan.apps.runtime.e.aDb();
        if (aDb == null) {
            return null;
        }
        String appId = aDb.getAppId();
        if (TextUtils.isEmpty(appId)) {
            return null;
        }
        return com.baidu.swan.apps.r.d.arV().getPath() + File.separator + "launch_tips_v2" + File.separator + appId;
    }

    private static long ba(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT);
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
