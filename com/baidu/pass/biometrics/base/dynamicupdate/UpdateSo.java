package com.baidu.pass.biometrics.base.dynamicupdate;

import android.app.Application;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.pass.biometrics.base.PassBiometricConfiguration;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.dynamicupdate.SdkConfigOptions;
import com.baidu.pass.biometrics.base.http.BinaryHttpHandlerWrap;
import com.baidu.pass.biometrics.base.http.HttpClientWrap;
import com.baidu.pass.biometrics.base.http.HttpHandlerWrap;
import com.baidu.pass.biometrics.base.http.HttpHashMapWrap;
import com.baidu.pass.biometrics.base.utils.PassBioBaseUtil;
import com.baidu.pass.biometrics.base.utils.PassBioFileUtils;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.biometrics.base.utils.RSA;
import com.baidu.pass.biometrics.base.utils.thread.TPRunnable;
import com.baidu.pass.biometrics.base.utils.thread.ThreadPoolService;
import com.baidu.pass.common.SecurityUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class UpdateSo {
    public static String TAG = "UpdateSo";

    /* renamed from: a  reason: collision with root package name */
    private Application f3991a;

    /* renamed from: b  reason: collision with root package name */
    private StatService f3992b;
    private CountDownLatch c;
    private SdkConfigOptions d;
    private SdkConfigOptions e;
    private PassBiometricConfiguration f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface LoadModuleEventListener {
        void onFailure(SdkConfigOptions.DistributedFile distributedFile);

        void onSuccess(SdkConfigOptions.DistributedFile distributedFile, byte[] bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class StatService {
        public static final String HOST_VERSION = "host_version";
        public static final String STAT_NAME_LIVENESS_FACE = "sapi_bio_dynamic_update_so";
        public static final String ZIP_VERSION = "zip_version";

        /* renamed from: a  reason: collision with root package name */
        private static final String f3999a = "get_config_success";

        /* renamed from: b  reason: collision with root package name */
        private static final String f4000b = "download_zip_file_success";
        private static final String c = "need_update";
        private static final String d = "update_from_net";
        private static final String e = "exception_info";
        private static final String f = "meet_gray";
        private static final String g = "zip_enable";
        private static final String h = "sdk_version_enable";
        private String i;
        private boolean j;
        private boolean k;
        private boolean l;
        private boolean m;
        private boolean n;
        private String o;
        private boolean p;
        private boolean q;

        private StatService() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            com.baidu.pass.biometrics.base.utils.StatService.onEvent(UpdateSo.this.f3991a, STAT_NAME_LIVENESS_FACE, a());
        }

        private Map<String, String> a() {
            HashMap hashMap = new HashMap();
            hashMap.put("host_version", SdkConfigOptions.HOST_VERSION);
            hashMap.put("zip_version", this.i);
            hashMap.put(f3999a, this.j ? "1" : "-1");
            if (this.j) {
                hashMap.put(g, this.p ? "1" : "-1");
                hashMap.put(c, this.l ? "1" : "-1");
            }
            if (this.p) {
                hashMap.put(f, this.m ? "1" : "-1");
            }
            if (this.l) {
                hashMap.put(d, this.n ? "1" : "-1");
                hashMap.put(f4000b, this.k ? "1" : "-1");
            }
            boolean z = this.q;
            if (z) {
                hashMap.put(h, z ? "1" : "-1");
            }
            hashMap.put(e, this.o);
            return hashMap;
        }
    }

    public void checkSoUpdate(PassBiometricConfiguration passBiometricConfiguration) {
        this.f = passBiometricConfiguration;
        this.f3991a = passBiometricConfiguration.getApplication();
        CheckDefaultSoExist.isExist(this.f3991a);
        this.f3992b = new StatService();
        this.c = new CountDownLatch(1);
        ThreadPoolService.getInstance().run(new TPRunnable(new Runnable() { // from class: com.baidu.pass.biometrics.base.dynamicupdate.UpdateSo.1
            @Override // java.lang.Runnable
            public void run() {
                UpdateSo.this.a();
                try {
                    UpdateSo.this.c.await();
                    String str = UpdateSo.TAG;
                    Object[] objArr = new Object[1];
                    objArr[0] = "begin stat service";
                    Log.i(str, objArr);
                    UpdateSo.this.f3992b.b();
                } catch (InterruptedException e) {
                    Log.e(UpdateSo.TAG, e);
                }
            }
        }));
    }

    private void c(SdkConfigOptions sdkConfigOptions) {
        if (sdkConfigOptions.distributedSdk == null) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            sdkConfigOptions.grayThreshold = random.nextInt(100);
            LocalConfigOptions.getInstance(this.f3991a).setBioOptions(sdkConfigOptions);
        }
        Log.i(TAG, "current gray = " + sdkConfigOptions.grayThreshold);
    }

    private void b(final SdkConfigOptions sdkConfigOptions) {
        a(sdkConfigOptions.distributedSdk, new LoadModuleEventListener() { // from class: com.baidu.pass.biometrics.base.dynamicupdate.UpdateSo.3
            @Override // com.baidu.pass.biometrics.base.dynamicupdate.UpdateSo.LoadModuleEventListener
            public void onFailure(SdkConfigOptions.DistributedFile distributedFile) {
                UpdateSo.this.a(sdkConfigOptions);
            }

            @Override // com.baidu.pass.biometrics.base.dynamicupdate.UpdateSo.LoadModuleEventListener
            public void onSuccess(SdkConfigOptions.DistributedFile distributedFile, byte[] bArr) {
                UpdateSo updateSo = UpdateSo.this;
                boolean b2 = updateSo.b(LocalConfigOptions.getInternalZipPath(updateSo.f3991a, sdkConfigOptions.zipVersion), bArr);
                if (b2) {
                    UpdateSo.this.f3992b.n = false;
                    UpdateSo updateSo2 = UpdateSo.this;
                    updateSo2.a(LocalConfigOptions.getInternalZipPath(updateSo2.f3991a, sdkConfigOptions.zipVersion), LocalConfigOptions.getInternalRootPath(UpdateSo.this.f3991a));
                    sdkConfigOptions.updateFail = false;
                    LocalConfigOptions.getInstance(UpdateSo.this.f3991a).setBioOptions(sdkConfigOptions);
                } else {
                    UpdateSo.this.a(sdkConfigOptions);
                }
                Log.e(UpdateSo.TAG, "loadFileFromExternal writeFileSuccess:" + b2);
            }
        }, LocalConfigOptions.getExternalZipPath(sdkConfigOptions.zipVersion));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("appid", this.f.appId);
        httpHashMapWrap.put("tpl", this.f.tpl);
        new HttpClientWrap(this.f3991a).get("https://wappass.bdimg.com/static/appsapi/appdistribute/android.txt", httpHashMapWrap, null, new HttpHandlerWrap(true) { // from class: com.baidu.pass.biometrics.base.dynamicupdate.UpdateSo.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str) {
                SdkConfigOptions bioOptions = LocalConfigOptions.getInstance(UpdateSo.this.f3991a).getBioOptions();
                bioOptions.updateFail = true;
                LocalConfigOptions.getInstance(UpdateSo.this.f3991a).setBioOptions(bioOptions);
                UpdateSo.this.f3992b.j = false;
                UpdateSo.this.f3992b.o = android.util.Log.getStackTraceString(th);
                UpdateSo.this.c.countDown();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
            public void onSuccess(int i, String str) {
                UpdateSo.this.a(str);
            }
        });
    }

    private byte[] b(String str) throws IOException {
        return a(new FileInputStream(new File(str)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str, byte[] bArr) {
        if (PassBioFileUtils.isFileExist(str)) {
            PassBioFileUtils.deleteFile(str);
        }
        File file = new File(str);
        try {
            return PassBioFileUtils.checkAndCreadFile(file) && PassBioFileUtils.write(file, bArr);
        } catch (IOException e) {
            Log.e(TAG, e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] c(String str) {
        try {
            return a(new FileInputStream(new File(str)));
        } catch (IOException e) {
            Log.e(TAG, e);
            return new byte[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            this.d = SdkConfigOptions.fromOnLineJSON(new JSONObject(str));
            this.e = LocalConfigOptions.getInstance(this.f3991a).getBioOptions();
            String str2 = TAG;
            Object[] objArr = new Object[1];
            objArr[0] = "asyncDistributeConf() newOptions:" + this.d.toJSON();
            Log.e(str2, objArr);
            String str3 = TAG;
            Object[] objArr2 = new Object[1];
            objArr2[0] = "asyncDistributeConf() oldOptions:" + this.e.toJSON();
            Log.e(str3, objArr2);
            if (!PassBioBaseUtil.listValueEqual(this.d.livenessConfigOption.illumList, this.e.livenessConfigOption.illumList)) {
                LocalConfigOptions.getInstance(this.f3991a).setIllumValueGray(-1);
            }
            this.e.globalEnable = this.d.globalEnable;
            this.e.enable = this.d.enable;
            this.e.livenessConfigOption = this.d.livenessConfigOption;
            LocalConfigOptions.getInstance(this.f3991a).setBioOptions(this.e);
            this.f3992b.j = true;
            this.f3992b.i = this.d.zipVersion;
            if (Build.VERSION.SDK_INT <= 19) {
                this.e.updateFail = true;
                this.f3992b.q = true;
                this.c.countDown();
                LocalConfigOptions.getInstance(this.f3991a).setBioOptions(this.e);
            } else if (!this.d.globalEnable || !this.d.enable) {
                this.f3992b.p = false;
                this.f3992b.l = false;
                this.c.countDown();
                this.e.updateFail = true;
                LocalConfigOptions.getInstance(this.f3991a).setBioOptions(this.e);
            } else {
                this.f3992b.p = true;
                c(this.e);
                int i = this.d.grayThreshold;
                this.d.grayThreshold = this.e.grayThreshold;
                if (!a(i, this.e)) {
                    this.f3992b.m = false;
                    this.f3992b.l = false;
                    this.c.countDown();
                    this.e.updateFail = true;
                    LocalConfigOptions.getInstance(this.f3991a).setBioOptions(this.e);
                    return;
                }
                this.f3992b.m = true;
                if (SdkConfigOptions.HOST_VERSION.compareTo(this.d.zipVersion) > 0) {
                    this.f3992b.l = false;
                    this.c.countDown();
                    this.e.updateFail = true;
                    LocalConfigOptions.getInstance(this.f3991a).setBioOptions(this.e);
                } else if (a(this.d.distributedSdk, this.e.distributedSdk)) {
                    b(this.d);
                    this.f3992b.l = true;
                } else {
                    a(this.d.distributedSdk);
                    this.f3992b.l = false;
                    this.c.countDown();
                }
            }
        } catch (JSONException e) {
            Log.e(TAG, e);
        }
    }

    private boolean a(int i, SdkConfigOptions sdkConfigOptions) {
        return 100 == this.d.grayThreshold || sdkConfigOptions.grayThreshold < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SdkConfigOptions sdkConfigOptions) {
        this.f3992b.n = true;
        Log.e(TAG, "loadFileFromExternal onFailure distributedSdk uri:" + sdkConfigOptions.distributedSdk.downloadUrl);
        new HttpClientWrap(this.f3991a).get(sdkConfigOptions.distributedSdk.downloadUrl, new BinaryHttpHandlerWrap(true, new String[]{"application/octet-stream", "*/*", "application/apk", "application/vnd.android.package-archive", "application/zip"}) { // from class: com.baidu.pass.biometrics.base.dynamicupdate.UpdateSo.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str) {
                Log.e(UpdateSo.TAG, "distributeFileDownload() onFailure" + th.toString());
                UpdateSo.this.e.updateFail = true;
                LocalConfigOptions.getInstance(UpdateSo.this.f3991a).setBioOptions(UpdateSo.this.e);
                UpdateSo.this.f3992b.k = false;
                UpdateSo.this.f3992b.o = android.util.Log.getStackTraceString(th);
                UpdateSo.this.c.countDown();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.pass.biometrics.base.http.BinaryHttpHandlerWrap
            public void onSuccess(int i, byte[] bArr) {
                UpdateSo.this.a(bArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr) {
        try {
            String str = TAG;
            Object[] objArr = new Object[1];
            objArr[0] = "distributeFileDownload() onSuccess" + this.d.distributedSdk.downloadUrl + ",:" + LocalConfigOptions.getInternalZipPath(this.f3991a, this.d.zipVersion);
            Log.e(str, objArr);
            String md5 = SecurityUtil.md5(bArr, false);
            String decrypt = RSA.decrypt(this.d.distributedSdk.hash);
            if (decrypt != null && decrypt.equals(md5)) {
                if (b(LocalConfigOptions.getInternalZipPath(this.f3991a, this.d.zipVersion), bArr)) {
                    a(LocalConfigOptions.getInternalZipPath(this.f3991a, this.d.zipVersion), LocalConfigOptions.getInternalRootPath(this.f3991a));
                    this.d.updateFail = false;
                    LocalConfigOptions.getInstance(this.f3991a).setBioOptions(this.d);
                } else {
                    this.e.updateFail = true;
                    LocalConfigOptions.getInstance(this.f3991a).setBioOptions(this.e);
                    this.f3992b.k = false;
                    this.f3992b.o = "zip file write internal fail";
                    this.c.countDown();
                }
                if (PassBiometricUtil.checkRequestPermission(this.f3991a, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    String externalZipPath = LocalConfigOptions.getExternalZipPath(this.d.zipVersion);
                    if (PassBioFileUtils.isFileExist(externalZipPath)) {
                        PassBioFileUtils.deleteFile(externalZipPath);
                    }
                    a(externalZipPath, bArr);
                    return;
                }
                return;
            }
            this.e.updateFail = true;
            LocalConfigOptions.getInstance(this.f3991a).setBioOptions(this.e);
            this.f3992b.k = false;
            this.f3992b.o = "localMd5 is not equals onlineMd5";
            this.c.countDown();
        } catch (Exception e) {
            Log.e(TAG, "distributeFileDownload() Exception " + e.toString());
            this.e.updateFail = true;
            LocalConfigOptions.getInstance(this.f3991a).setBioOptions(this.e);
            this.f3992b.k = false;
            this.f3992b.o = android.util.Log.getStackTraceString(e);
            this.c.countDown();
        }
    }

    private void a(SdkConfigOptions.DistributedFile distributedFile) {
        a(distributedFile, new LoadModuleEventListener() { // from class: com.baidu.pass.biometrics.base.dynamicupdate.UpdateSo.5
            @Override // com.baidu.pass.biometrics.base.dynamicupdate.UpdateSo.LoadModuleEventListener
            public void onFailure(SdkConfigOptions.DistributedFile distributedFile2) {
                String internalZipPath = LocalConfigOptions.getInternalZipPath(UpdateSo.this.f3991a, UpdateSo.this.d.zipVersion);
                String externalZipPath = LocalConfigOptions.getExternalZipPath(UpdateSo.this.d.zipVersion);
                Log.e(UpdateSo.TAG, "asyncDistributeConf(), loadFileFromExternal failure internalFile:" + internalZipPath);
                if (PassBioFileUtils.isFileExist(internalZipPath)) {
                    byte[] c = UpdateSo.this.c(internalZipPath);
                    if (PassBiometricUtil.checkRequestPermission(UpdateSo.this.f3991a, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                        if (PassBioFileUtils.isFileExist(externalZipPath)) {
                            PassBioFileUtils.deleteFile(externalZipPath);
                        }
                        UpdateSo.this.a(externalZipPath, c);
                    }
                }
            }

            @Override // com.baidu.pass.biometrics.base.dynamicupdate.UpdateSo.LoadModuleEventListener
            public void onSuccess(SdkConfigOptions.DistributedFile distributedFile2, byte[] bArr) {
                Log.e(UpdateSo.TAG, "copyInternalFileToExternal(), loadFileFromExternal distributed success");
            }
        }, LocalConfigOptions.getExternalZipPath(this.d.zipVersion));
    }

    private void a(SdkConfigOptions.DistributedFile distributedFile, LoadModuleEventListener loadModuleEventListener, String str) {
        if (loadModuleEventListener != null) {
            try {
                if ("mounted".equals(Environment.getExternalStorageState()) && new File(str).exists()) {
                    byte[] b2 = b(str);
                    String md5 = SecurityUtil.md5(b2, false);
                    String decrypt = RSA.decrypt(distributedFile.hash);
                    String str2 = TAG;
                    Object[] objArr = new Object[1];
                    objArr[0] = "loadFileFromExternal() localMd5:" + md5 + ",onlineMd5" + decrypt;
                    Log.e(str2, objArr);
                    if (decrypt != null && decrypt.equals(md5)) {
                        loadModuleEventListener.onSuccess(distributedFile, b2);
                    } else {
                        loadModuleEventListener.onFailure(distributedFile);
                    }
                } else {
                    loadModuleEventListener.onFailure(distributedFile);
                }
                return;
            } catch (Throwable th) {
                Log.e(TAG, "loadFileFromExternal() Throwable" + th.toString());
                loadModuleEventListener.onFailure(distributedFile);
                return;
            }
        }
        throw new IllegalArgumentException(LoadModuleEventListener.class.getName() + "can't be null");
    }

    private byte[] a(InputStream inputStream) throws IOException {
        try {
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            return bArr;
        } finally {
            inputStream.close();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [125=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    File file = new File(str);
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(bArr);
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream2 = fileOutputStream;
                        try {
                            Log.e(TAG, th);
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                            return;
                        } catch (Throwable th2) {
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (Throwable th3) {
                                    Log.e(TAG, th3);
                                }
                            }
                            throw th2;
                        }
                    }
                } else {
                    fileOutputStream = null;
                }
            } catch (Throwable th4) {
                Log.e(TAG, th4);
                return;
            }
        } catch (Throwable th5) {
            th = th5;
        }
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
    }

    private boolean a(SdkConfigOptions.DistributedFile distributedFile, SdkConfigOptions.DistributedFile distributedFile2) {
        return distributedFile2 == null || distributedFile == null || TextUtils.isEmpty(distributedFile2.hash) || !distributedFile.hash.equals(distributedFile2.hash);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [165=4, 172=4] */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:88:0x019f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, String str2) {
        Throwable th;
        Exception e;
        BufferedOutputStream bufferedOutputStream;
        byte[] bArr;
        String name;
        ZipInputStream zipInputStream = null;
        this.f3992b.k = true;
        this.c.countDown();
        Log.i(TAG, "thread name unZipApkSoToLibDir = " + Thread.currentThread().getName());
        Log.d(TAG, "unZipApkSoToLibDir(), zipFilePath:" + str + ",libDir:" + str2);
        try {
            try {
                ZipInputStream zipInputStream2 = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
                BufferedOutputStream bufferedOutputStream2 = null;
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream2.getNextEntry();
                        if (nextEntry == null) {
                            break;
                        }
                        try {
                            bArr = new byte[4096];
                            name = nextEntry.getName();
                            String str3 = TAG;
                            Object[] objArr = new Object[1];
                            objArr[0] = "unZipApkSoToLibDir() entryName," + name;
                            Log.e(str3, objArr);
                        } catch (Exception e2) {
                            e = e2;
                            bufferedOutputStream = bufferedOutputStream2;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        if (name.endsWith(PluginInstallerService.APK_LIB_SUFFIX)) {
                            String str4 = name.substring(name.lastIndexOf("/") + 1, name.lastIndexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) + PluginInstallerService.APK_LIB_SUFFIX;
                            String str5 = TAG;
                            Object[] objArr2 = new Object[1];
                            objArr2[0] = "unZipApkSoToLibDir(),fileName2:" + str4;
                            Log.d(str5, objArr2);
                            File file = new File(str2 + File.separator + str4);
                            if (file.exists()) {
                                file.delete();
                            }
                            File file2 = new File(file.getParent());
                            String str6 = TAG;
                            Object[] objArr3 = new Object[1];
                            objArr3[0] = "unZipApkSoToLibDir()entryFile" + file.toString() + "entryDir" + file2.toString();
                            Log.d(str6, objArr3);
                            if (!file2.exists()) {
                                String str7 = TAG;
                                Object[] objArr4 = new Object[1];
                                objArr4[0] = "unZipApkSoToLibDir() not exists";
                                Log.d(str7, objArr4);
                                file2.mkdirs();
                            }
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 4096);
                            while (true) {
                                try {
                                    try {
                                        int read = zipInputStream2.read(bArr, 0, 4096);
                                        if (read == -1) {
                                            break;
                                        }
                                        bufferedOutputStream.write(bArr, 0, read);
                                    } catch (Exception e3) {
                                        e = e3;
                                        e.printStackTrace();
                                        if (bufferedOutputStream != null) {
                                            bufferedOutputStream.close();
                                        }
                                        bufferedOutputStream2 = bufferedOutputStream;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    bufferedOutputStream2 = bufferedOutputStream;
                                    if (bufferedOutputStream2 != null) {
                                        bufferedOutputStream2.close();
                                    }
                                    throw th;
                                }
                            }
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                            bufferedOutputStream2 = bufferedOutputStream;
                        } else if (bufferedOutputStream2 != null) {
                            bufferedOutputStream2.close();
                        }
                    } catch (Exception e4) {
                        e = e4;
                        zipInputStream = zipInputStream2;
                        try {
                            Log.e(TAG, e);
                            if (zipInputStream != null) {
                                zipInputStream.close();
                            }
                            return;
                        } catch (Throwable th4) {
                            th = th4;
                            if (zipInputStream != null) {
                                try {
                                    zipInputStream.close();
                                } catch (IOException e5) {
                                    Log.e(TAG, e5);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        zipInputStream = zipInputStream2;
                        if (zipInputStream != null) {
                        }
                        throw th;
                    }
                }
                zipInputStream2.close();
            } catch (IOException e6) {
                Log.e(TAG, e6);
            }
        } catch (Exception e7) {
            e = e7;
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
