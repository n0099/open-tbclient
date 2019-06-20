package com.baidu.swan.games.f;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.system.Os;
import android.text.TextUtils;
import android.util.Base64;
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
/* loaded from: classes2.dex */
public class e {
    private static List<String> bgF = new ArrayList();
    private String bgE = g.getBasePath();
    private String bgG;
    private Context mContext;

    static {
        bgF.add("ascii");
        bgF.add("base64");
        bgF.add("binary");
        bgF.add("hex");
        bgF.add("utf-8");
        bgF.add("utf8");
        bgF.add("latin1");
        bgF.add("ucs2");
        bgF.add("ucs-2");
        bgF.add("utf16le");
        bgF.add("utf-16le");
    }

    public e(Context context, String str) {
        this.mContext = context;
        this.bgG = str;
    }

    private String iY(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith(a.USER_DATA_PATH)) {
            return g.ji(str);
        }
        if (str.startsWith("bdfile://tmp")) {
            return g.jj(str);
        }
        if (str.startsWith("bdfile://code")) {
            this.bgG = this.bgG.endsWith(File.separator) ? this.bgG.substring(0, this.bgG.length() - 1) : this.bgG;
            return this.bgG + str.substring("bdfile://code".length());
        }
        return "";
    }

    private c iZ(String str) {
        c w = w(-1, "fail permission denied, open " + str);
        if (!TextUtils.isEmpty(str) && str.startsWith(a.USER_DATA_PATH)) {
            return null;
        }
        return w;
    }

    private c w(int i, String str) {
        c cVar = new c();
        cVar.errCode = i;
        cVar.errMsg = str;
        return cVar;
    }

    private c aX(String str, String str2) {
        if (g.ab(this.mContext, str2)) {
            return null;
        }
        c cVar = new c();
        cVar.errCode = -1;
        cVar.errMsg = "fail permission denied, open " + str;
        return cVar;
    }

    private c y(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            c cVar = new c();
            cVar.errCode = -1;
            cVar.errMsg = "fail no such file or directory " + str;
            return cVar;
        }
        String iY = iY(str);
        if (TextUtils.isEmpty(str)) {
            c cVar2 = new c();
            cVar2.errCode = -1;
            cVar2.errMsg = "fail no such file or directory " + str;
            return cVar2;
        }
        File file = new File(iY);
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

    private c z(String str, boolean z) {
        if (str.endsWith(File.separator)) {
            str = str.substring(0, str.length() - 1);
        }
        String iY = iY(str);
        if (TextUtils.isEmpty(iY)) {
            return w(-1, "fail no such file or directory " + str);
        }
        if (iY.contains(File.separator)) {
            File file = new File(iY.substring(0, iY.lastIndexOf(File.separator)));
            if (!z && (!file.exists() || (file.exists() && file.isFile()))) {
                return w(-1, "fail no such file or directory " + str);
            }
        }
        return null;
    }

    public c b(String str, boolean z, boolean z2) {
        boolean mkdir;
        c aX = aX(str, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (aX == null) {
            c y = g.y(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
            if (y == null) {
                c iZ = iZ(str);
                if (iZ == null) {
                    if (!g.jd(str)) {
                        return w(-4, "fail permission denied, open " + str);
                    }
                    String iY = iY(str);
                    c z3 = z(str, z);
                    if (z3 == null) {
                        File file = new File(iY);
                        if (file.exists()) {
                            return w(-1, "fail file already exists " + str);
                        }
                        try {
                            if (z) {
                                mkdir = file.mkdirs();
                            } else {
                                mkdir = file.mkdir();
                            }
                            if (!mkdir) {
                                return w(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                            }
                            return w(0, "ok");
                        } catch (Exception e) {
                            return w(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                        }
                    }
                    return z3;
                }
                return iZ;
            }
            return y;
        }
        return aX;
    }

    public c a(boolean z, String str, Object obj, String str2) {
        c y = g.y(str, z ? "filePath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        return y != null ? y : a(str, obj, str2, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [448=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:88:0x01b0 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v25, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v77 */
    private c a(String str, Object obj, String str2, boolean z) {
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2;
        ?? fileOutputStream;
        String str3;
        String str4;
        BufferedWriter bufferedWriter3 = null;
        c aX = aX(str, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (aX != null) {
            return aX;
        }
        c iZ = iZ(str);
        if (iZ != null) {
            return iZ;
        }
        if (obj == null) {
            return w(-1, "The argument must be string or arrayBuffer");
        }
        int length = (a.USER_DATA_PATH + File.separator).length();
        if (!g.jd(str)) {
            return w(-4, "fail permission denied, open " + str.substring(length));
        }
        boolean z2 = obj instanceof byte[];
        if (!z2 && TextUtils.isEmpty(str2)) {
            str2 = "utf-8";
        }
        if (!TextUtils.isEmpty(str2)) {
            if ("binary".equals(str2.toLowerCase())) {
                str2 = "latin1";
            }
            if (!bgF.contains(str2.toLowerCase())) {
                return w(-1, "fail invalid encoding \"" + str2 + "\"");
            }
        }
        c z3 = z(str, false);
        if (z3 != null) {
            return z3;
        }
        String iY = iY(str);
        if (TextUtils.isEmpty(iY)) {
            return w(-1, "fail no such file or directory " + str.substring(length));
        }
        long j = 0;
        if (!z2 && !TextUtils.isEmpty((String) obj)) {
            j = ((String) obj).getBytes().length;
        } else if (z2) {
            j = ((byte[]) obj).length;
        }
        if (g.ad(j)) {
            return w(-1, "fail file size over 50M");
        }
        File file = new File(iY);
        if (file.exists() && file.isDirectory()) {
            return w(-1, " fail illegal operation on a directory, open " + str);
        }
        c w = w(0, "ok");
        try {
            if (z2) {
                byte[] bArr = (byte[]) obj;
                fileOutputStream = new FileOutputStream(iY, z);
                try {
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.flush();
                        fileOutputStream = fileOutputStream;
                    } catch (Throwable th) {
                        bufferedWriter = null;
                        bufferedWriter3 = fileOutputStream;
                        th = th;
                        com.baidu.swan.c.a.c(bufferedWriter);
                        com.baidu.swan.c.a.c(bufferedWriter3);
                        throw th;
                    }
                } catch (Exception e) {
                    bufferedWriter2 = fileOutputStream;
                    c w2 = w(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                    com.baidu.swan.c.a.c(bufferedWriter3);
                    com.baidu.swan.c.a.c(bufferedWriter2);
                    return w2;
                }
            } else {
                String[] bb = g.bb((String) obj, str2);
                if (bb == null || bb.length != 2) {
                    str3 = "utf-8";
                    str4 = "";
                } else {
                    String str5 = bb[0];
                    str3 = bb[1];
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
                        c w22 = w(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                        com.baidu.swan.c.a.c(bufferedWriter3);
                        com.baidu.swan.c.a.c(bufferedWriter2);
                        return w22;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedWriter = bufferedWriter3;
                        bufferedWriter3 = bufferedWriter2;
                        com.baidu.swan.c.a.c(bufferedWriter);
                        com.baidu.swan.c.a.c(bufferedWriter3);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.baidu.swan.c.a.c(bufferedWriter);
                    com.baidu.swan.c.a.c(bufferedWriter3);
                    throw th;
                }
            }
            try {
                g.ac(j);
                com.baidu.swan.c.a.c(bufferedWriter3);
                com.baidu.swan.c.a.c(fileOutputStream);
                return w;
            } catch (Throwable th4) {
                bufferedWriter = bufferedWriter3;
                bufferedWriter3 = fileOutputStream;
                th = th4;
                com.baidu.swan.c.a.c(bufferedWriter);
                com.baidu.swan.c.a.c(bufferedWriter3);
                throw th;
            }
        } catch (Exception e3) {
            bufferedWriter2 = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedWriter = null;
        }
    }

    public c A(String str, boolean z) {
        c w;
        c aX = aX(str, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (aX == null) {
            c y = g.y(str, z ? "filePath must be a string" : g.l("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of Object;");
            if (y == null) {
                if (!g.je(str)) {
                    return w(-4, g.l("fail permission denied, open ", null, str, null));
                }
                c y2 = y(str, false);
                if (y2 == null) {
                    c iZ = iZ(str);
                    if (iZ == null) {
                        String iY = iY(str);
                        if (TextUtils.isEmpty(iY)) {
                            return w(-1, g.l("fail no such file or directory ", null, str, null));
                        }
                        File file = new File(iY);
                        if (file.isDirectory()) {
                            return w(-1, g.l("fail operation not permitted ", "unlink", str, null));
                        }
                        long jm = g.jm(iY);
                        try {
                            if (file.delete()) {
                                g.ac(-jm);
                                w = w(0, "ok");
                            } else {
                                w = w(-1, g.l(LivenessStat.TYPE_FACE_MATCH_FAIL, null, str, null));
                            }
                            return w;
                        } catch (Exception e) {
                            return w(-1, g.l(LivenessStat.TYPE_FACE_MATCH_FAIL, null, str, null));
                        }
                    }
                    return iZ;
                }
                return y2;
            }
            return y;
        }
        return aX;
    }

    public c aY(String str, String str2) {
        c y = g.y(str, g.b("fail no such file or directory ", "unzip", str, str2, true), "fail parameter error: parameter.zipFilePath should be String instead of Object;");
        if (y == null) {
            c y2 = g.y(str2, g.b("fail no such file or directory ", "unzip", str, str2, true), "fail parameter error: parameter.targetPath should be String instead of Object;");
            if (y2 == null) {
                if (!str2.startsWith(a.USER_DATA_PATH)) {
                    return w(-1, "fail permission denied, open " + str2);
                }
                String jn = g.jn(str);
                if (!jn.startsWith(a.USER_DATA_PATH) && !jn.startsWith("bdfile://code")) {
                    return w(-1, "fail permission denied, open " + str);
                }
                if (!g.jd(jn)) {
                    return w(-4, g.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (!g.jd(str2)) {
                    return w(-4, g.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (ja(str2)) {
                    return w(-1, g.b("fail permission denied, ", "unzip", str, str2, true));
                }
                c z = z(str2, false);
                if (z != null) {
                    z.errMsg = g.b("fail no such file or directory ", "unzip", str, str2, true);
                    return z;
                }
                String iY = iY(jn);
                String iY2 = iY(str2);
                if (TextUtils.isEmpty(iY)) {
                    return w(-1, g.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (TextUtils.isEmpty(iY2)) {
                    return w(-1, g.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                File file = new File(iY);
                if (!file.exists()) {
                    return w(-1, g.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (!iY.endsWith(".zip")) {
                    return w(-1, "fail unzip failed");
                }
                if (!file.isFile()) {
                    return w(-1, g.b("fail permission denied, ", "unzip", str, str2, true));
                }
                File file2 = new File(iY2);
                if (!file2.exists()) {
                    file2.mkdir();
                } else if (file2.isFile()) {
                    return w(-1, "fail unzip failed");
                }
                List<String> E = g.E(iY2, true);
                if (!com.baidu.swan.c.a.bs(iY, iY2)) {
                    return w(-1, "fail unzip failed");
                }
                List<String> E2 = g.E(iY2, true);
                ArrayList arrayList = new ArrayList(E2.size());
                long j = 0;
                for (String str3 : E2) {
                    if (!E.contains(str3)) {
                        arrayList.add(str3);
                        j = g.jm(str3) + j;
                    }
                }
                if (g.ad(j)) {
                    g.E(arrayList);
                    return w(-1, "fail file size over 50M");
                }
                g.ac(j);
                return w(0, "ok");
            }
            return y2;
        }
        return y;
    }

    private boolean ja(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains(File.separator)) {
            return jb(str.substring(str.lastIndexOf(File.separator) + 1));
        }
        return jb(str);
    }

    private boolean jb(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(".")) {
            return false;
        }
        String[] split = str.split("\\.");
        return (split.length != 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) ? false : true;
    }

    public c l(String str, String str2, boolean z) {
        c aX = aX(str2, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (aX == null) {
            c y = g.y(str, z ? "tempFilePath must be a string" : "fail tempFilePath file not exist", z ? " The argument must be string" : "fail parameter error: parameter.tempFilePath should be String instead of Object;");
            if (y == null) {
                String jn = g.jn(str2);
                if (TextUtils.isEmpty(jn)) {
                    jn = a.USER_DATA_PATH + File.separator + com.baidu.swan.c.a.kY(str);
                }
                if (!jn.startsWith(a.USER_DATA_PATH)) {
                    return w(-1, g.l("fail permission denied, open ", null, str2, null));
                }
                if (!(!TextUtils.isEmpty(str) && (str.startsWith(new StringBuilder().append("bdfile://tmp").append(File.separator).toString()) || "bdfile://tmp".equals(str)))) {
                    return w(-4, "fail it is not a tempFilePath");
                }
                c z2 = z(jn, false);
                if (z2 != null) {
                    return z2;
                }
                c z3 = z(str, false);
                if (z3 != null) {
                    return z3;
                }
                File file = new File(iY(jn));
                if (a.USER_DATA_PATH.equals(jn) || (file.exists() && file.isDirectory())) {
                    return w(-1, g.l("fail Error: EISDIR: illegal operation on a directory, open ", null, str2, null));
                }
                c y2 = y(str, true);
                if (y2 != null) {
                    y2.errMsg = "fail no such file or directory ";
                    return y2;
                }
                String iY = iY(str);
                long jm = g.jm(iY);
                if (g.ad(jm)) {
                    return w(-1, "fail file size over 50M");
                }
                if (!jn.startsWith(a.USER_DATA_PATH) || g.jf(jn)) {
                    return w(-1, g.l("fail permission denied, open ", null, str2, null));
                }
                c z4 = z(jn, false);
                if (z4 != null) {
                    return z4;
                }
                c iZ = iZ(jn);
                if (iZ != null) {
                    return iZ;
                }
                c aZ = aZ(str, jn);
                if (aZ != null && aZ.errCode == 0) {
                    g.ac(jm);
                    if (TextUtils.isEmpty(str)) {
                        return w(-1, g.l("fail no such file or directory ", null, str, null));
                    }
                    File file2 = new File(iY);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(jn);
                    aZ.bfT = arrayList;
                    aZ.errMsg = "ok";
                }
                return aZ;
            }
            return y;
        }
        return aX;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [813=4, 821=4] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v11, resolved type: java.io.FileOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private c aZ(String str, String str2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream3 = null;
        String iY = iY(str);
        String iY2 = iY(str2);
        if (TextUtils.isEmpty(iY)) {
            return w(-1, g.l("fail no such file or directory ", null, str, null));
        }
        if (TextUtils.isEmpty(iY2)) {
            return w(-1, g.l("fail no such file or directory ", null, str2, null));
        }
        c w = w(0, "ok");
        try {
            File file = new File(iY2);
            fileInputStream = new FileInputStream(new File(iY));
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
            com.baidu.swan.c.a.c(fileInputStream);
            com.baidu.swan.c.a.c(fileOutputStream);
            if (TextUtils.isEmpty(str2)) {
                w.errMsg = LivenessStat.TYPE_FACE_MATCH_FAIL;
                w.errCode = -1;
                return w;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            w.bfT = arrayList;
            return w;
        } catch (IOException e3) {
            e = e3;
            fileInputStream3 = fileInputStream;
            fileInputStream2 = fileOutputStream;
            try {
                e.printStackTrace();
                c w2 = w(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                com.baidu.swan.c.a.c(fileInputStream3);
                com.baidu.swan.c.a.c(fileInputStream2);
                if (TextUtils.isEmpty("")) {
                    w.errMsg = LivenessStat.TYPE_FACE_MATCH_FAIL;
                    w.errCode = -1;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(str2);
                    w.bfT = arrayList2;
                }
                return w2;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream3;
                fileInputStream3 = fileInputStream2;
                com.baidu.swan.c.a.c(fileInputStream);
                com.baidu.swan.c.a.c(fileInputStream3);
                if (TextUtils.isEmpty("")) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(str2);
                    w.bfT = arrayList3;
                } else {
                    w.errMsg = LivenessStat.TYPE_FACE_MATCH_FAIL;
                    w.errCode = -1;
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream3 = fileOutputStream;
            com.baidu.swan.c.a.c(fileInputStream);
            com.baidu.swan.c.a.c(fileInputStream3);
            if (TextUtils.isEmpty("")) {
            }
            throw th;
        }
    }

    public c B(String str, boolean z) {
        c aX = aX(str, "android.permission.READ_EXTERNAL_STORAGE");
        if (aX == null) {
            c y = g.y(str, z ? "dirPath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
            if (y == null) {
                String jn = g.jn(str);
                if (!g.je(jn)) {
                    return w(-4, "fail permission denied, open " + str);
                }
                String iY = iY(jn);
                if (TextUtils.isEmpty(iY)) {
                    return w(-1, "fail no such file or directory " + str);
                }
                File file = new File(iY);
                if (!file.exists()) {
                    return w(-1, "fail no such file or directory " + str);
                }
                if (!file.isDirectory()) {
                    return w(-1, "fail no such file or directory " + str);
                }
                File[] listFiles = file.listFiles();
                ArrayList arrayList = new ArrayList();
                for (File file2 : listFiles) {
                    if (file2.exists()) {
                        arrayList.add(com.baidu.swan.c.a.kY(file2.getAbsolutePath()));
                    }
                }
                c w = w(0, "ok");
                w.bfT = arrayList;
                return w;
            }
            return y;
        }
        return aX;
    }

    public c c(String str, boolean z, boolean z2) {
        boolean deleteFile;
        c aX = aX(str, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (aX == null) {
            c y = g.y(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
            if (y == null) {
                c iZ = iZ(str);
                if (iZ == null) {
                    if (!g.je(str)) {
                        return w(-4, "fail permission denied, open " + str);
                    }
                    File file = new File(iY(str));
                    if (!file.exists() || file.isFile()) {
                        return w(-1, "fail no such file or directory " + str);
                    }
                    boolean d = d(file.listFiles());
                    try {
                        if (!z && d) {
                            return w(-1, "fail directory not empty ");
                        }
                        if (!z) {
                            deleteFile = file.delete();
                        } else {
                            deleteFile = com.baidu.swan.c.a.deleteFile(file);
                        }
                        if (!deleteFile) {
                            return w(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                        }
                        return w(0, "ok");
                    } catch (Exception e) {
                        return w(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                    }
                }
                return iZ;
            }
            return y;
        }
        return aX;
    }

    private boolean d(File[] fileArr) {
        return (fileArr == null || fileArr.length == 0) ? false : true;
    }

    public c m(String str, String str2, boolean z) {
        String str3;
        c aX = aX(str, "android.permission.READ_EXTERNAL_STORAGE");
        if (aX == null) {
            c y = g.y(str, z ? "filePath must be a string" : "fail file not found", z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of NULL;");
            if (y == null) {
                String jn = g.jn(str);
                if (!g.jd(jn)) {
                    return w(-1, "fail permission denied, open " + str);
                }
                c y2 = y(jn, true);
                if (y2 != null) {
                    y2.errMsg = g.l("fail no such file or directory ", "open", str, null);
                    return y2;
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
                if (!isEmpty && !bgF.contains(str3)) {
                    return w(-1, "fail Error: Unknown encoding: " + str3);
                }
                String iY = iY(jn);
                if (TextUtils.isEmpty(iY)) {
                    return w(-1, "fail no such file or directory " + str);
                }
                File file = new File(iY);
                String str4 = "";
                byte[] bArr = new byte[0];
                c w = w(0, "ok");
                try {
                    if (TextUtils.isEmpty(str3)) {
                        bArr = g.jo(iY);
                    } else {
                        String a = a(new FileInputStream(file), ("base64".equals(str3) || "hex".equals(str3)) ? "" : str3);
                        if (!TextUtils.isEmpty(a)) {
                            if ("base64".equals(str3)) {
                                str4 = new String(Base64.encode(a.getBytes(), 2), "utf-8");
                            } else if ("hex".equals(str3)) {
                                str4 = g.jh(iY);
                            }
                        }
                        str4 = a;
                    }
                    if (TextUtils.isEmpty(str3)) {
                        w.bfU = bArr;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str4);
                        w.bfT = arrayList;
                    }
                    return w;
                } catch (Exception e) {
                    e.printStackTrace();
                    return w(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                }
            }
            return y;
        }
        return aX;
    }

    private String a(FileInputStream fileInputStream, String str) {
        if (fileInputStream == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(TextUtils.isEmpty(str) ? new InputStreamReader(fileInputStream) : new InputStreamReader(fileInputStream, str));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine).append("\n");
                }
                String substring = sb.length() > 0 ? sb.toString().substring(0, sb.length() - 1) : sb.toString();
                try {
                    fileInputStream.close();
                    return substring;
                } catch (IOException e) {
                    e.printStackTrace();
                    return substring;
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                throw th;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            try {
                fileInputStream.close();
                return "";
            } catch (IOException e4) {
                e4.printStackTrace();
                return "";
            }
        }
    }

    public c n(String str, String str2, boolean z) {
        c aX = aX(str, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (aX == null) {
            c aX2 = aX(str2, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (aX2 == null) {
                c y = g.y(str, z ? "oldPath must be a string" : g.l("fail no such file or directory ", "rename", str, null), z ? " The argument must be string" : "fail parameter error: parameter.oldPath should be String instead of Undefined;");
                if (y == null) {
                    c y2 = g.y(str2, z ? "newPath must be a string" : g.l("fail no such file or directory ", "rename", str2, null), z ? " The argument must be string" : "fail parameter error: parameter.newPath should be String instead of Undefined;");
                    if (y2 == null) {
                        String jn = g.jn(str);
                        c iZ = iZ(jn);
                        if (iZ != null) {
                            iZ.errMsg = g.l("fail permission denied, ", "rename", str, str2);
                            return iZ;
                        }
                        String jn2 = g.jn(str2);
                        c iZ2 = iZ(jn2);
                        if (iZ2 != null) {
                            iZ2.errMsg = g.l("fail permission denied, ", "rename", str, str2);
                            return iZ2;
                        }
                        c y3 = y(jn, false);
                        if (y3 != null) {
                            y3.errMsg = g.l("fail no such file or directory ", "rename", str, str2);
                            return y3;
                        } else if (!g.jd(jn) || !g.jd(jn2)) {
                            return w(-4, g.l("fail permission denied, ", "rename", str, str2));
                        } else {
                            c z2 = z(jn2, false);
                            if (z2 != null) {
                                z2.errMsg = g.l("fail no such file or directory ", "rename", str, str2);
                                return z2;
                            }
                            String iY = iY(jn);
                            String iY2 = iY(jn2);
                            File file = new File(iY);
                            File file2 = new File(iY2);
                            boolean exists = file2.exists();
                            if (!g.e(file, file2) || (file.isDirectory() && !exists && ja(iY2))) {
                                return w(-1, "fail rename failed");
                            }
                            try {
                                if ((file2.isDirectory() && file2.listFiles() != null && file2.listFiles().length > 0) || !file.renameTo(file2)) {
                                    return w(-1, "fail rename failed");
                                }
                                return w(0, "ok");
                            } catch (Exception e) {
                                return w(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                            }
                        }
                    }
                    return y2;
                }
                return y;
            }
            return aX2;
        }
        return aX;
    }

    public c o(String str, String str2, boolean z) {
        c aX = aX(str2, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (aX == null) {
            c y = g.y(str, "srcPath must be a string", " The argument must be string");
            if (y == null) {
                c y2 = g.y(str2, "destPath must be a string", " The argument must be string");
                if (y2 == null) {
                    String jn = g.jn(str);
                    if (!g.jd(jn)) {
                        return w(-4, g.l("fail no such file or directory ", "copyFile", str, null));
                    }
                    String jn2 = g.jn(str2);
                    if (!g.jd(jn2)) {
                        return w(-4, g.l("fail permission denied, open ", "copyFile", str2, null));
                    }
                    c iZ = iZ(jn2);
                    if (iZ == null) {
                        String iY = iY(jn);
                        File file = new File(iY);
                        if (!file.exists() || !file.isFile()) {
                            return w(-1, g.l("fail no such file or directory ", "copyFile", str, null));
                        }
                        c z2 = z(jn2, false);
                        if (z2 != null) {
                            z2.errMsg = g.l("fail no such file or directory ", "copyFile", str2, null);
                            return z2;
                        } else if (jn2.endsWith(File.separator)) {
                            return w(-1, g.l("fail permission denied, ", "copyFile", str, str2));
                        } else {
                            File file2 = new File(iY(jn2));
                            if (file2.exists() && file2.isDirectory()) {
                                if (d(file2.listFiles())) {
                                    return w(-1, g.l("fail permission denied, ", "copyFile", str, str2));
                                }
                                try {
                                    file2.delete();
                                } catch (Exception e) {
                                    return w(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                                }
                            }
                            long jm = g.jm(iY);
                            boolean z3 = (jn.equals(jn2) || jn.startsWith(a.USER_DATA_PATH)) ? false : true;
                            if (z3 && g.ad(jm)) {
                                return w(-1, "fail file size over 50M");
                            }
                            c aZ = !jn.equals(jn2) ? aZ(jn, jn2) : w(0, "ok");
                            if (z3 && aZ != null && aZ.errCode == 0) {
                                g.ac(jm);
                                return aZ;
                            }
                            return aZ;
                        }
                    }
                    return iZ;
                }
                return y2;
            }
            return y;
        }
        return aX;
    }

    public c b(String str, Object obj, String str2, boolean z) {
        c y = g.y(str, g.l("fail permission denied, open ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of NULL;");
        if (y == null) {
            c aX = aX(str, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (aX == null) {
                String jn = g.jn(str);
                if (!"mounted".equals(Environment.getExternalStorageState())) {
                    return w(-1, "fail sdcard not mounted ");
                }
                c iZ = iZ(jn);
                if (iZ == null) {
                    if (obj == null) {
                        return w(-1, "fail TypeError: data argument must be a string, Buffer, ArrayBuffer, Array, or array-like object");
                    }
                    File file = new File(iY(jn));
                    if (!file.exists()) {
                        return w(-1, g.l("fail no such file or directory ", "open", str, null));
                    }
                    if (file.isDirectory()) {
                        return w(-1, "fail illegal operation on a directory, open " + str);
                    }
                    return a(jn, obj, str2, true);
                }
                return iZ;
            }
            return aX;
        }
        return y;
    }

    public c C(String str, boolean z) {
        c aX = aX(str, "android.permission.READ_EXTERNAL_STORAGE");
        if (aX == null) {
            c y = g.y(str, z ? "path must be a string" : g.l("fail no such file or directory ", "access", str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Undefined;");
            if (y == null) {
                String jn = g.jn(str);
                if (!g.jd(jn)) {
                    return w(-4, g.l("fail no such file or directory ", "access", str, null));
                }
                if (!new File(iY(jn)).exists()) {
                    return w(-1, g.l("fail no such file or directory ", "access", str, null));
                }
                return w(0, "ok");
            }
            return y;
        }
        return aX;
    }

    public c D(String str, boolean z) {
        c aX = aX(str, "android.permission.READ_EXTERNAL_STORAGE");
        if (aX == null) {
            c y = g.y(str, z ? "path must be a string" : g.l("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Object;");
            if (y == null) {
                if (!g.jq(str) && !g.je(str)) {
                    return w(-1, "fail permission denied, open " + str);
                }
                c y2 = y(str, false);
                if (y2 == null) {
                    f fVar = new f();
                    String iY = iY(str);
                    if (TextUtils.isEmpty(iY)) {
                        return w(-1, g.l("fail no such file or directory ", null, str, null));
                    }
                    File file = new File(iY);
                    fVar.cM(file.isDirectory());
                    fVar.cN(file.isFile());
                    return a(str, fVar);
                }
                return y2;
            }
            return y;
        }
        return aX;
    }

    private c a(String str, f fVar) {
        File file = new File(iY(str));
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                fVar.lastAccessedTime = Os.lstat(file.getAbsolutePath()).st_atime;
                fVar.lastModifiedTime = Os.lstat(file.getAbsolutePath()).st_mtime;
                fVar.mode = Os.lstat(file.getAbsolutePath()).st_mode;
                fVar.size = Os.lstat(file.getAbsolutePath()).st_size;
            } catch (Exception e) {
                e.printStackTrace();
                return w(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
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
                fVar.lastAccessedTime = declaredField2.getLong(invoke);
                Field declaredField3 = invoke.getClass().getDeclaredField("st_mtime");
                if (!declaredField3.isAccessible()) {
                    declaredField3.setAccessible(true);
                }
                fVar.lastModifiedTime = declaredField3.getLong(invoke);
                Field declaredField4 = invoke.getClass().getDeclaredField("st_mode");
                if (!declaredField4.isAccessible()) {
                    declaredField4.setAccessible(true);
                }
                fVar.mode = declaredField4.getInt(invoke);
                Field declaredField5 = invoke.getClass().getDeclaredField("st_size");
                if (!declaredField5.isAccessible()) {
                    declaredField5.setAccessible(true);
                }
                fVar.size = declaredField5.getLong(invoke);
            } catch (Exception e2) {
                e2.printStackTrace();
                return w(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
            }
        }
        c w = w(0, "ok");
        w.stats = fVar;
        w.errMsg = "ok";
        return w;
    }

    public c jc(String str) {
        c aX = aX(str, "android.permission.READ_EXTERNAL_STORAGE");
        if (aX == null) {
            c y = g.y(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (y == null) {
                String jn = g.jn(str);
                if (!jn.startsWith("bdfile://tmp")) {
                    return w(-4, "fail file not exist");
                }
                File file = new File(iY(jn));
                if (!file.exists()) {
                    return w(-1, "fail file not exist");
                }
                if (file.isDirectory()) {
                    return w(-1, "fail " + str + " is directory");
                }
                c w = w(0, "ok");
                w.size = file.exists() ? file.length() : 0L;
                w.digest = file.exists() ? com.baidu.swan.c.b.b(file, false) : null;
                return w;
            }
            return y;
        }
        return aX;
    }
}
