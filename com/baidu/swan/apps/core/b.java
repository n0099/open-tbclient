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
/* loaded from: classes8.dex */
class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    b() {
    }

    public static void e(long j, final String str) {
        long aR = aR(j);
        if (aR == -1) {
            if (DEBUG) {
                Log.e("LaunchTipsFileHelper", "get timestampByDay failed");
                return;
            }
            return;
        }
        final File aP = aP(aR);
        if (aP != null && aP.exists()) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.b.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (b.class) {
                        com.baidu.swan.c.d.saveToFile(str, aP, true);
                    }
                    b.aeZ();
                }
            }, "saveLaunchTipsLog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aeZ() {
        com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        if (azJ != null && !TextUtils.isEmpty(azJ.getAppId())) {
            File file = new File(com.baidu.swan.apps.r.d.aoz().getPath() + File.separator + "launch_tips");
            if (file.exists() && file.isDirectory()) {
                com.baidu.swan.c.d.deleteFile(file);
            }
        }
    }

    private static File aP(long j) {
        long parseLong;
        File file = null;
        File[] afb = afb();
        if (afb == null || afb.length == 0) {
            return aQ(j);
        }
        int length = afb.length;
        int i = 0;
        while (i < length) {
            File file2 = afb[i];
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
            return aQ(j);
        }
        return file;
    }

    public static String afa() {
        File[] afb = afb();
        if (afb == null) {
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
        long aR = aR(System.currentTimeMillis());
        for (File file : afb) {
            try {
                long parseLong = Long.parseLong(file.getName());
                if (aR - parseLong >= Config.THREAD_IMAGE_SAVE_MAX_TIME) {
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
                sb.append("「").append(new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date(((Long) entry.getKey()).longValue()))).append("」\n");
                for (String str : (List) entry.getValue()) {
                    sb.append(str).append("\n");
                }
            }
            return sb.toString();
        }
        return null;
    }

    private static File[] afb() {
        String afc = afc();
        if (afc == null) {
            return null;
        }
        File file = new File(afc);
        if (file.exists() && file.isDirectory()) {
            return file.listFiles();
        }
        return null;
    }

    private static File aQ(long j) {
        String afc = afc();
        if (afc == null) {
            return null;
        }
        File file = new File(afc + File.separator + j);
        if (file.exists()) {
            com.baidu.swan.c.d.safeDeleteFile(file);
        }
        com.baidu.swan.c.d.createNewFileSafely(file);
        return file;
    }

    private static String afc() {
        com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        if (azJ == null) {
            return null;
        }
        String appId = azJ.getAppId();
        if (TextUtils.isEmpty(appId)) {
            return null;
        }
        return com.baidu.swan.apps.r.d.aoz().getPath() + File.separator + "launch_tips_v2" + File.separator + appId;
    }

    private static long aR(long j) {
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
