package com.baidu.swan.games.i;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.system.Os;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.baidu.android.util.io.FileUtils;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class f {
    private static List<String> eer = new ArrayList();
    private String ees;
    private final com.baidu.swan.apps.storage.b.c eet;
    private final com.baidu.swan.apps.storage.b.d eeu;
    private Context mContext;

    static {
        eer.add("ascii");
        eer.add("base64");
        eer.add("binary");
        eer.add("hex");
        eer.add("utf-8");
        eer.add("utf8");
        eer.add("latin1");
        eer.add("ucs2");
        eer.add("ucs-2");
        eer.add("utf16le");
        eer.add("utf-16le");
    }

    public f(Context context, String str, @NonNull com.baidu.swan.apps.storage.b.c cVar) {
        this.mContext = context;
        this.ees = str;
        this.eet = cVar;
        this.eeu = this.eet.aLK();
    }

    private String wc(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith("bdfile://code")) {
            this.ees = this.ees.endsWith(File.separator) ? this.ees.substring(0, this.ees.length() - 1) : this.ees;
            return this.ees + str.substring("bdfile://code".length());
        } else if (str.startsWith("bdfile://")) {
            return this.eet.sV(str);
        } else {
            return "";
        }
    }

    private c wd(String str) {
        c aA = aA(-1, "fail permission denied, open " + str);
        if (!TextUtils.isEmpty(str) && str.startsWith(a.USER_DATA_PATH)) {
            return null;
        }
        return aA;
    }

    private c aA(int i, String str) {
        c cVar = new c();
        cVar.errCode = i;
        cVar.errMsg = str;
        return cVar;
    }

    private c am(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            c cVar = new c();
            cVar.errCode = -1;
            cVar.errMsg = "fail no such file or directory " + str;
            return cVar;
        }
        String wc = wc(str);
        if (TextUtils.isEmpty(str)) {
            c cVar2 = new c();
            cVar2.errCode = -1;
            cVar2.errMsg = "fail no such file or directory " + str;
            return cVar2;
        }
        File file = new File(wc);
        if (!file.exists()) {
            c cVar3 = new c();
            cVar3.errCode = -1;
            cVar3.errMsg = "fail no such file or directory " + str;
            return cVar3;
        } else if (!z || file.isFile()) {
            return null;
        } else {
            c cVar4 = new c();
            cVar4.errCode = -1;
            cVar4.errMsg = "fail no such file or directory " + str;
            return cVar4;
        }
    }

    private c an(String str, boolean z) {
        if (str.endsWith(File.separator)) {
            str = str.substring(0, str.length() - 1);
        }
        String wc = wc(str);
        if (TextUtils.isEmpty(wc)) {
            return aA(-1, "fail no such file or directory " + str);
        }
        if (wc.contains(File.separator)) {
            File file = new File(wc.substring(0, wc.lastIndexOf(File.separator)));
            if (!z && (!file.exists() || (file.exists() && file.isFile()))) {
                return aA(-1, "fail no such file or directory " + str);
            }
        }
        return null;
    }

    public c b(String str, boolean z, boolean z2) {
        boolean mkdir;
        c af = n.af(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (af == null) {
            c wd = wd(str);
            if (wd == null) {
                if (!n.wi(str)) {
                    return aA(-4, "fail permission denied, open " + str);
                }
                String wc = wc(str);
                if (TextUtils.isEmpty(wc)) {
                    return aA(-1, "fail no such file or directory " + str);
                }
                c an = an(str, z);
                if (an == null) {
                    File file = new File(wc);
                    if (file.exists()) {
                        return aA(-1, "fail file already exists " + str);
                    }
                    try {
                        if (z) {
                            mkdir = file.mkdirs();
                        } else {
                            mkdir = file.mkdir();
                        }
                        if (!mkdir) {
                            return aA(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                        }
                        return aA(0, "ok");
                    } catch (Exception e) {
                        return aA(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                    }
                }
                return an;
            }
            return wd;
        }
        return af;
    }

    public c a(boolean z, String str, Object obj, String str2) {
        c af = n.af(str, z ? "filePath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        return af != null ? af : a(str, obj, str2, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [457=4, 461=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:110:0x0181 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v26, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29, types: [com.baidu.swan.games.i.c] */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v71 */
    /* JADX WARN: Type inference failed for: r2v72 */
    private c a(String str, Object obj, String str2, boolean z) {
        Throwable th;
        FileOutputStream fileOutputStream;
        BufferedWriter bufferedWriter;
        ?? r2;
        String str3;
        String str4;
        c wd = wd(str);
        if (wd != null) {
            return wd;
        }
        if (obj == null) {
            return aA(-1, "The argument must be string or arrayBuffer");
        }
        int length = (a.USER_DATA_PATH + File.separator).length();
        if (n.wi(str)) {
            boolean z2 = obj instanceof byte[];
            if (!z2 && TextUtils.isEmpty(str2)) {
                str2 = "utf-8";
            }
            if (!TextUtils.isEmpty(str2)) {
                if ("binary".equals(str2.toLowerCase())) {
                    str2 = "latin1";
                }
                if (!eer.contains(str2.toLowerCase())) {
                    return aA(-1, "fail invalid encoding \"" + str2 + "\"");
                }
            }
            BufferedWriter bufferedWriter2 = null;
            Closeable closeable = null;
            c an = an(str, false);
            if (an == null) {
                String wc = wc(str);
                if (TextUtils.isEmpty(wc)) {
                    return aA(-1, "fail no such file or directory " + str.substring(length));
                }
                long j = 0;
                if (!z2 && !TextUtils.isEmpty((String) obj)) {
                    j = ((String) obj).getBytes().length;
                } else if (z2) {
                    j = ((byte[]) obj).length;
                }
                if (this.eet.aLK().cR(j)) {
                    return aA(-1, aWb());
                }
                File file = new File(wc);
                if (file.exists() && file.isDirectory()) {
                    return aA(-1, " fail illegal operation on a directory, open " + str);
                }
                long length2 = file.length();
                c aA = aA(0, "ok");
                try {
                    if (z2) {
                        byte[] bArr = (byte[]) obj;
                        FileOutputStream fileOutputStream2 = new FileOutputStream(wc, z);
                        try {
                            fileOutputStream2.write(bArr);
                            fileOutputStream2.flush();
                            r2 = fileOutputStream2;
                        } catch (Exception e) {
                            fileOutputStream = fileOutputStream2;
                            bufferedWriter = null;
                            c aA2 = aA(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                            com.baidu.swan.c.d.closeSafely(bufferedWriter);
                            com.baidu.swan.c.d.closeSafely(fileOutputStream);
                            return aA2;
                        } catch (Throwable th2) {
                            th = th2;
                            closeable = fileOutputStream2;
                            com.baidu.swan.c.d.closeSafely(bufferedWriter2);
                            com.baidu.swan.c.d.closeSafely(closeable);
                            throw th;
                        }
                    } else if (TextUtils.isEmpty((String) obj) || !TextUtils.equals("base64", str2)) {
                        String[] df = n.df((String) obj, str2);
                        if (df == null || df.length != 2) {
                            str3 = "";
                            str4 = "utf-8";
                        } else {
                            str3 = df[0];
                            str4 = df[1];
                        }
                        BufferedWriter bufferedWriter3 = new BufferedWriter(TextUtils.isEmpty(str4) ? new OutputStreamWriter(new FileOutputStream(file, z)) : new OutputStreamWriter(new FileOutputStream(file, z), str4.toLowerCase()));
                        try {
                            bufferedWriter3.write(str3);
                            bufferedWriter3.flush();
                            r2 = 0;
                            bufferedWriter2 = bufferedWriter3;
                        } catch (Exception e2) {
                            fileOutputStream = null;
                            bufferedWriter = bufferedWriter3;
                            try {
                                c aA22 = aA(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                                com.baidu.swan.c.d.closeSafely(bufferedWriter);
                                com.baidu.swan.c.d.closeSafely(fileOutputStream);
                                return aA22;
                            } catch (Throwable th3) {
                                th = th3;
                                closeable = fileOutputStream;
                                bufferedWriter2 = bufferedWriter;
                                com.baidu.swan.c.d.closeSafely(bufferedWriter2);
                                com.baidu.swan.c.d.closeSafely(closeable);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            bufferedWriter2 = bufferedWriter3;
                            com.baidu.swan.c.d.closeSafely(bufferedWriter2);
                            com.baidu.swan.c.d.closeSafely(closeable);
                            throw th;
                        }
                    } else {
                        byte[] decode = Base64.decode((String) obj, 2);
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file, z);
                        try {
                            fileOutputStream3.write(decode);
                            fileOutputStream3.flush();
                            r2 = fileOutputStream3;
                        } catch (Exception e3) {
                            fileOutputStream = fileOutputStream3;
                            bufferedWriter = null;
                            c aA222 = aA(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                            com.baidu.swan.c.d.closeSafely(bufferedWriter);
                            com.baidu.swan.c.d.closeSafely(fileOutputStream);
                            return aA222;
                        } catch (Throwable th5) {
                            th = th5;
                            closeable = fileOutputStream3;
                            com.baidu.swan.c.d.closeSafely(bufferedWriter2);
                            com.baidu.swan.c.d.closeSafely(closeable);
                            throw th;
                        }
                    }
                } catch (Exception e4) {
                    fileOutputStream = null;
                    bufferedWriter = null;
                } catch (Throwable th6) {
                    th = th6;
                }
                try {
                    if (z) {
                        this.eeu.cQ(j);
                    } else {
                        this.eeu.cQ(j - length2);
                    }
                    com.baidu.swan.c.d.closeSafely(bufferedWriter2);
                    com.baidu.swan.c.d.closeSafely(r2);
                    r2 = aA;
                    return r2;
                } catch (Exception e5) {
                    fileOutputStream = r2;
                    bufferedWriter = bufferedWriter2;
                    c aA2222 = aA(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                    com.baidu.swan.c.d.closeSafely(bufferedWriter);
                    com.baidu.swan.c.d.closeSafely(fileOutputStream);
                    return aA2222;
                } catch (Throwable th7) {
                    th = th7;
                    closeable = r2;
                    com.baidu.swan.c.d.closeSafely(bufferedWriter2);
                    com.baidu.swan.c.d.closeSafely(closeable);
                    throw th;
                }
            }
            return an;
        }
        return aA(-4, "fail permission denied, open " + str.substring(length));
    }

    public c ao(String str, boolean z) {
        c aA;
        c af = n.af(str, z ? "filePath must be a string" : n.u("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of Object;");
        if (af == null) {
            if (!n.wj(str)) {
                return aA(-4, n.u("fail permission denied, open ", null, str, null));
            }
            c am = am(str, false);
            if (am == null) {
                c wd = wd(str);
                if (wd == null) {
                    String wc = wc(str);
                    if (TextUtils.isEmpty(wc)) {
                        return aA(-1, n.u("fail no such file or directory ", null, str, null));
                    }
                    File file = new File(wc);
                    if (file.isDirectory()) {
                        return aA(-1, n.u("fail operation not permitted ", "unlink", str, null));
                    }
                    long fileSize = n.getFileSize(wc);
                    try {
                        if (file.delete()) {
                            this.eeu.cQ(-fileSize);
                            aA = aA(0, "ok");
                        } else {
                            aA = aA(-1, n.u(com.baidu.pass.biometrics.face.liveness.c.a.p, null, str, null));
                        }
                        return aA;
                    } catch (Exception e) {
                        return aA(-1, n.u(com.baidu.pass.biometrics.face.liveness.c.a.p, null, str, null));
                    }
                }
                return wd;
            }
            return am;
        }
        return af;
    }

    public c db(String str, String str2) {
        c af = n.af(str, n.g("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true), "fail parameter error: parameter.zipFilePath should be String instead of Object;");
        if (af == null) {
            c af2 = n.af(str2, n.g("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true), "fail parameter error: parameter.targetPath should be String instead of Object;");
            if (af2 == null) {
                if (!str2.startsWith("bdfile://tmp") && !str2.startsWith(a.USER_DATA_PATH)) {
                    return aA(-1, "fail permission denied, open " + str2);
                }
                String wq = n.wq(str);
                if (!this.eet.ah(wq, true)) {
                    return aA(-4, n.g("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (!n.wi(str2)) {
                    return aA(-4, n.g("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (we(str2)) {
                    return aA(-1, n.g("fail permission denied, ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                String wc = wc(wq);
                String wc2 = wc(str2);
                if (TextUtils.isEmpty(wc)) {
                    return aA(-1, n.g("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (TextUtils.isEmpty(wc2)) {
                    return aA(-1, n.g("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                File file = new File(wc);
                if (!file.exists()) {
                    return aA(-1, n.g("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (!wc.endsWith(".zip")) {
                    return aA(-1, "fail unzip failed");
                }
                if (!file.isFile()) {
                    return aA(-1, n.g("fail permission denied, ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                File file2 = new File(wc2);
                if (!file2.exists()) {
                    file2.mkdirs();
                } else if (file2.isFile()) {
                    return aA(-1, "fail unzip failed");
                }
                List<String> as = n.as(wc2, true);
                if (!com.baidu.swan.c.d.unzipFile(wc, wc2)) {
                    return aA(-1, "fail unzip failed");
                }
                if (str2.startsWith(a.USER_DATA_PATH)) {
                    List<String> as2 = n.as(wc2, true);
                    ArrayList arrayList = new ArrayList(as2.size());
                    long j = 0;
                    for (String str3 : as2) {
                        if (!as.contains(str3)) {
                            arrayList.add(str3);
                            j = n.getFileSize(str3) + j;
                        }
                    }
                    if (this.eeu.cR(j)) {
                        n.bd(arrayList);
                        return aA(-1, aWb());
                    }
                    this.eeu.cQ(j);
                }
                return aA(0, "ok");
            }
            return af2;
        }
        return af;
    }

    private boolean we(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains(File.separator)) {
            return wf(str.substring(str.lastIndexOf(File.separator) + 1));
        }
        return wf(str);
    }

    private boolean wf(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(".")) {
            return false;
        }
        String[] split = str.split("\\.");
        return (split.length != 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) ? false : true;
    }

    public c u(String str, String str2, boolean z) {
        c af = n.af(str, z ? "tempFilePath must be a string" : "fail tempFilePath file not exist", z ? " The argument must be string" : "fail parameter error: parameter.tempFilePath should be String instead of Object;");
        if (af == null) {
            String wq = n.wq(str2);
            if (TextUtils.isEmpty(wq)) {
                wq = a.USER_DATA_PATH + File.separator + com.baidu.swan.c.d.getFileNameFromPath(str);
            }
            if (!wq.startsWith(a.USER_DATA_PATH)) {
                return aA(-1, n.u("fail permission denied, open ", null, str2, null));
            }
            if (!this.eet.sF(str)) {
                return aA(-4, "fail it is not a tempFilePath");
            }
            c an = an(wq, false);
            if (an != null) {
                return an;
            }
            c an2 = an(str, false);
            if (an2 != null) {
                return an2;
            }
            String wc = wc(wq);
            if (TextUtils.isEmpty(wc)) {
                return aA(-1, "fail no such file or directory " + str2);
            }
            File file = new File(wc);
            if (a.USER_DATA_PATH.equals(wq) || (file.exists() && file.isDirectory())) {
                return aA(-1, n.u("fail Error: EISDIR: illegal operation on a directory, open ", null, str2, null));
            }
            c am = am(str, true);
            if (am != null) {
                am.errMsg = "fail no such file or directory ";
                return am;
            }
            String wc2 = wc(str);
            if (TextUtils.isEmpty(wc2)) {
                return aA(-1, "fail no such file or directory " + str);
            }
            long fileSize = n.getFileSize(wc2);
            if (this.eeu.cR(fileSize)) {
                return aA(-1, aWb());
            }
            if (!wq.startsWith(a.USER_DATA_PATH) || n.wk(wq)) {
                return aA(-1, n.u("fail permission denied, open ", null, str2, null));
            }
            c an3 = an(wq, false);
            if (an3 != null) {
                return an3;
            }
            c wd = wd(wq);
            if (wd != null) {
                return wd;
            }
            c dc = dc(str, wq);
            if (dc != null && dc.errCode == 0) {
                this.eeu.cQ(fileSize);
                if (TextUtils.isEmpty(str)) {
                    return aA(-1, n.u("fail no such file or directory ", null, str, null));
                }
                File file2 = new File(wc2);
                if (file2.exists()) {
                    file2.delete();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(wq);
                dc.result = arrayList;
                dc.errMsg = "ok";
            }
            return dc;
        }
        return af;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [813=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x00d0 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable] */
    private c dc(String str, String str2) {
        FileOutputStream fileOutputStream;
        File file;
        FileInputStream fileInputStream = null;
        String wc = wc(str);
        ?? wc2 = wc(str2);
        if (TextUtils.isEmpty(wc)) {
            return aA(-1, n.u("fail no such file or directory ", null, str, null));
        }
        if (TextUtils.isEmpty(wc2)) {
            return aA(-1, n.u("fail no such file or directory ", null, str2, null));
        }
        c aA = aA(0, "ok");
        try {
            try {
                file = new File((String) wc2);
                fileInputStream = new FileInputStream(new File(wc));
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        fileOutputStream.flush();
                    }
                    com.baidu.swan.c.d.closeSafely(fileInputStream);
                    com.baidu.swan.c.d.closeSafely(fileOutputStream);
                    if (TextUtils.isEmpty(str2)) {
                        aA.errMsg = com.baidu.pass.biometrics.face.liveness.c.a.p;
                        aA.errCode = -1;
                        return aA;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str2);
                    aA.result = arrayList;
                    return aA;
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                    c aA2 = aA(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                    com.baidu.swan.c.d.closeSafely(fileInputStream);
                    com.baidu.swan.c.d.closeSafely(fileOutputStream);
                    if (TextUtils.isEmpty("")) {
                        aA.errMsg = com.baidu.pass.biometrics.face.liveness.c.a.p;
                        aA.errCode = -1;
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(str2);
                        aA.result = arrayList2;
                    }
                    return aA2;
                }
            } catch (IOException e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                wc2 = 0;
                com.baidu.swan.c.d.closeSafely(fileInputStream);
                com.baidu.swan.c.d.closeSafely(wc2);
                if (TextUtils.isEmpty("")) {
                    aA.errMsg = com.baidu.pass.biometrics.face.liveness.c.a.p;
                    aA.errCode = -1;
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(str2);
                    aA.result = arrayList3;
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            wc2 = 0;
            fileInputStream = null;
        }
    }

    public c ap(String str, boolean z) {
        c af = n.af(str, z ? "dirPath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (af == null) {
            String wq = n.wq(str);
            if (!n.wj(wq)) {
                return aA(-4, "fail permission denied, open " + str);
            }
            String wc = wc(wq);
            if (TextUtils.isEmpty(wc)) {
                return aA(-1, "fail no such file or directory " + str);
            }
            File file = new File(wc);
            if (!file.exists()) {
                return aA(-1, "fail no such file or directory " + str);
            }
            if (!file.isDirectory()) {
                return aA(-1, "fail no such file or directory " + str);
            }
            File[] listFiles = file.listFiles();
            ArrayList arrayList = new ArrayList();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2 != null && file2.exists()) {
                        arrayList.add(com.baidu.swan.c.d.getFileNameFromPath(file2.getAbsolutePath()));
                    }
                }
            }
            c aA = aA(0, "ok");
            aA.result = arrayList;
            return aA;
        }
        return af;
    }

    public c c(String str, boolean z, boolean z2) {
        boolean deleteFile;
        c af = n.af(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (af == null) {
            c wd = wd(str);
            if (wd == null) {
                if (!n.wj(str)) {
                    return aA(-4, "fail permission denied, open " + str);
                }
                String wc = wc(str);
                if (TextUtils.isEmpty(wc)) {
                    return aA(-1, "fail no such file or directory " + str);
                }
                File file = new File(wc);
                if (!file.exists() || file.isFile()) {
                    return aA(-1, "fail no such file or directory " + str);
                }
                boolean d = d(file.listFiles());
                try {
                    if (!z && d) {
                        return aA(-1, "fail directory not empty ");
                    }
                    if (!z) {
                        deleteFile = file.delete();
                    } else {
                        deleteFile = com.baidu.swan.c.d.deleteFile(file);
                    }
                    if (!deleteFile) {
                        return aA(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                    }
                    return aA(0, "ok");
                } catch (Exception e) {
                    return aA(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                }
            }
            return wd;
        }
        return af;
    }

    private boolean d(File[] fileArr) {
        return (fileArr == null || fileArr.length == 0) ? false : true;
    }

    public c v(String str, String str2, boolean z) {
        byte[] bArr;
        c af = n.af(str, z ? "filePath must be a string" : "fail file not found", z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of NULL;");
        if (af == null) {
            String wq = n.wq(str);
            if (!this.eet.ah(wq, true)) {
                return aA(-1, "fail permission denied, open " + str);
            }
            c am = am(wq, true);
            if (am != null) {
                am.errMsg = n.u("fail no such file or directory ", "open", str, null);
                return am;
            }
            boolean isEmpty = TextUtils.isEmpty(str2);
            if (!isEmpty) {
                str2 = str2.toLowerCase();
                if ("binary".equals(str2)) {
                    str2 = "latin1";
                }
            }
            if (!isEmpty && !eer.contains(str2)) {
                return aA(-1, "fail Error: Unknown encoding: " + str2);
            }
            String wc = wc(wq);
            if (TextUtils.isEmpty(wc)) {
                return aA(-1, "fail no such file or directory " + str);
            }
            File file = new File(wc);
            String str3 = "";
            byte[] bArr2 = new byte[0];
            c aA = aA(0, "ok");
            try {
                if (TextUtils.isEmpty(str2)) {
                    bArr = n.wr(wc);
                } else if ("base64".equals(str2)) {
                    bArr = n.wr(wc);
                    str3 = bArr.length == 0 ? "" : Base64.encodeToString(bArr, 2);
                } else if ("hex".equals(str2)) {
                    str3 = n.wm(wc);
                    bArr = bArr2;
                } else {
                    str3 = a(new FileInputStream(file), str2);
                    bArr = bArr2;
                }
                if (TextUtils.isEmpty(str2)) {
                    aA.edy = bArr;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str3);
                    aA.result = arrayList;
                }
                return aA;
            } catch (Exception e) {
                e.printStackTrace();
                return aA(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
            }
        }
        return af;
    }

    private String a(FileInputStream fileInputStream, String str) {
        if (fileInputStream == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(TextUtils.isEmpty(str) ? new InputStreamReader(fileInputStream) : new InputStreamReader(fileInputStream, str));
            char[] cArr = new char[1024];
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read != -1) {
                    sb.append(cArr, 0, read);
                } else {
                    return sb.toString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } finally {
            com.baidu.swan.c.d.closeSafely(fileInputStream);
        }
    }

    public c w(String str, String str2, boolean z) {
        c af = n.af(str, z ? "oldPath must be a string" : n.u("fail no such file or directory ", "rename", str, null), z ? " The argument must be string" : "fail parameter error: parameter.oldPath should be String instead of Undefined;");
        if (af == null) {
            c af2 = n.af(str2, z ? "newPath must be a string" : n.u("fail no such file or directory ", "rename", str2, null), z ? " The argument must be string" : "fail parameter error: parameter.newPath should be String instead of Undefined;");
            if (af2 == null) {
                String wq = n.wq(str);
                c wd = wd(wq);
                if (wd != null) {
                    wd.errMsg = n.u("fail permission denied, ", "rename", str, str2);
                    return wd;
                }
                String wq2 = n.wq(str2);
                c wd2 = wd(wq2);
                if (wd2 != null) {
                    wd2.errMsg = n.u("fail permission denied, ", "rename", str, str2);
                    return wd2;
                }
                c am = am(wq, false);
                if (am != null) {
                    am.errMsg = n.u("fail no such file or directory ", "rename", str, str2);
                    return am;
                } else if (!n.wi(wq) || !n.wi(wq2)) {
                    return aA(-4, n.u("fail permission denied, ", "rename", str, str2));
                } else {
                    c an = an(wq2, false);
                    if (an != null) {
                        an.errMsg = n.u("fail no such file or directory ", "rename", str, str2);
                        return an;
                    }
                    String wc = wc(wq);
                    if (TextUtils.isEmpty(wc)) {
                        return aA(-1, "fail no such file or directory " + str);
                    }
                    String wc2 = wc(wq2);
                    if (TextUtils.isEmpty(wc2)) {
                        return aA(-1, "fail no such file or directory " + str2);
                    }
                    File file = new File(wc);
                    File file2 = new File(wc2);
                    boolean exists = file2.exists();
                    if (!n.k(file, file2) || (file.isDirectory() && !exists && we(wc2))) {
                        return aA(-1, "fail rename failed");
                    }
                    try {
                        if ((file2.isDirectory() && file2.listFiles() != null && file2.listFiles().length > 0) || !file.renameTo(file2)) {
                            return aA(-1, "fail rename failed");
                        }
                        return aA(0, "ok");
                    } catch (Exception e) {
                        return aA(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                    }
                }
            }
            return af2;
        }
        return af;
    }

    public c x(String str, String str2, boolean z) {
        boolean z2 = true;
        c af = n.af(str, "srcPath must be a string", " The argument must be string");
        if (af == null) {
            c af2 = n.af(str2, "destPath must be a string", " The argument must be string");
            if (af2 == null) {
                String wq = n.wq(str);
                if (!this.eet.ah(wq, true)) {
                    return aA(-4, n.u("fail no such file or directory ", "copyFile", str, null));
                }
                String wq2 = n.wq(str2);
                if (!n.wi(wq2)) {
                    return aA(-4, n.u("fail permission denied, open ", "copyFile", str2, null));
                }
                c wd = wd(wq2);
                if (wd == null) {
                    String wc = wc(wq);
                    if (TextUtils.isEmpty(wc)) {
                        return aA(-1, "fail no such file or directory " + str);
                    }
                    File file = new File(wc);
                    if (!file.exists() || !file.isFile()) {
                        return aA(-1, n.u("fail no such file or directory ", "copyFile", str, null));
                    }
                    c an = an(wq2, false);
                    if (an != null) {
                        an.errMsg = n.u("fail no such file or directory ", "copyFile", str2, null);
                        return an;
                    } else if (wq2.endsWith(File.separator)) {
                        return aA(-1, n.u("fail permission denied, ", "copyFile", str, str2));
                    } else {
                        String wc2 = wc(wq2);
                        if (TextUtils.isEmpty(wc2)) {
                            return aA(-1, "fail no such file or directory " + str2);
                        }
                        File file2 = new File(wc2);
                        if (file2.exists() && file2.isDirectory()) {
                            if (d(file2.listFiles())) {
                                return aA(-1, n.u("fail permission denied, ", "copyFile", str, str2));
                            }
                            try {
                                file2.delete();
                            } catch (Exception e) {
                                return aA(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                            }
                        }
                        long fileSize = n.getFileSize(wc);
                        if (wq.equals(wq2) || wq.startsWith(a.USER_DATA_PATH)) {
                            z2 = false;
                        }
                        if (z2 && this.eeu.cR(fileSize)) {
                            return aA(-1, aWb());
                        }
                        c dc = !wq.equals(wq2) ? dc(wq, wq2) : aA(0, "ok");
                        if (z2 && dc != null && dc.errCode == 0) {
                            this.eeu.cQ(fileSize);
                            return dc;
                        }
                        return dc;
                    }
                }
                return wd;
            }
            return af2;
        }
        return af;
    }

    public c b(String str, Object obj, String str2, boolean z) {
        c af = n.af(str, n.u("fail permission denied, open ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of NULL;");
        if (af == null) {
            String wq = n.wq(str);
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return aA(-1, "fail sdcard not mounted ");
            }
            c wd = wd(wq);
            if (wd == null) {
                if (obj == null) {
                    return aA(-1, "fail TypeError: data argument must be a string, Buffer, ArrayBuffer, Array, or array-like object");
                }
                String wc = wc(wq);
                if (TextUtils.isEmpty(wc)) {
                    return aA(-1, "fail no such file or directory " + str);
                }
                File file = new File(wc);
                if (!file.exists()) {
                    return aA(-1, n.u("fail no such file or directory ", "open", str, null));
                }
                if (file.isDirectory()) {
                    return aA(-1, "fail illegal operation on a directory, open " + str);
                }
                return a(wq, obj, str2, true);
            }
            return wd;
        }
        return af;
    }

    public c aq(String str, boolean z) {
        c af = n.af(str, z ? "path must be a string" : n.u("fail no such file or directory ", "access", str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Undefined;");
        if (af == null) {
            String wq = n.wq(str);
            if (!this.eet.ah(wq, true)) {
                return aA(-4, n.u("fail no such file or directory ", "access", str, null));
            }
            String wc = wc(wq);
            if (TextUtils.isEmpty(wc)) {
                return aA(-1, "fail no such file or directory " + str);
            }
            if (!new File(wc).exists()) {
                return aA(-1, n.u("fail no such file or directory ", "access", str, null));
            }
            return aA(0, "ok");
        }
        return af;
    }

    public c ar(String str, boolean z) {
        c af = n.af(str, z ? "path must be a string" : n.u("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Object;");
        if (af == null) {
            if (!this.eet.sF(str) && !this.eet.sE(str)) {
                return aA(-1, "fail permission denied, open " + str);
            }
            c am = am(str, false);
            if (am == null) {
                j jVar = new j();
                String wc = wc(str);
                if (TextUtils.isEmpty(wc)) {
                    return aA(-1, n.u("fail no such file or directory ", null, str, null));
                }
                File file = new File(wc);
                jVar.ia(file.isDirectory());
                jVar.ib(file.isFile());
                return a(str, jVar);
            }
            return am;
        }
        return af;
    }

    private c a(String str, j jVar) {
        String wc = wc(str);
        if (TextUtils.isEmpty(wc)) {
            return aA(-1, "fail no such file or directory " + str);
        }
        File file = new File(wc);
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                jVar.lastAccessedTime = Os.lstat(file.getAbsolutePath()).st_atime;
                jVar.lastModifiedTime = Os.lstat(file.getAbsolutePath()).st_mtime;
                jVar.mode = Os.lstat(file.getAbsolutePath()).st_mode;
                jVar.size = Os.lstat(file.getAbsolutePath()).st_size;
            } catch (Exception e) {
                e.printStackTrace();
                return aA(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
            }
        } else {
            try {
                Field declaredField = Class.forName("libcore.io.Libcore").getDeclaredField("os");
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                Object obj = declaredField.get(null);
                Object invoke = obj.getClass().getMethod("lstat", String.class).invoke(obj, file.getAbsolutePath());
                Field declaredField2 = invoke.getClass().getDeclaredField("st_atime");
                if (!declaredField2.isAccessible()) {
                    declaredField2.setAccessible(true);
                }
                jVar.lastAccessedTime = declaredField2.getLong(invoke);
                Field declaredField3 = invoke.getClass().getDeclaredField("st_mtime");
                if (!declaredField3.isAccessible()) {
                    declaredField3.setAccessible(true);
                }
                jVar.lastModifiedTime = declaredField3.getLong(invoke);
                Field declaredField4 = invoke.getClass().getDeclaredField("st_mode");
                if (!declaredField4.isAccessible()) {
                    declaredField4.setAccessible(true);
                }
                jVar.mode = declaredField4.getInt(invoke);
                Field declaredField5 = invoke.getClass().getDeclaredField("st_size");
                if (!declaredField5.isAccessible()) {
                    declaredField5.setAccessible(true);
                }
                jVar.size = declaredField5.getLong(invoke);
            } catch (Exception e2) {
                e2.printStackTrace();
                return aA(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
            }
        }
        c aA = aA(0, "ok");
        aA.stats = jVar;
        aA.errMsg = "ok";
        return aA;
    }

    public c aWa() {
        String aLJ = this.eet.aLJ();
        String wc = wc(a.USER_DATA_PATH);
        if (TextUtils.isEmpty(wc)) {
            return aA(-1, "path must be a string");
        }
        ArrayList arrayList = new ArrayList();
        for (String str : n.as(wc, false)) {
            File file = new File(str);
            d dVar = new d();
            dVar.createTime = file.exists() ? file.lastModified() : 0L;
            String absolutePath = file.getAbsolutePath();
            if (file.exists() && !TextUtils.isEmpty(absolutePath) && !TextUtils.isEmpty(aLJ) && absolutePath.startsWith(aLJ)) {
                dVar.filePath = this.eet.sW(absolutePath);
            }
            dVar.size = file.exists() ? file.length() : 0L;
            arrayList.add(dVar);
        }
        c aA = aA(0, "ok");
        aA.fileList = arrayList;
        return aA;
    }

    public c wg(String str) {
        c aA;
        c af = n.af(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Object;");
        if (af == null) {
            if (wd(str) != null) {
                return aA(-4, "fail file not exist");
            }
            String wc = wc(str);
            if (TextUtils.isEmpty(wc)) {
                return aA(-1, "fail no such file or directory " + str);
            }
            File file = new File(wc);
            if (!file.exists() || file.isDirectory()) {
                return aA(-1, "fail file not exist");
            }
            long fileSize = n.getFileSize(wc);
            try {
                if (!file.delete()) {
                    aA = aA(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                } else {
                    this.eeu.cQ(-fileSize);
                    aA = aA(0, "ok");
                }
                return aA;
            } catch (Exception e) {
                return aA(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
            }
        }
        return af;
    }

    public c wh(String str) {
        c af = n.af(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Undefined;");
        if (af == null) {
            String wq = n.wq(str);
            if (!this.eet.ah(wq, true)) {
                return aA(-4, "fail file not exist");
            }
            String wc = wc(wq);
            if (TextUtils.isEmpty(wc)) {
                return aA(-1, "fail no such file or directory " + str);
            }
            File file = new File(wc);
            if (!file.exists()) {
                return aA(-1, "fail file not exist");
            }
            if (file.isDirectory()) {
                return aA(-1, "fail " + str + " is directory");
            }
            c aA = aA(0, "ok");
            aA.size = file.exists() ? file.length() : 0L;
            aA.digest = file.exists() ? com.baidu.swan.c.e.e(file, false) : null;
            return aA;
        }
        return af;
    }

    private String aWb() {
        String generateFileSizeText = com.baidu.swan.c.d.generateFileSizeText(this.eeu.getMaxSize());
        return String.format("fail file size over %s", (TextUtils.isEmpty(generateFileSizeText) || TextUtils.equals(generateFileSizeText, FileUtils.UNKNOW)) ? "" : "");
    }
}
