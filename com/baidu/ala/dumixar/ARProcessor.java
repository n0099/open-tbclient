package com.baidu.ala.dumixar;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
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
import com.baidu.ala.dumixar.utils.LuaMessageHelper;
import com.baidu.ala.dumixar.utils.SafeConcurrentHashMap;
import com.baidu.ala.recorder.video.gles.GlUtil;
import com.baidu.ar.ARType;
import com.baidu.ar.DefinedLuaListener;
import com.baidu.ar.DuMixCallback;
import com.baidu.ar.DuMixErrorType;
import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.capture.ICaptureAbilityListener;
import com.baidu.ar.capture.ICaptureResult;
import com.baidu.ar.face.FaceListener;
import com.baidu.ar.face.FaceResultData;
import com.baidu.ar.filter.FilterNode;
import com.baidu.ar.filter.FilterStateListener;
import com.baidu.ar.lua.LuaMsgListener;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.minivideo.arface.a;
import com.baidu.minivideo.arface.b;
import com.baidu.minivideo.arface.bean.BeautyType;
import com.baidu.minivideo.arface.bean.Filter;
import com.baidu.minivideo.arface.bean.Makeup;
import com.baidu.minivideo.arface.bean.Sticker;
import com.baidu.minivideo.arface.c;
import com.baidu.minivideo.arface.d;
import com.baidu.minivideo.arface.utils.ThreadPool;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.sina.weibo.sdk.constant.WBConstants;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.microedition.khronos.opengles.GL10;
@TargetApi(14)
/* loaded from: classes3.dex */
public class ARProcessor implements SurfaceTexture.OnFrameAvailableListener {
    public static final boolean DEBUG = false;
    public static final int ERROR_CODE_ARFACE_SETUP = 1001;
    public static final float GENDER_MALE_DEFAULT = 0.8f;
    private static final String TAG = "DuAr_ARProcessor";
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
    private DuMixCallback mDuMixCallback;
    private a mEffect;
    private float mEyeAndFace;
    private boolean mFaceArInited;
    private float mFilterLevel;
    private boolean mIsCaptureTimerStart;
    private boolean mIsCheckFace;
    private boolean mIsFirstAvailableFrame;
    private boolean mIsPreviewing;
    private boolean mIsSetup;
    private OnDataLoadCallback mOnRecordManagerInitListener;
    private Sticker mSticker;
    private float mThinFace;
    private Filter mfilter;
    public static a.InterfaceC0172a sEffectHolder = new a.InterfaceC0172a() { // from class: com.baidu.ala.dumixar.ARProcessor.1
        @Override // com.baidu.minivideo.arface.a.InterfaceC0172a
        public void onHolderChanged(a.InterfaceC0172a interfaceC0172a) {
        }
    };
    public static String DEF_FILTER_ID = "500001";
    public static String DEF_FILTER_FOLDER = "yuantu";
    private static float DEF_FILTER_VALUE = 0.25f;
    private static float FILTER_VALUE = 0.55f;
    private static Boolean sThinAnchorPointsEnable = null;
    private com.baidu.minivideo.arface.bean.a beautyEnableStatus = new com.baidu.minivideo.arface.bean.a();
    private int mCameraId = 1;
    private ConcurrentHashMap<BeautyType, Object> mBeautyMap = new SafeConcurrentHashMap();
    private boolean mDrawerChanged = false;
    private int[] mFramebuffers = new int[1];
    private int mWidth = 1080;
    private int mHeight = WBConstants.SDK_NEW_PAY_VERSION;
    private boolean isShowDefFilterValue = true;
    private boolean isShowDefBeautifulValue = true;
    private volatile boolean mIsOverrideParm = false;
    private float[] mSTMatrix = new float[16];
    private boolean mIsFaceThin = false;
    private int mOutputFPS = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface Callback extends DuMixCallback {
    }

