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
/* loaded from: classes8.dex */
public class f {
    private static List<String> eia = new ArrayList();
    private String eib;
    private final com.baidu.swan.apps.storage.b.c eic;
    private final com.baidu.swan.apps.storage.b.d eid;
    private Context mContext;

    static {
        eia.add("ascii");
        eia.add("base64");
        eia.add("binary");
        eia.add("hex");
        eia.add("utf-8");
        eia.add("utf8");
        eia.add("latin1");
        eia.add("ucs2");
        eia.add("ucs-2");
        eia.add("utf16le");
        eia.add("utf-16le");
    }

    public f(Context context, String str, @NonNull com.baidu.swan.apps.storage.b.c cVar) {
        this.mContext = context;
        this.eib = str;
        this.eic = cVar;
        this.eid = this.eic.aMg();
    }

    private String wC(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith("bdfile://code")) {
            this.eib = this.eib.endsWith(File.separator) ? this.eib.substring(0, this.eib.length() - 1) : this.eib;
            return this.eib + str.substring("bdfile://code".length());
        } else if (str.startsWith("bdfile://")) {
            return this.eic.tv(str);
        } else {
            return "";
        }
    }

    private c wD(String str) {
        c aE = aE(-1, "fail permission denied, open " + str);
        if (!TextUtils.isEmpty(str) && str.startsWith(a.USER_DATA_PATH)) {
            return null;
        }
        return aE;
    }

    private c aE(int i, String str) {
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
        String wC = wC(str);
        if (TextUtils.isEmpty(str)) {
            c cVar2 = new c();
            cVar2.errCode = -1;
            cVar2.errMsg = "fail no such file or directory " + str;
            return cVar2;
        }
        File file = new File(wC);
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
        String wC = wC(str);
        if (TextUtils.isEmpty(wC)) {
            return aE(-1, "fail no such file or directory " + str);
        }
        if (wC.contains(File.separator)) {
            File file = new File(wC.substring(0, wC.lastIndexOf(File.separator)));
            if (!z && (!file.exists() || (file.exists() && file.isFile()))) {
                return aE(-1, "fail no such file or directory " + str);
            }
        }
        return null;
    }

    public c b(String str, boolean z, boolean z2) {
        boolean mkdir;
        c ag = n.ag(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (ag == null) {
            c wD = wD(str);
            if (wD == null) {
                if (!n.wI(str)) {
                    return aE(-4, "fail permission denied, open " + str);
                }
                String wC = wC(str);
                if (TextUtils.isEmpty(wC)) {
                    return aE(-1, "fail no such file or directory " + str);
                }
                c am = am(str, z);
                if (am == null) {
                    File file = new File(wC);
                    if (file.exists()) {
                        return aE(-1, "fail file already exists " + str);
                    }
                    try {
                        if (z) {
                            mkdir = file.mkdirs();
                        } else {
                            mkdir = file.mkdir();
                        }
                        if (!mkdir) {
                            return aE(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                        }
                        return aE(0, "ok");
                    } catch (Exception e) {
                        return aE(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                    }
                }
                return am;
            }
            return wD;
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
        c wD = wD(str);
        if (wD != null) {
            return wD;
        }
        if (obj == null) {
            return aE(-1, "The argument must be string or arrayBuffer");
        }
        int length = (a.USER_DATA_PATH + File.separator).length();
        if (n.wI(str)) {
            boolean z2 = obj instanceof byte[];
            if (!z2 && TextUtils.isEmpty(str2)) {
                str2 = "utf-8";
            }
            if (!TextUtils.isEmpty(str2)) {
                if ("binary".equals(str2.toLowerCase())) {
                    str2 = "latin1";
                }
                if (!eia.contains(str2.toLowerCase())) {
                    return aE(-1, "fail invalid encoding \"" + str2 + "\"");
                }
            }
            BufferedWriter bufferedWriter2 = null;
            Closeable closeable = null;
            c am = am(str, false);
            if (am == null) {
                String wC = wC(str);
                if (TextUtils.isEmpty(wC)) {
                    return aE(-1, "fail no such file or directory " + str.substring(length));
                }
                long j = 0;
                if (!z2 && !TextUtils.isEmpty((String) obj)) {
                    j = ((String) obj).getBytes().length;
                } else if (z2) {
                    j = ((byte[]) obj).length;
                }
                if (this.eic.aMg().cX(j)) {
                    return aE(-1, aWq());
                }
                File file = new File(wC);
                if (file.exists() && file.isDirectory()) {
                    return aE(-1, " fail illegal operation on a directory, open " + str);
                }
                long length2 = file.length();
                c aE = aE(0, "ok");
                try {
                    if (z2) {
                        byte[] bArr = (byte[]) obj;
                        FileOutputStream fileOutputStream2 = new FileOutputStream(wC, z);
                        try {
                            fileOutputStream2.write(bArr);
                            fileOutputStream2.flush();
                            r2 = fileOutputStream2;
                        } catch (Exception e) {
                            fileOutputStream = fileOutputStream2;
                            bufferedWriter = null;
                            c aE2 = aE(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                            com.baidu.swan.c.d.closeSafely(bufferedWriter);
                            com.baidu.swan.c.d.closeSafely(fileOutputStream);
                            return aE2;
                        } catch (Throwable th2) {
                            th = th2;
                            closeable = fileOutputStream2;
                            com.baidu.swan.c.d.closeSafely(bufferedWriter2);
                            com.baidu.swan.c.d.closeSafely(closeable);
                            throw th;
                        }
                    } else if (TextUtils.isEmpty((String) obj) || !TextUtils.equals("base64", str2)) {
                        String[] cZ = n.cZ((String) obj, str2);
                        if (cZ == null || cZ.length != 2) {
                            str3 = "";
                            str4 = "utf-8";
                        } else {
                            str3 = cZ[0];
                            str4 = cZ[1];
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
                                c aE22 = aE(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                                com.baidu.swan.c.d.closeSafely(bufferedWriter);
                                com.baidu.swan.c.d.closeSafely(fileOutputStream);
                                return aE22;
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
                            c aE222 = aE(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                            com.baidu.swan.c.d.closeSafely(bufferedWriter);
                            com.baidu.swan.c.d.closeSafely(fileOutputStream);
                            return aE222;
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
                        this.eid.cW(j);
                    } else {
                        this.eid.cW(j - length2);
                    }
                    com.baidu.swan.c.d.closeSafely(bufferedWriter2);
                    com.baidu.swan.c.d.closeSafely(r2);
                    r2 = aE;
                    return r2;
                } catch (Exception e5) {
                    fileOutputStream = r2;
                    bufferedWriter = bufferedWriter2;
                    c aE2222 = aE(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                    com.baidu.swan.c.d.closeSafely(bufferedWriter);
                    com.baidu.swan.c.d.closeSafely(fileOutputStream);
                    return aE2222;
                } catch (Throwable th7) {
                    th = th7;
                    closeable = r2;
                    com.baidu.swan.c.d.closeSafely(bufferedWriter2);
                    com.baidu.swan.c.d.closeSafely(closeable);
                    throw th;
                }
            }
            return am;
        }
        return aE(-4, "fail permission denied, open " + str.substring(length));
    }

    public c an(String str, boolean z) {
        c aE;
        c ag = n.ag(str, z ? "filePath must be a string" : n.u("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of Object;");
        if (ag == null) {
            if (!n.wJ(str)) {
                return aE(-4, n.u("fail permission denied, open ", null, str, null));
            }
            c al = al(str, false);
            if (al == null) {
                c wD = wD(str);
                if (wD == null) {
                    String wC = wC(str);
                    if (TextUtils.isEmpty(wC)) {
                        return aE(-1, n.u("fail no such file or directory ", null, str, null));
                    }
                    File file = new File(wC);
                    if (file.isDirectory()) {
                        return aE(-1, n.u("fail operation not permitted ", "unlink", str, null));
                    }
                    long fileSize = n.getFileSize(wC);
                    try {
                        if (file.delete()) {
                            this.eid.cW(-fileSize);
                            aE = aE(0, "ok");
                        } else {
                            aE = aE(-1, n.u(com.baidu.pass.biometrics.face.liveness.c.a.p, null, str, null));
                        }
                        return aE;
                    } catch (Exception e) {
                        return aE(-1, n.u(com.baidu.pass.biometrics.face.liveness.c.a.p, null, str, null));
                    }
                }
                return wD;
            }
            return al;
        }
        return ag;
    }

    public c cV(String str, String str2) {
        c ag = n.ag(str, n.c("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true), "fail parameter error: parameter.zipFilePath should be String instead of Object;");
        if (ag == null) {
            c ag2 = n.ag(str2, n.c("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true), "fail parameter error: parameter.targetPath should be String instead of Object;");
            if (ag2 == null) {
                if (!str2.startsWith("bdfile://tmp") && !str2.startsWith(a.USER_DATA_PATH)) {
                    return aE(-1, "fail permission denied, open " + str2);
                }
                String wQ = n.wQ(str);
                if (!this.eic.ag(wQ, true)) {
                    return aE(-4, n.c("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (!n.wI(str2)) {
                    return aE(-4, n.c("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (wE(str2)) {
                    return aE(-1, n.c("fail permission denied, ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                String wC = wC(wQ);
                String wC2 = wC(str2);
                if (TextUtils.isEmpty(wC)) {
                    return aE(-1, n.c("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (TextUtils.isEmpty(wC2)) {
                    return aE(-1, n.c("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                File file = new File(wC);
                if (!file.exists()) {
                    return aE(-1, n.c("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (!wC.endsWith(".zip")) {
                    return aE(-1, "fail unzip failed");
                }
                if (!file.isFile()) {
                    return aE(-1, n.c("fail permission denied, ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                File file2 = new File(wC2);
                if (!file2.exists()) {
                    file2.mkdirs();
                } else if (file2.isFile()) {
                    return aE(-1, "fail unzip failed");
                }
                List<String> ar = n.ar(wC2, true);
                if (!com.baidu.swan.c.d.unzipFile(wC, wC2)) {
                    return aE(-1, "fail unzip failed");
                }
                if (str2.startsWith(a.USER_DATA_PATH)) {
                    List<String> ar2 = n.ar(wC2, true);
                    ArrayList arrayList = new ArrayList(ar2.size());
                    long j = 0;
                    for (String str3 : ar2) {
                        if (!ar.contains(str3)) {
                            arrayList.add(str3);
                            j = n.getFileSize(str3) + j;
                        }
                    }
                    if (this.eid.cX(j)) {
                        n.aY(arrayList);
                        return aE(-1, aWq());
                    }
                    this.eid.cW(j);
                }
                return aE(0, "ok");
            }
            return ag2;
        }
        return ag;
    }

    private boolean wE(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains(File.separator)) {
            return wF(str.substring(str.lastIndexOf(File.separator) + 1));
        }
        return wF(str);
    }

    private boolean wF(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(".")) {
            return false;
        }
        String[] split = str.split("\\.");
        return (split.length != 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) ? false : true;
    }

    public c u(String str, String str2, boolean z) {
        c ag = n.ag(str, z ? "tempFilePath must be a string" : "fail tempFilePath file not exist", z ? " The argument must be string" : "fail parameter error: parameter.tempFilePath should be String instead of Object;");
        if (ag == null) {
            String wQ = n.wQ(str2);
            if (TextUtils.isEmpty(wQ)) {
                wQ = a.USER_DATA_PATH + File.separator + com.baidu.swan.c.d.getFileNameFromPath(str);
            }
            if (!wQ.startsWith(a.USER_DATA_PATH)) {
                return aE(-1, n.u("fail permission denied, open ", null, str2, null));
            }
            if (!this.eic.tf(str)) {
                return aE(-4, "fail it is not a tempFilePath");
            }
            c am = am(wQ, false);
            if (am != null) {
                return am;
            }
            c am2 = am(str, false);
            if (am2 != null) {
                return am2;
            }
            String wC = wC(wQ);
            if (TextUtils.isEmpty(wC)) {
                return aE(-1, "fail no such file or directory " + str2);
            }
            File file = new File(wC);
            if (a.USER_DATA_PATH.equals(wQ) || (file.exists() && file.isDirectory())) {
                return aE(-1, n.u("fail Error: EISDIR: illegal operation on a directory, open ", null, str2, null));
            }
            c al = al(str, true);
            if (al != null) {
                al.errMsg = "fail no such file or directory ";
                return al;
            }
            String wC2 = wC(str);
            if (TextUtils.isEmpty(wC2)) {
                return aE(-1, "fail no such file or directory " + str);
            }
            long fileSize = n.getFileSize(wC2);
            if (this.eid.cX(fileSize)) {
                return aE(-1, aWq());
            }
            if (!wQ.startsWith(a.USER_DATA_PATH) || n.wK(wQ)) {
                return aE(-1, n.u("fail permission denied, open ", null, str2, null));
            }
            c am3 = am(wQ, false);
            if (am3 != null) {
                return am3;
            }
            c wD = wD(wQ);
            if (wD != null) {
                return wD;
            }
            c cW = cW(str, wQ);
            if (cW != null && cW.errCode == 0) {
                this.eid.cW(fileSize);
                if (TextUtils.isEmpty(str)) {
                    return aE(-1, n.u("fail no such file or directory ", null, str, null));
                }
                File file2 = new File(wC2);
                if (file2.exists()) {
                    file2.delete();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(wQ);
                cW.result = arrayList;
                cW.errMsg = "ok";
            }
            return cW;
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
    private c cW(String str, String str2) {
        FileOutputStream fileOutputStream;
        File file;
        FileInputStream fileInputStream = null;
        String wC = wC(str);
        ?? wC2 = wC(str2);
        if (TextUtils.isEmpty(wC)) {
            return aE(-1, n.u("fail no such file or directory ", null, str, null));
        }
        if (TextUtils.isEmpty(wC2)) {
            return aE(-1, n.u("fail no such file or directory ", null, str2, null));
        }
        c aE = aE(0, "ok");
        try {
            try {
                file = new File((String) wC2);
                fileInputStream = new FileInputStream(new File(wC));
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
                        aE.errMsg = com.baidu.pass.biometrics.face.liveness.c.a.p;
                        aE.errCode = -1;
                        return aE;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str2);
                    aE.result = arrayList;
                    return aE;
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                    c aE2 = aE(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                    com.baidu.swan.c.d.closeSafely(fileInputStream);
                    com.baidu.swan.c.d.closeSafely(fileOutputStream);
                    if (TextUtils.isEmpty("")) {
                        aE.errMsg = com.baidu.pass.biometrics.face.liveness.c.a.p;
                        aE.errCode = -1;
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(str2);
                        aE.result = arrayList2;
                    }
                    return aE2;
                }
            } catch (IOException e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                wC2 = 0;
                com.baidu.swan.c.d.closeSafely(fileInputStream);
                com.baidu.swan.c.d.closeSafely(wC2);
                if (TextUtils.isEmpty("")) {
                    aE.errMsg = com.baidu.pass.biometrics.face.liveness.c.a.p;
                    aE.errCode = -1;
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(str2);
                    aE.result = arrayList3;
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            wC2 = 0;
            fileInputStream = null;
        }
    }

    public c ao(String str, boolean z) {
        c ag = n.ag(str, z ? "dirPath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (ag == null) {
            String wQ = n.wQ(str);
            if (!n.wJ(wQ)) {
                return aE(-4, "fail permission denied, open " + str);
            }
            String wC = wC(wQ);
            if (TextUtils.isEmpty(wC)) {
                return aE(-1, "fail no such file or directory " + str);
            }
            File file = new File(wC);
            if (!file.exists()) {
                return aE(-1, "fail no such file or directory " + str);
            }
            if (!file.isDirectory()) {
                return aE(-1, "fail no such file or directory " + str);
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
            c aE = aE(0, "ok");
            aE.result = arrayList;
            return aE;
        }
        return ag;
    }

    public c c(String str, boolean z, boolean z2) {
        boolean deleteFile;
        c ag = n.ag(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (ag == null) {
            c wD = wD(str);
            if (wD == null) {
                if (!n.wJ(str)) {
                    return aE(-4, "fail permission denied, open " + str);
                }
                String wC = wC(str);
                if (TextUtils.isEmpty(wC)) {
                    return aE(-1, "fail no such file or directory " + str);
                }
                File file = new File(wC);
                if (!file.exists() || file.isFile()) {
                    return aE(-1, "fail no such file or directory " + str);
                }
                boolean d = d(file.listFiles());
                try {
                    if (!z && d) {
                        return aE(-1, "fail directory not empty ");
                    }
                    if (!z) {
                        deleteFile = file.delete();
                    } else {
                        deleteFile = com.baidu.swan.c.d.deleteFile(file);
                    }
                    if (!deleteFile) {
                        return aE(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                    }
                    return aE(0, "ok");
                } catch (Exception e) {
                    return aE(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                }
            }
            return wD;
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
            String wQ = n.wQ(str);
            if (!this.eic.ag(wQ, true)) {
                return aE(-1, "fail permission denied, open " + str);
            }
            c al = al(wQ, true);
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
            if (!isEmpty && !eia.contains(str2)) {
                return aE(-1, "fail Error: Unknown encoding: " + str2);
            }
            String wC = wC(wQ);
            if (TextUtils.isEmpty(wC)) {
                return aE(-1, "fail no such file or directory " + str);
            }
            File file = new File(wC);
            String str3 = "";
            byte[] bArr2 = new byte[0];
            c aE = aE(0, "ok");
            try {
                if (TextUtils.isEmpty(str2)) {
                    bArr = n.wR(wC);
                } else if ("base64".equals(str2)) {
                    bArr = n.wR(wC);
                    str3 = bArr.length == 0 ? "" : Base64.encodeToString(bArr, 2);
                } else if ("hex".equals(str2)) {
                    str3 = n.wM(wC);
                    bArr = bArr2;
                } else {
                    str3 = a(new FileInputStream(file), str2);
                    bArr = bArr2;
                }
                if (TextUtils.isEmpty(str2)) {
                    aE.ehh = bArr;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str3);
                    aE.result = arrayList;
                }
                return aE;
            } catch (Exception e) {
                e.printStackTrace();
                return aE(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
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
                String wQ = n.wQ(str);
                c wD = wD(wQ);
                if (wD != null) {
                    wD.errMsg = n.u("fail permission denied, ", "rename", str, str2);
                    return wD;
                }
                String wQ2 = n.wQ(str2);
                c wD2 = wD(wQ2);
                if (wD2 != null) {
                    wD2.errMsg = n.u("fail permission denied, ", "rename", str, str2);
                    return wD2;
                }
                c al = al(wQ, false);
                if (al != null) {
                    al.errMsg = n.u("fail no such file or directory ", "rename", str, str2);
                    return al;
                } else if (!n.wI(wQ) || !n.wI(wQ2)) {
                    return aE(-4, n.u("fail permission denied, ", "rename", str, str2));
                } else {
                    c am = am(wQ2, false);
                    if (am != null) {
                        am.errMsg = n.u("fail no such file or directory ", "rename", str, str2);
                        return am;
                    }
                    String wC = wC(wQ);
                    if (TextUtils.isEmpty(wC)) {
                        return aE(-1, "fail no such file or directory " + str);
                    }
                    String wC2 = wC(wQ2);
                    if (TextUtils.isEmpty(wC2)) {
                        return aE(-1, "fail no such file or directory " + str2);
                    }
                    File file = new File(wC);
                    File file2 = new File(wC2);
                    boolean exists = file2.exists();
                    if (!n.h(file, file2) || (file.isDirectory() && !exists && wE(wC2))) {
                        return aE(-1, "fail rename failed");
                    }
                    try {
                        if ((file2.isDirectory() && file2.listFiles() != null && file2.listFiles().length > 0) || !file.renameTo(file2)) {
                            return aE(-1, "fail rename failed");
                        }
                        return aE(0, "ok");
                    } catch (Exception e) {
                        return aE(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
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
                String wQ = n.wQ(str);
                if (!this.eic.ag(wQ, true)) {
                    return aE(-4, n.u("fail no such file or directory ", "copyFile", str, null));
                }
                String wQ2 = n.wQ(str2);
                if (!n.wI(wQ2)) {
                    return aE(-4, n.u("fail permission denied, open ", "copyFile", str2, null));
                }
                c wD = wD(wQ2);
                if (wD == null) {
                    String wC = wC(wQ);
                    if (TextUtils.isEmpty(wC)) {
                        return aE(-1, "fail no such file or directory " + str);
                    }
                    File file = new File(wC);
                    if (!file.exists() || !file.isFile()) {
                        return aE(-1, n.u("fail no such file or directory ", "copyFile", str, null));
                    }
                    c am = am(wQ2, false);
                    if (am != null) {
                        am.errMsg = n.u("fail no such file or directory ", "copyFile", str2, null);
                        return am;
                    } else if (wQ2.endsWith(File.separator)) {
                        return aE(-1, n.u("fail permission denied, ", "copyFile", str, str2));
                    } else {
                        String wC2 = wC(wQ2);
                        if (TextUtils.isEmpty(wC2)) {
                            return aE(-1, "fail no such file or directory " + str2);
                        }
                        File file2 = new File(wC2);
                        if (file2.exists() && file2.isDirectory()) {
                            if (d(file2.listFiles())) {
                                return aE(-1, n.u("fail permission denied, ", "copyFile", str, str2));
                            }
                            try {
                                file2.delete();
                            } catch (Exception e) {
                                return aE(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                            }
                        }
                        long fileSize = n.getFileSize(wC);
                        if (wQ.equals(wQ2) || wQ.startsWith(a.USER_DATA_PATH)) {
                            z2 = false;
                        }
                        if (z2 && this.eid.cX(fileSize)) {
                            return aE(-1, aWq());
                        }
                        c cW = !wQ.equals(wQ2) ? cW(wQ, wQ2) : aE(0, "ok");
                        if (z2 && cW != null && cW.errCode == 0) {
                            this.eid.cW(fileSize);
                            return cW;
                        }
                        return cW;
                    }
                }
                return wD;
            }
            return ag2;
        }
        return ag;
    }

    public c b(String str, Object obj, String str2, boolean z) {
        c ag = n.ag(str, n.u("fail permission denied, open ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of NULL;");
        if (ag == null) {
            String wQ = n.wQ(str);
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return aE(-1, "fail sdcard not mounted ");
            }
            c wD = wD(wQ);
            if (wD == null) {
                if (obj == null) {
                    return aE(-1, "fail TypeError: data argument must be a string, Buffer, ArrayBuffer, Array, or array-like object");
                }
                String wC = wC(wQ);
                if (TextUtils.isEmpty(wC)) {
                    return aE(-1, "fail no such file or directory " + str);
                }
                File file = new File(wC);
                if (!file.exists()) {
                    return aE(-1, n.u("fail no such file or directory ", "open", str, null));
                }
                if (file.isDirectory()) {
                    return aE(-1, "fail illegal operation on a directory, open " + str);
                }
                return a(wQ, obj, str2, true);
            }
            return wD;
        }
        return ag;
    }

    public c ap(String str, boolean z) {
        c ag = n.ag(str, z ? "path must be a string" : n.u("fail no such file or directory ", "access", str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Undefined;");
        if (ag == null) {
            String wQ = n.wQ(str);
            if (!this.eic.ag(wQ, true)) {
                return aE(-4, n.u("fail no such file or directory ", "access", str, null));
            }
            String wC = wC(wQ);
            if (TextUtils.isEmpty(wC)) {
                return aE(-1, "fail no such file or directory " + str);
            }
            if (!new File(wC).exists()) {
                return aE(-1, n.u("fail no such file or directory ", "access", str, null));
            }
            return aE(0, "ok");
        }
        return ag;
    }

    public c aq(String str, boolean z) {
        c ag = n.ag(str, z ? "path must be a string" : n.u("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Object;");
        if (ag == null) {
            if (!this.eic.tf(str) && !this.eic.te(str)) {
                return aE(-1, "fail permission denied, open " + str);
            }
            c al = al(str, false);
            if (al == null) {
                j jVar = new j();
                String wC = wC(str);
                if (TextUtils.isEmpty(wC)) {
                    return aE(-1, n.u("fail no such file or directory ", null, str, null));
                }
                File file = new File(wC);
                jVar.ic(file.isDirectory());
                jVar.id(file.isFile());
                return a(str, jVar);
            }
            return al;
        }
        return ag;
    }

    private c a(String str, j jVar) {
        String wC = wC(str);
        if (TextUtils.isEmpty(wC)) {
            return aE(-1, "fail no such file or directory " + str);
        }
        File file = new File(wC);
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                jVar.lastAccessedTime = Os.lstat(file.getAbsolutePath()).st_atime;
                jVar.lastModifiedTime = Os.lstat(file.getAbsolutePath()).st_mtime;
                jVar.mode = Os.lstat(file.getAbsolutePath()).st_mode;
                jVar.size = Os.lstat(file.getAbsolutePath()).st_size;
            } catch (Exception e) {
                e.printStackTrace();
                return aE(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
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
                return aE(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
            }
        }
        c aE = aE(0, "ok");
        aE.stats = jVar;
        aE.errMsg = "ok";
        return aE;
    }

    public c aWp() {
        String aMf = this.eic.aMf();
        String wC = wC(a.USER_DATA_PATH);
        if (TextUtils.isEmpty(wC)) {
            return aE(-1, "path must be a string");
        }
        ArrayList arrayList = new ArrayList();
        for (String str : n.ar(wC, false)) {
            File file = new File(str);
            d dVar = new d();
            dVar.createTime = file.exists() ? file.lastModified() : 0L;
            String absolutePath = file.getAbsolutePath();
            if (file.exists() && !TextUtils.isEmpty(absolutePath) && !TextUtils.isEmpty(aMf) && absolutePath.startsWith(aMf)) {
                dVar.filePath = this.eic.tw(absolutePath);
            }
            dVar.size = file.exists() ? file.length() : 0L;
            arrayList.add(dVar);
        }
        c aE = aE(0, "ok");
        aE.fileList = arrayList;
        return aE;
    }

    public c wG(String str) {
        c aE;
        c ag = n.ag(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Object;");
        if (ag == null) {
            if (wD(str) != null) {
                return aE(-4, "fail file not exist");
            }
            String wC = wC(str);
            if (TextUtils.isEmpty(wC)) {
                return aE(-1, "fail no such file or directory " + str);
            }
            File file = new File(wC);
            if (!file.exists() || file.isDirectory()) {
                return aE(-1, "fail file not exist");
            }
            long fileSize = n.getFileSize(wC);
            try {
                if (!file.delete()) {
                    aE = aE(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
                } else {
                    this.eid.cW(-fileSize);
                    aE = aE(0, "ok");
                }
                return aE;
            } catch (Exception e) {
                return aE(-1, com.baidu.pass.biometrics.face.liveness.c.a.p);
            }
        }
        return ag;
    }

    public c wH(String str) {
        c ag = n.ag(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Undefined;");
        if (ag == null) {
            String wQ = n.wQ(str);
            if (!this.eic.ag(wQ, true)) {
                return aE(-4, "fail file not exist");
            }
            String wC = wC(wQ);
            if (TextUtils.isEmpty(wC)) {
                return aE(-1, "fail no such file or directory " + str);
            }
            File file = new File(wC);
            if (!file.exists()) {
                return aE(-1, "fail file not exist");
            }
            if (file.isDirectory()) {
                return aE(-1, "fail " + str + " is directory");
            }
            c aE = aE(0, "ok");
            aE.size = file.exists() ? file.length() : 0L;
            aE.digest = file.exists() ? com.baidu.swan.c.e.e(file, false) : null;
            return aE;
        }
        return ag;
    }

    private String aWq() {
        String generateFileSizeText = com.baidu.swan.c.d.generateFileSizeText(this.eid.getMaxSize());
        return String.format("fail file size over %s", (TextUtils.isEmpty(generateFileSizeText) || TextUtils.equals(generateFileSizeText, FileUtils.UNKNOW)) ? "" : "");
    }
}
