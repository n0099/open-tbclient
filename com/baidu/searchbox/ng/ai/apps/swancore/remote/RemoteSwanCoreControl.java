package com.baidu.searchbox.ng.ai.apps.swancore.remote;

import com.baidu.searchbox.ng.ai.apps.data.AiAppsSpHelper;
import com.baidu.searchbox.ng.ai.apps.process.AiAppsMessengerService;
import com.baidu.searchbox.ng.ai.apps.swancore.AboutDevSwanCoreHistory;
import com.baidu.searchbox.ng.ai.apps.swancore.AiAppsSwanCoreManager;
import com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppSignChecker;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class RemoteSwanCoreControl {
    private static final boolean DEBUG = false;
    private static final String PREF_CUR_REMOTE_VERSION = "aiapps_cur_remote_ver_key";
    private static final int STATUS_IGNORE_EQUAL = 2;
    private static final int STATUS_IGNORE_LESS = 1;
    private static final int STATUS_NEED_UPDATE = 0;
    public static final String SWAN_CORE_PACKAGE_NAME = "swan-core";
    private static final String SWAN_CORE_REMOTE_DIR_NAME = "remote";
    private static final String TAG = "RemoteSwanCoreControl";

    public static RemoteCoreUpdateStatus doRemoteUpdate(String str, String str2, String str3) {
        long version = AiAppsSwanCoreManager.getVersion(str);
        if (version == 0) {
            return RemoteCoreUpdateStatus.failed("invalid version code : " + str);
        }
        int checkCurVersion = checkCurVersion(version);
        if (checkCurVersion == 1 || checkCurVersion == 2) {
            return RemoteCoreUpdateStatus.success();
        }
        if (!AiAppSignChecker.checkZipSign(new File(str2), str3)) {
            return RemoteCoreUpdateStatus.failed("sign failed.");
        }
        if (!AiAppsFileUtils.unzipFile(str2, getRemoteDirFile(version).getPath())) {
            return RemoteCoreUpdateStatus.failed("unzip bundle failed.");
        }
        AiAppsSwanCoreManager.deleteOldSwanCores(getRemoteBaseDir(), getUsedRemoteVersions(getCurRemoteVersion(), version));
        setCurRemoteVersion(version);
        return RemoteCoreUpdateStatus.success();
    }

    private static ArrayList<Long> getUsedRemoteVersions(long j, long j2) {
        ArrayList<Long> arrayList = new ArrayList<>();
        if (j != 0) {
            arrayList.add(Long.valueOf(j));
        }
        arrayList.add(Long.valueOf(j2));
        AiAppsMessengerService serviceObject = AiAppsMessengerService.getServiceObject();
        if (serviceObject == null) {
            return arrayList;
        }
        for (AiAppsMessengerService.AiAppsClientObject aiAppsClientObject : serviceObject.getAllClientObjects().values()) {
            if (aiAppsClientObject.mSwanCoreVersion != null && !arrayList.contains(Long.valueOf(aiAppsClientObject.mSwanCoreVersion.swanCoreVersion))) {
                arrayList.add(Long.valueOf(aiAppsClientObject.mSwanCoreVersion.swanCoreVersion));
            }
        }
        return arrayList;
    }

    private static int checkCurVersion(long j) {
        long curRemoteVersion = getCurRemoteVersion();
        if (curRemoteVersion < j) {
            return 0;
        }
        if (curRemoteVersion > j) {
            return 1;
        }
        return 2;
    }

    public static long getCurRemoteVersion() {
        return AiAppsSpHelper.getsInstance().getLong(PREF_CUR_REMOTE_VERSION, 0L);
    }

    private static void setCurRemoteVersion(final long j) {
        AiAppsSpHelper.getsInstance().putLong(PREF_CUR_REMOTE_VERSION, j);
        AiAppExecutorUtils.postOnIO(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.swancore.remote.RemoteSwanCoreControl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AboutDevSwanCoreHistory.getIns().cacheSwanCoreInfo(j);
                } catch (Exception e) {
                }
            }
        }, "cacheSwanCoreInfo");
    }

    private static File getRemoteBaseDir() {
        return new File(AiAppsSwanCoreManager.getSwanCoreBaseDir(), SWAN_CORE_REMOTE_DIR_NAME);
    }

    public static File getRemoteDirFile(long j) {
        return new File(getRemoteBaseDir(), String.valueOf(j));
    }

    /* loaded from: classes2.dex */
    public static class RemoteCoreUpdateStatus {
        public static final int REMOTE_UPDATE_FAILED = 1;
        public static final int REMOTE_UPDATE_OK = 0;
        public String message;
        public int statusCode = 0;

        public boolean isOk() {
            return this.statusCode == 0;
        }

        public static RemoteCoreUpdateStatus success() {
            return createObject(0, "");
        }

        public static RemoteCoreUpdateStatus failed(String str) {
            return createObject(1, str);
        }

        public static RemoteCoreUpdateStatus createObject(int i, String str) {
            RemoteCoreUpdateStatus remoteCoreUpdateStatus = new RemoteCoreUpdateStatus();
            remoteCoreUpdateStatus.statusCode = i;
            remoteCoreUpdateStatus.message = str;
            return remoteCoreUpdateStatus;
        }

        public String toString() {
            return "RemoteCoreUpdateStatus{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
        }
    }
}