    /* loaded from: classes3.dex */
    public interface DuArProcessorCallback {

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes3.dex */
        public @interface CHECK_FACE_STATE {
            public static final int STATE_FACE_ANGLE = 2;
            public static final int STATE_FACE_EDGE = 4;
            public static final int STATE_FACE_OK = 0;
            public static final int STATE_FACE_OVERLAP = 3;
            public static final int STATE_NOTHING = 5;
            public static final int STATE_NO_FACE = 1;
        }

        void onBeautyEnableChanged(com.baidu.minivideo.arface.bean.a aVar);

        void onBeforeAr();

        void onCapture(ICaptureResult iCaptureResult);

        void onChangeGender(boolean z);

        void onCheckFaceState(int i);

        void onFaceFocus(int i, int i2, int i3, int i4);

        void onLuaMessage(HashMap<String, Object> hashMap);

        void onStickerSwitchCamera(int i);
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
        BeautyDataManager.getInstance().getBeautyTypes(this.mBeautyMap);
        sThinAnchorPointsEnable = Boolean.valueOf(Build.VERSION.SDK_INT > 19);
    }

    public void loadData(OnDataLoadCallback onDataLoadCallback) {
        d("loadFaceAssets ... ");
        setOnRecordManagerInitListener(onDataLoadCallback);
        b.a(this.mContext.getApplicationContext(), new b.a() { // from class: com.baidu.ala.dumixar.ARProcessor.2
            @Override // com.baidu.minivideo.arface.b.a
            public void onResult(boolean z, String str) {
                ARProcessor.d("loadFaceAssets : " + z);
                ARProcessor.this.onLoadData(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initEffectValue() {
        setSticker(getSticker());
        setFilter(getFilter());
        setBeautyValues(this.mBeautyMap);
    }

    public void setBeautyValues(ConcurrentHashMap<BeautyType, Object> concurrentHashMap) {
        if (this.mEffect != null) {
            this.mEffect.g(concurrentHashMap);
        }
    }

    protected void onLoadData(boolean z) {
        if (this.mOnRecordManagerInitListener != null) {
            this.mOnRecordManagerInitListener.onLoadFinish(z);
        }
    }

    public void setOnRecordManagerInitListener(OnDataLoadCallback onDataLoadCallback) {
        this.mOnRecordManagerInitListener = onDataLoadCallback;
    }

    public void onSurfaceCreate(FullFrameRect fullFrameRect, FullFrameRect fullFrameRect2) {
        this.mARFullFrameRect = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D_AR));
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

    public void onSwitchCamera(int i) {
        if (this.mCameraId != i) {
            this.mCameraId = i;
        }
    }

    public void setBlur(float f) {
        BeautyType beautyType = BeautyType.smooth;
        this.mBeautyMap.put(beautyType, Float.valueOf(f));
        if (this.mEffect != null) {
            this.mEffect.setBeautyValue(beautyType, f);
        }
    }

    public void setCheekThin(float f) {
        BeautyType beautyType = BeautyType.thinFace;
        this.mBeautyMap.put(beautyType, Float.valueOf(f));
        if (this.mEffect != null) {
            this.mEffect.setBeautyValue(beautyType, f);
        }
    }

    public void setWhiten(float f) {
        BeautyType beautyType = BeautyType.whiten;
        this.mBeautyMap.put(beautyType, Float.valueOf(f));
        if (this.mEffect != null) {
            this.mEffect.setBeautyValue(beautyType, f);
        }
    }

    public void setAccurateSmooth(boolean z) {
        if (this.mEffect != null) {
            a aVar = this.mEffect;
            b.JX();
            aVar.fx(c.cv(z));
        }
    }

    public void setSticker(Sticker sticker) {
        if (!isSetup() || this.mEffect == null || this.mEffect.isPaused()) {
            this.mBackUp = sticker;
        } else if (sticker == null) {
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

    public void clearBackUpSticker() {
        this.mBackUp = null;
    }

    public void loadCase(String str, String str2) {
        if (this.mEffect != null) {
            this.mEffect.loadCase(str, str2);
        }
    }

    public void setEnlargeEye(float f) {
        BeautyType beautyType = BeautyType.eye;
        this.mBeautyMap.put(beautyType, Float.valueOf(f));
        if (this.mEffect != null) {
            this.mEffect.setBeautyValue(beautyType, f);
        }
    }

    public void setFilter(Filter filter) {
        String str;
        float f;
        String str2;
        this.mfilter = filter;
        if (filter == null && !this.isShowDefFilterValue) {
            f = 0.0f;
            str2 = null;
        } else if (filter == null || DEF_FILTER_ID.equals(filter.getParam())) {
            if (b.JX() != null) {
                b.JX();
                str = c.Ka();
            } else {
                str = null;
            }
            f = DEF_FILTER_VALUE;
            str2 = str;
        } else {
            File lutFile = getLutFile(filter.getFile());
            String absolutePath = lutFile != null ? lutFile.getAbsolutePath() : null;
            f = filter.getLevel();
            str2 = absolutePath;
        }
        Object obj = this.mBeautyMap.get(BeautyType.lutFile);
        String str3 = obj instanceof String ? (String) obj : null;
        if (str2 != null && !str2.equals(str3)) {
            this.mBeautyMap.put(BeautyType.lutFile, str2);
            if (this.mEffect != null && str2 != null) {
                this.mEffect.setBeautyValue(BeautyType.lutFile, str2);
            }
        }
        setFilterLevel(f);
    }

    public void setLutFilterForDebug(String str) {
        this.mEffect.setBeautyValue(BeautyType.lutFile, str);
        setFilterLevel(0.4f);
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
        BeautyType beautyType = BeautyType.lutIntensity;
        Object obj = this.mBeautyMap.get(beautyType);
        if (!(obj instanceof Float) || ((Float) obj).floatValue() != f) {
            this.mBeautyMap.put(beautyType, Float.valueOf(f));
            if (this.mEffect != null) {
                this.mEffect.setBeautyValue(beautyType, f);
            }
        }
    }

    public float getFilterLevel() {
        Object obj = this.mBeautyMap.get(BeautyType.lutIntensity);
        if (obj instanceof Float) {
            return ((Float) obj).floatValue();
        }
        return 0.0f;
    }

    public void setMakeup(Makeup makeup) {
        if (makeup != null) {
            BeautyType type = makeup.getType();
            this.mBeautyMap.put(type, makeup);
            if (this.mEffect != null) {
                this.mEffect.a(type, makeup);
            }
        }
    }

    public void setMakeupValue(BeautyType beautyType, float f) {
        Object obj = this.mBeautyMap.get(beautyType);
        if (obj instanceof Makeup) {
            ((Makeup) obj).setValue(f);
        }
        if (this.mEffect != null) {
            this.mEffect.setBeautyValue(beautyType, f);
        }
    }

    public void setBeautyValue(BeautyType beautyType, int i) {
        this.mBeautyMap.put(beautyType, Integer.valueOf(i));
        if (this.mEffect != null) {
            this.mEffect.setBeautyValue(beautyType, i);
        }
    }

    public void setBeautyValue(BeautyType beautyType, float f) {
        this.mBeautyMap.put(beautyType, Float.valueOf(f));
        if (this.mEffect != null) {
            this.mEffect.setBeautyValue(beautyType, f);
        }
    }

    public void setBeautyValue(BeautyType beautyType, String str) {
        this.mBeautyMap.put(beautyType, str);
        if (this.mEffect != null) {
            this.mEffect.setBeautyValue(beautyType, str);
        }
    }

    public void setBeautyValue(BeautyType beautyType, float[] fArr) {
        this.mBeautyMap.put(beautyType, fArr);
        if (this.mEffect != null) {
            this.mEffect.setBeautyValue(beautyType, fArr);
        }
    }

    public void setCurve(List<List<Point>> list) {
        if (this.mEffect != null) {
            this.mEffect.setCurve(list);
        }
    }

    public void setOverrideDefaultParm(boolean z) {
        this.mIsOverrideParm = z;
        if (this.mEffect != null) {
            this.mEffect.setOverrideDefaultParm(z);
        }
    }

    public float getWhite() {
        Object obj = this.mBeautyMap.get(BeautyType.whiten);
        if (obj instanceof Float) {
            return ((Float) obj).floatValue();
        }
        return 0.0f;
    }

    public float getBlure() {
        Object obj = this.mBeautyMap.get(BeautyType.smooth);
        if (obj instanceof Float) {
            return ((Float) obj).floatValue();
        }
        return 0.0f;
    }

    public float getBigEye() {
        Object obj = this.mBeautyMap.get(BeautyType.eye);
        if (obj instanceof Float) {
            return ((Float) obj).floatValue();
        }
        return 0.0f;
    }

    public float getThinFace() {
        Object obj = this.mBeautyMap.get(BeautyType.thinFace);
        if (obj instanceof Float) {
            return ((Float) obj).floatValue();
        }
        return 0.0f;
    }

    public Sticker getSticker() {
        return this.mSticker == null ? this.mBackUp : this.mSticker;
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
        return sticker.isSupport(a.getVersion()) && !TextUtils.isEmpty(sticker.getPath()) && new File(sticker.getPath()).exists() && a.fy(sticker.getPath());
    }

    public Sticker getFace() {
        return this.mSticker == null ? this.mBackUp : this.mSticker;
    }

    public void setFace(Sticker sticker) {
        this.mSticker = sticker;
    }

    protected void release() {
        releaseTextureId();
    }

    public int onProcessFrame(int i, float[] fArr) {
        if (this.mARTexture != null) {
            this.mARTexture.updateTexImage();
            this.mARTexture.getTransformMatrix(fArr);
        }
        if (this.mARFullFrameRect == null) {
            this.mARFullFrameRect = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D_AR));
        }
        if (fArr == null) {
            float[] fArr2 = this.mSTMatrix;
        }
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

    private float[] convertPointValue(int i, int i2, boolean z, float f, float f2, float f3, float f4) {
        PointF pointF;
        Size size = new Size(i, i2);
        Size size2 = new Size(320, 180);
        float[] fArr = new float[4];
        if (z) {
            pointF = new PointF(size2.getHeight() - f2, size2.getWidth() - f);
        } else {
            pointF = new PointF(size2.getHeight() - f2, f);
        }
        float height = size.getHeight() / size2.getWidth();
        float width = size.getWidth() / size2.getHeight();
        if (z) {
            fArr[0] = (pointF.x - f3) * width;
            fArr[1] = (pointF.y - f4) * height;
        } else {
            fArr[0] = (pointF.x - f3) * width;
            fArr[1] = (pointF.y + f4) * height;
        }
        fArr[2] = width * pointF.x;
        fArr[3] = pointF.y * height;
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float[] convertPointValue2(int i, int i2, boolean z, float f, float f2, float f3, float f4) {
        Size size = new Size(i, i2);
        Size size2 = new Size(180, 320);
        PointF pointF = new PointF(f, f2);
        float height = size.getHeight() / size2.getHeight();
        float width = size.getWidth() / size2.getWidth();
        return new float[]{(pointF.x + f3) * width, (pointF.y + f4) * height, width * pointF.x, pointF.y * height};
    }

    public static void createAR(Context context) {
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        SurfaceTexture surfaceTexture2 = new SurfaceTexture(0);
        final a a = a.a(context, null, null);
        Log.e(TAG, "ARProcessor arController = " + a);
        a.onCameraDrawerCreated(surfaceTexture2, 720, 1280);
        a.a(surfaceTexture, null, 720, 1280, true, new d() { // from class: com.baidu.ala.dumixar.ARProcessor.3
            @Override // com.baidu.minivideo.arface.d, com.baidu.ar.DuMixCallback
            public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
                super.onSetup(z, duMixInput, duMixOutput);
                SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.ala.dumixar.ARProcessor.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.release();
                    }
                });
            }
        });
    }

    public void onResume() {
        this.mIsPreviewing = true;
        if (a.a(this.mEffect, sEffectHolder)) {
            this.mEffect.resume();
            d("onResume last");
            return;
        }
        d("onResume new");
        if (this.mDuArProcessorCallback != null) {
            this.mDuArProcessorCallback.onBeforeAr();
        }
        this.mEffect = a.a(this.mContext, sEffectHolder, null);
        this.mEffect.setOutputFPS(this.mOutputFPS);
        Log.e(TAG, "ARProcessor arController = " + this.mEffect);
        this.mEffect.setOverrideDefaultParm(this.mIsOverrideParm);
        this.mEffect.a(new ICaptureAbilityListener() { // from class: com.baidu.ala.dumixar.ARProcessor.4
            @Override // com.baidu.ar.capture.ICaptureAbilityListener
            public void onOpen() {
                ARProcessor.this.mIsCheckFace = true;
                ARProcessor.this.mIsCaptureTimerStart = false;
                if (ARProcessor.this.mEffect != null) {
                    ARProcessor.this.mEffect.d(new ICallbackWith<ICaptureResult>() { // from class: com.baidu.ala.dumixar.ARProcessor.4.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.ar.callback.ICallbackWith
                        public void run(ICaptureResult iCaptureResult) {
                            if (iCaptureResult != null && ARProcessor.this.mIsCaptureTimerStart) {
                                ARProcessor.this.mIsCheckFace = false;
                                if (ARProcessor.this.mDuArProcessorCallback != null) {
                                    ARProcessor.this.mDuArProcessorCallback.onCapture(iCaptureResult);
                                }
                            }
                        }
                    });
                }
            }

            @Override // com.baidu.ar.capture.ICaptureAbilityListener
            public void onClose() {
                ARProcessor.this.mIsCheckFace = false;
                ARProcessor.this.mIsCaptureTimerStart = false;
                if (ARProcessor.this.mEffect != null) {
                    ARProcessor.this.mEffect.d((ICallbackWith<ICaptureResult>) null);
                }
            }
        });
        this.mEffect.setFaceListener(new FaceListener() { // from class: com.baidu.ala.dumixar.ARProcessor.5
            @Override // com.baidu.ar.face.FaceListener
            public void onFaceResult(Object obj) {
                if (obj != null && (obj instanceof FaceResultData)) {
                    FaceResultData faceResultData = (FaceResultData) obj;
                    int[] faceIds = faceResultData.getFaceIds();
                    boolean z = ARProcessor.this.mCameraId == 1;
                    float[] faceBoxes = faceResultData.getFaceBoxes();
                    if (faceBoxes != null && faceBoxes.length <= 4 && faceIds != null) {
                        float[] convertPointValue2 = ARProcessor.this.convertPointValue2(ARProcessor.this.mARWidth, ARProcessor.this.mARHeight, z, faceBoxes[0], faceBoxes[1], faceBoxes[2], faceBoxes[3]);
                        int i = (int) (convertPointValue2[0] - convertPointValue2[2]);
                        int i2 = (int) (convertPointValue2[1] - convertPointValue2[3]);
                        int i3 = ((int) (convertPointValue2[0] + convertPointValue2[2])) / 2;
                        int i4 = ((int) (convertPointValue2[3] + convertPointValue2[1])) / 2;
                        if (ARProcessor.this.mDuArProcessorCallback != null) {
                            ARProcessor.this.mDuArProcessorCallback.onFaceFocus(i, i2, i3, i4);
                        }
                    }
                    ARProcessor.this.checkFace(faceResultData);
                    float[] genders = faceResultData.getGenders();
                    if (genders != null) {
                        boolean z2 = genders[0] > 0.8f;
                        if (ARProcessor.this.mDuArProcessorCallback != null) {
                            ARProcessor.this.mDuArProcessorCallback.onChangeGender(z2);
                        }
                        if (faceIds == null) {
                        }
                    }
                }
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onStickerLoadingFinished(List<String> list) {
            }

            @Override // com.baidu.ar.face.FaceListener
            public void onTriggerFired(String str) {
            }
        });
        if (this.mCameraTexture != null && this.mARTexture != null) {
            onCameraDrawerCreated(this.mCameraTexture, this.mWidth, this.mHeight);
            onARDrawerCreated(this.mARTexture, this, this.mWidth, this.mHeight);
        }
    }

    public void checkFace(FaceResultData faceResultData) {
        if (!this.mIsCheckFace || faceResultData == null) {
            if (this.mDuArProcessorCallback != null) {
                this.mDuArProcessorCallback.onCheckFaceState(5);
                return;
            }
            return;
        }
        int checkFaceQualified = checkFaceQualified(faceResultData);
        if (checkFaceQualified == 0) {
            if (this.mDuArProcessorCallback != null) {
                this.mDuArProcessorCallback.onCheckFaceState(5);
            }
            sendMessage2Lua(LuaMessageHelper.getLuaMessageByType(LuaMessageHelper.KEY_SEND_LUA_MESSAGE.CAPTURE_TIMER_START));
            this.mIsCaptureTimerStart = true;
            return;
        }
        if (this.mDuArProcessorCallback != null) {
            this.mDuArProcessorCallback.onCheckFaceState(checkFaceQualified);
        }
        sendMessage2Lua(LuaMessageHelper.getLuaMessageByType(LuaMessageHelper.KEY_SEND_LUA_MESSAGE.CAPTURE_TIMER_CLEAR));
        this.mIsCaptureTimerStart = false;
    }

    private int checkFaceQualified(FaceResultData faceResultData) {
        boolean z;
        boolean z2 = true;
        if (faceResultData == null) {
            return 5;
        }
        if (faceResultData.isTracked()) {
            float[] normalizedFaceBoxes = faceResultData.getNormalizedFaceBoxes();
            if (normalizedFaceBoxes != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < normalizedFaceBoxes.length && i + 3 < normalizedFaceBoxes.length; i += 4) {
                    arrayList.add(new float[]{normalizedFaceBoxes[i], normalizedFaceBoxes[i + 1] + normalizedFaceBoxes[i + 3], normalizedFaceBoxes[i] + normalizedFaceBoxes[i + 2], normalizedFaceBoxes[i + 1]});
                }
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    float f = ((float[]) arrayList.get(i2))[0];
                    float f2 = ((float[]) arrayList.get(i2))[1];
                    float f3 = ((float[]) arrayList.get(i2))[2];
                    float f4 = ((float[]) arrayList.get(i2))[3];
                    if (f < 0.0f || f3 > 1.0f || f2 > 0.75f || f4 < 0.1f) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                return 4;
            }
            List<float[]> headPoses = faceResultData.getHeadPoses();
            if (headPoses != null) {
                for (float[] fArr : headPoses) {
                    if (fArr.length < 3) {
                        break;
                    }
                    float f5 = fArr[0];
                    float f6 = fArr[1];
                    float f7 = fArr[2];
                    if (Math.abs(f5) > 20.0f) {
                        break;
                    } else if (Math.abs(f6) > 30.0f) {
                        break;
                    }
                }
            }
            z2 = false;
            return z2 ? 2 : 0;
        }
        return 1;
    }

    private boolean isRectangleOverlap(float[] fArr, float[] fArr2) {
        return fArr[0] < fArr2[2] && fArr2[0] < fArr[2] && fArr[1] < fArr2[3] && fArr2[1] < fArr[3];
    }

    public void setCaptureProcessResult(Object... objArr) {
        if (this.mEffect != null) {
            this.mEffect.h(objArr);
        }
    }

    public void setCaseReset() {
        this.mIsCaptureTimerStart = false;
    }

    public void setNeedFace() {
        this.mIsCheckFace = true;
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

    public boolean isSetup() {
        return this.mIsSetup && a.a(this.mEffect, sEffectHolder);
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
            this.mEffect.setDefinedLuaListener(new DefinedLuaListener() { // from class: com.baidu.ala.dumixar.ARProcessor.6
                @Override // com.baidu.ar.DefinedLuaListener
                public void onRequireSwitchCamera(int i5) {
                    if (ARProcessor.this.mDuArProcessorCallback != null) {
                        ARProcessor.this.mDuArProcessorCallback.onStickerSwitchCamera(i5);
                    }
                }

                @Override // com.baidu.ar.DefinedLuaListener
                public void onOpenUrl(String str, int i5, HashMap<String, Object> hashMap) {
                }
            });
            this.mEffect.c(new LuaMsgListener() { // from class: com.baidu.ala.dumixar.ARProcessor.7
                @Override // com.baidu.ar.lua.LuaMsgListener
                public List<String> getMsgKeyListened() {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(LuaMessageHelper.KEY_EVENT_NAME);
                    return arrayList;
                }

                @Override // com.baidu.ar.lua.LuaMsgListener
                public void onLuaMessage(HashMap<String, Object> hashMap) {
                    if (ARProcessor.this.mDuArProcessorCallback != null) {
                        ARProcessor.this.mDuArProcessorCallback.onLuaMessage(hashMap);
                    }
                }
            });
            this.mEffect.a(surfaceTexture, onFrameAvailableListener, i3, i4, isFrontCamera(), generateDuMixCallback());
            this.mEffect.setFilterStateListener(new FilterStateListener() { // from class: com.baidu.ala.dumixar.ARProcessor.8
                @Override // com.baidu.ar.filter.FilterStateListener
                public void onFilterStateChanged(HashMap<FilterNode, Boolean> hashMap, String str) {
                    Boolean bool;
                    Boolean bool2;
                    Boolean bool3;
                    Boolean bool4 = null;
                    boolean z = false;
                    if (hashMap != null) {
                        bool3 = hashMap.get(FilterNode.makeupFilter);
                        bool2 = hashMap.get(FilterNode.lutFilter);
                        bool = hashMap.get(FilterNode.skinFilter);
                        bool4 = hashMap.get(FilterNode.faceFilter);
                    } else {
                        bool = null;
                        bool2 = null;
                        bool3 = null;
                    }
                    ARProcessor.this.beautyEnableStatus.cw(bool3 == null || bool3.booleanValue());
                    ARProcessor.this.beautyEnableStatus.cx(bool2 == null || bool2.booleanValue());
                    ARProcessor.this.beautyEnableStatus.cy(bool == null || bool.booleanValue());
                    com.baidu.minivideo.arface.bean.a aVar = ARProcessor.this.beautyEnableStatus;
                    if (bool4 == null || bool4.booleanValue()) {
                        z = true;
                    }
                    aVar.cz(z);
                    if (ARProcessor.this.mDuArProcessorCallback != null) {
                        SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.ala.dumixar.ARProcessor.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ARProcessor.this.mDuArProcessorCallback.onBeautyEnableChanged(ARProcessor.this.beautyEnableStatus);
                            }
                        });
                    }
                }
            });
            return;
        }
        d("onARDrawerCreated Effect == null");
    }

    private DuMixCallback generateDuMixCallback() {
        return new DuMixCallback() { // from class: com.baidu.ala.dumixar.ARProcessor.9
            @Override // com.baidu.ar.DuMixCallback
            public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
                if (!z || ARProcessor.this.mEffect == null || b.JX() != null) {
                }
                ARProcessor.this.mIsSetup = z;
                if (ARProcessor.this.mCallback != null) {
                    ARProcessor.this.mCallback.onSetup(z, duMixInput, duMixOutput);
                }
                if (!z) {
                    ARProcessor.this.notifyError(1001, "onSetup返回失败：" + z);
                    return;
                }
                ARProcessor.this.mIsFirstAvailableFrame = false;
                ThreadPool.Kj().execute(new Runnable() { // from class: com.baidu.ala.dumixar.ARProcessor.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ARProcessor.this.initEffectValue();
                    }
                });
                ARProcessor.this.mFaceArInited = false;
                if (ARProcessor.this.mARWidth > 0 && ARProcessor.this.mARHeight > 0) {
                    ARProcessor.this.onARDrawerChanged(ARProcessor.this.mARTexture, ARProcessor.this.mARWidth, ARProcessor.this.mARHeight);
                }
                ARProcessor.this.mIsSetup = true;
                if (!ARProcessor.this.mFaceArInited) {
                    ARProcessor.this.mFaceArInited = true;
                    ARProcessor.this.setBeautyValues(ARProcessor.this.mBeautyMap);
                    if (Config.getInstance().getDuSticker() != null) {
                        ARProcessor.this.setFace(Config.getInstance().getDuSticker());
                    }
                    ARProcessor.this.setEffectItemSelected(ARProcessor.this.getFace());
                    ARProcessor.this.setFilterSelected(ARProcessor.this.getFilter());
                    ARProcessor.d("onFaceArInited ");
                }
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onCaseCreate(boolean z, String str, String str2) {
                if (ARProcessor.this.mCallback != null) {
                    ARProcessor.this.mCallback.onCaseCreate(z, str, str2);
                }
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onCaseDestroy() {
                if (ARProcessor.this.mCallback != null) {
                    ARProcessor.this.mCallback.onCaseDestroy();
                }
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onRelease() {
                if (ARProcessor.this.mCallback != null) {
                    ARProcessor.this.mCallback.onRelease();
                }
                ARProcessor.this.mIsSetup = false;
                ARProcessor.this.mCameraTexture = new SurfaceTexture(0);
            }

            @Override // com.baidu.ar.DuMixCallback
            public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
                if (ARProcessor.this.mCallback != null) {
                    ARProcessor.this.mCallback.onError(duMixErrorType, str, str2);
                }
            }
        };
    }

    public void setFilterSelected(Filter filter) {
        this.mfilter = filter;
        if (this.mEffect != null) {
            if (filter == null && !this.isShowDefFilterValue) {
                this.mEffect.setBeautyValue(BeautyType.lutFile, 0);
            } else if (filter == null || DEF_FILTER_ID.equals(filter.getParam())) {
                if (b.JX() != null) {
                    a aVar = this.mEffect;
                    BeautyType beautyType = BeautyType.lutFile;
                    b.JX();
                    aVar.setBeautyValue(beautyType, c.Ka());
                    setInitValue(true, DEF_FILTER_VALUE);
                }
            } else {
                File lutFile = getLutFile(filter.getFile());
                if (lutFile != null && lutFile.exists()) {
                    this.mEffect.setBeautyValue(BeautyType.lutFile, lutFile.getAbsolutePath());
                    setInitValue(true, FILTER_VALUE);
                }
            }
        }
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

    public void onARDrawerChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyError(int i, String str) {
    }

    public void setCallback(DuArProcessorCallback duArProcessorCallback) {
        this.mDuArProcessorCallback = duArProcessorCallback;
    }

    public void sendMessage2Lua(HashMap<String, Object> hashMap) {
        if (this.mEffect != null && hashMap != null) {
            this.mEffect.sendMessage2Lua(hashMap);
        }
    }

    public void updateFilterBrightness(float f) {
        if (this.mEffect != null) {
            this.mEffect.updateFilterBrightness(f);
        }
    }

    public void updateFilterContrast(float f) {
        if (this.mEffect != null) {
            this.mEffect.updateFilterContrast(f);
        }
    }

    public void updateFilterSaturation(float f) {
        if (this.mEffect != null) {
            this.mEffect.updateFilterSaturation(f);
        }
    }

    public void resetAllQualityParm() {
        if (this.mEffect != null) {
            this.mEffect.resetAllQualityParm();
        }
    }

    public void setOutputFPS(int i) {
        this.mOutputFPS = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class Size {
        private int height;
        private int width;

        public Size(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        public int getWidth() {
            return this.width;
        }

        public int getHeight() {
            return this.height;
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

    public SurfaceTexture getCameraTexture() {
        d("getCameraTexture: " + this.mCameraTexture);
        if (this.mCameraTexture == null) {
            this.mCameraTexture = new SurfaceTexture(0);
        }
        return this.mCameraTexture;
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str) {
    }

    /* loaded from: classes3.dex */
    public static class CallbackAdapter implements Callback {
        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onCaseCreate(boolean z, String str, String str2) {
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onCaseDestroy() {
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onRelease() {
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
        }
    }
}
