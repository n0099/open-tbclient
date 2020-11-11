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
    private static List<String> dUR = new ArrayList();
    private String dUS;
    private final com.baidu.swan.apps.storage.b.c dUT;
    private final com.baidu.swan.apps.storage.b.d dUU;
    private Context mContext;

    static {
        dUR.add("ascii");
        dUR.add("base64");
        dUR.add("binary");
        dUR.add("hex");
        dUR.add("utf-8");
        dUR.add("utf8");
        dUR.add("latin1");
        dUR.add("ucs2");
        dUR.add("ucs-2");
        dUR.add("utf16le");
        dUR.add("utf-16le");
    }

    public f(Context context, String str, @NonNull com.baidu.swan.apps.storage.b.c cVar) {
        this.mContext = context;
        this.dUS = str;
        this.dUT = cVar;
        this.dUU = this.dUT.aKO();
    }

    private String wM(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith("bdfile://code")) {
            this.dUS = this.dUS.endsWith(File.separator) ? this.dUS.substring(0, this.dUS.length() - 1) : this.dUS;
            return this.dUS + str.substring("bdfile://code".length());
        } else if (str.startsWith("bdfile://")) {
            return this.dUT.tH(str);
        } else {
            return "";
        }
    }

    private c wN(String str) {
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
        String wM = wM(str);
        if (TextUtils.isEmpty(str)) {
            c cVar2 = new c();
            cVar2.errCode = -1;
            cVar2.errMsg = "fail no such file or directory " + str;
            return cVar2;
        }
        File file = new File(wM);
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
        String wM = wM(str);
        if (TextUtils.isEmpty(wM)) {
            return ax(-1, "fail no such file or directory " + str);
        }
        if (wM.contains(File.separator)) {
            File file = new File(wM.substring(0, wM.lastIndexOf(File.separator)));
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
            c wN = wN(str);
            if (wN == null) {
                if (!n.wS(str)) {
                    return ax(-4, "fail permission denied, open " + str);
                }
                String wM = wM(str);
                if (TextUtils.isEmpty(wM)) {
                    return ax(-1, "fail no such file or directory " + str);
                }
                c am = am(str, z);
                if (am == null) {
                    File file = new File(wM);
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
            return wN;
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
        c wN = wN(str);
        if (wN != null) {
            return wN;
        }
        if (obj == null) {
            return ax(-1, "The argument must be string or arrayBuffer");
        }
        int length = (a.USER_DATA_PATH + File.separator).length();
        if (n.wS(str)) {
            boolean z2 = obj instanceof byte[];
            if (!z2 && TextUtils.isEmpty(str2)) {
                str2 = "utf-8";
            }
            if (!TextUtils.isEmpty(str2)) {
                if ("binary".equals(str2.toLowerCase())) {
                    str2 = "latin1";
                }
                if (!dUR.contains(str2.toLowerCase())) {
                    return ax(-1, "fail invalid encoding \"" + str2 + "\"");
                }
            }
            BufferedWriter bufferedWriter3 = null;
            Closeable closeable = null;
            c am = am(str, false);
            if (am == null) {
                String wM = wM(str);
                if (TextUtils.isEmpty(wM)) {
                    return ax(-1, "fail no such file or directory " + str.substring(length));
                }
                long j = 0;
                if (!z2 && !TextUtils.isEmpty((String) obj)) {
                    j = ((String) obj).getBytes().length;
                } else if (z2) {
                    j = ((byte[]) obj).length;
                }
                if (this.dUT.aKO().cr(j)) {
                    return ax(-1, aVd());
                }
                File file = new File(wM);
                if (file.exists() && file.isDirectory()) {
                    return ax(-1, " fail illegal operation on a directory, open " + str);
                }
                long length2 = file.length();
                c ax = ax(0, "ok");
                try {
                    if (z2) {
                        byte[] bArr = (byte[]) obj;
                        FileOutputStream fileOutputStream2 = new FileOutputStream(wM, z);
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
                        String[] db = n.db((String) obj, str2);
                        if (db == null || db.length != 2) {
                            str3 = "utf-8";
                            str4 = "";
                        } else {
                            String str5 = db[0];
                            str3 = db[1];
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
                        this.dUU.cq(j);
                    } else {
                        this.dUU.cq(j - length2);
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
            if (!n.wT(str)) {
                return ax(-4, n.u("fail permission denied, open ", null, str, null));
            }
            c al = al(str, false);
            if (al == null) {
                c wN = wN(str);
                if (wN == null) {
                    String wM = wM(str);
                    if (TextUtils.isEmpty(wM)) {
                        return ax(-1, n.u("fail no such file or directory ", null, str, null));
                    }
                    File file = new File(wM);
                    if (file.isDirectory()) {
                        return ax(-1, n.u("fail operation not permitted ", "unlink", str, null));
                    }
                    long fileSize = n.getFileSize(wM);
                    try {
                        if (file.delete()) {
                            this.dUU.cq(-fileSize);
                            ax = ax(0, "ok");
                        } else {
                            ax = ax(-1, n.u("fail", null, str, null));
                        }
                        return ax;
                    } catch (Exception e) {
                        return ax(-1, n.u("fail", null, str, null));
                    }
                }
                return wN;
            }
            return al;
        }
        return aa;
    }

    public c cX(String str, String str2) {
        c aa = n.aa(str, n.f("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true), "fail parameter error: parameter.zipFilePath should be String instead of Object;");
        if (aa == null) {
            c aa2 = n.aa(str2, n.f("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true), "fail parameter error: parameter.targetPath should be String instead of Object;");
            if (aa2 == null) {
                if (!str2.startsWith("bdfile://tmp") && !str2.startsWith(a.USER_DATA_PATH)) {
                    return ax(-1, "fail permission denied, open " + str2);
                }
                String xa = n.xa(str);
                if (!this.dUT.ag(xa, true)) {
                    return ax(-4, n.f("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (!n.wS(str2)) {
                    return ax(-4, n.f("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (wO(str2)) {
                    return ax(-1, n.f("fail permission denied, ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                String wM = wM(xa);
                String wM2 = wM(str2);
                if (TextUtils.isEmpty(wM)) {
                    return ax(-1, n.f("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (TextUtils.isEmpty(wM2)) {
                    return ax(-1, n.f("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                File file = new File(wM);
                if (!file.exists()) {
                    return ax(-1, n.f("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (!wM.endsWith(".zip")) {
                    return ax(-1, "fail unzip failed");
                }
                if (!file.isFile()) {
                    return ax(-1, n.f("fail permission denied, ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                File file2 = new File(wM2);
                if (!file2.exists()) {
                    file2.mkdirs();
                } else if (file2.isFile()) {
                    return ax(-1, "fail unzip failed");
                }
                List<String> ar = n.ar(wM2, true);
                if (!com.baidu.swan.c.d.unzipFile(wM, wM2)) {
                    return ax(-1, "fail unzip failed");
                }
                if (str2.startsWith(a.USER_DATA_PATH)) {
                    List<String> ar2 = n.ar(wM2, true);
                    ArrayList arrayList = new ArrayList(ar2.size());
                    long j = 0;
                    for (String str3 : ar2) {
                        if (!ar.contains(str3)) {
                            arrayList.add(str3);
                            j = n.getFileSize(str3) + j;
                        }
                    }
                    if (this.dUU.cr(j)) {
                        n.aT(arrayList);
                        return ax(-1, aVd());
                    }
                    this.dUU.cq(j);
                }
                return ax(0, "ok");
            }
            return aa2;
        }
        return aa;
    }

    private boolean wO(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains(File.separator)) {
            return wP(str.substring(str.lastIndexOf(File.separator) + 1));
        }
        return wP(str);
    }

    private boolean wP(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(".")) {
            return false;
        }
        String[] split = str.split("\\.");
        return (split.length != 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) ? false : true;
    }

    public c r(String str, String str2, boolean z) {
        c aa = n.aa(str, z ? "tempFilePath must be a string" : "fail tempFilePath file not exist", z ? " The argument must be string" : "fail parameter error: parameter.tempFilePath should be String instead of Object;");
        if (aa == null) {
            String xa = n.xa(str2);
            if (TextUtils.isEmpty(xa)) {
                xa = a.USER_DATA_PATH + File.separator + com.baidu.swan.c.d.getFileNameFromPath(str);
            }
            if (!xa.startsWith(a.USER_DATA_PATH)) {
                return ax(-1, n.u("fail permission denied, open ", null, str2, null));
            }
            if (!this.dUT.tr(str)) {
                return ax(-4, "fail it is not a tempFilePath");
            }
            c am = am(xa, false);
            if (am != null) {
                return am;
            }
            c am2 = am(str, false);
            if (am2 != null) {
                return am2;
            }
            String wM = wM(xa);
            if (TextUtils.isEmpty(wM)) {
                return ax(-1, "fail no such file or directory " + str2);
            }
            File file = new File(wM);
            if (a.USER_DATA_PATH.equals(xa) || (file.exists() && file.isDirectory())) {
                return ax(-1, n.u("fail Error: EISDIR: illegal operation on a directory, open ", null, str2, null));
            }
            c al = al(str, true);
            if (al != null) {
                al.errMsg = "fail no such file or directory ";
                return al;
            }
            String wM2 = wM(str);
            if (TextUtils.isEmpty(wM2)) {
                return ax(-1, "fail no such file or directory " + str);
            }
            long fileSize = n.getFileSize(wM2);
            if (this.dUU.cr(fileSize)) {
                return ax(-1, aVd());
            }
            if (!xa.startsWith(a.USER_DATA_PATH) || n.wU(xa)) {
                return ax(-1, n.u("fail permission denied, open ", null, str2, null));
            }
            c am3 = am(xa, false);
            if (am3 != null) {
                return am3;
            }
            c wN = wN(xa);
            if (wN != null) {
                return wN;
            }
            c cY = cY(str, xa);
            if (cY != null && cY.errCode == 0) {
                this.dUU.cq(fileSize);
                if (TextUtils.isEmpty(str)) {
                    return ax(-1, n.u("fail no such file or directory ", null, str, null));
                }
                File file2 = new File(wM2);
                if (file2.exists()) {
                    file2.delete();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(xa);
                cY.result = arrayList;
                cY.errMsg = "ok";
            }
            return cY;
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
    private c cY(String str, String str2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream3 = null;
        String wM = wM(str);
        String wM2 = wM(str2);
        if (TextUtils.isEmpty(wM)) {
            return ax(-1, n.u("fail no such file or directory ", null, str, null));
        }
        if (TextUtils.isEmpty(wM2)) {
            return ax(-1, n.u("fail no such file or directory ", null, str2, null));
        }
        c ax = ax(0, "ok");
        try {
            File file = new File(wM2);
            fileInputStream = new FileInputStream(new File(wM));
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
            String xa = n.xa(str);
            if (!n.wT(xa)) {
                return ax(-4, "fail permission denied, open " + str);
            }
            String wM = wM(xa);
            if (TextUtils.isEmpty(wM)) {
                return ax(-1, "fail no such file or directory " + str);
            }
            File file = new File(wM);
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
            c wN = wN(str);
            if (wN == null) {
                if (!n.wT(str)) {
                    return ax(-4, "fail permission denied, open " + str);
                }
                String wM = wM(str);
                if (TextUtils.isEmpty(wM)) {
                    return ax(-1, "fail no such file or directory " + str);
                }
                File file = new File(wM);
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
            return wN;
        }
        return aa;
    }

    private boolean d(File[] fileArr) {
        return (fileArr == null || fileArr.length == 0) ? false : true;
    }

    public c s(String str, String str2, boolean z) {
        c aa = n.aa(str, z ? "filePath must be a string" : "fail file not found", z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of NULL;");
        if (aa == null) {
            String xa = n.xa(str);
            if (!this.dUT.ag(xa, true)) {
                return ax(-1, "fail permission denied, open " + str);
            }
            c al = al(xa, true);
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
            if (!isEmpty && !dUR.contains(str2)) {
                return ax(-1, "fail Error: Unknown encoding: " + str2);
            }
            String wM = wM(xa);
            if (TextUtils.isEmpty(wM)) {
                return ax(-1, "fail no such file or directory " + str);
            }
            File file = new File(wM);
            String str3 = "";
            byte[] bArr = new byte[0];
            c ax = ax(0, "ok");
            try {
                if (TextUtils.isEmpty(str2)) {
                    bArr = n.xb(wM);
                } else if ("base64".equals(str2)) {
                    byte[] xb = n.xb(wM);
                    str3 = xb.length == 0 ? "" : Base64.encodeToString(xb, 2);
                    bArr = xb;
                } else if ("hex".equals(str2)) {
                    str3 = n.wW(wM);
                } else {
                    str3 = a(new FileInputStream(file), str2);
                }
                if (TextUtils.isEmpty(str2)) {
                    ax.dTY = bArr;
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
                String xa = n.xa(str);
                c wN = wN(xa);
                if (wN != null) {
                    wN.errMsg = n.u("fail permission denied, ", "rename", str, str2);
                    return wN;
                }
                String xa2 = n.xa(str2);
                c wN2 = wN(xa2);
                if (wN2 != null) {
                    wN2.errMsg = n.u("fail permission denied, ", "rename", str, str2);
                    return wN2;
                }
                c al = al(xa, false);
                if (al != null) {
                    al.errMsg = n.u("fail no such file or directory ", "rename", str, str2);
                    return al;
                } else if (!n.wS(xa) || !n.wS(xa2)) {
                    return ax(-4, n.u("fail permission denied, ", "rename", str, str2));
                } else {
                    c am = am(xa2, false);
                    if (am != null) {
                        am.errMsg = n.u("fail no such file or directory ", "rename", str, str2);
                        return am;
                    }
                    String wM = wM(xa);
                    if (TextUtils.isEmpty(wM)) {
                        return ax(-1, "fail no such file or directory " + str);
                    }
                    String wM2 = wM(xa2);
                    if (TextUtils.isEmpty(wM2)) {
                        return ax(-1, "fail no such file or directory " + str2);
                    }
                    File file = new File(wM);
                    File file2 = new File(wM2);
                    boolean exists = file2.exists();
                    if (!n.k(file, file2) || (file.isDirectory() && !exists && wO(wM2))) {
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
                String xa = n.xa(str);
                if (!this.dUT.ag(xa, true)) {
                    return ax(-4, n.u("fail no such file or directory ", "copyFile", str, null));
                }
                String xa2 = n.xa(str2);
                if (!n.wS(xa2)) {
                    return ax(-4, n.u("fail permission denied, open ", "copyFile", str2, null));
                }
                c wN = wN(xa2);
                if (wN == null) {
                    String wM = wM(xa);
                    if (TextUtils.isEmpty(wM)) {
                        return ax(-1, "fail no such file or directory " + str);
                    }
                    File file = new File(wM);
                    if (!file.exists() || !file.isFile()) {
                        return ax(-1, n.u("fail no such file or directory ", "copyFile", str, null));
                    }
                    c am = am(xa2, false);
                    if (am != null) {
                        am.errMsg = n.u("fail no such file or directory ", "copyFile", str2, null);
                        return am;
                    } else if (xa2.endsWith(File.separator)) {
                        return ax(-1, n.u("fail permission denied, ", "copyFile", str, str2));
                    } else {
                        String wM2 = wM(xa2);
                        if (TextUtils.isEmpty(wM2)) {
                            return ax(-1, "fail no such file or directory " + str2);
                        }
                        File file2 = new File(wM2);
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
                        long fileSize = n.getFileSize(wM);
                        if (xa.equals(xa2) || xa.startsWith(a.USER_DATA_PATH)) {
                            z2 = false;
                        }
                        if (z2 && this.dUU.cr(fileSize)) {
                            return ax(-1, aVd());
                        }
                        c cY = !xa.equals(xa2) ? cY(xa, xa2) : ax(0, "ok");
                        if (z2 && cY != null && cY.errCode == 0) {
                            this.dUU.cq(fileSize);
                            return cY;
                        }
                        return cY;
                    }
                }
                return wN;
            }
            return aa2;
        }
        return aa;
    }

    public c b(String str, Object obj, String str2, boolean z) {
        c aa = n.aa(str, n.u("fail permission denied, open ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of NULL;");
        if (aa == null) {
            String xa = n.xa(str);
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return ax(-1, "fail sdcard not mounted ");
            }
            c wN = wN(xa);
            if (wN == null) {
                if (obj == null) {
                    return ax(-1, "fail TypeError: data argument must be a string, Buffer, ArrayBuffer, Array, or array-like object");
                }
                String wM = wM(xa);
                if (TextUtils.isEmpty(wM)) {
                    return ax(-1, "fail no such file or directory " + str);
                }
                File file = new File(wM);
                if (!file.exists()) {
                    return ax(-1, n.u("fail no such file or directory ", "open", str, null));
                }
                if (file.isDirectory()) {
                    return ax(-1, "fail illegal operation on a directory, open " + str);
                }
                return a(xa, obj, str2, true);
            }
            return wN;
        }
        return aa;
    }

    public c ap(String str, boolean z) {
        c aa = n.aa(str, z ? "path must be a string" : n.u("fail no such file or directory ", "access", str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Undefined;");
        if (aa == null) {
            String xa = n.xa(str);
            if (!this.dUT.ag(xa, true)) {
                return ax(-4, n.u("fail no such file or directory ", "access", str, null));
            }
            String wM = wM(xa);
            if (TextUtils.isEmpty(wM)) {
                return ax(-1, "fail no such file or directory " + str);
            }
            if (!new File(wM).exists()) {
                return ax(-1, n.u("fail no such file or directory ", "access", str, null));
            }
            return ax(0, "ok");
        }
        return aa;
    }

    public c aq(String str, boolean z) {
        c aa = n.aa(str, z ? "path must be a string" : n.u("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Object;");
        if (aa == null) {
            if (!this.dUT.tr(str) && !this.dUT.tq(str)) {
                return ax(-1, "fail permission denied, open " + str);
            }
            c al = al(str, false);
            if (al == null) {
                j jVar = new j();
                String wM = wM(str);
                if (TextUtils.isEmpty(wM)) {
                    return ax(-1, n.u("fail no such file or directory ", null, str, null));
                }
                File file = new File(wM);
                jVar.hu(file.isDirectory());
                jVar.hv(file.isFile());
                return a(str, jVar);
            }
            return al;
        }
        return aa;
    }

    private c a(String str, j jVar) {
        String wM = wM(str);
        if (TextUtils.isEmpty(wM)) {
            return ax(-1, "fail no such file or directory " + str);
        }
        File file = new File(wM);
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

    public c aVc() {
        String aKN = this.dUT.aKN();
        String wM = wM(a.USER_DATA_PATH);
        if (TextUtils.isEmpty(wM)) {
            return ax(-1, "path must be a string");
        }
        ArrayList arrayList = new ArrayList();
        for (String str : n.ar(wM, false)) {
            File file = new File(str);
            d dVar = new d();
            dVar.createTime = file.exists() ? file.lastModified() : 0L;
            String absolutePath = file.getAbsolutePath();
            if (file.exists() && !TextUtils.isEmpty(absolutePath) && !TextUtils.isEmpty(aKN) && absolutePath.startsWith(aKN)) {
                dVar.filePath = this.dUT.tI(absolutePath);
            }
            dVar.size = file.exists() ? file.length() : 0L;
            arrayList.add(dVar);
        }
        c ax = ax(0, "ok");
        ax.fileList = arrayList;
        return ax;
    }

    public c wQ(String str) {
        c ax;
        c aa = n.aa(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Object;");
        if (aa == null) {
            if (wN(str) != null) {
                return ax(-4, "fail file not exist");
            }
            String wM = wM(str);
            if (TextUtils.isEmpty(wM)) {
                return ax(-1, "fail no such file or directory " + str);
            }
            File file = new File(wM);
            if (!file.exists() || file.isDirectory()) {
                return ax(-1, "fail file not exist");
            }
            long fileSize = n.getFileSize(wM);
            try {
                if (!file.delete()) {
                    ax = ax(-1, "fail");
                } else {
                    this.dUU.cq(-fileSize);
                    ax = ax(0, "ok");
                }
                return ax;
            } catch (Exception e) {
                return ax(-1, "fail");
            }
        }
        return aa;
    }

    public c wR(String str) {
        c aa = n.aa(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Undefined;");
        if (aa == null) {
            String xa = n.xa(str);
            if (!this.dUT.ag(xa, true)) {
                return ax(-4, "fail file not exist");
            }
            String wM = wM(xa);
            if (TextUtils.isEmpty(wM)) {
                return ax(-1, "fail no such file or directory " + str);
            }
            File file = new File(wM);
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

    private String aVd() {
        String generateFileSizeText = com.baidu.swan.c.d.generateFileSizeText(this.dUU.getMaxSize());
        return String.format("fail file size over %s", (TextUtils.isEmpty(generateFileSizeText) || TextUtils.equals(generateFileSizeText, FileUtils.UNKNOW)) ? "" : "");
    }
}
