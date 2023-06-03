package com.baidu.cyberplayer.sdk.utils;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.q;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a {
    public static final int a = 37;

    /* loaded from: classes3.dex */
    public static class b extends Exception {
        public b(String str) {
            super(str);
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends Exception {
        public c(String str) {
            super(str);
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends Exception {
        public d(String str) {
            super(str);
        }
    }

    /* renamed from: com.baidu.cyberplayer.sdk.utils.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0102a {
        public String a;
        public String b;

        public static C0102a a(String str) {
            if (b(str)) {
                C0102a c0102a = new C0102a();
                c0102a.a = str.substring(a.a);
                c0102a.b = str.substring(4, 36);
                return c0102a;
            }
            return null;
        }

        public static boolean b(String str) {
            if (!TextUtils.isEmpty(str) && str.startsWith("md5_") && str.length() > a.a) {
                return true;
            }
            return false;
        }
    }

    public static String a(String str, String str2, String str3) throws Exception {
        String str4;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            if (q.j()) {
                CyberLog.d("CyberFileUtils", "downloadServer:" + str);
                CyberLog.d("CyberFileUtils", "fileName:" + str2);
                CyberLog.d("CyberFileUtils", "saveDirectory:" + str3);
                q.b(str3);
                HashMap hashMap = new HashMap();
                if (!str.equals("https://pms-zeus-xcdn.bdstatic.com/searchbox/androidvideo")) {
                    str4 = "";
                } else {
                    str4 = com.baidu.cyberplayer.sdk.downloader.b.a("", "cdn_type=1");
                }
                String cfgValue = CyberCfgManager.getInstance().getCfgValue("download_zip_sid", "");
                if (!TextUtils.isEmpty(cfgValue)) {
                    str4 = com.baidu.cyberplayer.sdk.downloader.b.a(str4, "abtest=" + cfgValue);
                }
                if (!TextUtils.isEmpty(str4)) {
                    hashMap.put("query", str4);
                }
                String str5 = str3 + File.separator + str2;
                try {
                    CyberLog.d("CyberFileUtils", "FileSize:" + com.baidu.cyberplayer.sdk.downloader.b.b(str + File.separator + str2 + str4, str5));
                    CyberLog.d("CyberFileUtils", "FilePath:" + str5);
                    return str5;
                } catch (Exception e) {
                    CyberLog.d("CyberFileUtils", "download fail, delete:" + str5);
                    q.a(str5);
                    throw new b(e.getMessage());
                }
            }
            throw new b("Disconnect");
        }
        throw new b("argument is null");
    }

    public static ArrayList<String> a(File file, String str) throws Exception {
        c cVar;
        ArrayList arrayList = new ArrayList();
        try {
            CyberLog.d("CyberFileUtils", ZeusPerformanceTiming.KEY_UNZIP + file + " to " + str);
            ArrayList<String> a2 = com.baidu.cyberplayer.sdk.utils.d.a(file, str);
            StringBuilder sb = new StringBuilder();
            sb.append("unzip FileList:");
            sb.append(a2);
            CyberLog.d("CyberFileUtils", sb.toString());
            if (a2 == null) {
                return null;
            }
            int i = 0;
            while (true) {
                if (i < a2.size()) {
                    String str2 = a2.get(i);
                    File file2 = new File(str2);
                    if (file2.isDirectory()) {
                        arrayList.add(str2);
                    } else {
                        C0102a a3 = C0102a.a(file2.getName());
                        if (a3 == null) {
                            continue;
                        } else if (!q.a(a3.b, str2)) {
                            CyberLog.d("CyberFileUtils", "---step---checkUnzipFilesMd5----fail");
                            cVar = new c(str2 + " md5 is not " + a3.b);
                            break;
                        } else {
                            File file3 = new File(file2.getParent(), a3.a);
                            boolean renameTo = file2.renameTo(file3);
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(file2.getName());
                            sb2.append("(" + file2.exists() + SmallTailInfo.EMOTION_SUFFIX);
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(" to ");
                            sb3.append(file3.getName());
                            sb2.append(sb3.toString());
                            sb2.append("(" + file3.exists() + SmallTailInfo.EMOTION_SUFFIX);
                            CyberLog.d("CyberFileUtils", sb2.toString());
                            if (renameTo) {
                                CyberLog.d("CyberFileUtils", "rename success:" + ((Object) sb2));
                            } else {
                                CyberLog.d("CyberFileUtils", "rename failed:" + ((Object) sb2));
                            }
                        }
                    }
                    i++;
                } else {
                    cVar = null;
                    break;
                }
            }
            if (cVar == null) {
                return null;
            }
            throw cVar;
        } catch (Exception e) {
            throw new d(e.toString());
        }
    }

    public static ArrayList<String> a(String str, String str2) throws Exception {
        File file = new File(str);
        ArrayList<String> arrayList = null;
        try {
            CyberLog.d("CyberFileUtils", "unzip " + file + " to " + str2);
            arrayList = com.baidu.cyberplayer.sdk.utils.d.a(file, str2);
            q.a(str);
            CyberLog.d("CyberFileUtils", "unzip FileList:" + arrayList);
            return arrayList;
        } catch (Exception e) {
            if (arrayList != null) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    CyberLog.d("CyberFileUtils", "unzip fail, delete:" + str);
                    q.a(it.next());
                }
                arrayList.clear();
            }
            throw new d(e.toString());
        }
    }

    public static String b(String str, String str2) {
        File[] listFiles;
        String str3 = "";
        for (File file : new File(str).listFiles()) {
            if (file.isFile() && file.getName().endsWith(".zip")) {
                String replace = file.getName().replace(".zip", "");
                if (replace.contains("cyber-media-dex")) {
                    str3 = replace.split("_")[2];
                }
                if (q.o()) {
                    try {
                        if (replace.startsWith("model_")) {
                            q.b(str2);
                            a(file, str2);
                        } else {
                            String str4 = str2 + File.separator + "libs";
                            q.b(str4);
                            a(file, str4);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        CyberLog.d("CyberFileUtils", "external core ver:" + str3);
        return str3;
    }

    public static ArrayList<String> b(String str, String str2, String str3) throws Exception {
        C0102a a2;
        String a3 = a(str, str2, str3);
        ArrayList<String> a4 = a(a3, str3);
        for (int i = 0; i < a4.size(); i++) {
            String str4 = a4.get(i);
            File file = new File(str4);
            if (!file.isDirectory() && (a2 = C0102a.a(file.getName())) != null && !q.a(a2.b, str4)) {
                String str5 = str4 + " md5 verification failed " + a2.b;
                CyberLog.d("CyberFileUtils", str5);
                if (a4 != null) {
                    Iterator<String> it = a4.iterator();
                    while (it.hasNext()) {
                        CyberLog.d("CyberFileUtils", "md5 verification fail, delete:" + a3);
                        q.a(it.next());
                    }
                }
                a4.clear();
                throw new c(str5);
            }
        }
        return a4;
    }
}
