package com.baidu.pass.biometrics.face.liveness.activity;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.idl.facesdk.FaceInfo;
import com.baidu.idl.facesdk.FaceSDK;
import com.baidu.idl.facesdk.FaceTracker;
import com.baidu.idl.facesdk.FaceVerifyData;
import com.baidu.pass.biometrics.base.armor.RimArmor;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.dynamicupdate.LocalConfigOptions;
import com.baidu.pass.biometrics.base.dynamicupdate.SdkConfigOptions;
import com.baidu.pass.biometrics.base.dynamicupdate.SoManager;
import com.baidu.pass.biometrics.base.http.HttpClientWrap;
import com.baidu.pass.biometrics.base.http.HttpHandlerWrap;
import com.baidu.pass.biometrics.base.http.HttpHashMapWrap;
import com.baidu.pass.biometrics.base.http.result.ContrastPortraitResult;
import com.baidu.pass.biometrics.base.restnet.beans.business.BeanConstants;
import com.baidu.pass.biometrics.base.result.PassBiometricResult;
import com.baidu.pass.biometrics.base.utils.Base64Utils;
import com.baidu.pass.biometrics.base.utils.PassBioDataEncryptor;
import com.baidu.pass.biometrics.base.utils.PassBioDisplayUtil;
import com.baidu.pass.biometrics.base.utils.PassBioGlobalUtils;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.pass.biometrics.base.utils.ViewUtility;
import com.baidu.pass.biometrics.face.R;
import com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.camera.CameraInterface;
import com.baidu.pass.biometrics.face.liveness.camera.CameraSurfaceView;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.pass.biometrics.face.liveness.utils.BioSensorManager;
import com.baidu.pass.biometrics.face.liveness.utils.enums.PassFaceRecogType;
import com.baidu.pass.biometrics.face.liveness.view.BioAlertDialog;
import com.baidu.pass.biometrics.face.liveness.view.ConstrastLoadingView;
import com.baidu.pass.biometrics.face.liveness.view.CustomAlertDialog;
import com.baidu.pass.biometrics.face.liveness.view.XfordView;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
@TargetApi(3)
/* loaded from: classes2.dex */
public class LivenessRecogActivity extends LivenessBaseActivity implements Handler.Callback {
    private static final int COUNTDOWNINTERVAL = 200;
    public static final String EXTRA_TIME_POINT_START = "time_point_start";
    private static final int HEAD_DOWN = 1;
    private static final int HEAD_EYES_BLINK = 0;
    private static final int HEAD_MOUTH_OPEN = 5;
    private static final int HEAD_POSE_STATE_OPEN = 1;
    private static final int HEAD_TURN_LEFT = 3;
    private static final int HEAD_TURN_RIGHT = 4;
    private static final int HEAD_UP = 2;
    private static final int IS_BRIGHTNESS_TOO_DARK = 2;
    private static final int IS_FACE_OUT_OR_RANGE = 4;
    private static final int IS_LOSE_FACE_FROM_CAMREA = 3;
    private static final int IS_TOO_FAR_FROM_CAMREA = 1;
    private static final int IS_TOO_NEAR_FROM_CAMERA = 0;
    private static final int MILLISINFUTURE = 5000;
    private static final int PERMISSION_REQUEST_CODE_CAMERA = 2002;
    private static final int SCREEN_MAX_BRIGHTNESS = 255;
    private static final String TAG = "LivenessRecog";
    private static final FaceTracker.ActionType action = FaceTracker.ActionType.RECOGNIZE;
    private AnimState animState;
    private ImageView backBtn;
    private PassFaceRecogCallback callback;
    private int cameraAngle;
    private byte[] cameraData;
    private CameraInterface cameraInterface;
    private int[] canvasBitmapSize;
    private ConstrastLoadingView constrastLoadingView;
    private int currentConstrastBeanPos;
    private FaceTracker.ErrCode errorCode;
    private byte[] faceData;
    private byte[] faceDigest;
    private FaceInfo[] faceInfos;
    private FaceRecognitionTask faceRecognitionTask;
    private ImageView faceStateIv;
    private FaceTracker faceTracker;
    private long firstLivenessRcogType;
    private int firstLivenessRecogTime;
    private boolean hasCameraReadyStatistics;
    private int headMode;
    private String[] headPoses;
    private int illumValue;
    private long lastCurMills;
    private SdkConfigOptions.LivenessConfigOption livenessConfig;
    private BioAlertDialog permissionAlertDialog;
    private ArrayList<HashMap<String, byte[]>> portraitList;
    private FrameLayout poseTipFl;
    private TextView poseTipTv;
    private FrameLayout poseTipWarningFl;
    private ImageView poseTipWarningIv;
    private TextView poseTipWarningTv;
    private int previewHeight;
    private int previewWidth;
    private ProcessState processState;
    private BioSensorManager sensorManager;
    private CameraSurfaceView surfaceView;
    private TimeCount timerCount;
    private int totalConstrastBeanCount;
    private Handler uiHandler;
    private ViewGroup viewGroup;
    private String voiceCredential;
    private XfordView xfordView;
    private int lastWaringType = -1;
    private int[] argbData = null;
    private boolean isActivityFinished = false;
    private int frameStack = 0;
    private Map<Integer, SoftReference<Bitmap>> bitmapCache = new ConcurrentHashMap();
    private List<int[]> cameraDataCache = new ArrayList();
    private boolean lifeCyclePause = false;
    private LivenessStat livenessStat = new LivenessStat();
    private boolean isLast = false;
    private boolean guideLiveness = true;
    private boolean whiteBgFlag = false;
    private boolean firstillumCallback = true;
    private Runnable recogTimeCountRunnable = new Runnable() { // from class: com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity.1
        @Override // java.lang.Runnable
        public void run() {
            if (LivenessRecogActivity.this.firstLivenessRcogType == 2) {
                LivenessRecogActivity.this.processState.stateFlag = 5;
                Log.w(LivenessRecogActivity.TAG, "timePointLivingEyeStart" + LivenessRecogActivity.this.livenessStat.timePointLivingEyeStart);
                LivenessRecogActivity.this.headMode = 0;
            } else {
                LivenessRecogActivity.this.processState.stateFlag = 7;
                Log.w(LivenessRecogActivity.TAG, "timePointLivingMouthStart" + LivenessRecogActivity.this.livenessStat.timePointLivingMouthStart);
                LivenessRecogActivity.this.headMode = 5;
            }
            long currentTimeMillis = 20000 - (System.currentTimeMillis() - LivenessRecogActivity.this.processState.wholeProcessStartTime);
            if (currentTimeMillis < 5000) {
                LivenessRecogActivity.this.processState.wholeProcessTimeOut = 25000 - currentTimeMillis;
            }
        }
    };
    Camera.PreviewCallback previewCallback = new Camera.PreviewCallback() { // from class: com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity.11
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            if (LivenessRecogActivity.this.processState.stateFlag != 0 && LivenessRecogActivity.this.processState.stateFlag != 10 && LivenessRecogActivity.this.processState.stateFlag != 17 && LivenessRecogActivity.this.processState.stateFlag != 19 && LivenessRecogActivity.this.processState.stateFlag != 18) {
                try {
                    if (LivenessRecogActivity.this.frameStack <= 0) {
                        LivenessRecogActivity.this.cameraData = bArr;
                        LivenessRecogActivity.this.doSomethingWithPreviewSize(camera);
                        LivenessRecogActivity.this.faceRecognitionTask = new FaceRecognitionTask();
                        LivenessRecogActivity.this.faceRecognitionTask.execute(new Void[0]);
                    }
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        }
    };
    private boolean isFinish = false;
    private int lastFaceId = -1;

    static /* synthetic */ int access$2004(LivenessRecogActivity livenessRecogActivity) {
        int i = livenessRecogActivity.frameStack + 1;
        livenessRecogActivity.frameStack = i;
        return i;
    }

    static /* synthetic */ int access$2006(LivenessRecogActivity livenessRecogActivity) {
        int i = livenessRecogActivity.frameStack - 1;
        livenessRecogActivity.frameStack = i;
        return i;
    }

    @Override // com.baidu.pass.biometrics.face.liveness.activity.LivenessBaseActivity, com.baidu.pass.biometrics.base.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setRequestedOrientation(1);
        super.onCreate(bundle);
        if (bundle != null) {
            this.hasCameraReadyStatistics = bundle.getBoolean("hasCameraReadyStatistics", false);
        }
        requestWindowFeature(1);
        getWindow().addFlags(67108864);
        getWindow().addFlags(128);
        this.viewGroup = (ViewGroup) View.inflate(this, R.layout.layout_pass_liveness_recognize, null);
        setContentView(this.viewGroup);
        this.livenessStat.timePointStart = getIntent().getLongExtra(EXTRA_TIME_POINT_START, System.currentTimeMillis());
        this.livenessStat.asyncGetPortraitType = 1;
        if (this.passFaceRecogDTO == null) {
            PassFaceRecogCallback passFaceRecogCallback = PassFaceRecogManager.getInstance().getPassFaceRecogCallback();
            if (passFaceRecogCallback != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(-205);
                passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_PARAM);
                passFaceRecogCallback.onFailure(passFaceRecogResult);
            }
            activityFinish(-205);
            return;
        }
        init();
        if (!this.livenessConfig.closeSkipLiving) {
            this.guideLiveness = this.passFaceRecogDTO.guideLiveness;
        }
        setupViews();
        this.sensorManager.registerSensorListener(new BioSensorManager.SensorCallback() { // from class: com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity.2
            @Override // com.baidu.pass.biometrics.face.liveness.utils.BioSensorManager.SensorCallback
            public void onChange(float f) {
                if (LivenessRecogActivity.this.firstillumCallback) {
                    LivenessRecogActivity.this.firstillumCallback = false;
                    if (LivenessRecogActivity.this.isUpdateWhiteBg(f)) {
                        LivenessRecogActivity.this.firstLivenessRcogType = 2L;
                        LivenessRecogActivity.this.headMode = 5;
                    }
                }
                LivenessRecogActivity.this.updateWhiteBg(f);
            }
        });
        requestCameraPermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String argb2String(int[] iArr) {
        CameraInterface.CameraSize previewSize = this.cameraInterface.getPreviewSize();
        Bitmap createBitmap = Bitmap.createBitmap(iArr, previewSize.height, previewSize.width, Bitmap.Config.ARGB_8888);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(Base64Utils.encode(byteArray));
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity$3] */
    @TargetApi(3)
    private void goToFaceMatchResult(final ContrastPortraitResult contrastPortraitResult) {
        if (this.callback != null && contrastPortraitResult != null) {
            new AsyncTask<Void, Void, PassFaceRecogResult>() { // from class: com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public PassFaceRecogResult doInBackground(Void... voidArr) {
                    byte[] encode;
                    int i = 0;
                    PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                    if (contrastPortraitResult.isProcessPass()) {
                        LivenessRecogActivity.this.livenessStat.faceMatchType = LivenessStat.TYPE_FACE_MATCH_PASS;
                        passFaceRecogResult.setResultCode(0);
                    } else {
                        LivenessRecogActivity.this.livenessStat.faceMatchType = LivenessStat.TYPE_FACE_MATCH_FAIL;
                        passFaceRecogResult.setResultCode(-302);
                    }
                    passFaceRecogResult.callbackkey = contrastPortraitResult.callbackkey;
                    if (!TextUtils.isEmpty(contrastPortraitResult.imgdigests) && LivenessRecogActivity.this.portraitList != null && LivenessRecogActivity.this.portraitList.size() > 0) {
                        int size = LivenessRecogActivity.this.portraitList.size();
                        while (true) {
                            if (i < size) {
                                byte[] bArr = (byte[]) ((HashMap) LivenessRecogActivity.this.portraitList.get(i)).get("digest");
                                if (bArr != null && contrastPortraitResult.imgdigests.equals(new String(bArr))) {
                                    break;
                                }
                                i++;
                            } else {
                                i = -1;
                                break;
                            }
                        }
                        if (i != -1 && LivenessRecogActivity.this.passFaceRecogDTO != null) {
                            if (LivenessRecogActivity.this.passFaceRecogDTO.isReturnOriginImage() && LivenessRecogActivity.this.cameraDataCache != null && LivenessRecogActivity.this.cameraDataCache.size() > 0) {
                                passFaceRecogResult.originalImage = LivenessRecogActivity.this.argb2String((int[]) LivenessRecogActivity.this.cameraDataCache.get((LivenessRecogActivity.this.cameraDataCache.size() - i) - 1));
                            }
                            if (LivenessRecogActivity.this.passFaceRecogDTO.isReturnCutImage()) {
                                byte[] bArr2 = (byte[]) ((HashMap) LivenessRecogActivity.this.portraitList.get(i)).get("data");
                                if (bArr2 != null && (encode = Base64Utils.encode(bArr2)) != null) {
                                    passFaceRecogResult.faceimage = new String(encode);
                                }
                                passFaceRecogResult.imgdigests = new String(contrastPortraitResult.imgdigests);
                            }
                        }
                    }
                    passFaceRecogResult.authSid = contrastPortraitResult.authsid;
                    return passFaceRecogResult;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(PassFaceRecogResult passFaceRecogResult) {
                    super.onPostExecute((AnonymousClass3) passFaceRecogResult);
                    if (contrastPortraitResult.isProcessPass()) {
                        LivenessRecogActivity.this.callback.onSuccess(passFaceRecogResult);
                    } else {
                        LivenessRecogActivity.this.callback.onFailure(passFaceRecogResult);
                    }
                    LivenessRecogActivity.this.activityFinish(passFaceRecogResult.getResultCode());
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackFailureOrContinueFaceDetect(int i, String str) {
        if (this.currentConstrastBeanPos == this.totalConstrastBeanCount) {
            this.livenessStat.faceMatchType = LivenessStat.TYPE_FACE_MATCH_FAIL;
            if (this.callback != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(i);
                passFaceRecogResult.setResultMsg(str);
                this.callback.onFailure(passFaceRecogResult);
                setActivityResult(-1);
                activityFinish(passFaceRecogResult.getResultCode());
                return;
            }
            return;
        }
        dofaceDetect();
    }

    @Override // com.baidu.pass.biometrics.base.activity.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lifeCyclePause) {
            this.lifeCyclePause = false;
            if (!this.processState.permissionFlag) {
                if (this.processState.stateFlag < 10) {
                    startLiveness();
                    openCamera();
                } else if (this.processState.stateFlag == 17) {
                    openCamera();
                }
            }
        }
    }

    @Override // com.baidu.pass.biometrics.base.activity.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.lifeCyclePause = true;
        if (!this.processState.permissionFlag) {
            this.timerCount.cancel();
            this.cameraInterface.doStopCamera();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    @Override // com.baidu.pass.biometrics.face.liveness.activity.LivenessBaseActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("hasCameraReadyStatistics", this.hasCameraReadyStatistics);
    }

    @Override // com.baidu.pass.biometrics.base.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.sensorManager != null) {
            this.sensorManager.unRegisterSensorListener();
        }
        this.isActivityFinished = true;
        this.argbData = null;
        this.cameraData = null;
        this.cameraDataCache.clear();
        this.cameraDataCache = null;
        try {
            clearBitmapCache();
            this.viewGroup.removeView(this.surfaceView);
            this.surfaceView = null;
            unbindDrawables(this.viewGroup);
            this.viewGroup.removeCallbacks(null);
            this.viewGroup = null;
            this.uiHandler.removeCallbacksAndMessages(null);
            System.gc();
        } catch (Exception e) {
            Log.e(e);
        }
    }

