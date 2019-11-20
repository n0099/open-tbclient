package com.baidu.swan.games.f;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.system.Os;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.internal.DefaultConfig;
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
/* loaded from: classes2.dex */
public class e {
    private static List<String> bzO = new ArrayList();
    private String bzN = g.getBasePath();
    private String bzP;
    private Context mContext;

    static {
        bzO.add("ascii");
        bzO.add("base64");
        bzO.add("binary");
        bzO.add("hex");
        bzO.add("utf-8");
        bzO.add("utf8");
        bzO.add("latin1");
        bzO.add("ucs2");
        bzO.add("ucs-2");
        bzO.add("utf16le");
        bzO.add("utf-16le");
    }

    public e(Context context, String str) {
        this.mContext = context;
        this.bzP = str;
    }

    private String jL(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith(a.USER_DATA_PATH)) {
            return g.jV(str);
        }
        if (str.startsWith("bdfile://tmp")) {
            return g.jW(str);
        }
        if (str.startsWith("bdfile://code")) {
            this.bzP = this.bzP.endsWith(File.separator) ? this.bzP.substring(0, this.bzP.length() - 1) : this.bzP;
            return this.bzP + str.substring("bdfile://code".length());
        }
        return "";
    }

    private c jM(String str) {
        c z = z(-1, "fail permission denied, open " + str);
        if (!TextUtils.isEmpty(str) && str.startsWith(a.USER_DATA_PATH)) {
            return null;
        }
        return z;
    }

    private c z(int i, String str) {
        c cVar = new c();
        cVar.errCode = i;
        cVar.errMsg = str;
        return cVar;
    }

    private c be(String str, String str2) {
        if (g.isPermissionGranted(this.mContext, str2)) {
            return null;
        }
        c cVar = new c();
        cVar.errCode = -1;
        cVar.errMsg = "fail permission denied, open " + str;
        return cVar;
    }

    private c C(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            c cVar = new c();
            cVar.errCode = -1;
            cVar.errMsg = "fail no such file or directory " + str;
            return cVar;
        }
        String jL = jL(str);
        if (TextUtils.isEmpty(str)) {
            c cVar2 = new c();
            cVar2.errCode = -1;
            cVar2.errMsg = "fail no such file or directory " + str;
            return cVar2;
        }
        File file = new File(jL);
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

    private c D(String str, boolean z) {
        if (str.endsWith(File.separator)) {
            str = str.substring(0, str.length() - 1);
        }
        String jL = jL(str);
        if (TextUtils.isEmpty(jL)) {
            return z(-1, "fail no such file or directory " + str);
        }
        if (jL.contains(File.separator)) {
            File file = new File(jL.substring(0, jL.lastIndexOf(File.separator)));
            if (!z && (!file.exists() || (file.exists() && file.isFile()))) {
                return z(-1, "fail no such file or directory " + str);
            }
        }
        return null;
    }

    public c b(String str, boolean z, boolean z2) {
        boolean mkdir;
        c be = be(str, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (be == null) {
            c C = g.C(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
            if (C == null) {
                c jM = jM(str);
                if (jM == null) {
                    if (!g.jQ(str)) {
                        return z(-4, "fail permission denied, open " + str);
                    }
                    String jL = jL(str);
                    c D = D(str, z);
                    if (D == null) {
                        File file = new File(jL);
                        if (file.exists()) {
                            return z(-1, "fail file already exists " + str);
                        }
                        try {
                            if (z) {
                                mkdir = file.mkdirs();
                            } else {
                                mkdir = file.mkdir();
                            }
                            if (!mkdir) {
                                return z(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                            }
                            return z(0, "ok");
                        } catch (Exception e) {
                            return z(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                        }
                    }
                    return D;
                }
                return jM;
            }
            return C;
        }
        return be;
    }

    public c a(boolean z, String str, Object obj, String str2) {
        c C = g.C(str, z ? "filePath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        return C != null ? C : a(str, obj, str2, false);
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
        c be = be(str, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (be != null) {
            return be;
        }
        c jM = jM(str);
        if (jM != null) {
            return jM;
        }
        if (obj == null) {
            return z(-1, "The argument must be string or arrayBuffer");
        }
        int length = (a.USER_DATA_PATH + File.separator).length();
        if (!g.jQ(str)) {
            return z(-4, "fail permission denied, open " + str.substring(length));
        }
        boolean z2 = obj instanceof byte[];
        if (!z2 && TextUtils.isEmpty(str2)) {
            str2 = "utf-8";
        }
        if (!TextUtils.isEmpty(str2)) {
            if ("binary".equals(str2.toLowerCase())) {
                str2 = "latin1";
            }
            if (!bzO.contains(str2.toLowerCase())) {
                return z(-1, "fail invalid encoding \"" + str2 + "\"");
            }
        }
        c D = D(str, false);
        if (D != null) {
            return D;
        }
        String jL = jL(str);
        if (TextUtils.isEmpty(jL)) {
            return z(-1, "fail no such file or directory " + str.substring(length));
        }
        long j = 0;
        if (!z2 && !TextUtils.isEmpty((String) obj)) {
            j = ((String) obj).getBytes().length;
        } else if (z2) {
            j = ((byte[]) obj).length;
        }
        if (g.aw(j)) {
            return z(-1, "fail file size over 50M");
        }
        File file = new File(jL);
        if (file.exists() && file.isDirectory()) {
            return z(-1, " fail illegal operation on a directory, open " + str);
        }
        c z3 = z(0, "ok");
        try {
            if (z2) {
                byte[] bArr = (byte[]) obj;
                fileOutputStream = new FileOutputStream(jL, z);
                try {
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.flush();
                        fileOutputStream = fileOutputStream;
                    } catch (Throwable th) {
                        bufferedWriter = null;
                        bufferedWriter3 = fileOutputStream;
                        th = th;
                        com.baidu.swan.c.a.b(bufferedWriter);
                        com.baidu.swan.c.a.b(bufferedWriter3);
                        throw th;
                    }
                } catch (Exception e) {
                    bufferedWriter2 = fileOutputStream;
                    c z4 = z(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                    com.baidu.swan.c.a.b(bufferedWriter3);
                    com.baidu.swan.c.a.b(bufferedWriter2);
                    return z4;
                }
            } else {
                String[] bi = g.bi((String) obj, str2);
                if (bi == null || bi.length != 2) {
                    str3 = "utf-8";
                    str4 = "";
                } else {
                    String str5 = bi[0];
                    str3 = bi[1];
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
                        c z42 = z(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                        com.baidu.swan.c.a.b(bufferedWriter3);
                        com.baidu.swan.c.a.b(bufferedWriter2);
                        return z42;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedWriter = bufferedWriter3;
                        bufferedWriter3 = bufferedWriter2;
                        com.baidu.swan.c.a.b(bufferedWriter);
                        com.baidu.swan.c.a.b(bufferedWriter3);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.baidu.swan.c.a.b(bufferedWriter);
                    com.baidu.swan.c.a.b(bufferedWriter3);
                    throw th;
                }
            }
            try {
                g.av(j);
                com.baidu.swan.c.a.b(bufferedWriter3);
                com.baidu.swan.c.a.b(fileOutputStream);
                return z3;
            } catch (Throwable th4) {
                bufferedWriter = bufferedWriter3;
                bufferedWriter3 = fileOutputStream;
                th = th4;
                com.baidu.swan.c.a.b(bufferedWriter);
                com.baidu.swan.c.a.b(bufferedWriter3);
                throw th;
            }
        } catch (Exception e3) {
            bufferedWriter2 = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedWriter = null;
        }
    }

    public c E(String str, boolean z) {
        c z2;
        c be = be(str, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (be == null) {
            c C = g.C(str, z ? "filePath must be a string" : g.o("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of Object;");
            if (C == null) {
                if (!g.jR(str)) {
                    return z(-4, g.o("fail permission denied, open ", null, str, null));
                }
                c C2 = C(str, false);
                if (C2 == null) {
                    c jM = jM(str);
                    if (jM == null) {
                        String jL = jL(str);
                        if (TextUtils.isEmpty(jL)) {
                            return z(-1, g.o("fail no such file or directory ", null, str, null));
                        }
                        File file = new File(jL);
                        if (file.isDirectory()) {
                            return z(-1, g.o("fail operation not permitted ", "unlink", str, null));
                        }
                        long fileSize = g.getFileSize(jL);
                        try {
                            if (file.delete()) {
                                g.av(-fileSize);
                                z2 = z(0, "ok");
                            } else {
                                z2 = z(-1, g.o(LivenessStat.TYPE_FACE_MATCH_FAIL, null, str, null));
                            }
                            return z2;
                        } catch (Exception e) {
                            return z(-1, g.o(LivenessStat.TYPE_FACE_MATCH_FAIL, null, str, null));
                        }
                    }
                    return jM;
                }
                return C2;
            }
            return C;
        }
        return be;
    }

    public c bf(String str, String str2) {
        c C = g.C(str, g.e("fail no such file or directory ", "unzip", str, str2, true), "fail parameter error: parameter.zipFilePath should be String instead of Object;");
        if (C == null) {
            c C2 = g.C(str2, g.e("fail no such file or directory ", "unzip", str, str2, true), "fail parameter error: parameter.targetPath should be String instead of Object;");
            if (C2 == null) {
                if (!str2.startsWith(a.USER_DATA_PATH)) {
                    return z(-1, "fail permission denied, open " + str2);
                }
                String jZ = g.jZ(str);
                if (!jZ.startsWith(a.USER_DATA_PATH) && !jZ.startsWith("bdfile://code")) {
                    return z(-1, "fail permission denied, open " + str);
                }
                if (!g.jQ(jZ)) {
                    return z(-4, g.e("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (!g.jQ(str2)) {
                    return z(-4, g.e("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (jN(str2)) {
                    return z(-1, g.e("fail permission denied, ", "unzip", str, str2, true));
                }
                c D = D(str2, false);
                if (D != null) {
                    D.errMsg = g.e("fail no such file or directory ", "unzip", str, str2, true);
                    return D;
                }
                String jL = jL(jZ);
                String jL2 = jL(str2);
                if (TextUtils.isEmpty(jL)) {
                    return z(-1, g.e("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (TextUtils.isEmpty(jL2)) {
                    return z(-1, g.e("fail no such file or directory ", "unzip", str, str2, true));
                }
                File file = new File(jL);
                if (!file.exists()) {
                    return z(-1, g.e("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (!jL.endsWith(".zip")) {
                    return z(-1, "fail unzip failed");
                }
                if (!file.isFile()) {
                    return z(-1, g.e("fail permission denied, ", "unzip", str, str2, true));
                }
                File file2 = new File(jL2);
                if (!file2.exists()) {
                    file2.mkdir();
                } else if (file2.isFile()) {
                    return z(-1, "fail unzip failed");
                }
                List<String> I = g.I(jL2, true);
                if (!com.baidu.swan.c.a.bz(jL, jL2)) {
                    return z(-1, "fail unzip failed");
                }
                List<String> I2 = g.I(jL2, true);
                ArrayList arrayList = new ArrayList(I2.size());
                long j = 0;
                for (String str3 : I2) {
                    if (!I.contains(str3)) {
                        arrayList.add(str3);
                        j = g.getFileSize(str3) + j;
                    }
                }
                if (g.aw(j)) {
                    g.ad(arrayList);
                    return z(-1, "fail file size over 50M");
                }
                g.av(j);
                return z(0, "ok");
            }
            return C2;
        }
        return C;
    }

    private boolean jN(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains(File.separator)) {
            return jO(str.substring(str.lastIndexOf(File.separator) + 1));
        }
        return jO(str);
    }

    private boolean jO(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(DefaultConfig.TOKEN_SEPARATOR)) {
            return false;
        }
        String[] split = str.split("\\.");
        return (split.length != 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) ? false : true;
    }

    public c o(String str, String str2, boolean z) {
        c be = be(str2, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (be == null) {
            c C = g.C(str, z ? "tempFilePath must be a string" : "fail tempFilePath file not exist", z ? " The argument must be string" : "fail parameter error: parameter.tempFilePath should be String instead of Object;");
            if (C == null) {
                String jZ = g.jZ(str2);
                if (TextUtils.isEmpty(jZ)) {
                    jZ = a.USER_DATA_PATH + File.separator + com.baidu.swan.c.a.lL(str);
                }
                if (!jZ.startsWith(a.USER_DATA_PATH)) {
                    return z(-1, g.o("fail permission denied, open ", null, str2, null));
                }
                if (!(!TextUtils.isEmpty(str) && (str.startsWith(new StringBuilder().append("bdfile://tmp").append(File.separator).toString()) || "bdfile://tmp".equals(str)))) {
                    return z(-4, "fail it is not a tempFilePath");
                }
                c D = D(jZ, false);
                if (D != null) {
                    return D;
                }
                c D2 = D(str, false);
                if (D2 != null) {
                    return D2;
                }
                File file = new File(jL(jZ));
                if (a.USER_DATA_PATH.equals(jZ) || (file.exists() && file.isDirectory())) {
                    return z(-1, g.o("fail Error: EISDIR: illegal operation on a directory, open ", null, str2, null));
                }
                c C2 = C(str, true);
                if (C2 != null) {
                    C2.errMsg = "fail no such file or directory ";
                    return C2;
                }
                String jL = jL(str);
                long fileSize = g.getFileSize(jL);
                if (g.aw(fileSize)) {
                    return z(-1, "fail file size over 50M");
                }
                if (!jZ.startsWith(a.USER_DATA_PATH) || g.jS(jZ)) {
                    return z(-1, g.o("fail permission denied, open ", null, str2, null));
                }
                c D3 = D(jZ, false);
                if (D3 != null) {
                    return D3;
                }
                c jM = jM(jZ);
                if (jM != null) {
                    return jM;
                }
                c bg = bg(str, jZ);
                if (bg != null && bg.errCode == 0) {
                    g.av(fileSize);
                    if (TextUtils.isEmpty(str)) {
                        return z(-1, g.o("fail no such file or directory ", null, str, null));
                    }
                    File file2 = new File(jL);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(jZ);
                    bg.result = arrayList;
                    bg.errMsg = "ok";
                }
                return bg;
            }
            return C;
        }
        return be;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [813=4, 821=4] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v11, resolved type: java.io.FileOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private c bg(String str, String str2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream3 = null;
        String jL = jL(str);
        String jL2 = jL(str2);
        if (TextUtils.isEmpty(jL)) {
            return z(-1, g.o("fail no such file or directory ", null, str, null));
        }
        if (TextUtils.isEmpty(jL2)) {
            return z(-1, g.o("fail no such file or directory ", null, str2, null));
        }
        c z = z(0, "ok");
        try {
            File file = new File(jL2);
            fileInputStream = new FileInputStream(new File(jL));
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
            com.baidu.swan.c.a.b(fileInputStream);
            com.baidu.swan.c.a.b(fileOutputStream);
            if (TextUtils.isEmpty(str2)) {
                z.errMsg = LivenessStat.TYPE_FACE_MATCH_FAIL;
                z.errCode = -1;
                return z;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            z.result = arrayList;
            return z;
        } catch (IOException e3) {
            e = e3;
            fileInputStream3 = fileInputStream;
            fileInputStream2 = fileOutputStream;
            try {
                e.printStackTrace();
                c z2 = z(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                com.baidu.swan.c.a.b(fileInputStream3);
                com.baidu.swan.c.a.b(fileInputStream2);
                if (TextUtils.isEmpty("")) {
                    z.errMsg = LivenessStat.TYPE_FACE_MATCH_FAIL;
                    z.errCode = -1;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(str2);
                    z.result = arrayList2;
                }
                return z2;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream3;
                fileInputStream3 = fileInputStream2;
                com.baidu.swan.c.a.b(fileInputStream);
                com.baidu.swan.c.a.b(fileInputStream3);
                if (TextUtils.isEmpty("")) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(str2);
                    z.result = arrayList3;
                } else {
                    z.errMsg = LivenessStat.TYPE_FACE_MATCH_FAIL;
                    z.errCode = -1;
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream3 = fileOutputStream;
            com.baidu.swan.c.a.b(fileInputStream);
            com.baidu.swan.c.a.b(fileInputStream3);
            if (TextUtils.isEmpty("")) {
            }
            throw th;
        }
    }

    public c F(String str, boolean z) {
        c be = be(str, "android.permission.READ_EXTERNAL_STORAGE");
        if (be == null) {
            c C = g.C(str, z ? "dirPath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
            if (C == null) {
                String jZ = g.jZ(str);
                if (!g.jR(jZ)) {
                    return z(-4, "fail permission denied, open " + str);
                }
                String jL = jL(jZ);
                if (TextUtils.isEmpty(jL)) {
                    return z(-1, "fail no such file or directory " + str);
                }
                File file = new File(jL);
                if (!file.exists()) {
                    return z(-1, "fail no such file or directory " + str);
                }
                if (!file.isDirectory()) {
                    return z(-1, "fail no such file or directory " + str);
                }
                File[] listFiles = file.listFiles();
                ArrayList arrayList = new ArrayList();
                for (File file2 : listFiles) {
                    if (file2.exists()) {
                        arrayList.add(com.baidu.swan.c.a.lL(file2.getAbsolutePath()));
                    }
                }
                c z2 = z(0, "ok");
                z2.result = arrayList;
                return z2;
            }
            return C;
        }
        return be;
    }

    public c c(String str, boolean z, boolean z2) {
        boolean deleteFile;
        c be = be(str, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (be == null) {
            c C = g.C(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
            if (C == null) {
                c jM = jM(str);
                if (jM == null) {
                    if (!g.jR(str)) {
                        return z(-4, "fail permission denied, open " + str);
                    }
                    File file = new File(jL(str));
                    if (!file.exists() || file.isFile()) {
                        return z(-1, "fail no such file or directory " + str);
                    }
                    boolean d = d(file.listFiles());
                    try {
                        if (!z && d) {
                            return z(-1, "fail directory not empty ");
                        }
                        if (!z) {
                            deleteFile = file.delete();
                        } else {
                            deleteFile = com.baidu.swan.c.a.deleteFile(file);
                        }
                        if (!deleteFile) {
                            return z(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                        }
                        return z(0, "ok");
                    } catch (Exception e) {
                        return z(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                    }
                }
                return jM;
            }
            return C;
        }
        return be;
    }

    private boolean d(File[] fileArr) {
        return (fileArr == null || fileArr.length == 0) ? false : true;
    }

    public c p(String str, String str2, boolean z) {
        String str3;
        c be = be(str, "android.permission.READ_EXTERNAL_STORAGE");
        if (be == null) {
            c C = g.C(str, z ? "filePath must be a string" : "fail file not found", z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of NULL;");
            if (C == null) {
                String jZ = g.jZ(str);
                if (!g.jQ(jZ)) {
                    return z(-1, "fail permission denied, open " + str);
                }
                c C2 = C(jZ, true);
                if (C2 != null) {
                    C2.errMsg = g.o("fail no such file or directory ", "open", str, null);
                    return C2;
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
                if (!isEmpty && !bzO.contains(str3)) {
                    return z(-1, "fail Error: Unknown encoding: " + str3);
                }
                String jL = jL(jZ);
                if (TextUtils.isEmpty(jL)) {
                    return z(-1, "fail no such file or directory " + str);
                }
                File file = new File(jL);
                String str4 = "";
                byte[] bArr = new byte[0];
                c z2 = z(0, "ok");
                try {
                    if (TextUtils.isEmpty(str3)) {
                        bArr = g.ka(jL);
                    } else {
                        String a = a(new FileInputStream(file), ("base64".equals(str3) || "hex".equals(str3)) ? "" : str3);
                        if (!TextUtils.isEmpty(a)) {
                            if ("base64".equals(str3)) {
                                str4 = new String(Base64.encode(a.getBytes(), 2), "utf-8");
                            } else if ("hex".equals(str3)) {
                                str4 = g.jU(jL);
                            }
                        }
                        str4 = a;
                    }
                    if (TextUtils.isEmpty(str3)) {
                        z2.bzf = bArr;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str4);
                        z2.result = arrayList;
                    }
                    return z2;
                } catch (Exception e) {
                    e.printStackTrace();
                    return z(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                }
            }
            return C;
        }
        return be;
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

    public c q(String str, String str2, boolean z) {
        c be = be(str, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (be == null) {
            c be2 = be(str2, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (be2 == null) {
                c C = g.C(str, z ? "oldPath must be a string" : g.o("fail no such file or directory ", "rename", str, null), z ? " The argument must be string" : "fail parameter error: parameter.oldPath should be String instead of Undefined;");
                if (C == null) {
                    c C2 = g.C(str2, z ? "newPath must be a string" : g.o("fail no such file or directory ", "rename", str2, null), z ? " The argument must be string" : "fail parameter error: parameter.newPath should be String instead of Undefined;");
                    if (C2 == null) {
                        String jZ = g.jZ(str);
                        c jM = jM(jZ);
                        if (jM != null) {
                            jM.errMsg = g.o("fail permission denied, ", "rename", str, str2);
                            return jM;
                        }
                        String jZ2 = g.jZ(str2);
                        c jM2 = jM(jZ2);
                        if (jM2 != null) {
                            jM2.errMsg = g.o("fail permission denied, ", "rename", str, str2);
                            return jM2;
                        }
                        c C3 = C(jZ, false);
                        if (C3 != null) {
                            C3.errMsg = g.o("fail no such file or directory ", "rename", str, str2);
                            return C3;
                        } else if (!g.jQ(jZ) || !g.jQ(jZ2)) {
                            return z(-4, g.o("fail permission denied, ", "rename", str, str2));
                        } else {
                            c D = D(jZ2, false);
                            if (D != null) {
                                D.errMsg = g.o("fail no such file or directory ", "rename", str, str2);
                                return D;
                            }
                            String jL = jL(jZ);
                            String jL2 = jL(jZ2);
                            File file = new File(jL);
                            File file2 = new File(jL2);
                            boolean exists = file2.exists();
                            if (!g.d(file, file2) || (file.isDirectory() && !exists && jN(jL2))) {
                                return z(-1, "fail rename failed");
                            }
                            try {
                                if ((file2.isDirectory() && file2.listFiles() != null && file2.listFiles().length > 0) || !file.renameTo(file2)) {
                                    return z(-1, "fail rename failed");
                                }
                                return z(0, "ok");
                            } catch (Exception e) {
                                return z(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                            }
                        }
                    }
                    return C2;
                }
                return C;
            }
            return be2;
        }
        return be;
    }

    public c r(String str, String str2, boolean z) {
        c be = be(str2, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (be == null) {
            c C = g.C(str, "srcPath must be a string", " The argument must be string");
            if (C == null) {
                c C2 = g.C(str2, "destPath must be a string", " The argument must be string");
                if (C2 == null) {
                    String jZ = g.jZ(str);
                    if (!g.jQ(jZ)) {
                        return z(-4, g.o("fail no such file or directory ", "copyFile", str, null));
                    }
                    String jZ2 = g.jZ(str2);
                    if (!g.jQ(jZ2)) {
                        return z(-4, g.o("fail permission denied, open ", "copyFile", str2, null));
                    }
                    c jM = jM(jZ2);
                    if (jM == null) {
                        String jL = jL(jZ);
                        File file = new File(jL);
                        if (!file.exists() || !file.isFile()) {
                            return z(-1, g.o("fail no such file or directory ", "copyFile", str, null));
                        }
                        c D = D(jZ2, false);
                        if (D != null) {
                            D.errMsg = g.o("fail no such file or directory ", "copyFile", str2, null);
                            return D;
                        } else if (jZ2.endsWith(File.separator)) {
                            return z(-1, g.o("fail permission denied, ", "copyFile", str, str2));
                        } else {
                            File file2 = new File(jL(jZ2));
                            if (file2.exists() && file2.isDirectory()) {
                                if (d(file2.listFiles())) {
                                    return z(-1, g.o("fail permission denied, ", "copyFile", str, str2));
                                }
                                try {
                                    file2.delete();
                                } catch (Exception e) {
                                    return z(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
                                }
                            }
                            long fileSize = g.getFileSize(jL);
                            boolean z2 = (jZ.equals(jZ2) || jZ.startsWith(a.USER_DATA_PATH)) ? false : true;
                            if (z2 && g.aw(fileSize)) {
                                return z(-1, "fail file size over 50M");
                            }
                            c bg = !jZ.equals(jZ2) ? bg(jZ, jZ2) : z(0, "ok");
                            if (z2 && bg != null && bg.errCode == 0) {
                                g.av(fileSize);
                                return bg;
                            }
                            return bg;
                        }
                    }
                    return jM;
                }
                return C2;
            }
            return C;
        }
        return be;
    }

    public c b(String str, Object obj, String str2, boolean z) {
        c C = g.C(str, g.o("fail permission denied, open ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of NULL;");
        if (C == null) {
            c be = be(str, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (be == null) {
                String jZ = g.jZ(str);
                if (!"mounted".equals(Environment.getExternalStorageState())) {
                    return z(-1, "fail sdcard not mounted ");
                }
                c jM = jM(jZ);
                if (jM == null) {
                    if (obj == null) {
                        return z(-1, "fail TypeError: data argument must be a string, Buffer, ArrayBuffer, Array, or array-like object");
                    }
                    File file = new File(jL(jZ));
                    if (!file.exists()) {
                        return z(-1, g.o("fail no such file or directory ", "open", str, null));
                    }
                    if (file.isDirectory()) {
                        return z(-1, "fail illegal operation on a directory, open " + str);
                    }
                    return a(jZ, obj, str2, true);
                }
                return jM;
            }
            return be;
        }
        return C;
    }

    public c G(String str, boolean z) {
        c be = be(str, "android.permission.READ_EXTERNAL_STORAGE");
        if (be == null) {
            c C = g.C(str, z ? "path must be a string" : g.o("fail no such file or directory ", LogConfig.KEY_ACCESS, str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Undefined;");
            if (C == null) {
                String jZ = g.jZ(str);
                if (!g.jQ(jZ)) {
                    return z(-4, g.o("fail no such file or directory ", LogConfig.KEY_ACCESS, str, null));
                }
                if (!new File(jL(jZ)).exists()) {
                    return z(-1, g.o("fail no such file or directory ", LogConfig.KEY_ACCESS, str, null));
                }
                return z(0, "ok");
            }
            return C;
        }
        return be;
    }

    public c H(String str, boolean z) {
        c be = be(str, "android.permission.READ_EXTERNAL_STORAGE");
        if (be == null) {
            c C = g.C(str, z ? "path must be a string" : g.o("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Object;");
            if (C == null) {
                if (!g.kc(str) && !g.jR(str)) {
                    return z(-1, "fail permission denied, open " + str);
                }
                c C2 = C(str, false);
                if (C2 == null) {
                    f fVar = new f();
                    String jL = jL(str);
                    if (TextUtils.isEmpty(jL)) {
                        return z(-1, g.o("fail no such file or directory ", null, str, null));
                    }
                    File file = new File(jL);
                    fVar.dg(file.isDirectory());
                    fVar.dh(file.isFile());
                    return a(str, fVar);
                }
                return C2;
            }
            return C;
        }
        return be;
    }

    private c a(String str, f fVar) {
        File file = new File(jL(str));
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                fVar.lastAccessedTime = Os.lstat(file.getAbsolutePath()).st_atime;
                fVar.lastModifiedTime = Os.lstat(file.getAbsolutePath()).st_mtime;
                fVar.mode = Os.lstat(file.getAbsolutePath()).st_mode;
                fVar.size = Os.lstat(file.getAbsolutePath()).st_size;
            } catch (Exception e) {
                e.printStackTrace();
                return z(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
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
                return z(-1, LivenessStat.TYPE_FACE_MATCH_FAIL);
            }
        }
        c z = z(0, "ok");
        z.stats = fVar;
        z.errMsg = "ok";
        return z;
    }

    public c jP(String str) {
        c be = be(str, "android.permission.READ_EXTERNAL_STORAGE");
        if (be == null) {
            c C = g.C(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (C == null) {
                String jZ = g.jZ(str);
                if (!jZ.startsWith("bdfile://tmp")) {
                    return z(-4, "fail file not exist");
                }
                File file = new File(jL(jZ));
                if (!file.exists()) {
                    return z(-1, "fail file not exist");
                }
                if (file.isDirectory()) {
                    return z(-1, "fail " + str + " is directory");
                }
                c z = z(0, "ok");
                z.size = file.exists() ? file.length() : 0L;
                z.digest = file.exists() ? com.baidu.swan.c.b.b(file, false) : null;
                return z;
            }
            return C;
        }
        return be;
    }
}
