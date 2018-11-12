package com.baidu.searchbox.bdmapsdk;

import android.os.Process;
import android.util.Log;
import com.baidu.f.a.a;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.VersionInfo;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes4.dex */
public class BdMapLibLoader {
    private static final boolean DEBUG = a.isDebug();
    private static final String TAG = "BdMapLibLoader";

    /* loaded from: classes4.dex */
    public interface OnFetchMapLibCallback {
        void onFailure();

        void onSuccess();
    }

    public static boolean makeSureMapSdkInitialized() {
        return makeSureMapSdkInitialized(null);
    }

    public static boolean makeSureMapSdkInitialized(final OnFetchMapLibCallback onFetchMapLibCallback) {
        if (BdMapLibHelper.checkLocalMapLibZipExist() && BdMapLibHelper.matchBdMapSdkVersion(BdMapLibHelper.getBdMapLibVersionIPC())) {
            initializeMapSdk(BdMapLibHelper.getBdMapLibFile().getAbsolutePath());
            return true;
        }
        if (DEBUG) {
            Log.d(TAG, "initializeMapLib failed, sdk version=" + VersionInfo.getApiVersion() + ", sp sdk version=" + BdMapLibHelper.getBdMapLibVersionIPC() + ", sdk existed=" + BdMapLibHelper.checkLocalMapLibZipExist() + ", pid=" + Process.myPid());
        }
        BdMapRuntime.getBdMapContext().loadBdMapLib(new OnFetchMapLibCallback() { // from class: com.baidu.searchbox.bdmapsdk.BdMapLibLoader.1
            @Override // com.baidu.searchbox.bdmapsdk.BdMapLibLoader.OnFetchMapLibCallback
            public void onSuccess() {
                if (BdMapLibLoader.DEBUG) {
                    Log.d(BdMapLibLoader.TAG, "makeSureMapSdkInitialized download success!");
                }
                if (OnFetchMapLibCallback.this != null) {
                    OnFetchMapLibCallback.this.onSuccess();
                }
            }

            @Override // com.baidu.searchbox.bdmapsdk.BdMapLibLoader.OnFetchMapLibCallback
            public void onFailure() {
                if (BdMapLibLoader.DEBUG) {
                    Log.d(BdMapLibLoader.TAG, "makeSureMapSdkInitialized download failed!");
                }
                if (OnFetchMapLibCallback.this != null) {
                    OnFetchMapLibCallback.this.onFailure();
                }
            }
        });
        return false;
    }

    private static void initializeMapSdk(String str) {
        SDKInitializer.initialize(AppRuntime.getAppContext(), true, str, null);
        SDKInitializer.setCoordType(CoordType.GCJ02);
        SDKInitializer.setHttpsEnable(true);
    }
}
