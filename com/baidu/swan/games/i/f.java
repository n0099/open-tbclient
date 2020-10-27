package com.baidu.swan.games.i;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.system.Os;
import android.text.TextUtils;
import android.util.Base64;
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
/* loaded from: classes10.dex */
public class f {
    private static List<String> dOZ = new ArrayList();
    private String dPa;
    private final com.baidu.swan.apps.storage.b.c dPb;
    private final com.baidu.swan.apps.storage.b.d dPc;
    private Context mContext;

    static {
        dOZ.add("ascii");
        dOZ.add("base64");
        dOZ.add("binary");
        dOZ.add("hex");
        dOZ.add("utf-8");
        dOZ.add("utf8");
        dOZ.add("latin1");
        dOZ.add("ucs2");
        dOZ.add("ucs-2");
        dOZ.add("utf16le");
        dOZ.add("utf-16le");
    }

    public f(Context context, String str, @NonNull com.baidu.swan.apps.storage.b.c cVar) {
        this.mContext = context;
        this.dPa = str;
        this.dPb = cVar;
        this.dPc = this.dPb.aIo();
    }

    private String wy(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.startsWith("bdfile://code")) {
            this.dPa = this.dPa.endsWith(File.separator) ? this.dPa.substring(0, this.dPa.length() - 1) : this.dPa;
            return this.dPa + str.substring("bdfile://code".length());
        } else if (str.startsWith("bdfile://")) {
            return this.dPb.tt(str);
        } else {
            return "";
        }
    }

    private c wz(String str) {
        c at = at(-1, "fail permission denied, open " + str);
        if (!TextUtils.isEmpty(str) && str.startsWith(a.USER_DATA_PATH)) {
            return null;
        }
        return at;
    }

    private c at(int i, String str) {
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
        String wy = wy(str);
        if (TextUtils.isEmpty(str)) {
            c cVar2 = new c();
            cVar2.errCode = -1;
            cVar2.errMsg = "fail no such file or directory " + str;
            return cVar2;
        }
        File file = new File(wy);
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
        String wy = wy(str);
        if (TextUtils.isEmpty(wy)) {
            return at(-1, "fail no such file or directory " + str);
        }
        if (wy.contains(File.separator)) {
            File file = new File(wy.substring(0, wy.lastIndexOf(File.separator)));
            if (!z && (!file.exists() || (file.exists() && file.isFile()))) {
                return at(-1, "fail no such file or directory " + str);
            }
        }
        return null;
    }

    public c b(String str, boolean z, boolean z2) {
        boolean mkdir;
        c aa = n.aa(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (aa == null) {
            c wz = wz(str);
            if (wz == null) {
                if (!n.wE(str)) {
                    return at(-4, "fail permission denied, open " + str);
                }
                String wy = wy(str);
                if (TextUtils.isEmpty(wy)) {
                    return at(-1, "fail no such file or directory " + str);
                }
                c am = am(str, z);
                if (am == null) {
                    File file = new File(wy);
                    if (file.exists()) {
                        return at(-1, "fail file already exists " + str);
                    }
                    try {
                        if (z) {
                            mkdir = file.mkdirs();
                        } else {
                            mkdir = file.mkdir();
                        }
                        if (!mkdir) {
                            return at(-1, "fail");
                        }
                        return at(0, "ok");
                    } catch (Exception e) {
                        return at(-1, "fail");
                    }
                }
                return am;
            }
            return wz;
        }
        return aa;
    }

    public c a(boolean z, String str, Object obj, String str2) {
        c aa = n.aa(str, z ? "filePath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        return aa != null ? aa : a(str, obj, str2, false);
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
        c wz = wz(str);
        if (wz != null) {
            return wz;
        }
        if (obj == null) {
            return at(-1, "The argument must be string or arrayBuffer");
        }
        int length = (a.USER_DATA_PATH + File.separator).length();
        if (n.wE(str)) {
            boolean z2 = obj instanceof byte[];
            if (!z2 && TextUtils.isEmpty(str2)) {
                str2 = "utf-8";
            }
            if (!TextUtils.isEmpty(str2)) {
                if ("binary".equals(str2.toLowerCase())) {
                    str2 = "latin1";
                }
                if (!dOZ.contains(str2.toLowerCase())) {
                    return at(-1, "fail invalid encoding \"" + str2 + "\"");
                }
            }
            BufferedWriter bufferedWriter3 = null;
            Closeable closeable = null;
            c am = am(str, false);
            if (am == null) {
                String wy = wy(str);
                if (TextUtils.isEmpty(wy)) {
                    return at(-1, "fail no such file or directory " + str.substring(length));
                }
                long j = 0;
                if (!z2 && !TextUtils.isEmpty((String) obj)) {
                    j = ((String) obj).getBytes().length;
                } else if (z2) {
                    j = ((byte[]) obj).length;
                }
                if (this.dPb.aIo().bV(j)) {
                    return at(-1, aSD());
                }
                File file = new File(wy);
                if (file.exists() && file.isDirectory()) {
                    return at(-1, " fail illegal operation on a directory, open " + str);
                }
                long length2 = file.length();
                c at = at(0, "ok");
                try {
                    if (z2) {
                        byte[] bArr = (byte[]) obj;
                        FileOutputStream fileOutputStream2 = new FileOutputStream(wy, z);
                        try {
                            fileOutputStream2.write(bArr);
                            fileOutputStream2.flush();
                            bufferedWriter2 = null;
                            r2 = fileOutputStream2;
                        } catch (Exception e) {
                            fileOutputStream = fileOutputStream2;
                            bufferedWriter = null;
                            c at2 = at(-1, "fail");
                            com.baidu.swan.c.d.closeSafely(bufferedWriter);
                            com.baidu.swan.c.d.closeSafely(fileOutputStream);
                            return at2;
                        } catch (Throwable th) {
                            closeable = fileOutputStream2;
                            th = th;
                            com.baidu.swan.c.d.closeSafely(bufferedWriter3);
                            com.baidu.swan.c.d.closeSafely(closeable);
                            throw th;
                        }
                    } else if (TextUtils.isEmpty((String) obj) || !TextUtils.equals("base64", str2)) {
                        String[] db = n.db((String) obj, str2);
                        if (db == null || db.length != 2) {
                            str3 = "utf-8";
                            str4 = "";
                        } else {
                            String str5 = db[0];
                            str3 = db[1];
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
                                c at22 = at(-1, "fail");
                                com.baidu.swan.c.d.closeSafely(bufferedWriter);
                                com.baidu.swan.c.d.closeSafely(fileOutputStream);
                                return at22;
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
                            c at222 = at(-1, "fail");
                            com.baidu.swan.c.d.closeSafely(bufferedWriter);
                            com.baidu.swan.c.d.closeSafely(fileOutputStream);
                            return at222;
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
                        this.dPc.bU(j);
                    } else {
                        this.dPc.bU(j - length2);
                    }
                    com.baidu.swan.c.d.closeSafely(bufferedWriter2);
                    com.baidu.swan.c.d.closeSafely(r2);
                    r2 = at;
                    return r2;
                } catch (Exception e5) {
                    fileOutputStream = r2;
                    bufferedWriter = bufferedWriter2;
                    c at2222 = at(-1, "fail");
                    com.baidu.swan.c.d.closeSafely(bufferedWriter);
                    com.baidu.swan.c.d.closeSafely(fileOutputStream);
                    return at2222;
                } catch (Throwable th6) {
                    bufferedWriter3 = bufferedWriter2;
                    closeable = r2;
                    th = th6;
                    com.baidu.swan.c.d.closeSafely(bufferedWriter3);
                    com.baidu.swan.c.d.closeSafely(closeable);
                    throw th;
                }
            }
            return am;
        }
        return at(-4, "fail permission denied, open " + str.substring(length));
    }

    public c an(String str, boolean z) {
        c at;
        c aa = n.aa(str, z ? "filePath must be a string" : n.u("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of Object;");
        if (aa == null) {
            if (!n.wF(str)) {
                return at(-4, n.u("fail permission denied, open ", null, str, null));
            }
            c al = al(str, false);
            if (al == null) {
                c wz = wz(str);
                if (wz == null) {
                    String wy = wy(str);
                    if (TextUtils.isEmpty(wy)) {
                        return at(-1, n.u("fail no such file or directory ", null, str, null));
                    }
                    File file = new File(wy);
                    if (file.isDirectory()) {
                        return at(-1, n.u("fail operation not permitted ", "unlink", str, null));
                    }
                    long fileSize = n.getFileSize(wy);
                    try {
                        if (file.delete()) {
                            this.dPc.bU(-fileSize);
                            at = at(0, "ok");
                        } else {
                            at = at(-1, n.u("fail", null, str, null));
                        }
                        return at;
                    } catch (Exception e) {
                        return at(-1, n.u("fail", null, str, null));
                    }
                }
                return wz;
            }
            return al;
        }
        return aa;
    }

    public c cX(String str, String str2) {
        c aa = n.aa(str, n.f("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true), "fail parameter error: parameter.zipFilePath should be String instead of Object;");
        if (aa == null) {
            c aa2 = n.aa(str2, n.f("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true), "fail parameter error: parameter.targetPath should be String instead of Object;");
            if (aa2 == null) {
                if (!str2.startsWith("bdfile://tmp") && !str2.startsWith(a.USER_DATA_PATH)) {
                    return at(-1, "fail permission denied, open " + str2);
                }
                String wM = n.wM(str);
                if (!this.dPb.ag(wM, true)) {
                    return at(-4, n.f("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (!n.wE(str2)) {
                    return at(-4, n.f("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (wA(str2)) {
                    return at(-1, n.f("fail permission denied, ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                String wy = wy(wM);
                String wy2 = wy(str2);
                if (TextUtils.isEmpty(wy)) {
                    return at(-1, n.f("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (TextUtils.isEmpty(wy2)) {
                    return at(-1, n.f("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                File file = new File(wy);
                if (!file.exists()) {
                    return at(-1, n.f("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                if (!wy.endsWith(".zip")) {
                    return at(-1, "fail unzip failed");
                }
                if (!file.isFile()) {
                    return at(-1, n.f("fail permission denied, ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
                }
                File file2 = new File(wy2);
                if (!file2.exists()) {
                    file2.mkdirs();
                } else if (file2.isFile()) {
                    return at(-1, "fail unzip failed");
                }
                List<String> ar = n.ar(wy2, true);
                if (!com.baidu.swan.c.d.unzipFile(wy, wy2)) {
                    return at(-1, "fail unzip failed");
                }
                if (str2.startsWith(a.USER_DATA_PATH)) {
                    List<String> ar2 = n.ar(wy2, true);
                    ArrayList arrayList = new ArrayList(ar2.size());
                    long j = 0;
                    for (String str3 : ar2) {
                        if (!ar.contains(str3)) {
                            arrayList.add(str3);
                            j = n.getFileSize(str3) + j;
                        }
                    }
                    if (this.dPc.bV(j)) {
                        n.aM(arrayList);
                        return at(-1, aSD());
                    }
                    this.dPc.bU(j);
                }
                return at(0, "ok");
            }
            return aa2;
        }
        return aa;
    }

    private boolean wA(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.contains(File.separator)) {
            return wB(str.substring(str.lastIndexOf(File.separator) + 1));
        }
        return wB(str);
    }

    private boolean wB(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(".")) {
            return false;
        }
        String[] split = str.split("\\.");
        return (split.length != 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) ? false : true;
    }

    public c q(String str, String str2, boolean z) {
        c aa = n.aa(str, z ? "tempFilePath must be a string" : "fail tempFilePath file not exist", z ? " The argument must be string" : "fail parameter error: parameter.tempFilePath should be String instead of Object;");
        if (aa == null) {
            String wM = n.wM(str2);
            if (TextUtils.isEmpty(wM)) {
                wM = a.USER_DATA_PATH + File.separator + com.baidu.swan.c.d.getFileNameFromPath(str);
            }
            if (!wM.startsWith(a.USER_DATA_PATH)) {
                return at(-1, n.u("fail permission denied, open ", null, str2, null));
            }
            if (!this.dPb.td(str)) {
                return at(-4, "fail it is not a tempFilePath");
            }
            c am = am(wM, false);
            if (am != null) {
                return am;
            }
            c am2 = am(str, false);
            if (am2 != null) {
                return am2;
            }
            String wy = wy(wM);
            if (TextUtils.isEmpty(wy)) {
                return at(-1, "fail no such file or directory " + str2);
            }
            File file = new File(wy);
            if (a.USER_DATA_PATH.equals(wM) || (file.exists() && file.isDirectory())) {
                return at(-1, n.u("fail Error: EISDIR: illegal operation on a directory, open ", null, str2, null));
            }
            c al = al(str, true);
            if (al != null) {
                al.errMsg = "fail no such file or directory ";
                return al;
            }
            String wy2 = wy(str);
            if (TextUtils.isEmpty(wy2)) {
                return at(-1, "fail no such file or directory " + str);
            }
            long fileSize = n.getFileSize(wy2);
            if (this.dPc.bV(fileSize)) {
                return at(-1, aSD());
            }
            if (!wM.startsWith(a.USER_DATA_PATH) || n.wG(wM)) {
                return at(-1, n.u("fail permission denied, open ", null, str2, null));
            }
            c am3 = am(wM, false);
            if (am3 != null) {
                return am3;
            }
            c wz = wz(wM);
            if (wz != null) {
                return wz;
            }
            c cY = cY(str, wM);
            if (cY != null && cY.errCode == 0) {
                this.dPc.bU(fileSize);
                if (TextUtils.isEmpty(str)) {
                    return at(-1, n.u("fail no such file or directory ", null, str, null));
                }
                File file2 = new File(wy2);
                if (file2.exists()) {
                    file2.delete();
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(wM);
                cY.result = arrayList;
                cY.errMsg = "ok";
            }
            return cY;
        }
        return aa;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [813=4] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v11, resolved type: java.io.FileOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private c cY(String str, String str2) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream3 = null;
        String wy = wy(str);
        String wy2 = wy(str2);
        if (TextUtils.isEmpty(wy)) {
            return at(-1, n.u("fail no such file or directory ", null, str, null));
        }
        if (TextUtils.isEmpty(wy2)) {
            return at(-1, n.u("fail no such file or directory ", null, str2, null));
        }
        c at = at(0, "ok");
        try {
            File file = new File(wy2);
            fileInputStream = new FileInputStream(new File(wy));
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
                at.errMsg = "fail";
                at.errCode = -1;
                return at;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            at.result = arrayList;
            return at;
        } catch (IOException e3) {
            e = e3;
            fileInputStream3 = fileInputStream;
            fileInputStream2 = fileOutputStream;
            try {
                e.printStackTrace();
                c at2 = at(-1, "fail");
                com.baidu.swan.c.d.closeSafely(fileInputStream3);
                com.baidu.swan.c.d.closeSafely(fileInputStream2);
                if (TextUtils.isEmpty("")) {
                    at.errMsg = "fail";
                    at.errCode = -1;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(str2);
                    at.result = arrayList2;
                }
                return at2;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream3;
                fileInputStream3 = fileInputStream2;
                com.baidu.swan.c.d.closeSafely(fileInputStream);
                com.baidu.swan.c.d.closeSafely(fileInputStream3);
                if (TextUtils.isEmpty("")) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(str2);
                    at.result = arrayList3;
                } else {
                    at.errMsg = "fail";
                    at.errCode = -1;
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

    public c ao(String str, boolean z) {
        c aa = n.aa(str, z ? "dirPath must be a string" : "fail permission denied, open " + str, z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (aa == null) {
            String wM = n.wM(str);
            if (!n.wF(wM)) {
                return at(-4, "fail permission denied, open " + str);
            }
            String wy = wy(wM);
            if (TextUtils.isEmpty(wy)) {
                return at(-1, "fail no such file or directory " + str);
            }
            File file = new File(wy);
            if (!file.exists()) {
                return at(-1, "fail no such file or directory " + str);
            }
            if (!file.isDirectory()) {
                return at(-1, "fail no such file or directory " + str);
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
            c at = at(0, "ok");
            at.result = arrayList;
            return at;
        }
        return aa;
    }

    public c c(String str, boolean z, boolean z2) {
        boolean deleteFile;
        c aa = n.aa(str, z2 ? "dirPath must be a string" : "fail permission denied, open " + str, z2 ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of Object;");
        if (aa == null) {
            c wz = wz(str);
            if (wz == null) {
                if (!n.wF(str)) {
                    return at(-4, "fail permission denied, open " + str);
                }
                String wy = wy(str);
                if (TextUtils.isEmpty(wy)) {
                    return at(-1, "fail no such file or directory " + str);
                }
                File file = new File(wy);
                if (!file.exists() || file.isFile()) {
                    return at(-1, "fail no such file or directory " + str);
                }
                boolean d = d(file.listFiles());
                try {
                    if (!z && d) {
                        return at(-1, "fail directory not empty ");
                    }
                    if (!z) {
                        deleteFile = file.delete();
                    } else {
                        deleteFile = com.baidu.swan.c.d.deleteFile(file);
                    }
                    if (!deleteFile) {
                        return at(-1, "fail");
                    }
                    return at(0, "ok");
                } catch (Exception e) {
                    return at(-1, "fail");
                }
            }
            return wz;
        }
        return aa;
    }

    private boolean d(File[] fileArr) {
        return (fileArr == null || fileArr.length == 0) ? false : true;
    }

    public c r(String str, String str2, boolean z) {
        c aa = n.aa(str, z ? "filePath must be a string" : "fail file not found", z ? " The argument must be string" : "fail parameter error: parameter.dirPath should be String instead of NULL;");
        if (aa == null) {
            String wM = n.wM(str);
            if (!this.dPb.ag(wM, true)) {
                return at(-1, "fail permission denied, open " + str);
            }
            c al = al(wM, true);
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
            if (!isEmpty && !dOZ.contains(str2)) {
                return at(-1, "fail Error: Unknown encoding: " + str2);
            }
            String wy = wy(wM);
            if (TextUtils.isEmpty(wy)) {
                return at(-1, "fail no such file or directory " + str);
            }
            File file = new File(wy);
            String str3 = "";
            byte[] bArr = new byte[0];
            c at = at(0, "ok");
            try {
                if (TextUtils.isEmpty(str2)) {
                    bArr = n.wN(wy);
                } else if ("base64".equals(str2)) {
                    byte[] wN = n.wN(wy);
                    str3 = wN.length == 0 ? "" : Base64.encodeToString(wN, 2);
                    bArr = wN;
                } else if ("hex".equals(str2)) {
                    str3 = n.wI(wy);
                } else {
                    str3 = a(new FileInputStream(file), str2);
                }
                if (TextUtils.isEmpty(str2)) {
                    at.dOg = bArr;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str3);
                    at.result = arrayList;
                }
                return at;
            } catch (Exception e) {
                e.printStackTrace();
                return at(-1, "fail");
            }
        }
        return aa;
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
        c aa = n.aa(str, z ? "oldPath must be a string" : n.u("fail no such file or directory ", "rename", str, null), z ? " The argument must be string" : "fail parameter error: parameter.oldPath should be String instead of Undefined;");
        if (aa == null) {
            c aa2 = n.aa(str2, z ? "newPath must be a string" : n.u("fail no such file or directory ", "rename", str2, null), z ? " The argument must be string" : "fail parameter error: parameter.newPath should be String instead of Undefined;");
            if (aa2 == null) {
                String wM = n.wM(str);
                c wz = wz(wM);
                if (wz != null) {
                    wz.errMsg = n.u("fail permission denied, ", "rename", str, str2);
                    return wz;
                }
                String wM2 = n.wM(str2);
                c wz2 = wz(wM2);
                if (wz2 != null) {
                    wz2.errMsg = n.u("fail permission denied, ", "rename", str, str2);
                    return wz2;
                }
                c al = al(wM, false);
                if (al != null) {
                    al.errMsg = n.u("fail no such file or directory ", "rename", str, str2);
                    return al;
                } else if (!n.wE(wM) || !n.wE(wM2)) {
                    return at(-4, n.u("fail permission denied, ", "rename", str, str2));
                } else {
                    c am = am(wM2, false);
                    if (am != null) {
                        am.errMsg = n.u("fail no such file or directory ", "rename", str, str2);
                        return am;
                    }
                    String wy = wy(wM);
                    if (TextUtils.isEmpty(wy)) {
                        return at(-1, "fail no such file or directory " + str);
                    }
                    String wy2 = wy(wM2);
                    if (TextUtils.isEmpty(wy2)) {
                        return at(-1, "fail no such file or directory " + str2);
                    }
                    File file = new File(wy);
                    File file2 = new File(wy2);
                    boolean exists = file2.exists();
                    if (!n.k(file, file2) || (file.isDirectory() && !exists && wA(wy2))) {
                        return at(-1, "fail rename failed");
                    }
                    try {
                        if ((file2.isDirectory() && file2.listFiles() != null && file2.listFiles().length > 0) || !file.renameTo(file2)) {
                            return at(-1, "fail rename failed");
                        }
                        return at(0, "ok");
                    } catch (Exception e) {
                        return at(-1, "fail");
                    }
                }
            }
            return aa2;
        }
        return aa;
    }

    public c t(String str, String str2, boolean z) {
        boolean z2 = true;
        c aa = n.aa(str, "srcPath must be a string", " The argument must be string");
        if (aa == null) {
            c aa2 = n.aa(str2, "destPath must be a string", " The argument must be string");
            if (aa2 == null) {
                String wM = n.wM(str);
                if (!this.dPb.ag(wM, true)) {
                    return at(-4, n.u("fail no such file or directory ", "copyFile", str, null));
                }
                String wM2 = n.wM(str2);
                if (!n.wE(wM2)) {
                    return at(-4, n.u("fail permission denied, open ", "copyFile", str2, null));
                }
                c wz = wz(wM2);
                if (wz == null) {
                    String wy = wy(wM);
                    if (TextUtils.isEmpty(wy)) {
                        return at(-1, "fail no such file or directory " + str);
                    }
                    File file = new File(wy);
                    if (!file.exists() || !file.isFile()) {
                        return at(-1, n.u("fail no such file or directory ", "copyFile", str, null));
                    }
                    c am = am(wM2, false);
                    if (am != null) {
                        am.errMsg = n.u("fail no such file or directory ", "copyFile", str2, null);
                        return am;
                    } else if (wM2.endsWith(File.separator)) {
                        return at(-1, n.u("fail permission denied, ", "copyFile", str, str2));
                    } else {
                        String wy2 = wy(wM2);
                        if (TextUtils.isEmpty(wy2)) {
                            return at(-1, "fail no such file or directory " + str2);
                        }
                        File file2 = new File(wy2);
                        if (file2.exists() && file2.isDirectory()) {
                            if (d(file2.listFiles())) {
                                return at(-1, n.u("fail permission denied, ", "copyFile", str, str2));
                            }
                            try {
                                file2.delete();
                            } catch (Exception e) {
                                return at(-1, "fail");
                            }
                        }
                        long fileSize = n.getFileSize(wy);
                        if (wM.equals(wM2) || wM.startsWith(a.USER_DATA_PATH)) {
                            z2 = false;
                        }
                        if (z2 && this.dPc.bV(fileSize)) {
                            return at(-1, aSD());
                        }
                        c cY = !wM.equals(wM2) ? cY(wM, wM2) : at(0, "ok");
                        if (z2 && cY != null && cY.errCode == 0) {
                            this.dPc.bU(fileSize);
                            return cY;
                        }
                        return cY;
                    }
                }
                return wz;
            }
            return aa2;
        }
        return aa;
    }

    public c b(String str, Object obj, String str2, boolean z) {
        c aa = n.aa(str, n.u("fail permission denied, open ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.filePath should be String instead of NULL;");
        if (aa == null) {
            String wM = n.wM(str);
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return at(-1, "fail sdcard not mounted ");
            }
            c wz = wz(wM);
            if (wz == null) {
                if (obj == null) {
                    return at(-1, "fail TypeError: data argument must be a string, Buffer, ArrayBuffer, Array, or array-like object");
                }
                String wy = wy(wM);
                if (TextUtils.isEmpty(wy)) {
                    return at(-1, "fail no such file or directory " + str);
                }
                File file = new File(wy);
                if (!file.exists()) {
                    return at(-1, n.u("fail no such file or directory ", "open", str, null));
                }
                if (file.isDirectory()) {
                    return at(-1, "fail illegal operation on a directory, open " + str);
                }
                return a(wM, obj, str2, true);
            }
            return wz;
        }
        return aa;
    }

    public c ap(String str, boolean z) {
        c aa = n.aa(str, z ? "path must be a string" : n.u("fail no such file or directory ", "access", str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Undefined;");
        if (aa == null) {
            String wM = n.wM(str);
            if (!this.dPb.ag(wM, true)) {
                return at(-4, n.u("fail no such file or directory ", "access", str, null));
            }
            String wy = wy(wM);
            if (TextUtils.isEmpty(wy)) {
                return at(-1, "fail no such file or directory " + str);
            }
            if (!new File(wy).exists()) {
                return at(-1, n.u("fail no such file or directory ", "access", str, null));
            }
            return at(0, "ok");
        }
        return aa;
    }

    public c aq(String str, boolean z) {
        c aa = n.aa(str, z ? "path must be a string" : n.u("fail no such file or directory ", null, str, null), z ? " The argument must be string" : "fail parameter error: parameter.path should be String instead of Object;");
        if (aa == null) {
            if (!this.dPb.td(str) && !this.dPb.tc(str)) {
                return at(-1, "fail permission denied, open " + str);
            }
            c al = al(str, false);
            if (al == null) {
                j jVar = new j();
                String wy = wy(str);
                if (TextUtils.isEmpty(wy)) {
                    return at(-1, n.u("fail no such file or directory ", null, str, null));
                }
                File file = new File(wy);
                jVar.hl(file.isDirectory());
                jVar.hm(file.isFile());
                return a(str, jVar);
            }
            return al;
        }
        return aa;
    }

    private c a(String str, j jVar) {
        String wy = wy(str);
        if (TextUtils.isEmpty(wy)) {
            return at(-1, "fail no such file or directory " + str);
        }
        File file = new File(wy);
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                jVar.lastAccessedTime = Os.lstat(file.getAbsolutePath()).st_atime;
                jVar.lastModifiedTime = Os.lstat(file.getAbsolutePath()).st_mtime;
                jVar.mode = Os.lstat(file.getAbsolutePath()).st_mode;
                jVar.size = Os.lstat(file.getAbsolutePath()).st_size;
            } catch (Exception e) {
                e.printStackTrace();
                return at(-1, "fail");
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
                return at(-1, "fail");
            }
        }
        c at = at(0, "ok");
        at.stats = jVar;
        at.errMsg = "ok";
        return at;
    }

    public c aSC() {
        String aIn = this.dPb.aIn();
        String wy = wy(a.USER_DATA_PATH);
        if (TextUtils.isEmpty(wy)) {
            return at(-1, "path must be a string");
        }
        ArrayList arrayList = new ArrayList();
        for (String str : n.ar(wy, false)) {
            File file = new File(str);
            d dVar = new d();
            dVar.createTime = file.exists() ? file.lastModified() : 0L;
            String absolutePath = file.getAbsolutePath();
            if (file.exists() && !TextUtils.isEmpty(absolutePath) && !TextUtils.isEmpty(aIn) && absolutePath.startsWith(aIn)) {
                dVar.filePath = this.dPb.tu(absolutePath);
            }
            dVar.size = file.exists() ? file.length() : 0L;
            arrayList.add(dVar);
        }
        c at = at(0, "ok");
        at.fileList = arrayList;
        return at;
    }

    public c wC(String str) {
        c at;
        c aa = n.aa(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Object;");
        if (aa == null) {
            if (wz(str) != null) {
                return at(-4, "fail file not exist");
            }
            String wy = wy(str);
            if (TextUtils.isEmpty(wy)) {
                return at(-1, "fail no such file or directory " + str);
            }
            File file = new File(wy);
            if (!file.exists() || file.isDirectory()) {
                return at(-1, "fail file not exist");
            }
            long fileSize = n.getFileSize(wy);
            try {
                if (!file.delete()) {
                    at = at(-1, "fail");
                } else {
                    this.dPc.bU(-fileSize);
                    at = at(0, "ok");
                }
                return at;
            } catch (Exception e) {
                return at(-1, "fail");
            }
        }
        return aa;
    }

    public c wD(String str) {
        c aa = n.aa(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Undefined;");
        if (aa == null) {
            String wM = n.wM(str);
            if (!this.dPb.ag(wM, true)) {
                return at(-4, "fail file not exist");
            }
            String wy = wy(wM);
            if (TextUtils.isEmpty(wy)) {
                return at(-1, "fail no such file or directory " + str);
            }
            File file = new File(wy);
            if (!file.exists()) {
                return at(-1, "fail file not exist");
            }
            if (file.isDirectory()) {
                return at(-1, "fail " + str + " is directory");
            }
            c at = at(0, "ok");
            at.size = file.exists() ? file.length() : 0L;
            at.digest = file.exists() ? com.baidu.swan.c.e.toMd5(file, false) : null;
            return at;
        }
        return aa;
    }

    private String aSD() {
        String generateFileSizeText = com.baidu.swan.c.d.generateFileSizeText(this.dPc.getMaxSize());
        return String.format("fail file size over %s", (TextUtils.isEmpty(generateFileSizeText) || TextUtils.equals(generateFileSizeText, FileUtils.UNKNOW)) ? "" : "");
    }
}
