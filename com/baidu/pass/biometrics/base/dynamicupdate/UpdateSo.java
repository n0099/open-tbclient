package com.baidu.pass.biometrics.base.dynamicupdate;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.android.common.security.MD5Util;
import com.baidu.pass.biometrics.base.PassBiometricConfiguration;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.dynamicupdate.SdkConfigOptions;
import com.baidu.pass.biometrics.base.http.BinaryHttpHandlerWrap;
import com.baidu.pass.biometrics.base.http.HttpClientWrap;
import com.baidu.pass.biometrics.base.http.HttpHandlerWrap;
import com.baidu.pass.biometrics.base.http.HttpHashMapWrap;
import com.baidu.pass.biometrics.base.utils.PassBioFileUtils;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.biometrics.base.utils.RSA;
import com.baidu.pass.biometrics.base.utils.thread.TPRunnable;
import com.baidu.pass.biometrics.base.utils.thread.ThreadPoolService;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
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
/* loaded from: classes2.dex */
public class UpdateSo {
    public static String TAG = "UpdateSo";
    private Application application;
    private PassBiometricConfiguration configuration;
    private SdkConfigOptions newOptions;
    private SdkConfigOptions oldOptions;
    private StatService statService;
    private CountDownLatch statServiceCountDownLatch;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface LoadModuleEventListener {
        void onFailure(SdkConfigOptions.DistributedFile distributedFile);

        void onSuccess(SdkConfigOptions.DistributedFile distributedFile, byte[] bArr);
    }

