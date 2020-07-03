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
    private static List<String> dcC = new ArrayList();
    private String dcD;
    private final com.baidu.swan.apps.storage.b.c dcE;
    private final com.baidu.swan.apps.storage.b.d dcF;
    private Context mContext;

    static {
        dcC.add("ascii");
        dcC.add("base64");
        dcC.add("binary");
        dcC.add("hex");
        dcC.add("utf-8");
        dcC.add("utf8");
        dcC.add("latin1");
        dcC.add("ucs2");
        dcC.add("ucs-2");
        dcC.add("utf16le");
        dcC.add("utf-16le");
    }

    public f(Context context, String str, @NonNull com.baidu.swan.apps.storage.b.c cVar) {
        this.mContext = context;
        this.dcD = str;
        this.dcE = cVar;
        this.dcF = this.dcE.asR();
    }

    private String rJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith("bdfile://code")) {
            this.dcD = this.dcD.endsWith(File.separator) ? this.dcD.substring(0, this.dcD.length() - 1) : this.dcD;
            return this.dcD + str.substring("bdfile://code".length());
        } else if (str.startsWith("bdfile://")) {
            return this.dcE.pi(str);
        } else {
            return "";
        }
    }

    private c rK(String str) {
        c ag = ag(-1, "fail permission denied, open " + str);
        if (!TextUtils.isEmpty(str) && str.startsWith(a.USER_DATA_PATH)) {
            return null;
        }
        return ag;
    }

    private c ag(int i, String str) {
        c cVar = new c();
        cVar.errCode = i;
        cVar.errMsg = str;
        return cVar;
    }

    private c ab(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            c cVar = new c();
            cVar.errCode = -1;
            cVar.errMsg = "fail no such file or directory " + str;
            return cVar;
        }
        String rJ = rJ(str);
        if (TextUtils.isEmpty(str)) {
            c cVar2 = new c();
            cVar2.errCode = -1;
            cVar2.errMsg = "fail no such file or directory " + str;
            return cVar2;
        }
        File file = new File(rJ);
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

    private c ac(String str, boolean z) {
        if (str.endsWith(File.separator)) {
            str = str.substring(0, str.length() - 1);
        }
        String rJ = rJ(str);
        if (TextUtils.isEmpty(rJ)) {
            return ag(-1, "fail no such file or directory " + str);
        }
        if (rJ.contains(File.separator)) {
            File file = new File(rJ.substring(0, rJ.lastIndexOf(File.separator)));
            if (!z && (!file.exists() || (file.exists() && file.isFile()))) {
                return ag(-1, "fail no such file or directory " + str);
            }
        }
        return null;
    }

    public c b(String str, boolean z, boolean z2) {
        boolean mkdir;
        c P = n.P(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (P == null) {
            c rK = rK(str);
            if (rK == null) {
                if (!n.rP(str)) {
                    return ag(-4, "fail permission denied, open " + str);
                }
                String rJ = rJ(str);
                if (TextUtils.isEmpty(rJ)) {
                    return ag(-1, "fail no such file or directory " + str);
                }
                c ac = ac(str, z);
                if (ac == null) {
                    File file = new File(rJ);
                    if (file.exists()) {
                        return ag(-1, "fail file already exists " + str);
                    }
                    try {
                        if (z) {
                            mkdir = file.mkdirs();
                        } else {
                            mkdir = file.mkdir();
                        }
                        if (!mkdir) {
                            return ag(-1, "fail");
                        }
                        return ag(0, "ok");
                    } catch (Exception e) {
                        return ag(-1, "fail");
                    }
                }
                return ac;
            }
            return rK;
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
        c rK = rK(str);
        if (rK != null) {
            return rK;
        }
        if (obj == null) {
            return ag(-1, "The argument must be string or arrayBuffer");
        }
        int length = (a.USER_DATA_PATH + File.separator).length();
        if (n.rP(str)) {
            boolean z2 = obj instanceof byte[];
            if (!z2 && TextUtils.isEmpty(str2)) {
                str2 = "utf-8";
            }
            if (!TextUtils.isEmpty(str2)) {
                if ("binary".equals(str2.toLowerCase())) {
                    str2 = "latin1";
                }
                if (!dcC.contains(str2.toLowerCase())) {
                    return ag(-1, "fail invalid encoding \"" + str2 + "\"");
                }
            }
            BufferedWriter bufferedWriter3 = null;
            Closeable closeable = null;
            c ac = ac(str, false);
            if (ac == null) {
                String rJ = rJ(str);
                if (TextUtils.isEmpty(rJ)) {
                    return ag(-1, "fail no such file or directory " + str.substring(length));
                }
                long j = 0;
                if (!z2 && !TextUtils.isEmpty((String) obj)) {
                    j = ((String) obj).getBytes().length;
                } else if (z2) {
                    j = ((byte[]) obj).length;
                }
                if (this.dcE.asR().bs(j)) {
                    return ag(-1, aAV());
                }
                File file = new File(rJ);
                if (file.exists() && file.isDirectory()) {
                    return ag(-1, " fail illegal operation on a directory, open " + str);
                }
                long length2 = file.length();
                c ag = ag(0, "ok");
                try {
                    if (z2) {
                        byte[] bArr = (byte[]) obj;
                        FileOutputStream fileOutputStream2 = new FileOutputStream(rJ, z);
                        try {
                            fileOutputStream2.write(bArr);
                            fileOutputStream2.flush();
                            bufferedWriter2 = null;
                            r2 = fileOutputStream2;
                        } catch (Exception e) {
                            fileOutputStream = fileOutputStream2;
                            bufferedWriter = null;
                            c ag2 = ag(-1, "fail");
                            com.baidu.swan.e.d.closeSafely(bufferedWriter);
                            com.baidu.swan.e.d.closeSafely(fileOutputStream);
                            return ag2;
                        } catch (Throwable th) {
                            closeable = fileOutputStream2;
                            th = th;
                            com.baidu.swan.e.d.closeSafely(bufferedWriter3);
                            com.baidu.swan.e.d.closeSafely(closeable);
                            throw th;
                        }
                    } else if (TextUtils.isEmpty((String) obj) || !TextUtils.equals("base64", str2)) {
                        String[] cs = n.cs((String) obj, str2);
                        if (cs == null || cs.length != 2) {
                            str3 = "utf-8";
                            str4 = "";
                        } else {
                            String str5 = cs[0];
                            str3 = cs[1];
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
                                c ag22 = ag(-1, "fail");
                                com.baidu.swan.e.d.closeSafely(bufferedWriter);
                                com.baidu.swan.e.d.closeSafely(fileOutputStream);
                                return ag22;
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
                            c ag222 = ag(-1, "fail");
                            com.baidu.swan.e.d.closeSafely(bufferedWriter);
                            com.baidu.swan.e.d.closeSafely(fileOutputStream);
                            return ag222;
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
                        this.dcF.br(j);
                    } else {
                        this.dcF.br(j - length2);
                    }
                    com.baidu.swan.e.d.closeSafely(bufferedWriter2);
                    com.baidu.swan.e.d.closeSafely(r2);
                    r2 = ag;
                    return r2;
                } catch (Exception e5) {
                    fileOutputStream = r2;
                    bufferedWriter = bufferedWriter2;
                    c ag2222 = ag(-1, "fail");
                    com.baidu.swan.e.d.closeSafely(bufferedWriter);
                    com.baidu.swan.e.d.closeSafely(fileOutputStream);
                    return ag2222;
                } catch (Throwable th6) {
                    bufferedWriter3 = bufferedWriter2;
                    closeable = r2;
                    th = th6;
                    com.baidu.swan.e.d.closeSafely(bufferedWriter3);
                    com.baidu.swan.e.d.closeSafely(closeable);
                    throw th;
                }
            }
            return ac;
        }
        return ag(-4, "fail permission denied, open " + str.substring(length));
    }

    public c ad(String str, boolean z) {
        c ag;
        c P = n.P(str, z ? "filePath must be a string" : n.t("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of Object;");
        if (P == null) {
            if (!n.rQ(str)) {
                return ag(-4, n.t("fail permission denied, open ", null, str, null));
            }
            c ab = ab(str, false);
            if (ab == null) {
                c rK = rK(str);
                if (rK == null) {
                    String rJ = rJ(str);
                    if (TextUtils.isEmpty(rJ)) {
                        return ag(-1, n.t("fail no such file or directory ", null, str, null));
                    }
                    File file = new File(rJ);
                    if (file.isDirectory()) {
                        return ag(-1, n.t("fail operation not permitted ", "unlink", str, null));
                    }
                    long fileSize = n.getFileSize(rJ);
                    try {
                        if (file.delete()) {
                            this.dcF.br(-fileSize);
                            ag = ag(0, "ok");
                        } else {
                            ag = ag(-1, n.t("fail", null, str, null));
                        }
                        return ag;
                    } catch (Exception e) {
                        return ag(-1, n.t("fail", null, str, null));
                    }
                }
                return rK;
            }
            return ab;
        }
        return P;
    }

    public c co(String str, String str2) {
        c P = n.P(str, n.b("fail no such file or directory ", "unzip", str, str2, true), "fail parameter error: parameter.zipFilePath should be String instead of Object;");
        if (P == null) {
            c P2 = n.P(str2, n.b("fail no such file or directory ", "unzip", str, str2, true), "fail parameter error: parameter.targetPath should be String instead of Object;");
            if (P2 == null) {
                if (!str2.startsWith("bdfile://tmp") && !str2.startsWith(a.USER_DATA_PATH)) {
                    return ag(-1, "fail permission denied, open " + str2);
                }
                String rX = n.rX(str);
                if (!this.dcE.W(rX, true)) {
                    return ag(-4, n.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (!n.rP(str2)) {
                    return ag(-4, n.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (rL(str2)) {
                    return ag(-1, n.b("fail permission denied, ", "unzip", str, str2, true));
                }
                String rJ = rJ(rX);
                String rJ2 = rJ(str2);
                if (TextUtils.isEmpty(rJ)) {
                    return ag(-1, n.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (TextUtils.isEmpty(rJ2)) {
                    return ag(-1, n.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                File file = new File(rJ);
                if (!file.exists()) {
                    return ag(-1, n.b("fail no such file or directory ", "unzip", str, str2, true));
                }
                if (!rJ.endsWith(".zip")) {
                    return ag(-1, "fail unzip failed");
                }
                if (!file.isFile()) {
                    return ag(-1, n.b("fail permission denied, ", "unzip", str, str2, true));
                }
                File file2 = new File(rJ2);
                if (!file2.exists()) {
                    file2.mkdirs();
                } else if (file2.isFile()) {
                    return ag(-1, "fail unzip failed");
                }
                List<String> ah = n.ah(rJ2, true);
                if (!com.baidu.swan.e.d.unzipFile(rJ, rJ2)) {
                    return ag(-1, "fail unzip failed");
                }
                if (str2.startsWith(a.USER_DATA_PATH)) {
                    List<String> ah2 = n.ah(rJ2, true);
                    ArrayList arrayList = new ArrayList(ah2.size());
                    long j = 0;
                    for (String str3 : ah2) {
                        if (!ah.contains(str3)) {
                            arrayList.add(str3);
                            j = n.getFileSize(str3) + j;
                        }
                    }
                    if (this.dcF.bs(j)) {
                        n.aq(arrayList);
                        return ag(-1, aAV());
                    }
                    this.dcF.br(j);
                }
                return ag(0, "ok");
            }
            return P2;
        }
        return P;
    }

    private boolean rL(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains(File.separator)) {
            return rM(str.substring(str.lastIndexOf(File.separator) + 1));
        }
        return rM(str);
    }

    private boolean rM(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(".")) {
            return false;
        }
        String[] split = str.split("\\.");
        return (split.length != 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) ? false : true;
    }

    public c q(String str, String str2, boolean z) {
        c P = n.P(str, z ? "tempFilePath must be a string" : "fail tempFilePath file not exist", z ? " The argument must be string" : "fail parameter error: parameter.tempFilePath should be String instead of Object;");
        if (P == null) {
            String rX = n.rX(str2);
            if (TextUtils.isEmpty(rX)) {
                rX = a.USER_DATA_PATH + File.separator + com.baidu.swan.e.d.getFileNameFromPath(str);
            }
            if (!rX.startsWith(a.USER_DATA_PATH)) {
                return ag(-1, n.t("fail permission denied, open ", null, str2, null));
            }
            if (!this.dcE.oS(str)) {
                return ag(-4, "fail it is not a tempFilePath");
            }
            c ac = ac(rX, false);
            if (ac != null) {
                return ac;
            }
            c ac2 = ac(str, false);
            if (ac2 != null) {
                return ac2;
            }
            String rJ = rJ(rX);
            if (TextUtils.isEmpty(rJ)) {
                return ag(-1, "fail no such file or directory " + str2);
            }
            File file = new File(rJ);
            if (a.USER_DATA_PATH.equals(rX) || (file.exists() && file.isDirectory())) {
                return ag(-1, n.t("fail Error: EISDIR: illegal operation on a directory, open ", null, str2, null));
            }
            c ab = ab(str, true);
            if (ab != null) {
                ab.errMsg = "fail no such file or directory ";
                return ab;
            }
            String rJ2 = rJ(str);
            if (TextUtils.isEmpty(rJ2)) {
                return ag(-1, "fail no such file or directory " + str);
            }
            long fileSize = n.getFileSize(rJ2);
            if (this.dcF.bs(fileSize)) {
                return ag(-1, aAV());
            }
            if (!rX.startsWith(a.USER_DATA_PATH) || n.rR(rX)) {
                return ag(-1, n.t("fail permission denied, open ", null, str2, null));
            }
            c ac3 = ac(rX, false);
            if (ac3 != null) {
                return ac3;
            }
            c rK = rK(rX);
            if (rK != null) {
                return rK;
            }
            c cp = cp(str, rX);
            if (cp != null && cp.errCode == 0) {
                this.dcF.br(fileSize);
                if (TextUtils.isEmpty(str)) {
                    return ag(-1, n.t("fail no such file or directory ", null, str, null));
                }
                File file2 = new File(rJ2);
                if (file2.exists()) {
                    file2.delete();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(rX);
                cp.result = arrayList;
                cp.errMsg = "ok";
            }
            return cp;
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
    private c cp(String str, String str2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream3 = null;
        String rJ = rJ(str);
        String rJ2 = rJ(str2);
        if (TextUtils.isEmpty(rJ)) {
            return ag(-1, n.t("fail no such file or directory ", null, str, null));
        }
        if (TextUtils.isEmpty(rJ2)) {
            return ag(-1, n.t("fail no such file or directory ", null, str2, null));
        }
        c ag = ag(0, "ok");
        try {
            File file = new File(rJ2);
            fileInputStream = new FileInputStream(new File(rJ));
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
                ag.errMsg = "fail";
                ag.errCode = -1;
                return ag;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            ag.result = arrayList;
            return ag;
        } catch (IOException e3) {
            e = e3;
            fileInputStream3 = fileInputStream;
            fileInputStream2 = fileOutputStream;
            try {
                e.printStackTrace();
                c ag2 = ag(-1, "fail");
                com.baidu.swan.e.d.closeSafely(fileInputStream3);
                com.baidu.swan.e.d.closeSafely(fileInputStream2);
                if (TextUtils.isEmpty("")) {
                    ag.errMsg = "fail";
                    ag.errCode = -1;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(str2);
                    ag.result = arrayList2;
                }
                return ag2;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream3;
                fileInputStream3 = fileInputStream2;
                com.baidu.swan.e.d.closeSafely(fileInputStream);
                com.baidu.swan.e.d.closeSafely(fileInputStream3);
                if (TextUtils.isEmpty("")) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(str2);
                    ag.result = arrayList3;
                } else {
                    ag.errMsg = "fail";
                    ag.errCode = -1;
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

    public c ae(String str, boolean z) {
        c P = n.P(str, z ? "dirPath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (P == null) {
            String rX = n.rX(str);
            if (!n.rQ(rX)) {
                return ag(-4, "fail permission denied, open " + str);
            }
            String rJ = rJ(rX);
            if (TextUtils.isEmpty(rJ)) {
                return ag(-1, "fail no such file or directory " + str);
            }
            File file = new File(rJ);
            if (!file.exists()) {
                return ag(-1, "fail no such file or directory " + str);
            }
            if (!file.isDirectory()) {
                return ag(-1, "fail no such file or directory " + str);
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
            c ag = ag(0, "ok");
            ag.result = arrayList;
            return ag;
        }
        return P;
    }

    public c c(String str, boolean z, boolean z2) {
        boolean deleteFile;
        c P = n.P(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (P == null) {
            c rK = rK(str);
            if (rK == null) {
                if (!n.rQ(str)) {
                    return ag(-4, "fail permission denied, open " + str);
                }
                String rJ = rJ(str);
                if (TextUtils.isEmpty(rJ)) {
                    return ag(-1, "fail no such file or directory " + str);
                }
                File file = new File(rJ);
                if (!file.exists() || file.isFile()) {
                    return ag(-1, "fail no such file or directory " + str);
                }
                boolean d = d(file.listFiles());
                try {
                    if (!z && d) {
                        return ag(-1, "fail directory not empty ");
                    }
                    if (!z) {
                        deleteFile = file.delete();
                    } else {
                        deleteFile = com.baidu.swan.e.d.deleteFile(file);
                    }
                    if (!deleteFile) {
                        return ag(-1, "fail");
                    }
                    return ag(0, "ok");
                } catch (Exception e) {
                    return ag(-1, "fail");
                }
            }
            return rK;
        }
        return P;
    }

    private boolean d(File[] fileArr) {
        return (fileArr == null || fileArr.length == 0) ? false : true;
    }

    public c r(String str, String str2, boolean z) {
        c P = n.P(str, z ? "filePath must be a string" : "fail file not found", z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of NULL;");
        if (P == null) {
            String rX = n.rX(str);
            if (!this.dcE.W(rX, true)) {
                return ag(-1, "fail permission denied, open " + str);
            }
            c ab = ab(rX, true);
            if (ab != null) {
                ab.errMsg = n.t("fail no such file or directory ", "open", str, null);
                return ab;
            }
            boolean isEmpty = TextUtils.isEmpty(str2);
            if (!isEmpty) {
                str2 = str2.toLowerCase();
                if ("binary".equals(str2)) {
                    str2 = "latin1";
                }
            }
            if (!isEmpty && !dcC.contains(str2)) {
                return ag(-1, "fail Error: Unknown encoding: " + str2);
            }
            String rJ = rJ(rX);
            if (TextUtils.isEmpty(rJ)) {
                return ag(-1, "fail no such file or directory " + str);
            }
            File file = new File(rJ);
            String str3 = "";
            byte[] bArr = new byte[0];
            c ag = ag(0, "ok");
            try {
                if (TextUtils.isEmpty(str2)) {
                    bArr = n.rY(rJ);
                } else if ("base64".equals(str2)) {
                    byte[] rY = n.rY(rJ);
                    str3 = rY.length == 0 ? "" : Base64.encodeToString(rY, 2);
                    bArr = rY;
                } else if ("hex".equals(str2)) {
                    str3 = n.rT(rJ);
                } else {
                    str3 = a(new FileInputStream(file), str2);
                }
                if (TextUtils.isEmpty(str2)) {
                    ag.dbI = bArr;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str3);
                    ag.result = arrayList;
                }
                return ag;
            } catch (Exception e) {
                e.printStackTrace();
                return ag(-1, "fail");
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
            com.baidu.swan.e.d.closeSafely(fileInputStream);
        }
    }

    public c s(String str, String str2, boolean z) {
        c P = n.P(str, z ? "oldPath must be a string" : n.t("fail no such file or directory ", "rename", str, null), z ? " The argument must be string" : "fail parameter error: parameter.oldPath should be String instead of Undefined;");
        if (P == null) {
            c P2 = n.P(str2, z ? "newPath must be a string" : n.t("fail no such file or directory ", "rename", str2, null), z ? " The argument must be string" : "fail parameter error: parameter.newPath should be String instead of Undefined;");
            if (P2 == null) {
                String rX = n.rX(str);
                c rK = rK(rX);
                if (rK != null) {
                    rK.errMsg = n.t("fail permission denied, ", "rename", str, str2);
                    return rK;
                }
                String rX2 = n.rX(str2);
                c rK2 = rK(rX2);
                if (rK2 != null) {
                    rK2.errMsg = n.t("fail permission denied, ", "rename", str, str2);
                    return rK2;
                }
                c ab = ab(rX, false);
                if (ab != null) {
                    ab.errMsg = n.t("fail no such file or directory ", "rename", str, str2);
                    return ab;
                } else if (!n.rP(rX) || !n.rP(rX2)) {
                    return ag(-4, n.t("fail permission denied, ", "rename", str, str2));
                } else {
                    c ac = ac(rX2, false);
                    if (ac != null) {
                        ac.errMsg = n.t("fail no such file or directory ", "rename", str, str2);
                        return ac;
                    }
                    String rJ = rJ(rX);
                    if (TextUtils.isEmpty(rJ)) {
                        return ag(-1, "fail no such file or directory " + str);
                    }
                    String rJ2 = rJ(rX2);
                    if (TextUtils.isEmpty(rJ2)) {
                        return ag(-1, "fail no such file or directory " + str2);
                    }
                    File file = new File(rJ);
                    File file2 = new File(rJ2);
                    boolean exists = file2.exists();
                    if (!n.i(file, file2) || (file.isDirectory() && !exists && rL(rJ2))) {
                        return ag(-1, "fail rename failed");
                    }
                    try {
                        if ((file2.isDirectory() && file2.listFiles() != null && file2.listFiles().length > 0) || !file.renameTo(file2)) {
                            return ag(-1, "fail rename failed");
                        }
                        return ag(0, "ok");
                    } catch (Exception e) {
                        return ag(-1, "fail");
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
                String rX = n.rX(str);
                if (!this.dcE.W(rX, true)) {
                    return ag(-4, n.t("fail no such file or directory ", "copyFile", str, null));
                }
                String rX2 = n.rX(str2);
                if (!n.rP(rX2)) {
                    return ag(-4, n.t("fail permission denied, open ", "copyFile", str2, null));
                }
                c rK = rK(rX2);
                if (rK == null) {
                    String rJ = rJ(rX);
                    if (TextUtils.isEmpty(rJ)) {
                        return ag(-1, "fail no such file or directory " + str);
                    }
                    File file = new File(rJ);
                    if (!file.exists() || !file.isFile()) {
                        return ag(-1, n.t("fail no such file or directory ", "copyFile", str, null));
                    }
                    c ac = ac(rX2, false);
                    if (ac != null) {
                        ac.errMsg = n.t("fail no such file or directory ", "copyFile", str2, null);
                        return ac;
                    } else if (rX2.endsWith(File.separator)) {
                        return ag(-1, n.t("fail permission denied, ", "copyFile", str, str2));
                    } else {
                        String rJ2 = rJ(rX2);
                        if (TextUtils.isEmpty(rJ2)) {
                            return ag(-1, "fail no such file or directory " + str2);
                        }
                        File file2 = new File(rJ2);
                        if (file2.exists() && file2.isDirectory()) {
                            if (d(file2.listFiles())) {
                                return ag(-1, n.t("fail permission denied, ", "copyFile", str, str2));
                            }
                            try {
                                file2.delete();
                            } catch (Exception e) {
                                return ag(-1, "fail");
                            }
                        }
                        long fileSize = n.getFileSize(rJ);
                        if (rX.equals(rX2) || rX.startsWith(a.USER_DATA_PATH)) {
                            z2 = false;
                        }
                        if (z2 && this.dcF.bs(fileSize)) {
                            return ag(-1, aAV());
                        }
                        c cp = !rX.equals(rX2) ? cp(rX, rX2) : ag(0, "ok");
                        if (z2 && cp != null && cp.errCode == 0) {
                            this.dcF.br(fileSize);
                            return cp;
                        }
                        return cp;
                    }
                }
                return rK;
            }
            return P2;
        }
        return P;
    }

    public c b(String str, Object obj, String str2, boolean z) {
        c P = n.P(str, n.t("fail permission denied, open ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of NULL;");
        if (P == null) {
            String rX = n.rX(str);
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return ag(-1, "fail sdcard not mounted ");
            }
            c rK = rK(rX);
            if (rK == null) {
                if (obj == null) {
                    return ag(-1, "fail TypeError: data argument must be a string, Buffer, ArrayBuffer, Array, or array-like object");
                }
                String rJ = rJ(rX);
                if (TextUtils.isEmpty(rJ)) {
                    return ag(-1, "fail no such file or directory " + str);
                }
                File file = new File(rJ);
                if (!file.exists()) {
                    return ag(-1, n.t("fail no such file or directory ", "open", str, null));
                }
                if (file.isDirectory()) {
                    return ag(-1, "fail illegal operation on a directory, open " + str);
                }
                return a(rX, obj, str2, true);
            }
            return rK;
        }
        return P;
    }

    public c af(String str, boolean z) {
        c P = n.P(str, z ? "path must be a string" : n.t("fail no such file or directory ", LogConfig.KEY_ACCESS, str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Undefined;");
        if (P == null) {
            String rX = n.rX(str);
            if (!this.dcE.W(rX, true)) {
                return ag(-4, n.t("fail no such file or directory ", LogConfig.KEY_ACCESS, str, null));
            }
            String rJ = rJ(rX);
            if (TextUtils.isEmpty(rJ)) {
                return ag(-1, "fail no such file or directory " + str);
            }
            if (!new File(rJ).exists()) {
                return ag(-1, n.t("fail no such file or directory ", LogConfig.KEY_ACCESS, str, null));
            }
            return ag(0, "ok");
        }
        return P;
    }

    public c ag(String str, boolean z) {
        c P = n.P(str, z ? "path must be a string" : n.t("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Object;");
        if (P == null) {
            if (!n.rZ(str) && !n.rQ(str)) {
                return ag(-1, "fail permission denied, open " + str);
            }
            c ab = ab(str, false);
            if (ab == null) {
                j jVar = new j();
                String rJ = rJ(str);
                if (TextUtils.isEmpty(rJ)) {
                    return ag(-1, n.t("fail no such file or directory ", null, str, null));
                }
                File file = new File(rJ);
                jVar.fQ(file.isDirectory());
                jVar.fR(file.isFile());
                return a(str, jVar);
            }
            return ab;
        }
        return P;
    }

    private c a(String str, j jVar) {
        String rJ = rJ(str);
        if (TextUtils.isEmpty(rJ)) {
            return ag(-1, "fail no such file or directory " + str);
        }
        File file = new File(rJ);
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                jVar.lastAccessedTime = Os.lstat(file.getAbsolutePath()).st_atime;
                jVar.lastModifiedTime = Os.lstat(file.getAbsolutePath()).st_mtime;
                jVar.mode = Os.lstat(file.getAbsolutePath()).st_mode;
                jVar.size = Os.lstat(file.getAbsolutePath()).st_size;
            } catch (Exception e) {
                e.printStackTrace();
                return ag(-1, "fail");
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
                return ag(-1, "fail");
            }
        }
        c ag = ag(0, "ok");
        ag.stats = jVar;
        ag.errMsg = "ok";
        return ag;
    }

    public c aAU() {
        String asQ = this.dcE.asQ();
        String rJ = rJ(a.USER_DATA_PATH);
        if (TextUtils.isEmpty(rJ)) {
            return ag(-1, "path must be a string");
        }
        ArrayList arrayList = new ArrayList();
        for (String str : n.ah(rJ, false)) {
            File file = new File(str);
            d dVar = new d();
            dVar.createTime = file.exists() ? file.lastModified() : 0L;
            String absolutePath = file.getAbsolutePath();
            if (file.exists() && !TextUtils.isEmpty(absolutePath) && !TextUtils.isEmpty(asQ) && absolutePath.startsWith(asQ)) {
                dVar.filePath = this.dcE.pj(absolutePath);
            }
            dVar.size = file.exists() ? file.length() : 0L;
            arrayList.add(dVar);
        }
        c ag = ag(0, "ok");
        ag.fileList = arrayList;
        return ag;
    }

    public c rN(String str) {
        c ag;
        c P = n.P(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Object;");
        if (P == null) {
            if (rK(str) != null) {
                return ag(-4, "fail file not exist");
            }
            String rJ = rJ(str);
            if (TextUtils.isEmpty(rJ)) {
                return ag(-1, "fail no such file or directory " + str);
            }
            File file = new File(rJ);
            if (!file.exists() || file.isDirectory()) {
                return ag(-1, "fail file not exist");
            }
            long fileSize = n.getFileSize(rJ);
            try {
                if (!file.delete()) {
                    ag = ag(-1, "fail");
                } else {
                    this.dcF.br(-fileSize);
                    ag = ag(0, "ok");
                }
                return ag;
            } catch (Exception e) {
                return ag(-1, "fail");
            }
        }
        return P;
    }

    public c rO(String str) {
        c P = n.P(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Undefined;");
        if (P == null) {
            String rX = n.rX(str);
            if (!this.dcE.W(rX, true)) {
                return ag(-4, "fail file not exist");
            }
            String rJ = rJ(rX);
            if (TextUtils.isEmpty(rJ)) {
                return ag(-1, "fail no such file or directory " + str);
            }
            File file = new File(rJ);
            if (!file.exists()) {
                return ag(-1, "fail file not exist");
            }
            if (file.isDirectory()) {
                return ag(-1, "fail " + str + " is directory");
            }
            c ag = ag(0, "ok");
            ag.size = file.exists() ? file.length() : 0L;
            ag.digest = file.exists() ? com.baidu.swan.e.e.toMd5(file, false) : null;
            return ag;
        }
        return P;
    }

    private String aAV() {
        String generateFileSizeText = com.baidu.swan.e.d.generateFileSizeText(this.dcF.getMaxSize());
        return String.format("fail file size over %s", (TextUtils.isEmpty(generateFileSizeText) || TextUtils.equals(generateFileSizeText, FileUtils.UNKNOW)) ? "" : "");
    }
}
