package com.baidu.cyberplayer.sdk.a;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.Utils;
import com.baidu.cyberplayer.sdk.a.b;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a implements b.a {
    private static final String a = Boolean.toString(true);
    private InterfaceC0048a b;
    private String c;
    private String d;
    private ArrayList<String> e = null;

    /* renamed from: com.baidu.cyberplayer.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0048a {
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
                    this.e = Utils.a(file, this.d);
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
                    if (!TextUtils.isEmpty(str2) && str2.startsWith("md5_") && !Utils.a(str2.substring("md5_".length(), "md5_".length() + 32), this.d + File.separator + str2)) {
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

    private String c() {
        File file;
        String str = a;
        try {
            if (this.e != null) {
                for (int i = 0; i < this.e.size(); i++) {
                    String str2 = this.e.get(i);
                    if (!TextUtils.isEmpty(str2)) {
                        File file2 = new File(this.d, str2);
                        if (file2.isDirectory()) {
                            continue;
                        } else {
                            String name = file2.getName();
                            String parent = file2.getParent();
                            if (!TextUtils.isEmpty(name) && name.startsWith("md5_") && name.length() > "md5_".length() + 32) {
                                if (!file2.exists()) {
                                    return "file not found:" + file2.getAbsolutePath();
                                }
                                if (!file2.renameTo(new File(parent, name.substring("md5_".length() + 32 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS.length(), name.length())))) {
                                    return "rename fail";
                                }
                                CyberLog.d("CyberFileDownloader", "rename " + file2.getName() + "(" + file2.exists() + ") to " + file.getName() + "(" + file.exists() + ")");
                            }
                        }
                    }
                }
            }
            return str;
        } catch (Exception e) {
            return e.toString();
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
        this.b.a(str, j, -1, str2 + ",networkstatus:" + Utils.h() + ",url:" + str);
    }

    public void a(String str, String str2, String str3, InterfaceC0048a interfaceC0048a) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || interfaceC0048a == null) {
            return;
        }
        this.c = str2;
        this.b = interfaceC0048a;
        this.d = str3;
        Utils.b(this.d);
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
            Utils.a(this.d, this.e);
            this.b.a(str, j, -2, a2);
            return;
        }
        String b = b();
        if (!a.equals(b)) {
            Utils.a(this.d, this.e);
            this.b.a(str, j, -3, b);
            return;
        }
        String c = c();
        if (a.equals(c)) {
            this.b.a(str, j, this.e);
            return;
        }
        Utils.a(this.d, this.e);
        this.b.a(str, j, -6, c);
    }
}
