package com.baidu.cyberplayer.sdk.a;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.a.b;
import com.baidu.cyberplayer.sdk.m;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a implements b.a {
    private static final String a = Boolean.toString(true);
    private InterfaceC0082a b;
    private String c;
    private String d;
    private ArrayList<String> e = null;

    /* renamed from: com.baidu.cyberplayer.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0082a {
        void a(String str, long j);

        void a(String str, long j, int i, String str2);

        void a(String str, long j, long j2);

        void a(String str, long j, ArrayList<String> arrayList);
    }

    private String a() {
        File file;
        String str = a;
        try {
            file = new File(this.d, this.c);
            try {
                try {
                    this.e = m.a(file, this.d);
                    CyberLog.d("CyberFileDownloader", "mUnzipFilesList:" + this.e);
                    if (file != null && file.exists()) {
                        file.delete();
                    }
                } catch (Exception e) {
                    e = e;
                    this.e = null;
                    str = e.toString();
                    if (file != null && file.exists()) {
                        file.delete();
                    }
                    return str;
                }
            } catch (Throwable th) {
                th = th;
                if (file != null && file.exists()) {
                    file.delete();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            file = null;
        } catch (Throwable th2) {
            th = th2;
            file = null;
            if (file != null) {
                file.delete();
            }
            throw th;
        }
        return str;
    }

    public static String a(String str, String str2) {
        File[] listFiles;
        String str3 = "";
        for (File file : new File(str).listFiles()) {
            if (file.isFile() && file.getName().endsWith(".zip")) {
                String replace = file.getName().replace(".zip", "");
                if (replace.contains("cyber-media-dex")) {
                    str3 = replace.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)[2];
                }
                if (m.m()) {
                    try {
                        if (replace.startsWith("model_")) {
                            m.b(str2);
                            a(str2, m.a(file.getAbsoluteFile(), str2));
                        } else {
                            String str4 = str2 + File.separator + "libs";
                            m.b(str4);
                            a(str4, m.a(file.getAbsoluteFile(), str4));
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        CyberLog.d("CyberFileDownloader", "external core ver:" + str3);
        return str3;
    }

    private static String a(String str, ArrayList<String> arrayList) {
        File file;
        String str2 = a;
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                try {
                    String str3 = arrayList.get(i);
                    if (!TextUtils.isEmpty(str3)) {
                        File file2 = new File(str, str3);
                        if (file2.isDirectory()) {
                            continue;
                        } else {
                            String name = file2.getName();
                            String parent = file2.getParent();
                            if (!TextUtils.isEmpty(name) && name.startsWith("md5_") && name.length() > "md5_".length() + 32) {
                                if (!file2.exists()) {
                                    return "file not found:" + file2.getAbsolutePath();
                                }
                                if (!file2.renameTo(new File(parent, name.substring("md5_".length() + 32 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS.length())))) {
                                    return "rename fail";
                                }
                                CyberLog.d("CyberFileDownloader", "rename " + file2.getName() + "(" + file2.exists() + ") to " + file.getName() + "(" + file.exists() + ")");
                            }
                        }
                    }
                } catch (Exception e) {
                    return e.toString();
                }
            }
        }
        return str2;
    }

    private String b() {
        String str = a;
        try {
            if (this.e != null) {
                CyberLog.d("CyberFileDownloader", "---step---checkUnzipFilesMd5----start");
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.e.size()) {
                        break;
                    }
                    String str2 = this.e.get(i2);
                    if (!TextUtils.isEmpty(str2) && str2.startsWith("md5_") && !m.a(str2.substring("md5_".length(), "md5_".length() + 32), this.d + File.separator + str2)) {
                        CyberLog.d("CyberFileDownloader", "---step---checkUnzipFilesMd5----fail");
                        return "md5 check fail.";
                    }
                    i = i2 + 1;
                }
            }
            return str;
        } catch (Exception e) {
            CyberLog.d("CyberFileDownloader", "---step---checkUnzipFilesMd5----fail");
            return "md5 check fail.";
        }
    }

    @Override // com.baidu.cyberplayer.sdk.a.b.a
    public void a(String str, long j) {
        this.b.a(str, j);
    }

    @Override // com.baidu.cyberplayer.sdk.a.b.a
    public void a(String str, long j, long j2) {
        this.b.a(str, j, j2);
    }

    @Override // com.baidu.cyberplayer.sdk.a.b.a
    public void a(String str, long j, String str2) {
        this.b.a(str, j, -1, str2 + ",networkstatus:" + m.i() + ",url:" + str);
    }

    public void a(String str, String str2, String str3, InterfaceC0082a interfaceC0082a) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || interfaceC0082a == null) {
            return;
        }
        this.c = str2;
        this.b = interfaceC0082a;
        this.d = str3;
        m.b(this.d);
        CyberLog.d("CyberFileDownloader", " unzipFolder:" + this.d);
        HashMap hashMap = new HashMap();
        hashMap.put("url", str + File.separator + this.c);
        hashMap.put("file-folder", this.d);
        hashMap.put("file-name", this.c);
        hashMap.put("is-asyn", "0");
        b.a(hashMap, this);
    }

    @Override // com.baidu.cyberplayer.sdk.a.b.a
    public void b(String str, long j) {
        String a2 = a();
        if (!a.equals(a2)) {
            m.a(this.d, this.e);
            this.b.a(str, j, -2, a2);
            return;
        }
        String b = b();
        if (!a.equals(b)) {
            m.a(this.d, this.e);
            this.b.a(str, j, -3, b);
            return;
        }
        String a3 = a(this.d, this.e);
        if (a.equals(a3)) {
            this.b.a(str, j, this.e);
            return;
        }
        m.a(this.d, this.e);
        this.b.a(str, j, -6, a3);
    }
}
