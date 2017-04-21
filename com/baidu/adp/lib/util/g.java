package com.baidu.adp.lib.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.plugin.Plugin;
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
public class g {
    private static g yv = null;

    public static g gW() {
        g gVar;
        if (yv == null) {
            synchronized (g.class) {
                if (yv == null) {
                    yv = new g();
                }
                gVar = yv;
            }
            return gVar;
        }
        return yv;
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
                String az = az(str);
                File file = new File(az);
                if (file.exists()) {
                    if (file.length() > 0) {
                        boolean loadSoLibrary = loadSoLibrary(az, sb);
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
                    a aVar = new a(str, az, sb, hVar);
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

    /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
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
            String az = az(str);
            File file = new File(az);
            if (file.exists()) {
                if (file.length() > 0) {
                    boolean loadSoLibrary = loadSoLibrary(az, sb);
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
        boolean loadSoLibrary = loadSoLibrary(ay(str), sb);
        if (!loadSoLibrary) {
            try {
                System.loadLibrary(str);
                sb.append("-Succ3-");
                return true;
            } catch (Throwable th) {
                sb.append("-Error3:");
                sb.append(String.valueOf(th.getClass().getName()) + "-" + th.getMessage());
                sb.append("-");
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
            sb.append(String.valueOf(th.getClass().getName()) + "-" + th.getMessage());
            sb.append("-");
            return false;
        }
    }

    private String ay(String str) {
        return BdBaseApplication.getInst().getApp().getApplicationInfo().dataDir + File.separator + Plugin.SO_LIB_DIR_NAME + File.separator + Plugin.SO_LIB_DIR_NAME + str + PluginInstallerService.APK_LIB_SUFFIX;
    }

    private String az(String str) {
        return BdBaseApplication.getInst().getApp().getApplicationInfo().dataDir + File.separator + "files" + File.separator + Plugin.SO_LIB_DIR_NAME + str + PluginInstallerService.APK_LIB_SUFFIX;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [269=4] */
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
                                        com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
                                    } catch (Throwable th) {
                                        byteArrayOutputStream2 = byteArrayOutputStream;
                                        th = th;
                                        com.baidu.adp.lib.g.a.d(byteArrayOutputStream2);
                                        throw th;
                                    }
                                }
                                byteArrayOutputStream.flush();
                                String az = az(str2);
                                a(az, byteArrayOutputStream.toByteArray(), sb);
                                if (loadSoLibrary(az, sb)) {
                                    sb.append("-Succ5-");
                                    z = true;
                                    com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
                                    break;
                                }
                                com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
                            } catch (Exception e3) {
                                byteArrayOutputStream = null;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                    }
                    com.baidu.adp.lib.g.a.j(zipInputStream);
                } catch (IOException e4) {
                    e = e4;
                    zipInputStream2 = zipInputStream;
                    sb.append("-Error5:");
                    sb.append(String.valueOf(e.getClass().getName()) + "-" + e.getMessage());
                    sb.append("-");
                    com.baidu.adp.lib.g.a.j(zipInputStream2);
                    return z;
                } catch (Throwable th3) {
                    th = th3;
                    zipInputStream2 = zipInputStream;
                    com.baidu.adp.lib.g.a.j(zipInputStream2);
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
                    com.baidu.adp.lib.g.a.d(fileOutputStream);
                } catch (Exception e) {
                    e = e;
                    sb.append("-Error4:");
                    sb.append(String.valueOf(e.getClass().getName()) + "-" + e.getMessage());
                    sb.append("-");
                    com.baidu.adp.lib.g.a.d(fileOutputStream);
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.g.a.d(fileOutputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            com.baidu.adp.lib.g.a.d(fileOutputStream);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Object, Object> {
        boolean yA = false;
        String yw;
        String yx;
        StringBuilder yy;
        h yz;

        public a(String str, String str2, StringBuilder sb, h hVar) {
            this.yw = str;
            this.yx = str2;
            this.yy = sb;
            this.yz = hVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Object doInBackground(Object... objArr) {
            this.yA = g.this.a(BdBaseApplication.getInst().getApp().getApplicationInfo().sourceDir, this.yw, this.yy);
            if (!this.yA) {
                g.this.a(this.yx, "".getBytes(), this.yy);
                return null;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            super.onPostExecute(obj);
            if (this.yy.length() > 0) {
                BdStatisticsManager.getInstance().error("so", "load_" + this.yw + PluginInstallerService.APK_LIB_SUFFIX, "", -9101, this.yy.toString(), new Object[0]);
            }
            if (this.yz != null) {
                this.yz.p(this.yA);
            }
        }
    }
}
