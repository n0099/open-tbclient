package com.baidu.searchbox.ng.ai.apps.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.camera.listener.CameraTimeOutListener;
import com.baidu.searchbox.ng.ai.apps.camera.manager.ICameraManager;
import com.baidu.searchbox.ng.ai.apps.camera.view.CameraPreview;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsCommonMessage;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public class AiAppsCameraManager implements ICameraManager {
    private static final boolean DEBUG = false;
    private static final String KEY_CAMERA = "camera";
    private static final String KEY_CAMERA_ID = "cameraId";
    private static final String KEY_EXCEPTION_TYPE = "eType";
    private static final String KEY_SLAVE_ID = "wvID";
    public static final String TAG = "AiAppsCameraManager";
    private static final String VALUE_EXCEPTION_ERROR = "error";
    private static final String VALUE_EXCEPTION_STOP = "stop";
    private CameraTimeOutListener mCameraTimeOutListener;
    private Timer mTimer;

    private AiAppsCameraManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SingletonHolder {
        private static final AiAppsCameraManager sInstance = new AiAppsCameraManager();

        private SingletonHolder() {
        }
    }

    public static AiAppsCameraManager getIns() {
        return SingletonHolder.sInstance;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.camera.manager.ICameraManager
    public boolean saveImage(byte[] bArr, String str, int i, int i2) {
        if (bArr == null || bArr.length == 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            if (i2 != 0) {
                Matrix matrix = new Matrix();
                matrix.reset();
                matrix.postRotate(i2);
                decodeByteArray = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            decodeByteArray.compress(Bitmap.CompressFormat.JPEG, i, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            return true;
        } catch (Exception e) {
            return false;
        } catch (OutOfMemoryError e2) {
            return false;
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.camera.manager.ICameraManager
    public CameraPreview getCameraPreviewBySlaveId(String str) {
        if (TextUtils.isEmpty(str) || cameraList.isEmpty()) {
            return null;
        }
        for (CameraPreview cameraPreview : cameraList) {
            if (cameraPreview != null && TextUtils.equals(cameraPreview.getSlaveId(), str)) {
                return cameraPreview;
            }
        }
        return null;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.camera.manager.ICameraManager
    public void addCameraPreview(CameraPreview cameraPreview) {
        cameraList.add(cameraPreview);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.camera.manager.ICameraManager
    public void removeCameraPreviewBySlaveId(String str) {
        CameraPreview cameraPreview;
        if (!TextUtils.isEmpty(str) && !cameraList.isEmpty()) {
            Iterator<CameraPreview> it = cameraList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cameraPreview = null;
                    break;
                }
                cameraPreview = it.next();
                if (cameraPreview != null && TextUtils.equals(cameraPreview.getSlaveId(), str)) {
                    break;
                }
            }
            if (cameraPreview != null) {
                cameraPreview.onRelease();
                cameraList.remove(cameraPreview);
            }
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.camera.manager.ICameraManager
    public void clearCameraList() {
        cameraList.clear();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.camera.manager.ICameraManager
    public void startTimer(int i, final CameraTimeOutListener cameraTimeOutListener) {
        this.mCameraTimeOutListener = cameraTimeOutListener;
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask() { // from class: com.baidu.searchbox.ng.ai.apps.camera.AiAppsCameraManager.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (cameraTimeOutListener != null) {
                    cameraTimeOutListener.timeOut();
                }
                AiAppsCameraManager.this.stopTimer();
            }
        }, i);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.camera.manager.ICameraManager
    public void stopTimer() {
        this.mCameraTimeOutListener = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.camera.manager.ICameraManager
    public void cancelTimer() {
        if (this.mCameraTimeOutListener != null) {
            this.mCameraTimeOutListener.cancel();
        }
        stopTimer();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.camera.manager.ICameraManager
    public void onAiAppForegroundChange(boolean z) {
        if (z) {
            cancelTimer();
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.camera.manager.ICameraManager
    public void onExceptionError(String str, String str2, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("wvID", str);
        hashMap.put(KEY_CAMERA_ID, str2);
        hashMap.put(KEY_EXCEPTION_TYPE, z ? "error" : "stop");
        AiAppsController.getInstance().sendJSMessage(new AiAppsCommonMessage("camera", hashMap));
    }

    @Override // com.baidu.searchbox.ng.ai.apps.camera.manager.ICameraManager
    public boolean hasCameraPermission(Context context) {
        return Build.VERSION.SDK_INT < 23 || ActivityCompat.checkSelfPermission(context, "android.permission.CAMERA") == 0;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.camera.manager.ICameraManager
    public boolean hasRecordPermission(Context context) {
        return Build.VERSION.SDK_INT < 23 || ActivityCompat.checkSelfPermission(context, "android.permission.RECORD_AUDIO") == 0;
    }
}
