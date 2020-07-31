package com.baidu.swan.games.i;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.system.Os;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.util.io.FileUtils;
import com.baidu.live.tbadk.log.LogConfig;
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
    private static List<String> dil = new ArrayList();
    private String dim;
    private final com.baidu.swan.apps.storage.b.c din;
    private final com.baidu.swan.apps.storage.b.d dio;
    private Context mContext;

    static {
        dil.add("ascii");
        dil.add("base64");
        dil.add("binary");
        dil.add("hex");
        dil.add("utf-8");
        dil.add("utf8");
        dil.add("latin1");
        dil.add("ucs2");
        dil.add("ucs-2");
        dil.add("utf16le");
        dil.add("utf-16le");
    }

    public f(Context context, String str, @NonNull com.baidu.swan.apps.storage.b.c cVar) {
        this.mContext = context;
        this.dim = str;
        this.din = cVar;
        this.dio = this.din.auS();
    }

    private String sI(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith("bdfile://code")) {
            this.dim = this.dim.endsWith(File.separator) ? this.dim.substring(0, this.dim.length() - 1) : this.dim;
            return this.dim + str.substring("bdfile://code".length());
        } else if (str.startsWith("bdfile://")) {
            return this.din.pT(str);
        } else {
            return "";
        }
    }

    private c sJ(String str) {
        c ah = ah(-1, "fail permission denied, open " + str);
        if (!TextUtils.isEmpty(str) && str.startsWith(a.USER_DATA_PATH)) {
            return null;
        }
        return ah;
    }

    private c ah(int i, String str) {
        c cVar = new c();
        cVar.errCode = i;
        cVar.errMsg = str;
        return cVar;
    }

    private c aa(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            c cVar = new c();
            cVar.errCode = -1;
            cVar.errMsg = "fail no such file or directory " + str;
            return cVar;
        }
        String sI = sI(str);
        if (TextUtils.isEmpty(str)) {
            c cVar2 = new c();
            cVar2.errCode = -1;
            cVar2.errMsg = "fail no such file or directory " + str;
            return cVar2;
        }
        File file = new File(sI);
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

    private c ab(String str, boolean z) {
        if (str.endsWith(File.separator)) {
            str = str.substring(0, str.length() - 1);
        }
        String sI = sI(str);
        if (TextUtils.isEmpty(sI)) {
            return ah(-1, "fail no such file or directory " + str);
        }
        if (sI.contains(File.separator)) {
            File file = new File(sI.substring(0, sI.lastIndexOf(File.separator)));
            if (!z && (!file.exists() || (file.exists() && file.isFile()))) {
                return ah(-1, "fail no such file or directory " + str);
            }
        }
        return null;
    }

    public c b(String str, boolean z, boolean z2) {
        boolean mkdir;
        c P = n.P(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (P == null) {
            c sJ = sJ(str);
            if (sJ == null) {
                if (!n.sO(str)) {
                    return ah(-4, "fail permission denied, open " + str);
                }
                String sI = sI(str);
                if (TextUtils.isEmpty(sI)) {
                    return ah(-1, "fail no such file or directory " + str);
                }
                c ab = ab(str, z);
                if (ab == null) {
                    File file = new File(sI);
                    if (file.exists()) {
                        return ah(-1, "fail file already exists " + str);
                    }
                    try {
                        if (z) {
                            mkdir = file.mkdirs();
                        } else {
                            mkdir = file.mkdir();
                        }
                        if (!mkdir) {
                            return ah(-1, "fail");
                        }
                        return ah(0, "ok");
                    } catch (Exception e) {
                        return ah(-1, "fail");
                    }
                }
                return ab;
            }
            return sJ;
        }
        return P;
    }

    public c a(boolean z, String str, Object obj, String str2) {
        c P = n.P(str, z ? "filePath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        return P != null ? P : a(str, obj, str2, false);
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
        c sJ = sJ(str);
        if (sJ != null) {
            return sJ;
        }
        if (obj == null) {
            return ah(-1, "The argument must be string or arrayBuffer");
        }
        int length = (a.USER_DATA_PATH + File.separator).length();
        if (n.sO(str)) {
            boolean z2 = obj instanceof byte[];
            if (!z2 && TextUtils.isEmpty(str2)) {
                str2 = "utf-8";
            }
            if (!TextUtils.isEmpty(str2)) {
                if ("binary".equals(str2.toLowerCase())) {
                    str2 = "latin1";
                }
                if (!dil.contains(str2.toLowerCase())) {
                    return ah(-1, "fail invalid encoding \"" + str2 + "\"");
                }
            }
            BufferedWriter bufferedWriter3 = null;
            Closeable closeable = null;
            c ab = ab(str, false);
            if (ab == null) {
                String sI = sI(str);
                if (TextUtils.isEmpty(sI)) {
                    return ah(-1, "fail no such file or directory " + str.substring(length));
                }
                long j = 0;
                if (!z2 && !TextUtils.isEmpty((String) obj)) {
                    j = ((String) obj).getBytes().length;
                } else if (z2) {
                    j = ((byte[]) obj).length;
                }
                if (this.din.auS().bD(j)) {
                    return ah(-1, aEA());
                }
                File file = new File(sI);
                if (file.exists() && file.isDirectory()) {
                    return ah(-1, " fail illegal operation on a directory, open " + str);
                }
                long length2 = file.length();
                c ah = ah(0, "ok");
                try {
                    if (z2) {
                        byte[] bArr = (byte[]) obj;
                        FileOutputStream fileOutputStream2 = new FileOutputStream(sI, z);
                        try {
                            fileOutputStream2.write(bArr);
                            fileOutputStream2.flush();
                            bufferedWriter2 = null;
                            r2 = fileOutputStream2;
                        } catch (Exception e) {
                            fileOutputStream = fileOutputStream2;
                            bufferedWriter = null;
                            c ah2 = ah(-1, "fail");
                            com.baidu.swan.d.d.closeSafely(bufferedWriter);
                            com.baidu.swan.d.d.closeSafely(fileOutputStream);
                            return ah2;
                        } catch (Throwable th) {
                            closeable = fileOutputStream2;
                            th = th;
                            com.baidu.swan.d.d.closeSafely(bufferedWriter3);
                            com.baidu.swan.d.d.closeSafely(closeable);
                            throw th;
                        }
                    } else if (TextUtils.isEmpty((String) obj) || !TextUtils.equals("base64", str2)) {
                        String[] cv = n.cv((String) obj, str2);
                        if (cv == null || cv.length != 2) {
                            str3 = "utf-8";
                            str4 = "";
                        } else {
                            String str5 = cv[0];
                            str3 = cv[1];
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
                                c ah22 = ah(-1, "fail");
                                com.baidu.swan.d.d.closeSafely(bufferedWriter);
                                com.baidu.swan.d.d.closeSafely(fileOutputStream);
                                return ah22;
                            } catch (Throwable th2) {
                                th = th2;
                                closeable = fileOutputStream;
                                bufferedWriter3 = bufferedWriter;
                                com.baidu.swan.d.d.closeSafely(bufferedWriter3);
                                com.baidu.swan.d.d.closeSafely(closeable);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedWriter3 = bufferedWriter4;
                            com.baidu.swan.d.d.closeSafely(bufferedWriter3);
                            com.baidu.swan.d.d.closeSafely(closeable);
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
                            c ah222 = ah(-1, "fail");
                            com.baidu.swan.d.d.closeSafely(bufferedWriter);
                            com.baidu.swan.d.d.closeSafely(fileOutputStream);
                            return ah222;
                        } catch (Throwable th4) {
                            closeable = fileOutputStream3;
                            th = th4;
                            com.baidu.swan.d.d.closeSafely(bufferedWriter3);
                            com.baidu.swan.d.d.closeSafely(closeable);
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
                        this.dio.bC(j);
                    } else {
                        this.dio.bC(j - length2);
                    }
                    com.baidu.swan.d.d.closeSafely(bufferedWriter2);
                    com.baidu.swan.d.d.closeSafely(r2);
                    r2 = ah;
                    return r2;
                } catch (Exception e5) {
                    fileOutputStream = r2;
                    bufferedWriter = bufferedWriter2;
                    c ah2222 = ah(-1, "fail");
                    com.baidu.swan.d.d.closeSafely(bufferedWriter);
                    com.baidu.swan.d.d.closeSafely(fileOutputStream);
                    return ah2222;
                } catch (Throwable th6) {
                    bufferedWriter3 = bufferedWriter2;
                    closeable = r2;
                    th = th6;
                    com.baidu.swan.d.d.closeSafely(bufferedWriter3);
                    com.baidu.swan.d.d.closeSafely(closeable);
                    throw th;
                }
            }
            return ab;
        }
        return ah(-4, "fail permission denied, open " + str.substring(length));
    }

    public c ac(String str, boolean z) {
        c ah;
        c P = n.P(str, z ? "filePath must be a string" : n.t("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of Object;");
        if (P == null) {
            if (!n.sP(str)) {
                return ah(-4, n.t("fail permission denied, open ", null, str, null));
            }
            c aa = aa(str, false);
            if (aa == null) {
                c sJ = sJ(str);
                if (sJ == null) {
                    String sI = sI(str);
                    if (TextUtils.isEmpty(sI)) {
                        return ah(-1, n.t("fail no such file or directory ", null, str, null));
                    }
                    File file = new File(sI);
                    if (file.isDirectory()) {
                        return ah(-1, n.t("fail operation not permitted ", "unlink", str, null));
                    }
                    long fileSize = n.getFileSize(sI);
                    try {
                        if (file.delete()) {
                            this.dio.bC(-fileSize);
                            ah = ah(0, "ok");
                        } else {
                            ah = ah(-1, n.t("fail", null, str, null));
                        }
                        return ah;
                    } catch (Exception e) {
                        return ah(-1, n.t("fail", null, str, null));
                    }
                }
                return sJ;
            }
            return aa;
        }
        return P;
    }

    public c cr(String str, String str2) {
        c P = n.P(str, n.b("fail no such file or directory ", "unzip", str, str2, true), "fail parameter error: parameter.zipFilePath should be String instead of Object;");
        if (P == null) {
            c P2 = n.P(str2, n.b("fail no such file or directory ", "unzip", str, str2, true), "fail parameter error: parameter.targetPath should be String instead of Object;");
            if (P2 == null) {
                if (!str2.startsWith("bdfile://tmp") && !str2.startsWith(a.USER_DATA_PATH)) {
                    return ah(-1, "fail permission denied, open " + str2);
                }
                String sW = n.sW(str);
                if (!this.din.V(sW, true)) {
                    return ah(-4, n.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (!n.sO(str2)) {
                    return ah(-4, n.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (sK(str2)) {
                    return ah(-1, n.b("fail permission denied, ", "unzip", str, str2, true));
                }
                String sI = sI(sW);
                String sI2 = sI(str2);
                if (TextUtils.isEmpty(sI)) {
                    return ah(-1, n.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (TextUtils.isEmpty(sI2)) {
                    return ah(-1, n.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                File file = new File(sI);
                if (!file.exists()) {
                    return ah(-1, n.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (!sI.endsWith(".zip")) {
                    return ah(-1, "fail unzip failed");
                }
                if (!file.isFile()) {
                    return ah(-1, n.b("fail permission denied, ", "unzip", str, str2, true));
                }
                File file2 = new File(sI2);
                if (!file2.exists()) {
                    file2.mkdirs();
                } else if (file2.isFile()) {
                    return ah(-1, "fail unzip failed");
                }
                List<String> ag = n.ag(sI2, true);
                if (!com.baidu.swan.d.d.unzipFile(sI, sI2)) {
                    return ah(-1, "fail unzip failed");
                }
                if (str2.startsWith(a.USER_DATA_PATH)) {
                    List<String> ag2 = n.ag(sI2, true);
                    ArrayList arrayList = new ArrayList(ag2.size());
                    long j = 0;
                    for (String str3 : ag2) {
                        if (!ag.contains(str3)) {
                            arrayList.add(str3);
                            j = n.getFileSize(str3) + j;
                        }
                    }
                    if (this.dio.bD(j)) {
                        n.au(arrayList);
                        return ah(-1, aEA());
                    }
                    this.dio.bC(j);
                }
                return ah(0, "ok");
            }
            return P2;
        }
        return P;
    }

    private boolean sK(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains(File.separator)) {
            return sL(str.substring(str.lastIndexOf(File.separator) + 1));
        }
        return sL(str);
    }

    private boolean sL(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(".")) {
            return false;
        }
        String[] split = str.split("\\.");
        return (split.length != 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) ? false : true;
    }

    public c q(String str, String str2, boolean z) {
        c P = n.P(str, z ? "tempFilePath must be a string" : "fail tempFilePath file not exist", z ? " The argument must be string" : "fail parameter error: parameter.tempFilePath should be String instead of Object;");
        if (P == null) {
            String sW = n.sW(str2);
            if (TextUtils.isEmpty(sW)) {
                sW = a.USER_DATA_PATH + File.separator + com.baidu.swan.d.d.getFileNameFromPath(str);
            }
            if (!sW.startsWith(a.USER_DATA_PATH)) {
                return ah(-1, n.t("fail permission denied, open ", null, str2, null));
            }
            if (!this.din.pD(str)) {
                return ah(-4, "fail it is not a tempFilePath");
            }
            c ab = ab(sW, false);
            if (ab != null) {
                return ab;
            }
            c ab2 = ab(str, false);
            if (ab2 != null) {
                return ab2;
            }
            String sI = sI(sW);
            if (TextUtils.isEmpty(sI)) {
                return ah(-1, "fail no such file or directory " + str2);
            }
            File file = new File(sI);
            if (a.USER_DATA_PATH.equals(sW) || (file.exists() && file.isDirectory())) {
                return ah(-1, n.t("fail Error: EISDIR: illegal operation on a directory, open ", null, str2, null));
            }
            c aa = aa(str, true);
            if (aa != null) {
                aa.errMsg = "fail no such file or directory ";
                return aa;
            }
            String sI2 = sI(str);
            if (TextUtils.isEmpty(sI2)) {
                return ah(-1, "fail no such file or directory " + str);
            }
            long fileSize = n.getFileSize(sI2);
            if (this.dio.bD(fileSize)) {
                return ah(-1, aEA());
            }
            if (!sW.startsWith(a.USER_DATA_PATH) || n.sQ(sW)) {
                return ah(-1, n.t("fail permission denied, open ", null, str2, null));
            }
            c ab3 = ab(sW, false);
            if (ab3 != null) {
                return ab3;
            }
            c sJ = sJ(sW);
            if (sJ != null) {
                return sJ;
            }
            c cs = cs(str, sW);
            if (cs != null && cs.errCode == 0) {
                this.dio.bC(fileSize);
                if (TextUtils.isEmpty(str)) {
                    return ah(-1, n.t("fail no such file or directory ", null, str, null));
                }
                File file2 = new File(sI2);
                if (file2.exists()) {
                    file2.delete();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(sW);
                cs.result = arrayList;
                cs.errMsg = "ok";
            }
            return cs;
        }
        return P;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [813=4] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v11, resolved type: java.io.FileOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private c cs(String str, String str2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream3 = null;
        String sI = sI(str);
        String sI2 = sI(str2);
        if (TextUtils.isEmpty(sI)) {
            return ah(-1, n.t("fail no such file or directory ", null, str, null));
        }
        if (TextUtils.isEmpty(sI2)) {
            return ah(-1, n.t("fail no such file or directory ", null, str2, null));
        }
        c ah = ah(0, "ok");
        try {
            File file = new File(sI2);
            fileInputStream = new FileInputStream(new File(sI));
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
            com.baidu.swan.d.d.closeSafely(fileInputStream);
            com.baidu.swan.d.d.closeSafely(fileOutputStream);
            if (TextUtils.isEmpty(str2)) {
                ah.errMsg = "fail";
                ah.errCode = -1;
                return ah;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            ah.result = arrayList;
            return ah;
        } catch (IOException e3) {
            e = e3;
            fileInputStream3 = fileInputStream;
            fileInputStream2 = fileOutputStream;
            try {
                e.printStackTrace();
                c ah2 = ah(-1, "fail");
                com.baidu.swan.d.d.closeSafely(fileInputStream3);
                com.baidu.swan.d.d.closeSafely(fileInputStream2);
                if (TextUtils.isEmpty("")) {
                    ah.errMsg = "fail";
                    ah.errCode = -1;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(str2);
                    ah.result = arrayList2;
                }
                return ah2;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream3;
                fileInputStream3 = fileInputStream2;
                com.baidu.swan.d.d.closeSafely(fileInputStream);
                com.baidu.swan.d.d.closeSafely(fileInputStream3);
                if (TextUtils.isEmpty("")) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(str2);
                    ah.result = arrayList3;
                } else {
                    ah.errMsg = "fail";
                    ah.errCode = -1;
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream3 = fileOutputStream;
            com.baidu.swan.d.d.closeSafely(fileInputStream);
            com.baidu.swan.d.d.closeSafely(fileInputStream3);
            if (TextUtils.isEmpty("")) {
            }
            throw th;
        }
    }

    public c ad(String str, boolean z) {
        c P = n.P(str, z ? "dirPath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (P == null) {
            String sW = n.sW(str);
            if (!n.sP(sW)) {
                return ah(-4, "fail permission denied, open " + str);
            }
            String sI = sI(sW);
            if (TextUtils.isEmpty(sI)) {
                return ah(-1, "fail no such file or directory " + str);
            }
            File file = new File(sI);
            if (!file.exists()) {
                return ah(-1, "fail no such file or directory " + str);
            }
            if (!file.isDirectory()) {
                return ah(-1, "fail no such file or directory " + str);
            }
            File[] listFiles = file.listFiles();
            ArrayList arrayList = new ArrayList();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2 != null && file2.exists()) {
                        arrayList.add(com.baidu.swan.d.d.getFileNameFromPath(file2.getAbsolutePath()));
                    }
                }
            }
            c ah = ah(0, "ok");
            ah.result = arrayList;
            return ah;
        }
        return P;
    }

    public c c(String str, boolean z, boolean z2) {
        boolean deleteFile;
        c P = n.P(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (P == null) {
            c sJ = sJ(str);
            if (sJ == null) {
                if (!n.sP(str)) {
                    return ah(-4, "fail permission denied, open " + str);
                }
                String sI = sI(str);
                if (TextUtils.isEmpty(sI)) {
                    return ah(-1, "fail no such file or directory " + str);
                }
                File file = new File(sI);
                if (!file.exists() || file.isFile()) {
                    return ah(-1, "fail no such file or directory " + str);
                }
                boolean d = d(file.listFiles());
                try {
                    if (!z && d) {
                        return ah(-1, "fail directory not empty ");
                    }
                    if (!z) {
                        deleteFile = file.delete();
                    } else {
                        deleteFile = com.baidu.swan.d.d.deleteFile(file);
                    }
                    if (!deleteFile) {
                        return ah(-1, "fail");
                    }
                    return ah(0, "ok");
                } catch (Exception e) {
                    return ah(-1, "fail");
                }
            }
            return sJ;
        }
        return P;
    }

    private boolean d(File[] fileArr) {
        return (fileArr == null || fileArr.length == 0) ? false : true;
    }

    public c r(String str, String str2, boolean z) {
        c P = n.P(str, z ? "filePath must be a string" : "fail file not found", z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of NULL;");
        if (P == null) {
            String sW = n.sW(str);
            if (!this.din.V(sW, true)) {
                return ah(-1, "fail permission denied, open " + str);
            }
            c aa = aa(sW, true);
            if (aa != null) {
                aa.errMsg = n.t("fail no such file or directory ", "open", str, null);
                return aa;
            }
            boolean isEmpty = TextUtils.isEmpty(str2);
            if (!isEmpty) {
                str2 = str2.toLowerCase();
                if ("binary".equals(str2)) {
                    str2 = "latin1";
                }
            }
            if (!isEmpty && !dil.contains(str2)) {
                return ah(-1, "fail Error: Unknown encoding: " + str2);
            }
            String sI = sI(sW);
            if (TextUtils.isEmpty(sI)) {
                return ah(-1, "fail no such file or directory " + str);
            }
            File file = new File(sI);
            String str3 = "";
            byte[] bArr = new byte[0];
            c ah = ah(0, "ok");
            try {
                if (TextUtils.isEmpty(str2)) {
                    bArr = n.sX(sI);
                } else if ("base64".equals(str2)) {
                    byte[] sX = n.sX(sI);
                    str3 = sX.length == 0 ? "" : Base64.encodeToString(sX, 2);
                    bArr = sX;
                } else if ("hex".equals(str2)) {
                    str3 = n.sS(sI);
                } else {
                    str3 = a(new FileInputStream(file), str2);
                }
                if (TextUtils.isEmpty(str2)) {
                    ah.dhr = bArr;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str3);
                    ah.result = arrayList;
                }
                return ah;
            } catch (Exception e) {
                e.printStackTrace();
                return ah(-1, "fail");
            }
        }
        return P;
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
            com.baidu.swan.d.d.closeSafely(fileInputStream);
        }
    }

    public c s(String str, String str2, boolean z) {
        c P = n.P(str, z ? "oldPath must be a string" : n.t("fail no such file or directory ", "rename", str, null), z ? " The argument must be string" : "fail parameter error: parameter.oldPath should be String instead of Undefined;");
        if (P == null) {
            c P2 = n.P(str2, z ? "newPath must be a string" : n.t("fail no such file or directory ", "rename", str2, null), z ? " The argument must be string" : "fail parameter error: parameter.newPath should be String instead of Undefined;");
            if (P2 == null) {
                String sW = n.sW(str);
                c sJ = sJ(sW);
                if (sJ != null) {
                    sJ.errMsg = n.t("fail permission denied, ", "rename", str, str2);
                    return sJ;
                }
                String sW2 = n.sW(str2);
                c sJ2 = sJ(sW2);
                if (sJ2 != null) {
                    sJ2.errMsg = n.t("fail permission denied, ", "rename", str, str2);
                    return sJ2;
                }
                c aa = aa(sW, false);
                if (aa != null) {
                    aa.errMsg = n.t("fail no such file or directory ", "rename", str, str2);
                    return aa;
                } else if (!n.sO(sW) || !n.sO(sW2)) {
                    return ah(-4, n.t("fail permission denied, ", "rename", str, str2));
                } else {
                    c ab = ab(sW2, false);
                    if (ab != null) {
                        ab.errMsg = n.t("fail no such file or directory ", "rename", str, str2);
                        return ab;
                    }
                    String sI = sI(sW);
                    if (TextUtils.isEmpty(sI)) {
                        return ah(-1, "fail no such file or directory " + str);
                    }
                    String sI2 = sI(sW2);
                    if (TextUtils.isEmpty(sI2)) {
                        return ah(-1, "fail no such file or directory " + str2);
                    }
                    File file = new File(sI);
                    File file2 = new File(sI2);
                    boolean exists = file2.exists();
                    if (!n.j(file, file2) || (file.isDirectory() && !exists && sK(sI2))) {
                        return ah(-1, "fail rename failed");
                    }
                    try {
                        if ((file2.isDirectory() && file2.listFiles() != null && file2.listFiles().length > 0) || !file.renameTo(file2)) {
                            return ah(-1, "fail rename failed");
                        }
                        return ah(0, "ok");
                    } catch (Exception e) {
                        return ah(-1, "fail");
                    }
                }
            }
            return P2;
        }
        return P;
    }

    public c t(String str, String str2, boolean z) {
        boolean z2 = true;
        c P = n.P(str, "srcPath must be a string", " The argument must be string");
        if (P == null) {
            c P2 = n.P(str2, "destPath must be a string", " The argument must be string");
            if (P2 == null) {
                String sW = n.sW(str);
                if (!this.din.V(sW, true)) {
                    return ah(-4, n.t("fail no such file or directory ", "copyFile", str, null));
                }
                String sW2 = n.sW(str2);
                if (!n.sO(sW2)) {
                    return ah(-4, n.t("fail permission denied, open ", "copyFile", str2, null));
                }
                c sJ = sJ(sW2);
                if (sJ == null) {
                    String sI = sI(sW);
                    if (TextUtils.isEmpty(sI)) {
                        return ah(-1, "fail no such file or directory " + str);
                    }
                    File file = new File(sI);
                    if (!file.exists() || !file.isFile()) {
                        return ah(-1, n.t("fail no such file or directory ", "copyFile", str, null));
                    }
                    c ab = ab(sW2, false);
                    if (ab != null) {
                        ab.errMsg = n.t("fail no such file or directory ", "copyFile", str2, null);
                        return ab;
                    } else if (sW2.endsWith(File.separator)) {
                        return ah(-1, n.t("fail permission denied, ", "copyFile", str, str2));
                    } else {
                        String sI2 = sI(sW2);
                        if (TextUtils.isEmpty(sI2)) {
                            return ah(-1, "fail no such file or directory " + str2);
                        }
                        File file2 = new File(sI2);
                        if (file2.exists() && file2.isDirectory()) {
                            if (d(file2.listFiles())) {
                                return ah(-1, n.t("fail permission denied, ", "copyFile", str, str2));
                            }
                            try {
                                file2.delete();
                            } catch (Exception e) {
                                return ah(-1, "fail");
                            }
                        }
                        long fileSize = n.getFileSize(sI);
                        if (sW.equals(sW2) || sW.startsWith(a.USER_DATA_PATH)) {
                            z2 = false;
                        }
                        if (z2 && this.dio.bD(fileSize)) {
                            return ah(-1, aEA());
                        }
                        c cs = !sW.equals(sW2) ? cs(sW, sW2) : ah(0, "ok");
                        if (z2 && cs != null && cs.errCode == 0) {
                            this.dio.bC(fileSize);
                            return cs;
                        }
                        return cs;
                    }
                }
                return sJ;
            }
            return P2;
        }
        return P;
    }

    public c b(String str, Object obj, String str2, boolean z) {
        c P = n.P(str, n.t("fail permission denied, open ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of NULL;");
        if (P == null) {
            String sW = n.sW(str);
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return ah(-1, "fail sdcard not mounted ");
            }
            c sJ = sJ(sW);
            if (sJ == null) {
                if (obj == null) {
                    return ah(-1, "fail TypeError: data argument must be a string, Buffer, ArrayBuffer, Array, or array-like object");
                }
                String sI = sI(sW);
                if (TextUtils.isEmpty(sI)) {
                    return ah(-1, "fail no such file or directory " + str);
                }
                File file = new File(sI);
                if (!file.exists()) {
                    return ah(-1, n.t("fail no such file or directory ", "open", str, null));
                }
                if (file.isDirectory()) {
                    return ah(-1, "fail illegal operation on a directory, open " + str);
                }
                return a(sW, obj, str2, true);
            }
            return sJ;
        }
        return P;
    }

    public c ae(String str, boolean z) {
        c P = n.P(str, z ? "path must be a string" : n.t("fail no such file or directory ", LogConfig.KEY_ACCESS, str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Undefined;");
        if (P == null) {
            String sW = n.sW(str);
            if (!this.din.V(sW, true)) {
                return ah(-4, n.t("fail no such file or directory ", LogConfig.KEY_ACCESS, str, null));
            }
            String sI = sI(sW);
            if (TextUtils.isEmpty(sI)) {
                return ah(-1, "fail no such file or directory " + str);
            }
            if (!new File(sI).exists()) {
                return ah(-1, n.t("fail no such file or directory ", LogConfig.KEY_ACCESS, str, null));
            }
            return ah(0, "ok");
        }
        return P;
    }

    public c af(String str, boolean z) {
        c P = n.P(str, z ? "path must be a string" : n.t("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Object;");
        if (P == null) {
            if (!n.sY(str) && !n.sP(str)) {
                return ah(-1, "fail permission denied, open " + str);
            }
            c aa = aa(str, false);
            if (aa == null) {
                j jVar = new j();
                String sI = sI(str);
                if (TextUtils.isEmpty(sI)) {
                    return ah(-1, n.t("fail no such file or directory ", null, str, null));
                }
                File file = new File(sI);
                jVar.gh(file.isDirectory());
                jVar.gi(file.isFile());
                return a(str, jVar);
            }
            return aa;
        }
        return P;
    }

    private c a(String str, j jVar) {
        String sI = sI(str);
        if (TextUtils.isEmpty(sI)) {
            return ah(-1, "fail no such file or directory " + str);
        }
        File file = new File(sI);
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                jVar.lastAccessedTime = Os.lstat(file.getAbsolutePath()).st_atime;
                jVar.lastModifiedTime = Os.lstat(file.getAbsolutePath()).st_mtime;
                jVar.mode = Os.lstat(file.getAbsolutePath()).st_mode;
                jVar.size = Os.lstat(file.getAbsolutePath()).st_size;
            } catch (Exception e) {
                e.printStackTrace();
                return ah(-1, "fail");
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
                return ah(-1, "fail");
            }
        }
        c ah = ah(0, "ok");
        ah.stats = jVar;
        ah.errMsg = "ok";
        return ah;
    }

    public c aEz() {
        String auR = this.din.auR();
        String sI = sI(a.USER_DATA_PATH);
        if (TextUtils.isEmpty(sI)) {
            return ah(-1, "path must be a string");
        }
        ArrayList arrayList = new ArrayList();
        for (String str : n.ag(sI, false)) {
            File file = new File(str);
            d dVar = new d();
            dVar.createTime = file.exists() ? file.lastModified() : 0L;
            String absolutePath = file.getAbsolutePath();
            if (file.exists() && !TextUtils.isEmpty(absolutePath) && !TextUtils.isEmpty(auR) && absolutePath.startsWith(auR)) {
                dVar.filePath = this.din.pU(absolutePath);
            }
            dVar.size = file.exists() ? file.length() : 0L;
            arrayList.add(dVar);
        }
        c ah = ah(0, "ok");
        ah.fileList = arrayList;
        return ah;
    }

    public c sM(String str) {
        c ah;
        c P = n.P(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Object;");
        if (P == null) {
            if (sJ(str) != null) {
                return ah(-4, "fail file not exist");
            }
            String sI = sI(str);
            if (TextUtils.isEmpty(sI)) {
                return ah(-1, "fail no such file or directory " + str);
            }
            File file = new File(sI);
            if (!file.exists() || file.isDirectory()) {
                return ah(-1, "fail file not exist");
            }
            long fileSize = n.getFileSize(sI);
            try {
                if (!file.delete()) {
                    ah = ah(-1, "fail");
                } else {
                    this.dio.bC(-fileSize);
                    ah = ah(0, "ok");
                }
                return ah;
            } catch (Exception e) {
                return ah(-1, "fail");
            }
        }
        return P;
    }

    public c sN(String str) {
        c P = n.P(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Undefined;");
        if (P == null) {
            String sW = n.sW(str);
            if (!this.din.V(sW, true)) {
                return ah(-4, "fail file not exist");
            }
            String sI = sI(sW);
            if (TextUtils.isEmpty(sI)) {
                return ah(-1, "fail no such file or directory " + str);
            }
            File file = new File(sI);
            if (!file.exists()) {
                return ah(-1, "fail file not exist");
            }
            if (file.isDirectory()) {
                return ah(-1, "fail " + str + " is directory");
            }
            c ah = ah(0, "ok");
            ah.size = file.exists() ? file.length() : 0L;
            ah.digest = file.exists() ? com.baidu.swan.d.e.toMd5(file, false) : null;
            return ah;
        }
        return P;
    }

    private String aEA() {
        String generateFileSizeText = com.baidu.swan.d.d.generateFileSizeText(this.dio.getMaxSize());
        return String.format("fail file size over %s", (TextUtils.isEmpty(generateFileSizeText) || TextUtils.equals(generateFileSizeText, FileUtils.UNKNOW)) ? "" : "");
    }
}
