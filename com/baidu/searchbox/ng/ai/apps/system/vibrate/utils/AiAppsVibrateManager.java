package com.baidu.searchbox.ng.ai.apps.system.vibrate.utils;

import android.content.Context;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.permission.AiAppsPermission;
import com.baidu.searchbox.ng.ai.apps.util.AiAppAPIUtils;
/* loaded from: classes2.dex */
public class AiAppsVibrateManager {
    private static final boolean DEBUG = false;
    public static final int LONG_VIBRATE_MS = 400;
    private static final int REQUEST_CODE = 700;
    public static final int SHORT_VIBRATE_MS = 15;
    private static final String TAG = "VibrateManager";
    private Context mContext;
    private long mMilliseconds;
    private final AiAppsPermission.PermissionCallback mPermissionCallback;
    private Vibrator mVibrator;

    /* loaded from: classes2.dex */
    private static class SingletonHolder {
        public static final AiAppsVibrateManager sInstance = new AiAppsVibrateManager();

        private SingletonHolder() {
        }
    }

    private AiAppsVibrateManager() {
        this.mMilliseconds = 0L;
        this.mPermissionCallback = new AiAppsPermission.PermissionCallback() { // from class: com.baidu.searchbox.ng.ai.apps.system.vibrate.utils.AiAppsVibrateManager.1
            @Override // com.baidu.searchbox.ng.ai.apps.permission.AiAppsPermission.PermissionCallback
            public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                if (i == 700 && iArr.length > 0 && iArr[0] == 0 && AiAppsVibrateManager.this.mVibrator != null) {
                    AiAppsVibrateManager.this.mVibrator.vibrate(AiAppsVibrateManager.this.mMilliseconds);
                }
            }
        };
        this.mContext = AppRuntime.getAppContext();
        this.mVibrator = (Vibrator) this.mContext.getSystemService("vibrator");
    }

    public static AiAppsVibrateManager getInstance() {
        return SingletonHolder.sInstance;
    }

    public void vibrate(long j) {
        this.mMilliseconds = j;
        if (checkVibratePermission()) {
            this.mVibrator.vibrate(this.mMilliseconds);
            return;
        }
        String[] strArr = {"android.permission.VIBRATE"};
        AiAppsController aiAppsController = AiAppsController.getInstance();
        if (aiAppsController != null) {
            aiAppsController.requestPermissionsExt(700, strArr, this.mPermissionCallback);
        }
    }

    private boolean checkVibratePermission() {
        if (AiAppAPIUtils.hasMarshMallow()) {
            return this.mContext != null && ActivityCompat.checkSelfPermission(this.mContext, "android.permission.VIBRATE") == 0;
        }
        return true;
    }

    public void vibrateShort() {
        vibrate(15L);
    }

    public void vibrateLong() {
        vibrate(400L);
    }
}
