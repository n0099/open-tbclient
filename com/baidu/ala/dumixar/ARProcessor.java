package com.baidu.ala.dumixar;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.ala.dumixar.gles.FullFrameRect;
import com.baidu.ala.dumixar.gles.Texture2dProgram;
import com.baidu.ala.recorder.video.gles.GlUtil;
import com.baidu.ar.ARType;
import com.baidu.ar.DefinedLuaListener;
import com.baidu.ar.DuMixCallback;
import com.baidu.ar.DuMixErrorType;
import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.FilterType;
import com.baidu.ar.face.FaceListener;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.minivideo.a.a;
import com.baidu.minivideo.a.b;
import com.baidu.minivideo.a.c;
import com.baidu.minivideo.arface.bean.Filter;
import com.baidu.minivideo.arface.bean.Sticker;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.sina.weibo.sdk.constant.WBConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes3.dex */
public class ARProcessor implements SurfaceTexture.OnFrameAvailableListener {
    public static final boolean DEBUG = false;
    public static final int ERROR_CODE_ARFACE_SETUP = 1001;
    private static final String TAG = "DuAr_ARProcessor";
    public static final float V_BEAUTY_DEF = 0.5f;
    public static final float V_BLURE_DEF = 0.7f;
    public static final float V_EYE_DEF = 0.5f;
    public static final float V_EYE_FACE_DEF = 0.5f;
    public static final float V_FILTER_DEF = 0.4f;
    public static final float V_THIN_FACE_DEF = 0.5f;
    public static final float V_WHITE_DEF = 0.5f;
    private boolean isFirstFrame;
    private SurfaceTexture.OnFrameAvailableListener mARFrameListener;
    private FullFrameRect mARFullFrameRect;
    private int mARHeight;
    private SurfaceTexture mARTexture;
    private int mARTexture2DId;
    private int mARTextureID;
    private int mARWidth;
    private Sticker mBackUp;
    private float mBeauty;
    private float mBeautyBlure;
    private float mBeautyRed;
    private float mBeautyWhite;
    private float mBigEye;
    private Callback mCallback;
    private SurfaceTexture mCameraTexture;
    private int mCameraTextureID;
    private Context mContext;
    private String mCurrentTrigger;
    private DuArInitHandler mDuArInitHandler;
    private DuArProcessorCallback mDuArProcessorCallback;
    private a mEffect;
    private float mEyeAndFace;
    private boolean mFaceArInited;
    private float mFilterLevel;
    private boolean mIsFirstAvailableFrame;
    private boolean mIsPreviewing;
    private boolean mIsSetup;
    private OnDataLoadCallback mOnRecordManagerInitListener;
    private Sticker mSticker;
    private float mThinFace;
    private Filter mfilter;
    public static String DEF_FILTER_ID = "500001";
    public static String DEF_FILTER_FOLDER = "yuantu";
    private static float DEF_FILTER_VALUE = 0.25f;
    private static float FILTER_VALUE = 0.55f;
    private static Boolean sThinAnchorPointsEnable = null;
    private int mCameraId = 1;
    HashMap<BeautyType, Object> mBeautys = new HashMap<>();
    private boolean mDrawerChanged = false;
    private int[] mFramebuffers = new int[1];
    private int mWidth = 1080;
    private int mHeight = WBConstants.SDK_NEW_PAY_VERSION;
    private boolean isShowDefFilterValue = true;
    private boolean isShowDefBeautifulValue = true;
    private float[] mSTMatrix = new float[16];
    private boolean mIsFaceThin = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface Callback extends DuMixCallback {
    }

    /* loaded from: classes3.dex */
    public interface DuArProcessorCallback {
        void onFilterUIVisible(boolean z);

        void onLuaMessage(HashMap<String, Object> hashMap);

        void onMakeupUIVisible(boolean z);

        void onStickerSwitchCamera();
    }

    /* loaded from: classes3.dex */
    public interface OnDataLoadCallback {
        void onLoadFinish(boolean z);
    }

