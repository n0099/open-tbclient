package com.baidu.android.nebula.b;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.StringTokenizer;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public class t extends h {
    private File e;
    private Context f;
    private static final String d = t.class.getSimpleName();
    public static final Map c = new x();

    public t(String str, int i, File file, Context context) {
        super(str, i);
        this.e = file;
        this.f = context;
        System.setProperty("baidu.moplus.tmpdir", this.f.getCacheDir().getAbsolutePath());
    }

    public static void a(c cVar, File file) {
        cVar.a("Cache-Control", "max-age=15552000");
        Calendar calendar = Calendar.getInstance();
        calendar.add(2, 1);
        cVar.a("Expires", calendar.getTime().toGMTString());
        cVar.a("Last-Modified", new Date(file.lastModified()).toGMTString());
    }

    private String b(String str) {
        String str2 = "";
        StringTokenizer stringTokenizer = new StringTokenizer(str, "/ ", true);
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (nextToken.equals("/")) {
                str2 = str2 + "/";
            } else if (nextToken.equals(" ")) {
                str2 = str2 + "%20";
            } else {
                try {
                    str2 = str2 + URLEncoder.encode(nextToken, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                }
            }
        }
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0063 A[Catch: Exception -> 0x009d, TRY_LEAVE, TryCatch #2 {Exception -> 0x009d, blocks: (B:19:0x004e, B:21:0x0063), top: B:44:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.android.nebula.b.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c a(String str, k kVar, Map map, Map map2, Map map3) {
        c cVar;
        String str2;
        c cVar2;
        boolean z;
        int length;
        int i;
        c cVar3 = null;
        if (k.OPTIONS.equals(kVar)) {
            try {
                c cVar4 = new c("");
                try {
                    cVar4.a("Access-Control-Allow-Origin", "*");
                    return cVar4;
                } catch (Exception e) {
                    cVar3 = cVar4;
                    e = e;
                    e.printStackTrace();
                    cVar = cVar3;
                    if (str.length() <= 0) {
                    }
                    str2 = (String) map2.get("mcmdf");
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            String[] split = com.baidu.android.a.s.a(this.f).h().split("@");
                            length = split.length;
                            i = 0;
                            while (true) {
                                if (i < length) {
                                }
                                i++;
                            }
                        } catch (Exception e2) {
                            z = false;
                        }
                        if (!z) {
                        }
                    }
                    cVar2 = cVar;
                    if (cVar2 == null) {
                    }
                    if (k.POST.equals(kVar)) {
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
        } else {
            cVar = null;
        }
        String substring = str.length() <= 0 ? str.substring(1) : str;
        str2 = (String) map2.get("mcmdf");
        if (!TextUtils.isEmpty(str2) && !TextUtils.equals(str2, "null") && str2.startsWith("inapp_")) {
            String[] split2 = com.baidu.android.a.s.a(this.f).h().split("@");
            length = split2.length;
            i = 0;
            while (true) {
                if (i < length) {
                    z = false;
                    break;
                } else if (TextUtils.equals(str2, split2[i])) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                cVar2 = new com.baidu.android.nebula.cmd.i(this.f).a(substring, kVar, map, map2, map3);
                if (cVar2 == null) {
                    cVar2 = a(str, map, this.e);
                }
                if (k.POST.equals(kVar)) {
                    cVar2.a("Access-Control-Allow-Origin", "*");
                    return cVar2;
                }
                return cVar2;
            }
        }
        cVar2 = cVar;
        if (cVar2 == null) {
        }
        if (k.POST.equals(kVar)) {
        }
    }

    public c a(String str, Map map, File file) {
        c cVar;
        File file2;
        long j;
        String str2;
        long j2;
        long j3;
        c cVar2;
        c cVar3 = file.isDirectory() ? null : new c(u.INTERNAL_ERROR, "text/plain", "INTERNAL ERRROR: serveFile(): given homeDir is not a directory.");
        if (cVar3 == null) {
            String replace = str.trim().replace(File.separatorChar, IOUtils.DIR_SEPARATOR_UNIX);
            if (replace.indexOf(63) >= 0) {
                replace = replace.substring(0, replace.indexOf(63));
            }
            if (replace.startsWith("src/main") || replace.endsWith("src/main") || replace.contains("../")) {
                str = replace;
                cVar = new c(u.FORBIDDEN, "text/plain", "FORBIDDEN: Won't serve ../ for security reasons.");
            } else {
                str = replace;
                cVar = cVar3;
            }
        } else {
            cVar = cVar3;
        }
        File file3 = new File(file, str);
        if (cVar == null && !file3.exists()) {
            cVar = new c(u.NOT_FOUND, "text/plain", "Error 404, file not found.");
        }
        if (cVar == null && file3.isDirectory()) {
            if (str.endsWith("/")) {
                cVar2 = cVar;
            } else {
                str = str + "/";
                cVar2 = new c(u.REDIRECT, "text/html", "<html><body>Redirected: <a href=\"" + str + "\">" + str + "</a></body></html>");
                cVar2.a("Location", str);
            }
            if (cVar2 != null) {
                file2 = file3;
                cVar = cVar2;
            } else if (new File(file3, "index.html").exists()) {
                file2 = new File(file, str + "/index.html");
                cVar = cVar2;
            } else if (new File(file3, "index.htm").exists()) {
                file2 = new File(file, str + "/index.htm");
                cVar = cVar2;
            } else if (file3.canRead()) {
                String[] list = file3.list();
                String str3 = "<html><body><h1>Directory " + str + "</h1><br/>";
                if (str.length() > 1) {
                    String substring = str.substring(0, str.length() - 1);
                    int lastIndexOf = substring.lastIndexOf(47);
                    if (lastIndexOf >= 0 && lastIndexOf < substring.length()) {
                        str3 = str3 + "<b><a href=\"" + str.substring(0, lastIndexOf + 1) + "\">..</a></b><br/>";
                    }
                }
                if (list != null) {
                    for (int i = 0; i < list.length; i++) {
                        File file4 = new File(file3, list[i]);
                        boolean isDirectory = file4.isDirectory();
                        if (isDirectory) {
                            str3 = str3 + "<b>";
                            list[i] = list[i] + "/";
                        }
                        String str4 = str3 + "<a href=\"" + b(str + list[i]) + "\">" + list[i] + "</a>";
                        if (file4.isFile()) {
                            long length = file4.length();
                            String str5 = str4 + " &nbsp;<font size=2>(";
                            str4 = (length < FileUtils.ONE_KB ? str5 + length + " bytes" : length < FileUtils.ONE_MB ? str5 + (length / FileUtils.ONE_KB) + "." + (((length % FileUtils.ONE_KB) / 10) % 100) + " KB" : str5 + (length / FileUtils.ONE_MB) + "." + (((length % FileUtils.ONE_MB) / 10) % 100) + " MB") + ")</font>";
                        }
                        str3 = str4 + "<br/>";
                        if (isDirectory) {
                            str3 = str3 + "</b>";
                        }
                    }
                }
                cVar = new c(str3 + "</body></html>");
                file2 = file3;
            } else {
                cVar = new c(u.FORBIDDEN, "text/plain", "FORBIDDEN: No directory listing.");
                file2 = file3;
            }
        } else {
            file2 = file3;
        }
        if (cVar == null) {
            try {
                int lastIndexOf2 = file2.getCanonicalPath().lastIndexOf(46);
                String str6 = lastIndexOf2 >= 0 ? (String) c.get(file2.getCanonicalPath().substring(lastIndexOf2 + 1).toLowerCase()) : null;
                String hexString = Integer.toHexString((file2.getAbsolutePath() + file2.lastModified() + "" + file2.length()).hashCode());
                long j4 = 0;
                String str7 = (String) map.get("range");
                if (str7 == null || !str7.startsWith("bytes=")) {
                    j = 0;
                    str2 = str7;
                    j2 = -1;
                } else {
                    String substring2 = str7.substring("bytes=".length());
                    int indexOf = substring2.indexOf(45);
                    if (indexOf > 0) {
                        try {
                            j4 = Long.parseLong(substring2.substring(0, indexOf));
                            j2 = Long.parseLong(substring2.substring(indexOf + 1));
                            j3 = j4;
                        } catch (NumberFormatException e) {
                            j = j4;
                            j2 = -1;
                            str2 = substring2;
                        }
                    } else {
                        j2 = -1;
                        j3 = 0;
                    }
                    j = j3;
                    str2 = substring2;
                }
                long length2 = file2.length();
                if (str2 == null || j < 0) {
                    if (hexString.equals(map.get("if-none-match"))) {
                        cVar = new c(u.NOT_MODIFIED, str6, "");
                    } else {
                        cVar = new c(u.OK, str6, new FileInputStream(file2));
                        cVar.a("Content-Length", "" + length2);
                        cVar.a("ETag", hexString);
                    }
                } else if (j >= length2) {
                    cVar = new c(u.RANGE_NOT_SATISFIABLE, "text/plain", "");
                    cVar.a("Content-Range", "bytes 0-0/" + length2);
                    cVar.a("ETag", hexString);
                } else {
                    long j5 = j2 < 0 ? length2 - 1 : j2;
                    long j6 = (j5 - j) + 1;
                    long j7 = j6 < 0 ? 0L : j6;
                    w wVar = new w(this, file2, j7);
                    wVar.skip(j);
                    cVar = new c(u.PARTIAL_CONTENT, str6, wVar);
                    cVar.a("Content-Length", "" + j7);
                    cVar.a("Content-Range", "bytes " + j + "-" + j5 + "/" + length2);
                    cVar.a("ETag", hexString);
                }
                a(cVar, file2);
            } catch (IOException e2) {
                cVar = new c(u.FORBIDDEN, "text/plain", "FORBIDDEN: Reading file failed.");
            }
        }
        cVar.a("Accept-Ranges", "bytes");
        return cVar;
    }

    @Override // com.baidu.android.nebula.b.h
    public void b() {
        super.b();
    }
}