    public void checkSoUpdate(PassBiometricConfiguration passBiometricConfiguration) {
        this.configuration = passBiometricConfiguration;
        this.application = passBiometricConfiguration.getApplication();
        CheckDefaultSoExist.isExist(this.application);
        this.statService = new StatService();
        this.statServiceCountDownLatch = new CountDownLatch(1);
        ThreadPoolService.getInstance().runImport(new TPRunnable(new Runnable() { // from class: com.baidu.pass.biometrics.base.dynamicupdate.UpdateSo.1
            @Override // java.lang.Runnable
            public void run() {
                UpdateSo.this.getHostConfig();
                try {
                    UpdateSo.this.statServiceCountDownLatch.await();
                    Log.i(UpdateSo.TAG, "begin stat service");
                    UpdateSo.this.statService.startStatService();
                } catch (InterruptedException e) {
                    Log.e(UpdateSo.TAG, e);
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getHostConfig() {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("appid", this.configuration.appId);
        httpHashMapWrap.put("tpl", this.configuration.tpl);
        new HttpClientWrap(this.application).get("https://gss0.bdstatic.com/6bMWfDe8BsgCpNKfpU_Y_D3/static/appsapi/appdistribute/android.txt", httpHashMapWrap, null, new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.pass.biometrics.base.dynamicupdate.UpdateSo.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
            public void onSuccess(int i, String str) {
                UpdateSo.this.loadConfigSuccess(str);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
            public void onFailure(Throwable th, String str) {
                SdkConfigOptions bioOptions = LocalConfigOptions.getInstance(UpdateSo.this.application).getBioOptions();
                bioOptions.updateFail = true;
                LocalConfigOptions.getInstance(UpdateSo.this.application).setBioOptions(bioOptions);
                UpdateSo.this.statService.getConfigSuccess = false;
                UpdateSo.this.statService.exceptionInfo = android.util.Log.getStackTraceString(th);
                UpdateSo.this.statServiceCountDownLatch.countDown();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadConfigSuccess(final String str) {
        ThreadPoolService.getInstance().runImport(new TPRunnable(new Runnable() { // from class: com.baidu.pass.biometrics.base.dynamicupdate.UpdateSo.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UpdateSo.this.newOptions = SdkConfigOptions.fromOnLineJSON(new JSONObject(str));
                    UpdateSo.this.oldOptions = LocalConfigOptions.getInstance(UpdateSo.this.application).getBioOptions();
                    Log.e(UpdateSo.TAG, "asyncDistributeConf() newOptions:" + UpdateSo.this.newOptions.toJSON());
                    Log.e(UpdateSo.TAG, "asyncDistributeConf() oldOptions:" + UpdateSo.this.oldOptions.toJSON());
                    UpdateSo.this.oldOptions.globalEnable = UpdateSo.this.newOptions.globalEnable;
                    UpdateSo.this.oldOptions.enable = UpdateSo.this.newOptions.enable;
                    UpdateSo.this.oldOptions.livenessConfigOption = UpdateSo.this.newOptions.livenessConfigOption;
                    LocalConfigOptions.getInstance(UpdateSo.this.application).setBioOptions(UpdateSo.this.oldOptions);
                    UpdateSo.this.statService.getConfigSuccess = true;
                    UpdateSo.this.statService.zipVersion = UpdateSo.this.newOptions.zipVersion;
                    if (Build.VERSION.SDK_INT <= 19) {
                        UpdateSo.this.oldOptions.updateFail = true;
                        UpdateSo.this.statService.sdkVersionBelow19 = true;
                        UpdateSo.this.statServiceCountDownLatch.countDown();
                        LocalConfigOptions.getInstance(UpdateSo.this.application).setBioOptions(UpdateSo.this.oldOptions);
                    } else if (!UpdateSo.this.newOptions.globalEnable || !UpdateSo.this.newOptions.enable) {
                        UpdateSo.this.statService.zipEnable = false;
                        UpdateSo.this.statService.needUpdate = false;
                        UpdateSo.this.statServiceCountDownLatch.countDown();
                        UpdateSo.this.oldOptions.updateFail = true;
                        LocalConfigOptions.getInstance(UpdateSo.this.application).setBioOptions(UpdateSo.this.oldOptions);
                    } else {
                        UpdateSo.this.statService.zipEnable = true;
                        UpdateSo.this.updateGrayPlugins(UpdateSo.this.oldOptions);
                        int i = UpdateSo.this.newOptions.grayThreshold;
                        UpdateSo.this.newOptions.grayThreshold = UpdateSo.this.oldOptions.grayThreshold;
                        if (!UpdateSo.this.meetGrayDemand(i, UpdateSo.this.oldOptions)) {
                            UpdateSo.this.statService.meetGray = false;
                            UpdateSo.this.statService.needUpdate = false;
                            UpdateSo.this.statServiceCountDownLatch.countDown();
                            UpdateSo.this.oldOptions.updateFail = true;
                            LocalConfigOptions.getInstance(UpdateSo.this.application).setBioOptions(UpdateSo.this.oldOptions);
                        } else {
                            UpdateSo.this.statService.meetGray = true;
                            if (SdkConfigOptions.HOST_VERSION.compareTo(UpdateSo.this.newOptions.zipVersion) <= 0) {
                                if (UpdateSo.this.needUpdate(UpdateSo.this.newOptions.distributedSdk, UpdateSo.this.oldOptions.distributedSdk)) {
                                    UpdateSo.this.updateFile(UpdateSo.this.newOptions);
                                    UpdateSo.this.statService.needUpdate = true;
                                } else {
                                    UpdateSo.this.copyInternalFileToExternal(UpdateSo.this.newOptions.distributedSdk);
                                    UpdateSo.this.statService.needUpdate = false;
                                    UpdateSo.this.statServiceCountDownLatch.countDown();
                                }
                            } else {
                                UpdateSo.this.statService.needUpdate = false;
                                UpdateSo.this.statServiceCountDownLatch.countDown();
                                UpdateSo.this.oldOptions.updateFail = true;
                                LocalConfigOptions.getInstance(UpdateSo.this.application).setBioOptions(UpdateSo.this.oldOptions);
                            }
                        }
                    }
                } catch (JSONException e) {
                    Log.e(UpdateSo.TAG, e);
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGrayPlugins(SdkConfigOptions sdkConfigOptions) {
        if (sdkConfigOptions.distributedSdk == null) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            sdkConfigOptions.grayThreshold = random.nextInt(100);
            LocalConfigOptions.getInstance(this.application).setBioOptions(sdkConfigOptions);
        }
        Log.i(TAG, "current gray = " + sdkConfigOptions.grayThreshold);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean meetGrayDemand(int i, SdkConfigOptions sdkConfigOptions) {
        return 100 == this.newOptions.grayThreshold || sdkConfigOptions.grayThreshold < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFile(final SdkConfigOptions sdkConfigOptions) {
        loadFileFromExternal(sdkConfigOptions.distributedSdk, new LoadModuleEventListener() { // from class: com.baidu.pass.biometrics.base.dynamicupdate.UpdateSo.4
            @Override // com.baidu.pass.biometrics.base.dynamicupdate.UpdateSo.LoadModuleEventListener
            public void onSuccess(SdkConfigOptions.DistributedFile distributedFile, byte[] bArr) {
                boolean writeInternal = UpdateSo.this.writeInternal(UpdateSo.this.application, LocalConfigOptions.getInternalZipPath(UpdateSo.this.application, sdkConfigOptions.zipVersion), bArr);
                if (!writeInternal) {
                    UpdateSo.this.downloadFile(sdkConfigOptions);
                } else {
                    UpdateSo.this.statService.updateFromNet = false;
                    UpdateSo.this.unZipApkSoToLibDir(LocalConfigOptions.getInternalZipPath(UpdateSo.this.application, sdkConfigOptions.zipVersion), LocalConfigOptions.getInternalRootPath(UpdateSo.this.application));
                    sdkConfigOptions.updateFail = false;
                    LocalConfigOptions.getInstance(UpdateSo.this.application).setBioOptions(sdkConfigOptions);
                }
                Log.e(UpdateSo.TAG, "loadFileFromExternal writeFileSuccess:" + writeInternal);
            }

            @Override // com.baidu.pass.biometrics.base.dynamicupdate.UpdateSo.LoadModuleEventListener
            public void onFailure(SdkConfigOptions.DistributedFile distributedFile) {
                UpdateSo.this.downloadFile(sdkConfigOptions);
            }
        }, LocalConfigOptions.getExternalZipPath(sdkConfigOptions.zipVersion));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadFile(SdkConfigOptions sdkConfigOptions) {
        this.statService.updateFromNet = true;
        Log.e(TAG, "loadFileFromExternal onFailure distributedSdk uri:" + sdkConfigOptions.distributedSdk.downloadUrl);
        new HttpClientWrap(this.application).get(sdkConfigOptions.distributedSdk.downloadUrl, new BinaryHttpHandlerWrap(Looper.getMainLooper(), new String[]{"application/octet-stream", "*/*", "application/apk", "application/vnd.android.package-archive", "application/zip"}) { // from class: com.baidu.pass.biometrics.base.dynamicupdate.UpdateSo.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.pass.biometrics.base.http.BinaryHttpHandlerWrap
            public void onSuccess(int i, byte[] bArr) {
                UpdateSo.this.downloadFileSuccess(bArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
            public void onFailure(Throwable th, String str) {
                Log.e(UpdateSo.TAG, "distributeFileDownload() onFailure" + th.toString());
                UpdateSo.this.oldOptions.updateFail = true;
                LocalConfigOptions.getInstance(UpdateSo.this.application).setBioOptions(UpdateSo.this.oldOptions);
                UpdateSo.this.statService.downloadZipFileSuccess = false;
                UpdateSo.this.statService.exceptionInfo = android.util.Log.getStackTraceString(th);
                UpdateSo.this.statServiceCountDownLatch.countDown();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadFileSuccess(final byte[] bArr) {
        ThreadPoolService.getInstance().runImport(new TPRunnable(new Runnable() { // from class: com.baidu.pass.biometrics.base.dynamicupdate.UpdateSo.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Log.e(UpdateSo.TAG, "distributeFileDownload() onSuccess" + UpdateSo.this.newOptions.distributedSdk.downloadUrl + ",:" + LocalConfigOptions.getInternalZipPath(UpdateSo.this.application, UpdateSo.this.newOptions.zipVersion));
                    String md5 = MD5Util.toMd5(bArr, false);
                    String decrypt = RSA.decrypt(UpdateSo.this.newOptions.distributedSdk.hash);
                    if (decrypt == null || !decrypt.equals(md5)) {
                        UpdateSo.this.oldOptions.updateFail = true;
                        LocalConfigOptions.getInstance(UpdateSo.this.application).setBioOptions(UpdateSo.this.oldOptions);
                        UpdateSo.this.statService.downloadZipFileSuccess = false;
                        UpdateSo.this.statService.exceptionInfo = "localMd5 is not equals onlineMd5";
                        UpdateSo.this.statServiceCountDownLatch.countDown();
                        return;
                    }
                    if (UpdateSo.this.writeInternal(UpdateSo.this.application, LocalConfigOptions.getInternalZipPath(UpdateSo.this.application, UpdateSo.this.newOptions.zipVersion), bArr)) {
                        UpdateSo.this.unZipApkSoToLibDir(LocalConfigOptions.getInternalZipPath(UpdateSo.this.application, UpdateSo.this.newOptions.zipVersion), LocalConfigOptions.getInternalRootPath(UpdateSo.this.application));
                        UpdateSo.this.newOptions.updateFail = false;
                        LocalConfigOptions.getInstance(UpdateSo.this.application).setBioOptions(UpdateSo.this.newOptions);
                    } else {
                        UpdateSo.this.oldOptions.updateFail = true;
                        LocalConfigOptions.getInstance(UpdateSo.this.application).setBioOptions(UpdateSo.this.oldOptions);
                        UpdateSo.this.statService.downloadZipFileSuccess = false;
                        UpdateSo.this.statService.exceptionInfo = "zip file write internal fail";
                        UpdateSo.this.statServiceCountDownLatch.countDown();
                    }
                    if (PassBiometricUtil.checkRequestPermission(UpdateSo.this.application, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                        String externalZipPath = LocalConfigOptions.getExternalZipPath(UpdateSo.this.newOptions.zipVersion);
                        if (PassBioFileUtils.isFileExist(externalZipPath)) {
                            PassBioFileUtils.deleteFile(externalZipPath);
                        }
                        UpdateSo.this.writeExternal(externalZipPath, bArr);
                    }
                } catch (Exception e) {
                    Log.e(UpdateSo.TAG, "distributeFileDownload() Exception " + e.toString());
                    UpdateSo.this.oldOptions.updateFail = true;
                    LocalConfigOptions.getInstance(UpdateSo.this.application).setBioOptions(UpdateSo.this.oldOptions);
                    UpdateSo.this.statService.downloadZipFileSuccess = false;
                    UpdateSo.this.statService.exceptionInfo = android.util.Log.getStackTraceString(e);
                    UpdateSo.this.statServiceCountDownLatch.countDown();
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void copyInternalFileToExternal(SdkConfigOptions.DistributedFile distributedFile) {
        loadFileFromExternal(distributedFile, new LoadModuleEventListener() { // from class: com.baidu.pass.biometrics.base.dynamicupdate.UpdateSo.7
            @Override // com.baidu.pass.biometrics.base.dynamicupdate.UpdateSo.LoadModuleEventListener
            public void onSuccess(SdkConfigOptions.DistributedFile distributedFile2, byte[] bArr) {
                Log.e(UpdateSo.TAG, "copyInternalFileToExternal(), loadFileFromExternal distributed success");
            }

            @Override // com.baidu.pass.biometrics.base.dynamicupdate.UpdateSo.LoadModuleEventListener
            public void onFailure(SdkConfigOptions.DistributedFile distributedFile2) {
                String internalZipPath = LocalConfigOptions.getInternalZipPath(UpdateSo.this.application, UpdateSo.this.newOptions.zipVersion);
                String externalZipPath = LocalConfigOptions.getExternalZipPath(UpdateSo.this.newOptions.zipVersion);
                Log.e(UpdateSo.TAG, "asyncDistributeConf(), loadFileFromExternal failure internalFile:" + internalZipPath);
                if (PassBioFileUtils.isFileExist(internalZipPath)) {
                    byte[] loadDataFromInternal = UpdateSo.this.loadDataFromInternal(internalZipPath);
                    if (PassBiometricUtil.checkRequestPermission(UpdateSo.this.application, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                        if (PassBioFileUtils.isFileExist(externalZipPath)) {
                            PassBioFileUtils.deleteFile(externalZipPath);
                        }
                        UpdateSo.this.writeExternal(externalZipPath, loadDataFromInternal);
                    }
                }
            }
        }, LocalConfigOptions.getExternalZipPath(this.newOptions.zipVersion));
    }

    private void loadFileFromExternal(SdkConfigOptions.DistributedFile distributedFile, LoadModuleEventListener loadModuleEventListener, String str) {
        if (loadModuleEventListener == null) {
            throw new IllegalArgumentException(LoadModuleEventListener.class.getName() + "can't be null");
        }
        try {
            if ("mounted".equals(Environment.getExternalStorageState()) && new File(Environment.getExternalStorageDirectory(), str).exists()) {
                byte[] loadDataFromExternal = loadDataFromExternal(str);
                String md5 = MD5Util.toMd5(loadDataFromExternal, false);
                String decrypt = RSA.decrypt(distributedFile.hash);
                Log.e(TAG, "loadFileFromExternal() localMd5:" + md5 + ",onlineMd5" + decrypt);
                if (decrypt != null && decrypt.equals(md5)) {
                    loadModuleEventListener.onSuccess(distributedFile, loadDataFromExternal);
                } else {
                    loadModuleEventListener.onFailure(distributedFile);
                }
            } else {
                loadModuleEventListener.onFailure(distributedFile);
            }
        } catch (Throwable th) {
            Log.e(TAG, "loadFileFromExternal() Throwable" + th.toString());
            loadModuleEventListener.onFailure(distributedFile);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] loadDataFromInternal(String str) {
        try {
            return loadData(new FileInputStream(new File(str)));
        } catch (IOException e) {
            Log.e(TAG, e);
            return new byte[0];
        }
    }

    private byte[] loadDataFromExternal(String str) throws IOException {
        return loadData(new FileInputStream(new File(Environment.getExternalStorageDirectory(), str)));
    }

    private byte[] loadData(InputStream inputStream) throws IOException {
        try {
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            return bArr;
        } finally {
            inputStream.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean writeInternal(Context context, String str, byte[] bArr) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [497=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public void writeExternal(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                File file = new File(Environment.getExternalStorageDirectory(), str);
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
                            try {
                                fileOutputStream2.close();
                                return;
                            } catch (Throwable th2) {
                                Log.e(TAG, th2);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th3) {
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (Throwable th4) {
                                Log.e(TAG, th4);
                            }
                        }
                        throw th3;
                    }
                }
            } else {
                fileOutputStream = null;
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th5) {
                    Log.e(TAG, th5);
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needUpdate(SdkConfigOptions.DistributedFile distributedFile, SdkConfigOptions.DistributedFile distributedFile2) {
        return distributedFile2 == null || distributedFile == null || TextUtils.isEmpty(distributedFile2.hash) || !distributedFile.hash.equals(distributedFile2.hash);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [578=5, 579=4] */
    /* JADX INFO: Access modifiers changed from: private */
    public void unZipApkSoToLibDir(String str, String str2) {
        BufferedOutputStream bufferedOutputStream;
        Exception e;
        byte[] bArr;
        String name;
        ZipInputStream zipInputStream = null;
        BufferedOutputStream bufferedOutputStream2 = null;
        zipInputStream = null;
        this.statService.downloadZipFileSuccess = true;
        this.statServiceCountDownLatch.countDown();
        Log.i(TAG, "thread name unZipApkSoToLibDir = " + Thread.currentThread().getName());
        Log.d(TAG, "unZipApkSoToLibDir(), zipFilePath:" + str + ",libDir:" + str2);
        try {
            try {
                ZipInputStream zipInputStream2 = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream2.getNextEntry();
                        if (nextEntry == null) {
                            break;
                        }
                        try {
                            bArr = new byte[4096];
                            name = nextEntry.getName();
                            Log.e(TAG, "unZipApkSoToLibDir() entryName," + name);
                        } catch (Exception e2) {
                            bufferedOutputStream = bufferedOutputStream2;
                            e = e2;
                        } catch (Throwable th) {
                            th = th;
                        }
                        if (name.endsWith(PluginInstallerService.APK_LIB_SUFFIX)) {
                            String str3 = name.substring(name.lastIndexOf("/") + 1, name.lastIndexOf("_")) + PluginInstallerService.APK_LIB_SUFFIX;
                            Log.d(TAG, "unZipApkSoToLibDir(),fileName2:" + str3);
                            File file = new File(str2 + File.separator + str3);
                            if (file.exists()) {
                                file.delete();
                            }
                            File file2 = new File(file.getParent());
                            Log.d(TAG, "unZipApkSoToLibDir()entryFile" + file.toString() + "entryDir" + file2.toString());
                            if (!file2.exists()) {
                                Log.d(TAG, "unZipApkSoToLibDir() not exists");
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
                                    } catch (Throwable th2) {
                                        bufferedOutputStream2 = bufferedOutputStream;
                                        th = th2;
                                        if (bufferedOutputStream2 != null) {
                                            bufferedOutputStream2.close();
                                        }
                                        throw th;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    e.printStackTrace();
                                    if (bufferedOutputStream != null) {
                                        bufferedOutputStream.close();
                                    }
                                    bufferedOutputStream2 = bufferedOutputStream;
                                }
                            }
                            bufferedOutputStream.flush();
                            if (bufferedOutputStream != null) {
                                bufferedOutputStream.close();
                            }
                            bufferedOutputStream2 = bufferedOutputStream;
                        } else if (bufferedOutputStream2 != null) {
                            bufferedOutputStream2.close();
                        }
                    } catch (Exception e4) {
                        e = e4;
                        zipInputStream = zipInputStream2;
                        Log.e(TAG, e);
                        if (zipInputStream != null) {
                            try {
                                zipInputStream.close();
                                return;
                            } catch (IOException e5) {
                                Log.e(TAG, e5);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        zipInputStream = zipInputStream2;
                        if (zipInputStream != null) {
                            try {
                                zipInputStream.close();
                            } catch (IOException e6) {
                                Log.e(TAG, e6);
                            }
                        }
                        throw th;
                    }
                }
                if (zipInputStream2 != null) {
                    try {
                        zipInputStream2.close();
                    } catch (IOException e7) {
                        Log.e(TAG, e7);
                    }
                }
            } catch (Exception e8) {
                e = e8;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class StatService {
        private static final String DOWNLOAD_ZIP_FILE_SUCCESS = "download_zip_file_success";
        private static final String EXCEPTION_INFO = "exception_info";
        private static final String GET_CONFIG_SUCCESS = "get_config_success";
        public static final String HOST_VERSION = "host_version";
        private static final String MEET_GRAY = "meet_gray";
        private static final String NEED_UPDATE = "need_update";
        private static final String SDK_VERSION_ENABLE = "sdk_version_enable";
        public static final String STAT_NAME_LIVENESS_FACE = "sapi_bio_dynamic_update_so";
        private static final String UPDATE_FROM_NET = "update_from_net";
        private static final String ZIP_ENABLE = "zip_enable";
        public static final String ZIP_VERSION = "zip_version";
        private boolean downloadZipFileSuccess;
        private String exceptionInfo;
        private boolean getConfigSuccess;
        private boolean meetGray;
        private boolean needUpdate;
        private boolean sdkVersionBelow19;
        private boolean updateFromNet;
        private boolean zipEnable;
        private String zipVersion;

        private StatService() {
        }

        private Map<String, String> prepareData() {
            HashMap hashMap = new HashMap();
            hashMap.put(HOST_VERSION, SdkConfigOptions.HOST_VERSION);
            hashMap.put(ZIP_VERSION, this.zipVersion);
            hashMap.put(GET_CONFIG_SUCCESS, this.getConfigSuccess ? "1" : LivenessStat.TYPE_STRING_DEFAULT);
            if (this.getConfigSuccess) {
                hashMap.put(ZIP_ENABLE, this.zipEnable ? "1" : LivenessStat.TYPE_STRING_DEFAULT);
                hashMap.put(NEED_UPDATE, this.needUpdate ? "1" : LivenessStat.TYPE_STRING_DEFAULT);
            }
            if (this.zipEnable) {
                hashMap.put(MEET_GRAY, this.meetGray ? "1" : LivenessStat.TYPE_STRING_DEFAULT);
            }
            if (this.needUpdate) {
                hashMap.put(UPDATE_FROM_NET, this.updateFromNet ? "1" : LivenessStat.TYPE_STRING_DEFAULT);
                hashMap.put(DOWNLOAD_ZIP_FILE_SUCCESS, this.downloadZipFileSuccess ? "1" : LivenessStat.TYPE_STRING_DEFAULT);
            }
            if (this.sdkVersionBelow19) {
                hashMap.put(SDK_VERSION_ENABLE, this.sdkVersionBelow19 ? "1" : LivenessStat.TYPE_STRING_DEFAULT);
            }
            hashMap.put(EXCEPTION_INFO, this.exceptionInfo);
            return hashMap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void startStatService() {
            com.baidu.pass.biometrics.base.utils.StatService.onEvent(UpdateSo.this.application, STAT_NAME_LIVENESS_FACE, prepareData());
        }
    }
}
