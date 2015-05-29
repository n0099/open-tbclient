package com.baidu.adp.lib.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.plugin.install.PluginInstallerService;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes.dex */
public class h {
    private static h yb = null;

    public static h iO() {
        h hVar;
        if (yb == null) {
            synchronized (h.class) {
                if (yb == null) {
                    yb = new h();
                }
                hVar = yb;
            }
            return hVar;
        }
        return yb;
    }

    public boolean a(String str, int i, j jVar) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        if (BdBaseApplication.getInst().getApp() == null || BdBaseApplication.getInst().getApp().getApplicationInfo() == null) {
            z = false;
        } else {
            boolean z2 = false;
            for (int i2 = 0; i2 < i; i2++) {
                z2 = a(str, sb);
                if (z2) {
                    break;
                }
            }
            if (z2) {
                z = z2;
            } else {
                String aR = aR(str);
                File file = new File(aR);
                if (file.exists()) {
                    if (file.length() > 0) {
                        boolean b = b(aR, sb);
                        if (b) {
                            sb.append("-Succ2-");
                            z = b;
                        } else {
                            sb.append("-Error7-");
                            z = b;
                        }
                    } else {
                        sb.append("-Error6:soSize1-");
                        z = z2;
                    }
                } else {
                    i iVar = new i(this, str, aR, sb, jVar);
                    iVar.setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen()));
                    iVar.execute(new Object[0]);
                    return false;
                }
            }
            if (sb.length() > 0) {
                com.baidu.adp.lib.stats.f.hz().a("so", "load_" + str + PluginInstallerService.APK_LIB_SUFFIX, "", "", -9101, sb.toString(), new Object[0]);
            }
        }
        return z;
    }

    private boolean a(String str, StringBuilder sb) {
        boolean b = b(aQ(str), sb);
        if (!b) {
            try {
                System.loadLibrary(str);
                sb.append("-Succ3-");
                return true;
            } catch (Throwable th) {
                sb.append("-Error3:");
                sb.append(String.valueOf(th.getClass().getName()) + "-" + th.getMessage());
                sb.append("-");
                return b;
            }
        }
        return b;
    }

    private boolean b(String str, StringBuilder sb) {
        if (!new File(str).exists()) {
            sb.append("-Error1:");
            sb.append(str);
            sb.append("_FileNotFound-");
            return false;
        }
        try {
            System.load(str);
            return true;
        } catch (Throwable th) {
            sb.append("-Error2:");
            sb.append(String.valueOf(th.getClass().getName()) + "-" + th.getMessage());
            sb.append("-");
            return false;
        }
    }

    private String aQ(String str) {
        return BdBaseApplication.getInst().getApp().getApplicationInfo().dataDir + File.separator + "lib" + File.separator + "lib" + str + PluginInstallerService.APK_LIB_SUFFIX;
    }

    private String aR(String str) {
        return BdBaseApplication.getInst().getApp().getApplicationInfo().dataDir + File.separator + "files" + File.separator + "lib" + str + PluginInstallerService.APK_LIB_SUFFIX;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [220=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, String str2, StringBuilder sb) {
        ZipInputStream zipInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ZipInputStream zipInputStream2 = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        zipInputStream2 = null;
        zipInputStream2 = null;
        boolean z = false;
        ArrayList arrayList = new ArrayList();
        arrayList.add("lib" + File.separator + "x86" + File.separator + "lib" + str2 + PluginInstallerService.APK_LIB_SUFFIX);
        arrayList.add("lib" + File.separator + "mips" + File.separator + "lib" + str2 + PluginInstallerService.APK_LIB_SUFFIX);
        arrayList.add("lib" + File.separator + "armeabi" + File.separator + "lib" + str2 + PluginInstallerService.APK_LIB_SUFFIX);
        File file = new File(str);
        try {
            if (file.exists()) {
                try {
                    zipInputStream = new ZipInputStream(new FileInputStream(file));
                } catch (IOException e) {
                    e = e;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            break;
                        } else if (arrayList.contains(nextEntry.getName())) {
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                while (true) {
                                    try {
                                        int read = zipInputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream.write(bArr, 0, read);
                                    } catch (Exception e2) {
                                        com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
                                    } catch (Throwable th) {
                                        byteArrayOutputStream2 = byteArrayOutputStream;
                                        th = th;
                                        com.baidu.adp.lib.g.a.b(byteArrayOutputStream2);
                                        throw th;
                                    }
                                }
                                byteArrayOutputStream.flush();
                                String aR = aR(str2);
                                a(aR, byteArrayOutputStream.toByteArray(), sb);
                                if (b(aR, sb)) {
                                    sb.append("-Succ5-");
                                    z = true;
                                    com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
                                    break;
                                }
                                com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
                            } catch (Exception e3) {
                                byteArrayOutputStream = null;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                    }
                    com.baidu.adp.lib.g.a.d(zipInputStream);
                } catch (IOException e4) {
                    e = e4;
                    zipInputStream2 = zipInputStream;
                    sb.append("-Error5:");
                    sb.append(String.valueOf(e.getClass().getName()) + "-" + e.getMessage());
                    sb.append("-");
                    com.baidu.adp.lib.g.a.d(zipInputStream2);
                    return z;
                } catch (Throwable th3) {
                    th = th3;
                    zipInputStream2 = zipInputStream;
                    com.baidu.adp.lib.g.a.d(zipInputStream2);
                    throw th;
                }
            }
            return z;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, byte[] bArr, StringBuilder sb) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(new File(str));
            try {
                try {
                    fileOutputStream.write(bArr);
                    com.baidu.adp.lib.g.a.b(fileOutputStream);
                } catch (Exception e) {
                    e = e;
                    sb.append("-Error4:");
                    sb.append(String.valueOf(e.getClass().getName()) + "-" + e.getMessage());
                    sb.append("-");
                    com.baidu.adp.lib.g.a.b(fileOutputStream);
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.g.a.b(fileOutputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            com.baidu.adp.lib.g.a.b(fileOutputStream);
            throw th;
        }
    }
}
