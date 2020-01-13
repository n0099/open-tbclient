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
/* loaded from: classes10.dex */
public class e {
    private static List<String> cjE = new ArrayList();
    private String cjD = l.getBasePath();
    private String cjF;
    private Context mContext;

    static {
        cjE.add("ascii");
        cjE.add("base64");
        cjE.add("binary");
        cjE.add("hex");
        cjE.add("utf-8");
        cjE.add("utf8");
        cjE.add("latin1");
        cjE.add("ucs2");
        cjE.add("ucs-2");
        cjE.add("utf16le");
        cjE.add("utf-16le");
    }

    public e(Context context, String str) {
        this.mContext = context;
        this.cjF = str;
    }

    private String oy(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith(a.USER_DATA_PATH)) {
            return l.oI(str);
        }
        if (str.startsWith("bdfile://tmp")) {
            return l.oJ(str);
        }
        if (str.startsWith("bdfile://code")) {
            this.cjF = this.cjF.endsWith(File.separator) ? this.cjF.substring(0, this.cjF.length() - 1) : this.cjF;
            return this.cjF + str.substring("bdfile://code".length());
        }
        return "";
    }

    private c oz(String str) {
        c H = H(-1, "fail permission denied, open " + str);
        if (!TextUtils.isEmpty(str) && str.startsWith(a.USER_DATA_PATH)) {
            return null;
        }
        return H;
    }

    private c H(int i, String str) {
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
        String oy = oy(str);
        if (TextUtils.isEmpty(str)) {
            c cVar2 = new c();
            cVar2.errCode = -1;
            cVar2.errMsg = "fail no such file or directory " + str;
            return cVar2;
        }
        File file = new File(oy);
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
        String oy = oy(str);
        if (TextUtils.isEmpty(oy)) {
            return H(-1, "fail no such file or directory " + str);
        }
        if (oy.contains(File.separator)) {
            File file = new File(oy.substring(0, oy.lastIndexOf(File.separator)));
            if (!z && (!file.exists() || (file.exists() && file.isFile()))) {
                return H(-1, "fail no such file or directory " + str);
            }
        }
        return null;
    }

    public c b(String str, boolean z, boolean z2) {
        boolean mkdir;
        c K = l.K(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (K == null) {
            c oz = oz(str);
            if (oz == null) {
                if (!l.oD(str)) {
                    return H(-4, "fail permission denied, open " + str);
                }
                String oy = oy(str);
                c I = I(str, z);
                if (I == null) {
                    File file = new File(oy);
                    if (file.exists()) {
                        return H(-1, "fail file already exists " + str);
                    }
                    try {
                        if (z) {
                            mkdir = file.mkdirs();
                        } else {
                            mkdir = file.mkdir();
                        }
                        if (!mkdir) {
                            return H(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                        }
                        return H(0, "ok");
                    } catch (Exception e) {
                        return H(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                    }
                }
                return I;
            }
            return oz;
        }
        return K;
    }

    public c a(boolean z, String str, Object obj, String str2) {
        c K = l.K(str, z ? "filePath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        return K != null ? K : a(str, obj, str2, false);
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
        c oz = oz(str);
        if (oz != null) {
            return oz;
        }
        if (obj == null) {
            return H(-1, "The argument must be string or arrayBuffer");
        }
        int length = (a.USER_DATA_PATH + File.separator).length();
        if (!l.oD(str)) {
            return H(-4, "fail permission denied, open " + str.substring(length));
        }
        boolean z2 = obj instanceof byte[];
        if (!z2 && TextUtils.isEmpty(str2)) {
            str2 = "utf-8";
        }
        if (!TextUtils.isEmpty(str2)) {
            if ("binary".equals(str2.toLowerCase())) {
                str2 = "latin1";
            }
            if (!cjE.contains(str2.toLowerCase())) {
                return H(-1, "fail invalid encoding \"" + str2 + "\"");
            }
        }
        c I = I(str, false);
        if (I != null) {
            return I;
        }
        String oy = oy(str);
        if (TextUtils.isEmpty(oy)) {
            return H(-1, "fail no such file or directory " + str.substring(length));
        }
        long j = 0;
        if (!z2 && !TextUtils.isEmpty((String) obj)) {
            j = ((String) obj).getBytes().length;
        } else if (z2) {
            j = ((byte[]) obj).length;
        }
        if (l.aV(j)) {
            return H(-1, "fail file size over 50M");
        }
        File file = new File(oy);
        if (file.exists() && file.isDirectory()) {
            return H(-1, " fail illegal operation on a directory, open " + str);
        }
        c H = H(0, "ok");
        try {
            if (z2) {
                byte[] bArr = (byte[]) obj;
                fileOutputStream = new FileOutputStream(oy, z);
                try {
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.flush();
                        fileOutputStream = fileOutputStream;
                    } catch (Exception e) {
                        bufferedWriter2 = fileOutputStream;
                        c H2 = H(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                        com.baidu.swan.d.c.closeSafely(bufferedWriter3);
                        com.baidu.swan.d.c.closeSafely(bufferedWriter2);
                        return H2;
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
                String[] bC = l.bC((String) obj, str2);
                if (bC == null || bC.length != 2) {
                    str3 = "utf-8";
                    str4 = "";
                } else {
                    String str5 = bC[0];
                    str3 = bC[1];
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
                        c H22 = H(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                        com.baidu.swan.d.c.closeSafely(bufferedWriter3);
                        com.baidu.swan.d.c.closeSafely(bufferedWriter2);
                        return H22;
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
                if (j > l.alI()) {
                    l.aU(j - l.alI());
                    l.aW(j);
                }
                com.baidu.swan.d.c.closeSafely(bufferedWriter3);
                com.baidu.swan.d.c.closeSafely(fileOutputStream);
                return H;
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
        c H;
        c K = l.K(str, z ? "filePath must be a string" : l.q("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of Object;");
        if (K == null) {
            if (!l.oE(str)) {
                return H(-4, l.q("fail permission denied, open ", null, str, null));
            }
            c H2 = H(str, false);
            if (H2 == null) {
                c oz = oz(str);
                if (oz == null) {
                    String oy = oy(str);
                    if (TextUtils.isEmpty(oy)) {
                        return H(-1, l.q("fail no such file or directory ", null, str, null));
                    }
                    File file = new File(oy);
                    if (file.isDirectory()) {
                        return H(-1, l.q("fail operation not permitted ", "unlink", str, null));
                    }
                    long fileSize = l.getFileSize(oy);
                    try {
                        if (file.delete()) {
                            l.aU(-fileSize);
                            H = H(0, "ok");
                        } else {
                            H = H(-1, l.q(LivenessStat.TYPE_FACE_MATCH_FAIL, null, str, null));
                        }
                        return H;
                    } catch (Exception e) {
                        return H(-1, l.q(LivenessStat.TYPE_FACE_MATCH_FAIL, null, str, null));
                    }
                }
                return oz;
            }
            return H2;
        }
        return K;
    }

    public c by(String str, String str2) {
        c K = l.K(str, l.e("fail no such file or directory ", "unzip", str, str2, true), "fail parameter error: parameter.zipFilePath should be String instead of Object;");
        if (K == null) {
            c K2 = l.K(str2, l.e("fail no such file or directory ", "unzip", str, str2, true), "fail parameter error: parameter.targetPath should be String instead of Object;");
            if (K2 == null) {
                if (!str2.startsWith("bdfile://tmp") && !str2.startsWith(a.USER_DATA_PATH)) {
                    return H(-1, "fail permission denied, open " + str2);
                }
                String oL = l.oL(str);
                if (!oL.startsWith("bdfile://tmp") && !oL.startsWith(a.USER_DATA_PATH) && !oL.startsWith("bdfile://code")) {
                    return H(-1, "fail permission denied, open " + str);
                }
                if (!l.oD(oL)) {
                    return H(-4, l.e("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (!l.oD(str2)) {
                    return H(-4, l.e("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (oA(str2)) {
                    return H(-1, l.e("fail permission denied, ", "unzip", str, str2, true));
                }
                String oy = oy(oL);
                String oy2 = oy(str2);
                if (TextUtils.isEmpty(oy)) {
                    return H(-1, l.e("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (TextUtils.isEmpty(oy2)) {
                    return H(-1, l.e("fail no such file or directory ", "unzip", str, str2, true));
                }
                File file = new File(oy);
                if (!file.exists()) {
                    return H(-1, l.e("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (!oy.endsWith(".zip")) {
                    return H(-1, "fail unzip failed");
                }
                if (!file.isFile()) {
                    return H(-1, l.e("fail permission denied, ", "unzip", str, str2, true));
                }
                File file2 = new File(oy2);
                if (!file2.exists()) {
                    file2.mkdirs();
                } else if (file2.isFile()) {
                    return H(-1, "fail unzip failed");
                }
                List<String> N = l.N(oy2, true);
                if (!com.baidu.swan.d.c.unzipFile(oy, oy2)) {
                    return H(-1, "fail unzip failed");
                }
                if (str2.startsWith(a.USER_DATA_PATH)) {
                    List<String> N2 = l.N(oy2, true);
                    ArrayList arrayList = new ArrayList(N2.size());
                    long j = 0;
                    for (String str3 : N2) {
                        if (!N.contains(str3)) {
                            arrayList.add(str3);
                            j = l.getFileSize(str3) + j;
                        }
                    }
                    if (l.aV(j)) {
                        l.deleteFiles(arrayList);
                        return H(-1, "fail file size over 50M");
                    }
                    l.aU(j);
                }
                return H(0, "ok");
            }
            return K2;
        }
        return K;
    }

    private boolean oA(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains(File.separator)) {
            return oB(str.substring(str.lastIndexOf(File.separator) + 1));
        }
        return oB(str);
    }

    private boolean oB(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(".")) {
            return false;
        }
        String[] split = str.split("\\.");
        return (split.length != 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) ? false : true;
    }

    public c o(String str, String str2, boolean z) {
        c K = l.K(str, z ? "tempFilePath must be a string" : "fail tempFilePath file not exist", z ? " The argument must be string" : "fail parameter error: parameter.tempFilePath should be String instead of Object;");
        if (K == null) {
            String oL = l.oL(str2);
            if (TextUtils.isEmpty(oL)) {
                oL = a.USER_DATA_PATH + File.separator + com.baidu.swan.d.c.getFileNameFromPath(str);
            }
            if (!oL.startsWith(a.USER_DATA_PATH)) {
                return H(-1, l.q("fail permission denied, open ", null, str2, null));
            }
            if (!(!TextUtils.isEmpty(str) && (str.startsWith(new StringBuilder().append("bdfile://tmp").append(File.separator).toString()) || "bdfile://tmp".equals(str)))) {
                return H(-4, "fail it is not a tempFilePath");
            }
            c I = I(oL, false);
            if (I != null) {
                return I;
            }
            c I2 = I(str, false);
            if (I2 != null) {
                return I2;
            }
            File file = new File(oy(oL));
            if (a.USER_DATA_PATH.equals(oL) || (file.exists() && file.isDirectory())) {
                return H(-1, l.q("fail Error: EISDIR: illegal operation on a directory, open ", null, str2, null));
            }
            c H = H(str, true);
            if (H != null) {
                H.errMsg = "fail no such file or directory ";
                return H;
            }
            String oy = oy(str);
            long fileSize = l.getFileSize(oy);
            if (l.aV(fileSize)) {
                return H(-1, "fail file size over 50M");
            }
            if (!oL.startsWith(a.USER_DATA_PATH) || l.oF(oL)) {
                return H(-1, l.q("fail permission denied, open ", null, str2, null));
            }
            c I3 = I(oL, false);
            if (I3 != null) {
                return I3;
            }
            c oz = oz(oL);
            if (oz != null) {
                return oz;
            }
            c bz = bz(str, oL);
            if (bz != null && bz.errCode == 0) {
                l.aU(fileSize);
                if (TextUtils.isEmpty(str)) {
                    return H(-1, l.q("fail no such file or directory ", null, str, null));
                }
                File file2 = new File(oy);
                if (file2.exists()) {
                    file2.delete();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(oL);
                bz.result = arrayList;
                bz.errMsg = "ok";
            }
            return bz;
        }
        return K;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [776=4] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v11, resolved type: java.io.FileOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private c bz(String str, String str2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream3 = null;
        String oy = oy(str);
        String oy2 = oy(str2);
        if (TextUtils.isEmpty(oy)) {
            return H(-1, l.q("fail no such file or directory ", null, str, null));
        }
        if (TextUtils.isEmpty(oy2)) {
            return H(-1, l.q("fail no such file or directory ", null, str2, null));
        }
        c H = H(0, "ok");
        try {
            File file = new File(oy2);
            fileInputStream = new FileInputStream(new File(oy));
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
                H.errMsg = LivenessStat.TYPE_FACE_MATCH_FAIL;
                H.errCode = -1;
                return H;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            H.result = arrayList;
            return H;
        } catch (IOException e3) {
            e = e3;
            fileInputStream3 = fileInputStream;
            fileInputStream2 = fileOutputStream;
            try {
                e.printStackTrace();
                c H2 = H(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                com.baidu.swan.d.c.closeSafely(fileInputStream3);
                com.baidu.swan.d.c.closeSafely(fileInputStream2);
                if (TextUtils.isEmpty("")) {
                    H.errMsg = LivenessStat.TYPE_FACE_MATCH_FAIL;
                    H.errCode = -1;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(str2);
                    H.result = arrayList2;
                }
                return H2;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream3;
                fileInputStream3 = fileInputStream2;
                com.baidu.swan.d.c.closeSafely(fileInputStream);
                com.baidu.swan.d.c.closeSafely(fileInputStream3);
                if (TextUtils.isEmpty("")) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(str2);
                    H.result = arrayList3;
                } else {
                    H.errMsg = LivenessStat.TYPE_FACE_MATCH_FAIL;
                    H.errCode = -1;
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
        c K = l.K(str, z ? "dirPath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (K == null) {
            String oL = l.oL(str);
            if (!l.oE(oL)) {
                return H(-4, "fail permission denied, open " + str);
            }
            String oy = oy(oL);
            if (TextUtils.isEmpty(oy)) {
                return H(-1, "fail no such file or directory " + str);
            }
            File file = new File(oy);
            if (!file.exists()) {
                return H(-1, "fail no such file or directory " + str);
            }
            if (!file.isDirectory()) {
                return H(-1, "fail no such file or directory " + str);
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
            c H = H(0, "ok");
            H.result = arrayList;
            return H;
        }
        return K;
    }

    public c c(String str, boolean z, boolean z2) {
        boolean deleteFile;
        c K = l.K(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (K == null) {
            c oz = oz(str);
            if (oz == null) {
                if (!l.oE(str)) {
                    return H(-4, "fail permission denied, open " + str);
                }
                File file = new File(oy(str));
                if (!file.exists() || file.isFile()) {
                    return H(-1, "fail no such file or directory " + str);
                }
                boolean d = d(file.listFiles());
                try {
                    if (!z && d) {
                        return H(-1, "fail directory not empty ");
                    }
                    if (!z) {
                        deleteFile = file.delete();
                    } else {
                        deleteFile = com.baidu.swan.d.c.deleteFile(file);
                    }
                    if (!deleteFile) {
                        return H(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                    }
                    return H(0, "ok");
                } catch (Exception e) {
                    return H(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                }
            }
            return oz;
        }
        return K;
    }

    private boolean d(File[] fileArr) {
        return (fileArr == null || fileArr.length == 0) ? false : true;
    }

    public c p(String str, String str2, boolean z) {
        String str3;
        c K = l.K(str, z ? "filePath must be a string" : "fail file not found", z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of NULL;");
        if (K == null) {
            String oL = l.oL(str);
            if (!l.oD(oL)) {
                return H(-1, "fail permission denied, open " + str);
            }
            c H = H(oL, true);
            if (H != null) {
                H.errMsg = l.q("fail no such file or directory ", "open", str, null);
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
            if (!isEmpty && !cjE.contains(str3)) {
                return H(-1, "fail Error: Unknown encoding: " + str3);
            }
            String oy = oy(oL);
            if (TextUtils.isEmpty(oy)) {
                return H(-1, "fail no such file or directory " + str);
            }
            File file = new File(oy);
            String str4 = "";
            byte[] bArr = new byte[0];
            c H2 = H(0, "ok");
            try {
                if (TextUtils.isEmpty(str3)) {
                    bArr = l.oM(oy);
                } else {
                    String a = a(new FileInputStream(file), ("base64".equals(str3) || "hex".equals(str3)) ? "" : str3);
                    if (!TextUtils.isEmpty(a)) {
                        if ("base64".equals(str3)) {
                            str4 = new String(Base64.encode(a.getBytes(), 2), "utf-8");
                        } else if ("hex".equals(str3)) {
                            str4 = l.oH(oy);
                        }
                    }
                    str4 = a;
                }
                if (TextUtils.isEmpty(str3)) {
                    H2.ciQ = bArr;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str4);
                    H2.result = arrayList;
                }
                return H2;
            } catch (Exception e) {
                e.printStackTrace();
                return H(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
            }
        }
        return K;
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
        c K = l.K(str, z ? "oldPath must be a string" : l.q("fail no such file or directory ", "rename", str, null), z ? " The argument must be string" : "fail parameter error: parameter.oldPath should be String instead of Undefined;");
        if (K == null) {
            c K2 = l.K(str2, z ? "newPath must be a string" : l.q("fail no such file or directory ", "rename", str2, null), z ? " The argument must be string" : "fail parameter error: parameter.newPath should be String instead of Undefined;");
            if (K2 == null) {
                String oL = l.oL(str);
                c oz = oz(oL);
                if (oz != null) {
                    oz.errMsg = l.q("fail permission denied, ", "rename", str, str2);
                    return oz;
                }
                String oL2 = l.oL(str2);
                c oz2 = oz(oL2);
                if (oz2 != null) {
                    oz2.errMsg = l.q("fail permission denied, ", "rename", str, str2);
                    return oz2;
                }
                c H = H(oL, false);
                if (H != null) {
                    H.errMsg = l.q("fail no such file or directory ", "rename", str, str2);
                    return H;
                } else if (!l.oD(oL) || !l.oD(oL2)) {
                    return H(-4, l.q("fail permission denied, ", "rename", str, str2));
                } else {
                    c I = I(oL2, false);
                    if (I != null) {
                        I.errMsg = l.q("fail no such file or directory ", "rename", str, str2);
                        return I;
                    }
                    String oy = oy(oL);
                    String oy2 = oy(oL2);
                    File file = new File(oy);
                    File file2 = new File(oy2);
                    boolean exists = file2.exists();
                    if (!l.h(file, file2) || (file.isDirectory() && !exists && oA(oy2))) {
                        return H(-1, "fail rename failed");
                    }
                    try {
                        if ((file2.isDirectory() && file2.listFiles() != null && file2.listFiles().length > 0) || !file.renameTo(file2)) {
                            return H(-1, "fail rename failed");
                        }
                        return H(0, "ok");
                    } catch (Exception e) {
                        return H(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                    }
                }
            }
            return K2;
        }
        return K;
    }

    public c r(String str, String str2, boolean z) {
        c K = l.K(str, "srcPath must be a string", " The argument must be string");
        if (K == null) {
            c K2 = l.K(str2, "destPath must be a string", " The argument must be string");
            if (K2 == null) {
                String oL = l.oL(str);
                if (!l.oD(oL)) {
                    return H(-4, l.q("fail no such file or directory ", "copyFile", str, null));
                }
                String oL2 = l.oL(str2);
                if (!l.oD(oL2)) {
                    return H(-4, l.q("fail permission denied, open ", "copyFile", str2, null));
                }
                c oz = oz(oL2);
                if (oz == null) {
                    String oy = oy(oL);
                    File file = new File(oy);
                    if (!file.exists() || !file.isFile()) {
                        return H(-1, l.q("fail no such file or directory ", "copyFile", str, null));
                    }
                    c I = I(oL2, false);
                    if (I != null) {
                        I.errMsg = l.q("fail no such file or directory ", "copyFile", str2, null);
                        return I;
                    } else if (oL2.endsWith(File.separator)) {
                        return H(-1, l.q("fail permission denied, ", "copyFile", str, str2));
                    } else {
                        File file2 = new File(oy(oL2));
                        if (file2.exists() && file2.isDirectory()) {
                            if (d(file2.listFiles())) {
                                return H(-1, l.q("fail permission denied, ", "copyFile", str, str2));
                            }
                            try {
                                file2.delete();
                            } catch (Exception e) {
                                return H(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                            }
                        }
                        long fileSize = l.getFileSize(oy);
                        boolean z2 = (oL.equals(oL2) || oL.startsWith(a.USER_DATA_PATH)) ? false : true;
                        if (z2 && l.aV(fileSize)) {
                            return H(-1, "fail file size over 50M");
                        }
                        c bz = !oL.equals(oL2) ? bz(oL, oL2) : H(0, "ok");
                        if (z2 && bz != null && bz.errCode == 0) {
                            l.aU(fileSize);
                            return bz;
                        }
                        return bz;
                    }
                }
                return oz;
            }
            return K2;
        }
        return K;
    }

    public c b(String str, Object obj, String str2, boolean z) {
        c K = l.K(str, l.q("fail permission denied, open ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of NULL;");
        if (K == null) {
            String oL = l.oL(str);
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return H(-1, "fail sdcard not mounted ");
            }
            c oz = oz(oL);
            if (oz == null) {
                if (obj == null) {
                    return H(-1, "fail TypeError: data argument must be a string, Buffer, ArrayBuffer, Array, or array-like object");
                }
                File file = new File(oy(oL));
                if (!file.exists()) {
                    return H(-1, l.q("fail no such file or directory ", "open", str, null));
                }
                if (file.isDirectory()) {
                    return H(-1, "fail illegal operation on a directory, open " + str);
                }
                return a(oL, obj, str2, true);
            }
            return oz;
        }
        return K;
    }

    public c L(String str, boolean z) {
        c K = l.K(str, z ? "path must be a string" : l.q("fail no such file or directory ", LogConfig.KEY_ACCESS, str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Undefined;");
        if (K == null) {
            String oL = l.oL(str);
            if (!l.oD(oL)) {
                return H(-4, l.q("fail no such file or directory ", LogConfig.KEY_ACCESS, str, null));
            }
            if (!new File(oy(oL)).exists()) {
                return H(-1, l.q("fail no such file or directory ", LogConfig.KEY_ACCESS, str, null));
            }
            return H(0, "ok");
        }
        return K;
    }

    public c M(String str, boolean z) {
        c K = l.K(str, z ? "path must be a string" : l.q("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Object;");
        if (K == null) {
            if (!l.oN(str) && !l.oE(str)) {
                return H(-1, "fail permission denied, open " + str);
            }
            c H = H(str, false);
            if (H == null) {
                i iVar = new i();
                String oy = oy(str);
                if (TextUtils.isEmpty(oy)) {
                    return H(-1, l.q("fail no such file or directory ", null, str, null));
                }
                File file = new File(oy);
                iVar.ev(file.isDirectory());
                iVar.ew(file.isFile());
                return a(str, iVar);
            }
            return H;
        }
        return K;
    }

    private c a(String str, i iVar) {
        File file = new File(oy(str));
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                iVar.lastAccessedTime = Os.lstat(file.getAbsolutePath()).st_atime;
                iVar.lastModifiedTime = Os.lstat(file.getAbsolutePath()).st_mtime;
                iVar.mode = Os.lstat(file.getAbsolutePath()).st_mode;
                iVar.size = Os.lstat(file.getAbsolutePath()).st_size;
            } catch (Exception e) {
                e.printStackTrace();
                return H(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
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
                return H(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
            }
        }
        c H = H(0, "ok");
        H.stats = iVar;
        H.errMsg = "ok";
        return H;
    }

    public c oC(String str) {
        c K = l.K(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Undefined;");
        if (K == null) {
            String oL = l.oL(str);
            if (!oL.startsWith("bdfile://tmp") && !oL.startsWith(a.USER_DATA_PATH) && !oL.startsWith("bdfile://code")) {
                return H(-4, "fail file not exist");
            }
            File file = new File(oy(oL));
            if (!file.exists()) {
                return H(-1, "fail file not exist");
            }
            if (file.isDirectory()) {
                return H(-1, "fail " + str + " is directory");
            }
            c H = H(0, "ok");
            H.size = file.exists() ? file.length() : 0L;
            H.digest = file.exists() ? com.baidu.swan.d.d.toMd5(file, false) : null;
            return H;
        }
        return K;
    }
}
