package com.baidu.searchbox.permission;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.permission.DangerousPermissionManager;
@SuppressLint({"BaseActivity"})
/* loaded from: classes3.dex */
public class PermissionActivity extends Activity {
    public static final String PERMISSION_ARRAY = "permission_array";
    public static final String PERMISSION_CALLBACK_TAG = "permission_callback_tag";
    public static final String PERMISSION_CODE = "permission_code";
    public static final String TAG = "PermissionActivity";
    public String mPermissionCallbackTag;
    public int mPermissionCode;
    public String[] mPermissions;
    public DangerousPermissionManager.RequestSystemPermissionCallBack mRequestSystemPermissionCallBack;

    private void onRequestFailed() {
        String[] strArr = this.mPermissions;
        int length = strArr.length;
        if (strArr != null && length > 0) {
            int[] iArr = new int[length];
            for (int i = 0; i < length; i++) {
                iArr[i] = -1;
            }
            DangerousPermissionManager.RequestSystemPermissionCallBack requestSystemPermissionCallBack = this.mRequestSystemPermissionCallBack;
            if (requestSystemPermissionCallBack != null) {
                requestSystemPermissionCallBack.onRequestPermissionsResult(this.mPermissionCode, this.mPermissions, iArr);
            }
            requestPermissionsResult(this.mPermissionCode, this.mPermissions, iArr);
        }
        finish();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        DangerousPermissionManager.getInstance(getApplicationContext()).removeRequestPermissionCallBack(this.mPermissionCallbackTag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        DangerousPermissionManager.RequestSystemPermissionCallBack requestPermissionCallBack = DangerousPermissionManager.getInstance(getApplicationContext()).getRequestPermissionCallBack(this.mPermissionCallbackTag);
        if (requestPermissionCallBack != null) {
            requestPermissionCallBack.onRequestPermissionsResult(i, strArr, iArr);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View view2 = new View(this);
        view2.setBackgroundColor(0);
        view2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setContentView(view2);
        Intent intent = getIntent();
        this.mPermissionCallbackTag = intent.getStringExtra(PERMISSION_CALLBACK_TAG);
        this.mPermissions = intent.getStringArrayExtra(PERMISSION_ARRAY);
        this.mPermissionCode = intent.getIntExtra(PERMISSION_CODE, -1);
        if (AppConfig.isDebug()) {
            Log.d(TAG, "onCreate: mPermissionCode = " + this.mPermissionCode);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            this.mRequestSystemPermissionCallBack = DangerousPermissionUtils.showPermissionInstrumentWindow("", this, this.mPermissions);
            try {
                requestPermissions(this.mPermissions, this.mPermissionCode);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                onRequestFailed();
                return;
            }
        }
        finish();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(final int i, @NonNull final String[] strArr, @NonNull final int[] iArr) {
        long j;
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (DangerousPermissionRuntime.GLOBAL_DEBUG) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                Log.d(TAG, "onRequestPermissionsResult: permission[" + i2 + "] = " + strArr[i2] + "grantResults[" + i2 + "] = " + iArr[i2]);
            }
        }
        DangerousPermissionManager.RequestSystemPermissionCallBack requestSystemPermissionCallBack = this.mRequestSystemPermissionCallBack;
        if (requestSystemPermissionCallBack != null) {
            requestSystemPermissionCallBack.onRequestPermissionsResult(i, strArr, iArr);
            if (DeviceUtil.isInMagicWindow(AppRuntime.getAppContext())) {
                j = 300;
            } else {
                j = 0;
            }
            if (j > 0) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.baidu.searchbox.permission.PermissionActivity.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PermissionActivity.this.requestPermissionsResult(i, strArr, iArr);
                    }
                }, j);
                return;
            } else {
                requestPermissionsResult(i, strArr, iArr);
                return;
            }
        }
        requestPermissionsResult(i, strArr, iArr);
    }
}
