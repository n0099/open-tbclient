package com.baidu.cyberplayer.sdk.downloader;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.downloader.b;
import com.baidu.cyberplayer.sdk.o;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a implements b.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4833a = Boolean.toString(true);

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0072a f4834b;

    /* renamed from: c  reason: collision with root package name */
    public String f4835c;

    /* renamed from: d  reason: collision with root package name */
    public String f4836d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<String> f4837e = null;

    /* renamed from: com.baidu.cyberplayer.sdk.downloader.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0072a {
        void a(String str, long j);

        void a(String str, long j, int i2, String str2);

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
        String str = f4833a;
        File file2 = null;
        try {
            file = new File(this.f4836d, this.f4835c);
            try {
                try {
                    this.f4837e = o.a(file, this.f4836d);
                    CyberLog.d("CyberFileDownloader", "mUnzipFilesList:" + this.f4837e);
                } catch (Exception e2) {
                    e = e2;
                    this.f4837e = null;
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
        } catch (Exception e3) {
            e = e3;
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

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a0, code lost:
        r1 = "file not found:" + r4.getAbsolutePath();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, ArrayList<String> arrayList) {
        File file;
        String str2 = f4833a;
        if (arrayList != null) {
            int i2 = 0;
            while (true) {
                try {
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    String str3 = arrayList.get(i2);
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
                    i2++;
                } catch (Exception e2) {
                    return e2.toString();
                }
            }
        }
        return str2;
    }

    private String b() {
        String str = f4833a;
        try {
            if (this.f4837e != null) {
                CyberLog.d("CyberFileDownloader", "---step---checkUnzipFilesMd5----start");
                for (int i2 = 0; i2 < this.f4837e.size(); i2++) {
                    String str2 = this.f4837e.get(i2);
                    if (!TextUtils.isEmpty(str2) && str2.startsWith("md5_")) {
                        String substring = str2.substring(4, 36);
                        if (!o.a(substring, this.f4836d + File.separator + str2)) {
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
        this.f4834b.a(str, j);
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.b.a
    public void a(String str, long j, long j2) {
        this.f4834b.a(str, j, j2);
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.b.a
    public void a(String str, long j, String str2) {
        this.f4834b.a(str, j, -1, str2 + ",networkstatus:" + o.i() + ",url:" + str);
    }

    public void a(String str, String str2, String str3, InterfaceC0072a interfaceC0072a) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || interfaceC0072a == null) {
            return;
        }
        this.f4835c = str2;
        this.f4834b = interfaceC0072a;
        this.f4836d = str3;
        o.b(str3);
        CyberLog.d("CyberFileDownloader", " unzipFolder:" + this.f4836d);
        HashMap hashMap = new HashMap();
        hashMap.put("url", str + File.separator + this.f4835c);
        hashMap.put("file-folder", this.f4836d);
        hashMap.put("file-name", this.f4835c);
        hashMap.put("is-asyn", "0");
        b.a(hashMap, this);
    }

    @Override // com.baidu.cyberplayer.sdk.downloader.b.a
    public void b(String str, long j) {
        String a2 = a();
        if (!f4833a.equals(a2)) {
            o.a(this.f4836d, this.f4837e);
            this.f4834b.a(str, j, -2, a2);
            return;
        }
        String b2 = b();
        if (!f4833a.equals(b2)) {
            o.a(this.f4836d, this.f4837e);
            this.f4834b.a(str, j, -3, b2);
            return;
        }
        String a3 = a(this.f4836d, this.f4837e);
        if (f4833a.equals(a3)) {
            this.f4834b.a(str, j, this.f4837e);
            return;
        }
        o.a(this.f4836d, this.f4837e);
        this.f4834b.a(str, j, -6, a3);
    }
}
