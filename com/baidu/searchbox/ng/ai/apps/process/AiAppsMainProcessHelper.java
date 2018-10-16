package com.baidu.searchbox.ng.ai.apps.process;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.process.AiAppsMessengerService;
import java.util.LinkedHashMap;
import java.util.Set;
/* loaded from: classes2.dex */
public final class AiAppsMainProcessHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "AiAppsMainProcessHelper";
    private static volatile AiAppsMainProcessHelper sInstance;
    private AiAppsMessengerService mService;

    /* loaded from: classes2.dex */
    public interface OnStatusCallback {
        void onReady();
    }

    private AiAppsMainProcessHelper() {
    }

    public static AiAppsMainProcessHelper getInstance() {
        if (sInstance == null) {
            synchronized (AiAppsMainProcessHelper.class) {
                if (sInstance == null) {
                    sInstance = new AiAppsMainProcessHelper();
                }
            }
        }
        return sInstance;
    }

    private AvailableProcessInfo getAvailableProcessInfo(String str) {
        if (this.mService == null || TextUtils.isEmpty(str)) {
            return AvailableProcessInfo.createDefaultObject();
        }
        AvailableProcessInfo availableProcessInfo = new AvailableProcessInfo();
        LinkedHashMap<Integer, AiAppsMessengerService.AiAppsClientObject> allClientObjects = this.mService.getAllClientObjects();
        if (allClientObjects.size() == 0) {
            availableProcessInfo.mProcessType = 0;
            availableProcessInfo.mProcessId = 0;
            return availableProcessInfo;
        }
        Set<Integer> keySet = allClientObjects.keySet();
        for (Integer num : keySet) {
            int intValue = num.intValue();
            if (TextUtils.equals(allClientObjects.get(Integer.valueOf(intValue)).mAppId, str)) {
                availableProcessInfo.mProcessId = intValue;
                availableProcessInfo.mProcessType = 1;
                return availableProcessInfo;
            }
        }
        if (keySet.size() == 6) {
            availableProcessInfo.mProcessId = keySet.iterator().next().intValue();
            availableProcessInfo.mProcessType = 2;
            return availableProcessInfo;
        }
        for (int i = 0; i <= 5; i++) {
            if (!keySet.contains(Integer.valueOf(i))) {
                availableProcessInfo.mProcessId = i;
                availableProcessInfo.mProcessType = 0;
                return availableProcessInfo;
            }
        }
        return AvailableProcessInfo.createDefaultObject();
    }

    public AvailableProcessInfo getProcessInfoAndResort(String str) {
        AvailableProcessInfo availableProcessInfo = getAvailableProcessInfo(str);
        if (this.mService != null) {
            this.mService.lruResortClient(availableProcessInfo.mProcessId);
        }
        return availableProcessInfo;
    }

    private void bindService(final OnStatusCallback onStatusCallback) {
        Context appContext = AppRuntime.getAppContext();
        appContext.bindService(new Intent(appContext, AiAppsMessengerService.class), new ServiceConnection() { // from class: com.baidu.searchbox.ng.ai.apps.process.AiAppsMainProcessHelper.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                AiAppsMainProcessHelper.this.mService = AiAppsMessengerService.getServiceObject();
                if (onStatusCallback != null) {
                    onStatusCallback.onReady();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                AiAppsMainProcessHelper.this.mService = null;
            }
        }, 1);
    }

    public void checkStatusAsync(OnStatusCallback onStatusCallback) {
        if (onStatusCallback != null) {
            if (this.mService == null) {
                bindService(onStatusCallback);
            } else {
                onStatusCallback.onReady();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class AvailableProcessInfo {
        public static final int PROCESS_TYPE_ALREADY_LAUNCH = 1;
        public static final int PROCESS_TYPE_NEED_RESET = 2;
        public static final int PROCESS_TYPE_NORMAL = 0;
        public int mProcessId;
        public int mProcessType;

        public static AvailableProcessInfo createDefaultObject() {
            AvailableProcessInfo availableProcessInfo = new AvailableProcessInfo();
            availableProcessInfo.mProcessType = 2;
            availableProcessInfo.mProcessId = 0;
            return availableProcessInfo;
        }
    }
}
