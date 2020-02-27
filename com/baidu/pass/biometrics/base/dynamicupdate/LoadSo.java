package com.baidu.pass.biometrics.base.dynamicupdate;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.baidu.adp.plugin.install.PluginInstallerService;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class LoadSo {
    static final String[] SO_NAME_ARRAY = {"bd_idl_pass_token", "idl_license", "FaceSDK"};
    static final String ZIP_VERSION = "3.0.0";
    private Bundle bundle;
    private Context context;
    private StatService statService;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [71=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean load(Context context, Bundle bundle) {
        this.context = context;
        this.statService = new StatService();
        this.statService.hostVersion = "3.0.0";
        this.bundle = bundle;
        SdkConfigOptions bioOptions = LocalConfigOptions.getInstance(context).getBioOptions();
        try {
            if (!bioOptions.globalEnable || !bioOptions.enable || inWhitePkgLoadDefaultSO(context)) {
                this.statService.zipVersion = bioOptions.zipVersion;
                this.statService.loadSoSuccess = true;
                loadDefaultSo();
                return true;
            }
            if (!bioOptions.updateFail) {
                loadPathSo(bioOptions);
            } else if ("3.0.0".compareTo(bioOptions.zipVersion) > 0) {
                this.statService.zipVersion = "3.0.0";
                loadDefaultSo();
            } else {
                loadPathSo(bioOptions);
            }
            this.statService.loadSoSuccess = true;
            return true;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                this.statService.exceptionInfo = Log.getStackTraceString(th);
                this.statService.execptionZipVersion = this.statService.zipVersion;
                this.statService.loadSoSuccess = false;
                return false;
            } finally {
                this.statService.startStatService();
            }
        }
    }

    private void loadDefaultSo() {
        for (String str : SO_NAME_ARRAY) {
            System.loadLibrary(str);
        }
        this.statService.loadDefaultSo = true;
    }

    private void loadPathSo(SdkConfigOptions sdkConfigOptions) {
        String[] strArr;
        boolean z = true;
        try {
            int length = SO_NAME_ARRAY.length;
            for (int i = 0; i < length; i++) {
                System.load(LocalConfigOptions.getLoadSoPath(this.context) + "/lib" + strArr[i] + PluginInstallerService.APK_LIB_SUFFIX);
            }
            this.statService.zipVersion = sdkConfigOptions.zipVersion;
        } catch (Throwable th) {
            this.statService.loadDownloadSoSuc = false;
            this.statService.zipVersion = sdkConfigOptions.zipVersion;
            this.statService.exceptionInfo = Log.getStackTraceString(th);
            this.statService.execptionZipVersion = sdkConfigOptions.zipVersion;
            z = false;
        }
        if (!z) {
            loadDefaultSo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class StatService {
        private static final String EXCEPTION_INFO = "exception_info";
        private static final String EXCEPTION_ZIP_VERSION = "execption_zip_version";
        private static final String HOST_VERSION = "host_version";
        private static final String LIVENESS_CUID = "bio_cuid";
        private static final String LIVENESS_DEVICE_MODEL = "device_model";
        private static final String LIVENESS_PHONO_SYS = "phone_sys";
        private static final String LIVENESS_PROCESS_ID = "bio_processid";
        private static final String LIVENESS_SUBPRO = "liveness_subpro";
        private static final String LIVENESS_TPL = "tpl";
        private static final String LOAD_DEFAULT_SO = "load_default_so";
        private static final String LOAD_DOWNLOAD_SO_SUC = "load_download_so_suc";
        private static final String LOAD_SO_SUCCESS = "load_so_success";
        private static final String MODLE_NAME = "modle_name";
        private static final String STAT_NAME_LIVENESS_FACE = "sapi_bio_dynamic_load_so";
        private static final String ZIP_VERSION = "zip_version";
        private String exceptionInfo;
        private String execptionZipVersion;
        private String hostVersion;
        private boolean loadDefaultSo;
        private boolean loadDownloadSoSuc;
        private boolean loadSoSuccess;
        private String productId;
        private String tpl;
        private String uuid;
        private String zipVersion;

        private StatService() {
            this.loadDefaultSo = false;
            this.loadDownloadSoSuc = true;
        }

        private Map<String, String> prepareData() {
            if (LoadSo.this.bundle != null) {
                this.uuid = LoadSo.this.bundle.getString("uuid");
                this.tpl = LoadSo.this.bundle.getString("tpl");
                this.productId = LoadSo.this.bundle.getString("productId");
            }
            HashMap hashMap = new HashMap();
            hashMap.put("host_version", this.hostVersion);
            hashMap.put("zip_version", this.zipVersion);
            hashMap.put(LOAD_DEFAULT_SO, this.loadDefaultSo ? "1" : "-1");
            hashMap.put(LOAD_SO_SUCCESS, this.loadSoSuccess ? "1" : "-1");
            hashMap.put(LOAD_DOWNLOAD_SO_SUC, this.loadDownloadSoSuc ? "1" : "-1");
            hashMap.put(EXCEPTION_INFO, this.exceptionInfo);
            hashMap.put(EXCEPTION_ZIP_VERSION, this.execptionZipVersion);
            hashMap.put(LIVENESS_PROCESS_ID, this.uuid);
            hashMap.put(LIVENESS_SUBPRO, this.productId);
            hashMap.put("tpl", this.tpl);
            hashMap.put(LIVENESS_CUID, PassBiometricUtil.getClientId(LoadSo.this.context));
            hashMap.put(LIVENESS_DEVICE_MODEL, PassBiometricUtil.getOSModel());
            hashMap.put(LIVENESS_PHONO_SYS, PassBiometricUtil.getOSVersion());
            return hashMap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void startStatService() {
            com.baidu.pass.biometrics.base.utils.StatService.onEvent(LoadSo.this.context, STAT_NAME_LIVENESS_FACE, prepareData());
        }
    }

    static boolean inWhitePkgLoadDefaultSO(Context context) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("com.baidu.searchbox(.*)");
        arrayList.add("com.baidu.BaiduMap(.*)");
        for (String str : arrayList) {
            if (context.getPackageName().matches(str)) {
                return true;
            }
        }
        return false;
    }
}
