package com.baidu.adp.lib.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.android.util.devices.IDevices;
import com.baidu.live.adp.lib.util.BdErrorInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes.dex */
public class h {
    private static h Pk = null;

    public static h oj() {
        h hVar;
        if (Pk == null) {
            synchronized (h.class) {
                if (Pk == null) {
                    Pk = new h();
                }
                hVar = Pk;
            }
            return hVar;
        }
        return Pk;
    }

    public boolean a(String str, int i, i iVar) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        if (BdBaseApplication.getInst().getApp() == null || BdBaseApplication.getInst().getApp().getApplicationInfo() == null) {
            z = false;
        } else {
            boolean z2 = false;
            for (int i2 = 0; i2 < i; i2++) {
                z2 = loadLibrary(str, sb);
                if (z2) {
                    break;
                }
            }
            if (z2) {
                z = z2;
            } else {
                String newLibFile = getNewLibFile(str);
                File file = new File(newLibFile);
                if (file.exists()) {
                    if (file.length() > 0) {
                        boolean loadSoLibrary = loadSoLibrary(newLibFile, sb);
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
                    a aVar = new a(str, newLibFile, sb, iVar);
                    aVar.setParallel(new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen()));
                    aVar.execute(new Object[0]);
                    return false;
                }
            }
            if (sb.length() > 0) {
                BdStatisticsManager.getInstance().error("so", "load_" + str + PluginInstallerService.APK_LIB_SUFFIX, "", BdErrorInfo.ERR_SO_LOAD, sb.toString(), new Object[0]);
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean loadLibrary(String str, int i) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        if (BdBaseApplication.getInst().getApp() == null || BdBaseApplication.getInst().getApp().getApplicationInfo() == null) {
            return false;
        }
        boolean z2 = false;
        for (int i2 = 0; i2 < i; i2++) {
            z2 = loadLibrary(str, sb);
            if (z2) {
                break;
            }
        }
        if (!z2) {
            String newLibFile = getNewLibFile(str);
            File file = new File(newLibFile);
            if (file.exists()) {
                if (file.length() > 0) {
                    boolean loadSoLibrary = loadSoLibrary(newLibFile, sb);
                    if (loadSoLibrary) {
                        sb.append("-Succ2-");
                        z = loadSoLibrary;
                    } else {
                        sb.append("-Error7-");
                        z = loadSoLibrary;
                    }
                    if (sb.length() <= 0) {
                        BdStatisticsManager.getInstance().error("so", "load_" + str + PluginInstallerService.APK_LIB_SUFFIX, "", BdErrorInfo.ERR_SO_LOAD, sb.toString(), new Object[0]);
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

    public boolean ci(String str) {
        boolean z;
        boolean z2;
        StringBuilder sb = new StringBuilder();
        if (BdBaseApplication.getInst().getApp() == null || BdBaseApplication.getInst().getApp().getApplicationInfo() == null) {
            return false;
        }
        boolean loadLibrary = loadLibrary(str, sb);
        if (loadLibrary) {
            return loadLibrary;
        }
        BdStatisticsManager.getInstance().error("so", 0L, (String) null, "try", "2", "exception", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        if (!a(str, sb2)) {
            z = loadLibrary;
            z2 = true;
        } else {
            boolean loadSoLibrary = loadSoLibrary(getNewLibFile(str), sb2);
            if (loadSoLibrary) {
                z2 = false;
                z = loadSoLibrary;
            } else {
                new File(getNewLibFile(str)).delete();
                z2 = true;
                z = loadSoLibrary;
            }
        }
        BdStatisticsManager.getInstance().error("so", 0L, (String) null, "try", "3", "exception", sb2.toString(), "copyfile", Boolean.valueOf(z2));
        if (z2) {
            StringBuilder sb3 = new StringBuilder();
            boolean loadFromApk = loadFromApk(BdBaseApplication.getInst().getApp().getApplicationInfo().sourceDir, str, sb3);
            BdStatisticsManager.getInstance().error("so", 0L, (String) null, "try", "4", "exception", sb3.toString());
            return loadFromApk;
        }
        return z;
    }

    private boolean a(String str, StringBuilder sb) {
        String libFile = getLibFile(str);
        File file = new File(getNewLibFile(str));
        if (!file.exists()) {
            sb.append("false_file_null");
            return false;
        }
        File file2 = new File(libFile);
        if (!file2.exists()) {
            sb.append("true_lib_null");
            return true;
        }
        String fileMd5 = getFileMd5(file);
        if (fileMd5 != null && fileMd5.equals(getFileMd5(file2))) {
            sb.append("true_md5_equals");
            return true;
        }
        sb.append("false_md5_not_equals");
        file.delete();
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [241=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x0061 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [long] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v2 */
    private String getFileMd5(File file) {
        FileInputStream fileInputStream;
        if (file != null && file.exists()) {
            ?? length = file.length();
            try {
                if (length > 0) {
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            String md5 = s.toMd5(fileInputStream);
                            if (!StringUtils.isNull(md5)) {
                                md5 = md5.toLowerCase();
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                    return md5;
                                } catch (IOException e) {
                                    BdLog.d(e.getMessage());
                                    return md5;
                                }
                            }
                            return md5;
                        } catch (Exception e2) {
                            e = e2;
                            BdLog.d(e.getMessage());
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e3) {
                                    BdLog.d(e3.getMessage());
                                }
                            }
                            return null;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        fileInputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        length = 0;
                        if (length != 0) {
                            try {
                                length.close();
                            } catch (IOException e5) {
                                BdLog.d(e5.getMessage());
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    private boolean loadLibrary(String str, StringBuilder sb) {
        boolean loadSoLibrary = loadSoLibrary(getLibFile(str), sb);
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

    private String getLibFile(String str) {
        return BdBaseApplication.getInst().getApp().getApplicationInfo().dataDir + File.separator + "lib" + File.separator + "lib" + str + PluginInstallerService.APK_LIB_SUFFIX;
    }

    private String getNewLibFile(String str) {
        return BdBaseApplication.getInst().getApp().getApplicationInfo().dataDir + File.separator + com.baidu.fsg.face.base.b.c.g + File.separator + "lib" + str + PluginInstallerService.APK_LIB_SUFFIX;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [370=5, 383=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public boolean loadFromApk(String str, String str2, StringBuilder sb) {
        ZipInputStream zipInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ZipInputStream zipInputStream2 = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        zipInputStream2 = null;
        zipInputStream2 = null;
        boolean z = false;
        ArrayList arrayList = new ArrayList();
        arrayList.add("lib" + File.separator + "x86" + File.separator + "lib" + str2 + PluginInstallerService.APK_LIB_SUFFIX);
        arrayList.add("lib" + File.separator + IDevices.ABI_MIPS + File.separator + "lib" + str2 + PluginInstallerService.APK_LIB_SUFFIX);
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
                                        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                                    } catch (Throwable th) {
                                        byteArrayOutputStream2 = byteArrayOutputStream;
                                        th = th;
                                        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream2);
                                        throw th;
                                    }
                                }
                                byteArrayOutputStream.flush();
                                String newLibFile = getNewLibFile(str2);
                                createLibFile(newLibFile, byteArrayOutputStream.toByteArray(), sb);
                                if (loadSoLibrary(newLibFile, sb)) {
                                    sb.append("-Succ5-");
                                    z = true;
                                    com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                                    break;
                                }
                                com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                            } catch (Exception e3) {
                                byteArrayOutputStream = null;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                    }
                    com.baidu.adp.lib.f.a.close((InputStream) zipInputStream);
                } catch (IOException e4) {
                    e = e4;
                    zipInputStream2 = zipInputStream;
                    sb.append("-Error5:");
                    sb.append(e.getClass().getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    com.baidu.adp.lib.f.a.close((InputStream) zipInputStream2);
                    return z;
                } catch (Throwable th3) {
                    th = th3;
                    zipInputStream2 = zipInputStream;
                    com.baidu.adp.lib.f.a.close((InputStream) zipInputStream2);
                    throw th;
                }
            }
            return z;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createLibFile(String str, byte[] bArr, StringBuilder sb) {
        FileOutputStream fileOutputStream;
        try {
            try {
                fileOutputStream = new FileOutputStream(new File(str));
                try {
                    fileOutputStream.write(bArr);
                    com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream);
                } catch (Exception e) {
                    e = e;
                    sb.append("-Error4:");
                    sb.append(e.getClass().getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage());
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream);
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream);
            throw th;
        }
    }

    /* loaded from: classes.dex */
    private class a extends BdAsyncTask<Object, Object, Object> {
        i Pl;
        String mLibName;
        boolean mLoadSuccess = false;
        StringBuilder mLogContent;
        String mNewFileName;

        public a(String str, String str2, StringBuilder sb, i iVar) {
            this.mLibName = str;
            this.mNewFileName = str2;
            this.mLogContent = sb;
            this.Pl = iVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected Object doInBackground(Object... objArr) {
            this.mLoadSuccess = h.this.loadFromApk(BdBaseApplication.getInst().getApp().getApplicationInfo().sourceDir, this.mLibName, this.mLogContent);
            if (!this.mLoadSuccess) {
                h.this.createLibFile(this.mNewFileName, "".getBytes(), this.mLogContent);
                return null;
            }
            return null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        protected void onPostExecute(Object obj) {
            super.onPostExecute(obj);
            if (this.mLogContent.length() > 0) {
                BdStatisticsManager.getInstance().error("so", "load_" + this.mLibName + PluginInstallerService.APK_LIB_SUFFIX, "", BdErrorInfo.ERR_SO_LOAD, this.mLogContent.toString(), new Object[0]);
            }
            if (this.Pl != null) {
                this.Pl.callback(this.mLoadSuccess);
            }
        }
    }
}
