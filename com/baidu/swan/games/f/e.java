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
    private static List<String> bcD = new ArrayList();
    private String bcC = g.getBasePath();
    private String bcE;
    private Context mContext;

    static {
        bcD.add("ascii");
        bcD.add("base64");
        bcD.add("binary");
        bcD.add("hex");
        bcD.add("utf-8");
        bcD.add("utf8");
        bcD.add("latin1");
        bcD.add("ucs2");
        bcD.add("ucs-2");
        bcD.add("utf16le");
        bcD.add("utf-16le");
    }

    public e(Context context, String str) {
        this.mContext = context;
        this.bcE = str;
    }

    private String iq(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith(a.USER_DATA_PATH)) {
            return g.iA(str);
        }
        if (str.startsWith("bdfile://tmp")) {
            return g.iB(str);
        }
        if (str.startsWith("bdfile://code")) {
            this.bcE = this.bcE.endsWith(File.separator) ? this.bcE.substring(0, this.bcE.length() - 1) : this.bcE;
            return this.bcE + str.substring("bdfile://code".length());
        }
        return "";
    }

    private c ir(String str) {
        c v = v(-1, "fail permission denied, open " + str);
        if (!TextUtils.isEmpty(str) && str.startsWith(a.USER_DATA_PATH)) {
            return null;
        }
        return v;
    }

    private c v(int i, String str) {
        c cVar = new c();
        cVar.errCode = i;
        cVar.errMsg = str;
        return cVar;
    }

    private c aU(String str, String str2) {
        if (g.an(this.mContext, str2)) {
            return null;
        }
        c cVar = new c();
        cVar.errCode = -1;
        cVar.errMsg = "fail permission denied, open " + str;
        return cVar;
    }

    private c w(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            c cVar = new c();
            cVar.errCode = -1;
            cVar.errMsg = "fail no such file or directory " + str;
            return cVar;
        }
        String iq = iq(str);
        if (TextUtils.isEmpty(str)) {
            c cVar2 = new c();
            cVar2.errCode = -1;
            cVar2.errMsg = "fail no such file or directory " + str;
            return cVar2;
        }
        File file = new File(iq);
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

    private c x(String str, boolean z) {
        if (str.endsWith(File.separator)) {
            str = str.substring(0, str.length() - 1);
        }
        String iq = iq(str);
        if (TextUtils.isEmpty(iq)) {
            return v(-1, "fail no such file or directory " + str);
        }
        if (iq.contains(File.separator)) {
            File file = new File(iq.substring(0, iq.lastIndexOf(File.separator)));
            if (!z && (!file.exists() || (file.exists() && file.isFile()))) {
                return v(-1, "fail no such file or directory " + str);
            }
        }
        return null;
    }

    public c b(String str, boolean z, boolean z2) {
        boolean mkdir;
        c aU = aU(str, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (aU == null) {
            c y = g.y(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
            if (y == null) {
                c ir = ir(str);
                if (ir == null) {
                    if (!g.iv(str)) {
                        return v(-4, "fail permission denied, open " + str);
                    }
                    String iq = iq(str);
                    c x = x(str, z);
                    if (x == null) {
                        File file = new File(iq);
                        if (file.exists()) {
                            return v(-1, "fail file already exists " + str);
                        }
                        try {
                            if (z) {
                                mkdir = file.mkdirs();
                            } else {
                                mkdir = file.mkdir();
                            }
                            if (!mkdir) {
                                return v(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                            }
                            return v(0, "ok");
                        } catch (Exception e) {
                            return v(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                        }
                    }
                    return x;
                }
                return ir;
            }
            return y;
        }
        return aU;
    }

    public c a(boolean z, String str, Object obj, String str2) {
        c y = g.y(str, z ? "filePath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        return y != null ? y : a(str, obj, str2, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [444=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:88:0x01a4 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v24, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r0v74 */
    private c a(String str, Object obj, String str2, boolean z) {
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2;
        ?? fileOutputStream;
        String str3;
        String str4;
        BufferedWriter bufferedWriter3 = null;
        c aU = aU(str, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (aU != null) {
            return aU;
        }
        c ir = ir(str);
        if (ir != null) {
            return ir;
        }
        int length = (a.USER_DATA_PATH + File.separator).length();
        if (!g.iv(str)) {
            return v(-4, "fail permission denied, open " + str.substring(length));
        }
        boolean z2 = obj instanceof byte[];
        if (!z2 && TextUtils.isEmpty(str2)) {
            str2 = "utf-8";
        }
        if (!TextUtils.isEmpty(str2)) {
            if ("binary".equals(str2.toLowerCase())) {
                str2 = "latin1";
            }
            if (!bcD.contains(str2.toLowerCase())) {
                return v(-1, "fail invalid encoding \"" + str2 + "\"");
            }
        }
        c x = x(str, false);
        if (x != null) {
            return x;
        }
        String iq = iq(str);
        if (TextUtils.isEmpty(iq)) {
            return v(-1, "fail no such file or directory " + str.substring(length));
        }
        long j = 0;
        if (!z2 && !TextUtils.isEmpty((String) obj)) {
            long length2 = ((String) obj).getBytes().length;
            if (g.R(length2)) {
                return v(-1, "fail file size over 50M");
            }
            j = length2;
        } else if (z2) {
            j = ((byte[]) obj).length;
        }
        File file = new File(iq);
        if (file.exists() && file.isDirectory()) {
            return v(-1, " fail illegal operation on a directory, open " + str);
        }
        c v = v(0, "ok");
        try {
            if (z2) {
                byte[] bArr = (byte[]) obj;
                fileOutputStream = new FileOutputStream(iq, z);
                try {
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.flush();
                        fileOutputStream = fileOutputStream;
                    } catch (Exception e) {
                        bufferedWriter2 = fileOutputStream;
                        c v2 = v(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                        com.baidu.swan.c.b.c(bufferedWriter3);
                        com.baidu.swan.c.b.c(bufferedWriter2);
                        return v2;
                    }
                } catch (Throwable th) {
                    bufferedWriter = null;
                    bufferedWriter3 = fileOutputStream;
                    th = th;
                    com.baidu.swan.c.b.c(bufferedWriter);
                    com.baidu.swan.c.b.c(bufferedWriter3);
                    throw th;
                }
            } else {
                String[] aZ = g.aZ((String) obj, str2);
                if (aZ == null || aZ.length != 2) {
                    str3 = "utf-8";
                    str4 = "";
                } else {
                    String str5 = aZ[0];
                    str3 = aZ[1];
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
                        c v22 = v(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                        com.baidu.swan.c.b.c(bufferedWriter3);
                        com.baidu.swan.c.b.c(bufferedWriter2);
                        return v22;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedWriter = bufferedWriter3;
                        bufferedWriter3 = bufferedWriter2;
                        com.baidu.swan.c.b.c(bufferedWriter);
                        com.baidu.swan.c.b.c(bufferedWriter3);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.baidu.swan.c.b.c(bufferedWriter);
                    com.baidu.swan.c.b.c(bufferedWriter3);
                    throw th;
                }
            }
            try {
                g.Q(j);
                com.baidu.swan.c.b.c(bufferedWriter3);
                com.baidu.swan.c.b.c(fileOutputStream);
                return v;
            } catch (Throwable th4) {
                bufferedWriter = bufferedWriter3;
                bufferedWriter3 = fileOutputStream;
                th = th4;
                com.baidu.swan.c.b.c(bufferedWriter);
                com.baidu.swan.c.b.c(bufferedWriter3);
                throw th;
            }
        } catch (Exception e3) {
            bufferedWriter2 = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedWriter = null;
        }
    }

    public c y(String str, boolean z) {
        c v;
        c aU = aU(str, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (aU == null) {
            c y = g.y(str, z ? "filePath must be a string" : g.l("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of Object;");
            if (y == null) {
                if (!g.iw(str)) {
                    return v(-4, g.l("fail permission denied, open ", null, str, null));
                }
                c w = w(str, false);
                if (w == null) {
                    c ir = ir(str);
                    if (ir == null) {
                        String iq = iq(str);
                        if (TextUtils.isEmpty(iq)) {
                            return v(-1, g.l("fail no such file or directory ", null, str, null));
                        }
                        File file = new File(iq);
                        if (file.isDirectory()) {
                            return v(-1, g.l("fail operation not permitted ", "unlink", str, null));
                        }
                        long iD = g.iD(iq);
                        try {
                            if (file.delete()) {
                                g.Q(-iD);
                                v = v(0, "ok");
                            } else {
                                v = v(-1, g.l(LivenessStat.TYPE_FACE_MATCH_FAIL, null, str, null));
                            }
                            return v;
                        } catch (Exception e) {
                            return v(-1, g.l(LivenessStat.TYPE_FACE_MATCH_FAIL, null, str, null));
                        }
                    }
                    return ir;
                }
                return w;
            }
            return y;
        }
        return aU;
    }

    public c aV(String str, String str2) {
        c y = g.y(str, g.a("fail no such file or directory ", "unzip", str, str2, true), "fail parameter error: parameter.zipFilePath should be String instead of Object;");
        if (y == null) {
            c y2 = g.y(str2, g.a("fail no such file or directory ", "unzip", str, str2, true), "fail parameter error: parameter.targetPath should be String instead of Object;");
            if (y2 == null) {
                if (!str2.startsWith(a.USER_DATA_PATH)) {
                    return v(-1, "fail permission denied, open " + str2);
                }
                String iE = g.iE(str);
                if (!iE.startsWith(a.USER_DATA_PATH) && !iE.startsWith("bdfile://code")) {
                    return v(-1, "fail permission denied, open " + str);
                }
                if (!g.iv(iE)) {
                    return v(-4, g.a("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (!g.iv(str2)) {
                    return v(-4, g.a("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (is(str2)) {
                    return v(-1, g.a("fail permission denied, ", "unzip", str, str2, true));
                }
                c x = x(str2, false);
                if (x != null) {
                    x.errMsg = g.a("fail no such file or directory ", "unzip", str, str2, true);
                    return x;
                }
                String iq = iq(iE);
                String iq2 = iq(str2);
                if (TextUtils.isEmpty(iq)) {
                    return v(-1, g.a("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (TextUtils.isEmpty(iq2)) {
                    return v(-1, g.a("fail no such file or directory ", "unzip", str, str2, true));
                }
                File file = new File(iq);
                if (!file.exists()) {
                    return v(-1, g.a("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (!iq.endsWith(".zip")) {
                    return v(-1, "fail unzip failed");
                }
                if (!file.isFile()) {
                    return v(-1, g.a("fail permission denied, ", "unzip", str, str2, true));
                }
                File file2 = new File(iq2);
                if (!file2.exists()) {
                    file2.mkdir();
                } else if (file2.isFile()) {
                    return v(-1, "fail unzip failed");
                }
                List<String> C = g.C(iq2, true);
                if (!com.baidu.swan.c.b.bl(iq, iq2)) {
                    return v(-1, "fail unzip failed");
                }
                List<String> C2 = g.C(iq2, true);
                ArrayList arrayList = new ArrayList(C2.size());
                long j = 0;
                for (String str3 : C2) {
                    if (!C.contains(str3)) {
                        arrayList.add(str3);
                        j = g.iD(str3) + j;
                    }
                }
                if (g.R(j)) {
                    g.D(arrayList);
                    return v(-1, "fail file size over 50M");
                }
                g.Q(j);
                return v(0, "ok");
            }
            return y2;
        }
        return y;
    }

    private boolean is(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains(File.separator)) {
            return it(str.substring(str.lastIndexOf(File.separator) + 1));
        }
        return it(str);
    }

    private boolean it(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(".")) {
            return false;
        }
        String[] split = str.split("\\.");
        return (split.length != 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) ? false : true;
    }

    public c k(String str, String str2, boolean z) {
        c aU = aU(str2, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (aU == null) {
            c y = g.y(str, z ? "tempFilePath must be a string" : "fail tempFilePath file not exist", z ? " The argument must be string" : "fail parameter error: parameter.tempFilePath should be String instead of Object;");
            if (y == null) {
                String iE = g.iE(str2);
                if (TextUtils.isEmpty(iE)) {
                    iE = a.USER_DATA_PATH + File.separator + com.baidu.swan.c.b.jZ(str);
                }
                if (!iE.startsWith(a.USER_DATA_PATH)) {
                    return v(-1, g.l("fail permission denied, open ", null, str2, null));
                }
                if (!(!TextUtils.isEmpty(str) && (str.startsWith(new StringBuilder().append("bdfile://tmp").append(File.separator).toString()) || "bdfile://tmp".equals(str)))) {
                    return v(-4, "fail it is not a tempFilePath");
                }
                c x = x(iE, false);
                if (x != null) {
                    return x;
                }
                c x2 = x(str, false);
                if (x2 != null) {
                    return x2;
                }
                File file = new File(iq(iE));
                if (a.USER_DATA_PATH.equals(iE) || (file.exists() && file.isDirectory())) {
                    return v(-1, g.l("fail Error: EISDIR: illegal operation on a directory, open ", null, str2, null));
                }
                c w = w(str, true);
                if (w != null) {
                    w.errMsg = "fail no such file or directory ";
                    return w;
                }
                String iq = iq(str);
                long iD = g.iD(iq);
                if (g.R(iD)) {
                    return v(-1, "fail file size over 50M");
                }
                if (!iE.startsWith(a.USER_DATA_PATH) || g.ix(iE)) {
                    return v(-1, g.l("fail permission denied, open ", null, str2, null));
                }
                c x3 = x(iE, false);
                if (x3 != null) {
                    return x3;
                }
                c ir = ir(iE);
                if (ir != null) {
                    return ir;
                }
                c aW = aW(str, iE);
                if (aW != null && aW.errCode == 0) {
                    g.Q(iD);
                    if (TextUtils.isEmpty(str)) {
                        return v(-1, g.l("fail no such file or directory ", null, str, null));
                    }
                    File file2 = new File(iq);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(iE);
                    aW.bbS = arrayList;
                    aW.errMsg = "ok";
                }
                return aW;
            }
            return y;
        }
        return aU;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [809=4] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v11, resolved type: java.io.FileOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private c aW(String str, String str2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream3 = null;
        String iq = iq(str);
        String iq2 = iq(str2);
        if (TextUtils.isEmpty(iq)) {
            return v(-1, g.l("fail no such file or directory ", null, str, null));
        }
        if (TextUtils.isEmpty(iq2)) {
            return v(-1, g.l("fail no such file or directory ", null, str2, null));
        }
        c v = v(0, "ok");
        try {
            File file = new File(iq2);
            fileInputStream = new FileInputStream(new File(iq));
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
            com.baidu.swan.c.b.c(fileInputStream);
            com.baidu.swan.c.b.c(fileOutputStream);
            if (TextUtils.isEmpty(str2)) {
                v.errMsg = LivenessStat.TYPE_FACE_MATCH_FAIL;
                v.errCode = -1;
                return v;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            v.bbS = arrayList;
            return v;
        } catch (IOException e3) {
            e = e3;
            fileInputStream3 = fileInputStream;
            fileInputStream2 = fileOutputStream;
            try {
                e.printStackTrace();
                c v2 = v(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                com.baidu.swan.c.b.c(fileInputStream3);
                com.baidu.swan.c.b.c(fileInputStream2);
                if (TextUtils.isEmpty("")) {
                    v.errMsg = LivenessStat.TYPE_FACE_MATCH_FAIL;
                    v.errCode = -1;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(str2);
                    v.bbS = arrayList2;
                }
                return v2;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream3;
                fileInputStream3 = fileInputStream2;
                com.baidu.swan.c.b.c(fileInputStream);
                com.baidu.swan.c.b.c(fileInputStream3);
                if (TextUtils.isEmpty("")) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(str2);
                    v.bbS = arrayList3;
                } else {
                    v.errMsg = LivenessStat.TYPE_FACE_MATCH_FAIL;
                    v.errCode = -1;
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream3 = fileOutputStream;
            com.baidu.swan.c.b.c(fileInputStream);
            com.baidu.swan.c.b.c(fileInputStream3);
            if (TextUtils.isEmpty("")) {
            }
            throw th;
        }
    }

    public c z(String str, boolean z) {
        c aU = aU(str, "android.permission.READ_EXTERNAL_STORAGE");
        if (aU == null) {
            c y = g.y(str, z ? "dirPath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
            if (y == null) {
                String iE = g.iE(str);
                if (!g.iw(iE)) {
                    return v(-4, "fail permission denied, open " + str);
                }
                String iq = iq(iE);
                if (TextUtils.isEmpty(iq)) {
                    return v(-1, "fail no such file or directory " + str);
                }
                File file = new File(iq);
                if (!file.exists()) {
                    return v(-1, "fail no such file or directory " + str);
                }
                if (!file.isDirectory()) {
                    return v(-1, "fail no such file or directory " + str);
                }
                File[] listFiles = file.listFiles();
                ArrayList arrayList = new ArrayList();
                for (File file2 : listFiles) {
                    if (file2.exists()) {
                        arrayList.add(com.baidu.swan.c.b.jZ(file2.getAbsolutePath()));
                    }
                }
                c v = v(0, "ok");
                v.bbS = arrayList;
                return v;
            }
            return y;
        }
        return aU;
    }

    public c c(String str, boolean z, boolean z2) {
        boolean deleteFile;
        c aU = aU(str, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (aU == null) {
            c y = g.y(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
            if (y == null) {
                c ir = ir(str);
                if (ir == null) {
                    if (!g.iw(str)) {
                        return v(-4, "fail permission denied, open " + str);
                    }
                    File file = new File(iq(str));
                    if (!file.exists() || file.isFile()) {
                        return v(-1, "fail no such file or directory " + str);
                    }
                    boolean e = e(file.listFiles());
                    try {
                        if (!z && e) {
                            return v(-1, "fail directory not empty ");
                        }
                        if (!z) {
                            deleteFile = file.delete();
                        } else {
                            deleteFile = com.baidu.swan.c.b.deleteFile(file);
                        }
                        if (!deleteFile) {
                            return v(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                        }
                        return v(0, "ok");
                    } catch (Exception e2) {
                        return v(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                    }
                }
                return ir;
            }
            return y;
        }
        return aU;
    }

    private boolean e(File[] fileArr) {
        return (fileArr == null || fileArr.length == 0) ? false : true;
    }

    public c l(String str, String str2, boolean z) {
        String str3;
        c aU = aU(str, "android.permission.READ_EXTERNAL_STORAGE");
        if (aU == null) {
            c y = g.y(str, z ? "filePath must be a string" : "fail file not found", z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of NULL;");
            if (y == null) {
                String iE = g.iE(str);
                if (!g.iv(iE)) {
                    return v(-1, "fail permission denied, open " + str);
                }
                c w = w(iE, true);
                if (w != null) {
                    w.errMsg = g.l("fail no such file or directory ", "open", str, null);
                    return w;
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
                if (!isEmpty && !bcD.contains(str3)) {
                    return v(-1, "fail Error: Unknown encoding: " + str3);
                }
                String iq = iq(iE);
                if (TextUtils.isEmpty(iq)) {
                    return v(-1, "fail no such file or directory " + str);
                }
                File file = new File(iq);
                String str4 = "";
                byte[] bArr = new byte[0];
                c v = v(0, "ok");
                try {
                    if (TextUtils.isEmpty(str3)) {
                        bArr = g.iF(iq);
                    } else {
                        String a = a(new FileInputStream(file), ("base64".equals(str3) || "hex".equals(str3)) ? "" : str3);
                        if (!TextUtils.isEmpty(a)) {
                            if ("base64".equals(str3)) {
                                str4 = new String(Base64.encode(a.getBytes(), 2), "utf-8");
                            } else if ("hex".equals(str3)) {
                                str4 = g.iz(a);
                            }
                        }
                        str4 = a;
                    }
                    if (TextUtils.isEmpty(str3)) {
                        v.bbT = bArr;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str4);
                        v.bbS = arrayList;
                    }
                    return v;
                } catch (Exception e) {
                    e.printStackTrace();
                    return v(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                }
            }
            return y;
        }
        return aU;
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

    public c m(String str, String str2, boolean z) {
        c aU = aU(str, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (aU == null) {
            c aU2 = aU(str2, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (aU2 == null) {
                c y = g.y(str, z ? "oldPath must be a string" : g.l("fail no such file or directory ", "rename", str, null), z ? " The argument must be string" : "fail parameter error: parameter.oldPath should be String instead of Undefined;");
                if (y == null) {
                    c y2 = g.y(str2, z ? "newPath must be a string" : g.l("fail no such file or directory ", "rename", str2, null), z ? " The argument must be string" : "fail parameter error: parameter.newPath should be String instead of Undefined;");
                    if (y2 == null) {
                        String iE = g.iE(str);
                        c ir = ir(iE);
                        if (ir != null) {
                            ir.errMsg = g.l("fail permission denied, ", "rename", str, str2);
                            return ir;
                        }
                        String iE2 = g.iE(str2);
                        c ir2 = ir(iE2);
                        if (ir2 != null) {
                            ir2.errMsg = g.l("fail permission denied, ", "rename", str, str2);
                            return ir2;
                        }
                        c w = w(iE, false);
                        if (w != null) {
                            w.errMsg = g.l("fail no such file or directory ", "rename", str, str2);
                            return w;
                        } else if (!g.iv(iE) || !g.iv(iE2)) {
                            return v(-4, g.l("fail permission denied, ", "rename", str, str2));
                        } else {
                            c x = x(iE2, false);
                            if (x != null) {
                                x.errMsg = g.l("fail no such file or directory ", "rename", str, str2);
                                return x;
                            }
                            String iq = iq(iE);
                            String iq2 = iq(iE2);
                            File file = new File(iq);
                            File file2 = new File(iq2);
                            boolean exists = file2.exists();
                            if (!g.d(file, file2) || (file.isDirectory() && !exists && is(iq2))) {
                                return v(-1, "fail rename failed");
                            }
                            try {
                                if ((file2.isDirectory() && file2.listFiles() != null && file2.listFiles().length > 0) || !file.renameTo(file2)) {
                                    return v(-1, "fail rename failed");
                                }
                                return v(0, "ok");
                            } catch (Exception e) {
                                return v(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                            }
                        }
                    }
                    return y2;
                }
                return y;
            }
            return aU2;
        }
        return aU;
    }

    public c n(String str, String str2, boolean z) {
        c aU = aU(str2, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (aU == null) {
            c y = g.y(str, "srcPath must be a string", " The argument must be string");
            if (y == null) {
                c y2 = g.y(str2, "destPath must be a string", " The argument must be string");
                if (y2 == null) {
                    String iE = g.iE(str);
                    if (!g.iv(iE)) {
                        return v(-4, g.l("fail no such file or directory ", "copyFile", str, null));
                    }
                    String iE2 = g.iE(str2);
                    if (!g.iv(iE2)) {
                        return v(-4, g.l("fail permission denied, open ", "copyFile", str2, null));
                    }
                    c ir = ir(iE2);
                    if (ir == null) {
                        String iq = iq(iE);
                        File file = new File(iq);
                        if (!file.exists() || !file.isFile()) {
                            return v(-1, g.l("fail no such file or directory ", "copyFile", str, null));
                        }
                        c x = x(iE2, false);
                        if (x != null) {
                            x.errMsg = g.l("fail no such file or directory ", "copyFile", str2, null);
                            return x;
                        } else if (iE2.endsWith(File.separator)) {
                            return v(-1, g.l("fail permission denied, ", "copyFile", str, str2));
                        } else {
                            File file2 = new File(iq(iE2));
                            if (file2.exists() && file2.isDirectory()) {
                                if (e(file2.listFiles())) {
                                    return v(-1, g.l("fail permission denied, ", "copyFile", str, str2));
                                }
                                try {
                                    file2.delete();
                                } catch (Exception e) {
                                    return v(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                                }
                            }
                            long iD = g.iD(iq);
                            boolean z2 = (iE.equals(iE2) || iE.startsWith(a.USER_DATA_PATH)) ? false : true;
                            if (z2 && g.R(iD)) {
                                return v(-1, "fail file size over 50M");
                            }
                            c aW = !iE.equals(iE2) ? aW(iE, iE2) : v(0, "ok");
                            if (z2 && aW != null && aW.errCode == 0) {
                                g.Q(iD);
                                return aW;
                            }
                            return aW;
                        }
                    }
                    return ir;
                }
                return y2;
            }
            return y;
        }
        return aU;
    }

    public c b(String str, Object obj, String str2, boolean z) {
        c y = g.y(str, g.l("fail permission denied, open ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of NULL;");
        if (y == null) {
            c aU = aU(str, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (aU == null) {
                String iE = g.iE(str);
                if (!"mounted".equals(Environment.getExternalStorageState())) {
                    return v(-1, "fail sdcard not mounted ");
                }
                c ir = ir(iE);
                if (ir == null) {
                    if (obj == null) {
                        return v(-1, "fail TypeError: data argument must be a string, Buffer, ArrayBuffer, Array, or array-like object");
                    }
                    File file = new File(iq(iE));
                    if (!file.exists()) {
                        return v(-1, g.l("fail no such file or directory ", "open", str, null));
                    }
                    if (file.isDirectory()) {
                        return v(-1, "fail illegal operation on a directory, open " + str);
                    }
                    return a(iE, obj, str2, true);
                }
                return ir;
            }
            return aU;
        }
        return y;
    }

    public c A(String str, boolean z) {
        c aU = aU(str, "android.permission.READ_EXTERNAL_STORAGE");
        if (aU == null) {
            c y = g.y(str, z ? "path must be a string" : g.l("fail no such file or directory ", "access", str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Undefined;");
            if (y == null) {
                String iE = g.iE(str);
                if (!g.iv(iE)) {
                    return v(-4, g.l("fail no such file or directory ", "access", str, null));
                }
                if (!new File(iq(iE)).exists()) {
                    return v(-1, g.l("fail no such file or directory ", "access", str, null));
                }
                return v(0, "ok");
            }
            return y;
        }
        return aU;
    }

    public c B(String str, boolean z) {
        c aU = aU(str, "android.permission.READ_EXTERNAL_STORAGE");
        if (aU == null) {
            c y = g.y(str, z ? "path must be a string" : g.l("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Object;");
            if (y == null) {
                if (!g.iI(str) && !g.iw(str)) {
                    return v(-1, "fail permission denied, open " + str);
                }
                c w = w(str, false);
                if (w == null) {
                    f fVar = new f();
                    String iq = iq(str);
                    if (TextUtils.isEmpty(iq)) {
                        return v(-1, g.l("fail no such file or directory ", null, str, null));
                    }
                    File file = new File(iq);
                    fVar.cv(file.isDirectory());
                    fVar.cw(file.isFile());
                    return a(str, fVar);
                }
                return w;
            }
            return y;
        }
        return aU;
    }

    private c a(String str, f fVar) {
        File file = new File(iq(str));
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                fVar.lastAccessedTime = Os.lstat(file.getAbsolutePath()).st_atime;
                fVar.lastModifiedTime = Os.lstat(file.getAbsolutePath()).st_mtime;
                fVar.mode = Os.lstat(file.getAbsolutePath()).st_mode;
                fVar.size = Os.lstat(file.getAbsolutePath()).st_size;
            } catch (Exception e) {
                e.printStackTrace();
                return v(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
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
                return v(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
            }
        }
        c v = v(0, "ok");
        v.stats = fVar;
        v.errMsg = "ok";
        return v;
    }

    public c iu(String str) {
        c aU = aU(str, "android.permission.READ_EXTERNAL_STORAGE");
        if (aU == null) {
            c y = g.y(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (y == null) {
                String iE = g.iE(str);
                if (!iE.startsWith("bdfile://tmp")) {
                    return v(-4, "fail file not exist");
                }
                File file = new File(iq(iE));
                if (!file.exists()) {
                    return v(-1, "fail file not exist");
                }
                if (file.isDirectory()) {
                    return v(-1, "fail " + str + " is directory");
                }
                c v = v(0, "ok");
                v.size = file.exists() ? file.length() : 0L;
                v.digest = file.exists() ? com.baidu.swan.c.c.c(file, false) : null;
                return v;
            }
            return y;
        }
        return aU;
    }
}
