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
/* loaded from: classes11.dex */
public class f {
    private static List<String> cXP = new ArrayList();
    private String cXQ;
    private final com.baidu.swan.apps.storage.b.c cXR;
    private final com.baidu.swan.apps.storage.b.d cXS;
    private Context mContext;

    static {
        cXP.add("ascii");
        cXP.add("base64");
        cXP.add("binary");
        cXP.add("hex");
        cXP.add("utf-8");
        cXP.add("utf8");
        cXP.add("latin1");
        cXP.add("ucs2");
        cXP.add("ucs-2");
        cXP.add("utf16le");
        cXP.add("utf-16le");
    }

    public f(Context context, String str, @NonNull com.baidu.swan.apps.storage.b.c cVar) {
        this.mContext = context;
        this.cXQ = str;
        this.cXR = cVar;
        this.cXS = this.cXR.arK();
    }

    private String rB(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith("bdfile://code")) {
            this.cXQ = this.cXQ.endsWith(File.separator) ? this.cXQ.substring(0, this.cXQ.length() - 1) : this.cXQ;
            return this.cXQ + str.substring("bdfile://code".length());
        } else if (str.startsWith("bdfile://")) {
            return this.cXR.pa(str);
        } else {
            return "";
        }
    }

    private c rC(String str) {
        c ae = ae(-1, "fail permission denied, open " + str);
        if (!TextUtils.isEmpty(str) && str.startsWith(a.USER_DATA_PATH)) {
            return null;
        }
        return ae;
    }

    private c ae(int i, String str) {
        c cVar = new c();
        cVar.errCode = i;
        cVar.errMsg = str;
        return cVar;
    }

    private c Z(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            c cVar = new c();
            cVar.errCode = -1;
            cVar.errMsg = "fail no such file or directory " + str;
            return cVar;
        }
        String rB = rB(str);
        if (TextUtils.isEmpty(str)) {
            c cVar2 = new c();
            cVar2.errCode = -1;
            cVar2.errMsg = "fail no such file or directory " + str;
            return cVar2;
        }
        File file = new File(rB);
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

    private c aa(String str, boolean z) {
        if (str.endsWith(File.separator)) {
            str = str.substring(0, str.length() - 1);
        }
        String rB = rB(str);
        if (TextUtils.isEmpty(rB)) {
            return ae(-1, "fail no such file or directory " + str);
        }
        if (rB.contains(File.separator)) {
            File file = new File(rB.substring(0, rB.lastIndexOf(File.separator)));
            if (!z && (!file.exists() || (file.exists() && file.isFile()))) {
                return ae(-1, "fail no such file or directory " + str);
            }
        }
        return null;
    }

    public c b(String str, boolean z, boolean z2) {
        boolean mkdir;
        c O = n.O(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (O == null) {
            c rC = rC(str);
            if (rC == null) {
                if (!n.rH(str)) {
                    return ae(-4, "fail permission denied, open " + str);
                }
                String rB = rB(str);
                if (TextUtils.isEmpty(rB)) {
                    return ae(-1, "fail no such file or directory " + str);
                }
                c aa = aa(str, z);
                if (aa == null) {
                    File file = new File(rB);
                    if (file.exists()) {
                        return ae(-1, "fail file already exists " + str);
                    }
                    try {
                        if (z) {
                            mkdir = file.mkdirs();
                        } else {
                            mkdir = file.mkdir();
                        }
                        if (!mkdir) {
                            return ae(-1, "fail");
                        }
                        return ae(0, "ok");
                    } catch (Exception e) {
                        return ae(-1, "fail");
                    }
                }
                return aa;
            }
            return rC;
        }
        return O;
    }

    public c a(boolean z, String str, Object obj, String str2) {
        c O = n.O(str, z ? "filePath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        return O != null ? O : a(str, obj, str2, false);
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
        c rC = rC(str);
        if (rC != null) {
            return rC;
        }
        if (obj == null) {
            return ae(-1, "The argument must be string or arrayBuffer");
        }
        int length = (a.USER_DATA_PATH + File.separator).length();
        if (n.rH(str)) {
            boolean z2 = obj instanceof byte[];
            if (!z2 && TextUtils.isEmpty(str2)) {
                str2 = "utf-8";
            }
            if (!TextUtils.isEmpty(str2)) {
                if ("binary".equals(str2.toLowerCase())) {
                    str2 = "latin1";
                }
                if (!cXP.contains(str2.toLowerCase())) {
                    return ae(-1, "fail invalid encoding \"" + str2 + "\"");
                }
            }
            BufferedWriter bufferedWriter3 = null;
            Closeable closeable = null;
            c aa = aa(str, false);
            if (aa == null) {
                String rB = rB(str);
                if (TextUtils.isEmpty(rB)) {
                    return ae(-1, "fail no such file or directory " + str.substring(length));
                }
                long j = 0;
                if (!z2 && !TextUtils.isEmpty((String) obj)) {
                    j = ((String) obj).getBytes().length;
                } else if (z2) {
                    j = ((byte[]) obj).length;
                }
                if (this.cXR.arK().bs(j)) {
                    return ae(-1, azP());
                }
                File file = new File(rB);
                if (file.exists() && file.isDirectory()) {
                    return ae(-1, " fail illegal operation on a directory, open " + str);
                }
                long length2 = file.length();
                c ae = ae(0, "ok");
                try {
                    if (z2) {
                        byte[] bArr = (byte[]) obj;
                        FileOutputStream fileOutputStream2 = new FileOutputStream(rB, z);
                        try {
                            fileOutputStream2.write(bArr);
                            fileOutputStream2.flush();
                            bufferedWriter2 = null;
                            r2 = fileOutputStream2;
                        } catch (Exception e) {
                            fileOutputStream = fileOutputStream2;
                            bufferedWriter = null;
                            c ae2 = ae(-1, "fail");
                            com.baidu.swan.e.d.closeSafely(bufferedWriter);
                            com.baidu.swan.e.d.closeSafely(fileOutputStream);
                            return ae2;
                        } catch (Throwable th) {
                            closeable = fileOutputStream2;
                            th = th;
                            com.baidu.swan.e.d.closeSafely(bufferedWriter3);
                            com.baidu.swan.e.d.closeSafely(closeable);
                            throw th;
                        }
                    } else if (TextUtils.isEmpty((String) obj) || !TextUtils.equals("base64", str2)) {
                        String[] cq = n.cq((String) obj, str2);
                        if (cq == null || cq.length != 2) {
                            str3 = "utf-8";
                            str4 = "";
                        } else {
                            String str5 = cq[0];
                            str3 = cq[1];
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
                                c ae22 = ae(-1, "fail");
                                com.baidu.swan.e.d.closeSafely(bufferedWriter);
                                com.baidu.swan.e.d.closeSafely(fileOutputStream);
                                return ae22;
                            } catch (Throwable th2) {
                                th = th2;
                                closeable = fileOutputStream;
                                bufferedWriter3 = bufferedWriter;
                                com.baidu.swan.e.d.closeSafely(bufferedWriter3);
                                com.baidu.swan.e.d.closeSafely(closeable);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedWriter3 = bufferedWriter4;
                            com.baidu.swan.e.d.closeSafely(bufferedWriter3);
                            com.baidu.swan.e.d.closeSafely(closeable);
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
                            c ae222 = ae(-1, "fail");
                            com.baidu.swan.e.d.closeSafely(bufferedWriter);
                            com.baidu.swan.e.d.closeSafely(fileOutputStream);
                            return ae222;
                        } catch (Throwable th4) {
                            closeable = fileOutputStream3;
                            th = th4;
                            com.baidu.swan.e.d.closeSafely(bufferedWriter3);
                            com.baidu.swan.e.d.closeSafely(closeable);
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
                        this.cXS.br(j);
                    } else {
                        this.cXS.br(j - length2);
                    }
                    com.baidu.swan.e.d.closeSafely(bufferedWriter2);
                    com.baidu.swan.e.d.closeSafely(r2);
                    r2 = ae;
                    return r2;
                } catch (Exception e5) {
                    fileOutputStream = r2;
                    bufferedWriter = bufferedWriter2;
                    c ae2222 = ae(-1, "fail");
                    com.baidu.swan.e.d.closeSafely(bufferedWriter);
                    com.baidu.swan.e.d.closeSafely(fileOutputStream);
                    return ae2222;
                } catch (Throwable th6) {
                    bufferedWriter3 = bufferedWriter2;
                    closeable = r2;
                    th = th6;
                    com.baidu.swan.e.d.closeSafely(bufferedWriter3);
                    com.baidu.swan.e.d.closeSafely(closeable);
                    throw th;
                }
            }
            return aa;
        }
        return ae(-4, "fail permission denied, open " + str.substring(length));
    }

    public c ab(String str, boolean z) {
        c ae;
        c O = n.O(str, z ? "filePath must be a string" : n.t("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of Object;");
        if (O == null) {
            if (!n.rI(str)) {
                return ae(-4, n.t("fail permission denied, open ", null, str, null));
            }
            c Z = Z(str, false);
            if (Z == null) {
                c rC = rC(str);
                if (rC == null) {
                    String rB = rB(str);
                    if (TextUtils.isEmpty(rB)) {
                        return ae(-1, n.t("fail no such file or directory ", null, str, null));
                    }
                    File file = new File(rB);
                    if (file.isDirectory()) {
                        return ae(-1, n.t("fail operation not permitted ", "unlink", str, null));
                    }
                    long fileSize = n.getFileSize(rB);
                    try {
                        if (file.delete()) {
                            this.cXS.br(-fileSize);
                            ae = ae(0, "ok");
                        } else {
                            ae = ae(-1, n.t("fail", null, str, null));
                        }
                        return ae;
                    } catch (Exception e) {
                        return ae(-1, n.t("fail", null, str, null));
                    }
                }
                return rC;
            }
            return Z;
        }
        return O;
    }

    public c cm(String str, String str2) {
        c O = n.O(str, n.b("fail no such file or directory ", "unzip", str, str2, true), "fail parameter error: parameter.zipFilePath should be String instead of Object;");
        if (O == null) {
            c O2 = n.O(str2, n.b("fail no such file or directory ", "unzip", str, str2, true), "fail parameter error: parameter.targetPath should be String instead of Object;");
            if (O2 == null) {
                if (!str2.startsWith("bdfile://tmp") && !str2.startsWith(a.USER_DATA_PATH)) {
                    return ae(-1, "fail permission denied, open " + str2);
                }
                String rP = n.rP(str);
                if (!this.cXR.U(rP, true)) {
                    return ae(-4, n.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (!n.rH(str2)) {
                    return ae(-4, n.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (rD(str2)) {
                    return ae(-1, n.b("fail permission denied, ", "unzip", str, str2, true));
                }
                String rB = rB(rP);
                String rB2 = rB(str2);
                if (TextUtils.isEmpty(rB)) {
                    return ae(-1, n.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (TextUtils.isEmpty(rB2)) {
                    return ae(-1, n.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                File file = new File(rB);
                if (!file.exists()) {
                    return ae(-1, n.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (!rB.endsWith(".zip")) {
                    return ae(-1, "fail unzip failed");
                }
                if (!file.isFile()) {
                    return ae(-1, n.b("fail permission denied, ", "unzip", str, str2, true));
                }
                File file2 = new File(rB2);
                if (!file2.exists()) {
                    file2.mkdirs();
                } else if (file2.isFile()) {
                    return ae(-1, "fail unzip failed");
                }
                List<String> af = n.af(rB2, true);
                if (!com.baidu.swan.e.d.unzipFile(rB, rB2)) {
                    return ae(-1, "fail unzip failed");
                }
                if (str2.startsWith(a.USER_DATA_PATH)) {
                    List<String> af2 = n.af(rB2, true);
                    ArrayList arrayList = new ArrayList(af2.size());
                    long j = 0;
                    for (String str3 : af2) {
                        if (!af.contains(str3)) {
                            arrayList.add(str3);
                            j = n.getFileSize(str3) + j;
                        }
                    }
                    if (this.cXS.bs(j)) {
                        n.am(arrayList);
                        return ae(-1, azP());
                    }
                    this.cXS.br(j);
                }
                return ae(0, "ok");
            }
            return O2;
        }
        return O;
    }

    private boolean rD(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains(File.separator)) {
            return rE(str.substring(str.lastIndexOf(File.separator) + 1));
        }
        return rE(str);
    }

    private boolean rE(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(".")) {
            return false;
        }
        String[] split = str.split("\\.");
        return (split.length != 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) ? false : true;
    }

    public c q(String str, String str2, boolean z) {
        c O = n.O(str, z ? "tempFilePath must be a string" : "fail tempFilePath file not exist", z ? " The argument must be string" : "fail parameter error: parameter.tempFilePath should be String instead of Object;");
        if (O == null) {
            String rP = n.rP(str2);
            if (TextUtils.isEmpty(rP)) {
                rP = a.USER_DATA_PATH + File.separator + com.baidu.swan.e.d.getFileNameFromPath(str);
            }
            if (!rP.startsWith(a.USER_DATA_PATH)) {
                return ae(-1, n.t("fail permission denied, open ", null, str2, null));
            }
            if (!this.cXR.oK(str)) {
                return ae(-4, "fail it is not a tempFilePath");
            }
            c aa = aa(rP, false);
            if (aa != null) {
                return aa;
            }
            c aa2 = aa(str, false);
            if (aa2 != null) {
                return aa2;
            }
            String rB = rB(rP);
            if (TextUtils.isEmpty(rB)) {
                return ae(-1, "fail no such file or directory " + str2);
            }
            File file = new File(rB);
            if (a.USER_DATA_PATH.equals(rP) || (file.exists() && file.isDirectory())) {
                return ae(-1, n.t("fail Error: EISDIR: illegal operation on a directory, open ", null, str2, null));
            }
            c Z = Z(str, true);
            if (Z != null) {
                Z.errMsg = "fail no such file or directory ";
                return Z;
            }
            String rB2 = rB(str);
            if (TextUtils.isEmpty(rB2)) {
                return ae(-1, "fail no such file or directory " + str);
            }
            long fileSize = n.getFileSize(rB2);
            if (this.cXS.bs(fileSize)) {
                return ae(-1, azP());
            }
            if (!rP.startsWith(a.USER_DATA_PATH) || n.rJ(rP)) {
                return ae(-1, n.t("fail permission denied, open ", null, str2, null));
            }
            c aa3 = aa(rP, false);
            if (aa3 != null) {
                return aa3;
            }
            c rC = rC(rP);
            if (rC != null) {
                return rC;
            }
            c cn = cn(str, rP);
            if (cn != null && cn.errCode == 0) {
                this.cXS.br(fileSize);
                if (TextUtils.isEmpty(str)) {
                    return ae(-1, n.t("fail no such file or directory ", null, str, null));
                }
                File file2 = new File(rB2);
                if (file2.exists()) {
                    file2.delete();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(rP);
                cn.result = arrayList;
                cn.errMsg = "ok";
            }
            return cn;
        }
        return O;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [813=4] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v11, resolved type: java.io.FileOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private c cn(String str, String str2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream3 = null;
        String rB = rB(str);
        String rB2 = rB(str2);
        if (TextUtils.isEmpty(rB)) {
            return ae(-1, n.t("fail no such file or directory ", null, str, null));
        }
        if (TextUtils.isEmpty(rB2)) {
            return ae(-1, n.t("fail no such file or directory ", null, str2, null));
        }
        c ae = ae(0, "ok");
        try {
            File file = new File(rB2);
            fileInputStream = new FileInputStream(new File(rB));
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
            com.baidu.swan.e.d.closeSafely(fileInputStream);
            com.baidu.swan.e.d.closeSafely(fileOutputStream);
            if (TextUtils.isEmpty(str2)) {
                ae.errMsg = "fail";
                ae.errCode = -1;
                return ae;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            ae.result = arrayList;
            return ae;
        } catch (IOException e3) {
            e = e3;
            fileInputStream3 = fileInputStream;
            fileInputStream2 = fileOutputStream;
            try {
                e.printStackTrace();
                c ae2 = ae(-1, "fail");
                com.baidu.swan.e.d.closeSafely(fileInputStream3);
                com.baidu.swan.e.d.closeSafely(fileInputStream2);
                if (TextUtils.isEmpty("")) {
                    ae.errMsg = "fail";
                    ae.errCode = -1;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(str2);
                    ae.result = arrayList2;
                }
                return ae2;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream3;
                fileInputStream3 = fileInputStream2;
                com.baidu.swan.e.d.closeSafely(fileInputStream);
                com.baidu.swan.e.d.closeSafely(fileInputStream3);
                if (TextUtils.isEmpty("")) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(str2);
                    ae.result = arrayList3;
                } else {
                    ae.errMsg = "fail";
                    ae.errCode = -1;
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream3 = fileOutputStream;
            com.baidu.swan.e.d.closeSafely(fileInputStream);
            com.baidu.swan.e.d.closeSafely(fileInputStream3);
            if (TextUtils.isEmpty("")) {
            }
            throw th;
        }
    }

    public c ac(String str, boolean z) {
        c O = n.O(str, z ? "dirPath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (O == null) {
            String rP = n.rP(str);
            if (!n.rI(rP)) {
                return ae(-4, "fail permission denied, open " + str);
            }
            String rB = rB(rP);
            if (TextUtils.isEmpty(rB)) {
                return ae(-1, "fail no such file or directory " + str);
            }
            File file = new File(rB);
            if (!file.exists()) {
                return ae(-1, "fail no such file or directory " + str);
            }
            if (!file.isDirectory()) {
                return ae(-1, "fail no such file or directory " + str);
            }
            File[] listFiles = file.listFiles();
            ArrayList arrayList = new ArrayList();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2 != null && file2.exists()) {
                        arrayList.add(com.baidu.swan.e.d.getFileNameFromPath(file2.getAbsolutePath()));
                    }
                }
            }
            c ae = ae(0, "ok");
            ae.result = arrayList;
            return ae;
        }
        return O;
    }

    public c c(String str, boolean z, boolean z2) {
        boolean deleteFile;
        c O = n.O(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (O == null) {
            c rC = rC(str);
            if (rC == null) {
                if (!n.rI(str)) {
                    return ae(-4, "fail permission denied, open " + str);
                }
                String rB = rB(str);
                if (TextUtils.isEmpty(rB)) {
                    return ae(-1, "fail no such file or directory " + str);
                }
                File file = new File(rB);
                if (!file.exists() || file.isFile()) {
                    return ae(-1, "fail no such file or directory " + str);
                }
                boolean d = d(file.listFiles());
                try {
                    if (!z && d) {
                        return ae(-1, "fail directory not empty ");
                    }
                    if (!z) {
                        deleteFile = file.delete();
                    } else {
                        deleteFile = com.baidu.swan.e.d.deleteFile(file);
                    }
                    if (!deleteFile) {
                        return ae(-1, "fail");
                    }
                    return ae(0, "ok");
                } catch (Exception e) {
                    return ae(-1, "fail");
                }
            }
            return rC;
        }
        return O;
    }

    private boolean d(File[] fileArr) {
        return (fileArr == null || fileArr.length == 0) ? false : true;
    }

    public c r(String str, String str2, boolean z) {
        c O = n.O(str, z ? "filePath must be a string" : "fail file not found", z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of NULL;");
        if (O == null) {
            String rP = n.rP(str);
            if (!this.cXR.U(rP, true)) {
                return ae(-1, "fail permission denied, open " + str);
            }
            c Z = Z(rP, true);
            if (Z != null) {
                Z.errMsg = n.t("fail no such file or directory ", "open", str, null);
                return Z;
            }
            boolean isEmpty = TextUtils.isEmpty(str2);
            if (!isEmpty) {
                str2 = str2.toLowerCase();
                if ("binary".equals(str2)) {
                    str2 = "latin1";
                }
            }
            if (!isEmpty && !cXP.contains(str2)) {
                return ae(-1, "fail Error: Unknown encoding: " + str2);
            }
            String rB = rB(rP);
            if (TextUtils.isEmpty(rB)) {
                return ae(-1, "fail no such file or directory " + str);
            }
            File file = new File(rB);
            String str3 = "";
            byte[] bArr = new byte[0];
            c ae = ae(0, "ok");
            try {
                if (TextUtils.isEmpty(str2)) {
                    bArr = n.rQ(rB);
                } else if ("base64".equals(str2)) {
                    byte[] rQ = n.rQ(rB);
                    str3 = rQ.length == 0 ? "" : Base64.encodeToString(rQ, 2);
                    bArr = rQ;
                } else if ("hex".equals(str2)) {
                    str3 = n.rL(rB);
                } else {
                    str3 = a(new FileInputStream(file), str2);
                }
                if (TextUtils.isEmpty(str2)) {
                    ae.cWW = bArr;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str3);
                    ae.result = arrayList;
                }
                return ae;
            } catch (Exception e) {
                e.printStackTrace();
                return ae(-1, "fail");
            }
        }
        return O;
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
            com.baidu.swan.e.d.closeSafely(fileInputStream);
        }
    }

    public c s(String str, String str2, boolean z) {
        c O = n.O(str, z ? "oldPath must be a string" : n.t("fail no such file or directory ", "rename", str, null), z ? " The argument must be string" : "fail parameter error: parameter.oldPath should be String instead of Undefined;");
        if (O == null) {
            c O2 = n.O(str2, z ? "newPath must be a string" : n.t("fail no such file or directory ", "rename", str2, null), z ? " The argument must be string" : "fail parameter error: parameter.newPath should be String instead of Undefined;");
            if (O2 == null) {
                String rP = n.rP(str);
                c rC = rC(rP);
                if (rC != null) {
                    rC.errMsg = n.t("fail permission denied, ", "rename", str, str2);
                    return rC;
                }
                String rP2 = n.rP(str2);
                c rC2 = rC(rP2);
                if (rC2 != null) {
                    rC2.errMsg = n.t("fail permission denied, ", "rename", str, str2);
                    return rC2;
                }
                c Z = Z(rP, false);
                if (Z != null) {
                    Z.errMsg = n.t("fail no such file or directory ", "rename", str, str2);
                    return Z;
                } else if (!n.rH(rP) || !n.rH(rP2)) {
                    return ae(-4, n.t("fail permission denied, ", "rename", str, str2));
                } else {
                    c aa = aa(rP2, false);
                    if (aa != null) {
                        aa.errMsg = n.t("fail no such file or directory ", "rename", str, str2);
                        return aa;
                    }
                    String rB = rB(rP);
                    if (TextUtils.isEmpty(rB)) {
                        return ae(-1, "fail no such file or directory " + str);
                    }
                    String rB2 = rB(rP2);
                    if (TextUtils.isEmpty(rB2)) {
                        return ae(-1, "fail no such file or directory " + str2);
                    }
                    File file = new File(rB);
                    File file2 = new File(rB2);
                    boolean exists = file2.exists();
                    if (!n.i(file, file2) || (file.isDirectory() && !exists && rD(rB2))) {
                        return ae(-1, "fail rename failed");
                    }
                    try {
                        if ((file2.isDirectory() && file2.listFiles() != null && file2.listFiles().length > 0) || !file.renameTo(file2)) {
                            return ae(-1, "fail rename failed");
                        }
                        return ae(0, "ok");
                    } catch (Exception e) {
                        return ae(-1, "fail");
                    }
                }
            }
            return O2;
        }
        return O;
    }

    public c t(String str, String str2, boolean z) {
        boolean z2 = true;
        c O = n.O(str, "srcPath must be a string", " The argument must be string");
        if (O == null) {
            c O2 = n.O(str2, "destPath must be a string", " The argument must be string");
            if (O2 == null) {
                String rP = n.rP(str);
                if (!this.cXR.U(rP, true)) {
                    return ae(-4, n.t("fail no such file or directory ", "copyFile", str, null));
                }
                String rP2 = n.rP(str2);
                if (!n.rH(rP2)) {
                    return ae(-4, n.t("fail permission denied, open ", "copyFile", str2, null));
                }
                c rC = rC(rP2);
                if (rC == null) {
                    String rB = rB(rP);
                    if (TextUtils.isEmpty(rB)) {
                        return ae(-1, "fail no such file or directory " + str);
                    }
                    File file = new File(rB);
                    if (!file.exists() || !file.isFile()) {
                        return ae(-1, n.t("fail no such file or directory ", "copyFile", str, null));
                    }
                    c aa = aa(rP2, false);
                    if (aa != null) {
                        aa.errMsg = n.t("fail no such file or directory ", "copyFile", str2, null);
                        return aa;
                    } else if (rP2.endsWith(File.separator)) {
                        return ae(-1, n.t("fail permission denied, ", "copyFile", str, str2));
                    } else {
                        String rB2 = rB(rP2);
                        if (TextUtils.isEmpty(rB2)) {
                            return ae(-1, "fail no such file or directory " + str2);
                        }
                        File file2 = new File(rB2);
                        if (file2.exists() && file2.isDirectory()) {
                            if (d(file2.listFiles())) {
                                return ae(-1, n.t("fail permission denied, ", "copyFile", str, str2));
                            }
                            try {
                                file2.delete();
                            } catch (Exception e) {
                                return ae(-1, "fail");
                            }
                        }
                        long fileSize = n.getFileSize(rB);
                        if (rP.equals(rP2) || rP.startsWith(a.USER_DATA_PATH)) {
                            z2 = false;
                        }
                        if (z2 && this.cXS.bs(fileSize)) {
                            return ae(-1, azP());
                        }
                        c cn = !rP.equals(rP2) ? cn(rP, rP2) : ae(0, "ok");
                        if (z2 && cn != null && cn.errCode == 0) {
                            this.cXS.br(fileSize);
                            return cn;
                        }
                        return cn;
                    }
                }
                return rC;
            }
            return O2;
        }
        return O;
    }

    public c b(String str, Object obj, String str2, boolean z) {
        c O = n.O(str, n.t("fail permission denied, open ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of NULL;");
        if (O == null) {
            String rP = n.rP(str);
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return ae(-1, "fail sdcard not mounted ");
            }
            c rC = rC(rP);
            if (rC == null) {
                if (obj == null) {
                    return ae(-1, "fail TypeError: data argument must be a string, Buffer, ArrayBuffer, Array, or array-like object");
                }
                String rB = rB(rP);
                if (TextUtils.isEmpty(rB)) {
                    return ae(-1, "fail no such file or directory " + str);
                }
                File file = new File(rB);
                if (!file.exists()) {
                    return ae(-1, n.t("fail no such file or directory ", "open", str, null));
                }
                if (file.isDirectory()) {
                    return ae(-1, "fail illegal operation on a directory, open " + str);
                }
                return a(rP, obj, str2, true);
            }
            return rC;
        }
        return O;
    }

    public c ad(String str, boolean z) {
        c O = n.O(str, z ? "path must be a string" : n.t("fail no such file or directory ", LogConfig.KEY_ACCESS, str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Undefined;");
        if (O == null) {
            String rP = n.rP(str);
            if (!this.cXR.U(rP, true)) {
                return ae(-4, n.t("fail no such file or directory ", LogConfig.KEY_ACCESS, str, null));
            }
            String rB = rB(rP);
            if (TextUtils.isEmpty(rB)) {
                return ae(-1, "fail no such file or directory " + str);
            }
            if (!new File(rB).exists()) {
                return ae(-1, n.t("fail no such file or directory ", LogConfig.KEY_ACCESS, str, null));
            }
            return ae(0, "ok");
        }
        return O;
    }

    public c ae(String str, boolean z) {
        c O = n.O(str, z ? "path must be a string" : n.t("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Object;");
        if (O == null) {
            if (!n.rR(str) && !n.rI(str)) {
                return ae(-1, "fail permission denied, open " + str);
            }
            c Z = Z(str, false);
            if (Z == null) {
                j jVar = new j();
                String rB = rB(str);
                if (TextUtils.isEmpty(rB)) {
                    return ae(-1, n.t("fail no such file or directory ", null, str, null));
                }
                File file = new File(rB);
                jVar.fL(file.isDirectory());
                jVar.fM(file.isFile());
                return a(str, jVar);
            }
            return Z;
        }
        return O;
    }

    private c a(String str, j jVar) {
        String rB = rB(str);
        if (TextUtils.isEmpty(rB)) {
            return ae(-1, "fail no such file or directory " + str);
        }
        File file = new File(rB);
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                jVar.lastAccessedTime = Os.lstat(file.getAbsolutePath()).st_atime;
                jVar.lastModifiedTime = Os.lstat(file.getAbsolutePath()).st_mtime;
                jVar.mode = Os.lstat(file.getAbsolutePath()).st_mode;
                jVar.size = Os.lstat(file.getAbsolutePath()).st_size;
            } catch (Exception e) {
                e.printStackTrace();
                return ae(-1, "fail");
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
                return ae(-1, "fail");
            }
        }
        c ae = ae(0, "ok");
        ae.stats = jVar;
        ae.errMsg = "ok";
        return ae;
    }

    public c azO() {
        String arJ = this.cXR.arJ();
        String rB = rB(a.USER_DATA_PATH);
        if (TextUtils.isEmpty(rB)) {
            return ae(-1, "path must be a string");
        }
        ArrayList arrayList = new ArrayList();
        for (String str : n.af(rB, false)) {
            File file = new File(str);
            d dVar = new d();
            dVar.createTime = file.exists() ? file.lastModified() : 0L;
            String absolutePath = file.getAbsolutePath();
            if (file.exists() && !TextUtils.isEmpty(absolutePath) && !TextUtils.isEmpty(arJ) && absolutePath.startsWith(arJ)) {
                dVar.filePath = this.cXR.pb(absolutePath);
            }
            dVar.size = file.exists() ? file.length() : 0L;
            arrayList.add(dVar);
        }
        c ae = ae(0, "ok");
        ae.fileList = arrayList;
        return ae;
    }

    public c rF(String str) {
        c ae;
        c O = n.O(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Object;");
        if (O == null) {
            if (rC(str) != null) {
                return ae(-4, "fail file not exist");
            }
            String rB = rB(str);
            if (TextUtils.isEmpty(rB)) {
                return ae(-1, "fail no such file or directory " + str);
            }
            File file = new File(rB);
            if (!file.exists() || file.isDirectory()) {
                return ae(-1, "fail file not exist");
            }
            long fileSize = n.getFileSize(rB);
            try {
                if (!file.delete()) {
                    ae = ae(-1, "fail");
                } else {
                    this.cXS.br(-fileSize);
                    ae = ae(0, "ok");
                }
                return ae;
            } catch (Exception e) {
                return ae(-1, "fail");
            }
        }
        return O;
    }

    public c rG(String str) {
        c O = n.O(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Undefined;");
        if (O == null) {
            String rP = n.rP(str);
            if (!this.cXR.U(rP, true)) {
                return ae(-4, "fail file not exist");
            }
            String rB = rB(rP);
            if (TextUtils.isEmpty(rB)) {
                return ae(-1, "fail no such file or directory " + str);
            }
            File file = new File(rB);
            if (!file.exists()) {
                return ae(-1, "fail file not exist");
            }
            if (file.isDirectory()) {
                return ae(-1, "fail " + str + " is directory");
            }
            c ae = ae(0, "ok");
            ae.size = file.exists() ? file.length() : 0L;
            ae.digest = file.exists() ? com.baidu.swan.e.e.toMd5(file, false) : null;
            return ae;
        }
        return O;
    }

    private String azP() {
        String generateFileSizeText = com.baidu.swan.e.d.generateFileSizeText(this.cXS.getMaxSize());
        return String.format("fail file size over %s", (TextUtils.isEmpty(generateFileSizeText) || TextUtils.equals(generateFileSizeText, FileUtils.UNKNOW)) ? "" : "");
    }
}
