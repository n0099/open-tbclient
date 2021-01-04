package com.baidu.swan.games.i;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.system.Os;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
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
/* loaded from: classes9.dex */
public class f {
    private static List<String> eje = new ArrayList();
    private String ejf;
    private final com.baidu.swan.apps.storage.b.c ejg;
    private final com.baidu.swan.apps.storage.b.d ejh;
    private Context mContext;

    static {
        eje.add("ascii");
        eje.add("base64");
        eje.add("binary");
        eje.add("hex");
        eje.add("utf-8");
        eje.add("utf8");
        eje.add("latin1");
        eje.add("ucs2");
        eje.add("ucs-2");
        eje.add("utf16le");
        eje.add("utf-16le");
    }

    public f(Context context, String str, @NonNull com.baidu.swan.apps.storage.b.c cVar) {
        this.mContext = context;
        this.ejf = str;
        this.ejg = cVar;
        this.ejh = this.ejg.aPD();
    }

    private String xn(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith("bdfile://code")) {
            this.ejf = this.ejf.endsWith(File.separator) ? this.ejf.substring(0, this.ejf.length() - 1) : this.ejf;
            return this.ejf + str.substring("bdfile://code".length());
        } else if (str.startsWith("bdfile://")) {
            return this.ejg.ug(str);
        } else {
            return "";
        }
    }

    private c xo(String str) {
        c az = az(-1, "fail permission denied, open " + str);
        if (!TextUtils.isEmpty(str) && str.startsWith(a.USER_DATA_PATH)) {
            return null;
        }
        return az;
    }

    private c az(int i, String str) {
        c cVar = new c();
        cVar.errCode = i;
        cVar.errMsg = str;
        return cVar;
    }

    private c am(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            c cVar = new c();
            cVar.errCode = -1;
            cVar.errMsg = "fail no such file or directory " + str;
            return cVar;
        }
        String xn = xn(str);
        if (TextUtils.isEmpty(str)) {
            c cVar2 = new c();
            cVar2.errCode = -1;
            cVar2.errMsg = "fail no such file or directory " + str;
            return cVar2;
        }
        File file = new File(xn);
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

    private c an(String str, boolean z) {
        if (str.endsWith(File.separator)) {
            str = str.substring(0, str.length() - 1);
        }
        String xn = xn(str);
        if (TextUtils.isEmpty(xn)) {
            return az(-1, "fail no such file or directory " + str);
        }
        if (xn.contains(File.separator)) {
            File file = new File(xn.substring(0, xn.lastIndexOf(File.separator)));
            if (!z && (!file.exists() || (file.exists() && file.isFile()))) {
                return az(-1, "fail no such file or directory " + str);
            }
        }
        return null;
    }

    public c b(String str, boolean z, boolean z2) {
        boolean mkdir;
        c ag = n.ag(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (ag == null) {
            c xo = xo(str);
            if (xo == null) {
                if (!n.xt(str)) {
                    return az(-4, "fail permission denied, open " + str);
                }
                String xn = xn(str);
                if (TextUtils.isEmpty(xn)) {
                    return az(-1, "fail no such file or directory " + str);
                }
                c an = an(str, z);
                if (an == null) {
                    File file = new File(xn);
                    if (file.exists()) {
                        return az(-1, "fail file already exists " + str);
                    }
                    try {
                        if (z) {
                            mkdir = file.mkdirs();
                        } else {
                            mkdir = file.mkdir();
                        }
                        if (!mkdir) {
                            return az(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                        }
                        return az(0, "ok");
                    } catch (Exception e) {
                        return az(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                    }
                }
                return an;
            }
            return xo;
        }
        return ag;
    }

    public c a(boolean z, String str, Object obj, String str2) {
        c ag = n.ag(str, z ? "filePath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        return ag != null ? ag : a(str, obj, str2, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [457=4, 461=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:110:0x0181 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v26, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29, types: [com.baidu.swan.games.i.c] */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v71 */
    /* JADX WARN: Type inference failed for: r2v72 */
    private c a(String str, Object obj, String str2, boolean z) {
        Throwable th;
        FileOutputStream fileOutputStream;
        BufferedWriter bufferedWriter;
        ?? r2;
        String str3;
        String str4;
        c xo = xo(str);
        if (xo != null) {
            return xo;
        }
        if (obj == null) {
            return az(-1, "The argument must be string or arrayBuffer");
        }
        int length = (a.USER_DATA_PATH + File.separator).length();
        if (n.xt(str)) {
            boolean z2 = obj instanceof byte[];
            if (!z2 && TextUtils.isEmpty(str2)) {
                str2 = "utf-8";
            }
            if (!TextUtils.isEmpty(str2)) {
                if ("binary".equals(str2.toLowerCase())) {
                    str2 = "latin1";
                }
                if (!eje.contains(str2.toLowerCase())) {
                    return az(-1, "fail invalid encoding \"" + str2 + "\"");
                }
            }
            BufferedWriter bufferedWriter2 = null;
            Closeable closeable = null;
            c an = an(str, false);
            if (an == null) {
                String xn = xn(str);
                if (TextUtils.isEmpty(xn)) {
                    return az(-1, "fail no such file or directory " + str.substring(length));
                }
                long j = 0;
                if (!z2 && !TextUtils.isEmpty((String) obj)) {
                    j = ((String) obj).getBytes().length;
                } else if (z2) {
                    j = ((byte[]) obj).length;
                }
                if (this.ejg.aPD().cR(j)) {
                    return az(-1, aZU());
                }
                File file = new File(xn);
                if (file.exists() && file.isDirectory()) {
                    return az(-1, " fail illegal operation on a directory, open " + str);
                }
                long length2 = file.length();
                c az = az(0, "ok");
                try {
                    if (z2) {
                        byte[] bArr = (byte[]) obj;
                        FileOutputStream fileOutputStream2 = new FileOutputStream(xn, z);
                        try {
                            fileOutputStream2.write(bArr);
                            fileOutputStream2.flush();
                            r2 = fileOutputStream2;
                        } catch (Exception e) {
                            fileOutputStream = fileOutputStream2;
                            bufferedWriter = null;
                            c az2 = az(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                            com.baidu.swan.c.d.closeSafely(bufferedWriter);
                            com.baidu.swan.c.d.closeSafely(fileOutputStream);
                            return az2;
                        } catch (Throwable th2) {
                            th = th2;
                            closeable = fileOutputStream2;
                            com.baidu.swan.c.d.closeSafely(bufferedWriter2);
                            com.baidu.swan.c.d.closeSafely(closeable);
                            throw th;
                        }
                    } else if (TextUtils.isEmpty((String) obj) || !TextUtils.equals("base64", str2)) {
                        String[] dg = n.dg((String) obj, str2);
                        if (dg == null || dg.length != 2) {
                            str3 = "";
                            str4 = "utf-8";
                        } else {
                            str3 = dg[0];
                            str4 = dg[1];
                        }
                        BufferedWriter bufferedWriter3 = new BufferedWriter(TextUtils.isEmpty(str4) ? new OutputStreamWriter(new FileOutputStream(file, z)) : new OutputStreamWriter(new FileOutputStream(file, z), str4.toLowerCase()));
                        try {
                            bufferedWriter3.write(str3);
                            bufferedWriter3.flush();
                            r2 = 0;
                            bufferedWriter2 = bufferedWriter3;
                        } catch (Exception e2) {
                            fileOutputStream = null;
                            bufferedWriter = bufferedWriter3;
                            try {
                                c az22 = az(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                                com.baidu.swan.c.d.closeSafely(bufferedWriter);
                                com.baidu.swan.c.d.closeSafely(fileOutputStream);
                                return az22;
                            } catch (Throwable th3) {
                                th = th3;
                                closeable = fileOutputStream;
                                bufferedWriter2 = bufferedWriter;
                                com.baidu.swan.c.d.closeSafely(bufferedWriter2);
                                com.baidu.swan.c.d.closeSafely(closeable);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            bufferedWriter2 = bufferedWriter3;
                            com.baidu.swan.c.d.closeSafely(bufferedWriter2);
                            com.baidu.swan.c.d.closeSafely(closeable);
                            throw th;
                        }
                    } else {
                        byte[] decode = Base64.decode((String) obj, 2);
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file, z);
                        try {
                            fileOutputStream3.write(decode);
                            fileOutputStream3.flush();
                            r2 = fileOutputStream3;
                        } catch (Exception e3) {
                            fileOutputStream = fileOutputStream3;
                            bufferedWriter = null;
                            c az222 = az(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                            com.baidu.swan.c.d.closeSafely(bufferedWriter);
                            com.baidu.swan.c.d.closeSafely(fileOutputStream);
                            return az222;
                        } catch (Throwable th5) {
                            th = th5;
                            closeable = fileOutputStream3;
                            com.baidu.swan.c.d.closeSafely(bufferedWriter2);
                            com.baidu.swan.c.d.closeSafely(closeable);
                            throw th;
                        }
                    }
                } catch (Exception e4) {
                    fileOutputStream = null;
                    bufferedWriter = null;
                } catch (Throwable th6) {
                    th = th6;
                }
                try {
                    if (z) {
                        this.ejh.cQ(j);
                    } else {
                        this.ejh.cQ(j - length2);
                    }
                    com.baidu.swan.c.d.closeSafely(bufferedWriter2);
                    com.baidu.swan.c.d.closeSafely(r2);
                    r2 = az;
                    return r2;
                } catch (Exception e5) {
                    fileOutputStream = r2;
                    bufferedWriter = bufferedWriter2;
                    c az2222 = az(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                    com.baidu.swan.c.d.closeSafely(bufferedWriter);
                    com.baidu.swan.c.d.closeSafely(fileOutputStream);
                    return az2222;
                } catch (Throwable th7) {
                    th = th7;
                    closeable = r2;
                    com.baidu.swan.c.d.closeSafely(bufferedWriter2);
                    com.baidu.swan.c.d.closeSafely(closeable);
                    throw th;
                }
            }
            return an;
        }
        return az(-4, "fail permission denied, open " + str.substring(length));
    }

    public c ao(String str, boolean z) {
        c az;
        c ag = n.ag(str, z ? "filePath must be a string" : n.u("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of Object;");
        if (ag == null) {
            if (!n.xu(str)) {
                return az(-4, n.u("fail permission denied, open ", null, str, null));
            }
            c am = am(str, false);
            if (am == null) {
                c xo = xo(str);
                if (xo == null) {
                    String xn = xn(str);
                    if (TextUtils.isEmpty(xn)) {
                        return az(-1, n.u("fail no such file or directory ", null, str, null));
                    }
                    File file = new File(xn);
                    if (file.isDirectory()) {
                        return az(-1, n.u("fail operation not permitted ", "unlink", str, null));
                    }
                    long fileSize = n.getFileSize(xn);
                    try {
                        if (file.delete()) {
                            this.ejh.cQ(-fileSize);
                            az = az(0, "ok");
                        } else {
                            az = az(-1, n.u(com.baidu.pass.biometrics.face.liveness.c.a.p, null, str, null));
                        }
                        return az;
                    } catch (Exception e) {
                        return az(-1, n.u(com.baidu.pass.biometrics.face.liveness.c.a.p, null, str, null));
                    }
                }
                return xo;
            }
            return am;
        }
        return ag;
    }

    public c dc(String str, String str2) {
        c ag = n.ag(str, n.g("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true), "fail parameter error: parameter.zipFilePath should be String instead of Object;");
        if (ag == null) {
            c ag2 = n.ag(str2, n.g("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true), "fail parameter error: parameter.targetPath should be String instead of Object;");
            if (ag2 == null) {
                if (!str2.startsWith("bdfile://tmp") && !str2.startsWith(a.USER_DATA_PATH)) {
                    return az(-1, "fail permission denied, open " + str2);
                }
                String xB = n.xB(str);
                if (!this.ejg.ah(xB, true)) {
                    return az(-4, n.g("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (!n.xt(str2)) {
                    return az(-4, n.g("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (xp(str2)) {
                    return az(-1, n.g("fail permission denied, ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                String xn = xn(xB);
                String xn2 = xn(str2);
                if (TextUtils.isEmpty(xn)) {
                    return az(-1, n.g("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (TextUtils.isEmpty(xn2)) {
                    return az(-1, n.g("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                File file = new File(xn);
                if (!file.exists()) {
                    return az(-1, n.g("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (!xn.endsWith(".zip")) {
                    return az(-1, "fail unzip failed");
                }
                if (!file.isFile()) {
                    return az(-1, n.g("fail permission denied, ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                File file2 = new File(xn2);
                if (!file2.exists()) {
                    file2.mkdirs();
                } else if (file2.isFile()) {
                    return az(-1, "fail unzip failed");
                }
                List<String> as = n.as(xn2, true);
                if (!com.baidu.swan.c.d.unzipFile(xn, xn2)) {
                    return az(-1, "fail unzip failed");
                }
                if (str2.startsWith(a.USER_DATA_PATH)) {
                    List<String> as2 = n.as(xn2, true);
                    ArrayList arrayList = new ArrayList(as2.size());
                    long j = 0;
                    for (String str3 : as2) {
                        if (!as.contains(str3)) {
                            arrayList.add(str3);
                            j = n.getFileSize(str3) + j;
                        }
                    }
                    if (this.ejh.cR(j)) {
                        n.bd(arrayList);
                        return az(-1, aZU());
                    }
                    this.ejh.cQ(j);
                }
                return az(0, "ok");
            }
            return ag2;
        }
        return ag;
    }

    private boolean xp(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains(File.separator)) {
            return xq(str.substring(str.lastIndexOf(File.separator) + 1));
        }
        return xq(str);
    }

    private boolean xq(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(".")) {
            return false;
        }
        String[] split = str.split("\\.");
        return (split.length != 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) ? false : true;
    }

    public c u(String str, String str2, boolean z) {
        c ag = n.ag(str, z ? "tempFilePath must be a string" : "fail tempFilePath file not exist", z ? " The argument must be string" : "fail parameter error: parameter.tempFilePath should be String instead of Object;");
        if (ag == null) {
            String xB = n.xB(str2);
            if (TextUtils.isEmpty(xB)) {
                xB = a.USER_DATA_PATH + File.separator + com.baidu.swan.c.d.getFileNameFromPath(str);
            }
            if (!xB.startsWith(a.USER_DATA_PATH)) {
                return az(-1, n.u("fail permission denied, open ", null, str2, null));
            }
            if (!this.ejg.tQ(str)) {
                return az(-4, "fail it is not a tempFilePath");
            }
            c an = an(xB, false);
            if (an != null) {
                return an;
            }
            c an2 = an(str, false);
            if (an2 != null) {
                return an2;
            }
            String xn = xn(xB);
            if (TextUtils.isEmpty(xn)) {
                return az(-1, "fail no such file or directory " + str2);
            }
            File file = new File(xn);
            if (a.USER_DATA_PATH.equals(xB) || (file.exists() && file.isDirectory())) {
                return az(-1, n.u("fail Error: EISDIR: illegal operation on a directory, open ", null, str2, null));
            }
            c am = am(str, true);
            if (am != null) {
                am.errMsg = "fail no such file or directory ";
                return am;
            }
            String xn2 = xn(str);
            if (TextUtils.isEmpty(xn2)) {
                return az(-1, "fail no such file or directory " + str);
            }
            long fileSize = n.getFileSize(xn2);
            if (this.ejh.cR(fileSize)) {
                return az(-1, aZU());
            }
            if (!xB.startsWith(a.USER_DATA_PATH) || n.xv(xB)) {
                return az(-1, n.u("fail permission denied, open ", null, str2, null));
            }
            c an3 = an(xB, false);
            if (an3 != null) {
                return an3;
            }
            c xo = xo(xB);
            if (xo != null) {
                return xo;
            }
            c dd = dd(str, xB);
            if (dd != null && dd.errCode == 0) {
                this.ejh.cQ(fileSize);
                if (TextUtils.isEmpty(str)) {
                    return az(-1, n.u("fail no such file or directory ", null, str, null));
                }
                File file2 = new File(xn2);
                if (file2.exists()) {
                    file2.delete();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(xB);
                dd.result = arrayList;
                dd.errMsg = "ok";
            }
            return dd;
        }
        return ag;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [813=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x00d0 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable] */
    private c dd(String str, String str2) {
        FileOutputStream fileOutputStream;
        File file;
        FileInputStream fileInputStream = null;
        String xn = xn(str);
        ?? xn2 = xn(str2);
        if (TextUtils.isEmpty(xn)) {
            return az(-1, n.u("fail no such file or directory ", null, str, null));
        }
        if (TextUtils.isEmpty(xn2)) {
            return az(-1, n.u("fail no such file or directory ", null, str2, null));
        }
        c az = az(0, "ok");
        try {
            try {
                file = new File((String) xn2);
                fileInputStream = new FileInputStream(new File(xn));
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream = new FileOutputStream(file);
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
                        az.errMsg = com.baidu.pass.biometrics.face.liveness.c.a.p;
                        az.errCode = -1;
                        return az;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str2);
                    az.result = arrayList;
                    return az;
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                    c az2 = az(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                    com.baidu.swan.c.d.closeSafely(fileInputStream);
                    com.baidu.swan.c.d.closeSafely(fileOutputStream);
                    if (TextUtils.isEmpty("")) {
                        az.errMsg = com.baidu.pass.biometrics.face.liveness.c.a.p;
                        az.errCode = -1;
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(str2);
                        az.result = arrayList2;
                    }
                    return az2;
                }
            } catch (IOException e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                xn2 = 0;
                com.baidu.swan.c.d.closeSafely(fileInputStream);
                com.baidu.swan.c.d.closeSafely(xn2);
                if (TextUtils.isEmpty("")) {
                    az.errMsg = com.baidu.pass.biometrics.face.liveness.c.a.p;
                    az.errCode = -1;
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(str2);
                    az.result = arrayList3;
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            xn2 = 0;
            fileInputStream = null;
        }
    }

    public c ap(String str, boolean z) {
        c ag = n.ag(str, z ? "dirPath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (ag == null) {
            String xB = n.xB(str);
            if (!n.xu(xB)) {
                return az(-4, "fail permission denied, open " + str);
            }
            String xn = xn(xB);
            if (TextUtils.isEmpty(xn)) {
                return az(-1, "fail no such file or directory " + str);
            }
            File file = new File(xn);
            if (!file.exists()) {
                return az(-1, "fail no such file or directory " + str);
            }
            if (!file.isDirectory()) {
                return az(-1, "fail no such file or directory " + str);
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
            c az = az(0, "ok");
            az.result = arrayList;
            return az;
        }
        return ag;
    }

    public c c(String str, boolean z, boolean z2) {
        boolean deleteFile;
        c ag = n.ag(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (ag == null) {
            c xo = xo(str);
            if (xo == null) {
                if (!n.xu(str)) {
                    return az(-4, "fail permission denied, open " + str);
                }
                String xn = xn(str);
                if (TextUtils.isEmpty(xn)) {
                    return az(-1, "fail no such file or directory " + str);
                }
                File file = new File(xn);
                if (!file.exists() || file.isFile()) {
                    return az(-1, "fail no such file or directory " + str);
                }
                boolean d = d(file.listFiles());
                try {
                    if (!z && d) {
                        return az(-1, "fail directory not empty ");
                    }
                    if (!z) {
                        deleteFile = file.delete();
                    } else {
                        deleteFile = com.baidu.swan.c.d.deleteFile(file);
                    }
                    if (!deleteFile) {
                        return az(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                    }
                    return az(0, "ok");
                } catch (Exception e) {
                    return az(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                }
            }
            return xo;
        }
        return ag;
    }

    private boolean d(File[] fileArr) {
        return (fileArr == null || fileArr.length == 0) ? false : true;
    }

    public c v(String str, String str2, boolean z) {
        byte[] bArr;
        c ag = n.ag(str, z ? "filePath must be a string" : "fail file not found", z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of NULL;");
        if (ag == null) {
            String xB = n.xB(str);
            if (!this.ejg.ah(xB, true)) {
                return az(-1, "fail permission denied, open " + str);
            }
            c am = am(xB, true);
            if (am != null) {
                am.errMsg = n.u("fail no such file or directory ", "open", str, null);
                return am;
            }
            boolean isEmpty = TextUtils.isEmpty(str2);
            if (!isEmpty) {
                str2 = str2.toLowerCase();
                if ("binary".equals(str2)) {
                    str2 = "latin1";
                }
            }
            if (!isEmpty && !eje.contains(str2)) {
                return az(-1, "fail Error: Unknown encoding: " + str2);
            }
            String xn = xn(xB);
            if (TextUtils.isEmpty(xn)) {
                return az(-1, "fail no such file or directory " + str);
            }
            File file = new File(xn);
            String str3 = "";
            byte[] bArr2 = new byte[0];
            c az = az(0, "ok");
            try {
                if (TextUtils.isEmpty(str2)) {
                    bArr = n.xC(xn);
                } else if ("base64".equals(str2)) {
                    bArr = n.xC(xn);
                    str3 = bArr.length == 0 ? "" : Base64.encodeToString(bArr, 2);
                } else if ("hex".equals(str2)) {
                    str3 = n.xx(xn);
                    bArr = bArr2;
                } else {
                    str3 = a(new FileInputStream(file), str2);
                    bArr = bArr2;
                }
                if (TextUtils.isEmpty(str2)) {
                    az.eil = bArr;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str3);
                    az.result = arrayList;
                }
                return az;
            } catch (Exception e) {
                e.printStackTrace();
                return az(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
            }
        }
        return ag;
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

    public c w(String str, String str2, boolean z) {
        c ag = n.ag(str, z ? "oldPath must be a string" : n.u("fail no such file or directory ", "rename", str, null), z ? " The argument must be string" : "fail parameter error: parameter.oldPath should be String instead of Undefined;");
        if (ag == null) {
            c ag2 = n.ag(str2, z ? "newPath must be a string" : n.u("fail no such file or directory ", "rename", str2, null), z ? " The argument must be string" : "fail parameter error: parameter.newPath should be String instead of Undefined;");
            if (ag2 == null) {
                String xB = n.xB(str);
                c xo = xo(xB);
                if (xo != null) {
                    xo.errMsg = n.u("fail permission denied, ", "rename", str, str2);
                    return xo;
                }
                String xB2 = n.xB(str2);
                c xo2 = xo(xB2);
                if (xo2 != null) {
                    xo2.errMsg = n.u("fail permission denied, ", "rename", str, str2);
                    return xo2;
                }
                c am = am(xB, false);
                if (am != null) {
                    am.errMsg = n.u("fail no such file or directory ", "rename", str, str2);
                    return am;
                } else if (!n.xt(xB) || !n.xt(xB2)) {
                    return az(-4, n.u("fail permission denied, ", "rename", str, str2));
                } else {
                    c an = an(xB2, false);
                    if (an != null) {
                        an.errMsg = n.u("fail no such file or directory ", "rename", str, str2);
                        return an;
                    }
                    String xn = xn(xB);
                    if (TextUtils.isEmpty(xn)) {
                        return az(-1, "fail no such file or directory " + str);
                    }
                    String xn2 = xn(xB2);
                    if (TextUtils.isEmpty(xn2)) {
                        return az(-1, "fail no such file or directory " + str2);
                    }
                    File file = new File(xn);
                    File file2 = new File(xn2);
                    boolean exists = file2.exists();
                    if (!n.k(file, file2) || (file.isDirectory() && !exists && xp(xn2))) {
                        return az(-1, "fail rename failed");
                    }
                    try {
                        if ((file2.isDirectory() && file2.listFiles() != null && file2.listFiles().length > 0) || !file.renameTo(file2)) {
                            return az(-1, "fail rename failed");
                        }
                        return az(0, "ok");
                    } catch (Exception e) {
                        return az(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                    }
                }
            }
            return ag2;
        }
        return ag;
    }

    public c x(String str, String str2, boolean z) {
        boolean z2 = true;
        c ag = n.ag(str, "srcPath must be a string", " The argument must be string");
        if (ag == null) {
            c ag2 = n.ag(str2, "destPath must be a string", " The argument must be string");
            if (ag2 == null) {
                String xB = n.xB(str);
                if (!this.ejg.ah(xB, true)) {
                    return az(-4, n.u("fail no such file or directory ", "copyFile", str, null));
                }
                String xB2 = n.xB(str2);
                if (!n.xt(xB2)) {
                    return az(-4, n.u("fail permission denied, open ", "copyFile", str2, null));
                }
                c xo = xo(xB2);
                if (xo == null) {
                    String xn = xn(xB);
                    if (TextUtils.isEmpty(xn)) {
                        return az(-1, "fail no such file or directory " + str);
                    }
                    File file = new File(xn);
                    if (!file.exists() || !file.isFile()) {
                        return az(-1, n.u("fail no such file or directory ", "copyFile", str, null));
                    }
                    c an = an(xB2, false);
                    if (an != null) {
                        an.errMsg = n.u("fail no such file or directory ", "copyFile", str2, null);
                        return an;
                    } else if (xB2.endsWith(File.separator)) {
                        return az(-1, n.u("fail permission denied, ", "copyFile", str, str2));
                    } else {
                        String xn2 = xn(xB2);
                        if (TextUtils.isEmpty(xn2)) {
                            return az(-1, "fail no such file or directory " + str2);
                        }
                        File file2 = new File(xn2);
                        if (file2.exists() && file2.isDirectory()) {
                            if (d(file2.listFiles())) {
                                return az(-1, n.u("fail permission denied, ", "copyFile", str, str2));
                            }
                            try {
                                file2.delete();
                            } catch (Exception e) {
                                return az(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                            }
                        }
                        long fileSize = n.getFileSize(xn);
                        if (xB.equals(xB2) || xB.startsWith(a.USER_DATA_PATH)) {
                            z2 = false;
                        }
                        if (z2 && this.ejh.cR(fileSize)) {
                            return az(-1, aZU());
                        }
                        c dd = !xB.equals(xB2) ? dd(xB, xB2) : az(0, "ok");
                        if (z2 && dd != null && dd.errCode == 0) {
                            this.ejh.cQ(fileSize);
                            return dd;
                        }
                        return dd;
                    }
                }
                return xo;
            }
            return ag2;
        }
        return ag;
    }

    public c b(String str, Object obj, String str2, boolean z) {
        c ag = n.ag(str, n.u("fail permission denied, open ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of NULL;");
        if (ag == null) {
            String xB = n.xB(str);
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return az(-1, "fail sdcard not mounted ");
            }
            c xo = xo(xB);
            if (xo == null) {
                if (obj == null) {
                    return az(-1, "fail TypeError: data argument must be a string, Buffer, ArrayBuffer, Array, or array-like object");
                }
                String xn = xn(xB);
                if (TextUtils.isEmpty(xn)) {
                    return az(-1, "fail no such file or directory " + str);
                }
                File file = new File(xn);
                if (!file.exists()) {
                    return az(-1, n.u("fail no such file or directory ", "open", str, null));
                }
                if (file.isDirectory()) {
                    return az(-1, "fail illegal operation on a directory, open " + str);
                }
                return a(xB, obj, str2, true);
            }
            return xo;
        }
        return ag;
    }

    public c aq(String str, boolean z) {
        c ag = n.ag(str, z ? "path must be a string" : n.u("fail no such file or directory ", "access", str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Undefined;");
        if (ag == null) {
            String xB = n.xB(str);
            if (!this.ejg.ah(xB, true)) {
                return az(-4, n.u("fail no such file or directory ", "access", str, null));
            }
            String xn = xn(xB);
            if (TextUtils.isEmpty(xn)) {
                return az(-1, "fail no such file or directory " + str);
            }
            if (!new File(xn).exists()) {
                return az(-1, n.u("fail no such file or directory ", "access", str, null));
            }
            return az(0, "ok");
        }
        return ag;
    }

    public c ar(String str, boolean z) {
        c ag = n.ag(str, z ? "path must be a string" : n.u("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Object;");
        if (ag == null) {
            if (!this.ejg.tQ(str) && !this.ejg.tP(str)) {
                return az(-1, "fail permission denied, open " + str);
            }
            c am = am(str, false);
            if (am == null) {
                j jVar = new j();
                String xn = xn(str);
                if (TextUtils.isEmpty(xn)) {
                    return az(-1, n.u("fail no such file or directory ", null, str, null));
                }
                File file = new File(xn);
                jVar.ie(file.isDirectory());
                jVar.m33if(file.isFile());
                return a(str, jVar);
            }
            return am;
        }
        return ag;
    }

    private c a(String str, j jVar) {
        String xn = xn(str);
        if (TextUtils.isEmpty(xn)) {
            return az(-1, "fail no such file or directory " + str);
        }
        File file = new File(xn);
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                jVar.lastAccessedTime = Os.lstat(file.getAbsolutePath()).st_atime;
                jVar.lastModifiedTime = Os.lstat(file.getAbsolutePath()).st_mtime;
                jVar.mode = Os.lstat(file.getAbsolutePath()).st_mode;
                jVar.size = Os.lstat(file.getAbsolutePath()).st_size;
            } catch (Exception e) {
                e.printStackTrace();
                return az(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
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
                return az(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
            }
        }
        c az = az(0, "ok");
        az.stats = jVar;
        az.errMsg = "ok";
        return az;
    }

    public c aZT() {
        String aPC = this.ejg.aPC();
        String xn = xn(a.USER_DATA_PATH);
        if (TextUtils.isEmpty(xn)) {
            return az(-1, "path must be a string");
        }
        ArrayList arrayList = new ArrayList();
        for (String str : n.as(xn, false)) {
            File file = new File(str);
            d dVar = new d();
            dVar.createTime = file.exists() ? file.lastModified() : 0L;
            String absolutePath = file.getAbsolutePath();
            if (file.exists() && !TextUtils.isEmpty(absolutePath) && !TextUtils.isEmpty(aPC) && absolutePath.startsWith(aPC)) {
                dVar.filePath = this.ejg.uh(absolutePath);
            }
            dVar.size = file.exists() ? file.length() : 0L;
            arrayList.add(dVar);
        }
        c az = az(0, "ok");
        az.fileList = arrayList;
        return az;
    }

    public c xr(String str) {
        c az;
        c ag = n.ag(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Object;");
        if (ag == null) {
            if (xo(str) != null) {
                return az(-4, "fail file not exist");
            }
            String xn = xn(str);
            if (TextUtils.isEmpty(xn)) {
                return az(-1, "fail no such file or directory " + str);
            }
            File file = new File(xn);
            if (!file.exists() || file.isDirectory()) {
                return az(-1, "fail file not exist");
            }
            long fileSize = n.getFileSize(xn);
            try {
                if (!file.delete()) {
                    az = az(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                } else {
                    this.ejh.cQ(-fileSize);
                    az = az(0, "ok");
                }
                return az;
            } catch (Exception e) {
                return az(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
            }
        }
        return ag;
    }

    public c xs(String str) {
        c ag = n.ag(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Undefined;");
        if (ag == null) {
            String xB = n.xB(str);
            if (!this.ejg.ah(xB, true)) {
                return az(-4, "fail file not exist");
            }
            String xn = xn(xB);
            if (TextUtils.isEmpty(xn)) {
                return az(-1, "fail no such file or directory " + str);
            }
            File file = new File(xn);
            if (!file.exists()) {
                return az(-1, "fail file not exist");
            }
            if (file.isDirectory()) {
                return az(-1, "fail " + str + " is directory");
            }
            c az = az(0, "ok");
            az.size = file.exists() ? file.length() : 0L;
            az.digest = file.exists() ? com.baidu.swan.c.e.e(file, false) : null;
            return az;
        }
        return ag;
    }

    private String aZU() {
        String generateFileSizeText = com.baidu.swan.c.d.generateFileSizeText(this.ejh.getMaxSize());
        return String.format("fail file size over %s", (TextUtils.isEmpty(generateFileSizeText) || TextUtils.equals(generateFileSizeText, FileUtils.UNKNOW)) ? "" : "");
    }
}
