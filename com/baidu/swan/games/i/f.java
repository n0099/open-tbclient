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
    private static List<String> dsz = new ArrayList();
    private String dsA;
    private final com.baidu.swan.apps.storage.b.c dsB;
    private final com.baidu.swan.apps.storage.b.d dsC;
    private Context mContext;

    static {
        dsz.add("ascii");
        dsz.add("base64");
        dsz.add("binary");
        dsz.add("hex");
        dsz.add("utf-8");
        dsz.add("utf8");
        dsz.add("latin1");
        dsz.add("ucs2");
        dsz.add("ucs-2");
        dsz.add("utf16le");
        dsz.add("utf-16le");
    }

    public f(Context context, String str, @NonNull com.baidu.swan.apps.storage.b.c cVar) {
        this.mContext = context;
        this.dsA = str;
        this.dsB = cVar;
        this.dsC = this.dsB.aDb();
    }

    private String va(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith("bdfile://code")) {
            this.dsA = this.dsA.endsWith(File.separator) ? this.dsA.substring(0, this.dsA.length() - 1) : this.dsA;
            return this.dsA + str.substring("bdfile://code".length());
        } else if (str.startsWith("bdfile://")) {
            return this.dsB.rU(str);
        } else {
            return "";
        }
    }

    private c vb(String str) {
        c af = af(-1, "fail permission denied, open " + str);
        if (!TextUtils.isEmpty(str) && str.startsWith(a.USER_DATA_PATH)) {
            return null;
        }
        return af;
    }

    private c af(int i, String str) {
        c cVar = new c();
        cVar.errCode = i;
        cVar.errMsg = str;
        return cVar;
    }

    private c af(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            c cVar = new c();
            cVar.errCode = -1;
            cVar.errMsg = "fail no such file or directory " + str;
            return cVar;
        }
        String va = va(str);
        if (TextUtils.isEmpty(str)) {
            c cVar2 = new c();
            cVar2.errCode = -1;
            cVar2.errMsg = "fail no such file or directory " + str;
            return cVar2;
        }
        File file = new File(va);
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

    private c ag(String str, boolean z) {
        if (str.endsWith(File.separator)) {
            str = str.substring(0, str.length() - 1);
        }
        String va = va(str);
        if (TextUtils.isEmpty(va)) {
            return af(-1, "fail no such file or directory " + str);
        }
        if (va.contains(File.separator)) {
            File file = new File(va.substring(0, va.lastIndexOf(File.separator)));
            if (!z && (!file.exists() || (file.exists() && file.isFile()))) {
                return af(-1, "fail no such file or directory " + str);
            }
        }
        return null;
    }

    public c b(String str, boolean z, boolean z2) {
        boolean mkdir;
        c S = n.S(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (S == null) {
            c vb = vb(str);
            if (vb == null) {
                if (!n.vg(str)) {
                    return af(-4, "fail permission denied, open " + str);
                }
                String va = va(str);
                if (TextUtils.isEmpty(va)) {
                    return af(-1, "fail no such file or directory " + str);
                }
                c ag = ag(str, z);
                if (ag == null) {
                    File file = new File(va);
                    if (file.exists()) {
                        return af(-1, "fail file already exists " + str);
                    }
                    try {
                        if (z) {
                            mkdir = file.mkdirs();
                        } else {
                            mkdir = file.mkdir();
                        }
                        if (!mkdir) {
                            return af(-1, "fail");
                        }
                        return af(0, "ok");
                    } catch (Exception e) {
                        return af(-1, "fail");
                    }
                }
                return ag;
            }
            return vb;
        }
        return S;
    }

    public c a(boolean z, String str, Object obj, String str2) {
        c S = n.S(str, z ? "filePath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        return S != null ? S : a(str, obj, str2, false);
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
        c vb = vb(str);
        if (vb != null) {
            return vb;
        }
        if (obj == null) {
            return af(-1, "The argument must be string or arrayBuffer");
        }
        int length = (a.USER_DATA_PATH + File.separator).length();
        if (n.vg(str)) {
            boolean z2 = obj instanceof byte[];
            if (!z2 && TextUtils.isEmpty(str2)) {
                str2 = "utf-8";
            }
            if (!TextUtils.isEmpty(str2)) {
                if ("binary".equals(str2.toLowerCase())) {
                    str2 = "latin1";
                }
                if (!dsz.contains(str2.toLowerCase())) {
                    return af(-1, "fail invalid encoding \"" + str2 + "\"");
                }
            }
            BufferedWriter bufferedWriter3 = null;
            Closeable closeable = null;
            c ag = ag(str, false);
            if (ag == null) {
                String va = va(str);
                if (TextUtils.isEmpty(va)) {
                    return af(-1, "fail no such file or directory " + str.substring(length));
                }
                long j = 0;
                if (!z2 && !TextUtils.isEmpty((String) obj)) {
                    j = ((String) obj).getBytes().length;
                } else if (z2) {
                    j = ((byte[]) obj).length;
                }
                if (this.dsB.aDb().bK(j)) {
                    return af(-1, aNp());
                }
                File file = new File(va);
                if (file.exists() && file.isDirectory()) {
                    return af(-1, " fail illegal operation on a directory, open " + str);
                }
                long length2 = file.length();
                c af = af(0, "ok");
                try {
                    if (z2) {
                        byte[] bArr = (byte[]) obj;
                        FileOutputStream fileOutputStream2 = new FileOutputStream(va, z);
                        try {
                            fileOutputStream2.write(bArr);
                            fileOutputStream2.flush();
                            bufferedWriter2 = null;
                            r2 = fileOutputStream2;
                        } catch (Exception e) {
                            fileOutputStream = fileOutputStream2;
                            bufferedWriter = null;
                            c af2 = af(-1, "fail");
                            com.baidu.swan.c.d.closeSafely(bufferedWriter);
                            com.baidu.swan.c.d.closeSafely(fileOutputStream);
                            return af2;
                        } catch (Throwable th) {
                            closeable = fileOutputStream2;
                            th = th;
                            com.baidu.swan.c.d.closeSafely(bufferedWriter3);
                            com.baidu.swan.c.d.closeSafely(closeable);
                            throw th;
                        }
                    } else if (TextUtils.isEmpty((String) obj) || !TextUtils.equals("base64", str2)) {
                        String[] cP = n.cP((String) obj, str2);
                        if (cP == null || cP.length != 2) {
                            str3 = "utf-8";
                            str4 = "";
                        } else {
                            String str5 = cP[0];
                            str3 = cP[1];
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
                                c af22 = af(-1, "fail");
                                com.baidu.swan.c.d.closeSafely(bufferedWriter);
                                com.baidu.swan.c.d.closeSafely(fileOutputStream);
                                return af22;
                            } catch (Throwable th2) {
                                th = th2;
                                closeable = fileOutputStream;
                                bufferedWriter3 = bufferedWriter;
                                com.baidu.swan.c.d.closeSafely(bufferedWriter3);
                                com.baidu.swan.c.d.closeSafely(closeable);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedWriter3 = bufferedWriter4;
                            com.baidu.swan.c.d.closeSafely(bufferedWriter3);
                            com.baidu.swan.c.d.closeSafely(closeable);
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
                            c af222 = af(-1, "fail");
                            com.baidu.swan.c.d.closeSafely(bufferedWriter);
                            com.baidu.swan.c.d.closeSafely(fileOutputStream);
                            return af222;
                        } catch (Throwable th4) {
                            closeable = fileOutputStream3;
                            th = th4;
                            com.baidu.swan.c.d.closeSafely(bufferedWriter3);
                            com.baidu.swan.c.d.closeSafely(closeable);
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
                        this.dsC.bJ(j);
                    } else {
                        this.dsC.bJ(j - length2);
                    }
                    com.baidu.swan.c.d.closeSafely(bufferedWriter2);
                    com.baidu.swan.c.d.closeSafely(r2);
                    r2 = af;
                    return r2;
                } catch (Exception e5) {
                    fileOutputStream = r2;
                    bufferedWriter = bufferedWriter2;
                    c af2222 = af(-1, "fail");
                    com.baidu.swan.c.d.closeSafely(bufferedWriter);
                    com.baidu.swan.c.d.closeSafely(fileOutputStream);
                    return af2222;
                } catch (Throwable th6) {
                    bufferedWriter3 = bufferedWriter2;
                    closeable = r2;
                    th = th6;
                    com.baidu.swan.c.d.closeSafely(bufferedWriter3);
                    com.baidu.swan.c.d.closeSafely(closeable);
                    throw th;
                }
            }
            return ag;
        }
        return af(-4, "fail permission denied, open " + str.substring(length));
    }

    public c ah(String str, boolean z) {
        c af;
        c S = n.S(str, z ? "filePath must be a string" : n.t("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of Object;");
        if (S == null) {
            if (!n.vh(str)) {
                return af(-4, n.t("fail permission denied, open ", null, str, null));
            }
            c af2 = af(str, false);
            if (af2 == null) {
                c vb = vb(str);
                if (vb == null) {
                    String va = va(str);
                    if (TextUtils.isEmpty(va)) {
                        return af(-1, n.t("fail no such file or directory ", null, str, null));
                    }
                    File file = new File(va);
                    if (file.isDirectory()) {
                        return af(-1, n.t("fail operation not permitted ", "unlink", str, null));
                    }
                    long fileSize = n.getFileSize(va);
                    try {
                        if (file.delete()) {
                            this.dsC.bJ(-fileSize);
                            af = af(0, "ok");
                        } else {
                            af = af(-1, n.t("fail", null, str, null));
                        }
                        return af;
                    } catch (Exception e) {
                        return af(-1, n.t("fail", null, str, null));
                    }
                }
                return vb;
            }
            return af2;
        }
        return S;
    }

    public c cL(String str, String str2) {
        c S = n.S(str, n.b("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true), "fail parameter error: parameter.zipFilePath should be String instead of Object;");
        if (S == null) {
            c S2 = n.S(str2, n.b("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true), "fail parameter error: parameter.targetPath should be String instead of Object;");
            if (S2 == null) {
                if (!str2.startsWith("bdfile://tmp") && !str2.startsWith(a.USER_DATA_PATH)) {
                    return af(-1, "fail permission denied, open " + str2);
                }
                String vo = n.vo(str);
                if (!this.dsB.aa(vo, true)) {
                    return af(-4, n.b("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (!n.vg(str2)) {
                    return af(-4, n.b("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (vc(str2)) {
                    return af(-1, n.b("fail permission denied, ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                String va = va(vo);
                String va2 = va(str2);
                if (TextUtils.isEmpty(va)) {
                    return af(-1, n.b("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (TextUtils.isEmpty(va2)) {
                    return af(-1, n.b("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                File file = new File(va);
                if (!file.exists()) {
                    return af(-1, n.b("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (!va.endsWith(".zip")) {
                    return af(-1, "fail unzip failed");
                }
                if (!file.isFile()) {
                    return af(-1, n.b("fail permission denied, ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                File file2 = new File(va2);
                if (!file2.exists()) {
                    file2.mkdirs();
                } else if (file2.isFile()) {
                    return af(-1, "fail unzip failed");
                }
                List<String> al = n.al(va2, true);
                if (!com.baidu.swan.c.d.unzipFile(va, va2)) {
                    return af(-1, "fail unzip failed");
                }
                if (str2.startsWith(a.USER_DATA_PATH)) {
                    List<String> al2 = n.al(va2, true);
                    ArrayList arrayList = new ArrayList(al2.size());
                    long j = 0;
                    for (String str3 : al2) {
                        if (!al.contains(str3)) {
                            arrayList.add(str3);
                            j = n.getFileSize(str3) + j;
                        }
                    }
                    if (this.dsC.bK(j)) {
                        n.av(arrayList);
                        return af(-1, aNp());
                    }
                    this.dsC.bJ(j);
                }
                return af(0, "ok");
            }
            return S2;
        }
        return S;
    }

    private boolean vc(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains(File.separator)) {
            return vd(str.substring(str.lastIndexOf(File.separator) + 1));
        }
        return vd(str);
    }

    private boolean vd(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(".")) {
            return false;
        }
        String[] split = str.split("\\.");
        return (split.length != 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) ? false : true;
    }

    public c q(String str, String str2, boolean z) {
        c S = n.S(str, z ? "tempFilePath must be a string" : "fail tempFilePath file not exist", z ? " The argument must be string" : "fail parameter error: parameter.tempFilePath should be String instead of Object;");
        if (S == null) {
            String vo = n.vo(str2);
            if (TextUtils.isEmpty(vo)) {
                vo = a.USER_DATA_PATH + File.separator + com.baidu.swan.c.d.getFileNameFromPath(str);
            }
            if (!vo.startsWith(a.USER_DATA_PATH)) {
                return af(-1, n.t("fail permission denied, open ", null, str2, null));
            }
            if (!this.dsB.rE(str)) {
                return af(-4, "fail it is not a tempFilePath");
            }
            c ag = ag(vo, false);
            if (ag != null) {
                return ag;
            }
            c ag2 = ag(str, false);
            if (ag2 != null) {
                return ag2;
            }
            String va = va(vo);
            if (TextUtils.isEmpty(va)) {
                return af(-1, "fail no such file or directory " + str2);
            }
            File file = new File(va);
            if (a.USER_DATA_PATH.equals(vo) || (file.exists() && file.isDirectory())) {
                return af(-1, n.t("fail Error: EISDIR: illegal operation on a directory, open ", null, str2, null));
            }
            c af = af(str, true);
            if (af != null) {
                af.errMsg = "fail no such file or directory ";
                return af;
            }
            String va2 = va(str);
            if (TextUtils.isEmpty(va2)) {
                return af(-1, "fail no such file or directory " + str);
            }
            long fileSize = n.getFileSize(va2);
            if (this.dsC.bK(fileSize)) {
                return af(-1, aNp());
            }
            if (!vo.startsWith(a.USER_DATA_PATH) || n.vi(vo)) {
                return af(-1, n.t("fail permission denied, open ", null, str2, null));
            }
            c ag3 = ag(vo, false);
            if (ag3 != null) {
                return ag3;
            }
            c vb = vb(vo);
            if (vb != null) {
                return vb;
            }
            c cM = cM(str, vo);
            if (cM != null && cM.errCode == 0) {
                this.dsC.bJ(fileSize);
                if (TextUtils.isEmpty(str)) {
                    return af(-1, n.t("fail no such file or directory ", null, str, null));
                }
                File file2 = new File(va2);
                if (file2.exists()) {
                    file2.delete();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(vo);
                cM.result = arrayList;
                cM.errMsg = "ok";
            }
            return cM;
        }
        return S;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [813=4] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v11, resolved type: java.io.FileOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private c cM(String str, String str2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream3 = null;
        String va = va(str);
        String va2 = va(str2);
        if (TextUtils.isEmpty(va)) {
            return af(-1, n.t("fail no such file or directory ", null, str, null));
        }
        if (TextUtils.isEmpty(va2)) {
            return af(-1, n.t("fail no such file or directory ", null, str2, null));
        }
        c af = af(0, "ok");
        try {
            File file = new File(va2);
            fileInputStream = new FileInputStream(new File(va));
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
            com.baidu.swan.c.d.closeSafely(fileInputStream);
            com.baidu.swan.c.d.closeSafely(fileOutputStream);
            if (TextUtils.isEmpty(str2)) {
                af.errMsg = "fail";
                af.errCode = -1;
                return af;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            af.result = arrayList;
            return af;
        } catch (IOException e3) {
            e = e3;
            fileInputStream3 = fileInputStream;
            fileInputStream2 = fileOutputStream;
            try {
                e.printStackTrace();
                c af2 = af(-1, "fail");
                com.baidu.swan.c.d.closeSafely(fileInputStream3);
                com.baidu.swan.c.d.closeSafely(fileInputStream2);
                if (TextUtils.isEmpty("")) {
                    af.errMsg = "fail";
                    af.errCode = -1;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(str2);
                    af.result = arrayList2;
                }
                return af2;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream3;
                fileInputStream3 = fileInputStream2;
                com.baidu.swan.c.d.closeSafely(fileInputStream);
                com.baidu.swan.c.d.closeSafely(fileInputStream3);
                if (TextUtils.isEmpty("")) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(str2);
                    af.result = arrayList3;
                } else {
                    af.errMsg = "fail";
                    af.errCode = -1;
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream3 = fileOutputStream;
            com.baidu.swan.c.d.closeSafely(fileInputStream);
            com.baidu.swan.c.d.closeSafely(fileInputStream3);
            if (TextUtils.isEmpty("")) {
            }
            throw th;
        }
    }

    public c ai(String str, boolean z) {
        c S = n.S(str, z ? "dirPath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (S == null) {
            String vo = n.vo(str);
            if (!n.vh(vo)) {
                return af(-4, "fail permission denied, open " + str);
            }
            String va = va(vo);
            if (TextUtils.isEmpty(va)) {
                return af(-1, "fail no such file or directory " + str);
            }
            File file = new File(va);
            if (!file.exists()) {
                return af(-1, "fail no such file or directory " + str);
            }
            if (!file.isDirectory()) {
                return af(-1, "fail no such file or directory " + str);
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
            c af = af(0, "ok");
            af.result = arrayList;
            return af;
        }
        return S;
    }

    public c c(String str, boolean z, boolean z2) {
        boolean deleteFile;
        c S = n.S(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (S == null) {
            c vb = vb(str);
            if (vb == null) {
                if (!n.vh(str)) {
                    return af(-4, "fail permission denied, open " + str);
                }
                String va = va(str);
                if (TextUtils.isEmpty(va)) {
                    return af(-1, "fail no such file or directory " + str);
                }
                File file = new File(va);
                if (!file.exists() || file.isFile()) {
                    return af(-1, "fail no such file or directory " + str);
                }
                boolean d = d(file.listFiles());
                try {
                    if (!z && d) {
                        return af(-1, "fail directory not empty ");
                    }
                    if (!z) {
                        deleteFile = file.delete();
                    } else {
                        deleteFile = com.baidu.swan.c.d.deleteFile(file);
                    }
                    if (!deleteFile) {
                        return af(-1, "fail");
                    }
                    return af(0, "ok");
                } catch (Exception e) {
                    return af(-1, "fail");
                }
            }
            return vb;
        }
        return S;
    }

    private boolean d(File[] fileArr) {
        return (fileArr == null || fileArr.length == 0) ? false : true;
    }

    public c r(String str, String str2, boolean z) {
        c S = n.S(str, z ? "filePath must be a string" : "fail file not found", z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of NULL;");
        if (S == null) {
            String vo = n.vo(str);
            if (!this.dsB.aa(vo, true)) {
                return af(-1, "fail permission denied, open " + str);
            }
            c af = af(vo, true);
            if (af != null) {
                af.errMsg = n.t("fail no such file or directory ", "open", str, null);
                return af;
            }
            boolean isEmpty = TextUtils.isEmpty(str2);
            if (!isEmpty) {
                str2 = str2.toLowerCase();
                if ("binary".equals(str2)) {
                    str2 = "latin1";
                }
            }
            if (!isEmpty && !dsz.contains(str2)) {
                return af(-1, "fail Error: Unknown encoding: " + str2);
            }
            String va = va(vo);
            if (TextUtils.isEmpty(va)) {
                return af(-1, "fail no such file or directory " + str);
            }
            File file = new File(va);
            String str3 = "";
            byte[] bArr = new byte[0];
            c af2 = af(0, "ok");
            try {
                if (TextUtils.isEmpty(str2)) {
                    bArr = n.vp(va);
                } else if ("base64".equals(str2)) {
                    byte[] vp = n.vp(va);
                    str3 = vp.length == 0 ? "" : Base64.encodeToString(vp, 2);
                    bArr = vp;
                } else if ("hex".equals(str2)) {
                    str3 = n.vk(va);
                } else {
                    str3 = a(new FileInputStream(file), str2);
                }
                if (TextUtils.isEmpty(str2)) {
                    af2.drF = bArr;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str3);
                    af2.result = arrayList;
                }
                return af2;
            } catch (Exception e) {
                e.printStackTrace();
                return af(-1, "fail");
            }
        }
        return S;
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

    public c s(String str, String str2, boolean z) {
        c S = n.S(str, z ? "oldPath must be a string" : n.t("fail no such file or directory ", "rename", str, null), z ? " The argument must be string" : "fail parameter error: parameter.oldPath should be String instead of Undefined;");
        if (S == null) {
            c S2 = n.S(str2, z ? "newPath must be a string" : n.t("fail no such file or directory ", "rename", str2, null), z ? " The argument must be string" : "fail parameter error: parameter.newPath should be String instead of Undefined;");
            if (S2 == null) {
                String vo = n.vo(str);
                c vb = vb(vo);
                if (vb != null) {
                    vb.errMsg = n.t("fail permission denied, ", "rename", str, str2);
                    return vb;
                }
                String vo2 = n.vo(str2);
                c vb2 = vb(vo2);
                if (vb2 != null) {
                    vb2.errMsg = n.t("fail permission denied, ", "rename", str, str2);
                    return vb2;
                }
                c af = af(vo, false);
                if (af != null) {
                    af.errMsg = n.t("fail no such file or directory ", "rename", str, str2);
                    return af;
                } else if (!n.vg(vo) || !n.vg(vo2)) {
                    return af(-4, n.t("fail permission denied, ", "rename", str, str2));
                } else {
                    c ag = ag(vo2, false);
                    if (ag != null) {
                        ag.errMsg = n.t("fail no such file or directory ", "rename", str, str2);
                        return ag;
                    }
                    String va = va(vo);
                    if (TextUtils.isEmpty(va)) {
                        return af(-1, "fail no such file or directory " + str);
                    }
                    String va2 = va(vo2);
                    if (TextUtils.isEmpty(va2)) {
                        return af(-1, "fail no such file or directory " + str2);
                    }
                    File file = new File(va);
                    File file2 = new File(va2);
                    boolean exists = file2.exists();
                    if (!n.j(file, file2) || (file.isDirectory() && !exists && vc(va2))) {
                        return af(-1, "fail rename failed");
                    }
                    try {
                        if ((file2.isDirectory() && file2.listFiles() != null && file2.listFiles().length > 0) || !file.renameTo(file2)) {
                            return af(-1, "fail rename failed");
                        }
                        return af(0, "ok");
                    } catch (Exception e) {
                        return af(-1, "fail");
                    }
                }
            }
            return S2;
        }
        return S;
    }

    public c t(String str, String str2, boolean z) {
        boolean z2 = true;
        c S = n.S(str, "srcPath must be a string", " The argument must be string");
        if (S == null) {
            c S2 = n.S(str2, "destPath must be a string", " The argument must be string");
            if (S2 == null) {
                String vo = n.vo(str);
                if (!this.dsB.aa(vo, true)) {
                    return af(-4, n.t("fail no such file or directory ", "copyFile", str, null));
                }
                String vo2 = n.vo(str2);
                if (!n.vg(vo2)) {
                    return af(-4, n.t("fail permission denied, open ", "copyFile", str2, null));
                }
                c vb = vb(vo2);
                if (vb == null) {
                    String va = va(vo);
                    if (TextUtils.isEmpty(va)) {
                        return af(-1, "fail no such file or directory " + str);
                    }
                    File file = new File(va);
                    if (!file.exists() || !file.isFile()) {
                        return af(-1, n.t("fail no such file or directory ", "copyFile", str, null));
                    }
                    c ag = ag(vo2, false);
                    if (ag != null) {
                        ag.errMsg = n.t("fail no such file or directory ", "copyFile", str2, null);
                        return ag;
                    } else if (vo2.endsWith(File.separator)) {
                        return af(-1, n.t("fail permission denied, ", "copyFile", str, str2));
                    } else {
                        String va2 = va(vo2);
                        if (TextUtils.isEmpty(va2)) {
                            return af(-1, "fail no such file or directory " + str2);
                        }
                        File file2 = new File(va2);
                        if (file2.exists() && file2.isDirectory()) {
                            if (d(file2.listFiles())) {
                                return af(-1, n.t("fail permission denied, ", "copyFile", str, str2));
                            }
                            try {
                                file2.delete();
                            } catch (Exception e) {
                                return af(-1, "fail");
                            }
                        }
                        long fileSize = n.getFileSize(va);
                        if (vo.equals(vo2) || vo.startsWith(a.USER_DATA_PATH)) {
                            z2 = false;
                        }
                        if (z2 && this.dsC.bK(fileSize)) {
                            return af(-1, aNp());
                        }
                        c cM = !vo.equals(vo2) ? cM(vo, vo2) : af(0, "ok");
                        if (z2 && cM != null && cM.errCode == 0) {
                            this.dsC.bJ(fileSize);
                            return cM;
                        }
                        return cM;
                    }
                }
                return vb;
            }
            return S2;
        }
        return S;
    }

    public c b(String str, Object obj, String str2, boolean z) {
        c S = n.S(str, n.t("fail permission denied, open ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of NULL;");
        if (S == null) {
            String vo = n.vo(str);
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return af(-1, "fail sdcard not mounted ");
            }
            c vb = vb(vo);
            if (vb == null) {
                if (obj == null) {
                    return af(-1, "fail TypeError: data argument must be a string, Buffer, ArrayBuffer, Array, or array-like object");
                }
                String va = va(vo);
                if (TextUtils.isEmpty(va)) {
                    return af(-1, "fail no such file or directory " + str);
                }
                File file = new File(va);
                if (!file.exists()) {
                    return af(-1, n.t("fail no such file or directory ", "open", str, null));
                }
                if (file.isDirectory()) {
                    return af(-1, "fail illegal operation on a directory, open " + str);
                }
                return a(vo, obj, str2, true);
            }
            return vb;
        }
        return S;
    }

    public c aj(String str, boolean z) {
        c S = n.S(str, z ? "path must be a string" : n.t("fail no such file or directory ", LogConfig.KEY_ACCESS, str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Undefined;");
        if (S == null) {
            String vo = n.vo(str);
            if (!this.dsB.aa(vo, true)) {
                return af(-4, n.t("fail no such file or directory ", LogConfig.KEY_ACCESS, str, null));
            }
            String va = va(vo);
            if (TextUtils.isEmpty(va)) {
                return af(-1, "fail no such file or directory " + str);
            }
            if (!new File(va).exists()) {
                return af(-1, n.t("fail no such file or directory ", LogConfig.KEY_ACCESS, str, null));
            }
            return af(0, "ok");
        }
        return S;
    }

    public c ak(String str, boolean z) {
        c S = n.S(str, z ? "path must be a string" : n.t("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Object;");
        if (S == null) {
            if (!this.dsB.rE(str) && !this.dsB.rD(str)) {
                return af(-1, "fail permission denied, open " + str);
            }
            c af = af(str, false);
            if (af == null) {
                j jVar = new j();
                String va = va(str);
                if (TextUtils.isEmpty(va)) {
                    return af(-1, n.t("fail no such file or directory ", null, str, null));
                }
                File file = new File(va);
                jVar.gE(file.isDirectory());
                jVar.gF(file.isFile());
                return a(str, jVar);
            }
            return af;
        }
        return S;
    }

    private c a(String str, j jVar) {
        String va = va(str);
        if (TextUtils.isEmpty(va)) {
            return af(-1, "fail no such file or directory " + str);
        }
        File file = new File(va);
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                jVar.lastAccessedTime = Os.lstat(file.getAbsolutePath()).st_atime;
                jVar.lastModifiedTime = Os.lstat(file.getAbsolutePath()).st_mtime;
                jVar.mode = Os.lstat(file.getAbsolutePath()).st_mode;
                jVar.size = Os.lstat(file.getAbsolutePath()).st_size;
            } catch (Exception e) {
                e.printStackTrace();
                return af(-1, "fail");
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
                return af(-1, "fail");
            }
        }
        c af = af(0, "ok");
        af.stats = jVar;
        af.errMsg = "ok";
        return af;
    }

    public c aNo() {
        String aDa = this.dsB.aDa();
        String va = va(a.USER_DATA_PATH);
        if (TextUtils.isEmpty(va)) {
            return af(-1, "path must be a string");
        }
        ArrayList arrayList = new ArrayList();
        for (String str : n.al(va, false)) {
            File file = new File(str);
            d dVar = new d();
            dVar.createTime = file.exists() ? file.lastModified() : 0L;
            String absolutePath = file.getAbsolutePath();
            if (file.exists() && !TextUtils.isEmpty(absolutePath) && !TextUtils.isEmpty(aDa) && absolutePath.startsWith(aDa)) {
                dVar.filePath = this.dsB.rV(absolutePath);
            }
            dVar.size = file.exists() ? file.length() : 0L;
            arrayList.add(dVar);
        }
        c af = af(0, "ok");
        af.fileList = arrayList;
        return af;
    }

    public c ve(String str) {
        c af;
        c S = n.S(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Object;");
        if (S == null) {
            if (vb(str) != null) {
                return af(-4, "fail file not exist");
            }
            String va = va(str);
            if (TextUtils.isEmpty(va)) {
                return af(-1, "fail no such file or directory " + str);
            }
            File file = new File(va);
            if (!file.exists() || file.isDirectory()) {
                return af(-1, "fail file not exist");
            }
            long fileSize = n.getFileSize(va);
            try {
                if (!file.delete()) {
                    af = af(-1, "fail");
                } else {
                    this.dsC.bJ(-fileSize);
                    af = af(0, "ok");
                }
                return af;
            } catch (Exception e) {
                return af(-1, "fail");
            }
        }
        return S;
    }

    public c vf(String str) {
        c S = n.S(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Undefined;");
        if (S == null) {
            String vo = n.vo(str);
            if (!this.dsB.aa(vo, true)) {
                return af(-4, "fail file not exist");
            }
            String va = va(vo);
            if (TextUtils.isEmpty(va)) {
                return af(-1, "fail no such file or directory " + str);
            }
            File file = new File(va);
            if (!file.exists()) {
                return af(-1, "fail file not exist");
            }
            if (file.isDirectory()) {
                return af(-1, "fail " + str + " is directory");
            }
            c af = af(0, "ok");
            af.size = file.exists() ? file.length() : 0L;
            af.digest = file.exists() ? com.baidu.swan.c.e.toMd5(file, false) : null;
            return af;
        }
        return S;
    }

    private String aNp() {
        String generateFileSizeText = com.baidu.swan.c.d.generateFileSizeText(this.dsC.getMaxSize());
        return String.format("fail file size over %s", (TextUtils.isEmpty(generateFileSizeText) || TextUtils.equals(generateFileSizeText, FileUtils.UNKNOW)) ? "" : "");
    }
}
