package com.baidu.adp.lib.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.plugin.install.PluginInstallerService;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes.dex */
public class g {
    private static g ye = null;

    public static g iC() {
        g gVar;
        if (ye == null) {
            synchronized (g.class) {
                if (ye == null) {
                    ye = new g();
                }
                gVar = ye;
            }
            return gVar;
        }
        return ye;
    }

    public boolean a(String str, int i, h hVar) {
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
                String aP = aP(str);
                File file = new File(aP);
                if (file.exists()) {
                    if (file.length() > 0) {
                        boolean b = b(aP, sb);
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
                    a aVar = new a(str, aP, sb, hVar);
                    aVar.setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen()));
                    aVar.execute(new Object[0]);
                    return false;
                }
            }
            if (sb.length() > 0) {
                com.baidu.adp.lib.stats.a.hl().a("so", "load_" + str + PluginInstallerService.APK_LIB_SUFFIX, "", -9101, sb.toString(), new Object[0]);
            }
        }
        return z;
    }

    private boolean a(String str, StringBuilder sb) {
        boolean b = b(aO(str), sb);
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

    private String aO(String str) {
        return BdBaseApplication.getInst().getApp().getApplicationInfo().dataDir + File.separator + "lib" + File.separator + "lib" + str + PluginInstallerService.APK_LIB_SUFFIX;
    }

    private String aP(String str) {
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
                                        com.baidu.adp.lib.h.a.b((OutputStream) byteArrayOutputStream);
                                    } catch (Throwable th) {
                                        byteArrayOutputStream2 = byteArrayOutputStream;
                                        th = th;
                                        com.baidu.adp.lib.h.a.b((OutputStream) byteArrayOutputStream2);
                                        throw th;
                                    }
                                }
                                byteArrayOutputStream.flush();
                                String aP = aP(str2);
                                a(aP, byteArrayOutputStream.toByteArray(), sb);
                                if (b(aP, sb)) {
                                    sb.append("-Succ5-");
                                    z = true;
                                    com.baidu.adp.lib.h.a.b((OutputStream) byteArrayOutputStream);
                                    break;
                                }
                                com.baidu.adp.lib.h.a.b((OutputStream) byteArrayOutputStream);
                            } catch (Exception e3) {
                                byteArrayOutputStream = null;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                    }
                    com.baidu.adp.lib.h.a.e(zipInputStream);
                } catch (IOException e4) {
                    e = e4;
                    zipInputStream2 = zipInputStream;
                    sb.append("-Error5:");
                    sb.append(String.valueOf(e.getClass().getName()) + "-" + e.getMessage());
                    sb.append("-");
                    com.baidu.adp.lib.h.a.e(zipInputStream2);
                    return z;
                } catch (Throwable th3) {
                    th = th3;
                    zipInputStream2 = zipInputStream;
                    com.baidu.adp.lib.h.a.e(zipInputStream2);
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
                    com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream);
                } catch (Exception e) {
                    e = e;
                    sb.append("-Error4:");
                    sb.append(String.valueOf(e.getClass().getName()) + "-" + e.getMessage());
                    sb.append("-");
                    com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream);
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Object, Object> {
        String yf;
        String yg;
        StringBuilder yh;
        h yi;
        boolean yj = false;

        public a(String str, String str2, StringBuilder sb, h hVar) {
            this.yf = str;
            this.yg = str2;
            this.yh = sb;
            this.yi = hVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(Object... objArr) {
            this.yj = g.this.a(BdBaseApplication.getInst().getApp().getApplicationInfo().sourceDir, this.yf, this.yh);
            if (!this.yj) {
                g.this.a(this.yg, "".getBytes(), this.yh);
                return null;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            super.onPostExecute(obj);
            if (this.yh.length() > 0) {
                com.baidu.adp.lib.stats.a.hl().a("so", "load_" + this.yf + PluginInstallerService.APK_LIB_SUFFIX, "", -9101, this.yh.toString(), new Object[0]);
            }
            if (this.yi != null) {
                this.yi.l(this.yj);
            }
        }
    }
}
