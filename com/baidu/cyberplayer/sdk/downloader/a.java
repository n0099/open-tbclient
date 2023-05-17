package com.baidu.cyberplayer.sdk.downloader;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.downloader.b;
import com.baidu.cyberplayer.sdk.o;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a implements b.a {
    public static final String a = Boolean.toString(true);
    public InterfaceC0092a b;
    public String c;
    public String d;
    public ArrayList<String> e = null;

    /* renamed from: com.baidu.cyberplayer.sdk.downloader.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0092a {
        void a(String str, long j);

        void a(String str, long j, int i, String str2);

        void a(String str, long j, long j2);

        void a(String str, long j, ArrayList<String> arrayList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0048, code lost:
        if (r2.exists() != false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0030, code lost:
        if (r2.exists() != false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0032, code lost:
        r2.delete();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a() {
        File file;
        String str = a;
        File file2 = null;
        try {
            file = new File(this.d, this.c);
            try {
                try {
                    this.e = o.a(file, this.d);
                    CyberLog.d("CyberFileDownloader", "mUnzipFilesList:" + this.e);
                } catch (Exception e) {
                    e = e;
                    this.e = null;
                    str = e.toString();
                    if (file != null) {
                    }
                    return str;
                }
            } catch (Throwable th) {
                th = th;
                file2 = file;
                if (file2 != null && file2.exists()) {
                    file2.delete();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            file = null;
        } catch (Throwable th2) {
            th = th2;
            if (file2 != null) {
                file2.delete();
            }
            throw th;
        }
    }

    public static String a(String str, String str2) {
        File[] listFiles;
        String str3 = "";
        for (File file : new File(str).listFiles()) {
            if (file.isFile() && file.getName().endsWith(".zip")) {
                String replace = file.getName().replace(".zip", "");
                if (replace.contains("cyber-media-dex")) {
                    str3 = replace.split("_")[2];
                }
                if (o.m()) {
                    try {
                        if (replace.startsWith("model_")) {
                            o.b(str2);
                            a(str2, o.a(file.getAbsoluteFile(), str2));
                        } else {
                            String str4 = str2 + File.separator + "libs";
                            o.b(str4);
                            a(str4, o.a(file.getAbsoluteFile(), str4));
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        CyberLog.d("CyberFileDownloader", "external core ver:" + str3);
        return str3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a2, code lost:
        r1 = "file not found:" + r4.getAbsolutePath();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, ArrayList<String> arrayList) {
        File file;
        String str2 = a;
        if (arrayList != null) {
            int i = 0;
            while (true) {
                try {
                    if (i >= arrayList.size()) {
                        break;
                    }
                    String str3 = arrayList.get(i);
                    if (!TextUtils.isEmpty(str3)) {
                        File file2 = new File(str, str3);
                        if (!file2.isDirectory()) {
                            String name = file2.getName();
                            String parent = file2.getParent();
                            if (!TextUtils.isEmpty(name) && name.startsWith("md5_") && name.length() > 36) {
                                if (!file2.exists()) {
                                    break;
                                }
                                if (!file2.renameTo(new File(parent, name.substring(37)))) {
                                    str2 = "rename fail";
                                    break;
                                }
                                CyberLog.d("CyberFileDownloader", "rename " + file2.getName() + "(" + file2.exists() + ") to " + file.getName() + "(" + file.exists() + SmallTailInfo.EMOTION_SUFFIX);
                            }
                        }
                    }
                    i++;
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
                for (int i = 0; i < this.e.size(); i++) {
                    String str2 = this.e.get(i);
                    if (!TextUtils.isEmpty(str2) && str2.startsWith("md5_")) {
                        String substring = str2.substring(4, 36);
                        if (!o.a(substring, this.d + File.separator + str2)) {
                            CyberLog.d("CyberFileDownloader", "---step---checkUnzipFilesMd5----fail");
                            return "md5 check fail.";
                        }
                    }
                }
            }
            return str;
        } catch (Exception unused) {
            CyberLog.d("CyberFileDownloader", "---step---checkUnzipFilesMd5----fail");
            return "md5 check fail.";
        }
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.b.a
    public void a(String str, long j) {
        this.b.a(str, j);
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.b.a
    public void a(String str, long j, long j2) {
        this.b.a(str, j, j2);
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.b.a
    public void a(String str, long j, String str2) {
        this.b.a(str, j, -1, str2 + ",networkstatus:" + o.i() + ",url:" + str);
    }

    public void a(String str, String str2, String str3, InterfaceC0092a interfaceC0092a) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || interfaceC0092a == null) {
            return;
        }
        this.c = str2;
        this.b = interfaceC0092a;
        this.d = str3;
        o.b(str3);
        CyberLog.d("CyberFileDownloader", " unzipFolder:" + this.d);
        HashMap hashMap = new HashMap();
        hashMap.put("url", str + File.separator + this.c);
        hashMap.put("file-folder", this.d);
        hashMap.put("file-name", this.c);
        hashMap.put("is-asyn", "0");
        b.a(hashMap, this);
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.b.a
    public void b(String str, long j) {
        String a2 = a();
        if (!a.equals(a2)) {
            o.a(this.d, this.e);
            this.b.a(str, j, -2, a2);
            return;
        }
        String b = b();
        if (!a.equals(b)) {
            o.a(this.d, this.e);
            this.b.a(str, j, -3, b);
            return;
        }
        String a3 = a(this.d, this.e);
        if (a.equals(a3)) {
            this.b.a(str, j, this.e);
            return;
        }
        o.a(this.d, this.e);
        this.b.a(str, j, -6, a3);
    }
}
