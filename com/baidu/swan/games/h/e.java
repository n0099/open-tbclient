package com.baidu.swan.games.h;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.system.Os;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
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
    private static List<String> cnV = new ArrayList();
    private String cnU = l.getBasePath();
    private String cnW;
    private Context mContext;

    static {
        cnV.add("ascii");
        cnV.add("base64");
        cnV.add("binary");
        cnV.add("hex");
        cnV.add("utf-8");
        cnV.add("utf8");
        cnV.add("latin1");
        cnV.add("ucs2");
        cnV.add("ucs-2");
        cnV.add("utf16le");
        cnV.add("utf-16le");
    }

    public e(Context context, String str) {
        this.mContext = context;
        this.cnW = str;
    }

    private String oM(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith(a.USER_DATA_PATH)) {
            return l.oW(str);
        }
        if (str.startsWith("bdfile://tmp")) {
            return l.oX(str);
        }
        if (str.startsWith("bdfile://code")) {
            this.cnW = this.cnW.endsWith(File.separator) ? this.cnW.substring(0, this.cnW.length() - 1) : this.cnW;
            return this.cnW + str.substring("bdfile://code".length());
        }
        return "";
    }

    private c oN(String str) {
        c J = J(-1, "fail permission denied, open " + str);
        if (!TextUtils.isEmpty(str) && str.startsWith(a.USER_DATA_PATH)) {
            return null;
        }
        return J;
    }

    private c J(int i, String str) {
        c cVar = new c();
        cVar.errCode = i;
        cVar.errMsg = str;
        return cVar;
    }

    private c H(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            c cVar = new c();
            cVar.errCode = -1;
            cVar.errMsg = "fail no such file or directory " + str;
            return cVar;
        }
        String oM = oM(str);
        if (TextUtils.isEmpty(str)) {
            c cVar2 = new c();
            cVar2.errCode = -1;
            cVar2.errMsg = "fail no such file or directory " + str;
            return cVar2;
        }
        File file = new File(oM);
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

    private c I(String str, boolean z) {
        if (str.endsWith(File.separator)) {
            str = str.substring(0, str.length() - 1);
        }
        String oM = oM(str);
        if (TextUtils.isEmpty(oM)) {
            return J(-1, "fail no such file or directory " + str);
        }
        if (oM.contains(File.separator)) {
            File file = new File(oM.substring(0, oM.lastIndexOf(File.separator)));
            if (!z && (!file.exists() || (file.exists() && file.isFile()))) {
                return J(-1, "fail no such file or directory " + str);
            }
        }
        return null;
    }

    public c b(String str, boolean z, boolean z2) {
        boolean mkdir;
        c L = l.L(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (L == null) {
            c oN = oN(str);
            if (oN == null) {
                if (!l.oR(str)) {
                    return J(-4, "fail permission denied, open " + str);
                }
                String oM = oM(str);
                c I = I(str, z);
                if (I == null) {
                    File file = new File(oM);
                    if (file.exists()) {
                        return J(-1, "fail file already exists " + str);
                    }
                    try {
                        if (z) {
                            mkdir = file.mkdirs();
                        } else {
                            mkdir = file.mkdir();
                        }
                        if (!mkdir) {
                            return J(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                        }
                        return J(0, "ok");
                    } catch (Exception e) {
                        return J(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                    }
                }
                return I;
            }
            return oN;
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
        c oN = oN(str);
        if (oN != null) {
            return oN;
        }
        if (obj == null) {
            return J(-1, "The argument must be string or arrayBuffer");
        }
        int length = (a.USER_DATA_PATH + File.separator).length();
        if (!l.oR(str)) {
            return J(-4, "fail permission denied, open " + str.substring(length));
        }
        boolean z2 = obj instanceof byte[];
        if (!z2 && TextUtils.isEmpty(str2)) {
            str2 = "utf-8";
        }
        if (!TextUtils.isEmpty(str2)) {
            if ("binary".equals(str2.toLowerCase())) {
                str2 = "latin1";
            }
            if (!cnV.contains(str2.toLowerCase())) {
                return J(-1, "fail invalid encoding \"" + str2 + "\"");
            }
        }
        c I = I(str, false);
        if (I != null) {
            return I;
        }
        String oM = oM(str);
        if (TextUtils.isEmpty(oM)) {
            return J(-1, "fail no such file or directory " + str.substring(length));
        }
        long j = 0;
        if (!z2 && !TextUtils.isEmpty((String) obj)) {
            j = ((String) obj).getBytes().length;
        } else if (z2) {
            j = ((byte[]) obj).length;
        }
        if (l.aZ(j)) {
            return J(-1, "fail file size over 50M");
        }
        File file = new File(oM);
        if (file.exists() && file.isDirectory()) {
            return J(-1, " fail illegal operation on a directory, open " + str);
        }
        c J = J(0, "ok");
        try {
            if (z2) {
                byte[] bArr = (byte[]) obj;
                fileOutputStream = new FileOutputStream(oM, z);
                try {
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.flush();
                        fileOutputStream = fileOutputStream;
                    } catch (Exception e) {
                        bufferedWriter2 = fileOutputStream;
                        c J2 = J(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                        com.baidu.swan.d.c.closeSafely(bufferedWriter3);
                        com.baidu.swan.d.c.closeSafely(bufferedWriter2);
                        return J2;
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
                String[] bK = l.bK((String) obj, str2);
                if (bK == null || bK.length != 2) {
                    str3 = "utf-8";
                    str4 = "";
                } else {
                    String str5 = bK[0];
                    str3 = bK[1];
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
                        c J22 = J(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                        com.baidu.swan.d.c.closeSafely(bufferedWriter3);
                        com.baidu.swan.d.c.closeSafely(bufferedWriter2);
                        return J22;
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
                if (j > l.aoa()) {
                    l.aY(j - l.aoa());
                    l.ba(j);
                }
                com.baidu.swan.d.c.closeSafely(bufferedWriter3);
                com.baidu.swan.d.c.closeSafely(fileOutputStream);
                return J;
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

    public c J(String str, boolean z) {
        c J;
        c L = l.L(str, z ? "filePath must be a string" : l.t("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of Object;");
        if (L == null) {
            if (!l.oS(str)) {
                return J(-4, l.t("fail permission denied, open ", null, str, null));
            }
            c H = H(str, false);
            if (H == null) {
                c oN = oN(str);
                if (oN == null) {
                    String oM = oM(str);
                    if (TextUtils.isEmpty(oM)) {
                        return J(-1, l.t("fail no such file or directory ", null, str, null));
                    }
                    File file = new File(oM);
                    if (file.isDirectory()) {
                        return J(-1, l.t("fail operation not permitted ", "unlink", str, null));
                    }
                    long fileSize = l.getFileSize(oM);
                    try {
                        if (file.delete()) {
                            l.aY(-fileSize);
                            J = J(0, "ok");
                        } else {
                            J = J(-1, l.t(LivenessStat.TYPE_FACE_MATCH_FAIL, null, str, null));
                        }
                        return J;
                    } catch (Exception e) {
                        return J(-1, l.t(LivenessStat.TYPE_FACE_MATCH_FAIL, null, str, null));
                    }
                }
                return oN;
            }
            return H;
        }
        return L;
    }

    public c bG(String str, String str2) {
        c L = l.L(str, l.b("fail no such file or directory ", "unzip", str, str2, true), "fail parameter error: parameter.zipFilePath should be String instead of Object;");
        if (L == null) {
            c L2 = l.L(str2, l.b("fail no such file or directory ", "unzip", str, str2, true), "fail parameter error: parameter.targetPath should be String instead of Object;");
            if (L2 == null) {
                if (!str2.startsWith("bdfile://tmp") && !str2.startsWith(a.USER_DATA_PATH)) {
                    return J(-1, "fail permission denied, open " + str2);
                }
                String oZ = l.oZ(str);
                if (!oZ.startsWith("bdfile://tmp") && !oZ.startsWith(a.USER_DATA_PATH) && !oZ.startsWith("bdfile://code")) {
                    return J(-1, "fail permission denied, open " + str);
                }
                if (!l.oR(oZ)) {
                    return J(-4, l.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (!l.oR(str2)) {
                    return J(-4, l.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (oO(str2)) {
                    return J(-1, l.b("fail permission denied, ", "unzip", str, str2, true));
                }
                String oM = oM(oZ);
                String oM2 = oM(str2);
                if (TextUtils.isEmpty(oM)) {
                    return J(-1, l.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (TextUtils.isEmpty(oM2)) {
                    return J(-1, l.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                File file = new File(oM);
                if (!file.exists()) {
                    return J(-1, l.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (!oM.endsWith(".zip")) {
                    return J(-1, "fail unzip failed");
                }
                if (!file.isFile()) {
                    return J(-1, l.b("fail permission denied, ", "unzip", str, str2, true));
                }
                File file2 = new File(oM2);
                if (!file2.exists()) {
                    file2.mkdirs();
                } else if (file2.isFile()) {
                    return J(-1, "fail unzip failed");
                }
                List<String> N = l.N(oM2, true);
                if (!com.baidu.swan.d.c.unzipFile(oM, oM2)) {
                    return J(-1, "fail unzip failed");
                }
                if (str2.startsWith(a.USER_DATA_PATH)) {
                    List<String> N2 = l.N(oM2, true);
                    ArrayList arrayList = new ArrayList(N2.size());
                    long j = 0;
                    for (String str3 : N2) {
                        if (!N.contains(str3)) {
                            arrayList.add(str3);
                            j = l.getFileSize(str3) + j;
                        }
                    }
                    if (l.aZ(j)) {
                        l.deleteFiles(arrayList);
                        return J(-1, "fail file size over 50M");
                    }
                    l.aY(j);
                }
                return J(0, "ok");
            }
            return L2;
        }
        return L;
    }

    private boolean oO(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains(File.separator)) {
            return oP(str.substring(str.lastIndexOf(File.separator) + 1));
        }
        return oP(str);
    }

    private boolean oP(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(".")) {
            return false;
        }
        String[] split = str.split("\\.");
        return (split.length != 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) ? false : true;
    }

    public c p(String str, String str2, boolean z) {
        c L = l.L(str, z ? "tempFilePath must be a string" : "fail tempFilePath file not exist", z ? " The argument must be string" : "fail parameter error: parameter.tempFilePath should be String instead of Object;");
        if (L == null) {
            String oZ = l.oZ(str2);
            if (TextUtils.isEmpty(oZ)) {
                oZ = a.USER_DATA_PATH + File.separator + com.baidu.swan.d.c.getFileNameFromPath(str);
            }
            if (!oZ.startsWith(a.USER_DATA_PATH)) {
                return J(-1, l.t("fail permission denied, open ", null, str2, null));
            }
            if (!(!TextUtils.isEmpty(str) && (str.startsWith(new StringBuilder().append("bdfile://tmp").append(File.separator).toString()) || "bdfile://tmp".equals(str)))) {
                return J(-4, "fail it is not a tempFilePath");
            }
            c I = I(oZ, false);
            if (I != null) {
                return I;
            }
            c I2 = I(str, false);
            if (I2 != null) {
                return I2;
            }
            File file = new File(oM(oZ));
            if (a.USER_DATA_PATH.equals(oZ) || (file.exists() && file.isDirectory())) {
                return J(-1, l.t("fail Error: EISDIR: illegal operation on a directory, open ", null, str2, null));
            }
            c H = H(str, true);
            if (H != null) {
                H.errMsg = "fail no such file or directory ";
                return H;
            }
            String oM = oM(str);
            long fileSize = l.getFileSize(oM);
            if (l.aZ(fileSize)) {
                return J(-1, "fail file size over 50M");
            }
            if (!oZ.startsWith(a.USER_DATA_PATH) || l.oT(oZ)) {
                return J(-1, l.t("fail permission denied, open ", null, str2, null));
            }
            c I3 = I(oZ, false);
            if (I3 != null) {
                return I3;
            }
            c oN = oN(oZ);
            if (oN != null) {
                return oN;
            }
            c bH = bH(str, oZ);
            if (bH != null && bH.errCode == 0) {
                l.aY(fileSize);
                if (TextUtils.isEmpty(str)) {
                    return J(-1, l.t("fail no such file or directory ", null, str, null));
                }
                File file2 = new File(oM);
                if (file2.exists()) {
                    file2.delete();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(oZ);
                bH.result = arrayList;
                bH.errMsg = "ok";
            }
            return bH;
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
    private c bH(String str, String str2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream3 = null;
        String oM = oM(str);
        String oM2 = oM(str2);
        if (TextUtils.isEmpty(oM)) {
            return J(-1, l.t("fail no such file or directory ", null, str, null));
        }
        if (TextUtils.isEmpty(oM2)) {
            return J(-1, l.t("fail no such file or directory ", null, str2, null));
        }
        c J = J(0, "ok");
        try {
            File file = new File(oM2);
            fileInputStream = new FileInputStream(new File(oM));
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
                J.errMsg = LivenessStat.TYPE_FACE_MATCH_FAIL;
                J.errCode = -1;
                return J;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            J.result = arrayList;
            return J;
        } catch (IOException e3) {
            e = e3;
            fileInputStream3 = fileInputStream;
            fileInputStream2 = fileOutputStream;
            try {
                e.printStackTrace();
                c J2 = J(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                com.baidu.swan.d.c.closeSafely(fileInputStream3);
                com.baidu.swan.d.c.closeSafely(fileInputStream2);
                if (TextUtils.isEmpty("")) {
                    J.errMsg = LivenessStat.TYPE_FACE_MATCH_FAIL;
                    J.errCode = -1;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(str2);
                    J.result = arrayList2;
                }
                return J2;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream3;
                fileInputStream3 = fileInputStream2;
                com.baidu.swan.d.c.closeSafely(fileInputStream);
                com.baidu.swan.d.c.closeSafely(fileInputStream3);
                if (TextUtils.isEmpty("")) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(str2);
                    J.result = arrayList3;
                } else {
                    J.errMsg = LivenessStat.TYPE_FACE_MATCH_FAIL;
                    J.errCode = -1;
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

    public c K(String str, boolean z) {
        c L = l.L(str, z ? "dirPath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (L == null) {
            String oZ = l.oZ(str);
            if (!l.oS(oZ)) {
                return J(-4, "fail permission denied, open " + str);
            }
            String oM = oM(oZ);
            if (TextUtils.isEmpty(oM)) {
                return J(-1, "fail no such file or directory " + str);
            }
            File file = new File(oM);
            if (!file.exists()) {
                return J(-1, "fail no such file or directory " + str);
            }
            if (!file.isDirectory()) {
                return J(-1, "fail no such file or directory " + str);
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
            c J = J(0, "ok");
            J.result = arrayList;
            return J;
        }
        return L;
    }

    public c c(String str, boolean z, boolean z2) {
        boolean deleteFile;
        c L = l.L(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (L == null) {
            c oN = oN(str);
            if (oN == null) {
                if (!l.oS(str)) {
                    return J(-4, "fail permission denied, open " + str);
                }
                File file = new File(oM(str));
                if (!file.exists() || file.isFile()) {
                    return J(-1, "fail no such file or directory " + str);
                }
                boolean d = d(file.listFiles());
                try {
                    if (!z && d) {
                        return J(-1, "fail directory not empty ");
                    }
                    if (!z) {
                        deleteFile = file.delete();
                    } else {
                        deleteFile = com.baidu.swan.d.c.deleteFile(file);
                    }
                    if (!deleteFile) {
                        return J(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                    }
                    return J(0, "ok");
                } catch (Exception e) {
                    return J(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                }
            }
            return oN;
        }
        return L;
    }

    private boolean d(File[] fileArr) {
        return (fileArr == null || fileArr.length == 0) ? false : true;
    }

    public c q(String str, String str2, boolean z) {
        String str3;
        c L = l.L(str, z ? "filePath must be a string" : "fail file not found", z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of NULL;");
        if (L == null) {
            String oZ = l.oZ(str);
            if (!l.oR(oZ)) {
                return J(-1, "fail permission denied, open " + str);
            }
            c H = H(oZ, true);
            if (H != null) {
                H.errMsg = l.t("fail no such file or directory ", "open", str, null);
                return H;
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
            if (!isEmpty && !cnV.contains(str3)) {
                return J(-1, "fail Error: Unknown encoding: " + str3);
            }
            String oM = oM(oZ);
            if (TextUtils.isEmpty(oM)) {
                return J(-1, "fail no such file or directory " + str);
            }
            File file = new File(oM);
            String str4 = "";
            byte[] bArr = new byte[0];
            c J = J(0, "ok");
            try {
                if (TextUtils.isEmpty(str3)) {
                    bArr = l.pa(oM);
                } else {
                    String a = a(new FileInputStream(file), ("base64".equals(str3) || "hex".equals(str3)) ? "" : str3);
                    if (!TextUtils.isEmpty(a)) {
                        if ("base64".equals(str3)) {
                            str4 = new String(Base64.encode(a.getBytes(), 2), "utf-8");
                        } else if ("hex".equals(str3)) {
                            str4 = l.oV(oM);
                        }
                    }
                    str4 = a;
                }
                if (TextUtils.isEmpty(str3)) {
                    J.cnh = bArr;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str4);
                    J.result = arrayList;
                }
                return J;
            } catch (Exception e) {
                e.printStackTrace();
                return J(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
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

    public c r(String str, String str2, boolean z) {
        c L = l.L(str, z ? "oldPath must be a string" : l.t("fail no such file or directory ", "rename", str, null), z ? " The argument must be string" : "fail parameter error: parameter.oldPath should be String instead of Undefined;");
        if (L == null) {
            c L2 = l.L(str2, z ? "newPath must be a string" : l.t("fail no such file or directory ", "rename", str2, null), z ? " The argument must be string" : "fail parameter error: parameter.newPath should be String instead of Undefined;");
            if (L2 == null) {
                String oZ = l.oZ(str);
                c oN = oN(oZ);
                if (oN != null) {
                    oN.errMsg = l.t("fail permission denied, ", "rename", str, str2);
                    return oN;
                }
                String oZ2 = l.oZ(str2);
                c oN2 = oN(oZ2);
                if (oN2 != null) {
                    oN2.errMsg = l.t("fail permission denied, ", "rename", str, str2);
                    return oN2;
                }
                c H = H(oZ, false);
                if (H != null) {
                    H.errMsg = l.t("fail no such file or directory ", "rename", str, str2);
                    return H;
                } else if (!l.oR(oZ) || !l.oR(oZ2)) {
                    return J(-4, l.t("fail permission denied, ", "rename", str, str2));
                } else {
                    c I = I(oZ2, false);
                    if (I != null) {
                        I.errMsg = l.t("fail no such file or directory ", "rename", str, str2);
                        return I;
                    }
                    String oM = oM(oZ);
                    String oM2 = oM(oZ2);
                    File file = new File(oM);
                    File file2 = new File(oM2);
                    boolean exists = file2.exists();
                    if (!l.h(file, file2) || (file.isDirectory() && !exists && oO(oM2))) {
                        return J(-1, "fail rename failed");
                    }
                    try {
                        if ((file2.isDirectory() && file2.listFiles() != null && file2.listFiles().length > 0) || !file.renameTo(file2)) {
                            return J(-1, "fail rename failed");
                        }
                        return J(0, "ok");
                    } catch (Exception e) {
                        return J(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                    }
                }
            }
            return L2;
        }
        return L;
    }

    public c s(String str, String str2, boolean z) {
        c L = l.L(str, "srcPath must be a string", " The argument must be string");
        if (L == null) {
            c L2 = l.L(str2, "destPath must be a string", " The argument must be string");
            if (L2 == null) {
                String oZ = l.oZ(str);
                if (!l.oR(oZ)) {
                    return J(-4, l.t("fail no such file or directory ", "copyFile", str, null));
                }
                String oZ2 = l.oZ(str2);
                if (!l.oR(oZ2)) {
                    return J(-4, l.t("fail permission denied, open ", "copyFile", str2, null));
                }
                c oN = oN(oZ2);
                if (oN == null) {
                    String oM = oM(oZ);
                    File file = new File(oM);
                    if (!file.exists() || !file.isFile()) {
                        return J(-1, l.t("fail no such file or directory ", "copyFile", str, null));
                    }
                    c I = I(oZ2, false);
                    if (I != null) {
                        I.errMsg = l.t("fail no such file or directory ", "copyFile", str2, null);
                        return I;
                    } else if (oZ2.endsWith(File.separator)) {
                        return J(-1, l.t("fail permission denied, ", "copyFile", str, str2));
                    } else {
                        File file2 = new File(oM(oZ2));
                        if (file2.exists() && file2.isDirectory()) {
                            if (d(file2.listFiles())) {
                                return J(-1, l.t("fail permission denied, ", "copyFile", str, str2));
                            }
                            try {
                                file2.delete();
                            } catch (Exception e) {
                                return J(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                            }
                        }
                        long fileSize = l.getFileSize(oM);
                        boolean z2 = (oZ.equals(oZ2) || oZ.startsWith(a.USER_DATA_PATH)) ? false : true;
                        if (z2 && l.aZ(fileSize)) {
                            return J(-1, "fail file size over 50M");
                        }
                        c bH = !oZ.equals(oZ2) ? bH(oZ, oZ2) : J(0, "ok");
                        if (z2 && bH != null && bH.errCode == 0) {
                            l.aY(fileSize);
                            return bH;
                        }
                        return bH;
                    }
                }
                return oN;
            }
            return L2;
        }
        return L;
    }

    public c b(String str, Object obj, String str2, boolean z) {
        c L = l.L(str, l.t("fail permission denied, open ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of NULL;");
        if (L == null) {
            String oZ = l.oZ(str);
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return J(-1, "fail sdcard not mounted ");
            }
            c oN = oN(oZ);
            if (oN == null) {
                if (obj == null) {
                    return J(-1, "fail TypeError: data argument must be a string, Buffer, ArrayBuffer, Array, or array-like object");
                }
                File file = new File(oM(oZ));
                if (!file.exists()) {
                    return J(-1, l.t("fail no such file or directory ", "open", str, null));
                }
                if (file.isDirectory()) {
                    return J(-1, "fail illegal operation on a directory, open " + str);
                }
                return a(oZ, obj, str2, true);
            }
            return oN;
        }
        return L;
    }

    public c L(String str, boolean z) {
        c L = l.L(str, z ? "path must be a string" : l.t("fail no such file or directory ", LogConfig.KEY_ACCESS, str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Undefined;");
        if (L == null) {
            String oZ = l.oZ(str);
            if (!l.oR(oZ)) {
                return J(-4, l.t("fail no such file or directory ", LogConfig.KEY_ACCESS, str, null));
            }
            if (!new File(oM(oZ)).exists()) {
                return J(-1, l.t("fail no such file or directory ", LogConfig.KEY_ACCESS, str, null));
            }
            return J(0, "ok");
        }
        return L;
    }

    public c M(String str, boolean z) {
        c L = l.L(str, z ? "path must be a string" : l.t("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Object;");
        if (L == null) {
            if (!l.pb(str) && !l.oS(str)) {
                return J(-1, "fail permission denied, open " + str);
            }
            c H = H(str, false);
            if (H == null) {
                i iVar = new i();
                String oM = oM(str);
                if (TextUtils.isEmpty(oM)) {
                    return J(-1, l.t("fail no such file or directory ", null, str, null));
                }
                File file = new File(oM);
                iVar.eD(file.isDirectory());
                iVar.eE(file.isFile());
                return a(str, iVar);
            }
            return H;
        }
        return L;
    }

    private c a(String str, i iVar) {
        File file = new File(oM(str));
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                iVar.lastAccessedTime = Os.lstat(file.getAbsolutePath()).st_atime;
                iVar.lastModifiedTime = Os.lstat(file.getAbsolutePath()).st_mtime;
                iVar.mode = Os.lstat(file.getAbsolutePath()).st_mode;
                iVar.size = Os.lstat(file.getAbsolutePath()).st_size;
            } catch (Exception e) {
                e.printStackTrace();
                return J(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
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
                return J(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
            }
        }
        c J = J(0, "ok");
        J.stats = iVar;
        J.errMsg = "ok";
        return J;
    }

    public c oQ(String str) {
        c L = l.L(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Undefined;");
        if (L == null) {
            String oZ = l.oZ(str);
            if (!oZ.startsWith("bdfile://tmp") && !oZ.startsWith(a.USER_DATA_PATH) && !oZ.startsWith("bdfile://code")) {
                return J(-4, "fail file not exist");
            }
            File file = new File(oM(oZ));
            if (!file.exists()) {
                return J(-1, "fail file not exist");
            }
            if (file.isDirectory()) {
                return J(-1, "fail " + str + " is directory");
            }
            c J = J(0, "ok");
            J.size = file.exists() ? file.length() : 0L;
            J.digest = file.exists() ? com.baidu.swan.d.d.toMd5(file, false) : null;
            return J;
        }
        return L;
    }
}
