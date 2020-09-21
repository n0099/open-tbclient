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
/* loaded from: classes3.dex */
class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    b() {
    }

    public static void e(long j, final String str) {
        long aS = aS(j);
        if (aS == -1) {
            if (DEBUG) {
                Log.e("LaunchTipsFileHelper", "get timestampByDay failed");
                return;
            }
            return;
        }
        final File aQ = aQ(aS);
        if (aQ != null && aQ.exists()) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.b.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (b.class) {
                        com.baidu.swan.c.d.saveToFile(str, aQ, true);
                    }
                    b.afJ();
                }
            }, "saveLaunchTipsLog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void afJ() {
        com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
        if (aAs != null && !TextUtils.isEmpty(aAs.getAppId())) {
            File file = new File(com.baidu.swan.apps.r.d.apk().getPath() + File.separator + "launch_tips");
            if (file.exists() && file.isDirectory()) {
                com.baidu.swan.c.d.deleteFile(file);
            }
        }
    }

    private static File aQ(long j) {
        long parseLong;
        File file = null;
        File[] afL = afL();
        if (afL == null || afL.length == 0) {
            return aR(j);
        }
        int length = afL.length;
        int i = 0;
        while (i < length) {
            File file2 = afL[i];
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
            return aR(j);
        }
        return file;
    }

    public static String afK() {
        File[] afL = afL();
        if (afL == null) {
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
        long aS = aS(System.currentTimeMillis());
        for (File file : afL) {
            try {
                long parseLong = Long.parseLong(file.getName());
                if (aS - parseLong >= Config.THREAD_IMAGE_SAVE_MAX_TIME) {
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

    private static File[] afL() {
        String afM = afM();
        if (afM == null) {
            return null;
        }
        File file = new File(afM);
        if (file.exists() && file.isDirectory()) {
            return file.listFiles();
        }
        return null;
    }

    private static File aR(long j) {
        String afM = afM();
        if (afM == null) {
            return null;
        }
        File file = new File(afM + File.separator + j);
        if (file.exists()) {
            com.baidu.swan.c.d.safeDeleteFile(file);
        }
        com.baidu.swan.c.d.createNewFileSafely(file);
        return file;
    }

    private static String afM() {
        com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
        if (aAs == null) {
            return null;
        }
        String appId = aAs.getAppId();
        if (TextUtils.isEmpty(appId)) {
            return null;
        }
        return com.baidu.swan.apps.r.d.apk().getPath() + File.separator + "launch_tips_v2" + File.separator + appId;
    }

    private static long aS(long j) {
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
