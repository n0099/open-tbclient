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
/* loaded from: classes7.dex */
public class f {
    private static List<String> dTj = new ArrayList();
    private String dTk;
    private final com.baidu.swan.apps.storage.b.c dTl;
    private final com.baidu.swan.apps.storage.b.d dTm;
    private Context mContext;

    static {
        dTj.add("ascii");
        dTj.add("base64");
        dTj.add("binary");
        dTj.add("hex");
        dTj.add("utf-8");
        dTj.add("utf8");
        dTj.add("latin1");
        dTj.add("ucs2");
        dTj.add("ucs-2");
        dTj.add("utf16le");
        dTj.add("utf-16le");
    }

    public f(Context context, String str, @NonNull com.baidu.swan.apps.storage.b.c cVar) {
        this.mContext = context;
        this.dTk = str;
        this.dTl = cVar;
        this.dTm = this.dTl.aKg();
    }

    private String wH(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith("bdfile://code")) {
            this.dTk = this.dTk.endsWith(File.separator) ? this.dTk.substring(0, this.dTk.length() - 1) : this.dTk;
            return this.dTk + str.substring("bdfile://code".length());
        } else if (str.startsWith("bdfile://")) {
            return this.dTl.tC(str);
        } else {
            return "";
        }
    }

    private c wI(String str) {
        c ax = ax(-1, "fail permission denied, open " + str);
        if (!TextUtils.isEmpty(str) && str.startsWith(a.USER_DATA_PATH)) {
            return null;
        }
        return ax;
    }

    private c ax(int i, String str) {
        c cVar = new c();
        cVar.errCode = i;
        cVar.errMsg = str;
        return cVar;
    }

    private c al(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            c cVar = new c();
            cVar.errCode = -1;
            cVar.errMsg = "fail no such file or directory " + str;
            return cVar;
        }
        String wH = wH(str);
        if (TextUtils.isEmpty(str)) {
            c cVar2 = new c();
            cVar2.errCode = -1;
            cVar2.errMsg = "fail no such file or directory " + str;
            return cVar2;
        }
        File file = new File(wH);
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

    private c am(String str, boolean z) {
        if (str.endsWith(File.separator)) {
            str = str.substring(0, str.length() - 1);
        }
        String wH = wH(str);
        if (TextUtils.isEmpty(wH)) {
            return ax(-1, "fail no such file or directory " + str);
        }
        if (wH.contains(File.separator)) {
            File file = new File(wH.substring(0, wH.lastIndexOf(File.separator)));
            if (!z && (!file.exists() || (file.exists() && file.isFile()))) {
                return ax(-1, "fail no such file or directory " + str);
            }
        }
        return null;
    }

    public c b(String str, boolean z, boolean z2) {
        boolean mkdir;
        c aa = n.aa(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (aa == null) {
            c wI = wI(str);
            if (wI == null) {
                if (!n.wN(str)) {
                    return ax(-4, "fail permission denied, open " + str);
                }
                String wH = wH(str);
                if (TextUtils.isEmpty(wH)) {
                    return ax(-1, "fail no such file or directory " + str);
                }
                c am = am(str, z);
                if (am == null) {
                    File file = new File(wH);
                    if (file.exists()) {
                        return ax(-1, "fail file already exists " + str);
                    }
                    try {
                        if (z) {
                            mkdir = file.mkdirs();
                        } else {
                            mkdir = file.mkdir();
                        }
                        if (!mkdir) {
                            return ax(-1, "fail");
                        }
                        return ax(0, "ok");
                    } catch (Exception e) {
                        return ax(-1, "fail");
                    }
                }
                return am;
            }
            return wI;
        }
        return aa;
    }

    public c a(boolean z, String str, Object obj, String str2) {
        c aa = n.aa(str, z ? "filePath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        return aa != null ? aa : a(str, obj, str2, false);
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
        c wI = wI(str);
        if (wI != null) {
            return wI;
        }
        if (obj == null) {
            return ax(-1, "The argument must be string or arrayBuffer");
        }
        int length = (a.USER_DATA_PATH + File.separator).length();
        if (n.wN(str)) {
            boolean z2 = obj instanceof byte[];
            if (!z2 && TextUtils.isEmpty(str2)) {
                str2 = "utf-8";
            }
            if (!TextUtils.isEmpty(str2)) {
                if ("binary".equals(str2.toLowerCase())) {
                    str2 = "latin1";
                }
                if (!dTj.contains(str2.toLowerCase())) {
                    return ax(-1, "fail invalid encoding \"" + str2 + "\"");
                }
            }
            BufferedWriter bufferedWriter3 = null;
            Closeable closeable = null;
            c am = am(str, false);
            if (am == null) {
                String wH = wH(str);
                if (TextUtils.isEmpty(wH)) {
                    return ax(-1, "fail no such file or directory " + str.substring(length));
                }
                long j = 0;
                if (!z2 && !TextUtils.isEmpty((String) obj)) {
                    j = ((String) obj).getBytes().length;
                } else if (z2) {
                    j = ((byte[]) obj).length;
                }
                if (this.dTl.aKg().cr(j)) {
                    return ax(-1, aUv());
                }
                File file = new File(wH);
                if (file.exists() && file.isDirectory()) {
                    return ax(-1, " fail illegal operation on a directory, open " + str);
                }
                long length2 = file.length();
                c ax = ax(0, "ok");
                try {
                    if (z2) {
                        byte[] bArr = (byte[]) obj;
                        FileOutputStream fileOutputStream2 = new FileOutputStream(wH, z);
                        try {
                            fileOutputStream2.write(bArr);
                            fileOutputStream2.flush();
                            bufferedWriter2 = null;
                            r2 = fileOutputStream2;
                        } catch (Exception e) {
                            fileOutputStream = fileOutputStream2;
                            bufferedWriter = null;
                            c ax2 = ax(-1, "fail");
                            com.baidu.swan.c.d.closeSafely(bufferedWriter);
                            com.baidu.swan.c.d.closeSafely(fileOutputStream);
                            return ax2;
                        } catch (Throwable th) {
                            closeable = fileOutputStream2;
                            th = th;
                            com.baidu.swan.c.d.closeSafely(bufferedWriter3);
                            com.baidu.swan.c.d.closeSafely(closeable);
                            throw th;
                        }
                    } else if (TextUtils.isEmpty((String) obj) || !TextUtils.equals("base64", str2)) {
                        String[] da = n.da((String) obj, str2);
                        if (da == null || da.length != 2) {
                            str3 = "utf-8";
                            str4 = "";
                        } else {
                            String str5 = da[0];
                            str3 = da[1];
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
                                c ax22 = ax(-1, "fail");
                                com.baidu.swan.c.d.closeSafely(bufferedWriter);
                                com.baidu.swan.c.d.closeSafely(fileOutputStream);
                                return ax22;
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
                            c ax222 = ax(-1, "fail");
                            com.baidu.swan.c.d.closeSafely(bufferedWriter);
                            com.baidu.swan.c.d.closeSafely(fileOutputStream);
                            return ax222;
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
                        this.dTm.cq(j);
                    } else {
                        this.dTm.cq(j - length2);
                    }
                    com.baidu.swan.c.d.closeSafely(bufferedWriter2);
                    com.baidu.swan.c.d.closeSafely(r2);
                    r2 = ax;
                    return r2;
                } catch (Exception e5) {
                    fileOutputStream = r2;
                    bufferedWriter = bufferedWriter2;
                    c ax2222 = ax(-1, "fail");
                    com.baidu.swan.c.d.closeSafely(bufferedWriter);
                    com.baidu.swan.c.d.closeSafely(fileOutputStream);
                    return ax2222;
                } catch (Throwable th6) {
                    bufferedWriter3 = bufferedWriter2;
                    closeable = r2;
                    th = th6;
                    com.baidu.swan.c.d.closeSafely(bufferedWriter3);
                    com.baidu.swan.c.d.closeSafely(closeable);
                    throw th;
                }
            }
            return am;
        }
        return ax(-4, "fail permission denied, open " + str.substring(length));
    }

    public c an(String str, boolean z) {
        c ax;
        c aa = n.aa(str, z ? "filePath must be a string" : n.u("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of Object;");
        if (aa == null) {
            if (!n.wO(str)) {
                return ax(-4, n.u("fail permission denied, open ", null, str, null));
            }
            c al = al(str, false);
            if (al == null) {
                c wI = wI(str);
                if (wI == null) {
                    String wH = wH(str);
                    if (TextUtils.isEmpty(wH)) {
                        return ax(-1, n.u("fail no such file or directory ", null, str, null));
                    }
                    File file = new File(wH);
                    if (file.isDirectory()) {
                        return ax(-1, n.u("fail operation not permitted ", "unlink", str, null));
                    }
                    long fileSize = n.getFileSize(wH);
                    try {
                        if (file.delete()) {
                            this.dTm.cq(-fileSize);
                            ax = ax(0, "ok");
                        } else {
                            ax = ax(-1, n.u("fail", null, str, null));
                        }
                        return ax;
                    } catch (Exception e) {
                        return ax(-1, n.u("fail", null, str, null));
                    }
                }
                return wI;
            }
            return al;
        }
        return aa;
    }

    public c cW(String str, String str2) {
        c aa = n.aa(str, n.f("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true), "fail parameter error: parameter.zipFilePath should be String instead of Object;");
        if (aa == null) {
            c aa2 = n.aa(str2, n.f("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true), "fail parameter error: parameter.targetPath should be String instead of Object;");
            if (aa2 == null) {
                if (!str2.startsWith("bdfile://tmp") && !str2.startsWith(a.USER_DATA_PATH)) {
                    return ax(-1, "fail permission denied, open " + str2);
                }
                String wV = n.wV(str);
                if (!this.dTl.ag(wV, true)) {
                    return ax(-4, n.f("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (!n.wN(str2)) {
                    return ax(-4, n.f("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (wJ(str2)) {
                    return ax(-1, n.f("fail permission denied, ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                String wH = wH(wV);
                String wH2 = wH(str2);
                if (TextUtils.isEmpty(wH)) {
                    return ax(-1, n.f("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (TextUtils.isEmpty(wH2)) {
                    return ax(-1, n.f("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                File file = new File(wH);
                if (!file.exists()) {
                    return ax(-1, n.f("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (!wH.endsWith(".zip")) {
                    return ax(-1, "fail unzip failed");
                }
                if (!file.isFile()) {
                    return ax(-1, n.f("fail permission denied, ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                File file2 = new File(wH2);
                if (!file2.exists()) {
                    file2.mkdirs();
                } else if (file2.isFile()) {
                    return ax(-1, "fail unzip failed");
                }
                List<String> ar = n.ar(wH2, true);
                if (!com.baidu.swan.c.d.unzipFile(wH, wH2)) {
                    return ax(-1, "fail unzip failed");
                }
                if (str2.startsWith(a.USER_DATA_PATH)) {
                    List<String> ar2 = n.ar(wH2, true);
                    ArrayList arrayList = new ArrayList(ar2.size());
                    long j = 0;
                    for (String str3 : ar2) {
                        if (!ar.contains(str3)) {
                            arrayList.add(str3);
                            j = n.getFileSize(str3) + j;
                        }
                    }
                    if (this.dTm.cr(j)) {
                        n.aT(arrayList);
                        return ax(-1, aUv());
                    }
                    this.dTm.cq(j);
                }
                return ax(0, "ok");
            }
            return aa2;
        }
        return aa;
    }

    private boolean wJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains(File.separator)) {
            return wK(str.substring(str.lastIndexOf(File.separator) + 1));
        }
        return wK(str);
    }

    private boolean wK(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(".")) {
            return false;
        }
        String[] split = str.split("\\.");
        return (split.length != 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) ? false : true;
    }

    public c r(String str, String str2, boolean z) {
        c aa = n.aa(str, z ? "tempFilePath must be a string" : "fail tempFilePath file not exist", z ? " The argument must be string" : "fail parameter error: parameter.tempFilePath should be String instead of Object;");
        if (aa == null) {
            String wV = n.wV(str2);
            if (TextUtils.isEmpty(wV)) {
                wV = a.USER_DATA_PATH + File.separator + com.baidu.swan.c.d.getFileNameFromPath(str);
            }
            if (!wV.startsWith(a.USER_DATA_PATH)) {
                return ax(-1, n.u("fail permission denied, open ", null, str2, null));
            }
            if (!this.dTl.tm(str)) {
                return ax(-4, "fail it is not a tempFilePath");
            }
            c am = am(wV, false);
            if (am != null) {
                return am;
            }
            c am2 = am(str, false);
            if (am2 != null) {
                return am2;
            }
            String wH = wH(wV);
            if (TextUtils.isEmpty(wH)) {
                return ax(-1, "fail no such file or directory " + str2);
            }
            File file = new File(wH);
            if (a.USER_DATA_PATH.equals(wV) || (file.exists() && file.isDirectory())) {
                return ax(-1, n.u("fail Error: EISDIR: illegal operation on a directory, open ", null, str2, null));
            }
            c al = al(str, true);
            if (al != null) {
                al.errMsg = "fail no such file or directory ";
                return al;
            }
            String wH2 = wH(str);
            if (TextUtils.isEmpty(wH2)) {
                return ax(-1, "fail no such file or directory " + str);
            }
            long fileSize = n.getFileSize(wH2);
            if (this.dTm.cr(fileSize)) {
                return ax(-1, aUv());
            }
            if (!wV.startsWith(a.USER_DATA_PATH) || n.wP(wV)) {
                return ax(-1, n.u("fail permission denied, open ", null, str2, null));
            }
            c am3 = am(wV, false);
            if (am3 != null) {
                return am3;
            }
            c wI = wI(wV);
            if (wI != null) {
                return wI;
            }
            c cX = cX(str, wV);
            if (cX != null && cX.errCode == 0) {
                this.dTm.cq(fileSize);
                if (TextUtils.isEmpty(str)) {
                    return ax(-1, n.u("fail no such file or directory ", null, str, null));
                }
                File file2 = new File(wH2);
                if (file2.exists()) {
                    file2.delete();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(wV);
                cX.result = arrayList;
                cX.errMsg = "ok";
            }
            return cX;
        }
        return aa;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [813=4] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v11, resolved type: java.io.FileOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private c cX(String str, String str2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream3 = null;
        String wH = wH(str);
        String wH2 = wH(str2);
        if (TextUtils.isEmpty(wH)) {
            return ax(-1, n.u("fail no such file or directory ", null, str, null));
        }
        if (TextUtils.isEmpty(wH2)) {
            return ax(-1, n.u("fail no such file or directory ", null, str2, null));
        }
        c ax = ax(0, "ok");
        try {
            File file = new File(wH2);
            fileInputStream = new FileInputStream(new File(wH));
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
                ax.errMsg = "fail";
                ax.errCode = -1;
                return ax;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            ax.result = arrayList;
            return ax;
        } catch (IOException e3) {
            e = e3;
            fileInputStream3 = fileInputStream;
            fileInputStream2 = fileOutputStream;
            try {
                e.printStackTrace();
                c ax2 = ax(-1, "fail");
                com.baidu.swan.c.d.closeSafely(fileInputStream3);
                com.baidu.swan.c.d.closeSafely(fileInputStream2);
                if (TextUtils.isEmpty("")) {
                    ax.errMsg = "fail";
                    ax.errCode = -1;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(str2);
                    ax.result = arrayList2;
                }
                return ax2;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream3;
                fileInputStream3 = fileInputStream2;
                com.baidu.swan.c.d.closeSafely(fileInputStream);
                com.baidu.swan.c.d.closeSafely(fileInputStream3);
                if (TextUtils.isEmpty("")) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(str2);
                    ax.result = arrayList3;
                } else {
                    ax.errMsg = "fail";
                    ax.errCode = -1;
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

    public c ao(String str, boolean z) {
        c aa = n.aa(str, z ? "dirPath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (aa == null) {
            String wV = n.wV(str);
            if (!n.wO(wV)) {
                return ax(-4, "fail permission denied, open " + str);
            }
            String wH = wH(wV);
            if (TextUtils.isEmpty(wH)) {
                return ax(-1, "fail no such file or directory " + str);
            }
            File file = new File(wH);
            if (!file.exists()) {
                return ax(-1, "fail no such file or directory " + str);
            }
            if (!file.isDirectory()) {
                return ax(-1, "fail no such file or directory " + str);
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
            c ax = ax(0, "ok");
            ax.result = arrayList;
            return ax;
        }
        return aa;
    }

    public c c(String str, boolean z, boolean z2) {
        boolean deleteFile;
        c aa = n.aa(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (aa == null) {
            c wI = wI(str);
            if (wI == null) {
                if (!n.wO(str)) {
                    return ax(-4, "fail permission denied, open " + str);
                }
                String wH = wH(str);
                if (TextUtils.isEmpty(wH)) {
                    return ax(-1, "fail no such file or directory " + str);
                }
                File file = new File(wH);
                if (!file.exists() || file.isFile()) {
                    return ax(-1, "fail no such file or directory " + str);
                }
                boolean d = d(file.listFiles());
                try {
                    if (!z && d) {
                        return ax(-1, "fail directory not empty ");
                    }
                    if (!z) {
                        deleteFile = file.delete();
                    } else {
                        deleteFile = com.baidu.swan.c.d.deleteFile(file);
                    }
                    if (!deleteFile) {
                        return ax(-1, "fail");
                    }
                    return ax(0, "ok");
                } catch (Exception e) {
                    return ax(-1, "fail");
                }
            }
            return wI;
        }
        return aa;
    }

    private boolean d(File[] fileArr) {
        return (fileArr == null || fileArr.length == 0) ? false : true;
    }

    public c s(String str, String str2, boolean z) {
        c aa = n.aa(str, z ? "filePath must be a string" : "fail file not found", z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of NULL;");
        if (aa == null) {
            String wV = n.wV(str);
            if (!this.dTl.ag(wV, true)) {
                return ax(-1, "fail permission denied, open " + str);
            }
            c al = al(wV, true);
            if (al != null) {
                al.errMsg = n.u("fail no such file or directory ", "open", str, null);
                return al;
            }
            boolean isEmpty = TextUtils.isEmpty(str2);
            if (!isEmpty) {
                str2 = str2.toLowerCase();
                if ("binary".equals(str2)) {
                    str2 = "latin1";
                }
            }
            if (!isEmpty && !dTj.contains(str2)) {
                return ax(-1, "fail Error: Unknown encoding: " + str2);
            }
            String wH = wH(wV);
            if (TextUtils.isEmpty(wH)) {
                return ax(-1, "fail no such file or directory " + str);
            }
            File file = new File(wH);
            String str3 = "";
            byte[] bArr = new byte[0];
            c ax = ax(0, "ok");
            try {
                if (TextUtils.isEmpty(str2)) {
                    bArr = n.wW(wH);
                } else if ("base64".equals(str2)) {
                    byte[] wW = n.wW(wH);
                    str3 = wW.length == 0 ? "" : Base64.encodeToString(wW, 2);
                    bArr = wW;
                } else if ("hex".equals(str2)) {
                    str3 = n.wR(wH);
                } else {
                    str3 = a(new FileInputStream(file), str2);
                }
                if (TextUtils.isEmpty(str2)) {
                    ax.dSq = bArr;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str3);
                    ax.result = arrayList;
                }
                return ax;
            } catch (Exception e) {
                e.printStackTrace();
                return ax(-1, "fail");
            }
        }
        return aa;
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

    public c t(String str, String str2, boolean z) {
        c aa = n.aa(str, z ? "oldPath must be a string" : n.u("fail no such file or directory ", "rename", str, null), z ? " The argument must be string" : "fail parameter error: parameter.oldPath should be String instead of Undefined;");
        if (aa == null) {
            c aa2 = n.aa(str2, z ? "newPath must be a string" : n.u("fail no such file or directory ", "rename", str2, null), z ? " The argument must be string" : "fail parameter error: parameter.newPath should be String instead of Undefined;");
            if (aa2 == null) {
                String wV = n.wV(str);
                c wI = wI(wV);
                if (wI != null) {
                    wI.errMsg = n.u("fail permission denied, ", "rename", str, str2);
                    return wI;
                }
                String wV2 = n.wV(str2);
                c wI2 = wI(wV2);
                if (wI2 != null) {
                    wI2.errMsg = n.u("fail permission denied, ", "rename", str, str2);
                    return wI2;
                }
                c al = al(wV, false);
                if (al != null) {
                    al.errMsg = n.u("fail no such file or directory ", "rename", str, str2);
                    return al;
                } else if (!n.wN(wV) || !n.wN(wV2)) {
                    return ax(-4, n.u("fail permission denied, ", "rename", str, str2));
                } else {
                    c am = am(wV2, false);
                    if (am != null) {
                        am.errMsg = n.u("fail no such file or directory ", "rename", str, str2);
                        return am;
                    }
                    String wH = wH(wV);
                    if (TextUtils.isEmpty(wH)) {
                        return ax(-1, "fail no such file or directory " + str);
                    }
                    String wH2 = wH(wV2);
                    if (TextUtils.isEmpty(wH2)) {
                        return ax(-1, "fail no such file or directory " + str2);
                    }
                    File file = new File(wH);
                    File file2 = new File(wH2);
                    boolean exists = file2.exists();
                    if (!n.k(file, file2) || (file.isDirectory() && !exists && wJ(wH2))) {
                        return ax(-1, "fail rename failed");
                    }
                    try {
                        if ((file2.isDirectory() && file2.listFiles() != null && file2.listFiles().length > 0) || !file.renameTo(file2)) {
                            return ax(-1, "fail rename failed");
                        }
                        return ax(0, "ok");
                    } catch (Exception e) {
                        return ax(-1, "fail");
                    }
                }
            }
            return aa2;
        }
        return aa;
    }

    public c u(String str, String str2, boolean z) {
        boolean z2 = true;
        c aa = n.aa(str, "srcPath must be a string", " The argument must be string");
        if (aa == null) {
            c aa2 = n.aa(str2, "destPath must be a string", " The argument must be string");
            if (aa2 == null) {
                String wV = n.wV(str);
                if (!this.dTl.ag(wV, true)) {
                    return ax(-4, n.u("fail no such file or directory ", "copyFile", str, null));
                }
                String wV2 = n.wV(str2);
                if (!n.wN(wV2)) {
                    return ax(-4, n.u("fail permission denied, open ", "copyFile", str2, null));
                }
                c wI = wI(wV2);
                if (wI == null) {
                    String wH = wH(wV);
                    if (TextUtils.isEmpty(wH)) {
                        return ax(-1, "fail no such file or directory " + str);
                    }
                    File file = new File(wH);
                    if (!file.exists() || !file.isFile()) {
                        return ax(-1, n.u("fail no such file or directory ", "copyFile", str, null));
                    }
                    c am = am(wV2, false);
                    if (am != null) {
                        am.errMsg = n.u("fail no such file or directory ", "copyFile", str2, null);
                        return am;
                    } else if (wV2.endsWith(File.separator)) {
                        return ax(-1, n.u("fail permission denied, ", "copyFile", str, str2));
                    } else {
                        String wH2 = wH(wV2);
                        if (TextUtils.isEmpty(wH2)) {
                            return ax(-1, "fail no such file or directory " + str2);
                        }
                        File file2 = new File(wH2);
                        if (file2.exists() && file2.isDirectory()) {
                            if (d(file2.listFiles())) {
                                return ax(-1, n.u("fail permission denied, ", "copyFile", str, str2));
                            }
                            try {
                                file2.delete();
                            } catch (Exception e) {
                                return ax(-1, "fail");
                            }
                        }
                        long fileSize = n.getFileSize(wH);
                        if (wV.equals(wV2) || wV.startsWith(a.USER_DATA_PATH)) {
                            z2 = false;
                        }
                        if (z2 && this.dTm.cr(fileSize)) {
                            return ax(-1, aUv());
                        }
                        c cX = !wV.equals(wV2) ? cX(wV, wV2) : ax(0, "ok");
                        if (z2 && cX != null && cX.errCode == 0) {
                            this.dTm.cq(fileSize);
                            return cX;
                        }
                        return cX;
                    }
                }
                return wI;
            }
            return aa2;
        }
        return aa;
    }

    public c b(String str, Object obj, String str2, boolean z) {
        c aa = n.aa(str, n.u("fail permission denied, open ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of NULL;");
        if (aa == null) {
            String wV = n.wV(str);
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return ax(-1, "fail sdcard not mounted ");
            }
            c wI = wI(wV);
            if (wI == null) {
                if (obj == null) {
                    return ax(-1, "fail TypeError: data argument must be a string, Buffer, ArrayBuffer, Array, or array-like object");
                }
                String wH = wH(wV);
                if (TextUtils.isEmpty(wH)) {
                    return ax(-1, "fail no such file or directory " + str);
                }
                File file = new File(wH);
                if (!file.exists()) {
                    return ax(-1, n.u("fail no such file or directory ", "open", str, null));
                }
                if (file.isDirectory()) {
                    return ax(-1, "fail illegal operation on a directory, open " + str);
                }
                return a(wV, obj, str2, true);
            }
            return wI;
        }
        return aa;
    }

    public c ap(String str, boolean z) {
        c aa = n.aa(str, z ? "path must be a string" : n.u("fail no such file or directory ", "access", str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Undefined;");
        if (aa == null) {
            String wV = n.wV(str);
            if (!this.dTl.ag(wV, true)) {
                return ax(-4, n.u("fail no such file or directory ", "access", str, null));
            }
            String wH = wH(wV);
            if (TextUtils.isEmpty(wH)) {
                return ax(-1, "fail no such file or directory " + str);
            }
            if (!new File(wH).exists()) {
                return ax(-1, n.u("fail no such file or directory ", "access", str, null));
            }
            return ax(0, "ok");
        }
        return aa;
    }

    public c aq(String str, boolean z) {
        c aa = n.aa(str, z ? "path must be a string" : n.u("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Object;");
        if (aa == null) {
            if (!this.dTl.tm(str) && !this.dTl.tl(str)) {
                return ax(-1, "fail permission denied, open " + str);
            }
            c al = al(str, false);
            if (al == null) {
                j jVar = new j();
                String wH = wH(str);
                if (TextUtils.isEmpty(wH)) {
                    return ax(-1, n.u("fail no such file or directory ", null, str, null));
                }
                File file = new File(wH);
                jVar.hx(file.isDirectory());
                jVar.hy(file.isFile());
                return a(str, jVar);
            }
            return al;
        }
        return aa;
    }

    private c a(String str, j jVar) {
        String wH = wH(str);
        if (TextUtils.isEmpty(wH)) {
            return ax(-1, "fail no such file or directory " + str);
        }
        File file = new File(wH);
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                jVar.lastAccessedTime = Os.lstat(file.getAbsolutePath()).st_atime;
                jVar.lastModifiedTime = Os.lstat(file.getAbsolutePath()).st_mtime;
                jVar.mode = Os.lstat(file.getAbsolutePath()).st_mode;
                jVar.size = Os.lstat(file.getAbsolutePath()).st_size;
            } catch (Exception e) {
                e.printStackTrace();
                return ax(-1, "fail");
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
                return ax(-1, "fail");
            }
        }
        c ax = ax(0, "ok");
        ax.stats = jVar;
        ax.errMsg = "ok";
        return ax;
    }

    public c aUu() {
        String aKf = this.dTl.aKf();
        String wH = wH(a.USER_DATA_PATH);
        if (TextUtils.isEmpty(wH)) {
            return ax(-1, "path must be a string");
        }
        ArrayList arrayList = new ArrayList();
        for (String str : n.ar(wH, false)) {
            File file = new File(str);
            d dVar = new d();
            dVar.createTime = file.exists() ? file.lastModified() : 0L;
            String absolutePath = file.getAbsolutePath();
            if (file.exists() && !TextUtils.isEmpty(absolutePath) && !TextUtils.isEmpty(aKf) && absolutePath.startsWith(aKf)) {
                dVar.filePath = this.dTl.tD(absolutePath);
            }
            dVar.size = file.exists() ? file.length() : 0L;
            arrayList.add(dVar);
        }
        c ax = ax(0, "ok");
        ax.fileList = arrayList;
        return ax;
    }

    public c wL(String str) {
        c ax;
        c aa = n.aa(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Object;");
        if (aa == null) {
            if (wI(str) != null) {
                return ax(-4, "fail file not exist");
            }
            String wH = wH(str);
            if (TextUtils.isEmpty(wH)) {
                return ax(-1, "fail no such file or directory " + str);
            }
            File file = new File(wH);
            if (!file.exists() || file.isDirectory()) {
                return ax(-1, "fail file not exist");
            }
            long fileSize = n.getFileSize(wH);
            try {
                if (!file.delete()) {
                    ax = ax(-1, "fail");
                } else {
                    this.dTm.cq(-fileSize);
                    ax = ax(0, "ok");
                }
                return ax;
            } catch (Exception e) {
                return ax(-1, "fail");
            }
        }
        return aa;
    }

    public c wM(String str) {
        c aa = n.aa(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Undefined;");
        if (aa == null) {
            String wV = n.wV(str);
            if (!this.dTl.ag(wV, true)) {
                return ax(-4, "fail file not exist");
            }
            String wH = wH(wV);
            if (TextUtils.isEmpty(wH)) {
                return ax(-1, "fail no such file or directory " + str);
            }
            File file = new File(wH);
            if (!file.exists()) {
                return ax(-1, "fail file not exist");
            }
            if (file.isDirectory()) {
                return ax(-1, "fail " + str + " is directory");
            }
            c ax = ax(0, "ok");
            ax.size = file.exists() ? file.length() : 0L;
            ax.digest = file.exists() ? com.baidu.swan.c.e.toMd5(file, false) : null;
            return ax;
        }
        return aa;
    }

    private String aUv() {
        String generateFileSizeText = com.baidu.swan.c.d.generateFileSizeText(this.dTm.getMaxSize());
        return String.format("fail file size over %s", (TextUtils.isEmpty(generateFileSizeText) || TextUtils.equals(generateFileSizeText, FileUtils.UNKNOW)) ? "" : "");
    }
}
