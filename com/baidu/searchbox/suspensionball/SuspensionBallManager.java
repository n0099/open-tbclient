package com.baidu.searchbox.suspensionball;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.android.ext.widget.dialog.BoxAlertDialog;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.suspensionball.ioc.SuspensionBallRuntime;
import com.baidu.searchbox.suspensionwindow.permission.PermissionActivity;
import com.baidu.searchbox.suspensionwindow.permission.PermissionListener;
import com.baidu.searchbox.suspensionwindow.permission.PermissionUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SuspensionBallManager {
    private static final int MULTIPLE = 2;
    private static final int SINGLE = 1;
    private static int mBallType = 1;
    private static volatile SuspensionBallManager mInstance;
    private Map<String, SuspensionBallEntity> mBallList = new ConcurrentHashMap();
    private boolean isSuspensionBallSwitchOn = false;
    private BallInfo mBallInfo = new BallInfo();
    private boolean isInit = false;
    private SuspensionBallDispatcher mDispatcher = new SuspensionBallDispatcher();

    private SuspensionBallManager() {
    }

    public static SuspensionBallManager getInstance() {
        if (mInstance == null) {
            synchronized (SuspensionBallManager.class) {
                if (mInstance == null) {
                    mInstance = new SuspensionBallManager();
                }
            }
        }
        return mInstance;
    }

    public void init() {
        if (Build.VERSION.SDK_INT != 26 && !this.isInit) {
            this.isInit = true;
            initInner();
            SuspensionBallRuntime.getDataInitImpl().init();
        }
    }

    private void release() {
        this.isInit = false;
        releaseInner();
        SuspensionBallShowHelper.releaseInstance();
        SuspensionBallRuntime.getDataInitImpl().release();
    }

    public static synchronized void releaseInstance() {
        synchronized (SuspensionBallManager.class) {
            if (mInstance != null) {
                mInstance.release();
            }
            mInstance = null;
        }
    }

    public boolean isInit() {
        return this.isInit;
    }

    public void checkAndInit(Activity activity) {
        if (!this.isInit && SuspensionBallRuntime.getDataInitImpl().enableInitSuspensionData(activity)) {
            init();
        }
    }

    private void initInner() {
        ExecutorUtilsExt.delayPostOnElastic(new Runnable() { // from class: com.baidu.searchbox.suspensionball.SuspensionBallManager.1
            @Override // java.lang.Runnable
            public void run() {
                SuspensionBallManager.this.isSuspensionBallSwitchOn = SuspensionSpUtil.getBoolean(SuspensionSpUtil.SUSPENSION_BALL_SWITCH, true);
                if (SuspensionBallManager.this.isSuspensionBallSwitchOn) {
                    SuspensionBallManager.this.mBallInfo.init();
                    String ballData = SuspensionSpUtil.getBallData();
                    if (!TextUtils.isEmpty(ballData)) {
                        try {
                            JSONArray jSONArray = new JSONArray(ballData);
                            int length = jSONArray.length();
                            for (int i = 0; i < length; i++) {
                                SuspensionBallEntity fromJson = SuspensionBallEntity.fromJson(jSONArray.getJSONObject(i));
                                if (fromJson != null && fromJson.isLegal()) {
                                    SuspensionBallManager.this.mBallList.put(fromJson.key, fromJson);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.suspensionball.SuspensionBallManager.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SuspensionBallShowHelper.getInstance().onResume(SuspensionBallRuntime.getDataInitImpl().getTopActivity());
                        }
                    });
                }
            }
        }, SuspensionSchemeUtil.DEFAULT_KEY_PREFIX, 2, 200L);
    }

    private void releaseInner() {
        if (!this.mBallList.isEmpty()) {
            for (String str : this.mBallList.keySet()) {
                SuspensionWindowController.destroy(this.mBallList.get(str).key);
            }
            this.mBallList.clear();
        }
    }

    public boolean isClickFromSuspension(Intent intent) {
        return getInstance().isInSuspensionBall(intent.getStringExtra(SuspensionSchemeUtil.SUSPENSION_KEY));
    }

    public void updateModelWithKey(Intent intent, String str, JSONObject jSONObject) {
        if (!this.mBallList.isEmpty()) {
            SuspensionBallEntity suspensionBallEntity = this.mBallList.get(str);
            if (suspensionBallEntity != null) {
                suspensionBallEntity.scheme = SuspensionSchemeUtil.generateDefaultSchemeByIntent(SuspensionSchemeUtil.intentAddSuspensionKey(intent, str), "0");
            }
            SuspensionSpUtil.putBallData(this.mBallList);
        }
    }

    public void addSuspensionBall(final Activity activity, Intent intent, JSONObject jSONObject, final SuspensionAddListener suspensionAddListener) {
        if (!isSuspensionBallSwitchOn()) {
            if (suspensionAddListener != null) {
                suspensionAddListener.onResult(false);
                return;
            }
            return;
        }
        String generateDefaultKey = SuspensionSchemeUtil.generateDefaultKey();
        final SuspensionBallEntity suspensionBallEntity = new SuspensionBallEntity(generateDefaultKey, getPageSource(jSONObject), SuspensionSchemeUtil.generateDefaultSchemeByIntent(SuspensionSchemeUtil.intentAddSuspensionKey(intent, generateDefaultKey), "0"));
        suspensionBallEntity.updateModelWithJson(jSONObject, generateDefaultKey);
        if (suspensionBallEntity == null || !suspensionBallEntity.isLegal()) {
            if (suspensionAddListener != null) {
                suspensionAddListener.onResult(false);
            }
        } else if (PermissionUtil.hasPermission(activity.getApplicationContext())) {
            addSuspensionBallInner(suspensionBallEntity);
            if (suspensionAddListener != null) {
                suspensionAddListener.onResult(true);
            }
        } else if (Build.VERSION.SDK_INT >= 23) {
            new BoxAlertDialog.Builder(activity).setTitle(R.string.suspension_permission_title).setMessage(R.string.suspension_permission_message).setCancelable(false).setNegativeButton(R.string.suspension_permission_cancel, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.suspensionball.SuspensionBallManager.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (suspensionAddListener != null) {
                        suspensionAddListener.onResult(false);
                    }
                }
            }).setPositiveButton(R.string.suspension_permission_authorize, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.suspensionball.SuspensionBallManager.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    PermissionActivity.request(activity.getApplicationContext(), new PermissionListener() { // from class: com.baidu.searchbox.suspensionball.SuspensionBallManager.2.1
                        @Override // com.baidu.searchbox.suspensionwindow.permission.PermissionListener
                        public void onSuccess() {
                            SuspensionBallManager.this.addSuspensionBallInner(suspensionBallEntity);
                            if (suspensionAddListener != null) {
                                suspensionAddListener.onResult(true);
                            }
                        }

                        @Override // com.baidu.searchbox.suspensionwindow.permission.PermissionListener
                        public void onFail() {
                            if (suspensionAddListener != null) {
                                suspensionAddListener.onResult(false);
                            }
                        }
                    });
                }
            }).show();
        } else {
            new BoxAlertDialog.Builder(activity).setMessage(R.string.suspension_permission_message_belowM).setCancelable(true).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.searchbox.suspensionball.SuspensionBallManager.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (suspensionAddListener != null) {
                        suspensionAddListener.onResult(false);
                    }
                }
            }).setNegativeButton(R.string.suspension_permission_known, new DialogInterface.OnClickListener() { // from class: com.baidu.searchbox.suspensionball.SuspensionBallManager.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (suspensionAddListener != null) {
                        suspensionAddListener.onResult(false);
                    }
                }
            }).show();
        }
    }

    private String getPageSource(JSONObject jSONObject) {
        try {
            return jSONObject.getString("page");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSuspensionBallInner(SuspensionBallEntity suspensionBallEntity) {
        suspensionBallEntity.createTime = System.currentTimeMillis();
        suspensionBallEntity.clickTimes = 0;
        if (mBallType == 1) {
            if (!this.mBallList.isEmpty()) {
                SuspensionBallEntity suspensionBallEntity2 = null;
                for (String str : this.mBallList.keySet()) {
                    suspensionBallEntity2 = this.mBallList.get(str);
                }
                this.mBallList.clear();
                if (suspensionBallEntity2 != null) {
                    suspensionBallEntity.mView = suspensionBallEntity2.mView;
                    if (suspensionBallEntity.mView != null) {
                        suspensionBallEntity.mView.updateData(suspensionBallEntity.key, suspensionBallEntity.image);
                    }
                    SuspensionWindowController.replace(suspensionBallEntity2.key, suspensionBallEntity.key);
                }
            }
            this.mBallList.put(suspensionBallEntity.key, suspensionBallEntity);
            SuspensionSpUtil.putBallData(this.mBallList);
        } else if (this.mBallList.containsKey(suspensionBallEntity.key)) {
            SuspensionBallEntity suspensionBallEntity3 = this.mBallList.get(suspensionBallEntity.key);
            suspensionBallEntity3.update(suspensionBallEntity);
            suspensionBallEntity = suspensionBallEntity3;
        } else {
            this.mBallList.put(suspensionBallEntity.key, suspensionBallEntity);
            SuspensionSpUtil.putBallData(this.mBallList);
        }
        showSuspensionBall(suspensionBallEntity.key);
    }

    public void removeSuspensionBall(Intent intent, SuspensionRemoveListener suspensionRemoveListener) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(SuspensionSchemeUtil.SUSPENSION_KEY);
            if (suspensionRemoveListener != null) {
                suspensionRemoveListener.removeStart(stringExtra);
            }
            removeSuspensionBall(stringExtra);
            UniversalToast.makeText(AppRuntime.getAppContext(), R.string.suspension_ball_cancel_toast).showToast();
            if (suspensionRemoveListener != null) {
                suspensionRemoveListener.removeEnd();
            }
        }
    }

    public void removeSuspensionBall(String str) {
        this.mBallList.remove(str);
        SuspensionSpUtil.putBallData(this.mBallList);
        SuspensionWindowController.destroy(str);
    }

    public boolean isInSuspensionBall(String str) {
        if (TextUtils.isEmpty(str) || this.mBallList.isEmpty()) {
            return false;
        }
        return this.mBallList.containsKey(str);
    }

    public boolean isSuspensionBallSwitchOn() {
        return this.isSuspensionBallSwitchOn;
    }

    public int getBallCenterXCoordinate() {
        return this.mBallInfo.mBallCenterXCoordinate;
    }

    public int getBallCenterYCoordinate() {
        return this.mBallInfo.mBallCenterYCoordinate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBallCenterXCoordinate(int i) {
        this.mBallInfo.mBallCenterXCoordinate = i;
        SuspensionSpUtil.putInt(SuspensionSpUtil.SUSPENSION_BALL_XCOORDINATE, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBallCenterYCoordinate(int i) {
        this.mBallInfo.mBallCenterYCoordinate = i;
        SuspensionSpUtil.putInt(SuspensionSpUtil.SUSPENSION_BALL_YCOORDINATE, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getBallRadius() {
        return this.mBallInfo.mRadius;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Rect getBallAreaPadding() {
        return this.mBallInfo.mLimitAreaPadding;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showAllSuspensionBall() {
        if (!this.mBallList.isEmpty()) {
            for (String str : this.mBallList.keySet()) {
                SuspensionBallEntity suspensionBallEntity = this.mBallList.get(str);
                if (suspensionBallEntity != null) {
                    SuspensionWindowController.show(suspensionBallEntity.key);
                }
            }
        }
    }

    public void hideAllSuspensionBall() {
        if (!this.mBallList.isEmpty()) {
            for (String str : this.mBallList.keySet()) {
                SuspensionBallEntity suspensionBallEntity = this.mBallList.get(str);
                if (suspensionBallEntity != null) {
                    SuspensionWindowController.hide(suspensionBallEntity.key);
                }
            }
        }
    }

    void showSuspensionBall(@NonNull String... strArr) {
        if (!this.mBallList.isEmpty() && strArr != null && strArr.length > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < strArr.length) {
                    if (this.mBallList.get(strArr[i2]) != null) {
                        SuspensionWindowController.show(strArr[i2]);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hideSuspensionBall(@NonNull String... strArr) {
        if (!this.mBallList.isEmpty() && strArr != null && strArr.length > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < strArr.length) {
                    if (this.mBallList.get(strArr[i2]) != null) {
                        SuspensionWindowController.hide(strArr[i2]);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasSuspensionBall() {
        return !this.mBallList.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SuspensionBallEntity getEntityByKey(String str) {
        return this.mBallList.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onBallClick(String str) {
        SuspensionBallEntity entityByKey = getEntityByKey(str);
        if (entityByKey != null) {
            this.mDispatcher.invoke(AppRuntime.getAppContext(), entityByKey);
        }
    }
}
