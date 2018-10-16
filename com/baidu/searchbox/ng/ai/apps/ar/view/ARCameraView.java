package com.baidu.searchbox.ng.ai.apps.ar.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.ar.ARController;
import com.baidu.ar.DuMixCallback;
import com.baidu.ar.DuMixSource;
import com.baidu.ar.DuMixTarget;
import com.baidu.ar.TakePictureCallback;
import com.baidu.ar.audio.easy.EasyAudio;
import com.baidu.ar.base.MsgField;
import com.baidu.ar.base.RequestController;
import com.baidu.ar.bean.ARResource;
import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.recorder.MovieRecorderCallback;
import com.baidu.baiduarsdk.ArBridge;
import com.baidu.searchbox.ng.ai.apps.ar.camera.ARCameraManager;
import com.baidu.searchbox.ng.ai.apps.ar.camera.PreviewCallback;
import com.baidu.searchbox.ng.ai.apps.ar.draw.ARRenderer;
import com.baidu.searchbox.ng.ai.apps.ar.listener.ARCameraStateCallback;
import com.baidu.searchbox.ng.ai.apps.ar.listener.RecordListener;
import com.baidu.searchbox.ng.ai.apps.ar.listener.TakePhotoListener;
import com.baidu.searchbox.ng.ai.apps.ar.model.ARCameraAttr;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ARCameraView extends GLSurfaceView {
    private static final boolean DEBUG = false;
    private static final boolean ENABLE_STATUS_CHANGE_TOAST = false;
    private static final int MAX_RECORD_TIME = 10000;
    private static final String SEARCHBOX_AR_APPID = "2";
    private static final String SEARCHBOX_AR_APPKEY = "076dd2b8e9b783f95ae568be218e7c98";
    private static final String TAG = "ARCameraView";
    private ARCameraManager mARCameraManager;
    private ARCameraStateCallback mARCameraStateCallback;
    private ARController mARController;
    private DuMixCallback mARDuMixCallback;
    private ARRenderer mARRenderer;
    public ARCameraAttr mCameraAttr;
    public Context mContext;
    private boolean mStopForShare;
    private String mVideoPath;

    public ARCameraView(Context context, ARCameraAttr aRCameraAttr, ARCameraStateCallback aRCameraStateCallback) {
        super(context);
        this.mStopForShare = false;
        this.mARDuMixCallback = new DuMixCallback() { // from class: com.baidu.searchbox.ng.ai.apps.ar.view.ARCameraView.6
            @Override // com.baidu.ar.DuMixCallback
            public void onStateChange(int i, Object obj) {
                switch (i) {
                    case MsgField.MSG_ON_QUERY_RESOURCE_ERROR_SERVER /* 1802 */:
                    case 2301:
                    case MsgField.MSG_ON_DOWNLOAD_SO_ERROR /* 2303 */:
                    case MsgField.MSG_ON_DOWNLOAD_RES_ERROR /* 2305 */:
                    case MsgField.MSG_ON_PARSE_RESOURCE_UNZIP_ERROR /* 4202 */:
                    case MsgField.MSG_ON_PARSE_RESOURCE_JSON_ERROR /* 4203 */:
                        if (ARCameraView.this.mARCameraStateCallback != null) {
                            ARCameraView.this.mARCameraStateCallback.onLoadError();
                            return;
                        }
                        return;
                    case MsgField.IMSG_MODEL_LOADED /* 1817 */:
                        if (ARCameraView.this.mARCameraStateCallback != null) {
                            ARCameraView.this.mARCameraStateCallback.onLoadComplete();
                            return;
                        }
                        return;
                    case MsgField.IMSG_CLOUDAR_RECG_RESULT /* 2106 */:
                    case MsgField.MSG_ON_DEVICE_IR_RESULT /* 2503 */:
                        if (obj != null) {
                            try {
                                JSONObject jSONObject = new JSONObject(String.valueOf(obj));
                                if (jSONObject != null) {
                                    String optString = jSONObject.optString("ar_key");
                                    int optInt = jSONObject.optInt("ar_type");
                                    if (ARCameraView.this.mARController != null) {
                                        ARCameraView.this.mARController.switchCase(optString, optInt);
                                    }
                                    if (ARCameraView.this.mARCameraStateCallback != null) {
                                        ARCameraView.this.mARCameraStateCallback.onScanComplete();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            } catch (Exception e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                        return;
                    case MsgField.MSG_MOBILE_NETWORK_FOR_START_QUERY_RES /* 2504 */:
                        RequestController requestController = (RequestController) obj;
                        if (requestController != null) {
                            requestController.startRequest();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }

            private void showToast(String str) {
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onLuaMessage(HashMap<String, Object> hashMap) {
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onStateError(int i, String str) {
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onSetup(boolean z) {
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onCaseChange(boolean z) {
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onCaseCreated(ARResource aRResource) {
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onPause(boolean z) {
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onResume(boolean z) {
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onReset(boolean z) {
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onRelease(boolean z) {
            }
        };
        this.mContext = context;
        this.mCameraAttr = aRCameraAttr;
        setup(context, aRCameraAttr.getWidth(), aRCameraAttr.getHeight());
        this.mARCameraStateCallback = aRCameraStateCallback;
    }

    public String getSlaveId() {
        return this.mCameraAttr != null ? this.mCameraAttr.slaveId : "";
    }

    public void onCreate() {
    }

    public void onDestroy() {
        if (this.mARController != null) {
            this.mARController.release();
        }
        this.mStopForShare = false;
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        if (!this.mStopForShare) {
            if (this.mARController != null) {
                this.mARController.resume();
                ArBridge.getInstance().onResumeByUser();
            }
            if (this.mARRenderer != null) {
                this.mARRenderer.setPauseARDraw(false);
            }
        }
        if (this.mARCameraManager != null && this.mARRenderer != null) {
            this.mARCameraManager.startCamera(this.mARRenderer.getCameraTexture(), null);
            this.mARCameraManager.setPreviewCallback(new PreviewCallback() { // from class: com.baidu.searchbox.ng.ai.apps.ar.view.ARCameraView.1
                @Override // com.baidu.searchbox.ng.ai.apps.ar.camera.PreviewCallback
                public void onPreviewFrame(byte[] bArr, int i, int i2) {
                    if (ARCameraView.this.mARController != null) {
                        ARCameraView.this.mARController.onCameraPreviewFrame(bArr, i, i2);
                    }
                }
            });
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        if (this.mARController != null) {
            this.mARController.pause();
        }
        if (this.mARCameraManager != null) {
            this.mARCameraManager.stopCamera(null, true);
        }
    }

    public void resetCamera() {
        if (this.mARController != null) {
            this.mARController.resume();
            ArBridge.getInstance().onResumeByUser();
        }
        if (this.mARRenderer != null) {
            this.mARRenderer.setPauseARDraw(false);
        }
        this.mStopForShare = false;
    }

    public void updateAttr(ARCameraAttr aRCameraAttr) {
        if (aRCameraAttr != null) {
            this.mCameraAttr = aRCameraAttr;
            if (aRCameraAttr.hasReset()) {
                if (aRCameraAttr.isReset()) {
                    resetCamera();
                }
            } else if (aRCameraAttr.getFlash().equals(ARCameraAttr.FlashType.FLASH_ON)) {
                this.mARCameraManager.openFlash(null);
            } else {
                this.mARCameraManager.closeFlash(null);
            }
        }
    }

    public String getTakePhotoPath(String str) {
        return str + File.separator + "IMG_" + Calendar.getInstance().getTimeInMillis() + ".jpg";
    }

    public void takePhoto(String str, final TakePhotoListener takePhotoListener, final boolean z) {
        if (this.mARController == null) {
            takePhotoListener.onFailure();
        } else {
            this.mARController.takePicture(str, new TakePictureCallback() { // from class: com.baidu.searchbox.ng.ai.apps.ar.view.ARCameraView.2
                @Override // com.baidu.ar.TakePictureCallback
                public void onPictureTake(boolean z2, String str2) {
                    if (z2) {
                        takePhotoListener.onSuccess(str2);
                    } else {
                        takePhotoListener.onFailure();
                    }
                    if (z) {
                        ARCameraView.this.mARRenderer.setPauseARDraw(true);
                        ArBridge.getInstance().onPauseByUser();
                        ARCameraView.this.mStopForShare = true;
                    }
                }
            });
        }
    }

    public boolean startRecord(String str, final RecordListener recordListener, final boolean z) {
        if (this.mARController == null) {
            recordListener.onFailure();
            return false;
        }
        this.mVideoPath = str;
        this.mARController.startRecord(str, ErrDef.Feature.WEIGHT, new MovieRecorderCallback() { // from class: com.baidu.searchbox.ng.ai.apps.ar.view.ARCameraView.3
            @Override // com.baidu.ar.recorder.MovieRecorderCallback
            public void onRecorderStart(boolean z2) {
            }

            @Override // com.baidu.ar.recorder.MovieRecorderCallback
            public void onRecorderProcess(int i) {
                if (i <= 100) {
                    recordListener.onProgress(i);
                }
                if (i >= 100 && ARCameraView.this.mARController != null) {
                    ARCameraView.this.mARController.stopRecord();
                }
            }

            @Override // com.baidu.ar.recorder.MovieRecorderCallback
            public void onRecorderComplete(boolean z2, String str2) {
                if (z2) {
                    recordListener.onComplete(str2);
                } else {
                    recordListener.onFailure();
                }
                if (z) {
                    ARCameraView.this.mARRenderer.setPauseARDraw(true);
                    ArBridge.getInstance().onPauseByUser();
                    ARCameraView.this.mStopForShare = true;
                }
            }

            @Override // com.baidu.ar.recorder.MovieRecorderCallback
            public void onRecorderError(int i) {
                recordListener.onFailure();
            }
        });
        return true;
    }

    public boolean stopRecord() {
        if (this.mARController != null) {
            this.mARController.stopRecord();
            EasyAudio.getInstance().release();
            return true;
        }
        return false;
    }

    public String getVideoPath() {
        return this.mVideoPath;
    }

    public void removeVideoPath() {
        this.mVideoPath = null;
    }

    public void setup(Context context, int i, int i2) {
        if (this.mCameraAttr != null && context != null) {
            DuMixARConfig.setAppId("2");
            DuMixARConfig.setAPIKey(SEARCHBOX_AR_APPKEY);
            DuMixARConfig.setSecretKey("");
            String str = this.mCameraAttr.arKey;
            int i3 = 7;
            try {
                i3 = Integer.parseInt(this.mCameraAttr.arType);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mARController = new ARController(context);
            this.mARRenderer = new ARRenderer(false);
            setEGLContextClientVersion(2);
            setRenderer(this.mARRenderer);
            SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener = new SurfaceTexture.OnFrameAvailableListener() { // from class: com.baidu.searchbox.ng.ai.apps.ar.view.ARCameraView.4
                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                    ARCameraView.this.requestRender();
                }
            };
            DuMixSource duMixSource = new DuMixSource(this.mARRenderer.getCameraTexture(), i, i2);
            duMixSource.setArKey(str);
            duMixSource.setArType(i3);
            duMixSource.setCameraSource(null);
            DuMixTarget duMixTarget = new DuMixTarget(this.mARRenderer.getARTexture(), onFrameAvailableListener, i, i2, true);
            this.mARCameraManager = new ARCameraManager();
            this.mARController.setup(duMixSource, duMixTarget, this.mARDuMixCallback);
            this.mARController.resume();
            setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.searchbox.ng.ai.apps.ar.view.ARCameraView.5
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (ARCameraView.this.mStopForShare || ARCameraView.this.mARController == null) {
                        return false;
                    }
                    return ARCameraView.this.mARController.onTouchEvent(motionEvent);
                }
            });
        }
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        onCreate();
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        onDestroy();
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            onResume();
        } else if (i == 8) {
            onPause();
        }
    }
}