    private void unbindDrawables(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback(null);
            view.setBackgroundResource(0);
        }
        if (view instanceof ImageView) {
            ((ImageView) view).setImageBitmap(null);
        }
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                unbindDrawables(((ViewGroup) view).getChildAt(i));
            }
            ((ViewGroup) view).removeAllViews();
            view.setBackgroundResource(0);
        }
    }

    private void clearBitmapCache() {
        for (SoftReference<Bitmap> softReference : this.bitmapCache.values()) {
            Bitmap bitmap = softReference.get();
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void userCancel() {
        if (this.callback != null) {
            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
            passFaceRecogResult.setResultMsg(PassFaceRecogResult.ERROR_MSG_USER_CANCEL);
            passFaceRecogResult.setResultCode(-204);
            this.callback.onFailure(passFaceRecogResult);
        }
    }

    private void setupViews() {
        PassBioDisplayUtil.enableNavigationBarTint(this, getResources().getColor(17170445));
        setBrightness(this, 255);
        this.backBtn = (ImageView) findViewById(R.id.btn_cancel);
        this.backBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LivenessRecogActivity.this.userCancel();
                LivenessRecogActivity.this.btnBackStat();
                LivenessRecogActivity.this.setActivityResult(0);
                LivenessRecogActivity.this.activityFinish(-204);
                LivenessRecogActivity.this.cameraInterface.doStopCamera();
            }
        });
        this.poseTipFl = (FrameLayout) findViewById(R.id.layout_pose_tip);
        this.poseTipTv = (TextView) findViewById(R.id.tv_pose_tip);
        this.poseTipWarningFl = (FrameLayout) findViewById(R.id.layout_pose_warning);
        this.poseTipWarningIv = (ImageView) findViewById(R.id.iv_pose_warning_tip);
        this.poseTipWarningTv = (TextView) findViewById(R.id.tv_pose_warning_tip);
        this.constrastLoadingView = (ConstrastLoadingView) findViewById(R.id.constrastLoadingView);
        this.faceStateIv = (ImageView) findViewById(R.id.img_face_recognized_state);
        this.faceStateIv.setImageBitmap(getScaleBitmap(R.drawable.pass_liveness_recog_face_failed));
        this.surfaceView = new CameraSurfaceView(this, null);
        this.viewGroup.addView(this.surfaceView, 0, new ViewGroup.LayoutParams(-2, -1));
        this.cameraInterface = new CameraInterface();
        this.surfaceView.setCameraInterface(this.cameraInterface);
        this.surfaceView.setVisibility(4);
        this.xfordView = (XfordView) findViewById(R.id.xfordview);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnBackStat() {
        if (this.processState.stateFlag < 4) {
            this.livenessStat.clickCloseType = LivenessStat.TYPE_CLOSE_FIND_FACE;
        } else if (this.processState.stateFlag >= 4 && this.processState.stateFlag < 9) {
            if (this.headMode == 0) {
                this.livenessStat.clickCloseType = LivenessStat.TYPE_CLOSE_FIND_EYE;
            } else if (this.headMode == 5) {
                this.livenessStat.clickCloseType = LivenessStat.TYPE_CLOSE_FIND_MOUTH;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getHeadMode() {
        if (this.firstLivenessRcogType == 1) {
            this.headMode = 0;
        } else {
            this.headMode = 5;
        }
        return this.headMode;
    }

    private void init() {
        this.headPoses = getResources().getStringArray(R.array.pass_liveness_head_pose);
        this.uiHandler = new Handler(Looper.getMainLooper(), this);
        this.processState = new ProcessState();
        this.animState = new AnimState();
        this.timerCount = new TimeCount(5000L, 200L);
        this.processState.wholeProcessStartTime = System.currentTimeMillis();
        this.livenessStat.subPro = this.passFaceRecogDTO.getSpno();
        this.callback = PassFaceRecogManager.getInstance().getPassFaceRecogCallback();
        initOnlineConfig();
        this.headMode = getHeadMode();
        initLiveness();
        this.illumValue = getOnlineIllum();
        this.livenessStat.onLineIllum = this.illumValue;
        this.sensorManager = new BioSensorManager(this);
    }

    private void initOnlineConfig() {
        this.livenessConfig = LocalConfigOptions.getInstance(this).getBioOptions().livenessConfigOption;
        this.firstLivenessRecogTime = this.livenessConfig.getRecogtimeInterval();
        this.firstLivenessRcogType = this.livenessConfig.getRecogActionType();
    }

    private void initLiveness() {
        try {
            loadSo();
            initFaceTracker();
        } catch (Exception e) {
            if (this.callback != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(PassFaceRecogResult.ERROR_CODE_FACE_SDK_INIT_FAIL);
                this.callback.onFailure(passFaceRecogResult);
            }
            setActivityResult(0);
            activityFinish(PassFaceRecogResult.ERROR_CODE_FACE_SDK_INIT_FAIL);
        }
    }

    private void loadSo() throws Exception {
        Bundle bundle = new Bundle();
        bundle.putString("uuid", this.passFaceRecogDTO.processid);
        bundle.putString(TableDefine.PaSubscribeColumns.COLUMN_TPL, BeanConstants.tpl);
        bundle.putString("productId", this.passFaceRecogDTO.getSpno());
        if (!SoManager.load(this, bundle)) {
            throw new Exception("load so failure");
        }
    }

    private void initFaceTracker() throws Exception {
        String token = RimArmor.getInstance().getToken();
        if (TextUtils.isEmpty(token) || TextUtils.isEmpty("frfsd_ai")) {
            throw new Exception("idlToken or apiKey is empty");
        }
        try {
            this.faceTracker = new FaceTracker(getAssets(), this, "frfsd_ai", token, "", FaceSDK.AlignMethodType.SDM_7PTS, FaceSDK.ParsMethodType.NOT_USE);
            this.faceTracker.set_isFineAlign(false);
            this.faceTracker.set_isVerifyLive(true);
            this.faceTracker.set_min_face_size(this.livenessConfig.getMinFaceSize());
            this.faceTracker.set_illum_thr(this.livenessConfig.getIllumThr());
            this.faceTracker.set_track_by_detection_interval(this.livenessConfig.getTrackInterval());
            this.faceTracker.set_detect_in_video_interval(this.livenessConfig.getDetectInterval());
            this.faceTracker.set_eulur_angle_thr(this.livenessConfig.getYaw(), this.livenessConfig.getPitch(), this.livenessConfig.getRoll());
            this.faceTracker.set_max_reg_img_num(this.livenessConfig.getMaxRegImgNum());
            this.faceTracker.set_prefetch_reg_img_interval(this.livenessConfig.getPrefetchRegImgInterval());
            this.faceTracker.set_cropFaceSize(this.livenessConfig.getCropFaceSize());
            this.faceTracker.set_cropFaceEnlargeRatio(this.livenessConfig.getCropFaceRatio());
        } catch (Exception e) {
            throw new Exception("init faceTracker failure: " + e.getMessage());
        }
    }

    private boolean openCamera() {
        this.surfaceView.setVisibility(4);
        boolean doOpenCamera = this.cameraInterface.doOpenCamera(this, 3);
        if (!doOpenCamera) {
            showPermissionDialog();
        } else {
            CameraInterface.CameraSize previewSize = this.cameraInterface.getPreviewSize();
            bindSurfaceView(previewSize);
            this.cameraInterface.setPreviewCallback(this.previewCallback);
            this.surfaceView.startPreview();
            this.livenessStat.previewSize = previewSize.height + Constants.ACCEPT_TIME_SEPARATOR_SP + previewSize.width;
        }
        this.surfaceView.setVisibility(0);
        return doOpenCamera;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(9)
    public void doSomethingWithPreviewSize(Camera camera) {
        if (this.previewWidth == 0) {
            Camera.Size previewSize = camera.getParameters().getPreviewSize();
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            if (this.cameraInterface.isFrontCamera()) {
                Camera.getCameraInfo(1, cameraInfo);
            } else {
                Camera.getCameraInfo(0, cameraInfo);
            }
            this.previewWidth = previewSize.width;
            this.previewHeight = previewSize.height;
            this.cameraAngle = cameraInfo.orientation;
        }
        if (this.canvasBitmapSize == null) {
            this.canvasBitmapSize = new int[2];
            this.canvasBitmapSize[0] = this.previewHeight;
            this.canvasBitmapSize[1] = this.previewWidth;
        }
        if (this.livenessConfig == null || TextUtils.isEmpty(this.livenessConfig.minFaceSize)) {
            if (this.previewWidth > 640 && this.previewHeight > 480) {
                this.faceTracker.set_min_face_size(200);
            } else {
                this.faceTracker.set_min_face_size(100);
            }
        }
        if (this.argbData == null) {
            this.argbData = new int[this.previewWidth * this.previewHeight];
        }
    }

    private void bindSurfaceView(CameraInterface.CameraSize cameraSize) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.surfaceView.getLayoutParams());
        CameraInterface.CameraSize surfaceViewSize = getSurfaceViewSize(cameraSize);
        if (surfaceViewSize == null || (surfaceViewSize.width == cameraSize.width && surfaceViewSize.height == cameraSize.height)) {
            layoutParams.width = -2;
            layoutParams.height = -1;
        } else {
            layoutParams.width = surfaceViewSize.width;
            layoutParams.height = surfaceViewSize.height;
        }
        this.surfaceView.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetViews() {
        this.poseTipWarningFl.setVisibility(4);
        this.lastWaringType = -1;
        this.poseTipTv.setText(R.string.pass_liveness_put_face_round);
        if (this.faceStateIv != null) {
            this.faceStateIv.setImageBitmap(getScaleBitmap(R.drawable.pass_liveness_recog_face_failed));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLiveness() {
        this.processState.wholeProcessStartTime = System.currentTimeMillis();
        startPoseTipAnim(0);
        this.timerCount.start();
        this.livenessStat.timePointStartFindFace = System.currentTimeMillis();
    }

    private CameraInterface.CameraSize getSurfaceViewSize(CameraInterface.CameraSize cameraSize) {
        if (cameraSize == null) {
            return null;
        }
        CameraInterface.CameraSize displaySize = getDisplaySize();
        CameraInterface.CameraSize cameraSize2 = new CameraInterface.CameraSize(cameraSize.width, cameraSize.height);
        float f = cameraSize.width / cameraSize.height;
        float f2 = displaySize.height / displaySize.width;
        if (Math.abs(f - f2) > 0.02d) {
            if (f < f2) {
                cameraSize2.width = (displaySize.height * cameraSize.height) / cameraSize.width;
                cameraSize2.height = displaySize.height;
                return cameraSize2;
            }
            cameraSize2.width = displaySize.width;
            cameraSize2.height = (displaySize.width * cameraSize.width) / cameraSize.height;
            return cameraSize2;
        }
        return cameraSize2;
    }

    private CameraInterface.CameraSize getDisplaySize() {
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        return new CameraInterface.CameraSize(defaultDisplay.getWidth(), defaultDisplay.getHeight() + PassBioDisplayUtil.getNavigationBarHeight(this));
    }

    @TargetApi(23)
    private void requestCameraPermission() {
        if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission("android.permission.CAMERA") != 0) {
            if (!this.configuration.showPmnRationaleDialog) {
                this.processState.permissionFlag = true;
                requestPermissions(new String[]{"android.permission.CAMERA"}, 2002);
                return;
            } else if (shouldShowRequestPermissionRationale("android.permission.CAMERA")) {
                final CustomAlertDialog customAlertDialog = new CustomAlertDialog(this);
                customAlertDialog.setPositiveBtn(getString(R.string.pass_bio_pmn_ok), new View.OnClickListener() { // from class: com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ViewUtility.dismissDialog(LivenessRecogActivity.this, customAlertDialog);
                        LivenessRecogActivity.this.processState.permissionFlag = true;
                        LivenessRecogActivity.this.requestPermissions(new String[]{"android.permission.CAMERA"}, 2002);
                    }
                });
                customAlertDialog.setNegativeBtn(getString(R.string.pass_bio_pmn_cancel), new View.OnClickListener() { // from class: com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ViewUtility.dismissDialog(LivenessRecogActivity.this, customAlertDialog);
                        if (LivenessRecogActivity.this.callback != null) {
                            PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                            passFaceRecogResult.setResultCode(PassFaceRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION);
                            LivenessRecogActivity.this.callback.onFailure(passFaceRecogResult);
                        }
                        LivenessRecogActivity.this.activityFinish(PassFaceRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION);
                    }
                });
                customAlertDialog.setTitleText(String.format(getString(R.string.pass_bio_pmn_title_liveness), PassBiometricUtil.getAppName(this), getString(R.string.pass_bio_pmn_camera)));
                customAlertDialog.setMessageText(String.format(getString(R.string.pass_bio_pmn_msg_liveness), PassBiometricUtil.getAppName(this), getString(R.string.pass_bio_pmn_camera)));
                customAlertDialog.show();
                return;
            } else {
                this.processState.permissionFlag = true;
                requestPermissions(new String[]{"android.permission.CAMERA"}, 2002);
                return;
            }
        }
        this.livenessStat.timePointStartRecog = System.currentTimeMillis();
        startLiveness();
        if (openCamera()) {
            this.livenessStat.withCameraPermission = 1;
            this.livenessStat.timePointCameraReady = System.currentTimeMillis();
        }
    }

    private void showVerifyTimeoutDialog() {
        this.livenessStat.tipOverTime = 1;
        this.processState.stateFlag = 17;
        this.uiHandler.removeCallbacks(this.recogTimeCountRunnable);
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setTitleMsg(getString(R.string.pass_face_timeout_dialog_title));
        bioAlertDialog.setTimeOutVisible(0);
        bioAlertDialog.setMessageText(getString(R.string.pass_face_timeout_dialog_msg));
        bioAlertDialog.setPositiveBtn(getString(R.string.pass_liveness_dialog_recognized_fail_cancel), new View.OnClickListener() { // from class: com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.w(LivenessRecogActivity.TAG, "showVerifyTimeoutDialog, livenessStat.resetTimePoint()");
                LivenessRecogActivity.this.livenessStat.resetTimePoint();
                LivenessRecogActivity.this.livenessStat.tipOverTimeRetry = 1;
                LivenessRecogActivity.this.resetViews();
                LivenessRecogActivity.this.processState.stateFlag = 1;
                LivenessRecogActivity.this.startLiveness();
                LivenessRecogActivity.this.headMode = LivenessRecogActivity.this.getHeadMode();
                LivenessRecogActivity.this.animState.startBlinkAnimFlag = false;
                LivenessRecogActivity.this.animState.startMouthOpenAnimFlag = false;
                LivenessRecogActivity.this.processState.wholeProcessStartTime = System.currentTimeMillis();
                bioAlertDialog.dismiss();
            }
        });
        bioAlertDialog.setNegativeBtn(getString(R.string.pass_bio_cancel), new View.OnClickListener() { // from class: com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
                LivenessRecogActivity.this.userCancel();
                LivenessRecogActivity.this.cameraInterface.doStopCamera();
                LivenessRecogActivity.this.livenessStat.tipOverTimeCancel = 1;
                LivenessRecogActivity.this.setActivityResult(0);
                LivenessRecogActivity.this.activityFinish(-204);
            }
        });
        bioAlertDialog.setCancelable(false);
        if (!isFinishing() && !bioAlertDialog.isShowing()) {
            bioAlertDialog.show();
        }
    }

    private void showChangeDeviceDialog() {
        this.livenessStat.tipOverTimeAgain = 1;
        this.processState.stateFlag = 17;
        this.uiHandler.removeCallbacks(this.recogTimeCountRunnable);
        final BioAlertDialog bioAlertDialog = new BioAlertDialog(this);
        bioAlertDialog.setDialogMsg(getString(R.string.pass_liveness_recog_fail_dialog_msg));
        bioAlertDialog.setDialogMsgColor(getResources().getColor(R.color.pass_bio_dialog_title_text_color));
        bioAlertDialog.setBtnCount(1);
        bioAlertDialog.setNeutralBtn(getString(R.string.pass_bio_alert_dialog_btn_ok), new View.OnClickListener() { // from class: com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                bioAlertDialog.dismiss();
                LivenessRecogActivity.this.livenessStat.tipOverTimeSure = 1;
                LivenessRecogActivity.this.setActivityResult(-1);
                if (LivenessRecogActivity.this.callback != null) {
                    PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                    passFaceRecogResult.setResultCode(-301);
                    LivenessRecogActivity.this.callback.onFailure(passFaceRecogResult);
                }
                LivenessRecogActivity.this.activityFinish(-301);
            }
        });
        bioAlertDialog.setCancelable(false);
        if (!isFinishing() && !bioAlertDialog.isShowing()) {
            bioAlertDialog.show();
        }
    }

    private void showPermissionDialog() {
        this.processState.permissionFlag = true;
        if (this.permissionAlertDialog == null) {
            this.permissionAlertDialog = new BioAlertDialog(this);
            this.permissionAlertDialog.setTitleMsg(getString(R.string.pass_bio_permission_request));
            this.permissionAlertDialog.setTitleVisible(true);
            this.permissionAlertDialog.setDialogMsg(String.format(getString(R.string.pass_liveness_permission_camera), PassBiometricUtil.getAppName(this)));
            this.permissionAlertDialog.setBtnCount(1);
            this.permissionAlertDialog.setNeutralBtn(getString(R.string.pass_bio_alert_dialog_btn_ok), new View.OnClickListener() { // from class: com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LivenessRecogActivity.this.permissionAlertDialog.dismiss();
                    LivenessRecogActivity.this.processState.permissionFlag = false;
                    if (LivenessRecogActivity.this.callback != null) {
                        PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                        passFaceRecogResult.setResultCode(PassFaceRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION);
                        LivenessRecogActivity.this.callback.onFailure(passFaceRecogResult);
                    }
                    LivenessRecogActivity.this.activityFinish(PassFaceRecogResult.ERROR_CODE_MAY_BE_NO_CAMERA_PERMISSION);
                }
            });
        }
        this.permissionAlertDialog.setCancelable(false);
        if (!isFinishing() && !this.permissionAlertDialog.isShowing()) {
            this.permissionAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(9)
    public void faceRecognize() {
        if (this.cameraData != null && this.argbData != null && !this.isActivityFinished) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                FaceSDK.getARGBFromYUVimg(this.cameraData, this.argbData, this.previewWidth, this.previewHeight, this.cameraAngle, 1);
                this.errorCode = this.faceTracker.face_verification(this.argbData, this.previewWidth, this.previewHeight, FaceSDK.ImgType.ARGB, action, "", "", "");
                Log.w(TAG, "errorcode:" + this.errorCode);
                this.faceInfos = this.faceTracker.get_TrackedFaceInfo();
                int i = (this.faceInfos == null || this.faceInfos.length <= 0 || this.faceInfos[0] == null) ? 0 : this.faceInfos[0].face_id;
                if (i != 0 && i != this.lastFaceId) {
                    this.cameraDataCache.clear();
                }
                this.lastFaceId = i;
                if (this.errorCode == FaceTracker.ErrCode.DATA_HIT_ONE) {
                    if (this.isFinish) {
                        this.cameraDataCache.clear();
                        this.isFinish = false;
                    }
                    if (this.argbData != null) {
                        this.cameraDataCache.add(Arrays.copyOf(this.argbData, this.argbData.length));
                    }
                } else if (this.errorCode == FaceTracker.ErrCode.DATA_HIT_LAST) {
                    if (this.argbData != null) {
                        this.cameraDataCache.add(Arrays.copyOf(this.argbData, this.argbData.length));
                    }
                    this.isFinish = true;
                }
                this.cameraData = null;
                if (this.faceInfos != null && this.faceInfos.length > 0 && this.faceInfos[0] != null) {
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    Log.w(TAG, "idl tracker time" + currentTimeMillis2);
                    LivenessStat livenessStat = this.livenessStat;
                    livenessStat.timePointIdlTrackTimeAll = currentTimeMillis2 + livenessStat.timePointIdlTrackTimeAll;
                    this.livenessStat.timePointIdlTrackCounts++;
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class FaceRecognitionTask extends AsyncTask<Void, Void, String> {
        private FaceRecognitionTask() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(Void... voidArr) {
            LivenessRecogActivity.access$2004(LivenessRecogActivity.this);
            LivenessRecogActivity.this.faceRecognize();
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((FaceRecognitionTask) str);
            LivenessRecogActivity.access$2006(LivenessRecogActivity.this);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class TimeCount extends CountDownTimer {
        public TimeCount(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            if (LivenessRecogActivity.this.processState.stateFlag != 0 && LivenessRecogActivity.this.processState.stateFlag != 17 && LivenessRecogActivity.this.processState.stateFlag != 19 && LivenessRecogActivity.this.processState.stateFlag != 18 && LivenessRecogActivity.this.processState.stateFlag != 10) {
                FaceInfo[] faceInfoArr = LivenessRecogActivity.this.faceInfos;
                if (LivenessRecogActivity.this.processState.stateFlag == 1) {
                    if (LivenessRecogActivity.this.isTimeOut()) {
                        LivenessRecogActivity.this.handleTimeOut();
                        return;
                    } else if (LivenessRecogActivity.this.isHasFace(faceInfoArr)) {
                        if (LivenessRecogActivity.this.errorCode == FaceTracker.ErrCode.POOR_ILLUMINATION) {
                            LivenessRecogActivity.this.startPoseWarningAnim(2);
                            return;
                        } else if (LivenessRecogActivity.this.isAngleOfRange(faceInfoArr[0], LivenessRecogActivity.this.errorCode)) {
                            LivenessRecogActivity.this.startPoseWarningAnim(4);
                            return;
                        } else if (!LivenessRecogActivity.this.isFaceInsideRound(faceInfoArr)) {
                            LivenessRecogActivity.this.lastWaringType = -1;
                            LivenessRecogActivity.this.poseTipWarningFl.setVisibility(8);
                            LivenessRecogActivity.this.faceStateIv.setImageBitmap(LivenessRecogActivity.this.getScaleBitmap(R.drawable.pass_liveness_recog_face_failed));
                            LivenessRecogActivity.this.processState.firstFindFaceFlag = false;
                            LivenessRecogActivity.this.livenessStat.findFaceLast = 0;
                            Log.w(LivenessRecogActivity.TAG, "STATE_START_RECOGNIZE, livenessStat.resetTimePoint()");
                            return;
                        } else if (PassBiometricUtil.isTooFarFromCamera(faceInfoArr[0].landmarks, LivenessRecogActivity.this.canvasBitmapSize)) {
                            LivenessRecogActivity.this.startPoseWarningAnim(1);
                            return;
                        } else if (PassBiometricUtil.isTooNearFromCamera(faceInfoArr[0].landmarks, LivenessRecogActivity.this.canvasBitmapSize)) {
                            LivenessRecogActivity.this.startPoseWarningAnim(0);
                            return;
                        } else {
                            LivenessRecogActivity.this.lastWaringType = -1;
                            LivenessRecogActivity.this.poseTipWarningFl.setVisibility(8);
                            LivenessRecogActivity.this.processState.stateFlag = 2;
                            if (!LivenessRecogActivity.this.processState.firstFindFaceFlag) {
                                LivenessRecogActivity.this.faceStateIv.setImageBitmap(LivenessRecogActivity.this.getScaleBitmap(R.drawable.pass_liveness_recog_face_successed));
                                LivenessRecogActivity.this.lastCurMills = System.currentTimeMillis();
                                LivenessRecogActivity.this.processState.firstFindFaceFlag = true;
                            }
                            LivenessRecogActivity.this.startRecognizingAnim();
                            LivenessRecogActivity.this.liveNessDetect(faceInfoArr);
                            return;
                        }
                    } else {
                        LivenessRecogActivity.this.faceStateIv.setImageBitmap(LivenessRecogActivity.this.getScaleBitmap(R.drawable.pass_liveness_recog_face_failed));
                        LivenessRecogActivity.this.processState.firstFindFaceFlag = false;
                        LivenessRecogActivity.this.lastWaringType = -1;
                        LivenessRecogActivity.this.poseTipWarningFl.setVisibility(8);
                        return;
                    }
                }
                if (LivenessRecogActivity.this.processState.stateFlag == 4) {
                    if (LivenessRecogActivity.this.isTimeOut()) {
                        LivenessRecogActivity.this.handleTimeOut();
                        return;
                    } else if (LivenessRecogActivity.this.isHasFace(faceInfoArr)) {
                        LivenessRecogActivity.this.lastWaringType = -1;
                        LivenessRecogActivity.this.poseTipWarningFl.setVisibility(8);
                        if (LivenessRecogActivity.this.isFaceInsideRound(faceInfoArr)) {
                            if (LivenessRecogActivity.this.meetStartTrackRequirement(faceInfoArr)) {
                                if (LivenessRecogActivity.this.firstLivenessRcogType == 1) {
                                    LivenessRecogActivity.this.processState.stateFlag = 5;
                                } else {
                                    LivenessRecogActivity.this.processState.stateFlag = 7;
                                }
                                LivenessRecogActivity.this.livenessStat.timePointLivingEyeStart = System.currentTimeMillis();
                                LivenessRecogActivity.this.livenessStat.timePointLivingMouthStart = System.currentTimeMillis();
                                Log.w(LivenessRecogActivity.TAG, "timePointLivingMouthStart" + LivenessRecogActivity.this.livenessStat.timePointLivingMouthStart);
                                LivenessRecogActivity.this.liveNessDetect(faceInfoArr);
                                long j2 = LivenessRecogActivity.this.firstLivenessRecogTime * 1000;
                                if (j2 < 20000) {
                                    LivenessRecogActivity.this.uiHandler.postDelayed(LivenessRecogActivity.this.recogTimeCountRunnable, j2);
                                }
                            } else {
                                LivenessRecogActivity.this.processState.stateFlag = 1;
                                LivenessRecogActivity.this.faceStateIv.setImageBitmap(LivenessRecogActivity.this.getScaleBitmap(R.drawable.pass_liveness_recog_face_failed));
                                LivenessRecogActivity.this.livenessStat.resetTimePoint();
                                Log.w(LivenessRecogActivity.TAG, "STATE_FIND_FACE_SPECIAL_ANIM_DONE, livenessStat.resetTimePoint()");
                                LivenessRecogActivity.this.processState.firstFindFaceFlag = false;
                                LivenessRecogActivity.this.livenessStat.findFaceLast = 0;
                                LivenessRecogActivity.this.livenessStat.timePointStartFindFace = System.currentTimeMillis();
                                return;
                            }
                        }
                    } else {
                        LivenessRecogActivity.this.processState.stateFlag = 1;
                        LivenessRecogActivity.this.faceStateIv.setImageBitmap(LivenessRecogActivity.this.getScaleBitmap(R.drawable.pass_liveness_recog_face_failed));
                        LivenessRecogActivity.this.livenessStat.resetTimePoint();
                        Log.w(LivenessRecogActivity.TAG, "STATE_FIND_FACE_SPECIAL_ANIM_DONE NO FACE, livenessStat.resetTimePoint()");
                        LivenessRecogActivity.this.processState.firstFindFaceFlag = false;
                        LivenessRecogActivity.this.livenessStat.findFaceLast = 0;
                        LivenessRecogActivity.this.livenessStat.timePointStartFindFace = System.currentTimeMillis();
                        return;
                    }
                }
                if (LivenessRecogActivity.this.processState.stateFlag == 5) {
                    if (LivenessRecogActivity.this.isHasFace(faceInfoArr)) {
                        LivenessRecogActivity.this.lastWaringType = -1;
                        LivenessRecogActivity.this.poseTipWarningFl.setVisibility(8);
                    }
                    if (!LivenessRecogActivity.this.animState.startBlinkAnimFlag) {
                        LivenessRecogActivity.this.startPoseTipAnim(1);
                        LivenessRecogActivity.this.animState.startBlinkAnimFlag = true;
                    }
                } else if (LivenessRecogActivity.this.processState.stateFlag == 7) {
                    if (LivenessRecogActivity.this.isHasFace(faceInfoArr)) {
                        LivenessRecogActivity.this.lastWaringType = -1;
                        LivenessRecogActivity.this.poseTipWarningFl.setVisibility(8);
                    }
                    if (!LivenessRecogActivity.this.animState.startMouthOpenAnimFlag) {
                        LivenessRecogActivity.this.startPoseTipAnim(3);
                        LivenessRecogActivity.this.animState.startMouthOpenAnimFlag = true;
                    }
                }
                Log.e(LivenessRecogActivity.TAG, "state STATE_START_TRACK_BLICK state", Integer.valueOf(LivenessRecogActivity.this.processState.stateFlag));
                if (LivenessRecogActivity.this.processState.stateFlag == 6 || LivenessRecogActivity.this.processState.stateFlag == 8) {
                    Log.e(LivenessRecogActivity.TAG, "state STATE_START_TRACK_BLICK");
                    if (LivenessRecogActivity.this.isTimeOut()) {
                        LivenessRecogActivity.this.handleTimeOut();
                        return;
                    } else if (LivenessRecogActivity.this.isHasFace(faceInfoArr)) {
                        if (LivenessRecogActivity.this.errorCode == FaceTracker.ErrCode.POOR_ILLUMINATION) {
                            LivenessRecogActivity.this.startPoseWarningAnim(2);
                            return;
                        } else if (LivenessRecogActivity.this.isAngleOfRange(faceInfoArr[0], LivenessRecogActivity.this.errorCode)) {
                            LivenessRecogActivity.this.startPoseWarningAnim(4);
                            return;
                        } else if (!LivenessRecogActivity.this.isFaceInsideRound(faceInfoArr)) {
                            LivenessRecogActivity.this.lastWaringType = -1;
                            LivenessRecogActivity.this.poseTipWarningFl.setVisibility(8);
                            return;
                        } else if (PassBiometricUtil.isTooFarFromCamera(faceInfoArr[0].landmarks, LivenessRecogActivity.this.canvasBitmapSize)) {
                            LivenessRecogActivity.this.startPoseWarningAnim(1);
                            return;
                        } else if (PassBiometricUtil.isTooNearFromCamera(faceInfoArr[0].landmarks, LivenessRecogActivity.this.canvasBitmapSize)) {
                            LivenessRecogActivity.this.startPoseWarningAnim(0);
                            return;
                        } else {
                            LivenessRecogActivity.this.lastWaringType = -1;
                            LivenessRecogActivity.this.poseTipWarningFl.setVisibility(8);
                            LivenessRecogActivity.this.liveNessDetect(faceInfoArr);
                        }
                    } else {
                        LivenessRecogActivity.this.startPoseWarningAnim(3);
                        LivenessRecogActivity.this.processState.blickFindFaceFlag = false;
                        return;
                    }
                }
                if (LivenessRecogActivity.this.processState.stateFlag == 9) {
                    if (LivenessRecogActivity.this.isTimeOut()) {
                        LivenessRecogActivity.this.handleTimeOut();
                        return;
                    } else if (LivenessRecogActivity.this.isHasFace(faceInfoArr)) {
                        if (LivenessRecogActivity.this.errorCode == FaceTracker.ErrCode.POOR_ILLUMINATION) {
                            LivenessRecogActivity.this.startPoseWarningAnim(2);
                            return;
                        } else if (LivenessRecogActivity.this.isAngleOfRange(faceInfoArr[0], LivenessRecogActivity.this.errorCode)) {
                            LivenessRecogActivity.this.startPoseWarningAnim(4);
                            return;
                        } else if (LivenessRecogActivity.this.isFaceInsideRound(faceInfoArr)) {
                            if (PassBiometricUtil.isTooFarFromCamera(faceInfoArr[0].landmarks, LivenessRecogActivity.this.canvasBitmapSize)) {
                                LivenessRecogActivity.this.startPoseWarningAnim(1);
                                return;
                            } else if (PassBiometricUtil.isTooNearFromCamera(faceInfoArr[0].landmarks, LivenessRecogActivity.this.canvasBitmapSize)) {
                                LivenessRecogActivity.this.startPoseWarningAnim(0);
                                return;
                            } else {
                                LivenessRecogActivity.this.lastWaringType = -1;
                                LivenessRecogActivity.this.poseTipWarningFl.setVisibility(8);
                            }
                        }
                    } else {
                        LivenessRecogActivity.this.startPoseWarningAnim(3);
                        LivenessRecogActivity.this.processState.blickFindFaceFlag = false;
                        return;
                    }
                }
                Log.w(LivenessRecogActivity.TAG, "onTick|state" + LivenessRecogActivity.this.processState.stateFlag + "|errcode|" + LivenessRecogActivity.this.errorCode);
                if (LivenessRecogActivity.this.isHasFace(faceInfoArr) && !LivenessRecogActivity.this.isActivityFinished) {
                    if ((LivenessRecogActivity.this.processState.stateFlag == 9 || LivenessRecogActivity.this.processState.stateFlag == 20) && LivenessRecogActivity.this.errorCode == FaceTracker.ErrCode.OK) {
                        FaceVerifyData[] faceVerifyDataArr = LivenessRecogActivity.this.faceTracker.get_FaceVerifyData(0);
                        LivenessRecogActivity.this.livenessStat.isLivenessSuc = true;
                        if (faceVerifyDataArr == null || faceVerifyDataArr.length <= 0) {
                            LivenessRecogActivity.this.livenessStat.getIDLPicture = 0;
                        } else {
                            LivenessRecogActivity.this.livenessStat.getIDLPicture = 1;
                        }
                        Object[] objArr = new Object[1];
                        objArr[0] = "livenessdone|faceVerifyDatas length|" + (faceVerifyDataArr != null ? Integer.valueOf(faceVerifyDataArr.length) : "0") + "|state|" + LivenessRecogActivity.this.processState.stateFlag;
                        Log.w(LivenessRecogActivity.TAG, objArr);
                        if (LivenessRecogActivity.this.shouldPhotograph(faceInfoArr[0], LivenessRecogActivity.this.errorCode) && faceVerifyDataArr != null && faceVerifyDataArr.length > 0) {
                            LivenessRecogActivity.this.processState.stateFlag = 10;
                            LivenessRecogActivity.this.uiHandler.removeCallbacks(LivenessRecogActivity.this.recogTimeCountRunnable);
                            LivenessRecogActivity.this.timerCount.cancel();
                            LivenessRecogActivity.this.cameraInterface.stopPreview();
                            LivenessRecogActivity.this.constrastLoadingView.setVisible(0);
                            LivenessRecogActivity.this.constrastPortrait(LivenessRecogActivity.this.revertData(faceVerifyDataArr));
                        }
                    }
                }
            }
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (!LivenessRecogActivity.this.isActivityFinished) {
                LivenessRecogActivity.this.timerCount.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isTimeOut() {
        Log.e(TAG, "processState.wholeProcessStartTime", Long.valueOf(this.processState.wholeProcessStartTime));
        return System.currentTimeMillis() - this.processState.wholeProcessStartTime > this.processState.wholeProcessTimeOut && this.processState.wholeProcessStartTime > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleTimeOut() {
        this.processState.wholeProcessStartTime = 0L;
        if (!this.processState.timeOutFlag) {
            showVerifyTimeoutDialog();
            this.processState.timeOutFlag = true;
            return;
        }
        showChangeDeviceDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FaceVerifyData[] revertData(FaceVerifyData[] faceVerifyDataArr) {
        FaceVerifyData[] faceVerifyDataArr2 = null;
        if (faceVerifyDataArr != null && faceVerifyDataArr.length > 0) {
            int length = faceVerifyDataArr.length;
            for (int i = 0; i < length; i++) {
                Log.d("hello", "原始数据照片签名" + i + "    :" + faceVerifyDataArr[i].mRegDigest);
            }
            faceVerifyDataArr2 = new FaceVerifyData[faceVerifyDataArr.length];
            for (int i2 = 0; i2 < length; i2++) {
                faceVerifyDataArr2[i2] = faceVerifyDataArr[(length - 1) - i2];
                Log.d("hello", "翻转后数据照片签名" + i2 + "    :" + faceVerifyDataArr[i2].mRegDigest);
            }
        }
        return faceVerifyDataArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap getScaleBitmap(int i) {
        Bitmap bitmap;
        if (!this.bitmapCache.containsKey(Integer.valueOf(i)) || this.bitmapCache.get(Integer.valueOf(i)) == null || (bitmap = this.bitmapCache.get(Integer.valueOf(i)).get()) == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.pass_liveness_face_round_height);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.pass_liveness_face_round_width);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(getResources(), i, options);
            options.inSampleSize = PassBiometricUtil.calculateInSampleSize(options, dimensionPixelSize2, dimensionPixelSize);
            options.inJustDecodeBounds = false;
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), i, options);
            this.bitmapCache.put(Integer.valueOf(i), new SoftReference<>(decodeResource));
            return decodeResource;
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void liveNessDetect(FaceInfo[] faceInfoArr) {
        boolean is_live_mouth;
        boolean is_live;
        boolean z;
        if (faceInfoArr != null && faceInfoArr.length > 0 && this.processState.stateFlag >= 1 && this.processState.stateFlag < 9) {
            switch (this.headMode) {
                case 0:
                    is_live_mouth = faceInfoArr[0].is_live_mouth();
                    is_live = faceInfoArr[0].is_live();
                    if (!is_live && !is_live_mouth) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 1:
                    z = faceInfoArr[0].is_live_head_down();
                    is_live_mouth = false;
                    is_live = false;
                    break;
                case 2:
                    z = faceInfoArr[0].is_live_head_up();
                    is_live_mouth = false;
                    is_live = false;
                    break;
                case 3:
                    z = faceInfoArr[0].is_live_head_turn_left();
                    is_live_mouth = false;
                    is_live = false;
                    break;
                case 4:
                    z = faceInfoArr[0].is_live_head_turn_right();
                    is_live_mouth = false;
                    is_live = false;
                    break;
                case 5:
                    is_live_mouth = faceInfoArr[0].is_live_mouth();
                    is_live = faceInfoArr[0].is_live();
                    if (!is_live && !is_live_mouth) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                default:
                    z = false;
                    is_live_mouth = false;
                    is_live = false;
                    break;
            }
            Log.w(TAG, "liveNessDetect|isLiveNess|" + z);
            if (z) {
                if (is_live) {
                    this.livenessStat.livingPassEyesNum++;
                    this.livenessStat.timePointLivingEyePass = System.currentTimeMillis();
                    this.livenessStat.livingPassType = LivenessStat.TYPE_LIVING_EYE;
                    Log.w(TAG, "timePointLivingEyePass:" + this.livenessStat.timePointLivingEyePass);
                } else if (is_live_mouth) {
                    this.livenessStat.livingPassMouthNum++;
                    this.livenessStat.timePointLivingMouthPass = System.currentTimeMillis();
                    this.livenessStat.livingPassType = LivenessStat.TYPE_LIVING_MOUTH;
                    Log.w(TAG, "timePointLivingMouthPass:" + this.livenessStat.timePointLivingMouthPass);
                }
                if (this.processState.stateFlag < 7) {
                    this.livenessStat.livingPassPeriod = LivenessStat.TYPE_LIVING_EYE;
                } else {
                    this.livenessStat.livingPassPeriod = LivenessStat.TYPE_LIVING_MOUTH;
                }
                Log.w(TAG, "isLiveNess ProcessState:" + this.processState.stateFlag);
                this.processState.stateFlag = 9;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean meetStartTrackRequirement(FaceInfo[] faceInfoArr) {
        if (faceInfoArr == null || faceInfoArr.length == 0) {
            return false;
        }
        return faceInfoArr == null || faceInfoArr.length <= 0 || !(PassBiometricUtil.isTooNearFromCamera(faceInfoArr[0].landmarks, this.canvasBitmapSize) || PassBiometricUtil.isTooFarFromCamera(faceInfoArr[0].landmarks, this.canvasBitmapSize));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHasFace(FaceInfo[] faceInfoArr) {
        return faceInfoArr != null && faceInfoArr.length > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFaceInsideRound(FaceInfo[] faceInfoArr) {
        return faceInfoArr != null && faceInfoArr.length > 0 && PassBiometricUtil.isFaceInsideRound(faceInfoArr[0].landmarks, this.canvasBitmapSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldPhotograph(FaceInfo faceInfo, FaceTracker.ErrCode errCode) {
        return faceInfo != null && this.errorCode == FaceTracker.ErrCode.OK;
    }

    private int getOnlineIllum() {
        List<Integer> aBtestIllumList = this.livenessConfig.getABtestIllumList();
        int illumVlaueGray = LocalConfigOptions.getInstance(this).getIllumVlaueGray();
        if (illumVlaueGray == -1) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            illumVlaueGray = random.nextInt(aBtestIllumList.size());
            LocalConfigOptions.getInstance(this).setIllumValueGray(illumVlaueGray);
            Log.w(TAG, "getOnlineIllum random" + illumVlaueGray);
        }
        Log.w(TAG, "getOnlineIllum" + illumVlaueGray);
        return aBtestIllumList.get(illumVlaueGray).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isUpdateWhiteBg(float f) {
        Log.w(TAG, "whiteBgIllumThr" + this.illumValue);
        return f <= ((float) this.illumValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public void updateWhiteBg(float f) {
        if (!this.whiteBgFlag) {
            this.livenessStat.illumValue = f;
            if (isUpdateWhiteBg(f)) {
                this.whiteBgFlag = true;
                this.livenessStat.whiteBg = 1;
                this.sensorManager.unRegisterSensorListener();
                if (Build.VERSION.SDK_INT >= 11) {
                    ValueAnimator valueAnimator = new ValueAnimator();
                    valueAnimator.setDuration(200L);
                    valueAnimator.setInterpolator(new LinearInterpolator());
                    valueAnimator.setIntValues(1, 100);
                    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity.12
                        private IntEvaluator mEvaluator = new IntEvaluator();

                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                            float intValue = ((Integer) valueAnimator2.getAnimatedValue()).intValue() / 100.0f;
                            int intValue2 = this.mEvaluator.evaluate(intValue, (Integer) 255, (Integer) 51).intValue();
                            LivenessRecogActivity.this.poseTipTv.setTextColor(Color.rgb(intValue2, intValue2, intValue2));
                            int intValue3 = this.mEvaluator.evaluate(intValue, (Integer) 0, (Integer) 255).intValue();
                            int intValue4 = this.mEvaluator.evaluate(intValue, (Integer) 66, (Integer) 255).intValue();
                            if (LivenessRecogActivity.this.xfordView != null) {
                                LivenessRecogActivity.this.xfordView.setBgPaintColor(Color.argb(intValue4, intValue3, intValue3, intValue3));
                                LivenessRecogActivity.this.xfordView.postInvalidate();
                            }
                        }
                    });
                    valueAnimator.start();
                    return;
                }
                this.poseTipTv.setTextColor(-11447983);
                if (this.xfordView != null) {
                    this.xfordView.setBgPaintColor(-1);
                    this.xfordView.postInvalidate();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public void startPoseTipAnim(int i) {
        updatePoseTip(i);
        if (this.processState.stateFlag == 0) {
            this.processState.stateFlag = 1;
        } else if (this.processState.stateFlag == 5) {
            this.processState.stateFlag = 6;
        } else if (this.processState.stateFlag == 7) {
            this.processState.stateFlag = 8;
        }
        this.poseTipFl.setVisibility(0);
        this.poseTipTv.setVisibility(0);
    }

    private void updatePoseTip(int i) {
        if (i == 0) {
            this.poseTipTv.setText(R.string.pass_liveness_put_face_round);
        } else if (i == 1) {
            if (this.headPoses != null && this.headMode < this.headPoses.length) {
                this.poseTipTv.setText(this.headPoses[this.headMode]);
            }
        } else if (i == 2) {
            if (this.headPoses != null && this.headMode < this.headPoses.length) {
                this.poseTipTv.setText(this.headPoses[this.headMode]);
            }
        } else if (i == 3 && this.headPoses != null && this.headMode < this.headPoses.length) {
            this.poseTipTv.setText(this.headPoses[this.headMode]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPoseWarningAnim(int i) {
        this.poseTipWarningFl.setVisibility(0);
        if (this.lastWaringType != i) {
            if (i == 1) {
                this.livenessStat.tipDistanceFarNum++;
                this.poseTipWarningTv.setText(getString(R.string.pass_liveness_tofar_from_camera));
            } else if (i == 0) {
                this.livenessStat.tipDistanceNearNum++;
                this.poseTipWarningTv.setText(getString(R.string.pass_liveness_tonear_from_camera));
            } else if (i == 2) {
                this.livenessStat.tipLightLowNum++;
                this.poseTipWarningTv.setText(getString(R.string.pass_liveness_brightness_too_dark));
            } else if (i == 4) {
                this.livenessStat.tipEyeSlopeNum++;
                this.poseTipWarningTv.setText(getString(R.string.pass_liveness_face_to_screen));
            } else {
                this.livenessStat.tipPutFaceRoundNum++;
                this.poseTipWarningTv.setText(getString(R.string.pass_liveness_put_face_round));
            }
            final Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.pass_liveness_tip_warning);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    LivenessRecogActivity.this.poseTipWarningIv.startAnimation(loadAnimation);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            if (!this.animState.startWarningFlag) {
                this.poseTipWarningIv.startAnimation(loadAnimation);
                this.animState.startWarningFlag = true;
            }
        }
        this.lastWaringType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecognizingAnim() {
        this.processState.stateFlag = 3;
        if (this.guideLiveness) {
            this.processState.stateFlag = 4;
        } else {
            this.processState.stateFlag = 20;
        }
        this.faceStateIv.setImageBitmap(getScaleBitmap(R.drawable.pass_liveness_recog_face_successed));
        this.livenessStat.timePointFindFaceDone = System.currentTimeMillis();
        Log.w(TAG, "livenessStat.timePointFindFaceDone:" + this.livenessStat.timePointFindFaceDone);
        this.livenessStat.findFaceNum++;
        this.livenessStat.findFaceLast = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAngleOfRange(FaceInfo faceInfo, FaceTracker.ErrCode errCode) {
        if (errCode == FaceTracker.ErrCode.YAW_OUT_OF_RANGE || errCode == FaceTracker.ErrCode.PITCH_OUT_OF_RANGE) {
            return true;
        }
        if (errCode == FaceTracker.ErrCode.OK && faceInfo.headPose.length == 3) {
            if (Math.abs(faceInfo.headPose[0]) >= (this.livenessConfig != null ? this.livenessConfig.getPitch() : 15)) {
                return true;
            }
            if (Math.abs(faceInfo.headPose[1]) >= (this.livenessConfig != null ? this.livenessConfig.getYaw() : 15)) {
                return true;
            }
        }
        return false;
    }

    public static void setBrightness(Activity activity, int i) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.screenBrightness = Float.valueOf(i).floatValue() * 0.003921569f;
        activity.getWindow().setAttributes(attributes);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            userCancel();
            btnBackStat();
            this.cameraInterface.doStopCamera();
            setActivityResult(0);
            activityFinish(-204);
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.processState.permissionFlag = false;
        if (i == 2002) {
            if (iArr.length > 0 && iArr[0] == 0) {
                this.livenessStat.withCameraPermission = 1;
                this.livenessStat.openCameraPermissionSuc = 1;
                this.livenessStat.timePointStartRecog = System.currentTimeMillis();
                startLiveness();
                if (openCamera()) {
                    this.livenessStat.timePointCameraReady = System.currentTimeMillis();
                    return;
                }
                return;
            }
            showPermissionDialog();
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void activityFinish(int i) {
        Log.w(TAG, "activityFinish");
        this.livenessStat.timePointEnd = System.currentTimeMillis();
        if (this.passFaceRecogDTO != null) {
            this.livenessStat.guideLiveness = this.passFaceRecogDTO.guideLiveness ? 1 : 0;
        }
        this.livenessStat.errCode = i;
        this.livenessStat.recogType = this.passFaceRecogDTO != null ? this.passFaceRecogDTO.livenessType.getRecogTypeName() : "unknown_type";
        this.livenessStat.onStat(this);
        if (this.timerCount != null) {
            this.timerCount.cancel();
        }
        PassFaceRecogManager.getInstance().cleanPassFaceRecogCallback();
        finish();
    }

    public void setActivityResult(int i) {
        Intent intent = new Intent();
        intent.putExtras(new Bundle());
        setResult(i, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity$14] */
    public void constrastPortrait(FaceVerifyData[] faceVerifyDataArr) {
        new AsyncTask<FaceVerifyData, Void, ArrayList<HashMap<String, byte[]>>>() { // from class: com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity.14
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public ArrayList<HashMap<String, byte[]>> doInBackground(FaceVerifyData... faceVerifyDataArr2) {
                int i;
                int i2;
                Bitmap createBitmap;
                LivenessRecogActivity.this.totalConstrastBeanCount = 0;
                LivenessRecogActivity.this.currentConstrastBeanPos = 0;
                ArrayList<HashMap<String, byte[]>> arrayList = new ArrayList<>();
                for (FaceVerifyData faceVerifyData : faceVerifyDataArr2) {
                    int[] iArr = faceVerifyData.mRegImg;
                    byte[] bArr = faceVerifyData.mRegDigest;
                    if (iArr != null && iArr.length > 0 && bArr != null && bArr.length > 0 && (createBitmap = Bitmap.createBitmap((i2 = faceVerifyData.cols), (i = faceVerifyData.rows), Bitmap.Config.ARGB_8888)) != null) {
                        createBitmap.setPixels(iArr, 0, i2, 0, 0, i2, i);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                        if (!createBitmap.isRecycled()) {
                            createBitmap.recycle();
                        }
                        HashMap<String, byte[]> hashMap = new HashMap<>();
                        hashMap.put("data", byteArrayOutputStream.toByteArray());
                        hashMap.put("digest", bArr);
                        arrayList.add(hashMap);
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                return arrayList;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(ArrayList<HashMap<String, byte[]>> arrayList) {
                if (arrayList == null || arrayList.size() <= 0) {
                    if (LivenessRecogActivity.this.callback != null) {
                        PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                        passFaceRecogResult.setResultCode(-306);
                        passFaceRecogResult.setResultMsg(PassFaceRecogResult.ERROR_MSG_IMAGE_FILE_EMPTY);
                        LivenessRecogActivity.this.callback.onFailure(passFaceRecogResult);
                    }
                    LivenessRecogActivity.this.activityFinish(-306);
                    return;
                }
                LivenessRecogActivity.this.totalConstrastBeanCount = arrayList.size();
                LivenessRecogActivity.this.portraitList = arrayList;
                if (LivenessRecogActivity.this.passFaceRecogDTO != null) {
                    if (LivenessRecogActivity.this.passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_FACEDETECT) {
                        if (LivenessRecogActivity.this.livenessConfig != null) {
                            LivenessRecogActivity.this.totalConstrastBeanCount = LivenessRecogActivity.this.livenessConfig.getRecogUploadPortraitCount(LivenessRecogActivity.this.totalConstrastBeanCount);
                        }
                        LivenessRecogActivity.this.dofaceDetect();
                        return;
                    }
                    LivenessRecogActivity.this.dofaceMatch();
                }
            }
        }.execute(faceVerifyDataArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dofaceMatch() {
        if (this.isLast) {
            if (this.callback != null) {
                this.livenessStat.faceMatchType = LivenessStat.TYPE_FACE_MATCH_FAIL;
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(-206);
                passFaceRecogResult.setResultMsg(PassBiometricResult.ERROR_MSG_SERVER_ERROR);
                this.callback.onFailure(passFaceRecogResult);
                setActivityResult(-1);
                activityFinish(passFaceRecogResult.getResultCode());
                return;
            }
            return;
        }
        this.currentConstrastBeanPos++;
        if (this.portraitList == null || this.currentConstrastBeanPos > this.portraitList.size()) {
            if (this.callback != null) {
                this.livenessStat.faceMatchType = LivenessStat.TYPE_FACE_MATCH_FAIL;
                PassFaceRecogResult passFaceRecogResult2 = new PassFaceRecogResult();
                passFaceRecogResult2.setResultCode(-206);
                passFaceRecogResult2.setResultMsg(PassBiometricResult.ERROR_MSG_SERVER_ERROR);
                this.callback.onFailure(passFaceRecogResult2);
                setActivityResult(-1);
                activityFinish(passFaceRecogResult2.getResultCode());
                return;
            }
            return;
        }
        byte[] bArr = this.portraitList.get(this.currentConstrastBeanPos - 1).get("data");
        byte[] bArr2 = this.portraitList.get(this.currentConstrastBeanPos - 1).get("digest");
        this.isLast = this.currentConstrastBeanPos == this.portraitList.size();
        portraitContrast(bArr2 == null ? null : new String(bArr2), bArr == null ? null : Base64Utils.encodeToString(bArr), this.isLast, this.voiceCredential);
    }

    private void portraitContrast(String str, String str2, boolean z, String str3) {
        final ContrastPortraitResult contrastPortraitResult = new ContrastPortraitResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("processid", this.passFaceRecogDTO.processid);
        if (this.passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_BDUSS) {
            httpHashMapWrap.put("type", "contrastportrait");
            httpHashMapWrap.put("atbc", PassBioDataEncryptor.encryptParams(getAtbc(this.passFaceRecogDTO)));
        } else if (this.passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_CERTINFO) {
            httpHashMapWrap.put("type", "certinfo");
            httpHashMapWrap.put("exuid", this.passFaceRecogDTO.exUid);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.passFaceRecogDTO.realName);
                jSONObject.put("cert", this.passFaceRecogDTO.idCardNum);
                jSONObject.put("bankmobile", this.passFaceRecogDTO.phoneNum);
                httpHashMapWrap.put("certinfo", PassBioDataEncryptor.encryptParams(jSONObject.toString()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (this.passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_AUTHTOKEN) {
            httpHashMapWrap.put("type", "authtoken");
            httpHashMapWrap.put("authtoken", this.passFaceRecogDTO.authToken);
        } else if (this.passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_OUTER) {
            httpHashMapWrap.put("type", "outer");
            httpHashMapWrap.put("exuid", this.passFaceRecogDTO.exUid);
        }
        httpHashMapWrap.put("service_type", this.passFaceRecogDTO.serviceType);
        httpHashMapWrap.put("imgdigests", str);
        httpHashMapWrap.put("image", str2);
        String zid = PassBioGlobalUtils.getZid(getApplicationContext());
        if (!TextUtils.isEmpty(zid)) {
            httpHashMapWrap.put("zid", zid);
        }
        httpHashMapWrap.put("last", z ? "1" : "0");
        if (!TextUtils.isEmpty(str3)) {
            httpHashMapWrap.put("callbackkey", str3);
        }
        httpHashMapWrap.putAll(HttpClientWrap.appendCertification(this));
        String nonce = HttpClientWrap.getNonce(this, this.passFaceRecogDTO.getSpParams(), httpHashMapWrap.getMap());
        if (!TextUtils.isEmpty(nonce)) {
            httpHashMapWrap.put("nonce", nonce);
        }
        httpHashMapWrap.put("sig", HttpClientWrap.calculateSig(httpHashMapWrap.getMap(), BeanConstants.appSignKey));
        new HttpClientWrap(this).post(getPortraitContrastUrl(), httpHashMapWrap, new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity.15
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
            public void onSuccess(int i, String str4) {
                try {
                    Log.i(LivenessRecogActivity.TAG, "portraitContrast|responseBody|" + str4);
                    JSONObject jSONObject2 = new JSONObject(str4);
                    int optInt = jSONObject2.optInt("retCode");
                    String optString = jSONObject2.optString("retMsg");
                    contrastPortraitResult.setResultCode(optInt);
                    contrastPortraitResult.setResultMsg(optString);
                    if (contrastPortraitResult.getResultCode() == 0) {
                        JSONObject jSONObject3 = new JSONObject(str4);
                        if (jSONObject3 != null) {
                            JSONObject optJSONObject = jSONObject3.optJSONObject("result");
                            if (LivenessRecogActivity.this.passFaceRecogDTO.livenessType == PassFaceRecogType.RECOG_TYPE_AUTHTOKEN) {
                                contrastPortraitResult.authsid = optJSONObject.optString("authsid");
                            }
                            contrastPortraitResult.callbackkey = optJSONObject.optString("callbackkey");
                            contrastPortraitResult.contrastres = optJSONObject.optInt("contrastres");
                            contrastPortraitResult.finalres = optJSONObject.optInt("finalres");
                            contrastPortraitResult.finish = optJSONObject.optInt("finish");
                            contrastPortraitResult.imgdigests = optJSONObject.optString("imgdigests");
                            contrastPortraitResult.recordvideo = optJSONObject.optInt("recordvideo");
                        } else {
                            return;
                        }
                    }
                } catch (JSONException e2) {
                    Log.e(e2);
                    contrastPortraitResult.setResultCode(-206);
                    contrastPortraitResult.setResultMsg(ContrastPortraitResult.ERROR_MSG_SERVER_ERROR);
                }
                LivenessRecogActivity.this.handlePortraitContrastSuc(contrastPortraitResult);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str4) {
                contrastPortraitResult.setResultCode(-206);
                contrastPortraitResult.setResultMsg(ContrastPortraitResult.ERROR_MSG_SERVER_ERROR);
                LivenessRecogActivity.this.handlePortraitContrastFail(contrastPortraitResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePortraitContrastFail(ContrastPortraitResult contrastPortraitResult) {
        if (this.isLast) {
            this.livenessStat.faceMatchType = LivenessStat.TYPE_FACE_MATCH_FAIL;
            if (this.callback != null) {
                PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                passFaceRecogResult.setResultCode(contrastPortraitResult.getResultCode());
                passFaceRecogResult.setResultMsg(contrastPortraitResult.getResultMsg());
                this.callback.onFailure(passFaceRecogResult);
                setActivityResult(-1);
                activityFinish(passFaceRecogResult.getResultCode());
                return;
            }
            return;
        }
        dofaceMatch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePortraitContrastSuc(ContrastPortraitResult contrastPortraitResult) {
        if (contrastPortraitResult.getResultCode() != 0) {
            handlePortraitContrastFail(contrastPortraitResult);
            this.livenessStat.faceMatchType = LivenessStat.TYPE_FACE_MATCH_FAIL;
            return;
        }
        this.voiceCredential = contrastPortraitResult.callbackkey;
        if (contrastPortraitResult.isFinish()) {
            if (contrastPortraitResult.isProcessPass()) {
                goToFaceMatchResult(contrastPortraitResult);
                return;
            } else {
                goToFaceMatchResult(contrastPortraitResult);
                return;
            }
        }
        dofaceMatch();
    }

    private void faceDetectHttp(String str, String str2, boolean z) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("processid", this.passFaceRecogDTO.processid);
        httpHashMapWrap.put("exuid", this.passFaceRecogDTO.exUid);
        httpHashMapWrap.put("imgdigests", str);
        httpHashMapWrap.put("image", str2);
        httpHashMapWrap.put("last", z ? "1" : "0");
        httpHashMapWrap.putAll(HttpClientWrap.appendCertification(this));
        String nonce = HttpClientWrap.getNonce(this, this.passFaceRecogDTO.getSpParams(), httpHashMapWrap.getMap());
        if (!TextUtils.isEmpty(nonce)) {
            httpHashMapWrap.put("nonce", nonce);
        }
        httpHashMapWrap.put("sig", HttpClientWrap.calculateSig(httpHashMapWrap.getMap(), BeanConstants.appSignKey));
        new HttpClientWrap(this).post(getFaceDetectUrl(), httpHashMapWrap, new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity.16
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r1v11, types: [com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity$16$1] */
            @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
            public void onSuccess(int i, String str3) {
                Log.i(LivenessRecogActivity.TAG, "faceDetectHttp|responseBody|" + str3);
                final PassFaceRecogResult passFaceRecogResult = new PassFaceRecogResult();
                try {
                    passFaceRecogResult.extraJson = new JSONObject(str3).getJSONObject("result");
                    passFaceRecogResult.callbackkey = passFaceRecogResult.extraJson.optString("faceid");
                    if (TextUtils.isEmpty(passFaceRecogResult.callbackkey)) {
                        LivenessRecogActivity.this.callbackFailureOrContinueFaceDetect(-206, PassBiometricResult.ERROR_MSG_SERVER_ERROR);
                    } else if (LivenessRecogActivity.this.callback != null) {
                        new AsyncTask<Void, Void, PassFaceRecogResult>() { // from class: com.baidu.pass.biometrics.face.liveness.activity.LivenessRecogActivity.16.1
                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // android.os.AsyncTask
                            public PassFaceRecogResult doInBackground(Void... voidArr) {
                                byte[] encode;
                                if (LivenessRecogActivity.this.passFaceRecogDTO != null) {
                                    if (LivenessRecogActivity.this.cameraDataCache != null && LivenessRecogActivity.this.cameraDataCache.size() > 0) {
                                        passFaceRecogResult.originalImage = LivenessRecogActivity.this.argb2String((int[]) LivenessRecogActivity.this.cameraDataCache.get(LivenessRecogActivity.this.cameraDataCache.size() - LivenessRecogActivity.this.currentConstrastBeanPos));
                                    }
                                    if (LivenessRecogActivity.this.faceData != null && (encode = Base64Utils.encode(LivenessRecogActivity.this.faceData)) != null) {
                                        passFaceRecogResult.faceimage = new String(encode);
                                    }
                                    if (LivenessRecogActivity.this.faceDigest != null) {
                                        passFaceRecogResult.imgdigests = new String(LivenessRecogActivity.this.faceDigest);
                                    }
                                }
                                return passFaceRecogResult;
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            /* JADX INFO: Access modifiers changed from: protected */
                            @Override // android.os.AsyncTask
                            public void onPostExecute(PassFaceRecogResult passFaceRecogResult2) {
                                super.onPostExecute((AnonymousClass1) passFaceRecogResult2);
                                passFaceRecogResult2.setResultCode(0);
                                LivenessRecogActivity.this.callback.onSuccess(passFaceRecogResult2);
                                LivenessRecogActivity.this.livenessStat.faceMatchType = LivenessStat.TYPE_FACE_MATCH_PASS;
                                LivenessRecogActivity.this.activityFinish(passFaceRecogResult2.getResultCode());
                            }
                        }.execute(new Void[0]);
                    }
                } catch (JSONException e) {
                    LivenessRecogActivity.this.callbackFailureOrContinueFaceDetect(-206, PassBiometricResult.ERROR_MSG_SERVER_ERROR);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.pass.biometrics.base.http.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str3) {
                LivenessRecogActivity.this.callbackFailureOrContinueFaceDetect(-206, PassBiometricResult.ERROR_MSG_SERVER_ERROR);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dofaceDetect() {
        this.currentConstrastBeanPos++;
        if (this.portraitList != null && this.currentConstrastBeanPos <= this.totalConstrastBeanCount && this.currentConstrastBeanPos <= this.portraitList.size()) {
            this.faceData = this.portraitList.get(this.currentConstrastBeanPos - 1).get("data");
            this.faceDigest = this.portraitList.get(this.currentConstrastBeanPos - 1).get("digest");
            this.isLast = this.currentConstrastBeanPos == this.portraitList.size();
            faceDetectHttp(this.faceDigest != null ? new String(this.faceDigest) : null, Base64Utils.encodeToString(this.faceData), this.isLast);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class ProcessState {
        static final int DEFAULT_WHOLE_PROCESS_TIME_OUT = 20000;
        static final int LIVENESS_RECOG_MIN_TIME = 5000;
        static final int STAET_VIDEO_UNRECOGNIZED = 18;
        static final int STATE_BEFORE_TRACK_BLINK = 5;
        static final int STATE_BEFORE_TRACK_MOUTH_OPEN = 7;
        static final int STATE_FACE_RECOG_DONE = 10;
        static final int STATE_FACE_RECOG_TIME_OUT = 17;
        static final int STATE_FIND_FACE = 2;
        static final int STATE_FIND_FACE_SPECIAL_ANIM_DONE = 4;
        static final int STATE_FIND_FACE_SPECIAL_ANIM_START = 3;
        static final int STATE_LIVE_NESS = 9;
        static final int STATE_LOST_FACE = 11;
        static final int STATE_NO_CAMERA_PERMISSION = 19;
        static final int STATE_NO_GUIDE_LIVENESS = 20;
        static final int STATE_OPEN_APP = 0;
        static final int STATE_START_RECOGNIZE = 1;
        static final int STATE_START_TRACK_BLICK = 6;
        static final int STATE_START_TRACK_MOUTH_OPEN = 8;
        long wholeProcessStartTime;
        int stateFlag = 0;
        boolean firstFindFaceFlag = false;
        boolean blickFindFaceFlag = false;
        long wholeProcessTimeOut = 20000;
        boolean timeOutFlag = false;
        boolean permissionFlag = false;

        ProcessState() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class AnimState {
        private static final int POSE_BOTTOM_TO_MIDDLE = 0;
        private static final int POSE_MIDDLE_TO_TOP = 1;
        static final int POSE_STATE_BLINK = 1;
        static final int POSE_STATE_MOUTH_OPEN = 3;
        static final int POSE_STATE_NOD_HEAD = 2;
        static final int POSE_STATE_PUSH_FACE_ROUND = 0;
        boolean startWarningFlag = false;
        boolean startBlinkAnimFlag = false;
        boolean startMouthOpenAnimFlag = false;
        boolean swipFaceFlag = false;

        AnimState() {
        }
    }
}
