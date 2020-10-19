package com.baidu.swan.games.i;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.system.Os;
import android.text.TextUtils;
import android.util.Base64;
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
/* loaded from: classes10.dex */
public class f {
    private static List<String> dGC = new ArrayList();
    private String dGD;
    private final com.baidu.swan.apps.storage.b.c dGE;
    private final com.baidu.swan.apps.storage.b.d dGF;
    private Context mContext;

    static {
        dGC.add("ascii");
        dGC.add("base64");
        dGC.add("binary");
        dGC.add("hex");
        dGC.add("utf-8");
        dGC.add("utf8");
        dGC.add("latin1");
        dGC.add("ucs2");
        dGC.add("ucs-2");
        dGC.add("utf16le");
        dGC.add("utf-16le");
    }

    public f(Context context, String str, @NonNull com.baidu.swan.apps.storage.b.c cVar) {
        this.mContext = context;
        this.dGD = str;
        this.dGE = cVar;
        this.dGF = this.dGE.aGu();
    }

    private String wf(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith("bdfile://code")) {
            this.dGD = this.dGD.endsWith(File.separator) ? this.dGD.substring(0, this.dGD.length() - 1) : this.dGD;
            return this.dGD + str.substring("bdfile://code".length());
        } else if (str.startsWith("bdfile://")) {
            return this.dGE.ta(str);
        } else {
            return "";
        }
    }

    private c wg(String str) {
        c ar = ar(-1, "fail permission denied, open " + str);
        if (!TextUtils.isEmpty(str) && str.startsWith(a.USER_DATA_PATH)) {
            return null;
        }
        return ar;
    }

    private c ar(int i, String str) {
        c cVar = new c();
        cVar.errCode = i;
        cVar.errMsg = str;
        return cVar;
    }

    private c aj(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            c cVar = new c();
            cVar.errCode = -1;
            cVar.errMsg = "fail no such file or directory " + str;
            return cVar;
        }
        String wf = wf(str);
        if (TextUtils.isEmpty(str)) {
            c cVar2 = new c();
            cVar2.errCode = -1;
            cVar2.errMsg = "fail no such file or directory " + str;
            return cVar2;
        }
        File file = new File(wf);
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

    private c ak(String str, boolean z) {
        if (str.endsWith(File.separator)) {
            str = str.substring(0, str.length() - 1);
        }
        String wf = wf(str);
        if (TextUtils.isEmpty(wf)) {
            return ar(-1, "fail no such file or directory " + str);
        }
        if (wf.contains(File.separator)) {
            File file = new File(wf.substring(0, wf.lastIndexOf(File.separator)));
            if (!z && (!file.exists() || (file.exists() && file.isFile()))) {
                return ar(-1, "fail no such file or directory " + str);
            }
        }
        return null;
    }

    public c b(String str, boolean z, boolean z2) {
        boolean mkdir;
        c T = n.T(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (T == null) {
            c wg = wg(str);
            if (wg == null) {
                if (!n.wl(str)) {
                    return ar(-4, "fail permission denied, open " + str);
                }
                String wf = wf(str);
                if (TextUtils.isEmpty(wf)) {
                    return ar(-1, "fail no such file or directory " + str);
                }
                c ak = ak(str, z);
                if (ak == null) {
                    File file = new File(wf);
                    if (file.exists()) {
                        return ar(-1, "fail file already exists " + str);
                    }
                    try {
                        if (z) {
                            mkdir = file.mkdirs();
                        } else {
                            mkdir = file.mkdir();
                        }
                        if (!mkdir) {
                            return ar(-1, "fail");
                        }
                        return ar(0, "ok");
                    } catch (Exception e) {
                        return ar(-1, "fail");
                    }
                }
                return ak;
            }
            return wg;
        }
        return T;
    }

    public c a(boolean z, String str, Object obj, String str2) {
        c T = n.T(str, z ? "filePath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        return T != null ? T : a(str, obj, str2, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [461=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:108:0x0182 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v28, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32, types: [com.baidu.swan.games.i.c] */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v76 */
    /* JADX WARN: Type inference failed for: r2v77 */
    private c a(String str, Object obj, String str2, boolean z) {
        FileOutputStream fileOutputStream;
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2;
        ?? r2;
        String str3;
        String str4;
        c wg = wg(str);
        if (wg != null) {
            return wg;
        }
        if (obj == null) {
            return ar(-1, "The argument must be string or arrayBuffer");
        }
        int length = (a.USER_DATA_PATH + File.separator).length();
        if (n.wl(str)) {
            boolean z2 = obj instanceof byte[];
            if (!z2 && TextUtils.isEmpty(str2)) {
                str2 = "utf-8";
            }
            if (!TextUtils.isEmpty(str2)) {
                if ("binary".equals(str2.toLowerCase())) {
                    str2 = "latin1";
                }
                if (!dGC.contains(str2.toLowerCase())) {
                    return ar(-1, "fail invalid encoding \"" + str2 + "\"");
                }
            }
            BufferedWriter bufferedWriter3 = null;
            Closeable closeable = null;
            c ak = ak(str, false);
            if (ak == null) {
                String wf = wf(str);
                if (TextUtils.isEmpty(wf)) {
                    return ar(-1, "fail no such file or directory " + str.substring(length));
                }
                long j = 0;
                if (!z2 && !TextUtils.isEmpty((String) obj)) {
                    j = ((String) obj).getBytes().length;
                } else if (z2) {
                    j = ((byte[]) obj).length;
                }
                if (this.dGE.aGu().bT(j)) {
                    return ar(-1, aQJ());
                }
                File file = new File(wf);
                if (file.exists() && file.isDirectory()) {
                    return ar(-1, " fail illegal operation on a directory, open " + str);
                }
                long length2 = file.length();
                c ar = ar(0, "ok");
                try {
                    if (z2) {
                        byte[] bArr = (byte[]) obj;
                        FileOutputStream fileOutputStream2 = new FileOutputStream(wf, z);
                        try {
                            fileOutputStream2.write(bArr);
                            fileOutputStream2.flush();
                            bufferedWriter2 = null;
                            r2 = fileOutputStream2;
                        } catch (Exception e) {
                            fileOutputStream = fileOutputStream2;
                            bufferedWriter = null;
                            c ar2 = ar(-1, "fail");
                            com.baidu.swan.c.d.closeSafely(bufferedWriter);
                            com.baidu.swan.c.d.closeSafely(fileOutputStream);
                            return ar2;
                        } catch (Throwable th) {
                            closeable = fileOutputStream2;
                            th = th;
                            com.baidu.swan.c.d.closeSafely(bufferedWriter3);
                            com.baidu.swan.c.d.closeSafely(closeable);
                            throw th;
                        }
                    } else if (TextUtils.isEmpty((String) obj) || !TextUtils.equals("base64", str2)) {
                        String[] cU = n.cU((String) obj, str2);
                        if (cU == null || cU.length != 2) {
                            str3 = "utf-8";
                            str4 = "";
                        } else {
                            String str5 = cU[0];
                            str3 = cU[1];
                            str4 = str5;
                        }
                        BufferedWriter bufferedWriter4 = new BufferedWriter(TextUtils.isEmpty(str3) ? new OutputStreamWriter(new FileOutputStream(file, z)) : new OutputStreamWriter(new FileOutputStream(file, z), str3.toLowerCase()));
                        try {
                            bufferedWriter4.write(str4);
                            bufferedWriter4.flush();
                            r2 = 0;
                            bufferedWriter2 = bufferedWriter4;
                        } catch (Exception e2) {
                            fileOutputStream = null;
                            bufferedWriter = bufferedWriter4;
                            try {
                                c ar22 = ar(-1, "fail");
                                com.baidu.swan.c.d.closeSafely(bufferedWriter);
                                com.baidu.swan.c.d.closeSafely(fileOutputStream);
                                return ar22;
                            } catch (Throwable th2) {
                                th = th2;
                                closeable = fileOutputStream;
                                bufferedWriter3 = bufferedWriter;
                                com.baidu.swan.c.d.closeSafely(bufferedWriter3);
                                com.baidu.swan.c.d.closeSafely(closeable);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedWriter3 = bufferedWriter4;
                            com.baidu.swan.c.d.closeSafely(bufferedWriter3);
                            com.baidu.swan.c.d.closeSafely(closeable);
                            throw th;
                        }
                    } else {
                        byte[] decode = Base64.decode((String) obj, 2);
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file, z);
                        try {
                            fileOutputStream3.write(decode);
                            fileOutputStream3.flush();
                            bufferedWriter2 = null;
                            r2 = fileOutputStream3;
                        } catch (Exception e3) {
                            fileOutputStream = fileOutputStream3;
                            bufferedWriter = null;
                            c ar222 = ar(-1, "fail");
                            com.baidu.swan.c.d.closeSafely(bufferedWriter);
                            com.baidu.swan.c.d.closeSafely(fileOutputStream);
                            return ar222;
                        } catch (Throwable th4) {
                            closeable = fileOutputStream3;
                            th = th4;
                            com.baidu.swan.c.d.closeSafely(bufferedWriter3);
                            com.baidu.swan.c.d.closeSafely(closeable);
                            throw th;
                        }
                    }
                } catch (Exception e4) {
                    fileOutputStream = null;
                    bufferedWriter = null;
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    if (z) {
                        this.dGF.bS(j);
                    } else {
                        this.dGF.bS(j - length2);
                    }
                    com.baidu.swan.c.d.closeSafely(bufferedWriter2);
                    com.baidu.swan.c.d.closeSafely(r2);
                    r2 = ar;
                    return r2;
                } catch (Exception e5) {
                    fileOutputStream = r2;
                    bufferedWriter = bufferedWriter2;
                    c ar2222 = ar(-1, "fail");
                    com.baidu.swan.c.d.closeSafely(bufferedWriter);
                    com.baidu.swan.c.d.closeSafely(fileOutputStream);
                    return ar2222;
                } catch (Throwable th6) {
                    bufferedWriter3 = bufferedWriter2;
                    closeable = r2;
                    th = th6;
                    com.baidu.swan.c.d.closeSafely(bufferedWriter3);
                    com.baidu.swan.c.d.closeSafely(closeable);
                    throw th;
                }
            }
            return ak;
        }
        return ar(-4, "fail permission denied, open " + str.substring(length));
    }

    public c al(String str, boolean z) {
        c ar;
        c T = n.T(str, z ? "filePath must be a string" : n.t("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of Object;");
        if (T == null) {
            if (!n.wm(str)) {
                return ar(-4, n.t("fail permission denied, open ", null, str, null));
            }
            c aj = aj(str, false);
            if (aj == null) {
                c wg = wg(str);
                if (wg == null) {
                    String wf = wf(str);
                    if (TextUtils.isEmpty(wf)) {
                        return ar(-1, n.t("fail no such file or directory ", null, str, null));
                    }
                    File file = new File(wf);
                    if (file.isDirectory()) {
                        return ar(-1, n.t("fail operation not permitted ", "unlink", str, null));
                    }
                    long fileSize = n.getFileSize(wf);
                    try {
                        if (file.delete()) {
                            this.dGF.bS(-fileSize);
                            ar = ar(0, "ok");
                        } else {
                            ar = ar(-1, n.t("fail", null, str, null));
                        }
                        return ar;
                    } catch (Exception e) {
                        return ar(-1, n.t("fail", null, str, null));
                    }
                }
                return wg;
            }
            return aj;
        }
        return T;
    }

    public c cQ(String str, String str2) {
        c T = n.T(str, n.c("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true), "fail parameter error: parameter.zipFilePath should be String instead of Object;");
        if (T == null) {
            c T2 = n.T(str2, n.c("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true), "fail parameter error: parameter.targetPath should be String instead of Object;");
            if (T2 == null) {
                if (!str2.startsWith("bdfile://tmp") && !str2.startsWith(a.USER_DATA_PATH)) {
                    return ar(-1, "fail permission denied, open " + str2);
                }
                String wt = n.wt(str);
                if (!this.dGE.ae(wt, true)) {
                    return ar(-4, n.c("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (!n.wl(str2)) {
                    return ar(-4, n.c("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (wh(str2)) {
                    return ar(-1, n.c("fail permission denied, ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                String wf = wf(wt);
                String wf2 = wf(str2);
                if (TextUtils.isEmpty(wf)) {
                    return ar(-1, n.c("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (TextUtils.isEmpty(wf2)) {
                    return ar(-1, n.c("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                File file = new File(wf);
                if (!file.exists()) {
                    return ar(-1, n.c("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (!wf.endsWith(".zip")) {
                    return ar(-1, "fail unzip failed");
                }
                if (!file.isFile()) {
                    return ar(-1, n.c("fail permission denied, ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                File file2 = new File(wf2);
                if (!file2.exists()) {
                    file2.mkdirs();
                } else if (file2.isFile()) {
                    return ar(-1, "fail unzip failed");
                }
                List<String> ap = n.ap(wf2, true);
                if (!com.baidu.swan.c.d.unzipFile(wf, wf2)) {
                    return ar(-1, "fail unzip failed");
                }
                if (str2.startsWith(a.USER_DATA_PATH)) {
                    List<String> ap2 = n.ap(wf2, true);
                    ArrayList arrayList = new ArrayList(ap2.size());
                    long j = 0;
                    for (String str3 : ap2) {
                        if (!ap.contains(str3)) {
                            arrayList.add(str3);
                            j = n.getFileSize(str3) + j;
                        }
                    }
                    if (this.dGF.bT(j)) {
                        n.aC(arrayList);
                        return ar(-1, aQJ());
                    }
                    this.dGF.bS(j);
                }
                return ar(0, "ok");
            }
            return T2;
        }
        return T;
    }

    private boolean wh(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains(File.separator)) {
            return wi(str.substring(str.lastIndexOf(File.separator) + 1));
        }
        return wi(str);
    }

    private boolean wi(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(".")) {
            return false;
        }
        String[] split = str.split("\\.");
        return (split.length != 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) ? false : true;
    }

    public c q(String str, String str2, boolean z) {
        c T = n.T(str, z ? "tempFilePath must be a string" : "fail tempFilePath file not exist", z ? " The argument must be string" : "fail parameter error: parameter.tempFilePath should be String instead of Object;");
        if (T == null) {
            String wt = n.wt(str2);
            if (TextUtils.isEmpty(wt)) {
                wt = a.USER_DATA_PATH + File.separator + com.baidu.swan.c.d.getFileNameFromPath(str);
            }
            if (!wt.startsWith(a.USER_DATA_PATH)) {
                return ar(-1, n.t("fail permission denied, open ", null, str2, null));
            }
            if (!this.dGE.sK(str)) {
                return ar(-4, "fail it is not a tempFilePath");
            }
            c ak = ak(wt, false);
            if (ak != null) {
                return ak;
            }
            c ak2 = ak(str, false);
            if (ak2 != null) {
                return ak2;
            }
            String wf = wf(wt);
            if (TextUtils.isEmpty(wf)) {
                return ar(-1, "fail no such file or directory " + str2);
            }
            File file = new File(wf);
            if (a.USER_DATA_PATH.equals(wt) || (file.exists() && file.isDirectory())) {
                return ar(-1, n.t("fail Error: EISDIR: illegal operation on a directory, open ", null, str2, null));
            }
            c aj = aj(str, true);
            if (aj != null) {
                aj.errMsg = "fail no such file or directory ";
                return aj;
            }
            String wf2 = wf(str);
            if (TextUtils.isEmpty(wf2)) {
                return ar(-1, "fail no such file or directory " + str);
            }
            long fileSize = n.getFileSize(wf2);
            if (this.dGF.bT(fileSize)) {
                return ar(-1, aQJ());
            }
            if (!wt.startsWith(a.USER_DATA_PATH) || n.wn(wt)) {
                return ar(-1, n.t("fail permission denied, open ", null, str2, null));
            }
            c ak3 = ak(wt, false);
            if (ak3 != null) {
                return ak3;
            }
            c wg = wg(wt);
            if (wg != null) {
                return wg;
            }
            c cR = cR(str, wt);
            if (cR != null && cR.errCode == 0) {
                this.dGF.bS(fileSize);
                if (TextUtils.isEmpty(str)) {
                    return ar(-1, n.t("fail no such file or directory ", null, str, null));
                }
                File file2 = new File(wf2);
                if (file2.exists()) {
                    file2.delete();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(wt);
                cR.result = arrayList;
                cR.errMsg = "ok";
            }
            return cR;
        }
        return T;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [813=4] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v11, resolved type: java.io.FileOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private c cR(String str, String str2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream3 = null;
        String wf = wf(str);
        String wf2 = wf(str2);
        if (TextUtils.isEmpty(wf)) {
            return ar(-1, n.t("fail no such file or directory ", null, str, null));
        }
        if (TextUtils.isEmpty(wf2)) {
            return ar(-1, n.t("fail no such file or directory ", null, str2, null));
        }
        c ar = ar(0, "ok");
        try {
            File file = new File(wf2);
            fileInputStream = new FileInputStream(new File(wf));
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (IOException e) {
                e = e;
                fileInputStream2 = null;
                fileInputStream3 = fileInputStream;
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e = e2;
            fileInputStream2 = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
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
                ar.errMsg = "fail";
                ar.errCode = -1;
                return ar;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            ar.result = arrayList;
            return ar;
        } catch (IOException e3) {
            e = e3;
            fileInputStream3 = fileInputStream;
            fileInputStream2 = fileOutputStream;
            try {
                e.printStackTrace();
                c ar2 = ar(-1, "fail");
                com.baidu.swan.c.d.closeSafely(fileInputStream3);
                com.baidu.swan.c.d.closeSafely(fileInputStream2);
                if (TextUtils.isEmpty("")) {
                    ar.errMsg = "fail";
                    ar.errCode = -1;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(str2);
                    ar.result = arrayList2;
                }
                return ar2;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream3;
                fileInputStream3 = fileInputStream2;
                com.baidu.swan.c.d.closeSafely(fileInputStream);
                com.baidu.swan.c.d.closeSafely(fileInputStream3);
                if (TextUtils.isEmpty("")) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(str2);
                    ar.result = arrayList3;
                } else {
                    ar.errMsg = "fail";
                    ar.errCode = -1;
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream3 = fileOutputStream;
            com.baidu.swan.c.d.closeSafely(fileInputStream);
            com.baidu.swan.c.d.closeSafely(fileInputStream3);
            if (TextUtils.isEmpty("")) {
            }
            throw th;
        }
    }

    public c am(String str, boolean z) {
        c T = n.T(str, z ? "dirPath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (T == null) {
            String wt = n.wt(str);
            if (!n.wm(wt)) {
                return ar(-4, "fail permission denied, open " + str);
            }
            String wf = wf(wt);
            if (TextUtils.isEmpty(wf)) {
                return ar(-1, "fail no such file or directory " + str);
            }
            File file = new File(wf);
            if (!file.exists()) {
                return ar(-1, "fail no such file or directory " + str);
            }
            if (!file.isDirectory()) {
                return ar(-1, "fail no such file or directory " + str);
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
            c ar = ar(0, "ok");
            ar.result = arrayList;
            return ar;
        }
        return T;
    }

    public c c(String str, boolean z, boolean z2) {
        boolean deleteFile;
        c T = n.T(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (T == null) {
            c wg = wg(str);
            if (wg == null) {
                if (!n.wm(str)) {
                    return ar(-4, "fail permission denied, open " + str);
                }
                String wf = wf(str);
                if (TextUtils.isEmpty(wf)) {
                    return ar(-1, "fail no such file or directory " + str);
                }
                File file = new File(wf);
                if (!file.exists() || file.isFile()) {
                    return ar(-1, "fail no such file or directory " + str);
                }
                boolean d = d(file.listFiles());
                try {
                    if (!z && d) {
                        return ar(-1, "fail directory not empty ");
                    }
                    if (!z) {
                        deleteFile = file.delete();
                    } else {
                        deleteFile = com.baidu.swan.c.d.deleteFile(file);
                    }
                    if (!deleteFile) {
                        return ar(-1, "fail");
                    }
                    return ar(0, "ok");
                } catch (Exception e) {
                    return ar(-1, "fail");
                }
            }
            return wg;
        }
        return T;
    }

    private boolean d(File[] fileArr) {
        return (fileArr == null || fileArr.length == 0) ? false : true;
    }

    public c r(String str, String str2, boolean z) {
        c T = n.T(str, z ? "filePath must be a string" : "fail file not found", z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of NULL;");
        if (T == null) {
            String wt = n.wt(str);
            if (!this.dGE.ae(wt, true)) {
                return ar(-1, "fail permission denied, open " + str);
            }
            c aj = aj(wt, true);
            if (aj != null) {
                aj.errMsg = n.t("fail no such file or directory ", "open", str, null);
                return aj;
            }
            boolean isEmpty = TextUtils.isEmpty(str2);
            if (!isEmpty) {
                str2 = str2.toLowerCase();
                if ("binary".equals(str2)) {
                    str2 = "latin1";
                }
            }
            if (!isEmpty && !dGC.contains(str2)) {
                return ar(-1, "fail Error: Unknown encoding: " + str2);
            }
            String wf = wf(wt);
            if (TextUtils.isEmpty(wf)) {
                return ar(-1, "fail no such file or directory " + str);
            }
            File file = new File(wf);
            String str3 = "";
            byte[] bArr = new byte[0];
            c ar = ar(0, "ok");
            try {
                if (TextUtils.isEmpty(str2)) {
                    bArr = n.wu(wf);
                } else if ("base64".equals(str2)) {
                    byte[] wu = n.wu(wf);
                    str3 = wu.length == 0 ? "" : Base64.encodeToString(wu, 2);
                    bArr = wu;
                } else if ("hex".equals(str2)) {
                    str3 = n.wp(wf);
                } else {
                    str3 = a(new FileInputStream(file), str2);
                }
                if (TextUtils.isEmpty(str2)) {
                    ar.dFJ = bArr;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str3);
                    ar.result = arrayList;
                }
                return ar;
            } catch (Exception e) {
                e.printStackTrace();
                return ar(-1, "fail");
            }
        }
        return T;
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

    public c s(String str, String str2, boolean z) {
        c T = n.T(str, z ? "oldPath must be a string" : n.t("fail no such file or directory ", "rename", str, null), z ? " The argument must be string" : "fail parameter error: parameter.oldPath should be String instead of Undefined;");
        if (T == null) {
            c T2 = n.T(str2, z ? "newPath must be a string" : n.t("fail no such file or directory ", "rename", str2, null), z ? " The argument must be string" : "fail parameter error: parameter.newPath should be String instead of Undefined;");
            if (T2 == null) {
                String wt = n.wt(str);
                c wg = wg(wt);
                if (wg != null) {
                    wg.errMsg = n.t("fail permission denied, ", "rename", str, str2);
                    return wg;
                }
                String wt2 = n.wt(str2);
                c wg2 = wg(wt2);
                if (wg2 != null) {
                    wg2.errMsg = n.t("fail permission denied, ", "rename", str, str2);
                    return wg2;
                }
                c aj = aj(wt, false);
                if (aj != null) {
                    aj.errMsg = n.t("fail no such file or directory ", "rename", str, str2);
                    return aj;
                } else if (!n.wl(wt) || !n.wl(wt2)) {
                    return ar(-4, n.t("fail permission denied, ", "rename", str, str2));
                } else {
                    c ak = ak(wt2, false);
                    if (ak != null) {
                        ak.errMsg = n.t("fail no such file or directory ", "rename", str, str2);
                        return ak;
                    }
                    String wf = wf(wt);
                    if (TextUtils.isEmpty(wf)) {
                        return ar(-1, "fail no such file or directory " + str);
                    }
                    String wf2 = wf(wt2);
                    if (TextUtils.isEmpty(wf2)) {
                        return ar(-1, "fail no such file or directory " + str2);
                    }
                    File file = new File(wf);
                    File file2 = new File(wf2);
                    boolean exists = file2.exists();
                    if (!n.k(file, file2) || (file.isDirectory() && !exists && wh(wf2))) {
                        return ar(-1, "fail rename failed");
                    }
                    try {
                        if ((file2.isDirectory() && file2.listFiles() != null && file2.listFiles().length > 0) || !file.renameTo(file2)) {
                            return ar(-1, "fail rename failed");
                        }
                        return ar(0, "ok");
                    } catch (Exception e) {
                        return ar(-1, "fail");
                    }
                }
            }
            return T2;
        }
        return T;
    }

    public c t(String str, String str2, boolean z) {
        boolean z2 = true;
        c T = n.T(str, "srcPath must be a string", " The argument must be string");
        if (T == null) {
            c T2 = n.T(str2, "destPath must be a string", " The argument must be string");
            if (T2 == null) {
                String wt = n.wt(str);
                if (!this.dGE.ae(wt, true)) {
                    return ar(-4, n.t("fail no such file or directory ", "copyFile", str, null));
                }
                String wt2 = n.wt(str2);
                if (!n.wl(wt2)) {
                    return ar(-4, n.t("fail permission denied, open ", "copyFile", str2, null));
                }
                c wg = wg(wt2);
                if (wg == null) {
                    String wf = wf(wt);
                    if (TextUtils.isEmpty(wf)) {
                        return ar(-1, "fail no such file or directory " + str);
                    }
                    File file = new File(wf);
                    if (!file.exists() || !file.isFile()) {
                        return ar(-1, n.t("fail no such file or directory ", "copyFile", str, null));
                    }
                    c ak = ak(wt2, false);
                    if (ak != null) {
                        ak.errMsg = n.t("fail no such file or directory ", "copyFile", str2, null);
                        return ak;
                    } else if (wt2.endsWith(File.separator)) {
                        return ar(-1, n.t("fail permission denied, ", "copyFile", str, str2));
                    } else {
                        String wf2 = wf(wt2);
                        if (TextUtils.isEmpty(wf2)) {
                            return ar(-1, "fail no such file or directory " + str2);
                        }
                        File file2 = new File(wf2);
                        if (file2.exists() && file2.isDirectory()) {
                            if (d(file2.listFiles())) {
                                return ar(-1, n.t("fail permission denied, ", "copyFile", str, str2));
                            }
                            try {
                                file2.delete();
                            } catch (Exception e) {
                                return ar(-1, "fail");
                            }
                        }
                        long fileSize = n.getFileSize(wf);
                        if (wt.equals(wt2) || wt.startsWith(a.USER_DATA_PATH)) {
                            z2 = false;
                        }
                        if (z2 && this.dGF.bT(fileSize)) {
                            return ar(-1, aQJ());
                        }
                        c cR = !wt.equals(wt2) ? cR(wt, wt2) : ar(0, "ok");
                        if (z2 && cR != null && cR.errCode == 0) {
                            this.dGF.bS(fileSize);
                            return cR;
                        }
                        return cR;
                    }
                }
                return wg;
            }
            return T2;
        }
        return T;
    }

    public c b(String str, Object obj, String str2, boolean z) {
        c T = n.T(str, n.t("fail permission denied, open ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of NULL;");
        if (T == null) {
            String wt = n.wt(str);
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return ar(-1, "fail sdcard not mounted ");
            }
            c wg = wg(wt);
            if (wg == null) {
                if (obj == null) {
                    return ar(-1, "fail TypeError: data argument must be a string, Buffer, ArrayBuffer, Array, or array-like object");
                }
                String wf = wf(wt);
                if (TextUtils.isEmpty(wf)) {
                    return ar(-1, "fail no such file or directory " + str);
                }
                File file = new File(wf);
                if (!file.exists()) {
                    return ar(-1, n.t("fail no such file or directory ", "open", str, null));
                }
                if (file.isDirectory()) {
                    return ar(-1, "fail illegal operation on a directory, open " + str);
                }
                return a(wt, obj, str2, true);
            }
            return wg;
        }
        return T;
    }

    public c an(String str, boolean z) {
        c T = n.T(str, z ? "path must be a string" : n.t("fail no such file or directory ", "access", str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Undefined;");
        if (T == null) {
            String wt = n.wt(str);
            if (!this.dGE.ae(wt, true)) {
                return ar(-4, n.t("fail no such file or directory ", "access", str, null));
            }
            String wf = wf(wt);
            if (TextUtils.isEmpty(wf)) {
                return ar(-1, "fail no such file or directory " + str);
            }
            if (!new File(wf).exists()) {
                return ar(-1, n.t("fail no such file or directory ", "access", str, null));
            }
            return ar(0, "ok");
        }
        return T;
    }

    public c ao(String str, boolean z) {
        c T = n.T(str, z ? "path must be a string" : n.t("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Object;");
        if (T == null) {
            if (!this.dGE.sK(str) && !this.dGE.sJ(str)) {
                return ar(-1, "fail permission denied, open " + str);
            }
            c aj = aj(str, false);
            if (aj == null) {
                j jVar = new j();
                String wf = wf(str);
                if (TextUtils.isEmpty(wf)) {
                    return ar(-1, n.t("fail no such file or directory ", null, str, null));
                }
                File file = new File(wf);
                jVar.gY(file.isDirectory());
                jVar.gZ(file.isFile());
                return a(str, jVar);
            }
            return aj;
        }
        return T;
    }

    private c a(String str, j jVar) {
        String wf = wf(str);
        if (TextUtils.isEmpty(wf)) {
            return ar(-1, "fail no such file or directory " + str);
        }
        File file = new File(wf);
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                jVar.lastAccessedTime = Os.lstat(file.getAbsolutePath()).st_atime;
                jVar.lastModifiedTime = Os.lstat(file.getAbsolutePath()).st_mtime;
                jVar.mode = Os.lstat(file.getAbsolutePath()).st_mode;
                jVar.size = Os.lstat(file.getAbsolutePath()).st_size;
            } catch (Exception e) {
                e.printStackTrace();
                return ar(-1, "fail");
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
                return ar(-1, "fail");
            }
        }
        c ar = ar(0, "ok");
        ar.stats = jVar;
        ar.errMsg = "ok";
        return ar;
    }

    public c aQI() {
        String aGt = this.dGE.aGt();
        String wf = wf(a.USER_DATA_PATH);
        if (TextUtils.isEmpty(wf)) {
            return ar(-1, "path must be a string");
        }
        ArrayList arrayList = new ArrayList();
        for (String str : n.ap(wf, false)) {
            File file = new File(str);
            d dVar = new d();
            dVar.createTime = file.exists() ? file.lastModified() : 0L;
            String absolutePath = file.getAbsolutePath();
            if (file.exists() && !TextUtils.isEmpty(absolutePath) && !TextUtils.isEmpty(aGt) && absolutePath.startsWith(aGt)) {
                dVar.filePath = this.dGE.tb(absolutePath);
            }
            dVar.size = file.exists() ? file.length() : 0L;
            arrayList.add(dVar);
        }
        c ar = ar(0, "ok");
        ar.fileList = arrayList;
        return ar;
    }

    public c wj(String str) {
        c ar;
        c T = n.T(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Object;");
        if (T == null) {
            if (wg(str) != null) {
                return ar(-4, "fail file not exist");
            }
            String wf = wf(str);
            if (TextUtils.isEmpty(wf)) {
                return ar(-1, "fail no such file or directory " + str);
            }
            File file = new File(wf);
            if (!file.exists() || file.isDirectory()) {
                return ar(-1, "fail file not exist");
            }
            long fileSize = n.getFileSize(wf);
            try {
                if (!file.delete()) {
                    ar = ar(-1, "fail");
                } else {
                    this.dGF.bS(-fileSize);
                    ar = ar(0, "ok");
                }
                return ar;
            } catch (Exception e) {
                return ar(-1, "fail");
            }
        }
        return T;
    }

    public c wk(String str) {
        c T = n.T(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Undefined;");
        if (T == null) {
            String wt = n.wt(str);
            if (!this.dGE.ae(wt, true)) {
                return ar(-4, "fail file not exist");
            }
            String wf = wf(wt);
            if (TextUtils.isEmpty(wf)) {
                return ar(-1, "fail no such file or directory " + str);
            }
            File file = new File(wf);
            if (!file.exists()) {
                return ar(-1, "fail file not exist");
            }
            if (file.isDirectory()) {
                return ar(-1, "fail " + str + " is directory");
            }
            c ar = ar(0, "ok");
            ar.size = file.exists() ? file.length() : 0L;
            ar.digest = file.exists() ? com.baidu.swan.c.e.toMd5(file, false) : null;
            return ar;
        }
        return T;
    }

    private String aQJ() {
        String generateFileSizeText = com.baidu.swan.c.d.generateFileSizeText(this.dGF.getMaxSize());
        return String.format("fail file size over %s", (TextUtils.isEmpty(generateFileSizeText) || TextUtils.equals(generateFileSizeText, FileUtils.UNKNOW)) ? "" : "");
    }
}