    public ARProcessor(Context context, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        d("ARProcessor structor");
        this.mContext = context;
        this.mARFrameListener = onFrameAvailableListener;
        this.mARTexture = new SurfaceTexture(0);
        Matrix.setIdentityM(this.mSTMatrix, 0);
        BeautyDataManager.getInstance().getBeautyTypes(this.mBeautys);
        sThinAnchorPointsEnable = Boolean.valueOf(Build.VERSION.SDK_INT > 19);
    }

    public void loadData(OnDataLoadCallback onDataLoadCallback) {
        d("loadFaceAssets ... ");
        setOnRecordManagerInitListener(onDataLoadCallback);
        b.a(this.mContext.getApplicationContext(), new b.a() { // from class: com.baidu.ala.dumixar.ARProcessor.1
            public void onResult(boolean z, String str) {
                ARProcessor.d("loadFaceAssets : " + z);
                ARProcessor.this.onLoadData(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initEffectValue() {
    }

    protected void onLoadData(boolean z) {
        if (this.mOnRecordManagerInitListener != null) {
            this.mOnRecordManagerInitListener.onLoadFinish(z);
        }
    }

    public void setOnRecordManagerInitListener(OnDataLoadCallback onDataLoadCallback) {
        this.mOnRecordManagerInitListener = onDataLoadCallback;
    }

    public void releaseTextureId() {
        d("releaseTextureId");
        GLES20.glDeleteFramebuffers(1, this.mFramebuffers, 0);
        GLES20.glDeleteTextures(1, new int[]{this.mARTexture2DId}, 0);
        this.mARTexture2DId = 0;
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        d("onSurfaceChanged");
        if (this.mARWidth != i || this.mARHeight != i2) {
            releaseTextureId();
        }
        this.mARWidth = i;
        this.mARHeight = i2;
        onARDrawerChanged(this.mARTexture, i, i2);
    }

    public float toNorValue(float f, float f2, float f3) {
        if (f <= f2) {
            return toNorValue(f, 0.0f, f2, 0.0f, f3);
        }
        return toNorValue(f, f2, 1.0f, f3, 1.0f);
    }

    public float toNorValue(float f, float f2, float f3, float f4, float f5) {
        return (((f5 - f4) / (f3 - f2)) * (f - f2)) + f4;
    }

    public void setEffectItemSelected(Sticker sticker) {
        if (this.mEffect == null || !this.mFaceArInited) {
            this.mBackUp = sticker;
            return;
        }
        Config.getInstance().setDuSticker(sticker);
        if (sticker == null || "cancelItem".equals(sticker.getId())) {
            this.mSticker = sticker;
            this.mEffect.clearCase();
        } else if (checkTipResFile(sticker)) {
            Sticker.AbilityModel abilityModel = sticker.getAbilityModel();
            this.mSticker = sticker;
            if (abilityModel != null) {
                this.mEffect.setMdlModelPath(abilityModel.getPath());
            }
            int arType = sticker.getArType();
            String id = sticker.getId();
            this.mSticker = sticker;
            this.mEffect.loadCase(ARType.valueOf(arType), sticker.getPath(), id);
        }
    }

    private boolean loadLib(String str) {
        try {
            System.load(str);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkTipResFile(Sticker sticker) {
        return sticker.isSupport(a.getVersion()) && !TextUtils.isEmpty(sticker.getPath()) && new File(sticker.getPath()).exists() && a.eE(sticker.getPath());
    }

    public void setFilterSelected(Filter filter) {
        this.mfilter = filter;
        if (this.mEffect != null) {
            if (filter == null && !this.isShowDefFilterValue) {
                this.mEffect.updateFilter((FilterType) null, 0);
            } else if (filter == null || DEF_FILTER_ID.equals(filter.getParam())) {
                if (b.DQ() != null) {
                    a aVar = this.mEffect;
                    FilterType filterType = BeautyType.lutFile.type;
                    b.DQ();
                    aVar.updateFilter(filterType, c.getFilterYuanTuPath());
                    setInitValue(true, DEF_FILTER_VALUE);
                }
            } else {
                File lutFile = getLutFile(filter.getFile());
                if (lutFile != null && lutFile.exists()) {
                    this.mEffect.updateFilter(BeautyType.lutFile.type, lutFile.getAbsolutePath());
                    setInitValue(true, FILTER_VALUE);
                }
            }
        }
    }

    public void setFilterSelected(String str) {
        if (this.mEffect != null) {
            this.mEffect.updateFilter(BeautyType.lutFile.type, str);
            if (str.endsWith("yuantu.png")) {
                setInitValue(true, DEF_FILTER_VALUE);
            } else {
                setInitValue(true, FILTER_VALUE);
            }
        }
    }

    private File getLutFile(File file) {
        if (file == null) {
            return null;
        }
        if (!file.isFile()) {
            File[] listFiles = file.listFiles();
            for (int i = 0; listFiles != null && i < listFiles.length; i++) {
                String name = listFiles[i].getName();
                if (name.substring(name.lastIndexOf(".") + 1).toLowerCase().equals("png")) {
                    return listFiles[i];
                }
            }
            return null;
        }
        return file;
    }

    public void setFilterLevel(float f) {
        this.mFilterLevel = f;
        if (this.mEffect != null) {
            this.mEffect.updateFilter(BeautyType.lutIntensity.type, f);
        }
    }

    public float getFilterLevel() {
        return this.mFilterLevel;
    }

    private void updateFilter(BeautyType beautyType, int i) {
        this.mBeautys.put(beautyType, Integer.valueOf(i));
        if (this.mEffect != null && beautyType != null) {
            this.mEffect.updateFilter(beautyType.type, i);
        }
    }

    private void updateFilter(BeautyType beautyType, float f) {
        if ((BeautyType.thinFace == beautyType || BeautyType.faceWidth == beautyType) && sThinAnchorPointsEnable.booleanValue()) {
            float f2 = -1.0f;
            if (BeautyType.thinFace == beautyType && getBeautyVlaue(BeautyType.faceWidth) != null && (getBeautyVlaue(BeautyType.faceWidth) instanceof Float)) {
                f2 = ((Float) getBeautyVlaue(BeautyType.faceWidth)).floatValue();
            } else if (BeautyType.faceWidth == beautyType && getBeautyVlaue(BeautyType.thinFace) != null && (getBeautyVlaue(BeautyType.thinFace) instanceof Float)) {
                f2 = ((Float) getBeautyVlaue(BeautyType.thinFace)).floatValue();
            }
            boolean z = ((double) Math.abs(f - 0.0f)) >= 0.001d || ((double) Math.abs(f2 - 0.0f)) >= 0.001d;
            if (z != this.mIsFaceThin) {
                HashMap<BeautyType, Object> faceThinTypes = BeautyDataManager.getInstance().getFaceThinTypes(z);
                this.mIsFaceThin = z;
                this.mBeautys.putAll(faceThinTypes);
                setBeautyValues(faceThinTypes);
            }
        }
        this.mBeautys.put(beautyType, Float.valueOf(f));
        if (this.mEffect != null && beautyType != null) {
            this.mEffect.updateFilter(beautyType.type, f);
        }
    }

    private Object getBeautyVlaue(BeautyType beautyType) {
        if (this.mBeautys == null || !this.mBeautys.containsKey(beautyType)) {
            return null;
        }
        return this.mBeautys.get(beautyType);
    }

    private void updateFilter(BeautyType beautyType, String str) {
        this.mBeautys.put(beautyType, str);
        if (this.mEffect != null && beautyType != null) {
            this.mEffect.updateFilter(beautyType.type, str);
        }
    }

    private void updateFilter(BeautyType beautyType, float[] fArr) {
        this.mBeautys.put(beautyType, fArr);
        if (this.mEffect != null && beautyType != null) {
            this.mEffect.updateFilter(beautyType.type, fArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBeautyValues(Map<BeautyType, Object> map) {
        Map.Entry entry;
        HashMap hashMap = new HashMap(map);
        if (hashMap != null) {
            Iterator it = hashMap.entrySet().iterator();
            while (it.hasNext() && (entry = (Map.Entry) it.next()) != null && entry.getKey() != null) {
                if (entry.getValue() instanceof Integer) {
                    updateFilter((BeautyType) entry.getKey(), ((Integer) entry.getValue()).intValue());
                } else if (entry.getValue() instanceof Float) {
                    updateFilter((BeautyType) entry.getKey(), ((Float) entry.getValue()).floatValue());
                } else if (entry.getValue() instanceof String) {
                    updateFilter((BeautyType) entry.getKey(), (String) entry.getValue());
                } else if (entry.getValue() instanceof float[]) {
                    updateFilter((BeautyType) entry.getKey(), (float[]) entry.getValue());
                } else if (entry.getValue() instanceof Double) {
                    updateFilter((BeautyType) entry.getKey(), new Float(((Double) entry.getValue()).doubleValue()).floatValue());
                } else if (entry.getValue() instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) entry.getValue();
                    int size = arrayList.size();
                    float[] fArr = new float[size];
                    for (int i = 0; i < size; i++) {
                        Object obj = arrayList.get(i);
                        if (obj instanceof Number) {
                            fArr[i] = ((Number) obj).floatValue();
                        }
                    }
                    updateFilter((BeautyType) entry.getKey(), fArr);
                }
            }
        }
    }

    public void setBeautyParams(HashMap<String, Object> hashMap) {
        setBeautyValues(BeautyDataManager.getInstance().convertParams(hashMap));
    }

    public Sticker getFace() {
        return this.mSticker == null ? this.mBackUp : this.mSticker;
    }

    public void setFace(Sticker sticker) {
        this.mSticker = sticker;
    }

    public Filter getFilter() {
        return this.mfilter;
    }

    public void setShowDefFilterValue(boolean z) {
        this.isShowDefFilterValue = z;
    }

    public void setShowDefBeautifulValue(boolean z) {
        this.isShowDefBeautifulValue = z;
    }

    protected void release() {
        releaseTextureId();
    }

    public int onProcessFrame(int i, float[] fArr) {
        this.mARTexture.updateTexImage();
        if (this.mARFullFrameRect == null) {
            this.mARFullFrameRect = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D_AR));
        }
        if (fArr == null) {
            fArr = this.mSTMatrix;
        }
        this.mARTexture.getTransformMatrix(fArr);
        if (this.mARTexture2DId == 0) {
            this.mARTexture2DId = this.mARFullFrameRect.createTexture2DObject();
            GLES20.glTexImage2D(3553, 0, 6408, this.mARWidth, this.mARHeight, 0, 6408, 5121, null);
            GLES20.glBindTexture(3553, 0);
            GLES20.glGenFramebuffers(1, this.mFramebuffers, 0);
        }
        GLES20.glBindFramebuffer(36160, this.mFramebuffers[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mARTexture2DId, 0);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16640);
        GLES20.glViewport(0, 0, this.mARWidth, this.mARHeight);
        this.mARFullFrameRect.drawFrame(this.mARTextureID, GlUtil.IDENTITY_MATRIX);
        GLES20.glBindFramebuffer(36160, 0);
        return this.mARTexture2DId;
    }

    public void initSourceSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.mWidth = i2;
            this.mHeight = i;
        }
    }

    public void onResume() {
        this.mIsPreviewing = true;
        if (this.mEffect != null) {
            this.mEffect.resume();
            d("onResume last");
            return;
        }
        d("onResume new");
        this.mEffect = a.aQ(this.mContext);
        this.mEffect.enableProfileLog(false);
        this.mEffect.setFaceListener(new FaceListener() { // from class: com.baidu.ala.dumixar.ARProcessor.2
            public void onFaceResult(Object obj) {
            }

            public void onStickerLoadingFinished(List<String> list) {
            }

            public void onTriggerFired(String str) {
            }
        });
        if (getCameraTexture() != null && this.mARTexture != null) {
            if (BdLog.isDebugMode()) {
                Log.e(TAG, "setCameraSize: " + this.mWidth + ", " + this.mHeight);
            }
            onCameraDrawerCreated(this.mCameraTexture, this.mWidth, this.mHeight);
            onARDrawerCreated(this.mARTexture, this, this.mWidth, this.mHeight);
        }
    }

    public void onPause() {
        d(MissionEvent.MESSAGE_PAUSE);
        if (this.mEffect != null) {
            this.mEffect.pause();
        }
        if (this.mDuArInitHandler != null) {
            this.mDuArInitHandler.cancel();
        }
        this.mIsPreviewing = false;
    }

    public void onDestroy() {
        d(MissionEvent.MESSAGE_DESTROY);
        this.mIsPreviewing = false;
        this.mIsSetup = false;
        if (this.mARTexture != null) {
            this.mARTexture.release();
            this.mARTexture = null;
        }
        if (this.mEffect != null) {
            this.mEffect.release();
            this.mEffect = null;
        }
        if (this.mARFullFrameRect != null) {
            this.mARFullFrameRect.release(false);
        }
    }

    public void onCameraDrawerCreated(SurfaceTexture surfaceTexture, int i, int i2) {
        d("onCameraDrawerCreated mEffect=" + this.mEffect);
        if (this.mEffect != null) {
            this.mEffect.onCameraDrawerCreated(surfaceTexture, i, i2);
        } else {
            d("onCameraDrawerCreated Effect == null");
        }
    }

    private boolean isFrontCamera() {
        return 1 == this.mCameraId;
    }

    public void onARDrawerCreated(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, int i, int i2) {
        int i3;
        int i4;
        d("onARDrawerCreated " + Thread.currentThread());
        if (i == 0 || i2 == 0) {
            i3 = this.mARWidth;
            i4 = this.mARHeight;
        } else {
            i4 = i2;
            i3 = i;
        }
        if (this.mEffect != null) {
            this.mEffect.setDefinedLuaListener(new DefinedLuaListener() { // from class: com.baidu.ala.dumixar.ARProcessor.3
                public void onRequireSwitchCamera(int i5) {
                    if (i5 == -1) {
                        if (ARProcessor.this.mDuArProcessorCallback != null) {
                            ARProcessor.this.mDuArProcessorCallback.onStickerSwitchCamera();
                        }
                    } else if (i5 != ARProcessor.this.mCameraId) {
                        ARProcessor.this.mDuArProcessorCallback.onStickerSwitchCamera();
                    }
                }

                public void onMakeupUIVisible(boolean z) {
                }

                public void onFilterUIVisible(boolean z) {
                }

                public void onOpenUrl(String str, int i5, HashMap<String, Object> hashMap) {
                }
            });
            this.mEffect.addLuaMsgListener(new LuaMsgListener() { // from class: com.baidu.ala.dumixar.ARProcessor.4
                public List<String> getMsgKeyListened() {
                    return null;
                }

                public void onLuaMessage(HashMap<String, Object> hashMap) {
                    if (ARProcessor.this.mDuArProcessorCallback != null) {
                        ARProcessor.this.mDuArProcessorCallback.onLuaMessage(hashMap);
                    }
                }
            });
            if (surfaceTexture != null) {
                surfaceTexture.setOnFrameAvailableListener(this.mARFrameListener);
            }
            this.mEffect.a(surfaceTexture, onFrameAvailableListener, i3, i4, isFrontCamera(), generateDuMixCallback());
            return;
        }
        d("onARDrawerCreated Effect == null");
    }

    private DuMixCallback generateDuMixCallback() {
        return new DuMixCallback() { // from class: com.baidu.ala.dumixar.ARProcessor.5
            public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
                if (!z || ARProcessor.this.mEffect == null || b.DQ() != null) {
                }
                if (ARProcessor.this.mCallback != null) {
                    ARProcessor.this.mCallback.onSetup(z, duMixInput, duMixOutput);
                }
                ARProcessor.this.mFaceArInited = false;
                if (!z) {
                    ARProcessor.this.notifyError(1001, "onSetup返回失败：" + z);
                }
                if (ARProcessor.this.mARWidth > 0 && ARProcessor.this.mARHeight > 0) {
                    ARProcessor.this.onARDrawerChanged(ARProcessor.this.mARTexture, ARProcessor.this.mARWidth, ARProcessor.this.mARHeight);
                }
                ARProcessor.this.mIsSetup = true;
                if (!ARProcessor.this.mFaceArInited) {
                    ARProcessor.this.mFaceArInited = true;
                    ARProcessor.this.setBeautyValues(ARProcessor.this.mBeautys);
                    if (Config.getInstance().getDuSticker() != null) {
                        ARProcessor.this.setFace(Config.getInstance().getDuSticker());
                    }
                    ARProcessor.this.setEffectItemSelected(ARProcessor.this.getFace());
                    ARProcessor.this.setFilterSelected(ARProcessor.this.getFilter());
                    ARProcessor.d("onFaceArInited ");
                }
            }

            public void onCaseCreate(boolean z, String str, String str2) {
                if (ARProcessor.this.mCallback != null) {
                    ARProcessor.this.mCallback.onCaseCreate(z, str, str2);
                }
            }

            public void onCaseDestroy() {
                if (ARProcessor.this.mCallback != null) {
                    ARProcessor.this.mCallback.onCaseDestroy();
                }
            }

            public void onRelease() {
                if (ARProcessor.this.mCallback != null) {
                    ARProcessor.this.mCallback.onRelease();
                }
            }

            public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
                if (ARProcessor.this.mCallback != null) {
                    ARProcessor.this.mCallback.onError(duMixErrorType, str, str2);
                }
            }
        };
    }

    private void setInitValue(boolean z, float f) {
        if (z) {
            setFilterLevel(f);
        }
        if (this.mDuArInitHandler == null) {
            this.mDuArInitHandler = new DuArInitHandler(this);
        }
        if (z) {
            this.mDuArInitHandler.initFilter(f);
        }
    }

    public boolean onTouchEvent(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (!this.mIsFirstAvailableFrame) {
            this.mIsFirstAvailableFrame = true;
            initEffectValue();
        }
        if (this.mARFrameListener != null) {
            this.mARFrameListener.onFrameAvailable(surfaceTexture);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class DuArInitHandler extends Handler {
        public static final int WHAT_DEF = 0;
        public static final int WHAT_FILTER = 1;
        private WeakReference<ARProcessor> mRef;

        public DuArInitHandler(ARProcessor aRProcessor) {
            this.mRef = new WeakReference<>(aRProcessor);
        }

        public void initFilter(float f) {
            if (this.mRef.get() != null) {
                sentInitMsg(1, f);
            }
        }

        private void setInitValue() {
            if (this.mRef.get() != null) {
                sentInitMsg(0, 0.0f);
            }
        }

        private void sentInitMsg(int i, float f) {
            removeMessages(i);
            onInit(i, f);
            sendMessageDelayed(obtainMessage(i, Float.valueOf(f)), 100L);
            sendMessageDelayed(obtainMessage(i, Float.valueOf(f)), 300L);
            sendMessageDelayed(obtainMessage(i, Float.valueOf(f)), 500L);
            sendMessageDelayed(obtainMessage(i, Float.valueOf(f)), 1500L);
            sendMessageDelayed(obtainMessage(i, Float.valueOf(f)), 3000L);
        }

        private void onInit(int i, float f) {
            ARProcessor aRProcessor = this.mRef.get();
            if (aRProcessor != null && i != 1) {
                aRProcessor.initEffectValue();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.mRef.get() != null) {
                float f = 0.0f;
                if (message.obj != null) {
                    f = ((Float) message.obj).floatValue();
                }
                onInit(message.what, f);
            } else {
                removeMessages(message.what);
            }
            super.handleMessage(message);
        }

        public void cancel() {
            removeMessages(0);
            removeMessages(1);
        }
    }

    public void onARDrawerChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyError(int i, String str) {
        d(i + str);
    }

    public SurfaceTexture getCameraTexture() {
        d("getCameraTexture: " + this.mCameraTexture);
        if (this.mCameraTexture == null) {
            this.mCameraTexture = new SurfaceTexture(0);
        }
        return this.mCameraTexture;
    }

    public void setCallback(DuArProcessorCallback duArProcessorCallback) {
        this.mDuArProcessorCallback = duArProcessorCallback;
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void sendMessage2Lua(HashMap<String, Object> hashMap) {
        if (this.mEffect != null && hashMap != null) {
            this.mEffect.sendMessage2Lua(hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str) {
    }

    /* loaded from: classes3.dex */
    public static class CallbackAdapter implements Callback {
        public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
        }

        public void onCaseCreate(boolean z, String str, String str2) {
        }

        public void onCaseDestroy() {
        }

        public void onRelease() {
        }

        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
        }
    }
}
