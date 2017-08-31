package com.baidu.adp.lib.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.xiaomi.mipush.sdk.Constants;
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
    private static g xS = null;

    public static g gU() {
        g gVar;
        if (xS == null) {
            synchronized (g.class) {
                if (xS == null) {
                    xS = new g();
                }
                gVar = xS;
            }
            return gVar;
        }
        return xS;
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
                String aJ = aJ(str);
                File file = new File(aJ);
                if (file.exists()) {
                    if (file.length() > 0) {
                        boolean loadSoLibrary = loadSoLibrary(aJ, sb);
                        if (loadSoLibrary) {
                            sb.append("-Succ2-");
                            z = loadSoLibrary;
                        } else {
                            sb.append("-Error7-");
                            z = loadSoLibrary;
                        }
                    } else {
                        sb.append("-Error6:soSize1-");
                        z = z2;
                    }
                } else {
                    a aVar = new a(str, aJ, sb, hVar);
                    aVar.setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen()));
                    aVar.execute(new Object[0]);
                    return false;
                }
            }
            if (sb.length() > 0) {
                BdStatisticsManager.getInstance().error("so", "load_" + str + PluginInstallerService.APK_LIB_SUFFIX, "", -9101, sb.toString(), new Object[0]);
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean i(String str, int i) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        if (BdBaseApplication.getInst().getApp() == null || BdBaseApplication.getInst().getApp().getApplicationInfo() == null) {
            return false;
        }
        boolean z2 = false;
        for (int i2 = 0; i2 < i; i2++) {
            z2 = a(str, sb);
            if (z2) {
                break;
            }
        }
        if (!z2) {
            String aJ = aJ(str);
            File file = new File(aJ);
            if (file.exists()) {
                if (file.length() > 0) {
                    boolean loadSoLibrary = loadSoLibrary(aJ, sb);
                    if (loadSoLibrary) {
                        sb.append("-Succ2-");
                        z = loadSoLibrary;
                    } else {
                        sb.append("-Error7-");
                        z = loadSoLibrary;
                    }
                    if (sb.length() <= 0) {
                        BdStatisticsManager.getInstance().error("so", "load_" + str + PluginInstallerService.APK_LIB_SUFFIX, "", -9101, sb.toString(), new Object[0]);
                        return z;
                    }
                    return z;
                }
                sb.append("-Error6:soSize1-");
            }
        }
        z = z2;
        if (sb.length() <= 0) {
        }
    }

    private boolean a(String str, StringBuilder sb) {
        boolean loadSoLibrary = loadSoLibrary(aI(str), sb);
        if (!loadSoLibrary) {
            try {
                System.loadLibrary(str);
                sb.append("-Succ3-");
                return true;
            } catch (Throwable th) {
                sb.append("-Error3:");
                sb.append(th.getClass().getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + th.getMessage());
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                return loadSoLibrary;
            }
        }
        return loadSoLibrary;
    }

    private boolean loadSoLibrary(String str, StringBuilder sb) {
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
            sb.append(th.getClass().getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + th.getMessage());
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            return false;
        }
    }

    private String aI(String str) {
        return BdBaseApplication.getInst().getApp().getApplicationInfo().dataDir + File.separator + Plugin.SO_LIB_DIR_NAME + File.separator + Plugin.SO_LIB_DIR_NAME + str + PluginInstallerService.APK_LIB_SUFFIX;
    }

    private String aJ(String str) {
        return BdBaseApplication.getInst().getApp().getApplicationInfo().dataDir + File.separator + "files" + File.separator + Plugin.SO_LIB_DIR_NAME + str + PluginInstallerService.APK_LIB_SUFFIX;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [269=5, 282=4] */
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
        arrayList.add(Plugin.SO_LIB_DIR_NAME + File.separator + "x86" + File.separator + Plugin.SO_LIB_DIR_NAME + str2 + PluginInstallerService.APK_LIB_SUFFIX);
        arrayList.add(Plugin.SO_LIB_DIR_NAME + File.separator + "mips" + File.separator + Plugin.SO_LIB_DIR_NAME + str2 + PluginInstallerService.APK_LIB_SUFFIX);
        arrayList.add(Plugin.SO_LIB_DIR_NAME + File.separator + "armeabi" + File.separator + Plugin.SO_LIB_DIR_NAME + str2 + PluginInstallerService.APK_LIB_SUFFIX);
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
                                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                                    } catch (Throwable th) {
                                        byteArrayOutputStream2 = byteArrayOutputStream;
                                        th = th;
                                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                                        throw th;
                                    }
                                }
                                byteArrayOutputStream.flush();
                                String aJ = aJ(str2);
                                a(aJ, byteArrayOutputStream.toByteArray(), sb);
                                if (loadSoLibrary(aJ, sb)) {
                                    sb.append("-Succ5-");
                                    z = true;
                                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                                    break;
                                }
                                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
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
                    sb.append(e.getClass().getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
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
            try {
                fileOutputStream = new FileOutputStream(new File(str));
                try {
                    fileOutputStream.write(bArr);
                    com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                } catch (Exception e) {
                    e = e;
                    sb.append("-Error4:");
                    sb.append(e.getClass().getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
            throw th;
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Object, Object, Object> {
        String xT;
        String xU;
        StringBuilder xV;
        h xW;
        boolean xX = false;

        public a(String str, String str2, StringBuilder sb, h hVar) {
            this.xT = str;
            this.xU = str2;
            this.xV = sb;
            this.xW = hVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object... objArr) {
            this.xX = g.this.a(BdBaseApplication.getInst().getApp().getApplicationInfo().sourceDir, this.xT, this.xV);
            if (!this.xX) {
                g.this.a(this.xU, "".getBytes(), this.xV);
                return null;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected void onPostExecute(Object obj) {
            super.onPostExecute(obj);
            if (this.xV.length() > 0) {
                BdStatisticsManager.getInstance().error("so", "load_" + this.xT + PluginInstallerService.APK_LIB_SUFFIX, "", -9101, this.xV.toString(), new Object[0]);
            }
            if (this.xW != null) {
                this.xW.p(this.xX);
            }
        }
    }
}
