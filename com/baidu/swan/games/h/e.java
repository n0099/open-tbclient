package com.baidu.swan.games.h;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.system.Os;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.live.tbadk.log.LogConfig;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class e {
    private static List<String> cMR = new ArrayList();
    private String cMQ = l.getBasePath();
    private String cMS;
    private Context mContext;

    static {
        cMR.add("ascii");
        cMR.add("base64");
        cMR.add("binary");
        cMR.add("hex");
        cMR.add("utf-8");
        cMR.add("utf8");
        cMR.add("latin1");
        cMR.add("ucs2");
        cMR.add("ucs-2");
        cMR.add("utf16le");
        cMR.add("utf-16le");
    }

    public e(Context context, String str) {
        this.mContext = context;
        this.cMS = str;
    }

    private String pZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith(a.USER_DATA_PATH)) {
            return l.qj(str);
        }
        if (str.startsWith("bdfile://tmp")) {
            return l.qk(str);
        }
        if (str.startsWith("bdfile://code")) {
            this.cMS = this.cMS.endsWith(File.separator) ? this.cMS.substring(0, this.cMS.length() - 1) : this.cMS;
            return this.cMS + str.substring("bdfile://code".length());
        }
        return "";
    }

    private c qa(String str) {
        c aa = aa(-1, "fail permission denied, open " + str);
        if (!TextUtils.isEmpty(str) && str.startsWith(a.USER_DATA_PATH)) {
            return null;
        }
        return aa;
    }

    private c aa(int i, String str) {
        c cVar = new c();
        cVar.errCode = i;
        cVar.errMsg = str;
        return cVar;
    }

    private c M(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            c cVar = new c();
            cVar.errCode = -1;
            cVar.errMsg = "fail no such file or directory " + str;
            return cVar;
        }
        String pZ = pZ(str);
        if (TextUtils.isEmpty(str)) {
            c cVar2 = new c();
            cVar2.errCode = -1;
            cVar2.errMsg = "fail no such file or directory " + str;
            return cVar2;
        }
        File file = new File(pZ);
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

    private c N(String str, boolean z) {
        if (str.endsWith(File.separator)) {
            str = str.substring(0, str.length() - 1);
        }
        String pZ = pZ(str);
        if (TextUtils.isEmpty(pZ)) {
            return aa(-1, "fail no such file or directory " + str);
        }
        if (pZ.contains(File.separator)) {
            File file = new File(pZ.substring(0, pZ.lastIndexOf(File.separator)));
            if (!z && (!file.exists() || (file.exists() && file.isFile()))) {
                return aa(-1, "fail no such file or directory " + str);
            }
        }
        return null;
    }

    public c b(String str, boolean z, boolean z2) {
        boolean mkdir;
        c L = l.L(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (L == null) {
            c qa = qa(str);
            if (qa == null) {
                if (!l.qe(str)) {
                    return aa(-4, "fail permission denied, open " + str);
                }
                String pZ = pZ(str);
                c N = N(str, z);
                if (N == null) {
                    File file = new File(pZ);
                    if (file.exists()) {
                        return aa(-1, "fail file already exists " + str);
                    }
                    try {
                        if (z) {
                            mkdir = file.mkdirs();
                        } else {
                            mkdir = file.mkdir();
                        }
                        if (!mkdir) {
                            return aa(-1, "fail");
                        }
                        return aa(0, "ok");
                    } catch (Exception e) {
                        return aa(-1, "fail");
                    }
                }
                return N;
            }
            return qa;
        }
        return L;
    }

    public c a(boolean z, String str, Object obj, String str2) {
        c L = l.L(str, z ? "filePath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        return L != null ? L : a(str, obj, str2, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [426=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:88:0x01b8 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v23, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v75 */
    private c a(String str, Object obj, String str2, boolean z) {
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2;
        ?? fileOutputStream;
        String str3;
        String str4;
        BufferedWriter bufferedWriter3 = null;
        c qa = qa(str);
        if (qa != null) {
            return qa;
        }
        if (obj == null) {
            return aa(-1, "The argument must be string or arrayBuffer");
        }
        int length = (a.USER_DATA_PATH + File.separator).length();
        if (!l.qe(str)) {
            return aa(-4, "fail permission denied, open " + str.substring(length));
        }
        boolean z2 = obj instanceof byte[];
        if (!z2 && TextUtils.isEmpty(str2)) {
            str2 = "utf-8";
        }
        if (!TextUtils.isEmpty(str2)) {
            if ("binary".equals(str2.toLowerCase())) {
                str2 = "latin1";
            }
            if (!cMR.contains(str2.toLowerCase())) {
                return aa(-1, "fail invalid encoding \"" + str2 + "\"");
            }
        }
        c N = N(str, false);
        if (N != null) {
            return N;
        }
        String pZ = pZ(str);
        if (TextUtils.isEmpty(pZ)) {
            return aa(-1, "fail no such file or directory " + str.substring(length));
        }
        long j = 0;
        if (!z2 && !TextUtils.isEmpty((String) obj)) {
            j = ((String) obj).getBytes().length;
        } else if (z2) {
            j = ((byte[]) obj).length;
        }
        if (l.bE(j)) {
            return aa(-1, "fail file size over 50M");
        }
        File file = new File(pZ);
        if (file.exists() && file.isDirectory()) {
            return aa(-1, " fail illegal operation on a directory, open " + str);
        }
        c aa = aa(0, "ok");
        try {
            if (z2) {
                byte[] bArr = (byte[]) obj;
                fileOutputStream = new FileOutputStream(pZ, z);
                try {
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.flush();
                        fileOutputStream = fileOutputStream;
                    } catch (Exception e) {
                        bufferedWriter2 = fileOutputStream;
                        c aa2 = aa(-1, "fail");
                        com.baidu.swan.d.c.closeSafely(bufferedWriter3);
                        com.baidu.swan.d.c.closeSafely(bufferedWriter2);
                        return aa2;
                    }
                } catch (Throwable th) {
                    bufferedWriter = null;
                    bufferedWriter3 = fileOutputStream;
                    th = th;
                    com.baidu.swan.d.c.closeSafely(bufferedWriter);
                    com.baidu.swan.d.c.closeSafely(bufferedWriter3);
                    throw th;
                }
            } else {
                String[] bV = l.bV((String) obj, str2);
                if (bV == null || bV.length != 2) {
                    str3 = "utf-8";
                    str4 = "";
                } else {
                    String str5 = bV[0];
                    str3 = bV[1];
                    str4 = str5;
                }
                bufferedWriter = new BufferedWriter(TextUtils.isEmpty(str3) ? new OutputStreamWriter(new FileOutputStream(file, z)) : new OutputStreamWriter(new FileOutputStream(file, z), str3.toLowerCase()));
                try {
                    bufferedWriter.write(str4);
                    bufferedWriter.flush();
                    fileOutputStream = 0;
                    bufferedWriter3 = bufferedWriter;
                } catch (Exception e2) {
                    bufferedWriter2 = null;
                    bufferedWriter3 = bufferedWriter;
                    try {
                        c aa22 = aa(-1, "fail");
                        com.baidu.swan.d.c.closeSafely(bufferedWriter3);
                        com.baidu.swan.d.c.closeSafely(bufferedWriter2);
                        return aa22;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedWriter = bufferedWriter3;
                        bufferedWriter3 = bufferedWriter2;
                        com.baidu.swan.d.c.closeSafely(bufferedWriter);
                        com.baidu.swan.d.c.closeSafely(bufferedWriter3);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.baidu.swan.d.c.closeSafely(bufferedWriter);
                    com.baidu.swan.d.c.closeSafely(bufferedWriter3);
                    throw th;
                }
            }
            try {
                if (j > l.awn()) {
                    l.bD(j - l.awn());
                    l.bF(j);
                }
                com.baidu.swan.d.c.closeSafely(bufferedWriter3);
                com.baidu.swan.d.c.closeSafely(fileOutputStream);
                return aa;
            } catch (Throwable th4) {
                bufferedWriter = bufferedWriter3;
                bufferedWriter3 = fileOutputStream;
                th = th4;
                com.baidu.swan.d.c.closeSafely(bufferedWriter);
                com.baidu.swan.d.c.closeSafely(bufferedWriter3);
                throw th;
            }
        } catch (Exception e3) {
            bufferedWriter2 = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedWriter = null;
        }
    }

    public c O(String str, boolean z) {
        c aa;
        c L = l.L(str, z ? "filePath must be a string" : l.t("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of Object;");
        if (L == null) {
            if (!l.qf(str)) {
                return aa(-4, l.t("fail permission denied, open ", null, str, null));
            }
            c M = M(str, false);
            if (M == null) {
                c qa = qa(str);
                if (qa == null) {
                    String pZ = pZ(str);
                    if (TextUtils.isEmpty(pZ)) {
                        return aa(-1, l.t("fail no such file or directory ", null, str, null));
                    }
                    File file = new File(pZ);
                    if (file.isDirectory()) {
                        return aa(-1, l.t("fail operation not permitted ", "unlink", str, null));
                    }
                    long fileSize = l.getFileSize(pZ);
                    try {
                        if (file.delete()) {
                            l.bD(-fileSize);
                            aa = aa(0, "ok");
                        } else {
                            aa = aa(-1, l.t("fail", null, str, null));
                        }
                        return aa;
                    } catch (Exception e) {
                        return aa(-1, l.t("fail", null, str, null));
                    }
                }
                return qa;
            }
            return M;
        }
        return L;
    }

    public c bR(String str, String str2) {
        c L = l.L(str, l.b("fail no such file or directory ", "unzip", str, str2, true), "fail parameter error: parameter.zipFilePath should be String instead of Object;");
        if (L == null) {
            c L2 = l.L(str2, l.b("fail no such file or directory ", "unzip", str, str2, true), "fail parameter error: parameter.targetPath should be String instead of Object;");
            if (L2 == null) {
                if (!str2.startsWith("bdfile://tmp") && !str2.startsWith(a.USER_DATA_PATH)) {
                    return aa(-1, "fail permission denied, open " + str2);
                }
                String qm = l.qm(str);
                if (!qm.startsWith("bdfile://tmp") && !qm.startsWith(a.USER_DATA_PATH) && !qm.startsWith("bdfile://code")) {
                    return aa(-1, "fail permission denied, open " + str);
                }
                if (!l.qe(qm)) {
                    return aa(-4, l.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (!l.qe(str2)) {
                    return aa(-4, l.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (qb(str2)) {
                    return aa(-1, l.b("fail permission denied, ", "unzip", str, str2, true));
                }
                String pZ = pZ(qm);
                String pZ2 = pZ(str2);
                if (TextUtils.isEmpty(pZ)) {
                    return aa(-1, l.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (TextUtils.isEmpty(pZ2)) {
                    return aa(-1, l.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                File file = new File(pZ);
                if (!file.exists()) {
                    return aa(-1, l.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (!pZ.endsWith(".zip")) {
                    return aa(-1, "fail unzip failed");
                }
                if (!file.isFile()) {
                    return aa(-1, l.b("fail permission denied, ", "unzip", str, str2, true));
                }
                File file2 = new File(pZ2);
                if (!file2.exists()) {
                    file2.mkdirs();
                } else if (file2.isFile()) {
                    return aa(-1, "fail unzip failed");
                }
                List<String> S = l.S(pZ2, true);
                if (!com.baidu.swan.d.c.unzipFile(pZ, pZ2)) {
                    return aa(-1, "fail unzip failed");
                }
                if (str2.startsWith(a.USER_DATA_PATH)) {
                    List<String> S2 = l.S(pZ2, true);
                    ArrayList arrayList = new ArrayList(S2.size());
                    long j = 0;
                    for (String str3 : S2) {
                        if (!S.contains(str3)) {
                            arrayList.add(str3);
                            j = l.getFileSize(str3) + j;
                        }
                    }
                    if (l.bE(j)) {
                        l.ar(arrayList);
                        return aa(-1, "fail file size over 50M");
                    }
                    l.bD(j);
                }
                return aa(0, "ok");
            }
            return L2;
        }
        return L;
    }

    private boolean qb(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains(File.separator)) {
            return qc(str.substring(str.lastIndexOf(File.separator) + 1));
        }
        return qc(str);
    }

    private boolean qc(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(".")) {
            return false;
        }
        String[] split = str.split("\\.");
        return (split.length != 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) ? false : true;
    }

    public c o(String str, String str2, boolean z) {
        c L = l.L(str, z ? "tempFilePath must be a string" : "fail tempFilePath file not exist", z ? " The argument must be string" : "fail parameter error: parameter.tempFilePath should be String instead of Object;");
        if (L == null) {
            String qm = l.qm(str2);
            if (TextUtils.isEmpty(qm)) {
                qm = a.USER_DATA_PATH + File.separator + com.baidu.swan.d.c.getFileNameFromPath(str);
            }
            if (!qm.startsWith(a.USER_DATA_PATH)) {
                return aa(-1, l.t("fail permission denied, open ", null, str2, null));
            }
            if (!(!TextUtils.isEmpty(str) && (str.startsWith(new StringBuilder().append("bdfile://tmp").append(File.separator).toString()) || "bdfile://tmp".equals(str)))) {
                return aa(-4, "fail it is not a tempFilePath");
            }
            c N = N(qm, false);
            if (N != null) {
                return N;
            }
            c N2 = N(str, false);
            if (N2 != null) {
                return N2;
            }
            File file = new File(pZ(qm));
            if (a.USER_DATA_PATH.equals(qm) || (file.exists() && file.isDirectory())) {
                return aa(-1, l.t("fail Error: EISDIR: illegal operation on a directory, open ", null, str2, null));
            }
            c M = M(str, true);
            if (M != null) {
                M.errMsg = "fail no such file or directory ";
                return M;
            }
            String pZ = pZ(str);
            long fileSize = l.getFileSize(pZ);
            if (l.bE(fileSize)) {
                return aa(-1, "fail file size over 50M");
            }
            if (!qm.startsWith(a.USER_DATA_PATH) || l.qg(qm)) {
                return aa(-1, l.t("fail permission denied, open ", null, str2, null));
            }
            c N3 = N(qm, false);
            if (N3 != null) {
                return N3;
            }
            c qa = qa(qm);
            if (qa != null) {
                return qa;
            }
            c bS = bS(str, qm);
            if (bS != null && bS.errCode == 0) {
                l.bD(fileSize);
                if (TextUtils.isEmpty(str)) {
                    return aa(-1, l.t("fail no such file or directory ", null, str, null));
                }
                File file2 = new File(pZ);
                if (file2.exists()) {
                    file2.delete();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(qm);
                bS.result = arrayList;
                bS.errMsg = "ok";
            }
            return bS;
        }
        return L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [776=4] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v11, resolved type: java.io.FileOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private c bS(String str, String str2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream3 = null;
        String pZ = pZ(str);
        String pZ2 = pZ(str2);
        if (TextUtils.isEmpty(pZ)) {
            return aa(-1, l.t("fail no such file or directory ", null, str, null));
        }
        if (TextUtils.isEmpty(pZ2)) {
            return aa(-1, l.t("fail no such file or directory ", null, str2, null));
        }
        c aa = aa(0, "ok");
        try {
            File file = new File(pZ2);
            fileInputStream = new FileInputStream(new File(pZ));
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
            com.baidu.swan.d.c.closeSafely(fileInputStream);
            com.baidu.swan.d.c.closeSafely(fileOutputStream);
            if (TextUtils.isEmpty(str2)) {
                aa.errMsg = "fail";
                aa.errCode = -1;
                return aa;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            aa.result = arrayList;
            return aa;
        } catch (IOException e3) {
            e = e3;
            fileInputStream3 = fileInputStream;
            fileInputStream2 = fileOutputStream;
            try {
                e.printStackTrace();
                c aa2 = aa(-1, "fail");
                com.baidu.swan.d.c.closeSafely(fileInputStream3);
                com.baidu.swan.d.c.closeSafely(fileInputStream2);
                if (TextUtils.isEmpty("")) {
                    aa.errMsg = "fail";
                    aa.errCode = -1;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(str2);
                    aa.result = arrayList2;
                }
                return aa2;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream3;
                fileInputStream3 = fileInputStream2;
                com.baidu.swan.d.c.closeSafely(fileInputStream);
                com.baidu.swan.d.c.closeSafely(fileInputStream3);
                if (TextUtils.isEmpty("")) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(str2);
                    aa.result = arrayList3;
                } else {
                    aa.errMsg = "fail";
                    aa.errCode = -1;
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream3 = fileOutputStream;
            com.baidu.swan.d.c.closeSafely(fileInputStream);
            com.baidu.swan.d.c.closeSafely(fileInputStream3);
            if (TextUtils.isEmpty("")) {
            }
            throw th;
        }
    }

    public c P(String str, boolean z) {
        c L = l.L(str, z ? "dirPath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (L == null) {
            String qm = l.qm(str);
            if (!l.qf(qm)) {
                return aa(-4, "fail permission denied, open " + str);
            }
            String pZ = pZ(qm);
            if (TextUtils.isEmpty(pZ)) {
                return aa(-1, "fail no such file or directory " + str);
            }
            File file = new File(pZ);
            if (!file.exists()) {
                return aa(-1, "fail no such file or directory " + str);
            }
            if (!file.isDirectory()) {
                return aa(-1, "fail no such file or directory " + str);
            }
            File[] listFiles = file.listFiles();
            ArrayList arrayList = new ArrayList();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2 != null && file2.exists()) {
                        arrayList.add(com.baidu.swan.d.c.getFileNameFromPath(file2.getAbsolutePath()));
                    }
                }
            }
            c aa = aa(0, "ok");
            aa.result = arrayList;
            return aa;
        }
        return L;
    }

    public c c(String str, boolean z, boolean z2) {
        boolean deleteFile;
        c L = l.L(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (L == null) {
            c qa = qa(str);
            if (qa == null) {
                if (!l.qf(str)) {
                    return aa(-4, "fail permission denied, open " + str);
                }
                File file = new File(pZ(str));
                if (!file.exists() || file.isFile()) {
                    return aa(-1, "fail no such file or directory " + str);
                }
                boolean d = d(file.listFiles());
                try {
                    if (!z && d) {
                        return aa(-1, "fail directory not empty ");
                    }
                    if (!z) {
                        deleteFile = file.delete();
                    } else {
                        deleteFile = com.baidu.swan.d.c.deleteFile(file);
                    }
                    if (!deleteFile) {
                        return aa(-1, "fail");
                    }
                    return aa(0, "ok");
                } catch (Exception e) {
                    return aa(-1, "fail");
                }
            }
            return qa;
        }
        return L;
    }

    private boolean d(File[] fileArr) {
        return (fileArr == null || fileArr.length == 0) ? false : true;
    }

    public c p(String str, String str2, boolean z) {
        String str3;
        c L = l.L(str, z ? "filePath must be a string" : "fail file not found", z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of NULL;");
        if (L == null) {
            String qm = l.qm(str);
            if (!l.qe(qm)) {
                return aa(-1, "fail permission denied, open " + str);
            }
            c M = M(qm, true);
            if (M != null) {
                M.errMsg = l.t("fail no such file or directory ", "open", str, null);
                return M;
            }
            boolean isEmpty = TextUtils.isEmpty(str2);
            if (isEmpty) {
                str3 = str2;
            } else {
                str3 = str2.toLowerCase();
                if ("binary".equals(str3)) {
                    str3 = "latin1";
                }
            }
            if (!isEmpty && !cMR.contains(str3)) {
                return aa(-1, "fail Error: Unknown encoding: " + str3);
            }
            String pZ = pZ(qm);
            if (TextUtils.isEmpty(pZ)) {
                return aa(-1, "fail no such file or directory " + str);
            }
            File file = new File(pZ);
            String str4 = "";
            byte[] bArr = new byte[0];
            c aa = aa(0, "ok");
            try {
                if (TextUtils.isEmpty(str3)) {
                    bArr = l.qn(pZ);
                } else {
                    String a = a(new FileInputStream(file), ("base64".equals(str3) || "hex".equals(str3)) ? "" : str3);
                    if (!TextUtils.isEmpty(a)) {
                        if ("base64".equals(str3)) {
                            str4 = new String(Base64.encode(a.getBytes(), 2), "utf-8");
                        } else if ("hex".equals(str3)) {
                            str4 = l.qi(pZ);
                        }
                    }
                    str4 = a;
                }
                if (TextUtils.isEmpty(str3)) {
                    aa.cMd = bArr;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str4);
                    aa.result = arrayList;
                }
                return aa;
            } catch (Exception e) {
                e.printStackTrace();
                return aa(-1, "fail");
            }
        }
        return L;
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
            com.baidu.swan.d.c.closeSafely(fileInputStream);
        }
    }

    public c q(String str, String str2, boolean z) {
        c L = l.L(str, z ? "oldPath must be a string" : l.t("fail no such file or directory ", "rename", str, null), z ? " The argument must be string" : "fail parameter error: parameter.oldPath should be String instead of Undefined;");
        if (L == null) {
            c L2 = l.L(str2, z ? "newPath must be a string" : l.t("fail no such file or directory ", "rename", str2, null), z ? " The argument must be string" : "fail parameter error: parameter.newPath should be String instead of Undefined;");
            if (L2 == null) {
                String qm = l.qm(str);
                c qa = qa(qm);
                if (qa != null) {
                    qa.errMsg = l.t("fail permission denied, ", "rename", str, str2);
                    return qa;
                }
                String qm2 = l.qm(str2);
                c qa2 = qa(qm2);
                if (qa2 != null) {
                    qa2.errMsg = l.t("fail permission denied, ", "rename", str, str2);
                    return qa2;
                }
                c M = M(qm, false);
                if (M != null) {
                    M.errMsg = l.t("fail no such file or directory ", "rename", str, str2);
                    return M;
                } else if (!l.qe(qm) || !l.qe(qm2)) {
                    return aa(-4, l.t("fail permission denied, ", "rename", str, str2));
                } else {
                    c N = N(qm2, false);
                    if (N != null) {
                        N.errMsg = l.t("fail no such file or directory ", "rename", str, str2);
                        return N;
                    }
                    String pZ = pZ(qm);
                    String pZ2 = pZ(qm2);
                    File file = new File(pZ);
                    File file2 = new File(pZ2);
                    boolean exists = file2.exists();
                    if (!l.i(file, file2) || (file.isDirectory() && !exists && qb(pZ2))) {
                        return aa(-1, "fail rename failed");
                    }
                    try {
                        if ((file2.isDirectory() && file2.listFiles() != null && file2.listFiles().length > 0) || !file.renameTo(file2)) {
                            return aa(-1, "fail rename failed");
                        }
                        return aa(0, "ok");
                    } catch (Exception e) {
                        return aa(-1, "fail");
                    }
                }
            }
            return L2;
        }
        return L;
    }

    public c r(String str, String str2, boolean z) {
        c L = l.L(str, "srcPath must be a string", " The argument must be string");
        if (L == null) {
            c L2 = l.L(str2, "destPath must be a string", " The argument must be string");
            if (L2 == null) {
                String qm = l.qm(str);
                if (!l.qe(qm)) {
                    return aa(-4, l.t("fail no such file or directory ", "copyFile", str, null));
                }
                String qm2 = l.qm(str2);
                if (!l.qe(qm2)) {
                    return aa(-4, l.t("fail permission denied, open ", "copyFile", str2, null));
                }
                c qa = qa(qm2);
                if (qa == null) {
                    String pZ = pZ(qm);
                    File file = new File(pZ);
                    if (!file.exists() || !file.isFile()) {
                        return aa(-1, l.t("fail no such file or directory ", "copyFile", str, null));
                    }
                    c N = N(qm2, false);
                    if (N != null) {
                        N.errMsg = l.t("fail no such file or directory ", "copyFile", str2, null);
                        return N;
                    } else if (qm2.endsWith(File.separator)) {
                        return aa(-1, l.t("fail permission denied, ", "copyFile", str, str2));
                    } else {
                        File file2 = new File(pZ(qm2));
                        if (file2.exists() && file2.isDirectory()) {
                            if (d(file2.listFiles())) {
                                return aa(-1, l.t("fail permission denied, ", "copyFile", str, str2));
                            }
                            try {
                                file2.delete();
                            } catch (Exception e) {
                                return aa(-1, "fail");
                            }
                        }
                        long fileSize = l.getFileSize(pZ);
                        boolean z2 = (qm.equals(qm2) || qm.startsWith(a.USER_DATA_PATH)) ? false : true;
                        if (z2 && l.bE(fileSize)) {
                            return aa(-1, "fail file size over 50M");
                        }
                        c bS = !qm.equals(qm2) ? bS(qm, qm2) : aa(0, "ok");
                        if (z2 && bS != null && bS.errCode == 0) {
                            l.bD(fileSize);
                            return bS;
                        }
                        return bS;
                    }
                }
                return qa;
            }
            return L2;
        }
        return L;
    }

    public c b(String str, Object obj, String str2, boolean z) {
        c L = l.L(str, l.t("fail permission denied, open ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of NULL;");
        if (L == null) {
            String qm = l.qm(str);
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return aa(-1, "fail sdcard not mounted ");
            }
            c qa = qa(qm);
            if (qa == null) {
                if (obj == null) {
                    return aa(-1, "fail TypeError: data argument must be a string, Buffer, ArrayBuffer, Array, or array-like object");
                }
                File file = new File(pZ(qm));
                if (!file.exists()) {
                    return aa(-1, l.t("fail no such file or directory ", "open", str, null));
                }
                if (file.isDirectory()) {
                    return aa(-1, "fail illegal operation on a directory, open " + str);
                }
                return a(qm, obj, str2, true);
            }
            return qa;
        }
        return L;
    }

    public c Q(String str, boolean z) {
        c L = l.L(str, z ? "path must be a string" : l.t("fail no such file or directory ", LogConfig.KEY_ACCESS, str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Undefined;");
        if (L == null) {
            String qm = l.qm(str);
            if (!l.qe(qm)) {
                return aa(-4, l.t("fail no such file or directory ", LogConfig.KEY_ACCESS, str, null));
            }
            if (!new File(pZ(qm)).exists()) {
                return aa(-1, l.t("fail no such file or directory ", LogConfig.KEY_ACCESS, str, null));
            }
            return aa(0, "ok");
        }
        return L;
    }

    public c R(String str, boolean z) {
        c L = l.L(str, z ? "path must be a string" : l.t("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Object;");
        if (L == null) {
            if (!l.qo(str) && !l.qf(str)) {
                return aa(-1, "fail permission denied, open " + str);
            }
            c M = M(str, false);
            if (M == null) {
                i iVar = new i();
                String pZ = pZ(str);
                if (TextUtils.isEmpty(pZ)) {
                    return aa(-1, l.t("fail no such file or directory ", null, str, null));
                }
                File file = new File(pZ);
                iVar.fA(file.isDirectory());
                iVar.fB(file.isFile());
                return a(str, iVar);
            }
            return M;
        }
        return L;
    }

    private c a(String str, i iVar) {
        File file = new File(pZ(str));
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                iVar.lastAccessedTime = Os.lstat(file.getAbsolutePath()).st_atime;
                iVar.lastModifiedTime = Os.lstat(file.getAbsolutePath()).st_mtime;
                iVar.mode = Os.lstat(file.getAbsolutePath()).st_mode;
                iVar.size = Os.lstat(file.getAbsolutePath()).st_size;
            } catch (Exception e) {
                e.printStackTrace();
                return aa(-1, "fail");
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
                iVar.lastAccessedTime = declaredField2.getLong(invoke);
                Field declaredField3 = invoke.getClass().getDeclaredField("st_mtime");
                if (!declaredField3.isAccessible()) {
                    declaredField3.setAccessible(true);
                }
                iVar.lastModifiedTime = declaredField3.getLong(invoke);
                Field declaredField4 = invoke.getClass().getDeclaredField("st_mode");
                if (!declaredField4.isAccessible()) {
                    declaredField4.setAccessible(true);
                }
                iVar.mode = declaredField4.getInt(invoke);
                Field declaredField5 = invoke.getClass().getDeclaredField("st_size");
                if (!declaredField5.isAccessible()) {
                    declaredField5.setAccessible(true);
                }
                iVar.size = declaredField5.getLong(invoke);
            } catch (Exception e2) {
                e2.printStackTrace();
                return aa(-1, "fail");
            }
        }
        c aa = aa(0, "ok");
        aa.stats = iVar;
        aa.errMsg = "ok";
        return aa;
    }

    public c qd(String str) {
        c L = l.L(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Undefined;");
        if (L == null) {
            String qm = l.qm(str);
            if (!qm.startsWith("bdfile://tmp") && !qm.startsWith(a.USER_DATA_PATH) && !qm.startsWith("bdfile://code")) {
                return aa(-4, "fail file not exist");
            }
            File file = new File(pZ(qm));
            if (!file.exists()) {
                return aa(-1, "fail file not exist");
            }
            if (file.isDirectory()) {
                return aa(-1, "fail " + str + " is directory");
            }
            c aa = aa(0, "ok");
            aa.size = file.exists() ? file.length() : 0L;
            aa.digest = file.exists() ? com.baidu.swan.d.d.toMd5(file, false) : null;
            return aa;
        }
        return L;
    }
}
