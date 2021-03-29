package com.baidu.cyberplayer.sdk.a;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.a.b;
import com.baidu.cyberplayer.sdk.n;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a implements b.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4848a = Boolean.toString(true);

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0071a f4849b;

    /* renamed from: c  reason: collision with root package name */
    public String f4850c;

    /* renamed from: d  reason: collision with root package name */
    public String f4851d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<String> f4852e = null;

    /* renamed from: com.baidu.cyberplayer.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0071a {
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
        String str = f4848a;
        File file2 = null;
        try {
            file = new File(this.f4851d, this.f4850c);
            try {
                try {
                    this.f4852e = n.a(file, this.f4851d);
                    CyberLog.d("CyberFileDownloader", "mUnzipFilesList:" + this.f4852e);
                } catch (Exception e2) {
                    e = e2;
                    this.f4852e = null;
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
                if (n.m()) {
                    try {
                        if (replace.startsWith("model_")) {
                            n.b(str2);
                            a(str2, n.a(file.getAbsoluteFile(), str2));
                        } else {
                            String str4 = str2 + File.separator + "libs";
                            n.b(str4);
                            a(str4, n.a(file.getAbsoluteFile(), str4));
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
        String str2 = f4848a;
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
                } catch (Exception e2) {
                    return e2.toString();
                }
            }
        }
        return str2;
    }

    private String b() {
        String str = f4848a;
        try {
            if (this.f4852e != null) {
                CyberLog.d("CyberFileDownloader", "---step---checkUnzipFilesMd5----start");
                for (int i = 0; i < this.f4852e.size(); i++) {
                    String str2 = this.f4852e.get(i);
                    if (!TextUtils.isEmpty(str2) && str2.startsWith("md5_")) {
                        String substring = str2.substring(4, 36);
                        if (!n.a(substring, this.f4851d + File.separator + str2)) {
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

    @Override // com.baidu.cyberplayer.sdk.a.b.a
    public void a(String str, long j) {
        this.f4849b.a(str, j);
    }

    @Override // com.baidu.cyberplayer.sdk.a.b.a
    public void a(String str, long j, long j2) {
        this.f4849b.a(str, j, j2);
    }

    @Override // com.baidu.cyberplayer.sdk.a.b.a
    public void a(String str, long j, String str2) {
        this.f4849b.a(str, j, -1, str2 + ",networkstatus:" + n.i() + ",url:" + str);
    }

    public void a(String str, String str2, String str3, InterfaceC0071a interfaceC0071a) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || interfaceC0071a == null) {
            return;
        }
        this.f4850c = str2;
        this.f4849b = interfaceC0071a;
        this.f4851d = str3;
        n.b(str3);
        CyberLog.d("CyberFileDownloader", " unzipFolder:" + this.f4851d);
        HashMap hashMap = new HashMap();
        hashMap.put("url", str + File.separator + this.f4850c);
        hashMap.put("file-folder", this.f4851d);
        hashMap.put("file-name", this.f4850c);
        hashMap.put("is-asyn", "0");
        b.a(hashMap, this);
    }

    @Override // com.baidu.cyberplayer.sdk.a.b.a
    public void b(String str, long j) {
        String a2 = a();
        if (!f4848a.equals(a2)) {
            n.a(this.f4851d, this.f4852e);
            this.f4849b.a(str, j, -2, a2);
            return;
        }
        String b2 = b();
        if (!f4848a.equals(b2)) {
            n.a(this.f4851d, this.f4852e);
            this.f4849b.a(str, j, -3, b2);
            return;
        }
        String a3 = a(this.f4851d, this.f4852e);
        if (f4848a.equals(a3)) {
            this.f4849b.a(str, j, this.f4852e);
            return;
        }
        n.a(this.f4851d, this.f4852e);
        this.f4849b.a(str, j, -6, a3);
    }
}
